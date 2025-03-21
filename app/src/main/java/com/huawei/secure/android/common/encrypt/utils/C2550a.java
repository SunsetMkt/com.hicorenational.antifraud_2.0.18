package com.huawei.secure.android.common.encrypt.utils;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* renamed from: com.huawei.secure.android.common.encrypt.utils.a */
/* loaded from: classes.dex */
public class C2550a {

    /* renamed from: a */
    private static final String f8109a = "IOUtil";

    /* renamed from: b */
    private static final int f8110b = 4096;

    /* renamed from: a */
    public static void m7886a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: b */
    public static byte[] m7894b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m7883a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static void m7891a(Reader reader) {
        m7887a((Closeable) reader);
    }

    /* renamed from: a */
    public static void m7892a(Writer writer) {
        m7887a((Closeable) writer);
    }

    /* renamed from: a */
    public static void m7889a(InputStream inputStream) {
        m7887a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m7890a(OutputStream outputStream) {
        m7887a((Closeable) outputStream);
    }

    /* renamed from: a */
    public static void m7887a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C2551b.m7898b(f8109a, "closeSecure IOException");
            }
        }
    }

    /* renamed from: a */
    public static long m7883a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m7884a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m7884a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
    }

    /* renamed from: a */
    public static InputStream m7885a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    /* renamed from: a */
    public static void m7888a(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        C2551b.m7898b(f8109a, "deleteSecure exception");
    }

    /* renamed from: a */
    public static void m7893a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m7888a(new File(str));
    }
}
