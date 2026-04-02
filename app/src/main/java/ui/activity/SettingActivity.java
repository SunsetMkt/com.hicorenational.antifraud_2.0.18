package ui.activity;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import bean.CheckTimeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import interfaces.IClickListener;
import manager.AccountManager;
import manager.LoginManager;
import manager.NotificationHelper;
import network.account.APIresult;
import network.http.StatisticsHttp;
import ui.Hicore;
import ui.callview.SettingView;
import ui.presenter.SettingPresenter;
import ui.presenter.WelocmPresenter;
import ui.view.SwitchButton;
import ui.view.swip.SwipBackLayout;
import util.c2;
import util.d2;
import util.e2;
import util.k2;

/* JADX INFO: loaded from: classes2.dex */
public class SettingActivity extends BaseActivity implements SettingView {
    private util.y0 alarmUtil = new util.y0();
    private boolean goOpenNotification;
    private boolean goOpenPush;
    private CheckTimeBean mCurrentTime;
    private SettingPresenter mPresenter;

    @BindView(R.id.rl_cache_calean)
    View mRlCache;

    @BindView(R.id.switchShow_check)
    SwitchButton mSwitchCheck;

    @BindView(R.id.switchShow_push)
    SwitchButton mSwitchPush;

    @BindView(R.id.time_setting)
    Group mTimeSetting;

    @BindView(R.id.time_txt)
    TextView mTimeTxt;

    @BindView(R.id.cache_num)
    TextView mTvCacheNum;

