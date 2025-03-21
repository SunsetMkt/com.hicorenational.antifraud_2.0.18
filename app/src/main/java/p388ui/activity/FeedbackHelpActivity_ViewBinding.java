package p388ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class FeedbackHelpActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private FeedbackHelpActivity f22333a;

    /* renamed from: b */
    private View f22334b;

    /* renamed from: c */
    private View f22335c;

    /* renamed from: ui.activity.FeedbackHelpActivity_ViewBinding$a */
    class C6313a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ FeedbackHelpActivity f22336a;

        C6313a(FeedbackHelpActivity feedbackHelpActivity) {
            this.f22336a = feedbackHelpActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22336a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.FeedbackHelpActivity_ViewBinding$b */
    class C6314b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ FeedbackHelpActivity f22338a;

        C6314b(FeedbackHelpActivity feedbackHelpActivity) {
            this.f22338a = feedbackHelpActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22338a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackHelpActivity_ViewBinding(FeedbackHelpActivity feedbackHelpActivity) {
        this(feedbackHelpActivity, feedbackHelpActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackHelpActivity feedbackHelpActivity = this.f22333a;
        if (feedbackHelpActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22333a = null;
        feedbackHelpActivity.mTvTitle = null;
        feedbackHelpActivity.mLlQaContent = null;
        this.f22334b.setOnClickListener(null);
        this.f22334b = null;
        this.f22335c.setOnClickListener(null);
        this.f22335c = null;
    }

    @UiThread
    public FeedbackHelpActivity_ViewBinding(FeedbackHelpActivity feedbackHelpActivity, View view) {
        this.f22333a = feedbackHelpActivity;
        feedbackHelpActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackHelpActivity.mLlQaContent = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_qa_content, "field 'mLlQaContent'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22334b = findRequiredView;
        findRequiredView.setOnClickListener(new C6313a(feedbackHelpActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_feedback, "method 'onViewClicked'");
        this.f22335c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6314b(feedbackHelpActivity));
    }
}
