package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.C4599k;

/* compiled from: ObservableOnErrorNext.java */
/* renamed from: g.a.y0.e.d.z1 */
/* loaded from: classes2.dex */
public final class C5042z1<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends T>> f19534b;

    /* renamed from: c */
    final boolean f19535c;

    /* compiled from: ObservableOnErrorNext.java */
    /* renamed from: g.a.y0.e.d.z1$a */
    static final class a<T> implements InterfaceC4514i0<T> {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19536a;

        /* renamed from: b */
        final InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends T>> f19537b;

        /* renamed from: c */
        final boolean f19538c;

        /* renamed from: d */
        final C4599k f19539d = new C4599k();

        /* renamed from: e */
        boolean f19540e;

        /* renamed from: f */
        boolean f19541f;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends T>> interfaceC4584o, boolean z) {
            this.f19536a = interfaceC4514i0;
            this.f19537b = interfaceC4584o;
            this.f19538c = z;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19541f) {
                return;
            }
            this.f19541f = true;
            this.f19540e = true;
            this.f19536a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19540e) {
                if (this.f19541f) {
                    C4476a.m17152b(th);
                    return;
                } else {
                    this.f19536a.onError(th);
                    return;
                }
            }
            this.f19540e = true;
            if (this.f19538c && !(th instanceof Exception)) {
                this.f19536a.onError(th);
                return;
            }
            try {
                InterfaceC4504g0<? extends T> apply = this.f19537b.apply(th);
                if (apply != null) {
                    apply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.f19536a.onError(nullPointerException);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f19536a.onError(new C4560a(th, th2));
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19541f) {
                return;
            }
            this.f19536a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19539d.replace(interfaceC4552c);
        }
    }

    public C5042z1(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends T>> interfaceC4584o, boolean z) {
        super(interfaceC4504g0);
        this.f19534b = interfaceC4584o;
        this.f19535c = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0, this.f19534b, this.f19535c);
        interfaceC4514i0.onSubscribe(aVar.f19539d);
        this.f18742a.subscribe(aVar);
    }
}
