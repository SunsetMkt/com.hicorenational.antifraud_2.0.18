package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import bean.PushEntity;
import bean.SmsBean;
import bean.module.BottomLocalBean;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IOneClickListener;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import manager.LoginManager;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p245d.C4440a;
import p388ui.C6813c;
import p388ui.callview.MainCallview;
import p388ui.fragment.HomeFragment;
import p388ui.fragment.LocalWebFragment;
import p388ui.fragment.MineFragment;
import p388ui.fragment.WebFragment;
import p388ui.presenter.MainPagePresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.BottomBar;
import p388ui.view.NoSlideViewPager;
import p388ui.view.ZoomOutPageTransformer;
import receiver.AppReceiver;
import receiver.C6088e;
import util.C7257b1;
import util.C7292k1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class MainActivity extends BaseActivity implements MainCallview {
    private static String pushType = "";
    private static String pushUrl = "";
    private FragmentStatePagerAdapter mAdapter;
    private AppReceiver mAppReceiver;

    @BindView(C2113R.id.bottomBar)
    BottomBar mBottomBar;

    @BindView(C2113R.id.full_screen)
    View mFullScreen;
    private HomeFragment mHomeFragment;

    @BindView(C2113R.id.iv_guide_main_1)
    ImageView mIvGuideMain1;
    private MineFragment mMineFragment;
    private MainPagePresenter mPresenter;

    @BindView(C2113R.id.viewpager)
    NoSlideViewPager mViewpager;
    private LocalWebFragment mWebFragLocal;
    private WebFragment mWebFragment;
    private int prePos;
    private RegionMudelBean regionBean;
    private boolean webFullScreen;
    private List<Fragment> mTabs = new ArrayList();
    private List<SmsBean> smsBean = new ArrayList();
    private String moduleLocal = "";

    /* renamed from: ui.activity.MainActivity$a */
    class C6369a extends FragmentStatePagerAdapter {
        C6369a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MainActivity.this.mTabs.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) MainActivity.this.mTabs.get(i2);
        }

        public long getItemId(int i2) {
            return ((Fragment) MainActivity.this.mTabs.get(i2)).hashCode();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public static void getPushIntent(Intent intent) {
        pushType = intent.getStringExtra(C7292k1.f25394d);
        pushUrl = intent.getStringExtra(C7292k1.f25365Q);
    }

    private void initAdapter() {
        this.mViewpager.setOffscreenPageLimit(this.mTabs.size());
        this.mViewpager.setPageTransformer(true, new ZoomOutPageTransformer());
        this.mAdapter = new C6369a(getSupportFragmentManager());
        this.mViewpager.setAdapter(this.mAdapter);
        this.mBottomBar.setOnTabSelectedListener(new BottomBar.InterfaceC7164a() { // from class: ui.activity.i0
            @Override // p388ui.view.BottomBar.InterfaceC7164a
            /* renamed from: a */
            public final void mo25435a(BottomLocalBean bottomLocalBean, int i2, int i3) {
                MainActivity.this.m25287a(bottomLocalBean, i2, i3);
            }
        });
    }

    private void initTabIndicators(BottomLocalBean bottomLocalBean) {
        if (bottomLocalBean != null) {
            this.mBottomBar.m25732a(bottomLocalBean);
        } else {
            this.mBottomBar.m25731a();
        }
        this.mBottomBar.setCurrentItem(0);
    }

    private void initViewPager(BottomLocalBean bottomLocalBean) {
        this.mTabs.add(this.mHomeFragment);
        this.mTabs.add(this.mWebFragment);
        this.mTabs.add(this.mMineFragment);
        if (bottomLocalBean != null) {
            this.moduleLocal = bottomLocalBean.getModule();
            this.mWebFragLocal = LocalWebFragment.getInstance(bottomLocalBean.getModule());
            this.mTabs.add(2, this.mWebFragLocal);
        }
        initAdapter();
    }

    private void intentHome() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    private void localFreshTab(BottomLocalBean bottomLocalBean) {
        if (bottomLocalBean != null) {
            if (TextUtils.equals(this.moduleLocal, bottomLocalBean.getModule())) {
                return;
            }
            this.moduleLocal = bottomLocalBean.getModule();
            this.mWebFragLocal = LocalWebFragment.getInstance(bottomLocalBean.getModule());
            this.mTabs.set(2, this.mWebFragLocal);
            this.mAdapter.notifyDataSetChanged();
        } else {
            if (this.mTabs.size() == 3) {
                return;
            }
            this.mTabs.remove(2);
            this.mAdapter.notifyDataSetChanged();
        }
        initTabIndicators(bottomLocalBean);
    }

    private void mineRedState(boolean z) {
        this.mBottomBar.m25735a(z);
    }

    private void registerAppReceiver() {
        this.mAppReceiver = new AppReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.mAppReceiver, intentFilter);
    }

    /* renamed from: a */
    public /* synthetic */ void m25286a() {
        if (this.mWebFragLocal == null || TextUtils.isEmpty(pushType) || !pushType.equals(C6088e.f21716d)) {
            return;
        }
        this.mViewpager.setCurrentItem(2, true);
        this.mBottomBar.setCurrentItem(2);
        LocalWebFragment.setPushUrl(pushUrl);
        pushType = "";
    }

    public List<SmsBean> getBean() {
        return this.smsBean;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        C6049c.m24987f().m25001e(this);
        registerAppReceiver();
        this.mPresenter = new MainPagePresenter(this.mActivity, this);
        Jzvd.f2737r0 = 1;
        getPushData();
        this.mHomeFragment = new HomeFragment();
        this.mWebFragment = new WebFragment();
        this.mMineFragment = new MineFragment();
        this.regionBean = C4440a.m16408j();
        RegionMudelBean regionMudelBean = this.regionBean;
        if (regionMudelBean != null) {
            initViewPager(regionMudelBean.getLocal());
            initTabIndicators(this.regionBean.getLocal());
        } else {
            initViewPager(null);
            initTabIndicators(null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        UMShareAPI.get(this).onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mTabs.get(this.mViewpager.getCurrentItem()) instanceof WebFragment) {
            WebFragment webFragment = this.mWebFragment;
            if (webFragment == null) {
                intentHome();
                return;
            } else {
                if (webFragment.onBackPressed()) {
                    return;
                }
                intentHome();
                return;
            }
        }
        if (!(this.mTabs.get(this.mViewpager.getCurrentItem()) instanceof LocalWebFragment)) {
            intentHome();
            return;
        }
        LocalWebFragment localWebFragment = this.mWebFragLocal;
        if (localWebFragment == null) {
            intentHome();
        } else {
            if (localWebFragment.onBackPressed()) {
                return;
            }
            intentHome();
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
        unregisterReceiver(this.mAppReceiver);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a == 110) {
                PushEntity pushEntity = (PushEntity) c7265a.m26300b();
                if (pushEntity != null) {
                    C6088e.m25180a(pushEntity.getExtra(), this);
                }
                return;
            }
            if (m26297a == 231) {
                this.mMineFragment.forceFreshListSize();
                return;
            }
            if (m26297a == 235) {
                mineRedState(((Boolean) c7265a.m26300b()).booleanValue());
                return;
            }
            if (m26297a == 153) {
                C6049c.m24987f().m25002f(c7265a);
                HomeFragment homeFragment = this.mHomeFragment;
                if (homeFragment != null) {
                    homeFragment.virusStatus();
                    return;
                }
                return;
            }
            if (m26297a == 154) {
                C6049c.m24987f().m25002f(c7265a);
                HomeFragment homeFragment2 = this.mHomeFragment;
                if (homeFragment2 != null) {
                    homeFragment2.virusFinish();
                    return;
                }
                return;
            }
            if (m26297a == 221) {
                localFreshTab((BottomLocalBean) c7265a.m26300b());
                return;
            }
            if (m26297a == 222) {
                this.mViewpager.setCurrentItem(this.prePos, true);
                this.mBottomBar.setCurrentItem(this.prePos);
                return;
            }
            switch (m26297a) {
                case 100:
                    C6049c.m24987f().m25002f(c7265a);
                    this.mBottomBar.setVisibility(8);
                    this.webFullScreen = true;
                    C7161b.m25698a((Activity) this, true, false);
                    break;
                case 101:
                    C6049c.m24987f().m25002f(c7265a);
                    this.mBottomBar.setVisibility(0);
                    this.webFullScreen = false;
                    C7161b.m25698a((Activity) this, true, true);
                    break;
                case 102:
                    C6049c.m24987f().m25002f(c7265a);
                    this.mBottomBar.setVisibility(8);
                    this.webFullScreen = true;
                    C7161b.m25698a((Activity) this, true, true);
                    break;
                case 103:
                    C6049c.m24987f().m25002f(c7265a);
                    this.mBottomBar.setVisibility(8);
                    this.webFullScreen = true;
                    C7161b.m25698a((Activity) this, true, false);
                    break;
                case 104:
                    if (this.mWebFragment != null) {
                        this.mBottomBar.setCurrentItem(1);
                        this.mViewpager.setCurrentItem(1);
                        this.mWebFragment.turnPage();
                        break;
                    }
                    break;
                case 105:
                    WebFragment webFragment = this.mWebFragment;
                    if (webFragment != null) {
                        webFragment.clearH5localData();
                        break;
                    }
                    break;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.webFullScreen && i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.getInt(C7292k1.f25394d, 0) != 480) {
            return;
        }
        this.mHomeFragment.autoForceRefresh();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (AccountManager.isLogin()) {
            this.mPresenter.getH5SchmeData(this.mBottomBar);
        } else {
            LoginManager.getInstance().exitToLogin();
        }
        if (C7337y1.m26780f()) {
            C7257b1.m26210b(this, "本应用不支持ROOT设备", "确定", new IOneClickListener() { // from class: ui.activity.j0
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    C6813c.m25437i().m25439a();
                }
            });
        }
        this.mBottomBar.postDelayed(new Runnable() { // from class: ui.activity.k0
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m25286a();
            }
        }, 1000L);
    }

    @OnClick({C2113R.id.iv_guide_main_1})
    public void onViewClicked(View view) {
        view.getId();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_main;
    }

    /* renamed from: a */
    public /* synthetic */ void m25287a(BottomLocalBean bottomLocalBean, int i2, int i3) {
        this.mViewpager.setCurrentItem(i2, false);
        this.prePos = i2;
    }
}
