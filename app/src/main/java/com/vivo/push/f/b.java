package com.vivo.push.f;

/* JADX INFO: compiled from: ChangeNetPermissionTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends com.vivo.push.s {
    b(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.model.b bVarA = com.vivo.push.util.aa.a(this.a, com.vivo.push.restructure.a.a().f());
        try {
            if (((com.vivo.push.b.d) vVar).d() ? j.a(this.a) : j.b(this.a)) {
                com.vivo.push.model.b bVarA2 = com.vivo.push.util.aa.a(this.a, com.vivo.push.restructure.a.a().f());
                if (bVarA == null || bVarA2 == null || bVarA2.a() == null || !bVarA2.a().equals(bVarA.a())) {
                    if (bVarA != null && bVarA.a() != null) {
                        com.vivo.push.a.a.a(this.a, bVarA.a(), new com.vivo.push.b.y(bVarA.a()));
                    }
                    if (bVarA2 == null || bVarA2.a() == null) {
                        return;
                    }
                    com.vivo.push.b.f fVar = new com.vivo.push.b.f();
                    com.vivo.push.restructure.a.a();
                    fVar.d();
                    com.vivo.push.a.a.a(this.a, bVarA2.a(), fVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
