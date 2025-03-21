package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;

/* compiled from: CompletableConcatArray.java */
/* renamed from: g.a.y0.e.a.d */
/* loaded from: classes2.dex */
public final class C4651d extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i[] f17648a;

    /* compiled from: CompletableConcatArray.java */
    /* renamed from: g.a.y0.e.a.d$a */
    static final class a extends AtomicInteger implements InterfaceC4491f {
        private static final long serialVersionUID = -7965400327305809232L;
        final InterfaceC4491f actual;
        int index;

        /* renamed from: sd */
        final C4599k f17649sd = new C4599k();
        final InterfaceC4513i[] sources;

        a(InterfaceC4491f interfaceC4491f, InterfaceC4513i[] interfaceC4513iArr) {
            this.actual = interfaceC4491f;
            this.sources = interfaceC4513iArr;
        }

        void next() {
            if (!this.f17649sd.isDisposed() && getAndIncrement() == 0) {
                InterfaceC4513i[] interfaceC4513iArr = this.sources;
                while (!this.f17649sd.isDisposed()) {
                    int i2 = this.index;
                    this.index = i2 + 1;
                    if (i2 == interfaceC4513iArr.length) {
                        this.actual.onComplete();
                        return;
                    } else {
                        interfaceC4513iArr[i2].mo17074a(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            next();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17649sd.replace(interfaceC4552c);
        }
    }

    public C4651d(InterfaceC4513i[] interfaceC4513iArr) {
        this.f17648a = interfaceC4513iArr;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        a aVar = new a(interfaceC4491f, this.f17648a);
        interfaceC4491f.onSubscribe(aVar.f17649sd);
        aVar.next();
    }
}
