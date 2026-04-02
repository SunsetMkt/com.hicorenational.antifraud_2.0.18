package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class SettingAccountActivity_ViewBinding implements Unbinder {
    private SettingAccountActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13775e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SettingAccountActivity a;

        a(SettingAccountActivity settingAccountActivity) {
            this.a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SettingAccountActivity a;

        b(SettingAccountActivity settingAccountActivity) {
            this.a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ SettingAccountActivity a;

        c(SettingAccountActivity settingAccountActivity) {
            this.a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ SettingAccountActivity a;

        d(SettingAccountActivity settingAccountActivity) {
            this.a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SettingAccountActivity_ViewBinding(SettingAccountActivity settingAccountActivity) {
        this(settingAccountActivity, settingAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingAccountActivity settingAccountActivity = this.a;
        if (settingAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        settingAccountActivity.mTvTitle = null;
        settingAccountActivity.mTvPhone = null;
        this.f13772b.setOnClickListener(null);
        this.f13772b = null;
        this.f13773c.setOnClickListener(null);
        this.f13773c = null;
        this.f13774d.setOnClickListener(null);
        this.f13774d = null;
        this.f13775e.setOnClickListener(null);
        this.f13775e = null;
    }

    @UiThread
    public SettingAccountActivity_ViewBinding(SettingAccountActivity settingAccountActivity, View view) {
        this.a = settingAccountActivity;
        settingAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        settingAccountActivity.mTvPhone = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone, "field 'mTvPhone'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13772b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(settingAccountActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_ed_phone, "method 'onViewClicked'");
        this.f13773c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(settingAccountActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_ed_pwd, "method 'onViewClicked'");
        this.f13774d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(settingAccountActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_logout_view, "method 'onViewClicked'");
        this.f13775e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(settingAccountActivity));
    }
}
