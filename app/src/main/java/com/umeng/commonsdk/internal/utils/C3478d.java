package com.umeng.commonsdk.internal.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/* compiled from: CpuUtil.java */
/* renamed from: com.umeng.commonsdk.internal.utils.d */
/* loaded from: classes2.dex */
public class C3478d {

    /* compiled from: CpuUtil.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.d$a */
    public static class a {

        /* renamed from: a */
        public String f12651a;

        /* renamed from: b */
        public String f12652b;

        /* renamed from: c */
        public int f12653c;

        /* renamed from: d */
        public String f12654d;

        /* renamed from: e */
        public String f12655e;

        /* renamed from: f */
        public String f12656f;

        /* renamed from: g */
        public String f12657g;

        /* renamed from: h */
        public String f12658h;

        /* renamed from: i */
        public String f12659i;

        /* renamed from: j */
        public String f12660j;

        /* renamed from: k */
        public String f12661k;

        /* renamed from: l */
        public String f12662l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0140, code lost:
    
        if (r4 != 0) goto L124;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.umeng.commonsdk.internal.utils.C3478d.a m11652a() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.C3478d.m11652a():com.umeng.commonsdk.internal.utils.d$a");
    }

    /* renamed from: b */
    public static String m11653b() {
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

    /* renamed from: c */
    public static String m11654c() {
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

    /* renamed from: d */
    public static String m11655d() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String trim = bufferedReader.readLine().trim();
            try {
                bufferedReader.close();
                return trim;
            } catch (Throwable unused2) {
                return trim;
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
