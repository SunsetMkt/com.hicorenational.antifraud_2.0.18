package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ac {
    public static boolean a(Context context, String str, long j2) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock = null;
        try {
            File file = new File(context.getFilesDir(), "/.vdevdir/");
            if (!v.m762a(file)) {
                w.a((Closeable) null);
                return true;
            }
            File file2 = new File(file, "lcfp.lock");
            w.m763a(file2);
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    boolean zB = b(context, str, j2);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    w.a(randomAccessFile);
                    return zB;
                } catch (Throwable th) {
                    th = th;
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    w.a(randomAccessFile);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
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
            if (fileLockLock != null) {
                fileLockLock.release();
            }
            w.a(randomAccessFile);
            throw th;
        }
        e.printStackTrace();
        if (fileLockLock != null && fileLockLock.isValid()) {
            fileLockLock.release();
        }
        w.a(randomAccessFile);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v14, types: [int] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    private static boolean b(Context context, String str, long j2) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        ?? Equals;
        ?? r10;
        BufferedWriter bufferedWriter;
        File file = new File(context.getFilesDir(), "/.vdevdir/");
        if (!v.m762a(file)) {
            return true;
        }
        File file2 = new File(file, "lcfp");
        ArrayList arrayList = new ArrayList();
        String str2 = str + Constants.COLON_SEPARATOR + context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis();
        if (file2.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            w.a(bufferedReader);
                            r10 = Equals;
                            break;
                        }
                        String[] strArrSplit = line.split(Constants.COLON_SEPARATOR);
                        if (strArrSplit.length == 2) {
                            Equals = TextUtils.equals(strArrSplit[0], String.valueOf(str));
                            if (Equals != 0) {
                                Equals = strArrSplit[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                if (Equals.length == 2) {
                                    long j3 = Long.parseLong(Equals[1]);
                                    Equals = TextUtils.equals(Equals[0], context.getPackageName());
                                    if (Equals == 0 && Math.abs(r3 - j3) < 1000 * j2 * 0.9f) {
                                        w.a(bufferedReader);
                                        return false;
                                    }
                                }
                            } else {
                                arrayList.add(line);
                            }
                        }
                    } catch (Exception unused) {
                        bufferedReader2 = bufferedReader;
                        try {
                            arrayList.clear();
                            w.a(bufferedReader2);
                            r10 = bufferedReader2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            w.a(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        w.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                bufferedReader2 = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } else if (!w.m763a(file2)) {
            return true;
        }
        arrayList.add(str2);
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file2));
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = null;
            } catch (Throwable th4) {
                th = th4;
                r10 = 0;
                w.a((Closeable) r10);
                throw th;
            }
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    bufferedWriter.write((String) it.next());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
            w.a(bufferedWriter);
            return true;
        } catch (Throwable th5) {
            th = th5;
            w.a((Closeable) r10);
            throw th;
        }
    }
}
