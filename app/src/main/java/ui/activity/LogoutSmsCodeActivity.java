package ui.activity;

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
import com.hicorenational.antifraud.R;
import i.q2.t.g1;
import interfaces.IOneClickListener;
import manager.AccountManager;
import ui.callview.LogoutSmsCodeView;
import ui.presenter.LogoutSmsCodePresenter;
import ui.view.CodeCutTimeTextView;
import ui.view.swip.SwipBackLayout;
import util.e2;
import util.g2;

/* JADX INFO: compiled from: LogoutSmsCodeActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u00020.H\u0016J\b\u00103\u001a\u000204H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lui/activity/LogoutSmsCodeActivity;", "Lui/activity/BaseActivity;", "Lui/callview/LogoutSmsCodeView;", "()V", "mConfim", "Landroid/widget/Button;", "getMConfim", "()Landroid/widget/Button;", "setMConfim", "(Landroid/widget/Button;)V", "mEtPhoneNum", "Landroid/widget/EditText;", "getMEtPhoneNum", "()Landroid/widget/EditText;", "setMEtPhoneNum", "(Landroid/widget/EditText;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPhoneCode", "getMPhoneCode", "setMPhoneCode", "mPresenter", "Lui/presenter/LogoutSmsCodePresenter;", "getMPresenter", "()Lui/presenter/LogoutSmsCodePresenter;", "setMPresenter", "(Lui/presenter/LogoutSmsCodePresenter;)V", "mTvReSend", "Lui/view/CodeCutTimeTextView;", "getMTvReSend", "()Lui/view/CodeCutTimeTextView;", "setMTvReSend", "(Lui/view/CodeCutTimeTextView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "reaseon", "", "initPage", "", "onClick", "view", "Landroid/view/View;", "onSuccessRequest", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class LogoutSmsCodeActivity extends BaseActivity implements LogoutSmsCodeView {

    @BindView(R.id.confirm)
    @j.c.a.d
    public Button mConfim;

    @BindView(R.id.et_phone_num)
    @j.c.a.d
    public EditText mEtPhoneNum;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.phone_code)
    @j.c.a.d
    public EditText mPhoneCode;

    @j.c.a.e
    private LogoutSmsCodePresenter mPresenter;

    @BindView(R.id.tv_resend)
    @j.c.a.d
    public CodeCutTimeTextView mTvReSend;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;
    private String reaseon = "";

    /* JADX INFO: compiled from: LogoutSmsCodeActivity.kt */
    static final class a implements IOneClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g1.h f13471b;

        a(g1.h hVar) {
            this.f13471b = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // interfaces.IOneClickListener
        public final void clickOKBtn() {
            LogoutSmsCodePresenter mPresenter = LogoutSmsCodeActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.verificationSubmit((String) this.f13471b.element, 7, LogoutSmsCodeActivity.this.getMTvReSend());
            }
        }
    }

    @j.c.a.d
    public final Button getMConfim() {
        Button button = this.mConfim;
        if (button == null) {
            i.q2.t.i0.k("mConfim");
        }
        return button;
    }

    @j.c.a.d
    public final EditText getMEtPhoneNum() {
        EditText editText = this.mEtPhoneNum;
        if (editText == null) {
            i.q2.t.i0.k("mEtPhoneNum");
        }
        return editText;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.d
    public final EditText getMPhoneCode() {
        EditText editText = this.mPhoneCode;
        if (editText == null) {
            i.q2.t.i0.k("mPhoneCode");
        }
        return editText;
    }

    @j.c.a.e
    public final LogoutSmsCodePresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final CodeCutTimeTextView getMTvReSend() {
        CodeCutTimeTextView codeCutTimeTextView = this.mTvReSend;
        if (codeCutTimeTextView == null) {
            i.q2.t.i0.k("mTvReSend");
        }
        return codeCutTimeTextView;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        Activity activity = this.mActivity;
        i.q2.t.i0.a((Object) activity, "mActivity");
        this.mPresenter = new LogoutSmsCodePresenter(activity, this);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u6ce8\u9500\u8d26\u53f7");
        String stringExtra = getIntent().getStringExtra(util.p1.f0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.reaseon = stringExtra;
        EditText editText = this.mEtPhoneNum;
        if (editText == null) {
            i.q2.t.i0.k("mEtPhoneNum");
        }
        if (editText == null) {
            i.q2.t.i0.f();
        }
        editText.setText(AccountManager.getVisiblePhone());
        CodeCutTimeTextView codeCutTimeTextView = this.mTvReSend;
        if (codeCutTimeTextView == null) {
            i.q2.t.i0.k("mTvReSend");
        }
        codeCutTimeTextView.setEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.String] */
    @OnClick({R.id.iv_back, R.id.tv_resend, R.id.iv_clear, R.id.confirm})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296501 */:
                EditText editText = this.mEtPhoneNum;
                if (editText == null) {
                    i.q2.t.i0.k("mEtPhoneNum");
                }
                String string = editText.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    EditText editText2 = this.mEtPhoneNum;
                    if (editText2 == null) {
                        i.q2.t.i0.k("mEtPhoneNum");
                    }
                    if (editText2.length() >= 11) {
                        EditText editText3 = this.mPhoneCode;
                        if (editText3 == null) {
                            i.q2.t.i0.k("mPhoneCode");
                        }
                        String string2 = editText3.getText().toString();
                        if (!TextUtils.isEmpty(string2)) {
                            LogoutSmsCodePresenter logoutSmsCodePresenter = this.mPresenter;
                            if (logoutSmsCodePresenter != null) {
                                logoutSmsCodePresenter.verificationCode(string, string2, 7);
                            }
                        } else {
                            e2.a("\u8f93\u5165\u9a8c\u8bc1\u7801~");
                        }
                    } else {
                        e2.a("\u8bf7\u8f93\u5165\u6b63\u786e\u624b\u673a\u53f7");
                    }
                } else {
                    e2.a("\u8bf7\u586b\u5199\u5f53\u524d\u8d26\u53f7\u624b\u673a\u53f7\u7801");
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                onBackPressed();
                break;
            case R.id.iv_clear /* 2131296818 */:
                EditText editText4 = this.mEtPhoneNum;
                if (editText4 == null) {
                    i.q2.t.i0.k("mEtPhoneNum");
                }
                editText4.setText("");
                break;
            case R.id.tv_resend /* 2131297853 */:
                g1.h hVar = new g1.h();
                EditText editText5 = this.mEtPhoneNum;
                if (editText5 == null) {
                    i.q2.t.i0.k("mEtPhoneNum");
                }
                hVar.element = editText5.getText().toString();
                if (!TextUtils.isEmpty((String) hVar.element)) {
                    EditText editText6 = this.mEtPhoneNum;
                    if (editText6 == null) {
                        i.q2.t.i0.k("mEtPhoneNum");
                    }
                    if (editText6.length() < 11) {
                        e2.a("\u8bf7\u8f93\u5165\u6b63\u786e\u624b\u673a\u53f7");
                    } else if (!g2.a(util.u1.w, true)) {
                        LogoutSmsCodePresenter logoutSmsCodePresenter2 = this.mPresenter;
                        if (logoutSmsCodePresenter2 != null) {
                            String str = (String) hVar.element;
                            CodeCutTimeTextView codeCutTimeTextView = this.mTvReSend;
                            if (codeCutTimeTextView == null) {
                                i.q2.t.i0.k("mTvReSend");
                            }
                            logoutSmsCodePresenter2.verificationSubmit(str, 7, codeCutTimeTextView);
                        }
                    } else {
                        toYanzheng(new a(hVar));
                    }
                } else {
                    e2.a("\u8bf7\u586b\u5199\u5f53\u524d\u8d26\u53f7\u624b\u673a\u53f7\u7801");
                }
                break;
        }
    }

    @Override // ui.callview.LogoutSmsCodeView
    public void onSuccessRequest() {
        Intent intent = new Intent(this.mActivity, (Class<?>) LogoutConfirmActivity.class);
        intent.putExtra(util.p1.f0, this.reaseon);
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_logout_sms_code;
    }

    public final void setMConfim(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mConfim = button;
    }

    public final void setMEtPhoneNum(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtPhoneNum = editText;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPhoneCode(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mPhoneCode = editText;
    }

    public final void setMPresenter(@j.c.a.e LogoutSmsCodePresenter logoutSmsCodePresenter) {
        this.mPresenter = logoutSmsCodePresenter;
    }

    public final void setMTvReSend(@j.c.a.d CodeCutTimeTextView codeCutTimeTextView) {
        i.q2.t.i0.f(codeCutTimeTextView, "<set-?>");
        this.mTvReSend = codeCutTimeTextView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
