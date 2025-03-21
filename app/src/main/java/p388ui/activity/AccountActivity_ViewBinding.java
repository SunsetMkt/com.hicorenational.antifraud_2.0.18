package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AccountActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AccountActivity f21743a;

    /* renamed from: b */
    private View f21744b;

    /* renamed from: c */
    private View f21745c;

    /* renamed from: d */
    private View f21746d;

    /* renamed from: e */
    private View f21747e;

    /* renamed from: f */
    private View f21748f;

    /* renamed from: g */
    private View f21749g;

    /* renamed from: ui.activity.AccountActivity_ViewBinding$a */
    class C6100a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountActivity f21750a;

        C6100a(AccountActivity accountActivity) {
            this.f21750a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21750a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AccountActivity_ViewBinding$b */
    class C6101b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountActivity f21752a;

        C6101b(AccountActivity accountActivity) {
            this.f21752a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21752a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AccountActivity_ViewBinding$c */
    class C6102c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountActivity f21754a;

        C6102c(AccountActivity accountActivity) {
            this.f21754a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21754a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AccountActivity_ViewBinding$d */
    class C6103d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountActivity f21756a;

        C6103d(AccountActivity accountActivity) {
            this.f21756a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21756a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AccountActivity_ViewBinding$e */
    class C6104e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountActivity f21758a;

        C6104e(AccountActivity accountActivity) {
            this.f21758a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21758a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AccountActivity_ViewBinding$f */
    class C6105f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountActivity f21760a;

        C6105f(AccountActivity accountActivity) {
            this.f21760a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21760a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountActivity_ViewBinding(AccountActivity accountActivity) {
        this(accountActivity, accountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountActivity accountActivity = this.f21743a;
        if (accountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21743a = null;
        accountActivity.mTvTitle = null;
        accountActivity.mTvPaymentType = null;
        accountActivity.mTvTime = null;
        accountActivity.mLlAmount = null;
        accountActivity.mEtAmount = null;
        accountActivity.mTvVictimType = null;
        accountActivity.mEtVictimOther = null;
        accountActivity.mEtVictimAccount = null;
        accountActivity.mTvSuspectType = null;
        accountActivity.mEtSuspectOther = null;
        accountActivity.mEtSuspectAccountName = null;
        accountActivity.mEtSuspectAccount = null;
        accountActivity.scrollView = null;
        accountActivity.mRecyclerview = null;
        accountActivity.mTvTip = null;
        accountActivity.mGroupVictim = null;
        accountActivity.mGroupSuspect = null;
        accountActivity.mTvConfirm = null;
        this.f21744b.setOnClickListener(null);
        this.f21744b = null;
        this.f21745c.setOnClickListener(null);
        this.f21745c = null;
        this.f21746d.setOnClickListener(null);
        this.f21746d = null;
        this.f21747e.setOnClickListener(null);
        this.f21747e = null;
        this.f21748f.setOnClickListener(null);
        this.f21748f = null;
        this.f21749g.setOnClickListener(null);
        this.f21749g = null;
    }

    @UiThread
    public AccountActivity_ViewBinding(AccountActivity accountActivity, View view) {
        this.f21743a = accountActivity;
        accountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_payment_type, "field 'mTvPaymentType' and method 'onViewClicked'");
        accountActivity.mTvPaymentType = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_payment_type, "field 'mTvPaymentType'", TextView.class);
        this.f21744b = findRequiredView;
        findRequiredView.setOnClickListener(new C6100a(accountActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        accountActivity.mTvTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f21745c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6101b(accountActivity));
        accountActivity.mLlAmount = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_amount, "field 'mLlAmount'", LinearLayout.class);
        accountActivity.mEtAmount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_amount, "field 'mEtAmount'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_victim_type, "field 'mTvVictimType' and method 'onViewClicked'");
        accountActivity.mTvVictimType = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_victim_type, "field 'mTvVictimType'", TextView.class);
        this.f21746d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6102c(accountActivity));
        accountActivity.mEtVictimOther = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_victim_other, "field 'mEtVictimOther'", EditText.class);
        accountActivity.mEtVictimAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_victim_account, "field 'mEtVictimAccount'", EditText.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_suspect_type, "field 'mTvSuspectType' and method 'onViewClicked'");
        accountActivity.mTvSuspectType = (TextView) Utils.castView(findRequiredView4, C2113R.id.tv_suspect_type, "field 'mTvSuspectType'", TextView.class);
        this.f21747e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6103d(accountActivity));
        accountActivity.mEtSuspectOther = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_suspect_other, "field 'mEtSuspectOther'", EditText.class);
        accountActivity.mEtSuspectAccountName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_suspect_account_name, "field 'mEtSuspectAccountName'", EditText.class);
        accountActivity.mEtSuspectAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_suspect_account, "field 'mEtSuspectAccount'", EditText.class);
        accountActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, C2113R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        accountActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        accountActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip, "field 'mTvTip'", TextView.class);
        accountActivity.mGroupVictim = Utils.findRequiredView(view, C2113R.id.group_victim, "field 'mGroupVictim'");
        accountActivity.mGroupSuspect = Utils.findRequiredView(view, C2113R.id.group_suspect, "field 'mGroupSuspect'");
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.tv_confirm, "field 'mTvConfirm' and method 'onViewClicked'");
        accountActivity.mTvConfirm = (TextView) Utils.castView(findRequiredView5, C2113R.id.tv_confirm, "field 'mTvConfirm'", TextView.class);
        this.f21748f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6104e(accountActivity));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21749g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6105f(accountActivity));
    }
}
