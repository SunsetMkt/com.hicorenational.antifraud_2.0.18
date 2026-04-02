package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CallActivity_ViewBinding implements Unbinder {
    private CallActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13134e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CallActivity a;

        a(CallActivity callActivity) {
            this.a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CallActivity a;

        b(CallActivity callActivity) {
            this.a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CallActivity a;

        c(CallActivity callActivity) {
            this.a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CallActivity a;

        d(CallActivity callActivity) {
            this.a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CallActivity_ViewBinding(CallActivity callActivity) {
        this(callActivity, callActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CallActivity callActivity = this.a;
        if (callActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        callActivity.mTvTitle = null;
        callActivity.mRecyclerview = null;
        callActivity.mTvSelectTip = null;
        callActivity.mTvCommitTip = null;
        callActivity.mBtnCommit = null;
        callActivity.mTvInputTip = null;
        this.f13131b.setOnClickListener(null);
        this.f13131b = null;
        this.f13132c.setOnClickListener(null);
        this.f13132c = null;
        this.f13133d.setOnClickListener(null);
        this.f13133d = null;
        this.f13134e.setOnClickListener(null);
        this.f13134e = null;
    }

    @UiThread
    public CallActivity_ViewBinding(CallActivity callActivity, View view) {
        this.a = callActivity;
        callActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        callActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        callActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        callActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13131b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callActivity));
        callActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13132c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f13133d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(callActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_input, "method 'onViewClicked'");
        this.f13134e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(callActivity));
    }
}
