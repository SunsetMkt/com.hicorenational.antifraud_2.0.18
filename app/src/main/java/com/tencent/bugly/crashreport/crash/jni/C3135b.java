package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import p000a.p001a.p014u.C0052a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.jni.b */
/* loaded from: classes2.dex */
public class C3135b {

    /* renamed from: a */
    private static List<File> f10456a = new ArrayList();

    /* renamed from: a */
    protected static Map<String, Integer> m9784a(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String[] split = str2.split(Constants.COLON_SEPARATOR);
                if (split.length != 2) {
                    C3151an.m9923e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e2) {
            C3151an.m9923e("error format intStateStr %s", str);
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    protected static String m9786b(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        com.tencent.bugly.proguard.C3151an.m9916a(r3);
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m9789c(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "map_record.txt"
            java.io.BufferedReader r3 = com.tencent.bugly.proguard.C3154aq.m9949a(r3, r0)
            r0 = 0
            if (r3 != 0) goto La
            return r0
        La:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r1.<init>()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L3f
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L4a
            if (r4 != 0) goto L1c
            goto L3f
        L1c:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L4a
            if (r4 == 0) goto L30
            java.lang.String r2 = "  "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4a
            r1.append(r4)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "\n"
            r1.append(r4)     // Catch: java.lang.Throwable -> L4a
            goto L1c
        L30:
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L3e
            r3.close()     // Catch: java.lang.Exception -> L3a
            goto L3e
        L3a:
            r3 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r3)
        L3e:
            return r4
        L3f:
            if (r3 == 0) goto L49
            r3.close()     // Catch: java.lang.Exception -> L45
            goto L49
        L45:
            r3 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r3)
        L49:
            return r0
        L4a:
            r4 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r4)     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r3 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r3)
        L58:
            return r0
        L59:
            r4 = move-exception
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.lang.Exception -> L60
            goto L64
        L60:
            r3 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r3)
        L64:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C3135b.m9789c(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    public static void m9790d(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        C3151an.m9921c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            C3151an.m9916a(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x006d, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0072, code lost:
    
        com.tencent.bugly.proguard.C3151an.m9916a(r9);
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m9787b(java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "reg_record.txt"
            java.io.BufferedReader r9 = com.tencent.bugly.proguard.C3154aq.m9949a(r9, r0)
            r0 = 0
            if (r9 != 0) goto La
            return r0
        La:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r2 = r9.readLine()     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L6b
            boolean r10 = r2.startsWith(r10)     // Catch: java.lang.Throwable -> L76
            if (r10 != 0) goto L1c
            goto L6b
        L1c:
            java.lang.String r10 = "                "
            r2 = 18
            r3 = 0
            r2 = 0
            r4 = 18
            r5 = 0
        L25:
            java.lang.String r6 = r9.readLine()     // Catch: java.lang.Throwable -> L76
            java.lang.String r7 = "\n"
            if (r6 == 0) goto L59
            int r8 = r2 % 4
            if (r8 != 0) goto L3c
            if (r2 <= 0) goto L36
            r1.append(r7)     // Catch: java.lang.Throwable -> L76
        L36:
            java.lang.String r5 = "  "
            r1.append(r5)     // Catch: java.lang.Throwable -> L76
            goto L4f
        L3c:
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L76
            r8 = 16
            if (r7 <= r8) goto L46
            r4 = 28
        L46:
            int r5 = r4 - r5
            java.lang.String r5 = r10.substring(r3, r5)     // Catch: java.lang.Throwable -> L76
            r1.append(r5)     // Catch: java.lang.Throwable -> L76
        L4f:
            int r5 = r6.length()     // Catch: java.lang.Throwable -> L76
            r1.append(r6)     // Catch: java.lang.Throwable -> L76
            int r2 = r2 + 1
            goto L25
        L59:
            r1.append(r7)     // Catch: java.lang.Throwable -> L76
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L76
            if (r9 == 0) goto L6a
            r9.close()     // Catch: java.lang.Exception -> L66
            goto L6a
        L66:
            r9 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r9)
        L6a:
            return r10
        L6b:
            if (r9 == 0) goto L75
            r9.close()     // Catch: java.lang.Exception -> L71
            goto L75
        L71:
            r9 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r9)
        L75:
            return r0
        L76:
            r10 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r10)     // Catch: java.lang.Throwable -> L85
            if (r9 == 0) goto L84
            r9.close()     // Catch: java.lang.Exception -> L80
            goto L84
        L80:
            r9 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r9)
        L84:
            return r0
        L85:
            r10 = move-exception
            if (r9 == 0) goto L90
            r9.close()     // Catch: java.lang.Exception -> L8c
            goto L90
        L8c:
            r9 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r9)
        L90:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C3135b.m9787b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    protected static CrashDetailBean m9780a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        HashMap hashMap;
        if (map == null) {
            return null;
        }
        if (C3113a.m9531a(context) == null) {
            C3151an.m9923e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 != null && str3.trim().length() > 0) {
            Map<String, Integer> m9784a = m9784a(str3);
            if (m9784a == null) {
                C3151an.m9923e("parse intSateMap fail", Integer.valueOf(map.size()));
                return null;
            }
            try {
                m9784a.get("sino").intValue();
                m9784a.get("sud").intValue();
                String str4 = map.get("soVersion");
                if (TextUtils.isEmpty(str4)) {
                    C3151an.m9923e("error format at version", new Object[0]);
                    return null;
                }
                String str5 = map.get("errorAddr");
                String str6 = "unknown";
                String str7 = str5 == null ? "unknown" : str5;
                String str8 = map.get("codeMsg");
                if (str8 == null) {
                    str8 = "unknown";
                }
                String str9 = map.get("tombPath");
                String str10 = str9 == null ? "unknown" : str9;
                String str11 = map.get("signalName");
                if (str11 == null) {
                    str11 = "unknown";
                }
                map.get("errnoMsg");
                String str12 = map.get("stack");
                if (str12 == null) {
                    str12 = "unknown";
                }
                String str13 = map.get("jstack");
                if (str13 != null) {
                    str12 = str12 + "java:\n" + str13;
                }
                Integer num = m9784a.get("sico");
                if (num == null || num.intValue() <= 0) {
                    str = str8;
                    str2 = str11;
                } else {
                    str2 = str11 + "(" + str8 + ")";
                    str = "KERNEL";
                }
                String str14 = map.get("nativeLog");
                byte[] m9974a = (str14 == null || str14.isEmpty()) ? null : C3154aq.m9974a((File) null, str14, "BuglyNativeLog.txt");
                String str15 = map.get("sendingProcess");
                if (str15 == null) {
                    str15 = "unknown";
                }
                Integer num2 = m9784a.get("spd");
                if (num2 != null) {
                    str15 = str15 + "(" + num2 + ")";
                }
                String str16 = str15;
                String str17 = map.get("threadName");
                if (str17 == null) {
                    str17 = "unknown";
                }
                Integer num3 = m9784a.get("et");
                if (num3 != null) {
                    str17 = str17 + "(" + num3 + ")";
                }
                String str18 = str17;
                String str19 = map.get("processName");
                if (str19 != null) {
                    str6 = str19;
                }
                Integer num4 = m9784a.get("ep");
                if (num4 != null) {
                    str6 = str6 + "(" + num4 + ")";
                }
                String str20 = str6;
                String str21 = map.get("key-value");
                if (str21 != null) {
                    HashMap hashMap2 = new HashMap();
                    String[] split = str21.split("\n");
                    int length = split.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String[] split2 = split[i2].split(ContainerUtils.KEY_VALUE_DELIMITER);
                        String[] strArr = split;
                        if (split2.length == 2) {
                            hashMap2.put(split2[0], split2[1]);
                        }
                        i2++;
                        split = strArr;
                    }
                    hashMap = hashMap2;
                } else {
                    hashMap = null;
                }
                CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str20, str18, (m9784a.get("etms").intValue() / 1000) + (m9784a.get("ets").intValue() * 1000), str2, str7, m9786b(str12), str, str16, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, m9974a, hashMap, false, false);
                if (packageCrashDatas != null) {
                    String str22 = map.get("userId");
                    if (str22 != null) {
                        C3151an.m9921c("[Native record info] userId: %s", str22);
                        packageCrashDatas.f10301m = str22;
                    }
                    String str23 = map.get("sysLog");
                    if (str23 != null) {
                        packageCrashDatas.f10311w = str23;
                    }
                    String str24 = map.get("appVersion");
                    if (str24 != null) {
                        C3151an.m9921c("[Native record info] appVersion: %s", str24);
                        packageCrashDatas.f10294f = str24;
                    }
                    String str25 = map.get("isAppForeground");
                    if (str25 != null) {
                        C3151an.m9921c("[Native record info] isAppForeground: %s", str25);
                        packageCrashDatas.f10280O = str25.equalsIgnoreCase(C0052a.f158j);
                    }
                    String str26 = map.get("launchTime");
                    if (str26 != null) {
                        C3151an.m9921c("[Native record info] launchTime: %s", str26);
                        try {
                            packageCrashDatas.f10279N = Long.parseLong(str26);
                        } catch (NumberFormatException e2) {
                            if (!C3151an.m9916a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    packageCrashDatas.f10314z = null;
                    packageCrashDatas.f10299k = true;
                }
                return packageCrashDatas;
            } catch (Throwable th) {
                C3151an.m9923e("error format", new Object[0]);
                th.printStackTrace();
                return null;
            }
        }
        C3151an.m9923e("no intStateStr", new Object[0]);
        return null;
    }

    /* renamed from: c */
    public static String m9788c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        return null;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static java.lang.String m9781a(java.io.BufferedInputStream r4) throws java.io.IOException {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L29
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L29
        Lb:
            int r2 = r4.read()     // Catch: java.lang.Throwable -> L27
            r3 = -1
            if (r2 == r3) goto L30
            if (r2 != 0) goto L23
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L27
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "UTf-8"
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L27
            r1.close()
            return r4
        L23:
            r1.write(r2)     // Catch: java.lang.Throwable -> L27
            goto Lb
        L27:
            r4 = move-exception
            goto L2b
        L29:
            r4 = move-exception
            r1 = r0
        L2b:
            com.tencent.bugly.proguard.C3151an.m9916a(r4)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L33
        L30:
            r1.close()
        L33:
            return r0
        L34:
            r4 = move-exception
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C3135b.m9781a(java.io.BufferedInputStream):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* renamed from: a */
    public static CrashDetailBean m9779a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String m9781a;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                BufferedInputStream canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            canRead = 0;
                            if (canRead != 0) {
                                try {
                                    canRead.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String m9781a2 = m9781a(bufferedInputStream);
                            if (m9781a2 != null && m9781a2.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        m9781a = m9781a(bufferedInputStream);
                                        if (m9781a == null) {
                                            break loop0;
                                        }
                                        if (str2 == null) {
                                            str2 = m9781a;
                                        }
                                    }
                                    hashMap.put(str2, m9781a);
                                }
                                if (str2 != null) {
                                    C3151an.m9923e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean m9780a = m9780a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                                return m9780a;
                            }
                            C3151an.m9923e("record read fail! %s", m9781a2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            return null;
                        } catch (IOException e7) {
                            e = e7;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
        C3151an.m9923e("get eup record file args error", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static String m9783a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String m9787b = m9787b(str, str2);
        if (m9787b != null && !m9787b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(m9787b);
        }
        String m9789c = m9789c(str, str2);
        if (m9789c != null && !m9789c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(m9789c);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m9785a(boolean z, String str) {
        if (str != null) {
            f10456a.add(new File(str, "rqd_record.eup"));
            f10456a.add(new File(str, "reg_record.txt"));
            f10456a.add(new File(str, "map_record.txt"));
            f10456a.add(new File(str, "backup_record.txt"));
            if (z) {
                m9790d(str);
            }
        }
        List<File> list = f10456a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f10456a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                C3151an.m9921c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    /* renamed from: a */
    public static String m9782a(String str, int i2, String str2, boolean z) {
        BufferedReader bufferedReader;
        if (str != null && i2 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                C3151an.m9915a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f10456a.add(file);
                C3151an.m9921c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return C3154aq.m9955a(new File(str), i2, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                if (i2 > 0 && sb.length() > i2) {
                                    if (z) {
                                        sb.delete(i2, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    C3151an.m9916a(th);
                                    sb.append("\n[error:" + th.toString() + "]");
                                    String sb2 = sb.toString();
                                    if (bufferedReader == null) {
                                        return sb2;
                                    }
                                    bufferedReader.close();
                                    sb = sb2;
                                    return sb;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            C3151an.m9916a(e2);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String sb3 = sb.toString();
                        bufferedReader.close();
                        sb = sb3;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                    return sb;
                } catch (Exception e3) {
                    C3151an.m9916a(e3);
                    return sb;
                }
            }
        }
        return null;
    }
}
