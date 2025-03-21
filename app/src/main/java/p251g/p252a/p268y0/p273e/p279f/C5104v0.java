package p251g.p252a.p268y0.p273e.p279f;

import java.util.Arrays;
import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p279f.C5076h0;
import p251g.p252a.p268y0.p273e.p279f.C5102u0;

/* compiled from: SingleZipIterable.java */
/* renamed from: g.a.y0.e.f.v0 */
/* loaded from: classes2.dex */
public final class C5104v0<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final Iterable<? extends InterfaceC4530q0<? extends T>> f19809a;

    /* renamed from: b */
    final InterfaceC4584o<? super Object[], ? extends R> f19810b;

    /* compiled from: SingleZipIterable.java */
    /* renamed from: g.a.y0.e.f.v0$a */
    final class a implements InterfaceC4584o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(T t) throws Exception {
            return (R) C4601b.m18284a(C5104v0.this.f19810b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public C5104v0(Iterable<? extends InterfaceC4530q0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        this.f19809a = iterable;
        this.f19810b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        InterfaceC4530q0[] interfaceC4530q0Arr = new InterfaceC4530q0[8];
        try {
            InterfaceC4530q0[] interfaceC4530q0Arr2 = interfaceC4530q0Arr;
            int i2 = 0;
            for (InterfaceC4530q0<? extends T> interfaceC4530q0 : this.f19809a) {
                if (interfaceC4530q0 == null) {
                    EnumC4593e.error(new NullPointerException("One of the sources is null"), interfaceC4524n0);
                    return;
                }
                if (i2 == interfaceC4530q0Arr2.length) {
                    interfaceC4530q0Arr2 = (InterfaceC4530q0[]) Arrays.copyOf(interfaceC4530q0Arr2, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                interfaceC4530q0Arr2[i2] = interfaceC4530q0;
                i2 = i3;
            }
            if (i2 == 0) {
                EnumC4593e.error(new NoSuchElementException(), interfaceC4524n0);
                return;
            }
            if (i2 == 1) {
                interfaceC4530q0Arr2[0].mo17490a(new C5076h0.a(interfaceC4524n0, new a()));
                return;
            }
            C5102u0.b bVar = new C5102u0.b(interfaceC4524n0, i2, this.f19810b);
            interfaceC4524n0.onSubscribe(bVar);
            for (int i4 = 0; i4 < i2 && !bVar.isDisposed(); i4++) {
                interfaceC4530q0Arr2[i4].mo17490a(bVar.observers[i4]);
            }
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4524n0);
        }
    }
}
