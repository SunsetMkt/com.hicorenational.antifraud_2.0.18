package p388ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import bean.AccountListBean;
import bean.CaseDetailBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.IFaceLiveCallBack;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p245d.C4443d;
import p388ui.Hicore;
import p388ui.callview.CaseHistoryCallView;
import p388ui.callview.CaseVerifyCallview;
import p388ui.presenter.CaseHistoryPresenter;
import p388ui.presenter.CaseVerifyPresenter;
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
public class CaseVerifyActivity extends BaseActivity implements CaseVerifyCallview {

    @BindView(C2113R.id.et_ID)
    EditText mEtID;

    @BindView(C2113R.id.et_name)
    EditText mEtName;
    private YCLicencePresenter mFacePresenter;
    private CaseVerifyPresenter mPresenter;
    private String mStrIDNumber;
    private String mStrName;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private IFaceLiveCallBack mFaceCallBack = null;
    private String mCaseInfoId = "";
    private ArrayList<AccountListBean> mAccountList = null;

    /* renamed from: ui.activity.CaseVerifyActivity$a */
    class C6207a implements PermissionsListener {
        C6207a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            CaseVerifyActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                CaseVerifyActivity.this.intentFace();
            } else if (C7310c.m26526f()) {
                CaseVerifyActivity.this.intentFace();
            } else {
                CaseVerifyActivity.this.camerPrimssDlg(false);
            }
        }
    }

    /* renamed from: ui.activity.CaseVerifyActivity$b */
    class C6208b implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f22070a;

        C6208b(boolean z) {
            this.f22070a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f22070a) {
                C7292k1.m26406j(CaseVerifyActivity.this.mActivity);
            } else {
                CaseVerifyActivity.this.varCamerPrims();
            }
        }
    }

    /* renamed from: ui.activity.CaseVerifyActivity$c */
    class C6209c implements IFaceLiveCallBack {
        C6209c() {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessFail(int i2) {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessSuccess(byte[] bArr) {
            CaseVerifyActivity.this.pctureTaken(bArr);
        }
    }

    /* renamed from: ui.activity.CaseVerifyActivity$d */
    class RunnableC6210d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f22073a;

        RunnableC6210d(String str) {
            this.f22073a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            CaseVerifyActivity.this.confirm(this.f22073a);
        }
    }

    /* renamed from: ui.activity.CaseVerifyActivity$e */
    class C6211e implements CaseHistoryCallView {
        C6211e() {
        }

        @Override // p388ui.callview.CaseHistoryCallView
        public void onSuccessBack() {
        }

        @Override // p388ui.callview.CaseHistoryCallView
        public void onSuccessCommit() {
            CaseVerifyActivity.this.setResult(-1);
            CaseVerifyActivity.this.mActivity.finish();
        }

        @Override // p388ui.callview.CaseHistoryCallView
        public void onSuccessDetail(CaseDetailBean caseDetailBean) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        C7257b1.m26230f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new C6208b(z));
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
            this.mPresenter.createInvited(this.mStrName, this.mStrIDNumber, str);
        }
    }

    private void getIntentData() {
        this.mCaseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        this.mAccountList = (ArrayList) getIntent().getSerializableExtra(C7292k1.f25391c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        if (this.mFaceCallBack == null) {
            this.mFaceCallBack = new C6209c();
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
            runOnUiThread(new RunnableC6210d(m26700a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25521A, C7308a.f25547z, C7308a.f25524c}, new C6207a());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("安全认证");
        this.mPresenter = new CaseVerifyPresenter(this.mActivity, this);
        this.mFacePresenter = new YCLicencePresenter(this.mActivity);
    }

    @Override // p388ui.callview.CaseVerifyCallview
    public void onFail() {
        startActivity(new Intent(this.mActivity, (Class<?>) IDVarfyFaceActivity.class));
    }

    @Override // p388ui.callview.CaseVerifyCallview
    public void onSuccess() {
        getIntentData();
        new CaseHistoryPresenter(this.mActivity, new C6211e()).submitCase(this.mCaseInfoId, this.mAccountList);
    }

    @Override // p388ui.callview.CaseVerifyCallview
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
        return C2113R.layout.activity_case_verify;
    }
}
