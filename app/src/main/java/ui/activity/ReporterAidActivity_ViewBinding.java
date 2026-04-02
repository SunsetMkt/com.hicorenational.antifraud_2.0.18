package ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ReporterAidActivity_ViewBinding implements Unbinder {
    private ReporterAidActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13750e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReporterAidActivity a;

        a(ReporterAidActivity reporterAidActivity) {
            this.a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ReporterAidActivity a;

        b(ReporterAidActivity reporterAidActivity) {
            this.a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ ReporterAidActivity a;

        c(ReporterAidActivity reporterAidActivity) {
            this.a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ ReporterAidActivity a;

        d(ReporterAidActivity reporterAidActivity) {
            this.a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReporterAidActivity_ViewBinding(ReporterAidActivity reporterAidActivity) {
        this(reporterAidActivity, reporterAidActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReporterAidActivity reporterAidActivity = this.a;
        if (reporterAidActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reporterAidActivity.mIvBack = null;
        reporterAidActivity.mTvTitle = null;
        reporterAidActivity.mTCbSelect = null;
        reporterAidActivity.mRedDot = null;
        this.f13747b.setOnClickListener(null);
        this.f13747b = null;
        this.f13748c.setOnClickListener(null);
        this.f13748c = null;
        this.f13749d.setOnClickListener(null);
        this.f13749d = null;
        this.f13750e.setOnClickListener(null);
        this.f13750e = null;
    }

    @UiThread
    public ReporterAidActivity_ViewBinding(ReporterAidActivity reporterAidActivity, View view) {
        this.a = reporterAidActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reporterAidActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13747b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reporterAidActivity));
        reporterAidActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reporterAidActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        reporterAidActivity.mRedDot = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_red_dot, "field 'mRedDot'", ImageView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_report_record, "method 'onClick'");
        this.f13748c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reporterAidActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_rule, "method 'onClick'");
        this.f13749d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(reporterAidActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.fl_confirm, "method 'onClick'");
        this.f13750e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(reporterAidActivity));
    }
}
