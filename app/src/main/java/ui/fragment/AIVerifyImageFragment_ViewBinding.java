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

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyImageFragment_ViewBinding implements Unbinder {
    private AIVerifyImageFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14134d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyImageFragment a;

        a(AIVerifyImageFragment aIVerifyImageFragment) {
            this.a = aIVerifyImageFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyImageFragment a;

        b(AIVerifyImageFragment aIVerifyImageFragment) {
            this.a = aIVerifyImageFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyImageFragment a;

        c(AIVerifyImageFragment aIVerifyImageFragment) {
            this.a = aIVerifyImageFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AIVerifyImageFragment_ViewBinding(AIVerifyImageFragment aIVerifyImageFragment, View view) {
        this.a = aIVerifyImageFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.mCheckLayout, "field 'mCheckLayout' and method 'onViewClicked'");
        aIVerifyImageFragment.mCheckLayout = (FrameLayout) Utils.castView(viewFindRequiredView, R.id.mCheckLayout, "field 'mCheckLayout'", FrameLayout.class);
        this.f14132b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aIVerifyImageFragment));
        aIVerifyImageFragment.mUnCheckLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mUnCheckLayout, "field 'mUnCheckLayout'", LinearLayout.class);
        aIVerifyImageFragment.mUnCheckTipImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.mUnCheckTipImg, "field 'mUnCheckTipImg'", ImageView.class);
        aIVerifyImageFragment.mUnCheckTipTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.mUnCheckTipTitle, "field 'mUnCheckTipTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.mCheckBtn, "field 'mCheckBtn' and method 'onViewClicked'");
        aIVerifyImageFragment.mCheckBtn = (TextView) Utils.castView(viewFindRequiredView2, R.id.mCheckBtn, "field 'mCheckBtn'", TextView.class);
        this.f14133c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(aIVerifyImageFragment));
        aIVerifyImageFragment.mCheckImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.mCheckImage, "field 'mCheckImage'", ImageView.class);
        aIVerifyImageFragment.mLoadingView = (LoadingLottieView) Utils.findRequiredViewAsType(view, R.id.mLoadingView, "field 'mLoadingView'", LoadingLottieView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.mUploadImageLayout, "method 'onViewClicked'");
        this.f14134d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(aIVerifyImageFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AIVerifyImageFragment aIVerifyImageFragment = this.a;
        if (aIVerifyImageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        aIVerifyImageFragment.mCheckLayout = null;
        aIVerifyImageFragment.mUnCheckLayout = null;
        aIVerifyImageFragment.mUnCheckTipImg = null;
        aIVerifyImageFragment.mUnCheckTipTitle = null;
        aIVerifyImageFragment.mCheckBtn = null;
        aIVerifyImageFragment.mCheckImage = null;
        aIVerifyImageFragment.mLoadingView = null;
        this.f14132b.setOnClickListener(null);
        this.f14132b = null;
        this.f14133c.setOnClickListener(null);
        this.f14133c = null;
        this.f14134d.setOnClickListener(null);
        this.f14134d = null;
    }
}
