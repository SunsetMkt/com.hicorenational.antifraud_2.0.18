package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.C3151an;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$a */
    public static class C3122a {

        /* renamed from: a */
        public long f10326a;

        /* renamed from: b */
        public String f10327b;

        /* renamed from: c */
        public long f10328c;

        /* renamed from: d */
        public Map<String, String[]> f10329d;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b */
    public interface InterfaceC3123b {
        /* renamed from: a */
        boolean mo9657a(long j2);

        /* renamed from: a */
        boolean mo9658a(long j2, long j3, String str);

        /* renamed from: a */
        boolean mo9659a(String str, int i2, String str2, String str3, boolean z);

        /* renamed from: a */
        boolean mo9660a(String str, long j2, long j3);
    }

    /* renamed from: a */
    protected static Object[] m9655a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null) {
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                for (Pattern pattern : patternArr) {
                    if (pattern.matcher(readLine).matches()) {
                        return new Object[]{pattern, readLine};
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    protected static String m9656b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static C3122a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            C3151an.m9923e("path:%s", str);
            return null;
        }
        final C3122a c3122a = new C3122a();
        readTraceFile(str, new InterfaceC3123b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b
            /* renamed from: a */
            public boolean mo9659a(String str2, int i2, String str3, String str4, boolean z2) {
                C3151an.m9921c("new thread %s", str2);
                C3122a c3122a2 = C3122a.this;
                if (c3122a2.f10329d == null) {
                    c3122a2.f10329d = new HashMap();
                }
                C3122a.this.f10329d.put(str2, new String[]{str3, str4, "" + i2});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b
            /* renamed from: a */
            public boolean mo9660a(String str2, long j2, long j3) {
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b
            /* renamed from: a */
            public boolean mo9658a(long j2, long j3, String str2) {
                C3151an.m9921c("new process %s", str2);
                C3122a c3122a2 = C3122a.this;
                c3122a2.f10326a = j2;
                c3122a2.f10327b = str2;
                c3122a2.f10328c = j3;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b
            /* renamed from: a */
            public boolean mo9657a(long j2) {
                C3151an.m9921c("process end %d", Long.valueOf(j2));
                return false;
            }
        });
        if (c3122a.f10326a > 0 && c3122a.f10328c > 0 && c3122a.f10327b != null) {
            return c3122a;
        }
        C3151an.m9923e("first dump error %s", c3122a.f10326a + AbstractC1191a.f2568g + c3122a.f10328c + AbstractC1191a.f2568g + c3122a.f10327b);
        return null;
    }

    public static C3122a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (str != null && str2 != null) {
            final C3122a c3122a = new C3122a();
            readTraceFile(str2, new InterfaceC3123b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b
                /* renamed from: a */
                public boolean mo9659a(String str3, int i2, String str4, String str5, boolean z2) {
                    C3151an.m9921c("new thread %s", str3);
                    C3122a c3122a2 = C3122a.this;
                    if (c3122a2.f10326a > 0 && c3122a2.f10328c > 0 && c3122a2.f10327b != null) {
                        if (c3122a2.f10329d == null) {
                            c3122a2.f10329d = new HashMap();
                        }
                        C3122a.this.f10329d.put(str3, new String[]{str4, str5, "" + i2});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b
                /* renamed from: a */
                public boolean mo9660a(String str3, long j2, long j3) {
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b
                /* renamed from: a */
                public boolean mo9658a(long j2, long j3, String str3) {
                    C3151an.m9921c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    C3122a c3122a2 = C3122a.this;
                    c3122a2.f10326a = j2;
                    c3122a2.f10327b = str3;
                    c3122a2.f10328c = j3;
                    return z;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b
                /* renamed from: a */
                public boolean mo9657a(long j2) {
                    C3151an.m9921c("process end %d", Long.valueOf(j2));
                    C3122a c3122a2 = C3122a.this;
                    return c3122a2.f10326a <= 0 || c3122a2.f10328c <= 0 || c3122a2.f10327b == null;
                }
            });
            if (c3122a.f10326a > 0 && c3122a.f10328c > 0 && c3122a.f10327b != null) {
                return c3122a;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x014a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0150, code lost:
    
        if (com.tencent.bugly.proguard.C3151an.m9916a(r0) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0152, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0155, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void readTraceFile(java.lang.String r18, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC3123b r19) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTraceFile(java.lang.String, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b):void");
    }

    /* renamed from: a */
    protected static String m9654a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 3; i2++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
