package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.C4215fi;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.C4329b;
import java.util.Collection;

/* renamed from: com.xiaomi.push.service.s */
/* loaded from: classes2.dex */
public class C4397s extends XMPushService.AbstractC4337j {

    /* renamed from: a */
    private XMPushService f16771a;

    /* renamed from: a */
    private String f16772a;

    /* renamed from: a */
    private byte[] f16773a;

    /* renamed from: b */
    private String f16774b;

    /* renamed from: c */
    private String f16775c;

    public C4397s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f16771a = xMPushService;
        this.f16772a = str;
        this.f16773a = bArr;
        this.f16774b = str2;
        this.f16775c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
    /* renamed from: a */
    public String mo14643a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
    /* renamed from: a */
    public void mo14644a() {
        C4361am.b next;
        C4393p m16204a = C4394q.m16204a((Context) this.f16771a);
        if (m16204a == null) {
            try {
                m16204a = C4394q.m16205a(this.f16771a, this.f16772a, this.f16774b, this.f16775c);
            } catch (Exception e2) {
                AbstractC4022b.m13361d("fail to register push account. " + e2);
            }
        }
        if (m16204a == null) {
            AbstractC4022b.m13361d("no account for registration.");
            C4398t.m16227a(this.f16771a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        AbstractC4022b.m13347a("do registration now.");
        Collection<C4361am.b> m15956a = C4361am.m15951a().m15956a("5");
        if (m15956a.isEmpty()) {
            next = m16204a.m16201a(this.f16771a);
            C4401w.m16282a(this.f16771a, next);
            C4361am.m15951a().m15962a(next);
        } else {
            next = m15956a.iterator().next();
        }
        if (!this.f16771a.m15812c()) {
            C4398t.m16231a(this.f16772a, this.f16773a);
            this.f16771a.m15803a(true);
            return;
        }
        try {
            if (next.f16551a == C4361am.c.binded) {
                C4401w.m16284a(this.f16771a, this.f16772a, this.f16773a);
            } else if (next.f16551a == C4361am.c.unbind) {
                C4398t.m16231a(this.f16772a, this.f16773a);
                XMPushService xMPushService = this.f16771a;
                XMPushService xMPushService2 = this.f16771a;
                xMPushService2.getClass();
                xMPushService.m15797a(xMPushService2.new C4329b(next));
            }
        } catch (C4215fi e3) {
            AbstractC4022b.m13361d("meet error, disconnect connection. " + e3);
            this.f16771a.m15795a(10, e3);
        }
    }
}
