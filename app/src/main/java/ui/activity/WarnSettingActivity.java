package ui.activity;

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
import com.airbnb.lottie.LottieAnimationView;
import com.hicorenational.antifraud.R;
import manager.AccountManager;
import network.http.StatisticsHttp;
import ui.Hicore;
import ui.presenter.BasePagePresenter;
import ui.view.SwitchButton;
import ui.view.swip.SwipBackLayout;
import util.c2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class WarnSettingActivity extends BaseActivity {
    BasePagePresenter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LottieAnimationView f14028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14029c = "";

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_right)
    ImageView mIvRight;

    @BindView(R.id.layout_open)
    ConstraintLayout mLayoutOpen;

    @BindView(R.id.switch_app)
    SwitchButton mSwitchApp;

    @BindView(R.id.switch_call)
    SwitchButton mSwitchCall;

    @BindView(R.id.switch_sms)
    SwitchButton mSwitchSms;

    @BindView(R.id.tv_app)
    TextView mTvApp;

    @BindView(R.id.tv_call)
    TextView mTvCall;

    @BindView(R.id.tv_content)
    TextView mTvContent;

    @BindView(R.id.tv_content_second)
    TextView mTvContentSecond;

    @BindView(R.id.tv_go_permission)
    TextView mTvGoPermission;

    @BindView(R.id.tv_sms)
    TextView mTvSms;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            c2.b(this.a, z);
            if (z) {
                WarnSettingActivity.this.b(true);
            } else {
                WarnSettingActivity.this.b();
            }
            switch (compoundButton.getId()) {
                case R.id.switch_call /* 2131297470 */:
                    StatisticsHttp.getInstance().trackWarnCall(z ? "1" : "0", null);
                    break;
                case R.id.switch_sms /* 2131297471 */:
                    StatisticsHttp.getInstance().trackWarnSms(z ? "1" : "0", null);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        b(c2.a(c2.F, false) || c2.a(c2.G, false));
    }

    private void checkPermission() {
        if (!util.permissionutil.c.a(this.mActivity, this.a.checkPermission()) || !this.a.isOpenFlowPrim()) {
            this.mSwitchCall.setVisibility(8);
            this.mSwitchSms.setVisibility(8);
            this.mTvGoPermission.setVisibility(0);
            b(false);
            c2.b(c2.F, false);
            c2.b(c2.G, false);
            return;
        }
        this.mSwitchCall.setVisibility(0);
        this.mSwitchSms.setVisibility(0);
        this.mTvGoPermission.setVisibility(8);
        boolean zA = c2.a(c2.F, false);
        boolean zA2 = c2.a(c2.G, false);
        boolean zA3 = c2.a(c2.H, false);
        if (!zA && !zA2) {
            b(false);
            return;
        }
        if (zA) {
            this.mSwitchCall.setChecked(true);
        }
        if (zA2) {
            this.mSwitchSms.setChecked(true);
        }
        if (zA3) {
            StatisticsHttp.getInstance().trackWarnApp(zA3 ? "1" : "0", null);
        }
        b(true);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10214n);
        ui.statusbarcompat.b.a((Activity) this, true, false);
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("\u6765\u7535\u9884\u8b66");
        this.mIvRight.setImageResource(R.mipmap.ic_warn_setting);
        this.mTvCall.setTypeface(this.typ_ME);
        this.mTvSms.setTypeface(this.typ_ME);
        this.mTvApp.setTypeface(this.typ_ME);
        this.a = new BasePagePresenter(this.mActivity);
        a(this.mSwitchCall, c2.F);
        a(this.mSwitchSms, c2.G);
        a();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LottieAnimationView lottieAnimationView = this.f14028b;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.f14028b.clearAnimation();
            this.f14028b.clearFocus();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        LottieAnimationView lottieAnimationView = this.f14028b;
        if (lottieAnimationView != null) {
            lottieAnimationView.g();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LottieAnimationView lottieAnimationView = this.f14028b;
        if (lottieAnimationView != null) {
            lottieAnimationView.h();
        }
        checkPermission();
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.tv_go_permission, R.id.tv_error_free})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.iv_right /* 2131296874 */:
            case R.id.tv_go_permission /* 2131297719 */:
                g2.a((Context) this.mActivity, (Class<?>) WarnPrimessActivity.class);
                break;
            case R.id.tv_error_free /* 2131297707 */:
                String str = e.a.f10143g + f.b.A;
                Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent.putExtra(util.p1.P, "\u9519\u8bef\u4e0a\u62a5");
                intent.putExtra(util.p1.Q, str + AccountManager.getShareParam());
                startActivity(intent);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_warn_setting;
    }

    private void a() {
        this.f14028b = (LottieAnimationView) findViewById(R.id.lottie_likeanim);
        this.f14028b.setRenderMode(com.airbnb.lottie.t.SOFTWARE);
        this.f14028b.setImageAssetsFolder("images/");
        this.f14028b.setAnimation("lottie_on.json");
        this.f14028b.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (a(z)) {
            return;
        }
        if (z) {
            this.mTvContent.setText("\u6765\u7535\u9884\u8b66\u5b88\u62a4\u4e2d");
            this.mTvContentSecond.setText("\u51c6\u786e\u8bc6\u522b\u7535\u4fe1\u8bc8\u9a97");
        } else {
            this.mTvContent.setText("\u6765\u7535\u9884\u8b66\u672a\u5f00\u542f");
            this.mTvContentSecond.setText("\u65e0\u6cd5\u51c6\u786e\u8bc6\u522b\u7535\u4fe1\u8bc8\u9a97\uff0c\u8bf7\u7acb\u5373\u5f00\u542f");
        }
    }

    private void a(SwitchButton switchButton, String str) {
        switchButton.setOnCheckedChangeListener(new a(str));
    }

    private boolean a(boolean z) {
        String str = z ? "lottie_on.json" : "lottie_off.json";
        if (TextUtils.equals(str, this.f14029c)) {
            return true;
        }
        this.f14029c = str;
        this.f14028b.setAnimation(str);
        this.f14028b.h();
        return false;
    }
}
