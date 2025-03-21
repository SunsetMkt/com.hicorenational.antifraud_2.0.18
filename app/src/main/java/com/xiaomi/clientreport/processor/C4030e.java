package com.xiaomi.clientreport.processor;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.data.C4024a;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.C4408w;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* renamed from: com.xiaomi.clientreport.processor.e */
/* loaded from: classes2.dex */
public class C4030e {
    /* renamed from: a */
    public static void m13415a(String str, C4024a[] c4024aArr) {
        RandomAccessFile randomAccessFile;
        if (c4024aArr == null || c4024aArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            C4408w.m16360a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> m13412a = m13412a(str);
                for (C4024a c4024a : c4024aArr) {
                    if (c4024a != null) {
                        String m13411a = m13411a((PerfClientReport) c4024a);
                        long j2 = ((PerfClientReport) c4024a).perfCounts;
                        long j3 = ((PerfClientReport) c4024a).perfLatencies;
                        if (!TextUtils.isEmpty(m13411a) && j2 > 0 && j3 >= 0) {
                            m13416a(m13412a, m13411a, j2, j3);
                        }
                    }
                }
                m13414a(str, m13412a);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        e = e2;
                        AbstractC4022b.m13351a(e);
                        C4408w.m16356a(randomAccessFile);
                    }
                }
            } catch (Throwable unused) {
                try {
                    AbstractC4022b.m13359c("failed to write perf to file ");
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            e = e3;
                            AbstractC4022b.m13351a(e);
                            C4408w.m16356a(randomAccessFile);
                        }
                    }
                    C4408w.m16356a(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            AbstractC4022b.m13351a(e4);
                        }
                    }
                    C4408w.m16356a(randomAccessFile);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        C4408w.m16356a(randomAccessFile);
    }

    /* renamed from: a */
    private static void m13416a(HashMap<String, String> hashMap, String str, long j2, long j3) {
        String str2;
        String str3 = hashMap.get(str);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put(str, j2 + "#" + j3);
            return;
        }
        long[] m13417a = m13417a(str3);
        if (m13417a != null && m13417a[0] > 0 && m13417a[1] >= 0) {
            str2 = (j2 + m13417a[0]) + "#" + (j3 + m13417a[1]);
        } else {
            str2 = j2 + "#" + j3;
        }
        hashMap.put(str, str2);
    }

    /* renamed from: a */
    protected static long[] m13417a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return null;
        }
    }

    /* renamed from: a */
    private static void m13414a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e2;
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
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
            C4408w.m16356a(bufferedWriter);
            throw th;
        }
        try {
            try {
                for (String str2 : hashMap.keySet()) {
                    bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                    bufferedWriter.newLine();
                }
            } catch (Throwable th3) {
                th = th3;
                C4408w.m16356a(bufferedWriter);
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
            AbstractC4022b.m13351a(e2);
            C4408w.m16356a(bufferedWriter);
        }
        C4408w.m16356a(bufferedWriter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* renamed from: a */
    private static HashMap<String, String> m13412a(String str) {
        BufferedReader bufferedReader;
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader2 = null;
        ?? r1 = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        ?? split = readLine.split("%%%");
                        r1 = split.length;
                        if (r1 >= 2) {
                            r1 = 0;
                            r1 = 0;
                            if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                r1 = split[0];
                                hashMap.put(r1, split[1]);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader3 = bufferedReader;
                        AbstractC4022b.m13351a(e);
                        C4408w.m16356a(bufferedReader3);
                        bufferedReader2 = bufferedReader3;
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        C4408w.m16356a(bufferedReader);
                        throw th;
                    }
                }
                C4408w.m16356a(bufferedReader);
                bufferedReader2 = r1;
            } catch (Exception e3) {
                e = e3;
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = bufferedReader2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
    
        if (r1 != null) goto L66;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> m13413a(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.C4030e.m13413a(android.content.Context, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    private static String[] m13418a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }

    /* renamed from: a */
    private static PerfClientReport m13410a(String str) {
        PerfClientReport perfClientReport = null;
        try {
            String[] m13418a = m13418a(str);
            if (m13418a == null || m13418a.length < 4 || TextUtils.isEmpty(m13418a[0]) || TextUtils.isEmpty(m13418a[1]) || TextUtils.isEmpty(m13418a[2]) || TextUtils.isEmpty(m13418a[3])) {
                return null;
            }
            perfClientReport = PerfClientReport.getBlankInstance();
            perfClientReport.production = Integer.parseInt(m13418a[0]);
            perfClientReport.clientInterfaceId = m13418a[1];
            perfClientReport.reportType = Integer.parseInt(m13418a[2]);
            perfClientReport.code = Integer.parseInt(m13418a[3]);
            return perfClientReport;
        } catch (Exception unused) {
            AbstractC4022b.m13359c("parse per key error");
            return perfClientReport;
        }
    }

    /* renamed from: a */
    private static PerfClientReport m13409a(PerfClientReport perfClientReport, String str) {
        long[] m13417a;
        if (perfClientReport == null || (m13417a = m13417a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = m13417a[0];
        perfClientReport.perfLatencies = m13417a[1];
        return perfClientReport;
    }

    /* renamed from: a */
    public static String m13411a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }
}
