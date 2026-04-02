package ui.activity;

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
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ReportWebsiteAddActivity_ViewBinding implements Unbinder {
    private ReportWebsiteAddActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13743c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ ReportWebsiteAddActivity a;

        a(ReportWebsiteAddActivity reportWebsiteAddActivity) {
            this.a = reportWebsiteAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ ReportWebsiteAddActivity a;

        b(ReportWebsiteAddActivity reportWebsiteAddActivity) {
            this.a = reportWebsiteAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportWebsiteAddActivity_ViewBinding(ReportWebsiteAddActivity reportWebsiteAddActivity) {
        this(reportWebsiteAddActivity, reportWebsiteAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportWebsiteAddActivity reportWebsiteAddActivity = this.a;
        if (reportWebsiteAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportWebsiteAddActivity.mIvBack = null;
        reportWebsiteAddActivity.mTvTitle = null;
        reportWebsiteAddActivity.mTvTip = null;
        reportWebsiteAddActivity.mEtWebUrl = null;
        reportWebsiteAddActivity.mBtnCommit = null;
        reportWebsiteAddActivity.scrollView = null;
        reportWebsiteAddActivity.mRecyView = null;
        this.f13742b.setOnClickListener(null);
        this.f13742b = null;
        this.f13743c.setOnClickListener(null);
        this.f13743c = null;
    }

    @UiThread
    public ReportWebsiteAddActivity_ViewBinding(ReportWebsiteAddActivity reportWebsiteAddActivity, View view) {
        this.a = reportWebsiteAddActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportWebsiteAddActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13742b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportWebsiteAddActivity));
        reportWebsiteAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportWebsiteAddActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTvTip'", TextView.class);
        reportWebsiteAddActivity.mEtWebUrl = (EditText) Utils.findRequiredViewAsType(view, R.id.et_weburl, "field 'mEtWebUrl'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onClick'");
        reportWebsiteAddActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13743c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportWebsiteAddActivity));
        reportWebsiteAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        reportWebsiteAddActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
