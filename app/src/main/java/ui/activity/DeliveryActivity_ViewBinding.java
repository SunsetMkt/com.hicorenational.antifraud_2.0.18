package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DeliveryActivity_ViewBinding implements Unbinder {
    private DeliveryActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13340d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ DeliveryActivity a;

        a(DeliveryActivity deliveryActivity) {
            this.a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ DeliveryActivity a;

        b(DeliveryActivity deliveryActivity) {
            this.a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ DeliveryActivity a;

        c(DeliveryActivity deliveryActivity) {
            this.a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public DeliveryActivity_ViewBinding(DeliveryActivity deliveryActivity) {
        this(deliveryActivity, deliveryActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DeliveryActivity deliveryActivity = this.a;
        if (deliveryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        deliveryActivity.mIvBack = null;
        deliveryActivity.mTvTitle = null;
        deliveryActivity.mLlAddLayout = null;
        deliveryActivity.mTvAdd = null;
        deliveryActivity.mRecycleView = null;
        deliveryActivity.mTvCommitTip = null;
        this.f13338b.setOnClickListener(null);
        this.f13338b = null;
        this.f13339c.setOnClickListener(null);
        this.f13339c = null;
        this.f13340d.setOnClickListener(null);
        this.f13340d = null;
    }

    @UiThread
    public DeliveryActivity_ViewBinding(DeliveryActivity deliveryActivity, View view) {
        this.a = deliveryActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        deliveryActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13338b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(deliveryActivity));
        deliveryActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        deliveryActivity.mLlAddLayout = viewFindRequiredView2;
        this.f13339c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(deliveryActivity));
        deliveryActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        deliveryActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        deliveryActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onClick'");
        this.f13340d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(deliveryActivity));
    }
}
