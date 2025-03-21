package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayDeque;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableTakeLast.java */
/* renamed from: g.a.y0.e.d.j3 */
/* loaded from: classes2.dex */
public final class C4964j3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final int f19091b;

    /* compiled from: ObservableTakeLast.java */
    /* renamed from: g.a.y0.e.d.j3$a */
    static final class a<T> extends ArrayDeque<T> implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 7240042530241604978L;
        final InterfaceC4514i0<? super T> actual;
        volatile boolean cancelled;
        final int count;

        /* renamed from: s */
        InterfaceC4552c f19092s;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, int i2) {
            this.actual = interfaceC4514i0;
            this.count = i2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f19092s.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            InterfaceC4514i0<? super T> interfaceC4514i0 = this.actual;
            while (!this.cancelled) {
                T poll = poll();
                if (poll == null) {
                    if (this.cancelled) {
                        return;
                    }
                    interfaceC4514i0.onComplete();
                    return;
                }
                interfaceC4514i0.onNext(poll);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19092s, interfaceC4552c)) {
                this.f19092s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4964j3(InterfaceC4504g0<T> interfaceC4504g0, int i2) {
        super(interfaceC4504g0);
        this.f19091b = i2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19091b));
    }
}
