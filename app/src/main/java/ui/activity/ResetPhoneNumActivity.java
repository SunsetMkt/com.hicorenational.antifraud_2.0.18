package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.ForgetPwdCallView;
import ui.presenter.ForgetPresenter;
import ui.view.swip.SwipBackLayout;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class ResetPhoneNumActivity extends BaseActivity implements ForgetPwdCallView {
    ForgetPresenter forgetPresenter;

    @BindView(R.id.confirm)
    TextView mConfim;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.phone_code)
    EditText mPhoneCode;

    @BindView(R.id.phone_label)
    TextView mPhoneLable;

    @BindView(R.id.tv_bom_tips)
    TextView mTvBomTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    String phoneNum;

    private void initListener() {
        util.h1.a(this.mPhoneCode, new IEditAfterListener() { // from class: ui.activity.a1
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                this.a.a(i2);
            }
        });
    }

    public /* synthetic */ void a(int i2) {
        if (i2 > 0) {
            this.mConfim.setEnabled(true);
            this.mIvClean.setVisibility(0);
        } else {
            this.mConfim.setEnabled(false);
            this.mIvClean.setVisibility(4);
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("");
        this.mPhoneLable.setTypeface(this.typ_ME);
        this.forgetPresenter = new ForgetPresenter(this.mActivity, this);
        this.phoneNum = getIntent().getStringExtra(util.p1.F);
        this.mTvBomTips.setText("\u4fee\u6539\u540e\u8d26\u53f7\u4fe1\u606f\u4e0d\u53d8\uff0c\u4e0b\u6b21\u9700\u4f7f\u7528\u65b0\u624b\u673a\u53f7\u767b\u5f55\u3002\u5f53\u524d\u624b\u673a\u53f7\uff1a" + g2.l(this.phoneNum));
        initListener();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onChangeMobileSuccRequest() {
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 23) {
            return;
        }
        finish();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccRequest(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) VerifyPhoneCodeActivity.class);
        intent.putExtra(util.p1.F, this.mPhoneCode.getText().toString());
        intent.putExtra(util.p1.H, util.p1.L);
        intent.putExtra(util.p1.E, i2);
        startActivity(intent);
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccessLoginOut() {
    }

    @OnClick({R.id.iv_back, R.id.iv_clear, R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.confirm) {
            if (id == R.id.iv_back) {
                finish();
                return;
            } else {
                if (id != R.id.iv_clear) {
                    return;
                }
                this.mPhoneCode.setText("");
                return;
            }
        }
        if (TextUtils.equals(this.phoneNum, this.mPhoneCode.getText().toString())) {
            util.f1.b(this.mActivity, "\u8be5\u624b\u673a\u4e0e\u5f53\u524d\u7ed1\u5b9a\u624b\u673a\u53f7\u76f8\u540c", "\u786e\u5b9a", null);
        } else if (g2.a(util.u1.u, true)) {
            toYanzheng(new IOneClickListener() { // from class: ui.activity.b1
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    this.a.a();
                }
            });
        } else {
            this.forgetPresenter.verificationResetPhone(this.mPhoneCode.getText().toString(), util.p1.L);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_reset_phone;
    }

    public /* synthetic */ void a() {
        this.forgetPresenter.verificationResetPhone(this.mPhoneCode.getText().toString(), util.p1.L);
    }
}
