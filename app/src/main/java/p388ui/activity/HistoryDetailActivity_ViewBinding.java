package p388ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class HistoryDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HistoryDetailActivity f22395a;

    /* renamed from: b */
    private View f22396b;

    /* renamed from: ui.activity.HistoryDetailActivity_ViewBinding$a */
    class C6332a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ HistoryDetailActivity f22397a;

        C6332a(HistoryDetailActivity historyDetailActivity) {
            this.f22397a = historyDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22397a.onViewClicked(view);
        }
    }

    @UiThread
    public HistoryDetailActivity_ViewBinding(HistoryDetailActivity historyDetailActivity) {
        this(historyDetailActivity, historyDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HistoryDetailActivity historyDetailActivity = this.f22395a;
        if (historyDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22395a = null;
        historyDetailActivity.mTvTitle = null;
        historyDetailActivity.mExpendList = null;
        historyDetailActivity.mCaseTip = null;
        historyDetailActivity.mCaseTegory = null;
        historyDetailActivity.mTvReportInfo = null;
        historyDetailActivity.mTvReportNum = null;
        historyDetailActivity.mTvSelf = null;
        historyDetailActivity.mTvCaseNum = null;
        historyDetailActivity.mTvReportTime = null;
        historyDetailActivity.mLlProgress = null;
        historyDetailActivity.mLlReportProgress = null;
        historyDetailActivity.mLlReportView = null;
        this.f22396b.setOnClickListener(null);
        this.f22396b = null;
    }

    @UiThread
    public HistoryDetailActivity_ViewBinding(HistoryDetailActivity historyDetailActivity, View view) {
        this.f22395a = historyDetailActivity;
        historyDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        historyDetailActivity.mExpendList = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mExpendList'", RecyclerView.class);
        historyDetailActivity.mCaseTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_case_type, "field 'mCaseTip'", TextView.class);
        historyDetailActivity.mCaseTegory = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.casecategory, "field 'mCaseTegory'", TextView.class);
        historyDetailActivity.mTvReportInfo = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_report_name, "field 'mTvReportInfo'", TextView.class);
        historyDetailActivity.mTvReportNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_report_num, "field 'mTvReportNum'", TextView.class);
        historyDetailActivity.mTvSelf = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_self, "field 'mTvSelf'", TextView.class);
        historyDetailActivity.mTvCaseNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_case_num, "field 'mTvCaseNum'", TextView.class);
        historyDetailActivity.mTvReportTime = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.report_time, "field 'mTvReportTime'", TextView.class);
        historyDetailActivity.mLlProgress = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_progress, "field 'mLlProgress'", LinearLayout.class);
        historyDetailActivity.mLlReportProgress = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_report_progress, "field 'mLlReportProgress'", LinearLayout.class);
        historyDetailActivity.mLlReportView = Utils.findRequiredView(view, C2113R.id.ll_report_view, "field 'mLlReportView'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22396b = findRequiredView;
        findRequiredView.setOnClickListener(new C6332a(historyDetailActivity));
    }
}
