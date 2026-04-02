package com.lxj.xpopup.c;

import android.view.View;

/* JADX INFO: compiled from: PopupAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.lxj.xpopup.d.c f5401b;

    public b() {
    }

    public abstract void a();

    public abstract void b();

    public int c() {
        return com.lxj.xpopup.b.a();
    }

    public abstract void d();

    public b(View view) {
        this(view, null);
    }

    public b(View view, com.lxj.xpopup.d.c cVar) {
        this.a = view;
        this.f5401b = cVar;
    }
}
