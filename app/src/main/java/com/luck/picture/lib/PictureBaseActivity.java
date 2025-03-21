package com.luck.picture.lib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.compress.OnCompressListener;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureLoadingDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.immersive.NavBarUtils;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.VoiceUtils;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.CutInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p324i.p336c.p337a.InterfaceC5816d;
import util.permissionutil.C7308a;

/* loaded from: classes.dex */
public abstract class PictureBaseActivity extends AppCompatActivity {
    protected int colorPrimary;
    protected int colorPrimaryDark;
    protected PictureSelectionConfig config;
    protected View container;
    private int index = 0;
    protected boolean isOnSaveInstanceState;
    protected Handler mHandler;
    protected PictureLoadingDialog mLoadingDialog;
    protected boolean numComplete;
    protected boolean openWhiteStatusBar;
    protected List<LocalMedia> selectionMedias;

    private UCrop.Options basicOptions() {
        return basicOptions(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void compressToLuban(final List<LocalMedia> list) {
        if (this.config.synOrAsy) {
            PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<File>>() { // from class: com.luck.picture.lib.PictureBaseActivity.2
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public List<File> doInBackground() throws Exception {
                    return Luban.with(PictureBaseActivity.this.getContext()).loadMediaData(list).isCamera(PictureBaseActivity.this.config.camera).setTargetDir(PictureBaseActivity.this.config.compressSavePath).setCompressQuality(PictureBaseActivity.this.config.compressQuality).setFocusAlpha(PictureBaseActivity.this.config.focusAlpha).setNewCompressFileName(PictureBaseActivity.this.config.renameCompressFileName).ignoreBy(PictureBaseActivity.this.config.minimumCompressSize).get();
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(List<File> list2) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                    if (list2 == null || list2.size() <= 0 || list2.size() != list.size()) {
                        PictureBaseActivity.this.onResult(list);
                    } else {
                        PictureBaseActivity.this.handleCompressCallBack(list, list2);
                    }
                }
            });
        } else {
            Luban.with(this).loadMediaData(list).ignoreBy(this.config.minimumCompressSize).isCamera(this.config.camera).setCompressQuality(this.config.compressQuality).setTargetDir(this.config.compressSavePath).setFocusAlpha(this.config.focusAlpha).setNewCompressFileName(this.config.renameCompressFileName).setCompressListener(new OnCompressListener() { // from class: com.luck.picture.lib.PictureBaseActivity.3
                @Override // com.luck.picture.lib.compress.OnCompressListener
                public void onError(Throwable th) {
                    PictureBaseActivity.this.onResult(list);
                }

                @Override // com.luck.picture.lib.compress.OnCompressListener
                public void onStart() {
                }

                @Override // com.luck.picture.lib.compress.OnCompressListener
                public void onSuccess(List<LocalMedia> list2) {
                    PictureBaseActivity.this.onResult(list2);
                }
            }).launch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCompressCallBack(List<LocalMedia> list, List<File> list2) {
        if (list == null || list2 == null) {
            closeActivity();
            return;
        }
        boolean checkedAndroid_Q = SdkVersionUtils.checkedAndroid_Q();
        int size = list.size();
        if (list2.size() == size) {
            for (int i2 = 0; i2 < size; i2++) {
                String absolutePath = list2.get(i2).getAbsolutePath();
                LocalMedia localMedia = list.get(i2);
                boolean z = !TextUtils.isEmpty(absolutePath) && PictureMimeType.isHttp(absolutePath);
                boolean eqVideo = PictureMimeType.eqVideo(localMedia.getMimeType());
                localMedia.setCompressed((eqVideo || z) ? false : true);
                localMedia.setCompressPath((eqVideo || z) ? "" : absolutePath);
                if (checkedAndroid_Q) {
                    if (eqVideo) {
                        absolutePath = null;
                    }
                    localMedia.setAndroidQToPath(absolutePath);
                }
            }
        }
        onResult(list);
    }

    private void initConfig() {
        List<LocalMedia> list = this.config.selectionMedias;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.selectionMedias = list;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        PictureParameterStyle pictureParameterStyle = pictureSelectionConfig.style;
        if (pictureParameterStyle != null) {
            this.openWhiteStatusBar = pictureParameterStyle.isChangeStatusBarFontColor;
            int i2 = pictureParameterStyle.pictureTitleBarBackgroundColor;
            if (i2 != 0) {
                this.colorPrimary = i2;
            }
            int i3 = this.config.style.pictureStatusBarColor;
            if (i3 != 0) {
                this.colorPrimaryDark = i3;
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.config;
            PictureParameterStyle pictureParameterStyle2 = pictureSelectionConfig2.style;
            this.numComplete = pictureParameterStyle2.isOpenCompletedNumStyle;
            pictureSelectionConfig2.checkNumMode = pictureParameterStyle2.isOpenCheckNumStyle;
        } else {
            this.openWhiteStatusBar = pictureSelectionConfig.isChangeStatusBarFontColor;
            if (!this.openWhiteStatusBar) {
                this.openWhiteStatusBar = AttrsUtils.getTypeValueBoolean(this, C2639R.attr.picture_statusFontColor);
            }
            this.numComplete = this.config.isOpenStyleNumComplete;
            if (!this.numComplete) {
                this.numComplete = AttrsUtils.getTypeValueBoolean(this, C2639R.attr.picture_style_numComplete);
            }
            PictureSelectionConfig pictureSelectionConfig3 = this.config;
            pictureSelectionConfig3.checkNumMode = pictureSelectionConfig3.isOpenStyleCheckNumMode;
            if (!pictureSelectionConfig3.checkNumMode) {
                pictureSelectionConfig3.checkNumMode = AttrsUtils.getTypeValueBoolean(this, C2639R.attr.picture_style_checkNumMode);
            }
            int i4 = this.config.titleBarBackgroundColor;
            if (i4 != 0) {
                this.colorPrimary = i4;
            } else {
                this.colorPrimary = AttrsUtils.getTypeValueColor(this, C2639R.attr.colorPrimary);
            }
            int i5 = this.config.pictureStatusBarColor;
            if (i5 != 0) {
                this.colorPrimaryDark = i5;
            } else {
                this.colorPrimaryDark = AttrsUtils.getTypeValueColor(this, C2639R.attr.colorPrimaryDark);
            }
        }
        if (this.config.openClickSound) {
            VoiceUtils.getInstance().init(getContext());
        }
    }

    private void isCheckConfigNull() {
        if (this.config == null) {
            this.config = PictureSelectionConfig.getInstance();
        }
    }

    private void onResultToAndroidAsy(final List<LocalMedia> list) {
        PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() { // from class: com.luck.picture.lib.PictureBaseActivity.6
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public List<LocalMedia> doInBackground() {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    LocalMedia localMedia = (LocalMedia) list.get(i2);
                    if (localMedia != null && !TextUtils.isEmpty(localMedia.getPath())) {
                        if (((localMedia.isCut() || localMedia.isCompressed() || !TextUtils.isEmpty(localMedia.getAndroidQToPath())) ? false : true) && PictureMimeType.isContent(localMedia.getPath())) {
                            localMedia.setAndroidQToPath(AndroidQTransformUtils.copyPathToAndroidQ(PictureBaseActivity.this.getContext(), localMedia.getPath(), localMedia.getWidth(), localMedia.getHeight(), localMedia.getMimeType(), PictureBaseActivity.this.config.cameraFileName));
                        } else if (localMedia.isCut() && localMedia.isCompressed()) {
                            localMedia.setAndroidQToPath(localMedia.getCompressPath());
                        }
                        if (PictureBaseActivity.this.config.isCheckOriginalImage) {
                            localMedia.setOriginal(true);
                            localMedia.setOriginalPath(localMedia.getAndroidQToPath());
                        }
                    }
                }
                return list;
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(List<LocalMedia> list2) {
                PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                PictureBaseActivity.this.dismissDialog();
                if (list2 != null) {
                    PictureBaseActivity pictureBaseActivity = PictureBaseActivity.this;
                    PictureSelectionConfig pictureSelectionConfig = pictureBaseActivity.config;
                    if (pictureSelectionConfig.camera && pictureSelectionConfig.selectionMode == 2 && pictureBaseActivity.selectionMedias != null) {
                        list2.addAll(list2.size() > 0 ? list2.size() - 1 : 0, PictureBaseActivity.this.selectionMedias);
                    }
                    OnResultCallbackListener onResultCallbackListener = PictureSelectionConfig.listener;
                    if (onResultCallbackListener != null) {
                        onResultCallbackListener.onResult(list2);
                    } else {
                        PictureBaseActivity.this.setResult(-1, PictureSelector.putIntentResult(list2));
                    }
                    PictureBaseActivity.this.closeActivity();
                }
            }
        });
    }

    private void releaseResultListener() {
        if (this.config != null) {
            PictureSelectionConfig.destroy();
            PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
            PictureThreadUtils.cancel(PictureThreadUtils.getSinglePool());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMultipleCropActivity(CutInfo cutInfo, UCrop.Options options) {
        String str;
        String path = cutInfo.getPath();
        String mimeType = cutInfo.getMimeType();
        Uri fromFile = !TextUtils.isEmpty(cutInfo.getAndroidQToPath()) ? Uri.fromFile(new File(cutInfo.getAndroidQToPath())) : (PictureMimeType.isHttp(path) || SdkVersionUtils.checkedAndroid_Q()) ? Uri.parse(path) : Uri.fromFile(new File(path));
        String replace = mimeType.replace("image/", ".");
        String diskCacheDir = PictureFileUtils.getDiskCacheDir(this);
        if (TextUtils.isEmpty(this.config.renameCropFileName)) {
            str = DateUtils.getCreateFileName("IMG_") + replace;
        } else {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            boolean z = pictureSelectionConfig.camera;
            str = pictureSelectionConfig.renameCropFileName;
            if (!z) {
                str = StringUtils.rename(str);
            }
        }
        UCrop withOptions = UCrop.m16371of(fromFile, Uri.fromFile(new File(diskCacheDir, str))).withOptions(options);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        withOptions.startAnimationMultipleCropActivity(this, pictureWindowAnimationStyle != null ? pictureWindowAnimationStyle.activityCropEnterAnimation : C2639R.anim.picture_anim_enter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSingleCropActivity(String str, String str2, String str3, UCrop.Options options) {
        String str4;
        boolean isHttp = PictureMimeType.isHttp(str);
        String replace = str3.replace("image/", ".");
        String diskCacheDir = PictureFileUtils.getDiskCacheDir(getContext());
        if (TextUtils.isEmpty(this.config.renameCropFileName)) {
            str4 = DateUtils.getCreateFileName("IMG_") + replace;
        } else {
            str4 = this.config.renameCropFileName;
        }
        UCrop withOptions = UCrop.m16371of(!TextUtils.isEmpty(str2) ? Uri.fromFile(new File(str2)) : (isHttp || SdkVersionUtils.checkedAndroid_Q()) ? Uri.parse(str) : Uri.fromFile(new File(str)), Uri.fromFile(new File(diskCacheDir, str4))).withOptions(options);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        withOptions.startAnimationActivity(this, pictureWindowAnimationStyle != null ? pictureWindowAnimationStyle.activityCropEnterAnimation : C2639R.anim.picture_anim_enter);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        this.config = PictureSelectionConfig.getInstance();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig != null) {
            super.attachBaseContext(PictureContextWrapper.wrap(context, pictureSelectionConfig.language));
        }
    }

    protected void closeActivity() {
        int i2;
        finish();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.camera) {
            overridePendingTransition(0, C2639R.anim.picture_anim_fade_out);
        } else {
            PictureWindowAnimationStyle pictureWindowAnimationStyle = pictureSelectionConfig.windowAnimationStyle;
            if (pictureWindowAnimationStyle == null || (i2 = pictureWindowAnimationStyle.activityExitAnimation) == 0) {
                i2 = C2639R.anim.picture_anim_exit;
            }
            overridePendingTransition(0, i2);
        }
        if (this.config.camera) {
            if ((getContext() instanceof PictureSelectorCameraEmptyActivity) || (getContext() instanceof PictureCustomCameraActivity)) {
                releaseResultListener();
                return;
            }
            return;
        }
        if (getContext() instanceof PictureSelectorActivity) {
            releaseResultListener();
            if (this.config.openClickSound) {
                VoiceUtils.getInstance().releaseSoundPool();
            }
        }
    }

    protected void compressImage(final List<LocalMedia> list) {
        showPleaseDialog();
        if (PictureSelectionConfig.cacheResourcesEngine != null) {
            PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() { // from class: com.luck.picture.lib.PictureBaseActivity.1
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public List<LocalMedia> doInBackground() {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        LocalMedia localMedia = (LocalMedia) list.get(i2);
                        if (localMedia != null) {
                            localMedia.setAndroidQToPath(PictureSelectionConfig.cacheResourcesEngine.onCachePath(PictureBaseActivity.this.getContext(), localMedia.getPath()));
                        }
                    }
                    return list;
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(List<LocalMedia> list2) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                    PictureBaseActivity.this.compressToLuban(list2);
                }
            });
        } else {
            compressToLuban(list);
        }
    }

    protected void createNewFolder(List<LocalMediaFolder> list) {
        if (list.size() == 0) {
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            localMediaFolder.setName(getString(this.config.chooseMode == PictureMimeType.ofAudio() ? C2639R.string.picture_all_audio : C2639R.string.picture_camera_roll));
            localMediaFolder.setFirstImagePath("");
            list.add(localMediaFolder);
        }
    }

    protected void dismissDialog() {
        if (isFinishing()) {
            return;
        }
        try {
            if (this.mLoadingDialog == null || !this.mLoadingDialog.isShowing()) {
                return;
            }
            this.mLoadingDialog.dismiss();
        } catch (Exception e2) {
            this.mLoadingDialog = null;
            e2.printStackTrace();
        }
    }

    protected String getAudioPath(Intent intent) {
        boolean z = Build.VERSION.SDK_INT <= 19;
        if (intent == null || this.config.chooseMode != PictureMimeType.ofAudio()) {
            return "";
        }
        try {
            Uri data = intent.getData();
            return data != null ? z ? data.getPath() : MediaUtils.getAudioFilePathFromUri(getContext(), data) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    protected Context getContext() {
        return this;
    }

    @Nullable
    protected LocalMediaFolder getImageFolder(String str, List<LocalMediaFolder> list) {
        File parentFile = new File(PictureMimeType.isContent(str) ? (String) Objects.requireNonNull(PictureFileUtils.getPath(getContext(), Uri.parse(str))) : str).getParentFile();
        for (LocalMediaFolder localMediaFolder : list) {
            if (parentFile != null && localMediaFolder.getName().equals(parentFile.getName())) {
                return localMediaFolder;
            }
        }
        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
        localMediaFolder2.setName(parentFile != null ? parentFile.getName() : "");
        localMediaFolder2.setFirstImagePath(str);
        list.add(localMediaFolder2);
        return localMediaFolder2;
    }

    public abstract int getResourceId();

    protected void handlerResult(List<LocalMedia> list) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.isCompress || pictureSelectionConfig.isCheckOriginalImage) {
            onResult(list);
        } else {
            compressImage(list);
        }
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, this.colorPrimaryDark, this.colorPrimary, this.openWhiteStatusBar);
    }

    protected void initCompleteText(int i2) {
    }

    protected void initCompleteText(List<LocalMedia> list) {
    }

    protected void initPictureSelectorStyle() {
    }

    protected void initWidgets() {
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return true;
    }

    public boolean isRequestedOrientation() {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i2;
        if (bundle != null) {
            this.config = (PictureSelectionConfig) bundle.getParcelable(PictureConfig.EXTRA_CONFIG);
        }
        isCheckConfigNull();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.camera) {
            setTheme(pictureSelectionConfig.themeStyleId);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        super.onCreate(bundle);
        if (isRequestedOrientation()) {
            setNewRequestedOrientation();
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        initConfig();
        if (isImmersive()) {
            immersive();
        }
        PictureParameterStyle pictureParameterStyle = this.config.style;
        if (pictureParameterStyle != null && (i2 = pictureParameterStyle.pictureNavBarColor) != 0) {
            NavBarUtils.setNavBarColor(this, i2);
        }
        int resourceId = getResourceId();
        if (resourceId != 0) {
            setContentView(resourceId);
        }
        initWidgets();
        initPictureSelectorStyle();
        this.isOnSaveInstanceState = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
        this.mLoadingDialog = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 3) {
            return;
        }
        if (iArr[0] != 0) {
            ToastUtils.m8140s(getContext(), getString(C2639R.string.picture_audio));
            return;
        }
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    protected void onResult(List<LocalMedia> list) {
        if (SdkVersionUtils.checkedAndroid_Q() && this.config.isAndroidQTransform) {
            showPleaseDialog();
            onResultToAndroidAsy(list);
            return;
        }
        dismissDialog();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.camera && pictureSelectionConfig.selectionMode == 2 && this.selectionMedias != null) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.selectionMedias);
        }
        if (this.config.isCheckOriginalImage) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                LocalMedia localMedia = list.get(i2);
                localMedia.setOriginal(true);
                localMedia.setOriginalPath(localMedia.getPath());
            }
        }
        OnResultCallbackListener onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onResult(list);
        } else {
            setResult(-1, PictureSelector.putIntentResult(list));
        }
        closeActivity();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@InterfaceC5816d Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.isOnSaveInstanceState = true;
        bundle.putParcelable(PictureConfig.EXTRA_CONFIG, this.config);
    }

    protected void setNewRequestedOrientation() {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null || pictureSelectionConfig.camera) {
            return;
        }
        setRequestedOrientation(pictureSelectionConfig.requestedOrientation);
    }

    protected void showPermissionsDialog(boolean z, String str) {
    }

    protected void showPleaseDialog() {
        if (isFinishing()) {
            return;
        }
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = new PictureLoadingDialog(getContext());
        }
        if (this.mLoadingDialog.isShowing()) {
            this.mLoadingDialog.dismiss();
        }
        this.mLoadingDialog.show();
    }

    protected void startCrop(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            ToastUtils.m8140s(this, getString(C2639R.string.picture_not_crop_data));
            return;
        }
        final UCrop.Options basicOptions = basicOptions();
        if (PictureSelectionConfig.cacheResourcesEngine != null) {
            PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<String>() { // from class: com.luck.picture.lib.PictureBaseActivity.4
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public String doInBackground() {
                    return PictureSelectionConfig.cacheResourcesEngine.onCachePath(PictureBaseActivity.this.getContext(), str);
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(String str3) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                    PictureBaseActivity.this.startSingleCropActivity(str, str3, str2, basicOptions);
                }
            });
        } else {
            startSingleCropActivity(str, null, str2, basicOptions);
        }
    }

    protected void startOpenCamera() {
        String str;
        Uri parUri;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                parUri = MediaUtils.createImageUri(getApplicationContext());
                if (parUri == null) {
                    ToastUtils.m8140s(getContext(), "open is camera error，the uri is empty ");
                    if (this.config.camera) {
                        closeActivity();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = parUri.toString();
            } else {
                int i2 = this.config.chooseMode;
                if (i2 == 0) {
                    i2 = 1;
                }
                if (TextUtils.isEmpty(this.config.cameraFileName)) {
                    str = "";
                } else {
                    boolean isSuffixOfImage = PictureMimeType.isSuffixOfImage(this.config.cameraFileName);
                    PictureSelectionConfig pictureSelectionConfig = this.config;
                    pictureSelectionConfig.cameraFileName = !isSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".jpg") : pictureSelectionConfig.cameraFileName;
                    PictureSelectionConfig pictureSelectionConfig2 = this.config;
                    boolean z = pictureSelectionConfig2.camera;
                    str = pictureSelectionConfig2.cameraFileName;
                    if (!z) {
                        str = StringUtils.rename(str);
                    }
                }
                Context applicationContext = getApplicationContext();
                PictureSelectionConfig pictureSelectionConfig3 = this.config;
                File createCameraFile = PictureFileUtils.createCameraFile(applicationContext, i2, str, pictureSelectionConfig3.suffixType, pictureSelectionConfig3.outPutCameraPath);
                if (createCameraFile == null) {
                    ToastUtils.m8140s(getContext(), "open is camera error，the uri is empty ");
                    if (this.config.camera) {
                        closeActivity();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = createCameraFile.getAbsolutePath();
                parUri = PictureFileUtils.parUri(this, createCameraFile);
            }
            this.config.cameraMimeType = PictureMimeType.ofImage();
            if (this.config.isCameraAroundState) {
                intent.putExtra(PictureConfig.CAMERA_FACING, 1);
            }
            intent.putExtra("output", parUri);
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    public void startOpenCameraAudio() {
        if (!PermissionChecker.checkSelfPermission(this, C7308a.f25530i)) {
            PermissionChecker.requestPermissions(this, new String[]{C7308a.f25530i}, 3);
            return;
        }
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        if (intent.resolveActivity(getPackageManager()) != null) {
            this.config.cameraMimeType = PictureMimeType.ofAudio();
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    protected void startOpenCameraVideo() {
        String str;
        Uri parUri;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                parUri = MediaUtils.createVideoUri(getApplicationContext());
                if (parUri == null) {
                    ToastUtils.m8140s(getContext(), "open is camera error，the uri is empty ");
                    if (this.config.camera) {
                        closeActivity();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = parUri.toString();
            } else {
                int i2 = this.config.chooseMode;
                if (i2 == 0) {
                    i2 = 2;
                }
                if (TextUtils.isEmpty(this.config.cameraFileName)) {
                    str = "";
                } else {
                    boolean isSuffixOfImage = PictureMimeType.isSuffixOfImage(this.config.cameraFileName);
                    PictureSelectionConfig pictureSelectionConfig = this.config;
                    pictureSelectionConfig.cameraFileName = isSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".mp4") : pictureSelectionConfig.cameraFileName;
                    PictureSelectionConfig pictureSelectionConfig2 = this.config;
                    boolean z = pictureSelectionConfig2.camera;
                    str = pictureSelectionConfig2.cameraFileName;
                    if (!z) {
                        str = StringUtils.rename(str);
                    }
                }
                Context applicationContext = getApplicationContext();
                PictureSelectionConfig pictureSelectionConfig3 = this.config;
                File createCameraFile = PictureFileUtils.createCameraFile(applicationContext, i2, str, pictureSelectionConfig3.suffixType, pictureSelectionConfig3.outPutCameraPath);
                if (createCameraFile == null) {
                    ToastUtils.m8140s(getContext(), "open is camera error，the uri is empty ");
                    if (this.config.camera) {
                        closeActivity();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = createCameraFile.getAbsolutePath();
                parUri = PictureFileUtils.parUri(this, createCameraFile);
            }
            this.config.cameraMimeType = PictureMimeType.ofVideo();
            intent.putExtra("output", parUri);
            if (this.config.isCameraAroundState) {
                intent.putExtra(PictureConfig.CAMERA_FACING, 1);
            }
            intent.putExtra("android.intent.extra.durationLimit", this.config.recordVideoSecond);
            intent.putExtra("android.intent.extra.videoQuality", this.config.videoQuality);
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    private UCrop.Options basicOptions(ArrayList<CutInfo> arrayList) {
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        PictureCropParameterStyle pictureCropParameterStyle = pictureSelectionConfig.cropStyle;
        if (pictureCropParameterStyle != null) {
            i2 = pictureCropParameterStyle.cropTitleBarBackgroundColor;
            if (i2 == 0) {
                i2 = 0;
            }
            i3 = this.config.cropStyle.cropStatusBarColorPrimaryDark;
            if (i3 == 0) {
                i3 = 0;
            }
            i4 = this.config.cropStyle.cropTitleColor;
            if (i4 == 0) {
                i4 = 0;
            }
            z = this.config.cropStyle.isChangeStatusBarFontColor;
        } else {
            i2 = pictureSelectionConfig.cropTitleBarBackgroundColor;
            if (i2 == 0) {
                i2 = AttrsUtils.getTypeValueColor(this, C2639R.attr.picture_crop_toolbar_bg);
            }
            i3 = this.config.cropStatusBarColorPrimaryDark;
            if (i3 == 0) {
                i3 = AttrsUtils.getTypeValueColor(this, C2639R.attr.picture_crop_status_color);
            }
            i4 = this.config.cropTitleColor;
            if (i4 == 0) {
                i4 = AttrsUtils.getTypeValueColor(this, C2639R.attr.picture_crop_title_color);
            }
            z = this.config.isChangeStatusBarFontColor;
            if (!z) {
                z = AttrsUtils.getTypeValueBoolean(this, C2639R.attr.picture_statusFontColor);
            }
        }
        UCrop.Options options = this.config.uCropOptions;
        if (options == null) {
            options = new UCrop.Options();
        }
        options.isOpenWhiteStatusBar(z);
        options.setToolbarColor(i2);
        options.setStatusBarColor(i3);
        options.setToolbarWidgetColor(i4);
        options.setCircleDimmedLayer(this.config.circleDimmedLayer);
        options.setDimmedLayerColor(this.config.circleDimmedColor);
        options.setDimmedLayerBorderColor(this.config.circleDimmedBorderColor);
        options.setCircleStrokeWidth(this.config.circleStrokeWidth);
        options.setShowCropFrame(this.config.showCropFrame);
        options.setDragFrameEnabled(this.config.isDragFrame);
        options.setShowCropGrid(this.config.showCropGrid);
        options.setScaleEnabled(this.config.scaleEnabled);
        options.setRotateEnabled(this.config.rotateEnabled);
        options.isMultipleSkipCrop(this.config.isMultipleSkipCrop);
        options.setHideBottomControls(this.config.hideBottomControls);
        options.setCompressionQuality(this.config.cropCompressQuality);
        options.setRenameCropFileName(this.config.renameCropFileName);
        options.isCamera(this.config.camera);
        options.setCutListData(arrayList);
        options.isWithVideoImage(this.config.isWithVideoImage);
        options.setFreeStyleCropEnabled(this.config.freeStyleCropEnabled);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        options.setCropExitAnimation(pictureWindowAnimationStyle != null ? pictureWindowAnimationStyle.activityCropExitAnimation : 0);
        PictureCropParameterStyle pictureCropParameterStyle2 = this.config.cropStyle;
        options.setNavBarColor(pictureCropParameterStyle2 != null ? pictureCropParameterStyle2.cropNavBarColor : 0);
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        options.withAspectRatio(pictureSelectionConfig2.aspect_ratio_x, pictureSelectionConfig2.aspect_ratio_y);
        options.isMultipleRecyclerAnimation(this.config.isMultipleRecyclerAnimation);
        PictureSelectionConfig pictureSelectionConfig3 = this.config;
        int i6 = pictureSelectionConfig3.cropWidth;
        if (i6 > 0 && (i5 = pictureSelectionConfig3.cropHeight) > 0) {
            options.withMaxResultSize(i6, i5);
        }
        return options;
    }

    protected void startCrop(final ArrayList<CutInfo> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            final UCrop.Options basicOptions = basicOptions(arrayList);
            final int size = arrayList.size();
            int i2 = 0;
            this.index = 0;
            if (this.config.chooseMode == PictureMimeType.ofAll() && this.config.isWithVideoImage) {
                if (PictureMimeType.eqVideo(size > 0 ? arrayList.get(this.index).getMimeType() : "")) {
                    while (true) {
                        if (i2 < size) {
                            CutInfo cutInfo = arrayList.get(i2);
                            if (cutInfo != null && PictureMimeType.eqImage(cutInfo.getMimeType())) {
                                this.index = i2;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (PictureSelectionConfig.cacheResourcesEngine != null) {
                PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<CutInfo>>() { // from class: com.luck.picture.lib.PictureBaseActivity.5
                    @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                    public List<CutInfo> doInBackground() {
                        for (int i3 = 0; i3 < size; i3++) {
                            CutInfo cutInfo2 = (CutInfo) arrayList.get(i3);
                            String onCachePath = PictureSelectionConfig.cacheResourcesEngine.onCachePath(PictureBaseActivity.this.getContext(), cutInfo2.getPath());
                            if (!TextUtils.isEmpty(onCachePath)) {
                                cutInfo2.setAndroidQToPath(onCachePath);
                            }
                        }
                        return arrayList;
                    }

                    @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                    public void onSuccess(List<CutInfo> list) {
                        PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                        if (PictureBaseActivity.this.index < size) {
                            PictureBaseActivity pictureBaseActivity = PictureBaseActivity.this;
                            pictureBaseActivity.startMultipleCropActivity(list.get(pictureBaseActivity.index), basicOptions);
                        }
                    }
                });
                return;
            }
            int i3 = this.index;
            if (i3 < size) {
                startMultipleCropActivity(arrayList.get(i3), basicOptions);
                return;
            }
            return;
        }
        ToastUtils.m8140s(this, getString(C2639R.string.picture_not_crop_data));
    }
}
