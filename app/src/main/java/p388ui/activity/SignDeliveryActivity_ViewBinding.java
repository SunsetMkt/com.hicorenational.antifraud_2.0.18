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
public final class SignDeliveryActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignDeliveryActivity f23127a;

    /* renamed from: b */
    private View f23128b;

    /* renamed from: ui.activity.SignDeliveryActivity_ViewBinding$a */
    class C6586a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignDeliveryActivity f23129a;

        C6586a(SignDeliveryActivity signDeliveryActivity) {
            this.f23129a = signDeliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23129a.onClick(view);
        }
    }

    @UiThread
    public SignDeliveryActivity_ViewBinding(SignDeliveryActivity signDeliveryActivity) {
        this(signDeliveryActivity, signDeliveryActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignDeliveryActivity signDeliveryActivity = this.f23127a;
        if (signDeliveryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23127a = null;
        signDeliveryActivity.mIvBack = null;
        signDeliveryActivity.mTvTitle = null;
        signDeliveryActivity.mRecycleView = null;
        this.f23128b.setOnClickListener(null);
        this.f23128b = null;
    }

    @UiThread
    public SignDeliveryActivity_ViewBinding(SignDeliveryActivity signDeliveryActivity, View view) {
        this.f23127a = signDeliveryActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signDeliveryActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23128b = findRequiredView;
        findRequiredView.setOnClickListener(new C6586a(signDeliveryActivity));
        signDeliveryActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signDeliveryActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
