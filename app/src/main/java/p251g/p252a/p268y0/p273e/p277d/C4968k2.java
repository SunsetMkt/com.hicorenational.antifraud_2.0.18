package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4574e;
import p251g.p252a.p268y0.p269a.C4599k;

/* compiled from: ObservableRepeatUntil.java */
/* renamed from: g.a.y0.e.d.k2 */
/* loaded from: classes2.dex */
public final class C4968k2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4574e f19101b;

    /* compiled from: ObservableRepeatUntil.java */
    /* renamed from: g.a.y0.e.d.k2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final InterfaceC4514i0<? super T> actual;

        /* renamed from: sd */
        final C4599k f19102sd;
        final InterfaceC4504g0<? extends T> source;
        final InterfaceC4574e stop;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4574e interfaceC4574e, C4599k c4599k, InterfaceC4504g0<? extends T> interfaceC4504g0) {
            this.actual = interfaceC4514i0;
            this.f19102sd = c4599k;
            this.source = interfaceC4504g0;
            this.stop = interfaceC4574e;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.actual.onError(th);
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
            this.f19102sd.replace(interfaceC4552c);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    public C4968k2(AbstractC4469b0<T> abstractC4469b0, InterfaceC4574e interfaceC4574e) {
        super(abstractC4469b0);
        this.f19101b = interfaceC4574e;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4599k c4599k = new C4599k();
        interfaceC4514i0.onSubscribe(c4599k);
        new a(interfaceC4514i0, this.f19101b, c4599k, this.f18742a).subscribeNext();
    }
}
