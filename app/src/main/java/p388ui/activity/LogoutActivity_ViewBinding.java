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
public final class LogoutActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LogoutActivity f22468a;

    /* renamed from: b */
    private View f22469b;

    /* renamed from: c */
    private View f22470c;

    /* renamed from: d */
    private View f22471d;

    /* renamed from: ui.activity.LogoutActivity_ViewBinding$a */
    class C6352a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutActivity f22472a;

        C6352a(LogoutActivity logoutActivity) {
            this.f22472a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22472a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutActivity_ViewBinding$b */
    class C6353b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutActivity f22474a;

        C6353b(LogoutActivity logoutActivity) {
            this.f22474a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22474a.onClick(view);
        }
    }

    /* renamed from: ui.activity.LogoutActivity_ViewBinding$c */
    class C6354c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LogoutActivity f22476a;

        C6354c(LogoutActivity logoutActivity) {
            this.f22476a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22476a.onClick(view);
        }
    }

    @UiThread
    public LogoutActivity_ViewBinding(LogoutActivity logoutActivity) {
        this(logoutActivity, logoutActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutActivity logoutActivity = this.f22468a;
        if (logoutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22468a = null;
        logoutActivity.mIvBack = null;
        logoutActivity.mTvTitle = null;
        this.f22469b.setOnClickListener(null);
        this.f22469b = null;
        this.f22470c.setOnClickListener(null);
        this.f22470c = null;
        this.f22471d.setOnClickListener(null);
        this.f22471d = null;
    }

    @UiThread
    public LogoutActivity_ViewBinding(LogoutActivity logoutActivity, View view) {
        this.f22468a = logoutActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22469b = findRequiredView;
        findRequiredView.setOnClickListener(new C6352a(logoutActivity));
        logoutActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_logout, "method 'onClick'");
        this.f22470c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6353b(logoutActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_cancel, "method 'onClick'");
        this.f22471d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6354c(logoutActivity));
    }
}
