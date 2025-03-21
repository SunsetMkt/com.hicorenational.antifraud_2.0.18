package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5163c;

/* compiled from: ObservableSwitchMap.java */
/* renamed from: g.a.y0.e.d.h3 */
/* loaded from: classes2.dex */
public final class C4953h3<T, R> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> f19044b;

    /* renamed from: c */
    final int f19045c;

    /* renamed from: d */
    final boolean f19046d;

    /* compiled from: ObservableSwitchMap.java */
    /* renamed from: g.a.y0.e.d.h3$a */
    static final class a<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        volatile boolean done;
        final long index;
        final b<T, R> parent;
        final C5111c<R> queue;

        a(b<T, R> bVar, long j2, int i2) {
            this.parent = bVar;
            this.index = j2;
            this.queue = new C5111c<>(i2);
        }

        public void cancel() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                this.queue.offer(r);
                this.parent.drain();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    /* compiled from: ObservableSwitchMap.java */
    /* renamed from: g.a.y0.e.d.h3$b */
    static final class b<T, R> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        static final a<Object, Object> CANCELLED = new a<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final InterfaceC4514i0<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> mapper;

        /* renamed from: s */
        InterfaceC4552c f19047s;
        volatile long unique;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final C5163c errors = new C5163c();

        static {
            CANCELLED.cancel();
        }

        b(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2, boolean z) {
            this.actual = interfaceC4514i0;
            this.mapper = interfaceC4584o;
            this.bufferSize = i2;
            this.delayErrors = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f19047s.dispose();
            disposeInner();
        }

        void disposeInner() {
            a<Object, Object> aVar;
            a<T, R> aVar2 = this.active.get();
            a<Object, Object> aVar3 = CANCELLED;
            if (aVar2 == aVar3 || (aVar = (a) this.active.getAndSet(aVar3)) == CANCELLED || aVar == null) {
                return;
            }
            aVar.cancel();
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x00d6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x000b A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p277d.C4953h3.b.drain():void");
        }

        void innerError(a<T, R> aVar, Throwable th) {
            if (aVar.index != this.unique || !this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (!this.delayErrors) {
                this.f19047s.dispose();
            }
            aVar.done = true;
            drain();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (!this.done && this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                if (!this.delayErrors) {
                    disposeInner();
                }
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            a<T, R> aVar;
            long j2 = this.unique + 1;
            this.unique = j2;
            a<T, R> aVar2 = this.active.get();
            if (aVar2 != null) {
                aVar2.cancel();
            }
            try {
                InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.mapper.apply(t), "The ObservableSource returned is null");
                a<T, R> aVar3 = new a<>(this, j2, this.bufferSize);
                do {
                    aVar = this.active.get();
                    if (aVar == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(aVar, aVar3));
                interfaceC4504g0.subscribe(aVar3);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19047s.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19047s, interfaceC4552c)) {
                this.f19047s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4953h3(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2, boolean z) {
        super(interfaceC4504g0);
        this.f19044b = interfaceC4584o;
        this.f19045c = i2;
        this.f19046d = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        if (C5008s2.m18520a(this.f18742a, interfaceC4514i0, this.f19044b)) {
            return;
        }
        this.f18742a.subscribe(new b(interfaceC4514i0, this.f19044b, this.f19045c, this.f19046d));
    }
}
