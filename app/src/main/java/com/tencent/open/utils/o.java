package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;
import i.f1;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements Cloneable {
    private int a;

    public o(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i2 = this.a;
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof o) && this.a == ((o) obj).b();
    }

    public int hashCode() {
        return this.a;
    }

    public o(byte[] bArr, int i2) {
        this.a = (bArr[i2 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.a += bArr[i2] & f1.f12066c;
    }

    public o(int i2) {
        this.a = i2;
    }
}
