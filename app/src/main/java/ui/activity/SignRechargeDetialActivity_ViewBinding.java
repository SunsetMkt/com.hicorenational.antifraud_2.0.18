package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SignRechargeDetialActivity_ViewBinding implements Unbinder {
    private SignRechargeDetialActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13824b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignRechargeDetialActivity a;

        a(SignRechargeDetialActivity signRechargeDetialActivity) {
            this.a = signRechargeDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SignRechargeDetialActivity_ViewBinding(SignRechargeDetialActivity signRechargeDetialActivity) {
        this(signRechargeDetialActivity, signRechargeDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignRechargeDetialActivity signRechargeDetialActivity = this.a;
        if (signRechargeDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signRechargeDetialActivity.mTvTitle = null;
        signRechargeDetialActivity.mBtnConfirm = null;
        signRechargeDetialActivity.mEtRechargePlat = null;
        signRechargeDetialActivity.mEtRechargePlatName = null;
        signRechargeDetialActivity.mEtRechargePhone = null;
        signRechargeDetialActivity.mEtRechargeSum = null;
        signRechargeDetialActivity.mEtRechargeTime = null;
        this.f13824b.setOnClickListener(null);
        this.f13824b = null;
    }

    @UiThread
    public SignRechargeDetialActivity_ViewBinding(SignRechargeDetialActivity signRechargeDetialActivity, View view) {
        this.a = signRechargeDetialActivity;
        signRechargeDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signRechargeDetialActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        signRechargeDetialActivity.mEtRechargePlat = (TextView) Utils.findRequiredViewAsType(view, R.id.et_recharge_plat, "field 'mEtRechargePlat'", TextView.class);
        signRechargeDetialActivity.mEtRechargePlatName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_name, "field 'mEtRechargePlatName'", EditText.class);
        signRechargeDetialActivity.mEtRechargePhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_phone, "field 'mEtRechargePhone'", EditText.class);
        signRechargeDetialActivity.mEtRechargeSum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_sum, "field 'mEtRechargeSum'", EditText.class);
        signRechargeDetialActivity.mEtRechargeTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_recharge_time, "field 'mEtRechargeTime'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13824b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signRechargeDetialActivity));
    }
}
