package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DataCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
final class d implements com.bumptech.glide.load.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.g f2892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.g f2893d;

    d(com.bumptech.glide.load.g gVar, com.bumptech.glide.load.g gVar2) {
        this.f2892c = gVar;
        this.f2893d = gVar2;
    }

    com.bumptech.glide.load.g a() {
        return this.f2892c;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2892c.equals(dVar.f2892c) && this.f2893d.equals(dVar.f2893d);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return (this.f2892c.hashCode() * 31) + this.f2893d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f2892c + ", signature=" + this.f2893d + '}';
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        this.f2892c.a(messageDigest);
        this.f2893d.a(messageDigest);
    }
}
