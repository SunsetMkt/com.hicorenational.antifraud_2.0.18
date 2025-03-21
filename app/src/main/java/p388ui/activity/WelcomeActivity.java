package p388ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import bean.AdBean;
import bean.PushEntity;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.airbnb.lottie.EnumC1389t;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.google.gson.C2051e;
import com.hicorenational.antifraud.C2113R;
import com.umeng.message.UmengNotifyClickActivity;
import interfaces.IBaseBeanCall;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.IResultCallback;
import interfaces.PermissionsListener;
import java.util.List;
import manager.AccountManager;
import network.DownloadInfo;
import network.account.APIresult;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import p247e.C4447d;
import p388ui.C6813c;
import p388ui.Hicore;
import p388ui.callview.WelcomeCallView;
import p388ui.presenter.JNIHandStamp;
import p388ui.presenter.WelocmPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.AbstractC7237p;
import util.C7257b1;
import util.C7292k1;
import util.C7301n1;
import util.C7307p1;
import util.C7325u1;
import util.C7337y1;
import util.UpdateUtil;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class WelcomeActivity extends UmengNotifyClickActivity implements WelcomeCallView {
    private AbstractC7237p downTimer;
    private PushEntity entity;
    private AdBean mAdBean = null;

    @BindView(C2113R.id.cl_layout)
    ConstraintLayout mClLayout;

    @BindView(C2113R.id.image)
    ImageView mImage;

    @BindView(C2113R.id.lottie_likeanim)
    LottieAnimationView mLottieLike;

    @BindView(C2113R.id.tv_next)
    TextView mTvNext;
    private WelocmPresenter presenter;

    /* renamed from: ui.activity.WelcomeActivity$a */
    class C6729a implements IOneClickListener {
        C6729a() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            WelcomeActivity.this.finishPage();
        }
    }

    /* renamed from: ui.activity.WelcomeActivity$b */
    class C6730b implements IOneClickListener {
        C6730b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            WelcomeActivity.this.presenter.requestPartDircly();
        }
    }

    /* renamed from: ui.activity.WelcomeActivity$c */
    class C6731c implements PermissionsListener {

        /* renamed from: a */
        final /* synthetic */ long f23559a;

        C6731c(long j2) {
            this.f23559a = j2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            WelcomeActivity.this.showUpdateDlg(this.f23559a);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            WelcomeActivity.this.showUpdateDlg(this.f23559a);
        }
    }

    /* renamed from: ui.activity.WelcomeActivity$d */
    class C6732d implements IBaseBeanCall<APIresult<DownloadInfo>> {

        /* renamed from: a */
        final /* synthetic */ long f23561a;

        C6732d(long j2) {
            this.f23561a = j2;
        }

        @Override // interfaces.IBaseBeanCall
        public void onClose() {
            WelcomeActivity.this.judageAdPage(this.f23561a);
        }

        @Override // interfaces.IBaseBeanCall
        public void onfail() {
            WelcomeActivity.this.judageAdPage(this.f23561a);
        }

        @Override // interfaces.IBaseBeanCall
        public void onsuccess(APIresult<DownloadInfo> aPIresult) {
        }
    }

    /* renamed from: ui.activity.WelcomeActivity$e */
    class C6733e implements IClickListener {
        C6733e() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            C6813c.m25437i().m25448d();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            C7325u1.m26631b(C7307p1.f25516y, false);
            WelcomeActivity.this.checkPermission(100L);
            C7307p1.m26488b(C7307p1.f25505n, true);
        }
    }

    /* renamed from: ui.activity.WelcomeActivity$f */
    class C6734f extends AbstractC7237p {
        C6734f(long j2, long j3) {
            super(j2, j3);
        }

        @Override // p388ui.view.AbstractC7237p
        /* renamed from: a */
        public void mo25433a(long j2) {
            WelcomeActivity welcomeActivity = WelcomeActivity.this;
            if (welcomeActivity == null || welcomeActivity.isFinishing()) {
                return;
            }
            int i2 = (int) (j2 / 1000);
            WelcomeActivity.this.mTvNext.setText("跳过 " + i2);
        }

        @Override // p388ui.view.AbstractC7237p
        /* renamed from: d */
        public void mo25434d() {
            if (WelcomeActivity.this.isFinishing()) {
                return;
            }
            WelcomeActivity.this.turnPage(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermission(long j2) {
        if (!C7307p1.m26481a(C7307p1.f25505n, false)) {
            Hicore.getApp().initSDK();
        }
        C7310c.m26518a(this, new String[]{C7308a.f25521A, C7308a.f25547z, C7308a.f25531j, "android.permission.RECEIVE_BOOT_COMPLETED"}, new C6731c(j2));
    }

    private void countTime() {
        if (this.downTimer == null) {
            this.downTimer = new C6734f(this.mAdBean.getShowTime() * 1000, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPage() {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    private void handleTurnPage() {
        if (C7325u1.m26623a(C7307p1.f25516y, true)) {
            showAgreement();
        } else {
            checkPermission(100L);
        }
    }

    private boolean isDoubleStart() {
        if ((getIntent().getFlags() & 4194304) <= 0) {
            return false;
        }
        finishPage();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judageAdPage(long j2) {
        this.presenter.otherPartDictionary();
        this.presenter.getAd(j2);
    }

    private void lottieInit() {
        this.mLottieLike.setRenderMode(EnumC1389t.SOFTWARE);
        this.mLottieLike.setAnimation("lottie_ad.json");
        this.mLottieLike.m2644h();
    }

    private void showAgreement() {
        C7257b1.m26178a((Activity) this, "服务协议和隐私政策", C7337y1.m26728a(this, getString(C2113R.string.clause_befor), "与", getString(C2113R.string.clause_end), "《服务协议》", "《隐私政策》"), true, "不同意", "同意", (IClickListener) new C6733e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateDlg(long j2) {
        updateAppWithTime(new C6732d(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnPage(long j2) {
        C7337y1.f25731b.postDelayed(new Runnable() { // from class: ui.activity.u1
            @Override // java.lang.Runnable
            public final void run() {
                WelcomeActivity.this.m25431a();
            }
        }, 0L);
    }

    /* renamed from: a */
    public /* synthetic */ void m25431a() {
        final Intent intent = new Intent();
        PushEntity pushEntity = this.entity;
        if (pushEntity != null) {
            intent.putExtra(C7292k1.f25391c, pushEntity);
        }
        if (!AccountManager.isLogin()) {
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
            finishPage();
        } else {
            if (C7307p1.m26473a(LocalModuelConfig.ISHAVE_LOCAL, -1) != -1) {
                LocalModuelConfig.getInstance().getConfigMude(AccountManager.getRegisterRegionCode(), new IResultCallback() { // from class: ui.activity.t1
                    @Override // interfaces.IResultCallback
                    public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                        WelcomeActivity.this.m25432a(intent, regionMudelBean);
                    }
                });
                return;
            }
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
            finishPage();
        }
    }

    public void initPage() {
        Hicore.schemeString = getIntent().getDataString();
        if (isDoubleStart()) {
            return;
        }
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17155b);
        this.presenter = new WelocmPresenter(this, this);
        JNIHandStamp.getInstance().handsharkKeyAsyn(new C6730b());
        this.mClLayout.setVisibility(8);
    }

    @Override // p388ui.callview.WelcomeCallView
    public void onAdRequest(AdBean adBean, long j2) {
        if (adBean == null || TextUtils.isEmpty(adBean.getImageUrl())) {
            this.mAdBean = null;
            turnPage(j2);
        } else {
            this.mAdBean = adBean;
            showAd();
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C7161b.m25698a((Activity) this, true, false);
        setContentView(C2113R.layout.activity_welcome);
        ButterKnife.bind(this);
        if (C7337y1.m26780f()) {
            C7257b1.m26210b(this, "本应用不支持ROOT设备", "确定", new C6729a());
        } else {
            initPage();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LottieAnimationView lottieAnimationView = this.mLottieLike;
        if (lottieAnimationView != null) {
            lottieAnimationView.m2619a();
            this.mLottieLike.clearAnimation();
            this.mLottieLike.clearFocus();
        }
        AbstractC7237p abstractC7237p = this.downTimer;
        if (abstractC7237p != null) {
            abstractC7237p.m26011a();
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity
    public void onMessage(Intent intent) {
        super.onMessage(intent);
        try {
            String stringExtra = intent.getStringExtra("body");
            if (C7337y1.m26791p(stringExtra)) {
                return;
            }
            this.entity = (PushEntity) new C2051e().m5569a(stringExtra, PushEntity.class);
            C6049c.m24987f().m25000d(new C7265a(110, this.entity));
        } catch (Exception unused) {
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        LottieAnimationView lottieAnimationView = this.mLottieLike;
        if (lottieAnimationView != null) {
            lottieAnimationView.m2643g();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AbstractC7237p abstractC7237p = this.downTimer;
        if (abstractC7237p != null && abstractC7237p.m26013b()) {
            this.downTimer.mo25434d();
        }
        LottieAnimationView lottieAnimationView = this.mLottieLike;
        if (lottieAnimationView != null) {
            lottieAnimationView.m2644h();
        }
        C7301n1.m26461d("tt", "hahahahahhaha");
    }

    @Override // p388ui.callview.WelcomeCallView
    public void onSuccessRequest() {
        C7325u1.m26631b(C7307p1.f25516y, true);
        showAgreement();
    }

    @OnClick({C2113R.id.tv_next, C2113R.id.lottie_likeanim})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.lottie_likeanim) {
            if (id != C2113R.id.tv_next) {
                return;
            }
            AbstractC7237p abstractC7237p = this.downTimer;
            if (abstractC7237p != null) {
                abstractC7237p.m26011a();
            }
            turnPage(0L);
            return;
        }
        if (this.mAdBean == null) {
            return;
        }
        AbstractC7237p abstractC7237p2 = this.downTimer;
        if (abstractC7237p2 != null) {
            abstractC7237p2.m26011a();
        }
        String openUrl = this.mAdBean.getOpenUrl();
        if (TextUtils.isEmpty(openUrl)) {
            return;
        }
        if (this.mAdBean.getOpenType() != 1) {
            if (this.mAdBean.getOpenType() == 2) {
                C7292k1.m26394a((Context) this, openUrl);
                return;
            }
            return;
        }
        String title = this.mAdBean.getTitle();
        Intent intent = new Intent(this, (Class<?>) WebActivity.class);
        if (TextUtils.isEmpty(title)) {
            title = "";
        }
        intent.putExtra(C7292k1.f25363P, title);
        intent.putExtra(C7292k1.f25365Q, openUrl + AccountManager.getShareParam());
        intent.putExtra(C7292k1.f25383Z, C7292k1.f25386a0);
        startActivity(intent);
        finish();
    }

    @Override // p388ui.callview.WelcomeCallView
    public void onfailRequest() {
        handleTurnPage();
    }

    public void showAd() {
        try {
            ComponentCallbacks2C1576b.m3634a((Activity) this).mo3719a(this.mAdBean.getImageUrl()).m3768a(this.mImage);
        } catch (Exception unused) {
        }
        this.mClLayout.setAlpha(0.0f);
        this.mClLayout.setVisibility(0);
        this.mClLayout.animate().alpha(1.0f).setDuration(1000L).setListener(null);
        if (TextUtils.isEmpty(this.mAdBean.getOpenUrl())) {
            this.mLottieLike.setVisibility(8);
        } else {
            lottieInit();
            this.mLottieLike.setVisibility(0);
        }
        if (this.mAdBean.getShowTime() > 0) {
            countTime();
        }
    }

    public void updateAppWithTime(IBaseBeanCall iBaseBeanCall) {
        if (UpdateUtil.isCheckUpdateAlready) {
            if (iBaseBeanCall != null) {
                iBaseBeanCall.onfail();
                return;
            }
            return;
        }
        if (!TextUtils.equals(C7337y1.m26775d("yyyy-MM-dd"), C7325u1.m26616a("update_home", ""))) {
            UpdateUtil.updateAppOnly(this, iBaseBeanCall);
        } else if (iBaseBeanCall != null) {
            iBaseBeanCall.onfail();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m25432a(Intent intent, RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
            finishPage();
        }
    }
}
