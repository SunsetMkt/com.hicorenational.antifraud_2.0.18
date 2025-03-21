package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class PaymentTypeActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PaymentTypeActivity f22653a;

    /* renamed from: b */
    private View f22654b;

    /* renamed from: ui.activity.PaymentTypeActivity_ViewBinding$a */
    class C6419a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PaymentTypeActivity f22655a;

        C6419a(PaymentTypeActivity paymentTypeActivity) {
            this.f22655a = paymentTypeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22655a.onViewClicked(view);
        }
    }

    @UiThread
    public PaymentTypeActivity_ViewBinding(PaymentTypeActivity paymentTypeActivity) {
        this(paymentTypeActivity, paymentTypeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PaymentTypeActivity paymentTypeActivity = this.f22653a;
        if (paymentTypeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22653a = null;
        paymentTypeActivity.mTvTitle = null;
        paymentTypeActivity.mRecyclerview = null;
        this.f22654b.setOnClickListener(null);
        this.f22654b = null;
    }

    @UiThread
    public PaymentTypeActivity_ViewBinding(PaymentTypeActivity paymentTypeActivity, View view) {
        this.f22653a = paymentTypeActivity;
        paymentTypeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        paymentTypeActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22654b = findRequiredView;
        findRequiredView.setOnClickListener(new C6419a(paymentTypeActivity));
    }
}
