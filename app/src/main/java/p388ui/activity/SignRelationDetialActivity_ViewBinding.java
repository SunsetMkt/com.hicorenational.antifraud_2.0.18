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
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: classes2.dex */
public final class SignRelationDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignRelationDetialActivity f23153a;

    /* renamed from: b */
    private View f23154b;

    /* renamed from: ui.activity.SignRelationDetialActivity_ViewBinding$a */
    class C6593a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignRelationDetialActivity f23155a;

        C6593a(SignRelationDetialActivity signRelationDetialActivity) {
            this.f23155a = signRelationDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23155a.onViewClicked(view);
        }
    }

    @UiThread
    public SignRelationDetialActivity_ViewBinding(SignRelationDetialActivity signRelationDetialActivity) {
        this(signRelationDetialActivity, signRelationDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignRelationDetialActivity signRelationDetialActivity = this.f23153a;
        if (signRelationDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23153a = null;
        signRelationDetialActivity.mTvTitle = null;
        signRelationDetialActivity.mBtnConfirm = null;
        signRelationDetialActivity.mFlowLayout = null;
        signRelationDetialActivity.mTvAccName = null;
        signRelationDetialActivity.mEtAccount = null;
        signRelationDetialActivity.mLlAccNorm = null;
        signRelationDetialActivity.mTvOtherTips = null;
        signRelationDetialActivity.mEtOtherName = null;
        signRelationDetialActivity.mLlAccOther = null;
        this.f23154b.setOnClickListener(null);
        this.f23154b = null;
    }

    @UiThread
    public SignRelationDetialActivity_ViewBinding(SignRelationDetialActivity signRelationDetialActivity, View view) {
        this.f23153a = signRelationDetialActivity;
        signRelationDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signRelationDetialActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, C2113R.id.btn_commit, "field 'mBtnConfirm'", Button.class);
        signRelationDetialActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, C2113R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        signRelationDetialActivity.mTvAccName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_acc_name, "field 'mTvAccName'", TextView.class);
        signRelationDetialActivity.mEtAccount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_account, "field 'mEtAccount'", TextView.class);
        signRelationDetialActivity.mLlAccNorm = Utils.findRequiredView(view, C2113R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        signRelationDetialActivity.mTvOtherTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_other_name, "field 'mTvOtherTips'", TextView.class);
        signRelationDetialActivity.mEtOtherName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_other_name, "field 'mEtOtherName'", EditText.class);
        signRelationDetialActivity.mLlAccOther = Utils.findRequiredView(view, C2113R.id.ll_acc_other, "field 'mLlAccOther'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23154b = findRequiredView;
        findRequiredView.setOnClickListener(new C6593a(signRelationDetialActivity));
    }
}
