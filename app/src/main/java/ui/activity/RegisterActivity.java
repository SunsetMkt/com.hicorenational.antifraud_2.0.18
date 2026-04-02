package ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.util.List;
import network.account.APIresult;
import network.account.AccountInfo;
import network.account.RegisterBody;
import network.http.LoginHttp;
import network.http.RegionConfigHttp;
import network.http.StatisticsHttp;
import ui.Hicore;
import ui.callview.RegisterlView;
import ui.presenter.RegisterPresenter;
import ui.view.CodeCutTimeTextView;
import util.d2;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity implements TextWatcher, RegisterlView {
    private boolean isChecked;

    @BindView(R.id.account)
    EditText mAccount;

    @BindView(R.id.clause)
    TextView mClause;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.iv_clear_account)
    ImageView mIvClearAccount;

    @BindView(R.id.ll_to_login)
    LinearLayout mLlToLogin;
    RegisterPresenter mPresenter;

    @BindView(R.id.pwd_eye)
    ImageView mPwdEye;

    @BindView(R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(R.id.tv_region)
    TextView mTvRegion;

    @BindView(R.id.tv_resend)
    CodeCutTimeTextView mTvResend;

    @BindView(R.id.user_pwd)
    EditText mUserPwd;

    @BindView(R.id.user_verification)
    EditText mUserVerification;
    private boolean pwdIsVisible = true;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            RegisterActivity.this.registerSubmit();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            RegisterActivity.this.registerSubmit();
        }
    }

    class b implements IOneClickListener {
        b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            RegisterActivity.this.showDlg();
        }
    }

    class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            g2.a((Context) RegisterActivity.this.mActivity, (Class<?>) MainActivity.class);
            RegisterActivity.this.mActivity.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            Intent intent = new Intent(RegisterActivity.this.mActivity, (Class<?>) MinePersonalActivity.class);
            intent.putExtra(util.p1.f15012d, 1);
            RegisterActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f15033j}, new a());
    }

    private void enableConfirm() {
        String strTrim = this.mAccount.getText().toString().trim();
        String strTrim2 = this.mUserVerification.getText().toString().trim();
        String strTrim3 = this.mUserPwd.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2) || TextUtils.isEmpty(strTrim3)) {
            this.mIvClean.setVisibility(4);
            this.mConfirm.setEnabled(false);
        } else {
            this.mIvClean.setVisibility(0);
            this.mConfirm.setEnabled(true);
        }
    }

    private void initCluse() {
        CharSequence charSequenceA = g2.a(this, "\u6ce8\u518c\u5373\u540c\u610f", "\u548c", "", "\u300a\u670d\u52a1\u534f\u8bae\u300b", "\u300a\u9690\u79c1\u653f\u7b56\u300b");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(charSequenceA);
    }

    private void initListener() {
        this.mPwdEye.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(view);
            }
        });
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.x0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerSubmit() {
        String string = this.mAccount.getText().toString();
        String strTrim = this.mUserPwd.getText().toString().trim();
        String strTrim2 = this.mUserVerification.getText().toString().trim();
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        if (strTrim.length() < 6 || strTrim.length() > 16 || util.h1.a(strTrim)) {
            e2.a(this.mActivity.getString(R.string.login_pwd));
            return;
        }
        if (TextUtils.isEmpty(nodeRegionId)) {
            e2.a("\u8bf7\u9009\u62e9\u5730\u533a");
            return;
        }
        String strI = d2.i();
        String strO = d2.o();
        String strL = d2.l();
        String strA = util.q1.a();
        RegisterBody registerBody = new RegisterBody();
        registerBody.setPhoneNum(string);
        registerBody.setSmsVerifyCode(strTrim2);
        registerBody.setPassword(strTrim);
        registerBody.setAppVersion(strO);
        registerBody.setOs(0);
        registerBody.setOsVersion(strI);
        registerBody.setImei(strL);
        registerBody.setRequestIP(strA);
        registerBody.setRegion(nodeRegionId);
        this.mPresenter.principalHttp(registerBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDlg() {
        util.f1.a(this.mActivity, "\u6ce8\u518c\u6210\u529f", "\u611f\u8c22\u60a8\u7684\u6ce8\u518c\uff0c\u5b8c\u5584\u60a8\u7684\u4e2a\u4eba\u4fe1\u606f\u5c06\u83b7\u5f97\u53cd\u8bc8\u90e8\u95e8\u66f4\u591a\u5173\u6ce8", "\u5ffd\u7565", "\u7ee7\u7eed\u5b8c\u5584", -1, -1, true, (IClickListener) new c());
    }

    public /* synthetic */ void a(View view) {
        if (this.pwdIsVisible) {
            this.mPwdEye.setImageResource(R.mipmap.eye_sel);
            this.mUserPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.mPwdEye.setImageResource(R.mipmap.eye_nor);
            this.mUserPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        this.pwdIsVisible = !this.pwdIsVisible;
        if (!this.mUserPwd.isFocused()) {
            this.mUserPwd.setFocusable(true);
            this.mUserPwd.setFocusableInTouchMode(true);
            this.mUserPwd.requestFocus();
            this.mUserPwd.requestFocusFromTouch();
        }
        EditText editText = this.mUserPwd;
        editText.setSelection(editText.getText().toString().length());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        enableConfirm();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10204d);
        this.mPresenter = new RegisterPresenter(this, this);
        String stringExtra = getIntent().getStringExtra(LoginActivity.EXTRA_LOGIN_VERIFICATION);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mUserVerification.setText(stringExtra);
        }
        this.mAccount.addTextChangedListener(this);
        this.mUserVerification.addTextChangedListener(this);
        this.mUserPwd.addTextChangedListener(this);
        this.mTvResend.a(true);
        initCluse();
        initListener();
        util.h1.b(this.mUserPwd);
    }

    @Override // ui.callview.RegisterlView
    public void onOauthSuccRequest(APIresult<AccountInfo> aPIresult) {
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mTvRegion.setText(RegionConfigHttp.getNodeRegionName());
    }

    @Override // ui.callview.RegisterlView
    public void onSuccRequest(APIresult<AccountInfo> aPIresult) {
        int code = aPIresult.getCode();
        String msg = aPIresult.getMsg();
        if (code != 0) {
            if (code != 1) {
                e2.e(msg);
                return;
            }
            e2.e(msg);
            finish();
            org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.v0));
            return;
        }
        if (aPIresult.getData() == null) {
            e2.e(msg);
            return;
        }
        LoginHttp.getInstance().loginSubmit(this.mActivity, this.mAccount.getText().toString(), this.mUserPwd.getText().toString().trim(), this.mUserVerification.getText().toString().trim(), 0, new b());
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({R.id.iv_clear_account, R.id.tv_resend, R.id.ll_to_login, R.id.iv_clear, R.id.confirm})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296501 */:
                if (!this.isChecked) {
                    e2.a("\u8bf7\u5148\u52fe\u9009\u540c\u610f\u534f\u8bae\u653f\u7b56\u540e\u518d\u6ce8\u518c");
                } else {
                    checkPermission();
                }
                break;
            case R.id.iv_clear /* 2131296818 */:
                this.mUserPwd.setText("");
                break;
            case R.id.iv_clear_account /* 2131296819 */:
                this.mAccount.setText("");
                break;
            case R.id.ll_to_login /* 2131297043 */:
                org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.v0, null));
                finish();
                break;
            case R.id.tv_resend /* 2131297853 */:
                final String string = this.mAccount.getText().toString();
                if (TextUtils.isEmpty(string) || string.length() != 11) {
                    e2.a("\u8bf7\u8f93\u5165\u6b63\u786e\u624b\u673a\u53f7~");
                } else if (!g2.a(util.u1.s, true)) {
                    this.mPresenter.verificationSubmit(1, string, this.mTvResend);
                } else {
                    toYanzheng(new IOneClickListener() { // from class: ui.activity.w0
                        @Override // interfaces.IOneClickListener
                        public final void clickOKBtn() {
                            this.a.a(string);
                        }
                    });
                }
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_register;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }

    public /* synthetic */ void a(String str) {
        this.mPresenter.verificationSubmit(1, str, this.mTvResend);
    }
}
