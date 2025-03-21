package p388ui.statusbarcompat;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: StatusBarCompatKitKat.java */
@TargetApi(19)
/* renamed from: ui.statusbarcompat.c */
/* loaded from: classes2.dex */
class C7162c {

    /* renamed from: a */
    private static final String f24445a = "statusBarView";

    /* renamed from: b */
    private static final String f24446b = "marginAdded";

    /* compiled from: StatusBarCompatKitKat.java */
    /* renamed from: ui.statusbarcompat.c$a */
    static class a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a */
        final /* synthetic */ CollapsingToolbarLayout f24447a;

        /* renamed from: b */
        final /* synthetic */ View f24448b;

        a(CollapsingToolbarLayout collapsingToolbarLayout, View view) {
            this.f24447a = collapsingToolbarLayout;
            this.f24448b = view;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (Math.abs(i2) > appBarLayout.getHeight() - this.f24447a.getScrimVisibleHeightTrigger()) {
                if (this.f24448b.getAlpha() == 0.0f) {
                    this.f24448b.animate().cancel();
                    this.f24448b.animate().alpha(1.0f).setDuration(this.f24447a.getScrimAnimationDuration()).start();
                    return;
                }
                return;
            }
            if (this.f24448b.getAlpha() == 1.0f) {
                this.f24448b.animate().cancel();
                this.f24448b.animate().alpha(0.0f).setDuration(this.f24447a.getScrimAnimationDuration()).start();
            }
        }
    }

    C7162c() {
    }

    /* renamed from: a */
    private static int m25706a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    /* renamed from: b */
    private static void m25717b(View view, int i2) {
        if (view != null && f24446b.equals(view.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin -= i2;
            view.setLayoutParams(layoutParams);
            view.setTag(null);
        }
    }

    /* renamed from: c */
    static void m25718c(Activity activity) {
        activity.getWindow().addFlags(AbstractC1191a.f2487B1);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
            childAt.setPadding(0, 0, 0, 0);
        }
        m25708a(activity);
        m25717b(childAt, m25706a((Context) activity));
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    /* renamed from: a */
    private static View m25707a(Activity activity, int i2, int i3) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i2);
        view.setTag(f24445a);
        viewGroup.addView(view);
        return view;
    }

    /* renamed from: b */
    static void m25716b(Activity activity, int i2) {
        activity.getWindow().addFlags(AbstractC1191a.f2487B1);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof StatusBarView) {
            childAt.setBackgroundResource(i2);
        } else {
            childAt.setPadding(0, m25706a((Context) activity), 0, 0);
            childAt = new StatusBarView(activity);
            childAt.setLayoutParams(new LinearLayout.LayoutParams(-1, m25706a((Context) activity)));
            childAt.setBackgroundResource(i2);
            viewGroup.addView(childAt);
        }
        m25708a(activity);
        m25717b(childAt, m25706a((Context) activity));
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    /* renamed from: a */
    private static void m25708a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag(f24445a);
        if (findViewWithTag != null) {
            viewGroup.removeView(findViewWithTag);
        }
    }

    /* renamed from: a */
    private static void m25712a(View view, int i2) {
        if (view == null || f24446b.equals(view.getTag())) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin += i2;
        view.setLayoutParams(layoutParams);
        view.setTag(f24446b);
    }

    /* renamed from: a */
    static void m25709a(Activity activity, int i2) {
        Window window = activity.getWindow();
        window.addFlags(AbstractC1191a.f2487B1);
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        int m25706a = m25706a((Context) activity);
        m25708a(activity);
        m25707a(activity, i2, m25706a);
        m25712a(childAt, m25706a);
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    /* renamed from: b */
    static void m25715b(Activity activity) {
        activity.getWindow().addFlags(AbstractC1191a.f2487B1);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
        } else {
            childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop() + m25706a((Context) activity), childAt.getPaddingRight(), childAt.getPaddingBottom());
        }
        m25708a(activity);
        m25717b(childAt, m25706a((Context) activity));
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    /* renamed from: a */
    static void m25710a(Activity activity, View view) {
        activity.getWindow().addFlags(AbstractC1191a.f2487B1);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + m25706a((Context) activity), view.getPaddingRight(), view.getPaddingBottom());
        }
        m25708a(activity);
        m25717b(view, m25706a((Context) activity));
        if (view != null) {
            ViewCompat.setFitsSystemWindows(view, false);
        }
    }

    /* renamed from: a */
    static void m25713a(Fragment fragment) {
        fragment.getActivity().getWindow().addFlags(AbstractC1191a.f2487B1);
        ViewGroup viewGroup = (ViewGroup) fragment.getActivity().findViewById(R.id.content);
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (childAt instanceof StatusBarView) {
                viewGroup.removeView(childAt);
                viewGroup.setPadding(0, 0, 0, 0);
            }
            if (viewGroup.getChildAt(0) != null) {
                viewGroup.getChildAt(0).setPadding(0, 0, 0, 0);
            }
        }
        m25708a((Activity) fragment.getActivity());
        m25717b(viewGroup, m25706a((Context) fragment.getActivity()));
        View view = fragment.getView();
        if (view != null) {
            if (view instanceof ScrollView) {
                View childAt2 = ((ViewGroup) view).getChildAt(0);
                if (childAt2 != null) {
                    childAt2.setPadding(childAt2.getPaddingLeft(), childAt2.getPaddingTop() + m25706a(fragment.getContext()), childAt2.getPaddingRight(), childAt2.getPaddingBottom());
                }
            } else {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + m25706a(fragment.getContext()), view.getPaddingRight(), view.getPaddingBottom());
            }
            ViewCompat.setFitsSystemWindows(view, false);
        }
    }

    /* renamed from: a */
    static void m25714a(Fragment fragment, View view) {
        fragment.getActivity().getWindow().addFlags(AbstractC1191a.f2487B1);
        ViewGroup viewGroup = (ViewGroup) fragment.getActivity().findViewById(R.id.content);
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (childAt instanceof StatusBarView) {
                viewGroup.removeView(childAt);
                viewGroup.setPadding(0, 0, 0, 0);
            }
            if (viewGroup.getChildAt(0) != null) {
                viewGroup.getChildAt(0).setPadding(0, 0, 0, 0);
            }
        }
        m25708a((Activity) fragment.getActivity());
        m25717b(viewGroup, m25706a((Context) fragment.getActivity()));
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + m25706a(fragment.getContext()), view.getPaddingRight(), view.getPaddingBottom());
        ViewCompat.setFitsSystemWindows(view, false);
    }

    /* renamed from: a */
    static void m25711a(Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, int i2) {
        Window window = activity.getWindow();
        window.addFlags(AbstractC1191a.f2487B1);
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        childAt.setFitsSystemWindows(false);
        ((View) appBarLayout.getParent()).setFitsSystemWindows(false);
        appBarLayout.setFitsSystemWindows(false);
        collapsingToolbarLayout.setFitsSystemWindows(false);
        collapsingToolbarLayout.getChildAt(0).setFitsSystemWindows(false);
        toolbar.setFitsSystemWindows(false);
        if (toolbar.getTag() == null) {
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbar.getLayoutParams();
            int m25706a = m25706a((Context) activity);
            ((FrameLayout.LayoutParams) layoutParams).height += m25706a;
            toolbar.setLayoutParams(layoutParams);
            toolbar.setPadding(toolbar.getPaddingLeft(), toolbar.getPaddingTop() + m25706a, toolbar.getPaddingRight(), toolbar.getPaddingBottom());
            toolbar.setTag(true);
        }
        int m25706a2 = m25706a((Context) activity);
        m25708a(activity);
        m25717b(childAt, m25706a2);
        View m25707a = m25707a(activity, i2, m25706a2);
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
        if (behavior != null && (behavior instanceof AppBarLayout.Behavior)) {
            if (Math.abs(((AppBarLayout.Behavior) behavior).getTopAndBottomOffset()) > appBarLayout.getHeight() - collapsingToolbarLayout.getScrimVisibleHeightTrigger()) {
                m25707a.setAlpha(1.0f);
            } else {
                m25707a.setAlpha(0.0f);
            }
        } else {
            m25707a.setAlpha(0.0f);
        }
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(collapsingToolbarLayout, m25707a));
    }
}
