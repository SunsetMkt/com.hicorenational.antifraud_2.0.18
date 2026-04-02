package ui.activity;

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
public class WebFullActivity_ViewBinding implements Unbinder {
    private WebFullActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14046b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ WebFullActivity a;

        a(WebFullActivity webFullActivity) {
            this.a = webFullActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public WebFullActivity_ViewBinding(WebFullActivity webFullActivity) {
        this(webFullActivity, webFullActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebFullActivity webFullActivity = this.a;
        if (webFullActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        webFullActivity.mProgressBar = null;
        webFullActivity.mLinearLayout = null;
        webFullActivity.mLlNetworkNo = null;
        this.f14046b.setOnClickListener(null);
        this.f14046b = null;
    }

    @UiThread
    public WebFullActivity_ViewBinding(WebFullActivity webFullActivity, View view) {
        this.a = webFullActivity;
        webFullActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        webFullActivity.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webFullActivity.mLlNetworkNo = viewFindRequiredView;
        this.f14046b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(webFullActivity));
    }
}
