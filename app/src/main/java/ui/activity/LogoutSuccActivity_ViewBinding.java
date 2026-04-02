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
public final class LogoutSuccActivity_ViewBinding implements Unbinder {
    private LogoutSuccActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13481c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ LogoutSuccActivity a;

        a(LogoutSuccActivity logoutSuccActivity) {
            this.a = logoutSuccActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ LogoutSuccActivity a;

        b(LogoutSuccActivity logoutSuccActivity) {
            this.a = logoutSuccActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public LogoutSuccActivity_ViewBinding(LogoutSuccActivity logoutSuccActivity) {
        this(logoutSuccActivity, logoutSuccActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutSuccActivity logoutSuccActivity = this.a;
        if (logoutSuccActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        logoutSuccActivity.mIvBack = null;
        logoutSuccActivity.mTvTitle = null;
        logoutSuccActivity.mTvAccTips = null;
        this.f13480b.setOnClickListener(null);
        this.f13480b = null;
        this.f13481c.setOnClickListener(null);
        this.f13481c = null;
    }

    @UiThread
    public LogoutSuccActivity_ViewBinding(LogoutSuccActivity logoutSuccActivity, View view) {
        this.a = logoutSuccActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutSuccActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13480b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutSuccActivity));
        logoutSuccActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        logoutSuccActivity.mTvAccTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_acc_tips, "field 'mTvAccTips'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_confirm, "method 'onClick'");
        this.f13481c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutSuccActivity));
    }
}
