package h.a.u0;

import h.a.y0.j.k;
import h.a.y0.j.s;
import java.util.ArrayList;

/* JADX INFO: compiled from: CompositeDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c, h.a.y0.a.c {
    s<c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f10430b;

    public b() {
    }

    public boolean a(@h.a.t0.f c... cVarArr) {
        h.a.y0.b.b.a(cVarArr, "ds is null");
        if (!this.f10430b) {
            synchronized (this) {
                if (!this.f10430b) {
                    s<c> sVar = this.a;
                    if (sVar == null) {
                        sVar = new s<>(cVarArr.length + 1);
                        this.a = sVar;
                    }
                    for (c cVar : cVarArr) {
                        h.a.y0.b.b.a(cVar, "d is null");
                        sVar.a(cVar);
                    }
                    return true;
                }
            }
        }
        for (c cVar2 : cVarArr) {
            cVar2.dispose();
        }
        return false;
    }

    @Override // h.a.y0.a.c
    public boolean b(@h.a.t0.f c cVar) {
        h.a.y0.b.b.a(cVar, "d is null");
        if (!this.f10430b) {
            synchronized (this) {
                if (!this.f10430b) {
                    s<c> sVar = this.a;
                    if (sVar == null) {
                        sVar = new s<>();
                        this.a = sVar;
                    }
                    sVar.a(cVar);
                    return true;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // h.a.y0.a.c
    public boolean c(@h.a.t0.f c cVar) {
        h.a.y0.b.b.a(cVar, "Disposable item is null");
        if (this.f10430b) {
            return false;
        }
        synchronized (this) {
            if (this.f10430b) {
                return false;
            }
            s<c> sVar = this.a;
            if (sVar != null && sVar.b(cVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // h.a.u0.c
    public void dispose() {
        if (this.f10430b) {
            return;
        }
        synchronized (this) {
            if (this.f10430b) {
                return;
            }
            this.f10430b = true;
            s<c> sVar = this.a;
            this.a = null;
            a(sVar);
        }
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f10430b;
    }

    public b(@h.a.t0.f c... cVarArr) {
        h.a.y0.b.b.a(cVarArr, "resources is null");
        this.a = new s<>(cVarArr.length + 1);
        for (c cVar : cVarArr) {
            h.a.y0.b.b.a(cVar, "Disposable item is null");
            this.a.a(cVar);
        }
    }

    public b(@h.a.t0.f Iterable<? extends c> iterable) {
        h.a.y0.b.b.a(iterable, "resources is null");
        this.a = new s<>();
        for (c cVar : iterable) {
            h.a.y0.b.b.a(cVar, "Disposable item is null");
            this.a.a(cVar);
        }
    }

    public int b() {
        if (this.f10430b) {
            return 0;
        }
        synchronized (this) {
            if (this.f10430b) {
                return 0;
            }
            s<c> sVar = this.a;
            return sVar != null ? sVar.c() : 0;
        }
    }

    @Override // h.a.y0.a.c
    public boolean a(@h.a.t0.f c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    public void a() {
        if (this.f10430b) {
            return;
        }
        synchronized (this) {
            if (this.f10430b) {
                return;
            }
            s<c> sVar = this.a;
            this.a = null;
            a(sVar);
        }
    }

    void a(s<c> sVar) {
        if (sVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : sVar.a()) {
            if (obj instanceof c) {
                try {
                    ((c) obj).dispose();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw k.c((Throwable) arrayList.get(0));
            }
            throw new h.a.v0.a(arrayList);
        }
    }
}
