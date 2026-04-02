package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.MyScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class TagFlowLaoutActivity_ViewBinding implements Unbinder {
    private TagFlowLaoutActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13907c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ TagFlowLaoutActivity a;

        a(TagFlowLaoutActivity tagFlowLaoutActivity) {
            this.a = tagFlowLaoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ TagFlowLaoutActivity a;

        b(TagFlowLaoutActivity tagFlowLaoutActivity) {
            this.a = tagFlowLaoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public TagFlowLaoutActivity_ViewBinding(TagFlowLaoutActivity tagFlowLaoutActivity) {
        this(tagFlowLaoutActivity, tagFlowLaoutActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TagFlowLaoutActivity tagFlowLaoutActivity = this.a;
        if (tagFlowLaoutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        tagFlowLaoutActivity.mIvBack = null;
        tagFlowLaoutActivity.mTvTitle = null;
        tagFlowLaoutActivity.mLlPraent = null;
        tagFlowLaoutActivity.myScrollView = null;
        tagFlowLaoutActivity.mLlNetworkNo = null;
        this.f13906b.setOnClickListener(null);
        this.f13906b = null;
        this.f13907c.setOnClickListener(null);
        this.f13907c = null;
    }

    @UiThread
    public TagFlowLaoutActivity_ViewBinding(TagFlowLaoutActivity tagFlowLaoutActivity, View view) {
        this.a = tagFlowLaoutActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        tagFlowLaoutActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13906b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tagFlowLaoutActivity));
        tagFlowLaoutActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        tagFlowLaoutActivity.mLlPraent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_praent, "field 'mLlPraent'", LinearLayout.class);
        tagFlowLaoutActivity.myScrollView = (MyScrollView) Utils.findRequiredViewAsType(view, R.id.myScrollView, "field 'myScrollView'", MyScrollView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        tagFlowLaoutActivity.mLlNetworkNo = viewFindRequiredView2;
        this.f13907c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(tagFlowLaoutActivity));
    }
}
