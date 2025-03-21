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
public final class SignDeliveryDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignDeliveryDetailActivity f23135a;

    /* renamed from: b */
    private View f23136b;

    /* renamed from: ui.activity.SignDeliveryDetailActivity_ViewBinding$a */
    class C6587a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignDeliveryDetailActivity f23137a;

        C6587a(SignDeliveryDetailActivity signDeliveryDetailActivity) {
            this.f23137a = signDeliveryDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23137a.onViewClicked(view);
        }
    }

    @UiThread
    public SignDeliveryDetailActivity_ViewBinding(SignDeliveryDetailActivity signDeliveryDetailActivity) {
        this(signDeliveryDetailActivity, signDeliveryDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignDeliveryDetailActivity signDeliveryDetailActivity = this.f23135a;
        if (signDeliveryDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23135a = null;
        signDeliveryDetailActivity.mIvBack = null;
        signDeliveryDetailActivity.mTvTitle = null;
        signDeliveryDetailActivity.mBtnConfirm = null;
        signDeliveryDetailActivity.mEtDeliveryNum = null;
        signDeliveryDetailActivity.mTvDeliveryPlat = null;
        signDeliveryDetailActivity.mEtDeliveryName = null;
        signDeliveryDetailActivity.mEtDeliveryPhone = null;
        signDeliveryDetailActivity.mEtDeliveryAddress = null;
        signDeliveryDetailActivity.mTvDeliveryTime = null;
        signDeliveryDetailActivity.mEtDeliveryWp = null;
        signDeliveryDetailActivity.scrollView = null;
        signDeliveryDetailActivity.mLlWlPic = null;
        signDeliveryDetailActivity.mRecyView = null;
        this.f23136b.setOnClickListener(null);
        this.f23136b = null;
    }

    @UiThread
    public SignDeliveryDetailActivity_ViewBinding(SignDeliveryDetailActivity signDeliveryDetailActivity, View view) {
        this.f23135a = signDeliveryDetailActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        signDeliveryDetailActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23136b = findRequiredView;
        findRequiredView.setOnClickListener(new C6587a(signDeliveryDetailActivity));
        signDeliveryDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signDeliveryDetailActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, C2113R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        signDeliveryDetailActivity.mEtDeliveryNum = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_num, "field 'mEtDeliveryNum'", EditText.class);
        signDeliveryDetailActivity.mTvDeliveryPlat = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_delivery_plat, "field 'mTvDeliveryPlat'", TextView.class);
        signDeliveryDetailActivity.mEtDeliveryName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_sender, "field 'mEtDeliveryName'", EditText.class);
        signDeliveryDetailActivity.mEtDeliveryPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_phone, "field 'mEtDeliveryPhone'", EditText.class);
        signDeliveryDetailActivity.mEtDeliveryAddress = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_address, "field 'mEtDeliveryAddress'", EditText.class);
        signDeliveryDetailActivity.mTvDeliveryTime = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_delivery_time, "field 'mTvDeliveryTime'", TextView.class);
        signDeliveryDetailActivity.mEtDeliveryWp = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_delivery_wp, "field 'mEtDeliveryWp'", EditText.class);
        signDeliveryDetailActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, C2113R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        signDeliveryDetailActivity.mLlWlPic = Utils.findRequiredView(view, C2113R.id.ll_wu_pic, "field 'mLlWlPic'");
        signDeliveryDetailActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
