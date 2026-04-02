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
public class PayStopListActivity_ViewBinding implements Unbinder {
    private PayStopListActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13542e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PayStopListActivity a;

        a(PayStopListActivity payStopListActivity) {
            this.a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ PayStopListActivity a;

        b(PayStopListActivity payStopListActivity) {
            this.a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ PayStopListActivity a;

        c(PayStopListActivity payStopListActivity) {
            this.a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ PayStopListActivity a;

        d(PayStopListActivity payStopListActivity) {
            this.a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopListActivity_ViewBinding(PayStopListActivity payStopListActivity) {
        this(payStopListActivity, payStopListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopListActivity payStopListActivity = this.a;
        if (payStopListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        payStopListActivity.mTvTitle = null;
        payStopListActivity.mLine = null;
        payStopListActivity.mLlSelect = null;
        payStopListActivity.mLlInput = null;
        payStopListActivity.mRecyclerview = null;
        payStopListActivity.mBtnCommit = null;
        this.f13539b.setOnClickListener(null);
        this.f13539b = null;
        this.f13540c.setOnClickListener(null);
        this.f13540c = null;
        this.f13541d.setOnClickListener(null);
        this.f13541d = null;
        this.f13542e.setOnClickListener(null);
        this.f13542e = null;
    }

    @UiThread
    public PayStopListActivity_ViewBinding(PayStopListActivity payStopListActivity, View view) {
        this.a = payStopListActivity;
        payStopListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        payStopListActivity.mLine = Utils.findRequiredView(view, R.id.v_line, "field 'mLine'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_select, "field 'mLlSelect' and method 'onViewClicked'");
        payStopListActivity.mLlSelect = viewFindRequiredView;
        this.f13539b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(payStopListActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_input, "field 'mLlInput' and method 'onViewClicked'");
        payStopListActivity.mLlInput = viewFindRequiredView2;
        this.f13540c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(payStopListActivity));
        payStopListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopListActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13541d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(payStopListActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13542e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(payStopListActivity));
    }
}
