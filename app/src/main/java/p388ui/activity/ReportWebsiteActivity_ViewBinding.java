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
public final class ReportWebsiteActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReportWebsiteActivity f22984a;

    /* renamed from: b */
    private View f22985b;

    /* renamed from: c */
    private View f22986c;

    /* renamed from: ui.activity.ReportWebsiteActivity_ViewBinding$a */
    class C6540a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportWebsiteActivity f22987a;

        C6540a(ReportWebsiteActivity reportWebsiteActivity) {
            this.f22987a = reportWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22987a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportWebsiteActivity_ViewBinding$b */
    class C6541b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportWebsiteActivity f22989a;

        C6541b(ReportWebsiteActivity reportWebsiteActivity) {
            this.f22989a = reportWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22989a.onClick(view);
        }
    }

    @UiThread
    public ReportWebsiteActivity_ViewBinding(ReportWebsiteActivity reportWebsiteActivity) {
        this(reportWebsiteActivity, reportWebsiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportWebsiteActivity reportWebsiteActivity = this.f22984a;
        if (reportWebsiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22984a = null;
        reportWebsiteActivity.mIvBack = null;
        reportWebsiteActivity.mTvTitle = null;
        reportWebsiteActivity.mLlAddLayout = null;
        reportWebsiteActivity.mTvAdd = null;
        reportWebsiteActivity.mRecycleView = null;
        this.f22985b.setOnClickListener(null);
        this.f22985b = null;
        this.f22986c.setOnClickListener(null);
        this.f22986c = null;
    }

    @UiThread
    public ReportWebsiteActivity_ViewBinding(ReportWebsiteActivity reportWebsiteActivity, View view) {
        this.f22984a = reportWebsiteActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportWebsiteActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22985b = findRequiredView;
        findRequiredView.setOnClickListener(new C6540a(reportWebsiteActivity));
        reportWebsiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        reportWebsiteActivity.mLlAddLayout = findRequiredView2;
        this.f22986c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6541b(reportWebsiteActivity));
        reportWebsiteActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportWebsiteActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
