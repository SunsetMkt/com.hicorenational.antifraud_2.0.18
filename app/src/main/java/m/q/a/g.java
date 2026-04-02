package m.q.a;

import h.a.b0;
import h.a.j0;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: RxJava2CallAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
final class g<R> implements m.c<R, Object> {
    private final Type a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private final j0 f12797b;

    /* JADX INFO: renamed from: c */
    private final boolean f12798c;

    /* JADX INFO: renamed from: d */
    private final boolean f12799d;

    /* JADX INFO: renamed from: e */
    private final boolean f12800e;

    /* JADX INFO: renamed from: f */
    private final boolean f12801f;

    /* JADX INFO: renamed from: g */
    private final boolean f12802g;

    /* JADX INFO: renamed from: h */
    private final boolean f12803h;

    /* JADX INFO: renamed from: i */
    private final boolean f12804i;

    g(Type type, @Nullable j0 j0Var, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = type;
        this.f12797b = j0Var;
        this.f12798c = z;
        this.f12799d = z2;
        this.f12800e = z3;
        this.f12801f = z4;
        this.f12802g = z5;
        this.f12803h = z6;
        this.f12804i = z7;
    }

    @Override // m.c
    public Type a() {
        return this.a;
    }

    @Override // m.c
    public Object a(m.b<R> bVar) {
        b0 bVar2 = this.f12798c ? new b(bVar) : new c(bVar);
        b0 fVar = this.f12799d ? new f(bVar2) : this.f12800e ? new a(bVar2) : bVar2;
        j0 j0Var = this.f12797b;
        if (j0Var != null) {
            fVar = fVar.c(j0Var);
        }
        return this.f12801f ? fVar.a(h.a.b.LATEST) : this.f12802g ? fVar.C() : this.f12803h ? fVar.B() : this.f12804i ? fVar.p() : fVar;
    }
}
