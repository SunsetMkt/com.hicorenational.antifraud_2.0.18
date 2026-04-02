package ui.activity;

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
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import network.http.StatisticsHttp;
import ui.callview.PoliceLoginCallView;
import ui.presenter.PoliceLoginPresenter;
import ui.view.CodeCutTimeTextView;
import ui.view.swip.SwipBackLayout;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class PoliceLoginActivity extends BaseActivity implements PoliceLoginCallView {

    @BindView(R.id.code)
    EditText mCode;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_clear_code)
    ImageView mIvClearCode;

    @BindView(R.id.iv_clear)
    ImageView mIvclean;

    @BindView(R.id.phone)
    EditText mPhone;

    @BindView(R.id.tv_resend)
    CodeCutTimeTextView mTvReset;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private PoliceLoginPresenter mPresenter = null;
    private boolean isAlreadySend = false;

    private void confirmClick() {
        String string = this.mPhone.getText().toString();
        if (TextUtils.isEmpty(string)) {
            e2.a("\u8bf7\u8f93\u5165\u624b\u673a\u53f7");
            return;
        }
        if (string.length() != 11) {
            e2.a("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            return;
        }
        String string2 = this.mCode.getText().toString();
        if (TextUtils.isEmpty(string2)) {
            e2.a("\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801");
        } else {
            this.mPresenter.smsVerify(string, string2);
        }
    }

    private void initView() {
        this.mPresenter = new PoliceLoginPresenter(this, this);
        this.mTvReset.a(true);
        util.h1.a(this.mPhone, new IEditAfterListener() { // from class: ui.activity.s0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                this.a.a(i2);
            }
        });
        util.h1.a(this.mCode, new IEditAfterListener() { // from class: ui.activity.r0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                this.a.b(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: resetClick, reason: merged with bridge method [inline-methods] */
    public void a() {
        String string = this.mPhone.getText().toString();
        if (TextUtils.isEmpty(string)) {
            e2.a("\u8bf7\u8f93\u5165\u624b\u673a\u53f7");
        } else if (string.length() != 11) {
            e2.a("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
        } else {
            this.isAlreadySend = true;
            this.mPresenter.sendSms(string);
        }
    }

    public /* synthetic */ void a(int i2) {
        if (this.mPhone.getText().toString().trim().length() > 0) {
            this.mIvclean.setVisibility(0);
        } else {
            this.mIvclean.setVisibility(8);
        }
    }

    public /* synthetic */ void b(int i2) {
        if (this.mCode.getText().toString().trim().length() > 0) {
            this.mIvClearCode.setVisibility(0);
        } else {
            this.mIvClearCode.setVisibility(8);
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10208h);
        ui.statusbarcompat.b.a((Activity) this, true, false);
        SwipBackLayout.a(this.mActivity).a();
        initView();
    }

    @Override // ui.callview.PoliceLoginCallView
    public void onSendFailRequest() {
        e2.a("\u9a8c\u8bc1\u7801\u53d1\u9001\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
        this.isAlreadySend = false;
    }

    @Override // ui.callview.PoliceLoginCallView
    public void onSendSuccessRequest() {
        e2.a("\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\uff0c\u8bf7\u67e5\u6536");
        this.isAlreadySend = false;
        CodeCutTimeTextView codeCutTimeTextView = this.mTvReset;
        if (codeCutTimeTextView != null) {
            codeCutTimeTextView.a(this.mActivity, 60);
        }
    }

    @Override // ui.callview.PoliceLoginCallView
    public void onVerifySuccessRequest(PolicBean policBean) {
        policBean.setTelNumber(this.mPhone.getText().toString());
        e.b.a(policBean);
        startActivity(new Intent(this, (Class<?>) PoliceInfoActivity.class));
        finish();
    }

    @OnClick({R.id.iv_back, R.id.iv_clear, R.id.tv_resend, R.id.iv_clear_code, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296501 */:
                confirmClick();
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.iv_clear /* 2131296818 */:
                this.mPhone.setText("");
                break;
            case R.id.iv_clear_code /* 2131296820 */:
                this.mCode.setText("");
                break;
            case R.id.tv_resend /* 2131297853 */:
                if (this.isAlreadySend) {
                    e2.a("\u9a8c\u8bc1\u7801\u83b7\u53d6\u4e2d\uff0c\u8bf7\u7a0d\u7b49");
                } else if (!g2.a(util.u1.x, true)) {
                    a();
                } else {
                    toYanzheng(new IOneClickListener() { // from class: ui.activity.q0
                        @Override // interfaces.IOneClickListener
                        public final void clickOKBtn() {
                            this.a.a();
                        }
                    });
                }
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_police_login;
    }
}
