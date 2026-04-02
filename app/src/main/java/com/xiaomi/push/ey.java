package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.dp;
import com.xiaomi.push.fa;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ey extends fh {
    private et a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private eu f484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Thread f485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f486a;

    public ey(XMPushService xMPushService, fb fbVar) {
        super(xMPushService, fbVar);
    }

    private void h() throws fi {
        try {
            this.a = new et(((fh) this).f514a.getInputStream(), this);
            this.f484a = new eu(((fh) this).f514a.getOutputStream(), this);
            this.f485a = new Thread("Blob Reader (" + ((fa) this).f8963b + ")") { // from class: com.xiaomi.push.ey.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ey.this.a.m400a();
                    } catch (Exception e2) {
                        ey.this.c(9, e2);
                    }
                }
            };
            this.f485a.start();
        } catch (Exception e2) {
            throw new fi("Error to init reader and writer", e2);
        }
    }

    @Override // com.xiaomi.push.fa
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo405a() {
        return true;
    }

    void b(fo foVar) {
        if (foVar == null) {
            return;
        }
        Iterator<fa.a> it = ((fa) this).f503a.values().iterator();
        while (it.hasNext()) {
            it.next().a(foVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    synchronized byte[] m406a() {
        if (this.f486a == null && !TextUtils.isEmpty(((fa) this).f500a)) {
            String strM703a = com.xiaomi.push.service.ax.m703a();
            this.f486a = com.xiaomi.push.service.ar.a(((fa) this).f500a.getBytes(), (((fa) this).f500a.substring(((fa) this).f500a.length() / 2) + strM703a.substring(strM703a.length() / 2)).getBytes());
        }
        return this.f486a;
    }

    @Override // com.xiaomi.push.fa
    public void b(er erVar) throws fi {
        eu euVar = this.f484a;
        if (euVar != null) {
            try {
                int iA = euVar.a(erVar);
                ((fa) this).f8965d = SystemClock.elapsedRealtime();
                String strF = erVar.f();
                if (!TextUtils.isEmpty(strF)) {
                    fz.a(((fa) this).f499a, strF, iA, false, true, System.currentTimeMillis());
                }
                Iterator<fa.a> it = ((fa) this).f506b.values().iterator();
                while (it.hasNext()) {
                    it.next().a(erVar);
                }
                return;
            } catch (Exception e2) {
                throw new fi(e2);
            }
        }
        throw new fi("the writer is null.");
    }

    private er a(boolean z) {
        ex exVar = new ex();
        if (z) {
            exVar.a("1");
        }
        byte[] bArrM386a = ep.m386a();
        if (bArrM386a != null) {
            dp.j jVar = new dp.j();
            jVar.a(a.a(bArrM386a));
            exVar.a(jVar.m372a(), (String) null);
        }
        return exVar;
    }

    @Override // com.xiaomi.push.fh
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected void mo404a(boolean z) throws fi {
        if (this.f484a != null) {
            er erVarA = a(z);
            com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] SND ping id=" + erVarA.e());
            b(erVarA);
            f();
            return;
        }
        throw new fi("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.fa
    public synchronized void a(am.b bVar) {
        eq.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fa
    public synchronized void a(String str, String str2) {
        eq.a(str, str2, this);
    }

    @Override // com.xiaomi.push.fh
    protected synchronized void a(int i2, Exception exc) {
        if (this.a != null) {
            this.a.b();
            this.a = null;
        }
        if (this.f484a != null) {
            try {
                this.f484a.b();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("SlimConnection shutdown cause exception: " + e2);
            }
            this.f484a = null;
            this.f486a = null;
            super.a(i2, exc);
        } else {
            this.f486a = null;
            super.a(i2, exc);
        }
    }

    @Override // com.xiaomi.push.fh, com.xiaomi.push.fa
    public void a(er[] erVarArr) throws fi {
        for (er erVar : erVarArr) {
            b(erVar);
        }
    }

    @Override // com.xiaomi.push.fa
    @Deprecated
    public void a(fo foVar) throws fi {
        b(er.a(foVar, (String) null));
    }

    @Override // com.xiaomi.push.fh
    /* JADX INFO: renamed from: a */
    protected synchronized void mo424a() {
        h();
        this.f484a.a();
    }

    void a(er erVar) {
        if (erVar == null) {
            return;
        }
        if (com.xiaomi.push.service.e.a(erVar)) {
            er erVar2 = new er();
            erVar2.a(erVar.a());
            erVar2.a("SYNC", "ACK_RTT");
            erVar2.a(erVar.e());
            erVar2.b(erVar.m394b());
            erVar2.a(erVar.m397c());
            XMPushService xMPushService = ((fa) this).f499a;
            xMPushService.a(new com.xiaomi.push.service.aw(xMPushService, erVar2));
        }
        if (erVar.m391a()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] RCV blob chid=" + erVar.a() + "; id=" + erVar.e() + "; errCode=" + erVar.b() + "; err=" + erVar.m398c());
        }
        if (erVar.a() == 0) {
            if ("PING".equals(erVar.m388a())) {
                com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] RCV ping id=" + erVar.e());
                g();
            } else if ("CLOSE".equals(erVar.m388a())) {
                c(13, null);
            }
        }
        Iterator<fa.a> it = ((fa) this).f503a.values().iterator();
        while (it.hasNext()) {
            it.next().a(erVar);
        }
    }
}
