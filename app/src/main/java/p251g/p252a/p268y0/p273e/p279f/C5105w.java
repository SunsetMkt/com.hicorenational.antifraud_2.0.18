package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleFlatMapCompletable.java */
/* renamed from: g.a.y0.e.f.w */
/* loaded from: classes2.dex */
public final class C5105w<T> extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19812a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4513i> f19813b;

    /* compiled from: SingleFlatMapCompletable.java */
    /* renamed from: g.a.y0.e.f.w$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, InterfaceC4491f, InterfaceC4552c {
        private static final long serialVersionUID = -2177128922851101253L;
        final InterfaceC4491f actual;
        final InterfaceC4584o<? super T, ? extends InterfaceC4513i> mapper;

        a(InterfaceC4491f interfaceC4491f, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o) {
            this.actual = interfaceC4491f;
            this.mapper = interfaceC4584o;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                InterfaceC4513i interfaceC4513i = (InterfaceC4513i) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (isDisposed()) {
                    return;
                }
                interfaceC4513i.mo17074a(this);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                onError(th);
            }
        }
    }

    public C5105w(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o) {
        this.f19812a = interfaceC4530q0;
        this.f19813b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        a aVar = new a(interfaceC4491f, this.f19813b);
        interfaceC4491f.onSubscribe(aVar);
        this.f19812a.mo17490a(aVar);
    }
}
