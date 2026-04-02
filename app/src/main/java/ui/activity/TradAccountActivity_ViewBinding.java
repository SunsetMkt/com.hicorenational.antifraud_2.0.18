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
public class TradAccountActivity_ViewBinding implements Unbinder {
    private TradAccountActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13914d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ TradAccountActivity a;

        a(TradAccountActivity tradAccountActivity) {
            this.a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ TradAccountActivity a;

        b(TradAccountActivity tradAccountActivity) {
            this.a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ TradAccountActivity a;

        c(TradAccountActivity tradAccountActivity) {
            this.a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public TradAccountActivity_ViewBinding(TradAccountActivity tradAccountActivity) {
        this(tradAccountActivity, tradAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TradAccountActivity tradAccountActivity = this.a;
        if (tradAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        tradAccountActivity.mTvTitle = null;
        tradAccountActivity.mRecyclerview = null;
        tradAccountActivity.mTvSelectTip = null;
        tradAccountActivity.mTvCommit = null;
        tradAccountActivity.mBtnCommit = null;
        this.f13912b.setOnClickListener(null);
        this.f13912b = null;
        this.f13913c.setOnClickListener(null);
        this.f13913c = null;
        this.f13914d.setOnClickListener(null);
        this.f13914d = null;
    }

    @UiThread
    public TradAccountActivity_ViewBinding(TradAccountActivity tradAccountActivity, View view) {
        this.a = tradAccountActivity;
        tradAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        tradAccountActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        tradAccountActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        tradAccountActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        tradAccountActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13912b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tradAccountActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13913c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(tradAccountActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f13914d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(tradAccountActivity));
    }
}
