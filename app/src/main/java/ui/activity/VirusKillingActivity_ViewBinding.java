package ui.activity;

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
import com.hicorenational.antifraud.R;
import ui.view.SwitchButton;

/* JADX INFO: loaded from: classes2.dex */
public class VirusKillingActivity_ViewBinding implements Unbinder {
    private VirusKillingActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f13986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f13987h;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ VirusKillingActivity a;

        a(VirusKillingActivity virusKillingActivity) {
            this.a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ VirusKillingActivity a;

        b(VirusKillingActivity virusKillingActivity) {
            this.a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ VirusKillingActivity a;

        c(VirusKillingActivity virusKillingActivity) {
            this.a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ VirusKillingActivity a;

        d(VirusKillingActivity virusKillingActivity) {
            this.a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ VirusKillingActivity a;

        e(VirusKillingActivity virusKillingActivity) {
            this.a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ VirusKillingActivity a;

        f(VirusKillingActivity virusKillingActivity) {
            this.a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {
        final /* synthetic */ VirusKillingActivity a;

        g(VirusKillingActivity virusKillingActivity) {
            this.a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public VirusKillingActivity_ViewBinding(VirusKillingActivity virusKillingActivity) {
        this(virusKillingActivity, virusKillingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VirusKillingActivity virusKillingActivity = this.a;
        if (virusKillingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
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
        this.f13981b.setOnClickListener(null);
        this.f13981b = null;
        this.f13982c.setOnClickListener(null);
        this.f13982c = null;
        this.f13983d.setOnClickListener(null);
        this.f13983d = null;
        this.f13984e.setOnClickListener(null);
        this.f13984e = null;
        this.f13985f.setOnClickListener(null);
        this.f13985f = null;
        this.f13986g.setOnClickListener(null);
        this.f13986g = null;
        this.f13987h.setOnClickListener(null);
        this.f13987h = null;
    }

    @UiThread
    public VirusKillingActivity_ViewBinding(VirusKillingActivity virusKillingActivity, View view) {
        this.a = virusKillingActivity;
        virusKillingActivity.mIvCircle = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_circle, "field 'mIvCircle'", ImageView.class);
        virusKillingActivity.mIvCircleCenter = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_circle_center, "field 'mIvCircleCenter'", ImageView.class);
        virusKillingActivity.mScanResultTip = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_result_tip, "field 'mScanResultTip'", TextView.class);
        virusKillingActivity.mScanState = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_state, "field 'mScanState'", TextView.class);
        virusKillingActivity.mLayoutRiskBtn = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.layout_risk_btn, "field 'mLayoutRiskBtn'", ConstraintLayout.class);
        virusKillingActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        virusKillingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        virusKillingActivity.mRecyclerview1 = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview1, "field 'mRecyclerview1'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.stop_scan, "field 'mStopScan' and method 'onViewClicked'");
        virusKillingActivity.mStopScan = (TextView) Utils.castView(viewFindRequiredView, R.id.stop_scan, "field 'mStopScan'", TextView.class);
        this.f13981b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(virusKillingActivity));
        virusKillingActivity.mScanAppCount = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_app_count, "field 'mScanAppCount'", TextView.class);
        virusKillingActivity.mScanPackageCount = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_package_count, "field 'mScanPackageCount'", TextView.class);
        virusKillingActivity.mIvAppStates = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_app_states, "field 'mIvAppStates'", ImageView.class);
        virusKillingActivity.mIvApkStates = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_apk_states, "field 'mIvApkStates'", ImageView.class);
        virusKillingActivity.mViewBg = Utils.findRequiredView(view, R.id.view_bg, "field 'mViewBg'");
        virusKillingActivity.mRecyclerviewRisk = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_risk, "field 'mRecyclerviewRisk'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_appeal, "field 'mTvAppeal' and method 'onViewClicked'");
        virusKillingActivity.mTvAppeal = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_appeal, "field 'mTvAppeal'", TextView.class);
        this.f13982c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(virusKillingActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_delete, "field 'mTvDelete' and method 'onViewClicked'");
        virusKillingActivity.mTvDelete = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_delete, "field 'mTvDelete'", TextView.class);
        this.f13983d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(virusKillingActivity));
        virusKillingActivity.mScanApp = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_app, "field 'mScanApp'", TextView.class);
        virusKillingActivity.mScanPackage = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_package, "field 'mScanPackage'", TextView.class);
        virusKillingActivity.mScanLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.scan_layout, "field 'mScanLayout'", ConstraintLayout.class);
        virusKillingActivity.mTvAppCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_count, "field 'mTvAppCount'", TextView.class);
        virusKillingActivity.mTvPackageCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_package_count, "field 'mTvPackageCount'", TextView.class);
        virusKillingActivity.mRlSafeResult = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_safe_result, "field 'mRlSafeResult'", RelativeLayout.class);
        virusKillingActivity.mSafeSpace = (Group) Utils.findRequiredViewAsType(view, R.id.safe_space, "field 'mSafeSpace'", Group.class);
        virusKillingActivity.mRlRiskResult = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_risk_result, "field 'mRlRiskResult'", RelativeLayout.class);
        virusKillingActivity.mTvApp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app, "field 'mTvApp'", TextView.class);
        virusKillingActivity.mSwitchApp = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_app, "field 'mSwitchApp'", SwitchButton.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13984e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(virusKillingActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.layout_app, "method 'onViewClicked'");
        this.f13985f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(virusKillingActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.layout_apk, "method 'onViewClicked'");
        this.f13986g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(virusKillingActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_appeal_wb, "method 'onViewClicked'");
        this.f13987h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(virusKillingActivity));
    }
}
