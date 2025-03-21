package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class ReportSuccessActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReportSuccessActivity f22975a;

    /* renamed from: b */
    private View f22976b;

    /* renamed from: c */
    private View f22977c;

    /* renamed from: ui.activity.ReportSuccessActivity_ViewBinding$a */
    class C6537a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportSuccessActivity f22978a;

        C6537a(ReportSuccessActivity reportSuccessActivity) {
            this.f22978a = reportSuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22978a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportSuccessActivity_ViewBinding$b */
    class C6538b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportSuccessActivity f22980a;

        C6538b(ReportSuccessActivity reportSuccessActivity) {
            this.f22980a = reportSuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22980a.onClick(view);
        }
    }

    @UiThread
    public ReportSuccessActivity_ViewBinding(ReportSuccessActivity reportSuccessActivity) {
        this(reportSuccessActivity, reportSuccessActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportSuccessActivity reportSuccessActivity = this.f22975a;
        if (reportSuccessActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22975a = null;
        reportSuccessActivity.mIvBack = null;
        reportSuccessActivity.mTvTitle = null;
        this.f22976b.setOnClickListener(null);
        this.f22976b = null;
        this.f22977c.setOnClickListener(null);
        this.f22977c = null;
    }

    @UiThread
    public ReportSuccessActivity_ViewBinding(ReportSuccessActivity reportSuccessActivity, View view) {
        this.f22975a = reportSuccessActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportSuccessActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22976b = findRequiredView;
        findRequiredView.setOnClickListener(new C6537a(reportSuccessActivity));
        reportSuccessActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.fl_confirm, "method 'onClick'");
        this.f22977c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6538b(reportSuccessActivity));
    }
}
