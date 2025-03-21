package p388ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.IFaceLiveCallBack;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import p245d.C4443d;
import p388ui.Hicore;
import p388ui.callview.BeforVerifyCallview;
import p388ui.presenter.BeforVerifyPresenter;
import p388ui.presenter.YCLicencePresenter;
import util.C7257b1;
import util.C7277f1;
import util.C7286i1;
import util.C7292k1;
import util.C7331w1;
import util.C7333x0;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class BeforIdVerifyActivity extends BaseActivity implements BeforVerifyCallview {

    @BindView(C2113R.id.et_ID)
    EditText mEtID;

    @BindView(C2113R.id.et_name)
    EditText mEtName;
    private IFaceLiveCallBack mFaceCallBack = null;
    private YCLicencePresenter mFacePresenter;
    private String mInvitedMobile;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;
    private BeforVerifyPresenter mPresenter;

    @BindView(C2113R.id.btn_start)
    Button mStart;
    private String mStrIDNumber;
    private String mStrName;

    /* renamed from: ui.activity.BeforIdVerifyActivity$a */
    class C6149a implements PermissionsListener {
        C6149a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            BeforIdVerifyActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                BeforIdVerifyActivity.this.intentFace();
            } else if (C7310c.m26526f()) {
                BeforIdVerifyActivity.this.intentFace();
            } else {
                BeforIdVerifyActivity.this.camerPrimssDlg(false);
            }
        }
    }

    /* renamed from: ui.activity.BeforIdVerifyActivity$b */
    class C6150b implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f21884a;

        C6150b(boolean z) {
            this.f21884a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f21884a) {
                C7292k1.m26406j(BeforIdVerifyActivity.this.mActivity);
            } else {
                BeforIdVerifyActivity.this.varCamerPrims();
            }
        }
    }

    /* renamed from: ui.activity.BeforIdVerifyActivity$c */
    class C6151c implements IFaceLiveCallBack {
        C6151c() {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessFail(int i2) {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessSuccess(byte[] bArr) {
            BeforIdVerifyActivity.this.pctureTaken(bArr);
        }
    }

    /* renamed from: ui.activity.BeforIdVerifyActivity$d */
    class RunnableC6152d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21887a;

        RunnableC6152d(String str) {
            this.f21887a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            BeforIdVerifyActivity.this.confirm(this.f21887a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        C7257b1.m26230f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new C6150b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm(String str) {
        if (TextUtils.isEmpty(str)) {
            C7331w1.m26688a("请重拍");
            return;
        }
        if (TextUtils.isEmpty(this.mStrName) || TextUtils.isEmpty(this.mStrIDNumber)) {
            C7331w1.m26688a("请重新填入个人信息");
            finish();
        } else {
            C7257b1.m26203a("人脸识别中，请耐心等待...", false, this.mActivity);
            this.mPresenter.createInvited(this.mInvitedMobile, this.mStrName, this.mStrIDNumber, str);
        }
    }

    private void getIntentData() {
        this.mInvitedMobile = getIntent().getStringExtra(C7292k1.f25398e0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        if (this.mFaceCallBack == null) {
            this.mFaceCallBack = new C6151c();
        }
        this.mFacePresenter.startLiveFace(this.mFaceCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pctureTaken(byte[] bArr) {
        Bitmap m26338a = bArr != null ? C7277f1.m26338a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
        if (m26338a != null) {
            ByteArrayOutputStream m26342a = C7277f1.m26342a(m26338a, C4443d.f16919C);
            String m26700a = C7333x0.m26700a(m26342a);
            try {
                m26342a.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            runOnUiThread(new RunnableC6152d(m26700a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z, C7308a.f25524c}, new C6149a());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mPresenter = new BeforVerifyPresenter(this.mActivity, this);
        this.mFacePresenter = new YCLicencePresenter(this.mActivity);
        getIntentData();
    }

    @Override // p388ui.callview.BeforVerifyCallview
    public void onFailCreate() {
        startActivity(new Intent(this.mActivity, (Class<?>) IDVarfyFaceActivity.class));
    }

    @Override // p388ui.callview.BeforVerifyCallview
    public void onSuccessCreate() {
        C7331w1.m26688a("核实请求发送成功");
        setResult(-1);
        this.mActivity.finish();
    }

    @Override // p388ui.callview.BeforVerifyCallview
    public void onSuccessID() {
        varCamerPrims();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_start})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_start) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        Editable text = this.mEtName.getText();
        this.mStrName = TextUtils.isEmpty(text) ? "" : text.toString();
        Editable text2 = this.mEtID.getText();
        this.mStrIDNumber = TextUtils.isEmpty(text2) ? "" : text2.toString();
        if (this.mStrName.length() < 2 || this.mStrName.length() > 20 || !C7337y1.m26799x(this.mStrName)) {
            C7331w1.m26688a("姓名格式不正确，请重新输入");
        } else if (C7286i1.m26382b(this.mStrIDNumber)) {
            this.mPresenter.checkID(this.mStrIDNumber);
        } else {
            C7331w1.m26688a("请填写正确的身份证号");
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_befor_id_verify;
    }
}
