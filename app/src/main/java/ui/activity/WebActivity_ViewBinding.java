package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.MyWebView;

/* JADX INFO: loaded from: classes2.dex */
public class WebActivity_ViewBinding implements Unbinder {
    private WebActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14041d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ WebActivity a;

        a(WebActivity webActivity) {
            this.a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ WebActivity a;

        b(WebActivity webActivity) {
            this.a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ WebActivity a;

        c(WebActivity webActivity) {
            this.a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public WebActivity_ViewBinding(WebActivity webActivity) {
        this(webActivity, webActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebActivity webActivity = this.a;
        if (webActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        webActivity.mRlTitle = null;
        webActivity.mTvTitle = null;
        webActivity.mTIvBack = null;
        webActivity.mTIvShare = null;
        webActivity.mWebview = null;
        webActivity.mProgressBar = null;
        webActivity.mProgressLoad = null;
        webActivity.mFlmask = null;
        webActivity.mLlNetworkNo = null;
        this.f14039b.setOnClickListener(null);
        this.f14039b = null;
        this.f14040c.setOnClickListener(null);
        this.f14040c = null;
        this.f14041d.setOnClickListener(null);
        this.f14041d = null;
    }

    @UiThread
    public WebActivity_ViewBinding(WebActivity webActivity, View view) {
        this.a = webActivity;
        webActivity.mRlTitle = Utils.findRequiredView(view, R.id.rl_title, "field 'mRlTitle'");
        webActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mTIvBack' and method 'onViewClicked'");
        webActivity.mTIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mTIvBack'", ImageView.class);
        this.f14039b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(webActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mTIvShare' and method 'onViewClicked'");
        webActivity.mTIvShare = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mTIvShare'", ImageView.class);
        this.f14040c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(webActivity));
        webActivity.mWebview = (MyWebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'mWebview'", MyWebView.class);
        webActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        webActivity.mProgressLoad = Utils.findRequiredView(view, R.id.ll_progress, "field 'mProgressLoad'");
        webActivity.mFlmask = Utils.findRequiredView(view, R.id.fl_mask, "field 'mFlmask'");
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webActivity.mLlNetworkNo = viewFindRequiredView3;
        this.f14041d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(webActivity));
    }
}
