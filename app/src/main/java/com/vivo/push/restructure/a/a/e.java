package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.u;

/* compiled from: DispatchNode.java */
/* loaded from: classes2.dex */
final class e extends a<com.vivo.push.restructure.a.a> {
    public e(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("ClientDispatchNode", aVar, iVar);
    }

    private static PushMessageCallback b(com.vivo.push.restructure.a.a aVar) {
        try {
            return (PushMessageCallback) Class.forName(com.vivo.push.restructure.a.a().e().a(com.vivo.push.restructure.a.a().b(), aVar.b().getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            u.b("DispatchNode", "reflect e: ", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.restructure.a.a.a
    public int a(com.vivo.push.restructure.a.a aVar) {
        PushMessageCallback b2 = b(aVar);
        if (b2 == null) {
            return 2804;
        }
        int i2 = 0;
        if (aVar != null && aVar.g()) {
            com.vivo.push.restructure.request.d.a().a(aVar);
            return 0;
        }
        if (aVar != null) {
            int k2 = aVar.k();
            String l2 = aVar.l();
            if (k2 == 3) {
                String i3 = com.vivo.push.m.a().i();
                if (TextUtils.isEmpty(i3) || !TextUtils.equals(i3, l2)) {
                    i2 = 2810;
                }
            } else if (k2 == 4) {
                com.vivo.push.m.a();
                if (!com.vivo.push.m.c().contains(l2)) {
                    i2 = 2811;
                }
            }
            if (i2 != 0) {
                com.vivo.push.util.g.a().execute(new f(this, k2, l2));
                return i2;
            }
        }
        try {
            return com.vivo.push.m.a().a(aVar.b(), b2);
        } catch (Exception unused) {
            return 2808;
        }
    }
}
