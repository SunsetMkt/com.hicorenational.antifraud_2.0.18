package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class ReportWebsiteAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReportWebsiteAddActivity f22996a;

    /* renamed from: b */
    private View f22997b;

    /* renamed from: c */
    private View f22998c;

    /* renamed from: ui.activity.ReportWebsiteAddActivity_ViewBinding$a */
    class C6545a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportWebsiteAddActivity f22999a;

        C6545a(ReportWebsiteAddActivity reportWebsiteAddActivity) {
            this.f22999a = reportWebsiteAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22999a.onClick(view);
        }
    }

    /* renamed from: ui.activity.ReportWebsiteAddActivity_ViewBinding$b */
    class C6546b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ReportWebsiteAddActivity f23001a;

        C6546b(ReportWebsiteAddActivity reportWebsiteAddActivity) {
            this.f23001a = reportWebsiteAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23001a.onClick(view);
        }
    }

    @UiThread
    public ReportWebsiteAddActivity_ViewBinding(ReportWebsiteAddActivity reportWebsiteAddActivity) {
        this(reportWebsiteAddActivity, reportWebsiteAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportWebsiteAddActivity reportWebsiteAddActivity = this.f22996a;
        if (reportWebsiteAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22996a = null;
        reportWebsiteAddActivity.mIvBack = null;
        reportWebsiteAddActivity.mTvTitle = null;
        reportWebsiteAddActivity.mTvTip = null;
        reportWebsiteAddActivity.mEtWebUrl = null;
        reportWebsiteAddActivity.mBtnCommit = null;
        reportWebsiteAddActivity.scrollView = null;
        reportWebsiteAddActivity.mRecyView = null;
        this.f22997b.setOnClickListener(null);
        this.f22997b = null;
        this.f22998c.setOnClickListener(null);
        this.f22998c = null;
    }

    @UiThread
    public ReportWebsiteAddActivity_ViewBinding(ReportWebsiteAddActivity reportWebsiteAddActivity, View view) {
        this.f22996a = reportWebsiteAddActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportWebsiteAddActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22997b = findRequiredView;
        findRequiredView.setOnClickListener(new C6545a(reportWebsiteAddActivity));
        reportWebsiteAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportWebsiteAddActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip, "field 'mTvTip'", TextView.class);
        reportWebsiteAddActivity.mEtWebUrl = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_weburl, "field 'mEtWebUrl'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onClick'");
        reportWebsiteAddActivity.mBtnCommit = (Button) Utils.castView(findRequiredView2, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f22998c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6546b(reportWebsiteAddActivity));
        reportWebsiteAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, C2113R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        reportWebsiteAddActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
