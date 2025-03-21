package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class WarnActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WarnActivity f23437a;

    /* renamed from: b */
    private View f23438b;

    /* renamed from: ui.activity.WarnActivity_ViewBinding$a */
    class C6685a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnActivity f23439a;

        C6685a(WarnActivity warnActivity) {
            this.f23439a = warnActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23439a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnActivity_ViewBinding(WarnActivity warnActivity) {
        this(warnActivity, warnActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnActivity warnActivity = this.f23437a;
        if (warnActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23437a = null;
        warnActivity.mTvAppVersion = null;
        this.f23438b.setOnClickListener(null);
        this.f23438b = null;
    }

    @UiThread
    public WarnActivity_ViewBinding(WarnActivity warnActivity, View view) {
        this.f23437a = warnActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_dialog_phone, "field 'mTvAppVersion' and method 'onViewClicked'");
        warnActivity.mTvAppVersion = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_dialog_phone, "field 'mTvAppVersion'", TextView.class);
        this.f23438b = findRequiredView;
        findRequiredView.setOnClickListener(new C6685a(warnActivity));
    }
}
