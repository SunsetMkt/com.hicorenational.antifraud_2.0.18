package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p268y0.p269a.C4599k;

/* compiled from: ObservableRetryBiPredicate.java */
/* renamed from: g.a.y0.e.d.n2 */
/* loaded from: classes2.dex */
public final class C4983n2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4573d<? super Integer, ? super Throwable> f19216b;

    /* compiled from: ObservableRetryBiPredicate.java */
    /* renamed from: g.a.y0.e.d.n2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final InterfaceC4514i0<? super T> actual;
        final InterfaceC4573d<? super Integer, ? super Throwable> predicate;
        int retries;

        /* renamed from: sa */
        final C4599k f19217sa;
        final InterfaceC4504g0<? extends T> source;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4573d<? super Integer, ? super Throwable> interfaceC4573d, C4599k c4599k, InterfaceC4504g0<? extends T> interfaceC4504g0) {
            this.actual = interfaceC4514i0;
            this.f19217sa = c4599k;
            this.source = interfaceC4504g0;
            this.predicate = interfaceC4573d;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            try {
                InterfaceC4573d<? super Integer, ? super Throwable> interfaceC4573d = this.predicate;
                int i2 = this.retries + 1;
                this.retries = i2;
                if (interfaceC4573d.mo18210a(Integer.valueOf(i2), th)) {
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
            this.f19217sa.update(interfaceC4552c);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f19217sa.isDisposed()) {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C4983n2(AbstractC4469b0<T> abstractC4469b0, InterfaceC4573d<? super Integer, ? super Throwable> interfaceC4573d) {
        super(abstractC4469b0);
        this.f19216b = interfaceC4573d;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4599k c4599k = new C4599k();
        interfaceC4514i0.onSubscribe(c4599k);
        new a(interfaceC4514i0, this.f19216b, c4599k, this.f18742a).subscribeNext();
    }
}
