package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class ForgetPdwResetActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ForgetPdwResetActivity f22351a;

    /* renamed from: b */
    private View f22352b;

    /* renamed from: c */
    private View f22353c;

    /* renamed from: ui.activity.ForgetPdwResetActivity_ViewBinding$a */
    class C6319a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ForgetPdwResetActivity f22354a;

        C6319a(ForgetPdwResetActivity forgetPdwResetActivity) {
            this.f22354a = forgetPdwResetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22354a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ForgetPdwResetActivity_ViewBinding$b */
    class C6320b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ForgetPdwResetActivity f22356a;

        C6320b(ForgetPdwResetActivity forgetPdwResetActivity) {
            this.f22356a = forgetPdwResetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22356a.onViewClicked(view);
        }
    }

    @UiThread
    public ForgetPdwResetActivity_ViewBinding(ForgetPdwResetActivity forgetPdwResetActivity) {
        this(forgetPdwResetActivity, forgetPdwResetActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ForgetPdwResetActivity forgetPdwResetActivity = this.f22351a;
        if (forgetPdwResetActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22351a = null;
        forgetPdwResetActivity.mTvTitle = null;
        forgetPdwResetActivity.mEtNewPwd = null;
        forgetPdwResetActivity.mPwdEye = null;
        forgetPdwResetActivity.mConfim = null;
        this.f22352b.setOnClickListener(null);
        this.f22352b = null;
        this.f22353c.setOnClickListener(null);
        this.f22353c = null;
    }

    @UiThread
    public ForgetPdwResetActivity_ViewBinding(ForgetPdwResetActivity forgetPdwResetActivity, View view) {
        this.f22351a = forgetPdwResetActivity;
        forgetPdwResetActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        forgetPdwResetActivity.mEtNewPwd = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_new_pwd, "field 'mEtNewPwd'", EditText.class);
        forgetPdwResetActivity.mPwdEye = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.pwd_eye, "field 'mPwdEye'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        forgetPdwResetActivity.mConfim = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfim'", TextView.class);
        this.f22352b = findRequiredView;
        findRequiredView.setOnClickListener(new C6319a(forgetPdwResetActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22353c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6320b(forgetPdwResetActivity));
    }
}
