package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5174n;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: ObservableCache.java */
/* renamed from: g.a.y0.e.d.r */
/* loaded from: classes2.dex */
public final class C5000r<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final a<T> f19339b;

    /* renamed from: c */
    final AtomicBoolean f19340c;

    /* compiled from: ObservableCache.java */
    /* renamed from: g.a.y0.e.d.r$a */
    static final class a<T> extends C5174n implements InterfaceC4514i0<T> {

        /* renamed from: k */
        static final b[] f19341k = new b[0];

        /* renamed from: l */
        static final b[] f19342l = new b[0];

        /* renamed from: f */
        final AbstractC4469b0<? extends T> f19343f;

        /* renamed from: g */
        final C4599k f19344g;

        /* renamed from: h */
        final AtomicReference<b<T>[]> f19345h;

        /* renamed from: i */
        volatile boolean f19346i;

        /* renamed from: j */
        boolean f19347j;

        a(AbstractC4469b0<? extends T> abstractC4469b0, int i2) {
            super(i2);
            this.f19343f = abstractC4469b0;
            this.f19345h = new AtomicReference<>(f19341k);
            this.f19344g = new C4599k();
        }

        /* renamed from: a */
        public boolean m18516a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f19345h.get();
                if (bVarArr == f19342l) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f19345h.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        /* renamed from: b */
        public void m18517b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f19345h.get();
                int length = bVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (bVarArr[i3].equals(bVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f19341k;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f19345h.compareAndSet(bVarArr, bVarArr2));
        }

        /* renamed from: c */
        public void m18518c() {
            this.f19343f.subscribe(this);
            this.f19346i = true;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19347j) {
                return;
            }
            this.f19347j = true;
            m18633a(EnumC5177q.complete());
            this.f19344g.dispose();
            for (b<T> bVar : this.f19345h.getAndSet(f19342l)) {
                bVar.replay();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19347j) {
                return;
            }
            this.f19347j = true;
            m18633a(EnumC5177q.error(th));
            this.f19344g.dispose();
            for (b<T> bVar : this.f19345h.getAndSet(f19342l)) {
                bVar.replay();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19347j) {
                return;
            }
            m18633a(EnumC5177q.next(t));
            for (b<T> bVar : this.f19345h.get()) {
                bVar.replay();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19344g.update(interfaceC4552c);
        }
    }

    /* compiled from: ObservableCache.java */
    /* renamed from: g.a.y0.e.d.r$b */
    static final class b<T> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = 7058506693698832024L;
        volatile boolean cancelled;
        final InterfaceC4514i0<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final a<T> state;

        b(InterfaceC4514i0<? super T> interfaceC4514i0, a<T> aVar) {
            this.child = interfaceC4514i0;
            this.state = aVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.m18517b(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC4514i0<? super T> interfaceC4514i0 = this.child;
            int i2 = 1;
            while (!this.cancelled) {
                int m18635b = this.state.m18635b();
                if (m18635b != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.m18634a();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - 1;
                    int i3 = this.index;
                    int i4 = this.currentIndexInBuffer;
                    while (i3 < m18635b) {
                        if (this.cancelled) {
                            return;
                        }
                        if (i4 == length) {
                            objArr = (Object[]) objArr[length];
                            i4 = 0;
                        }
                        if (EnumC5177q.accept(objArr[i4], interfaceC4514i0)) {
                            return;
                        }
                        i4++;
                        i3++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    this.index = i3;
                    this.currentIndexInBuffer = i4;
                    this.currentBuffer = objArr;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    private C5000r(AbstractC4469b0<T> abstractC4469b0, a<T> aVar) {
        super(abstractC4469b0);
        this.f19339b = aVar;
        this.f19340c = new AtomicBoolean();
    }

    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m18511a(AbstractC4469b0<T> abstractC4469b0) {
        return m18512a((AbstractC4469b0) abstractC4469b0, 16);
    }

    /* renamed from: O */
    int m18513O() {
        return this.f19339b.m18635b();
    }

    /* renamed from: P */
    boolean m18514P() {
        return this.f19339b.f19345h.get().length != 0;
    }

    /* renamed from: Q */
    boolean m18515Q() {
        return this.f19339b.f19346i;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        b<T> bVar = new b<>(interfaceC4514i0, this.f19339b);
        interfaceC4514i0.onSubscribe(bVar);
        this.f19339b.m18516a((b) bVar);
        if (!this.f19340c.get() && this.f19340c.compareAndSet(false, true)) {
            this.f19339b.m18518c();
        }
        bVar.replay();
    }

    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m18512a(AbstractC4469b0<T> abstractC4469b0, int i2) {
        C4601b.m18279a(i2, "capacityHint");
        return C4476a.m17119a(new C5000r(abstractC4469b0, new a(abstractC4469b0, i2)));
    }
}
