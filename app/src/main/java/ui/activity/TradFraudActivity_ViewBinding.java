package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class TradFraudActivity_ViewBinding implements Unbinder {
    private TradFraudActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13929f;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ TradFraudActivity a;

        a(TradFraudActivity tradFraudActivity) {
            this.a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ TradFraudActivity a;

        b(TradFraudActivity tradFraudActivity) {
            this.a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ TradFraudActivity a;

        c(TradFraudActivity tradFraudActivity) {
            this.a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ TradFraudActivity a;

        d(TradFraudActivity tradFraudActivity) {
            this.a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ TradFraudActivity a;

        e(TradFraudActivity tradFraudActivity) {
            this.a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public TradFraudActivity_ViewBinding(TradFraudActivity tradFraudActivity) {
        this(tradFraudActivity, tradFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TradFraudActivity tradFraudActivity = this.a;
        if (tradFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        tradFraudActivity.mTvTitle = null;
        tradFraudActivity.mTvAccName = null;
        tradFraudActivity.mRlOtherAcc = null;
        tradFraudActivity.mEtTagOther = null;
        tradFraudActivity.mTvAccNum = null;
        tradFraudActivity.mRegion = null;
        tradFraudActivity.mTvDuperyType = null;
        tradFraudActivity.mEtCaseDescribe = null;
        this.f13925b.setOnClickListener(null);
        this.f13925b = null;
        this.f13926c.setOnClickListener(null);
        this.f13926c = null;
        this.f13927d.setOnClickListener(null);
        this.f13927d = null;
        this.f13928e.setOnClickListener(null);
        this.f13928e = null;
        this.f13929f.setOnClickListener(null);
        this.f13929f = null;
    }

    @UiThread
    public TradFraudActivity_ViewBinding(TradFraudActivity tradFraudActivity, View view) {
        this.a = tradFraudActivity;
        tradFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_account_name, "field 'mTvAccName' and method 'onViewClicked'");
        tradFraudActivity.mTvAccName = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_account_name, "field 'mTvAccName'", TextView.class);
        this.f13925b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tradFraudActivity));
        tradFraudActivity.mRlOtherAcc = Utils.findRequiredView(view, R.id.rl_other_acc, "field 'mRlOtherAcc'");
        tradFraudActivity.mEtTagOther = (EditText) Utils.findRequiredViewAsType(view, R.id.et_tag_other, "field 'mEtTagOther'", EditText.class);
        tradFraudActivity.mTvAccNum = (TextView) Utils.findRequiredViewAsType(view, R.id.trad_fraud_num, "field 'mTvAccNum'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.region, "field 'mRegion' and method 'onViewClicked'");
        tradFraudActivity.mRegion = (TextView) Utils.castView(viewFindRequiredView2, R.id.region, "field 'mRegion'", TextView.class);
        this.f13926c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(tradFraudActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_dupery_type, "field 'mTvDuperyType' and method 'onViewClicked'");
        tradFraudActivity.mTvDuperyType = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_dupery_type, "field 'mTvDuperyType'", TextView.class);
        this.f13927d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(tradFraudActivity));
        tradFraudActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_case_describe, "field 'mEtCaseDescribe'", EditText.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13928e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(tradFraudActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onViewClicked'");
        this.f13929f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(tradFraudActivity));
    }
}
