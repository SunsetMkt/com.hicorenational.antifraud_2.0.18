package p388ui.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class LocalWebFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LocalWebFragment f23820a;

    /* renamed from: b */
    private View f23821b;

    /* renamed from: ui.fragment.LocalWebFragment_ViewBinding$a */
    class C6865a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ LocalWebFragment f23822a;

        C6865a(LocalWebFragment localWebFragment) {
            this.f23822a = localWebFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23822a.onViewClicked(view);
        }
    }

    @UiThread
    public LocalWebFragment_ViewBinding(LocalWebFragment localWebFragment, View view) {
        this.f23820a = localWebFragment;
        localWebFragment.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
        localWebFragment.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C2113R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        localWebFragment.mProgressLoad = Utils.findRequiredView(view, C2113R.id.ll_progress, "field 'mProgressLoad'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        localWebFragment.mLlNetworkNo = findRequiredView;
        this.f23821b = findRequiredView;
        findRequiredView.setOnClickListener(new C6865a(localWebFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalWebFragment localWebFragment = this.f23820a;
        if (localWebFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23820a = null;
        localWebFragment.mLinearLayout = null;
        localWebFragment.mProgressBar = null;
        localWebFragment.mProgressLoad = null;
        localWebFragment.mLlNetworkNo = null;
        this.f23821b.setOnClickListener(null);
        this.f23821b = null;
    }
}
