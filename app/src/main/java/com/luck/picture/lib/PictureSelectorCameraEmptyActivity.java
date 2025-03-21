package com.luck.picture.lib;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.tools.BitmapUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PictureSelectorCameraEmptyActivity extends PictureBaseActivity {
    private void cameraHandleResult(LocalMedia localMedia, String str) {
        boolean eqImage = PictureMimeType.eqImage(str);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enableCrop && eqImage) {
            String str2 = pictureSelectionConfig.cameraPath;
            pictureSelectionConfig.originalPath = str2;
            startCrop(str2, str);
            return;
        }
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        if (pictureSelectionConfig2.isCompress && eqImage && !pictureSelectionConfig2.isCheckOriginalImage) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(localMedia);
            compressImage(arrayList);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(localMedia);
            onResult(arrayList2);
        }
    }

    private void onTakePhoto() {
        if (!PermissionChecker.checkSelfPermission(this, util.permissionutil.a.f20909c)) {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20909c}, 2);
            return;
        }
        if (this.config.isUseCustomCamera ? PermissionChecker.checkSelfPermission(this, util.permissionutil.a.f20915i) : true) {
            startCamera();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20915i}, 4);
        }
    }

    private void startCamera() {
        int i2 = this.config.chooseMode;
        if (i2 == 0 || i2 == 1) {
            startOpenCamera();
        } else if (i2 == 2) {
            startOpenCameraVideo();
        } else {
            if (i2 != 3) {
                return;
            }
            startOpenCameraAudio();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_empty;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, ContextCompat.getColor(this, R.color.picture_color_transparent), ContextCompat.getColor(this, R.color.picture_color_transparent), this.openWhiteStatusBar);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        OnResultCallbackListener onResultCallbackListener;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 69) {
                singleCropHandleResult(intent);
                return;
            } else {
                if (i2 != 909) {
                    return;
                }
                requestCamera(intent);
                return;
            }
        }
        if (i3 == 0) {
            if (this.config != null && (onResultCallbackListener = PictureSelectionConfig.listener) != null) {
                onResultCallbackListener.onCancel();
            }
            closeActivity();
            return;
        }
        if (i3 != 96 || intent == null) {
            return;
        }
        ToastUtils.s(getContext(), ((Throwable) intent.getSerializableExtra(UCrop.EXTRA_ERROR)).getMessage());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void a() {
        super.a();
        closeActivity();
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (!this.config.isUseCustomCamera && PictureSelectionConfig.onPictureSelectorInterfaceListener == null) {
            if (bundle == null) {
                if (PermissionChecker.checkSelfPermission(this, util.permissionutil.a.z) && PermissionChecker.checkSelfPermission(this, util.permissionutil.a.A)) {
                    onTakePhoto();
                } else {
                    PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.z, util.permissionutil.a.A}, 1);
                }
            }
            setTheme(R.style.Picture_Theme_Translucent);
        }
        super.onCreate(bundle);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20909c}, 2);
                return;
            } else {
                ToastUtils.s(getContext(), getString(R.string.picture_jurisdiction));
                closeActivity();
                return;
            }
        }
        if (i2 == 2) {
            if (iArr.length > 0 && iArr[0] == 0) {
                onTakePhoto();
                return;
            } else {
                closeActivity();
                ToastUtils.s(getContext(), getString(R.string.picture_camera));
                return;
            }
        }
        if (i2 != 4) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            onTakePhoto();
        } else {
            closeActivity();
            ToastUtils.s(getContext(), getString(R.string.picture_audio));
        }
    }

    protected void requestCamera(Intent intent) {
        String str;
        long j2;
        int lastImageId;
        int[] videoSizeForUrl;
        int[] videoSizeForUri;
        long extractDuration;
        boolean checkedAndroid_Q = SdkVersionUtils.checkedAndroid_Q();
        long j3 = 0;
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            this.config.cameraPath = getAudioPath(intent);
            if (TextUtils.isEmpty(this.config.cameraPath)) {
                return;
            }
            j2 = MediaUtils.extractDuration(getContext(), checkedAndroid_Q, this.config.cameraPath);
            str = PictureMimeType.MIME_TYPE_AUDIO;
        } else {
            str = null;
            j2 = 0;
        }
        if (TextUtils.isEmpty(this.config.cameraPath)) {
            return;
        }
        new File(this.config.cameraPath);
        int[] iArr = new int[2];
        if (!checkedAndroid_Q) {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            if (pictureSelectionConfig.isFallbackVersion3) {
                new PictureMediaScannerConnection(getContext(), this.config.cameraPath);
            } else {
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(pictureSelectionConfig.cameraPath))));
            }
        }
        LocalMedia localMedia = new LocalMedia();
        if (this.config.chooseMode != PictureMimeType.ofAudio()) {
            if (PictureMimeType.isContent(this.config.cameraPath)) {
                String path = PictureFileUtils.getPath(getApplicationContext(), Uri.parse(this.config.cameraPath));
                long length = new File(path).length();
                String mimeType = PictureMimeType.getMimeType(this.config.cameraMimeType);
                if (PictureMimeType.eqImage(mimeType)) {
                    long j4 = j2;
                    videoSizeForUri = MediaUtils.getImageSizeForUrlToAndroidQ(this, this.config.cameraPath);
                    extractDuration = j4;
                } else {
                    videoSizeForUri = MediaUtils.getVideoSizeForUri(this, Uri.parse(this.config.cameraPath));
                    extractDuration = MediaUtils.extractDuration(getContext(), true, this.config.cameraPath);
                }
                int lastIndexOf = this.config.cameraPath.lastIndexOf("/") + 1;
                localMedia.setId(lastIndexOf > 0 ? ValueOf.toLong(this.config.cameraPath.substring(lastIndexOf)) : -1L);
                localMedia.setRealPath(path);
                if (this.config.isUseCustomCamera && intent != null) {
                    localMedia.setAndroidQToPath(intent.getStringExtra(PictureConfig.EXTRA_MEDIA_PATH));
                }
                j3 = length;
                str = mimeType;
                iArr = videoSizeForUri;
                j2 = extractDuration;
            } else {
                File file = new File(this.config.cameraPath);
                str = PictureMimeType.getMimeType(this.config.cameraMimeType);
                j3 = file.length();
                if (PictureMimeType.eqImage(str)) {
                    BitmapUtils.rotateImage(PictureFileUtils.readPictureDegree(this, this.config.cameraPath), this.config.cameraPath);
                    videoSizeForUrl = MediaUtils.getImageSizeForUrl(this.config.cameraPath);
                } else {
                    videoSizeForUrl = MediaUtils.getVideoSizeForUrl(this.config.cameraPath);
                    j2 = MediaUtils.extractDuration(getContext(), false, this.config.cameraPath);
                }
                iArr = videoSizeForUrl;
                localMedia.setId(System.currentTimeMillis());
            }
        }
        localMedia.setDuration(j2);
        localMedia.setWidth(iArr[0]);
        localMedia.setHeight(iArr[1]);
        localMedia.setPath(this.config.cameraPath);
        localMedia.setMimeType(str);
        localMedia.setSize(j3);
        localMedia.setChooseModel(this.config.chooseMode);
        MediaUtils.setOrientation(getContext(), localMedia);
        cameraHandleResult(localMedia, str);
        if (checkedAndroid_Q || !PictureMimeType.eqImage(localMedia.getMimeType()) || (lastImageId = MediaUtils.getLastImageId(getContext(), localMedia.getMimeType())) == -1) {
            return;
        }
        MediaUtils.removeMedia(getContext(), lastImageId);
    }

    protected void singleCropHandleResult(Intent intent) {
        int i2;
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Uri output = UCrop.getOutput(intent);
        if (output == null) {
            return;
        }
        String path = output.getPath();
        boolean isEmpty = TextUtils.isEmpty(path);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        LocalMedia localMedia = new LocalMedia(pictureSelectionConfig.cameraPath, 0L, false, pictureSelectionConfig.isCamera ? 1 : 0, 0, pictureSelectionConfig.chooseMode);
        if (SdkVersionUtils.checkedAndroid_Q()) {
            int lastIndexOf = this.config.cameraPath.lastIndexOf("/") + 1;
            localMedia.setId(lastIndexOf > 0 ? ValueOf.toLong(this.config.cameraPath.substring(lastIndexOf)) : -1L);
            localMedia.setAndroidQToPath(path);
            if (!isEmpty) {
                localMedia.setSize(new File(path).length());
            } else if (PictureMimeType.isContent(this.config.cameraPath)) {
                String path2 = PictureFileUtils.getPath(this, Uri.parse(this.config.cameraPath));
                localMedia.setSize(!TextUtils.isEmpty(path2) ? new File(path2).length() : 0L);
            } else {
                localMedia.setSize(new File(this.config.cameraPath).length());
            }
        } else {
            localMedia.setId(System.currentTimeMillis());
            localMedia.setSize(new File(isEmpty ? localMedia.getPath() : path).length());
        }
        localMedia.setCut(!isEmpty);
        localMedia.setCutPath(path);
        localMedia.setMimeType(PictureMimeType.getImageMimeType(path));
        localMedia.setOrientation(-1);
        int i3 = 0;
        if (PictureMimeType.isContent(localMedia.getPath())) {
            if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                int[] videoSizeForUri = MediaUtils.getVideoSizeForUri(getContext(), Uri.parse(localMedia.getPath()));
                i3 = videoSizeForUri[0];
                i2 = videoSizeForUri[1];
            } else {
                if (PictureMimeType.eqImage(localMedia.getMimeType())) {
                    int[] imageSizeForUri = MediaUtils.getImageSizeForUri(getContext(), Uri.parse(localMedia.getPath()));
                    i3 = imageSizeForUri[0];
                    i2 = imageSizeForUri[1];
                }
                i2 = 0;
            }
        } else if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
            int[] videoSizeForUrl = MediaUtils.getVideoSizeForUrl(localMedia.getPath());
            i3 = videoSizeForUrl[0];
            i2 = videoSizeForUrl[1];
        } else {
            if (PictureMimeType.eqImage(localMedia.getMimeType())) {
                int[] imageSizeForUrl = MediaUtils.getImageSizeForUrl(localMedia.getPath());
                i3 = imageSizeForUrl[0];
                i2 = imageSizeForUrl[1];
            }
            i2 = 0;
        }
        localMedia.setWidth(i3);
        localMedia.setHeight(i2);
        MediaUtils.setOrientation(getContext(), localMedia);
        arrayList.add(localMedia);
        handlerResult(arrayList);
    }
}
