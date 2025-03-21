package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IOneClickListener;
import manager.LoginManager;
import org.greenrobot.eventbus.C6049c;
import p388ui.callview.ForgetPwdCallView;
import p388ui.presenter.ForgetPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.CodeCutTimeTextView;
import p388ui.view.VerifyCodeView;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7307p1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class VerifyPhoneCodeActivity extends BaseActivity implements ForgetPwdCallView {
    ForgetPresenter forgetPresenter;
    private int fromType;

    @BindView(C2113R.id.phone_code)
    VerifyCodeView mPhoneCode;

    @BindView(C2113R.id.phone_label)
    TextView mPhoneLable;

    @BindView(C2113R.id.tv_reSend)
    CodeCutTimeTextView mTvReset;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private String phoneNum;
    private int timer;

    @BindView(C2113R.id.tv_phone)
    TextView tvPhoneTip;

    /* renamed from: ui.activity.VerifyPhoneCodeActivity$a */
    class C6653a implements VerifyCodeView.InterfaceC7201b {
        C6653a() {
        }

        @Override // p388ui.view.VerifyCodeView.InterfaceC7201b
        /* renamed from: a */
        public void mo25390a() {
            if (VerifyPhoneCodeActivity.this.fromType == C7292k1.f25351J) {
                VerifyPhoneCodeActivity verifyPhoneCodeActivity = VerifyPhoneCodeActivity.this;
                verifyPhoneCodeActivity.forgetPresenter.verificationCode(verifyPhoneCodeActivity.phoneNum, VerifyPhoneCodeActivity.this.mPhoneCode.getEditContent());
            } else if (VerifyPhoneCodeActivity.this.fromType == C7292k1.f25355L) {
                VerifyPhoneCodeActivity verifyPhoneCodeActivity2 = VerifyPhoneCodeActivity.this;
                verifyPhoneCodeActivity2.forgetPresenter.changeMobileSubmit(verifyPhoneCodeActivity2.phoneNum, VerifyPhoneCodeActivity.this.mPhoneCode.getEditContent());
            } else {
                VerifyPhoneCodeActivity verifyPhoneCodeActivity3 = VerifyPhoneCodeActivity.this;
                verifyPhoneCodeActivity3.forgetPresenter.verificationCode(verifyPhoneCodeActivity3.phoneNum, VerifyPhoneCodeActivity.this.mPhoneCode.getEditContent());
            }
        }

        @Override // p388ui.view.VerifyCodeView.InterfaceC7201b
        /* renamed from: a */
        public void mo25391a(int i2) {
        }
    }

    private void downTimer(int i2) {
        if (i2 > 0) {
            this.mTvReset.m25756a(this.mActivity, i2);
        } else {
            this.mTvReset.m25756a(this.mActivity, 180);
        }
    }

    private void getIntentData() {
        this.phoneNum = getIntent().getStringExtra(C7292k1.f25343F);
        this.fromType = getIntent().getIntExtra(C7292k1.f25347H, 0);
        this.timer = getIntent().getIntExtra(C7292k1.f25341E, 0);
        int i2 = this.fromType;
        if (i2 == C7292k1.f25351J) {
            downTimer(this.timer);
        } else if (i2 == C7292k1.f25355L) {
            downTimer(this.timer);
        } else {
            downTimer(this.timer);
        }
        this.tvPhoneTip.setText(Html.fromHtml("短信验证码已发送至\t<font color=#1D1A33>" + C7337y1.m26787l(this.phoneNum) + "</font>"));
        this.mPhoneCode.setInputCompleteListener(new C6653a());
    }

    /* renamed from: a */
    public /* synthetic */ void m25387a() {
        this.forgetPresenter.verificationSubmit(this.phoneNum, C7292k1.f25351J, 3, this.mTvReset);
    }

    /* renamed from: b */
    public /* synthetic */ void m25388b() {
        this.forgetPresenter.verificationSubmit(this.phoneNum, C7292k1.f25351J, 4, this.mTvReset);
    }

    /* renamed from: c */
    public /* synthetic */ void m25389c() {
        this.forgetPresenter.verificationSubmit(this.phoneNum, C7292k1.f25351J, 3, this.mTvReset);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        C7161b.m25698a((Activity) this, true, true);
        this.mTvTitle.setText("");
        this.mPhoneLable.setTypeface(this.typ_ME);
        this.forgetPresenter = new ForgetPresenter(this.mActivity, this);
        getIntentData();
        showSoftInput(this.mPhoneCode.getEditText());
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onChangeMobileSuccRequest() {
        C7331w1.m26688a("恭喜，您已完成新手机号绑定");
        this.forgetPresenter.requestLoginOut();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onSuccRequest(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) ForgetPdwResetActivity.class);
        intent.putExtra(C7292k1.f25343F, this.phoneNum);
        intent.putExtra(C7292k1.f25345G, this.mPhoneCode.getEditContent());
        startActivity(intent);
        C6049c.m24987f().m25000d(new C7265a(23, null));
        finish();
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onSuccessLoginOut() {
        LoginManager.getInstance().exitToLogin();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_reSend})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            finish();
            return;
        }
        if (id != C2113R.id.tv_reSend) {
            return;
        }
        int i2 = this.fromType;
        if (i2 == C7292k1.f25353K) {
            this.forgetPresenter.verificationSubmit(this.phoneNum, C7292k1.f25351J, 2, this.mTvReset);
            return;
        }
        if (i2 == C7292k1.f25351J) {
            if (C7337y1.m26760a(C7307p1.f25513v, true)) {
                toYanzheng(new IOneClickListener() { // from class: ui.activity.k1
                    @Override // interfaces.IOneClickListener
                    public final void clickOKBtn() {
                        VerifyPhoneCodeActivity.this.m25387a();
                    }
                });
                return;
            } else {
                this.forgetPresenter.verificationSubmit(this.phoneNum, C7292k1.f25351J, 3, this.mTvReset);
                return;
            }
        }
        if (i2 == C7292k1.f25355L) {
            if (C7337y1.m26760a(C7307p1.f25512u, true)) {
                toYanzheng(new IOneClickListener() { // from class: ui.activity.l1
                    @Override // interfaces.IOneClickListener
                    public final void clickOKBtn() {
                        VerifyPhoneCodeActivity.this.m25388b();
                    }
                });
                return;
            } else {
                this.forgetPresenter.verificationSubmit(this.phoneNum, C7292k1.f25351J, 4, this.mTvReset);
                return;
            }
        }
        if (C7337y1.m26760a(C7307p1.f25511t, true)) {
            toYanzheng(new IOneClickListener() { // from class: ui.activity.j1
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    VerifyPhoneCodeActivity.this.m25389c();
                }
            });
        } else {
            this.forgetPresenter.verificationSubmit(this.phoneNum, C7292k1.f25351J, 3, this.mTvReset);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_forger_code;
    }
}
