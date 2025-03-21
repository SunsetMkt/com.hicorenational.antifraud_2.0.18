package com.xiaomi.push;

import java.io.IOException;

/* renamed from: com.xiaomi.push.e */
/* loaded from: classes2.dex */
public abstract class AbstractC4179e {
    /* renamed from: a */
    public abstract int mo14314a();

    /* renamed from: a */
    public abstract AbstractC4179e mo14316a(C4098b c4098b);

    /* renamed from: a */
    public abstract void mo14320a(C4125c c4125c);

    /* renamed from: a */
    public byte[] m14590a() {
        byte[] bArr = new byte[mo14322b()];
        m14588a(bArr, 0, bArr.length);
        return bArr;
    }

    /* renamed from: b */
    public abstract int mo14322b();

    /* renamed from: a */
    public void m14588a(byte[] bArr, int i2, int i3) {
        try {
            C4125c m13992a = C4125c.m13992a(bArr, i2, i3);
            mo14320a(m13992a);
            m13992a.m14018b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: a */
    public AbstractC4179e m14586a(byte[] bArr) {
        return m14587a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public AbstractC4179e m14587a(byte[] bArr, int i2, int i3) {
        try {
            C4098b m13849a = C4098b.m13849a(bArr, i2, i3);
            mo14316a(m13849a);
            m13849a.m13859a(0);
            return this;
        } catch (C4152d e2) {
            throw e2;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: a */
    protected boolean m14589a(C4098b c4098b, int i2) {
        return c4098b.m13862a(i2);
    }
}
