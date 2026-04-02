package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public class PromosWebDetActivity_ViewBinding implements Unbinder {
    private PromosWebDetActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f13599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f13600g;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PromosWebDetActivity a;

        a(PromosWebDetActivity promosWebDetActivity) {
            this.a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ PromosWebDetActivity a;

        b(PromosWebDetActivity promosWebDetActivity) {
            this.a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ PromosWebDetActivity a;

        c(PromosWebDetActivity promosWebDetActivity) {
            this.a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ PromosWebDetActivity a;

        d(PromosWebDetActivity promosWebDetActivity) {
            this.a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {
        final /* synthetic */ PromosWebDetActivity a;

        e(PromosWebDetActivity promosWebDetActivity) {
            this.a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {
        final /* synthetic */ PromosWebDetActivity a;

        f(PromosWebDetActivity promosWebDetActivity) {
            this.a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public PromosWebDetActivity_ViewBinding(PromosWebDetActivity promosWebDetActivity) {
        this(promosWebDetActivity, promosWebDetActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PromosWebDetActivity promosWebDetActivity = this.a;
        if (promosWebDetActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        promosWebDetActivity.mRlTitle = null;
        promosWebDetActivity.mTvTitle = null;
        promosWebDetActivity.mIvRight = null;
        promosWebDetActivity.mIvRight2 = null;
        promosWebDetActivity.mRlTitleWhite = null;
        promosWebDetActivity.mWebview = null;
        promosWebDetActivity.mTvHelp = null;
        promosWebDetActivity.mProgressBar = null;
        promosWebDetActivity.mLlNetworkNo = null;
        promosWebDetActivity.mLlToReport = null;
        this.f13595b.setOnClickListener(null);
        this.f13595b = null;
        this.f13596c.setOnClickListener(null);
        this.f13596c = null;
        this.f13597d.setOnClickListener(null);
        this.f13597d = null;
        this.f13598e.setOnClickListener(null);
        this.f13598e = null;
        this.f13599f.setOnClickListener(null);
        this.f13599f = null;
        this.f13600g.setOnClickListener(null);
        this.f13600g = null;
    }

    @UiThread
    public PromosWebDetActivity_ViewBinding(PromosWebDetActivity promosWebDetActivity, View view) {
        this.a = promosWebDetActivity;
        promosWebDetActivity.mRlTitle = Utils.findRequiredView(view, R.id.rl_title, "field 'mRlTitle'");
        promosWebDetActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        promosWebDetActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f13595b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(promosWebDetActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right2, "field 'mIvRight2' and method 'onViewClicked'");
        promosWebDetActivity.mIvRight2 = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right2, "field 'mIvRight2'", ImageView.class);
        this.f13596c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(promosWebDetActivity));
        promosWebDetActivity.mRlTitleWhite = Utils.findRequiredView(view, R.id.fl_tit_white, "field 'mRlTitleWhite'");
        promosWebDetActivity.mWebview = (MyWebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'mWebview'", MyWebView.class);
        promosWebDetActivity.mTvHelp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_help, "field 'mTvHelp'", TextView.class);
        promosWebDetActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        promosWebDetActivity.mLlNetworkNo = viewFindRequiredView3;
        this.f13597d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(promosWebDetActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_to_report, "field 'mLlToReport' and method 'onViewClicked'");
        promosWebDetActivity.mLlToReport = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.ll_to_report, "field 'mLlToReport'", LinearLayout.class);
        this.f13598e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(promosWebDetActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13599f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(promosWebDetActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_back2, "method 'onViewClicked'");
        this.f13600g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(promosWebDetActivity));
    }
}
