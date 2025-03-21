package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.SwitchButton;

/* loaded from: classes2.dex */
public class WarnSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WarnSettingActivity f23499a;

    /* renamed from: b */
    private View f23500b;

    /* renamed from: c */
    private View f23501c;

    /* renamed from: d */
    private View f23502d;

    /* renamed from: e */
    private View f23503e;

    /* renamed from: ui.activity.WarnSettingActivity_ViewBinding$a */
    class C6706a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnSettingActivity f23504a;

        C6706a(WarnSettingActivity warnSettingActivity) {
            this.f23504a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23504a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnSettingActivity_ViewBinding$b */
    class C6707b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnSettingActivity f23506a;

        C6707b(WarnSettingActivity warnSettingActivity) {
            this.f23506a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23506a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnSettingActivity_ViewBinding$c */
    class C6708c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnSettingActivity f23508a;

        C6708c(WarnSettingActivity warnSettingActivity) {
            this.f23508a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23508a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnSettingActivity_ViewBinding$d */
    class C6709d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnSettingActivity f23510a;

        C6709d(WarnSettingActivity warnSettingActivity) {
            this.f23510a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23510a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnSettingActivity_ViewBinding(WarnSettingActivity warnSettingActivity) {
        this(warnSettingActivity, warnSettingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnSettingActivity warnSettingActivity = this.f23499a;
        if (warnSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23499a = null;
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
        this.f23500b.setOnClickListener(null);
        this.f23500b = null;
        this.f23501c.setOnClickListener(null);
        this.f23501c = null;
        this.f23502d.setOnClickListener(null);
        this.f23502d = null;
        this.f23503e.setOnClickListener(null);
        this.f23503e = null;
    }

    @UiThread
    public WarnSettingActivity_ViewBinding(WarnSettingActivity warnSettingActivity, View view) {
        this.f23499a = warnSettingActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        warnSettingActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23500b = findRequiredView;
        findRequiredView.setOnClickListener(new C6706a(warnSettingActivity));
        warnSettingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        warnSettingActivity.mIvRight = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f23501c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6707b(warnSettingActivity));
        warnSettingActivity.mTvContent = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_content, "field 'mTvContent'", TextView.class);
        warnSettingActivity.mTvContentSecond = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_content_second, "field 'mTvContentSecond'", TextView.class);
        warnSettingActivity.mLayoutOpen = (ConstraintLayout) Utils.findRequiredViewAsType(view, C2113R.id.layout_open, "field 'mLayoutOpen'", ConstraintLayout.class);
        warnSettingActivity.mSwitchCall = (SwitchButton) Utils.findRequiredViewAsType(view, C2113R.id.switch_call, "field 'mSwitchCall'", SwitchButton.class);
        warnSettingActivity.mSwitchSms = (SwitchButton) Utils.findRequiredViewAsType(view, C2113R.id.switch_sms, "field 'mSwitchSms'", SwitchButton.class);
        warnSettingActivity.mSwitchApp = (SwitchButton) Utils.findRequiredViewAsType(view, C2113R.id.switch_app, "field 'mSwitchApp'", SwitchButton.class);
        warnSettingActivity.mTvCall = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_call, "field 'mTvCall'", TextView.class);
        warnSettingActivity.mTvSms = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_sms, "field 'mTvSms'", TextView.class);
        warnSettingActivity.mTvApp = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app, "field 'mTvApp'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_go_permission, "field 'mTvGoPermission' and method 'onViewClicked'");
        warnSettingActivity.mTvGoPermission = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_go_permission, "field 'mTvGoPermission'", TextView.class);
        this.f23502d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6708c(warnSettingActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.tv_error_free, "method 'onViewClicked'");
        this.f23503e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6709d(warnSettingActivity));
    }
}
