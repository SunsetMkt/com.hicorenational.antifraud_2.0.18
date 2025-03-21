package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class FeedbackDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private FeedbackDetailActivity f22310a;

    /* renamed from: b */
    private View f22311b;

    /* renamed from: c */
    private View f22312c;

    /* renamed from: d */
    private View f22313d;

    /* renamed from: e */
    private View f22314e;

    /* renamed from: ui.activity.FeedbackDetailActivity_ViewBinding$a */
    class C6304a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ FeedbackDetailActivity f22315a;

        C6304a(FeedbackDetailActivity feedbackDetailActivity) {
            this.f22315a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22315a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.FeedbackDetailActivity_ViewBinding$b */
    class C6305b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ FeedbackDetailActivity f22317a;

        C6305b(FeedbackDetailActivity feedbackDetailActivity) {
            this.f22317a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22317a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.FeedbackDetailActivity_ViewBinding$c */
    class C6306c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ FeedbackDetailActivity f22319a;

        C6306c(FeedbackDetailActivity feedbackDetailActivity) {
            this.f22319a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22319a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.FeedbackDetailActivity_ViewBinding$d */
    class C6307d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ FeedbackDetailActivity f22321a;

        C6307d(FeedbackDetailActivity feedbackDetailActivity) {
            this.f22321a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22321a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackDetailActivity_ViewBinding(FeedbackDetailActivity feedbackDetailActivity) {
        this(feedbackDetailActivity, feedbackDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackDetailActivity feedbackDetailActivity = this.f22310a;
        if (feedbackDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22310a = null;
        feedbackDetailActivity.mTvTitle = null;
        feedbackDetailActivity.mTvQuestion = null;
        feedbackDetailActivity.mTvAnswer = null;
        feedbackDetailActivity.mTvGoFeedback = null;
        feedbackDetailActivity.mIvSolve = null;
        feedbackDetailActivity.mTvSolveTip = null;
        feedbackDetailActivity.mIvNotSolve = null;
        feedbackDetailActivity.mTvNotSolveTip = null;
        this.f22311b.setOnClickListener(null);
        this.f22311b = null;
        this.f22312c.setOnClickListener(null);
        this.f22312c = null;
        this.f22313d.setOnClickListener(null);
        this.f22313d = null;
        this.f22314e.setOnClickListener(null);
        this.f22314e = null;
    }

    @UiThread
    public FeedbackDetailActivity_ViewBinding(FeedbackDetailActivity feedbackDetailActivity, View view) {
        this.f22310a = feedbackDetailActivity;
        feedbackDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackDetailActivity.mTvQuestion = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_question, "field 'mTvQuestion'", TextView.class);
        feedbackDetailActivity.mTvAnswer = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_answer, "field 'mTvAnswer'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_go_feedback, "field 'mTvGoFeedback' and method 'onViewClicked'");
        feedbackDetailActivity.mTvGoFeedback = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_go_feedback, "field 'mTvGoFeedback'", TextView.class);
        this.f22311b = findRequiredView;
        findRequiredView.setOnClickListener(new C6304a(feedbackDetailActivity));
        feedbackDetailActivity.mIvSolve = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_solve, "field 'mIvSolve'", ImageView.class);
        feedbackDetailActivity.mTvSolveTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_solve_tip, "field 'mTvSolveTip'", TextView.class);
        feedbackDetailActivity.mIvNotSolve = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_not_solve, "field 'mIvNotSolve'", ImageView.class);
        feedbackDetailActivity.mTvNotSolveTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_not_solve_tip, "field 'mTvNotSolveTip'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22312c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6305b(feedbackDetailActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.ll_solve, "method 'onViewClicked'");
        this.f22313d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6306c(feedbackDetailActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.ll_not_solve, "method 'onViewClicked'");
        this.f22314e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6307d(feedbackDetailActivity));
    }
}
