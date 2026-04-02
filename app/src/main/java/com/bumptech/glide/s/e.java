package com.bumptech.glide.s;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ObjectKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f3552c;

    public e(@NonNull Object obj) {
        this.f3552c = j.a(obj);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f3552c.toString().getBytes(g.f2715b));
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f3552c.equals(((e) obj).f3552c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f3552c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f3552c + '}';
    }
}
