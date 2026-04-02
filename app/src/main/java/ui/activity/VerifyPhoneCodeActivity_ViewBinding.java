package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.CodeCutTimeTextView;
import ui.view.VerifyCodeView;

/* JADX INFO: loaded from: classes2.dex */
public class VerifyPhoneCodeActivity_ViewBinding implements Unbinder {
    private VerifyPhoneCodeActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13958c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ VerifyPhoneCodeActivity a;

        a(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
            this.a = verifyPhoneCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ VerifyPhoneCodeActivity a;

        b(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
            this.a = verifyPhoneCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public VerifyPhoneCodeActivity_ViewBinding(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
        this(verifyPhoneCodeActivity, verifyPhoneCodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VerifyPhoneCodeActivity verifyPhoneCodeActivity = this.a;
        if (verifyPhoneCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        verifyPhoneCodeActivity.mTvTitle = null;
        verifyPhoneCodeActivity.tvPhoneTip = null;
        verifyPhoneCodeActivity.mPhoneCode = null;
        verifyPhoneCodeActivity.mTvReset = null;
        verifyPhoneCodeActivity.mPhoneLable = null;
        this.f13957b.setOnClickListener(null);
        this.f13957b = null;
        this.f13958c.setOnClickListener(null);
        this.f13958c = null;
    }

    @UiThread
    public VerifyPhoneCodeActivity_ViewBinding(VerifyPhoneCodeActivity verifyPhoneCodeActivity, View view) {
        this.a = verifyPhoneCodeActivity;
        verifyPhoneCodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        verifyPhoneCodeActivity.tvPhoneTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone, "field 'tvPhoneTip'", TextView.class);
        verifyPhoneCodeActivity.mPhoneCode = (VerifyCodeView) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", VerifyCodeView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_reSend, "field 'mTvReset' and method 'onViewClicked'");
        verifyPhoneCodeActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView, R.id.tv_reSend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f13957b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(verifyPhoneCodeActivity));
        verifyPhoneCodeActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13958c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(verifyPhoneCodeActivity));
    }
}
