package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.SwitchButton;

/* loaded from: classes2.dex */
public class VirusKillingActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private VirusKillingActivity f23415a;

    /* renamed from: b */
    private View f23416b;

    /* renamed from: c */
    private View f23417c;

    /* renamed from: d */
    private View f23418d;

    /* renamed from: e */
    private View f23419e;

    /* renamed from: f */
    private View f23420f;

    /* renamed from: g */
    private View f23421g;

    /* renamed from: h */
    private View f23422h;

    /* renamed from: ui.activity.VirusKillingActivity_ViewBinding$a */
    class C6678a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusKillingActivity f23423a;

        C6678a(VirusKillingActivity virusKillingActivity) {
            this.f23423a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23423a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity_ViewBinding$b */
    class C6679b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusKillingActivity f23425a;

        C6679b(VirusKillingActivity virusKillingActivity) {
            this.f23425a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23425a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity_ViewBinding$c */
    class C6680c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusKillingActivity f23427a;

        C6680c(VirusKillingActivity virusKillingActivity) {
            this.f23427a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23427a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity_ViewBinding$d */
    class C6681d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusKillingActivity f23429a;

        C6681d(VirusKillingActivity virusKillingActivity) {
            this.f23429a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23429a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity_ViewBinding$e */
    class C6682e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusKillingActivity f23431a;

        C6682e(VirusKillingActivity virusKillingActivity) {
            this.f23431a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23431a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity_ViewBinding$f */
    class C6683f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusKillingActivity f23433a;

        C6683f(VirusKillingActivity virusKillingActivity) {
            this.f23433a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23433a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity_ViewBinding$g */
    class C6684g extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VirusKillingActivity f23435a;

        C6684g(VirusKillingActivity virusKillingActivity) {
            this.f23435a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23435a.onViewClicked(view);
        }
    }

    @UiThread
    public VirusKillingActivity_ViewBinding(VirusKillingActivity virusKillingActivity) {
        this(virusKillingActivity, virusKillingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VirusKillingActivity virusKillingActivity = this.f23415a;
        if (virusKillingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23415a = null;
        virusKillingActivity.mIvCircle = null;
        virusKillingActivity.mIvCircleCenter = null;
        virusKillingActivity.mScanResultTip = null;
        virusKillingActivity.mScanState = null;
        virusKillingActivity.mLayoutRiskBtn = null;
        virusKillingActivity.mRecyclerview = null;
        virusKillingActivity.mTvTitle = null;
        virusKillingActivity.mRecyclerview1 = null;
        virusKillingActivity.mStopScan = null;
        virusKillingActivity.mScanAppCount = null;
        virusKillingActivity.mScanPackageCount = null;
        virusKillingActivity.mIvAppStates = null;
        virusKillingActivity.mIvApkStates = null;
        virusKillingActivity.mViewBg = null;
        virusKillingActivity.mRecyclerviewRisk = null;
        virusKillingActivity.mTvAppeal = null;
        virusKillingActivity.mTvDelete = null;
        virusKillingActivity.mScanApp = null;
        virusKillingActivity.mScanPackage = null;
        virusKillingActivity.mScanLayout = null;
        virusKillingActivity.mTvAppCount = null;
        virusKillingActivity.mTvPackageCount = null;
        virusKillingActivity.mRlSafeResult = null;
        virusKillingActivity.mSafeSpace = null;
        virusKillingActivity.mRlRiskResult = null;
        virusKillingActivity.mTvApp = null;
        virusKillingActivity.mSwitchApp = null;
        this.f23416b.setOnClickListener(null);
        this.f23416b = null;
        this.f23417c.setOnClickListener(null);
        this.f23417c = null;
        this.f23418d.setOnClickListener(null);
        this.f23418d = null;
        this.f23419e.setOnClickListener(null);
        this.f23419e = null;
        this.f23420f.setOnClickListener(null);
        this.f23420f = null;
        this.f23421g.setOnClickListener(null);
        this.f23421g = null;
        this.f23422h.setOnClickListener(null);
        this.f23422h = null;
    }

    @UiThread
    public VirusKillingActivity_ViewBinding(VirusKillingActivity virusKillingActivity, View view) {
        this.f23415a = virusKillingActivity;
        virusKillingActivity.mIvCircle = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_circle, "field 'mIvCircle'", ImageView.class);
        virusKillingActivity.mIvCircleCenter = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_circle_center, "field 'mIvCircleCenter'", ImageView.class);
        virusKillingActivity.mScanResultTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.scan_result_tip, "field 'mScanResultTip'", TextView.class);
        virusKillingActivity.mScanState = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.scan_state, "field 'mScanState'", TextView.class);
        virusKillingActivity.mLayoutRiskBtn = (ConstraintLayout) Utils.findRequiredViewAsType(view, C2113R.id.layout_risk_btn, "field 'mLayoutRiskBtn'", ConstraintLayout.class);
        virusKillingActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        virusKillingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        virusKillingActivity.mRecyclerview1 = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview1, "field 'mRecyclerview1'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.stop_scan, "field 'mStopScan' and method 'onViewClicked'");
        virusKillingActivity.mStopScan = (TextView) Utils.castView(findRequiredView, C2113R.id.stop_scan, "field 'mStopScan'", TextView.class);
        this.f23416b = findRequiredView;
        findRequiredView.setOnClickListener(new C6678a(virusKillingActivity));
        virusKillingActivity.mScanAppCount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.scan_app_count, "field 'mScanAppCount'", TextView.class);
        virusKillingActivity.mScanPackageCount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.scan_package_count, "field 'mScanPackageCount'", TextView.class);
        virusKillingActivity.mIvAppStates = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_app_states, "field 'mIvAppStates'", ImageView.class);
        virusKillingActivity.mIvApkStates = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_apk_states, "field 'mIvApkStates'", ImageView.class);
        virusKillingActivity.mViewBg = Utils.findRequiredView(view, C2113R.id.view_bg, "field 'mViewBg'");
        virusKillingActivity.mRecyclerviewRisk = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview_risk, "field 'mRecyclerviewRisk'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_appeal, "field 'mTvAppeal' and method 'onViewClicked'");
        virusKillingActivity.mTvAppeal = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_appeal, "field 'mTvAppeal'", TextView.class);
        this.f23417c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6679b(virusKillingActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_delete, "field 'mTvDelete' and method 'onViewClicked'");
        virusKillingActivity.mTvDelete = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_delete, "field 'mTvDelete'", TextView.class);
        this.f23418d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6680c(virusKillingActivity));
        virusKillingActivity.mScanApp = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.scan_app, "field 'mScanApp'", TextView.class);
        virusKillingActivity.mScanPackage = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.scan_package, "field 'mScanPackage'", TextView.class);
        virusKillingActivity.mScanLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, C2113R.id.scan_layout, "field 'mScanLayout'", ConstraintLayout.class);
        virusKillingActivity.mTvAppCount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_count, "field 'mTvAppCount'", TextView.class);
        virusKillingActivity.mTvPackageCount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_package_count, "field 'mTvPackageCount'", TextView.class);
        virusKillingActivity.mRlSafeResult = (RelativeLayout) Utils.findRequiredViewAsType(view, C2113R.id.rl_safe_result, "field 'mRlSafeResult'", RelativeLayout.class);
        virusKillingActivity.mSafeSpace = (Group) Utils.findRequiredViewAsType(view, C2113R.id.safe_space, "field 'mSafeSpace'", Group.class);
        virusKillingActivity.mRlRiskResult = (RelativeLayout) Utils.findRequiredViewAsType(view, C2113R.id.rl_risk_result, "field 'mRlRiskResult'", RelativeLayout.class);
        virusKillingActivity.mTvApp = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app, "field 'mTvApp'", TextView.class);
        virusKillingActivity.mSwitchApp = (SwitchButton) Utils.findRequiredViewAsType(view, C2113R.id.switch_app, "field 'mSwitchApp'", SwitchButton.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23419e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6681d(virusKillingActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.layout_app, "method 'onViewClicked'");
        this.f23420f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6682e(virusKillingActivity));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.layout_apk, "method 'onViewClicked'");
        this.f23421g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6683f(virusKillingActivity));
        View findRequiredView7 = Utils.findRequiredView(view, C2113R.id.tv_appeal_wb, "method 'onViewClicked'");
        this.f23422h = findRequiredView7;
        findRequiredView7.setOnClickListener(new C6684g(virusKillingActivity));
    }
}
