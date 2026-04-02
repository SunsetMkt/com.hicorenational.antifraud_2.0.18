package ui.activity;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.BottomBar;
import ui.view.NoSlideViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivity_ViewBinding implements Unbinder {
    private MainActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13484b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ MainActivity a;

        a(MainActivity mainActivity) {
            this.a = mainActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MainActivity mainActivity = this.a;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mainActivity.mViewpager = null;
        mainActivity.mBottomBar = null;
        mainActivity.mFullScreen = null;
        mainActivity.mIvGuideMain1 = null;
        this.f13484b.setOnClickListener(null);
        this.f13484b = null;
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
        this.a = mainActivity;
        mainActivity.mViewpager = (NoSlideViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'mViewpager'", NoSlideViewPager.class);
        mainActivity.mBottomBar = (BottomBar) Utils.findRequiredViewAsType(view, R.id.bottomBar, "field 'mBottomBar'", BottomBar.class);
        mainActivity.mFullScreen = Utils.findRequiredView(view, R.id.full_screen, "field 'mFullScreen'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_guide_main_1, "field 'mIvGuideMain1' and method 'onViewClicked'");
        mainActivity.mIvGuideMain1 = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_guide_main_1, "field 'mIvGuideMain1'", ImageView.class);
        this.f13484b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(mainActivity));
    }
}
