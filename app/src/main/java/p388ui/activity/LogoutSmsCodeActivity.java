package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IOneClickListener;
import manager.AccountManager;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5539g1;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.LogoutSmsCodeView;
import p388ui.presenter.LogoutSmsCodePresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.CodeCutTimeTextView;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7307p1;
import util.C7331w1;
import util.C7337y1;

/* compiled from: LogoutSmsCodeActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u00020.H\u0016J\b\u00103\u001a\u000204H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, m23546d2 = {"Lui/activity/LogoutSmsCodeActivity;", "Lui/activity/BaseActivity;", "Lui/callview/LogoutSmsCodeView;", "()V", "mConfim", "Landroid/widget/Button;", "getMConfim", "()Landroid/widget/Button;", "setMConfim", "(Landroid/widget/Button;)V", "mEtPhoneNum", "Landroid/widget/EditText;", "getMEtPhoneNum", "()Landroid/widget/EditText;", "setMEtPhoneNum", "(Landroid/widget/EditText;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPhoneCode", "getMPhoneCode", "setMPhoneCode", "mPresenter", "Lui/presenter/LogoutSmsCodePresenter;", "getMPresenter", "()Lui/presenter/LogoutSmsCodePresenter;", "setMPresenter", "(Lui/presenter/LogoutSmsCodePresenter;)V", "mTvReSend", "Lui/view/CodeCutTimeTextView;", "getMTvReSend", "()Lui/view/CodeCutTimeTextView;", "setMTvReSend", "(Lui/view/CodeCutTimeTextView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "reaseon", "", "initPage", "", "onClick", "view", "Landroid/view/View;", "onSuccessRequest", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutSmsCodeActivity extends BaseActivity implements LogoutSmsCodeView {

    @BindView(C2113R.id.confirm)
    @InterfaceC5816d
    public Button mConfim;

    @BindView(C2113R.id.et_phone_num)
    @InterfaceC5816d
    public EditText mEtPhoneNum;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.phone_code)
    @InterfaceC5816d
    public EditText mPhoneCode;

    @InterfaceC5817e
    private LogoutSmsCodePresenter mPresenter;

    @BindView(C2113R.id.tv_resend)
    @InterfaceC5816d
    public CodeCutTimeTextView mTvReSend;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private String reaseon = "";

    /* compiled from: LogoutSmsCodeActivity.kt */
    /* renamed from: ui.activity.LogoutSmsCodeActivity$a */
    static final class C6362a implements IOneClickListener {

        /* renamed from: b */
        final /* synthetic */ C5539g1.h f22500b;

        C6362a(C5539g1.h hVar) {
            this.f22500b = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // interfaces.IOneClickListener
        public final void clickOKBtn() {
            LogoutSmsCodePresenter mPresenter = LogoutSmsCodeActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.verificationSubmit((String) this.f22500b.element, 7, LogoutSmsCodeActivity.this.getMTvReSend());
            }
        }
    }

    @InterfaceC5816d
    public final Button getMConfim() {
        Button button = this.mConfim;
        if (button == null) {
            C5544i0.m22554k("mConfim");
        }
        return button;
    }

    @InterfaceC5816d
    public final EditText getMEtPhoneNum() {
        EditText editText = this.mEtPhoneNum;
        if (editText == null) {
            C5544i0.m22554k("mEtPhoneNum");
        }
        return editText;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final EditText getMPhoneCode() {
        EditText editText = this.mPhoneCode;
        if (editText == null) {
            C5544i0.m22554k("mPhoneCode");
        }
        return editText;
    }

    @InterfaceC5817e
    public final LogoutSmsCodePresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final CodeCutTimeTextView getMTvReSend() {
        CodeCutTimeTextView codeCutTimeTextView = this.mTvReSend;
        if (codeCutTimeTextView == null) {
            C5544i0.m22554k("mTvReSend");
        }
        return codeCutTimeTextView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        Activity activity = this.mActivity;
        C5544i0.m22521a((Object) activity, "mActivity");
        this.mPresenter = new LogoutSmsCodePresenter(activity, this);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("注销账号");
        String stringExtra = getIntent().getStringExtra(C7292k1.f25401f0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.reaseon = stringExtra;
        EditText editText = this.mEtPhoneNum;
        if (editText == null) {
            C5544i0.m22554k("mEtPhoneNum");
        }
        if (editText == null) {
            C5544i0.m22545f();
        }
        editText.setText(AccountManager.getVisiblePhone());
        CodeCutTimeTextView codeCutTimeTextView = this.mTvReSend;
        if (codeCutTimeTextView == null) {
            C5544i0.m22554k("mTvReSend");
        }
        codeCutTimeTextView.setEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.String] */
    @OnClick({C2113R.id.iv_back, C2113R.id.tv_resend, C2113R.id.iv_clear, C2113R.id.confirm})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                EditText editText = this.mEtPhoneNum;
                if (editText == null) {
                    C5544i0.m22554k("mEtPhoneNum");
                }
                String obj = editText.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    EditText editText2 = this.mEtPhoneNum;
                    if (editText2 == null) {
                        C5544i0.m22554k("mEtPhoneNum");
                    }
                    if (editText2.length() >= 11) {
                        EditText editText3 = this.mPhoneCode;
                        if (editText3 == null) {
                            C5544i0.m22554k("mPhoneCode");
                        }
                        String obj2 = editText3.getText().toString();
                        if (!TextUtils.isEmpty(obj2)) {
                            LogoutSmsCodePresenter logoutSmsCodePresenter = this.mPresenter;
                            if (logoutSmsCodePresenter != null) {
                                logoutSmsCodePresenter.verificationCode(obj, obj2, 7);
                                break;
                            }
                        } else {
                            C7331w1.m26688a("输入验证码~");
                            break;
                        }
                    } else {
                        C7331w1.m26688a("请输入正确手机号");
                        break;
                    }
                } else {
                    C7331w1.m26688a("请填写当前账号手机号码");
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.iv_clear /* 2131296772 */:
                EditText editText4 = this.mEtPhoneNum;
                if (editText4 == null) {
                    C5544i0.m22554k("mEtPhoneNum");
                }
                editText4.setText("");
                break;
            case C2113R.id.tv_resend /* 2131297692 */:
                C5539g1.h hVar = new C5539g1.h();
                EditText editText5 = this.mEtPhoneNum;
                if (editText5 == null) {
                    C5544i0.m22554k("mEtPhoneNum");
                }
                hVar.element = editText5.getText().toString();
                if (!TextUtils.isEmpty((String) hVar.element)) {
                    EditText editText6 = this.mEtPhoneNum;
                    if (editText6 == null) {
                        C5544i0.m22554k("mEtPhoneNum");
                    }
                    if (editText6.length() >= 11) {
                        if (!C7337y1.m26760a(C7307p1.f25514w, true)) {
                            LogoutSmsCodePresenter logoutSmsCodePresenter2 = this.mPresenter;
                            if (logoutSmsCodePresenter2 != null) {
                                String str = (String) hVar.element;
                                CodeCutTimeTextView codeCutTimeTextView = this.mTvReSend;
                                if (codeCutTimeTextView == null) {
                                    C5544i0.m22554k("mTvReSend");
                                }
                                logoutSmsCodePresenter2.verificationSubmit(str, 7, codeCutTimeTextView);
                                break;
                            }
                        } else {
                            toYanzheng(new C6362a(hVar));
                            break;
                        }
                    } else {
                        C7331w1.m26688a("请输入正确手机号");
                        break;
                    }
                } else {
                    C7331w1.m26688a("请填写当前账号手机号码");
                    break;
                }
                break;
        }
    }

    @Override // p388ui.callview.LogoutSmsCodeView
    public void onSuccessRequest() {
        Intent intent = new Intent(this.mActivity, (Class<?>) LogoutConfirmActivity.class);
        intent.putExtra(C7292k1.f25401f0, this.reaseon);
        startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_logout_sms_code;
    }

    public final void setMConfim(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mConfim = button;
    }

    public final void setMEtPhoneNum(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtPhoneNum = editText;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPhoneCode(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mPhoneCode = editText;
    }

    public final void setMPresenter(@InterfaceC5817e LogoutSmsCodePresenter logoutSmsCodePresenter) {
        this.mPresenter = logoutSmsCodePresenter;
    }

    public final void setMTvReSend(@InterfaceC5816d CodeCutTimeTextView codeCutTimeTextView) {
        C5544i0.m22546f(codeCutTimeTextView, "<set-?>");
        this.mTvReSend = codeCutTimeTextView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
