package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: CompletableCache.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.a.b */
/* loaded from: classes2.dex */
public final class C4647b extends AbstractC4474c implements InterfaceC4491f {

    /* renamed from: e */
    static final a[] f17637e = new a[0];

    /* renamed from: f */
    static final a[] f17638f = new a[0];

    /* renamed from: a */
    final InterfaceC4513i f17639a;

    /* renamed from: b */
    final AtomicReference<a[]> f17640b = new AtomicReference<>(f17637e);

    /* renamed from: c */
    final AtomicBoolean f17641c = new AtomicBoolean();

    /* renamed from: d */
    Throwable f17642d;

    /* compiled from: CompletableCache.java */
    /* renamed from: g.a.y0.e.a.b$a */
    final class a extends AtomicBoolean implements InterfaceC4552c {
        private static final long serialVersionUID = 8943152917179642732L;
        final InterfaceC4491f actual;

        a(InterfaceC4491f interfaceC4491f) {
            this.actual = interfaceC4491f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (compareAndSet(false, true)) {
                C4647b.this.m18311b(this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get();
        }
    }

    public C4647b(InterfaceC4513i interfaceC4513i) {
        this.f17639a = interfaceC4513i;
    }

    /* renamed from: a */
    boolean m18310a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f17640b.get();
            if (aVarArr == f17638f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17640b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        a aVar = new a(interfaceC4491f);
        interfaceC4491f.onSubscribe(aVar);
        if (m18310a(aVar)) {
            if (aVar.isDisposed()) {
                m18311b(aVar);
            }
            if (this.f17641c.compareAndSet(false, true)) {
                this.f17639a.mo17074a(this);
                return;
            }
            return;
        }
        Throwable th = this.f17642d;
        if (th != null) {
            interfaceC4491f.onError(th);
        } else {
            interfaceC4491f.onComplete();
        }
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onComplete() {
        for (a aVar : this.f17640b.getAndSet(f17638f)) {
            if (!aVar.get()) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onError(Throwable th) {
        this.f17642d = th;
        for (a aVar : this.f17640b.getAndSet(f17638f)) {
            if (!aVar.get()) {
                aVar.actual.onError(th);
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
    }

    /* renamed from: b */
    void m18311b(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f17640b.get();
            int length = aVarArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f17637e;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17640b.compareAndSet(aVarArr, aVarArr2));
    }
}
