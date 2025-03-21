package p388ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import manager.AccountManager;
import p388ui.Hicore;
import p388ui.callview.MineChangePwdView;
import p388ui.presenter.MineChangePwdPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class SettingAccountActivity extends BaseActivity implements MineChangePwdView {
    MineChangePwdPresenter mPresenter;

    @BindView(C2113R.id.tv_phone)
    TextView mTvPhone;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    String phoneNum;

    private String getPhoneNmb() {
        this.phoneNum = AccountManager.getAccountPhone();
        return C7337y1.m26787l(this.phoneNum);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("账号与安全");
        this.mPresenter = new MineChangePwdPresenter(this, this);
    }

    @Override // p388ui.callview.MineChangePwdView
    public void onHasPwdSuccRequest(boolean z) {
        Intent intent = new Intent();
        if (z) {
            intent.setClass(this.mActivity, ResetPwdActivity.class);
        } else {
            intent.setClass(this.mActivity, ForgetPdwResetActivity.class);
            intent.putExtra(C7292k1.f25343F, this.phoneNum);
            intent.putExtra(C7292k1.f25345G, "");
        }
        startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mTvPhone.setText(getPhoneNmb());
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_ed_phone, C2113R.id.tv_ed_pwd, C2113R.id.rl_logout_view})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.rl_logout_view /* 2131297194 */:
                startActivity(LogoutActivity.class);
                break;
            case C2113R.id.tv_ed_phone /* 2131297545 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) ResetPhoneNumActivity.class);
                intent.putExtra(C7292k1.f25343F, this.phoneNum);
                startActivity(intent);
                break;
            case C2113R.id.tv_ed_pwd /* 2131297546 */:
                this.mPresenter.getAccHasPwd();
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_setting_account;
    }
}
