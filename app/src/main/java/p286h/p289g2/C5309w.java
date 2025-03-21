package p286h.p289g2;

import java.util.List;
import p286h.p309q2.p310s.InterfaceC5506l;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* renamed from: h.g2.w */
/* loaded from: classes2.dex */
public final class C5309w extends C5262g0 {
    private C5309w() {
    }

    /* renamed from: C */
    public static /* bridge */ /* synthetic */ <T> T m21709C(@InterfaceC5816d Iterable<? extends T> iterable) {
        return (T) C5262g0.m19746C(iterable);
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ Appendable m21715a(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, InterfaceC5506l interfaceC5506l, int i3, Object obj) {
        Appendable m19774a;
        m19774a = C5262g0.m19774a(iterable, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i2, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : interfaceC5506l);
        return m19774a;
    }

    /* renamed from: r */
    public static /* bridge */ /* synthetic */ <T> T m21735r(@InterfaceC5816d List<? extends T> list) {
        return (T) C5262g0.m19921r((List) list);
    }

    @InterfaceC5817e
    /* renamed from: y */
    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> T m21736y(@InterfaceC5816d Iterable<? extends T> iterable) {
        return (T) C5262g0.m19943y(iterable);
    }
}
