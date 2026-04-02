package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class gb {
    private static boolean a = false;

    static class a implements Runnable {
        private Context a;

        /* JADX INFO: renamed from: a */
        private ge f556a;

        public a(Context context, ge geVar) {
            this.f556a = geVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            gb.c(this.a, this.f556a);
        }
    }

    public static void a(Context context, ge geVar) {
        ae.a(context).a(new a(context, geVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, ge geVar) throws Throwable {
        RandomAccessFile randomAccessFile;
        File file;
        if (a) {
            com.xiaomi.channel.commonutils.logger.b.m48a("TinyData extractTinyData is running");
            return;
        }
        a = true;
        File file2 = new File(context.getFilesDir(), "tiny_data.data");
        if (!file2.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m48a("TinyData no ready file to get data.");
            return;
        }
        a(context);
        byte[] bArrA = com.xiaomi.push.service.ba.a(context);
        FileLock fileLockLock = null;
        try {
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                w.m763a(file3);
                randomAccessFile = new RandomAccessFile(file3, "rw");
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
                w.a(randomAccessFile);
                throw th;
            }
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e4) {
                        e = e4;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
            } catch (Exception e5) {
                e = e5;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e6) {
                        e = e6;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                w.a(randomAccessFile);
                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                if (file.exists()) {
                }
            }
            w.a(randomAccessFile);
            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
            if (file.exists()) {
                com.xiaomi.channel.commonutils.logger.b.m48a("TinyData no ready file to get data.");
                return;
            }
            a(context, geVar, file, bArrA);
            ga.a(false);
            b(context);
            a = false;
        } catch (Throwable th2) {
            th = th2;
            if (fileLockLock != null && fileLockLock.isValid()) {
                fileLockLock.release();
            }
            w.a(randomAccessFile);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x00a0, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, ge geVar, File file, byte[] bArr) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream2 = null;
                loop0: while (true) {
                    int i2 = 0;
                    int length = 0;
                    while (true) {
                        try {
                            int i3 = bufferedInputStream.read(bArr2);
                            if (i3 == -1) {
                                break loop0;
                            }
                            if (i3 != 4) {
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause lengthBuffer error. size:" + i3);
                                break loop0;
                            }
                            int iA = y.a(bArr2);
                            if (iA < 1 || iA > 30720) {
                                break loop0;
                            }
                            byte[] bArr3 = new byte[iA];
                            int i4 = bufferedInputStream.read(bArr3);
                            if (i4 != iA) {
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause buffer size not equal length. size:" + i4 + "__length:" + iA);
                                break loop0;
                            }
                            byte[] bArrA = h.a(bArr, bArr3);
                            if (bArrA == null || bArrA.length == 0) {
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");
                            } else {
                                gj gjVar = new gj();
                                hp.a(gjVar, bArrA);
                                gjVar.a("item_size", String.valueOf(bArrA.length));
                                arrayList.add(gjVar);
                                i2++;
                                length += bArrA.length;
                                if (i2 >= 8 || length >= 30720) {
                                    break;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bufferedInputStream2 = bufferedInputStream;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            w.a((Closeable) bufferedInputStream2);
                        } catch (Throwable th) {
                            th = th;
                            w.a((Closeable) bufferedInputStream);
                            throw th;
                        }
                    }
                    gc.a(context, geVar, arrayList);
                    arrayList.clear();
                }
                gc.a(context, geVar, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("TinyData delete reading temp file failed");
                }
                w.a((Closeable) bufferedInputStream);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    private static void b(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 4).edit();
        editorEdit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        editorEdit.commit();
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
