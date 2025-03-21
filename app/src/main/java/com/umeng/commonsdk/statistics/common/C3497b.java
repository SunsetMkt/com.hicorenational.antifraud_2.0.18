package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* compiled from: DeflaterHelper.java */
/* renamed from: com.umeng.commonsdk.statistics.common.b */
/* loaded from: classes2.dex */
public class C3497b {

    /* renamed from: a */
    public static int f12751a;

    /* renamed from: a */
    public static byte[] m11808a(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m11809a(str.getBytes(str2));
    }

    /* renamed from: b */
    public static byte[] m11810b(byte[] bArr) throws UnsupportedEncodingException, DataFormatException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Inflater inflater = new Inflater();
        int i2 = 0;
        inflater.setInput(bArr, 0, bArr.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (!inflater.needsInput()) {
            int inflate = inflater.inflate(bArr2);
            byteArrayOutputStream.write(bArr2, i2, inflate);
            i2 += inflate;
        }
        inflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static byte[] m11809a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f12751a = 0;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f12751a += deflate;
                    byteArrayOutputStream.write(bArr2, 0, deflate);
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* renamed from: a */
    public static String m11807a(byte[] bArr, String str) throws UnsupportedEncodingException, DataFormatException {
        byte[] m11810b = m11810b(bArr);
        if (m11810b != null) {
            return new String(m11810b, str);
        }
        return null;
    }
}
