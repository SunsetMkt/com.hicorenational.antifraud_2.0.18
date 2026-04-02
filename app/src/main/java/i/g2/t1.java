package i.g2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: UArraysKt.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.c(level = i.d.HIDDEN, message = "Provided for binary compatibility")
public final class t1 {
    public static final t1 a = new t1();

    private t1() {
    }

    @i.q2.h
    @i.k
    public static final int a(@j.c.a.d int[] iArr, @j.c.a.d i.u2.f fVar) {
        i.q2.t.i0.f(iArr, "$this$random");
        i.q2.t.i0.f(fVar, "random");
        if (i.k1.e(iArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return i.k1.b(iArr, fVar.c(i.k1.c(iArr)));
    }

    @i.q2.h
    @i.k
    @j.c.a.d
    public static final String b(@j.c.a.d int[] iArr) {
        i.q2.t.i0.f(iArr, "$this$contentToString");
        return g0.a(i.k1.a(iArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @i.q2.h
    @i.k
    @j.c.a.d
    public static final i.j1[] c(@j.c.a.d int[] iArr) {
        i.q2.t.i0.f(iArr, "$this$toTypedArray");
        int iC = i.k1.c(iArr);
        i.j1[] j1VarArr = new i.j1[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            j1VarArr[i2] = i.j1.a(i.k1.b(iArr, i2));
        }
        return j1VarArr;
    }

    @i.q2.h
    @i.k
    @j.c.a.d
    public static final String b(@j.c.a.d long[] jArr) {
        i.q2.t.i0.f(jArr, "$this$contentToString");
        return g0.a(i.o1.a(jArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @i.q2.h
    @i.k
    @j.c.a.d
    public static final i.n1[] c(@j.c.a.d long[] jArr) {
        i.q2.t.i0.f(jArr, "$this$toTypedArray");
        int iC = i.o1.c(jArr);
        i.n1[] n1VarArr = new i.n1[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            n1VarArr[i2] = i.n1.a(i.o1.a(jArr, i2));
        }
        return n1VarArr;
    }

    @i.q2.h
    @i.k
    @j.c.a.d
    public static final String b(@j.c.a.d byte[] bArr) {
        i.q2.t.i0.f(bArr, "$this$contentToString");
        return g0.a(i.g1.a(bArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @i.q2.h
    @i.k
    @j.c.a.d
    public static final i.f1[] c(@j.c.a.d byte[] bArr) {
        i.q2.t.i0.f(bArr, "$this$toTypedArray");
        int iC = i.g1.c(bArr);
        i.f1[] f1VarArr = new i.f1[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            f1VarArr[i2] = i.f1.a(i.g1.a(bArr, i2));
        }
        return f1VarArr;
    }

    @i.q2.h
    @i.k
    public static final long a(@j.c.a.d long[] jArr, @j.c.a.d i.u2.f fVar) {
        i.q2.t.i0.f(jArr, "$this$random");
        i.q2.t.i0.f(fVar, "random");
        if (!i.o1.e(jArr)) {
            return i.o1.a(jArr, fVar.c(i.o1.c(jArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @i.q2.h
    @i.k
    @j.c.a.d
    public static final String b(@j.c.a.d short[] sArr) {
        i.q2.t.i0.f(sArr, "$this$contentToString");
        return g0.a(i.u1.a(sArr), ", ", "[", "]", 0, null, null, 56, null);
    }

    @i.q2.h
    @i.k
    @j.c.a.d
    public static final i.t1[] c(@j.c.a.d short[] sArr) {
        i.q2.t.i0.f(sArr, "$this$toTypedArray");
        int iC = i.u1.c(sArr);
        i.t1[] t1VarArr = new i.t1[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            t1VarArr[i2] = i.t1.a(i.u1.a(sArr, i2));
        }
        return t1VarArr;
    }

    @i.q2.h
    @i.k
    public static final byte a(@j.c.a.d byte[] bArr, @j.c.a.d i.u2.f fVar) {
        i.q2.t.i0.f(bArr, "$this$random");
        i.q2.t.i0.f(fVar, "random");
        if (!i.g1.e(bArr)) {
            return i.g1.a(bArr, fVar.c(i.g1.c(bArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @i.q2.h
    @i.k
    public static final short a(@j.c.a.d short[] sArr, @j.c.a.d i.u2.f fVar) {
        i.q2.t.i0.f(sArr, "$this$random");
        i.q2.t.i0.f(fVar, "random");
        if (!i.u1.e(sArr)) {
            return i.u1.a(sArr, fVar.c(i.u1.c(sArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @i.q2.h
    @i.k
    public static final boolean a(@j.c.a.d int[] iArr, @j.c.a.d int[] iArr2) {
        i.q2.t.i0.f(iArr, "$this$contentEquals");
        i.q2.t.i0.f(iArr2, DispatchConstants.OTHER);
        return Arrays.equals(iArr, iArr2);
    }

    @i.q2.h
    @i.k
    public static final boolean a(@j.c.a.d long[] jArr, @j.c.a.d long[] jArr2) {
        i.q2.t.i0.f(jArr, "$this$contentEquals");
        i.q2.t.i0.f(jArr2, DispatchConstants.OTHER);
        return Arrays.equals(jArr, jArr2);
    }

    @i.q2.h
    @i.k
    public static final boolean a(@j.c.a.d byte[] bArr, @j.c.a.d byte[] bArr2) {
        i.q2.t.i0.f(bArr, "$this$contentEquals");
        i.q2.t.i0.f(bArr2, DispatchConstants.OTHER);
        return Arrays.equals(bArr, bArr2);
    }

    @i.q2.h
    @i.k
    public static final boolean a(@j.c.a.d short[] sArr, @j.c.a.d short[] sArr2) {
        i.q2.t.i0.f(sArr, "$this$contentEquals");
        i.q2.t.i0.f(sArr2, DispatchConstants.OTHER);
        return Arrays.equals(sArr, sArr2);
    }

    @i.q2.h
    @i.k
    public static final int a(@j.c.a.d int[] iArr) {
        i.q2.t.i0.f(iArr, "$this$contentHashCode");
        return Arrays.hashCode(iArr);
    }

    @i.q2.h
    @i.k
    public static final int a(@j.c.a.d long[] jArr) {
        i.q2.t.i0.f(jArr, "$this$contentHashCode");
        return Arrays.hashCode(jArr);
    }

    @i.q2.h
    @i.k
    public static final int a(@j.c.a.d byte[] bArr) {
        i.q2.t.i0.f(bArr, "$this$contentHashCode");
        return Arrays.hashCode(bArr);
    }

    @i.q2.h
    @i.k
    public static final int a(@j.c.a.d short[] sArr) {
        i.q2.t.i0.f(sArr, "$this$contentHashCode");
        return Arrays.hashCode(sArr);
    }
}
