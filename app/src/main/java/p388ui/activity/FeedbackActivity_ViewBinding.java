package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import com.zhy.view.flowlayout.TagFlowLayout;
import p388ui.view.MyEdittext;

/* loaded from: classes2.dex */
public class FeedbackActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private FeedbackActivity f22303a;

    /* renamed from: b */
    private View f22304b;

    /* renamed from: c */
    private View f22305c;

    /* renamed from: ui.activity.FeedbackActivity_ViewBinding$a */
    class C6302a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ FeedbackActivity f22306a;

        C6302a(FeedbackActivity feedbackActivity) {
            this.f22306a = feedbackActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22306a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.FeedbackActivity_ViewBinding$b */
    class C6303b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ FeedbackActivity f22308a;

        C6303b(FeedbackActivity feedbackActivity) {
            this.f22308a = feedbackActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22308a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity) {
        this(feedbackActivity, feedbackActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackActivity feedbackActivity = this.f22303a;
        if (feedbackActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22303a = null;
        feedbackActivity.mTvTitle = null;
        feedbackActivity.mFlowLayout = null;
        feedbackActivity.mEtDescribe = null;
        feedbackActivity.mRecyclerview = null;
        feedbackActivity.mPhone = null;
        feedbackActivity.mConfirm = null;
        this.f22304b.setOnClickListener(null);
        this.f22304b = null;
        this.f22305c.setOnClickListener(null);
        this.f22305c = null;
    }

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity, View view) {
        this.f22303a = feedbackActivity;
        feedbackActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, C2113R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        feedbackActivity.mEtDescribe = (MyEdittext) Utils.findRequiredViewAsType(view, C2113R.id.et_describe, "field 'mEtDescribe'", MyEdittext.class);
        feedbackActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        feedbackActivity.mPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.phone, "field 'mPhone'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        feedbackActivity.mConfirm = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f22304b = findRequiredView;
        findRequiredView.setOnClickListener(new C6302a(feedbackActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f22305c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6303b(feedbackActivity));
    }
}
