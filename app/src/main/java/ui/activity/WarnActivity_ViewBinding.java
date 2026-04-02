package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class WarnActivity_ViewBinding implements Unbinder {
    private WarnActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13995b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ WarnActivity a;

        a(WarnActivity warnActivity) {
            this.a = warnActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnActivity_ViewBinding(WarnActivity warnActivity) {
        this(warnActivity, warnActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnActivity warnActivity = this.a;
        if (warnActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        warnActivity.mTvAppVersion = null;
        this.f13995b.setOnClickListener(null);
        this.f13995b = null;
    }

    @UiThread
    public WarnActivity_ViewBinding(WarnActivity warnActivity, View view) {
        this.a = warnActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_dialog_phone, "field 'mTvAppVersion' and method 'onViewClicked'");
        warnActivity.mTvAppVersion = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_dialog_phone, "field 'mTvAppVersion'", TextView.class);
        this.f13995b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(warnActivity));
    }
}
