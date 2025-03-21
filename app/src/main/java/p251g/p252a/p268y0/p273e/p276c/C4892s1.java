package p251g.p252a.p268y0.p273e.p276c;

import java.util.Arrays;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p276c.C4889r1;
import p251g.p252a.p268y0.p273e.p276c.C4896u0;

/* compiled from: MaybeZipIterable.java */
/* renamed from: g.a.y0.e.c.s1 */
/* loaded from: classes2.dex */
public final class C4892s1<T, R> extends AbstractC4533s<R> {

    /* renamed from: a */
    final Iterable<? extends InterfaceC4588y<? extends T>> f18704a;

    /* renamed from: b */
    final InterfaceC4584o<? super Object[], ? extends R> f18705b;

    /* compiled from: MaybeZipIterable.java */
    /* renamed from: g.a.y0.e.c.s1$a */
    final class a implements InterfaceC4584o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(T t) throws Exception {
            return (R) C4601b.m18284a(C4892s1.this.f18705b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public C4892s1(Iterable<? extends InterfaceC4588y<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        this.f18704a = iterable;
        this.f18705b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        InterfaceC4588y[] interfaceC4588yArr = new InterfaceC4588y[8];
        try {
            InterfaceC4588y[] interfaceC4588yArr2 = interfaceC4588yArr;
            int i2 = 0;
            for (InterfaceC4588y<? extends T> interfaceC4588y : this.f18704a) {
                if (interfaceC4588y == null) {
                    EnumC4593e.error(new NullPointerException("One of the sources is null"), interfaceC4559v);
                    return;
                }
                if (i2 == interfaceC4588yArr2.length) {
                    interfaceC4588yArr2 = (InterfaceC4588y[]) Arrays.copyOf(interfaceC4588yArr2, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                interfaceC4588yArr2[i2] = interfaceC4588y;
                i2 = i3;
            }
            if (i2 == 0) {
                EnumC4593e.complete(interfaceC4559v);
                return;
            }
            if (i2 == 1) {
                interfaceC4588yArr2[0].mo18100a(new C4896u0.a(interfaceC4559v, new a()));
                return;
            }
            C4889r1.b bVar = new C4889r1.b(interfaceC4559v, i2, this.f18705b);
            interfaceC4559v.onSubscribe(bVar);
            for (int i4 = 0; i4 < i2 && !bVar.isDisposed(); i4++) {
                interfaceC4588yArr2[i4].mo18100a(bVar.observers[i4]);
            }
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4559v);
        }
    }
}
