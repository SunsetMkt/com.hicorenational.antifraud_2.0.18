package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.RegionWheelView;

/* JADX INFO: loaded from: classes2.dex */
public class AddressActivity_ViewBinding implements Unbinder {
    private AddressActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13084b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AddressActivity a;

        a(AddressActivity addressActivity) {
            this.a = addressActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AddressActivity_ViewBinding(AddressActivity addressActivity) {
        this(addressActivity, addressActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddressActivity addressActivity = this.a;
        if (addressActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        addressActivity.mConfirm = null;
        addressActivity.mLlRegion = null;
        this.f13084b.setOnClickListener(null);
        this.f13084b = null;
    }

    @UiThread
    public AddressActivity_ViewBinding(AddressActivity addressActivity, View view) {
        this.a = addressActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        addressActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f13084b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addressActivity));
        addressActivity.mLlRegion = (RegionWheelView) Utils.findRequiredViewAsType(view, R.id.ll_region, "field 'mLlRegion'", RegionWheelView.class);
    }
}
