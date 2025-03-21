package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public final class ManualListActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ManualListActivity f22554a;

    /* renamed from: b */
    private View f22555b;

    /* renamed from: ui.activity.ManualListActivity_ViewBinding$a */
    class C6386a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ManualListActivity f22556a;

        C6386a(ManualListActivity manualListActivity) {
            this.f22556a = manualListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22556a.onClick(view);
        }
    }

    @UiThread
    public ManualListActivity_ViewBinding(ManualListActivity manualListActivity) {
        this(manualListActivity, manualListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ManualListActivity manualListActivity = this.f22554a;
        if (manualListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22554a = null;
        manualListActivity.mIvBack = null;
        manualListActivity.mTvTitle = null;
        manualListActivity.mNoImg = null;
        manualListActivity.mNoTip = null;
        manualListActivity.mClNoData = null;
        manualListActivity.mRvList = null;
        manualListActivity.mRefreshLayout = null;
        this.f22555b.setOnClickListener(null);
        this.f22555b = null;
    }

    @UiThread
    public ManualListActivity_ViewBinding(ManualListActivity manualListActivity, View view) {
        this.f22554a = manualListActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        manualListActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22555b = findRequiredView;
        findRequiredView.setOnClickListener(new C6386a(manualListActivity));
        manualListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        manualListActivity.mNoImg = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_img, "field 'mNoImg'", ImageView.class);
        manualListActivity.mNoTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip, "field 'mNoTip'", TextView.class);
        manualListActivity.mClNoData = (ConstraintLayout) Utils.findRequiredViewAsType(view, C2113R.id.cl_no_data, "field 'mClNoData'", ConstraintLayout.class);
        manualListActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        manualListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, C2113R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    }
}
