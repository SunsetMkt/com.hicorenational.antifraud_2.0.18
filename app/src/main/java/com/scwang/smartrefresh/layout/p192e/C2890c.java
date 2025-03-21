package com.scwang.smartrefresh.layout.p192e;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2875i;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2881a;

/* compiled from: DesignUtil.java */
/* renamed from: com.scwang.smartrefresh.layout.e.c */
/* loaded from: classes.dex */
public class C2890c {

    /* compiled from: DesignUtil.java */
    /* renamed from: com.scwang.smartrefresh.layout.e.c$a */
    static class a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a */
        final /* synthetic */ InterfaceC2881a f9117a;

        a(InterfaceC2881a interfaceC2881a) {
            this.f9117a = interfaceC2881a;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            this.f9117a.mo8722a(i2 >= 0, appBarLayout.getTotalScrollRange() + i2 <= 0);
        }
    }

    /* renamed from: a */
    public static void m8738a(View view, InterfaceC2875i interfaceC2875i, InterfaceC2881a interfaceC2881a) {
        try {
            if (view instanceof CoordinatorLayout) {
                interfaceC2875i.mo8698c().mo8684u(false);
                m8739a((ViewGroup) view, interfaceC2881a);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static void m8739a(ViewGroup viewGroup, InterfaceC2881a interfaceC2881a) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(interfaceC2881a));
            }
        }
    }
}
