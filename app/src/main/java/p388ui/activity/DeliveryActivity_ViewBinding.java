package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class DeliveryActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private DeliveryActivity f22259a;

    /* renamed from: b */
    private View f22260b;

    /* renamed from: c */
    private View f22261c;

    /* renamed from: d */
    private View f22262d;

    /* renamed from: ui.activity.DeliveryActivity_ViewBinding$a */
    class C6283a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ DeliveryActivity f22263a;

        C6283a(DeliveryActivity deliveryActivity) {
            this.f22263a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22263a.onClick(view);
        }
    }

    /* renamed from: ui.activity.DeliveryActivity_ViewBinding$b */
    class C6284b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ DeliveryActivity f22265a;

        C6284b(DeliveryActivity deliveryActivity) {
            this.f22265a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22265a.onClick(view);
        }
    }

    /* renamed from: ui.activity.DeliveryActivity_ViewBinding$c */
    class C6285c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ DeliveryActivity f22267a;

        C6285c(DeliveryActivity deliveryActivity) {
            this.f22267a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22267a.onClick(view);
        }
    }

    @UiThread
    public DeliveryActivity_ViewBinding(DeliveryActivity deliveryActivity) {
        this(deliveryActivity, deliveryActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DeliveryActivity deliveryActivity = this.f22259a;
        if (deliveryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22259a = null;
        deliveryActivity.mIvBack = null;
        deliveryActivity.mTvTitle = null;
        deliveryActivity.mLlAddLayout = null;
        deliveryActivity.mTvAdd = null;
        deliveryActivity.mRecycleView = null;
        deliveryActivity.mTvCommitTip = null;
        this.f22260b.setOnClickListener(null);
        this.f22260b = null;
        this.f22261c.setOnClickListener(null);
        this.f22261c = null;
        this.f22262d.setOnClickListener(null);
        this.f22262d = null;
    }

    @UiThread
    public DeliveryActivity_ViewBinding(DeliveryActivity deliveryActivity, View view) {
        this.f22259a = deliveryActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        deliveryActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22260b = findRequiredView;
        findRequiredView.setOnClickListener(new C6283a(deliveryActivity));
        deliveryActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        deliveryActivity.mLlAddLayout = findRequiredView2;
        this.f22261c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6284b(deliveryActivity));
        deliveryActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvAdd'", TextView.class);
        deliveryActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        deliveryActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onClick'");
        this.f22262d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6285c(deliveryActivity));
    }
}
