package com.xiaomi.push;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes2.dex */
public class ac {
    public static boolean a(Context context, String str, long j2) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        try {
            File file = new File(context.getFilesDir(), "/.vdevdir/");
            if (!v.m764a(file)) {
                w.a((Closeable) null);
                return true;
            }
            File file2 = new File(file, "lcfp.lock");
            w.m765a(file2);
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    boolean b2 = b(context, str, j2);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    w.a(randomAccessFile);
                    return b2;
                } catch (Throwable th) {
                    th = th;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    w.a(randomAccessFile);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                }
                w.a(randomAccessFile);
                return true;
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLock != null) {
                fileLock.release();
            }
            w.a(randomAccessFile);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e1 A[Catch: IOException -> 0x00f1, all -> 0x0103, LOOP:0: B:15:0x00db->B:17:0x00e1, LOOP_END, TRY_LEAVE, TryCatch #2 {all -> 0x0103, blocks: (B:14:0x00d7, B:15:0x00db, B:17:0x00e1, B:23:0x00f8), top: B:11:0x00cd }] */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v14, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.String[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(android.content.Context r16, java.lang.String r17, long r18) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ac.b(android.content.Context, java.lang.String, long):boolean");
    }
}
