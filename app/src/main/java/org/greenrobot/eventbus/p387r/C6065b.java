package org.greenrobot.eventbus.p387r;

import org.greenrobot.eventbus.C6061o;

/* compiled from: SimpleSubscriberInfo.java */
/* renamed from: org.greenrobot.eventbus.r.b */
/* loaded from: classes2.dex */
public class C6065b extends AbstractC6064a {

    /* renamed from: d */
    private final C6068e[] f21619d;

    public C6065b(Class cls, boolean z, C6068e[] c6068eArr) {
        super(cls, null, z);
        this.f21619d = c6068eArr;
    }

    @Override // org.greenrobot.eventbus.p387r.InterfaceC6066c
    /* renamed from: a */
    public synchronized C6061o[] mo25053a() {
        C6061o[] c6061oArr;
        int length = this.f21619d.length;
        c6061oArr = new C6061o[length];
        for (int i2 = 0; i2 < length; i2++) {
            C6068e c6068e = this.f21619d[i2];
            c6061oArr[i2] = m25049a(c6068e.f21620a, c6068e.f21622c, c6068e.f21621b, c6068e.f21623d, c6068e.f21624e);
        }
        return c6061oArr;
    }
}
