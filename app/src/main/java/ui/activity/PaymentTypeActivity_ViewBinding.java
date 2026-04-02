package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentTypeActivity_ViewBinding implements Unbinder {
    private PaymentTypeActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13552b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PaymentTypeActivity a;

        a(PaymentTypeActivity paymentTypeActivity) {
            this.a = paymentTypeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public PaymentTypeActivity_ViewBinding(PaymentTypeActivity paymentTypeActivity) {
        this(paymentTypeActivity, paymentTypeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PaymentTypeActivity paymentTypeActivity = this.a;
        if (paymentTypeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        paymentTypeActivity.mTvTitle = null;
        paymentTypeActivity.mRecyclerview = null;
        this.f13552b.setOnClickListener(null);
        this.f13552b = null;
    }

    @UiThread
    public PaymentTypeActivity_ViewBinding(PaymentTypeActivity paymentTypeActivity, View view) {
        this.a = paymentTypeActivity;
        paymentTypeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        paymentTypeActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13552b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(paymentTypeActivity));
    }
}
