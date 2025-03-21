package p251g.p252a.p268y0.p272d;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;

/* compiled from: BasicFuseableObserver.java */
/* renamed from: g.a.y0.d.a */
/* loaded from: classes2.dex */
public abstract class AbstractC4617a<T, R> implements InterfaceC4514i0<T>, InterfaceC4611j<R> {

    /* renamed from: a */
    protected final InterfaceC4514i0<? super R> f17561a;

    /* renamed from: b */
    protected InterfaceC4552c f17562b;

    /* renamed from: c */
    protected InterfaceC4611j<T> f17563c;

    /* renamed from: d */
    protected boolean f17564d;

    /* renamed from: e */
    protected int f17565e;

    public AbstractC4617a(InterfaceC4514i0<? super R> interfaceC4514i0) {
        this.f17561a = interfaceC4514i0;
    }

    /* renamed from: a */
    protected void m18290a() {
    }

    /* renamed from: a */
    protected final void m18291a(Throwable th) {
        C4561b.m18199b(th);
        this.f17562b.dispose();
        onError(th);
    }

    /* renamed from: b */
    protected boolean m18292b() {
        return true;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public void clear() {
        this.f17563c.clear();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        this.f17562b.dispose();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f17562b.isDisposed();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean isEmpty() {
        return this.f17563c.isEmpty();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.f17564d) {
            return;
        }
        this.f17564d = true;
        this.f17561a.onComplete();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (this.f17564d) {
            C4476a.m17152b(th);
        } else {
            this.f17564d = true;
            this.f17561a.onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.validate(this.f17562b, interfaceC4552c)) {
            this.f17562b = interfaceC4552c;
            if (interfaceC4552c instanceof InterfaceC4611j) {
                this.f17563c = (InterfaceC4611j) interfaceC4552c;
            }
            if (m18292b()) {
                this.f17561a.onSubscribe(this);
                m18290a();
            }
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    /* renamed from: a */
    protected final int m18289a(int i2) {
        InterfaceC4611j<T> interfaceC4611j = this.f17563c;
        if (interfaceC4611j == null || (i2 & 4) != 0) {
            return 0;
        }
        int requestFusion = interfaceC4611j.requestFusion(i2);
        if (requestFusion != 0) {
            this.f17565e = requestFusion;
        }
        return requestFusion;
    }
}
