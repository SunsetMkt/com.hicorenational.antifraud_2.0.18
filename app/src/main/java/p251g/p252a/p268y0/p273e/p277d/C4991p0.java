package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;

/* compiled from: ObservableElementAtMaybe.java */
/* renamed from: g.a.y0.e.d.p0 */
/* loaded from: classes2.dex */
public final class C4991p0<T> extends AbstractC4533s<T> implements InterfaceC4605d<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19264a;

    /* renamed from: b */
    final long f19265b;

    /* compiled from: ObservableElementAtMaybe.java */
    /* renamed from: g.a.y0.e.d.p0$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f19266a;

        /* renamed from: b */
        final long f19267b;

        /* renamed from: c */
        InterfaceC4552c f19268c;

        /* renamed from: d */
        long f19269d;

        /* renamed from: e */
        boolean f19270e;

        a(InterfaceC4559v<? super T> interfaceC4559v, long j2) {
            this.f19266a = interfaceC4559v;
            this.f19267b = j2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19268c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19268c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19270e) {
                return;
            }
            this.f19270e = true;
            this.f19266a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19270e) {
                C4476a.m17152b(th);
            } else {
                this.f19270e = true;
                this.f19266a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19270e) {
                return;
            }
            long j2 = this.f19269d;
            if (j2 != this.f19267b) {
                this.f19269d = j2 + 1;
                return;
            }
            this.f19270e = true;
            this.f19268c.dispose();
            this.f19266a.onSuccess(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19268c, interfaceC4552c)) {
                this.f19268c = interfaceC4552c;
                this.f19266a.onSubscribe(this);
            }
        }
    }

    public C4991p0(InterfaceC4504g0<T> interfaceC4504g0, long j2) {
        this.f19264a = interfaceC4504g0;
        this.f19265b = j2;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<T> mo18288a() {
        return C4476a.m17119a(new C4986o0(this.f19264a, this.f19265b, null, false));
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    public void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f19264a.subscribe(new a(interfaceC4559v, this.f19265b));
    }
}
