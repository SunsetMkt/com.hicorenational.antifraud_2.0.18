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
import ui.view.AudioPlayerView;
import ui.view.LoadingLottieView;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyAudioFragment_ViewBinding implements Unbinder {
    private AIVerifyAudioFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f14127e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyAudioFragment a;

        a(AIVerifyAudioFragment aIVerifyAudioFragment) {
            this.a = aIVerifyAudioFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyAudioFragment a;

        b(AIVerifyAudioFragment aIVerifyAudioFragment) {
            this.a = aIVerifyAudioFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyAudioFragment a;

        c(AIVerifyAudioFragment aIVerifyAudioFragment) {
            this.a = aIVerifyAudioFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyAudioFragment a;

        d(AIVerifyAudioFragment aIVerifyAudioFragment) {
            this.a = aIVerifyAudioFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AIVerifyAudioFragment_ViewBinding(AIVerifyAudioFragment aIVerifyAudioFragment, View view) {
        this.a = aIVerifyAudioFragment;
        aIVerifyAudioFragment.mCheckLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.mCheckLayout, "field 'mCheckLayout'", FrameLayout.class);
        aIVerifyAudioFragment.mUnCheckLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mUnCheckLayout, "field 'mUnCheckLayout'", LinearLayout.class);
        aIVerifyAudioFragment.mUnCheckTipImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.mUnCheckTipImg, "field 'mUnCheckTipImg'", ImageView.class);
        aIVerifyAudioFragment.mUnCheckTipTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.mUnCheckTipTitle, "field 'mUnCheckTipTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.mCheckBtn, "field 'mCheckBtn' and method 'onViewClicked'");
        aIVerifyAudioFragment.mCheckBtn = (TextView) Utils.castView(viewFindRequiredView, R.id.mCheckBtn, "field 'mCheckBtn'", TextView.class);
        this.f14124b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aIVerifyAudioFragment));
        aIVerifyAudioFragment.mLoadingView = (LoadingLottieView) Utils.findRequiredViewAsType(view, R.id.mLoadingView, "field 'mLoadingView'", LoadingLottieView.class);
        aIVerifyAudioFragment.mAudioView = (AudioPlayerView) Utils.findRequiredViewAsType(view, R.id.mAudioPlayerView, "field 'mAudioView'", AudioPlayerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.mUploadImageLayout, "method 'onViewClicked'");
        this.f14125c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(aIVerifyAudioFragment));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.frame_layout, "method 'onViewClicked'");
        this.f14126d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(aIVerifyAudioFragment));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ai_check_border, "method 'onViewClicked'");
        this.f14127e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(aIVerifyAudioFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AIVerifyAudioFragment aIVerifyAudioFragment = this.a;
        if (aIVerifyAudioFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        aIVerifyAudioFragment.mCheckLayout = null;
        aIVerifyAudioFragment.mUnCheckLayout = null;
        aIVerifyAudioFragment.mUnCheckTipImg = null;
        aIVerifyAudioFragment.mUnCheckTipTitle = null;
        aIVerifyAudioFragment.mCheckBtn = null;
        aIVerifyAudioFragment.mLoadingView = null;
        aIVerifyAudioFragment.mAudioView = null;
        this.f14124b.setOnClickListener(null);
        this.f14124b = null;
        this.f14125c.setOnClickListener(null);
        this.f14125c = null;
        this.f14126d.setOnClickListener(null);
        this.f14126d = null;
        this.f14127e.setOnClickListener(null);
        this.f14127e = null;
    }
}
