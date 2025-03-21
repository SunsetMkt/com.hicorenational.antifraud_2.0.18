package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.PolicBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import network.http.StatisticsHttp;
import p245d.C4441b;
import p247e.C4447d;
import p388ui.callview.PoliceLoginCallView;
import p388ui.presenter.PoliceLoginPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.CodeCutTimeTextView;
import p388ui.view.swip.SwipBackLayout;
import util.C7268d1;
import util.C7307p1;
import util.C7331w1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class PoliceLoginActivity extends BaseActivity implements PoliceLoginCallView {

    @BindView(C2113R.id.code)
    EditText mCode;

    @BindView(C2113R.id.confirm)
    TextView mConfirm;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.iv_clear_code)
    ImageView mIvClearCode;

    @BindView(C2113R.id.iv_clear)
    ImageView mIvclean;

    @BindView(C2113R.id.phone)
    EditText mPhone;

    @BindView(C2113R.id.tv_resend)
    CodeCutTimeTextView mTvReset;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private PoliceLoginPresenter mPresenter = null;
    private boolean isAlreadySend = false;

    private void confirmClick() {
        String obj = this.mPhone.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请输入手机号");
            return;
        }
        if (obj.length() != 11) {
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
            return;
        }
        String obj2 = this.mCode.getText().toString();
        if (TextUtils.isEmpty(obj2)) {
            C7331w1.m26688a("请输入验证码");
        } else {
            this.mPresenter.smsVerify(obj, obj2);
        }
    }

    private void initView() {
        this.mPresenter = new PoliceLoginPresenter(this, this);
        this.mTvReset.m25757a(true);
        C7268d1.m26310a(this.mPhone, new IEditAfterListener() { // from class: ui.activity.q0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                PoliceLoginActivity.this.m25303a(i2);
            }
        });
        C7268d1.m26310a(this.mCode, new IEditAfterListener() { // from class: ui.activity.p0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                PoliceLoginActivity.this.m25304b(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resetClick, reason: merged with bridge method [inline-methods] */
    public void m25302a() {
        String obj = this.mPhone.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请输入手机号");
        } else if (obj.length() != 11) {
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
        } else {
            this.isAlreadySend = true;
            this.mPresenter.sendSms(obj);
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m25303a(int i2) {
        if (this.mPhone.getText().toString().trim().length() > 0) {
            this.mIvclean.setVisibility(0);
        } else {
            this.mIvclean.setVisibility(8);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m25304b(int i2) {
        if (this.mCode.getText().toString().trim().length() > 0) {
            this.mIvClearCode.setVisibility(0);
        } else {
            this.mIvClearCode.setVisibility(8);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17161h);
        C7161b.m25698a((Activity) this, true, false);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        initView();
    }

    @Override // p388ui.callview.PoliceLoginCallView
    public void onSendFailRequest() {
        C7331w1.m26688a("验证码发送失败，请重试");
        this.isAlreadySend = false;
    }

    @Override // p388ui.callview.PoliceLoginCallView
    public void onSendSuccessRequest() {
        C7331w1.m26688a("验证码已发送，请查收");
        this.isAlreadySend = false;
        CodeCutTimeTextView codeCutTimeTextView = this.mTvReset;
        if (codeCutTimeTextView != null) {
            codeCutTimeTextView.m25756a(this.mActivity, 60);
        }
    }

    @Override // p388ui.callview.PoliceLoginCallView
    public void onVerifySuccessRequest(PolicBean policBean) {
        policBean.setTelNumber(this.mPhone.getText().toString());
        C4441b.m16413a(policBean);
        startActivity(new Intent(this, (Class<?>) PoliceInfoActivity.class));
        finish();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_clear, C2113R.id.tv_resend, C2113R.id.iv_clear_code, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                confirmClick();
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.iv_clear /* 2131296772 */:
                this.mPhone.setText("");
                break;
            case C2113R.id.iv_clear_code /* 2131296774 */:
                this.mCode.setText("");
                break;
            case C2113R.id.tv_resend /* 2131297692 */:
                if (!this.isAlreadySend) {
                    if (!C7337y1.m26760a(C7307p1.f25515x, true)) {
                        m25302a();
                        break;
                    } else {
                        toYanzheng(new IOneClickListener() { // from class: ui.activity.o0
                            @Override // interfaces.IOneClickListener
                            public final void clickOKBtn() {
                                PoliceLoginActivity.this.m25302a();
                            }
                        });
                        break;
                    }
                } else {
                    C7331w1.m26688a("验证码获取中，请稍等");
                    break;
                }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_police_login;
    }
}
