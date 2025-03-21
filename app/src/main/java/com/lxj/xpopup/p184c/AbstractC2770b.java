package com.lxj.xpopup.p184c;

import android.view.View;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p185d.EnumC2803c;

/* compiled from: PopupAnimator.java */
/* renamed from: com.lxj.xpopup.c.b */
/* loaded from: classes.dex */
public abstract class AbstractC2770b {

    /* renamed from: a */
    public View f8569a;

    /* renamed from: b */
    public EnumC2803c f8570b;

    public AbstractC2770b() {
    }

    /* renamed from: a */
    public abstract void mo8347a();

    /* renamed from: b */
    public abstract void mo8348b();

    /* renamed from: c */
    public int m8350c() {
        return C2768b.m8294a();
    }

    /* renamed from: d */
    public abstract void mo8349d();

    public AbstractC2770b(View view) {
        this(view, null);
    }

    public AbstractC2770b(View view, EnumC2803c enumC2803c) {
        this.f8569a = view;
        this.f8570b = enumC2803c;
    }
}
