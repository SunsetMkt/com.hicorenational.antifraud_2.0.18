package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ik */
/* loaded from: classes2.dex */
public abstract class AbstractC4298ik {
    /* renamed from: a */
    public abstract int mo15662a(byte[] bArr, int i2, int i3);

    /* renamed from: a */
    public void mo15665a(int i2) {
    }

    /* renamed from: a */
    public abstract void mo15663a(byte[] bArr, int i2, int i3);

    /* renamed from: a */
    public byte[] mo15667a() {
        return null;
    }

    /* renamed from: a_ */
    public int mo15668a_() {
        return 0;
    }

    /* renamed from: b */
    public int mo15669b() {
        return -1;
    }

    /* renamed from: b */
    public int m15671b(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int mo15662a = mo15662a(bArr, i2 + i4, i3 - i4);
            if (mo15662a <= 0) {
                throw new C4299il("Cannot read. Remote side has closed. Tried to read " + i3 + " bytes, but only got " + i4 + " bytes.");
            }
            i4 += mo15662a;
        }
        return i4;
    }
}
