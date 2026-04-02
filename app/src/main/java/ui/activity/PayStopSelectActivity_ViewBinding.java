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
public class PayStopSelectActivity_ViewBinding implements Unbinder {
    private PayStopSelectActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13549c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PayStopSelectActivity a;

        a(PayStopSelectActivity payStopSelectActivity) {
            this.a = payStopSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ PayStopSelectActivity a;

        b(PayStopSelectActivity payStopSelectActivity) {
            this.a = payStopSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopSelectActivity_ViewBinding(PayStopSelectActivity payStopSelectActivity) {
        this(payStopSelectActivity, payStopSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopSelectActivity payStopSelectActivity = this.a;
        if (payStopSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        payStopSelectActivity.mTvTitle = null;
        payStopSelectActivity.mRecyclerview = null;
        payStopSelectActivity.mBtnCommit = null;
        this.f13548b.setOnClickListener(null);
        this.f13548b = null;
        this.f13549c.setOnClickListener(null);
        this.f13549c = null;
    }

    @UiThread
    public PayStopSelectActivity_ViewBinding(PayStopSelectActivity payStopSelectActivity, View view) {
        this.a = payStopSelectActivity;
        payStopSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        payStopSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopSelectActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13548b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(payStopSelectActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13549c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(payStopSelectActivity));
    }
}
