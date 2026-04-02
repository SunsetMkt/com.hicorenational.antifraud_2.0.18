package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.SwitchButton;

/* JADX INFO: loaded from: classes2.dex */
public class SettingActivity_ViewBinding implements Unbinder {
    private SettingActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13784f;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SettingActivity a;

        a(SettingActivity settingActivity) {
            this.a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SettingActivity a;

        b(SettingActivity settingActivity) {
            this.a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ SettingActivity a;

        c(SettingActivity settingActivity) {
            this.a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ SettingActivity a;

        d(SettingActivity settingActivity) {
            this.a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ SettingActivity a;

        e(SettingActivity settingActivity) {
            this.a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SettingActivity_ViewBinding(SettingActivity settingActivity) {
        this(settingActivity, settingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingActivity settingActivity = this.a;
        if (settingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        settingActivity.mTvTitle = null;
        settingActivity.mSwitchCheck = null;
        settingActivity.mTimeTxt = null;
        settingActivity.mTimeSetting = null;
        settingActivity.mSwitchPush = null;
        settingActivity.mTvPushTips = null;
        settingActivity.mRlCache = null;
        settingActivity.mTvCacheNum = null;
        this.f13780b.setOnClickListener(null);
        this.f13780b = null;
        this.f13781c.setOnClickListener(null);
        this.f13781c = null;
        this.f13782d.setOnClickListener(null);
        this.f13782d = null;
        this.f13783e.setOnClickListener(null);
        this.f13783e = null;
        this.f13784f.setOnClickListener(null);
        this.f13784f = null;
    }

    @UiThread
    public SettingActivity_ViewBinding(SettingActivity settingActivity, View view) {
        this.a = settingActivity;
        settingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        settingActivity.mSwitchCheck = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switchShow_check, "field 'mSwitchCheck'", SwitchButton.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.time_txt, "field 'mTimeTxt' and method 'onViewClicked'");
        settingActivity.mTimeTxt = (TextView) Utils.castView(viewFindRequiredView, R.id.time_txt, "field 'mTimeTxt'", TextView.class);
        this.f13780b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(settingActivity));
        settingActivity.mTimeSetting = (Group) Utils.findRequiredViewAsType(view, R.id.time_setting, "field 'mTimeSetting'", Group.class);
        settingActivity.mSwitchPush = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switchShow_push, "field 'mSwitchPush'", SwitchButton.class);
        settingActivity.mTvPushTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_push_tips, "field 'mTvPushTips'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_cache_calean, "field 'mRlCache' and method 'onViewClicked'");
        settingActivity.mRlCache = viewFindRequiredView2;
        this.f13781c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(settingActivity));
        settingActivity.mTvCacheNum = (TextView) Utils.findRequiredViewAsType(view, R.id.cache_num, "field 'mTvCacheNum'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13782d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(settingActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_account, "method 'onViewClicked'");
        this.f13783e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(settingActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.logout_btn, "method 'onViewClicked'");
        this.f13784f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(settingActivity));
    }
}
