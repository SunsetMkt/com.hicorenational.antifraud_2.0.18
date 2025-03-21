package p388ui.fragment;

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
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class WebFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WebFragment f23886a;

    /* renamed from: b */
    private View f23887b;

    /* renamed from: c */
    private View f23888c;

    /* renamed from: d */
    private View f23889d;

    /* renamed from: ui.fragment.WebFragment_ViewBinding$a */
    class C6886a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebFragment f23890a;

        C6886a(WebFragment webFragment) {
            this.f23890a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23890a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.WebFragment_ViewBinding$b */
    class C6887b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebFragment f23892a;

        C6887b(WebFragment webFragment) {
            this.f23892a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23892a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.WebFragment_ViewBinding$c */
    class C6888c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebFragment f23894a;

        C6888c(WebFragment webFragment) {
            this.f23894a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23894a.onViewClicked(view);
        }
    }

    @UiThread
    public WebFragment_ViewBinding(WebFragment webFragment, View view) {
        this.f23886a = webFragment;
        webFragment.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, C2113R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mTIvBack' and method 'onViewClicked'");
        webFragment.mTIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mTIvBack'", ImageView.class);
        this.f23887b = findRequiredView;
        findRequiredView.setOnClickListener(new C6886a(webFragment));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        webFragment.mIvRight = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f23888c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6887b(webFragment));
        webFragment.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webFragment.mLlNetworkNo = findRequiredView3;
        this.f23889d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6888c(webFragment));
        webFragment.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C2113R.id.pro_bar, "field 'mProgressBar'", ProgressBar.class);
        webFragment.mNetTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.net_tips, "field 'mNetTips'", TextView.class);
        webFragment.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebFragment webFragment = this.f23886a;
        if (webFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23886a = null;
        webFragment.mRlTitle = null;
        webFragment.mTIvBack = null;
        webFragment.mIvRight = null;
        webFragment.mTvTitle = null;
        webFragment.mLlNetworkNo = null;
        webFragment.mProgressBar = null;
        webFragment.mNetTips = null;
        webFragment.mLinearLayout = null;
        this.f23887b.setOnClickListener(null);
        this.f23887b = null;
        this.f23888c.setOnClickListener(null);
        this.f23888c = null;
        this.f23889d.setOnClickListener(null);
        this.f23889d = null;
    }
}
