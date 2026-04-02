package i.k2.n.a;

import i.t0;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
public abstract class j extends a {
    public j(@j.c.a.e i.k2.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == i.k2.i.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // i.k2.d
    @j.c.a.d
    public i.k2.g getContext() {
        return i.k2.i.INSTANCE;
    }
}
