package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.MyWebView;

/* loaded from: classes2.dex */
public class WebActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WebActivity f23516a;

    /* renamed from: b */
    private View f23517b;

    /* renamed from: c */
    private View f23518c;

    /* renamed from: d */
    private View f23519d;

    /* renamed from: ui.activity.WebActivity_ViewBinding$a */
    class C6714a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebActivity f23520a;

        C6714a(WebActivity webActivity) {
            this.f23520a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23520a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WebActivity_ViewBinding$b */
    class C6715b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebActivity f23522a;

        C6715b(WebActivity webActivity) {
            this.f23522a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23522a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WebActivity_ViewBinding$c */
    class C6716c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebActivity f23524a;

        C6716c(WebActivity webActivity) {
            this.f23524a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23524a.onViewClicked(view);
        }
    }

    @UiThread
    public WebActivity_ViewBinding(WebActivity webActivity) {
        this(webActivity, webActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebActivity webActivity = this.f23516a;
        if (webActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23516a = null;
        webActivity.mRlTitle = null;
        webActivity.mTvTitle = null;
        webActivity.mTIvBack = null;
        webActivity.mTIvShare = null;
        webActivity.mWebview = null;
        webActivity.mProgressBar = null;
        webActivity.mProgressLoad = null;
        webActivity.mFlmask = null;
        webActivity.mLlNetworkNo = null;
        this.f23517b.setOnClickListener(null);
        this.f23517b = null;
        this.f23518c.setOnClickListener(null);
        this.f23518c = null;
        this.f23519d.setOnClickListener(null);
        this.f23519d = null;
    }

    @UiThread
    public WebActivity_ViewBinding(WebActivity webActivity, View view) {
        this.f23516a = webActivity;
        webActivity.mRlTitle = Utils.findRequiredView(view, C2113R.id.rl_title, "field 'mRlTitle'");
        webActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mTIvBack' and method 'onViewClicked'");
        webActivity.mTIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mTIvBack'", ImageView.class);
        this.f23517b = findRequiredView;
        findRequiredView.setOnClickListener(new C6714a(webActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mTIvShare' and method 'onViewClicked'");
        webActivity.mTIvShare = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_right, "field 'mTIvShare'", ImageView.class);
        this.f23518c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6715b(webActivity));
        webActivity.mWebview = (MyWebView) Utils.findRequiredViewAsType(view, C2113R.id.webview, "field 'mWebview'", MyWebView.class);
        webActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C2113R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        webActivity.mProgressLoad = Utils.findRequiredView(view, C2113R.id.ll_progress, "field 'mProgressLoad'");
        webActivity.mFlmask = Utils.findRequiredView(view, C2113R.id.fl_mask, "field 'mFlmask'");
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webActivity.mLlNetworkNo = findRequiredView3;
        this.f23519d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6716c(webActivity));
    }
}
