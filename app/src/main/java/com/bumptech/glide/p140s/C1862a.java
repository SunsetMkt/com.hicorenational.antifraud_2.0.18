package com.bumptech.glide.p140s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.util.C1878l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: AndroidResourceSignature.java */
/* renamed from: com.bumptech.glide.s.a */
/* loaded from: classes.dex */
public final class C1862a implements InterfaceC1593g {

    /* renamed from: c */
    private final int f5456c;

    /* renamed from: d */
    private final InterfaceC1593g f5457d;

    private C1862a(int i2, InterfaceC1593g interfaceC1593g) {
        this.f5456c = i2;
        this.f5457d = interfaceC1593g;
    }

    @NonNull
    /* renamed from: a */
    public static InterfaceC1593g m4943a(@NonNull Context context) {
        return new C1862a(context.getResources().getConfiguration().uiMode & 48, C1863b.m4947b(context));
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (!(obj instanceof C1862a)) {
            return false;
        }
        C1862a c1862a = (C1862a) obj;
        return this.f5456c == c1862a.f5456c && this.f5457d.equals(c1862a.f5457d);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return C1878l.m4996a(this.f5457d, this.f5456c);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        this.f5457d.mo3827a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f5456c).array());
    }
}
