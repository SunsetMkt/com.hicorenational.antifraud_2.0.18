package ui.activity;

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
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* JADX INFO: loaded from: classes2.dex */
public class CriminalSocialEditActivity_ViewBinding implements Unbinder {
    private CriminalSocialEditActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13326c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSocialEditActivity a;

        a(CriminalSocialEditActivity criminalSocialEditActivity) {
            this.a = criminalSocialEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CriminalSocialEditActivity a;

        b(CriminalSocialEditActivity criminalSocialEditActivity) {
            this.a = criminalSocialEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSocialEditActivity_ViewBinding(CriminalSocialEditActivity criminalSocialEditActivity) {
        this(criminalSocialEditActivity, criminalSocialEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSocialEditActivity criminalSocialEditActivity = this.a;
        if (criminalSocialEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
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
        this.f13325b.setOnClickListener(null);
        this.f13325b = null;
        this.f13326c.setOnClickListener(null);
        this.f13326c = null;
    }

    @UiThread
    public CriminalSocialEditActivity_ViewBinding(CriminalSocialEditActivity criminalSocialEditActivity, View view) {
        this.a = criminalSocialEditActivity;
        criminalSocialEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalSocialEditActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        criminalSocialEditActivity.mFlowUncheck = Utils.findRequiredView(view, R.id.v_flow_uncheck, "field 'mFlowUncheck'");
        criminalSocialEditActivity.mTvAccountLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_account_label, "field 'mTvAccountLabel'", TextView.class);
        criminalSocialEditActivity.mEtAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_account, "field 'mEtAccount'", EditText.class);
        criminalSocialEditActivity.mLlAccNorm = Utils.findRequiredView(view, R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        criminalSocialEditActivity.mTvTagOtherLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tag_other_label, "field 'mTvTagOtherLabel'", TextView.class);
        criminalSocialEditActivity.mTvAccountOtherLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_account_other_label, "field 'mTvAccountOtherLabel'", TextView.class);
        criminalSocialEditActivity.mEtTagOther = (EditText) Utils.findRequiredViewAsType(view, R.id.et_tag_other, "field 'mEtTagOther'", EditText.class);
        criminalSocialEditActivity.mEtAccountOther = (EditText) Utils.findRequiredViewAsType(view, R.id.et_account_other, "field 'mEtAccountOther'", EditText.class);
        criminalSocialEditActivity.mLlAccOther = Utils.findRequiredView(view, R.id.ll_acc_other, "field 'mLlAccOther'");
        criminalSocialEditActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSocialEditActivity.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSocialEditActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13325b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalSocialEditActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13326c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalSocialEditActivity));
    }
}
