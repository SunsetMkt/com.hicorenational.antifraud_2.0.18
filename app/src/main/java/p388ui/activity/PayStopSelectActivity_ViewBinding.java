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
public class PayStopSelectActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PayStopSelectActivity f22646a;

    /* renamed from: b */
    private View f22647b;

    /* renamed from: c */
    private View f22648c;

    /* renamed from: ui.activity.PayStopSelectActivity_ViewBinding$a */
    class C6417a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopSelectActivity f22649a;

        C6417a(PayStopSelectActivity payStopSelectActivity) {
            this.f22649a = payStopSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22649a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PayStopSelectActivity_ViewBinding$b */
    class C6418b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PayStopSelectActivity f22651a;

        C6418b(PayStopSelectActivity payStopSelectActivity) {
            this.f22651a = payStopSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22651a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopSelectActivity_ViewBinding(PayStopSelectActivity payStopSelectActivity) {
        this(payStopSelectActivity, payStopSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopSelectActivity payStopSelectActivity = this.f22646a;
        if (payStopSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22646a = null;
        payStopSelectActivity.mTvTitle = null;
        payStopSelectActivity.mRecyclerview = null;
        payStopSelectActivity.mBtnCommit = null;
        this.f22647b.setOnClickListener(null);
        this.f22647b = null;
        this.f22648c.setOnClickListener(null);
        this.f22648c = null;
    }

    @UiThread
    public PayStopSelectActivity_ViewBinding(PayStopSelectActivity payStopSelectActivity, View view) {
        this.f22646a = payStopSelectActivity;
        payStopSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        payStopSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopSelectActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22647b = findRequiredView;
        findRequiredView.setOnClickListener(new C6417a(payStopSelectActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22648c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6418b(payStopSelectActivity));
    }
}
