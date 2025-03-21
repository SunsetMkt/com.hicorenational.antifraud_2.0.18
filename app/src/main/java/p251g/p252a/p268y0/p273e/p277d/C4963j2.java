package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: ObservableRepeat.java */
/* renamed from: g.a.y0.e.d.j2 */
/* loaded from: classes2.dex */
public final class C4963j2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f19089b;

    /* compiled from: ObservableRepeat.java */
    /* renamed from: g.a.y0.e.d.j2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final InterfaceC4514i0<? super T> actual;
        long remaining;

        /* renamed from: sd */
        final C4599k f19090sd;
        final InterfaceC4504g0<? extends T> source;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, C4599k c4599k, InterfaceC4504g0<? extends T> interfaceC4504g0) {
            this.actual = interfaceC4514i0;
            this.f19090sd = c4599k;
            this.source = interfaceC4504g0;
            this.remaining = j2;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            long j2 = this.remaining;
            if (j2 != C5556m0.f20396b) {
                this.remaining = j2 - 1;
            }
            if (j2 != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19090sd.replace(interfaceC4552c);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f19090sd.isDisposed()) {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C4963j2(AbstractC4469b0<T> abstractC4469b0, long j2) {
        super(abstractC4469b0);
        this.f19089b = j2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4599k c4599k = new C4599k();
        interfaceC4514i0.onSubscribe(c4599k);
        long j2 = this.f19089b;
        long j3 = C5556m0.f20396b;
        if (j2 != C5556m0.f20396b) {
            j3 = j2 - 1;
        }
        new a(interfaceC4514i0, j3, c4599k, this.f18742a).subscribeNext();
    }
}
