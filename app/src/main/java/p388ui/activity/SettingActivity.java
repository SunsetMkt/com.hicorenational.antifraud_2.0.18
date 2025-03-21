package p388ui.activity;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import bean.CheckTimeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import interfaces.IClickListener;
import manager.AccountManager;
import manager.LoginManager;
import manager.NotificationHelper;
import network.account.APIresult;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import p388ui.Hicore;
import p388ui.callview.SettingView;
import p388ui.presenter.SettingPresenter;
import p388ui.presenter.WelocmPresenter;
import p388ui.view.SwitchButton;
import p388ui.view.swip.SwipBackLayout;
import receiver.C6088e;
import util.C7253a1;
import util.C7254a2;
import util.C7257b1;
import util.C7325u1;
import util.C7327v0;
import util.C7328v1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class SettingActivity extends BaseActivity implements SettingView {
    private C7327v0 alarmUtil = new C7327v0();
    private boolean goOpenNotification;
    private boolean goOpenPush;
    private CheckTimeBean mCurrentTime;
    private SettingPresenter mPresenter;

    @BindView(C2113R.id.rl_cache_calean)
    View mRlCache;

    @BindView(C2113R.id.switchShow_check)
    SwitchButton mSwitchCheck;

    @BindView(C2113R.id.switchShow_push)
    SwitchButton mSwitchPush;

    @BindView(C2113R.id.time_setting)
    Group mTimeSetting;

    @BindView(C2113R.id.time_txt)
    TextView mTimeTxt;

    @BindView(C2113R.id.cache_num)
    TextView mTvCacheNum;

    @BindView(C2113R.id.tv_push_tips)
    TextView mTvPushTips;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.SettingActivity$a */
    class C6568a implements IClickListener {
        C6568a() {
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

    /* renamed from: ui.activity.SettingActivity$b */
    class C6569b implements IClickListener {
        C6569b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            SettingActivity.this.goOpenNotification = false;
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            SettingActivity.this.goOpenNotification = true;
            C7328v1.m26673k(SettingActivity.this.mActivity);
        }
    }

    private void checkPrimissDialog() {
        C7257b1.m26209b(this.mActivity, C2113R.drawable.iv_flow_primiss, "开启宣传及功能消息推送", (Build.VERSION.SDK_INT >= 26 || !(Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) ? "可至”设置-通知栏与状态“中开启”允许通知、类别通知“权限" : "可至”设置-通知栏与状态“中开启”允许通知、更多通知“权限", "放弃使用", "去开启", new C6569b());
    }

    private void initCheckView() {
        CheckTimeBean checkTimeBean = (CheckTimeBean) C7325u1.m26615a(C7325u1.f25640I0, CheckTimeBean.class);
        if (checkTimeBean == null) {
            this.mSwitchCheck.setChecked(false);
        } else if (isOpenCheckNotification()) {
            this.mSwitchCheck.setChecked(true);
            this.mTimeTxt.setText(checkTimeBean.getContent());
            this.mTimeSetting.setVisibility(0);
        } else {
            this.mSwitchCheck.setChecked(false);
        }
        this.mSwitchCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.d1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SettingActivity.this.m25327a(compoundButton, z);
            }
        });
    }

    private void initPushView() {
        this.mSwitchPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.c1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SettingActivity.this.m25328b(compoundButton, z);
            }
        });
    }

    private boolean isOpenCheckNotification() {
        return NotificationHelper.isNotificationEnabled(this.mActivity, C7254a2.f25106g, C7254a2.f25107h);
    }

    private void openPushBySetting(boolean z) {
        if (this.goOpenPush && z) {
            C7325u1.m26631b(C7325u1.f25627C, true);
            this.goOpenPush = false;
        }
    }

    private void setPushState(boolean z) {
        if (z) {
            C6088e.m25188c(this.mActivity);
            this.mTvPushTips.setText("有重要资讯和功能消息时通知我");
        } else {
            C6088e.m25185b(this.mActivity);
            this.mTvPushTips.setText("你可能错过重要资讯通知，点击开启消息通知");
        }
        this.mSwitchPush.setChecked(z);
        C7325u1.m26631b(C7325u1.f25627C, z);
    }

    private void startAlarm(int i2) {
        this.alarmUtil.m26641b(this.mActivity, i2);
    }

    /* renamed from: a */
    public /* synthetic */ void m25327a(CompoundButton compoundButton, boolean z) {
        if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
            this.mSwitchCheck.setChecked(!z);
            C7331w1.m26688a(WelocmPresenter.VIRSTMSG);
            return;
        }
        if (!z) {
            this.mTimeSetting.setVisibility(8);
            this.mPresenter.closeTimeDlg();
            C7325u1.m26619a((Object) null, C7325u1.f25640I0);
            C7325u1.m26629b(C7325u1.f25642J0, 0L);
            C7325u1.m26629b(C7325u1.f25644K0, 0L);
            return;
        }
        if (!isOpenCheckNotification()) {
            checkPrimissDialog();
            this.mSwitchCheck.setChecked(false);
            return;
        }
        this.mTimeTxt.setText(this.mPresenter.mDefaultStr);
        this.mTimeSetting.setVisibility(0);
        C7325u1.m26619a(new CheckTimeBean(this.mPresenter.mDefaultStr, 1), C7325u1.f25640I0);
        startAlarm(1);
        StatisticsHttp.getInstance().trackPageClick("2");
    }

    /* renamed from: b */
    public /* synthetic */ void m25328b(CompoundButton compoundButton, boolean z) {
        if (!z) {
            setPushState(false);
        } else {
            if (C6088e.m25189d(this.mActivity)) {
                setPushState(true);
                return;
            }
            setPushState(false);
            C6088e.m25190e(this.mActivity);
            this.goOpenPush = true;
        }
    }

    @Override // p388ui.callview.SettingView
    public void cancleTimeDlg() {
        this.mCurrentTime = null;
    }

    @Override // p388ui.callview.SettingView
    public void ensureTimeDlg() {
        if (this.mCurrentTime != null) {
            CheckTimeBean checkTimeBean = (CheckTimeBean) C7325u1.m26615a(C7325u1.f25640I0, CheckTimeBean.class);
            if (checkTimeBean != null && this.mCurrentTime.getCode() == checkTimeBean.getCode() && TextUtils.equals(this.mCurrentTime.getContent(), checkTimeBean.getContent())) {
                return;
            }
            this.mTimeTxt.setText(this.mCurrentTime.getContent());
            C7325u1.m26619a(this.mCurrentTime, C7325u1.f25640I0);
            startAlarm(this.mCurrentTime.getCode());
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("设置");
        this.mPresenter = new SettingPresenter(this.mActivity, this);
        initCheckView();
        initPushView();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mPresenter.closeTimeDlg();
        super.onBackPressed();
    }

    @Override // p388ui.callview.SettingView
    public void onItemClick(CheckTimeBean checkTimeBean) {
        this.mCurrentTime = checkTimeBean;
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mTvCacheNum.setText(C7253a1.m26150h(this.mActivity));
        boolean m25189d = C6088e.m25189d(this.mActivity);
        openPushBySetting(m25189d);
        if (C7325u1.m26623a(C7325u1.f25627C, true) && m25189d) {
            C7325u1.m26631b(C7325u1.f25627C, true);
            setPushState(true);
        } else {
            C7325u1.m26631b(C7325u1.f25627C, false);
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
        CheckTimeBean checkTimeBean = (CheckTimeBean) C7325u1.m26615a(C7325u1.f25640I0, CheckTimeBean.class);
        if (!isOpenCheckNotification() || checkTimeBean == null) {
            this.mSwitchCheck.setChecked(false);
        } else {
            this.mSwitchCheck.setChecked(true);
        }
    }

    @Override // p388ui.callview.SettingView
    public void onSuccessLoginOut(APIresult aPIresult) {
        LoginManager.getInstance().exitToLogin();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.rl_account, C2113R.id.time_txt, C2113R.id.rl_cache_calean, C2113R.id.logout_btn})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.logout_btn /* 2131297010 */:
                C7257b1.m26184a(this.mActivity, "您确认要退出登录吗？", "", "确定", "取消", -1, -1, true, (IClickListener) new C6568a());
                break;
            case C2113R.id.rl_account /* 2131297183 */:
                if (AccountManager.isLogin()) {
                    startActivity(SettingAccountActivity.class);
                    break;
                }
                break;
            case C2113R.id.rl_cache_calean /* 2131297188 */:
                C6049c.m24987f().m25000d(new C7265a(105, null));
                C7253a1.m26146d(this.mActivity);
                this.mTvCacheNum.setText("0KB");
                break;
            case C2113R.id.time_txt /* 2131297357 */:
                if (!TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
                    this.mPresenter.showSelectTimeDlg();
                    break;
                } else {
                    C7331w1.m26688a(WelocmPresenter.VIRSTMSG);
                    break;
                }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_setting;
    }
}
