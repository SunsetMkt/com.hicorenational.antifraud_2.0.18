package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.b;
import com.xiaomi.push.service.am;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class s extends XMPushService.j {
    private XMPushService a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f1072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f1073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9420c;

    public s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f1072a = str;
        this.f1073a = bArr;
        this.f9419b = str2;
        this.f9420c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* JADX INFO: renamed from: a */
    public void mo377a() {
        am.b next;
        p pVarM739a = q.m739a((Context) this.a);
        if (pVarM739a == null) {
            try {
                pVarM739a = q.a(this.a, this.f1072a, this.f9419b, this.f9420c);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e2);
            }
        }
        if (pVarM739a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            t.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("do registration now.");
        Collection<am.b> collectionM691a = am.a().m691a("5");
        if (collectionM691a.isEmpty()) {
            next = pVarM739a.a(this.a);
            w.a(this.a, next);
            am.a().a(next);
        } else {
            next = collectionM691a.iterator().next();
        }
        if (!this.a.m666c()) {
            t.a(this.f1072a, this.f1073a);
            this.a.a(true);
            return;
        }
        try {
            if (next.f996a == am.c.binded) {
                w.a(this.a, this.f1072a, this.f1073a);
            } else if (next.f996a == am.c.unbind) {
                t.a(this.f1072a, this.f1073a);
                XMPushService xMPushService = this.a;
                XMPushService xMPushService2 = this.a;
                xMPushService2.getClass();
                xMPushService.a(xMPushService2.new b(next));
            }
        } catch (fi e3) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e3);
            this.a.a(10, e3);
        }
    }
}
