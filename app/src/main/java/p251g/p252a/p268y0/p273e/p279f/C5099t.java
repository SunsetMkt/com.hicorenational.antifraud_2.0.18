package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleEquals.java */
/* renamed from: g.a.y0.e.f.t */
/* loaded from: classes2.dex */
public final class C5099t<T> extends AbstractC4518k0<Boolean> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19789a;

    /* renamed from: b */
    final InterfaceC4530q0<? extends T> f19790b;

    /* compiled from: SingleEquals.java */
    /* renamed from: g.a.y0.e.f.t$a */
    static class a<T> implements InterfaceC4524n0<T> {

        /* renamed from: a */
        final int f19791a;

        /* renamed from: b */
        final C4551b f19792b;

        /* renamed from: c */
        final Object[] f19793c;

        /* renamed from: d */
        final InterfaceC4524n0<? super Boolean> f19794d;

        /* renamed from: e */
        final AtomicInteger f19795e;

        a(int i2, C4551b c4551b, Object[] objArr, InterfaceC4524n0<? super Boolean> interfaceC4524n0, AtomicInteger atomicInteger) {
            this.f19791a = i2;
            this.f19792b = c4551b;
            this.f19793c = objArr;
            this.f19794d = interfaceC4524n0;
            this.f19795e = atomicInteger;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            int i2;
            do {
                i2 = this.f19795e.get();
                if (i2 >= 2) {
                    C4476a.m17152b(th);
                    return;
                }
            } while (!this.f19795e.compareAndSet(i2, 2));
            this.f19792b.dispose();
            this.f19794d.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19792b.mo18181b(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19793c[this.f19791a] = t;
            if (this.f19795e.incrementAndGet() == 2) {
                InterfaceC4524n0<? super Boolean> interfaceC4524n0 = this.f19794d;
                Object[] objArr = this.f19793c;
                interfaceC4524n0.onSuccess(Boolean.valueOf(C4601b.m18285a(objArr[0], objArr[1])));
            }
        }
    }

    public C5099t(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4530q0<? extends T> interfaceC4530q02) {
        this.f19789a = interfaceC4530q0;
        this.f19790b = interfaceC4530q02;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        C4551b c4551b = new C4551b();
        interfaceC4524n0.onSubscribe(c4551b);
        this.f19789a.mo17490a(new a(0, c4551b, objArr, interfaceC4524n0, atomicInteger));
        this.f19790b.mo17490a(new a(1, c4551b, objArr, interfaceC4524n0, atomicInteger));
    }
}
