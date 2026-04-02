package ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackHelpActivity_ViewBinding implements Unbinder {
    private FeedbackHelpActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13379c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ FeedbackHelpActivity a;

        a(FeedbackHelpActivity feedbackHelpActivity) {
            this.a = feedbackHelpActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ FeedbackHelpActivity a;

        b(FeedbackHelpActivity feedbackHelpActivity) {
            this.a = feedbackHelpActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackHelpActivity_ViewBinding(FeedbackHelpActivity feedbackHelpActivity) {
        this(feedbackHelpActivity, feedbackHelpActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackHelpActivity feedbackHelpActivity = this.a;
        if (feedbackHelpActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        feedbackHelpActivity.mTvTitle = null;
        feedbackHelpActivity.mLlQaContent = null;
        this.f13378b.setOnClickListener(null);
        this.f13378b = null;
        this.f13379c.setOnClickListener(null);
        this.f13379c = null;
    }

    @UiThread
    public FeedbackHelpActivity_ViewBinding(FeedbackHelpActivity feedbackHelpActivity, View view) {
        this.a = feedbackHelpActivity;
        feedbackHelpActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackHelpActivity.mLlQaContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_qa_content, "field 'mLlQaContent'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13378b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(feedbackHelpActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_feedback, "method 'onViewClicked'");
        this.f13379c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(feedbackHelpActivity));
    }
}
