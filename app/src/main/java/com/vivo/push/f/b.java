package com.vivo.push.f;

/* compiled from: ChangeNetPermissionTask.java */
/* loaded from: classes2.dex */
final class b extends com.vivo.push.s {
    b(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.model.b a2 = com.vivo.push.util.aa.a(this.f12207a, com.vivo.push.restructure.a.a().f());
        try {
            if (((com.vivo.push.b.d) vVar).d() ? j.a(this.f12207a) : j.b(this.f12207a)) {
                com.vivo.push.model.b a3 = com.vivo.push.util.aa.a(this.f12207a, com.vivo.push.restructure.a.a().f());
                if (a2 == null || a3 == null || a3.a() == null || !a3.a().equals(a2.a())) {
                    if (a2 != null && a2.a() != null) {
                        com.vivo.push.a.a.a(this.f12207a, a2.a(), new com.vivo.push.b.y(a2.a()));
                    }
                    if (a3 == null || a3.a() == null) {
                        return;
                    }
                    com.vivo.push.b.f fVar = new com.vivo.push.b.f();
                    com.vivo.push.restructure.a.a();
                    fVar.d();
                    com.vivo.push.a.a.a(this.f12207a, a3.a(), fVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
