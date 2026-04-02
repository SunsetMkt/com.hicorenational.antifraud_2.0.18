package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableLift.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.h f10558b;

    public x(h.a.i iVar, h.a.h hVar) {
        this.a = iVar;
        this.f10558b = hVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        try {
            this.a.a(this.f10558b.a(fVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
    }
}
