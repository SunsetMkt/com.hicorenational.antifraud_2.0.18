package com.bumptech.glide.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.g;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: MediaStoreSignature.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final String f3549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f3550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3551e;

    public d(@Nullable String str, long j2, int i2) {
        this.f3549c = str == null ? "" : str;
        this.f3550d = j2;
        this.f3551e = i2;
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f3550d).putInt(this.f3551e).array());
        messageDigest.update(this.f3549c.getBytes(g.f2715b));
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f3550d == dVar.f3550d && this.f3551e == dVar.f3551e && this.f3549c.equals(dVar.f3549c);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        int iHashCode = this.f3549c.hashCode() * 31;
        long j2 = this.f3550d;
        return ((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f3551e;
    }
}
