package com.luck.picture.lib;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraX;
import androidx.camera.view.CameraView;
import androidx.lifecycle.LifecycleOwner;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.camera.listener.CameraListener;
import com.luck.picture.lib.camera.listener.ClickListener;
import com.luck.picture.lib.camera.listener.ImageCallbackListener;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.tools.ToastUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import util.permissionutil.C7308a;

/* loaded from: classes.dex */
public class PictureCustomCameraActivity extends PictureSelectorCameraEmptyActivity {
    protected boolean isEnterSetting;
    private CustomCameraView mCameraView;

    private void createCameraView() {
        if (this.mCameraView == null) {
            this.mCameraView = new CustomCameraView(getContext());
            setContentView(this.mCameraView);
            initView();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8094a(File file, ImageView imageView) {
        ImageEngine imageEngine;
        if (this.config == null || (imageEngine = PictureSelectionConfig.imageEngine) == null || file == null) {
            return;
        }
        imageEngine.loadImage(getContext(), file.getAbsolutePath(), imageView);
    }

    /* renamed from: b */
    public /* synthetic */ void m8095b(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        PermissionChecker.launchAppDetailsSettings(getContext());
        this.isEnterSetting = true;
    }

    protected void initView() {
        this.mCameraView.setPictureSelectionConfig(this.config);
        this.mCameraView.setBindToLifecycle((LifecycleOwner) new WeakReference(this).get());
        int i2 = this.config.recordVideoSecond;
        if (i2 > 0) {
            this.mCameraView.setRecordVideoMaxTime(i2);
        }
        int i3 = this.config.recordVideoMinSecond;
        if (i3 > 0) {
            this.mCameraView.setRecordVideoMinTime(i3);
        }
        CameraView cameraView = this.mCameraView.getCameraView();
        if (cameraView != null && this.config.isCameraAroundState) {
            cameraView.toggleCamera();
        }
        CaptureLayout captureLayout = this.mCameraView.getCaptureLayout();
        if (captureLayout != null) {
            captureLayout.setButtonFeatures(this.config.buttonFeatures);
        }
        this.mCameraView.setImageCallbackListener(new ImageCallbackListener() { // from class: com.luck.picture.lib.b
            @Override // com.luck.picture.lib.camera.listener.ImageCallbackListener
            public final void onLoadImage(File file, ImageView imageView) {
                PictureCustomCameraActivity.this.m8094a(file, imageView);
            }
        });
        this.mCameraView.setCameraListener(new CameraListener() { // from class: com.luck.picture.lib.PictureCustomCameraActivity.1
            @Override // com.luck.picture.lib.camera.listener.CameraListener
            public void onError(int i4, @NonNull String str, @Nullable Throwable th) {
                ToastUtils.m8140s(PictureCustomCameraActivity.this.getContext(), str);
                PictureCustomCameraActivity.this.m8092a();
            }

            @Override // com.luck.picture.lib.camera.listener.CameraListener
            public void onPictureSuccess(@NonNull File file) {
                PictureCustomCameraActivity.this.config.cameraMimeType = PictureMimeType.ofImage();
                Intent intent = new Intent();
                intent.putExtra(PictureConfig.EXTRA_MEDIA_PATH, file.getAbsolutePath());
                PictureCustomCameraActivity pictureCustomCameraActivity = PictureCustomCameraActivity.this;
                if (pictureCustomCameraActivity.config.camera) {
                    pictureCustomCameraActivity.requestCamera(intent);
                } else {
                    pictureCustomCameraActivity.setResult(-1, intent);
                    PictureCustomCameraActivity.this.m8092a();
                }
            }

            @Override // com.luck.picture.lib.camera.listener.CameraListener
            public void onRecordSuccess(@NonNull File file) {
                PictureCustomCameraActivity.this.config.cameraMimeType = PictureMimeType.ofVideo();
                Intent intent = new Intent();
                intent.putExtra(PictureConfig.EXTRA_MEDIA_PATH, file.getAbsolutePath());
                PictureCustomCameraActivity pictureCustomCameraActivity = PictureCustomCameraActivity.this;
                if (pictureCustomCameraActivity.config.camera) {
                    pictureCustomCameraActivity.requestCamera(intent);
                } else {
                    pictureCustomCameraActivity.setResult(-1, intent);
                    PictureCustomCameraActivity.this.m8092a();
                }
            }
        });
        this.mCameraView.setOnClickListener(new ClickListener() { // from class: com.luck.picture.lib.c
            @Override // com.luck.picture.lib.camera.listener.ClickListener
            public final void onClick() {
                PictureCustomCameraActivity.this.m8092a();
            }
        });
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, android.app.Activity
    public boolean isImmersive() {
        return false;
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed, reason: merged with bridge method [inline-methods] */
    public void m8092a() {
        OnResultCallbackListener onResultCallbackListener;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig != null && pictureSelectionConfig.camera && (onResultCallbackListener = PictureSelectionConfig.listener) != null) {
            onResultCallbackListener.onCancel();
        }
        closeActivity();
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(AbstractC1191a.f2487B1, AbstractC1191a.f2487B1);
        getWindow().setFlags(AbstractC1191a.f2490C1, AbstractC1191a.f2490C1);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        getWindow().addFlags(128);
        super.onCreate(bundle);
        if (!(PermissionChecker.checkSelfPermission(this, C7308a.f25547z) && PermissionChecker.checkSelfPermission(this, C7308a.f25521A))) {
            PermissionChecker.requestPermissions(this, new String[]{C7308a.f25547z, C7308a.f25521A}, 1);
            return;
        }
        if (!PermissionChecker.checkSelfPermission(this, C7308a.f25524c)) {
            PermissionChecker.requestPermissions(this, new String[]{C7308a.f25524c}, 2);
        } else if (PermissionChecker.checkSelfPermission(this, C7308a.f25530i)) {
            createCameraView();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{C7308a.f25530i}, 4);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onDestroy() {
        if (this.mCameraView != null) {
            CameraX.unbindAll();
            this.mCameraView = null;
        }
        super.onDestroy();
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(true, getString(C2639R.string.picture_jurisdiction));
                return;
            } else {
                PermissionChecker.requestPermissions(this, new String[]{C7308a.f25524c}, 2);
                return;
            }
        }
        if (i2 != 2) {
            if (i2 != 4) {
                return;
            }
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(false, getString(C2639R.string.picture_audio));
                return;
            } else {
                createCameraView();
                return;
            }
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            showPermissionsDialog(true, getString(C2639R.string.picture_camera));
        } else if (PermissionChecker.checkSelfPermission(this, C7308a.f25530i)) {
            createCameraView();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{C7308a.f25530i}, 4);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.isEnterSetting) {
            if (!(PermissionChecker.checkSelfPermission(this, C7308a.f25547z) && PermissionChecker.checkSelfPermission(this, C7308a.f25521A))) {
                showPermissionsDialog(false, getString(C2639R.string.picture_jurisdiction));
            } else if (!PermissionChecker.checkSelfPermission(this, C7308a.f25524c)) {
                showPermissionsDialog(false, getString(C2639R.string.picture_camera));
            } else if (PermissionChecker.checkSelfPermission(this, C7308a.f25530i)) {
                createCameraView();
            } else {
                showPermissionsDialog(false, getString(C2639R.string.picture_audio));
            }
            this.isEnterSetting = false;
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void showPermissionsDialog(boolean z, String str) {
        if (isFinishing()) {
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), C2639R.layout.picture_wind_base_dialog);
        pictureCustomDialog.setCancelable(false);
        pictureCustomDialog.setCanceledOnTouchOutside(false);
        Button button = (Button) pictureCustomDialog.findViewById(C2639R.id.btn_cancel);
        Button button2 = (Button) pictureCustomDialog.findViewById(C2639R.id.btn_commit);
        button2.setText(getString(C2639R.string.picture_go_setting));
        TextView textView = (TextView) pictureCustomDialog.findViewById(C2639R.id.tv_title);
        TextView textView2 = (TextView) pictureCustomDialog.findViewById(C2639R.id.tv_content);
        textView.setText(getString(C2639R.string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureCustomCameraActivity.this.m8093a(pictureCustomDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureCustomCameraActivity.this.m8095b(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }

    /* renamed from: a */
    public /* synthetic */ void m8093a(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        closeActivity();
    }
}
