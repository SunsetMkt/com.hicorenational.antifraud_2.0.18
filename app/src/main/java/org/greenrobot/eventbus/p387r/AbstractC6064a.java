package org.greenrobot.eventbus.p387r;

import org.greenrobot.eventbus.C6051e;
import org.greenrobot.eventbus.C6061o;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: AbstractSubscriberInfo.java */
/* renamed from: org.greenrobot.eventbus.r.a */
/* loaded from: classes2.dex */
public abstract class AbstractC6064a implements InterfaceC6066c {

    /* renamed from: a */
    private final Class f21616a;

    /* renamed from: b */
    private final Class<? extends InterfaceC6066c> f21617b;

    /* renamed from: c */
    private final boolean f21618c;

    protected AbstractC6064a(Class cls, Class<? extends InterfaceC6066c> cls2, boolean z) {
        this.f21616a = cls;
        this.f21617b = cls2;
        this.f21618c = z;
    }

    /* renamed from: a */
    protected C6061o m25047a(String str, Class<?> cls) {
        return m25049a(str, cls, ThreadMode.POSTING, 0, false);
    }

    @Override // org.greenrobot.eventbus.p387r.InterfaceC6066c
    /* renamed from: b */
    public InterfaceC6066c mo25050b() {
        Class<? extends InterfaceC6066c> cls = this.f21617b;
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

    @Override // org.greenrobot.eventbus.p387r.InterfaceC6066c
    /* renamed from: c */
    public boolean mo25051c() {
        return this.f21618c;
    }

    @Override // org.greenrobot.eventbus.p387r.InterfaceC6066c
    /* renamed from: d */
    public Class mo25052d() {
        return this.f21616a;
    }

    /* renamed from: a */
    protected C6061o m25048a(String str, Class<?> cls, ThreadMode threadMode) {
        return m25049a(str, cls, threadMode, 0, false);
    }

    /* renamed from: a */
    protected C6061o m25049a(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        try {
            return new C6061o(this.f21616a.getDeclaredMethod(str, cls), cls, threadMode, i2, z);
        } catch (NoSuchMethodException e2) {
            throw new C6051e("Could not find subscriber method in " + this.f21616a + ". Maybe a missing ProGuard rule?", e2);
        }
    }
}
