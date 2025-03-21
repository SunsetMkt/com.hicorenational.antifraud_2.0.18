package p251g.p252a.p268y0.p273e.p277d;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;

/* compiled from: ObservableZip.java */
/* renamed from: g.a.y0.e.d.f4 */
/* loaded from: classes2.dex */
public final class C4942f4<T, R> extends AbstractC4469b0<R> {

    /* renamed from: a */
    final InterfaceC4504g0<? extends T>[] f18979a;

    /* renamed from: b */
    final Iterable<? extends InterfaceC4504g0<? extends T>> f18980b;

    /* renamed from: c */
    final InterfaceC4584o<? super Object[], ? extends R> f18981c;

    /* renamed from: d */
    final int f18982d;

    /* renamed from: e */
    final boolean f18983e;

    /* compiled from: ObservableZip.java */
    /* renamed from: g.a.y0.e.d.f4$a */
    static final class a<T, R> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = 2983708048395377667L;
        final InterfaceC4514i0<? super R> actual;
        volatile boolean cancelled;
        final boolean delayError;
        final b<T, R>[] observers;
        final T[] row;
        final InterfaceC4584o<? super Object[], ? extends R> zipper;

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, boolean z) {
            this.actual = interfaceC4514i0;
            this.zipper = interfaceC4584o;
            this.observers = new b[i2];
            this.row = (T[]) new Object[i2];
            this.delayError = z;
        }

        void cancel() {
            clear();
            cancelSources();
        }

        void cancelSources() {
            for (b<T, R> bVar : this.observers) {
                bVar.m18444a();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC4514i0<? super R> interfaceC4514i0, boolean z3, b<?, ?> bVar) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = bVar.f18987d;
                cancel();
                if (th != null) {
                    interfaceC4514i0.onError(th);
                } else {
                    interfaceC4514i0.onComplete();
                }
                return true;
            }
            Throwable th2 = bVar.f18987d;
            if (th2 != null) {
                cancel();
                interfaceC4514i0.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cancel();
            interfaceC4514i0.onComplete();
            return true;
        }

        void clear() {
            for (b<T, R> bVar : this.observers) {
                bVar.f18985b.clear();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T, R>[] bVarArr = this.observers;
            InterfaceC4514i0<? super R> interfaceC4514i0 = this.actual;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int i2 = 1;
            while (true) {
                int i3 = 0;
                int i4 = 0;
                for (b<T, R> bVar : bVarArr) {
                    if (tArr[i4] == null) {
                        boolean z2 = bVar.f18986c;
                        T poll = bVar.f18985b.poll();
                        boolean z3 = poll == null;
                        if (checkTerminated(z2, z3, interfaceC4514i0, z, bVar)) {
                            return;
                        }
                        if (z3) {
                            i3++;
                        } else {
                            tArr[i4] = poll;
                        }
                    } else if (bVar.f18986c && !z && (th = bVar.f18987d) != null) {
                        cancel();
                        interfaceC4514i0.onError(th);
                        return;
                    }
                    i4++;
                }
                if (i3 != 0) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    try {
                        interfaceC4514i0.onNext((Object) C4601b.m18284a(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        cancel();
                        interfaceC4514i0.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr, int i2) {
            b<T, R>[] bVarArr = this.observers;
            int length = bVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                bVarArr[i3] = new b<>(this, i2);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i4 = 0; i4 < length && !this.cancelled; i4++) {
                interfaceC4504g0Arr[i4].subscribe(bVarArr[i4]);
            }
        }
    }

    /* compiled from: ObservableZip.java */
    /* renamed from: g.a.y0.e.d.f4$b */
    static final class b<T, R> implements InterfaceC4514i0<T> {

        /* renamed from: a */
        final a<T, R> f18984a;

        /* renamed from: b */
        final C5111c<T> f18985b;

        /* renamed from: c */
        volatile boolean f18986c;

        /* renamed from: d */
        Throwable f18987d;

        /* renamed from: e */
        final AtomicReference<InterfaceC4552c> f18988e = new AtomicReference<>();

        b(a<T, R> aVar, int i2) {
            this.f18984a = aVar;
            this.f18985b = new C5111c<>(i2);
        }

        /* renamed from: a */
        public void m18444a() {
            EnumC4592d.dispose(this.f18988e);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18986c = true;
            this.f18984a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18987d = th;
            this.f18986c = true;
            this.f18984a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f18985b.offer(t);
            this.f18984a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this.f18988e, interfaceC4552c);
        }
    }

    public C4942f4(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr, Iterable<? extends InterfaceC4504g0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, boolean z) {
        this.f18979a = interfaceC4504g0Arr;
        this.f18980b = iterable;
        this.f18981c = interfaceC4584o;
        this.f18982d = i2;
        this.f18983e = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        int length;
        InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr = this.f18979a;
        if (interfaceC4504g0Arr == null) {
            interfaceC4504g0Arr = new AbstractC4469b0[8];
            length = 0;
            for (InterfaceC4504g0<? extends T> interfaceC4504g0 : this.f18980b) {
                if (length == interfaceC4504g0Arr.length) {
                    InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr2 = new InterfaceC4504g0[(length >> 2) + length];
                    System.arraycopy(interfaceC4504g0Arr, 0, interfaceC4504g0Arr2, 0, length);
                    interfaceC4504g0Arr = interfaceC4504g0Arr2;
                }
                interfaceC4504g0Arr[length] = interfaceC4504g0;
                length++;
            }
        } else {
            length = interfaceC4504g0Arr.length;
        }
        if (length == 0) {
            EnumC4593e.complete(interfaceC4514i0);
        } else {
            new a(interfaceC4514i0, this.f18981c, length, this.f18983e).subscribe(interfaceC4504g0Arr, this.f18982d);
        }
    }
}
