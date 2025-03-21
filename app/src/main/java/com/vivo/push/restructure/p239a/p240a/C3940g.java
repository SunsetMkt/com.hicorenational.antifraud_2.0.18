package com.vivo.push.restructure.p239a.p240a;

import android.os.SystemClock;
import com.vivo.push.restructure.p239a.InterfaceC3933a;

/* compiled from: IPCNode.java */
/* renamed from: com.vivo.push.restructure.a.a.g */
/* loaded from: classes2.dex */
final class C3940g extends AbstractC3934a<InterfaceC3933a> {

    /* renamed from: b */
    private long f14134b;

    public C3940g(InterfaceC3933a interfaceC3933a, InterfaceC3942i interfaceC3942i) {
        super("IPCNode", interfaceC3933a, interfaceC3942i);
        this.f14134b = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long mo13081d = interfaceC3933a.mo13081d();
        if (mo13081d <= 0 || elapsedRealtime <= mo13081d) {
            return;
        }
        this.f14134b = elapsedRealtime - mo13081d;
    }

    @Override // com.vivo.push.restructure.p239a.p240a.AbstractC3934a
    /* renamed from: a */
    protected final /* bridge */ /* synthetic */ int mo13092a(InterfaceC3933a interfaceC3933a) {
        return 0;
    }

    @Override // com.vivo.push.restructure.p239a.p240a.AbstractC3934a
    /* renamed from: b */
    public final synchronized String mo13096b() {
        m13094a(this.f14134b);
        return super.mo13096b();
    }
}
