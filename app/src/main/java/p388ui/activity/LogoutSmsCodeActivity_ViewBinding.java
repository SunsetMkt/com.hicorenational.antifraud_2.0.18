package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.CodeCutTimeTextView;

/* loaded from: classes2.dex */
public final class LogoutSmsCodeActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LogoutSmsCodeActivity f22501a;

    /* renamed from: b */
    private View f22502b;

    /* renamed from: c */
    private View f22503c;

    /* renamed from: d */
    private View f22504d;

    /* renamed from: e */
    private View f22505e;

    /* renamed from: ui.activity.LogoutSmsCodeActivity_ViewBinding$a */
    class C6363a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutSmsCodeActivity f22506a;

        C6363a(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.f22506a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22506a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutSmsCodeActivity_ViewBinding$b */
    class C6364b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutSmsCodeActivity f22508a;

        C6364b(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.f22508a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22508a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutSmsCodeActivity_ViewBinding$c */
    class C6365c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutSmsCodeActivity f22510a;

        C6365c(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.f22510a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22510a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutSmsCodeActivity_ViewBinding$d */
    class C6366d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutSmsCodeActivity f22512a;

        C6366d(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.f22512a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22512a.onClick(view);
        }
    }

    @UiThread
    public LogoutSmsCodeActivity_ViewBinding(LogoutSmsCodeActivity logoutSmsCodeActivity) {
        this(logoutSmsCodeActivity, logoutSmsCodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutSmsCodeActivity logoutSmsCodeActivity = this.f22501a;
        if (logoutSmsCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22501a = null;
        logoutSmsCodeActivity.mIvBack = null;
        logoutSmsCodeActivity.mTvTitle = null;
        logoutSmsCodeActivity.mEtPhoneNum = null;
        logoutSmsCodeActivity.mPhoneCode = null;
        logoutSmsCodeActivity.mTvReSend = null;
        logoutSmsCodeActivity.mConfim = null;
        this.f22502b.setOnClickListener(null);
        this.f22502b = null;
        this.f22503c.setOnClickListener(null);
        this.f22503c = null;
        this.f22504d.setOnClickListener(null);
        this.f22504d = null;
        this.f22505e.setOnClickListener(null);
        this.f22505e = null;
    }

    @UiThread
    public LogoutSmsCodeActivity_ViewBinding(LogoutSmsCodeActivity logoutSmsCodeActivity, View view) {
        this.f22501a = logoutSmsCodeActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutSmsCodeActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22502b = findRequiredView;
        findRequiredView.setOnClickListener(new C6363a(logoutSmsCodeActivity));
        logoutSmsCodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        logoutSmsCodeActivity.mEtPhoneNum = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone_num, "field 'mEtPhoneNum'", EditText.class);
        logoutSmsCodeActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_resend, "field 'mTvReSend' and method 'onClick'");
        logoutSmsCodeActivity.mTvReSend = (CodeCutTimeTextView) Utils.castView(findRequiredView2, C2113R.id.tv_resend, "field 'mTvReSend'", CodeCutTimeTextView.class);
        this.f22503c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6364b(logoutSmsCodeActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfim' and method 'onClick'");
        logoutSmsCodeActivity.mConfim = (Button) Utils.castView(findRequiredView3, C2113R.id.confirm, "field 'mConfim'", Button.class);
        this.f22504d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6365c(logoutSmsCodeActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.iv_clear, "method 'onClick'");
        this.f22505e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6366d(logoutSmsCodeActivity));
    }
}
