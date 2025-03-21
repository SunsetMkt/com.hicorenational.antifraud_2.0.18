package p388ui.activity;

import android.app.Activity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IEditAfterListener;
import manager.LoginManager;
import p388ui.callview.ForgetPwdCallView;
import p388ui.presenter.ForgetPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7268d1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ForgetPdwResetActivity extends BaseActivity implements IEditAfterListener, ForgetPwdCallView {
    private ForgetPresenter forgetPresenter;

    @BindView(C2113R.id.confirm)
    TextView mConfim;

    @BindView(C2113R.id.et_new_pwd)
    EditText mEtNewPwd;

    @BindView(C2113R.id.pwd_eye)
    ImageView mPwdEye;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private String phoneCode;
    private String phoneNum;
    private boolean pwdIsVisible = true;

    private void initListener() {
        this.mPwdEye.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgetPdwResetActivity.this.m25241a(view);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25241a(View view) {
        if (this.pwdIsVisible) {
            this.mPwdEye.setImageResource(C2113R.mipmap.eye_sel);
            this.mEtNewPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.mPwdEye.setImageResource(C2113R.mipmap.eye_nor);
            this.mEtNewPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        this.pwdIsVisible = !this.pwdIsVisible;
        if (!this.mEtNewPwd.isFocused()) {
            this.mEtNewPwd.setFocusable(true);
            this.mEtNewPwd.setFocusableInTouchMode(true);
            this.mEtNewPwd.requestFocus();
            this.mEtNewPwd.requestFocusFromTouch();
        }
        EditText editText = this.mEtNewPwd;
        editText.setSelection(editText.getText().toString().length());
    }

    @Override // interfaces.IEditAfterListener
    public void editLength(int i2) {
        if (this.mEtNewPwd.getText().toString().length() >= 6) {
            this.mConfim.setEnabled(true);
        } else {
            this.mConfim.setEnabled(false);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        C7161b.m25698a((Activity) this, true, true);
        this.mTvTitle.setText("");
        initListener();
        this.forgetPresenter = new ForgetPresenter(this.mActivity, this);
        C7268d1.m26310a(this.mEtNewPwd, this);
        C7268d1.m26314b(this.mEtNewPwd);
        showSoftInput(this.mEtNewPwd);
        this.phoneNum = getIntent().getStringExtra(C7292k1.f25343F);
        this.phoneCode = getIntent().getStringExtra(C7292k1.f25345G);
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onChangeMobileSuccRequest() {
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onSuccRequest(int i2) {
        C7331w1.m26688a("密码设置成功，请重新登录");
        LoginManager.getInstance().exitToLogin();
    }

    @Override // p388ui.callview.ForgetPwdCallView
    public void onSuccessLoginOut() {
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.confirm) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
        } else {
            this.forgetPresenter.resetPwd(this.phoneNum, this.phoneCode, this.mEtNewPwd.getText().toString());
            hideSoftInput();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_forger_reset;
    }
}
