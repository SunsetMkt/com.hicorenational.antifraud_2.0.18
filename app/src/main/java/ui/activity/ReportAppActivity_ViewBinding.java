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
public final class ReportAppActivity_ViewBinding implements Unbinder {
    private ReportAppActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13656c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReportAppActivity a;

        a(ReportAppActivity reportAppActivity) {
            this.a = reportAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ReportAppActivity a;

        b(ReportAppActivity reportAppActivity) {
            this.a = reportAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportAppActivity_ViewBinding(ReportAppActivity reportAppActivity) {
        this(reportAppActivity, reportAppActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportAppActivity reportAppActivity = this.a;
        if (reportAppActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportAppActivity.mIvBack = null;
        reportAppActivity.mTvTitle = null;
        reportAppActivity.mTvAdd = null;
        reportAppActivity.mRecycleView = null;
        this.f13655b.setOnClickListener(null);
        this.f13655b = null;
        this.f13656c.setOnClickListener(null);
        this.f13656c = null;
    }

    @UiThread
    public ReportAppActivity_ViewBinding(ReportAppActivity reportAppActivity, View view) {
        this.a = reportAppActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportAppActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13655b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportAppActivity));
        reportAppActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportAppActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportAppActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "method 'onClick'");
        this.f13656c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportAppActivity));
    }
}
