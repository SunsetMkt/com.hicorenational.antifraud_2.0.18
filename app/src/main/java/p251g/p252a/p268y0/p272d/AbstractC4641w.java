package p251g.p252a.p268y0.p272d;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p284j.C5182v;
import p251g.p252a.p268y0.p284j.InterfaceC5178r;

/* compiled from: QueueDrainObserver.java */
/* renamed from: g.a.y0.d.w */
/* loaded from: classes2.dex */
public abstract class AbstractC4641w<T, U, V> extends C4643y implements InterfaceC4514i0<T>, InterfaceC5178r<U, V> {

    /* renamed from: F */
    protected final InterfaceC4514i0<? super V> f17591F;

    /* renamed from: G */
    protected final InterfaceC4615n<U> f17592G;

    /* renamed from: H */
    protected volatile boolean f17593H;

    /* renamed from: I */
    protected volatile boolean f17594I;

    /* renamed from: J */
    protected Throwable f17595J;

    public AbstractC4641w(InterfaceC4514i0<? super V> interfaceC4514i0, InterfaceC4615n<U> interfaceC4615n) {
        this.f17591F = interfaceC4514i0;
        this.f17592G = interfaceC4615n;
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5178r
    /* renamed from: a */
    public void mo18302a(InterfaceC4514i0<? super V> interfaceC4514i0, U u) {
    }

    /* renamed from: a */
    protected final void m18303a(U u, boolean z, InterfaceC4552c interfaceC4552c) {
        InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
        InterfaceC4615n<U> interfaceC4615n = this.f17592G;
        if (this.f17626p.get() == 0 && this.f17626p.compareAndSet(0, 1)) {
            mo18302a(interfaceC4514i0, u);
            if (mo18300a(-1) == 0) {
                return;
            }
        } else {
            interfaceC4615n.offer(u);
            if (!mo18305b()) {
                return;
            }
        }
        C5182v.m18647a(interfaceC4615n, interfaceC4514i0, z, interfaceC4552c, this);
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5178r
    /* renamed from: b */
    public final boolean mo18305b() {
        return this.f17626p.getAndIncrement() == 0;
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5178r
    /* renamed from: c */
    public final boolean mo18306c() {
        return this.f17594I;
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5178r
    /* renamed from: d */
    public final boolean mo18307d() {
        return this.f17593H;
    }

    /* renamed from: e */
    public final boolean m18308e() {
        return this.f17626p.get() == 0 && this.f17626p.compareAndSet(0, 1);
    }

    /* renamed from: b */
    protected final void m18304b(U u, boolean z, InterfaceC4552c interfaceC4552c) {
        InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
        InterfaceC4615n<U> interfaceC4615n = this.f17592G;
        if (this.f17626p.get() != 0 || !this.f17626p.compareAndSet(0, 1)) {
            interfaceC4615n.offer(u);
            if (!mo18305b()) {
                return;
            }
        } else if (interfaceC4615n.isEmpty()) {
            mo18302a(interfaceC4514i0, u);
            if (mo18300a(-1) == 0) {
                return;
            }
        } else {
            interfaceC4615n.offer(u);
        }
        C5182v.m18647a(interfaceC4615n, interfaceC4514i0, z, interfaceC4552c, this);
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5178r
    /* renamed from: a */
    public final Throwable mo18301a() {
        return this.f17595J;
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5178r
    /* renamed from: a */
    public final int mo18300a(int i2) {
        return this.f17626p.addAndGet(i2);
    }
}
