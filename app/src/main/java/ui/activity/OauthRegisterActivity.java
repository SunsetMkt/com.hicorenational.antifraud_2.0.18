package ui.activity;

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
import com.hicorenational.antifraud.R;
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
import ui.Hicore;
import ui.callview.RegisterlView;
import ui.presenter.RegisterPresenter;
import ui.view.CodeCutTimeTextView;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class OauthRegisterActivity extends BaseActivity implements TextWatcher, RegisterlView {
    private boolean isChecked;

    @BindView(R.id.account)
    EditText mAccount;

    @BindView(R.id.clause)
    TextView mClause;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;
    RegisterPresenter mPresenter;
    private String mStrAccount;

    @BindView(R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(R.id.tv_resend)
    CodeCutTimeTextView mTvReset;

    @BindView(R.id.user_code)
    EditText mUserCode;
    private String openId;
    private int pltmId;

    class a implements PermissionsListener {
        a() {
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

    class b implements IClickListener {
        b() {
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
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f15033j}, new a());
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
        CharSequence charSequenceA = g2.a(this, "\u6ce8\u518c\u5373\u540c\u610f", "\u548c", "", "\u300a\u670d\u52a1\u534f\u8bae\u300b", "\u300a\u9690\u79c1\u653f\u7b56\u300b");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(charSequenceA);
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.o0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerSubmit() {
        this.mStrAccount = this.mAccount.getText().toString().trim();
        String strTrim = this.mUserCode.getText().toString().trim();
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        if (this.mStrAccount.length() != 11) {
            e2.a("\u8bf7\u8f93\u5165\u6b63\u786e\u624b\u673a\u53f7");
        } else if (strTrim.length() < 4) {
            e2.a("\u8bf7\u8f93\u5165\u6b63\u786e\u9a8c\u8bc1\u7801");
        } else {
            this.mPresenter.oauthBindAccount(this.mStrAccount, strTrim, nodeRegionId, this.pltmId, this.openId);
        }
    }

    private void showCancleDlg() {
        util.f1.a(this.mActivity, "\u786e\u8ba4\u653e\u5f03\u767b\u5f55?", "\u5fc5\u987b\u7ed1\u5b9a\u624b\u673a\u53f7\u624d\u80fd\u767b\u5f55\uff0c\u4e3a\u4e86\u60a8\u7684\u8d26\u53f7\u5b89\u5168\u5efa\u8bae\u7ed1\u5b9a", "\u653e\u5f03\u767b\u5f55", "\u7ee7\u7eed\u7ed1\u5b9a", -1, -1, true, (IClickListener) new b());
    }

    public /* synthetic */ void a() {
        this.mPresenter.verificationSubmit(5, this.mStrAccount, this.mTvReset);
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
        this.mPresenter = new RegisterPresenter(this, this);
        this.pltmId = getIntent().getIntExtra(util.p1.M, 0);
        this.openId = getIntent().getStringExtra("open_id");
        this.mTvReset.a(true);
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

    @Override // ui.callview.RegisterlView
    public void onOauthSuccRequest(APIresult<AccountInfo> aPIresult) {
        int code = aPIresult.getCode();
        if (code == 0) {
            AccountInfo data = aPIresult.getData();
            data.setLoginType(this.pltmId);
            data.setVisiblePhone(this.mStrAccount);
            AccountManager.saveAccount(data);
            g2.a((Context) this.mActivity, (Class<?>) MainActivity.class);
            receiver.e.a(data.getTags());
            this.mActivity.finish();
            return;
        }
        if (code != 11) {
            String msg = aPIresult.getMsg();
            if (TextUtils.isEmpty(msg)) {
                e2.a(Hicore.getApp().getResources().getString(R.string.err_system));
                return;
            } else {
                e2.a(msg);
                return;
            }
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setLoginType(this.pltmId);
        accountInfo.setOpenId(this.openId);
        accountInfo.setPhoneNum(this.mStrAccount);
        Intent intent = new Intent(this.mActivity, (Class<?>) AddressActivity.class);
        intent.putExtra(util.p1.f15011c, accountInfo);
        intent.putExtra(util.p1.X0, 6);
        startActivity(intent);
    }

    @Override // ui.callview.RegisterlView
    public void onSuccRequest(APIresult<AccountInfo> aPIresult) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({R.id.iv_back, R.id.iv_clear, R.id.confirm, R.id.tv_resend})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296501 */:
                if (!this.isChecked) {
                    e2.a("\u8bf7\u5148\u52fe\u9009\u540c\u610f\u534f\u8bae\u653f\u7b56\u540e\u518d\u786e\u5b9a");
                } else {
                    checkPermission();
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                showCancleDlg();
                break;
            case R.id.iv_clear /* 2131296818 */:
                this.mUserCode.setText("");
                break;
            case R.id.tv_resend /* 2131297853 */:
                this.mStrAccount = this.mAccount.getText().toString().trim();
                if (TextUtils.isEmpty(this.mStrAccount) || this.mStrAccount.length() != 11) {
                    e2.a("\u8bf7\u8f93\u5165\u6b63\u786e\u624b\u673a\u53f7~");
                } else if (!g2.a(util.u1.r, true)) {
                    this.mPresenter.verificationSubmit(5, this.mStrAccount, this.mTvReset);
                } else {
                    toYanzheng(new IOneClickListener() { // from class: ui.activity.p0
                        @Override // interfaces.IOneClickListener
                        public final void clickOKBtn() {
                            this.a.a();
                        }
                    });
                }
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_oauth_register;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }
}
