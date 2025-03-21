package p388ui.statusbarcompat;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p251g.p252a.p263t0.InterfaceC4546f;

/* compiled from: StatusBarCompat.java */
/* renamed from: ui.statusbarcompat.b */
/* loaded from: classes2.dex */
public class C7161b {
    /* renamed from: a */
    static int m25689a(int i2, int i3) {
        float f2 = 1.0f - (i3 / 255.0f);
        return ((int) (((i2 & 255) * f2) + 0.5d)) | (((int) ((((i2 >> 16) & 255) * f2) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i2 >> 8) & 255) * f2) + 0.5d)) << 8);
    }

    /* renamed from: a */
    public static void m25693a(@InterfaceC4546f Activity activity, @ColorInt int i2, int i3) {
        m25694a(activity, m25689a(i2, i3), false);
    }

    /* renamed from: a */
    public static void m25694a(@InterfaceC4546f Activity activity, @ColorInt int i2, boolean z) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            C7163d.m25720a(activity, i2, z);
        } else if (i3 >= 19) {
            C7162c.m25709a(activity, i2);
        }
    }

    /* renamed from: a */
    public static void m25692a(@InterfaceC4546f Activity activity, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            C7163d.m25727b(activity, i2, false);
        } else if (i3 >= 19) {
            C7162c.m25716b(activity, i2);
        }
    }

    /* renamed from: a */
    public static void m25691a(@InterfaceC4546f Activity activity) {
        m25696a(activity, false);
    }

    /* renamed from: a */
    public static void m25698a(@InterfaceC4546f Activity activity, boolean z, boolean z2) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            C7163d.m25724a(activity, z, z2);
        } else if (i2 >= 19) {
            C7162c.m25718c(activity);
        }
    }

    /* renamed from: a */
    public static void m25696a(@InterfaceC4546f Activity activity, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            C7163d.m25722a(activity, z);
        } else if (i2 >= 19) {
            C7162c.m25715b(activity);
        }
    }

    /* renamed from: a */
    public static void m25697a(@InterfaceC4546f Activity activity, boolean z, View view, boolean z2) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            C7163d.m25723a(activity, z, view, z2);
        } else if (i2 >= 19) {
            C7162c.m25710a(activity, view);
        }
    }

    /* renamed from: a */
    public static void m25703a(@InterfaceC4546f Fragment fragment, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            C7163d.m25725a(fragment, z);
        } else if (i2 >= 19) {
            C7162c.m25713a(fragment);
        }
    }

    /* renamed from: a */
    public static void m25704a(@InterfaceC4546f Fragment fragment, boolean z, View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            C7163d.m25726a(fragment, z, view);
        } else if (i2 >= 19) {
            C7162c.m25714a(fragment, view);
        }
    }

    /* renamed from: a */
    public static void m25695a(@InterfaceC4546f Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, @ColorInt int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            C7163d.m25721a(activity, appBarLayout, collapsingToolbarLayout, toolbar, i2);
        } else if (i3 >= 19) {
            C7162c.m25711a(activity, appBarLayout, collapsingToolbarLayout, toolbar, i2);
        }
    }

    /* renamed from: a */
    public static int m25690a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    /* renamed from: a */
    public static void m25699a(Context context, View view) {
        int i2;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (i2 = layoutParams.height) > 0) {
                layoutParams.height = i2 + m25690a(context);
            }
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + m25690a(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    /* renamed from: a */
    public static void m25700a(Context context, boolean z) {
        if (context instanceof Activity) {
            m25702a(((Activity) context).getWindow(), z);
        }
    }

    /* renamed from: a */
    private static void m25702a(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                decorView.setSystemUiVisibility(systemUiVisibility | 8192);
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
            }
        }
    }

    /* renamed from: a */
    public static boolean m25705a(@ColorInt int i2) {
        return ColorUtils.calculateLuminance(i2) < 0.5d;
    }

    /* renamed from: a */
    public static void m25701a(@InterfaceC4546f Window window, @ColorInt int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(AbstractC1191a.f2487B1);
            window.clearFlags(AbstractC1191a.f2490C1);
            window.getDecorView().setSystemUiVisibility(256);
            window.setStatusBarColor(i2);
            m25702a(window, !m25705a(i2));
        }
    }
}
