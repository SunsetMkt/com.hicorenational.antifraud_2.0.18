package p388ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.EnumC1389t;
import com.airbnb.lottie.LottieAnimationView;
import com.hicorenational.antifraud.C2113R;
import manager.AccountManager;
import network.http.StatisticsHttp;
import p245d.C4440a;
import p247e.C4445b;
import p247e.C4447d;
import p388ui.Hicore;
import p388ui.presenter.BasePagePresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.SwitchButton;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7325u1;
import util.C7337y1;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class WarnSettingActivity extends BaseActivity {

    /* renamed from: a */
    BasePagePresenter f23494a;

    /* renamed from: b */
    private LottieAnimationView f23495b;

    /* renamed from: c */
    private String f23496c = "";

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.iv_right)
    ImageView mIvRight;

    @BindView(C2113R.id.layout_open)
    ConstraintLayout mLayoutOpen;

    @BindView(C2113R.id.switch_app)
    SwitchButton mSwitchApp;

    @BindView(C2113R.id.switch_call)
    SwitchButton mSwitchCall;

    @BindView(C2113R.id.switch_sms)
    SwitchButton mSwitchSms;

    @BindView(C2113R.id.tv_app)
    TextView mTvApp;

    @BindView(C2113R.id.tv_call)
    TextView mTvCall;

    @BindView(C2113R.id.tv_content)
    TextView mTvContent;

    @BindView(C2113R.id.tv_content_second)
    TextView mTvContentSecond;

    @BindView(C2113R.id.tv_go_permission)
    TextView mTvGoPermission;

    @BindView(C2113R.id.tv_sms)
    TextView mTvSms;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.WarnSettingActivity$a */
    class C6705a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ String f23497a;

        C6705a(String str) {
            this.f23497a = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C7325u1.m26631b(this.f23497a, z);
            if (z) {
                WarnSettingActivity.this.m25418b(true);
            } else {
                WarnSettingActivity.this.m25417b();
            }
            switch (compoundButton.getId()) {
                case C2113R.id.switch_call /* 2131297323 */:
                    StatisticsHttp.getInstance().trackWarnCall(z ? "1" : "0", null);
                    break;
                case C2113R.id.switch_sms /* 2131297324 */:
                    StatisticsHttp.getInstance().trackWarnSms(z ? "1" : "0", null);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m25417b() {
        m25418b(C7325u1.m26623a(C7325u1.f25633F, false) || C7325u1.m26623a(C7325u1.f25635G, false));
    }

    private void checkPermission() {
        if (!C7310c.m26520a(this.mActivity, this.f23494a.checkPermission()) || !this.f23494a.isOpenFlowPrim()) {
            this.mSwitchCall.setVisibility(8);
            this.mSwitchSms.setVisibility(8);
            this.mTvGoPermission.setVisibility(0);
            m25418b(false);
            C7325u1.m26631b(C7325u1.f25633F, false);
            C7325u1.m26631b(C7325u1.f25635G, false);
            return;
        }
        this.mSwitchCall.setVisibility(0);
        this.mSwitchSms.setVisibility(0);
        this.mTvGoPermission.setVisibility(8);
        boolean m26623a = C7325u1.m26623a(C7325u1.f25633F, false);
        boolean m26623a2 = C7325u1.m26623a(C7325u1.f25635G, false);
        boolean m26623a3 = C7325u1.m26623a(C7325u1.f25637H, false);
        if (!m26623a && !m26623a2) {
            m25418b(false);
            return;
        }
        if (m26623a) {
            this.mSwitchCall.setChecked(true);
        }
        if (m26623a2) {
            this.mSwitchSms.setChecked(true);
        }
        if (m26623a3) {
            StatisticsHttp.getInstance().trackWarnApp(m26623a3 ? "1" : "0", null);
        }
        m25418b(true);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17167n);
        C7161b.m25698a((Activity) this, true, false);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("来电预警");
        this.mIvRight.setImageResource(C2113R.mipmap.ic_warn_setting);
        this.mTvCall.setTypeface(this.typ_ME);
        this.mTvSms.setTypeface(this.typ_ME);
        this.mTvApp.setTypeface(this.typ_ME);
        this.f23494a = new BasePagePresenter(this.mActivity);
        m25415a(this.mSwitchCall, C7325u1.f25633F);
        m25415a(this.mSwitchSms, C7325u1.f25635G);
        m25412a();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LottieAnimationView lottieAnimationView = this.f23495b;
        if (lottieAnimationView != null) {
            lottieAnimationView.m2619a();
            this.f23495b.clearAnimation();
            this.f23495b.clearFocus();
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        LottieAnimationView lottieAnimationView = this.f23495b;
        if (lottieAnimationView != null) {
            lottieAnimationView.m2643g();
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LottieAnimationView lottieAnimationView = this.f23495b;
        if (lottieAnimationView != null) {
            lottieAnimationView.m2644h();
        }
        checkPermission();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_right, C2113R.id.tv_go_permission, C2113R.id.tv_error_free})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.iv_right /* 2131296826 */:
            case C2113R.id.tv_go_permission /* 2131297560 */:
                C7337y1.m26748a((Context) this.mActivity, (Class<?>) WarnPrimessActivity.class);
                break;
            case C2113R.id.tv_error_free /* 2131297548 */:
                String str = C4440a.f16885g + C4445b.f17144z;
                Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent.putExtra(C7292k1.f25363P, "错误上报");
                intent.putExtra(C7292k1.f25365Q, str + AccountManager.getShareParam());
                startActivity(intent);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_warn_setting;
    }

    /* renamed from: a */
    private void m25412a() {
        this.f23495b = (LottieAnimationView) findViewById(C2113R.id.lottie_likeanim);
        this.f23495b.setRenderMode(EnumC1389t.SOFTWARE);
        this.f23495b.setImageAssetsFolder("images/");
        this.f23495b.setAnimation("lottie_on.json");
        this.f23495b.m2644h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m25418b(boolean z) {
        if (m25416a(z)) {
            return;
        }
        if (z) {
            this.mTvContent.setText("来电预警守护中");
            this.mTvContentSecond.setText("准确识别电信诈骗");
        } else {
            this.mTvContent.setText("来电预警未开启");
            this.mTvContentSecond.setText("无法准确识别电信诈骗，请立即开启");
        }
    }

    /* renamed from: a */
    private void m25415a(SwitchButton switchButton, String str) {
        switchButton.setOnCheckedChangeListener(new C6705a(str));
    }

    /* renamed from: a */
    private boolean m25416a(boolean z) {
        String str = z ? "lottie_on.json" : "lottie_off.json";
        if (TextUtils.equals(str, this.f23496c)) {
            return true;
        }
        this.f23496c = str;
        this.f23495b.setAnimation(str);
        this.f23495b.m2644h();
        return false;
    }
}
