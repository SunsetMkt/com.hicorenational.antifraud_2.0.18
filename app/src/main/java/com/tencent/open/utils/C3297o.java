package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;
import p286h.C5230f1;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.o */
/* loaded from: classes2.dex */
public final class C3297o implements Cloneable {

    /* renamed from: a */
    private int f11334a;

    public C3297o(byte[] bArr) {
        this(bArr, 0);
    }

    /* renamed from: a */
    public byte[] m10717a() {
        int i2 = this.f11334a;
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    /* renamed from: b */
    public int m10718b() {
        return this.f11334a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof C3297o) && this.f11334a == ((C3297o) obj).m10718b();
    }

    public int hashCode() {
        return this.f11334a;
    }

    public C3297o(byte[] bArr, int i2) {
        this.f11334a = (bArr[i2 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f11334a += bArr[i2] & C5230f1.f20085c;
    }

    public C3297o(int i2) {
        this.f11334a = i2;
    }
}
