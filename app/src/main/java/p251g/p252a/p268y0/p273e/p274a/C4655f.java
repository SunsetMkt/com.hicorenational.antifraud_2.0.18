package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4486e;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4503g;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4575f;
import p251g.p252a.p268y0.p269a.C4590b;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CompletableCreate.java */
/* renamed from: g.a.y0.e.a.f */
/* loaded from: classes2.dex */
public final class C4655f extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4503g f17655a;

    /* compiled from: CompletableCreate.java */
    /* renamed from: g.a.y0.e.a.f$a */
    static final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4486e, InterfaceC4552c {
        private static final long serialVersionUID = -2467358622224974244L;
        final InterfaceC4491f actual;

        a(InterfaceC4491f interfaceC4491f) {
            this.actual = interfaceC4491f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4486e, p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4486e
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

        @Override // p251g.p252a.InterfaceC4486e
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            C4476a.m17152b(th);
        }

        @Override // p251g.p252a.InterfaceC4486e
        public void setCancellable(InterfaceC4575f interfaceC4575f) {
            setDisposable(new C4590b(interfaceC4575f));
        }

        @Override // p251g.p252a.InterfaceC4486e
        public void setDisposable(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.set(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4486e
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

    public C4655f(InterfaceC4503g interfaceC4503g) {
        this.f17655a = interfaceC4503g;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        a aVar = new a(interfaceC4491f);
        interfaceC4491f.onSubscribe(aVar);
        try {
            this.f17655a.m17376a(aVar);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            aVar.onError(th);
        }
    }
}
