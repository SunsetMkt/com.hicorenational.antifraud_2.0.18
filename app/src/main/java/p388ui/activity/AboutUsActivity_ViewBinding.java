package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AboutUsActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AboutUsActivity f21722a;

    /* renamed from: b */
    private View f21723b;

    /* renamed from: c */
    private View f21724c;

    /* renamed from: d */
    private View f21725d;

    /* renamed from: e */
    private View f21726e;

    /* renamed from: ui.activity.AboutUsActivity_ViewBinding$a */
    class C6091a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AboutUsActivity f21727a;

        C6091a(AboutUsActivity aboutUsActivity) {
            this.f21727a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21727a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AboutUsActivity_ViewBinding$b */
    class C6092b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AboutUsActivity f21729a;

        C6092b(AboutUsActivity aboutUsActivity) {
            this.f21729a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21729a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AboutUsActivity_ViewBinding$c */
    class C6093c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AboutUsActivity f21731a;

        C6093c(AboutUsActivity aboutUsActivity) {
            this.f21731a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21731a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AboutUsActivity_ViewBinding$d */
    class C6094d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AboutUsActivity f21733a;

        C6094d(AboutUsActivity aboutUsActivity) {
            this.f21733a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21733a.onViewClicked(view);
        }
    }

    @UiThread
    public AboutUsActivity_ViewBinding(AboutUsActivity aboutUsActivity) {
        this(aboutUsActivity, aboutUsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AboutUsActivity aboutUsActivity = this.f21722a;
        if (aboutUsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21722a = null;
        aboutUsActivity.mTvAppVersion = null;
        aboutUsActivity.mTvTitle = null;
        aboutUsActivity.mTvOwnerTip = null;
        aboutUsActivity.mTvTechSupor = null;
        aboutUsActivity.mTvAppTip = null;
        aboutUsActivity.mChenkBtn = null;
        aboutUsActivity.mTvSdk = null;
        this.f21723b.setOnClickListener(null);
        this.f21723b = null;
        this.f21724c.setOnClickListener(null);
        this.f21724c = null;
        this.f21725d.setOnClickListener(null);
        this.f21725d = null;
        this.f21726e.setOnClickListener(null);
        this.f21726e = null;
    }

    @UiThread
    public AboutUsActivity_ViewBinding(AboutUsActivity aboutUsActivity, View view) {
        this.f21722a = aboutUsActivity;
        aboutUsActivity.mTvAppVersion = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_version, "field 'mTvAppVersion'", TextView.class);
        aboutUsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        aboutUsActivity.mTvOwnerTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_owner_tip, "field 'mTvOwnerTip'", TextView.class);
        aboutUsActivity.mTvTechSupor = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tech_sup, "field 'mTvTechSupor'", TextView.class);
        aboutUsActivity.mTvAppTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_new_tips, "field 'mTvAppTip'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.check_upadte, "field 'mChenkBtn' and method 'onViewClicked'");
        aboutUsActivity.mChenkBtn = (Button) Utils.castView(findRequiredView, C2113R.id.check_upadte, "field 'mChenkBtn'", Button.class);
        this.f21723b = findRequiredView;
        findRequiredView.setOnClickListener(new C6091a(aboutUsActivity));
        aboutUsActivity.mTvSdk = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_sdk_version, "field 'mTvSdk'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21724c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6092b(aboutUsActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_agreement, "method 'onViewClicked'");
        this.f21725d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6093c(aboutUsActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.ll_policy, "method 'onViewClicked'");
        this.f21726e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6094d(aboutUsActivity));
    }
}
