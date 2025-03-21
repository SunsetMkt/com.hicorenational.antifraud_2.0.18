package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.RegionWheelView;

/* loaded from: classes2.dex */
public class AddressActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AddressActivity f21804a;

    /* renamed from: b */
    private View f21805b;

    /* renamed from: ui.activity.AddressActivity_ViewBinding$a */
    class C6119a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddressActivity f21806a;

        C6119a(AddressActivity addressActivity) {
            this.f21806a = addressActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21806a.onViewClicked(view);
        }
    }

    @UiThread
    public AddressActivity_ViewBinding(AddressActivity addressActivity) {
        this(addressActivity, addressActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddressActivity addressActivity = this.f21804a;
        if (addressActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21804a = null;
        addressActivity.mConfirm = null;
        addressActivity.mLlRegion = null;
        this.f21805b.setOnClickListener(null);
        this.f21805b = null;
    }

    @UiThread
    public AddressActivity_ViewBinding(AddressActivity addressActivity, View view) {
        this.f21804a = addressActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        addressActivity.mConfirm = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f21805b = findRequiredView;
        findRequiredView.setOnClickListener(new C6119a(addressActivity));
        addressActivity.mLlRegion = (RegionWheelView) Utils.findRequiredViewAsType(view, C2113R.id.ll_region, "field 'mLlRegion'", RegionWheelView.class);
    }
}
