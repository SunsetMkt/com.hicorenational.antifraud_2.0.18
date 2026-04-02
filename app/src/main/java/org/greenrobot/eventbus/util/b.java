package org.greenrobot.eventbus.util;

import android.content.res.Resources;

/* JADX INFO: compiled from: ErrorDialogConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    final Resources a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f12987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f12988c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    org.greenrobot.eventbus.c f12990e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f12992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f12993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Class<?> f12994i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12991f = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final d f12989d = new d();

    public b(Resources resources, int i2, int i3) {
        this.a = resources;
        this.f12987b = i2;
        this.f12988c = i3;
    }

    public b a(Class<? extends Throwable> cls, int i2) {
        this.f12989d.a(cls, i2);
        return this;
    }

    org.greenrobot.eventbus.c b() {
        org.greenrobot.eventbus.c cVar = this.f12990e;
        return cVar != null ? cVar : org.greenrobot.eventbus.c.f();
    }

    public int a(Throwable th) {
        Integer numA = this.f12989d.a(th);
        if (numA != null) {
            return numA.intValue();
        }
        String str = org.greenrobot.eventbus.c.s;
        String str2 = "No specific message ressource ID found for " + th;
        return this.f12988c;
    }

    public void a(int i2) {
        this.f12993h = i2;
    }

    public void a(Class<?> cls) {
        this.f12994i = cls;
    }

    public void a() {
        this.f12991f = false;
    }

    public void a(String str) {
        this.f12992g = str;
    }

    public void a(org.greenrobot.eventbus.c cVar) {
        this.f12990e = cVar;
    }
}
