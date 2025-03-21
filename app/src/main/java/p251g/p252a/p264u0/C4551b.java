package p251g.p252a.p264u0;

import java.util.ArrayList;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.InterfaceC4591c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.C5179s;

/* compiled from: CompositeDisposable.java */
/* renamed from: g.a.u0.b */
/* loaded from: classes2.dex */
public final class C4551b implements InterfaceC4552c, InterfaceC4591c {

    /* renamed from: a */
    C5179s<InterfaceC4552c> f17467a;

    /* renamed from: b */
    volatile boolean f17468b;

    public C4551b() {
    }

    /* renamed from: a */
    public boolean m18179a(@InterfaceC4546f InterfaceC4552c... interfaceC4552cArr) {
        C4601b.m18284a(interfaceC4552cArr, "ds is null");
        if (!this.f17468b) {
            synchronized (this) {
                if (!this.f17468b) {
                    C5179s<InterfaceC4552c> c5179s = this.f17467a;
                    if (c5179s == null) {
                        c5179s = new C5179s<>(interfaceC4552cArr.length + 1);
                        this.f17467a = c5179s;
                    }
                    for (InterfaceC4552c interfaceC4552c : interfaceC4552cArr) {
                        C4601b.m18284a(interfaceC4552c, "d is null");
                        c5179s.m18639a((C5179s<InterfaceC4552c>) interfaceC4552c);
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
    public boolean mo18181b(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "d is null");
        if (!this.f17468b) {
            synchronized (this) {
                if (!this.f17468b) {
                    C5179s<InterfaceC4552c> c5179s = this.f17467a;
                    if (c5179s == null) {
                        c5179s = new C5179s<>();
                        this.f17467a = c5179s;
                    }
                    c5179s.m18639a((C5179s<InterfaceC4552c>) interfaceC4552c);
                    return true;
                }
            }
        }
        interfaceC4552c.dispose();
        return false;
    }

    @Override // p251g.p252a.p268y0.p269a.InterfaceC4591c
    /* renamed from: c */
    public boolean mo18182c(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "Disposable item is null");
        if (this.f17468b) {
            return false;
        }
        synchronized (this) {
            if (this.f17468b) {
                return false;
            }
            C5179s<InterfaceC4552c> c5179s = this.f17467a;
            if (c5179s != null && c5179s.m18642b(interfaceC4552c)) {
                return true;
            }
            return false;
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        if (this.f17468b) {
            return;
        }
        synchronized (this) {
            if (this.f17468b) {
                return;
            }
            this.f17468b = true;
            C5179s<InterfaceC4552c> c5179s = this.f17467a;
            this.f17467a = null;
            m18177a(c5179s);
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f17468b;
    }

    public C4551b(@InterfaceC4546f InterfaceC4552c... interfaceC4552cArr) {
        C4601b.m18284a(interfaceC4552cArr, "resources is null");
        this.f17467a = new C5179s<>(interfaceC4552cArr.length + 1);
        for (InterfaceC4552c interfaceC4552c : interfaceC4552cArr) {
            C4601b.m18284a(interfaceC4552c, "Disposable item is null");
            this.f17467a.m18639a((C5179s<InterfaceC4552c>) interfaceC4552c);
        }
    }

    public C4551b(@InterfaceC4546f Iterable<? extends InterfaceC4552c> iterable) {
        C4601b.m18284a(iterable, "resources is null");
        this.f17467a = new C5179s<>();
        for (InterfaceC4552c interfaceC4552c : iterable) {
            C4601b.m18284a(interfaceC4552c, "Disposable item is null");
            this.f17467a.m18639a((C5179s<InterfaceC4552c>) interfaceC4552c);
        }
    }

    /* renamed from: b */
    public int m18180b() {
        if (this.f17468b) {
            return 0;
        }
        synchronized (this) {
            if (this.f17468b) {
                return 0;
            }
            C5179s<InterfaceC4552c> c5179s = this.f17467a;
            return c5179s != null ? c5179s.m18643c() : 0;
        }
    }

    @Override // p251g.p252a.p268y0.p269a.InterfaceC4591c
    /* renamed from: a */
    public boolean mo18178a(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (!mo18182c(interfaceC4552c)) {
            return false;
        }
        interfaceC4552c.dispose();
        return true;
    }

    /* renamed from: a */
    public void m18176a() {
        if (this.f17468b) {
            return;
        }
        synchronized (this) {
            if (this.f17468b) {
                return;
            }
            C5179s<InterfaceC4552c> c5179s = this.f17467a;
            this.f17467a = null;
            m18177a(c5179s);
        }
    }

    /* renamed from: a */
    void m18177a(C5179s<InterfaceC4552c> c5179s) {
        if (c5179s == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : c5179s.m18640a()) {
            if (obj instanceof InterfaceC4552c) {
                try {
                    ((InterfaceC4552c) obj).dispose();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
