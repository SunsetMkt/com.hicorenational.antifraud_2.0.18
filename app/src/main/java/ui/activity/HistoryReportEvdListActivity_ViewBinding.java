package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes2.dex */
public class HistoryReportEvdListActivity_ViewBinding implements Unbinder {
    private HistoryReportEvdListActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13417c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ HistoryReportEvdListActivity a;

        a(HistoryReportEvdListActivity historyReportEvdListActivity) {
            this.a = historyReportEvdListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ HistoryReportEvdListActivity a;

        b(HistoryReportEvdListActivity historyReportEvdListActivity) {
            this.a = historyReportEvdListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public HistoryReportEvdListActivity_ViewBinding(HistoryReportEvdListActivity historyReportEvdListActivity) {
        this(historyReportEvdListActivity, historyReportEvdListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HistoryReportEvdListActivity historyReportEvdListActivity = this.a;
        if (historyReportEvdListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        historyReportEvdListActivity.mTvTitle = null;
        historyReportEvdListActivity.mIvRight = null;
        historyReportEvdListActivity.mRecyclerview = null;
        historyReportEvdListActivity.mRefreshLayout = null;
        this.f13416b.setOnClickListener(null);
        this.f13416b = null;
        this.f13417c.setOnClickListener(null);
        this.f13417c = null;
    }

    @UiThread
    public HistoryReportEvdListActivity_ViewBinding(HistoryReportEvdListActivity historyReportEvdListActivity, View view) {
        this.a = historyReportEvdListActivity;
        historyReportEvdListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        historyReportEvdListActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f13416b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(historyReportEvdListActivity));
        historyReportEvdListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        historyReportEvdListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13417c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(historyReportEvdListActivity));
    }
}
