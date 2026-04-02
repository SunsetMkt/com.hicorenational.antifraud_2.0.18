package ui.activity;

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
import com.hicorenational.antifraud.R;
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
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.LoginCallView;
import ui.presenter.LoginPresenter;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class LoginActivity extends BaseActivity implements IEditAfterListener, LoginCallView {
    public static final String EXTRA_LOGIN_ACCOUNT = "extra_login_account";
    public static final String EXTRA_LOGIN_VERIFICATION = "extra_login_verification";
    public static final int LOGIN_TYPE_OAUTH = 2;
    public static final int LOGIN_TYPE_PWD = 0;
    public static final int LOGIN_TYPE_VERIFICATION = 1;
    private boolean isChecked;
    LoginPresenter loginPresenter;

    @BindView(R.id.account)
    EditText mAccount;

    @BindView(R.id.account_label)
    TextView mAccountLabel;

    @BindView(R.id.clause)
    TextView mClause;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.forget_pwd)
    TextView mForgetPwd;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.line_v)
    View mLineV;

    @BindView(R.id.login_change)
    TextView mLoginChange;

    @BindView(R.id.login_label)
    TextView mLoginLabel;

    @BindView(R.id.pwd_eye)
    ImageView mPwdEye;

    @BindView(R.id.pwd_group)
    Group mPwdGroup;

    @BindView(R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(R.id.user_pwd)
    EditText mUserPwd;
    private boolean pwdIsVisible = true;
    UMAuthListener authListener = new a();

    class a implements UMAuthListener {
        a() {
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
            if (th.getMessage().contains("\u6ca1\u6709\u5b89\u88c5\u5e94\u7528")) {
                e2.a("\u6ca1\u6709\u5b89\u88c5\u5e94\u7528");
            }
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA share_media) {
            LoginActivity.this.showProgressDialog("\u767b\u5f55\u4e2d...");
        }
    }

    private void buttonStatus() {
        String strTrim = this.mAccount.getText().toString().trim();
        if (strTrim.length() > 0) {
            this.mIvClean.setVisibility(0);
        } else {
            this.mIvClean.setVisibility(4);
        }
        String strTrim2 = this.mUserPwd.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || strTrim.length() != 11 || TextUtils.isEmpty(strTrim2) || strTrim2.length() < 6) {
            this.mConfirm.setEnabled(false);
        } else {
            this.mConfirm.setEnabled(true);
        }
    }

    private void doAuthLogin(SHARE_MEDIA share_media) {
        if (g2.a(this.mActivity, share_media)) {
            UMShareAPI.get(this.mActivity).getPlatformInfo(this.mActivity, share_media, this.authListener);
            return;
        }
        if (share_media == SHARE_MEDIA.WEIXIN) {
            e2.a("\u60a8\u672a\u5b89\u88c5\u5fae\u4fe1\u5ba2\u6237\u7aef");
        } else if (share_media == SHARE_MEDIA.QQ) {
            e2.a("\u60a8\u672a\u5b89\u88c5QQ\u5ba2\u6237\u7aef");
        } else if (share_media == SHARE_MEDIA.SINA) {
            e2.a("\u60a8\u672a\u5b89\u88c5\u65b0\u6d6a\u5ba2\u6237\u7aef");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doLogin, reason: merged with bridge method [inline-methods] */
    public void b() {
        showProgressDialog("\u767b\u5f55\u4e2d...");
        this.loginPresenter.loginSubmit(this.mAccount.getText().toString().trim(), 0, this.mUserPwd.getText().toString().trim(), "");
    }

    private void initCluse(boolean z) {
        CharSequence charSequenceA = g2.a(this, z ? "\u65b0\u7528\u6237\u767b\u5f55\u5373\u5b8c\u6210\u6ce8\u518c\uff0c\u4e14\u8868\u793a\u60a8\u5df2\u540c\u610f\n" : "\u767b\u5f55\u5373\u540c\u610f", "\u548c", "", "\u300a\u670d\u52a1\u534f\u8bae\u300b", "\u300a\u9690\u79c1\u653f\u7b56\u300b");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(charSequenceA);
    }

    private void initListener() {
        this.mPwdEye.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(view);
            }
        });
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.j0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.a(compoundButton, z);
            }
        });
        util.h1.a(this.mAccount, this);
        util.h1.a(this.mUserPwd, this);
        initCluse(true);
        initCluse(false);
        buttonStatus();
    }

    private void judgeRegisterRegion(final AccountInfo accountInfo, int i2) {
        if (!TextUtils.isEmpty(accountInfo.getRegisterRegionName()) && !TextUtils.isEmpty(accountInfo.getRegisterRegionCode())) {
            LocalModuelConfig.getInstance().getConfigMude(accountInfo.getRegisterRegionCode(), new IResultCallback() { // from class: ui.activity.f0
                @Override // interfaces.IResultCallback
                public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                    this.a.a(accountInfo, regionMudelBean);
                }
            });
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) AddressActivity.class);
        intent.putExtra(util.p1.X0, i2);
        intent.putExtra(util.p1.f15011c, accountInfo);
        startActivity(intent);
    }

    private void tip() {
        e2.a("\u8bf7\u5148\u52fe\u9009\u540c\u610f\u534f\u8bae\u653f\u7b56\u540e\u518d\u767b\u5f55");
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

    @Override // interfaces.IEditAfterListener
    public void editLength(int i2) {
        buttonStatus();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10203c);
        this.loginPresenter = new LoginPresenter(this.mActivity, this);
        initListener();
        org.greenrobot.eventbus.c.f().e(this);
        getPushData();
        receiver.e.a(this.mActivity);
        util.h1.b(this.mUserPwd);
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

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 155) {
            return;
        }
        ((ActivityManager) getSystemService("activity")).moveTaskToFront(getTaskId(), 1);
    }

    @Override // ui.callview.LoginCallView
    public void onLoginSuccRequest(APIresult<AccountInfo> aPIresult) {
        hideProgressDialog();
        if (aPIresult.getCode() != 0) {
            e2.a(aPIresult.getMsg());
            return;
        }
        AccountInfo data = aPIresult.getData();
        data.setLoginType(AccountManager.LOGIN_NORMAL);
        data.setVisiblePhone(this.mAccount.getText().toString().trim());
        judgeRegisterRegion(data, 1);
        receiver.e.a(data.getTags());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10203c);
    }

    @Override // ui.callview.LoginCallView
    public void onOathfail() {
        hideProgressDialog();
    }

    @Override // ui.callview.LoginCallView
    public void onOauthLoginSuccRequest(APIresult<AccountInfo> aPIresult, int i2, String str) {
        hideProgressDialog();
        int code = aPIresult.getCode();
        if (code == 0) {
            AccountInfo data = aPIresult.getData();
            data.setLoginType(i2);
            data.setVisiblePhone("");
            judgeRegisterRegion(data, 5);
            receiver.e.a(data.getTags());
            return;
        }
        if (code != 7) {
            e2.a(aPIresult.getMsg());
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) OauthRegisterActivity.class);
        intent.putExtra(util.p1.M, i2);
        intent.putExtra("open_id", str);
        startActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onStop() {
        super.onStop();
        hideProgressDialog();
        new Thread(new Runnable() { // from class: ui.activity.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        }).start();
    }

    @OnClick({R.id.confirm, R.id.iv_clear, R.id.login_change, R.id.forget_pwd, R.id.iv_wx_login, R.id.iv_qq_login, R.id.iv_sina_login})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        hideSoftInput();
        switch (view.getId()) {
            case R.id.confirm /* 2131296501 */:
                if (!this.isChecked) {
                    tip();
                } else if (!g2.a(util.u1.q, true)) {
                    b();
                } else {
                    toYanzheng(new IOneClickListener() { // from class: ui.activity.h0
                        @Override // interfaces.IOneClickListener
                        public final void clickOKBtn() {
                            this.a.b();
                        }
                    });
                }
                break;
            case R.id.forget_pwd /* 2131296698 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) ForgetPdwOneActivity.class);
                if (this.mAccount.length() > 0) {
                    intent.putExtra(util.p1.e0, this.mAccount.getText().toString());
                }
                startActivity(intent);
                break;
            case R.id.iv_clear /* 2131296818 */:
                this.mAccount.setText("");
                buttonStatus();
                break;
            case R.id.iv_qq_login /* 2131296867 */:
                if (!this.isChecked) {
                    tip();
                } else {
                    doAuthLogin(SHARE_MEDIA.QQ);
                }
                break;
            case R.id.iv_sina_login /* 2131296880 */:
                if (!this.isChecked) {
                    tip();
                } else {
                    doAuthLogin(SHARE_MEDIA.SINA);
                }
                break;
            case R.id.iv_wx_login /* 2131296916 */:
                if (!this.isChecked) {
                    tip();
                } else {
                    doAuthLogin(SHARE_MEDIA.WEIXIN);
                }
                break;
            case R.id.login_change /* 2131297058 */:
                startActivity(AddressActivity.class);
                break;
        }
    }

    @Override // ui.callview.LoginCallView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_login;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }

    public /* synthetic */ void a() {
        if (util.z0.a(this.mActivity)) {
            return;
        }
        Looper.prepare();
        e2.a("APP\u5df2\u8fdb\u5165\u540e\u53f0\uff0c\u8bf7\u786e\u8ba4\u64cd\u4f5c\u73af\u5883\u662f\u5426\u5b89\u5168~");
        Looper.loop();
    }

    public /* synthetic */ void a(AccountInfo accountInfo, RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            AccountManager.saveAccount(accountInfo);
            g2.a((Context) this.mActivity, (Class<?>) MainActivity.class);
            finish();
            return;
        }
        e2.a("\u6682\u65e0\u5730\u533a\u914d\u7f6e\u6570\u636e");
    }
}
