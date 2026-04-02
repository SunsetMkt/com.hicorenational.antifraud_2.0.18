package com.heytap.mcssdk.h;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.f;
import com.heytap.mcssdk.k.e;
import com.heytap.mcssdk.k.g;
import com.heytap.msp.push.mode.BaseMode;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    private static final String a = "a";

    @Override // com.heytap.mcssdk.h.d
    public BaseMode a(Context context, int i2, Intent intent) {
        if (4105 == i2) {
            return a(intent, i2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.heytap.mcssdk.h.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected BaseMode a(Intent intent, int i2) {
        f.c cVar;
        Exception e2;
        try {
            cVar = new f.c();
        } catch (Exception e3) {
            cVar = null;
            e2 = e3;
        } catch (Throwable unused) {
            cVar = null;
            g.b(a, "parseMessageByIntent() finally will get miniProgramPkg");
            if (cVar != null) {
            }
            return cVar;
        }
        try {
            try {
                cVar.a(Integer.parseInt(e.d(intent.getStringExtra("command"))));
                cVar.b(Integer.parseInt(e.d(intent.getStringExtra("code"))));
                cVar.e(e.d(intent.getStringExtra("content")));
                cVar.a(e.d(intent.getStringExtra("appKey")));
                cVar.b(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.A)));
                cVar.g(e.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3895e)));
                g.b(a, "parseMessageByIntent() finally will get miniProgramPkg");
                try {
                    g.b(a, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                    cVar.f(intent.getStringExtra("miniProgramPkg"));
                    g.b("OnHandleIntent-message:" + cVar.toString());
                } catch (Exception e4) {
                    g.b("OnHandleIntent--" + e4.getMessage() + d.c.a.b.a.a.f10074g);
                }
                return cVar;
            } catch (Throwable unused2) {
                g.b(a, "parseMessageByIntent() finally will get miniProgramPkg");
                if (cVar != null) {
                    try {
                        g.b(a, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        cVar.f(intent.getStringExtra("miniProgramPkg"));
                        g.b("OnHandleIntent-message:" + cVar.toString());
                    } catch (Exception e5) {
                        g.b("OnHandleIntent--" + e5.getMessage() + d.c.a.b.a.a.f10074g);
                    }
                }
                return cVar;
            }
        } catch (Exception e6) {
            e2 = e6;
            g.b("OnHandleIntent--" + e2.getMessage());
            g.b(a, "parseMessageByIntent() finally will get miniProgramPkg");
            if (cVar != null) {
                try {
                    g.b(a, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                    cVar.f(intent.getStringExtra("miniProgramPkg"));
                    g.b("OnHandleIntent-message:" + cVar.toString());
                } catch (Exception e7) {
                    g.b("OnHandleIntent--" + e7.getMessage() + d.c.a.b.a.a.f10074g);
                }
            }
            return cVar;
        }
    }
}
