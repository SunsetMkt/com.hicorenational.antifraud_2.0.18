package com.bumptech.glide.o;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: GifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    public static final int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3377b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3378c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3379d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3380e = 0;

    /* JADX INFO: renamed from: com.bumptech.glide.o.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GifDecoder.java */
    public interface InterfaceC0063a {
        @NonNull
        Bitmap a(int i2, int i3, @NonNull Bitmap.Config config);

        void a(@NonNull Bitmap bitmap);

        void a(@NonNull byte[] bArr);

        void a(@NonNull int[] iArr);

        @NonNull
        int[] a(int i2);

        @NonNull
        byte[] b(int i2);
    }

    /* JADX INFO: compiled from: GifDecoder.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    int a(int i2);

    int a(@Nullable InputStream inputStream, int i2);

    @Nullable
    Bitmap a();

    void a(@NonNull Bitmap.Config config);

    void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer);

    void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i2);

    void a(@NonNull c cVar, @NonNull byte[] bArr);

    void b();

    int c();

    void clear();

    int d();

    @NonNull
    ByteBuffer e();

    void f();

    int g();

    int getHeight();

    int getWidth();

    int h();

    int i();

    int j();

    int k();

    @Deprecated
    int l();

    int read(@Nullable byte[] bArr);
}
