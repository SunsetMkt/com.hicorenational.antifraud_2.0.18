package org.greenrobot.eventbus.r;

import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.o;

/* JADX INFO: compiled from: AbstractSubscriberInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements c {
    private final Class a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends c> f12959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12960c;

    protected a(Class cls, Class<? extends c> cls2, boolean z) {
        this.a = cls;
        this.f12959b = cls2;
        this.f12960c = z;
    }

    protected o a(String str, Class<?> cls) {
        return a(str, cls, ThreadMode.POSTING, 0, false);
    }

    @Override // org.greenrobot.eventbus.r.c
    public c b() {
        Class<? extends c> cls = this.f12959b;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // org.greenrobot.eventbus.r.c
    public boolean c() {
        return this.f12960c;
    }

    @Override // org.greenrobot.eventbus.r.c
    public Class d() {
        return this.a;
    }

    protected o a(String str, Class<?> cls, ThreadMode threadMode) {
        return a(str, cls, threadMode, 0, false);
    }

    protected o a(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        try {
            return new o(this.a.getDeclaredMethod(str, cls), cls, threadMode, i2, z);
        } catch (NoSuchMethodException e2) {
            throw new org.greenrobot.eventbus.e("Could not find subscriber method in " + this.a + ". Maybe a missing ProGuard rule?", e2);
        }
    }
}
