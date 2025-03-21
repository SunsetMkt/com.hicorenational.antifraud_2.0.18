package com.luck.picture.lib;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.just.agentweb.AgentWebPermissions;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.PictureMediaScannerConnection;
import com.luck.picture.lib.broadcast.BroadcastAction;
import com.luck.picture.lib.broadcast.BroadcastManager;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.listener.OnVideoSelectedPlayCallback;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.PreviewViewPager;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes.dex */
public class PictureExternalPreviewActivity extends PictureBaseActivity implements View.OnClickListener {

    /* renamed from: adapter, reason: collision with root package name */
    private SimpleFragmentAdapter f7744adapter;
    private String downloadPath;
    private ImageButton ibDelete;
    private ImageButton ibLeftBack;
    private boolean isAndroidQ;
    private String mMimeType;
    private View titleViewBg;
    private TextView tvTitle;
    private PreviewViewPager viewPager;
    private List<LocalMedia> images = new ArrayList();
    private int position = 0;

    static /* synthetic */ void a() {
    }

    private Uri createOutImageUri() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", ValueOf.toString(Long.valueOf(System.currentTimeMillis())));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", PictureMimeType.DCIM);
        return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setPanEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitAnimation() {
        int i2;
        int i3 = R.anim.picture_anim_fade_in;
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        if (pictureWindowAnimationStyle == null || (i2 = pictureWindowAnimationStyle.activityPreviewExitAnimation) == 0) {
            i2 = R.anim.picture_anim_exit;
        }
        overridePendingTransition(i3, i2);
    }

    private void initViewPageAdapterData() {
        this.tvTitle.setText(getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(this.position + 1), Integer.valueOf(this.images.size())}));
        this.f7744adapter = new SimpleFragmentAdapter();
        this.viewPager.setAdapter(this.f7744adapter);
        this.viewPager.setCurrentItem(this.position);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.luck.picture.lib.PictureExternalPreviewActivity.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                PictureExternalPreviewActivity.this.tvTitle.setText(PictureExternalPreviewActivity.this.getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(i2 + 1), Integer.valueOf(PictureExternalPreviewActivity.this.images.size())}));
                PictureExternalPreviewActivity.this.position = i2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccessful(String str) {
        dismissDialog();
        if (TextUtils.isEmpty(str)) {
            ToastUtils.s(getContext(), getString(R.string.picture_save_error));
            return;
        }
        try {
            if (!SdkVersionUtils.checkedAndroid_Q()) {
                File file = new File(str);
                MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                new PictureMediaScannerConnection(getContext(), file.getAbsolutePath(), new PictureMediaScannerConnection.ScanListener() { // from class: com.luck.picture.lib.j
                    @Override // com.luck.picture.lib.PictureMediaScannerConnection.ScanListener
                    public final void onScanFinish() {
                        PictureExternalPreviewActivity.a();
                    }
                });
            }
            ToastUtils.s(getContext(), getString(R.string.picture_save_success) + "\n" + str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void savePictureAlbum() throws Exception {
        String absolutePath;
        String lastImgSuffix = PictureMimeType.getLastImgSuffix(this.mMimeType);
        String externalStorageState = Environment.getExternalStorageState();
        File externalStoragePublicDirectory = externalStorageState.equals("mounted") ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) : getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalStoragePublicDirectory != null && !externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        if (this.isAndroidQ || !externalStorageState.equals("mounted")) {
            absolutePath = externalStoragePublicDirectory.getAbsolutePath();
        } else {
            absolutePath = externalStoragePublicDirectory.getAbsolutePath() + File.separator + AgentWebPermissions.ACTION_CAMERA + File.separator;
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, DateUtils.getCreateFileName("IMG_") + lastImgSuffix);
        PictureFileUtils.copyFile(this.downloadPath, file2.getAbsolutePath());
        onSuccessful(file2.getAbsolutePath());
    }

    private void savePictureAlbumAndroidQ(final Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", ValueOf.toString(Long.valueOf(System.currentTimeMillis())));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", PictureMimeType.DCIM);
        final Uri insert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            ToastUtils.s(getContext(), getString(R.string.picture_save_error));
        } else {
            PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<String>() { // from class: com.luck.picture.lib.PictureExternalPreviewActivity.3
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public String doInBackground() {
                    BufferedSource bufferedSource = null;
                    try {
                        try {
                            bufferedSource = Okio.buffer(Okio.source((InputStream) Objects.requireNonNull(PictureExternalPreviewActivity.this.getContentResolver().openInputStream(uri))));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (bufferedSource == null || !bufferedSource.isOpen()) {
                                return "";
                            }
                        }
                        if (PictureFileUtils.bufferCopy(bufferedSource, PictureExternalPreviewActivity.this.getContentResolver().openOutputStream(insert))) {
                            String path = PictureFileUtils.getPath(PictureExternalPreviewActivity.this.getContext(), insert);
                            if (bufferedSource != null && bufferedSource.isOpen()) {
                                PictureFileUtils.close(bufferedSource);
                            }
                            return path;
                        }
                        if (bufferedSource == null || !bufferedSource.isOpen()) {
                            return "";
                        }
                        PictureFileUtils.close(bufferedSource);
                        return "";
                    } catch (Throwable th) {
                        if (bufferedSource != null && bufferedSource.isOpen()) {
                            PictureFileUtils.close(bufferedSource);
                        }
                        throw th;
                    }
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(String str) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                    PictureExternalPreviewActivity.this.onSuccessful(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownLoadDialog() {
        if (isFinishing() || TextUtils.isEmpty(this.downloadPath)) {
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_wind_base_dialog);
        Button button = (Button) pictureCustomDialog.findViewById(R.id.btn_cancel);
        Button button2 = (Button) pictureCustomDialog.findViewById(R.id.btn_commit);
        TextView textView = (TextView) pictureCustomDialog.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) pictureCustomDialog.findViewById(R.id.tv_content);
        textView.setText(getString(R.string.picture_prompt));
        textView2.setText(getString(R.string.picture_prompt_content));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureExternalPreviewActivity.this.a(pictureCustomDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureExternalPreviewActivity.this.b(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }

    public /* synthetic */ void a(PictureCustomDialog pictureCustomDialog, View view) {
        if (isFinishing()) {
            return;
        }
        pictureCustomDialog.dismiss();
    }

    public /* synthetic */ void b(PictureCustomDialog pictureCustomDialog, View view) {
        boolean isHttp = PictureMimeType.isHttp(this.downloadPath);
        showPleaseDialog();
        if (isHttp) {
            PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<String>() { // from class: com.luck.picture.lib.PictureExternalPreviewActivity.2
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public String doInBackground() {
                    PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
                    return pictureExternalPreviewActivity.showLoadingImage(pictureExternalPreviewActivity.downloadPath);
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(String str) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                    PictureExternalPreviewActivity.this.onSuccessful(str);
                }
            });
        } else {
            try {
                if (this.isAndroidQ) {
                    savePictureAlbumAndroidQ(PictureMimeType.isContent(this.downloadPath) ? Uri.parse(this.downloadPath) : Uri.fromFile(new File(this.downloadPath)));
                } else {
                    savePictureAlbum();
                }
            } catch (Exception e2) {
                ToastUtils.s(getContext(), getString(R.string.picture_save_error) + "\n" + e2.getMessage());
                dismissDialog();
                e2.printStackTrace();
            }
        }
        if (isFinishing()) {
            return;
        }
        pictureCustomDialog.dismiss();
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_activity_external_preview;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void initPictureSelectorStyle() {
        PictureParameterStyle pictureParameterStyle = this.config.style;
        if (pictureParameterStyle == null) {
            int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_ac_preview_title_bg);
            if (typeValueColor != 0) {
                this.titleViewBg.setBackgroundColor(typeValueColor);
                return;
            } else {
                this.titleViewBg.setBackgroundColor(this.colorPrimary);
                return;
            }
        }
        int i2 = pictureParameterStyle.pictureTitleTextColor;
        if (i2 != 0) {
            this.tvTitle.setTextColor(i2);
        }
        int i3 = this.config.style.pictureTitleTextSize;
        if (i3 != 0) {
            this.tvTitle.setTextSize(i3);
        }
        int i4 = this.config.style.pictureLeftBackIcon;
        if (i4 != 0) {
            this.ibLeftBack.setImageResource(i4);
        }
        int i5 = this.config.style.pictureExternalPreviewDeleteStyle;
        if (i5 != 0) {
            this.ibDelete.setImageResource(i5);
        }
        if (this.config.style.pictureTitleBarBackgroundColor != 0) {
            this.titleViewBg.setBackgroundColor(this.colorPrimary);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.isAndroidQ = SdkVersionUtils.checkedAndroid_Q();
        this.titleViewBg = findViewById(R.id.titleViewBg);
        this.tvTitle = (TextView) findViewById(R.id.picture_title);
        this.ibLeftBack = (ImageButton) findViewById(R.id.left_back);
        this.ibDelete = (ImageButton) findViewById(R.id.ib_delete);
        this.viewPager = (PreviewViewPager) findViewById(R.id.preview_pager);
        this.position = getIntent().getIntExtra("position", 0);
        this.images = (List) getIntent().getSerializableExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST);
        this.ibLeftBack.setOnClickListener(this);
        this.ibDelete.setOnClickListener(this);
        ImageButton imageButton = this.ibDelete;
        PictureParameterStyle pictureParameterStyle = this.config.style;
        int i2 = 8;
        if (pictureParameterStyle != null && pictureParameterStyle.pictureExternalPreviewGonePreviewDelete) {
            i2 = 0;
        }
        imageButton.setVisibility(i2);
        initViewPageAdapterData();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void a() {
        super.a();
        finish();
        exitAnimation();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<LocalMedia> list;
        int id = view.getId();
        if (id == R.id.left_back) {
            finish();
            exitAnimation();
            return;
        }
        if (id != R.id.ib_delete || (list = this.images) == null || list.size() <= 0) {
            return;
        }
        int currentItem = this.viewPager.getCurrentItem();
        this.images.remove(currentItem);
        this.f7744adapter.removeCacheView(currentItem);
        Bundle bundle = new Bundle();
        bundle.putInt("position", currentItem);
        BroadcastManager.getInstance(getContext()).action(BroadcastAction.ACTION_DELETE_PREVIEW_POSITION).extras(bundle).broadcast();
        if (this.images.size() == 0) {
            a();
            return;
        }
        this.tvTitle.setText(getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(this.position + 1), Integer.valueOf(this.images.size())}));
        this.position = currentItem;
        this.f7744adapter.notifyDataSetChanged();
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SimpleFragmentAdapter simpleFragmentAdapter = this.f7744adapter;
        if (simpleFragmentAdapter != null) {
            simpleFragmentAdapter.clear();
        }
        if (PictureSelectionConfig.customVideoPlayCallback != null) {
            PictureSelectionConfig.customVideoPlayCallback = null;
        }
        if (PictureSelectionConfig.onPictureSelectorInterfaceListener != null) {
            PictureSelectionConfig.onPictureSelectorInterfaceListener = null;
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 1) {
            return;
        }
        for (int i3 : iArr) {
            if (i3 == 0) {
                showDownLoadDialog();
            } else {
                ToastUtils.s(getContext(), getString(R.string.picture_jurisdiction));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.io.Closeable, okio.BufferedSource] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.Closeable] */
    public String showLoadingImage(String str) {
        OutputStream outputStream;
        Closeable closeable;
        Object obj;
        Uri uri;
        ?? r3;
        String str2;
        Closeable closeable2 = null;
        try {
            try {
                try {
                    if (this.isAndroidQ) {
                        uri = createOutImageUri();
                    } else {
                        String lastImgSuffix = PictureMimeType.getLastImgSuffix(this.mMimeType);
                        String externalStorageState = Environment.getExternalStorageState();
                        File externalStoragePublicDirectory = externalStorageState.equals("mounted") ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) : getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                        if (externalStoragePublicDirectory != null) {
                            if (!externalStoragePublicDirectory.exists()) {
                                externalStoragePublicDirectory.mkdirs();
                            }
                            if (externalStorageState.equals("mounted")) {
                                str2 = externalStoragePublicDirectory.getAbsolutePath() + File.separator + AgentWebPermissions.ACTION_CAMERA + File.separator;
                            } else {
                                str2 = externalStoragePublicDirectory.getAbsolutePath();
                            }
                            File file = new File(str2);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            uri = Uri.fromFile(new File(file, DateUtils.getCreateFileName("IMG_") + lastImgSuffix));
                        } else {
                            uri = null;
                        }
                    }
                    if (uri != null) {
                        try {
                            outputStream = (OutputStream) Objects.requireNonNull(getContentResolver().openOutputStream(uri));
                            try {
                                str = new URL(str).openStream();
                                try {
                                    r3 = Okio.buffer(Okio.source((InputStream) str));
                                } catch (Exception unused) {
                                    r3 = 0;
                                    str = str;
                                } catch (Throwable th) {
                                    th = th;
                                    closeable = null;
                                    closeable2 = str;
                                    th = th;
                                    PictureFileUtils.close(closeable2);
                                    PictureFileUtils.close(outputStream);
                                    PictureFileUtils.close(closeable);
                                    throw th;
                                }
                            } catch (Exception unused2) {
                                str = 0;
                                r3 = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = null;
                                PictureFileUtils.close(closeable2);
                                PictureFileUtils.close(outputStream);
                                PictureFileUtils.close(closeable);
                                throw th;
                            }
                        } catch (Exception unused3) {
                            obj = null;
                            outputStream = null;
                            r3 = outputStream;
                            str = obj;
                            if (uri != null) {
                                getContentResolver().delete(uri, null, null);
                            }
                            PictureFileUtils.close(str);
                            PictureFileUtils.close(outputStream);
                            PictureFileUtils.close(r3);
                            return null;
                        }
                        try {
                            if (PictureFileUtils.bufferCopy((BufferedSource) r3, outputStream)) {
                                String path = PictureFileUtils.getPath(this, uri);
                                PictureFileUtils.close(str);
                                PictureFileUtils.close(outputStream);
                                PictureFileUtils.close(r3);
                                return path;
                            }
                        } catch (Exception unused4) {
                            r3 = r3;
                            str = str;
                            if (uri != null && this.isAndroidQ) {
                                getContentResolver().delete(uri, null, null);
                            }
                            PictureFileUtils.close(str);
                            PictureFileUtils.close(outputStream);
                            PictureFileUtils.close(r3);
                            return null;
                        }
                    } else {
                        str = 0;
                        outputStream = null;
                        r3 = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    closeable = null;
                }
            } catch (Exception unused5) {
                obj = null;
                uri = null;
                outputStream = null;
            }
            PictureFileUtils.close(str);
            PictureFileUtils.close(outputStream);
            PictureFileUtils.close(r3);
            return null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public class SimpleFragmentAdapter extends PagerAdapter {
        private static final int MAX_CACHE_SIZE = 20;
        private SparseArray<View> mCacheView = new SparseArray<>();

        public SimpleFragmentAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            SparseArray<View> sparseArray = this.mCacheView;
            if (sparseArray != null) {
                sparseArray.clear();
                this.mCacheView = null;
            }
        }

        public /* synthetic */ void a(View view, float f2, float f3) {
            PictureExternalPreviewActivity.this.finish();
            PictureExternalPreviewActivity.this.exitAnimation();
        }

        public /* synthetic */ boolean b(String str, LocalMedia localMedia, View view) {
            PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
            if (pictureExternalPreviewActivity.config.isNotPreviewDownload) {
                if (PermissionChecker.checkSelfPermission(pictureExternalPreviewActivity.getContext(), util.permissionutil.a.A)) {
                    PictureExternalPreviewActivity.this.downloadPath = str;
                    String imageMimeType = PictureMimeType.isHttp(str) ? PictureMimeType.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
                    PictureExternalPreviewActivity pictureExternalPreviewActivity2 = PictureExternalPreviewActivity.this;
                    if (PictureMimeType.isJPG(imageMimeType)) {
                        imageMimeType = "image/jpeg";
                    }
                    pictureExternalPreviewActivity2.mMimeType = imageMimeType;
                    PictureExternalPreviewActivity.this.showDownLoadDialog();
                } else {
                    PermissionChecker.requestPermissions(PictureExternalPreviewActivity.this, new String[]{util.permissionutil.a.A}, 1);
                }
            }
            return true;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
            if (this.mCacheView.size() > 20) {
                this.mCacheView.remove(i2);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (PictureExternalPreviewActivity.this.images != null) {
                return PictureExternalPreviewActivity.this.images.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(final ViewGroup viewGroup, int i2) {
            ImageEngine imageEngine;
            ImageEngine imageEngine2;
            View view = this.mCacheView.get(i2);
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_image_preview, viewGroup, false);
                this.mCacheView.put(i2, view);
            }
            PhotoView photoView = (PhotoView) view.findViewById(R.id.preview_image);
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view.findViewById(R.id.longImg);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_play);
            final LocalMedia localMedia = (LocalMedia) PictureExternalPreviewActivity.this.images.get(i2);
            if (localMedia != null) {
                final String compressPath = (!localMedia.isCut() || localMedia.isCompressed()) ? (localMedia.isCompressed() || (localMedia.isCut() && localMedia.isCompressed())) ? localMedia.getCompressPath() : !TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? localMedia.getAndroidQToPath() : localMedia.getPath() : localMedia.getCutPath();
                boolean isHttp = PictureMimeType.isHttp(compressPath);
                String imageMimeType = isHttp ? PictureMimeType.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
                boolean eqVideo = PictureMimeType.eqVideo(imageMimeType);
                int i3 = 8;
                imageView.setVisibility(eqVideo ? 0 : 8);
                boolean isGif = PictureMimeType.isGif(imageMimeType);
                boolean isLongImg = MediaUtils.isLongImg(localMedia);
                photoView.setVisibility((!isLongImg || isGif) ? 0 : 8);
                if (isLongImg && !isGif) {
                    i3 = 0;
                }
                subsamplingScaleImageView.setVisibility(i3);
                if (!isGif || localMedia.isCompressed()) {
                    PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
                    if (pictureExternalPreviewActivity.config != null && (imageEngine = PictureSelectionConfig.imageEngine) != null) {
                        if (isHttp) {
                            imageEngine.loadImage(view.getContext(), compressPath, photoView, subsamplingScaleImageView, new OnImageCompleteCallback() { // from class: com.luck.picture.lib.PictureExternalPreviewActivity.SimpleFragmentAdapter.1
                                @Override // com.luck.picture.lib.listener.OnImageCompleteCallback
                                public void onHideLoading() {
                                    PictureExternalPreviewActivity.this.dismissDialog();
                                }

                                @Override // com.luck.picture.lib.listener.OnImageCompleteCallback
                                public void onShowLoading() {
                                    PictureExternalPreviewActivity.this.showPleaseDialog();
                                }
                            });
                        } else if (isLongImg) {
                            pictureExternalPreviewActivity.displayLongPic(pictureExternalPreviewActivity.isAndroidQ ? Uri.parse(compressPath) : Uri.fromFile(new File(compressPath)), subsamplingScaleImageView);
                        } else {
                            imageEngine.loadImage(view.getContext(), compressPath, photoView);
                        }
                    }
                } else {
                    PictureExternalPreviewActivity pictureExternalPreviewActivity2 = PictureExternalPreviewActivity.this;
                    if (pictureExternalPreviewActivity2.config != null && (imageEngine2 = PictureSelectionConfig.imageEngine) != null) {
                        imageEngine2.loadAsGifImage(pictureExternalPreviewActivity2.getContext(), compressPath, photoView);
                    }
                }
                photoView.setOnViewTapListener(new OnViewTapListener() { // from class: com.luck.picture.lib.e
                    @Override // com.luck.picture.lib.photoview.OnViewTapListener
                    public final void onViewTap(View view2, float f2, float f3) {
                        PictureExternalPreviewActivity.SimpleFragmentAdapter.this.a(view2, f2, f3);
                    }
                });
                subsamplingScaleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PictureExternalPreviewActivity.SimpleFragmentAdapter.this.a(view2);
                    }
                });
                if (!eqVideo) {
                    subsamplingScaleImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.luck.picture.lib.f
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view2) {
                            return PictureExternalPreviewActivity.SimpleFragmentAdapter.this.a(compressPath, localMedia, view2);
                        }
                    });
                }
                if (!eqVideo) {
                    photoView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.luck.picture.lib.g
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view2) {
                            return PictureExternalPreviewActivity.SimpleFragmentAdapter.this.b(compressPath, localMedia, view2);
                        }
                    });
                }
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PictureExternalPreviewActivity.SimpleFragmentAdapter.a(LocalMedia.this, compressPath, viewGroup, view2);
                    }
                });
            }
            viewGroup.addView(view, 0);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void removeCacheView(int i2) {
            SparseArray<View> sparseArray = this.mCacheView;
            if (sparseArray == null || i2 >= sparseArray.size()) {
                return;
            }
            this.mCacheView.removeAt(i2);
        }

        public /* synthetic */ void a(View view) {
            PictureExternalPreviewActivity.this.finish();
            PictureExternalPreviewActivity.this.exitAnimation();
        }

        public /* synthetic */ boolean a(String str, LocalMedia localMedia, View view) {
            PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
            if (pictureExternalPreviewActivity.config.isNotPreviewDownload) {
                if (PermissionChecker.checkSelfPermission(pictureExternalPreviewActivity.getContext(), util.permissionutil.a.A)) {
                    PictureExternalPreviewActivity.this.downloadPath = str;
                    String imageMimeType = PictureMimeType.isHttp(str) ? PictureMimeType.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
                    PictureExternalPreviewActivity pictureExternalPreviewActivity2 = PictureExternalPreviewActivity.this;
                    if (PictureMimeType.isJPG(imageMimeType)) {
                        imageMimeType = "image/jpeg";
                    }
                    pictureExternalPreviewActivity2.mMimeType = imageMimeType;
                    PictureExternalPreviewActivity.this.showDownLoadDialog();
                } else {
                    PermissionChecker.requestPermissions(PictureExternalPreviewActivity.this, new String[]{util.permissionutil.a.A}, 1);
                }
            }
            return true;
        }

        static /* synthetic */ void a(LocalMedia localMedia, String str, ViewGroup viewGroup, View view) {
            OnVideoSelectedPlayCallback onVideoSelectedPlayCallback = PictureSelectionConfig.customVideoPlayCallback;
            if (onVideoSelectedPlayCallback != null) {
                onVideoSelectedPlayCallback.startPlayVideo(localMedia);
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("videoPath", str);
            intent.putExtras(bundle);
            JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
        }
    }
}
