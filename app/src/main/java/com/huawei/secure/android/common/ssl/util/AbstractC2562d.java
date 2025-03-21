package com.huawei.secure.android.common.ssl.util;

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

/* renamed from: com.huawei.secure.android.common.ssl.util.d */
/* loaded from: classes.dex */
public abstract class AbstractC2562d {

    /* renamed from: a */
    private static final String f8244a = "IOUtil";

    /* renamed from: b */
    private static final int f8245b = 4096;

    /* renamed from: a */
    public static void m7974a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: b */
    public static byte[] m7982b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m7971a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static void m7979a(Reader reader) {
        m7975a((Closeable) reader);
    }

    /* renamed from: a */
    public static void m7980a(Writer writer) {
        m7975a((Closeable) writer);
    }

    /* renamed from: a */
    public static void m7977a(InputStream inputStream) {
        m7975a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m7978a(OutputStream outputStream) {
        m7975a((Closeable) outputStream);
    }

    /* renamed from: a */
    public static void m7975a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C2563e.m7986b(f8244a, "closeSecure IOException");
            }
        }
    }

    /* renamed from: a */
    public static long m7971a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m7972a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m7972a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
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
    public static InputStream m7973a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    /* renamed from: a */
    public static void m7976a(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        C2563e.m7986b(f8244a, "deleteSecure exception");
    }

    /* renamed from: a */
    public static void m7981a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m7976a(new File(str));
    }
}
