package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeOnErrorNext.java */
/* renamed from: g.a.y0.e.c.z0 */
/* loaded from: classes2.dex */
public final class C4906z0<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super Throwable, ? extends InterfaceC4588y<? extends T>> f18738b;

    /* renamed from: c */
    final boolean f18739c;

    /* compiled from: MaybeOnErrorNext.java */
    /* renamed from: g.a.y0.e.c.z0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = 2026620218879969836L;
        final InterfaceC4559v<? super T> actual;
        final boolean allowFatal;
        final InterfaceC4584o<? super Throwable, ? extends InterfaceC4588y<? extends T>> resumeFunction;

        /* compiled from: MaybeOnErrorNext.java */
        /* renamed from: g.a.y0.e.c.z0$a$a, reason: collision with other inner class name */
        static final class C7408a<T> implements InterfaceC4559v<T> {

            /* renamed from: a */
            final InterfaceC4559v<? super T> f18740a;

            /* renamed from: b */
            final AtomicReference<InterfaceC4552c> f18741b;

            C7408a(InterfaceC4559v<? super T> interfaceC4559v, AtomicReference<InterfaceC4552c> atomicReference) {
                this.f18740a = interfaceC4559v;
                this.f18741b = atomicReference;
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onComplete() {
                this.f18740a.onComplete();
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onError(Throwable th) {
                this.f18740a.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this.f18741b, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
            public void onSuccess(T t) {
                this.f18740a.onSuccess(t);
            }
        }

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4584o<? super Throwable, ? extends InterfaceC4588y<? extends T>> interfaceC4584o, boolean z) {
            this.actual = interfaceC4559v;
            this.resumeFunction = interfaceC4584o;
            this.allowFatal = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            if (!this.allowFatal && !(th instanceof Exception)) {
                this.actual.onError(th);
                return;
            }
            try {
                InterfaceC4588y interfaceC4588y = (InterfaceC4588y) C4601b.m18284a(this.resumeFunction.apply(th), "The resumeFunction returned a null MaybeSource");
                EnumC4592d.replace(this, null);
                interfaceC4588y.mo18100a(new C7408a(this.actual, this));
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.actual.onError(new C4560a(th, th2));
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public C4906z0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super Throwable, ? extends InterfaceC4588y<? extends T>> interfaceC4584o, boolean z) {
        super(interfaceC4588y);
        this.f18738b = interfaceC4584o;
        this.f18739c = z;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18738b, this.f18739c));
    }
}
