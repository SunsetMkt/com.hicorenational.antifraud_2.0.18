package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p268y0.p283i.C5159i;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableConcatArray.java */
/* renamed from: g.a.y0.e.b.v */
/* loaded from: classes2.dex */
public final class C4811v<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC5821b<? extends T>[] f18448b;

    /* renamed from: c */
    final boolean f18449c;

    /* compiled from: FlowableConcatArray.java */
    /* renamed from: g.a.y0.e.b.v$a */
    static final class a<T> extends C5159i implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final InterfaceC5822c<? super T> actual;
        final boolean delayError;
        List<Throwable> errors;
        int index;
        long produced;
        final InterfaceC5821b<? extends T>[] sources;
        final AtomicInteger wip = new AtomicInteger();

        a(InterfaceC5821b<? extends T>[] interfaceC5821bArr, boolean z, InterfaceC5822c<? super T> interfaceC5822c) {
            this.actual = interfaceC5822c;
            this.sources = interfaceC5821bArr;
            this.delayError = z;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                InterfaceC5821b<? extends T>[] interfaceC5821bArr = this.sources;
                int length = interfaceC5821bArr.length;
                int i2 = this.index;
                while (i2 != length) {
                    InterfaceC5821b<? extends T> interfaceC5821b = interfaceC5821bArr[i2];
                    if (interfaceC5821b == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (!this.delayError) {
                            this.actual.onError(nullPointerException);
                            return;
                        }
                        List list = this.errors;
                        if (list == null) {
                            list = new ArrayList((length - i2) + 1);
                            this.errors = list;
                        }
                        list.add(nullPointerException);
                        i2++;
                    } else {
                        long j2 = this.produced;
                        if (j2 != 0) {
                            this.produced = 0L;
                            produced(j2);
                        }
                        interfaceC5821b.subscribe(this);
                        i2++;
                        this.index = i2;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.errors;
                if (list2 == null) {
                    this.actual.onComplete();
                } else if (list2.size() == 1) {
                    this.actual.onError(list2.get(0));
                } else {
                    this.actual.onError(new C4560a(list2));
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (!this.delayError) {
                this.actual.onError(th);
                return;
            }
            List list = this.errors;
            if (list == null) {
                list = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = list;
            }
            list.add(th);
            onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            setSubscription(interfaceC5823d);
        }
    }

    public C4811v(InterfaceC5821b<? extends T>[] interfaceC5821bArr, boolean z) {
        this.f18448b = interfaceC5821bArr;
        this.f18449c = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        a aVar = new a(this.f18448b, this.f18449c, interfaceC5822c);
        interfaceC5822c.onSubscribe(aVar);
        aVar.onComplete();
    }
}
