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
public final class ReportRecordsReplyActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReportRecordsReplyActivity f22933a;

    /* renamed from: b */
    private View f22934b;

    /* renamed from: ui.activity.ReportRecordsReplyActivity_ViewBinding$a */
    class C6523a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportRecordsReplyActivity f22935a;

        C6523a(ReportRecordsReplyActivity reportRecordsReplyActivity) {
            this.f22935a = reportRecordsReplyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22935a.onClick(view);
        }
    }

    @UiThread
    public ReportRecordsReplyActivity_ViewBinding(ReportRecordsReplyActivity reportRecordsReplyActivity) {
        this(reportRecordsReplyActivity, reportRecordsReplyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportRecordsReplyActivity reportRecordsReplyActivity = this.f22933a;
        if (reportRecordsReplyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22933a = null;
        reportRecordsReplyActivity.mIvBack = null;
        reportRecordsReplyActivity.mTvTitle = null;
        reportRecordsReplyActivity.mRvList = null;
        reportRecordsReplyActivity.mRefreshLayout = null;
        this.f22934b.setOnClickListener(null);
        this.f22934b = null;
    }

    @UiThread
    public ReportRecordsReplyActivity_ViewBinding(ReportRecordsReplyActivity reportRecordsReplyActivity, View view) {
        this.f22933a = reportRecordsReplyActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportRecordsReplyActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22934b = findRequiredView;
        findRequiredView.setOnClickListener(new C6523a(reportRecordsReplyActivity));
        reportRecordsReplyActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportRecordsReplyActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        reportRecordsReplyActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    }
}
