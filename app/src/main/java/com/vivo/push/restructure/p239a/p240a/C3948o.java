package com.vivo.push.restructure.p239a.p240a;

import android.text.TextUtils;
import com.vivo.push.restructure.p239a.InterfaceC3933a;
import com.vivo.push.util.C4010u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: NodeSaveImpl.java */
/* renamed from: com.vivo.push.restructure.a.a.o */
/* loaded from: classes2.dex */
final class C3948o implements InterfaceC3947n {

    /* renamed from: a */
    private Map<String, C3946m> f14141a = new ConcurrentHashMap();

    C3948o() {
    }

    @Override // com.vivo.push.restructure.p239a.p240a.InterfaceC3947n
    /* renamed from: a */
    public final void mo13107a(InterfaceC3933a interfaceC3933a, AbstractC3934a abstractC3934a) {
        if (interfaceC3933a == null) {
            C4010u.m13298a("addToCache error. msg is null");
        } else if (TextUtils.isEmpty(interfaceC3933a.mo13078a())) {
            C4010u.m13298a("addToCache error. messageID is null");
        } else if (abstractC3934a == null) {
            C4010u.m13298a("addToCache error. firstNode is null");
        }
    }
}
