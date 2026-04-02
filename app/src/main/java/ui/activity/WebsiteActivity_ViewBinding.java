package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class WebsiteActivity_ViewBinding implements Unbinder {
    private WebsiteActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f14054e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ WebsiteActivity a;

        a(WebsiteActivity websiteActivity) {
            this.a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ WebsiteActivity a;

        b(WebsiteActivity websiteActivity) {
            this.a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ WebsiteActivity a;

        c(WebsiteActivity websiteActivity) {
            this.a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ WebsiteActivity a;

        d(WebsiteActivity websiteActivity) {
            this.a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public WebsiteActivity_ViewBinding(WebsiteActivity websiteActivity) {
        this(websiteActivity, websiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebsiteActivity websiteActivity = this.a;
        if (websiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        websiteActivity.mIvBack = null;
        websiteActivity.mTvTitle = null;
        websiteActivity.mVline = null;
        websiteActivity.mTvSelectHistory = null;
        websiteActivity.mLinearLayout = null;
        websiteActivity.mTvCommit = null;
        websiteActivity.mBtnCommit = null;
        this.f14051b.setOnClickListener(null);
        this.f14051b = null;
        this.f14052c.setOnClickListener(null);
        this.f14052c = null;
        this.f14053d.setOnClickListener(null);
        this.f14053d = null;
        this.f14054e.setOnClickListener(null);
        this.f14054e = null;
    }

    @UiThread
    public WebsiteActivity_ViewBinding(WebsiteActivity websiteActivity, View view) {
        this.a = websiteActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        websiteActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f14051b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(websiteActivity));
        websiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        websiteActivity.mVline = Utils.findRequiredView(view, R.id.v_line, "field 'mVline'");
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.fl_select_history, "field 'mTvSelectHistory' and method 'onViewClicked'");
        websiteActivity.mTvSelectHistory = viewFindRequiredView2;
        this.f14052c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(websiteActivity));
        websiteActivity.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.linearlayout, "field 'mLinearLayout'", LinearLayout.class);
        websiteActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        websiteActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f14053d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(websiteActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.fl_select, "method 'onViewClicked'");
        this.f14054e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(websiteActivity));
    }
}
