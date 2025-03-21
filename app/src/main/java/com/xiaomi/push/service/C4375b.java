package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4408w;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* renamed from: com.xiaomi.push.service.b */
/* loaded from: classes2.dex */
public class C4375b {

    /* renamed from: a */
    private static volatile C4375b f16672a;

    /* renamed from: a */
    private Context f16673a;

    /* renamed from: e */
    private volatile String f16680e;

    /* renamed from: f */
    private volatile String f16681f;

    /* renamed from: a */
    private final Object f16674a = new Object();

    /* renamed from: b */
    private final Object f16676b = new Object();

    /* renamed from: a */
    private final String f16675a = "mipush_region";

    /* renamed from: b */
    private final String f16677b = "mipush_country_code";

    /* renamed from: c */
    private final String f16678c = "mipush_region.lock";

    /* renamed from: d */
    private final String f16679d = "mipush_country_code.lock";

    public C4375b(Context context) {
        this.f16673a = context;
    }

    /* renamed from: a */
    public static C4375b m16045a(Context context) {
        if (f16672a == null) {
            synchronized (C4375b.class) {
                if (f16672a == null) {
                    f16672a = new C4375b(context);
                }
            }
        }
        return f16672a;
    }

    /* renamed from: b */
    public String m16050b() {
        if (TextUtils.isEmpty(this.f16681f)) {
            this.f16681f = m16046a(this.f16673a, "mipush_country_code", "mipush_country_code.lock", this.f16676b);
        }
        return this.f16681f;
    }

    /* renamed from: b */
    public void m16051b(String str, boolean z) {
        if (!TextUtils.equals(str, this.f16681f)) {
            this.f16681f = str;
        }
        if (z) {
            m16047a(this.f16673a, str, "mipush_country_code", "mipush_region.lock", this.f16674a);
        }
    }

    /* renamed from: a */
    public String m16048a() {
        if (TextUtils.isEmpty(this.f16680e)) {
            this.f16680e = m16046a(this.f16673a, "mipush_region", "mipush_region.lock", this.f16674a);
        }
        return this.f16680e;
    }

    /* renamed from: a */
    public void m16049a(String str, boolean z) {
        if (!TextUtils.equals(str, this.f16680e)) {
            this.f16680e = str;
        }
        if (z) {
            m16047a(this.f16673a, str, "mipush_region", "mipush_region.lock", this.f16674a);
        }
    }

    /* renamed from: a */
    private void m16047a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                File file = new File(context.getFilesDir(), str3);
                C4408w.m16360a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e3) {
                        AbstractC4022b.m13351a(e3);
                    }
                }
                C4408w.m16356a(randomAccessFile);
                throw th;
            }
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    C4408w.m16358a(new File(context.getFilesDir(), str2), str);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            AbstractC4022b.m13351a(e4);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    C4408w.m16356a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                AbstractC4022b.m13351a(e);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e6) {
                        AbstractC4022b.m13351a(e6);
                    }
                }
                C4408w.m16356a(randomAccessFile);
            }
            C4408w.m16356a(randomAccessFile);
        }
    }

    /* renamed from: a */
    private String m16046a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            AbstractC4022b.m13347a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                C4408w.m16360a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception e2) {
                    e = e2;
                    fileLock = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (IOException e3) {
                            AbstractC4022b.m13351a(e3);
                        }
                    }
                    C4408w.m16356a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
            try {
                try {
                    String m16355a = C4408w.m16355a(file);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            AbstractC4022b.m13351a(e5);
                        }
                    }
                    C4408w.m16356a(randomAccessFile);
                    return m16355a;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock2 = fileLock;
                    if (fileLock2 != null && fileLock2.isValid()) {
                        fileLock2.release();
                    }
                    C4408w.m16356a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                AbstractC4022b.m13351a(e);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e7) {
                        AbstractC4022b.m13351a(e7);
                    }
                }
                C4408w.m16356a(randomAccessFile);
                return null;
            }
        }
    }
}
