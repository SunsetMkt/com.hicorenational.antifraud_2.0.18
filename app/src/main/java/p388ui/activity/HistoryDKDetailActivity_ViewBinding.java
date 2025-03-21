package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class HistoryDKDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HistoryDKDetailActivity f22391a;

    /* renamed from: b */
    private View f22392b;

    /* renamed from: ui.activity.HistoryDKDetailActivity_ViewBinding$a */
    class C6331a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ HistoryDKDetailActivity f22393a;

        C6331a(HistoryDKDetailActivity historyDKDetailActivity) {
            this.f22393a = historyDKDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22393a.onViewClicked(view);
        }
    }

    @UiThread
    public HistoryDKDetailActivity_ViewBinding(HistoryDKDetailActivity historyDKDetailActivity) {
        this(historyDKDetailActivity, historyDKDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HistoryDKDetailActivity historyDKDetailActivity = this.f22391a;
        if (historyDKDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22391a = null;
        historyDKDetailActivity.mTvTitle = null;
        historyDKDetailActivity.mExpendList = null;
        this.f22392b.setOnClickListener(null);
        this.f22392b = null;
    }

    @UiThread
    public HistoryDKDetailActivity_ViewBinding(HistoryDKDetailActivity historyDKDetailActivity, View view) {
        this.f22391a = historyDKDetailActivity;
        historyDKDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        historyDKDetailActivity.mExpendList = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.expand_list, "field 'mExpendList'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22392b = findRequiredView;
        findRequiredView.setOnClickListener(new C6331a(historyDKDetailActivity));
    }
}
