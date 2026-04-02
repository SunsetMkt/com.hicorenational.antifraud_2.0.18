package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IOneClickListener;
import manager.LoginManager;
import ui.callview.ForgetPwdCallView;
import ui.presenter.ForgetPresenter;
import ui.view.CodeCutTimeTextView;
import ui.view.VerifyCodeView;
import ui.view.swip.SwipBackLayout;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class VerifyPhoneCodeActivity extends BaseActivity implements ForgetPwdCallView {
    ForgetPresenter forgetPresenter;
    private int fromType;

    @BindView(R.id.phone_code)
    VerifyCodeView mPhoneCode;

    @BindView(R.id.phone_label)
    TextView mPhoneLable;

    @BindView(R.id.tv_reSend)
    CodeCutTimeTextView mTvReset;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private String phoneNum;
    private int timer;

    @BindView(R.id.tv_phone)
    TextView tvPhoneTip;

    class a implements VerifyCodeView.b {
        a() {
        }

        @Override // ui.view.VerifyCodeView.b
        public void a() {
            if (VerifyPhoneCodeActivity.this.fromType == util.p1.J) {
                VerifyPhoneCodeActivity verifyPhoneCodeActivity = VerifyPhoneCodeActivity.this;
                verifyPhoneCodeActivity.forgetPresenter.verificationCode(verifyPhoneCodeActivity.phoneNum, VerifyPhoneCodeActivity.this.mPhoneCode.getEditContent());
            } else if (VerifyPhoneCodeActivity.this.fromType == util.p1.L) {
                VerifyPhoneCodeActivity verifyPhoneCodeActivity2 = VerifyPhoneCodeActivity.this;
                verifyPhoneCodeActivity2.forgetPresenter.changeMobileSubmit(verifyPhoneCodeActivity2.phoneNum, VerifyPhoneCodeActivity.this.mPhoneCode.getEditContent());
            } else {
                VerifyPhoneCodeActivity verifyPhoneCodeActivity3 = VerifyPhoneCodeActivity.this;
                verifyPhoneCodeActivity3.forgetPresenter.verificationCode(verifyPhoneCodeActivity3.phoneNum, VerifyPhoneCodeActivity.this.mPhoneCode.getEditContent());
            }
        }

        @Override // ui.view.VerifyCodeView.b
        public void a(int i2) {
        }
    }

    private void downTimer(int i2) {
        if (i2 > 0) {
            this.mTvReset.a(this.mActivity, i2);
        } else {
            this.mTvReset.a(this.mActivity, 180);
        }
    }

    private void getIntentData() {
        this.phoneNum = getIntent().getStringExtra(util.p1.F);
        this.fromType = getIntent().getIntExtra(util.p1.H, 0);
        this.timer = getIntent().getIntExtra(util.p1.E, 0);
        int i2 = this.fromType;
        if (i2 != util.p1.J && i2 == util.p1.L) {
            downTimer(this.timer);
        } else {
            downTimer(this.timer);
        }
        this.tvPhoneTip.setText(Html.fromHtml("\u77ed\u4fe1\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\u81f3\t<font color=#1D1A33>" + g2.l(this.phoneNum) + "</font>"));
        this.mPhoneCode.setInputCompleteListener(new a());
    }

    public /* synthetic */ void a() {
        this.forgetPresenter.verificationSubmit(this.phoneNum, util.p1.J, 3, this.mTvReset);
    }

    public /* synthetic */ void b() {
        this.forgetPresenter.verificationSubmit(this.phoneNum, util.p1.J, 4, this.mTvReset);
    }

    public /* synthetic */ void c() {
        this.forgetPresenter.verificationSubmit(this.phoneNum, util.p1.J, 3, this.mTvReset);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        this.mTvTitle.setText("");
        this.mPhoneLable.setTypeface(this.typ_ME);
        this.forgetPresenter = new ForgetPresenter(this.mActivity, this);
        getIntentData();
        showSoftInput(this.mPhoneCode.getEditText());
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onChangeMobileSuccRequest() {
        e2.a("\u606d\u559c\uff0c\u60a8\u5df2\u5b8c\u6210\u65b0\u624b\u673a\u53f7\u7ed1\u5b9a");
        this.forgetPresenter.requestLoginOut();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccRequest(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) ForgetPdwResetActivity.class);
        intent.putExtra(util.p1.F, this.phoneNum);
        intent.putExtra(util.p1.G, this.mPhoneCode.getEditContent());
        startActivity(intent);
        org.greenrobot.eventbus.c.f().d(new util.n2.a(23, null));
        finish();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccessLoginOut() {
        LoginManager.getInstance().exitToLogin();
    }

    @OnClick({R.id.iv_back, R.id.tv_reSend})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
            return;
        }
        if (id != R.id.tv_reSend) {
            return;
        }
        int i2 = this.fromType;
        if (i2 == util.p1.K) {
            this.forgetPresenter.verificationSubmit(this.phoneNum, util.p1.J, 2, this.mTvReset);
            return;
        }
        if (i2 == util.p1.J) {
            if (g2.a(util.u1.v, true)) {
                toYanzheng(new IOneClickListener() { // from class: ui.activity.m1
                    @Override // interfaces.IOneClickListener
                    public final void clickOKBtn() {
                        this.a.a();
                    }
                });
                return;
            } else {
                this.forgetPresenter.verificationSubmit(this.phoneNum, util.p1.J, 3, this.mTvReset);
                return;
            }
        }
        if (i2 == util.p1.L) {
            if (g2.a(util.u1.u, true)) {
                toYanzheng(new IOneClickListener() { // from class: ui.activity.n1
                    @Override // interfaces.IOneClickListener
                    public final void clickOKBtn() {
                        this.a.b();
                    }
                });
                return;
            } else {
                this.forgetPresenter.verificationSubmit(this.phoneNum, util.p1.J, 4, this.mTvReset);
                return;
            }
        }
        if (g2.a(util.u1.t, true)) {
            toYanzheng(new IOneClickListener() { // from class: ui.activity.l1
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    this.a.c();
                }
            });
        } else {
            this.forgetPresenter.verificationSubmit(this.phoneNum, util.p1.J, 3, this.mTvReset);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_forger_code;
    }
}
