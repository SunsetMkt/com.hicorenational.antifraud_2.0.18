package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class HistoryDKDetailActivity_ViewBinding implements Unbinder {
    private HistoryDKDetailActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13412b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ HistoryDKDetailActivity a;

        a(HistoryDKDetailActivity historyDKDetailActivity) {
            this.a = historyDKDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public HistoryDKDetailActivity_ViewBinding(HistoryDKDetailActivity historyDKDetailActivity) {
        this(historyDKDetailActivity, historyDKDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HistoryDKDetailActivity historyDKDetailActivity = this.a;
        if (historyDKDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        historyDKDetailActivity.mTvTitle = null;
        historyDKDetailActivity.mExpendList = null;
        this.f13412b.setOnClickListener(null);
        this.f13412b = null;
    }

    @UiThread
    public HistoryDKDetailActivity_ViewBinding(HistoryDKDetailActivity historyDKDetailActivity, View view) {
        this.a = historyDKDetailActivity;
        historyDKDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        historyDKDetailActivity.mExpendList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.expand_list, "field 'mExpendList'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13412b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(historyDKDetailActivity));
    }
}
