package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: classes2.dex */
public final class RelationAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private RelationAddActivity f22831a;

    /* renamed from: b */
    private View f22832b;

    /* renamed from: c */
    private View f22833c;

    /* renamed from: ui.activity.RelationAddActivity_ViewBinding$a */
    class C6485a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RelationAddActivity f22834a;

        C6485a(RelationAddActivity relationAddActivity) {
            this.f22834a = relationAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22834a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RelationAddActivity_ViewBinding$b */
    class C6486b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RelationAddActivity f22836a;

        C6486b(RelationAddActivity relationAddActivity) {
            this.f22836a = relationAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22836a.onViewClicked(view);
        }
    }

    @UiThread
    public RelationAddActivity_ViewBinding(RelationAddActivity relationAddActivity) {
        this(relationAddActivity, relationAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RelationAddActivity relationAddActivity = this.f22831a;
        if (relationAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22831a = null;
        relationAddActivity.mTvTitle = null;
        relationAddActivity.scrollView = null;
        relationAddActivity.mFlowLayout = null;
        relationAddActivity.mTvAccName = null;
        relationAddActivity.mEtAccount = null;
        relationAddActivity.mLlAccNorm = null;
        relationAddActivity.mTvOtherTips = null;
        relationAddActivity.mEtOtherName = null;
        relationAddActivity.mLlAccOther = null;
        this.f22832b.setOnClickListener(null);
        this.f22832b = null;
        this.f22833c.setOnClickListener(null);
        this.f22833c = null;
    }

    @UiThread
    public RelationAddActivity_ViewBinding(RelationAddActivity relationAddActivity, View view) {
        this.f22831a = relationAddActivity;
        relationAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        relationAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, C2113R.id.scrollView, "field 'scrollView'", NestedScrollView.class);
        relationAddActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, C2113R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        relationAddActivity.mTvAccName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_acc_name, "field 'mTvAccName'", TextView.class);
        relationAddActivity.mEtAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_account, "field 'mEtAccount'", EditText.class);
        relationAddActivity.mLlAccNorm = Utils.findRequiredView(view, C2113R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        relationAddActivity.mTvOtherTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_other_name, "field 'mTvOtherTips'", TextView.class);
        relationAddActivity.mEtOtherName = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_other_name, "field 'mEtOtherName'", EditText.class);
        relationAddActivity.mLlAccOther = Utils.findRequiredView(view, C2113R.id.ll_acc_other, "field 'mLlAccOther'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22832b = findRequiredView;
        findRequiredView.setOnClickListener(new C6485a(relationAddActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onViewClicked'");
        this.f22833c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6486b(relationAddActivity));
    }
}
