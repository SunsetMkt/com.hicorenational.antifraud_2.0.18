package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1028a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile String f9396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f9397f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f1029a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9393b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f1030a = "mipush_region";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final String f1031b = "mipush_country_code";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9394c = "mipush_region.lock";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9395d = "mipush_country_code.lock";

    public b(Context context) {
        this.f1028a = context;
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f9397f)) {
            this.f9397f = a(this.f1028a, "mipush_country_code", "mipush_country_code.lock", this.f9393b);
        }
        return this.f9397f;
    }

    public void b(String str, boolean z) {
        if (!TextUtils.equals(str, this.f9397f)) {
            this.f9397f = str;
        }
        if (z) {
            a(this.f1028a, str, "mipush_country_code", "mipush_region.lock", this.f1029a);
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f9396e)) {
            this.f9396e = a(this.f1028a, "mipush_region", "mipush_region.lock", this.f1029a);
        }
        return this.f9396e;
    }

    public void a(String str, boolean z) {
        if (!TextUtils.equals(str, this.f9396e)) {
            this.f9396e = str;
        }
        if (z) {
            a(this.f1028a, str, "mipush_region", "mipush_region.lock", this.f1029a);
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLockLock = null;
            try {
                File file = new File(context.getFilesDir(), str3);
                com.xiaomi.push.w.m763a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                    }
                }
                com.xiaomi.push.w.a(randomAccessFile);
                throw th;
            }
            try {
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    com.xiaomi.push.w.a(new File(context.getFilesDir(), str2), str);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        fileLockLock.release();
                    }
                    com.xiaomi.push.w.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e6) {
                        com.xiaomi.channel.commonutils.logger.b.a(e6);
                    }
                }
            }
            com.xiaomi.push.w.a(randomAccessFile);
        }
    }

    private String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock = null;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                com.xiaomi.push.w.m763a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                } catch (Exception e2) {
                    e = e2;
                    fileLockLock = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                        }
                    }
                    com.xiaomi.push.w.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                fileLockLock = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
            try {
                try {
                    String strA = com.xiaomi.push.w.a(file);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e5) {
                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                        }
                    }
                    com.xiaomi.push.w.a(randomAccessFile);
                    return strA;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = fileLockLock;
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    com.xiaomi.push.w.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e7) {
                        com.xiaomi.channel.commonutils.logger.b.a(e7);
                    }
                }
                com.xiaomi.push.w.a(randomAccessFile);
                return null;
            }
        }
    }
}
