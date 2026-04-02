package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyActivity_ViewBinding implements Unbinder {
    private AIVerifyActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13034c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyActivity a;

        a(AIVerifyActivity aIVerifyActivity) {
            this.a = aIVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AIVerifyActivity a;

        b(AIVerifyActivity aIVerifyActivity) {
            this.a = aIVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AIVerifyActivity_ViewBinding(AIVerifyActivity aIVerifyActivity) {
        this(aIVerifyActivity, aIVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AIVerifyActivity aIVerifyActivity = this.a;
        if (aIVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        aIVerifyActivity.mTitleBg = null;
        aIVerifyActivity.mTvTitle = null;
        aIVerifyActivity.mRightImage = null;
        aIVerifyActivity.mTabLayout = null;
        aIVerifyActivity.mViewPager = null;
        aIVerifyActivity.mCheckNum = null;
        this.f13033b.setOnClickListener(null);
        this.f13033b = null;
        this.f13034c.setOnClickListener(null);
        this.f13034c = null;
    }

    @UiThread
    public AIVerifyActivity_ViewBinding(AIVerifyActivity aIVerifyActivity, View view) {
        this.a = aIVerifyActivity;
        aIVerifyActivity.mTitleBg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mTitleBg'", RelativeLayout.class);
        aIVerifyActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_right, "field 'mRightImage' and method 'onViewClicked'");
        aIVerifyActivity.mRightImage = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_right, "field 'mRightImage'", ImageView.class);
        this.f13033b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aIVerifyActivity));
        aIVerifyActivity.mTabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.mTabLayout, "field 'mTabLayout'", TabLayout.class);
        aIVerifyActivity.mViewPager = (ViewPager2) Utils.findRequiredViewAsType(view, R.id.mViewPager, "field 'mViewPager'", ViewPager2.class);
        aIVerifyActivity.mCheckNum = (TextView) Utils.findRequiredViewAsType(view, R.id.checkNum, "field 'mCheckNum'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13034c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(aIVerifyActivity));
    }
}
