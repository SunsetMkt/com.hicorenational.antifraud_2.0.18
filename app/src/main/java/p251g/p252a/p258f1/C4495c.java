package p251g.p252a.p258f1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: CompletableSubject.java */
/* renamed from: g.a.f1.c */
/* loaded from: classes2.dex */
public final class C4495c extends AbstractC4474c implements InterfaceC4491f {

    /* renamed from: d */
    static final a[] f17364d = new a[0];

    /* renamed from: e */
    static final a[] f17365e = new a[0];

    /* renamed from: c */
    Throwable f17368c;

    /* renamed from: b */
    final AtomicBoolean f17367b = new AtomicBoolean();

    /* renamed from: a */
    final AtomicReference<a[]> f17366a = new AtomicReference<>(f17364d);

    /* compiled from: CompletableSubject.java */
    /* renamed from: g.a.f1.c$a */
    static final class a extends AtomicReference<C4495c> implements InterfaceC4552c {
        private static final long serialVersionUID = -7650903191002190468L;
        final InterfaceC4491f actual;

        a(InterfaceC4491f interfaceC4491f, C4495c c4495c) {
            this.actual = interfaceC4491f;
            lazySet(c4495c);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            C4495c andSet = getAndSet(null);
            if (andSet != null) {
                andSet.m17318b(this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    C4495c() {
    }

    @InterfaceC4544d
    /* renamed from: x */
    public static C4495c m17316x() {
        return new C4495c();
    }

    /* renamed from: a */
    boolean m17317a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f17366a.get();
            if (aVarArr == f17365e) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17366a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        a aVar = new a(interfaceC4491f, this);
        interfaceC4491f.onSubscribe(aVar);
        if (m17317a(aVar)) {
            if (aVar.isDisposed()) {
                m17318b(aVar);
            }
        } else {
            Throwable th = this.f17368c;
            if (th != null) {
                interfaceC4491f.onError(th);
            } else {
                interfaceC4491f.onComplete();
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onComplete() {
        if (this.f17367b.compareAndSet(false, true)) {
            for (a aVar : this.f17366a.getAndSet(f17365e)) {
                aVar.actual.onComplete();
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("Null errors are not allowed in 2.x");
        }
        if (!this.f17367b.compareAndSet(false, true)) {
            C4476a.m17152b(th);
            return;
        }
        this.f17368c = th;
        for (a aVar : this.f17366a.getAndSet(f17365e)) {
            aVar.actual.onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (this.f17366a.get() == f17365e) {
            interfaceC4552c.dispose();
        }
    }

    /* renamed from: s */
    public Throwable m17319s() {
        if (this.f17366a.get() == f17365e) {
            return this.f17368c;
        }
        return null;
    }

    /* renamed from: t */
    public boolean m17320t() {
        return this.f17366a.get() == f17365e && this.f17368c == null;
    }

    /* renamed from: u */
    public boolean m17321u() {
        return this.f17366a.get().length != 0;
    }

    /* renamed from: v */
    public boolean m17322v() {
        return this.f17366a.get() == f17365e && this.f17368c != null;
    }

    /* renamed from: w */
    int m17323w() {
        return this.f17366a.get().length;
    }

    /* renamed from: b */
    void m17318b(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f17366a.get();
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
                aVarArr2 = f17364d;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17366a.compareAndSet(aVarArr, aVarArr2));
    }
}
