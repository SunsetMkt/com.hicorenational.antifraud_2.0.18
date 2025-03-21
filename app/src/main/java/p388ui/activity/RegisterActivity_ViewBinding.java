package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import p388ui.view.CodeCutTimeTextView;

/* loaded from: classes2.dex */
public class RegisterActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private RegisterActivity f22799a;

    /* renamed from: b */
    private View f22800b;

    /* renamed from: c */
    private View f22801c;

    /* renamed from: d */
    private View f22802d;

    /* renamed from: e */
    private View f22803e;

    /* renamed from: f */
    private View f22804f;

    /* renamed from: ui.activity.RegisterActivity_ViewBinding$a */
    class C6472a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RegisterActivity f22805a;

        C6472a(RegisterActivity registerActivity) {
            this.f22805a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22805a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RegisterActivity_ViewBinding$b */
    class C6473b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RegisterActivity f22807a;

        C6473b(RegisterActivity registerActivity) {
            this.f22807a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22807a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RegisterActivity_ViewBinding$c */
    class C6474c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RegisterActivity f22809a;

        C6474c(RegisterActivity registerActivity) {
            this.f22809a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22809a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RegisterActivity_ViewBinding$d */
    class C6475d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RegisterActivity f22811a;

        C6475d(RegisterActivity registerActivity) {
            this.f22811a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22811a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.RegisterActivity_ViewBinding$e */
    class C6476e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ RegisterActivity f22813a;

        C6476e(RegisterActivity registerActivity) {
            this.f22813a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22813a.onViewClicked(view);
        }
    }

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity) {
        this(registerActivity, registerActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RegisterActivity registerActivity = this.f22799a;
        if (registerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22799a = null;
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
        this.f22800b.setOnClickListener(null);
        this.f22800b = null;
        this.f22801c.setOnClickListener(null);
        this.f22801c = null;
        this.f22802d.setOnClickListener(null);
        this.f22802d = null;
        this.f22803e.setOnClickListener(null);
        this.f22803e = null;
        this.f22804f.setOnClickListener(null);
        this.f22804f = null;
    }

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity, View view) {
        this.f22799a = registerActivity;
        registerActivity.mTvRegion = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_region, "field 'mTvRegion'", TextView.class);
        registerActivity.mUserPwd = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.user_pwd, "field 'mUserPwd'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        registerActivity.mConfirm = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f22800b = findRequiredView;
        findRequiredView.setOnClickListener(new C6472a(registerActivity));
        registerActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.clause, "field 'mClause'", TextView.class);
        registerActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, C2113R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        registerActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.account, "field 'mAccount'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        registerActivity.mIvClean = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f22801c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6473b(registerActivity));
        registerActivity.mPwdEye = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.pwd_eye, "field 'mPwdEye'", ImageView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_clear_account, "field 'mIvClearAccount' and method 'onViewClicked'");
        registerActivity.mIvClearAccount = (ImageView) Utils.castView(findRequiredView3, C2113R.id.iv_clear_account, "field 'mIvClearAccount'", ImageView.class);
        this.f22802d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6474c(registerActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_resend, "field 'mTvResend' and method 'onViewClicked'");
        registerActivity.mTvResend = (CodeCutTimeTextView) Utils.castView(findRequiredView4, C2113R.id.tv_resend, "field 'mTvResend'", CodeCutTimeTextView.class);
        this.f22803e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6475d(registerActivity));
        registerActivity.mUserVerification = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.user_verification, "field 'mUserVerification'", EditText.class);
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.ll_to_login, "field 'mLlToLogin' and method 'onViewClicked'");
        registerActivity.mLlToLogin = (LinearLayout) Utils.castView(findRequiredView5, C2113R.id.ll_to_login, "field 'mLlToLogin'", LinearLayout.class);
        this.f22804f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6476e(registerActivity));
    }
}
