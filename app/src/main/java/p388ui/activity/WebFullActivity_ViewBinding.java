package p388ui.activity;

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
public class WebFullActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WebFullActivity f23535a;

    /* renamed from: b */
    private View f23536b;

    /* renamed from: ui.activity.WebFullActivity_ViewBinding$a */
    class C6723a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WebFullActivity f23537a;

        C6723a(WebFullActivity webFullActivity) {
            this.f23537a = webFullActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23537a.onViewClicked(view);
        }
    }

    @UiThread
    public WebFullActivity_ViewBinding(WebFullActivity webFullActivity) {
        this(webFullActivity, webFullActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebFullActivity webFullActivity = this.f23535a;
        if (webFullActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23535a = null;
        webFullActivity.mProgressBar = null;
        webFullActivity.mLinearLayout = null;
        webFullActivity.mLlNetworkNo = null;
        this.f23536b.setOnClickListener(null);
        this.f23536b = null;
    }

    @UiThread
    public WebFullActivity_ViewBinding(WebFullActivity webFullActivity, View view) {
        this.f23535a = webFullActivity;
        webFullActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C2113R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        webFullActivity.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webFullActivity.mLlNetworkNo = findRequiredView;
        this.f23536b = findRequiredView;
        findRequiredView.setOnClickListener(new C6723a(webFullActivity));
    }
}
