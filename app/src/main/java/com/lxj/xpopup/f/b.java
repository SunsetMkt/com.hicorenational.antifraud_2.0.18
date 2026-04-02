package com.lxj.xpopup.f;

import android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.lxj.xpopup.core.BasePopupView;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: KeyboardUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ViewTreeObserver.OnGlobalLayoutListener f5465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HashMap<View, InterfaceC0103b> f5466c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f5467d = 0;

    /* JADX INFO: compiled from: KeyboardUtils.java */
    static class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iB = b.b(this.a);
            if (b.a != iB) {
                Iterator it = b.f5466c.values().iterator();
                while (it.hasNext()) {
                    ((InterfaceC0103b) it.next()).a(iB);
                }
                b.a = iB;
            }
        }
    }

    /* JADX INFO: renamed from: com.lxj.xpopup.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KeyboardUtils.java */
    public interface InterfaceC0103b {
        void a(int i2);
    }

    private b() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            return a;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int iAbs = Math.abs(decorView.getBottom() - rect.bottom);
        if (iAbs > b()) {
            return iAbs - f5467d;
        }
        f5467d = iAbs;
        return 0;
    }

    public static void a(Activity activity, BasePopupView basePopupView, InterfaceC0103b interfaceC0103b) {
        if ((activity.getWindow().getAttributes().flags & 512) != 0) {
            activity.getWindow().clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        a = b(activity);
        f5466c.put(basePopupView, interfaceC0103b);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(activity));
    }

    private static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void a(View view, BasePopupView basePopupView) {
        view.findViewById(R.id.content).getViewTreeObserver().removeGlobalOnLayoutListener(f5465b);
        f5465b = null;
        f5466c.remove(basePopupView);
    }

    public static void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static void a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
