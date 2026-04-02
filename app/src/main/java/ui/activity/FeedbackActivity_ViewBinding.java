package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.TagFlowLayout;
import ui.view.MyEdittext;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackActivity_ViewBinding implements Unbinder {
    private FeedbackActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13362c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ FeedbackActivity a;

        a(FeedbackActivity feedbackActivity) {
            this.a = feedbackActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ FeedbackActivity a;

        b(FeedbackActivity feedbackActivity) {
            this.a = feedbackActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity) {
        this(feedbackActivity, feedbackActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackActivity feedbackActivity = this.a;
        if (feedbackActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        feedbackActivity.mTvTitle = null;
        feedbackActivity.mFlowLayout = null;
        feedbackActivity.mEtDescribe = null;
        feedbackActivity.mRecyclerview = null;
        feedbackActivity.mPhone = null;
        feedbackActivity.mConfirm = null;
        this.f13361b.setOnClickListener(null);
        this.f13361b = null;
        this.f13362c.setOnClickListener(null);
        this.f13362c = null;
    }

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity, View view) {
        this.a = feedbackActivity;
        feedbackActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        feedbackActivity.mEtDescribe = (MyEdittext) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", MyEdittext.class);
        feedbackActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        feedbackActivity.mPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.phone, "field 'mPhone'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        feedbackActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f13361b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(feedbackActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13362c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(feedbackActivity));
    }
}
