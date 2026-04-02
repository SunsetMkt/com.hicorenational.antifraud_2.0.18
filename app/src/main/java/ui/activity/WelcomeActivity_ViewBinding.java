package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class WelcomeActivity_ViewBinding implements Unbinder {
    private WelcomeActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14063c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ WelcomeActivity a;

        a(WelcomeActivity welcomeActivity) {
            this.a = welcomeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ WelcomeActivity a;

        b(WelcomeActivity welcomeActivity) {
            this.a = welcomeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public WelcomeActivity_ViewBinding(WelcomeActivity welcomeActivity) {
        this(welcomeActivity, welcomeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WelcomeActivity welcomeActivity = this.a;
        if (welcomeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        welcomeActivity.mImage = null;
        welcomeActivity.mTvNext = null;
        welcomeActivity.mLottieLike = null;
        welcomeActivity.mClLayout = null;
        this.f14062b.setOnClickListener(null);
        this.f14062b = null;
        this.f14063c.setOnClickListener(null);
        this.f14063c = null;
    }

    @UiThread
    public WelcomeActivity_ViewBinding(WelcomeActivity welcomeActivity, View view) {
        this.a = welcomeActivity;
        welcomeActivity.mImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.image, "field 'mImage'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_next, "field 'mTvNext' and method 'onViewClicked'");
        welcomeActivity.mTvNext = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_next, "field 'mTvNext'", TextView.class);
        this.f14062b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(welcomeActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.lottie_likeanim, "field 'mLottieLike' and method 'onViewClicked'");
        welcomeActivity.mLottieLike = (LottieAnimationView) Utils.castView(viewFindRequiredView2, R.id.lottie_likeanim, "field 'mLottieLike'", LottieAnimationView.class);
        this.f14063c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(welcomeActivity));
        welcomeActivity.mClLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_layout, "field 'mClLayout'", ConstraintLayout.class);
    }
}
