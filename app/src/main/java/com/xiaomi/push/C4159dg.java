package com.xiaomi.push;

/* renamed from: com.xiaomi.push.dg */
/* loaded from: classes2.dex */
public class C4159dg {

    /* renamed from: a */
    private static volatile C4159dg f14885a;

    /* renamed from: a */
    private InterfaceC4158df f14886a;

    /* renamed from: a */
    public static C4159dg m14281a() {
        if (f14885a == null) {
            synchronized (C4159dg.class) {
                if (f14885a == null) {
                    f14885a = new C4159dg();
                }
            }
        }
        return f14885a;
    }

    /* renamed from: a */
    public InterfaceC4158df m14282a() {
        return this.f14886a;
    }

    /* renamed from: a */
    public void m14283a(InterfaceC4158df interfaceC4158df) {
        this.f14886a = interfaceC4158df;
    }
}
