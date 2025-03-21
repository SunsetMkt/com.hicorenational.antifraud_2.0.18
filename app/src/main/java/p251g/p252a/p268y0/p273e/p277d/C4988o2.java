package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.C4599k;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: ObservableRetryPredicate.java */
/* renamed from: g.a.y0.e.d.o2 */
/* loaded from: classes2.dex */
public final class C4988o2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4587r<? super Throwable> f19248b;

    /* renamed from: c */
    final long f19249c;

    /* compiled from: ObservableRetryPredicate.java */
    /* renamed from: g.a.y0.e.d.o2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final InterfaceC4514i0<? super T> actual;
        final InterfaceC4587r<? super Throwable> predicate;
        long remaining;

        /* renamed from: sa */
        final C4599k f19250sa;
        final InterfaceC4504g0<? extends T> source;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, InterfaceC4587r<? super Throwable> interfaceC4587r, C4599k c4599k, InterfaceC4504g0<? extends T> interfaceC4504g0) {
            this.actual = interfaceC4514i0;
            this.f19250sa = c4599k;
            this.source = interfaceC4504g0;
            this.predicate = interfaceC4587r;
            this.remaining = j2;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            long j2 = this.remaining;
            if (j2 != C5556m0.f20396b) {
                this.remaining = j2 - 1;
            }
            if (j2 == 0) {
                this.actual.onError(th);
                return;
            }
            try {
                if (this.predicate.test(th)) {
                    subscribeNext();
                } else {
                    this.actual.onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.actual.onError(new C4560a(th, th2));
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19250sa.update(interfaceC4552c);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f19250sa.isDisposed()) {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C4988o2(AbstractC4469b0<T> abstractC4469b0, long j2, InterfaceC4587r<? super Throwable> interfaceC4587r) {
        super(abstractC4469b0);
        this.f19248b = interfaceC4587r;
        this.f19249c = j2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4599k c4599k = new C4599k();
        interfaceC4514i0.onSubscribe(c4599k);
        new a(interfaceC4514i0, this.f19249c, this.f19248b, c4599k, this.f18742a).subscribeNext();
    }
}
