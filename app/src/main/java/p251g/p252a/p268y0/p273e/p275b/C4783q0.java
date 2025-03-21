package p251g.p252a.p268y0.p273e.p275b;

import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableElementAt.java */
/* renamed from: g.a.y0.e.b.q0 */
/* loaded from: classes2.dex */
public final class C4783q0<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f18309c;

    /* renamed from: d */
    final T f18310d;

    /* renamed from: e */
    final boolean f18311e;

    /* compiled from: FlowableElementAt.java */
    /* renamed from: g.a.y0.e.b.q0$a */
    static final class a<T> extends C5156f<T> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;

        /* renamed from: s */
        InterfaceC5823d f18312s;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2, T t, boolean z) {
            super(interfaceC5822c);
            this.index = j2;
            this.defaultValue = t;
            this.errorOnFewer = z;
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f18312s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t = this.defaultValue;
            if (t != null) {
                complete(t);
            } else if (this.errorOnFewer) {
                this.actual.onError(new NoSuchElementException());
            } else {
                this.actual.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.count;
            if (j2 != this.index) {
                this.count = j2 + 1;
                return;
            }
            this.done = true;
            this.f18312s.cancel();
            complete(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18312s, interfaceC5823d)) {
                this.f18312s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4783q0(AbstractC4519l<T> abstractC4519l, long j2, T t, boolean z) {
        super(abstractC4519l);
        this.f18309c = j2;
        this.f18310d = t;
        this.f18311e = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18309c, this.f18310d, this.f18311e));
    }
}
