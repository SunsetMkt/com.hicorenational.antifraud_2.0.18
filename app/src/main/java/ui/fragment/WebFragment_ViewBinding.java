package ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class WebFragment_ViewBinding implements Unbinder {
    private WebFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14224d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ WebFragment a;

        a(WebFragment webFragment) {
            this.a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ WebFragment a;

        b(WebFragment webFragment) {
            this.a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ WebFragment a;

        c(WebFragment webFragment) {
            this.a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public WebFragment_ViewBinding(WebFragment webFragment, View view) {
        this.a = webFragment;
        webFragment.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mTIvBack' and method 'onViewClicked'");
        webFragment.mTIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mTIvBack'", ImageView.class);
        this.f14222b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(webFragment));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        webFragment.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f14223c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(webFragment));
        webFragment.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webFragment.mLlNetworkNo = viewFindRequiredView3;
        this.f14224d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(webFragment));
        webFragment.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pro_bar, "field 'mProgressBar'", ProgressBar.class);
        webFragment.mNetTips = (TextView) Utils.findRequiredViewAsType(view, R.id.net_tips, "field 'mNetTips'", TextView.class);
        webFragment.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebFragment webFragment = this.a;
        if (webFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        webFragment.mRlTitle = null;
        webFragment.mTIvBack = null;
        webFragment.mIvRight = null;
        webFragment.mTvTitle = null;
        webFragment.mLlNetworkNo = null;
        webFragment.mProgressBar = null;
        webFragment.mNetTips = null;
        webFragment.mLinearLayout = null;
        this.f14222b.setOnClickListener(null);
        this.f14222b = null;
        this.f14223c.setOnClickListener(null);
        this.f14223c = null;
        this.f14224d.setOnClickListener(null);
        this.f14224d = null;
    }
}
