package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: classes2.dex */
public class CriminalSocialEditActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CriminalSocialEditActivity f22237a;

    /* renamed from: b */
    private View f22238b;

    /* renamed from: c */
    private View f22239c;

    /* renamed from: ui.activity.CriminalSocialEditActivity_ViewBinding$a */
    class C6276a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSocialEditActivity f22240a;

        C6276a(CriminalSocialEditActivity criminalSocialEditActivity) {
            this.f22240a = criminalSocialEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22240a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.CriminalSocialEditActivity_ViewBinding$b */
    class C6277b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalSocialEditActivity f22242a;

        C6277b(CriminalSocialEditActivity criminalSocialEditActivity) {
            this.f22242a = criminalSocialEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22242a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSocialEditActivity_ViewBinding(CriminalSocialEditActivity criminalSocialEditActivity) {
        this(criminalSocialEditActivity, criminalSocialEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSocialEditActivity criminalSocialEditActivity = this.f22237a;
        if (criminalSocialEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22237a = null;
        criminalSocialEditActivity.mTvTitle = null;
        criminalSocialEditActivity.mFlowLayout = null;
        criminalSocialEditActivity.mFlowUncheck = null;
        criminalSocialEditActivity.mTvAccountLabel = null;
        criminalSocialEditActivity.mEtAccount = null;
        criminalSocialEditActivity.mLlAccNorm = null;
        criminalSocialEditActivity.mTvTagOtherLabel = null;
        criminalSocialEditActivity.mTvAccountOtherLabel = null;
        criminalSocialEditActivity.mEtTagOther = null;
        criminalSocialEditActivity.mEtAccountOther = null;
        criminalSocialEditActivity.mLlAccOther = null;
        criminalSocialEditActivity.mRecyclerview = null;
        criminalSocialEditActivity.mLlPicture = null;
        criminalSocialEditActivity.mBtnCommit = null;
        this.f22238b.setOnClickListener(null);
        this.f22238b = null;
        this.f22239c.setOnClickListener(null);
        this.f22239c = null;
    }

    @UiThread
    public CriminalSocialEditActivity_ViewBinding(CriminalSocialEditActivity criminalSocialEditActivity, View view) {
        this.f22237a = criminalSocialEditActivity;
        criminalSocialEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalSocialEditActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, C2113R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        criminalSocialEditActivity.mFlowUncheck = Utils.findRequiredView(view, C2113R.id.v_flow_uncheck, "field 'mFlowUncheck'");
        criminalSocialEditActivity.mTvAccountLabel = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_account_label, "field 'mTvAccountLabel'", TextView.class);
        criminalSocialEditActivity.mEtAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_account, "field 'mEtAccount'", EditText.class);
        criminalSocialEditActivity.mLlAccNorm = Utils.findRequiredView(view, C2113R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        criminalSocialEditActivity.mTvTagOtherLabel = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tag_other_label, "field 'mTvTagOtherLabel'", TextView.class);
        criminalSocialEditActivity.mTvAccountOtherLabel = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_account_other_label, "field 'mTvAccountOtherLabel'", TextView.class);
        criminalSocialEditActivity.mEtTagOther = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_tag_other, "field 'mEtTagOther'", EditText.class);
        criminalSocialEditActivity.mEtAccountOther = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_account_other, "field 'mEtAccountOther'", EditText.class);
        criminalSocialEditActivity.mLlAccOther = Utils.findRequiredView(view, C2113R.id.ll_acc_other, "field 'mLlAccOther'");
        criminalSocialEditActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSocialEditActivity.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSocialEditActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22238b = findRequiredView;
        findRequiredView.setOnClickListener(new C6276a(criminalSocialEditActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22239c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6277b(criminalSocialEditActivity));
    }
}
