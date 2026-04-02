package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class ResetPwdActivity_ViewBinding implements Unbinder {
    private ResetPwdActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13763d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ResetPwdActivity a;

        a(ResetPwdActivity resetPwdActivity) {
            this.a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ResetPwdActivity a;

        b(ResetPwdActivity resetPwdActivity) {
            this.a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ ResetPwdActivity a;

        c(ResetPwdActivity resetPwdActivity) {
            this.a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ResetPwdActivity_ViewBinding(ResetPwdActivity resetPwdActivity) {
        this(resetPwdActivity, resetPwdActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ResetPwdActivity resetPwdActivity = this.a;
        if (resetPwdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        resetPwdActivity.mTvTitle = null;
        resetPwdActivity.mPhoneCode = null;
        resetPwdActivity.mConfim = null;
        resetPwdActivity.mPhoneLable = null;
        resetPwdActivity.mIvClean = null;
        this.f13761b.setOnClickListener(null);
        this.f13761b = null;
        this.f13762c.setOnClickListener(null);
        this.f13762c = null;
        this.f13763d.setOnClickListener(null);
        this.f13763d = null;
    }

    @UiThread
    public ResetPwdActivity_ViewBinding(ResetPwdActivity resetPwdActivity, View view) {
        this.a = resetPwdActivity;
        resetPwdActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        resetPwdActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        resetPwdActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f13761b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(resetPwdActivity));
        resetPwdActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        resetPwdActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f13762c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(resetPwdActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13763d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(resetPwdActivity));
    }
}
