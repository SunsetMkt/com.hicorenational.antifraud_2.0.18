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
public final class ReportAppActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReportAppActivity f22840a;

    /* renamed from: b */
    private View f22841b;

    /* renamed from: c */
    private View f22842c;

    /* renamed from: ui.activity.ReportAppActivity_ViewBinding$a */
    class C6488a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportAppActivity f22843a;

        C6488a(ReportAppActivity reportAppActivity) {
            this.f22843a = reportAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22843a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportAppActivity_ViewBinding$b */
    class C6489b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportAppActivity f22845a;

        C6489b(ReportAppActivity reportAppActivity) {
            this.f22845a = reportAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22845a.onClick(view);
        }
    }

    @UiThread
    public ReportAppActivity_ViewBinding(ReportAppActivity reportAppActivity) {
        this(reportAppActivity, reportAppActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportAppActivity reportAppActivity = this.f22840a;
        if (reportAppActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22840a = null;
        reportAppActivity.mIvBack = null;
        reportAppActivity.mTvTitle = null;
        reportAppActivity.mTvAdd = null;
        reportAppActivity.mRecycleView = null;
        this.f22841b.setOnClickListener(null);
        this.f22841b = null;
        this.f22842c.setOnClickListener(null);
        this.f22842c = null;
    }

    @UiThread
    public ReportAppActivity_ViewBinding(ReportAppActivity reportAppActivity, View view) {
        this.f22840a = reportAppActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportAppActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22841b = findRequiredView;
        findRequiredView.setOnClickListener(new C6488a(reportAppActivity));
        reportAppActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportAppActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportAppActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_add, "method 'onClick'");
        this.f22842c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6489b(reportAppActivity));
    }
}
