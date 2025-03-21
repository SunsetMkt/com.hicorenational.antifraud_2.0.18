package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSkipWhile.java */
/* renamed from: g.a.y0.e.b.q3 */
/* loaded from: classes2.dex */
public final class C4786q3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4587r<? super T> f18324c;

    /* compiled from: FlowableSkipWhile.java */
    /* renamed from: g.a.y0.e.b.q3$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f18325a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f18326b;

        /* renamed from: c */
        InterfaceC5823d f18327c;

        /* renamed from: d */
        boolean f18328d;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f18325a = interfaceC5822c;
            this.f18326b = interfaceC4587r;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18327c.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18325a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18325a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18328d) {
                this.f18325a.onNext(t);
                return;
            }
            try {
                if (this.f18326b.test(t)) {
                    this.f18327c.request(1L);
                } else {
                    this.f18328d = true;
                    this.f18325a.onNext(t);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18327c.cancel();
                this.f18325a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18327c, interfaceC5823d)) {
                this.f18327c = interfaceC5823d;
                this.f18325a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f18327c.request(j2);
        }
    }

    public C4786q3(AbstractC4519l<T> abstractC4519l, InterfaceC4587r<? super T> interfaceC4587r) {
        super(abstractC4519l);
        this.f18324c = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18324c));
    }
}
