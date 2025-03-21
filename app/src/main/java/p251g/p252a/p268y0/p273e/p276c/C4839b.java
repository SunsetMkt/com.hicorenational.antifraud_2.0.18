package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: MaybeAmb.java */
/* renamed from: g.a.y0.e.c.b */
/* loaded from: classes2.dex */
public final class C4839b<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    private final InterfaceC4588y<? extends T>[] f18555a;

    /* renamed from: b */
    private final Iterable<? extends InterfaceC4588y<? extends T>> f18556b;

    /* compiled from: MaybeAmb.java */
    /* renamed from: g.a.y0.e.c.b$a */
    static final class a<T> extends AtomicBoolean implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = -7044685185359438206L;
        final InterfaceC4559v<? super T> actual;
        final C4551b set = new C4551b();

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.actual = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                C4476a.m17152b(th);
            } else {
                this.set.dispose();
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.set.mo18181b(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onSuccess(t);
            }
        }
    }

    public C4839b(InterfaceC4588y<? extends T>[] interfaceC4588yArr, Iterable<? extends InterfaceC4588y<? extends T>> iterable) {
        this.f18555a = interfaceC4588yArr;
        this.f18556b = iterable;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        int length;
        InterfaceC4588y<? extends T>[] interfaceC4588yArr = this.f18555a;
        if (interfaceC4588yArr == null) {
            interfaceC4588yArr = new InterfaceC4588y[8];
            try {
                length = 0;
                for (InterfaceC4588y<? extends T> interfaceC4588y : this.f18556b) {
                    if (interfaceC4588y == null) {
                        EnumC4593e.error(new NullPointerException("One of the sources is null"), interfaceC4559v);
                        return;
                    }
                    if (length == interfaceC4588yArr.length) {
                        InterfaceC4588y<? extends T>[] interfaceC4588yArr2 = new InterfaceC4588y[(length >> 2) + length];
                        System.arraycopy(interfaceC4588yArr, 0, interfaceC4588yArr2, 0, length);
                        interfaceC4588yArr = interfaceC4588yArr2;
                    }
                    int i2 = length + 1;
                    interfaceC4588yArr[length] = interfaceC4588y;
                    length = i2;
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC4593e.error(th, interfaceC4559v);
                return;
            }
        } else {
            length = interfaceC4588yArr.length;
        }
        a aVar = new a(interfaceC4559v);
        interfaceC4559v.onSubscribe(aVar);
        for (int i3 = 0; i3 < length; i3++) {
            InterfaceC4588y<? extends T> interfaceC4588y2 = interfaceC4588yArr[i3];
            if (aVar.isDisposed()) {
                return;
            }
            if (interfaceC4588y2 == null) {
                aVar.onError(new NullPointerException("One of the MaybeSources is null"));
                return;
            }
            interfaceC4588y2.mo18100a(aVar);
        }
        if (length == 0) {
            interfaceC4559v.onComplete();
        }
    }
}
