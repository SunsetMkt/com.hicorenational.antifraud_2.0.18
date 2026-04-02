package ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.CodeCutTimeTextView;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterActivity_ViewBinding implements Unbinder {
    private RegisterActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13635f;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ RegisterActivity a;

        a(RegisterActivity registerActivity) {
            this.a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ RegisterActivity a;

        b(RegisterActivity registerActivity) {
            this.a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ RegisterActivity a;

        c(RegisterActivity registerActivity) {
            this.a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ RegisterActivity a;

        d(RegisterActivity registerActivity) {
            this.a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ RegisterActivity a;

        e(RegisterActivity registerActivity) {
            this.a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity) {
        this(registerActivity, registerActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RegisterActivity registerActivity = this.a;
        if (registerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        registerActivity.mTvRegion = null;
        registerActivity.mUserPwd = null;
        registerActivity.mConfirm = null;
        registerActivity.mClause = null;
        registerActivity.mTCbSelect = null;
        registerActivity.mAccount = null;
        registerActivity.mIvClean = null;
        registerActivity.mPwdEye = null;
        registerActivity.mIvClearAccount = null;
        registerActivity.mTvResend = null;
        registerActivity.mUserVerification = null;
        registerActivity.mLlToLogin = null;
        this.f13631b.setOnClickListener(null);
        this.f13631b = null;
        this.f13632c.setOnClickListener(null);
        this.f13632c = null;
        this.f13633d.setOnClickListener(null);
        this.f13633d = null;
        this.f13634e.setOnClickListener(null);
        this.f13634e = null;
        this.f13635f.setOnClickListener(null);
        this.f13635f = null;
    }

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity, View view) {
        this.a = registerActivity;
        registerActivity.mTvRegion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_region, "field 'mTvRegion'", TextView.class);
        registerActivity.mUserPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.user_pwd, "field 'mUserPwd'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        registerActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f13631b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(registerActivity));
        registerActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, R.id.clause, "field 'mClause'", TextView.class);
        registerActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        registerActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.account, "field 'mAccount'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        registerActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f13632c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(registerActivity));
        registerActivity.mPwdEye = (ImageView) Utils.findRequiredViewAsType(view, R.id.pwd_eye, "field 'mPwdEye'", ImageView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_clear_account, "field 'mIvClearAccount' and method 'onViewClicked'");
        registerActivity.mIvClearAccount = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_clear_account, "field 'mIvClearAccount'", ImageView.class);
        this.f13633d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(registerActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_resend, "field 'mTvResend' and method 'onViewClicked'");
        registerActivity.mTvResend = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView4, R.id.tv_resend, "field 'mTvResend'", CodeCutTimeTextView.class);
        this.f13634e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(registerActivity));
        registerActivity.mUserVerification = (EditText) Utils.findRequiredViewAsType(view, R.id.user_verification, "field 'mUserVerification'", EditText.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_to_login, "field 'mLlToLogin' and method 'onViewClicked'");
        registerActivity.mLlToLogin = (LinearLayout) Utils.castView(viewFindRequiredView5, R.id.ll_to_login, "field 'mLlToLogin'", LinearLayout.class);
        this.f13635f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(registerActivity));
    }
}
