package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import manager.AccountManager;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import p388ui.callview.ResetPwdView;
import p388ui.presenter.ResetPwdPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7268d1;
import util.C7292k1;
import util.C7307p1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class ResetPwdActivity extends BaseActivity implements ResetPwdView {

    @BindView(C2113R.id.confirm)
    TextView mConfim;

    @BindView(C2113R.id.iv_clear)
    ImageView mIvClean;

    @BindView(C2113R.id.phone_code)
    EditText mPhoneCode;

    @BindView(C2113R.id.phone_label)
    TextView mPhoneLable;
    ResetPwdPresenter mPresenter;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    String phoneNum;

    private void initListener() {
        C7268d1.m26310a(this.mPhoneCode, new IEditAfterListener() { // from class: ui.activity.b1
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                ResetPwdActivity.this.m25317a(i2);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25317a(int i2) {
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
        this.mPhoneCode.setText(AccountManager.getVisiblePhone());
        this.mPresenter = new ResetPwdPresenter(this.mActivity, this);
        initListener();
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

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // p388ui.callview.ResetPwdView
    public void onSuccRequest(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) VerifyPhoneCodeActivity.class);
        intent.putExtra(C7292k1.f25343F, this.phoneNum);
        intent.putExtra(C7292k1.f25347H, C7292k1.f25351J);
        intent.putExtra(C7292k1.f25341E, i2);
        startActivity(intent);
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
        this.phoneNum = this.mPhoneCode.getText().toString();
        if (this.mPhoneCode.getText().toString().length() != 11) {
            C7331w1.m26688a("手机号码格式不正确，请重新输入");
        } else if (C7337y1.m26760a(C7307p1.f25513v, true)) {
            toYanzheng(new IOneClickListener() { // from class: ui.activity.a1
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    ResetPwdActivity.this.m25316a();
                }
            });
        } else {
            this.mPresenter.verificationSubmit(3, this.phoneNum);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_reset_pwd;
    }

    /* renamed from: a */
    public /* synthetic */ void m25316a() {
        this.mPresenter.verificationSubmit(3, this.phoneNum);
    }
}
