package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class LogoutConfirmActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LogoutConfirmActivity f22478a;

    /* renamed from: b */
    private View f22479b;

    /* renamed from: c */
    private View f22480c;

    /* renamed from: d */
    private View f22481d;

    /* renamed from: ui.activity.LogoutConfirmActivity_ViewBinding$a */
    class C6355a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutConfirmActivity f22482a;

        C6355a(LogoutConfirmActivity logoutConfirmActivity) {
            this.f22482a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22482a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutConfirmActivity_ViewBinding$b */
    class C6356b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutConfirmActivity f22484a;

        C6356b(LogoutConfirmActivity logoutConfirmActivity) {
            this.f22484a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22484a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutConfirmActivity_ViewBinding$c */
    class C6357c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutConfirmActivity f22486a;

        C6357c(LogoutConfirmActivity logoutConfirmActivity) {
            this.f22486a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22486a.onClick(view);
        }
    }

    @UiThread
    public LogoutConfirmActivity_ViewBinding(LogoutConfirmActivity logoutConfirmActivity) {
        this(logoutConfirmActivity, logoutConfirmActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutConfirmActivity logoutConfirmActivity = this.f22478a;
        if (logoutConfirmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22478a = null;
        logoutConfirmActivity.mIvBack = null;
        logoutConfirmActivity.mTvTitle = null;
        logoutConfirmActivity.mLogout = null;
        logoutConfirmActivity.mCancel = null;
        this.f22479b.setOnClickListener(null);
        this.f22479b = null;
        this.f22480c.setOnClickListener(null);
        this.f22480c = null;
        this.f22481d.setOnClickListener(null);
        this.f22481d = null;
    }

    @UiThread
    public LogoutConfirmActivity_ViewBinding(LogoutConfirmActivity logoutConfirmActivity, View view) {
        this.f22478a = logoutConfirmActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutConfirmActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22479b = findRequiredView;
        findRequiredView.setOnClickListener(new C6355a(logoutConfirmActivity));
        logoutConfirmActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_logout, "field 'mLogout' and method 'onClick'");
        logoutConfirmActivity.mLogout = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_logout, "field 'mLogout'", Button.class);
        this.f22480c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6356b(logoutConfirmActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_cancel, "field 'mCancel' and method 'onClick'");
        logoutConfirmActivity.mCancel = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_cancel, "field 'mCancel'", Button.class);
        this.f22481d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6357c(logoutConfirmActivity));
    }
}
