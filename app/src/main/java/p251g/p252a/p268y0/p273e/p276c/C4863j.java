package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4549u;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4566w;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4575f;
import p251g.p252a.p268y0.p269a.C4590b;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeCreate.java */
/* renamed from: g.a.y0.e.c.j */
/* loaded from: classes2.dex */
public final class C4863j<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final InterfaceC4566w<T> f18629a;

    /* compiled from: MaybeCreate.java */
    /* renamed from: g.a.y0.e.c.j$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4549u<T>, InterfaceC4552c {
        private static final long serialVersionUID = -2467358622224974244L;
        final InterfaceC4559v<? super T> actual;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.actual = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4549u, p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4549u
        public void onComplete() {
            InterfaceC4552c andSet;
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || (andSet = getAndSet(enumC4592d)) == EnumC4592d.DISPOSED) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4549u
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            C4476a.m17152b(th);
        }

        @Override // p251g.p252a.InterfaceC4549u
        public void onSuccess(T t) {
            InterfaceC4552c andSet;
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || (andSet = getAndSet(enumC4592d)) == EnumC4592d.DISPOSED) {
                return;
            }
            try {
                if (t == null) {
                    this.actual.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.actual.onSuccess(t);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (Throwable th) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th;
            }
        }

        @Override // p251g.p252a.InterfaceC4549u
        public void setCancellable(InterfaceC4575f interfaceC4575f) {
            setDisposable(new C4590b(interfaceC4575f));
        }

        @Override // p251g.p252a.InterfaceC4549u
        public void setDisposable(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.set(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4549u
        public boolean tryOnError(Throwable th) {
            InterfaceC4552c andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || (andSet = getAndSet(enumC4592d)) == EnumC4592d.DISPOSED) {
                return false;
            }
            try {
                this.actual.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    public C4863j(InterfaceC4566w<T> interfaceC4566w) {
        this.f18629a = interfaceC4566w;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        a aVar = new a(interfaceC4559v);
        interfaceC4559v.onSubscribe(aVar);
        try {
            this.f18629a.m18200a(aVar);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            aVar.onError(th);
        }
    }
}
