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
public final class CriminalWebInfoActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CriminalWebInfoActivity f22244a;

    /* renamed from: b */
    private View f22245b;

    /* renamed from: c */
    private View f22246c;

    /* renamed from: d */
    private View f22247d;

    /* renamed from: e */
    private View f22248e;

    /* renamed from: ui.activity.CriminalWebInfoActivity_ViewBinding$a */
    class C6278a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalWebInfoActivity f22249a;

        C6278a(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.f22249a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22249a.onClick(view);
        }
    }

    /* renamed from: ui.activity.CriminalWebInfoActivity_ViewBinding$b */
    class C6279b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalWebInfoActivity f22251a;

        C6279b(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.f22251a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22251a.onClick(view);
        }
    }

    /* renamed from: ui.activity.CriminalWebInfoActivity_ViewBinding$c */
    class C6280c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalWebInfoActivity f22253a;

        C6280c(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.f22253a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22253a.onClick(view);
        }
    }

    /* renamed from: ui.activity.CriminalWebInfoActivity_ViewBinding$d */
    class C6281d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalWebInfoActivity f22255a;

        C6281d(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.f22255a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22255a.onClick(view);
        }
    }

    @UiThread
    public CriminalWebInfoActivity_ViewBinding(CriminalWebInfoActivity criminalWebInfoActivity) {
        this(criminalWebInfoActivity, criminalWebInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CriminalWebInfoActivity criminalWebInfoActivity = this.f22244a;
        if (criminalWebInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22244a = null;
        criminalWebInfoActivity.mIvBack = null;
        criminalWebInfoActivity.mTvTitle = null;
        criminalWebInfoActivity.mTvSocialNum = null;
        criminalWebInfoActivity.mTvAppNum = null;
        criminalWebInfoActivity.mTvWebsiteNum = null;
        this.f22245b.setOnClickListener(null);
        this.f22245b = null;
        this.f22246c.setOnClickListener(null);
        this.f22246c = null;
        this.f22247d.setOnClickListener(null);
        this.f22247d = null;
        this.f22248e.setOnClickListener(null);
        this.f22248e = null;
    }

    @UiThread
    public CriminalWebInfoActivity_ViewBinding(CriminalWebInfoActivity criminalWebInfoActivity, View view) {
        this.f22244a = criminalWebInfoActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        criminalWebInfoActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22245b = findRequiredView;
        findRequiredView.setOnClickListener(new C6278a(criminalWebInfoActivity));
        criminalWebInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalWebInfoActivity.mTvSocialNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_social_num, "field 'mTvSocialNum'", TextView.class);
        criminalWebInfoActivity.mTvAppNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_app_num, "field 'mTvAppNum'", TextView.class);
        criminalWebInfoActivity.mTvWebsiteNum = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_website_num, "field 'mTvWebsiteNum'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.cl_social, "method 'onClick'");
        this.f22246c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6279b(criminalWebInfoActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.cl_app, "method 'onClick'");
        this.f22247d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6280c(criminalWebInfoActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.cl_website, "method 'onClick'");
        this.f22248e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6281d(criminalWebInfoActivity));
    }
}
