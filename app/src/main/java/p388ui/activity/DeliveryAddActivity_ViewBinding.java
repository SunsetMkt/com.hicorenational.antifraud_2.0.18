package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class DeliveryAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private DeliveryAddActivity f22277a;

    /* renamed from: b */
    private View f22278b;

    /* renamed from: c */
    private View f22279c;

    /* renamed from: d */
    private View f22280d;

    /* renamed from: e */
    private View f22281e;

    /* renamed from: ui.activity.DeliveryAddActivity_ViewBinding$a */
    class C6292a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ DeliveryAddActivity f22282a;

        C6292a(DeliveryAddActivity deliveryAddActivity) {
            this.f22282a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22282a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.DeliveryAddActivity_ViewBinding$b */
    class C6293b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ DeliveryAddActivity f22284a;

        C6293b(DeliveryAddActivity deliveryAddActivity) {
            this.f22284a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22284a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.DeliveryAddActivity_ViewBinding$c */
    class C6294c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ DeliveryAddActivity f22286a;

        C6294c(DeliveryAddActivity deliveryAddActivity) {
            this.f22286a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22286a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.DeliveryAddActivity_ViewBinding$d */
    class C6295d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ DeliveryAddActivity f22288a;

        C6295d(DeliveryAddActivity deliveryAddActivity) {
            this.f22288a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22288a.onViewClicked(view);
        }
    }

    @UiThread
    public DeliveryAddActivity_ViewBinding(DeliveryAddActivity deliveryAddActivity) {
        this(deliveryAddActivity, deliveryAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DeliveryAddActivity deliveryAddActivity = this.f22277a;
        if (deliveryAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22277a = null;
        deliveryAddActivity.mIvBack = null;
        deliveryAddActivity.mTvTitle = null;
        deliveryAddActivity.mBtnConfirm = null;
        deliveryAddActivity.mEtDeliveryNum = null;
        deliveryAddActivity.mTvDeliveryPlat = null;
        deliveryAddActivity.mLlDeliveryPlat = null;
        deliveryAddActivity.mEtPlatName = null;
        deliveryAddActivity.mEtDeliveryName = null;
        deliveryAddActivity.mEtDeliveryPhone = null;
        deliveryAddActivity.mEtDeliveryAddress = null;
        deliveryAddActivity.mTvDeliveryTime = null;
        deliveryAddActivity.mEtDeliveryWp = null;
        deliveryAddActivity.scrollView = null;
        deliveryAddActivity.mRecyView = null;
        this.f22278b.setOnClickListener(null);
        this.f22278b = null;
        this.f22279c.setOnClickListener(null);
        this.f22279c = null;
        this.f22280d.setOnClickListener(null);
        this.f22280d = null;
        this.f22281e.setOnClickListener(null);
        this.f22281e = null;
    }

    @UiThread
    public DeliveryAddActivity_ViewBinding(DeliveryAddActivity deliveryAddActivity, View view) {
        this.f22277a = deliveryAddActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        deliveryAddActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22278b = findRequiredView;
        findRequiredView.setOnClickListener(new C6292a(deliveryAddActivity));
        deliveryAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        deliveryAddActivity.mBtnConfirm = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f22279c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6293b(deliveryAddActivity));
        deliveryAddActivity.mEtDeliveryNum = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_num, "field 'mEtDeliveryNum'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_delivery_plat, "field 'mTvDeliveryPlat' and method 'onViewClicked'");
        deliveryAddActivity.mTvDeliveryPlat = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_delivery_plat, "field 'mTvDeliveryPlat'", TextView.class);
        this.f22280d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6294c(deliveryAddActivity));
        deliveryAddActivity.mLlDeliveryPlat = Utils.findRequiredView(view, C2113R.id.ll_delivery_plat, "field 'mLlDeliveryPlat'");
        deliveryAddActivity.mEtPlatName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_name, "field 'mEtPlatName'", EditText.class);
        deliveryAddActivity.mEtDeliveryName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_sender, "field 'mEtDeliveryName'", EditText.class);
        deliveryAddActivity.mEtDeliveryPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_phone, "field 'mEtDeliveryPhone'", EditText.class);
        deliveryAddActivity.mEtDeliveryAddress = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_address, "field 'mEtDeliveryAddress'", EditText.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_delivery_time, "field 'mTvDeliveryTime' and method 'onViewClicked'");
        deliveryAddActivity.mTvDeliveryTime = (TextView) Utils.castView(findRequiredView4, C2113R.id.tv_delivery_time, "field 'mTvDeliveryTime'", TextView.class);
        this.f22281e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6295d(deliveryAddActivity));
        deliveryAddActivity.mEtDeliveryWp = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_wp, "field 'mEtDeliveryWp'", EditText.class);
        deliveryAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, C2113R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        deliveryAddActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
