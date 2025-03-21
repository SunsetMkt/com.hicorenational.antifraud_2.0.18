package p286h;

import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;

/* compiled from: UShortArray.kt */
/* renamed from: h.v1 */
/* loaded from: classes2.dex */
public final class C5631v1 {
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final short[] m23004a(int i2, InterfaceC5506l<? super Integer, C5611t1> interfaceC5506l) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = interfaceC5506l.invoke(Integer.valueOf(i3)).m22913a();
        }
        return C5619u1.m22932b(sArr);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final short[] m23005a(short... sArr) {
        return sArr;
    }
}
