package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p273e.p275b.C4726g3;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p324i.p338d.InterfaceC5821b;

/* compiled from: FlowableSequenceEqualSingle.java */
/* renamed from: g.a.y0.e.b.h3 */
/* loaded from: classes2.dex */
public final class C4732h3<T> extends AbstractC4518k0<Boolean> implements InterfaceC4603b<Boolean> {

    /* renamed from: a */
    final InterfaceC5821b<? extends T> f17943a;

    /* renamed from: b */
    final InterfaceC5821b<? extends T> f17944b;

    /* renamed from: c */
    final InterfaceC4573d<? super T, ? super T> f17945c;

    /* renamed from: d */
    final int f17946d;

    /* compiled from: FlowableSequenceEqualSingle.java */
    /* renamed from: g.a.y0.e.b.h3$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4552c, C4726g3.b {
        private static final long serialVersionUID = -6178010334400373240L;
        final InterfaceC4524n0<? super Boolean> actual;
        final InterfaceC4573d<? super T, ? super T> comparer;
        final C5163c error = new C5163c();
        final C4726g3.c<T> first;
        final C4726g3.c<T> second;

        /* renamed from: v1 */
        T f17947v1;

        /* renamed from: v2 */
        T f17948v2;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0, int i2, InterfaceC4573d<? super T, ? super T> interfaceC4573d) {
            this.actual = interfaceC4524n0;
            this.comparer = interfaceC4573d;
            this.first = new C4726g3.c<>(this, i2);
            this.second = new C4726g3.c<>(this, i2);
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.first.cancel();
            this.second.cancel();
            if (getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4726g3.b
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            do {
                InterfaceC4616o<T> interfaceC4616o = this.first.queue;
                InterfaceC4616o<T> interfaceC4616o2 = this.second.queue;
                if (interfaceC4616o != null && interfaceC4616o2 != null) {
                    while (!isDisposed()) {
                        if (this.error.get() != null) {
                            cancelAndClear();
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T t = this.f17947v1;
                        if (t == null) {
                            try {
                                t = interfaceC4616o.poll();
                                this.f17947v1 = t;
                            } catch (Throwable th) {
                                C4561b.m18199b(th);
                                cancelAndClear();
                                this.error.addThrowable(th);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z2 = t == null;
                        boolean z3 = this.second.done;
                        T t2 = this.f17948v2;
                        if (t2 == null) {
                            try {
                                t2 = interfaceC4616o2.poll();
                                this.f17948v2 = t2;
                            } catch (Throwable th2) {
                                C4561b.m18199b(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z4 = t2 == null;
                        if (z && z3 && z2 && z4) {
                            this.actual.onSuccess(true);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            cancelAndClear();
                            this.actual.onSuccess(false);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.comparer.mo18210a(t, t2)) {
                                    cancelAndClear();
                                    this.actual.onSuccess(false);
                                    return;
                                } else {
                                    this.f17947v1 = null;
                                    this.f17948v2 = null;
                                    this.first.request();
                                    this.second.request();
                                }
                            } catch (Throwable th3) {
                                C4561b.m18199b(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    cancelAndClear();
                    this.actual.onError(this.error.terminate());
                    return;
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4726g3.b
        public void innerError(Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC5160j.isCancelled(this.first.get());
        }

        void subscribe(InterfaceC5821b<? extends T> interfaceC5821b, InterfaceC5821b<? extends T> interfaceC5821b2) {
            interfaceC5821b.subscribe(this.first);
            interfaceC5821b2.subscribe(this.second);
        }
    }

    public C4732h3(InterfaceC5821b<? extends T> interfaceC5821b, InterfaceC5821b<? extends T> interfaceC5821b2, InterfaceC4573d<? super T, ? super T> interfaceC4573d, int i2) {
        this.f17943a = interfaceC5821b;
        this.f17944b = interfaceC5821b2;
        this.f17945c = interfaceC4573d;
        this.f17946d = i2;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    public void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        a aVar = new a(interfaceC4524n0, this.f17946d, this.f17945c);
        interfaceC4524n0.onSubscribe(aVar);
        aVar.subscribe(this.f17943a, this.f17944b);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<Boolean> mo18286b() {
        return C4476a.m17129a(new C4726g3(this.f17943a, this.f17944b, this.f17945c, this.f17946d));
    }
}
