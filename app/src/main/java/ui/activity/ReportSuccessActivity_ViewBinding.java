package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ReportSuccessActivity_ViewBinding implements Unbinder {
    private ReportSuccessActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13732c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReportSuccessActivity a;

        a(ReportSuccessActivity reportSuccessActivity) {
            this.a = reportSuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ReportSuccessActivity a;

        b(ReportSuccessActivity reportSuccessActivity) {
            this.a = reportSuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportSuccessActivity_ViewBinding(ReportSuccessActivity reportSuccessActivity) {
        this(reportSuccessActivity, reportSuccessActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportSuccessActivity reportSuccessActivity = this.a;
        if (reportSuccessActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportSuccessActivity.mIvBack = null;
        reportSuccessActivity.mTvTitle = null;
        this.f13731b.setOnClickListener(null);
        this.f13731b = null;
        this.f13732c.setOnClickListener(null);
        this.f13732c = null;
    }

    @UiThread
    public ReportSuccessActivity_ViewBinding(ReportSuccessActivity reportSuccessActivity, View view) {
        this.a = reportSuccessActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportSuccessActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13731b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportSuccessActivity));
        reportSuccessActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.fl_confirm, "method 'onClick'");
        this.f13732c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportSuccessActivity));
    }
}
