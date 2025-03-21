package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableWithLatestFrom.java */
/* renamed from: g.a.y0.e.b.q4 */
/* loaded from: classes2.dex */
public final class C4787q4<T, U, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4572c<? super T, ? super U, ? extends R> f18329c;

    /* renamed from: d */
    final InterfaceC5821b<? extends U> f18330d;

    /* compiled from: FlowableWithLatestFrom.java */
    /* renamed from: g.a.y0.e.b.q4$a */
    final class a implements InterfaceC4529q<U> {

        /* renamed from: a */
        private final b<T, U, R> f18331a;

        a(b<T, U, R> bVar) {
            this.f18331a = bVar;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18331a.otherError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(U u) {
            this.f18331a.lazySet(u);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (this.f18331a.setOther(interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    /* compiled from: FlowableWithLatestFrom.java */
    /* renamed from: g.a.y0.e.b.q4$b */
    static final class b<T, U, R> extends AtomicReference<U> implements InterfaceC4602a<T>, InterfaceC5823d {
        private static final long serialVersionUID = -312246233408980075L;
        final InterfaceC5822c<? super R> actual;
        final InterfaceC4572c<? super T, ? super U, ? extends R> combiner;

        /* renamed from: s */
        final AtomicReference<InterfaceC5823d> f18333s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<InterfaceC5823d> other = new AtomicReference<>();

        b(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
            this.actual = interfaceC5822c;
            this.combiner = interfaceC4572c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this.f18333s);
            EnumC5160j.cancel(this.other);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            EnumC5160j.cancel(this.other);
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            EnumC5160j.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f18333s.get().request(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            EnumC5160j.deferredSetOnce(this.f18333s, this.requested, interfaceC5823d);
        }

        public void otherError(Throwable th) {
            EnumC5160j.cancel(this.f18333s);
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            EnumC5160j.deferredRequest(this.f18333s, this.requested, j2);
        }

        public boolean setOther(InterfaceC5823d interfaceC5823d) {
            return EnumC5160j.setOnce(this.other, interfaceC5823d);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(C4601b.m18284a(this.combiner.apply(t, u), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    cancel();
                    this.actual.onError(th);
                }
            }
            return false;
        }
    }

    public C4787q4(AbstractC4519l<T> abstractC4519l, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, InterfaceC5821b<? extends U> interfaceC5821b) {
        super(abstractC4519l);
        this.f18329c = interfaceC4572c;
        this.f18330d = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        C4509e c4509e = new C4509e(interfaceC5822c);
        b bVar = new b(c4509e, this.f18329c);
        c4509e.onSubscribe(bVar);
        this.f18330d.subscribe(new a(bVar));
        this.f17759b.m17799a((InterfaceC4529q) bVar);
    }
}
