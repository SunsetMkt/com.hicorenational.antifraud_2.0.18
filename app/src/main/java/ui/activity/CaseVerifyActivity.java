package ui.activity;

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
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IFaceLiveCallBack;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import ui.callview.CaseHistoryCallView;
import ui.callview.CaseVerifyCallview;
import ui.presenter.CaseHistoryPresenter;
import ui.presenter.CaseVerifyPresenter;
import ui.presenter.YCLicencePresenter;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class CaseVerifyActivity extends BaseActivity implements CaseVerifyCallview {

    @BindView(R.id.et_ID)
    EditText mEtID;

    @BindView(R.id.et_name)
    EditText mEtName;
    private YCLicencePresenter mFacePresenter;
    private CaseVerifyPresenter mPresenter;
    private String mStrIDNumber;
    private String mStrName;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private IFaceLiveCallBack mFaceCallBack = null;
    private String mCaseInfoId = "";
    private ArrayList<AccountListBean> mAccountList = null;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            CaseVerifyActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                CaseVerifyActivity.this.intentFace();
            } else if (util.permissionutil.c.f()) {
                CaseVerifyActivity.this.intentFace();
            } else {
                CaseVerifyActivity.this.camerPrimssDlg(false);
            }
        }
    }

    class b implements IClickListener {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.a) {
                util.p1.j(CaseVerifyActivity.this.mActivity);
            } else {
                CaseVerifyActivity.this.varCamerPrims();
            }
        }
    }

    class c implements IFaceLiveCallBack {
        c() {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessFail(int i2) {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessSuccess(byte[] bArr) {
            CaseVerifyActivity.this.pctureTaken(bArr);
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            CaseVerifyActivity.this.confirm(this.a);
        }
    }

    class e implements CaseHistoryCallView {
        e() {
        }

        @Override // ui.callview.CaseHistoryCallView
        public void onSuccessBack() {
        }

        @Override // ui.callview.CaseHistoryCallView
        public void onSuccessCommit() {
            CaseVerifyActivity.this.setResult(-1);
            CaseVerifyActivity.this.mActivity.finish();
        }

        @Override // ui.callview.CaseHistoryCallView
        public void onSuccessDetail(CaseDetailBean caseDetailBean) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        util.f1.f(this.mActivity, "\u6743\u9650\u5f00\u542f", "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3\u672a\u53d6\u5f97\u6743\u9650\uff0c\u8fd9\u6837\u4f1a\u5bfc\u81f4\u6b64\u529f\u80fd\u65e0\u6cd5\u4f7f\u7528\u3002", "\u53d6\u6d88", "\u53bb\u6388\u6743", new b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm(String str) {
        if (TextUtils.isEmpty(str)) {
            e2.a("\u8bf7\u91cd\u62cd");
            return;
        }
        if (TextUtils.isEmpty(this.mStrName) || TextUtils.isEmpty(this.mStrIDNumber)) {
            e2.a("\u8bf7\u91cd\u65b0\u586b\u5165\u4e2a\u4eba\u4fe1\u606f");
            finish();
        } else {
            util.f1.a("\u4eba\u8138\u8bc6\u522b\u4e2d\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", false, this.mActivity);
            this.mPresenter.createInvited(this.mStrName, this.mStrIDNumber, str);
        }
    }

    private void getIntentData() {
        this.mCaseInfoId = getIntent().getStringExtra(util.p1.C0);
        this.mAccountList = (ArrayList) getIntent().getSerializableExtra(util.p1.f15011c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        if (this.mFaceCallBack == null) {
            this.mFaceCallBack = new c();
        }
        this.mFacePresenter.startLiveFace(this.mFaceCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pctureTaken(byte[] bArr) {
        Bitmap bitmapA = bArr != null ? util.j1.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
        if (bitmapA != null) {
            ByteArrayOutputStream byteArrayOutputStreamA = util.j1.a(bitmapA, e.d.E);
            String strA = util.b1.a(byteArrayOutputStreamA);
            try {
                byteArrayOutputStreamA.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            runOnUiThread(new d(strA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f15026c}, new a());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("\u5b89\u5168\u8ba4\u8bc1");
        this.mPresenter = new CaseVerifyPresenter(this.mActivity, this);
        this.mFacePresenter = new YCLicencePresenter(this.mActivity);
    }

    @Override // ui.callview.CaseVerifyCallview
    public void onFail() {
        startActivity(new Intent(this.mActivity, (Class<?>) IDVarfyFaceActivity.class));
    }

    @Override // ui.callview.CaseVerifyCallview
    public void onSuccess() {
        getIntentData();
        new CaseHistoryPresenter(this.mActivity, new e()).submitCase(this.mCaseInfoId, this.mAccountList);
    }

    @Override // ui.callview.CaseVerifyCallview
    public void onSuccessID() {
        varCamerPrims();
    }

    @OnClick({R.id.iv_back, R.id.btn_start})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_start) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        Editable text = this.mEtName.getText();
        this.mStrName = TextUtils.isEmpty(text) ? "" : text.toString();
        Editable text2 = this.mEtID.getText();
        this.mStrIDNumber = TextUtils.isEmpty(text2) ? "" : text2.toString();
        if (this.mStrName.length() < 2 || this.mStrName.length() > 20 || !g2.x(this.mStrName)) {
            e2.a("\u59d3\u540d\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
        } else if (util.m1.b(this.mStrIDNumber)) {
            this.mPresenter.checkID(this.mStrIDNumber);
        } else {
            e2.a("\u8bf7\u586b\u5199\u6b63\u786e\u7684\u8eab\u4efd\u8bc1\u53f7");
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_case_verify;
    }
}
