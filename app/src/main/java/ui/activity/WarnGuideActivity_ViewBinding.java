package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class WarnGuideActivity_ViewBinding implements Unbinder {
    private WarnGuideActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14002c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ WarnGuideActivity a;

        a(WarnGuideActivity warnGuideActivity) {
            this.a = warnGuideActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ WarnGuideActivity a;

        b(WarnGuideActivity warnGuideActivity) {
            this.a = warnGuideActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnGuideActivity_ViewBinding(WarnGuideActivity warnGuideActivity) {
        this(warnGuideActivity, warnGuideActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnGuideActivity warnGuideActivity = this.a;
        if (warnGuideActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        warnGuideActivity.mRlTitle = null;
        warnGuideActivity.mIvBack = null;
        warnGuideActivity.mTvTitle = null;
        warnGuideActivity.mIvWarnGuide = null;
        this.f14001b.setOnClickListener(null);
        this.f14001b = null;
        this.f14002c.setOnClickListener(null);
        this.f14002c = null;
    }

    @UiThread
    public WarnGuideActivity_ViewBinding(WarnGuideActivity warnGuideActivity, View view) {
        this.a = warnGuideActivity;
        warnGuideActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        warnGuideActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f14001b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(warnGuideActivity));
        warnGuideActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        warnGuideActivity.mIvWarnGuide = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_warn_guide, "field 'mIvWarnGuide'", ImageView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_go_setting, "method 'onViewClicked'");
        this.f14002c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(warnGuideActivity));
    }
}
