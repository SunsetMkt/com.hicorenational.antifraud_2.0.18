package ui.activity;

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
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class LoginActivity_ViewBinding implements Unbinder {
    private LoginActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f13445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f13446h;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ LoginActivity a;

        a(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ LoginActivity a;

        b(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ LoginActivity a;

        c(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ LoginActivity a;

        d(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ LoginActivity a;

        e(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ LoginActivity a;

        f(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {
        final /* synthetic */ LoginActivity a;

        g(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity) {
        this(loginActivity, loginActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LoginActivity loginActivity = this.a;
        if (loginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
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
        this.f13440b.setOnClickListener(null);
        this.f13440b = null;
        this.f13441c.setOnClickListener(null);
        this.f13441c = null;
        this.f13442d.setOnClickListener(null);
        this.f13442d = null;
        this.f13443e.setOnClickListener(null);
        this.f13443e = null;
        this.f13444f.setOnClickListener(null);
        this.f13444f = null;
        this.f13445g.setOnClickListener(null);
        this.f13445g = null;
        this.f13446h.setOnClickListener(null);
        this.f13446h = null;
    }

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity, View view) {
        this.a = loginActivity;
        loginActivity.mLoginLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.login_label, "field 'mLoginLabel'", TextView.class);
        loginActivity.mAccountLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.account_label, "field 'mAccountLabel'", TextView.class);
        loginActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.account, "field 'mAccount'", EditText.class);
        loginActivity.mUserPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.user_pwd, "field 'mUserPwd'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        loginActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f13440b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(loginActivity));
        loginActivity.mPwdEye = (ImageView) Utils.findRequiredViewAsType(view, R.id.pwd_eye, "field 'mPwdEye'", ImageView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        loginActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView2, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f13441c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(loginActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.login_change, "field 'mLoginChange' and method 'onViewClicked'");
        loginActivity.mLoginChange = (TextView) Utils.castView(viewFindRequiredView3, R.id.login_change, "field 'mLoginChange'", TextView.class);
        this.f13442d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(loginActivity));
        loginActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, R.id.clause, "field 'mClause'", TextView.class);
        loginActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        loginActivity.mPwdGroup = (Group) Utils.findRequiredViewAsType(view, R.id.pwd_group, "field 'mPwdGroup'", Group.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.forget_pwd, "field 'mForgetPwd' and method 'onViewClicked'");
        loginActivity.mForgetPwd = (TextView) Utils.castView(viewFindRequiredView4, R.id.forget_pwd, "field 'mForgetPwd'", TextView.class);
        this.f13443e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(loginActivity));
        loginActivity.mLineV = Utils.findRequiredView(view, R.id.line_v, "field 'mLineV'");
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_wx_login, "method 'onViewClicked'");
        this.f13444f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(loginActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_qq_login, "method 'onViewClicked'");
        this.f13445g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(loginActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.iv_sina_login, "method 'onViewClicked'");
        this.f13446h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(loginActivity));
    }
}
