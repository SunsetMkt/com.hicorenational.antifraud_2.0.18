package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackDetailActivity_ViewBinding implements Unbinder {
    private FeedbackDetailActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13368e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ FeedbackDetailActivity a;

        a(FeedbackDetailActivity feedbackDetailActivity) {
            this.a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ FeedbackDetailActivity a;

        b(FeedbackDetailActivity feedbackDetailActivity) {
            this.a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ FeedbackDetailActivity a;

        c(FeedbackDetailActivity feedbackDetailActivity) {
            this.a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ FeedbackDetailActivity a;

        d(FeedbackDetailActivity feedbackDetailActivity) {
            this.a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackDetailActivity_ViewBinding(FeedbackDetailActivity feedbackDetailActivity) {
        this(feedbackDetailActivity, feedbackDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackDetailActivity feedbackDetailActivity = this.a;
        if (feedbackDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        feedbackDetailActivity.mTvTitle = null;
        feedbackDetailActivity.mTvQuestion = null;
        feedbackDetailActivity.mTvAnswer = null;
        feedbackDetailActivity.mTvGoFeedback = null;
        feedbackDetailActivity.mIvSolve = null;
        feedbackDetailActivity.mTvSolveTip = null;
        feedbackDetailActivity.mIvNotSolve = null;
        feedbackDetailActivity.mTvNotSolveTip = null;
        this.f13365b.setOnClickListener(null);
        this.f13365b = null;
        this.f13366c.setOnClickListener(null);
        this.f13366c = null;
        this.f13367d.setOnClickListener(null);
        this.f13367d = null;
        this.f13368e.setOnClickListener(null);
        this.f13368e = null;
    }

    @UiThread
    public FeedbackDetailActivity_ViewBinding(FeedbackDetailActivity feedbackDetailActivity, View view) {
        this.a = feedbackDetailActivity;
        feedbackDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackDetailActivity.mTvQuestion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_question, "field 'mTvQuestion'", TextView.class);
        feedbackDetailActivity.mTvAnswer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_answer, "field 'mTvAnswer'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_go_feedback, "field 'mTvGoFeedback' and method 'onViewClicked'");
        feedbackDetailActivity.mTvGoFeedback = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_go_feedback, "field 'mTvGoFeedback'", TextView.class);
        this.f13365b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(feedbackDetailActivity));
        feedbackDetailActivity.mIvSolve = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_solve, "field 'mIvSolve'", ImageView.class);
        feedbackDetailActivity.mTvSolveTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_solve_tip, "field 'mTvSolveTip'", TextView.class);
        feedbackDetailActivity.mIvNotSolve = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_not_solve, "field 'mIvNotSolve'", ImageView.class);
        feedbackDetailActivity.mTvNotSolveTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_not_solve_tip, "field 'mTvNotSolveTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13366c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(feedbackDetailActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_solve, "method 'onViewClicked'");
        this.f13367d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(feedbackDetailActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_not_solve, "method 'onViewClicked'");
        this.f13368e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(feedbackDetailActivity));
    }
}
