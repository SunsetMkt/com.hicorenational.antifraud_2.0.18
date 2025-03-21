package p388ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class LoginActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LoginActivity f22446a;

    /* renamed from: b */
    private View f22447b;

    /* renamed from: c */
    private View f22448c;

    /* renamed from: d */
    private View f22449d;

    /* renamed from: e */
    private View f22450e;

    /* renamed from: f */
    private View f22451f;

    /* renamed from: g */
    private View f22452g;

    /* renamed from: h */
    private View f22453h;

    /* renamed from: ui.activity.LoginActivity_ViewBinding$a */
    class C6345a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LoginActivity f22454a;

        C6345a(LoginActivity loginActivity) {
            this.f22454a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22454a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.LoginActivity_ViewBinding$b */
    class C6346b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LoginActivity f22456a;

        C6346b(LoginActivity loginActivity) {
            this.f22456a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22456a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.LoginActivity_ViewBinding$c */
    class C6347c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LoginActivity f22458a;

        C6347c(LoginActivity loginActivity) {
            this.f22458a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22458a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.LoginActivity_ViewBinding$d */
    class C6348d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LoginActivity f22460a;

        C6348d(LoginActivity loginActivity) {
            this.f22460a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22460a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.LoginActivity_ViewBinding$e */
    class C6349e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LoginActivity f22462a;

        C6349e(LoginActivity loginActivity) {
            this.f22462a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22462a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.LoginActivity_ViewBinding$f */
    class C6350f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LoginActivity f22464a;

        C6350f(LoginActivity loginActivity) {
            this.f22464a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22464a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.LoginActivity_ViewBinding$g */
    class C6351g extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LoginActivity f22466a;

        C6351g(LoginActivity loginActivity) {
            this.f22466a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22466a.onViewClicked(view);
        }
    }

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity) {
        this(loginActivity, loginActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LoginActivity loginActivity = this.f22446a;
        if (loginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22446a = null;
        loginActivity.mLoginLabel = null;
        loginActivity.mAccountLabel = null;
        loginActivity.mAccount = null;
        loginActivity.mUserPwd = null;
        loginActivity.mIvClean = null;
        loginActivity.mPwdEye = null;
        loginActivity.mConfirm = null;
        loginActivity.mLoginChange = null;
        loginActivity.mClause = null;
        loginActivity.mTCbSelect = null;
        loginActivity.mPwdGroup = null;
        loginActivity.mForgetPwd = null;
        loginActivity.mLineV = null;
        this.f22447b.setOnClickListener(null);
        this.f22447b = null;
        this.f22448c.setOnClickListener(null);
        this.f22448c = null;
        this.f22449d.setOnClickListener(null);
        this.f22449d = null;
        this.f22450e.setOnClickListener(null);
        this.f22450e = null;
        this.f22451f.setOnClickListener(null);
        this.f22451f = null;
        this.f22452g.setOnClickListener(null);
        this.f22452g = null;
        this.f22453h.setOnClickListener(null);
        this.f22453h = null;
    }

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity, View view) {
        this.f22446a = loginActivity;
        loginActivity.mLoginLabel = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.login_label, "field 'mLoginLabel'", TextView.class);
        loginActivity.mAccountLabel = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.account_label, "field 'mAccountLabel'", TextView.class);
        loginActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.account, "field 'mAccount'", EditText.class);
        loginActivity.mUserPwd = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.user_pwd, "field 'mUserPwd'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        loginActivity.mIvClean = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f22447b = findRequiredView;
        findRequiredView.setOnClickListener(new C6345a(loginActivity));
        loginActivity.mPwdEye = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.pwd_eye, "field 'mPwdEye'", ImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        loginActivity.mConfirm = (TextView) Utils.castView(findRequiredView2, C2113R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f22448c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6346b(loginActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.login_change, "field 'mLoginChange' and method 'onViewClicked'");
        loginActivity.mLoginChange = (TextView) Utils.castView(findRequiredView3, C2113R.id.login_change, "field 'mLoginChange'", TextView.class);
        this.f22449d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6347c(loginActivity));
        loginActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.clause, "field 'mClause'", TextView.class);
        loginActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, C2113R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        loginActivity.mPwdGroup = (Group) Utils.findRequiredViewAsType(view, C2113R.id.pwd_group, "field 'mPwdGroup'", Group.class);
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.forget_pwd, "field 'mForgetPwd' and method 'onViewClicked'");
        loginActivity.mForgetPwd = (TextView) Utils.castView(findRequiredView4, C2113R.id.forget_pwd, "field 'mForgetPwd'", TextView.class);
        this.f22450e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6348d(loginActivity));
        loginActivity.mLineV = Utils.findRequiredView(view, C2113R.id.line_v, "field 'mLineV'");
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.iv_wx_login, "method 'onViewClicked'");
        this.f22451f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6349e(loginActivity));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.iv_qq_login, "method 'onViewClicked'");
        this.f22452g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6350f(loginActivity));
        View findRequiredView7 = Utils.findRequiredView(view, C2113R.id.iv_sina_login, "method 'onViewClicked'");
        this.f22453h = findRequiredView7;
        findRequiredView7.setOnClickListener(new C6351g(loginActivity));
    }
}
