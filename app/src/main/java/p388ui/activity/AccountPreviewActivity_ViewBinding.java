package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AccountPreviewActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AccountPreviewActivity f21775a;

    /* renamed from: b */
    private View f21776b;

    /* renamed from: ui.activity.AccountPreviewActivity_ViewBinding$a */
    class C6110a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountPreviewActivity f21777a;

        C6110a(AccountPreviewActivity accountPreviewActivity) {
            this.f21777a = accountPreviewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21777a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountPreviewActivity_ViewBinding(AccountPreviewActivity accountPreviewActivity) {
        this(accountPreviewActivity, accountPreviewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountPreviewActivity accountPreviewActivity = this.f21775a;
        if (accountPreviewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21775a = null;
        accountPreviewActivity.mTvTitle = null;
        accountPreviewActivity.mTvPaymentType = null;
        accountPreviewActivity.mTvTime = null;
        accountPreviewActivity.mTvVictimTypeXing = null;
        accountPreviewActivity.mTvVictimAccXing = null;
        accountPreviewActivity.mTvVictimType = null;
        accountPreviewActivity.mEtVictimOther = null;
        accountPreviewActivity.mEtVictimAccount = null;
        accountPreviewActivity.mTvSuspectType = null;
        accountPreviewActivity.mEtSuspectOther = null;
        accountPreviewActivity.mEtSuspectAccountName = null;
        accountPreviewActivity.mEtSuspectAccount = null;
        accountPreviewActivity.mLlPictures = null;
        accountPreviewActivity.mRecyclerview = null;
        accountPreviewActivity.mGroupVictim = null;
        accountPreviewActivity.mGroupSuspect = null;
        accountPreviewActivity.mGroupSuspectName = null;
        accountPreviewActivity.mGroupAmount = null;
        accountPreviewActivity.mTvAmount = null;
        this.f21776b.setOnClickListener(null);
        this.f21776b = null;
    }

    @UiThread
    public AccountPreviewActivity_ViewBinding(AccountPreviewActivity accountPreviewActivity, View view) {
        this.f21775a = accountPreviewActivity;
        accountPreviewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        accountPreviewActivity.mTvPaymentType = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_payment_type, "field 'mTvPaymentType'", TextView.class);
        accountPreviewActivity.mTvTime = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_time, "field 'mTvTime'", TextView.class);
        accountPreviewActivity.mTvVictimTypeXing = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_type_tag, "field 'mTvVictimTypeXing'", TextView.class);
        accountPreviewActivity.mTvVictimAccXing = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_account_tag, "field 'mTvVictimAccXing'", TextView.class);
        accountPreviewActivity.mTvVictimType = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_type, "field 'mTvVictimType'", TextView.class);
        accountPreviewActivity.mEtVictimOther = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_victim_other, "field 'mEtVictimOther'", EditText.class);
        accountPreviewActivity.mEtVictimAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_victim_account, "field 'mEtVictimAccount'", EditText.class);
        accountPreviewActivity.mTvSuspectType = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_suspect_type, "field 'mTvSuspectType'", TextView.class);
        accountPreviewActivity.mEtSuspectOther = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_suspect_other, "field 'mEtSuspectOther'", EditText.class);
        accountPreviewActivity.mEtSuspectAccountName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_suspect_account_name, "field 'mEtSuspectAccountName'", EditText.class);
        accountPreviewActivity.mEtSuspectAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_suspect_account, "field 'mEtSuspectAccount'", EditText.class);
        accountPreviewActivity.mLlPictures = Utils.findRequiredView(view, C2113R.id.ll_pictures, "field 'mLlPictures'");
        accountPreviewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        accountPreviewActivity.mGroupVictim = (Group) Utils.findRequiredViewAsType(view, C2113R.id.group_victim, "field 'mGroupVictim'", Group.class);
        accountPreviewActivity.mGroupSuspect = (Group) Utils.findRequiredViewAsType(view, C2113R.id.group_suspect, "field 'mGroupSuspect'", Group.class);
        accountPreviewActivity.mGroupSuspectName = Utils.findRequiredView(view, C2113R.id.group_suspect_name, "field 'mGroupSuspectName'");
        accountPreviewActivity.mGroupAmount = (Group) Utils.findRequiredViewAsType(view, C2113R.id.group_amount, "field 'mGroupAmount'", Group.class);
        accountPreviewActivity.mTvAmount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_amount, "field 'mTvAmount'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21776b = findRequiredView;
        findRequiredView.setOnClickListener(new C6110a(accountPreviewActivity));
    }
}
