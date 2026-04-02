package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.CodeCutTimeTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class LogoutSmsCodeActivity_ViewBinding implements Unbinder {
    private LogoutSmsCodeActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13475e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ LogoutSmsCodeActivity a;

        a(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ LogoutSmsCodeActivity a;

        b(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ LogoutSmsCodeActivity a;

        c(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ LogoutSmsCodeActivity a;

        d(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public LogoutSmsCodeActivity_ViewBinding(LogoutSmsCodeActivity logoutSmsCodeActivity) {
        this(logoutSmsCodeActivity, logoutSmsCodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutSmsCodeActivity logoutSmsCodeActivity = this.a;
        if (logoutSmsCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        logoutSmsCodeActivity.mIvBack = null;
        logoutSmsCodeActivity.mTvTitle = null;
        logoutSmsCodeActivity.mEtPhoneNum = null;
        logoutSmsCodeActivity.mPhoneCode = null;
        logoutSmsCodeActivity.mTvReSend = null;
        logoutSmsCodeActivity.mConfim = null;
        this.f13472b.setOnClickListener(null);
        this.f13472b = null;
        this.f13473c.setOnClickListener(null);
        this.f13473c = null;
        this.f13474d.setOnClickListener(null);
        this.f13474d = null;
        this.f13475e.setOnClickListener(null);
        this.f13475e = null;
    }

    @UiThread
    public LogoutSmsCodeActivity_ViewBinding(LogoutSmsCodeActivity logoutSmsCodeActivity, View view) {
        this.a = logoutSmsCodeActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutSmsCodeActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13472b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutSmsCodeActivity));
        logoutSmsCodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        logoutSmsCodeActivity.mEtPhoneNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone_num, "field 'mEtPhoneNum'", EditText.class);
        logoutSmsCodeActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_resend, "field 'mTvReSend' and method 'onClick'");
        logoutSmsCodeActivity.mTvReSend = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView2, R.id.tv_resend, "field 'mTvReSend'", CodeCutTimeTextView.class);
        this.f13473c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutSmsCodeActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onClick'");
        logoutSmsCodeActivity.mConfim = (Button) Utils.castView(viewFindRequiredView3, R.id.confirm, "field 'mConfim'", Button.class);
        this.f13474d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(logoutSmsCodeActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_clear, "method 'onClick'");
        this.f13475e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(logoutSmsCodeActivity));
    }
}
