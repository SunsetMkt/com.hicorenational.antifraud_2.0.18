package ui.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.FixedScrollbarEditText;
import ui.view.LoadingLottieView;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyTextFragment_ViewBinding implements Unbinder {
    private AIVerifyTextFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14138b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyTextFragment a;

        a(AIVerifyTextFragment aIVerifyTextFragment) {
            this.a = aIVerifyTextFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AIVerifyTextFragment_ViewBinding(AIVerifyTextFragment aIVerifyTextFragment, View view) {
        this.a = aIVerifyTextFragment;
        aIVerifyTextFragment.mTextCountLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mTextCountLayout, "field 'mTextCountLayout'", LinearLayout.class);
        aIVerifyTextFragment.mTextCount = (TextView) Utils.findRequiredViewAsType(view, R.id.mTextCount, "field 'mTextCount'", TextView.class);
        aIVerifyTextFragment.mEditText = (FixedScrollbarEditText) Utils.findRequiredViewAsType(view, R.id.mEditText, "field 'mEditText'", FixedScrollbarEditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.mCheckBtn, "field 'mCheckBtn' and method 'onViewClicked'");
        aIVerifyTextFragment.mCheckBtn = (TextView) Utils.castView(viewFindRequiredView, R.id.mCheckBtn, "field 'mCheckBtn'", TextView.class);
        this.f14138b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aIVerifyTextFragment));
        aIVerifyTextFragment.mLoadingView = (LoadingLottieView) Utils.findRequiredViewAsType(view, R.id.mLoadingView, "field 'mLoadingView'", LoadingLottieView.class);
        aIVerifyTextFragment.aiCheckBorder = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.ai_check_border, "field 'aiCheckBorder'", ConstraintLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AIVerifyTextFragment aIVerifyTextFragment = this.a;
        if (aIVerifyTextFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        aIVerifyTextFragment.mTextCountLayout = null;
        aIVerifyTextFragment.mTextCount = null;
        aIVerifyTextFragment.mEditText = null;
        aIVerifyTextFragment.mCheckBtn = null;
        aIVerifyTextFragment.mLoadingView = null;
        aIVerifyTextFragment.aiCheckBorder = null;
        this.f14138b.setOnClickListener(null);
        this.f14138b = null;
    }
}
