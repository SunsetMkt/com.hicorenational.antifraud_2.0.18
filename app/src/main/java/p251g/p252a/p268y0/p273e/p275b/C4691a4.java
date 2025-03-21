package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTakeUntilPredicate.java */
/* renamed from: g.a.y0.e.b.a4 */
/* loaded from: classes2.dex */
public final class C4691a4<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4587r<? super T> f17769c;

    /* compiled from: FlowableTakeUntilPredicate.java */
    /* renamed from: g.a.y0.e.b.a4$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f17770a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f17771b;

        /* renamed from: c */
        InterfaceC5823d f17772c;

        /* renamed from: d */
        boolean f17773d;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f17770a = interfaceC5822c;
            this.f17771b = interfaceC4587r;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17772c.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f17773d) {
                return;
            }
            this.f17773d = true;
            this.f17770a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f17773d) {
                C4476a.m17152b(th);
            } else {
                this.f17773d = true;
                this.f17770a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f17773d) {
                return;
            }
            this.f17770a.onNext(t);
            try {
                if (this.f17771b.test(t)) {
                    this.f17773d = true;
                    this.f17772c.cancel();
                    this.f17770a.onComplete();
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17772c.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17772c, interfaceC5823d)) {
                this.f17772c = interfaceC5823d;
                this.f17770a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f17772c.request(j2);
        }
    }

    public C4691a4(AbstractC4519l<T> abstractC4519l, InterfaceC4587r<? super T> interfaceC4587r) {
        super(abstractC4519l);
        this.f17769c = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17769c));
    }
}
