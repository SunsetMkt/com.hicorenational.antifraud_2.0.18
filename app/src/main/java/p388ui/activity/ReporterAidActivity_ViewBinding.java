package p388ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class ReporterAidActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReporterAidActivity f23008a;

    /* renamed from: b */
    private View f23009b;

    /* renamed from: c */
    private View f23010c;

    /* renamed from: d */
    private View f23011d;

    /* renamed from: e */
    private View f23012e;

    /* renamed from: ui.activity.ReporterAidActivity_ViewBinding$a */
    class C6551a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReporterAidActivity f23013a;

        C6551a(ReporterAidActivity reporterAidActivity) {
            this.f23013a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23013a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReporterAidActivity_ViewBinding$b */
    class C6552b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReporterAidActivity f23015a;

        C6552b(ReporterAidActivity reporterAidActivity) {
            this.f23015a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23015a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReporterAidActivity_ViewBinding$c */
    class C6553c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReporterAidActivity f23017a;

        C6553c(ReporterAidActivity reporterAidActivity) {
            this.f23017a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23017a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReporterAidActivity_ViewBinding$d */
    class C6554d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReporterAidActivity f23019a;

        C6554d(ReporterAidActivity reporterAidActivity) {
            this.f23019a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23019a.onClick(view);
        }
    }

    @UiThread
    public ReporterAidActivity_ViewBinding(ReporterAidActivity reporterAidActivity) {
        this(reporterAidActivity, reporterAidActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReporterAidActivity reporterAidActivity = this.f23008a;
        if (reporterAidActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23008a = null;
        reporterAidActivity.mIvBack = null;
        reporterAidActivity.mTvTitle = null;
        reporterAidActivity.mTCbSelect = null;
        reporterAidActivity.mRedDot = null;
        this.f23009b.setOnClickListener(null);
        this.f23009b = null;
        this.f23010c.setOnClickListener(null);
        this.f23010c = null;
        this.f23011d.setOnClickListener(null);
        this.f23011d = null;
        this.f23012e.setOnClickListener(null);
        this.f23012e = null;
    }

    @UiThread
    public ReporterAidActivity_ViewBinding(ReporterAidActivity reporterAidActivity, View view) {
        this.f23008a = reporterAidActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reporterAidActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23009b = findRequiredView;
        findRequiredView.setOnClickListener(new C6551a(reporterAidActivity));
        reporterAidActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reporterAidActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, C2113R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        reporterAidActivity.mRedDot = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_red_dot, "field 'mRedDot'", ImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_report_record, "method 'onClick'");
        this.f23010c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6552b(reporterAidActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_rule, "method 'onClick'");
        this.f23011d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6553c(reporterAidActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.fl_confirm, "method 'onClick'");
        this.f23012e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6554d(reporterAidActivity));
    }
}
