package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.MyScrollView;

/* loaded from: classes2.dex */
public class TagFlowLaoutActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private TagFlowLaoutActivity f23272a;

    /* renamed from: b */
    private View f23273b;

    /* renamed from: c */
    private View f23274c;

    /* renamed from: ui.activity.TagFlowLaoutActivity_ViewBinding$a */
    class C6623a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TagFlowLaoutActivity f23275a;

        C6623a(TagFlowLaoutActivity tagFlowLaoutActivity) {
            this.f23275a = tagFlowLaoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23275a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.TagFlowLaoutActivity_ViewBinding$b */
    class C6624b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ TagFlowLaoutActivity f23277a;

        C6624b(TagFlowLaoutActivity tagFlowLaoutActivity) {
            this.f23277a = tagFlowLaoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23277a.onViewClicked(view);
        }
    }

    @UiThread
    public TagFlowLaoutActivity_ViewBinding(TagFlowLaoutActivity tagFlowLaoutActivity) {
        this(tagFlowLaoutActivity, tagFlowLaoutActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TagFlowLaoutActivity tagFlowLaoutActivity = this.f23272a;
        if (tagFlowLaoutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23272a = null;
        tagFlowLaoutActivity.mIvBack = null;
        tagFlowLaoutActivity.mTvTitle = null;
        tagFlowLaoutActivity.mLlPraent = null;
        tagFlowLaoutActivity.myScrollView = null;
        tagFlowLaoutActivity.mLlNetworkNo = null;
        this.f23273b.setOnClickListener(null);
        this.f23273b = null;
        this.f23274c.setOnClickListener(null);
        this.f23274c = null;
    }

    @UiThread
    public TagFlowLaoutActivity_ViewBinding(TagFlowLaoutActivity tagFlowLaoutActivity, View view) {
        this.f23272a = tagFlowLaoutActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        tagFlowLaoutActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23273b = findRequiredView;
        findRequiredView.setOnClickListener(new C6623a(tagFlowLaoutActivity));
        tagFlowLaoutActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        tagFlowLaoutActivity.mLlPraent = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_praent, "field 'mLlPraent'", LinearLayout.class);
        tagFlowLaoutActivity.myScrollView = (MyScrollView) Utils.findRequiredViewAsType(view, C2113R.id.myScrollView, "field 'myScrollView'", MyScrollView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        tagFlowLaoutActivity.mLlNetworkNo = findRequiredView2;
        this.f23274c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6624b(tagFlowLaoutActivity));
    }
}
