package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class AboutUsActivity_ViewBinding implements Unbinder {
    private AboutUsActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13040e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AboutUsActivity a;

        a(AboutUsActivity aboutUsActivity) {
            this.a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AboutUsActivity a;

        b(AboutUsActivity aboutUsActivity) {
            this.a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AboutUsActivity a;

        c(AboutUsActivity aboutUsActivity) {
            this.a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ AboutUsActivity a;

        d(AboutUsActivity aboutUsActivity) {
            this.a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AboutUsActivity_ViewBinding(AboutUsActivity aboutUsActivity) {
        this(aboutUsActivity, aboutUsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AboutUsActivity aboutUsActivity = this.a;
        if (aboutUsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        aboutUsActivity.mTvAppVersion = null;
        aboutUsActivity.mTvTitle = null;
        aboutUsActivity.mTvOwnerTip = null;
        aboutUsActivity.mTvTechSupor = null;
        aboutUsActivity.mTvAppTip = null;
        aboutUsActivity.mChenkBtn = null;
        aboutUsActivity.mTvSdk = null;
        this.f13037b.setOnClickListener(null);
        this.f13037b = null;
        this.f13038c.setOnClickListener(null);
        this.f13038c = null;
        this.f13039d.setOnClickListener(null);
        this.f13039d = null;
        this.f13040e.setOnClickListener(null);
        this.f13040e = null;
    }

    @UiThread
    public AboutUsActivity_ViewBinding(AboutUsActivity aboutUsActivity, View view) {
        this.a = aboutUsActivity;
        aboutUsActivity.mTvAppVersion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_version, "field 'mTvAppVersion'", TextView.class);
        aboutUsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        aboutUsActivity.mTvOwnerTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_owner_tip, "field 'mTvOwnerTip'", TextView.class);
        aboutUsActivity.mTvTechSupor = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tech_sup, "field 'mTvTechSupor'", TextView.class);
        aboutUsActivity.mTvAppTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_new_tips, "field 'mTvAppTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.check_upadte, "field 'mChenkBtn' and method 'onViewClicked'");
        aboutUsActivity.mChenkBtn = (Button) Utils.castView(viewFindRequiredView, R.id.check_upadte, "field 'mChenkBtn'", Button.class);
        this.f13037b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aboutUsActivity));
        aboutUsActivity.mTvSdk = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sdk_version, "field 'mTvSdk'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13038c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(aboutUsActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_agreement, "method 'onViewClicked'");
        this.f13039d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(aboutUsActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_policy, "method 'onViewClicked'");
        this.f13040e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(aboutUsActivity));
    }
}
