package com.xiaomi.push;

import com.xiaomi.push.em;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;

/* JADX INFO: loaded from: classes2.dex */
class el implements am.b.a {
    private int a;

    /* JADX INFO: renamed from: a */
    private fa f444a;

    /* JADX INFO: renamed from: a */
    private XMPushService f445a;

    /* JADX INFO: renamed from: a */
    private am.b f446a;

    /* JADX INFO: renamed from: a */
    private boolean f448a = false;

    /* JADX INFO: renamed from: a */
    private am.c f447a = am.c.binding;

    /* JADX INFO: renamed from: com.xiaomi.push.el$1 */
    class AnonymousClass1 extends XMPushService.j {
        AnonymousClass1(int i2) {
            super(i2);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Handling bind stats";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            el.this.c();
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.el$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[am.c.values().length];

        static {
            try {
                a[am.c.unbind.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[am.c.binding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[am.c.binded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    el(XMPushService xMPushService, am.b bVar) {
        this.f445a = xMPushService;
        this.f446a = bVar;
    }

    private void b() {
        this.f446a.b(this);
    }

    public void c() {
        b();
        if (this.f448a && this.a != 11) {
            ej ejVarM382a = eo.m380a().m382a();
            int i2 = AnonymousClass2.a[this.f447a.ordinal()];
            if (i2 == 1) {
                int i3 = this.a;
                if (i3 == 17) {
                    ejVarM382a.f430a = ei.BIND_TCP_READ_TIMEOUT.a();
                } else if (i3 == 21) {
                    ejVarM382a.f430a = ei.BIND_TIMEOUT.a();
                } else {
                    try {
                        em.a aVarC = em.c(eo.a().a());
                        ejVarM382a.f430a = aVarC.a.a();
                        ejVarM382a.c(aVarC.f449a);
                    } catch (NullPointerException unused) {
                        ejVarM382a = null;
                    }
                }
            } else if (i2 != 2 && i2 == 3) {
                ejVarM382a.f430a = ei.BIND_SUCCESS.a();
            }
            if (ejVarM382a != null) {
                ejVarM382a.b(this.f444a.mo412a());
                ejVarM382a.d(this.f446a.f1001b);
                ejVarM382a.f433b = 1;
                try {
                    ejVarM382a.a((byte) Integer.parseInt(this.f446a.f9362g));
                } catch (NumberFormatException unused2) {
                }
                eo.m380a().a(ejVarM382a);
            }
        }
    }

    void a() {
        this.f446a.a(this);
        this.f444a = this.f445a.m658a();
    }

    @Override // com.xiaomi.push.service.am.b.a
    public void a(am.c cVar, am.c cVar2, int i2) {
        if (!this.f448a && cVar == am.c.binding) {
            this.f447a = cVar2;
            this.a = i2;
            this.f448a = true;
        }
        this.f445a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.el.1
            AnonymousClass1(int i22) {
                super(i22);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Handling bind stats";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                el.this.c();
            }
        });
    }
}
