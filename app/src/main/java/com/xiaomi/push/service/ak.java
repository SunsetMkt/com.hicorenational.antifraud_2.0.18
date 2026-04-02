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

/* JADX INFO: loaded from: classes2.dex */
public class ak {
    private XMPushService a;

    ak(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void c(er erVar) {
        am.b bVarA;
        String strG = erVar.g();
        String string = Integer.toString(erVar.a());
        if (TextUtils.isEmpty(strG) || TextUtils.isEmpty(string) || (bVarA = am.a().a(string, strG)) == null) {
            return;
        }
        fz.a(this.a, bVarA.f998a, erVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fo foVar) {
        if (!"5".equals(foVar.k())) {
            b(foVar);
        }
        String strK = foVar.k();
        if (TextUtils.isEmpty(strK)) {
            strK = "1";
            foVar.l("1");
        }
        if (strK.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Received wrong packet with chid = 0 : " + foVar.mo429a());
        }
        if (foVar instanceof fm) {
            fl flVarA = foVar.a("kick");
            if (flVarA != null) {
                String strL = foVar.l();
                String strA = flVarA.a("type");
                String strA2 = flVarA.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m48a("kicked by server, chid=" + strK + " res=" + am.b.a(strL) + " type=" + strA + " reason=" + strA2);
                if (!"wait".equals(strA)) {
                    this.a.a(strK, strL, 3, strA2, strA);
                    am.a().m695a(strK, strL);
                    return;
                }
                am.b bVarA = am.a().a(strK, strL);
                if (bVarA != null) {
                    this.a.a(bVarA);
                    bVarA.a(am.c.unbind, 3, 0, strA2, strA);
                    return;
                }
                return;
            }
        } else if (foVar instanceof fn) {
            fn fnVar = (fn) foVar;
            if ("redir".equals(fnVar.b())) {
                fl flVarA2 = fnVar.a(DispatchConstants.HOSTS);
                if (flVarA2 != null) {
                    a(flVarA2);
                    return;
                }
                return;
            }
        }
        this.a.m663b().a(this.a, strK, foVar);
    }

    public void b(er erVar) throws Throwable {
        String strM388a = erVar.m388a();
        if (erVar.a() == 0) {
            if ("PING".equals(strM388a)) {
                byte[] bArrM392a = erVar.m392a();
                if (bArrM392a != null && bArrM392a.length > 0) {
                    dp.j jVarA = dp.j.a(bArrM392a);
                    if (jVarA.m346b()) {
                        ax.a().a(jVarA.m344a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                    this.a.m660a();
                }
                if ("1".equals(erVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("received a server ping");
                } else {
                    ep.b();
                }
                this.a.m664b();
                return;
            }
            if (!"SYNC".equals(strM388a)) {
                if ("NOTIFY".equals(erVar.m388a())) {
                    dp.h hVarA = dp.h.a(erVar.m392a());
                    com.xiaomi.channel.commonutils.logger.b.m48a("notify by server err = " + hVarA.c() + " desc = " + hVarA.m338a());
                    return;
                }
                return;
            }
            if ("CONF".equals(erVar.m395b())) {
                ax.a().a(dp.b.a(erVar.m392a()));
                return;
            }
            if (TextUtils.equals("U", erVar.m395b())) {
                dp.k kVarA = dp.k.a(erVar.m392a());
                db.a(this.a).a(kVarA.m348a(), kVarA.m351b(), new Date(kVarA.m347a()), new Date(kVarA.m350b()), kVarA.c() * 1024, kVarA.e());
                er erVar2 = new er();
                erVar2.a(0);
                erVar2.a(erVar.m388a(), "UCA");
                erVar2.a(erVar.e());
                XMPushService xMPushService = this.a;
                xMPushService.a(new aw(xMPushService, erVar2));
                return;
            }
            if (TextUtils.equals("P", erVar.m395b())) {
                dp.i iVarA = dp.i.a(erVar.m392a());
                er erVar3 = new er();
                erVar3.a(0);
                erVar3.a(erVar.m388a(), "PCA");
                erVar3.a(erVar.e());
                dp.i iVar = new dp.i();
                if (iVarA.m342a()) {
                    iVar.a(iVarA.m341a());
                }
                erVar3.a(iVar.m372a(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new aw(xMPushService2, erVar3));
                com.xiaomi.channel.commonutils.logger.b.m48a("ACK msgP: id = " + erVar.e());
                return;
            }
            return;
        }
        String string = Integer.toString(erVar.a());
        if ("SECMSG".equals(erVar.m388a())) {
            if (!erVar.m391a()) {
                this.a.m663b().a(this.a, string, erVar);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("Recv SECMSG errCode = " + erVar.b() + " errStr = " + erVar.m398c());
            return;
        }
        if (!"BIND".equals(strM388a)) {
            if ("KICK".equals(strM388a)) {
                dp.g gVarA = dp.g.a(erVar.m392a());
                String strG = erVar.g();
                String strM333a = gVarA.m333a();
                String strM335b = gVarA.m335b();
                com.xiaomi.channel.commonutils.logger.b.m48a("kicked by server, chid=" + string + " res= " + am.b.a(strG) + " type=" + strM333a + " reason=" + strM335b);
                if (!"wait".equals(strM333a)) {
                    this.a.a(string, strG, 3, strM335b, strM333a);
                    am.a().m695a(string, strG);
                    return;
                }
                am.b bVarA = am.a().a(string, strG);
                if (bVarA != null) {
                    this.a.a(bVarA);
                    bVarA.a(am.c.unbind, 3, 0, strM335b, strM333a);
                    return;
                }
                return;
            }
            return;
        }
        dp.d dVarA = dp.d.a(erVar.m392a());
        String strG2 = erVar.g();
        am.b bVarA2 = am.a().a(string, strG2);
        if (bVarA2 == null) {
            return;
        }
        if (dVarA.m309a()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("SMACK: channel bind succeeded, chid=" + erVar.a());
            bVarA2.a(am.c.binded, 1, 0, (String) null, (String) null);
            return;
        }
        String strM308a = dVarA.m308a();
        if ("auth".equals(strM308a)) {
            if ("invalid-sig".equals(dVarA.m310b())) {
                com.xiaomi.channel.commonutils.logger.b.m48a("SMACK: bind error invalid-sig token = " + bVarA2.f9358c + " sec = " + bVarA2.f9363h);
                ep.a(0, ei.BIND_INVALID_SIG.a(), 1, null, 0);
            }
            bVarA2.a(am.c.unbind, 1, 5, dVarA.m310b(), strM308a);
            am.a().m695a(string, strG2);
        } else if (CommonNetImpl.CANCEL.equals(strM308a)) {
            bVarA2.a(am.c.unbind, 1, 7, dVarA.m310b(), strM308a);
            am.a().m695a(string, strG2);
        } else if ("wait".equals(strM308a)) {
            this.a.a(bVarA2);
            bVarA2.a(am.c.unbind, 1, 7, dVarA.m310b(), strM308a);
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("SMACK: channel bind failed, chid=" + string + " reason=" + dVarA.m310b());
    }

    public void a(er erVar) {
        if (5 != erVar.a()) {
            c(erVar);
        }
        try {
            b(erVar);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + erVar.a() + " cmd = " + erVar.m388a() + " packetid = " + erVar.e() + " failure ", e2);
        }
    }

    private void a(fl flVar) {
        String strC = flVar.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        String[] strArrSplit = strC.split(";");
        cc ccVarA = cg.a().a(fb.a(), false);
        if (ccVarA == null || strArrSplit.length <= 0) {
            return;
        }
        ccVarA.a(strArrSplit);
        this.a.a(20, (Exception) null);
        this.a.a(true);
    }

    private void b(fo foVar) {
        am.b bVarA;
        String strL = foVar.l();
        String strK = foVar.k();
        if (TextUtils.isEmpty(strL) || TextUtils.isEmpty(strK) || (bVarA = am.a().a(strK, strL)) == null) {
            return;
        }
        fz.a(this.a, bVarA.f998a, fz.a(foVar.mo429a()), true, true, System.currentTimeMillis());
    }
}
