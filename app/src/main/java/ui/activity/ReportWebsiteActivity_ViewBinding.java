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
public final class ReportWebsiteActivity_ViewBinding implements Unbinder {
    private ReportWebsiteActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13737c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReportWebsiteActivity a;

        a(ReportWebsiteActivity reportWebsiteActivity) {
            this.a = reportWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ReportWebsiteActivity a;

        b(ReportWebsiteActivity reportWebsiteActivity) {
            this.a = reportWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportWebsiteActivity_ViewBinding(ReportWebsiteActivity reportWebsiteActivity) {
        this(reportWebsiteActivity, reportWebsiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportWebsiteActivity reportWebsiteActivity = this.a;
        if (reportWebsiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportWebsiteActivity.mIvBack = null;
        reportWebsiteActivity.mTvTitle = null;
        reportWebsiteActivity.mLlAddLayout = null;
        reportWebsiteActivity.mTvAdd = null;
        reportWebsiteActivity.mRecycleView = null;
        this.f13736b.setOnClickListener(null);
        this.f13736b = null;
        this.f13737c.setOnClickListener(null);
        this.f13737c = null;
    }

    @UiThread
    public ReportWebsiteActivity_ViewBinding(ReportWebsiteActivity reportWebsiteActivity, View view) {
        this.a = reportWebsiteActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportWebsiteActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13736b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportWebsiteActivity));
        reportWebsiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        reportWebsiteActivity.mLlAddLayout = viewFindRequiredView2;
        this.f13737c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportWebsiteActivity));
        reportWebsiteActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportWebsiteActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
