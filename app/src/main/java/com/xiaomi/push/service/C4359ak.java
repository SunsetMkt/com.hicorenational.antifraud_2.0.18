package com.xiaomi.push.service;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.AbstractC4221fo;
import com.xiaomi.push.C4128cc;
import com.xiaomi.push.C4132cg;
import com.xiaomi.push.C4154db;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.C4195ep;
import com.xiaomi.push.C4197er;
import com.xiaomi.push.C4208fb;
import com.xiaomi.push.C4218fl;
import com.xiaomi.push.C4219fm;
import com.xiaomi.push.C4220fn;
import com.xiaomi.push.C4232fz;
import com.xiaomi.push.EnumC4188ei;
import com.xiaomi.push.service.C4361am;
import java.util.Date;

/* renamed from: com.xiaomi.push.service.ak */
/* loaded from: classes2.dex */
public class C4359ak {

    /* renamed from: a */
    private XMPushService f16539a;

    C4359ak(XMPushService xMPushService) {
        this.f16539a = xMPushService;
    }

    /* renamed from: c */
    private void m15946c(C4197er c4197er) {
        C4361am.b m15954a;
        String m14711g = c4197er.m14711g();
        String num = Integer.toString(c4197er.m14683a());
        if (TextUtils.isEmpty(m14711g) || TextUtils.isEmpty(num) || (m15954a = C4361am.m15951a().m15954a(num, m14711g)) == null) {
            return;
        }
        C4232fz.m14917a(this.f16539a, m15954a.f16553a, c4197er.mo14704c(), true, true, System.currentTimeMillis());
    }

    /* renamed from: a */
    public void m15948a(AbstractC4221fo abstractC4221fo) {
        if (!"5".equals(abstractC4221fo.m14865k())) {
            m15945b(abstractC4221fo);
        }
        String m14865k = abstractC4221fo.m14865k();
        if (TextUtils.isEmpty(m14865k)) {
            m14865k = "1";
            abstractC4221fo.m14868l("1");
        }
        if (m14865k.equals("0")) {
            AbstractC4022b.m13347a("Received wrong packet with chid = 0 : " + abstractC4221fo.mo14829a());
        }
        if (abstractC4221fo instanceof C4219fm) {
            C4218fl m14856a = abstractC4221fo.m14856a("kick");
            if (m14856a != null) {
                String m14867l = abstractC4221fo.m14867l();
                String m14821a = m14856a.m14821a("type");
                String m14821a2 = m14856a.m14821a("reason");
                AbstractC4022b.m13347a("kicked by server, chid=" + m14865k + " res=" + C4361am.b.m15968a(m14867l) + " type=" + m14821a + " reason=" + m14821a2);
                if (!"wait".equals(m14821a)) {
                    this.f16539a.m15801a(m14865k, m14867l, 3, m14821a2, m14821a);
                    C4361am.m15951a().m15964a(m14865k, m14867l);
                    return;
                }
                C4361am.b m15954a = C4361am.m15951a().m15954a(m14865k, m14867l);
                if (m15954a != null) {
                    this.f16539a.m15800a(m15954a);
                    m15954a.m15979a(C4361am.c.unbind, 3, 0, m14821a2, m14821a);
                    return;
                }
                return;
            }
        } else if (abstractC4221fo instanceof C4220fn) {
            C4220fn c4220fn = (C4220fn) abstractC4221fo;
            if ("redir".equals(c4220fn.m14837b())) {
                C4218fl m14856a2 = c4220fn.m14856a(DispatchConstants.HOSTS);
                if (m14856a2 != null) {
                    m15944a(m14856a2);
                    return;
                }
                return;
            }
        }
        this.f16539a.m15808b().m16107a(this.f16539a, m14865k, abstractC4221fo);
    }

