package com.scwang.smartrefresh.layout.e;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.b.i;

/* JADX INFO: compiled from: DesignUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: compiled from: DesignUtil.java */
    static class a implements AppBarLayout.OnOffsetChangedListener {
        final /* synthetic */ com.scwang.smartrefresh.layout.d.a a;

        a(com.scwang.smartrefresh.layout.d.a aVar) {
            this.a = aVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            this.a.a(i2 >= 0, appBarLayout.getTotalScrollRange() + i2 <= 0);
        }
    }

    public static void a(View view, i iVar, com.scwang.smartrefresh.layout.d.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                iVar.c().u(false);
                a((ViewGroup) view, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(ViewGroup viewGroup, com.scwang.smartrefresh.layout.d.a aVar) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(aVar));
            }
        }
    }
}
