package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class LogoutSuccActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LogoutSuccActivity f22514a;

    /* renamed from: b */
    private View f22515b;

    /* renamed from: c */
    private View f22516c;

    /* renamed from: ui.activity.LogoutSuccActivity_ViewBinding$a */
    class C6367a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutSuccActivity f22517a;

        C6367a(LogoutSuccActivity logoutSuccActivity) {
            this.f22517a = logoutSuccActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22517a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutSuccActivity_ViewBinding$b */
    class C6368b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutSuccActivity f22519a;

        C6368b(LogoutSuccActivity logoutSuccActivity) {
            this.f22519a = logoutSuccActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22519a.onClick(view);
        }
    }

    @UiThread
    public LogoutSuccActivity_ViewBinding(LogoutSuccActivity logoutSuccActivity) {
        this(logoutSuccActivity, logoutSuccActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutSuccActivity logoutSuccActivity = this.f22514a;
        if (logoutSuccActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22514a = null;
        logoutSuccActivity.mIvBack = null;
        logoutSuccActivity.mTvTitle = null;
        logoutSuccActivity.mTvAccTips = null;
        this.f22515b.setOnClickListener(null);
        this.f22515b = null;
        this.f22516c.setOnClickListener(null);
        this.f22516c = null;
    }

    @UiThread
    public LogoutSuccActivity_ViewBinding(LogoutSuccActivity logoutSuccActivity, View view) {
        this.f22514a = logoutSuccActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutSuccActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22515b = findRequiredView;
        findRequiredView.setOnClickListener(new C6367a(logoutSuccActivity));
        logoutSuccActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        logoutSuccActivity.mTvAccTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_acc_tips, "field 'mTvAccTips'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_confirm, "method 'onClick'");
        this.f22516c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6368b(logoutSuccActivity));
    }
}
