package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeDelayWithCompletable.java */
/* renamed from: g.a.y0.e.c.o */
/* loaded from: classes2.dex */
public final class C4878o<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18667a;

    /* renamed from: b */
    final InterfaceC4513i f18668b;

    /* compiled from: MaybeDelayWithCompletable.java */
    /* renamed from: g.a.y0.e.c.o$a */
    static final class a<T> implements InterfaceC4559v<T> {

        /* renamed from: a */
        final AtomicReference<InterfaceC4552c> f18669a;

        /* renamed from: b */
        final InterfaceC4559v<? super T> f18670b;

        a(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4559v<? super T> interfaceC4559v) {
            this.f18669a = atomicReference;
            this.f18670b = interfaceC4559v;
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18670b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18670b.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this.f18669a, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18670b.onSuccess(t);
        }
    }

    /* compiled from: MaybeDelayWithCompletable.java */
    /* renamed from: g.a.y0.e.c.o$b */
    static final class b<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c {
        private static final long serialVersionUID = 703409937383992161L;
        final InterfaceC4559v<? super T> actual;
        final InterfaceC4588y<T> source;

        b(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4588y<T> interfaceC4588y) {
            this.actual = interfaceC4559v;
            this.source = interfaceC4588y;
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
            this.source.mo18100a(new a(this, this.actual));
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4878o(InterfaceC4588y<T> interfaceC4588y, InterfaceC4513i interfaceC4513i) {
        this.f18667a = interfaceC4588y;
        this.f18668b = interfaceC4513i;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18668b.mo17074a(new b(interfaceC4559v, this.f18667a));
    }
}
