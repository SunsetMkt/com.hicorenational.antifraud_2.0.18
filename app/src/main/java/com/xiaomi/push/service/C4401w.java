package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.AbstractC4207fa;
import com.xiaomi.push.AbstractC4221fo;
import com.xiaomi.push.C4085an;
import com.xiaomi.push.C4144cs;
import com.xiaomi.push.C4197er;
import com.xiaomi.push.C4215fi;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4254gu;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4281hu;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.InterfaceC4277hq;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.C4373ay;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.w */
/* loaded from: classes2.dex */
final class C4401w {
    /* renamed from: a */
    static void m16280a(XMPushService xMPushService) {
        C4393p m16204a = C4394q.m16204a(xMPushService.getApplicationContext());
        if (m16204a != null) {
            C4361am.b m16201a = C4394q.m16204a(xMPushService.getApplicationContext()).m16201a(xMPushService);
            AbstractC4022b.m13347a("prepare account. " + m16201a.f16553a);
            m16282a(xMPushService, m16201a);
            C4361am.m15951a().m15962a(m16201a);
            m16283a(xMPushService, m16204a, 172800);
        }
    }

    /* renamed from: b */
    static <T extends InterfaceC4277hq<T, ?>> C4262hb m16286b(String str, String str2, T t, EnumC4239gf enumC4239gf) {
        return m16277a(str, str2, t, enumC4239gf, false);
    }

    /* renamed from: b */
    static C4262hb m16285b(String str, String str2) {
        C4265he c4265he = new C4265he();
        c4265he.m15314b(str2);
        c4265he.m15318c(EnumC4249gp.AppDataCleared.f15769a);
        c4265he.m15301a(C4358aj.m15941a());
        c4265he.m15304a(false);
        return m16276a(str, str2, c4265he, EnumC4239gf.Notification);
    }

    /* renamed from: a */
    private static void m16283a(final XMPushService xMPushService, final C4393p c4393p, int i2) {
        C4373ay.m16032a(xMPushService).m16036a(new C4373ay.a("MSAID", i2) { // from class: com.xiaomi.push.service.w.1
            @Override // com.xiaomi.push.service.C4373ay.a
            /* renamed from: a */
            void mo16038a(C4373ay c4373ay) {
                C4085an m13755a = C4085an.m13755a(xMPushService);
                String m16035a = c4373ay.m16035a("MSAID", "msaid");
                String mo13736a = m13755a.mo13736a();
                if (TextUtils.isEmpty(mo13736a) || TextUtils.equals(m16035a, mo13736a)) {
                    return;
                }
                c4373ay.m16037a("MSAID", "msaid", mo13736a);
                C4265he c4265he = new C4265he();
                c4265he.m15314b(c4393p.f16757d);
                c4265he.m15318c(EnumC4249gp.ClientInfoUpdate.f15769a);
                c4265he.m15301a(C4358aj.m15941a());
                c4265he.m15303a(new HashMap());
                m13755a.m13758a(c4265he.m15307a());
                byte[] m15567a = C4276hp.m15567a(C4401w.m16276a(xMPushService.getPackageName(), c4393p.f16757d, c4265he, EnumC4239gf.Notification));
                XMPushService xMPushService2 = xMPushService;
                xMPushService2.m15802a(xMPushService2.getPackageName(), m15567a, true);
            }
        });
    }

