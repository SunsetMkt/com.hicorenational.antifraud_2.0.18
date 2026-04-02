package com.bumptech.glide.s;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import java.security.MessageDigest;

/* JADX INFO: compiled from: EmptySignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f3548c = new c();

    private c() {
    }

    @NonNull
    public static c a() {
        return f3548c;
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
