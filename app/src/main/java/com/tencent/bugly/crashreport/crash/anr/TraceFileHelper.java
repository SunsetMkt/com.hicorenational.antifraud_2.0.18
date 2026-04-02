package com.tencent.bugly.crashreport.crash.anr;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.proguard.an;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class TraceFileHelper {

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f6238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f6239d;
    }

    /* JADX INFO: compiled from: BUGLY */
    public interface b {
        boolean a(long j2);

        boolean a(long j2, long j3, String str);

        boolean a(String str, int i2, String str2, String str3, boolean z);

        boolean a(String str, long j2, long j3);
    }

    protected static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                for (Pattern pattern : patternArr) {
                    if (pattern.matcher(line).matches()) {
                        return new Object[]{pattern, line};
                    }
                }
            }
        }
        return null;
    }

    protected static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, final boolean z) throws Throwable {
        if (str == null) {
            an.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public boolean a(String str2, int i2, String str3, String str4, boolean z2) {
                an.c("new thread %s", str2);
                a aVar2 = aVar;
                if (aVar2.f6239d == null) {
                    aVar2.f6239d = new HashMap();
                }
                aVar.f6239d.put(str2, new String[]{str3, str4, "" + i2});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public boolean a(String str2, long j2, long j3) {
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public boolean a(long j2, long j3, String str2) {
                an.c("new process %s", str2);
                a aVar2 = aVar;
                aVar2.a = j2;
                aVar2.f6237b = str2;
                aVar2.f6238c = j3;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public boolean a(long j2) {
                an.c("process end %d", Long.valueOf(j2));
                return false;
            }
        });
        if (aVar.a > 0 && aVar.f6238c > 0 && aVar.f6237b != null) {
            return aVar;
        }
        an.e("first dump error %s", aVar.a + d.c.a.b.a.a.f10074g + aVar.f6238c + d.c.a.b.a.a.f10074g + aVar.f6237b);
        return null;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z) throws Throwable {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public boolean a(String str3, int i2, String str4, String str5, boolean z2) {
                    an.c("new thread %s", str3);
                    a aVar2 = aVar;
                    if (aVar2.a > 0 && aVar2.f6238c > 0 && aVar2.f6237b != null) {
                        if (aVar2.f6239d == null) {
                            aVar2.f6239d = new HashMap();
                        }
                        aVar.f6239d.put(str3, new String[]{str4, str5, "" + i2});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public boolean a(String str3, long j2, long j3) {
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public boolean a(long j2, long j3, String str3) {
                    an.c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    a aVar2 = aVar;
                    aVar2.a = j2;
                    aVar2.f6237b = str3;
                    aVar2.f6238c = j3;
                    return z;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public boolean a(long j2) {
                    an.c("process end %d", Long.valueOf(j2));
                    a aVar2 = aVar;
                    return aVar2.a <= 0 || aVar2.f6238c <= 0 || aVar2.f6237b == null;
                }
            });
            if (aVar.a > 0 && aVar.f6238c > 0 && aVar.f6237b != null) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x014a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0150, code lost:
    
        if (com.tencent.bugly.proguard.an.a(r0) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0152, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0155, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void readTraceFile(String str, b bVar) throws Throwable {
        BufferedReader bufferedReader;
        IOException iOException;
        String strSubstring;
        boolean zContains;
        String strGroup;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists() || !bVar.a(str, file.lastModified(), file.length())) {
            return;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    while (true) {
                        Object[] objArrA = a(bufferedReader, patternCompile);
                        if (objArrA == null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e2) {
                                iOException = e2;
                                if (an.a(iOException)) {
                                    return;
                                }
                                iOException.printStackTrace();
                            }
                        }
                        String[] strArrSplit = objArrA[1].toString().split("\\s");
                        long j2 = Long.parseLong(strArrSplit[2]);
                        long time = simpleDateFormat.parse(strArrSplit[4] + d.c.a.b.a.a.f10074g + strArrSplit[5]).getTime();
                        Object[] objArrA2 = a(bufferedReader, patternCompile3);
                        if (objArrA2 == null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e3) {
                                if (an.a(e3)) {
                                    return;
                                }
                                e3.printStackTrace();
                                return;
                            }
                        }
                        Matcher matcher = patternCompile3.matcher(objArrA2[1].toString());
                        matcher.find();
                        matcher.group(1);
                        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                        if (!bVar.a(j2, time, matcher.group(1))) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e4) {
                                if (an.a(e4)) {
                                    return;
                                }
                                e4.printStackTrace();
                                return;
                            }
                        }
                        do {
                            Object[] objArrA3 = a(bufferedReader, patternCompile4, patternCompile2);
                            if (objArrA3 == null) {
                                break;
                            }
                            if (objArrA3[0] == patternCompile4) {
                                String string = objArrA3[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(string);
                                matcher2.find();
                                String strGroup2 = matcher2.group();
                                strSubstring = strGroup2.substring(1, strGroup2.length() - 1);
                                zContains = string.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(string);
                                matcher3.find();
                                strGroup = matcher3.group();
                            } else if (!bVar.a(Long.parseLong(objArrA3[1].toString().split("\\s")[2]))) {
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (IOException e5) {
                                    if (an.a(e5)) {
                                        return;
                                    }
                                    e5.printStackTrace();
                                    return;
                                }
                            }
                            simpleDateFormat = simpleDateFormat2;
                        } while (bVar.a(strSubstring, Integer.parseInt(strGroup.substring(strGroup.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1)), a(bufferedReader), b(bufferedReader), zContains));
                        bufferedReader.close();
                        return;
                    }
                } catch (Exception e6) {
                    e = e6;
                    bufferedReader2 = bufferedReader;
                    if (!an.a(e)) {
                        e.printStackTrace();
                    }
                    an.d("trace open fail:%s : %s", e.getClass().getName(), "" + e.getMessage());
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            iOException = e7;
                            if (an.a(iOException)) {
                                return;
                            }
                            iOException.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    if (bufferedReader == null) {
                        throw th2;
                    }
                    try {
                        bufferedReader.close();
                        throw th2;
                    } catch (IOException e8) {
                        if (an.a(e8)) {
                            throw th2;
                        }
                        e8.printStackTrace();
                        throw th2;
                    }
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    protected static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 3; i2++) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }
}
