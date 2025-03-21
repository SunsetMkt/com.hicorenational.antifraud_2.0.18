package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.xiaomi.push.ez */
/* loaded from: classes2.dex */
public class C4205ez implements InterfaceC4216fj {

    /* renamed from: a */
    public static boolean f15246a = false;

    /* renamed from: a */
    private AbstractC4207fa f15248a;

    /* renamed from: a */
    private SimpleDateFormat f15251a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a */
    private a f15247a = null;

    /* renamed from: b */
    private a f15252b = null;

    /* renamed from: a */
    private InterfaceC4210fd f15249a = null;

    /* renamed from: a */
    private final String f15250a = "[Slim] ";

    public C4205ez(AbstractC4207fa abstractC4207fa) {
        this.f15248a = null;
        this.f15248a = abstractC4207fa;
        m14753a();
    }

    /* renamed from: a */
    private void m14753a() {
        this.f15247a = new a(true);
        this.f15252b = new a(false);
        AbstractC4207fa abstractC4207fa = this.f15248a;
        a aVar = this.f15247a;
        abstractC4207fa.m14767a(aVar, aVar);
        AbstractC4207fa abstractC4207fa2 = this.f15248a;
        a aVar2 = this.f15252b;
        abstractC4207fa2.m14776b(aVar2, aVar2);
        this.f15249a = new InterfaceC4210fd() { // from class: com.xiaomi.push.ez.1
            @Override // com.xiaomi.push.InterfaceC4210fd
            /* renamed from: a */
            public void mo14174a(AbstractC4207fa abstractC4207fa3, int i2, Exception exc) {
                AbstractC4022b.m13359c("[Slim] " + C4205ez.this.f15251a.format(new Date()) + " Connection closed (" + C4205ez.this.f15248a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.InterfaceC4210fd
            /* renamed from: b */
            public void mo14176b(AbstractC4207fa abstractC4207fa3) {
                AbstractC4022b.m13359c("[Slim] " + C4205ez.this.f15251a.format(new Date()) + " Connection reconnected (" + C4205ez.this.f15248a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.InterfaceC4210fd
            /* renamed from: a */
            public void mo14175a(AbstractC4207fa abstractC4207fa3, Exception exc) {
                AbstractC4022b.m13359c("[Slim] " + C4205ez.this.f15251a.format(new Date()) + " Reconnection failed due to an exception (" + C4205ez.this.f15248a.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // com.xiaomi.push.InterfaceC4210fd
            /* renamed from: a */
            public void mo14173a(AbstractC4207fa abstractC4207fa3) {
                AbstractC4022b.m13359c("[Slim] " + C4205ez.this.f15251a.format(new Date()) + " Connection started (" + C4205ez.this.f15248a.hashCode() + ")");
            }
        };
    }

    /* renamed from: com.xiaomi.push.ez$a */
    class a implements InterfaceC4212ff, InterfaceC4217fk {

        /* renamed from: a */
        String f15255a;

        /* renamed from: a */
        private boolean f15256a;

        a(boolean z) {
            this.f15256a = true;
            this.f15256a = z;
            this.f15255a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.InterfaceC4212ff
        /* renamed from: a */
        public void mo14117a(AbstractC4221fo abstractC4221fo) {
            if (C4205ez.f15246a) {
                AbstractC4022b.m13359c("[Slim] " + C4205ez.this.f15251a.format(new Date()) + this.f15255a + " PKT " + abstractC4221fo.mo14829a());
                return;
            }
            AbstractC4022b.m13359c("[Slim] " + C4205ez.this.f15251a.format(new Date()) + this.f15255a + " PKT [" + abstractC4221fo.m14865k() + Constants.ACCEPT_TIME_SEPARATOR_SP + abstractC4221fo.m14864j() + "]");
        }

        @Override // com.xiaomi.push.InterfaceC4217fk
        /* renamed from: a */
        public boolean mo14118a(AbstractC4221fo abstractC4221fo) {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // com.xiaomi.push.InterfaceC4212ff
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo14116a(com.xiaomi.push.C4197er r6) {
            /*
                Method dump skipped, instructions count: 367
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C4205ez.a.mo14116a(com.xiaomi.push.er):void");
        }
    }
}
