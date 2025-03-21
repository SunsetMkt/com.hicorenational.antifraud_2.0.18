package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class SettingAccountActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SettingAccountActivity f23049a;

    /* renamed from: b */
    private View f23050b;

    /* renamed from: c */
    private View f23051c;

    /* renamed from: d */
    private View f23052d;

    /* renamed from: e */
    private View f23053e;

    /* renamed from: ui.activity.SettingAccountActivity_ViewBinding$a */
    class C6564a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingAccountActivity f23054a;

        C6564a(SettingAccountActivity settingAccountActivity) {
            this.f23054a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23054a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SettingAccountActivity_ViewBinding$b */
    class C6565b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingAccountActivity f23056a;

        C6565b(SettingAccountActivity settingAccountActivity) {
            this.f23056a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23056a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SettingAccountActivity_ViewBinding$c */
    class C6566c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingAccountActivity f23058a;

        C6566c(SettingAccountActivity settingAccountActivity) {
            this.f23058a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23058a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SettingAccountActivity_ViewBinding$d */
    class C6567d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingAccountActivity f23060a;

        C6567d(SettingAccountActivity settingAccountActivity) {
            this.f23060a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23060a.onViewClicked(view);
        }
    }

    @UiThread
    public SettingAccountActivity_ViewBinding(SettingAccountActivity settingAccountActivity) {
        this(settingAccountActivity, settingAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingAccountActivity settingAccountActivity = this.f23049a;
        if (settingAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23049a = null;
        settingAccountActivity.mTvTitle = null;
        settingAccountActivity.mTvPhone = null;
        this.f23050b.setOnClickListener(null);
        this.f23050b = null;
        this.f23051c.setOnClickListener(null);
        this.f23051c = null;
        this.f23052d.setOnClickListener(null);
        this.f23052d = null;
        this.f23053e.setOnClickListener(null);
        this.f23053e = null;
    }

    @UiThread
    public SettingAccountActivity_ViewBinding(SettingAccountActivity settingAccountActivity, View view) {
        this.f23049a = settingAccountActivity;
        settingAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        settingAccountActivity.mTvPhone = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_phone, "field 'mTvPhone'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23050b = findRequiredView;
        findRequiredView.setOnClickListener(new C6564a(settingAccountActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_ed_phone, "method 'onViewClicked'");
        this.f23051c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6565b(settingAccountActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_ed_pwd, "method 'onViewClicked'");
        this.f23052d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6566c(settingAccountActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.rl_logout_view, "method 'onViewClicked'");
        this.f23053e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6567d(settingAccountActivity));
    }
}
