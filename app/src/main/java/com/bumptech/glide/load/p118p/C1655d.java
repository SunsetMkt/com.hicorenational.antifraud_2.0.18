package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1593g;
import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* renamed from: com.bumptech.glide.load.p.d */
/* loaded from: classes.dex */
final class C1655d implements InterfaceC1593g {

    /* renamed from: c */
    private final InterfaceC1593g f4431c;

    /* renamed from: d */
    private final InterfaceC1593g f4432d;

    C1655d(InterfaceC1593g interfaceC1593g, InterfaceC1593g interfaceC1593g2) {
        this.f4431c = interfaceC1593g;
        this.f4432d = interfaceC1593g2;
    }

    /* renamed from: a */
    InterfaceC1593g m4048a() {
        return this.f4431c;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (!(obj instanceof C1655d)) {
            return false;
        }
        C1655d c1655d = (C1655d) obj;
        return this.f4431c.equals(c1655d.f4431c) && this.f4432d.equals(c1655d.f4432d);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return (this.f4431c.hashCode() * 31) + this.f4432d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f4431c + ", signature=" + this.f4432d + '}';
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        this.f4431c.mo3827a(messageDigest);
        this.f4432d.mo3827a(messageDigest);
    }
}
