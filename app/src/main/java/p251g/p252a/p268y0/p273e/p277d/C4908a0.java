package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4478d0;
import p251g.p252a.InterfaceC4487e0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4575f;
import p251g.p252a.p268y0.p269a.C4590b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5163c;

/* compiled from: ObservableCreate.java */
/* renamed from: g.a.y0.e.d.a0 */
/* loaded from: classes2.dex */
public final class C4908a0<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final InterfaceC4487e0<T> f18743a;

    /* compiled from: ObservableCreate.java */
    /* renamed from: g.a.y0.e.d.a0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4478d0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -3434801548987643227L;
        final InterfaceC4514i0<? super T> observer;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.observer = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4478d0, p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            C4476a.m17152b(th);
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4478d0
        public InterfaceC4478d0<T> serialize() {
            return new b(this);
        }

        @Override // p251g.p252a.InterfaceC4478d0
        public void setCancellable(InterfaceC4575f interfaceC4575f) {
            setDisposable(new C4590b(interfaceC4575f));
        }

        @Override // p251g.p252a.InterfaceC4478d0
        public void setDisposable(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.set(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4478d0
        public boolean tryOnError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }
    }

    /* compiled from: ObservableCreate.java */
    /* renamed from: g.a.y0.e.d.a0$b */
    static final class b<T> extends AtomicInteger implements InterfaceC4478d0<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final InterfaceC4478d0<T> emitter;
        final C5163c error = new C5163c();
        final C5111c<T> queue = new C5111c<>(16);

        b(InterfaceC4478d0<T> interfaceC4478d0) {
            this.emitter = interfaceC4478d0;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            InterfaceC4478d0<T> interfaceC4478d0 = this.emitter;
            C5111c<T> c5111c = this.queue;
            C5163c c5163c = this.error;
            int i2 = 1;
            while (!interfaceC4478d0.isDisposed()) {
                if (c5163c.get() != null) {
                    c5111c.clear();
                    interfaceC4478d0.onError(c5163c.terminate());
                    return;
                }
                boolean z = this.done;
                T poll = c5111c.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    interfaceC4478d0.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    interfaceC4478d0.onNext(poll);
                }
            }
            c5111c.clear();
        }

        @Override // p251g.p252a.InterfaceC4478d0, p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onComplete() {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            C4476a.m17152b(th);
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onNext(T t) {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                C5111c<T> c5111c = this.queue;
                synchronized (c5111c) {
                    c5111c.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // p251g.p252a.InterfaceC4478d0
        public InterfaceC4478d0<T> serialize() {
            return this;
        }

        @Override // p251g.p252a.InterfaceC4478d0
        public void setCancellable(InterfaceC4575f interfaceC4575f) {
            this.emitter.setCancellable(interfaceC4575f);
        }

        @Override // p251g.p252a.InterfaceC4478d0
        public void setDisposable(InterfaceC4552c interfaceC4552c) {
            this.emitter.setDisposable(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4478d0
        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isDisposed() && !this.done) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public C4908a0(InterfaceC4487e0<T> interfaceC4487e0) {
        this.f18743a = interfaceC4487e0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0);
        interfaceC4514i0.onSubscribe(aVar);
        try {
            this.f18743a.m17266a(aVar);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            aVar.onError(th);
        }
    }
}
