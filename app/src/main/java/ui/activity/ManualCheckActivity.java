package ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.List;
import manager.AccountManager;
import manager.LoginManager;
import network.account.APIresult;
import ui.callview.ManualCheckView;
import ui.presenter.ManualCheckPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class ManualCheckActivity extends BaseActivity implements ManualCheckView {
    private int coveType;
    boolean isIDCard;

    @BindView(R.id.confirm)
    TextView mIvConfirm;

    @BindView(R.id.iv_upload_pic_f)
    ImageView mIvUploadPicF;

    @BindView(R.id.iv_upload_pic_z)
    ImageView mIvUploadPicZ;
    private LocalMedia mLocalMedia1;
    private LocalMedia mLocalMedia2;
    private ManualCheckPresenter mPresenter;

    @BindView(R.id.tv_tips)
    TextView mTvTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private String savePath_f;
    private String savePath_z;
    private String strIDNumber;
    private String strName;
    private String strPhone;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(ManualCheckActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            k.e.a(ManualCheckActivity.this.mActivity, 200L, PictureMimeType.ofImage(), 1).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    class b implements IOneClickListener {
        b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.v0, null));
            ManualCheckActivity.this.finish();
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a());
    }

    public static void deleteSaveBitmap(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private void displayImge(LocalMedia localMedia, ImageView imageView, String str) {
        Bitmap bitmapA = util.c1.a(BitmapFactory.decodeResource(getResources(), R.drawable.iv_water_img), localMedia.getPath(), str);
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        int i2 = this.coveType;
        if (i2 == 1) {
            this.savePath_z = str;
            ManualCheckPresenter manualCheckPresenter = this.mPresenter;
            if (manualCheckPresenter != null) {
                manualCheckPresenter.clearFront();
                return;
            }
            return;
        }
        if (i2 == 2) {
            this.savePath_f = str;
            ManualCheckPresenter manualCheckPresenter2 = this.mPresenter;
            if (manualCheckPresenter2 != null) {
                manualCheckPresenter2.clearBack();
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("");
        this.strName = getIntent().getStringExtra(util.p1.b0);
        this.strPhone = getIntent().getStringExtra(util.p1.e0);
        this.strIDNumber = getIntent().getStringExtra(util.p1.d0);
        this.isIDCard = getIntent().getBooleanExtra(util.p1.f15012d, false);
        this.mPresenter = new ManualCheckPresenter(this.mActivity, this, this.strName, this.strIDNumber, this.strPhone, this.isIDCard);
        this.mTvTips.setText("\u8bf7\u4e0a\u4f20\u201c" + g2.j(this.strName) + "\u201d\u672c\u4eba\u7684\u624b\u6301\u8bc1\u4ef6\u53f7\u7167\u7247");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        List listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            g2.a(this.mActivity, (List<LocalMedia>) listObtainMultipleResult);
        }
        if (this.coveType == 1 && listObtainMultipleResult.size() > 0) {
            this.mLocalMedia1 = (LocalMedia) listObtainMultipleResult.get(0);
            displayImge(this.mLocalMedia1, this.mIvUploadPicZ, e.d.f10176l + e.d.f10178n);
            return;
        }
        if (this.coveType != 2 || listObtainMultipleResult.size() <= 0) {
            return;
        }
        this.mLocalMedia2 = (LocalMedia) listObtainMultipleResult.get(0);
        displayImge(this.mLocalMedia2, this.mIvUploadPicF, e.d.f10176l + e.d.o);
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        deleteSaveBitmap(this.savePath_z);
        deleteSaveBitmap(this.savePath_f);
    }

    @Override // ui.callview.ManualCheckView
    public void onSubmitSuccessRequest(APIresult aPIresult) {
        hideProgressDialog();
        org.greenrobot.eventbus.c.f().d(new util.n2.a(200, null));
        e2.a("\u63d0\u4ea4\u6210\u529f");
        util.f1.b(this.mActivity, "\u8bf7\u81f3\u6240\u5728\u8f96\u533a\u6d3e\u51fa\u6240\u8054\u7cfb\u6c11\u8b66\u8fdb\u884c\u5ba1\u6838", "\u77e5\u9053\u4e86", new b());
    }

    @OnClick({R.id.iv_back, R.id.fl_upload_pic_z, R.id.iv_upload_pic_z, R.id.fl_upload_pic_f, R.id.iv_upload_pic_f, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        if (!AccountManager.isLogin()) {
            LoginManager.getInstance().exitToLogin();
            return;
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296501 */:
                if (TextUtils.isEmpty(this.savePath_z) || TextUtils.isEmpty(this.savePath_f)) {
                    e2.a("\u8bf7\u6dfb\u52a0\u8bc1\u4ef6\u53f7\u7167\u7247");
                } else {
                    showProgressDialog("\u4e0a\u4f20\u4e2d...");
                    this.mPresenter.uploadPic(this.savePath_z, this.savePath_f);
                }
                break;
            case R.id.fl_upload_pic_f /* 2131296685 */:
            case R.id.iv_upload_pic_f /* 2131296903 */:
                this.coveType = 2;
                checkPermission();
                break;
            case R.id.fl_upload_pic_z /* 2131296686 */:
            case R.id.iv_upload_pic_z /* 2131296904 */:
                this.coveType = 1;
                checkPermission();
                break;
            case R.id.iv_back /* 2131296808 */:
                a();
                break;
        }
    }

    @Override // ui.callview.ManualCheckView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_manual_upload;
    }
}
