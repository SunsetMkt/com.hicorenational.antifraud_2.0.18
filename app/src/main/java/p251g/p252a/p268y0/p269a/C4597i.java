package p251g.p252a.p268y0.p269a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: ListCompositeDisposable.java */
/* renamed from: g.a.y0.a.i */
/* loaded from: classes2.dex */
public final class C4597i implements InterfaceC4552c, InterfaceC4591c {

    /* renamed from: a */
    List<InterfaceC4552c> f17506a;

    /* renamed from: b */
    volatile boolean f17507b;

    public C4597i() {
    }

    /* renamed from: a */
    public boolean m18222a(InterfaceC4552c... interfaceC4552cArr) {
        C4601b.m18284a(interfaceC4552cArr, "ds is null");
        if (!this.f17507b) {
            synchronized (this) {
                if (!this.f17507b) {
                    List list = this.f17506a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f17506a = list;
                    }
                    for (InterfaceC4552c interfaceC4552c : interfaceC4552cArr) {
                        C4601b.m18284a(interfaceC4552c, "d is null");
                        list.add(interfaceC4552c);
                    }
                    return true;
                }
            }
        }
        for (InterfaceC4552c interfaceC4552c2 : interfaceC4552cArr) {
            interfaceC4552c2.dispose();
        }
        return false;
    }

    @Override // p251g.p252a.p268y0.p269a.InterfaceC4591c
    /* renamed from: b */
    public boolean mo18181b(InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "d is null");
        if (!this.f17507b) {
            synchronized (this) {
                if (!this.f17507b) {
                    List list = this.f17506a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f17506a = list;
                    }
                    list.add(interfaceC4552c);
                    return true;
                }
            }
        }
        interfaceC4552c.dispose();
        return false;
    }

    @Override // p251g.p252a.p268y0.p269a.InterfaceC4591c
    /* renamed from: c */
    public boolean mo18182c(InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "Disposable item is null");
        if (this.f17507b) {
            return false;
        }
        synchronized (this) {
            if (this.f17507b) {
                return false;
            }
            List<InterfaceC4552c> list = this.f17506a;
            if (list != null && list.remove(interfaceC4552c)) {
                return true;
            }
            return false;
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        if (this.f17507b) {
            return;
        }
        synchronized (this) {
            if (this.f17507b) {
                return;
            }
            this.f17507b = true;
            List<InterfaceC4552c> list = this.f17506a;
            this.f17506a = null;
            m18221a(list);
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f17507b;
    }

    public C4597i(InterfaceC4552c... interfaceC4552cArr) {
        C4601b.m18284a(interfaceC4552cArr, "resources is null");
        this.f17506a = new LinkedList();
        for (InterfaceC4552c interfaceC4552c : interfaceC4552cArr) {
            C4601b.m18284a(interfaceC4552c, "Disposable item is null");
            this.f17506a.add(interfaceC4552c);
        }
    }

    public C4597i(Iterable<? extends InterfaceC4552c> iterable) {
        C4601b.m18284a(iterable, "resources is null");
        this.f17506a = new LinkedList();
        for (InterfaceC4552c interfaceC4552c : iterable) {
            C4601b.m18284a(interfaceC4552c, "Disposable item is null");
            this.f17506a.add(interfaceC4552c);
        }
    }

    @Override // p251g.p252a.p268y0.p269a.InterfaceC4591c
    /* renamed from: a */
    public boolean mo18178a(InterfaceC4552c interfaceC4552c) {
        if (!mo18182c(interfaceC4552c)) {
            return false;
        }
        interfaceC4552c.dispose();
        return true;
    }

    /* renamed from: a */
    public void m18220a() {
        if (this.f17507b) {
            return;
        }
        synchronized (this) {
            if (this.f17507b) {
                return;
            }
            List<InterfaceC4552c> list = this.f17506a;
            this.f17506a = null;
            m18221a(list);
        }
    }

    /* renamed from: a */
    void m18221a(List<InterfaceC4552c> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<InterfaceC4552c> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw C5171k.m18626c((Throwable) arrayList.get(0));
            }
            throw new C4560a(arrayList);
        }
    }
}
