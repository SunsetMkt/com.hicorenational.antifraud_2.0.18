package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ReportCaseInfoActivity_ViewBinding implements Unbinder {
    private ReportCaseInfoActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f13664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f13665h;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReportCaseInfoActivity a;

        a(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ReportCaseInfoActivity a;

        b(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ ReportCaseInfoActivity a;

        c(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ ReportCaseInfoActivity a;

        d(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ ReportCaseInfoActivity a;

        e(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ ReportCaseInfoActivity a;

        f(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class g extends DebouncingOnClickListener {
        final /* synthetic */ ReportCaseInfoActivity a;

        g(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportCaseInfoActivity_ViewBinding(ReportCaseInfoActivity reportCaseInfoActivity) {
        this(reportCaseInfoActivity, reportCaseInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportCaseInfoActivity reportCaseInfoActivity = this.a;
        if (reportCaseInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportCaseInfoActivity.mIvBack = null;
        reportCaseInfoActivity.mTvTitle = null;
        reportCaseInfoActivity.mTvAdd = null;
        reportCaseInfoActivity.mRvList = null;
        reportCaseInfoActivity.mInvolveAccTip = null;
        reportCaseInfoActivity.mIvCallTip = null;
        reportCaseInfoActivity.mIvSmsTip = null;
        reportCaseInfoActivity.mIvWebNetTip = null;
        reportCaseInfoActivity.mFlBottomView = null;
        this.f13659b.setOnClickListener(null);
        this.f13659b = null;
        this.f13660c.setOnClickListener(null);
        this.f13660c = null;
        this.f13661d.setOnClickListener(null);
        this.f13661d = null;
        this.f13662e.setOnClickListener(null);
        this.f13662e = null;
        this.f13663f.setOnClickListener(null);
        this.f13663f = null;
        this.f13664g.setOnClickListener(null);
        this.f13664g = null;
        this.f13665h.setOnClickListener(null);
        this.f13665h = null;
    }

    @UiThread
    public ReportCaseInfoActivity_ViewBinding(ReportCaseInfoActivity reportCaseInfoActivity, View view) {
        this.a = reportCaseInfoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportCaseInfoActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13659b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportCaseInfoActivity));
        reportCaseInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportCaseInfoActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportCaseInfoActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        reportCaseInfoActivity.mInvolveAccTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.involved_acc_tip, "field 'mInvolveAccTip'", ImageView.class);
        reportCaseInfoActivity.mIvCallTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_call_tip, "field 'mIvCallTip'", ImageView.class);
        reportCaseInfoActivity.mIvSmsTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_sms_tip, "field 'mIvSmsTip'", ImageView.class);
        reportCaseInfoActivity.mIvWebNetTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_webnet_tip, "field 'mIvWebNetTip'", ImageView.class);
        reportCaseInfoActivity.mFlBottomView = Utils.findRequiredView(view, R.id.fl_bottom_view, "field 'mFlBottomView'");
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "method 'onClick'");
        this.f13660c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportCaseInfoActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_involved_acc, "method 'onClick'");
        this.f13661d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(reportCaseInfoActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_crime_phone, "method 'onClick'");
        this.f13662e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(reportCaseInfoActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.rl_sms_item, "method 'onClick'");
        this.f13663f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(reportCaseInfoActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.rl_webnet_item, "method 'onClick'");
        this.f13664g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(reportCaseInfoActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onClick'");
        this.f13665h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(reportCaseInfoActivity));
    }
}
