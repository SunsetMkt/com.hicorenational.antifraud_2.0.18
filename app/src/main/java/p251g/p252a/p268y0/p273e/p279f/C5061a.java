package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: SingleAmb.java */
/* renamed from: g.a.y0.e.f.a */
/* loaded from: classes2.dex */
public final class C5061a<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    private final InterfaceC4530q0<? extends T>[] f19662a;

    /* renamed from: b */
    private final Iterable<? extends InterfaceC4530q0<? extends T>> f19663b;

    /* compiled from: SingleAmb.java */
    /* renamed from: g.a.y0.e.f.a$a */
    static final class a<T> extends AtomicBoolean implements InterfaceC4524n0<T> {
        private static final long serialVersionUID = -1944085461036028108L;

        /* renamed from: s */
        final InterfaceC4524n0<? super T> f19664s;
        final C4551b set;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, C4551b c4551b) {
            this.f19664s = interfaceC4524n0;
            this.set = c4551b;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                C4476a.m17152b(th);
            } else {
                this.set.dispose();
                this.f19664s.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.set.mo18181b(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.f19664s.onSuccess(t);
            }
        }
    }

    public C5061a(InterfaceC4530q0<? extends T>[] interfaceC4530q0Arr, Iterable<? extends InterfaceC4530q0<? extends T>> iterable) {
        this.f19662a = interfaceC4530q0Arr;
        this.f19663b = iterable;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        int length;
        InterfaceC4530q0<? extends T>[] interfaceC4530q0Arr = this.f19662a;
        if (interfaceC4530q0Arr == null) {
            interfaceC4530q0Arr = new InterfaceC4530q0[8];
            try {
                length = 0;
                for (InterfaceC4530q0<? extends T> interfaceC4530q0 : this.f19663b) {
                    if (interfaceC4530q0 == null) {
                        EnumC4593e.error(new NullPointerException("One of the sources is null"), interfaceC4524n0);
                        return;
                    }
                    if (length == interfaceC4530q0Arr.length) {
                        InterfaceC4530q0<? extends T>[] interfaceC4530q0Arr2 = new InterfaceC4530q0[(length >> 2) + length];
                        System.arraycopy(interfaceC4530q0Arr, 0, interfaceC4530q0Arr2, 0, length);
                        interfaceC4530q0Arr = interfaceC4530q0Arr2;
                    }
                    int i2 = length + 1;
                    interfaceC4530q0Arr[length] = interfaceC4530q0;
                    length = i2;
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC4593e.error(th, interfaceC4524n0);
                return;
            }
        } else {
            length = interfaceC4530q0Arr.length;
        }
        C4551b c4551b = new C4551b();
        a aVar = new a(interfaceC4524n0, c4551b);
        interfaceC4524n0.onSubscribe(c4551b);
        for (int i3 = 0; i3 < length; i3++) {
            InterfaceC4530q0<? extends T> interfaceC4530q02 = interfaceC4530q0Arr[i3];
            if (aVar.get()) {
                return;
            }
            if (interfaceC4530q02 == null) {
                c4551b.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (aVar.compareAndSet(false, true)) {
                    interfaceC4524n0.onError(nullPointerException);
                    return;
                } else {
                    C4476a.m17152b(nullPointerException);
                    return;
                }
            }
            interfaceC4530q02.mo17490a(aVar);
        }
    }
}
