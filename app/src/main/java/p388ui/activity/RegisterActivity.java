package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
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
import org.greenrobot.eventbus.C6049c;
import p247e.C4447d;
import p388ui.Hicore;
import p388ui.callview.RegisterlView;
import p388ui.presenter.RegisterPresenter;
import p388ui.view.CodeCutTimeTextView;
import util.C7257b1;
import util.C7268d1;
import util.C7292k1;
import util.C7295l1;
import util.C7307p1;
import util.C7328v1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity implements TextWatcher, RegisterlView {
    private boolean isChecked;

    @BindView(C2113R.id.account)
    EditText mAccount;

    @BindView(C2113R.id.clause)
    TextView mClause;

    @BindView(C2113R.id.confirm)
    TextView mConfirm;

    @BindView(C2113R.id.iv_clear)
    ImageView mIvClean;

    @BindView(C2113R.id.iv_clear_account)
    ImageView mIvClearAccount;

    @BindView(C2113R.id.ll_to_login)
    LinearLayout mLlToLogin;
    RegisterPresenter mPresenter;

    @BindView(C2113R.id.pwd_eye)
    ImageView mPwdEye;

    @BindView(C2113R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(C2113R.id.tv_region)
    TextView mTvRegion;

    @BindView(C2113R.id.tv_resend)
    CodeCutTimeTextView mTvResend;

    @BindView(C2113R.id.user_pwd)
    EditText mUserPwd;

    @BindView(C2113R.id.user_verification)
    EditText mUserVerification;
    private boolean pwdIsVisible = true;

    /* renamed from: ui.activity.RegisterActivity$a */
    class C6469a implements PermissionsListener {
        C6469a() {
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

    /* renamed from: ui.activity.RegisterActivity$b */
    class C6470b implements IOneClickListener {
        C6470b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            RegisterActivity.this.showDlg();
        }
    }

    /* renamed from: ui.activity.RegisterActivity$c */
    class C6471c implements IClickListener {
        C6471c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            C7337y1.m26748a((Context) RegisterActivity.this.mActivity, (Class<?>) MainActivity.class);
            RegisterActivity.this.mActivity.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            Intent intent = new Intent(RegisterActivity.this.mActivity, (Class<?>) MinePersonalActivity.class);
            intent.putExtra(C7292k1.f25394d, 1);
            RegisterActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25531j}, new C6469a());
    }

    private void enableConfirm() {
        String trim = this.mAccount.getText().toString().trim();
        String trim2 = this.mUserVerification.getText().toString().trim();
        String trim3 = this.mUserPwd.getText().toString().trim();
        if (TextUtils.isEmpty(trim) || TextUtils.isEmpty(trim2) || TextUtils.isEmpty(trim3)) {
            this.mIvClean.setVisibility(4);
            this.mConfirm.setEnabled(false);
        } else {
            this.mIvClean.setVisibility(0);
            this.mConfirm.setEnabled(true);
        }
    }

    private void initCluse() {
        CharSequence m26728a = C7337y1.m26728a(this, "注册即同意", "和", "", "《服务协议》", "《隐私政策》");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(m26728a);
    }

    private void initListener() {
        this.mPwdEye.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m25310a(view);
            }
        });
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.v0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RegisterActivity.this.m25311a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerSubmit() {
        String obj = this.mAccount.getText().toString();
        String trim = this.mUserPwd.getText().toString().trim();
        String trim2 = this.mUserVerification.getText().toString().trim();
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        if (trim.length() < 6 || trim.length() > 16 || C7268d1.m26312a(trim)) {
            C7331w1.m26688a(this.mActivity.getString(C2113R.string.login_pwd));
            return;
        }
        if (TextUtils.isEmpty(nodeRegionId)) {
            C7331w1.m26688a("请选择地区");
            return;
        }
        String m26668i = C7328v1.m26668i();
        String m26678o = C7328v1.m26678o();
        String m26674l = C7328v1.m26674l();
        String m26407a = C7295l1.m26407a();
        RegisterBody registerBody = new RegisterBody();
        registerBody.setPhoneNum(obj);
        registerBody.setSmsVerifyCode(trim2);
        registerBody.setPassword(trim);
        registerBody.setAppVersion(m26678o);
        registerBody.setOs(0);
        registerBody.setOsVersion(m26668i);
        registerBody.setImei(m26674l);
        registerBody.setRequestIP(m26407a);
        registerBody.setRegion(nodeRegionId);
        this.mPresenter.principalHttp(registerBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDlg() {
        C7257b1.m26184a(this.mActivity, "注册成功", "感谢您的注册，完善您的个人信息将获得反诈部门更多关注", "忽略", "继续完善", -1, -1, true, (IClickListener) new C6471c());
    }

    /* renamed from: a */
    public /* synthetic */ void m25310a(View view) {
        if (this.pwdIsVisible) {
            this.mPwdEye.setImageResource(C2113R.mipmap.eye_sel);
            this.mUserPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.mPwdEye.setImageResource(C2113R.mipmap.eye_nor);
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

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17157d);
        this.mPresenter = new RegisterPresenter(this, this);
        String stringExtra = getIntent().getStringExtra(LoginActivity.EXTRA_LOGIN_VERIFICATION);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mUserVerification.setText(stringExtra);
        }
        this.mAccount.addTextChangedListener(this);
        this.mUserVerification.addTextChangedListener(this);
        this.mUserPwd.addTextChangedListener(this);
        this.mTvResend.m25757a(true);
        initCluse();
        initListener();
        C7268d1.m26314b(this.mUserPwd);
    }

    @Override // p388ui.callview.RegisterlView
    public void onOauthSuccRequest(APIresult<AccountInfo> aPIresult) {
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mTvRegion.setText(RegionConfigHttp.getNodeRegionName());
    }

    @Override // p388ui.callview.RegisterlView
    public void onSuccRequest(APIresult<AccountInfo> aPIresult) {
        int code = aPIresult.getCode();
        String msg = aPIresult.getMsg();
        if (code != 0) {
            if (code != 1) {
                C7331w1.m26696e(msg);
                return;
            }
            C7331w1.m26696e(msg);
            finish();
            C6049c.m24987f().m25000d(new C7265a(C7265a.f25267v0));
            return;
        }
        if (aPIresult.getData() == null) {
            C7331w1.m26696e(msg);
            return;
        }
        LoginHttp.getInstance().loginSubmit(this.mActivity, this.mAccount.getText().toString(), this.mUserPwd.getText().toString().trim(), this.mUserVerification.getText().toString().trim(), 0, new C6470b());
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({C2113R.id.iv_clear_account, C2113R.id.tv_resend, C2113R.id.ll_to_login, C2113R.id.iv_clear, C2113R.id.confirm})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                if (!this.isChecked) {
                    C7331w1.m26688a("请先勾选同意协议政策后再注册");
                    break;
                } else {
                    checkPermission();
                    break;
                }
            case C2113R.id.iv_clear /* 2131296772 */:
                this.mUserPwd.setText("");
                break;
            case C2113R.id.iv_clear_account /* 2131296773 */:
                this.mAccount.setText("");
                break;
            case C2113R.id.ll_to_login /* 2131296993 */:
                C6049c.m24987f().m25000d(new C7265a(C7265a.f25267v0, null));
                finish();
                break;
            case C2113R.id.tv_resend /* 2131297692 */:
                final String obj = this.mAccount.getText().toString();
                if (!TextUtils.isEmpty(obj) && obj.length() == 11) {
                    if (!C7337y1.m26760a(C7307p1.f25510s, true)) {
                        this.mPresenter.verificationSubmit(1, obj, this.mTvResend);
                        break;
                    } else {
                        toYanzheng(new IOneClickListener() { // from class: ui.activity.u0
                            @Override // interfaces.IOneClickListener
                            public final void clickOKBtn() {
                                RegisterActivity.this.m25312a(obj);
                            }
                        });
                        break;
                    }
                } else {
                    C7331w1.m26688a("请输入正确手机号~");
                    break;
                }
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_register;
    }

    /* renamed from: a */
    public /* synthetic */ void m25311a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }

    /* renamed from: a */
    public /* synthetic */ void m25312a(String str) {
        this.mPresenter.verificationSubmit(1, str, this.mTvResend);
    }
}
