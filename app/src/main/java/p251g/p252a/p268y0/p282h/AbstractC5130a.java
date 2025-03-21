package p251g.p252a.p268y0.p282h;

import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5823d;

/* compiled from: BasicFuseableConditionalSubscriber.java */
/* renamed from: g.a.y0.h.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5130a<T, R> implements InterfaceC4602a<T>, InterfaceC4613l<R> {

    /* renamed from: a */
    protected final InterfaceC4602a<? super R> f19948a;

    /* renamed from: b */
    protected InterfaceC5823d f19949b;

    /* renamed from: c */
    protected InterfaceC4613l<T> f19950c;

    /* renamed from: d */
    protected boolean f19951d;

    /* renamed from: e */
    protected int f19952e;

    public AbstractC5130a(InterfaceC4602a<? super R> interfaceC4602a) {
        this.f19948a = interfaceC4602a;
    }

    /* renamed from: a */
    protected void m18582a() {
    }

    /* renamed from: a */
    protected final void m18583a(Throwable th) {
        C4561b.m18199b(th);
        this.f19949b.cancel();
        onError(th);
    }

    /* renamed from: b */
    protected boolean m18584b() {
        return true;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        this.f19949b.cancel();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public void clear() {
        this.f19950c.clear();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean isEmpty() {
        return this.f19950c.isEmpty();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (this.f19951d) {
            return;
        }
        this.f19951d = true;
        this.f19948a.onComplete();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (this.f19951d) {
            C4476a.m17152b(th);
        } else {
            this.f19951d = true;
            this.f19948a.onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4529q
    public final void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.validate(this.f19949b, interfaceC5823d)) {
            this.f19949b = interfaceC5823d;
            if (interfaceC5823d instanceof InterfaceC4613l) {
                this.f19950c = (InterfaceC4613l) interfaceC5823d;
            }
            if (m18584b()) {
                this.f19948a.onSubscribe(this);
                m18582a();
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        this.f19949b.request(j2);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    /* renamed from: a */
    protected final int m18581a(int i2) {
        InterfaceC4613l<T> interfaceC4613l = this.f19950c;
        if (interfaceC4613l == null || (i2 & 4) != 0) {
            return 0;
        }
        int requestFusion = interfaceC4613l.requestFusion(i2);
        if (requestFusion != 0) {
            this.f19952e = requestFusion;
        }
        return requestFusion;
    }
}
