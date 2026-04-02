package ui.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class LocalWebFragment_ViewBinding implements Unbinder {
    private LocalWebFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14178b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ LocalWebFragment a;

        a(LocalWebFragment localWebFragment) {
            this.a = localWebFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public LocalWebFragment_ViewBinding(LocalWebFragment localWebFragment, View view) {
        this.a = localWebFragment;
        localWebFragment.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
        localWebFragment.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        localWebFragment.mProgressLoad = Utils.findRequiredView(view, R.id.ll_progress, "field 'mProgressLoad'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        localWebFragment.mLlNetworkNo = viewFindRequiredView;
        this.f14178b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(localWebFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalWebFragment localWebFragment = this.a;
        if (localWebFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        localWebFragment.mLinearLayout = null;
        localWebFragment.mProgressBar = null;
        localWebFragment.mProgressLoad = null;
        localWebFragment.mLlNetworkNo = null;
        this.f14178b.setOnClickListener(null);
        this.f14178b = null;
    }
}
