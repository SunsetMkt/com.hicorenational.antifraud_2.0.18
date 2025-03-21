package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.SwitchButton;

/* loaded from: classes2.dex */
public class SettingActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SettingActivity f23064a;

    /* renamed from: b */
    private View f23065b;

    /* renamed from: c */
    private View f23066c;

    /* renamed from: d */
    private View f23067d;

    /* renamed from: e */
    private View f23068e;

    /* renamed from: f */
    private View f23069f;

    /* renamed from: ui.activity.SettingActivity_ViewBinding$a */
    class C6570a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingActivity f23070a;

        C6570a(SettingActivity settingActivity) {
            this.f23070a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23070a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SettingActivity_ViewBinding$b */
    class C6571b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingActivity f23072a;

        C6571b(SettingActivity settingActivity) {
            this.f23072a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23072a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SettingActivity_ViewBinding$c */
    class C6572c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingActivity f23074a;

        C6572c(SettingActivity settingActivity) {
            this.f23074a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23074a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SettingActivity_ViewBinding$d */
    class C6573d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingActivity f23076a;

        C6573d(SettingActivity settingActivity) {
            this.f23076a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23076a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SettingActivity_ViewBinding$e */
    class C6574e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SettingActivity f23078a;

        C6574e(SettingActivity settingActivity) {
            this.f23078a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23078a.onViewClicked(view);
        }
    }

    @UiThread
    public SettingActivity_ViewBinding(SettingActivity settingActivity) {
        this(settingActivity, settingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingActivity settingActivity = this.f23064a;
        if (settingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23064a = null;
        settingActivity.mTvTitle = null;
        settingActivity.mSwitchCheck = null;
        settingActivity.mTimeTxt = null;
        settingActivity.mTimeSetting = null;
        settingActivity.mSwitchPush = null;
        settingActivity.mTvPushTips = null;
        settingActivity.mRlCache = null;
        settingActivity.mTvCacheNum = null;
        this.f23065b.setOnClickListener(null);
        this.f23065b = null;
        this.f23066c.setOnClickListener(null);
        this.f23066c = null;
        this.f23067d.setOnClickListener(null);
        this.f23067d = null;
        this.f23068e.setOnClickListener(null);
        this.f23068e = null;
        this.f23069f.setOnClickListener(null);
        this.f23069f = null;
    }

    @UiThread
    public SettingActivity_ViewBinding(SettingActivity settingActivity, View view) {
        this.f23064a = settingActivity;
        settingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        settingActivity.mSwitchCheck = (SwitchButton) Utils.findRequiredViewAsType(view, C2113R.id.switchShow_check, "field 'mSwitchCheck'", SwitchButton.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.time_txt, "field 'mTimeTxt' and method 'onViewClicked'");
        settingActivity.mTimeTxt = (TextView) Utils.castView(findRequiredView, C2113R.id.time_txt, "field 'mTimeTxt'", TextView.class);
        this.f23065b = findRequiredView;
        findRequiredView.setOnClickListener(new C6570a(settingActivity));
        settingActivity.mTimeSetting = (Group) Utils.findRequiredViewAsType(view, C2113R.id.time_setting, "field 'mTimeSetting'", Group.class);
        settingActivity.mSwitchPush = (SwitchButton) Utils.findRequiredViewAsType(view, C2113R.id.switchShow_push, "field 'mSwitchPush'", SwitchButton.class);
        settingActivity.mTvPushTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_push_tips, "field 'mTvPushTips'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.rl_cache_calean, "field 'mRlCache' and method 'onViewClicked'");
        settingActivity.mRlCache = findRequiredView2;
        this.f23066c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6571b(settingActivity));
        settingActivity.mTvCacheNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.cache_num, "field 'mTvCacheNum'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23067d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6572c(settingActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.rl_account, "method 'onViewClicked'");
        this.f23068e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6573d(settingActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.logout_btn, "method 'onViewClicked'");
        this.f23069f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6574e(settingActivity));
    }
}
