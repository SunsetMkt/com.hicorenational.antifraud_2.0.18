package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: classes2.dex */
public class TradAccountEditActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private TradAccountEditActivity f23294a;

    /* renamed from: b */
    private View f23295b;

    /* renamed from: c */
    private View f23296c;

    /* renamed from: ui.activity.TradAccountEditActivity_ViewBinding$a */
    class C6630a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradAccountEditActivity f23297a;

        C6630a(TradAccountEditActivity tradAccountEditActivity) {
            this.f23297a = tradAccountEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23297a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.TradAccountEditActivity_ViewBinding$b */
    class C6631b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TradAccountEditActivity f23299a;

        C6631b(TradAccountEditActivity tradAccountEditActivity) {
            this.f23299a = tradAccountEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23299a.onViewClicked(view);
        }
    }

    @UiThread
    public TradAccountEditActivity_ViewBinding(TradAccountEditActivity tradAccountEditActivity) {
        this(tradAccountEditActivity, tradAccountEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TradAccountEditActivity tradAccountEditActivity = this.f23294a;
        if (tradAccountEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23294a = null;
        tradAccountEditActivity.mTvTitle = null;
        tradAccountEditActivity.mFlowLayout = null;
        tradAccountEditActivity.mTvAccName = null;
        tradAccountEditActivity.mEtAccount = null;
        tradAccountEditActivity.mLlAccNorm = null;
        tradAccountEditActivity.mEtTagOther = null;
        tradAccountEditActivity.mEtAccountOther = null;
        tradAccountEditActivity.mLlAccOther = null;
        this.f23295b.setOnClickListener(null);
        this.f23295b = null;
        this.f23296c.setOnClickListener(null);
        this.f23296c = null;
    }

    @UiThread
    public TradAccountEditActivity_ViewBinding(TradAccountEditActivity tradAccountEditActivity, View view) {
        this.f23294a = tradAccountEditActivity;
        tradAccountEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        tradAccountEditActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, C2113R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        tradAccountEditActivity.mTvAccName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_acc_name, "field 'mTvAccName'", TextView.class);
        tradAccountEditActivity.mEtAccount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_account, "field 'mEtAccount'", TextView.class);
        tradAccountEditActivity.mLlAccNorm = Utils.findRequiredView(view, C2113R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        tradAccountEditActivity.mEtTagOther = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_tag_other, "field 'mEtTagOther'", TextView.class);
        tradAccountEditActivity.mEtAccountOther = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_account_other, "field 'mEtAccountOther'", TextView.class);
        tradAccountEditActivity.mLlAccOther = Utils.findRequiredView(view, C2113R.id.ll_acc_other, "field 'mLlAccOther'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23295b = findRequiredView;
        findRequiredView.setOnClickListener(new C6630a(tradAccountEditActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onViewClicked'");
        this.f23296c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6631b(tradAccountEditActivity));
    }
}
