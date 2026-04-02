package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class CallNewActivity_ViewBinding implements Unbinder {
    private CallNewActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13156e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CallNewActivity a;

        a(CallNewActivity callNewActivity) {
            this.a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CallNewActivity a;

        b(CallNewActivity callNewActivity) {
            this.a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CallNewActivity a;

        c(CallNewActivity callNewActivity) {
            this.a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CallNewActivity a;

        d(CallNewActivity callNewActivity) {
            this.a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CallNewActivity_ViewBinding(CallNewActivity callNewActivity) {
        this(callNewActivity, callNewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallNewActivity callNewActivity = this.a;
        if (callNewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        callNewActivity.mTvTitle = null;
        callNewActivity.mRecyclerview = null;
        callNewActivity.mTvSelectTip = null;
        callNewActivity.mTvCommitTip = null;
        callNewActivity.mBtnCommit = null;
        callNewActivity.mTvInputTip = null;
        this.f13153b.setOnClickListener(null);
        this.f13153b = null;
        this.f13154c.setOnClickListener(null);
        this.f13154c = null;
        this.f13155d.setOnClickListener(null);
        this.f13155d = null;
        this.f13156e.setOnClickListener(null);
        this.f13156e = null;
    }

    @UiThread
    public CallNewActivity_ViewBinding(CallNewActivity callNewActivity, View view) {
        this.a = callNewActivity;
        callNewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callNewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        callNewActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        callNewActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        callNewActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13153b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callNewActivity));
        callNewActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13154c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callNewActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f13155d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(callNewActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_input, "method 'onViewClicked'");
        this.f13156e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(callNewActivity));
    }
}
