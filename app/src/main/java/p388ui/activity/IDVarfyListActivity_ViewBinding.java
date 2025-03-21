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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public class IDVarfyListActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private IDVarfyListActivity f22417a;

    /* renamed from: b */
    private View f22418b;

    /* renamed from: ui.activity.IDVarfyListActivity_ViewBinding$a */
    class C6338a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ IDVarfyListActivity f22419a;

        C6338a(IDVarfyListActivity iDVarfyListActivity) {
            this.f22419a = iDVarfyListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22419a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfyListActivity_ViewBinding(IDVarfyListActivity iDVarfyListActivity) {
        this(iDVarfyListActivity, iDVarfyListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfyListActivity iDVarfyListActivity = this.f22417a;
        if (iDVarfyListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22417a = null;
        iDVarfyListActivity.mTvTitle = null;
        iDVarfyListActivity.mLlNodata = null;
        iDVarfyListActivity.mRecyclerview = null;
        iDVarfyListActivity.mRefreshLayout = null;
        this.f22418b.setOnClickListener(null);
        this.f22418b = null;
    }

    @UiThread
    public IDVarfyListActivity_ViewBinding(IDVarfyListActivity iDVarfyListActivity, View view) {
        this.f22417a = iDVarfyListActivity;
        iDVarfyListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        iDVarfyListActivity.mLlNodata = Utils.findRequiredView(view, C2113R.id.ll_nodata, "field 'mLlNodata'");
        iDVarfyListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        iDVarfyListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.sm_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22418b = findRequiredView;
        findRequiredView.setOnClickListener(new C6338a(iDVarfyListActivity));
    }
}
