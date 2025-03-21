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
public class ResetPwdActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ResetPwdActivity f23031a;

    /* renamed from: b */
    private View f23032b;

    /* renamed from: c */
    private View f23033c;

    /* renamed from: d */
    private View f23034d;

    /* renamed from: ui.activity.ResetPwdActivity_ViewBinding$a */
    class C6558a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ResetPwdActivity f23035a;

        C6558a(ResetPwdActivity resetPwdActivity) {
            this.f23035a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23035a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ResetPwdActivity_ViewBinding$b */
    class C6559b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ResetPwdActivity f23037a;

        C6559b(ResetPwdActivity resetPwdActivity) {
            this.f23037a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23037a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ResetPwdActivity_ViewBinding$c */
    class C6560c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ResetPwdActivity f23039a;

        C6560c(ResetPwdActivity resetPwdActivity) {
            this.f23039a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23039a.onViewClicked(view);
        }
    }

    @UiThread
    public ResetPwdActivity_ViewBinding(ResetPwdActivity resetPwdActivity) {
        this(resetPwdActivity, resetPwdActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ResetPwdActivity resetPwdActivity = this.f23031a;
        if (resetPwdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23031a = null;
        resetPwdActivity.mTvTitle = null;
        resetPwdActivity.mPhoneCode = null;
        resetPwdActivity.mConfim = null;
        resetPwdActivity.mPhoneLable = null;
        resetPwdActivity.mIvClean = null;
        this.f23032b.setOnClickListener(null);
        this.f23032b = null;
        this.f23033c.setOnClickListener(null);
        this.f23033c = null;
        this.f23034d.setOnClickListener(null);
        this.f23034d = null;
    }

    @UiThread
    public ResetPwdActivity_ViewBinding(ResetPwdActivity resetPwdActivity, View view) {
        this.f23031a = resetPwdActivity;
        resetPwdActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        resetPwdActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        resetPwdActivity.mConfim = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfim'", TextView.class);
        this.f23032b = findRequiredView;
        findRequiredView.setOnClickListener(new C6558a(resetPwdActivity));
        resetPwdActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        resetPwdActivity.mIvClean = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f23033c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6559b(resetPwdActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23034d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6560c(resetPwdActivity));
    }
}
