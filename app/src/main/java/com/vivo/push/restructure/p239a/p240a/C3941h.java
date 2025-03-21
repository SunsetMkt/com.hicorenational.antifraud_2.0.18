package com.vivo.push.restructure.p239a.p240a;

import android.content.Context;
import com.vivo.push.C3924m;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.p239a.InterfaceC3933a;
import com.vivo.push.util.C4010u;

/* compiled from: InitNode.java */
/* renamed from: com.vivo.push.restructure.a.a.h */
/* loaded from: classes2.dex */
final class C3941h extends AbstractC3934a<InterfaceC3933a> {
    public C3941h(InterfaceC3933a interfaceC3933a, InterfaceC3942i interfaceC3942i) {
        super("InitNode", interfaceC3933a, interfaceC3942i);
    }

    @Override // com.vivo.push.restructure.p239a.p240a.AbstractC3934a
    /* renamed from: a */
    protected final /* synthetic */ int mo13092a(InterfaceC3933a interfaceC3933a) {
        Context m13071b = C3932a.m13069a().m13071b();
        C3924m.m13016a().m13030a(m13071b);
        C4010u.m13309d("InitNode", "PushMessageReceiver " + m13071b.getPackageName() + " ; requestId = " + interfaceC3933a.mo13080c());
        return 0;
    }
}
