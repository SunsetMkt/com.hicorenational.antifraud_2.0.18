package com.vivo.push.restructure.p239a.p240a;

import android.text.TextUtils;
import com.vivo.push.C3924m;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.p239a.InterfaceC3933a;
import com.vivo.push.restructure.request.C3968d;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.C3996g;
import com.vivo.push.util.C4010u;

/* compiled from: DispatchNode.java */
/* renamed from: com.vivo.push.restructure.a.a.e */
/* loaded from: classes2.dex */
final class C3938e extends AbstractC3934a<InterfaceC3933a> {
    public C3938e(InterfaceC3933a interfaceC3933a, InterfaceC3942i interfaceC3942i) {
        super("ClientDispatchNode", interfaceC3933a, interfaceC3942i);
    }

    /* renamed from: b */
    private static PushMessageCallback m13101b(InterfaceC3933a interfaceC3933a) {
        try {
            return (PushMessageCallback) Class.forName(C3932a.m13069a().m13074e().mo13113a(C3932a.m13069a().m13071b(), interfaceC3933a.mo13079b().getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            C4010u.m13302b("DispatchNode", "reflect e: ", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.restructure.p239a.p240a.AbstractC3934a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo13092a(InterfaceC3933a interfaceC3933a) {
        PushMessageCallback m13101b = m13101b(interfaceC3933a);
        if (m13101b == null) {
            return 2804;
        }
        int i2 = 0;
        if (interfaceC3933a != null && interfaceC3933a.mo13084g()) {
            C3968d.m13155a().m13158a(interfaceC3933a);
            return 0;
        }
        if (interfaceC3933a != null) {
            int mo13088k = interfaceC3933a.mo13088k();
            String mo13089l = interfaceC3933a.mo13089l();
            if (mo13088k == 3) {
                String m13050i = C3924m.m13016a().m13050i();
                if (TextUtils.isEmpty(m13050i) || !TextUtils.equals(m13050i, mo13089l)) {
                    i2 = 2810;
                }
            } else if (mo13088k == 4) {
                C3924m.m13016a();
                if (!C3924m.m13026c().contains(mo13089l)) {
                    i2 = 2811;
                }
            }
            if (i2 != 0) {
                C3996g.m13250a().execute(new RunnableC3939f(this, mo13088k, mo13089l));
                return i2;
            }
        }
        try {
            return C3924m.m13016a().m13029a(interfaceC3933a.mo13079b(), m13101b);
        } catch (Exception unused) {
            return 2808;
        }
    }
}
