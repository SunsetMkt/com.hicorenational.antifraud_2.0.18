package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class CallNewActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CallNewActivity f21937a;

    /* renamed from: b */
    private View f21938b;

    /* renamed from: c */
    private View f21939c;

    /* renamed from: d */
    private View f21940d;

    /* renamed from: e */
    private View f21941e;

    /* renamed from: ui.activity.CallNewActivity_ViewBinding$a */
    class C6169a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallNewActivity f21942a;

        C6169a(CallNewActivity callNewActivity) {
            this.f21942a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21942a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallNewActivity_ViewBinding$b */
    class C6170b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallNewActivity f21944a;

        C6170b(CallNewActivity callNewActivity) {
            this.f21944a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21944a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallNewActivity_ViewBinding$c */
    class C6171c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallNewActivity f21946a;

        C6171c(CallNewActivity callNewActivity) {
            this.f21946a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21946a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallNewActivity_ViewBinding$d */
    class C6172d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallNewActivity f21948a;

        C6172d(CallNewActivity callNewActivity) {
            this.f21948a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21948a.onViewClicked(view);
        }
    }

    @UiThread
    public CallNewActivity_ViewBinding(CallNewActivity callNewActivity) {
        this(callNewActivity, callNewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallNewActivity callNewActivity = this.f21937a;
        if (callNewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21937a = null;
        callNewActivity.mTvTitle = null;
        callNewActivity.mRecyclerview = null;
        callNewActivity.mTvSelectTip = null;
        callNewActivity.mTvCommitTip = null;
        callNewActivity.mBtnCommit = null;
        callNewActivity.mTvInputTip = null;
        this.f21938b.setOnClickListener(null);
        this.f21938b = null;
        this.f21939c.setOnClickListener(null);
        this.f21939c = null;
        this.f21940d.setOnClickListener(null);
        this.f21940d = null;
        this.f21941e.setOnClickListener(null);
        this.f21941e = null;
    }

    @UiThread
    public CallNewActivity_ViewBinding(CallNewActivity callNewActivity, View view) {
        this.f21937a = callNewActivity;
        callNewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callNewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        callNewActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        callNewActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        callNewActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f21938b = findRequiredView;
        findRequiredView.setOnClickListener(new C6169a(callNewActivity));
        callNewActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21939c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6170b(callNewActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_select, "method 'onViewClicked'");
        this.f21940d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6171c(callNewActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.ll_input, "method 'onViewClicked'");
        this.f21941e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6172d(callNewActivity));
    }
}
