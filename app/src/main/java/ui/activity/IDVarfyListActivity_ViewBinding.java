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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes2.dex */
public class IDVarfyListActivity_ViewBinding implements Unbinder {
    private IDVarfyListActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13426b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ IDVarfyListActivity a;

        a(IDVarfyListActivity iDVarfyListActivity) {
            this.a = iDVarfyListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfyListActivity_ViewBinding(IDVarfyListActivity iDVarfyListActivity) {
        this(iDVarfyListActivity, iDVarfyListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfyListActivity iDVarfyListActivity = this.a;
        if (iDVarfyListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        iDVarfyListActivity.mTvTitle = null;
        iDVarfyListActivity.mLlNodata = null;
        iDVarfyListActivity.mRecyclerview = null;
        iDVarfyListActivity.mRefreshLayout = null;
        this.f13426b.setOnClickListener(null);
        this.f13426b = null;
    }

    @UiThread
    public IDVarfyListActivity_ViewBinding(IDVarfyListActivity iDVarfyListActivity, View view) {
        this.a = iDVarfyListActivity;
        iDVarfyListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        iDVarfyListActivity.mLlNodata = Utils.findRequiredView(view, R.id.ll_nodata, "field 'mLlNodata'");
        iDVarfyListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        iDVarfyListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sm_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13426b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(iDVarfyListActivity));
    }
}
