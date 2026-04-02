package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl extends ae.a {
    protected int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Context f330a;

    public dl(Context context, int i2) {
        this.a = i2;
        this.f330a = context;
    }

    private String c() {
        return "dc_job_result_time_" + mo181a();
    }

    private String d() {
        return "dc_job_result_" + mo181a();
    }

    public abstract gh a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected boolean m269a() {
        return di.a(this.f330a, String.valueOf(mo181a()), this.a);
    }

    public abstract String b();

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    protected boolean m270b() {
        return true;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    protected boolean m271c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (m269a()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("DC run job mutual: " + mo181a());
            return;
        }
        df dfVarM267a = dg.a().m267a();
        String strA = dfVarM267a == null ? "" : dfVarM267a.a();
        if (!TextUtils.isEmpty(strA) && m270b()) {
            if (m271c()) {
                SharedPreferences sharedPreferences = this.f330a.getSharedPreferences("mipush_extra", 0);
                if (bb.a(strB).equals(sharedPreferences.getString(d(), null))) {
                    long j2 = sharedPreferences.getLong(c(), 0L);
                    int iA = com.xiaomi.push.service.ah.a(this.f330a).a(gk.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j2) / 1000 < this.a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j2) / 1000 < iA) {
                        strB = "same_" + j2;
                    }
                }
            }
            gn gnVar = new gn();
            gnVar.a(strB);
            gnVar.a(System.currentTimeMillis());
            gnVar.a(a());
            a(this.f330a, gnVar, strA);
        }
    }

    public static void a(Context context, gn gnVar) {
        df dfVarM267a = dg.a().m267a();
        String strA = dfVarM267a == null ? "" : dfVarM267a.a();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(gnVar.a())) {
            return;
        }
        a(context, gnVar, strA);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #7 {, blocks: (B:23:0x0067, B:25:0x006d, B:26:0x0070, B:27:0x0073, B:48:0x009c, B:54:0x00a3, B:56:0x00a9, B:57:0x00ac, B:58:0x00b2, B:44:0x008f, B:46:0x0095, B:47:0x0098), top: B:72:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, gn gnVar, String str) {
        FileLock fileLockLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArrB = di.b(str, hp.a(gnVar));
        if (bArrB == null || bArrB.length == 0) {
            return;
        }
        synchronized (dj.a) {
            BufferedOutputStream bufferedOutputStream2 = null;
            bufferedOutputStream2 = null;
            fileLock = null;
            bufferedOutputStream2 = null;
            FileLock fileLock = null;
            try {
                File file = new File(context.getFilesDir(), "push_cdata.lock");
                w.m763a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileLockLock = null;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                fileLockLock = null;
                randomAccessFile = null;
            }
            try {
                File file2 = new File(context.getFilesDir(), "push_cdata.data");
                if (v.m762a(file2)) {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                    try {
                        bufferedOutputStream.write(y.a(bArrB.length));
                        bufferedOutputStream.write(bArrB);
                        bufferedOutputStream.flush();
                        file2.setLastModified(0L);
                    } catch (IOException e4) {
                        e = e4;
                        fileLock = fileLockLock;
                        try {
                            e.printStackTrace();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused) {
                                }
                            }
                            w.a(bufferedOutputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            fileLockLock = fileLock;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused2) {
                                }
                            }
                            w.a(bufferedOutputStream2);
                            w.a(randomAccessFile);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream2 = bufferedOutputStream;
                        if (fileLockLock != null) {
                            fileLockLock.release();
                        }
                        w.a(bufferedOutputStream2);
                        w.a(randomAccessFile);
                        throw th;
                    }
                } else {
                    bufferedOutputStream = null;
                }
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException unused3) {
                    }
                }
                w.a(bufferedOutputStream);
            } catch (IOException e5) {
                e = e5;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileLockLock != null) {
                }
                w.a(bufferedOutputStream2);
                w.a(randomAccessFile);
                throw th;
            }
            w.a(randomAccessFile);
        }
    }
}
