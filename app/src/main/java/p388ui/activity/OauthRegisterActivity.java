package p388ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.util.List;
import manager.AccountManager;
import network.account.APIresult;
import network.account.AccountInfo;
import network.http.RegionConfigHttp;
import p388ui.Hicore;
import p388ui.callview.RegisterlView;
import p388ui.presenter.RegisterPresenter;
import p388ui.view.CodeCutTimeTextView;
import receiver.C6088e;
import util.C7257b1;
import util.C7292k1;
import util.C7307p1;
import util.C7331w1;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class OauthRegisterActivity extends BaseActivity implements TextWatcher, RegisterlView {
    private boolean isChecked;

    @BindView(C2113R.id.account)
    EditText mAccount;

    @BindView(C2113R.id.clause)
    TextView mClause;

    @BindView(C2113R.id.confirm)
    TextView mConfirm;

    @BindView(C2113R.id.iv_clear)
    ImageView mIvClean;
    RegisterPresenter mPresenter;
    private String mStrAccount;

    @BindView(C2113R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(C2113R.id.tv_resend)
    CodeCutTimeTextView mTvReset;

    @BindView(C2113R.id.user_code)
    EditText mUserCode;
    private String openId;
    private int pltmId;

    /* renamed from: ui.activity.OauthRegisterActivity$a */
    class C6399a implements PermissionsListener {
        C6399a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            OauthRegisterActivity.this.registerSubmit();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            OauthRegisterActivity.this.registerSubmit();
        }
    }

    /* renamed from: ui.activity.OauthRegisterActivity$b */
    class C6400b implements IClickListener {
        C6400b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (OauthRegisterActivity.this.pltmId > 0) {
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                if (OauthRegisterActivity.this.pltmId == AccountManager.LOGIN_QQ) {
                    share_media = SHARE_MEDIA.QQ;
                } else if (OauthRegisterActivity.this.pltmId == AccountManager.LOGIN_WX) {
                    share_media = SHARE_MEDIA.WEIXIN;
                } else if (OauthRegisterActivity.this.pltmId == AccountManager.LOGIN_SINA) {
                    share_media = SHARE_MEDIA.SINA;
                }
                UMShareAPI.get(OauthRegisterActivity.this.mActivity).deleteOauth(OauthRegisterActivity.this.mActivity, share_media, null);
                OauthRegisterActivity.this.mActivity.finish();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25531j}, new C6399a());
    }

    private void enableConfirm() {
        this.mStrAccount = this.mAccount.getText().toString().trim();
        if (TextUtils.isEmpty(this.mUserCode.getText().toString().trim()) || TextUtils.isEmpty(this.mStrAccount)) {
            this.mIvClean.setVisibility(4);
            this.mConfirm.setEnabled(false);
            this.mIvClean.setVisibility(8);
        } else {
            this.mIvClean.setVisibility(0);
            this.mConfirm.setEnabled(true);
            this.mIvClean.setVisibility(0);
        }
    }

    private void initCluse() {
        CharSequence m26728a = C7337y1.m26728a(this, "注册即同意", "和", "", "《服务协议》", "《隐私政策》");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(m26728a);
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.m0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                OauthRegisterActivity.this.m25298a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerSubmit() {
        this.mStrAccount = this.mAccount.getText().toString().trim();
        String trim = this.mUserCode.getText().toString().trim();
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        if (this.mStrAccount.length() != 11) {
            C7331w1.m26688a("请输入正确手机号");
        } else if (trim.length() < 4) {
            C7331w1.m26688a("请输入正确验证码");
        } else {
            this.mPresenter.oauthBindAccount(this.mStrAccount, trim, nodeRegionId, this.pltmId, this.openId);
        }
    }

    private void showCancleDlg() {
        C7257b1.m26184a(this.mActivity, "确认放弃登录?", "必须绑定手机号才能登录，为了您的账号安全建议绑定", "放弃登录", "继续绑定", -1, -1, true, (IClickListener) new C6400b());
    }

    /* renamed from: a */
    public /* synthetic */ void m25297a() {
        this.mPresenter.verificationSubmit(5, this.mStrAccount, this.mTvReset);
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
        this.mPresenter = new RegisterPresenter(this, this);
        this.pltmId = getIntent().getIntExtra(C7292k1.f25357M, 0);
        this.openId = getIntent().getStringExtra("open_id");
        this.mTvReset.m25757a(true);
        this.mUserCode.addTextChangedListener(this);
        initCluse();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        showCancleDlg();
        return true;
    }

    @Override // p388ui.callview.RegisterlView
    public void onOauthSuccRequest(APIresult<AccountInfo> aPIresult) {
        int code = aPIresult.getCode();
        if (code == 0) {
            AccountInfo data = aPIresult.getData();
            data.setLoginType(this.pltmId);
            data.setVisiblePhone(this.mStrAccount);
            AccountManager.saveAccount(data);
            C7337y1.m26748a((Context) this.mActivity, (Class<?>) MainActivity.class);
            C6088e.m25181a(data.getTags());
            this.mActivity.finish();
            return;
        }
        if (code != 11) {
            String msg = aPIresult.getMsg();
            if (TextUtils.isEmpty(msg)) {
                C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.err_system));
                return;
            } else {
                C7331w1.m26688a(msg);
                return;
            }
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setLoginType(this.pltmId);
        accountInfo.setOpenId(this.openId);
        accountInfo.setPhoneNum(this.mStrAccount);
        Intent intent = new Intent(this.mActivity, (Class<?>) AddressActivity.class);
        intent.putExtra(C7292k1.f25391c, accountInfo);
        intent.putExtra(C7292k1.f25380X0, 6);
        startActivity(intent);
    }

    @Override // p388ui.callview.RegisterlView
    public void onSuccRequest(APIresult<AccountInfo> aPIresult) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_clear, C2113R.id.confirm, C2113R.id.tv_resend})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                if (!this.isChecked) {
                    C7331w1.m26688a("请先勾选同意协议政策后再确定");
                    break;
                } else {
                    checkPermission();
                    break;
                }
            case C2113R.id.iv_back /* 2131296762 */:
                showCancleDlg();
                break;
            case C2113R.id.iv_clear /* 2131296772 */:
                this.mUserCode.setText("");
                break;
            case C2113R.id.tv_resend /* 2131297692 */:
                this.mStrAccount = this.mAccount.getText().toString().trim();
                if (!TextUtils.isEmpty(this.mStrAccount) && this.mStrAccount.length() == 11) {
                    if (!C7337y1.m26760a(C7307p1.f25509r, true)) {
                        this.mPresenter.verificationSubmit(5, this.mStrAccount, this.mTvReset);
                        break;
                    } else {
                        toYanzheng(new IOneClickListener() { // from class: ui.activity.n0
                            @Override // interfaces.IOneClickListener
                            public final void clickOKBtn() {
                                OauthRegisterActivity.this.m25297a();
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
        return C2113R.layout.activity_oauth_register;
    }

    /* renamed from: a */
    public /* synthetic */ void m25298a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }
}
