package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableScan.java */
/* renamed from: g.a.y0.e.b.e3 */
/* loaded from: classes2.dex */
public final class C4714e3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4572c<T, T, T> f17860c;

    /* compiled from: FlowableScan.java */
    /* renamed from: g.a.y0.e.b.e3$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f17861a;

        /* renamed from: b */
        final InterfaceC4572c<T, T, T> f17862b;

        /* renamed from: c */
        InterfaceC5823d f17863c;

        /* renamed from: d */
        T f17864d;

        /* renamed from: e */
        boolean f17865e;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4572c<T, T, T> interfaceC4572c) {
            this.f17861a = interfaceC5822c;
            this.f17862b = interfaceC4572c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17863c.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f17865e) {
                return;
            }
            this.f17865e = true;
            this.f17861a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f17865e) {
                C4476a.m17152b(th);
            } else {
                this.f17865e = true;
                this.f17861a.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f17865e) {
                return;
            }
            InterfaceC5822c<? super T> interfaceC5822c = this.f17861a;
            T t2 = this.f17864d;
            if (t2 == null) {
                this.f17864d = t;
                interfaceC5822c.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) C4601b.m18284a((Object) this.f17862b.apply(t2, t), "The value returned by the accumulator is null");
                this.f17864d = r4;
                interfaceC5822c.onNext(r4);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17863c.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17863c, interfaceC5823d)) {
                this.f17863c = interfaceC5823d;
                this.f17861a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f17863c.request(j2);
        }
    }

    public C4714e3(AbstractC4519l<T> abstractC4519l, InterfaceC4572c<T, T, T> interfaceC4572c) {
        super(abstractC4519l);
        this.f17860c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17860c));
    }
}
