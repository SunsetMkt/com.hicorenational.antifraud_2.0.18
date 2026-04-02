package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.SwitchButton;

/* JADX INFO: loaded from: classes2.dex */
public class WarnSettingActivity_ViewBinding implements Unbinder {
    private WarnSettingActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f14034e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ WarnSettingActivity a;

        a(WarnSettingActivity warnSettingActivity) {
            this.a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ WarnSettingActivity a;

        b(WarnSettingActivity warnSettingActivity) {
            this.a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ WarnSettingActivity a;

        c(WarnSettingActivity warnSettingActivity) {
            this.a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ WarnSettingActivity a;

        d(WarnSettingActivity warnSettingActivity) {
            this.a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnSettingActivity_ViewBinding(WarnSettingActivity warnSettingActivity) {
        this(warnSettingActivity, warnSettingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnSettingActivity warnSettingActivity = this.a;
        if (warnSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        warnSettingActivity.mIvBack = null;
        warnSettingActivity.mTvTitle = null;
        warnSettingActivity.mIvRight = null;
        warnSettingActivity.mTvContent = null;
        warnSettingActivity.mTvContentSecond = null;
        warnSettingActivity.mLayoutOpen = null;
        warnSettingActivity.mSwitchCall = null;
        warnSettingActivity.mSwitchSms = null;
        warnSettingActivity.mSwitchApp = null;
        warnSettingActivity.mTvCall = null;
        warnSettingActivity.mTvSms = null;
        warnSettingActivity.mTvApp = null;
        warnSettingActivity.mTvGoPermission = null;
        this.f14031b.setOnClickListener(null);
        this.f14031b = null;
        this.f14032c.setOnClickListener(null);
        this.f14032c = null;
        this.f14033d.setOnClickListener(null);
        this.f14033d = null;
        this.f14034e.setOnClickListener(null);
        this.f14034e = null;
    }

    @UiThread
    public WarnSettingActivity_ViewBinding(WarnSettingActivity warnSettingActivity, View view) {
        this.a = warnSettingActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        warnSettingActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f14031b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(warnSettingActivity));
        warnSettingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        warnSettingActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f14032c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(warnSettingActivity));
        warnSettingActivity.mTvContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'mTvContent'", TextView.class);
        warnSettingActivity.mTvContentSecond = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content_second, "field 'mTvContentSecond'", TextView.class);
        warnSettingActivity.mLayoutOpen = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.layout_open, "field 'mLayoutOpen'", ConstraintLayout.class);
        warnSettingActivity.mSwitchCall = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_call, "field 'mSwitchCall'", SwitchButton.class);
        warnSettingActivity.mSwitchSms = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_sms, "field 'mSwitchSms'", SwitchButton.class);
        warnSettingActivity.mSwitchApp = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_app, "field 'mSwitchApp'", SwitchButton.class);
        warnSettingActivity.mTvCall = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_call, "field 'mTvCall'", TextView.class);
        warnSettingActivity.mTvSms = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sms, "field 'mTvSms'", TextView.class);
        warnSettingActivity.mTvApp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app, "field 'mTvApp'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_go_permission, "field 'mTvGoPermission' and method 'onViewClicked'");
        warnSettingActivity.mTvGoPermission = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_go_permission, "field 'mTvGoPermission'", TextView.class);
        this.f14033d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(warnSettingActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_error_free, "method 'onViewClicked'");
        this.f14034e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(warnSettingActivity));
    }
}
