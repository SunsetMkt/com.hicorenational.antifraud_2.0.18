package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleFlatMapMaybe.java */
/* renamed from: g.a.y0.e.f.z */
/* loaded from: classes2.dex */
public final class C5108z<T, R> extends AbstractC4533s<R> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19822a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> f19823b;

    /* compiled from: SingleFlatMapMaybe.java */
    /* renamed from: g.a.y0.e.f.z$a */
    static final class a<R> implements InterfaceC4559v<R> {

        /* renamed from: a */
        final AtomicReference<InterfaceC4552c> f19824a;

        /* renamed from: b */
        final InterfaceC4559v<? super R> f19825b;

        a(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4559v<? super R> interfaceC4559v) {
            this.f19824a = atomicReference;
            this.f19825b = interfaceC4559v;
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f19825b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f19825b.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this.f19824a, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(R r) {
            this.f19825b.onSuccess(r);
        }
    }

    /* compiled from: SingleFlatMapMaybe.java */
    /* renamed from: g.a.y0.e.f.z$b */
    static final class b<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -5843758257109742742L;
        final InterfaceC4559v<? super R> actual;
        final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> mapper;

        b(InterfaceC4559v<? super R> interfaceC4559v, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o) {
            this.actual = interfaceC4559v;
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

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                InterfaceC4588y interfaceC4588y = (InterfaceC4588y) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                interfaceC4588y.mo18100a(new a(this, this.actual));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                onError(th);
            }
        }
    }

    public C5108z(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o) {
        this.f19823b = interfaceC4584o;
        this.f19822a = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        this.f19822a.mo17490a(new b(interfaceC4559v, this.f19823b));
    }
}
