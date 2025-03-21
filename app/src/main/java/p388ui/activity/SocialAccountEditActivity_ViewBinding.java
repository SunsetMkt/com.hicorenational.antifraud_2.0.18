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
public class SocialAccountEditActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SocialAccountEditActivity f23239a;

    /* renamed from: b */
    private View f23240b;

    /* renamed from: c */
    private View f23241c;

    /* renamed from: ui.activity.SocialAccountEditActivity_ViewBinding$a */
    class C6613a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SocialAccountEditActivity f23242a;

        C6613a(SocialAccountEditActivity socialAccountEditActivity) {
            this.f23242a = socialAccountEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23242a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SocialAccountEditActivity_ViewBinding$b */
    class C6614b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SocialAccountEditActivity f23244a;

        C6614b(SocialAccountEditActivity socialAccountEditActivity) {
            this.f23244a = socialAccountEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23244a.onViewClicked(view);
        }
    }

    @UiThread
    public SocialAccountEditActivity_ViewBinding(SocialAccountEditActivity socialAccountEditActivity) {
        this(socialAccountEditActivity, socialAccountEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SocialAccountEditActivity socialAccountEditActivity = this.f23239a;
        if (socialAccountEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23239a = null;
        socialAccountEditActivity.mTvTitle = null;
        socialAccountEditActivity.mFlowLayout = null;
        socialAccountEditActivity.mTvAccName = null;
        socialAccountEditActivity.mEtAccount = null;
        socialAccountEditActivity.mLlAccNorm = null;
        socialAccountEditActivity.mEtTagOther = null;
        socialAccountEditActivity.mEtAccountOther = null;
        socialAccountEditActivity.mLlAccOther = null;
        this.f23240b.setOnClickListener(null);
        this.f23240b = null;
        this.f23241c.setOnClickListener(null);
        this.f23241c = null;
    }

    @UiThread
    public SocialAccountEditActivity_ViewBinding(SocialAccountEditActivity socialAccountEditActivity, View view) {
        this.f23239a = socialAccountEditActivity;
        socialAccountEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        socialAccountEditActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, C2113R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        socialAccountEditActivity.mTvAccName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_acc_name, "field 'mTvAccName'", TextView.class);
        socialAccountEditActivity.mEtAccount = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_account, "field 'mEtAccount'", TextView.class);
        socialAccountEditActivity.mLlAccNorm = Utils.findRequiredView(view, C2113R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        socialAccountEditActivity.mEtTagOther = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_tag_other, "field 'mEtTagOther'", TextView.class);
        socialAccountEditActivity.mEtAccountOther = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_account_other, "field 'mEtAccountOther'", TextView.class);
        socialAccountEditActivity.mLlAccOther = Utils.findRequiredView(view, C2113R.id.ll_acc_other, "field 'mLlAccOther'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23240b = findRequiredView;
        findRequiredView.setOnClickListener(new C6613a(socialAccountEditActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_commit, "method 'onViewClicked'");
        this.f23241c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6614b(socialAccountEditActivity));
    }
}
