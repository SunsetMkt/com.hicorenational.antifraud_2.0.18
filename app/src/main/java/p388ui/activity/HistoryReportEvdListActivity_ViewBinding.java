package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public class HistoryReportEvdListActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HistoryReportEvdListActivity f22399a;

    /* renamed from: b */
    private View f22400b;

    /* renamed from: c */
    private View f22401c;

    /* renamed from: ui.activity.HistoryReportEvdListActivity_ViewBinding$a */
    class C6333a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ HistoryReportEvdListActivity f22402a;

        C6333a(HistoryReportEvdListActivity historyReportEvdListActivity) {
            this.f22402a = historyReportEvdListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22402a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.HistoryReportEvdListActivity_ViewBinding$b */
    class C6334b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ HistoryReportEvdListActivity f22404a;

        C6334b(HistoryReportEvdListActivity historyReportEvdListActivity) {
            this.f22404a = historyReportEvdListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22404a.onViewClicked(view);
        }
    }

    @UiThread
    public HistoryReportEvdListActivity_ViewBinding(HistoryReportEvdListActivity historyReportEvdListActivity) {
        this(historyReportEvdListActivity, historyReportEvdListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HistoryReportEvdListActivity historyReportEvdListActivity = this.f22399a;
        if (historyReportEvdListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22399a = null;
        historyReportEvdListActivity.mTvTitle = null;
        historyReportEvdListActivity.mIvRight = null;
        historyReportEvdListActivity.mRecyclerview = null;
        historyReportEvdListActivity.mRefreshLayout = null;
        this.f22400b.setOnClickListener(null);
        this.f22400b = null;
        this.f22401c.setOnClickListener(null);
        this.f22401c = null;
    }

    @UiThread
    public HistoryReportEvdListActivity_ViewBinding(HistoryReportEvdListActivity historyReportEvdListActivity, View view) {
        this.f22399a = historyReportEvdListActivity;
        historyReportEvdListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        historyReportEvdListActivity.mIvRight = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f22400b = findRequiredView;
        findRequiredView.setOnClickListener(new C6333a(historyReportEvdListActivity));
        historyReportEvdListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        historyReportEvdListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22401c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6334b(historyReportEvdListActivity));
    }
}
