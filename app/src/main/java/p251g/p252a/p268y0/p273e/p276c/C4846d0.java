package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeFlatMapNotification.java */
/* renamed from: g.a.y0.e.c.d0 */
/* loaded from: classes2.dex */
public final class C4846d0<T, R> extends AbstractC4836a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> f18587b;

    /* renamed from: c */
    final InterfaceC4584o<? super Throwable, ? extends InterfaceC4588y<? extends R>> f18588c;

    /* renamed from: d */
    final Callable<? extends InterfaceC4588y<? extends R>> f18589d;

    /* compiled from: MaybeFlatMapNotification.java */
    /* renamed from: g.a.y0.e.c.d0$a */
    static final class a<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = 4375739915521278546L;
        final InterfaceC4559v<? super R> actual;

        /* renamed from: d */
        InterfaceC4552c f18590d;
        final Callable<? extends InterfaceC4588y<? extends R>> onCompleteSupplier;
        final InterfaceC4584o<? super Throwable, ? extends InterfaceC4588y<? extends R>> onErrorMapper;
        final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> onSuccessMapper;

        /* compiled from: MaybeFlatMapNotification.java */
        /* renamed from: g.a.y0.e.c.d0$a$a, reason: collision with other inner class name */
        final class C7401a implements InterfaceC4559v<R> {
            C7401a() {
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onComplete() {
                a.this.actual.onComplete();
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onError(Throwable th) {
                a.this.actual.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(a.this, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
            public void onSuccess(R r) {
                a.this.actual.onSuccess(r);
            }
        }

        a(InterfaceC4559v<? super R> interfaceC4559v, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o, InterfaceC4584o<? super Throwable, ? extends InterfaceC4588y<? extends R>> interfaceC4584o2, Callable<? extends InterfaceC4588y<? extends R>> callable) {
            this.actual = interfaceC4559v;
            this.onSuccessMapper = interfaceC4584o;
            this.onErrorMapper = interfaceC4584o2;
            this.onCompleteSupplier = callable;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            this.f18590d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            try {
                ((InterfaceC4588y) C4601b.m18284a(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource")).mo18100a(new C7401a());
            } catch (Exception e2) {
                C4561b.m18199b(e2);
                this.actual.onError(e2);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            try {
                ((InterfaceC4588y) C4601b.m18284a(this.onErrorMapper.apply(th), "The onErrorMapper returned a null MaybeSource")).mo18100a(new C7401a());
            } catch (Exception e2) {
                C4561b.m18199b(e2);
                this.actual.onError(new C4560a(th, e2));
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18590d, interfaceC4552c)) {
                this.f18590d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                ((InterfaceC4588y) C4601b.m18284a(this.onSuccessMapper.apply(t), "The onSuccessMapper returned a null MaybeSource")).mo18100a(new C7401a());
            } catch (Exception e2) {
                C4561b.m18199b(e2);
                this.actual.onError(e2);
            }
        }
    }

    public C4846d0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o, InterfaceC4584o<? super Throwable, ? extends InterfaceC4588y<? extends R>> interfaceC4584o2, Callable<? extends InterfaceC4588y<? extends R>> callable) {
        super(interfaceC4588y);
        this.f18587b = interfaceC4584o;
        this.f18588c = interfaceC4584o2;
        this.f18589d = callable;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18587b, this.f18588c, this.f18589d));
    }
}
