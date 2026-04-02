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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class ReportRecordsActivity_ViewBinding implements Unbinder {
    private ReportRecordsActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13702b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReportRecordsActivity a;

        a(ReportRecordsActivity reportRecordsActivity) {
            this.a = reportRecordsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportRecordsActivity_ViewBinding(ReportRecordsActivity reportRecordsActivity) {
        this(reportRecordsActivity, reportRecordsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportRecordsActivity reportRecordsActivity = this.a;
        if (reportRecordsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportRecordsActivity.mIvBack = null;
        reportRecordsActivity.mTvTitle = null;
        reportRecordsActivity.mRvList = null;
        reportRecordsActivity.mRefreshLayout = null;
        reportRecordsActivity.mLlNodata = null;
        this.f13702b.setOnClickListener(null);
        this.f13702b = null;
    }

    @UiThread
    public ReportRecordsActivity_ViewBinding(ReportRecordsActivity reportRecordsActivity, View view) {
        this.a = reportRecordsActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportRecordsActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13702b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportRecordsActivity));
        reportRecordsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportRecordsActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        reportRecordsActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        reportRecordsActivity.mLlNodata = Utils.findRequiredView(view, R.id.ll_nodata, "field 'mLlNodata'");
    }
}
