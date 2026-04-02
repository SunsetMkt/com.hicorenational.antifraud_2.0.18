package ui.activity;

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
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DeliveryAddActivity_ViewBinding implements Unbinder {
    private DeliveryAddActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13349e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ DeliveryAddActivity a;

        a(DeliveryAddActivity deliveryAddActivity) {
            this.a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ DeliveryAddActivity a;

        b(DeliveryAddActivity deliveryAddActivity) {
            this.a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ DeliveryAddActivity a;

        c(DeliveryAddActivity deliveryAddActivity) {
            this.a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ DeliveryAddActivity a;

        d(DeliveryAddActivity deliveryAddActivity) {
            this.a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public DeliveryAddActivity_ViewBinding(DeliveryAddActivity deliveryAddActivity) {
        this(deliveryAddActivity, deliveryAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DeliveryAddActivity deliveryAddActivity = this.a;
        if (deliveryAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
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
        this.f13346b.setOnClickListener(null);
        this.f13346b = null;
        this.f13347c.setOnClickListener(null);
        this.f13347c = null;
        this.f13348d.setOnClickListener(null);
        this.f13348d = null;
        this.f13349e.setOnClickListener(null);
        this.f13349e = null;
    }

    @UiThread
    public DeliveryAddActivity_ViewBinding(DeliveryAddActivity deliveryAddActivity, View view) {
        this.a = deliveryAddActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        deliveryAddActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13346b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(deliveryAddActivity));
        deliveryAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        deliveryAddActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f13347c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(deliveryAddActivity));
        deliveryAddActivity.mEtDeliveryNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_num, "field 'mEtDeliveryNum'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_delivery_plat, "field 'mTvDeliveryPlat' and method 'onViewClicked'");
        deliveryAddActivity.mTvDeliveryPlat = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_delivery_plat, "field 'mTvDeliveryPlat'", TextView.class);
        this.f13348d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(deliveryAddActivity));
        deliveryAddActivity.mLlDeliveryPlat = Utils.findRequiredView(view, R.id.ll_delivery_plat, "field 'mLlDeliveryPlat'");
        deliveryAddActivity.mEtPlatName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_name, "field 'mEtPlatName'", EditText.class);
        deliveryAddActivity.mEtDeliveryName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_sender, "field 'mEtDeliveryName'", EditText.class);
        deliveryAddActivity.mEtDeliveryPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_phone, "field 'mEtDeliveryPhone'", EditText.class);
        deliveryAddActivity.mEtDeliveryAddress = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_address, "field 'mEtDeliveryAddress'", EditText.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_delivery_time, "field 'mTvDeliveryTime' and method 'onViewClicked'");
        deliveryAddActivity.mTvDeliveryTime = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_delivery_time, "field 'mTvDeliveryTime'", TextView.class);
        this.f13349e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(deliveryAddActivity));
        deliveryAddActivity.mEtDeliveryWp = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_wp, "field 'mEtDeliveryWp'", EditText.class);
        deliveryAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        deliveryAddActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
