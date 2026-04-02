package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class LogoutConfirmActivity_ViewBinding implements Unbinder {
    private LogoutConfirmActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13462d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ LogoutConfirmActivity a;

        a(LogoutConfirmActivity logoutConfirmActivity) {
            this.a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ LogoutConfirmActivity a;

        b(LogoutConfirmActivity logoutConfirmActivity) {
            this.a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ LogoutConfirmActivity a;

        c(LogoutConfirmActivity logoutConfirmActivity) {
            this.a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public LogoutConfirmActivity_ViewBinding(LogoutConfirmActivity logoutConfirmActivity) {
        this(logoutConfirmActivity, logoutConfirmActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutConfirmActivity logoutConfirmActivity = this.a;
        if (logoutConfirmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        logoutConfirmActivity.mIvBack = null;
        logoutConfirmActivity.mTvTitle = null;
        logoutConfirmActivity.mLogout = null;
        logoutConfirmActivity.mCancel = null;
        this.f13460b.setOnClickListener(null);
        this.f13460b = null;
        this.f13461c.setOnClickListener(null);
        this.f13461c = null;
        this.f13462d.setOnClickListener(null);
        this.f13462d = null;
    }

    @UiThread
    public LogoutConfirmActivity_ViewBinding(LogoutConfirmActivity logoutConfirmActivity, View view) {
        this.a = logoutConfirmActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutConfirmActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13460b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutConfirmActivity));
        logoutConfirmActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_logout, "field 'mLogout' and method 'onClick'");
        logoutConfirmActivity.mLogout = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_logout, "field 'mLogout'", Button.class);
        this.f13461c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutConfirmActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_cancel, "field 'mCancel' and method 'onClick'");
        logoutConfirmActivity.mCancel = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_cancel, "field 'mCancel'", Button.class);
        this.f13462d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(logoutConfirmActivity));
    }
}
