package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p258f1.AbstractC4501i;
import p251g.p252a.p258f1.C4497e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5172l;

/* compiled from: ObservableRepeatWhen.java */
/* renamed from: g.a.y0.e.d.l2 */
/* loaded from: classes2.dex */
public final class C4973l2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super AbstractC4469b0<Object>, ? extends InterfaceC4504g0<?>> f19112b;

    /* compiled from: ObservableRepeatWhen.java */
    /* renamed from: g.a.y0.e.d.l2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final InterfaceC4514i0<? super T> actual;
        final AbstractC4501i<Object> signaller;
        final InterfaceC4504g0<T> source;
        final AtomicInteger wip = new AtomicInteger();
        final C5163c error = new C5163c();
        final a<T>.C7414a inner = new C7414a();

        /* renamed from: d */
        final AtomicReference<InterfaceC4552c> f19113d = new AtomicReference<>();

        /* compiled from: ObservableRepeatWhen.java */
        /* renamed from: g.a.y0.e.d.l2$a$a, reason: collision with other inner class name */
        final class C7414a extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            C7414a() {
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onComplete() {
                a.this.innerComplete();
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onError(Throwable th) {
                a.this.innerError(th);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onNext(Object obj) {
                a.this.innerNext();
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this, interfaceC4552c);
            }
        }

        a(InterfaceC4514i0<? super T> interfaceC4514i0, AbstractC4501i<Object> abstractC4501i, InterfaceC4504g0<T> interfaceC4504g0) {
            this.actual = interfaceC4514i0;
            this.signaller = abstractC4501i;
            this.source = interfaceC4504g0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this.f19113d);
            EnumC4592d.dispose(this.inner);
        }

        void innerComplete() {
            EnumC4592d.dispose(this.f19113d);
            C5172l.m18629a(this.actual, this, this.error);
        }

        void innerError(Throwable th) {
            EnumC4592d.dispose(this.f19113d);
            C5172l.m18628a((InterfaceC4514i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext() {
            subscribeNext();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(this.f19113d.get());
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.active = false;
            this.signaller.onNext(0);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            EnumC4592d.dispose(this.inner);
            C5172l.m18628a((InterfaceC4514i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            C5172l.m18627a(this.actual, t, this, this.error);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this.f19113d, interfaceC4552c);
        }

        void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C4973l2(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super AbstractC4469b0<Object>, ? extends InterfaceC4504g0<?>> interfaceC4584o) {
        super(interfaceC4504g0);
        this.f19112b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        AbstractC4501i<T> m17364S = C4497e.m17335T().m17364S();
        try {
            InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f19112b.apply(m17364S), "The handler returned a null ObservableSource");
            a aVar = new a(interfaceC4514i0, m17364S, this.f18742a);
            interfaceC4514i0.onSubscribe(aVar);
            interfaceC4504g0.subscribe(aVar.inner);
            aVar.subscribeNext();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4514i0);
        }
    }
}
