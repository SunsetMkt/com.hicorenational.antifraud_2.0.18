package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import org.greenrobot.eventbus.C6049c;

/* compiled from: ErrorDialogConfig.java */
/* renamed from: org.greenrobot.eventbus.util.b */
/* loaded from: classes2.dex */
public class C6070b {

    /* renamed from: a */
    final Resources f21653a;

    /* renamed from: b */
    final int f21654b;

    /* renamed from: c */
    final int f21655c;

    /* renamed from: e */
    C6049c f21657e;

    /* renamed from: g */
    String f21659g;

    /* renamed from: h */
    int f21660h;

    /* renamed from: i */
    Class<?> f21661i;

    /* renamed from: f */
    boolean f21658f = true;

    /* renamed from: d */
    final C6072d f21656d = new C6072d();

    public C6070b(Resources resources, int i2, int i3) {
        this.f21653a = resources;
        this.f21654b = i2;
        this.f21655c = i3;
    }

    /* renamed from: a */
    public C6070b m25081a(Class<? extends Throwable> cls, int i2) {
        this.f21656d.m25093a(cls, i2);
        return this;
    }

    /* renamed from: b */
    C6049c m25087b() {
        C6049c c6049c = this.f21657e;
        return c6049c != null ? c6049c : C6049c.m24987f();
    }

    /* renamed from: a */
    public int m25080a(Throwable th) {
        Integer m25092a = this.f21656d.m25092a(th);
        if (m25092a != null) {
            return m25092a.intValue();
        }
        String str = C6049c.f21526s;
        String str2 = "No specific message ressource ID found for " + th;
        return this.f21655c;
    }

    /* renamed from: a */
    public void m25083a(int i2) {
        this.f21660h = i2;
    }

    /* renamed from: a */
    public void m25084a(Class<?> cls) {
        this.f21661i = cls;
    }

    /* renamed from: a */
    public void m25082a() {
        this.f21658f = false;
    }

    /* renamed from: a */
    public void m25085a(String str) {
        this.f21659g = str;
    }

    /* renamed from: a */
    public void m25086a(C6049c c6049c) {
        this.f21657e = c6049c;
    }
}
