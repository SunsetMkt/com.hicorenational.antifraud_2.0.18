package org.greenrobot.eventbus.r;

import org.greenrobot.eventbus.o;

/* JADX INFO: compiled from: SimpleSubscriberInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e[] f12961d;

    public b(Class cls, boolean z, e[] eVarArr) {
        super(cls, null, z);
        this.f12961d = eVarArr;
    }

    @Override // org.greenrobot.eventbus.r.c
    public synchronized o[] a() {
        o[] oVarArr;
        int length = this.f12961d.length;
        oVarArr = new o[length];
        for (int i2 = 0; i2 < length; i2++) {
            e eVar = this.f12961d[i2];
            oVarArr[i2] = a(eVar.a, eVar.f12963c, eVar.f12962b, eVar.f12964d, eVar.f12965e);
        }
        return oVarArr;
    }
}
