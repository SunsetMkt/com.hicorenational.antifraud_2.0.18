package com.lxj.xpopup.p187f;

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

/* compiled from: KeyboardUtils.java */
/* renamed from: com.lxj.xpopup.f.b */
/* loaded from: classes.dex */
public final class C2818b {

    /* renamed from: a */
    public static int f8731a;

    /* renamed from: b */
    private static ViewTreeObserver.OnGlobalLayoutListener f8732b;

    /* renamed from: c */
    private static HashMap<View, b> f8733c = new HashMap<>();

    /* renamed from: d */
    private static int f8734d = 0;

    /* compiled from: KeyboardUtils.java */
    /* renamed from: com.lxj.xpopup.f.b$a */
    static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ Activity f8735a;

        a(Activity activity) {
            this.f8735a = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int m8446b = C2818b.m8446b(this.f8735a);
            if (C2818b.f8731a != m8446b) {
                Iterator it = C2818b.f8733c.values().iterator();
                while (it.hasNext()) {
                    ((b) it.next()).mo8395a(m8446b);
                }
                C2818b.f8731a = m8446b;
            }
        }
    }

    /* compiled from: KeyboardUtils.java */
    /* renamed from: com.lxj.xpopup.f.b$b */
    public interface b {
        /* renamed from: a */
        void mo8395a(int i2);
    }

    private C2818b() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static int m8446b(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            return f8731a;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs > m8445b()) {
            return abs - f8734d;
        }
        f8734d = abs;
        return 0;
    }

    /* renamed from: a */
    public static void m8442a(Activity activity, BasePopupView basePopupView, b bVar) {
        if ((activity.getWindow().getAttributes().flags & 512) != 0) {
            activity.getWindow().clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        f8731a = m8446b(activity);
        f8733c.put(basePopupView, bVar);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(activity));
    }

    /* renamed from: b */
    private static int m8445b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: a */
    public static void m8444a(View view, BasePopupView basePopupView) {
        view.findViewById(R.id.content).getViewTreeObserver().removeGlobalOnLayoutListener(f8732b);
        f8732b = null;
        f8733c.remove(basePopupView);
    }

    /* renamed from: b */
    public static void m8447b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    /* renamed from: a */
    public static void m8443a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
