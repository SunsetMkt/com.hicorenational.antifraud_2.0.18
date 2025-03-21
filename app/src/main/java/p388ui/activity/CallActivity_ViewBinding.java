package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class CallActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CallActivity f21899a;

    /* renamed from: b */
    private View f21900b;

    /* renamed from: c */
    private View f21901c;

    /* renamed from: d */
    private View f21902d;

    /* renamed from: e */
    private View f21903e;

    /* renamed from: ui.activity.CallActivity_ViewBinding$a */
    class C6157a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallActivity f21904a;

        C6157a(CallActivity callActivity) {
            this.f21904a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21904a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallActivity_ViewBinding$b */
    class C6158b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallActivity f21906a;

        C6158b(CallActivity callActivity) {
            this.f21906a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21906a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallActivity_ViewBinding$c */
    class C6159c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallActivity f21908a;

        C6159c(CallActivity callActivity) {
            this.f21908a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21908a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CallActivity_ViewBinding$d */
    class C6160d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CallActivity f21910a;

        C6160d(CallActivity callActivity) {
            this.f21910a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21910a.onViewClicked(view);
        }
    }

    @UiThread
    public CallActivity_ViewBinding(CallActivity callActivity) {
        this(callActivity, callActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CallActivity callActivity = this.f21899a;
        if (callActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21899a = null;
        callActivity.mTvTitle = null;
        callActivity.mRecyclerview = null;
        callActivity.mTvSelectTip = null;
        callActivity.mTvCommitTip = null;
        callActivity.mBtnCommit = null;
        callActivity.mTvInputTip = null;
        this.f21900b.setOnClickListener(null);
        this.f21900b = null;
        this.f21901c.setOnClickListener(null);
        this.f21901c = null;
        this.f21902d.setOnClickListener(null);
        this.f21902d = null;
        this.f21903e.setOnClickListener(null);
        this.f21903e = null;
    }

    @UiThread
    public CallActivity_ViewBinding(CallActivity callActivity, View view) {
        this.f21899a = callActivity;
        callActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        callActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        callActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        callActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f21900b = findRequiredView;
        findRequiredView.setOnClickListener(new C6157a(callActivity));
        callActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21901c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6158b(callActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_select, "method 'onViewClicked'");
        this.f21902d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6159c(callActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.ll_input, "method 'onViewClicked'");
        this.f21903e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6160d(callActivity));
    }
}
