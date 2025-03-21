package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import p388ui.view.MyWebView;

/* loaded from: classes2.dex */
public class PromosWebDetActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PromosWebDetActivity f22731a;

    /* renamed from: b */
    private View f22732b;

    /* renamed from: c */
    private View f22733c;

    /* renamed from: d */
    private View f22734d;

    /* renamed from: e */
    private View f22735e;

    /* renamed from: f */
    private View f22736f;

    /* renamed from: g */
    private View f22737g;

    /* renamed from: ui.activity.PromosWebDetActivity_ViewBinding$a */
    class C6447a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PromosWebDetActivity f22738a;

        C6447a(PromosWebDetActivity promosWebDetActivity) {
            this.f22738a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22738a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PromosWebDetActivity_ViewBinding$b */
    class C6448b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PromosWebDetActivity f22740a;

        C6448b(PromosWebDetActivity promosWebDetActivity) {
            this.f22740a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22740a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PromosWebDetActivity_ViewBinding$c */
    class C6449c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PromosWebDetActivity f22742a;

        C6449c(PromosWebDetActivity promosWebDetActivity) {
            this.f22742a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22742a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PromosWebDetActivity_ViewBinding$d */
    class C6450d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PromosWebDetActivity f22744a;

        C6450d(PromosWebDetActivity promosWebDetActivity) {
            this.f22744a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22744a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PromosWebDetActivity_ViewBinding$e */
    class C6451e extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PromosWebDetActivity f22746a;

        C6451e(PromosWebDetActivity promosWebDetActivity) {
            this.f22746a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22746a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.PromosWebDetActivity_ViewBinding$f */
    class C6452f extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PromosWebDetActivity f22748a;

        C6452f(PromosWebDetActivity promosWebDetActivity) {
            this.f22748a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22748a.onViewClicked(view);
        }
    }

    @UiThread
    public PromosWebDetActivity_ViewBinding(PromosWebDetActivity promosWebDetActivity) {
        this(promosWebDetActivity, promosWebDetActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PromosWebDetActivity promosWebDetActivity = this.f22731a;
        if (promosWebDetActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22731a = null;
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
        this.f22732b.setOnClickListener(null);
        this.f22732b = null;
        this.f22733c.setOnClickListener(null);
        this.f22733c = null;
        this.f22734d.setOnClickListener(null);
        this.f22734d = null;
        this.f22735e.setOnClickListener(null);
        this.f22735e = null;
        this.f22736f.setOnClickListener(null);
        this.f22736f = null;
        this.f22737g.setOnClickListener(null);
        this.f22737g = null;
    }

    @UiThread
    public PromosWebDetActivity_ViewBinding(PromosWebDetActivity promosWebDetActivity, View view) {
        this.f22731a = promosWebDetActivity;
        promosWebDetActivity.mRlTitle = Utils.findRequiredView(view, C2113R.id.rl_title, "field 'mRlTitle'");
        promosWebDetActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        promosWebDetActivity.mIvRight = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f22732b = findRequiredView;
        findRequiredView.setOnClickListener(new C6447a(promosWebDetActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_right2, "field 'mIvRight2' and method 'onViewClicked'");
        promosWebDetActivity.mIvRight2 = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_right2, "field 'mIvRight2'", ImageView.class);
        this.f22733c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6448b(promosWebDetActivity));
        promosWebDetActivity.mRlTitleWhite = Utils.findRequiredView(view, C2113R.id.fl_tit_white, "field 'mRlTitleWhite'");
        promosWebDetActivity.mWebview = (MyWebView) Utils.findRequiredViewAsType(view, C2113R.id.webview, "field 'mWebview'", MyWebView.class);
        promosWebDetActivity.mTvHelp = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_help, "field 'mTvHelp'", TextView.class);
        promosWebDetActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C2113R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        promosWebDetActivity.mLlNetworkNo = findRequiredView3;
        this.f22734d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6449c(promosWebDetActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.ll_to_report, "field 'mLlToReport' and method 'onViewClicked'");
        promosWebDetActivity.mLlToReport = (LinearLayout) Utils.castView(findRequiredView4, C2113R.id.ll_to_report, "field 'mLlToReport'", LinearLayout.class);
        this.f22735e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6450d(promosWebDetActivity));
        View findRequiredView5 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22736f = findRequiredView5;
        findRequiredView5.setOnClickListener(new C6451e(promosWebDetActivity));
        View findRequiredView6 = Utils.findRequiredView(view, C2113R.id.iv_back2, "method 'onViewClicked'");
        this.f22737g = findRequiredView6;
        findRequiredView6.setOnClickListener(new C6452f(promosWebDetActivity));
    }
}
