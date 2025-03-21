package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5172l;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTakeUntil.java */
/* renamed from: g.a.y0.e.b.z3 */
/* loaded from: classes2.dex */
public final class C4835z3<T, U> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC5821b<? extends U> f18546c;

    /* compiled from: FlowableTakeUntil.java */
    /* renamed from: g.a.y0.e.b.z3$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -4945480365982832967L;
        final InterfaceC5822c<? super T> actual;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s */
        final AtomicReference<InterfaceC5823d> f18547s = new AtomicReference<>();
        final a<T>.C7400a other = new C7400a();
        final C5163c error = new C5163c();

        /* compiled from: FlowableTakeUntil.java */
        /* renamed from: g.a.y0.e.b.z3$a$a, reason: collision with other inner class name */
        final class C7400a extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            C7400a() {
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onComplete() {
                EnumC5160j.cancel(a.this.f18547s);
                a aVar = a.this;
                C5172l.m18632a(aVar.actual, aVar, aVar.error);
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onError(Throwable th) {
                EnumC5160j.cancel(a.this.f18547s);
                a aVar = a.this;
                C5172l.m18631a((InterfaceC5822c<?>) aVar.actual, th, (AtomicInteger) aVar, aVar.error);
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onNext(Object obj) {
                EnumC5160j.cancel(this);
                onComplete();
            }

            @Override // p251g.p252a.InterfaceC4529q
            public void onSubscribe(InterfaceC5823d interfaceC5823d) {
                if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                    interfaceC5823d.request(C5556m0.f20396b);
                }
            }
        }

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            this.actual = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this.f18547s);
            EnumC5160j.cancel(this.other);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            EnumC5160j.cancel(this.other);
            C5172l.m18632a(this.actual, this, this.error);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            EnumC5160j.cancel(this.other);
            C5172l.m18631a((InterfaceC5822c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            C5172l.m18630a(this.actual, t, this, this.error);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            EnumC5160j.deferredSetOnce(this.f18547s, this.requested, interfaceC5823d);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            EnumC5160j.deferredRequest(this.f18547s, this.requested, j2);
        }
    }

    public C4835z3(AbstractC4519l<T> abstractC4519l, InterfaceC5821b<? extends U> interfaceC5821b) {
        super(abstractC4519l);
        this.f18546c = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        a aVar = new a(interfaceC5822c);
        interfaceC5822c.onSubscribe(aVar);
        this.f18546c.subscribe(aVar.other);
        this.f17759b.m17799a((InterfaceC4529q) aVar);
    }
}
