package com.luck.picture.lib.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.CameraView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.luck.picture.lib.C2639R;
import com.luck.picture.lib.PictureMediaScannerConnection;
import com.luck.picture.lib.camera.listener.CameraListener;
import com.luck.picture.lib.camera.listener.CaptureListener;
import com.luck.picture.lib.camera.listener.ClickListener;
import com.luck.picture.lib.camera.listener.ImageCallbackListener;
import com.luck.picture.lib.camera.listener.TypeListener;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class CustomCameraView extends RelativeLayout {
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    private static final int TYPE_FLASH_AUTO = 33;
    private static final int TYPE_FLASH_OFF = 35;
    private static final int TYPE_FLASH_ON = 34;
    private CameraListener mCameraListener;
    private CameraView mCameraView;
    private CaptureLayout mCaptureLayout;
    private PictureSelectionConfig mConfig;
    private ImageView mFlashLamp;
    private ImageCallbackListener mImageCallbackListener;
    private ImageView mImagePreview;
    private MediaPlayer mMediaPlayer;
    private ClickListener mOnClickListener;
    private File mPhotoFile;
    private ImageView mSwitchCamera;
    private TextureView mTextureView;
    private File mVideoFile;
    private long recordTime;
    private TextureView.SurfaceTextureListener surfaceTextureListener;
    private int type_flash;

    /* renamed from: com.luck.picture.lib.camera.CustomCameraView$1 */
    class C26511 implements CaptureListener {
        C26511() {
        }

        @Override // com.luck.picture.lib.camera.listener.CaptureListener
        public void recordEnd(long j2) {
            CustomCameraView.this.recordTime = j2;
            CustomCameraView.this.mCameraView.stopRecording();
        }

        @Override // com.luck.picture.lib.camera.listener.CaptureListener
        public void recordError() {
            if (CustomCameraView.this.mCameraListener != null) {
                CustomCameraView.this.mCameraListener.onError(0, "An unknown error", null);
            }
        }

        @Override // com.luck.picture.lib.camera.listener.CaptureListener
        public void recordShort(long j2) {
            CustomCameraView.this.recordTime = j2;
            CustomCameraView.this.mSwitchCamera.setVisibility(0);
            CustomCameraView.this.mFlashLamp.setVisibility(0);
            CustomCameraView.this.mCaptureLayout.resetCaptureLayout();
            CustomCameraView.this.mCaptureLayout.setTextWithAnimation(CustomCameraView.this.getContext().getString(C2639R.string.picture_recording_time_is_short));
            CustomCameraView.this.mCameraView.stopRecording();
        }

        @Override // com.luck.picture.lib.camera.listener.CaptureListener
        public void recordStart() {
            CustomCameraView.this.mSwitchCamera.setVisibility(4);
            CustomCameraView.this.mFlashLamp.setVisibility(4);
            CustomCameraView.this.mCameraView.setCaptureMode(CameraView.CaptureMode.VIDEO);
            CustomCameraView.this.mCameraView.startRecording(CustomCameraView.this.createVideoFile(), ContextCompat.getMainExecutor(CustomCameraView.this.getContext().getApplicationContext()), new VideoCapture.OnVideoSavedCallback() { // from class: com.luck.picture.lib.camera.CustomCameraView.1.2
                @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
                public void onError(int i2, @NonNull String str, @Nullable Throwable th) {
                    if (CustomCameraView.this.mCameraListener != null) {
                        CustomCameraView.this.mCameraListener.onError(i2, str, th);
                    }
                }

                @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
                public void onVideoSaved(@NonNull final File file) {
                    CustomCameraView.this.mVideoFile = file;
                    if (CustomCameraView.this.recordTime < 1500 && CustomCameraView.this.mVideoFile.exists() && CustomCameraView.this.mVideoFile.delete()) {
                        return;
                    }
                    if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(CustomCameraView.this.mConfig.cameraPath)) {
                        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<Boolean>() { // from class: com.luck.picture.lib.camera.CustomCameraView.1.2.1
                            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                            public Boolean doInBackground() {
                                return Boolean.valueOf(AndroidQTransformUtils.copyPathToDCIM(CustomCameraView.this.getContext(), file, Uri.parse(CustomCameraView.this.mConfig.cameraPath)));
                            }

                            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                            public void onSuccess(Boolean bool) {
                                PictureThreadUtils.cancel(PictureThreadUtils.getSinglePool());
                            }
                        });
                    }
                    CustomCameraView.this.mTextureView.setVisibility(0);
                    CustomCameraView.this.mCameraView.setVisibility(4);
                    if (!CustomCameraView.this.mTextureView.isAvailable()) {
                        CustomCameraView.this.mTextureView.setSurfaceTextureListener(CustomCameraView.this.surfaceTextureListener);
                    } else {
                        CustomCameraView customCameraView = CustomCameraView.this;
                        customCameraView.startVideoPlay(customCameraView.mVideoFile);
                    }
                }
            });
        }

        @Override // com.luck.picture.lib.camera.listener.CaptureListener
        public void recordZoom(float f2) {
        }

        @Override // com.luck.picture.lib.camera.listener.CaptureListener
        public void takePictures() {
            CustomCameraView.this.mSwitchCamera.setVisibility(4);
            CustomCameraView.this.mFlashLamp.setVisibility(4);
            CustomCameraView.this.mCameraView.setCaptureMode(CameraView.CaptureMode.IMAGE);
            final File createImageFile = CustomCameraView.this.createImageFile();
            if (createImageFile == null) {
                return;
            }
            CustomCameraView.this.mCameraView.takePicture(createImageFile, ContextCompat.getMainExecutor(CustomCameraView.this.getContext().getApplicationContext()), new ImageCapture.OnImageSavedCallback() { // from class: com.luck.picture.lib.camera.CustomCameraView.1.1
                @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                public void onError(@NonNull ImageCaptureException imageCaptureException) {
                    if (CustomCameraView.this.mCameraListener != null) {
                        CustomCameraView.this.mCameraListener.onError(imageCaptureException.getImageCaptureError(), imageCaptureException.getMessage(), imageCaptureException.getCause());
                    }
                }

                @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                    if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(CustomCameraView.this.mConfig.cameraPath)) {
                        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<Boolean>() { // from class: com.luck.picture.lib.camera.CustomCameraView.1.1.1
                            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                            public Boolean doInBackground() {
                                Context context = CustomCameraView.this.getContext();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                return Boolean.valueOf(AndroidQTransformUtils.copyPathToDCIM(context, createImageFile, Uri.parse(CustomCameraView.this.mConfig.cameraPath)));
                            }

                            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                            public void onSuccess(Boolean bool) {
                                PictureThreadUtils.cancel(PictureThreadUtils.getSinglePool());
                            }
                        });
                    }
                    CustomCameraView.this.mPhotoFile = createImageFile;
                    if (CustomCameraView.this.mImageCallbackListener != null) {
                        CustomCameraView.this.mImageCallbackListener.onLoadImage(createImageFile, CustomCameraView.this.mImagePreview);
                    }
                    CustomCameraView.this.mImagePreview.setVisibility(0);
                    CustomCameraView.this.mCaptureLayout.startTypeBtnAnimator();
                }
            });
        }
    }

    public CustomCameraView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    static /* synthetic */ void m8124a(LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
    }

    private Uri getOutUri(int i2) {
        return i2 == PictureMimeType.ofVideo() ? MediaUtils.createVideoUri(getContext()) : MediaUtils.createImageUri(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetState() {
        if (this.mCameraView.getCaptureMode() == CameraView.CaptureMode.VIDEO) {
            if (this.mCameraView.isRecording()) {
                this.mCameraView.stopRecording();
            }
            File file = this.mVideoFile;
            if (file != null && file.exists()) {
                this.mVideoFile.delete();
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(this.mConfig.cameraPath)) {
                    getContext().getContentResolver().delete(Uri.parse(this.mConfig.cameraPath), null, null);
                } else {
                    new PictureMediaScannerConnection(getContext(), this.mVideoFile.getAbsolutePath());
                }
            }
        } else {
            this.mImagePreview.setVisibility(4);
            File file2 = this.mPhotoFile;
            if (file2 != null && file2.exists()) {
                this.mPhotoFile.delete();
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(this.mConfig.cameraPath)) {
                    getContext().getContentResolver().delete(Uri.parse(this.mConfig.cameraPath), null, null);
                } else {
                    new PictureMediaScannerConnection(getContext(), this.mPhotoFile.getAbsolutePath());
                }
            }
        }
        this.mSwitchCamera.setVisibility(0);
        this.mFlashLamp.setVisibility(0);
        this.mCameraView.setVisibility(0);
        this.mCaptureLayout.resetCaptureLayout();
    }

    private void setFlashRes() {
        switch (this.type_flash) {
            case 33:
                this.mFlashLamp.setImageResource(C2639R.drawable.picture_ic_flash_auto);
                this.mCameraView.setFlash(0);
                break;
            case 34:
                this.mFlashLamp.setImageResource(C2639R.drawable.picture_ic_flash_on);
                this.mCameraView.setFlash(1);
                break;
            case 35:
                this.mFlashLamp.setImageResource(C2639R.drawable.picture_ic_flash_off);
                this.mCameraView.setFlash(2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoPlay(File file) {
        try {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
            }
            this.mMediaPlayer.setDataSource(file.getAbsolutePath());
            this.mMediaPlayer.setSurface(new Surface(this.mTextureView.getSurfaceTexture()));
            this.mMediaPlayer.setLooping(true);
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.luck.picture.lib.camera.d
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    CustomCameraView.this.m8126a(mediaPlayer);
                }
            });
            this.mMediaPlayer.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVideoPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mTextureView.setVisibility(8);
    }

    /* renamed from: a */
    public /* synthetic */ void m8127a(View view) {
        this.type_flash++;
        if (this.type_flash > 35) {
            this.type_flash = 33;
        }
        setFlashRes();
    }

    /* renamed from: b */
    public /* synthetic */ void m8128b(View view) {
        this.mCameraView.toggleCamera();
    }

    public File createImageFile() {
        String str;
        String str2;
        if (SdkVersionUtils.checkedAndroid_Q()) {
            File file = new File(PictureFileUtils.getDiskCacheDir(getContext()));
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean isEmpty = TextUtils.isEmpty(this.mConfig.cameraFileName);
            String str3 = TextUtils.isEmpty(this.mConfig.suffixType) ? ".jpg" : this.mConfig.suffixType;
            if (isEmpty) {
                str2 = DateUtils.getCreateFileName("IMG_") + str3;
            } else {
                str2 = this.mConfig.cameraFileName;
            }
            File file2 = new File(file, str2);
            Uri outUri = getOutUri(PictureMimeType.ofImage());
            if (outUri != null) {
                this.mConfig.cameraPath = outUri.toString();
            }
            return file2;
        }
        if (TextUtils.isEmpty(this.mConfig.cameraFileName)) {
            str = "";
        } else {
            boolean isSuffixOfImage = PictureMimeType.isSuffixOfImage(this.mConfig.cameraFileName);
            PictureSelectionConfig pictureSelectionConfig = this.mConfig;
            pictureSelectionConfig.cameraFileName = !isSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".jpg") : pictureSelectionConfig.cameraFileName;
            PictureSelectionConfig pictureSelectionConfig2 = this.mConfig;
            boolean z = pictureSelectionConfig2.camera;
            str = pictureSelectionConfig2.cameraFileName;
            if (!z) {
                str = StringUtils.rename(str);
            }
        }
        Context context = getContext();
        int ofImage = PictureMimeType.ofImage();
        PictureSelectionConfig pictureSelectionConfig3 = this.mConfig;
        File createCameraFile = PictureFileUtils.createCameraFile(context, ofImage, str, pictureSelectionConfig3.suffixType, pictureSelectionConfig3.outPutCameraPath);
        if (createCameraFile != null) {
            this.mConfig.cameraPath = createCameraFile.getAbsolutePath();
        }
        return createCameraFile;
    }

    public File createVideoFile() {
        String str;
        String str2;
        if (SdkVersionUtils.checkedAndroid_Q()) {
            File file = new File(PictureFileUtils.getVideoDiskCacheDir(getContext()));
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean isEmpty = TextUtils.isEmpty(this.mConfig.cameraFileName);
            String str3 = TextUtils.isEmpty(this.mConfig.suffixType) ? ".mp4" : this.mConfig.suffixType;
            if (isEmpty) {
                str2 = DateUtils.getCreateFileName("VID_") + str3;
            } else {
                str2 = this.mConfig.cameraFileName;
            }
            File file2 = new File(file, str2);
            Uri outUri = getOutUri(PictureMimeType.ofVideo());
            if (outUri != null) {
                this.mConfig.cameraPath = outUri.toString();
            }
            return file2;
        }
        if (TextUtils.isEmpty(this.mConfig.cameraFileName)) {
            str = "";
        } else {
            boolean isSuffixOfImage = PictureMimeType.isSuffixOfImage(this.mConfig.cameraFileName);
            PictureSelectionConfig pictureSelectionConfig = this.mConfig;
            pictureSelectionConfig.cameraFileName = !isSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".mp4") : pictureSelectionConfig.cameraFileName;
            PictureSelectionConfig pictureSelectionConfig2 = this.mConfig;
            boolean z = pictureSelectionConfig2.camera;
            str = pictureSelectionConfig2.cameraFileName;
            if (!z) {
                str = StringUtils.rename(str);
            }
        }
        Context context = getContext();
        int ofVideo = PictureMimeType.ofVideo();
        PictureSelectionConfig pictureSelectionConfig3 = this.mConfig;
        File createCameraFile = PictureFileUtils.createCameraFile(context, ofVideo, str, pictureSelectionConfig3.suffixType, pictureSelectionConfig3.outPutCameraPath);
        this.mConfig.cameraPath = createCameraFile.getAbsolutePath();
        return createCameraFile;
    }

    public CameraView getCameraView() {
        return this.mCameraView;
    }

    public CaptureLayout getCaptureLayout() {
        return this.mCaptureLayout;
    }

    public void initView() {
        setWillNotDraw(false);
        setBackgroundColor(ContextCompat.getColor(getContext(), C2639R.color.picture_color_black));
        View inflate = LayoutInflater.from(getContext()).inflate(C2639R.layout.picture_camera_view, this);
        this.mCameraView = (CameraView) inflate.findViewById(C2639R.id.cameraView);
        this.mCameraView.enableTorch(true);
        this.mTextureView = (TextureView) inflate.findViewById(C2639R.id.video_play_preview);
        this.mImagePreview = (ImageView) inflate.findViewById(C2639R.id.image_preview);
        this.mSwitchCamera = (ImageView) inflate.findViewById(C2639R.id.image_switch);
        this.mSwitchCamera.setImageResource(C2639R.drawable.picture_ic_camera);
        this.mFlashLamp = (ImageView) inflate.findViewById(C2639R.id.image_flash);
        setFlashRes();
        this.mFlashLamp.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.camera.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomCameraView.this.m8127a(view);
            }
        });
        this.mCaptureLayout = (CaptureLayout) inflate.findViewById(C2639R.id.capture_layout);
        this.mCaptureLayout.setDuration(15000);
        this.mSwitchCamera.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.camera.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomCameraView.this.m8128b(view);
            }
        });
        this.mCaptureLayout.setCaptureListener(new C26511());
        this.mCaptureLayout.setTypeListener(new TypeListener() { // from class: com.luck.picture.lib.camera.CustomCameraView.2
            @Override // com.luck.picture.lib.camera.listener.TypeListener
            public void cancel() {
                CustomCameraView.this.stopVideoPlay();
                CustomCameraView.this.resetState();
            }

            @Override // com.luck.picture.lib.camera.listener.TypeListener
            public void confirm() {
                if (CustomCameraView.this.mCameraView.getCaptureMode() == CameraView.CaptureMode.VIDEO) {
                    if (CustomCameraView.this.mVideoFile == null) {
                        return;
                    }
                    CustomCameraView.this.stopVideoPlay();
                    if (CustomCameraView.this.mCameraListener == null && CustomCameraView.this.mVideoFile.exists()) {
                        return;
                    }
                    CustomCameraView.this.mCameraListener.onRecordSuccess(CustomCameraView.this.mVideoFile);
                    return;
                }
                if (CustomCameraView.this.mPhotoFile == null || !CustomCameraView.this.mPhotoFile.exists()) {
                    return;
                }
                CustomCameraView.this.mImagePreview.setVisibility(4);
                if (CustomCameraView.this.mCameraListener != null) {
                    CustomCameraView.this.mCameraListener.onPictureSuccess(CustomCameraView.this.mPhotoFile);
                }
            }
        });
        this.mCaptureLayout.setLeftClickListener(new ClickListener() { // from class: com.luck.picture.lib.camera.c
            @Override // com.luck.picture.lib.camera.listener.ClickListener
            public final void onClick() {
                CustomCameraView.this.m8125a();
            }
        });
    }

    public void setBindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mCameraView.bindToLifecycle(lifecycleOwner);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.luck.picture.lib.camera.b
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event2) {
                CustomCameraView.m8124a(lifecycleOwner2, event2);
            }
        });
    }

    public void setCameraListener(CameraListener cameraListener) {
        this.mCameraListener = cameraListener;
    }

    public void setImageCallbackListener(ImageCallbackListener imageCallbackListener) {
        this.mImageCallbackListener = imageCallbackListener;
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.mOnClickListener = clickListener;
    }

    public void setPictureSelectionConfig(PictureSelectionConfig pictureSelectionConfig) {
        this.mConfig = pictureSelectionConfig;
    }

    public void setRecordVideoMaxTime(int i2) {
        this.mCaptureLayout.setDuration(i2 * 1000);
    }

    public void setRecordVideoMinTime(int i2) {
        this.mCaptureLayout.setMinDuration(i2 * 1000);
    }

    public CustomCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomCameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.type_flash = 35;
        this.recordTime = 0L;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.luck.picture.lib.camera.CustomCameraView.3
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
                CustomCameraView customCameraView = CustomCameraView.this;
                customCameraView.startVideoPlay(customCameraView.mVideoFile);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        initView();
    }

    /* renamed from: a */
    public /* synthetic */ void m8125a() {
        ClickListener clickListener = this.mOnClickListener;
        if (clickListener != null) {
            clickListener.onClick();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8126a(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        float videoWidth = (mediaPlayer.getVideoWidth() * 1.0f) / mediaPlayer.getVideoHeight();
        int width = this.mTextureView.getWidth();
        ViewGroup.LayoutParams layoutParams = this.mTextureView.getLayoutParams();
        layoutParams.height = (int) (width / videoWidth);
        this.mTextureView.setLayoutParams(layoutParams);
    }
}
