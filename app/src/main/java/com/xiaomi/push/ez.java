package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dp;
import com.xiaomi.push.fa;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ez implements fj {
    public static boolean a = false;

    /* JADX INFO: renamed from: a */
    private fa f488a;

    /* JADX INFO: renamed from: a */
    private SimpleDateFormat f491a = new SimpleDateFormat("hh:mm:ss aaa");

    /* JADX INFO: renamed from: a */
    private a f487a = null;

    /* JADX INFO: renamed from: b */
    private a f8959b = null;

    /* JADX INFO: renamed from: a */
    private fd f489a = null;

    /* JADX INFO: renamed from: a */
    private final String f490a = "[Slim] ";

    public ez(fa faVar) {
        this.f488a = null;
        this.f488a = faVar;
        a();
    }

    /* JADX INFO: renamed from: com.xiaomi.push.ez$1 */
    class AnonymousClass1 implements fd {
        AnonymousClass1() {
        }

        @Override // com.xiaomi.push.fd
        public void a(fa faVar, int i2, Exception exc) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection closed (" + ez.this.f488a.hashCode() + ")");
        }

        @Override // com.xiaomi.push.fd
        public void b(fa faVar) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection reconnected (" + ez.this.f488a.hashCode() + ")");
        }

        @Override // com.xiaomi.push.fd
        public void a(fa faVar, Exception exc) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Reconnection failed due to an exception (" + ez.this.f488a.hashCode() + ")");
            exc.printStackTrace();
        }

        @Override // com.xiaomi.push.fd
        public void a(fa faVar) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection started (" + ez.this.f488a.hashCode() + ")");
        }
    }

    private void a() {
        this.f487a = new a(true);
        this.f8959b = new a(false);
        fa faVar = this.f488a;
        a aVar = this.f487a;
        faVar.a(aVar, aVar);
        fa faVar2 = this.f488a;
        a aVar2 = this.f8959b;
        faVar2.b(aVar2, aVar2);
        this.f489a = new fd() { // from class: com.xiaomi.push.ez.1
            AnonymousClass1() {
            }

            @Override // com.xiaomi.push.fd
            public void a(fa faVar3, int i2, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection closed (" + ez.this.f488a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fd
            public void b(fa faVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection reconnected (" + ez.this.f488a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fd
            public void a(fa faVar3, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Reconnection failed due to an exception (" + ez.this.f488a.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // com.xiaomi.push.fd
            public void a(fa faVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + " Connection started (" + ez.this.f488a.hashCode() + ")");
            }
        };
    }

    class a implements ff, fk {

        /* JADX INFO: renamed from: a */
        String f492a;

        /* JADX INFO: renamed from: a */
        private boolean f493a;

        a(boolean z) {
            this.f493a = true;
            this.f493a = z;
            this.f492a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.ff
        public void a(fo foVar) {
            if (ez.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + this.f492a + " PKT " + foVar.mo429a());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + this.f492a + " PKT [" + foVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + foVar.j() + "]");
        }

        @Override // com.xiaomi.push.fk
        /* JADX INFO: renamed from: a */
        public boolean mo238a(fo foVar) {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0137  */
        @Override // com.xiaomi.push.ff
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(er erVar) {
            er erVar2;
            if (ez.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + this.f492a + erVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f491a.format(new Date()) + this.f492a + " Blob [" + erVar.m388a() + Constants.ACCEPT_TIME_SEPARATOR_SP + erVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.push.service.aj.a(erVar.e()) + "]");
            }
            if (erVar == null || erVar.a() != 99999) {
                return;
            }
            String strM388a = erVar.m388a();
            if (this.f493a) {
                erVar2 = null;
            } else if ("BIND".equals(strM388a)) {
                com.xiaomi.channel.commonutils.logger.b.m48a("build binded result for loopback.");
                dp.d dVar = new dp.d();
                dVar.a(true);
                dVar.c("login success.");
                dVar.b("success");
                dVar.a("success");
                er erVar3 = new er();
                erVar3.a(dVar.m372a(), (String) null);
                erVar3.a((short) 2);
                erVar3.a(99999);
                erVar3.a("BIND", (String) null);
                erVar3.a(erVar.e());
                erVar3.b((String) null);
                erVar3.c(erVar.g());
                erVar2 = erVar3;
            } else if (!"UBND".equals(strM388a) && "SECMSG".equals(strM388a)) {
                erVar2 = new er();
                erVar2.a(99999);
                erVar2.a("SECMSG", (String) null);
                erVar2.c(erVar.g());
                erVar2.a(erVar.e());
                erVar2.a(erVar.m390a());
                erVar2.b(erVar.f());
                erVar2.a(erVar.m393a(com.xiaomi.push.service.am.a().a(String.valueOf(99999), erVar.g()).f9363h), (String) null);
            }
            if (erVar2 != null) {
                for (Map.Entry<ff, fa.a> entry : ez.this.f488a.m413a().entrySet()) {
                    if (ez.this.f487a != entry.getKey()) {
                        entry.getValue().a(erVar2);
                    }
                }
            }
        }
    }
}
