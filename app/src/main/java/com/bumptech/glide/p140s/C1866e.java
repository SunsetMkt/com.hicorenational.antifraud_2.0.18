package com.bumptech.glide.p140s;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.util.C1876j;
import java.security.MessageDigest;

/* compiled from: ObjectKey.java */
/* renamed from: com.bumptech.glide.s.e */
/* loaded from: classes.dex */
public final class C1866e implements InterfaceC1593g {

    /* renamed from: c */
    private final Object f5464c;

    public C1866e(@NonNull Object obj) {
        this.f5464c = C1876j.m4985a(obj);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f5464c.toString().getBytes(InterfaceC1593g.f4191b));
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (obj instanceof C1866e) {
            return this.f5464c.equals(((C1866e) obj).f5464c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return this.f5464c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f5464c + '}';
    }
}
