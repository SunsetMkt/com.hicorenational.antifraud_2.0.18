package ui.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.LoadingLottieView;
import ui.view.VideoTouchView;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyVideoFragment_ViewBinding implements Unbinder {
    private AIVerifyVideoFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14142d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyVideoFragment a;

        a(AIVerifyVideoFragment aIVerifyVideoFragment) {
            this.a = aIVerifyVideoFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyVideoFragment a;

        b(AIVerifyVideoFragment aIVerifyVideoFragment) {
            this.a = aIVerifyVideoFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyVideoFragment a;

        c(AIVerifyVideoFragment aIVerifyVideoFragment) {
            this.a = aIVerifyVideoFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AIVerifyVideoFragment_ViewBinding(AIVerifyVideoFragment aIVerifyVideoFragment, View view) {
        this.a = aIVerifyVideoFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.mCheckLayout, "field 'mCheckLayout' and method 'onViewClicked'");
        aIVerifyVideoFragment.mCheckLayout = (FrameLayout) Utils.castView(viewFindRequiredView, R.id.mCheckLayout, "field 'mCheckLayout'", FrameLayout.class);
        this.f14140b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aIVerifyVideoFragment));
        aIVerifyVideoFragment.mUnCheckLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mUnCheckLayout, "field 'mUnCheckLayout'", LinearLayout.class);
        aIVerifyVideoFragment.mUnCheckTipImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.mUnCheckTipImg, "field 'mUnCheckTipImg'", ImageView.class);
        aIVerifyVideoFragment.mUnCheckTipTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.mUnCheckTipTitle, "field 'mUnCheckTipTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.mCheckBtn, "field 'mCheckBtn' and method 'onViewClicked'");
        aIVerifyVideoFragment.mCheckBtn = (TextView) Utils.castView(viewFindRequiredView2, R.id.mCheckBtn, "field 'mCheckBtn'", TextView.class);
        this.f14141c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(aIVerifyVideoFragment));
        aIVerifyVideoFragment.mLoadingView = (LoadingLottieView) Utils.findRequiredViewAsType(view, R.id.mLoadingView, "field 'mLoadingView'", LoadingLottieView.class);
        aIVerifyVideoFragment.mVideoPlayer = (VideoTouchView) Utils.findRequiredViewAsType(view, R.id.mVideoPlayer, "field 'mVideoPlayer'", VideoTouchView.class);
        aIVerifyVideoFragment.clickVideoView = Utils.findRequiredView(view, R.id.clickVideoView, "field 'clickVideoView'");
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.mUploadImageLayout, "method 'onViewClicked'");
        this.f14142d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(aIVerifyVideoFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AIVerifyVideoFragment aIVerifyVideoFragment = this.a;
        if (aIVerifyVideoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        aIVerifyVideoFragment.mCheckLayout = null;
        aIVerifyVideoFragment.mUnCheckLayout = null;
        aIVerifyVideoFragment.mUnCheckTipImg = null;
        aIVerifyVideoFragment.mUnCheckTipTitle = null;
        aIVerifyVideoFragment.mCheckBtn = null;
        aIVerifyVideoFragment.mLoadingView = null;
        aIVerifyVideoFragment.mVideoPlayer = null;
        aIVerifyVideoFragment.clickVideoView = null;
        this.f14140b.setOnClickListener(null);
        this.f14140b = null;
        this.f14141c.setOnClickListener(null);
        this.f14141c = null;
        this.f14142d.setOnClickListener(null);
        this.f14142d = null;
    }
}
