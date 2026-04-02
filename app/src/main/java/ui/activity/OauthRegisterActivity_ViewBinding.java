package ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.CodeCutTimeTextView;

/* JADX INFO: loaded from: classes2.dex */
public class OauthRegisterActivity_ViewBinding implements Unbinder {
    private OauthRegisterActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13523e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ OauthRegisterActivity a;

        a(OauthRegisterActivity oauthRegisterActivity) {
            this.a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ OauthRegisterActivity a;

        b(OauthRegisterActivity oauthRegisterActivity) {
            this.a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ OauthRegisterActivity a;

        c(OauthRegisterActivity oauthRegisterActivity) {
            this.a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ OauthRegisterActivity a;

        d(OauthRegisterActivity oauthRegisterActivity) {
            this.a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public OauthRegisterActivity_ViewBinding(OauthRegisterActivity oauthRegisterActivity) {
        this(oauthRegisterActivity, oauthRegisterActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OauthRegisterActivity oauthRegisterActivity = this.a;
        if (oauthRegisterActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        oauthRegisterActivity.mUserCode = null;
        oauthRegisterActivity.mConfirm = null;
        oauthRegisterActivity.mClause = null;
        oauthRegisterActivity.mTCbSelect = null;
        oauthRegisterActivity.mAccount = null;
        oauthRegisterActivity.mIvClean = null;
        oauthRegisterActivity.mTvReset = null;
        this.f13520b.setOnClickListener(null);
        this.f13520b = null;
        this.f13521c.setOnClickListener(null);
        this.f13521c = null;
        this.f13522d.setOnClickListener(null);
        this.f13522d = null;
        this.f13523e.setOnClickListener(null);
        this.f13523e = null;
    }

    @UiThread
    public OauthRegisterActivity_ViewBinding(OauthRegisterActivity oauthRegisterActivity, View view) {
        this.a = oauthRegisterActivity;
        oauthRegisterActivity.mUserCode = (EditText) Utils.findRequiredViewAsType(view, R.id.user_code, "field 'mUserCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        oauthRegisterActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f13520b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(oauthRegisterActivity));
        oauthRegisterActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, R.id.clause, "field 'mClause'", TextView.class);
        oauthRegisterActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        oauthRegisterActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.account, "field 'mAccount'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        oauthRegisterActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f13521c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(oauthRegisterActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_resend, "field 'mTvReset' and method 'onViewClicked'");
        oauthRegisterActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView3, R.id.tv_resend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f13522d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(oauthRegisterActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13523e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(oauthRegisterActivity));
    }
}
