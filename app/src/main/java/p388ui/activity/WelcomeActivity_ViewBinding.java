package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class WelcomeActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private WelcomeActivity f23565a;

    /* renamed from: b */
    private View f23566b;

    /* renamed from: c */
    private View f23567c;

    /* renamed from: ui.activity.WelcomeActivity_ViewBinding$a */
    class C6735a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WelcomeActivity f23568a;

        C6735a(WelcomeActivity welcomeActivity) {
            this.f23568a = welcomeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23568a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.WelcomeActivity_ViewBinding$b */
    class C6736b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ WelcomeActivity f23570a;

        C6736b(WelcomeActivity welcomeActivity) {
            this.f23570a = welcomeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23570a.onViewClicked(view);
        }
    }

    @UiThread
    public WelcomeActivity_ViewBinding(WelcomeActivity welcomeActivity) {
        this(welcomeActivity, welcomeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WelcomeActivity welcomeActivity = this.f23565a;
        if (welcomeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23565a = null;
        welcomeActivity.mImage = null;
        welcomeActivity.mTvNext = null;
        welcomeActivity.mLottieLike = null;
        welcomeActivity.mClLayout = null;
        this.f23566b.setOnClickListener(null);
        this.f23566b = null;
        this.f23567c.setOnClickListener(null);
        this.f23567c = null;
    }

    @UiThread
    public WelcomeActivity_ViewBinding(WelcomeActivity welcomeActivity, View view) {
        this.f23565a = welcomeActivity;
        welcomeActivity.mImage = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.image, "field 'mImage'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_next, "field 'mTvNext' and method 'onViewClicked'");
        welcomeActivity.mTvNext = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_next, "field 'mTvNext'", TextView.class);
        this.f23566b = findRequiredView;
        findRequiredView.setOnClickListener(new C6735a(welcomeActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.lottie_likeanim, "field 'mLottieLike' and method 'onViewClicked'");
        welcomeActivity.mLottieLike = (LottieAnimationView) Utils.castView(findRequiredView2, C2113R.id.lottie_likeanim, "field 'mLottieLike'", LottieAnimationView.class);
        this.f23567c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6736b(welcomeActivity));
        welcomeActivity.mClLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, C2113R.id.cl_layout, "field 'mClLayout'", ConstraintLayout.class);
    }
}
