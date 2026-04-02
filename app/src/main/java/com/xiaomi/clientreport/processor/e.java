package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.w;
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
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void a(String str, com.xiaomi.clientreport.data.a[] aVarArr) {
        RandomAccessFile randomAccessFile;
        if (aVarArr == null || aVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLockLock = null;
        try {
            File file = new File(str + ".lock");
            w.m763a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> mapM62a = m62a(str);
                for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                    if (aVar != null) {
                        String strA = a((PerfClientReport) aVar);
                        long j2 = ((PerfClientReport) aVar).perfCounts;
                        long j3 = ((PerfClientReport) aVar).perfLatencies;
                        if (!TextUtils.isEmpty(strA) && j2 > 0 && j3 >= 0) {
                            a(mapM62a, strA, j2, j3);
                        }
                    }
                }
                a(str, mapM62a);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e2) {
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
            } catch (Throwable unused) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("failed to write perf to file ");
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    w.a(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    w.a(randomAccessFile);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        w.a(randomAccessFile);
    }

    private static void a(HashMap<String, String> map, String str, long j2, long j3) {
        String str2;
        String str3 = map.get(str);
        if (TextUtils.isEmpty(str3)) {
            map.put(str, j2 + "#" + j3);
            return;
        }
        long[] jArrM63a = m63a(str3);
        if (jArrM63a != null && jArrM63a[0] > 0 && jArrM63a[1] >= 0) {
            str2 = (j2 + jArrM63a[0]) + "#" + (j3 + jArrM63a[1]);
        } else {
            str2 = j2 + "#" + j3;
        }
        map.put(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected static long[] m63a(String str) {
        long[] jArr = new long[2];
        try {
            String[] strArrSplit = str.split("#");
            if (strArrSplit.length >= 2) {
                jArr[0] = Long.parseLong(strArrSplit[0].trim());
                jArr[1] = Long.parseLong(strArrSplit[1].trim());
            }
            return jArr;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    private static void a(String str, HashMap<String, String> map) throws Throwable {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e2;
        if (TextUtils.isEmpty(str) || map == null || map.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception e3) {
            bufferedWriter = null;
            e2 = e3;
        } catch (Throwable th2) {
            bufferedWriter = null;
            th = th2;
            w.a(bufferedWriter);
            throw th;
        }
        try {
            try {
                for (String str2 : map.keySet()) {
                    bufferedWriter.write(str2 + "%%%" + map.get(str2));
                    bufferedWriter.newLine();
                }
            } catch (Throwable th3) {
                th = th3;
                w.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        w.a(bufferedWriter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static HashMap<String, String> m62a(String str) throws Throwable {
        ?? bufferedReader;
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return map;
        }
        ?? r1 = 0;
        ?? length = 0;
        ?? r12 = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        ?? Split = line.split("%%%");
                        length = Split.length;
                        if (length >= 2) {
                            length = 0;
                            length = 0;
                            if (!TextUtils.isEmpty(Split[0]) && !TextUtils.isEmpty(Split[1])) {
                                length = Split[0];
                                map.put(length, Split[1]);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        r12 = bufferedReader;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        w.a((Closeable) r12);
                        r1 = r12;
                    } catch (Throwable th) {
                        th = th;
                        w.a((Closeable) bufferedReader);
                        throw th;
                    }
                }
                w.a((Closeable) bufferedReader);
                r1 = length;
            } catch (Exception e3) {
                e = e3;
            }
            return map;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> a(Context context, String str) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        ?? bufferedReader;
        PerfClientReport perfClientReportA;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return arrayList;
        }
        ?? r0 = 0;
        r0 = 0;
        fileLock = null;
        r0 = 0;
        FileLock fileLock = null;
        try {
            file = new File(str + ".lock");
        } catch (Exception e2) {
            e = e2;
            file = null;
            randomAccessFile = null;
        } catch (Throwable th) {
            th = th;
            file = null;
            randomAccessFile = null;
        }
        try {
            w.m763a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedReader = new BufferedReader(new FileReader(str));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            String[] strArrSplit = line.split("%%%");
                            if (strArrSplit.length >= 2 && !TextUtils.isEmpty(strArrSplit[0]) && !TextUtils.isEmpty(strArrSplit[1]) && (perfClientReportA = a(a(strArrSplit[0]), strArrSplit[1])) != null) {
                                arrayList.add(perfClientReportA.toJsonString());
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileLock = fileLockLock;
                            bufferedReader = bufferedReader;
                            try {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    }
                                }
                                w.a(randomAccessFile);
                                w.a((Closeable) bufferedReader);
                                if (file != null) {
                                }
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                fileLockLock = fileLock;
                                r0 = bufferedReader;
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e5) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                                    }
                                }
                                w.a(randomAccessFile);
                                w.a((Closeable) r0);
                                if (file == null) {
                                    file.delete();
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            r0 = bufferedReader;
                            if (fileLockLock != null) {
                            }
                            w.a(randomAccessFile);
                            w.a((Closeable) r0);
                            if (file == null) {
                            }
                        }
                    }
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e6) {
                            com.xiaomi.channel.commonutils.logger.b.a(e6);
                        }
                    }
                    w.a(randomAccessFile);
                    w.a((Closeable) bufferedReader);
                } catch (Exception e7) {
                    e = e7;
                    bufferedReader = 0;
                } catch (Throwable th4) {
                    th = th4;
                    if (fileLockLock != null) {
                    }
                    w.a(randomAccessFile);
                    w.a((Closeable) r0);
                    if (file == null) {
                    }
                }
            } catch (Exception e8) {
                e = e8;
                bufferedReader = 0;
            } catch (Throwable th5) {
                th = th5;
                fileLockLock = null;
            }
        } catch (Exception e9) {
            e = e9;
            randomAccessFile = null;
            bufferedReader = randomAccessFile;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            if (fileLock != null && fileLock.isValid()) {
                fileLock.release();
            }
            w.a(randomAccessFile);
            w.a((Closeable) bufferedReader);
            if (file != null) {
                file.delete();
            }
            return arrayList;
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile = null;
            fileLockLock = randomAccessFile;
            if (fileLockLock != null) {
                fileLockLock.release();
            }
            w.a(randomAccessFile);
            w.a((Closeable) r0);
            if (file == null) {
            }
        }
        file.delete();
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String[] m64a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }

    private static PerfClientReport a(String str) {
        PerfClientReport blankInstance = null;
        try {
            String[] strArrM64a = m64a(str);
            if (strArrM64a == null || strArrM64a.length < 4 || TextUtils.isEmpty(strArrM64a[0]) || TextUtils.isEmpty(strArrM64a[1]) || TextUtils.isEmpty(strArrM64a[2]) || TextUtils.isEmpty(strArrM64a[3])) {
                return null;
            }
            blankInstance = PerfClientReport.getBlankInstance();
            blankInstance.production = Integer.parseInt(strArrM64a[0]);
            blankInstance.clientInterfaceId = strArrM64a[1];
            blankInstance.reportType = Integer.parseInt(strArrM64a[2]);
            blankInstance.code = Integer.parseInt(strArrM64a[3]);
            return blankInstance;
        } catch (Exception unused) {
            com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
            return blankInstance;
        }
    }

    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] jArrM63a;
        if (perfClientReport == null || (jArrM63a = m63a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = jArrM63a[0];
        perfClientReport.perfLatencies = jArrM63a[1];
        return perfClientReport;
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }
}
