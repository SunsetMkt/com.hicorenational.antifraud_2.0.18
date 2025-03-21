package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CallRecordNewActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CallRecordNewActivity f21980a;

    /* renamed from: b */
    private View f21981b;

    /* renamed from: c */
    private View f21982c;

    /* renamed from: d */
    private View f21983d;

    /* renamed from: e */
    private View f21984e;

    /* renamed from: ui.activity.CallRecordNewActivity_ViewBinding$a */
    class C6177a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallRecordNewActivity f21985a;

        C6177a(CallRecordNewActivity callRecordNewActivity) {
            this.f21985a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21985a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallRecordNewActivity_ViewBinding$b */
    class C6178b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallRecordNewActivity f21987a;

        C6178b(CallRecordNewActivity callRecordNewActivity) {
            this.f21987a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21987a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallRecordNewActivity_ViewBinding$c */
    class C6179c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallRecordNewActivity f21989a;

        C6179c(CallRecordNewActivity callRecordNewActivity) {
            this.f21989a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21989a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallRecordNewActivity_ViewBinding$d */
    class C6180d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallRecordNewActivity f21991a;

        C6180d(CallRecordNewActivity callRecordNewActivity) {
            this.f21991a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21991a.onViewClicked(view);
        }
    }

    @UiThread
    public CallRecordNewActivity_ViewBinding(CallRecordNewActivity callRecordNewActivity) {
        this(callRecordNewActivity, callRecordNewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallRecordNewActivity callRecordNewActivity = this.f21980a;
        if (callRecordNewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21980a = null;
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
        this.f21981b.setOnClickListener(null);
        this.f21981b = null;
        this.f21982c.setOnClickListener(null);
        this.f21982c = null;
        this.f21983d.setOnClickListener(null);
        this.f21983d = null;
        this.f21984e.setOnClickListener(null);
        this.f21984e = null;
    }

    @UiThread
    public CallRecordNewActivity_ViewBinding(CallRecordNewActivity callRecordNewActivity, View view) {
        this.f21980a = callRecordNewActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        callRecordNewActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f21981b = findRequiredView;
        findRequiredView.setOnClickListener(new C6177a(callRecordNewActivity));
        callRecordNewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callRecordNewActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, C2113R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        callRecordNewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        callRecordNewActivity.mBtnReport = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f21982c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6178b(callRecordNewActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_child_tab_me, "field 'mTvChildTabMe' and method 'onViewClicked'");
        callRecordNewActivity.mTvChildTabMe = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_child_tab_me, "field 'mTvChildTabMe'", TextView.class);
        this.f21983d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6179c(callRecordNewActivity));
        callRecordNewActivity.mVMe = Utils.findRequiredView(view, C2113R.id.v_me, "field 'mVMe'");
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_child_tab_other, "field 'mTvChildTabOther' and method 'onViewClicked'");
        callRecordNewActivity.mTvChildTabOther = (TextView) Utils.castView(findRequiredView4, C2113R.id.tv_child_tab_other, "field 'mTvChildTabOther'", TextView.class);
        this.f21984e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6180d(callRecordNewActivity));
        callRecordNewActivity.mVOther = Utils.findRequiredView(view, C2113R.id.v_other, "field 'mVOther'");
        callRecordNewActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip, "field 'mTvTip'", TextView.class);
    }
}
