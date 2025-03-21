package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;
import p388ui.view.BottomBar;
import p388ui.view.NoSlideViewPager;

/* loaded from: classes2.dex */
public class MainActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private MainActivity f22522a;

    /* renamed from: b */
    private View f22523b;

    /* renamed from: ui.activity.MainActivity_ViewBinding$a */
    class C6370a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ MainActivity f22524a;

        C6370a(MainActivity mainActivity) {
            this.f22524a = mainActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22524a.onViewClicked(view);
        }
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MainActivity mainActivity = this.f22522a;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22522a = null;
        mainActivity.mViewpager = null;
        mainActivity.mBottomBar = null;
        mainActivity.mFullScreen = null;
        mainActivity.mIvGuideMain1 = null;
        this.f22523b.setOnClickListener(null);
        this.f22523b = null;
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
        this.f22522a = mainActivity;
        mainActivity.mViewpager = (NoSlideViewPager) Utils.findRequiredViewAsType(view, C2113R.id.viewpager, "field 'mViewpager'", NoSlideViewPager.class);
        mainActivity.mBottomBar = (BottomBar) Utils.findRequiredViewAsType(view, C2113R.id.bottomBar, "field 'mBottomBar'", BottomBar.class);
        mainActivity.mFullScreen = Utils.findRequiredView(view, C2113R.id.full_screen, "field 'mFullScreen'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_guide_main_1, "field 'mIvGuideMain1' and method 'onViewClicked'");
        mainActivity.mIvGuideMain1 = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_guide_main_1, "field 'mIvGuideMain1'", ImageView.class);
        this.f22523b = findRequiredView;
        findRequiredView.setOnClickListener(new C6370a(mainActivity));
    }
}