    @BindView(R.id.tv_push_tips)
    TextView mTvPushTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            int loginType;
            if (AccountManager.getAccountInfo() != null && (loginType = AccountManager.getAccountInfo().getLoginType()) > 0) {
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                if (loginType == AccountManager.LOGIN_QQ) {
                    share_media = SHARE_MEDIA.QQ;
                } else if (loginType == AccountManager.LOGIN_WX) {
                    share_media = SHARE_MEDIA.WEIXIN;
                } else if (loginType == AccountManager.LOGIN_SINA) {
                    share_media = SHARE_MEDIA.SINA;
                }
                UMShareAPI.get(SettingActivity.this.mActivity).deleteOauth(SettingActivity.this.mActivity, share_media, null);
            }
            SettingActivity.this.mPresenter.requestLoginOut();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            SettingActivity.this.goOpenNotification = false;
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            SettingActivity.this.goOpenNotification = true;
            d2.k(SettingActivity.this.mActivity);
        }
    }

    private void checkPrimissDialog() {
        util.f1.b(this.mActivity, R.drawable.iv_flow_primiss, "\u5f00\u542f\u5ba3\u4f20\u53ca\u529f\u80fd\u6d88\u606f\u63a8\u9001", (Build.VERSION.SDK_INT >= 26 || !(Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) ? "\u53ef\u81f3\u201d\u8bbe\u7f6e-\u901a\u77e5\u680f\u4e0e\u72b6\u6001\u201c\u4e2d\u5f00\u542f\u201d\u5141\u8bb8\u901a\u77e5\u3001\u7c7b\u522b\u901a\u77e5\u201c\u6743\u9650" : "\u53ef\u81f3\u201d\u8bbe\u7f6e-\u901a\u77e5\u680f\u4e0e\u72b6\u6001\u201c\u4e2d\u5f00\u542f\u201d\u5141\u8bb8\u901a\u77e5\u3001\u66f4\u591a\u901a\u77e5\u201c\u6743\u9650", "\u653e\u5f03\u4f7f\u7528", "\u53bb\u5f00\u542f", new b());
    }

    private void initCheckView() {
        CheckTimeBean checkTimeBean = (CheckTimeBean) c2.a(c2.I0, CheckTimeBean.class);
        if (checkTimeBean != null && isOpenCheckNotification()) {
            this.mSwitchCheck.setChecked(true);
            this.mTimeTxt.setText(checkTimeBean.getContent());
            this.mTimeSetting.setVisibility(0);
        } else {
            this.mSwitchCheck.setChecked(false);
        }
        this.mSwitchCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.f1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.a(compoundButton, z);
            }
        });
    }

    private void initPushView() {
        this.mSwitchPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.e1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.b(compoundButton, z);
            }
        });
    }

    private boolean isOpenCheckNotification() {
        return NotificationHelper.isNotificationEnabled(this.mActivity, k2.f14936g, k2.f14937h);
    }

    private void openPushBySetting(boolean z) {
        if (this.goOpenPush && z) {
            c2.b(c2.C, true);
            this.goOpenPush = false;
        }
    }

    private void setPushState(boolean z) {
        if (z) {
            receiver.e.c(this.mActivity);
            this.mTvPushTips.setText("\u6709\u91cd\u8981\u8d44\u8baf\u548c\u529f\u80fd\u6d88\u606f\u65f6\u901a\u77e5\u6211");
        } else {
            receiver.e.b(this.mActivity);
            this.mTvPushTips.setText("\u4f60\u53ef\u80fd\u9519\u8fc7\u91cd\u8981\u8d44\u8baf\u901a\u77e5\uff0c\u70b9\u51fb\u5f00\u542f\u6d88\u606f\u901a\u77e5");
        }
        this.mSwitchPush.setChecked(z);
        c2.b(c2.C, z);
    }

    private void startAlarm(int i2) {
        this.alarmUtil.b(this.mActivity, i2);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
            this.mSwitchCheck.setChecked(!z);
            e2.a(WelocmPresenter.VIRSTMSG);
            return;
        }
        if (!z) {
            this.mTimeSetting.setVisibility(8);
            this.mPresenter.closeTimeDlg();
            c2.a((Object) null, c2.I0);
            c2.b(c2.J0, 0L);
            c2.b(c2.K0, 0L);
            return;
        }
        if (!isOpenCheckNotification()) {
            checkPrimissDialog();
            this.mSwitchCheck.setChecked(false);
            return;
        }
        this.mTimeTxt.setText(this.mPresenter.mDefaultStr);
        this.mTimeSetting.setVisibility(0);
        c2.a(new CheckTimeBean(this.mPresenter.mDefaultStr, 1), c2.I0);
        startAlarm(1);
        StatisticsHttp.getInstance().trackPageClick("2");
    }

    public /* synthetic */ void b(CompoundButton compoundButton, boolean z) {
        if (!z) {
            setPushState(false);
        } else {
            if (receiver.e.d(this.mActivity)) {
                setPushState(true);
                return;
            }
            setPushState(false);
            receiver.e.e(this.mActivity);
            this.goOpenPush = true;
        }
    }

    @Override // ui.callview.SettingView
    public void cancleTimeDlg() {
        this.mCurrentTime = null;
    }

    @Override // ui.callview.SettingView
    public void ensureTimeDlg() {
        if (this.mCurrentTime != null) {
            CheckTimeBean checkTimeBean = (CheckTimeBean) c2.a(c2.I0, CheckTimeBean.class);
            if (checkTimeBean != null && this.mCurrentTime.getCode() == checkTimeBean.getCode() && TextUtils.equals(this.mCurrentTime.getContent(), checkTimeBean.getContent())) {
                return;
            }
            this.mTimeTxt.setText(this.mCurrentTime.getContent());
            c2.a(this.mCurrentTime, c2.I0);
            startAlarm(this.mCurrentTime.getCode());
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("\u8bbe\u7f6e");
        this.mPresenter = new SettingPresenter(this.mActivity, this);
        initCheckView();
        initPushView();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* JADX INFO: renamed from: onBackPressed */
    public void a() {
        this.mPresenter.closeTimeDlg();
        super.a();
    }

    @Override // ui.callview.SettingView
    public void onItemClick(CheckTimeBean checkTimeBean) {
        this.mCurrentTime = checkTimeBean;
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mTvCacheNum.setText(util.e1.h(this.mActivity));
        boolean zD = receiver.e.d(this.mActivity);
        openPushBySetting(zD);
        if (c2.a(c2.C, true) && zD) {
            c2.b(c2.C, true);
            setPushState(true);
        } else {
            c2.b(c2.C, false);
            setPushState(false);
        }
        if (this.goOpenNotification) {
            this.goOpenNotification = false;
            if (isOpenCheckNotification()) {
                this.mSwitchCheck.setChecked(true);
                return;
            } else {
                this.mSwitchCheck.setChecked(false);
                return;
            }
        }
        CheckTimeBean checkTimeBean = (CheckTimeBean) c2.a(c2.I0, CheckTimeBean.class);
        if (!isOpenCheckNotification() || checkTimeBean == null) {
            this.mSwitchCheck.setChecked(false);
        } else {
            this.mSwitchCheck.setChecked(true);
        }
    }

    @Override // ui.callview.SettingView
    public void onSuccessLoginOut(APIresult aPIresult) {
        LoginManager.getInstance().exitToLogin();
    }

    @OnClick({R.id.iv_back, R.id.rl_account, R.id.time_txt, R.id.rl_cache_calean, R.id.logout_btn})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296808 */:
                a();
                break;
            case R.id.logout_btn /* 2131297060 */:
                util.f1.a(this.mActivity, "\u60a8\u786e\u8ba4\u8981\u9000\u51fa\u767b\u5f55\u5417\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", -1, -1, true, (IClickListener) new a());
                break;
            case R.id.rl_account /* 2131297324 */:
                if (AccountManager.isLogin()) {
                    startActivity(SettingAccountActivity.class);
                }
                break;
            case R.id.rl_cache_calean /* 2131297329 */:
                org.greenrobot.eventbus.c.f().d(new util.n2.a(105, null));
                util.e1.d(this.mActivity);
                this.mTvCacheNum.setText("0KB");
                break;
            case R.id.time_txt /* 2131297515 */:
                if (!TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
                    this.mPresenter.showSelectTimeDlg();
                } else {
                    e2.a(WelocmPresenter.VIRSTMSG);
                }
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_setting;
    }
}