    /* renamed from: b */
    public void m15949b(C4197er c4197er) {
        String m14685a = c4197er.m14685a();
        if (c4197er.m14683a() == 0) {
            if ("PING".equals(m14685a)) {
                byte[] m14696a = c4197er.m14696a();
                if (m14696a != null && m14696a.length > 0) {
                    C4168dp.j m14487a = C4168dp.j.m14487a(m14696a);
                    if (m14487a.m14493b()) {
                        C4372ax.m16017a().m16028a(m14487a.m14489a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f16539a.getPackageName())) {
                    this.f16539a.m15793a();
                }
                if ("1".equals(c4197er.m14709e())) {
                    AbstractC4022b.m13347a("received a server ping");
                } else {
                    C4195ep.m14676b();
                }
                this.f16539a.m15809b();
                return;
            }
            if (!"SYNC".equals(m14685a)) {
                if ("NOTIFY".equals(c4197er.m14685a())) {
                    C4168dp.h m14476a = C4168dp.h.m14476a(c4197er.m14696a());
                    AbstractC4022b.m13347a("notify by server err = " + m14476a.m14482c() + " desc = " + m14476a.m14479a());
                    return;
                }
                return;
            }
            if ("CONF".equals(c4197er.m14700b())) {
                C4372ax.m16017a().m16028a(C4168dp.b.m14373a(c4197er.m14696a()));
                return;
            }
            if (TextUtils.equals("U", c4197er.m14700b())) {
                C4168dp.k m14494a = C4168dp.k.m14494a(c4197er.m14696a());
                C4154db.m14261a(this.f16539a).m14270a(m14494a.m14500a(), m14494a.m14505b(), new Date(m14494a.m14495a()), new Date(m14494a.m14502b()), m14494a.m14507c() * 1024, m14494a.m14510e());
                C4197er c4197er2 = new C4197er();
                c4197er2.m14688a(0);
                c4197er2.m14692a(c4197er.m14685a(), "UCA");
                c4197er2.m14691a(c4197er.m14709e());
                XMPushService xMPushService = this.f16539a;
                xMPushService.m15797a(new C4371aw(xMPushService, c4197er2));
                return;
            }
            if (TextUtils.equals("P", c4197er.m14700b())) {
                C4168dp.i m14483a = C4168dp.i.m14483a(c4197er.m14696a());
                C4197er c4197er3 = new C4197er();
                c4197er3.m14688a(0);
                c4197er3.m14692a(c4197er.m14685a(), "PCA");
                c4197er3.m14691a(c4197er.m14709e());
                C4168dp.i iVar = new C4168dp.i();
                if (m14483a.m14486a()) {
                    iVar.m14485a(m14483a.m14484a());
                }
                c4197er3.m14694a(iVar.m14590a(), (String) null);
                XMPushService xMPushService2 = this.f16539a;
                xMPushService2.m15797a(new C4371aw(xMPushService2, c4197er3));
                AbstractC4022b.m13347a("ACK msgP: id = " + c4197er.m14709e());
                return;
            }
            return;
        }
        String num = Integer.toString(c4197er.m14683a());
        if ("SECMSG".equals(c4197er.m14685a())) {
            if (!c4197er.m14695a()) {
                this.f16539a.m15808b().m16106a(this.f16539a, num, c4197er);
                return;
            }
            AbstractC4022b.m13347a("Recv SECMSG errCode = " + c4197er.m14698b() + " errStr = " + c4197er.m14706c());
            return;
        }
        if (!"BIND".equals(m14685a)) {
            if ("KICK".equals(m14685a)) {
                C4168dp.g m14466a = C4168dp.g.m14466a(c4197er.m14696a());
                String m14711g = c4197er.m14711g();
                String m14468a = m14466a.m14468a();
                String m14471b = m14466a.m14471b();
                AbstractC4022b.m13347a("kicked by server, chid=" + num + " res= " + C4361am.b.m15968a(m14711g) + " type=" + m14468a + " reason=" + m14471b);
                if (!"wait".equals(m14468a)) {
                    this.f16539a.m15801a(num, m14711g, 3, m14471b, m14468a);
                    C4361am.m15951a().m15964a(num, m14711g);
                    return;
                }
                C4361am.b m15954a = C4361am.m15951a().m15954a(num, m14711g);
                if (m15954a != null) {
                    this.f16539a.m15800a(m15954a);
                    m15954a.m15979a(C4361am.c.unbind, 3, 0, m14471b, m14468a);
                    return;
                }
                return;
            }
            return;
        }
        C4168dp.d m14404a = C4168dp.d.m14404a(c4197er.m14696a());
        String m14711g2 = c4197er.m14711g();
        C4361am.b m15954a2 = C4361am.m15951a().m15954a(num, m14711g2);
        if (m15954a2 == null) {
            return;
        }
        if (m14404a.m14408a()) {
            AbstractC4022b.m13347a("SMACK: channel bind succeeded, chid=" + c4197er.m14683a());
            m15954a2.m15979a(C4361am.c.binded, 1, 0, (String) null, (String) null);
            return;
        }
        String m14407a = m14404a.m14407a();
        if ("auth".equals(m14407a)) {
            if ("invalid-sig".equals(m14404a.m14410b())) {
                AbstractC4022b.m13347a("SMACK: bind error invalid-sig token = " + m15954a2.f16559c + " sec = " + m15954a2.f16564h);
                C4195ep.m14670a(0, EnumC4188ei.BIND_INVALID_SIG.m14600a(), 1, null, 0);
            }
            m15954a2.m15979a(C4361am.c.unbind, 1, 5, m14404a.m14410b(), m14407a);
            C4361am.m15951a().m15964a(num, m14711g2);
        } else if (CommonNetImpl.CANCEL.equals(m14407a)) {
            m15954a2.m15979a(C4361am.c.unbind, 1, 7, m14404a.m14410b(), m14407a);
            C4361am.m15951a().m15964a(num, m14711g2);
        } else if ("wait".equals(m14407a)) {
            this.f16539a.m15800a(m15954a2);
            m15954a2.m15979a(C4361am.c.unbind, 1, 7, m14404a.m14410b(), m14407a);
        }
        AbstractC4022b.m13347a("SMACK: channel bind failed, chid=" + num + " reason=" + m14404a.m14410b());
    }

    /* renamed from: a */
    public void m15947a(C4197er c4197er) {
        if (5 != c4197er.m14683a()) {
            m15946c(c4197er);
        }
        try {
            m15949b(c4197er);
        } catch (Exception e2) {
            AbstractC4022b.m13349a("handle Blob chid = " + c4197er.m14683a() + " cmd = " + c4197er.m14685a() + " packetid = " + c4197er.m14709e() + " failure ", e2);
        }
    }

    /* renamed from: a */
    private void m15944a(C4218fl c4218fl) {
        String m14825c = c4218fl.m14825c();
        if (TextUtils.isEmpty(m14825c)) {
            return;
        }
        String[] split = m14825c.split(";");
        C4128cc m14077a = C4132cg.m14066a().m14077a(C4208fb.m14784a(), false);
        if (m14077a == null || split.length <= 0) {
            return;
        }
        m14077a.m14046a(split);
        this.f16539a.m15795a(20, (Exception) null);
        this.f16539a.m15803a(true);
    }

    /* renamed from: b */
    private void m15945b(AbstractC4221fo abstractC4221fo) {
        C4361am.b m15954a;
        String m14867l = abstractC4221fo.m14867l();
        String m14865k = abstractC4221fo.m14865k();
        if (TextUtils.isEmpty(m14867l) || TextUtils.isEmpty(m14865k) || (m15954a = C4361am.m15951a().m15954a(m14865k, m14867l)) == null) {
            return;
        }
        C4232fz.m14917a(this.f16539a, m15954a.f16553a, C4232fz.m14909a(abstractC4221fo.mo14829a()), true, true, System.currentTimeMillis());
    }
}
