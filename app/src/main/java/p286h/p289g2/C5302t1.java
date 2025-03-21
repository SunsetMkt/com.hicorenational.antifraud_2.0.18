package p286h.p289g2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Arrays;
import java.util.NoSuchElementException;
import p286h.C5230f1;
import p286h.C5239g1;
import p286h.C5341j1;
import p286h.C5354k1;
import p286h.C5441n1;
import p286h.C5468o1;
import p286h.C5611t1;
import p286h.C5619u1;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5352k;
import p286h.p309q2.InterfaceC5484h;
import p286h.p309q2.p311t.C5544i0;
import p286h.p318u2.AbstractC5625f;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: UArraysKt.kt */
@InterfaceC5216c(level = EnumC5220d.HIDDEN, message = "Provided for binary compatibility")
/* renamed from: h.g2.t1 */
/* loaded from: classes2.dex */
public final class C5302t1 {

    /* renamed from: a */
    public static final C5302t1 f20184a = new C5302t1();

    private C5302t1() {
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final int m21690a(@InterfaceC5816d int[] iArr, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(iArr, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        if (C5354k1.m21988e(iArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return C5354k1.m21982b(iArr, abstractC5625f.mo22948c(C5354k1.m21984c(iArr)));
    }

    @InterfaceC5352k
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: b */
    public static final String m21700b(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$contentToString");
        return C5262g0.m19786a(C5354k1.m21976a(iArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: c */
    public static final C5341j1[] m21704c(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$toTypedArray");
        int m21984c = C5354k1.m21984c(iArr);
        C5341j1[] c5341j1Arr = new C5341j1[m21984c];
        for (int i2 = 0; i2 < m21984c; i2++) {
            c5341j1Arr[i2] = C5341j1.m21921a(C5354k1.m21982b(iArr, i2));
        }
        return c5341j1Arr;
    }

    @InterfaceC5352k
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: b */
    public static final String m21701b(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$contentToString");
        return C5262g0.m19786a(C5468o1.m22415a(jArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: c */
    public static final C5441n1[] m21705c(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$toTypedArray");
        int m22423c = C5468o1.m22423c(jArr);
        C5441n1[] c5441n1Arr = new C5441n1[m22423c];
        for (int i2 = 0; i2 < m22423c; i2++) {
            c5441n1Arr[i2] = C5441n1.m22197a(C5468o1.m22414a(jArr, i2));
        }
        return c5441n1Arr;
    }

    @InterfaceC5352k
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: b */
    public static final String m21699b(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$contentToString");
        return C5262g0.m19786a(C5239g1.m18974a(bArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: c */
    public static final C5230f1[] m21703c(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$toTypedArray");
        int m18982c = C5239g1.m18982c(bArr);
        C5230f1[] c5230f1Arr = new C5230f1[m18982c];
        for (int i2 = 0; i2 < m18982c; i2++) {
            c5230f1Arr[i2] = C5230f1.m18921a(C5239g1.m18973a(bArr, i2));
        }
        return c5230f1Arr;
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final long m21693a(@InterfaceC5816d long[] jArr, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(jArr, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        if (!C5468o1.m22426e(jArr)) {
            return C5468o1.m22414a(jArr, abstractC5625f.mo22948c(C5468o1.m22423c(jArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @InterfaceC5352k
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: b */
    public static final String m21702b(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$contentToString");
        return C5262g0.m19786a(C5619u1.m22924a(sArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: c */
    public static final C5611t1[] m21706c(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$toTypedArray");
        int m22933c = C5619u1.m22933c(sArr);
        C5611t1[] c5611t1Arr = new C5611t1[m22933c];
        for (int i2 = 0; i2 < m22933c; i2++) {
            c5611t1Arr[i2] = C5611t1.m22867a(C5619u1.m22925a(sArr, i2));
        }
        return c5611t1Arr;
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final byte m21687a(@InterfaceC5816d byte[] bArr, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(bArr, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        if (!C5239g1.m18985e(bArr)) {
            return C5239g1.m18973a(bArr, abstractC5625f.mo22948c(C5239g1.m18982c(bArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final short m21694a(@InterfaceC5816d short[] sArr, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(sArr, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        if (!C5619u1.m22936e(sArr)) {
            return C5619u1.m22925a(sArr, abstractC5625f.mo22948c(C5619u1.m22933c(sArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final boolean m21696a(@InterfaceC5816d int[] iArr, @InterfaceC5816d int[] iArr2) {
        C5544i0.m22546f(iArr, "$this$contentEquals");
        C5544i0.m22546f(iArr2, DispatchConstants.OTHER);
        return Arrays.equals(iArr, iArr2);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final boolean m21697a(@InterfaceC5816d long[] jArr, @InterfaceC5816d long[] jArr2) {
        C5544i0.m22546f(jArr, "$this$contentEquals");
        C5544i0.m22546f(jArr2, DispatchConstants.OTHER);
        return Arrays.equals(jArr, jArr2);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final boolean m21695a(@InterfaceC5816d byte[] bArr, @InterfaceC5816d byte[] bArr2) {
        C5544i0.m22546f(bArr, "$this$contentEquals");
        C5544i0.m22546f(bArr2, DispatchConstants.OTHER);
        return Arrays.equals(bArr, bArr2);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final boolean m21698a(@InterfaceC5816d short[] sArr, @InterfaceC5816d short[] sArr2) {
        C5544i0.m22546f(sArr, "$this$contentEquals");
        C5544i0.m22546f(sArr2, DispatchConstants.OTHER);
        return Arrays.equals(sArr, sArr2);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final int m21689a(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$contentHashCode");
        return Arrays.hashCode(iArr);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final int m21691a(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$contentHashCode");
        return Arrays.hashCode(jArr);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final int m21688a(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$contentHashCode");
        return Arrays.hashCode(bArr);
    }

    @InterfaceC5352k
    @InterfaceC5484h
    /* renamed from: a */
    public static final int m21692a(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$contentHashCode");
        return Arrays.hashCode(sArr);
    }
}
