package com.xiaomi.push;

import com.xiaomi.push.C4192em;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.el */
/* loaded from: classes2.dex */
class C4191el implements C4361am.b.a {

    /* renamed from: a */
    private int f15175a;

    /* renamed from: a */
    private AbstractC4207fa f15176a;

    /* renamed from: a */
    private XMPushService f15177a;

    /* renamed from: a */
    private C4361am.b f15178a;

    /* renamed from: a */
    private boolean f15180a = false;

    /* renamed from: a */
    private C4361am.c f15179a = C4361am.c.binding;

    /* renamed from: com.xiaomi.push.el$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f15182a = new int[C4361am.c.values().length];

        static {
            try {
                f15182a[C4361am.c.unbind.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15182a[C4361am.c.binding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15182a[C4361am.c.binded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    C4191el(XMPushService xMPushService, C4361am.b bVar) {
        this.f15177a = xMPushService;
        this.f15178a = bVar;
    }

    /* renamed from: b */
    private void m14639b() {
        this.f15178a.m15980b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m14640c() {
        m14639b();
        if (this.f15180a && this.f15175a != 11) {
            C4189ej m14659a = C4194eo.m14657a().m14659a();
            int i2 = AnonymousClass2.f15182a[this.f15179a.ordinal()];
            if (i2 == 1) {
                int i3 = this.f15175a;
                if (i3 == 17) {
                    m14659a.f15158a = EnumC4188ei.BIND_TCP_READ_TIMEOUT.m14600a();
                } else if (i3 == 21) {
                    m14659a.f15158a = EnumC4188ei.BIND_TIMEOUT.m14600a();
                } else {
                    try {
                        C4192em.a m14648c = C4192em.m14648c(C4194eo.m14656a().m14652a());
                        m14659a.f15158a = m14648c.f15183a.m14600a();
                        m14659a.m14616c(m14648c.f15184a);
                    } catch (NullPointerException unused) {
                        m14659a = null;
                    }
                }
            } else if (i2 != 2 && i2 == 3) {
                m14659a.f15158a = EnumC4188ei.BIND_SUCCESS.m14600a();
            }
            if (m14659a != null) {
                m14659a.m14611b(this.f15176a.mo14762a());
                m14659a.m14620d(this.f15178a.f16557b);
                m14659a.f15161b = 1;
                try {
                    m14659a.m14602a((byte) Integer.parseInt(this.f15178a.f16563g));
                } catch (NumberFormatException unused2) {
                }
                C4194eo.m14657a().m14662a(m14659a);
            }
        }
    }

    /* renamed from: a */
    void m14641a() {
        this.f15178a.m15978a(this);
        this.f15176a = this.f15177a.m15791a();
    }

    @Override // com.xiaomi.push.service.C4361am.b.a
    /* renamed from: a */
    public void mo14642a(C4361am.c cVar, C4361am.c cVar2, int i2) {
        if (!this.f15180a && cVar == C4361am.c.binding) {
            this.f15179a = cVar2;
            this.f15175a = i2;
            this.f15180a = true;
        }
        this.f15177a.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.el.1
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "Handling bind stats";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                C4191el.this.m14640c();
            }
        });
    }
}
