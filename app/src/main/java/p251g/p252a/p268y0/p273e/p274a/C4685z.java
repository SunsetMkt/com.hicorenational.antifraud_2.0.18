package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: CompletableMergeArray.java */
/* renamed from: g.a.y0.e.a.z */
/* loaded from: classes2.dex */
public final class C4685z extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i[] f17758a;

    /* compiled from: CompletableMergeArray.java */
    /* renamed from: g.a.y0.e.a.z$a */
    static final class a extends AtomicInteger implements InterfaceC4491f {
        private static final long serialVersionUID = -8360547806504310570L;
        final InterfaceC4491f actual;
        final AtomicBoolean once;
        final C4551b set;

        a(InterfaceC4491f interfaceC4491f, AtomicBoolean atomicBoolean, C4551b c4551b, int i2) {
            this.actual = interfaceC4491f;
            this.once = atomicBoolean;
            this.set = c4551b;
            lazySet(i2);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.set.mo18181b(interfaceC4552c);
        }
    }

    public C4685z(InterfaceC4513i[] interfaceC4513iArr) {
        this.f17758a = interfaceC4513iArr;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        C4551b c4551b = new C4551b();
        a aVar = new a(interfaceC4491f, new AtomicBoolean(), c4551b, this.f17758a.length + 1);
        interfaceC4491f.onSubscribe(c4551b);
        for (InterfaceC4513i interfaceC4513i : this.f17758a) {
            if (c4551b.isDisposed()) {
                return;
            }
            if (interfaceC4513i == null) {
                c4551b.dispose();
                aVar.onError(new NullPointerException("A completable source is null"));
                return;
            }
            interfaceC4513i.mo17074a(aVar);
        }
        aVar.onComplete();
    }
}
