package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: MaybeConcatArray.java */
/* renamed from: g.a.y0.e.c.e */
/* loaded from: classes2.dex */
public final class C4848e<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC4588y<? extends T>[] f18595b;

    /* compiled from: MaybeConcatArray.java */
    /* renamed from: g.a.y0.e.c.e$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4559v<T>, InterfaceC5823d {
        private static final long serialVersionUID = 3520831347801429610L;
        final InterfaceC5822c<? super T> actual;
        int index;
        long produced;
        final InterfaceC4588y<? extends T>[] sources;
        final AtomicLong requested = new AtomicLong();
        final C4599k disposables = new C4599k();
        final AtomicReference<Object> current = new AtomicReference<>(EnumC5177q.COMPLETE);

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4588y<? extends T>[] interfaceC4588yArr) {
            this.actual = interfaceC5822c;
            this.sources = interfaceC4588yArr;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<Object> atomicReference = this.current;
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            C4599k c4599k = this.disposables;
            while (!c4599k.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z = true;
                    if (obj != EnumC5177q.COMPLETE) {
                        long j2 = this.produced;
                        if (j2 != this.requested.get()) {
                            this.produced = j2 + 1;
                            atomicReference.lazySet(null);
                            interfaceC5822c.onNext(obj);
                        } else {
                            z = false;
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (z && !c4599k.isDisposed()) {
                        int i2 = this.index;
                        InterfaceC4588y<? extends T>[] interfaceC4588yArr = this.sources;
                        if (i2 == interfaceC4588yArr.length) {
                            interfaceC5822c.onComplete();
                            return;
                        } else {
                            this.index = i2 + 1;
                            interfaceC4588yArr[i2].mo18100a(this);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.current.lazySet(EnumC5177q.COMPLETE);
            drain();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.disposables.replace(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }
    }

    public C4848e(InterfaceC4588y<? extends T>[] interfaceC4588yArr) {
        this.f18595b = interfaceC4588yArr;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        a aVar = new a(interfaceC5822c, this.f18595b);
        interfaceC5822c.onSubscribe(aVar);
        aVar.drain();
    }
}
