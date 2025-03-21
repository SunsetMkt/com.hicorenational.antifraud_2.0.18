package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: Key.java */
/* renamed from: com.bumptech.glide.load.g */
/* loaded from: classes.dex */
public interface InterfaceC1593g {

    /* renamed from: a */
    public static final String f4190a = "UTF-8";

    /* renamed from: b */
    public static final Charset f4191b = Charset.forName("UTF-8");

    /* renamed from: a */
    void mo3827a(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
