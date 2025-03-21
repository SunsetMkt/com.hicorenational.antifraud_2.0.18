package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class SignRechargeDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignRechargeDetialActivity f23143a;

    /* renamed from: b */
    private View f23144b;

    /* renamed from: ui.activity.SignRechargeDetialActivity_ViewBinding$a */
    class C6589a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignRechargeDetialActivity f23145a;

        C6589a(SignRechargeDetialActivity signRechargeDetialActivity) {
            this.f23145a = signRechargeDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23145a.onViewClicked(view);
        }
    }

    @UiThread
    public SignRechargeDetialActivity_ViewBinding(SignRechargeDetialActivity signRechargeDetialActivity) {
        this(signRechargeDetialActivity, signRechargeDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignRechargeDetialActivity signRechargeDetialActivity = this.f23143a;
        if (signRechargeDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23143a = null;
        signRechargeDetialActivity.mTvTitle = null;
        signRechargeDetialActivity.mBtnConfirm = null;
        signRechargeDetialActivity.mEtRechargePlat = null;
        signRechargeDetialActivity.mEtRechargePlatName = null;
        signRechargeDetialActivity.mEtRechargePhone = null;
        signRechargeDetialActivity.mEtRechargeSum = null;
        signRechargeDetialActivity.mEtRechargeTime = null;
        this.f23144b.setOnClickListener(null);
        this.f23144b = null;
    }

    @UiThread
    public SignRechargeDetialActivity_ViewBinding(SignRechargeDetialActivity signRechargeDetialActivity, View view) {
        this.f23143a = signRechargeDetialActivity;
        signRechargeDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signRechargeDetialActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, C2113R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        signRechargeDetialActivity.mEtRechargePlat = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_recharge_plat, "field 'mEtRechargePlat'", TextView.class);
        signRechargeDetialActivity.mEtRechargePlatName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_recharge_name, "field 'mEtRechargePlatName'", EditText.class);
        signRechargeDetialActivity.mEtRechargePhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_recharge_phone, "field 'mEtRechargePhone'", EditText.class);
        signRechargeDetialActivity.mEtRechargeSum = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_recharge_sum, "field 'mEtRechargeSum'", EditText.class);
        signRechargeDetialActivity.mEtRechargeTime = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_recharge_time, "field 'mEtRechargeTime'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23144b = findRequiredView;
        findRequiredView.setOnClickListener(new C6589a(signRechargeDetialActivity));
    }
}
