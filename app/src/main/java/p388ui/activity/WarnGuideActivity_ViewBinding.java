package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class WarnGuideActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WarnGuideActivity f23448a;

    /* renamed from: b */
    private View f23449b;

    /* renamed from: c */
    private View f23450c;

    /* renamed from: ui.activity.WarnGuideActivity_ViewBinding$a */
    class C6688a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnGuideActivity f23451a;

        C6688a(WarnGuideActivity warnGuideActivity) {
            this.f23451a = warnGuideActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23451a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WarnGuideActivity_ViewBinding$b */
    class C6689b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WarnGuideActivity f23453a;

        C6689b(WarnGuideActivity warnGuideActivity) {
            this.f23453a = warnGuideActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23453a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnGuideActivity_ViewBinding(WarnGuideActivity warnGuideActivity) {
        this(warnGuideActivity, warnGuideActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnGuideActivity warnGuideActivity = this.f23448a;
        if (warnGuideActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23448a = null;
        warnGuideActivity.mRlTitle = null;
        warnGuideActivity.mIvBack = null;
        warnGuideActivity.mTvTitle = null;
        warnGuideActivity.mIvWarnGuide = null;
        this.f23449b.setOnClickListener(null);
        this.f23449b = null;
        this.f23450c.setOnClickListener(null);
        this.f23450c = null;
    }

    @UiThread
    public WarnGuideActivity_ViewBinding(WarnGuideActivity warnGuideActivity, View view) {
        this.f23448a = warnGuideActivity;
        warnGuideActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, C2113R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        warnGuideActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23449b = findRequiredView;
        findRequiredView.setOnClickListener(new C6688a(warnGuideActivity));
        warnGuideActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        warnGuideActivity.mIvWarnGuide = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_warn_guide, "field 'mIvWarnGuide'", ImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_go_setting, "method 'onViewClicked'");
        this.f23450c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6689b(warnGuideActivity));
    }
}
