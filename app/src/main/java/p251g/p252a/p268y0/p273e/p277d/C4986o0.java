package p251g.p252a.p268y0.p273e.p277d;

import java.util.NoSuchElementException;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableElementAt.java */
/* renamed from: g.a.y0.e.d.o0 */
/* loaded from: classes2.dex */
public final class C4986o0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f19232b;

    /* renamed from: c */
    final T f19233c;

    /* renamed from: d */
    final boolean f19234d;

    /* compiled from: ObservableElementAt.java */
    /* renamed from: g.a.y0.e.d.o0$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19235a;

        /* renamed from: b */
        final long f19236b;

        /* renamed from: c */
        final T f19237c;

        /* renamed from: d */
        final boolean f19238d;

        /* renamed from: e */
        InterfaceC4552c f19239e;

        /* renamed from: f */
        long f19240f;

        /* renamed from: g */
        boolean f19241g;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, T t, boolean z) {
            this.f19235a = interfaceC4514i0;
            this.f19236b = j2;
            this.f19237c = t;
            this.f19238d = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19239e.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19239e.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19241g) {
                return;
            }
            this.f19241g = true;
            T t = this.f19237c;
            if (t == null && this.f19238d) {
                this.f19235a.onError(new NoSuchElementException());
                return;
            }
            if (t != null) {
                this.f19235a.onNext(t);
            }
            this.f19235a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19241g) {
                C4476a.m17152b(th);
            } else {
                this.f19241g = true;
                this.f19235a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19241g) {
                return;
            }
            long j2 = this.f19240f;
            if (j2 != this.f19236b) {
                this.f19240f = j2 + 1;
                return;
            }
            this.f19241g = true;
            this.f19239e.dispose();
            this.f19235a.onNext(t);
            this.f19235a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19239e, interfaceC4552c)) {
                this.f19239e = interfaceC4552c;
                this.f19235a.onSubscribe(this);
            }
        }
    }

    public C4986o0(InterfaceC4504g0<T> interfaceC4504g0, long j2, T t, boolean z) {
        super(interfaceC4504g0);
        this.f19232b = j2;
        this.f19233c = t;
        this.f19234d = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19232b, this.f19233c, this.f19234d));
    }
}
