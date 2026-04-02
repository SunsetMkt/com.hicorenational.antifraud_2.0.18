package com.umeng.commonsdk.internal.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: CpuUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: compiled from: CpuUtil.java */
    public static class a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f7617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f7618e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f7619f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f7620g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f7621h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f7622i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f7623j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f7624k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f7625l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a() throws Throwable {
        int i2;
        a aVar;
        FileReader fileReader;
        ?? bufferedReader;
        Throwable th;
        try {
            try {
                aVar = new a();
                try {
                    fileReader = new FileReader("/proc/cpuinfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                        try {
                            try {
                                int i3 = 0;
                                boolean z = true;
                                i2 = 0;
                                for (String line = bufferedReader.readLine(); !TextUtils.isEmpty(line) && (i3 = i3 + 1) < 30; line = bufferedReader.readLine()) {
                                    try {
                                        String[] strArrSplit = line.split(":\\s+", 2);
                                        if (z && strArrSplit != null && strArrSplit.length > 1) {
                                            aVar.a = strArrSplit[1];
                                            z = false;
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("processor")) {
                                            i2++;
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("Features")) {
                                            aVar.f7617d = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("implementer")) {
                                            aVar.f7618e = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("architecture")) {
                                            aVar.f7619f = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("variant")) {
                                            aVar.f7620g = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("part")) {
                                            aVar.f7621h = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("revision")) {
                                            aVar.f7622i = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("Hardware")) {
                                            aVar.f7623j = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("Revision")) {
                                            aVar.f7624k = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("Serial")) {
                                            aVar.f7625l = strArrSplit[1];
                                        }
                                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("implementer")) {
                                            aVar.f7618e = strArrSplit[1];
                                        }
                                    } catch (Exception unused) {
                                        bufferedReader = bufferedReader;
                                        if (fileReader != null) {
                                            try {
                                                fileReader.close();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        if (bufferedReader != 0) {
                                        }
                                        aVar.f7616c = i2;
                                        return aVar;
                                    }
                                }
                                try {
                                    fileReader.close();
                                } catch (IOException unused3) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileReader != null) {
                                    try {
                                        fileReader.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                if (bufferedReader != 0) {
                                    throw th;
                                }
                                try {
                                    bufferedReader.close();
                                    throw th;
                                } catch (IOException unused5) {
                                    throw th;
                                }
                            }
                        } catch (Exception unused6) {
                            i2 = 0;
                            bufferedReader = bufferedReader;
                        }
                    } catch (Exception unused7) {
                        i2 = 0;
                        bufferedReader = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = 0;
                        th = th;
                        if (fileReader != null) {
                        }
                        if (bufferedReader != 0) {
                        }
                    }
                } catch (Exception unused8) {
                    i2 = 0;
                    fileReader = null;
                    bufferedReader = fileReader;
                    if (fileReader != null) {
                    }
                    if (bufferedReader != 0) {
                        bufferedReader.close();
                    }
                    aVar.f7616c = i2;
                    return aVar;
                }
            } catch (Exception unused9) {
                i2 = 0;
                aVar = null;
                fileReader = null;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused10) {
            }
            aVar.f7616c = i2;
            return aVar;
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            bufferedReader = 0;
        }
    }

    public static String b() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String c() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String d() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String strTrim = bufferedReader.readLine().trim();
            try {
                bufferedReader.close();
                return strTrim;
            } catch (Throwable unused2) {
                return strTrim;
            }
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused5) {
                }
            }
            throw th;
        }
    }
}
