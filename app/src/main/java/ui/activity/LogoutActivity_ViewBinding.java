package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class LogoutActivity_ViewBinding implements Unbinder {
    private LogoutActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13456d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ LogoutActivity a;

        a(LogoutActivity logoutActivity) {
            this.a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ LogoutActivity a;

        b(LogoutActivity logoutActivity) {
            this.a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ LogoutActivity a;

        c(LogoutActivity logoutActivity) {
            this.a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public LogoutActivity_ViewBinding(LogoutActivity logoutActivity) {
        this(logoutActivity, logoutActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutActivity logoutActivity = this.a;
        if (logoutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        logoutActivity.mIvBack = null;
        logoutActivity.mTvTitle = null;
        this.f13454b.setOnClickListener(null);
        this.f13454b = null;
        this.f13455c.setOnClickListener(null);
        this.f13455c = null;
        this.f13456d.setOnClickListener(null);
        this.f13456d = null;
    }

    @UiThread
    public LogoutActivity_ViewBinding(LogoutActivity logoutActivity, View view) {
        this.a = logoutActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13454b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutActivity));
        logoutActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_logout, "method 'onClick'");
        this.f13455c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_cancel, "method 'onClick'");
        this.f13456d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(logoutActivity));
    }
}
