package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelMap.java */
/* renamed from: g.a.y0.e.e.j */
/* loaded from: classes2.dex */
public final class C5054j<T, R> extends AbstractC4471b<R> {

    /* renamed from: a */
    final AbstractC4471b<T> f19614a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends R> f19615b;

    /* compiled from: ParallelMap.java */
    /* renamed from: g.a.y0.e.e.j$a */
    static final class a<T, R> implements InterfaceC4602a<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC4602a<? super R> f19616a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends R> f19617b;

        /* renamed from: c */
        InterfaceC5823d f19618c;

        /* renamed from: d */
        boolean f19619d;

        a(InterfaceC4602a<? super R> interfaceC4602a, InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
            this.f19616a = interfaceC4602a;
            this.f19617b = interfaceC4584o;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19618c.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19619d) {
                return;
            }
            this.f19619d = true;
            this.f19616a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19619d) {
                C4476a.m17152b(th);
            } else {
                this.f19619d = true;
                this.f19616a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19619d) {
                return;
            }
            try {
                this.f19616a.onNext(C4601b.m18284a(this.f19617b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19618c, interfaceC5823d)) {
                this.f19618c = interfaceC5823d;
                this.f19616a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f19618c.request(j2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            if (this.f19619d) {
                return false;
            }
            try {
                return this.f19616a.tryOnNext(C4601b.m18284a(this.f19617b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                onError(th);
                return false;
            }
        }
    }

    /* compiled from: ParallelMap.java */
    /* renamed from: g.a.y0.e.e.j$b */
    static final class b<T, R> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super R> f19620a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends R> f19621b;

        /* renamed from: c */
        InterfaceC5823d f19622c;

        /* renamed from: d */
        boolean f19623d;

        b(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
            this.f19620a = interfaceC5822c;
            this.f19621b = interfaceC4584o;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19622c.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19623d) {
                return;
            }
            this.f19623d = true;
            this.f19620a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19623d) {
                C4476a.m17152b(th);
            } else {
                this.f19623d = true;
                this.f19620a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19623d) {
                return;
            }
            try {
                this.f19620a.onNext(C4601b.m18284a(this.f19621b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19622c, interfaceC5823d)) {
                this.f19622c = interfaceC5823d;
                this.f19620a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f19622c.request(j2);
        }
    }

    public C5054j(AbstractC4471b<T> abstractC4471b, InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
        this.f19614a = abstractC4471b;
        this.f19615b = interfaceC4584o;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super R>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super T>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            for (int i2 = 0; i2 < length; i2++) {
                InterfaceC5822c<? super R> interfaceC5822c = interfaceC5822cArr[i2];
                if (interfaceC5822c instanceof InterfaceC4602a) {
                    interfaceC5822cArr2[i2] = new a((InterfaceC4602a) interfaceC5822c, this.f19615b);
                } else {
                    interfaceC5822cArr2[i2] = new b(interfaceC5822c, this.f19615b);
                }
            }
            this.f19614a.mo16994a(interfaceC5822cArr2);
        }
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19614a.mo16967a();
    }
}
