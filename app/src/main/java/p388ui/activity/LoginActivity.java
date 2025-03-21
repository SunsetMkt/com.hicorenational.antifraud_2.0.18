package p388ui.activity;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import interfaces.IResultCallback;
import java.util.Map;
import manager.AccountManager;
import network.account.APIresult;
import network.account.AccountInfo;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p247e.C4447d;
import p388ui.callview.LoginCallView;
import p388ui.presenter.LoginPresenter;
import receiver.C6088e;
import util.C7268d1;
import util.C7292k1;
import util.C7307p1;
import util.C7330w0;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class LoginActivity extends BaseActivity implements IEditAfterListener, LoginCallView {
    public static final String EXTRA_LOGIN_ACCOUNT = "extra_login_account";
    public static final String EXTRA_LOGIN_VERIFICATION = "extra_login_verification";
    public static final int LOGIN_TYPE_OAUTH = 2;
    public static final int LOGIN_TYPE_PWD = 0;
    public static final int LOGIN_TYPE_VERIFICATION = 1;
    private boolean isChecked;
    LoginPresenter loginPresenter;

    @BindView(C2113R.id.account)
    EditText mAccount;

    @BindView(C2113R.id.account_label)
    TextView mAccountLabel;

    @BindView(C2113R.id.clause)
    TextView mClause;

    @BindView(C2113R.id.confirm)
    TextView mConfirm;

    @BindView(C2113R.id.forget_pwd)
    TextView mForgetPwd;

    @BindView(C2113R.id.iv_clear)
    ImageView mIvClean;

    @BindView(C2113R.id.line_v)
    View mLineV;

    @BindView(C2113R.id.login_change)
    TextView mLoginChange;

    @BindView(C2113R.id.login_label)
    TextView mLoginLabel;

    @BindView(C2113R.id.pwd_eye)
    ImageView mPwdEye;

    @BindView(C2113R.id.pwd_group)
    Group mPwdGroup;

    @BindView(C2113R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(C2113R.id.user_pwd)
    EditText mUserPwd;
    private boolean pwdIsVisible = true;
    UMAuthListener authListener = new C6344a();

    /* renamed from: ui.activity.LoginActivity$a */
    class C6344a implements UMAuthListener {
        C6344a() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA share_media, int i2) {
            LoginActivity.this.hideProgressDialog();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA share_media, int i2, Map<String, String> map) {
            String str;
            int i3;
            LoginActivity.this.hideProgressDialog();
            if (share_media == SHARE_MEDIA.QQ) {
                i3 = AccountManager.LOGIN_QQ;
                str = map.get("openid");
                map.get("unionid");
            } else if (share_media == SHARE_MEDIA.WEIXIN) {
                i3 = AccountManager.LOGIN_WX;
                str = map.get("openid");
                map.get("unionid");
            } else if (share_media == SHARE_MEDIA.SINA) {
                i3 = AccountManager.LOGIN_SINA;
                str = map.get("uid");
            } else {
                str = "";
                i3 = 0;
            }
            map.get("iconurl");
            map.get(CommonNetImpl.NAME);
            LoginActivity.this.loginPresenter.oauthLogin(i3, str);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA share_media, int i2, Throwable th) {
            LoginActivity.this.hideProgressDialog();
            if (th.getMessage().contains("没有安装应用")) {
                C7331w1.m26688a("没有安装应用");
            }
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA share_media) {
            LoginActivity.this.showProgressDialog("登录中...");
        }
    }

    private void buttonStatus() {
        String trim = this.mAccount.getText().toString().trim();
        if (trim.length() > 0) {
            this.mIvClean.setVisibility(0);
        } else {
            this.mIvClean.setVisibility(4);
        }
        String trim2 = this.mUserPwd.getText().toString().trim();
        if (TextUtils.isEmpty(trim) || trim.length() != 11 || TextUtils.isEmpty(trim2) || trim2.length() < 6) {
            this.mConfirm.setEnabled(false);
        } else {
            this.mConfirm.setEnabled(true);
        }
    }

    private void doAuthLogin(SHARE_MEDIA share_media) {
        if (C7337y1.m26757a(this.mActivity, share_media)) {
            UMShareAPI.get(this.mActivity).getPlatformInfo(this.mActivity, share_media, this.authListener);
            return;
        }
        if (share_media == SHARE_MEDIA.WEIXIN) {
            C7331w1.m26688a("您未安装微信客户端");
        } else if (share_media == SHARE_MEDIA.QQ) {
            C7331w1.m26688a("您未安装QQ客户端");
        } else if (share_media == SHARE_MEDIA.SINA) {
            C7331w1.m26688a("您未安装新浪客户端");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doLogin, reason: merged with bridge method [inline-methods] */
    public void m25271b() {
        showProgressDialog("登录中...");
        this.loginPresenter.loginSubmit(this.mAccount.getText().toString().trim(), 0, this.mUserPwd.getText().toString().trim(), "");
    }

    private void initCluse(boolean z) {
        CharSequence m26728a = C7337y1.m26728a(this, z ? "新用户登录即完成注册，且表示您已同意\n" : "登录即同意", "和", "", "《服务协议》", "《隐私政策》");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(m26728a);
    }

    private void initListener() {
        this.mPwdEye.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m25268a(view);
            }
        });
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.h0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoginActivity.this.m25269a(compoundButton, z);
            }
        });
        C7268d1.m26310a(this.mAccount, this);
        C7268d1.m26310a(this.mUserPwd, this);
        initCluse(true);
        initCluse(false);
        buttonStatus();
    }

    private void judgeRegisterRegion(final AccountInfo accountInfo, int i2) {
        if (!TextUtils.isEmpty(accountInfo.getRegisterRegionName()) && !TextUtils.isEmpty(accountInfo.getRegisterRegionCode())) {
            LocalModuelConfig.getInstance().getConfigMude(accountInfo.getRegisterRegionCode(), new IResultCallback() { // from class: ui.activity.d0
                @Override // interfaces.IResultCallback
                public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                    LoginActivity.this.m25270a(accountInfo, regionMudelBean);
                }
            });
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) AddressActivity.class);
        intent.putExtra(C7292k1.f25380X0, i2);
        intent.putExtra(C7292k1.f25391c, accountInfo);
        startActivity(intent);
    }

    private void tip() {
        C7331w1.m26688a("请先勾选同意协议政策后再登录");
    }

    /* renamed from: a */
    public /* synthetic */ void m25268a(View view) {
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

    @Override // interfaces.IEditAfterListener
    public void editLength(int i2) {
        buttonStatus();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17156c);
        this.loginPresenter = new LoginPresenter(this.mActivity, this);
        initListener();
        C6049c.m24987f().m25001e(this);
        getPushData();
        C6088e.m25178a(this.mActivity);
        C7268d1.m26314b(this.mUserPwd);
        String visiblePhone = AccountManager.getVisiblePhone();
        if (TextUtils.isEmpty(visiblePhone)) {
            return;
        }
        this.mAccount.setText(visiblePhone);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        UMShareAPI.get(this).onActivityResult(i2, i3, intent);
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 155) {
            return;
        }
        ((ActivityManager) getSystemService("activity")).moveTaskToFront(getTaskId(), 1);
    }

    @Override // p388ui.callview.LoginCallView
    public void onLoginSuccRequest(APIresult<AccountInfo> aPIresult) {
        hideProgressDialog();
        if (aPIresult.getCode() != 0) {
            C7331w1.m26688a(aPIresult.getMsg());
            return;
        }
        AccountInfo data = aPIresult.getData();
        data.setLoginType(AccountManager.LOGIN_NORMAL);
        data.setVisiblePhone(this.mAccount.getText().toString().trim());
        judgeRegisterRegion(data, 1);
        C6088e.m25181a(data.getTags());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17156c);
    }

    @Override // p388ui.callview.LoginCallView
    public void onOathfail() {
        hideProgressDialog();
    }

    @Override // p388ui.callview.LoginCallView
    public void onOauthLoginSuccRequest(APIresult<AccountInfo> aPIresult, int i2, String str) {
        hideProgressDialog();
        int code = aPIresult.getCode();
        if (code == 0) {
            AccountInfo data = aPIresult.getData();
            data.setLoginType(i2);
            data.setVisiblePhone("");
            judgeRegisterRegion(data, 5);
            C6088e.m25181a(data.getTags());
            return;
        }
        if (code != 7) {
            C7331w1.m26688a(aPIresult.getMsg());
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) OauthRegisterActivity.class);
        intent.putExtra(C7292k1.f25357M, i2);
        intent.putExtra("open_id", str);
        startActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onStop() {
        super.onStop();
        hideProgressDialog();
        new Thread(new Runnable() { // from class: ui.activity.g0
            @Override // java.lang.Runnable
            public final void run() {
                LoginActivity.this.m25267a();
            }
        }).start();
    }

    @OnClick({C2113R.id.confirm, C2113R.id.iv_clear, C2113R.id.login_change, C2113R.id.forget_pwd, C2113R.id.iv_wx_login, C2113R.id.iv_qq_login, C2113R.id.iv_sina_login})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        hideSoftInput();
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                if (!this.isChecked) {
                    tip();
                    break;
                } else if (!C7337y1.m26760a(C7307p1.f25508q, true)) {
                    m25271b();
                    break;
                } else {
                    toYanzheng(new IOneClickListener() { // from class: ui.activity.f0
                        @Override // interfaces.IOneClickListener
                        public final void clickOKBtn() {
                            LoginActivity.this.m25271b();
                        }
                    });
                    break;
                }
            case C2113R.id.forget_pwd /* 2131296661 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) ForgetPdwOneActivity.class);
                if (this.mAccount.length() > 0) {
                    intent.putExtra(C7292k1.f25398e0, this.mAccount.getText().toString());
                }
                startActivity(intent);
                break;
            case C2113R.id.iv_clear /* 2131296772 */:
                this.mAccount.setText("");
                buttonStatus();
                break;
            case C2113R.id.iv_qq_login /* 2131296819 */:
                if (!this.isChecked) {
                    tip();
                    break;
                } else {
                    doAuthLogin(SHARE_MEDIA.QQ);
                    break;
                }
            case C2113R.id.iv_sina_login /* 2131296832 */:
                if (!this.isChecked) {
                    tip();
                    break;
                } else {
                    doAuthLogin(SHARE_MEDIA.SINA);
                    break;
                }
            case C2113R.id.iv_wx_login /* 2131296868 */:
                if (!this.isChecked) {
                    tip();
                    break;
                } else {
                    doAuthLogin(SHARE_MEDIA.WEIXIN);
                    break;
                }
            case C2113R.id.login_change /* 2131297008 */:
                startActivity(AddressActivity.class);
                break;
        }
    }

    @Override // p388ui.callview.LoginCallView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_login;
    }

    /* renamed from: a */
    public /* synthetic */ void m25269a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }

    /* renamed from: a */
    public /* synthetic */ void m25267a() {
        if (C7330w0.m26684a(this.mActivity)) {
            return;
        }
        Looper.prepare();
        C7331w1.m26688a("APP已进入后台，请确认操作环境是否安全~");
        Looper.loop();
    }

    /* renamed from: a */
    public /* synthetic */ void m25270a(AccountInfo accountInfo, RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            AccountManager.saveAccount(accountInfo);
            C7337y1.m26748a((Context) this.mActivity, (Class<?>) MainActivity.class);
            finish();
            return;
        }
        C7331w1.m26688a("暂无地区配置数据");
    }
}
