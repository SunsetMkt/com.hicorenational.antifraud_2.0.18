package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableAmb.java */
/* renamed from: g.a.y0.e.b.h */
/* loaded from: classes2.dex */
public final class C4728h<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC5821b<? extends T>[] f17925b;

    /* renamed from: c */
    final Iterable<? extends InterfaceC5821b<? extends T>> f17926c;

    /* compiled from: FlowableAmb.java */
    /* renamed from: g.a.y0.e.b.h$b */
    static final class b<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -1185974347409665484L;
        final InterfaceC5822c<? super T> actual;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final a<T> parent;
        boolean won;

        b(a<T> aVar, int i2, InterfaceC5822c<? super T> interfaceC5822c) {
            this.parent = aVar;
            this.index = i2;
            this.actual = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (!this.parent.m18324a(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.m18324a(this.index)) {
                this.won = true;
                this.actual.onError(th);
            } else {
                get().cancel();
                C4476a.m17152b(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (!this.parent.m18324a(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.actual.onNext(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            EnumC5160j.deferredSetOnce(this, this.missedRequested, interfaceC5823d);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            EnumC5160j.deferredRequest(this, this.missedRequested, j2);
        }
    }

    public C4728h(InterfaceC5821b<? extends T>[] interfaceC5821bArr, Iterable<? extends InterfaceC5821b<? extends T>> iterable) {
        this.f17925b = interfaceC5821bArr;
        this.f17926c = iterable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        int length;
        InterfaceC5821b<? extends T>[] interfaceC5821bArr = this.f17925b;
        if (interfaceC5821bArr == null) {
            interfaceC5821bArr = new InterfaceC5821b[8];
            try {
                length = 0;
                for (InterfaceC5821b<? extends T> interfaceC5821b : this.f17926c) {
                    if (interfaceC5821b == null) {
                        EnumC5157g.error(new NullPointerException("One of the sources is null"), interfaceC5822c);
                        return;
                    }
                    if (length == interfaceC5821bArr.length) {
                        InterfaceC5821b<? extends T>[] interfaceC5821bArr2 = new InterfaceC5821b[(length >> 2) + length];
                        System.arraycopy(interfaceC5821bArr, 0, interfaceC5821bArr2, 0, length);
                        interfaceC5821bArr = interfaceC5821bArr2;
                    }
                    int i2 = length + 1;
                    interfaceC5821bArr[length] = interfaceC5821b;
                    length = i2;
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC5157g.error(th, interfaceC5822c);
                return;
            }
        } else {
            length = interfaceC5821bArr.length;
        }
        if (length == 0) {
            EnumC5157g.complete(interfaceC5822c);
        } else if (length == 1) {
            interfaceC5821bArr[0].subscribe(interfaceC5822c);
        } else {
            new a(interfaceC5822c, length).m18323a(interfaceC5821bArr);
        }
    }

    /* compiled from: FlowableAmb.java */
    /* renamed from: g.a.y0.e.b.h$a */
    static final class a<T> implements InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f17927a;

        /* renamed from: b */
        final b<T>[] f17928b;

        /* renamed from: c */
        final AtomicInteger f17929c = new AtomicInteger();

        a(InterfaceC5822c<? super T> interfaceC5822c, int i2) {
            this.f17927a = interfaceC5822c;
            this.f17928b = new b[i2];
        }

        /* renamed from: a */
        public void m18323a(InterfaceC5821b<? extends T>[] interfaceC5821bArr) {
            b<T>[] bVarArr = this.f17928b;
            int length = bVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr[i2] = new b<>(this, i3, this.f17927a);
                i2 = i3;
            }
            this.f17929c.lazySet(0);
            this.f17927a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f17929c.get() == 0; i4++) {
                interfaceC5821bArr[i4].subscribe(bVarArr[i4]);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.f17929c.get() != -1) {
                this.f17929c.lazySet(-1);
                for (b<T> bVar : this.f17928b) {
                    bVar.cancel();
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                int i2 = this.f17929c.get();
                if (i2 > 0) {
                    this.f17928b[i2 - 1].request(j2);
                    return;
                }
                if (i2 == 0) {
                    for (b<T> bVar : this.f17928b) {
                        bVar.request(j2);
                    }
                }
            }
        }

        /* renamed from: a */
        public boolean m18324a(int i2) {
            int i3 = 0;
            if (this.f17929c.get() != 0 || !this.f17929c.compareAndSet(0, i2)) {
                return false;
            }
            b<T>[] bVarArr = this.f17928b;
            int length = bVarArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i2) {
                    bVarArr[i3].cancel();
                }
                i3 = i4;
            }
            return true;
        }
    }
}
