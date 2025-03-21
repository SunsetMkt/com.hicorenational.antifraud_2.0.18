package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: ObservableTake.java */
/* renamed from: g.a.y0.e.d.i3 */
/* loaded from: classes2.dex */
public final class C4959i3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f19070b;

    /* compiled from: ObservableTake.java */
    /* renamed from: g.a.y0.e.d.i3$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19071a;

        /* renamed from: b */
        boolean f19072b;

        /* renamed from: c */
        InterfaceC4552c f19073c;

        /* renamed from: d */
        long f19074d;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2) {
            this.f19071a = interfaceC4514i0;
            this.f19074d = j2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19073c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19073c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19072b) {
                return;
            }
            this.f19072b = true;
            this.f19073c.dispose();
            this.f19071a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19072b) {
                C4476a.m17152b(th);
                return;
            }
            this.f19072b = true;
            this.f19073c.dispose();
            this.f19071a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19072b) {
                return;
            }
            long j2 = this.f19074d;
            this.f19074d = j2 - 1;
            if (j2 > 0) {
                boolean z = this.f19074d == 0;
                this.f19071a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19073c, interfaceC4552c)) {
                this.f19073c = interfaceC4552c;
                if (this.f19074d != 0) {
                    this.f19071a.onSubscribe(this);
                    return;
                }
                this.f19072b = true;
                interfaceC4552c.dispose();
                EnumC4593e.complete(this.f19071a);
            }
        }
    }

    public C4959i3(InterfaceC4504g0<T> interfaceC4504g0, long j2) {
        super(interfaceC4504g0);
        this.f19070b = j2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19070b));
    }
}
