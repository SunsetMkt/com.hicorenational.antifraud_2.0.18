package com.bumptech.glide.p134o;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: GifDecoder.java */
/* renamed from: com.bumptech.glide.o.a */
/* loaded from: classes.dex */
public interface InterfaceC1804a {

    /* renamed from: a */
    public static final int f5153a = 0;

    /* renamed from: b */
    public static final int f5154b = 1;

    /* renamed from: c */
    public static final int f5155c = 2;

    /* renamed from: d */
    public static final int f5156d = 3;

    /* renamed from: e */
    public static final int f5157e = 0;

    /* compiled from: GifDecoder.java */
    /* renamed from: com.bumptech.glide.o.a$a */
    public interface a {
        @NonNull
        /* renamed from: a */
        Bitmap mo4464a(int i2, int i3, @NonNull Bitmap.Config config);

        /* renamed from: a */
        void mo4465a(@NonNull Bitmap bitmap);

        /* renamed from: a */
        void mo4466a(@NonNull byte[] bArr);

        /* renamed from: a */
        void mo4467a(@NonNull int[] iArr);

        @NonNull
        /* renamed from: a */
        int[] mo4468a(int i2);

        @NonNull
        /* renamed from: b */
        byte[] mo4469b(int i2);
    }

    /* compiled from: GifDecoder.java */
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.bumptech.glide.o.a$b */
    public @interface b {
    }

    /* renamed from: a */
    int mo4634a(int i2);

    /* renamed from: a */
    int mo4635a(@Nullable InputStream inputStream, int i2);

    @Nullable
    /* renamed from: a */
    Bitmap mo4636a();

    /* renamed from: a */
    void mo4637a(@NonNull Bitmap.Config config);

    /* renamed from: a */
    void mo4638a(@NonNull C1806c c1806c, @NonNull ByteBuffer byteBuffer);

    /* renamed from: a */
    void mo4639a(@NonNull C1806c c1806c, @NonNull ByteBuffer byteBuffer, int i2);

    /* renamed from: a */
    void mo4640a(@NonNull C1806c c1806c, @NonNull byte[] bArr);

    /* renamed from: b */
    void mo4641b();

    /* renamed from: c */
    int mo4642c();

    void clear();

    /* renamed from: d */
    int mo4643d();

    @NonNull
    /* renamed from: e */
    ByteBuffer mo4644e();

    /* renamed from: f */
    void mo4645f();

    /* renamed from: g */
    int mo4646g();

    int getHeight();

    int getWidth();

    /* renamed from: h */
    int mo4647h();

    /* renamed from: i */
    int mo4648i();

    /* renamed from: j */
    int mo4649j();

    /* renamed from: k */
    int mo4650k();

    @Deprecated
    /* renamed from: l */
    int mo4651l();

    int read(@Nullable byte[] bArr);
}
