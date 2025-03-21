package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class ReportCaseInfoActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReportCaseInfoActivity f22853a;

    /* renamed from: b */
    private View f22854b;

    /* renamed from: c */
    private View f22855c;

    /* renamed from: d */
    private View f22856d;

    /* renamed from: e */
    private View f22857e;

    /* renamed from: f */
    private View f22858f;

    /* renamed from: g */
    private View f22859g;

    /* renamed from: h */
    private View f22860h;

    /* renamed from: ui.activity.ReportCaseInfoActivity_ViewBinding$a */
    class C6494a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportCaseInfoActivity f22861a;

        C6494a(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f22861a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22861a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportCaseInfoActivity_ViewBinding$b */
    class C6495b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportCaseInfoActivity f22863a;

        C6495b(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f22863a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22863a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportCaseInfoActivity_ViewBinding$c */
    class C6496c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportCaseInfoActivity f22865a;

        C6496c(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f22865a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22865a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportCaseInfoActivity_ViewBinding$d */
    class C6497d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportCaseInfoActivity f22867a;

        C6497d(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f22867a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22867a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportCaseInfoActivity_ViewBinding$e */
    class C6498e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportCaseInfoActivity f22869a;

        C6498e(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f22869a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22869a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportCaseInfoActivity_ViewBinding$f */
    class C6499f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportCaseInfoActivity f22871a;

        C6499f(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f22871a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22871a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportCaseInfoActivity_ViewBinding$g */
    class C6500g extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportCaseInfoActivity f22873a;

        C6500g(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f22873a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22873a.onClick(view);
        }
    }

    @UiThread
    public ReportCaseInfoActivity_ViewBinding(ReportCaseInfoActivity reportCaseInfoActivity) {
        this(reportCaseInfoActivity, reportCaseInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportCaseInfoActivity reportCaseInfoActivity = this.f22853a;
        if (reportCaseInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22853a = null;
        reportCaseInfoActivity.mIvBack = null;
        reportCaseInfoActivity.mTvTitle = null;
        reportCaseInfoActivity.mTvAdd = null;
        reportCaseInfoActivity.mRvList = null;
        reportCaseInfoActivity.mInvolveAccTip = null;
        reportCaseInfoActivity.mIvCallTip = null;
        reportCaseInfoActivity.mIvSmsTip = null;
        reportCaseInfoActivity.mIvWebNetTip = null;
        reportCaseInfoActivity.mFlBottomView = null;
        this.f22854b.setOnClickListener(null);
        this.f22854b = null;
        this.f22855c.setOnClickListener(null);
        this.f22855c = null;
        this.f22856d.setOnClickListener(null);
        this.f22856d = null;
        this.f22857e.setOnClickListener(null);
        this.f22857e = null;
        this.f22858f.setOnClickListener(null);
        this.f22858f = null;
        this.f22859g.setOnClickListener(null);
        this.f22859g = null;
        this.f22860h.setOnClickListener(null);
        this.f22860h = null;
    }

    @UiThread
    public ReportCaseInfoActivity_ViewBinding(ReportCaseInfoActivity reportCaseInfoActivity, View view) {
        this.f22853a = reportCaseInfoActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportCaseInfoActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22854b = findRequiredView;
        findRequiredView.setOnClickListener(new C6494a(reportCaseInfoActivity));
        reportCaseInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportCaseInfoActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportCaseInfoActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        reportCaseInfoActivity.mInvolveAccTip = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.involved_acc_tip, "field 'mInvolveAccTip'", ImageView.class);
        reportCaseInfoActivity.mIvCallTip = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_call_tip, "field 'mIvCallTip'", ImageView.class);
        reportCaseInfoActivity.mIvSmsTip = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_sms_tip, "field 'mIvSmsTip'", ImageView.class);
        reportCaseInfoActivity.mIvWebNetTip = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_webnet_tip, "field 'mIvWebNetTip'", ImageView.class);
        reportCaseInfoActivity.mFlBottomView = Utils.findRequiredView(view, C2113R.id.fl_bottom_view, "field 'mFlBottomView'");
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_add, "method 'onClick'");
        this.f22855c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6495b(reportCaseInfoActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.rl_involved_acc, "method 'onClick'");
        this.f22856d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6496c(reportCaseInfoActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.rl_crime_phone, "method 'onClick'");
        this.f22857e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6497d(reportCaseInfoActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.rl_sms_item, "method 'onClick'");
        this.f22858f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6498e(reportCaseInfoActivity));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.rl_webnet_item, "method 'onClick'");
        this.f22859g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6499f(reportCaseInfoActivity));
        View findRequiredView7 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onClick'");
        this.f22860h = findRequiredView7;
        findRequiredView7.setOnClickListener(new C6500g(reportCaseInfoActivity));
    }
}
