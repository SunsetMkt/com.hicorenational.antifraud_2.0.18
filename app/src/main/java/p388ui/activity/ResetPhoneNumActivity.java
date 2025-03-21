package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import p388ui.callview.ForgetPwdCallView;
import p388ui.presenter.ForgetPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7268d1;
import util.C7292k1;
import util.C7307p1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class ResetPhoneNumActivity extends BaseActivity implements ForgetPwdCallView {
    ForgetPresenter forgetPresenter;

    @BindView(C2113R.id.confirm)
    TextView mConfim;

    @BindView(C2113R.id.iv_clear)
    ImageView mIvClean;

    @BindView(C2113R.id.phone_code)
    EditText mPhoneCode;

    @BindView(C2113R.id.phone_label)
    TextView mPhoneLable;

    @BindView(C2113R.id.tv_bom_tips)
    TextView mTvBomTips;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    String phoneNum;

    private void initListener() {
        C7268d1.m26310a(this.mPhoneCode, new IEditAfterListener() { // from class: ui.activity.y0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                ResetPhoneNumActivity.this.m25315a(i2);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25315a(int i2) {
        if (i2 > 0) {
            this.mConfim.setEnabled(true);
            this.mIvClean.setVisibility(0);
        } else {
            this.mConfim.setEnabled(false);
            this.mIvClean.setVisibility(4);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        C7161b.m25698a((Activity) this, true, true);
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("");
        this.mPhoneLable.setTypeface(this.typ_ME);
        this.forgetPresenter = new ForgetPresenter(this.mActivity, this);
        this.phoneNum = getIntent().getStringExtra(C7292k1.f25343F);
        this.mTvBomTips.setText("修改后账号信息不变，下次需使用新手机号登录。当前手机号：" + C7337y1.m26787l(this.phoneNum));
        initListener();
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onChangeMobileSuccRequest() {
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 23) {
            return;
        }
        finish();
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onSuccRequest(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) VerifyPhoneCodeActivity.class);
        intent.putExtra(C7292k1.f25343F, this.mPhoneCode.getText().toString());
        intent.putExtra(C7292k1.f25347H, C7292k1.f25355L);
        intent.putExtra(C7292k1.f25341E, i2);
        startActivity(intent);
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onSuccessLoginOut() {
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_clear, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.confirm) {
            if (id == C2113R.id.iv_back) {
                finish();
                return;
            } else {
                if (id != C2113R.id.iv_clear) {
                    return;
                }
                this.mPhoneCode.setText("");
                return;
            }
        }
        if (TextUtils.equals(this.phoneNum, this.mPhoneCode.getText().toString())) {
            C7257b1.m26210b(this.mActivity, "该手机与当前绑定手机号相同", "确定", null);
        } else if (C7337y1.m26760a(C7307p1.f25512u, true)) {
            toYanzheng(new IOneClickListener() { // from class: ui.activity.z0
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    ResetPhoneNumActivity.this.m25314a();
                }
            });
        } else {
            this.forgetPresenter.verificationResetPhone(this.mPhoneCode.getText().toString(), C7292k1.f25355L);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_reset_phone;
    }

    /* renamed from: a */
    public /* synthetic */ void m25314a() {
        this.forgetPresenter.verificationResetPhone(this.mPhoneCode.getText().toString(), C7292k1.f25355L);
    }
}
