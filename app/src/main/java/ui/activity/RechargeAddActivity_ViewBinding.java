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
public final class RechargeAddActivity_ViewBinding implements Unbinder {
    private RechargeAddActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13622e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ RechargeAddActivity a;

        a(RechargeAddActivity rechargeAddActivity) {
            this.a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ RechargeAddActivity a;

        b(RechargeAddActivity rechargeAddActivity) {
            this.a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ RechargeAddActivity a;

        c(RechargeAddActivity rechargeAddActivity) {
            this.a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ RechargeAddActivity a;

        d(RechargeAddActivity rechargeAddActivity) {
            this.a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public RechargeAddActivity_ViewBinding(RechargeAddActivity rechargeAddActivity) {
        this(rechargeAddActivity, rechargeAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeAddActivity rechargeAddActivity = this.a;
        if (rechargeAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        rechargeAddActivity.mTvTitle = null;
        rechargeAddActivity.mBtnConfirm = null;
        rechargeAddActivity.mEtRechargePlat = null;
        rechargeAddActivity.mLlOtherPlatName = null;
        rechargeAddActivity.mEtRechargePlatName = null;
        rechargeAddActivity.mEtRechargePhone = null;
        rechargeAddActivity.mEtRechargeSum = null;
        rechargeAddActivity.mEtRechargeTime = null;
        this.f13619b.setOnClickListener(null);
        this.f13619b = null;
        this.f13620c.setOnClickListener(null);
        this.f13620c = null;
        this.f13621d.setOnClickListener(null);
        this.f13621d = null;
        this.f13622e.setOnClickListener(null);
        this.f13622e = null;
    }

    @UiThread
    public RechargeAddActivity_ViewBinding(RechargeAddActivity rechargeAddActivity, View view) {
        this.a = rechargeAddActivity;
        rechargeAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        rechargeAddActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f13619b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(rechargeAddActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.et_recharge_plat, "field 'mEtRechargePlat' and method 'onViewClicked'");
        rechargeAddActivity.mEtRechargePlat = (TextView) Utils.castView(viewFindRequiredView2, R.id.et_recharge_plat, "field 'mEtRechargePlat'", TextView.class);
        this.f13620c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(rechargeAddActivity));
        rechargeAddActivity.mLlOtherPlatName = Utils.findRequiredView(view, R.id.ll_recharge_plat, "field 'mLlOtherPlatName'");
        rechargeAddActivity.mEtRechargePlatName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_name, "field 'mEtRechargePlatName'", EditText.class);
        rechargeAddActivity.mEtRechargePhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_phone, "field 'mEtRechargePhone'", EditText.class);
        rechargeAddActivity.mEtRechargeSum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_sum, "field 'mEtRechargeSum'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_recharge_time, "field 'mEtRechargeTime' and method 'onViewClicked'");
        rechargeAddActivity.mEtRechargeTime = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_recharge_time, "field 'mEtRechargeTime'", TextView.class);
        this.f13621d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(rechargeAddActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13622e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(rechargeAddActivity));
    }
}
