package p251g.p252a.p268y0.p273e.p277d;

import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;

/* compiled from: ObservableElementAtSingle.java */
/* renamed from: g.a.y0.e.d.q0 */
/* loaded from: classes2.dex */
public final class C4996q0<T> extends AbstractC4518k0<T> implements InterfaceC4605d<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19317a;

    /* renamed from: b */
    final long f19318b;

    /* renamed from: c */
    final T f19319c;

    /* compiled from: ObservableElementAtSingle.java */
    /* renamed from: g.a.y0.e.d.q0$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f19320a;

        /* renamed from: b */
        final long f19321b;

        /* renamed from: c */
        final T f19322c;

        /* renamed from: d */
        InterfaceC4552c f19323d;

        /* renamed from: e */
        long f19324e;

        /* renamed from: f */
        boolean f19325f;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, long j2, T t) {
            this.f19320a = interfaceC4524n0;
            this.f19321b = j2;
            this.f19322c = t;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19323d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19323d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19325f) {
                return;
            }
            this.f19325f = true;
            T t = this.f19322c;
            if (t != null) {
                this.f19320a.onSuccess(t);
            } else {
                this.f19320a.onError(new NoSuchElementException());
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19325f) {
                C4476a.m17152b(th);
            } else {
                this.f19325f = true;
                this.f19320a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19325f) {
                return;
            }
            long j2 = this.f19324e;
            if (j2 != this.f19321b) {
                this.f19324e = j2 + 1;
                return;
            }
            this.f19325f = true;
            this.f19323d.dispose();
            this.f19320a.onSuccess(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19323d, interfaceC4552c)) {
                this.f19323d = interfaceC4552c;
                this.f19320a.onSubscribe(this);
            }
        }
    }

    public C4996q0(InterfaceC4504g0<T> interfaceC4504g0, long j2, T t) {
        this.f19317a = interfaceC4504g0;
        this.f19318b = j2;
        this.f19319c = t;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<T> mo18288a() {
        return C4476a.m17119a(new C4986o0(this.f19317a, this.f19318b, this.f19319c, true));
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    public void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19317a.subscribe(new a(interfaceC4524n0, this.f19318b, this.f19319c));
    }
}
