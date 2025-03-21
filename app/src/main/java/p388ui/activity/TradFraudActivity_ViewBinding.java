package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class TradFraudActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private TradFraudActivity f23302a;

    /* renamed from: b */
    private View f23303b;

    /* renamed from: c */
    private View f23304c;

    /* renamed from: d */
    private View f23305d;

    /* renamed from: e */
    private View f23306e;

    /* renamed from: f */
    private View f23307f;

    /* renamed from: ui.activity.TradFraudActivity_ViewBinding$a */
    class C6633a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradFraudActivity f23308a;

        C6633a(TradFraudActivity tradFraudActivity) {
            this.f23308a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23308a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.TradFraudActivity_ViewBinding$b */
    class C6634b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradFraudActivity f23310a;

        C6634b(TradFraudActivity tradFraudActivity) {
            this.f23310a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23310a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.TradFraudActivity_ViewBinding$c */
    class C6635c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradFraudActivity f23312a;

        C6635c(TradFraudActivity tradFraudActivity) {
            this.f23312a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23312a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.TradFraudActivity_ViewBinding$d */
    class C6636d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradFraudActivity f23314a;

        C6636d(TradFraudActivity tradFraudActivity) {
            this.f23314a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23314a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.TradFraudActivity_ViewBinding$e */
    class C6637e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradFraudActivity f23316a;

        C6637e(TradFraudActivity tradFraudActivity) {
            this.f23316a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23316a.onViewClicked(view);
        }
    }

    @UiThread
    public TradFraudActivity_ViewBinding(TradFraudActivity tradFraudActivity) {
        this(tradFraudActivity, tradFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TradFraudActivity tradFraudActivity = this.f23302a;
        if (tradFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23302a = null;
        tradFraudActivity.mTvTitle = null;
        tradFraudActivity.mTvAccName = null;
        tradFraudActivity.mRlOtherAcc = null;
        tradFraudActivity.mEtTagOther = null;
        tradFraudActivity.mTvAccNum = null;
        tradFraudActivity.mRegion = null;
        tradFraudActivity.mTvDuperyType = null;
        tradFraudActivity.mEtCaseDescribe = null;
        this.f23303b.setOnClickListener(null);
        this.f23303b = null;
        this.f23304c.setOnClickListener(null);
        this.f23304c = null;
        this.f23305d.setOnClickListener(null);
        this.f23305d = null;
        this.f23306e.setOnClickListener(null);
        this.f23306e = null;
        this.f23307f.setOnClickListener(null);
        this.f23307f = null;
    }

    @UiThread
    public TradFraudActivity_ViewBinding(TradFraudActivity tradFraudActivity, View view) {
        this.f23302a = tradFraudActivity;
        tradFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_account_name, "field 'mTvAccName' and method 'onViewClicked'");
        tradFraudActivity.mTvAccName = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_account_name, "field 'mTvAccName'", TextView.class);
        this.f23303b = findRequiredView;
        findRequiredView.setOnClickListener(new C6633a(tradFraudActivity));
        tradFraudActivity.mRlOtherAcc = Utils.findRequiredView(view, C2113R.id.rl_other_acc, "field 'mRlOtherAcc'");
        tradFraudActivity.mEtTagOther = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_tag_other, "field 'mEtTagOther'", EditText.class);
        tradFraudActivity.mTvAccNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.trad_fraud_num, "field 'mTvAccNum'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.region, "field 'mRegion' and method 'onViewClicked'");
        tradFraudActivity.mRegion = (TextView) Utils.castView(findRequiredView2, C2113R.id.region, "field 'mRegion'", TextView.class);
        this.f23304c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6634b(tradFraudActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_dupery_type, "field 'mTvDuperyType' and method 'onViewClicked'");
        tradFraudActivity.mTvDuperyType = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_dupery_type, "field 'mTvDuperyType'", TextView.class);
        this.f23305d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6635c(tradFraudActivity));
        tradFraudActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_case_describe, "field 'mEtCaseDescribe'", EditText.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23306e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6636d(tradFraudActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onViewClicked'");
        this.f23307f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6637e(tradFraudActivity));
    }
}
