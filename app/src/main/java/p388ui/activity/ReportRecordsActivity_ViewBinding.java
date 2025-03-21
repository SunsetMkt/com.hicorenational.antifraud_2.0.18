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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public final class ReportRecordsActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReportRecordsActivity f22927a;

    /* renamed from: b */
    private View f22928b;

    /* renamed from: ui.activity.ReportRecordsActivity_ViewBinding$a */
    class C6521a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportRecordsActivity f22929a;

        C6521a(ReportRecordsActivity reportRecordsActivity) {
            this.f22929a = reportRecordsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22929a.onClick(view);
        }
    }

    @UiThread
    public ReportRecordsActivity_ViewBinding(ReportRecordsActivity reportRecordsActivity) {
        this(reportRecordsActivity, reportRecordsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportRecordsActivity reportRecordsActivity = this.f22927a;
        if (reportRecordsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22927a = null;
        reportRecordsActivity.mIvBack = null;
        reportRecordsActivity.mTvTitle = null;
        reportRecordsActivity.mRvList = null;
        reportRecordsActivity.mRefreshLayout = null;
        reportRecordsActivity.mLlNodata = null;
        this.f22928b.setOnClickListener(null);
        this.f22928b = null;
    }

    @UiThread
    public ReportRecordsActivity_ViewBinding(ReportRecordsActivity reportRecordsActivity, View view) {
        this.f22927a = reportRecordsActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportRecordsActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22928b = findRequiredView;
        findRequiredView.setOnClickListener(new C6521a(reportRecordsActivity));
        reportRecordsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportRecordsActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        reportRecordsActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        reportRecordsActivity.mLlNodata = Utils.findRequiredView(view, C2113R.id.ll_nodata, "field 'mLlNodata'");
    }
}
