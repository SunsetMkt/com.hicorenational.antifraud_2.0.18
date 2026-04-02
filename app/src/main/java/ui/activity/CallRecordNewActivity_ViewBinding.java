package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CallRecordNewActivity_ViewBinding implements Unbinder {
    private CallRecordNewActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13185e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CallRecordNewActivity a;

        a(CallRecordNewActivity callRecordNewActivity) {
            this.a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CallRecordNewActivity a;

        b(CallRecordNewActivity callRecordNewActivity) {
            this.a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CallRecordNewActivity a;

        c(CallRecordNewActivity callRecordNewActivity) {
            this.a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CallRecordNewActivity a;

        d(CallRecordNewActivity callRecordNewActivity) {
            this.a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CallRecordNewActivity_ViewBinding(CallRecordNewActivity callRecordNewActivity) {
        this(callRecordNewActivity, callRecordNewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallRecordNewActivity callRecordNewActivity = this.a;
        if (callRecordNewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        callRecordNewActivity.mIvBack = null;
        callRecordNewActivity.mTvTitle = null;
        callRecordNewActivity.mRlTitle = null;
        callRecordNewActivity.mRecyclerview = null;
        callRecordNewActivity.mBtnReport = null;
        callRecordNewActivity.mTvChildTabMe = null;
        callRecordNewActivity.mVMe = null;
        callRecordNewActivity.mTvChildTabOther = null;
        callRecordNewActivity.mVOther = null;
        callRecordNewActivity.mTvTip = null;
        this.f13182b.setOnClickListener(null);
        this.f13182b = null;
        this.f13183c.setOnClickListener(null);
        this.f13183c = null;
        this.f13184d.setOnClickListener(null);
        this.f13184d = null;
        this.f13185e.setOnClickListener(null);
        this.f13185e = null;
    }

    @UiThread
    public CallRecordNewActivity_ViewBinding(CallRecordNewActivity callRecordNewActivity, View view) {
        this.a = callRecordNewActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        callRecordNewActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13182b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callRecordNewActivity));
        callRecordNewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callRecordNewActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        callRecordNewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        callRecordNewActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f13183c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callRecordNewActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_child_tab_me, "field 'mTvChildTabMe' and method 'onViewClicked'");
        callRecordNewActivity.mTvChildTabMe = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_child_tab_me, "field 'mTvChildTabMe'", TextView.class);
        this.f13184d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(callRecordNewActivity));
        callRecordNewActivity.mVMe = Utils.findRequiredView(view, R.id.v_me, "field 'mVMe'");
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_child_tab_other, "field 'mTvChildTabOther' and method 'onViewClicked'");
        callRecordNewActivity.mTvChildTabOther = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_child_tab_other, "field 'mTvChildTabOther'", TextView.class);
        this.f13185e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(callRecordNewActivity));
        callRecordNewActivity.mVOther = Utils.findRequiredView(view, R.id.v_other, "field 'mVOther'");
        callRecordNewActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTvTip'", TextView.class);
    }
}
