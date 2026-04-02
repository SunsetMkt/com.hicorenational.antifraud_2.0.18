package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CriminalWebInfoActivity_ViewBinding implements Unbinder {
    private CriminalWebInfoActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13332e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ CriminalWebInfoActivity a;

        a(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ CriminalWebInfoActivity a;

        b(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ CriminalWebInfoActivity a;

        c(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ CriminalWebInfoActivity a;

        d(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public CriminalWebInfoActivity_ViewBinding(CriminalWebInfoActivity criminalWebInfoActivity) {
        this(criminalWebInfoActivity, criminalWebInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CriminalWebInfoActivity criminalWebInfoActivity = this.a;
        if (criminalWebInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        criminalWebInfoActivity.mIvBack = null;
        criminalWebInfoActivity.mTvTitle = null;
        criminalWebInfoActivity.mTvSocialNum = null;
        criminalWebInfoActivity.mTvAppNum = null;
        criminalWebInfoActivity.mTvWebsiteNum = null;
        this.f13329b.setOnClickListener(null);
        this.f13329b = null;
        this.f13330c.setOnClickListener(null);
        this.f13330c = null;
        this.f13331d.setOnClickListener(null);
        this.f13331d = null;
        this.f13332e.setOnClickListener(null);
        this.f13332e = null;
    }

    @UiThread
    public CriminalWebInfoActivity_ViewBinding(CriminalWebInfoActivity criminalWebInfoActivity, View view) {
        this.a = criminalWebInfoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        criminalWebInfoActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13329b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalWebInfoActivity));
        criminalWebInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalWebInfoActivity.mTvSocialNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_social_num, "field 'mTvSocialNum'", TextView.class);
        criminalWebInfoActivity.mTvAppNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_num, "field 'mTvAppNum'", TextView.class);
        criminalWebInfoActivity.mTvWebsiteNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_website_num, "field 'mTvWebsiteNum'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.cl_social, "method 'onClick'");
        this.f13330c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalWebInfoActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.cl_app, "method 'onClick'");
        this.f13331d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalWebInfoActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.cl_website, "method 'onClick'");
        this.f13332e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(criminalWebInfoActivity));
    }
}
