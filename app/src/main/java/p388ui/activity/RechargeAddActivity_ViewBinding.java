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
public final class RechargeAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private RechargeAddActivity f22775a;

    /* renamed from: b */
    private View f22776b;

    /* renamed from: c */
    private View f22777c;

    /* renamed from: d */
    private View f22778d;

    /* renamed from: e */
    private View f22779e;

    /* renamed from: ui.activity.RechargeAddActivity_ViewBinding$a */
    class C6463a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RechargeAddActivity f22780a;

        C6463a(RechargeAddActivity rechargeAddActivity) {
            this.f22780a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22780a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RechargeAddActivity_ViewBinding$b */
    class C6464b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RechargeAddActivity f22782a;

        C6464b(RechargeAddActivity rechargeAddActivity) {
            this.f22782a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22782a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RechargeAddActivity_ViewBinding$c */
    class C6465c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RechargeAddActivity f22784a;

        C6465c(RechargeAddActivity rechargeAddActivity) {
            this.f22784a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22784a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RechargeAddActivity_ViewBinding$d */
    class C6466d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RechargeAddActivity f22786a;

        C6466d(RechargeAddActivity rechargeAddActivity) {
            this.f22786a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22786a.onViewClicked(view);
        }
    }

    @UiThread
    public RechargeAddActivity_ViewBinding(RechargeAddActivity rechargeAddActivity) {
        this(rechargeAddActivity, rechargeAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeAddActivity rechargeAddActivity = this.f22775a;
        if (rechargeAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22775a = null;
        rechargeAddActivity.mTvTitle = null;
        rechargeAddActivity.mBtnConfirm = null;
        rechargeAddActivity.mEtRechargePlat = null;
        rechargeAddActivity.mLlOtherPlatName = null;
        rechargeAddActivity.mEtRechargePlatName = null;
        rechargeAddActivity.mEtRechargePhone = null;
        rechargeAddActivity.mEtRechargeSum = null;
        rechargeAddActivity.mEtRechargeTime = null;
        this.f22776b.setOnClickListener(null);
        this.f22776b = null;
        this.f22777c.setOnClickListener(null);
        this.f22777c = null;
        this.f22778d.setOnClickListener(null);
        this.f22778d = null;
        this.f22779e.setOnClickListener(null);
        this.f22779e = null;
    }

    @UiThread
    public RechargeAddActivity_ViewBinding(RechargeAddActivity rechargeAddActivity, View view) {
        this.f22775a = rechargeAddActivity;
        rechargeAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        rechargeAddActivity.mBtnConfirm = (Button) Utils.castView(findRequiredView, C2113R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f22776b = findRequiredView;
        findRequiredView.setOnClickListener(new C6463a(rechargeAddActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.et_recharge_plat, "field 'mEtRechargePlat' and method 'onViewClicked'");
        rechargeAddActivity.mEtRechargePlat = (TextView) Utils.castView(findRequiredView2, C2113R.id.et_recharge_plat, "field 'mEtRechargePlat'", TextView.class);
        this.f22777c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6464b(rechargeAddActivity));
        rechargeAddActivity.mLlOtherPlatName = Utils.findRequiredView(view, C2113R.id.ll_recharge_plat, "field 'mLlOtherPlatName'");
        rechargeAddActivity.mEtRechargePlatName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_recharge_name, "field 'mEtRechargePlatName'", EditText.class);
        rechargeAddActivity.mEtRechargePhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_recharge_phone, "field 'mEtRechargePhone'", EditText.class);
        rechargeAddActivity.mEtRechargeSum = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_recharge_sum, "field 'mEtRechargeSum'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_recharge_time, "field 'mEtRechargeTime' and method 'onViewClicked'");
        rechargeAddActivity.mEtRechargeTime = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_recharge_time, "field 'mEtRechargeTime'", TextView.class);
        this.f22778d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6465c(rechargeAddActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22779e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6466d(rechargeAddActivity));
    }
}
