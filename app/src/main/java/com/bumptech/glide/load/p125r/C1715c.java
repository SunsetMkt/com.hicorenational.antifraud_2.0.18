package com.bumptech.glide.load.p125r;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import java.security.MessageDigest;

/* compiled from: UnitTransformation.java */
/* renamed from: com.bumptech.glide.load.r.c */
/* loaded from: classes.dex */
public final class C1715c<T> implements InterfaceC1600n<T> {

    /* renamed from: c */
    private static final InterfaceC1600n<?> f4811c = new C1715c();

    private C1715c() {
    }

    @NonNull
    /* renamed from: a */
    public static <T> C1715c<T> m4302a() {
        return (C1715c) f4811c;
    }

    @Override // com.bumptech.glide.load.InterfaceC1600n
    @NonNull
    /* renamed from: a */
    public InterfaceC1677v<T> mo3828a(@NonNull Context context, @NonNull InterfaceC1677v<T> interfaceC1677v, int i2, int i3) {
        return interfaceC1677v;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
    }
}