    /* renamed from: a */
    private static String m16278a(C4262hb c4262hb) {
        Map<String, String> map;
        C4252gs c4252gs = c4262hb.f15999a;
        if (c4252gs != null && (map = c4252gs.f15846b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return c4262hb.f16005b;
    }

    /* renamed from: a */
    static C4197er m16274a(C4393p c4393p, Context context, C4262hb c4262hb) {
        try {
            C4197er c4197er = new C4197er();
            c4197er.m14688a(5);
            c4197er.m14708c(c4393p.f16754a);
            c4197er.m14702b(m16278a(c4262hb));
            c4197er.m14692a("SECMSG", "message");
            String str = c4393p.f16754a;
            c4262hb.f16000a.f15865a = str.substring(0, str.indexOf("@"));
            c4262hb.f16000a.f15869c = str.substring(str.indexOf("/") + 1);
            c4197er.m14694a(C4276hp.m15567a(c4262hb), c4393p.f16756c);
            c4197er.m14693a((short) 1);
            AbstractC4022b.m13347a("try send mi push message. packagename:" + c4262hb.f16005b + " action:" + c4262hb.f15998a);
            return c4197er;
        } catch (NullPointerException e2) {
            AbstractC4022b.m13351a(e2);
            return null;
        }
    }

    /* renamed from: a */
    static C4197er m16273a(XMPushService xMPushService, byte[] bArr) {
        C4262hb c4262hb = new C4262hb();
        try {
            C4276hp.m15566a(c4262hb, bArr);
            return m16274a(C4394q.m16204a((Context) xMPushService), xMPushService, c4262hb);
        } catch (C4281hu e2) {
            AbstractC4022b.m13351a(e2);
            return null;
        }
    }

    /* renamed from: a */
    static <T extends InterfaceC4277hq<T, ?>> C4262hb m16276a(String str, String str2, T t, EnumC4239gf enumC4239gf) {
        return m16277a(str, str2, t, enumC4239gf, true);
    }

    /* renamed from: a */
    private static <T extends InterfaceC4277hq<T, ?>> C4262hb m16277a(String str, String str2, T t, EnumC4239gf enumC4239gf, boolean z) {
        byte[] m15567a = C4276hp.m15567a(t);
        C4262hb c4262hb = new C4262hb();
        C4254gu c4254gu = new C4254gu();
        c4254gu.f15864a = 5L;
        c4254gu.f15865a = "fakeid";
        c4262hb.m15267a(c4254gu);
        c4262hb.m15269a(ByteBuffer.wrap(m15567a));
        c4262hb.m15265a(enumC4239gf);
        c4262hb.m15278b(z);
        c4262hb.m15277b(str);
        c4262hb.m15270a(false);
        c4262hb.m15268a(str2);
        return c4262hb;
    }

    /* renamed from: a */
    static C4262hb m16275a(String str, String str2) {
        C4265he c4265he = new C4265he();
        c4265he.m15314b(str2);
        c4265he.m15318c("package uninstalled");
        c4265he.m15301a(AbstractC4221fo.m14854i());
        c4265he.m15304a(false);
        return m16276a(str, str2, c4265he, EnumC4239gf.Notification);
    }

    /* renamed from: a */
    static void m16282a(final XMPushService xMPushService, C4361am.b bVar) {
        bVar.m15977a((Messenger) null);
        bVar.m15978a(new C4361am.b.a() { // from class: com.xiaomi.push.service.w.2
            @Override // com.xiaomi.push.service.C4361am.b.a
            /* renamed from: a */
            public void mo14642a(C4361am.c cVar, C4361am.c cVar2, int i2) {
                if (cVar2 == C4361am.c.binded) {
                    C4398t.m16230a(XMPushService.this, true);
                    C4398t.m16229a(XMPushService.this);
                } else if (cVar2 == C4361am.c.unbind) {
                    AbstractC4022b.m13347a("onChange unbind");
                    C4398t.m16227a(XMPushService.this, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
                }
            }
        });
    }

    /* renamed from: a */
    static void m16284a(XMPushService xMPushService, String str, byte[] bArr) {
        C4144cs.m14183a(str, xMPushService.getApplicationContext(), bArr);
        AbstractC4207fa m15791a = xMPushService.m15791a();
        if (m15791a != null) {
            if (m15791a.mo14746a()) {
                C4197er m16273a = m16273a(xMPushService, bArr);
                if (m16273a != null) {
                    m15791a.mo14748b(m16273a);
                    return;
                } else {
                    C4398t.m16228a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
                    return;
                }
            }
            throw new C4215fi("Don't support XMPP connection.");
        }
        throw new C4215fi("try send msg while connection is null.");
    }

    /* renamed from: a */
    static void m16281a(XMPushService xMPushService, C4262hb c4262hb) {
        C4144cs.m14181a(c4262hb.m15279b(), xMPushService.getApplicationContext(), c4262hb, -1);
        AbstractC4207fa m15791a = xMPushService.m15791a();
        if (m15791a != null) {
            if (m15791a.mo14746a()) {
                C4197er m16274a = m16274a(C4394q.m16204a((Context) xMPushService), xMPushService, c4262hb);
                if (m16274a != null) {
                    m15791a.mo14748b(m16274a);
                    return;
                }
                return;
            }
            throw new C4215fi("Don't support XMPP connection.");
        }
        throw new C4215fi("try send msg while connection is null.");
    }

    /* renamed from: a */
    static String m16279a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }
}
