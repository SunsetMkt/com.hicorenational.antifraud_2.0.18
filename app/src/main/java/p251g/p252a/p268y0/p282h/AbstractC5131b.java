package p251g.p252a.p268y0.p282h;

import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: BasicFuseableSubscriber.java */
/* renamed from: g.a.y0.h.b */
/* loaded from: classes2.dex */
public abstract class AbstractC5131b<T, R> implements InterfaceC4529q<T>, InterfaceC4613l<R> {

    /* renamed from: a */
    protected final InterfaceC5822c<? super R> f19953a;

    /* renamed from: b */
    protected InterfaceC5823d f19954b;

    /* renamed from: c */
    protected InterfaceC4613l<T> f19955c;

    /* renamed from: d */
    protected boolean f19956d;

    /* renamed from: e */
    protected int f19957e;

    public AbstractC5131b(InterfaceC5822c<? super R> interfaceC5822c) {
        this.f19953a = interfaceC5822c;
    }

    /* renamed from: a */
    protected void m18586a() {
    }

    /* renamed from: a */
    protected final void m18587a(Throwable th) {
        C4561b.m18199b(th);
        this.f19954b.cancel();
        onError(th);
    }

    /* renamed from: b */
    protected boolean m18588b() {
        return true;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        this.f19954b.cancel();
    }

    public void clear() {
        this.f19955c.clear();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean isEmpty() {
        return this.f19955c.isEmpty();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (this.f19956d) {
            return;
        }
        this.f19956d = true;
        this.f19953a.onComplete();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (this.f19956d) {
            C4476a.m17152b(th);
        } else {
            this.f19956d = true;
            this.f19953a.onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4529q
    public final void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.validate(this.f19954b, interfaceC5823d)) {
            this.f19954b = interfaceC5823d;
            if (interfaceC5823d instanceof InterfaceC4613l) {
                this.f19955c = (InterfaceC4613l) interfaceC5823d;
            }
            if (m18588b()) {
                this.f19953a.onSubscribe(this);
                m18586a();
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        this.f19954b.request(j2);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    /* renamed from: a */
    protected final int m18585a(int i2) {
        InterfaceC4613l<T> interfaceC4613l = this.f19955c;
        if (interfaceC4613l == null || (i2 & 4) != 0) {
            return 0;
        }
        int requestFusion = interfaceC4613l.requestFusion(i2);
        if (requestFusion != 0) {
            this.f19957e = requestFusion;
        }
        return requestFusion;
    }
}
