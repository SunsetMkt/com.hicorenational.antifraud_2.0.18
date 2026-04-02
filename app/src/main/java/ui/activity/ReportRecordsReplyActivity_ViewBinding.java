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
public final class ReportRecordsReplyActivity_ViewBinding implements Unbinder {
    private ReportRecordsReplyActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13705b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReportRecordsReplyActivity a;

        a(ReportRecordsReplyActivity reportRecordsReplyActivity) {
            this.a = reportRecordsReplyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportRecordsReplyActivity_ViewBinding(ReportRecordsReplyActivity reportRecordsReplyActivity) {
        this(reportRecordsReplyActivity, reportRecordsReplyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportRecordsReplyActivity reportRecordsReplyActivity = this.a;
        if (reportRecordsReplyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportRecordsReplyActivity.mIvBack = null;
        reportRecordsReplyActivity.mTvTitle = null;
        reportRecordsReplyActivity.mRvList = null;
        reportRecordsReplyActivity.mRefreshLayout = null;
        this.f13705b.setOnClickListener(null);
        this.f13705b = null;
    }

    @UiThread
    public ReportRecordsReplyActivity_ViewBinding(ReportRecordsReplyActivity reportRecordsReplyActivity, View view) {
        this.a = reportRecordsReplyActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportRecordsReplyActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13705b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportRecordsReplyActivity));
        reportRecordsReplyActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportRecordsReplyActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        reportRecordsReplyActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    }
}
