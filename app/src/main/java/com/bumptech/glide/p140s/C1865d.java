package com.bumptech.glide.p140s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC1593g;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: MediaStoreSignature.java */
/* renamed from: com.bumptech.glide.s.d */
/* loaded from: classes.dex */
public class C1865d implements InterfaceC1593g {

    /* renamed from: c */
    @NonNull
    private final String f5461c;

    /* renamed from: d */
    private final long f5462d;

    /* renamed from: e */
    private final int f5463e;

    public C1865d(@Nullable String str, long j2, int i2) {
        this.f5461c = str == null ? "" : str;
        this.f5462d = j2;
        this.f5463e = i2;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f5462d).putInt(this.f5463e).array());
        messageDigest.update(this.f5461c.getBytes(InterfaceC1593g.f4191b));
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1865d.class != obj.getClass()) {
            return false;
        }
        C1865d c1865d = (C1865d) obj;
        return this.f5462d == c1865d.f5462d && this.f5463e == c1865d.f5463e && this.f5461c.equals(c1865d.f5461c);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        int hashCode = this.f5461c.hashCode() * 31;
        long j2 = this.f5462d;
        return ((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f5463e;
    }
}
