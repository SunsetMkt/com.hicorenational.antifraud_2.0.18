package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.EnumC4468b;
import p251g.p252a.InterfaceC4523n;
import p251g.p252a.InterfaceC4525o;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4575f;
import p251g.p252a.p268y0.p269a.C4590b;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5164d;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableCreate.java */
/* renamed from: g.a.y0.e.b.c0 */
/* loaded from: classes2.dex */
public final class C4699c0<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC4525o<T> f17798b;

    /* renamed from: c */
    final EnumC4468b f17799c;

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f17800a = new int[EnumC4468b.values().length];

        static {
            try {
                f17800a[EnumC4468b.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17800a[EnumC4468b.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17800a[EnumC4468b.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17800a[EnumC4468b.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$b */
    static abstract class b<T> extends AtomicLong implements InterfaceC4523n<T>, InterfaceC5823d {
        private static final long serialVersionUID = 7326289992464377023L;
        final InterfaceC5822c<? super T> actual;
        final C4599k serial = new C4599k();

        b(InterfaceC5822c<? super T> interfaceC5822c) {
            this.actual = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        protected void complete() {
            if (isCancelled()) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        protected boolean error(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.actual.onError(th);
                this.serial.dispose();
                return true;
            } catch (Throwable th2) {
                this.serial.dispose();
                throw th2;
            }
        }

        @Override // p251g.p252a.InterfaceC4523n
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onComplete() {
            complete();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public final void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            C4476a.m17152b(th);
        }

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this, j2);
                onRequested();
            }
        }

        @Override // p251g.p252a.InterfaceC4523n
        public final long requested() {
            return get();
        }

        @Override // p251g.p252a.InterfaceC4523n
        public final InterfaceC4523n<T> serialize() {
            return new i(this);
        }

        @Override // p251g.p252a.InterfaceC4523n
        public final void setCancellable(InterfaceC4575f interfaceC4575f) {
            setDisposable(new C4590b(interfaceC4575f));
        }

        @Override // p251g.p252a.InterfaceC4523n
        public final void setDisposable(InterfaceC4552c interfaceC4552c) {
            this.serial.update(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4523n
        public boolean tryOnError(Throwable th) {
            return error(th);
        }
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$c */
    static final class c<T> extends b<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final C5111c<T> queue;
        final AtomicInteger wip;

        c(InterfaceC5822c<? super T> interfaceC5822c, int i2) {
            super(interfaceC5822c);
            this.queue = new C5111c<>(i2);
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            C5111c<T> c5111c = this.queue;
            int i2 = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (j3 != j2) {
                    if (isCancelled()) {
                        c5111c.clear();
                        return;
                    }
                    boolean z = this.done;
                    T poll = c5111c.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(poll);
                    j3++;
                }
                if (j3 == j2) {
                    if (isCancelled()) {
                        c5111c.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean isEmpty = c5111c.isEmpty();
                    if (z3 && isEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            error(th2);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    C5164d.m18610c(this, j3);
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.b, p251g.p252a.InterfaceC4517k
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.offer(t);
                drain();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.b
        void onRequested() {
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.b
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.b, p251g.p252a.InterfaceC4523n
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$d */
    static final class d<T> extends h<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        d(InterfaceC5822c<? super T> interfaceC5822c) {
            super(interfaceC5822c);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.h
        void onOverflow() {
        }
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$e */
    static final class e<T> extends h<T> {
        private static final long serialVersionUID = 338953216916120960L;

        e(InterfaceC5822c<? super T> interfaceC5822c) {
            super(interfaceC5822c);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.h
        void onOverflow() {
            onError(new C4562c("create: could not emit value due to lack of requests"));
        }
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$f */
    static final class f<T> extends b<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        f(InterfaceC5822c<? super T> interfaceC5822c) {
            super(interfaceC5822c);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            AtomicReference<T> atomicReference = this.queue;
            int i2 = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        break;
                    }
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(andSet);
                    j3++;
                }
                if (j3 == j2) {
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z3 = this.done;
                    boolean z4 = atomicReference.get() == null;
                    if (z3 && z4) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            error(th2);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    C5164d.m18610c(this, j3);
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.b, p251g.p252a.InterfaceC4517k
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.set(t);
                drain();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.b
        void onRequested() {
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.b
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4699c0.b, p251g.p252a.InterfaceC4523n
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$g */
    static final class g<T> extends b<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        g(InterfaceC5822c<? super T> interfaceC5822c) {
            super(interfaceC5822c);
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onNext(T t) {
            long j2;
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.actual.onNext(t);
            do {
                j2 = get();
                if (j2 == 0) {
                    return;
                }
            } while (!compareAndSet(j2, j2 - 1));
        }
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$h */
    static abstract class h<T> extends b<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        h(InterfaceC5822c<? super T> interfaceC5822c) {
            super(interfaceC5822c);
        }

        @Override // p251g.p252a.InterfaceC4517k
        public final void onNext(T t) {
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                onOverflow();
            } else {
                this.actual.onNext(t);
                C5164d.m18610c(this, 1L);
            }
        }

        abstract void onOverflow();
    }

    /* compiled from: FlowableCreate.java */
    /* renamed from: g.a.y0.e.b.c0$i */
    static final class i<T> extends AtomicInteger implements InterfaceC4523n<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final b<T> emitter;
        final C5163c error = new C5163c();
        final InterfaceC4615n<T> queue = new C5111c(16);

        i(b<T> bVar) {
            this.emitter = bVar;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            b<T> bVar = this.emitter;
            InterfaceC4615n<T> interfaceC4615n = this.queue;
            C5163c c5163c = this.error;
            int i2 = 1;
            while (!bVar.isCancelled()) {
                if (c5163c.get() != null) {
                    interfaceC4615n.clear();
                    bVar.onError(c5163c.terminate());
                    return;
                }
                boolean z = this.done;
                T poll = interfaceC4615n.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    bVar.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    bVar.onNext(poll);
                }
            }
            interfaceC4615n.clear();
        }

        @Override // p251g.p252a.InterfaceC4523n
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
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
            if (this.emitter.isCancelled() || this.done) {
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
                InterfaceC4615n<T> interfaceC4615n = this.queue;
                synchronized (interfaceC4615n) {
                    interfaceC4615n.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // p251g.p252a.InterfaceC4523n
        public long requested() {
            return this.emitter.requested();
        }

        @Override // p251g.p252a.InterfaceC4523n
        public InterfaceC4523n<T> serialize() {
            return this;
        }

        @Override // p251g.p252a.InterfaceC4523n
        public void setCancellable(InterfaceC4575f interfaceC4575f) {
            this.emitter.setCancellable(interfaceC4575f);
        }

        @Override // p251g.p252a.InterfaceC4523n
        public void setDisposable(InterfaceC4552c interfaceC4552c) {
            this.emitter.setDisposable(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4523n
        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isCancelled() && !this.done) {
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

    public C4699c0(InterfaceC4525o<T> interfaceC4525o, EnumC4468b enumC4468b) {
        this.f17798b = interfaceC4525o;
        this.f17799c = enumC4468b;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        int i2 = a.f17800a[this.f17799c.ordinal()];
        b cVar = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new c(interfaceC5822c, AbstractC4519l.m17539Q()) : new f(interfaceC5822c) : new d(interfaceC5822c) : new e(interfaceC5822c) : new g(interfaceC5822c);
        interfaceC5822c.onSubscribe(cVar);
        try {
            this.f17798b.m18003a(cVar);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            cVar.onError(th);
        }
    }
}
