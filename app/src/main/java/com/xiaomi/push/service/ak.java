package com.xiaomi.push.service;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.push.cc;
import com.xiaomi.push.cg;
import com.xiaomi.push.db;
import com.xiaomi.push.dp;
import com.xiaomi.push.ei;
import com.xiaomi.push.ep;
import com.xiaomi.push.er;
import com.xiaomi.push.fb;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fz;
import com.xiaomi.push.service.am;
import java.util.Date;

/* loaded from: classes2.dex */
public class ak {

    /* renamed from: a, reason: collision with root package name */
    private XMPushService f13341a;

    ak(XMPushService xMPushService) {
        this.f13341a = xMPushService;
    }

    private void c(er erVar) {
        am.b a2;
        String g2 = erVar.g();
        String num = Integer.toString(erVar.a());
        if (TextUtils.isEmpty(g2) || TextUtils.isEmpty(num) || (a2 = am.a().a(num, g2)) == null) {
            return;
        }
        fz.a(this.f13341a, a2.f998a, erVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fo foVar) {
        if (!"5".equals(foVar.k())) {
            b(foVar);
        }
        String k2 = foVar.k();
        if (TextUtils.isEmpty(k2)) {
            k2 = "1";
            foVar.l("1");
        }
        if (k2.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Received wrong packet with chid = 0 : " + foVar.mo431a());
        }
        if (foVar instanceof fm) {
            fl a2 = foVar.a("kick");
            if (a2 != null) {
                String l2 = foVar.l();
                String a3 = a2.a("type");
                String a4 = a2.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m50a("kicked by server, chid=" + k2 + " res=" + am.b.a(l2) + " type=" + a3 + " reason=" + a4);
                if (!"wait".equals(a3)) {
                    this.f13341a.a(k2, l2, 3, a4, a3);
                    am.a().m697a(k2, l2);
                    return;
                }
                am.b a5 = am.a().a(k2, l2);
                if (a5 != null) {
                    this.f13341a.a(a5);
                    a5.a(am.c.unbind, 3, 0, a4, a3);
                    return;
                }
                return;
            }
        } else if (foVar instanceof fn) {
            fn fnVar = (fn) foVar;
            if ("redir".equals(fnVar.b())) {
                fl a6 = fnVar.a(DispatchConstants.HOSTS);
                if (a6 != null) {
                    a(a6);
                    return;
                }
                return;
            }
        }
        this.f13341a.m665b().a(this.f13341a, k2, foVar);
    }

    public void b(er erVar) {
        String m390a = erVar.m390a();
        if (erVar.a() == 0) {
            if ("PING".equals(m390a)) {
                byte[] m394a = erVar.m394a();
                if (m394a != null && m394a.length > 0) {
                    dp.j a2 = dp.j.a(m394a);
                    if (a2.m348b()) {
                        ax.a().a(a2.m346a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f13341a.getPackageName())) {
                    this.f13341a.m662a();
                }
                if ("1".equals(erVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("received a server ping");
                } else {
                    ep.b();
                }
                this.f13341a.m666b();
                return;
            }
            if (!"SYNC".equals(m390a)) {
                if ("NOTIFY".equals(erVar.m390a())) {
                    dp.h a3 = dp.h.a(erVar.m394a());
                    com.xiaomi.channel.commonutils.logger.b.m50a("notify by server err = " + a3.c() + " desc = " + a3.m340a());
                    return;
                }
                return;
            }
            if ("CONF".equals(erVar.m397b())) {
                ax.a().a(dp.b.a(erVar.m394a()));
                return;
            }
            if (TextUtils.equals("U", erVar.m397b())) {
                dp.k a4 = dp.k.a(erVar.m394a());
                db.a(this.f13341a).a(a4.m350a(), a4.m353b(), new Date(a4.m349a()), new Date(a4.m352b()), a4.c() * 1024, a4.e());
                er erVar2 = new er();
                erVar2.a(0);
                erVar2.a(erVar.m390a(), "UCA");
                erVar2.a(erVar.e());
                XMPushService xMPushService = this.f13341a;
                xMPushService.a(new aw(xMPushService, erVar2));
                return;
            }
            if (TextUtils.equals("P", erVar.m397b())) {
                dp.i a5 = dp.i.a(erVar.m394a());
                er erVar3 = new er();
                erVar3.a(0);
                erVar3.a(erVar.m390a(), "PCA");
                erVar3.a(erVar.e());
                dp.i iVar = new dp.i();
                if (a5.m344a()) {
                    iVar.a(a5.m343a());
                }
                erVar3.a(iVar.m374a(), (String) null);
                XMPushService xMPushService2 = this.f13341a;
                xMPushService2.a(new aw(xMPushService2, erVar3));
                com.xiaomi.channel.commonutils.logger.b.m50a("ACK msgP: id = " + erVar.e());
                return;
            }
            return;
        }
        String num = Integer.toString(erVar.a());
        if ("SECMSG".equals(erVar.m390a())) {
            if (!erVar.m393a()) {
                this.f13341a.m665b().a(this.f13341a, num, erVar);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("Recv SECMSG errCode = " + erVar.b() + " errStr = " + erVar.m400c());
            return;
        }
        if (!"BIND".equals(m390a)) {
            if ("KICK".equals(m390a)) {
                dp.g a6 = dp.g.a(erVar.m394a());
                String g2 = erVar.g();
                String m335a = a6.m335a();
                String m337b = a6.m337b();
                com.xiaomi.channel.commonutils.logger.b.m50a("kicked by server, chid=" + num + " res= " + am.b.a(g2) + " type=" + m335a + " reason=" + m337b);
                if (!"wait".equals(m335a)) {
                    this.f13341a.a(num, g2, 3, m337b, m335a);
                    am.a().m697a(num, g2);
                    return;
                }
                am.b a7 = am.a().a(num, g2);
                if (a7 != null) {
                    this.f13341a.a(a7);
                    a7.a(am.c.unbind, 3, 0, m337b, m335a);
                    return;
                }
                return;
            }
            return;
        }
        dp.d a8 = dp.d.a(erVar.m394a());
        String g3 = erVar.g();
        am.b a9 = am.a().a(num, g3);
        if (a9 == null) {
            return;
        }
        if (a8.m311a()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("SMACK: channel bind succeeded, chid=" + erVar.a());
            a9.a(am.c.binded, 1, 0, (String) null, (String) null);
            return;
        }
        String m310a = a8.m310a();
        if ("auth".equals(m310a)) {
            if ("invalid-sig".equals(a8.m312b())) {
                com.xiaomi.channel.commonutils.logger.b.m50a("SMACK: bind error invalid-sig token = " + a9.f13346c + " sec = " + a9.f13351h);
                ep.a(0, ei.BIND_INVALID_SIG.a(), 1, null, 0);
            }
            a9.a(am.c.unbind, 1, 5, a8.m312b(), m310a);
            am.a().m697a(num, g3);
        } else if (CommonNetImpl.CANCEL.equals(m310a)) {
            a9.a(am.c.unbind, 1, 7, a8.m312b(), m310a);
            am.a().m697a(num, g3);
        } else if ("wait".equals(m310a)) {
            this.f13341a.a(a9);
            a9.a(am.c.unbind, 1, 7, a8.m312b(), m310a);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("SMACK: channel bind failed, chid=" + num + " reason=" + a8.m312b());
    }

    public void a(er erVar) {
        if (5 != erVar.a()) {
            c(erVar);
        }
        try {
            b(erVar);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + erVar.a() + " cmd = " + erVar.m390a() + " packetid = " + erVar.e() + " failure ", e2);
        }
    }

    private void a(fl flVar) {
        String c2 = flVar.c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String[] split = c2.split(";");
        cc a2 = cg.a().a(fb.a(), false);
        if (a2 == null || split.length <= 0) {
            return;
        }
        a2.a(split);
        this.f13341a.a(20, (Exception) null);
        this.f13341a.a(true);
    }

    private void b(fo foVar) {
        am.b a2;
        String l2 = foVar.l();
        String k2 = foVar.k();
        if (TextUtils.isEmpty(l2) || TextUtils.isEmpty(k2) || (a2 = am.a().a(k2, l2)) == null) {
            return;
        }
        fz.a(this.f13341a, a2.f998a, fz.a(foVar.mo431a()), true, true, System.currentTimeMillis());
    }
}
