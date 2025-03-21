package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
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
import org.greenrobot.eventbus.C6049c;
import p245d.C4443d;
import p357j.C5846e;
import p388ui.callview.ManualCheckView;
import p388ui.presenter.ManualCheckPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.C7336y0;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class ManualCheckActivity extends BaseActivity implements ManualCheckView {
    private int coveType;
    boolean isIDCard;

    @BindView(C2113R.id.confirm)
    TextView mIvConfirm;

    @BindView(C2113R.id.iv_upload_pic_f)
    ImageView mIvUploadPicF;

    @BindView(C2113R.id.iv_upload_pic_z)
    ImageView mIvUploadPicZ;
    private LocalMedia mLocalMedia1;
    private LocalMedia mLocalMedia2;
    private ManualCheckPresenter mPresenter;

    @BindView(C2113R.id.tv_tips)
    TextView mTvTips;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private String savePath_f;
    private String savePath_z;
    private String strIDNumber;
    private String strName;
    private String strPhone;

    /* renamed from: ui.activity.ManualCheckActivity$a */
    class C6372a implements PermissionsListener {
        C6372a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(ManualCheckActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(ManualCheckActivity.this.mActivity, 200L, PictureMimeType.ofImage(), 1).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    /* renamed from: ui.activity.ManualCheckActivity$b */
    class C6373b implements IOneClickListener {
        C6373b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            C6049c.m24987f().m25000d(new C7265a(C7265a.f25267v0, null));
            ManualCheckActivity.this.finish();
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6372a());
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
        Bitmap m26711a = C7336y0.m26711a(BitmapFactory.decodeResource(getResources(), C2113R.drawable.iv_water_img), localMedia.getPath(), str);
        if (m26711a != null) {
            imageView.setImageBitmap(m26711a);
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

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("");
        this.strName = getIntent().getStringExtra(C7292k1.f25389b0);
        this.strPhone = getIntent().getStringExtra(C7292k1.f25398e0);
        this.strIDNumber = getIntent().getStringExtra(C7292k1.f25395d0);
        this.isIDCard = getIntent().getBooleanExtra(C7292k1.f25394d, false);
        this.mPresenter = new ManualCheckPresenter(this.mActivity, this, this.strName, this.strIDNumber, this.strPhone, this.isIDCard);
        this.mTvTips.setText("请上传“" + C7337y1.m26785j(this.strName) + "”本人的手持证件号照片");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        List obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            C7337y1.m26751a(this.mActivity, (List<LocalMedia>) obtainMultipleResult);
        }
        if (this.coveType == 1 && obtainMultipleResult.size() > 0) {
            this.mLocalMedia1 = (LocalMedia) obtainMultipleResult.get(0);
            displayImge(this.mLocalMedia1, this.mIvUploadPicZ, C4443d.f16965l + C4443d.f16967n);
            return;
        }
        if (this.coveType != 2 || obtainMultipleResult.size() <= 0) {
            return;
        }
        this.mLocalMedia2 = (LocalMedia) obtainMultipleResult.get(0);
        displayImge(this.mLocalMedia2, this.mIvUploadPicF, C4443d.f16965l + C4443d.f16968o);
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        deleteSaveBitmap(this.savePath_z);
        deleteSaveBitmap(this.savePath_f);
    }

    @Override // p388ui.callview.ManualCheckView
    public void onSubmitSuccessRequest(APIresult aPIresult) {
        hideProgressDialog();
        C6049c.m24987f().m25000d(new C7265a(200, null));
        C7331w1.m26688a("提交成功");
        C7257b1.m26210b(this.mActivity, "请至所在辖区派出所联系民警进行审核", "知道了", new C6373b());
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.fl_upload_pic_z, C2113R.id.iv_upload_pic_z, C2113R.id.fl_upload_pic_f, C2113R.id.iv_upload_pic_f, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        if (!AccountManager.isLogin()) {
            LoginManager.getInstance().exitToLogin();
            return;
        }
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                if (!TextUtils.isEmpty(this.savePath_z) && !TextUtils.isEmpty(this.savePath_f)) {
                    showProgressDialog("上传中...");
                    this.mPresenter.uploadPic(this.savePath_z, this.savePath_f);
                    break;
                } else {
                    C7331w1.m26688a("请添加证件号照片");
                    break;
                }
                break;
            case C2113R.id.fl_upload_pic_f /* 2131296649 */:
            case C2113R.id.iv_upload_pic_f /* 2131296855 */:
                this.coveType = 2;
                checkPermission();
                break;
            case C2113R.id.fl_upload_pic_z /* 2131296650 */:
            case C2113R.id.iv_upload_pic_z /* 2131296856 */:
                this.coveType = 1;
                checkPermission();
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
        }
    }

    @Override // p388ui.callview.ManualCheckView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_manual_upload;
    }
}
