package ui.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes2.dex */
public class AIInspectRecordActivity_ViewBinding implements Unbinder {
    private AIInspectRecordActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13028b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AIInspectRecordActivity a;

        a(AIInspectRecordActivity aIInspectRecordActivity) {
            this.a = aIInspectRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AIInspectRecordActivity_ViewBinding(AIInspectRecordActivity aIInspectRecordActivity) {
        this(aIInspectRecordActivity, aIInspectRecordActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AIInspectRecordActivity aIInspectRecordActivity = this.a;
        if (aIInspectRecordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        aIInspectRecordActivity.mTitleBg = null;
        aIInspectRecordActivity.mTvTitle = null;
        aIInspectRecordActivity.mRefreshLayout = null;
        aIInspectRecordActivity.mNoDataLayout = null;
        aIInspectRecordActivity.mRecyclerView = null;
        aIInspectRecordActivity.tvTip = null;
        this.f13028b.setOnClickListener(null);
        this.f13028b = null;
    }

    @UiThread
    public AIInspectRecordActivity_ViewBinding(AIInspectRecordActivity aIInspectRecordActivity, View view) {
        this.a = aIInspectRecordActivity;
        aIInspectRecordActivity.mTitleBg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mTitleBg'", RelativeLayout.class);
        aIInspectRecordActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        aIInspectRecordActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.mRefreshLayout, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        aIInspectRecordActivity.mNoDataLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_no_data, "field 'mNoDataLayout'", ConstraintLayout.class);
        aIInspectRecordActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.mRecyclerView, "field 'mRecyclerView'", RecyclerView.class);
        aIInspectRecordActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13028b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aIInspectRecordActivity));
    }
}
