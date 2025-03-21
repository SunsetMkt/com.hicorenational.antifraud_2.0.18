package com.tencent.p208mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.opensdk.utils.b */
/* loaded from: classes2.dex */
public final class C3240b {

    /* renamed from: a */
    public static Context f11092a;

    /* renamed from: b */
    private static final int f11093b;

    /* renamed from: c */
    private static final int f11094c;

    /* renamed from: d */
    private static final int f11095d;

    /* renamed from: e */
    public static ThreadPoolExecutor f11096e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f11093b = availableProcessors;
        f11094c = availableProcessors + 1;
        f11095d = (availableProcessors * 2) + 1;
        f11096e = new ThreadPoolExecutor(f11094c, f11095d, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    /* renamed from: a */
    public static int m10368a(ContentResolver contentResolver, Uri uri) {
        Log.m10365i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.m10367w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return 0;
                }
                int available = openInputStream.available();
                try {
                    openInputStream.close();
                } catch (IOException unused2) {
                }
                return available;
            } catch (Exception e2) {
                Log.m10367w("MicroMsg.SDK.Util", "getFileSize fail, " + e2.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static int m10369a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f11092a != null && str.startsWith("content")) {
            try {
                return m10368a(f11092a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10370a(String str, int i2) {
        if (str == null) {
            return i2;
        }
        try {
            return str.length() <= 0 ? i2 : Integer.parseInt(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    /* renamed from: a */
    public static boolean m10371a(int i2) {
        return i2 == 36 || i2 == 46;
    }

    /* renamed from: b */
    public static boolean m10372b(String str) {
        return str == null || str.length() <= 0;
    }
}
