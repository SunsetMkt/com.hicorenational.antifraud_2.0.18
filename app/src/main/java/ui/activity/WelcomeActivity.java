package ui.activity;

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
import com.airbnb.lottie.LottieAnimationView;
import com.hicorenational.antifraud.R;
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
import ui.Hicore;
import ui.callview.WelcomeCallView;
import ui.presenter.JNIHandStamp;
import ui.presenter.WelocmPresenter;
import util.UpdateUtil;
import util.c2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class WelcomeActivity extends UmengNotifyClickActivity implements WelcomeCallView {
    private ui.view.r downTimer;
    private PushEntity entity;
    private AdBean mAdBean = null;

    @BindView(R.id.cl_layout)
    ConstraintLayout mClLayout;

    @BindView(R.id.image)
    ImageView mImage;

    @BindView(R.id.lottie_likeanim)
    LottieAnimationView mLottieLike;

    @BindView(R.id.tv_next)
    TextView mTvNext;
    private WelocmPresenter presenter;

    class a implements IOneClickListener {
        a() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            WelcomeActivity.this.finishPage();
        }
    }

    class b implements IOneClickListener {
        b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            WelcomeActivity.this.presenter.requestPartDircly();
        }
    }

    class c implements PermissionsListener {
        final /* synthetic */ long a;

        c(long j2) {
            this.a = j2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            WelcomeActivity.this.showUpdateDlg(this.a);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            WelcomeActivity.this.showUpdateDlg(this.a);
        }
    }

    class d implements IBaseBeanCall<APIresult<DownloadInfo>> {
        final /* synthetic */ long a;

        d(long j2) {
            this.a = j2;
        }

        @Override // interfaces.IBaseBeanCall
        public void onClose() {
            WelcomeActivity.this.judageAdPage(this.a);
        }

        @Override // interfaces.IBaseBeanCall
        public void onfail() {
            WelcomeActivity.this.judageAdPage(this.a);
        }

        @Override // interfaces.IBaseBeanCall
        public void onsuccess(APIresult<DownloadInfo> aPIresult) {
        }
    }

    class e implements IClickListener {
        e() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ui.c.i().d();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            c2.b(util.u1.y, false);
            WelcomeActivity.this.checkPermission(100L);
            util.u1.b(util.u1.f15091n, true);
        }
    }

    class f extends ui.view.r {
        f(long j2, long j3) {
            super(j2, j3);
        }

        @Override // ui.view.r
        public void a(long j2) {
            WelcomeActivity welcomeActivity = WelcomeActivity.this;
            if (welcomeActivity == null || welcomeActivity.isFinishing()) {
                return;
            }
            int i2 = (int) (j2 / 1000);
            WelcomeActivity.this.mTvNext.setText("\u8df3\u8fc7 " + i2);
        }

        @Override // ui.view.r
        public void d() {
            if (WelcomeActivity.this.isFinishing()) {
                return;
            }
            WelcomeActivity.this.turnPage(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermission(long j2) {
        if (!util.u1.a(util.u1.f15091n, false)) {
            Hicore.getApp().initSDK();
        }
        util.permissionutil.c.a(this, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f15033j, "android.permission.MANAGE_DOCUMENTS", "android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission.RECEIVE_BOOT_COMPLETED"}, new c(j2));
    }

    private void countTime() {
        if (this.downTimer == null) {
            this.downTimer = new f(this.mAdBean.getShowTime() * 1000, 1000L);
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
        if (c2.a(util.u1.y, true)) {
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
        this.presenter.getAiMediaConfig();
        this.presenter.otherPartDictionary();
        this.presenter.getAd(j2);
    }

    private void lottieInit() {
        this.mLottieLike.setRenderMode(com.airbnb.lottie.t.SOFTWARE);
        this.mLottieLike.setAnimation("lottie_ad.json");
        this.mLottieLike.h();
    }

    private void showAgreement() {
        util.f1.a((Activity) this, "\u670d\u52a1\u534f\u8bae\u548c\u9690\u79c1\u653f\u7b56", g2.a(this, getString(R.string.clause_befor), "\u4e0e", getString(R.string.clause_end), "\u300a\u670d\u52a1\u534f\u8bae\u300b", "\u300a\u9690\u79c1\u653f\u7b56\u300b"), true, "\u4e0d\u540c\u610f", "\u540c\u610f", (IClickListener) new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateDlg(long j2) {
        updateAppWithTime(new d(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnPage(long j2) {
        g2.f14889b.postDelayed(new Runnable() { // from class: ui.activity.s1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        }, 0L);
    }

    public /* synthetic */ void a() {
        final Intent intent = new Intent();
        PushEntity pushEntity = this.entity;
        if (pushEntity != null) {
            intent.putExtra(util.p1.f15011c, pushEntity);
        }
        if (!AccountManager.isLogin()) {
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
            finishPage();
        } else {
            if (util.u1.a(LocalModuelConfig.ISHAVE_LOCAL, -1) != -1) {
                LocalModuelConfig.getInstance().getConfigMude(AccountManager.getRegisterRegionCode(), new IResultCallback() { // from class: ui.activity.r1
                    @Override // interfaces.IResultCallback
                    public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                        this.a.a(intent, regionMudelBean);
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
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10202b);
        this.presenter = new WelocmPresenter(this, this);
        JNIHandStamp.getInstance().handsharkKeyAsyn(new b());
        this.mClLayout.setVisibility(8);
    }

    @Override // ui.callview.WelcomeCallView
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
        ui.statusbarcompat.b.a((Activity) this, true, false);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        if (g2.f()) {
            util.f1.b(this, "\u672c\u5e94\u7528\u4e0d\u652f\u6301ROOT\u8bbe\u5907", "\u786e\u5b9a", new a());
        } else {
            initPage();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LottieAnimationView lottieAnimationView = this.mLottieLike;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.mLottieLike.clearAnimation();
            this.mLottieLike.clearFocus();
        }
        ui.view.r rVar = this.downTimer;
        if (rVar != null) {
            rVar.a();
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity
    public void onMessage(Intent intent) {
        super.onMessage(intent);
        try {
            String stringExtra = intent.getStringExtra("body");
            if (g2.p(stringExtra)) {
                return;
            }
            this.entity = (PushEntity) new com.google.gson.e().a(stringExtra, PushEntity.class);
            org.greenrobot.eventbus.c.f().d(new util.n2.a(110, this.entity));
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
            lottieAnimationView.g();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ui.view.r rVar = this.downTimer;
        if (rVar != null && rVar.b()) {
            this.downTimer.d();
        }
        LottieAnimationView lottieAnimationView = this.mLottieLike;
        if (lottieAnimationView != null) {
            lottieAnimationView.h();
        }
        util.s1.d("tt", "hahahahahhaha");
    }

    @Override // ui.callview.WelcomeCallView
    public void onSuccessRequest() {
        c2.b(util.u1.y, true);
        showAgreement();
    }

    @OnClick({R.id.tv_next, R.id.lottie_likeanim})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.lottie_likeanim) {
            if (id != R.id.tv_next) {
                return;
            }
            ui.view.r rVar = this.downTimer;
            if (rVar != null) {
                rVar.a();
            }
            turnPage(0L);
            return;
        }
        if (this.mAdBean == null) {
            return;
        }
        ui.view.r rVar2 = this.downTimer;
        if (rVar2 != null) {
            rVar2.a();
        }
        String openUrl = this.mAdBean.getOpenUrl();
        if (TextUtils.isEmpty(openUrl)) {
            return;
        }
        if (this.mAdBean.getOpenType() != 1) {
            if (this.mAdBean.getOpenType() == 2) {
                util.p1.a((Context) this, openUrl);
                return;
            }
            return;
        }
        String title = this.mAdBean.getTitle();
        Intent intent = new Intent(this, (Class<?>) WebActivity.class);
        if (TextUtils.isEmpty(title)) {
            title = "";
        }
        intent.putExtra(util.p1.P, title);
        intent.putExtra(util.p1.Q, openUrl + AccountManager.getShareParam());
        intent.putExtra(util.p1.Z, util.p1.a0);
        startActivity(intent);
        finish();
    }

    @Override // ui.callview.WelcomeCallView
    public void onfailRequest() {
        handleTurnPage();
    }

    public void showAd() {
        try {
            com.bumptech.glide.b.a((Activity) this).a(this.mAdBean.getImageUrl()).a(this.mImage);
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
        if (!TextUtils.equals(g2.d("yyyy-MM-dd"), c2.a("update_home", ""))) {
            UpdateUtil.updateAppOnly(this, iBaseBeanCall);
        } else if (iBaseBeanCall != null) {
            iBaseBeanCall.onfail();
        }
    }

    public /* synthetic */ void a(Intent intent, RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
            finishPage();
        }
    }
}
