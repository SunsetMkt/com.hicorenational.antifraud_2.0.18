package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.CodeCutTimeTextView;
import p388ui.view.VerifyCodeView;

/* loaded from: classes2.dex */
public class VerifyPhoneCodeActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private VerifyPhoneCodeActivity f23359a;

    /* renamed from: b */
    private View f23360b;

    /* renamed from: c */
    private View f23361c;

    /* renamed from: ui.activity.VerifyPhoneCodeActivity_ViewBinding$a */
    class C6654a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VerifyPhoneCodeActivity f23362a;

        C6654a(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
            this.f23362a = verifyPhoneCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23362a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.VerifyPhoneCodeActivity_ViewBinding$b */
    class C6655b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VerifyPhoneCodeActivity f23364a;

        C6655b(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
            this.f23364a = verifyPhoneCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23364a.onViewClicked(view);
        }
    }

    @UiThread
    public VerifyPhoneCodeActivity_ViewBinding(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
        this(verifyPhoneCodeActivity, verifyPhoneCodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VerifyPhoneCodeActivity verifyPhoneCodeActivity = this.f23359a;
        if (verifyPhoneCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23359a = null;
        verifyPhoneCodeActivity.mTvTitle = null;
        verifyPhoneCodeActivity.tvPhoneTip = null;
        verifyPhoneCodeActivity.mPhoneCode = null;
        verifyPhoneCodeActivity.mTvReset = null;
        verifyPhoneCodeActivity.mPhoneLable = null;
        this.f23360b.setOnClickListener(null);
        this.f23360b = null;
        this.f23361c.setOnClickListener(null);
        this.f23361c = null;
    }

    @UiThread
    public VerifyPhoneCodeActivity_ViewBinding(VerifyPhoneCodeActivity verifyPhoneCodeActivity, View view) {
        this.f23359a = verifyPhoneCodeActivity;
        verifyPhoneCodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        verifyPhoneCodeActivity.tvPhoneTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_phone, "field 'tvPhoneTip'", TextView.class);
        verifyPhoneCodeActivity.mPhoneCode = (VerifyCodeView) Utils.findRequiredViewAsType(view, C2113R.id.phone_code, "field 'mPhoneCode'", VerifyCodeView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_reSend, "field 'mTvReset' and method 'onViewClicked'");
        verifyPhoneCodeActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(findRequiredView, C2113R.id.tv_reSend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f23360b = findRequiredView;
        findRequiredView.setOnClickListener(new C6654a(verifyPhoneCodeActivity));
        verifyPhoneCodeActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23361c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6655b(verifyPhoneCodeActivity));
    }
}
