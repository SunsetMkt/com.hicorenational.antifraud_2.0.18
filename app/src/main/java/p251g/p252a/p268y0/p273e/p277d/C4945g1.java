package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4517k;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: ObservableGenerate.java */
/* renamed from: g.a.y0.e.d.g1 */
/* loaded from: classes2.dex */
public final class C4945g1<T, S> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final Callable<S> f18998a;

    /* renamed from: b */
    final InterfaceC4572c<S, InterfaceC4517k<T>, S> f18999b;

    /* renamed from: c */
    final InterfaceC4576g<? super S> f19000c;

    public C4945g1(Callable<S> callable, InterfaceC4572c<S, InterfaceC4517k<T>, S> interfaceC4572c, InterfaceC4576g<? super S> interfaceC4576g) {
        this.f18998a = callable;
        this.f18999b = interfaceC4572c;
        this.f19000c = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        try {
            a aVar = new a(interfaceC4514i0, this.f18999b, this.f19000c, this.f18998a.call());
            interfaceC4514i0.onSubscribe(aVar);
            aVar.m18447a();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4514i0);
        }
    }

    /* compiled from: ObservableGenerate.java */
    /* renamed from: g.a.y0.e.d.g1$a */
    static final class a<T, S> implements InterfaceC4517k<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19001a;

        /* renamed from: b */
        final InterfaceC4572c<S, ? super InterfaceC4517k<T>, S> f19002b;

        /* renamed from: c */
        final InterfaceC4576g<? super S> f19003c;

        /* renamed from: d */
        S f19004d;

        /* renamed from: e */
        volatile boolean f19005e;

        /* renamed from: f */
        boolean f19006f;

        /* renamed from: g */
        boolean f19007g;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4572c<S, ? super InterfaceC4517k<T>, S> interfaceC4572c, InterfaceC4576g<? super S> interfaceC4576g, S s) {
            this.f19001a = interfaceC4514i0;
            this.f19002b = interfaceC4572c;
            this.f19003c = interfaceC4576g;
            this.f19004d = s;
        }

        /* renamed from: a */
        public void m18447a() {
            S s = this.f19004d;
            if (this.f19005e) {
                this.f19004d = null;
                m18446a(s);
                return;
            }
            InterfaceC4572c<S, ? super InterfaceC4517k<T>, S> interfaceC4572c = this.f19002b;
            while (!this.f19005e) {
                this.f19007g = false;
                try {
                    s = interfaceC4572c.apply(s, this);
                    if (this.f19006f) {
                        this.f19005e = true;
                        this.f19004d = null;
                        m18446a(s);
                        return;
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f19004d = null;
                    this.f19005e = true;
                    onError(th);
                    m18446a(s);
                    return;
                }
            }
            this.f19004d = null;
            m18446a(s);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19005e = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19005e;
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onComplete() {
            if (this.f19006f) {
                return;
            }
            this.f19006f = true;
            this.f19001a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onError(Throwable th) {
            if (this.f19006f) {
                C4476a.m17152b(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f19006f = true;
            this.f19001a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4517k
        public void onNext(T t) {
            if (this.f19006f) {
                return;
            }
            if (this.f19007g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f19007g = true;
                this.f19001a.onNext(t);
            }
        }

        /* renamed from: a */
        private void m18446a(S s) {
            try {
                this.f19003c.accept(s);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
        }
    }
}
