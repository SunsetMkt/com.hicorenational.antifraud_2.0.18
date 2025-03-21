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
public class IDVarfyAceptListActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private IDVarfyAceptListActivity f22406a;

    /* renamed from: b */
    private View f22407b;

    /* renamed from: ui.activity.IDVarfyAceptListActivity_ViewBinding$a */
    class C6335a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ IDVarfyAceptListActivity f22408a;

        C6335a(IDVarfyAceptListActivity iDVarfyAceptListActivity) {
            this.f22408a = iDVarfyAceptListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22408a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfyAceptListActivity_ViewBinding(IDVarfyAceptListActivity iDVarfyAceptListActivity) {
        this(iDVarfyAceptListActivity, iDVarfyAceptListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfyAceptListActivity iDVarfyAceptListActivity = this.f22406a;
        if (iDVarfyAceptListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22406a = null;
        iDVarfyAceptListActivity.mTvTitle = null;
        iDVarfyAceptListActivity.mLlNodata = null;
        iDVarfyAceptListActivity.mRecyclerview = null;
        iDVarfyAceptListActivity.mRefreshLayout = null;
        this.f22407b.setOnClickListener(null);
        this.f22407b = null;
    }

    @UiThread
    public IDVarfyAceptListActivity_ViewBinding(IDVarfyAceptListActivity iDVarfyAceptListActivity, View view) {
        this.f22406a = iDVarfyAceptListActivity;
        iDVarfyAceptListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        iDVarfyAceptListActivity.mLlNodata = Utils.findRequiredView(view, C2113R.id.ll_nodata, "field 'mLlNodata'");
        iDVarfyAceptListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        iDVarfyAceptListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.sm_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22407b = findRequiredView;
        findRequiredView.setOnClickListener(new C6335a(iDVarfyAceptListActivity));
    }
}
