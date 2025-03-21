package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* renamed from: com.bumptech.glide.util.b */
/* loaded from: classes.dex */
public final class C1868b extends FilterInputStream {

    /* renamed from: c */
    private static final String f5474c = "ContentLengthStream";

    /* renamed from: d */
    private static final int f5475d = -1;

    /* renamed from: a */
    private final long f5476a;

    /* renamed from: b */
    private int f5477b;

    private C1868b(@NonNull InputStream inputStream, long j2) {
        super(inputStream);
        this.f5476a = j2;
    }

    @NonNull
    /* renamed from: a */
    public static InputStream m4960a(@NonNull InputStream inputStream, @Nullable String str) {
        return m4959a(inputStream, m4958a(str));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f5476a - this.f5477b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        m4957a(read >= 0 ? 1 : -1);
        return read;
    }

    @NonNull
    /* renamed from: a */
    public static InputStream m4959a(@NonNull InputStream inputStream, long j2) {
        return new C1868b(inputStream, j2);
    }

    /* renamed from: a */
    private static int m4958a(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                if (Log.isLoggable(f5474c, 3)) {
                    String str2 = "failed to parse content length header: " + str;
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return m4957a(super.read(bArr, i2, i3));
    }

    /* renamed from: a */
    private int m4957a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f5477b += i2;
        } else if (this.f5476a - this.f5477b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f5476a + ", but read: " + this.f5477b);
        }
        return i2;
    }
}
