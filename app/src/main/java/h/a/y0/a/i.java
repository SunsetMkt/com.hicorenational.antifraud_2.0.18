package h.a.y0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: ListCompositeDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements h.a.u0.c, c {
    List<h.a.u0.c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f10445b;

    public i() {
    }

    public boolean a(h.a.u0.c... cVarArr) {
        h.a.y0.b.b.a(cVarArr, "ds is null");
        if (!this.f10445b) {
            synchronized (this) {
                if (!this.f10445b) {
                    List linkedList = this.a;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.a = linkedList;
                    }
                    for (h.a.u0.c cVar : cVarArr) {
                        h.a.y0.b.b.a(cVar, "d is null");
                        linkedList.add(cVar);
                    }
                    return true;
                }
            }
        }
        for (h.a.u0.c cVar2 : cVarArr) {
            cVar2.dispose();
        }
        return false;
    }

    @Override // h.a.y0.a.c
    public boolean b(h.a.u0.c cVar) {
        h.a.y0.b.b.a(cVar, "d is null");
        if (!this.f10445b) {
            synchronized (this) {
                if (!this.f10445b) {
                    List linkedList = this.a;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.a = linkedList;
                    }
                    linkedList.add(cVar);
                    return true;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // h.a.y0.a.c
    public boolean c(h.a.u0.c cVar) {
        h.a.y0.b.b.a(cVar, "Disposable item is null");
        if (this.f10445b) {
            return false;
        }
        synchronized (this) {
            if (this.f10445b) {
                return false;
            }
            List<h.a.u0.c> list = this.a;
            if (list != null && list.remove(cVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // h.a.u0.c
    public void dispose() {
        if (this.f10445b) {
            return;
        }
        synchronized (this) {
            if (this.f10445b) {
                return;
            }
            this.f10445b = true;
            List<h.a.u0.c> list = this.a;
            this.a = null;
            a(list);
        }
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f10445b;
    }

    public i(h.a.u0.c... cVarArr) {
        h.a.y0.b.b.a(cVarArr, "resources is null");
        this.a = new LinkedList();
        for (h.a.u0.c cVar : cVarArr) {
            h.a.y0.b.b.a(cVar, "Disposable item is null");
            this.a.add(cVar);
        }
    }

    public i(Iterable<? extends h.a.u0.c> iterable) {
        h.a.y0.b.b.a(iterable, "resources is null");
        this.a = new LinkedList();
        for (h.a.u0.c cVar : iterable) {
            h.a.y0.b.b.a(cVar, "Disposable item is null");
            this.a.add(cVar);
        }
    }

    @Override // h.a.y0.a.c
    public boolean a(h.a.u0.c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    public void a() {
        if (this.f10445b) {
            return;
        }
        synchronized (this) {
            if (this.f10445b) {
                return;
            }
            List<h.a.u0.c> list = this.a;
            this.a = null;
            a(list);
        }
    }

    void a(List<h.a.u0.c> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<h.a.u0.c> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw h.a.y0.j.k.c((Throwable) arrayList.get(0));
            }
            throw new h.a.v0.a(arrayList);
        }
    }
}
