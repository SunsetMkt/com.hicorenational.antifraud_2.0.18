package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4522m0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4526o0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4575f;
import p251g.p252a.p268y0.p269a.C4590b;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleCreate.java */
/* renamed from: g.a.y0.e.f.d */
/* loaded from: classes2.dex */
public final class C5067d<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4526o0<T> f19685a;

    /* compiled from: SingleCreate.java */
    /* renamed from: g.a.y0.e.f.d$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4522m0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -2467358622224974244L;
        final InterfaceC4524n0<? super T> actual;

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.actual = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4522m0, p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4522m0
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            C4476a.m17152b(th);
        }

        @Override // p251g.p252a.InterfaceC4522m0
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

        @Override // p251g.p252a.InterfaceC4522m0
        public void setCancellable(InterfaceC4575f interfaceC4575f) {
            setDisposable(new C4590b(interfaceC4575f));
        }

        @Override // p251g.p252a.InterfaceC4522m0
        public void setDisposable(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.set(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4522m0
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

    public C5067d(InterfaceC4526o0<T> interfaceC4526o0) {
        this.f19685a = interfaceC4526o0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        a aVar = new a(interfaceC4524n0);
        interfaceC4524n0.onSubscribe(aVar);
        try {
            this.f19685a.m18004a(aVar);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            aVar.onError(th);
        }
    }
}
