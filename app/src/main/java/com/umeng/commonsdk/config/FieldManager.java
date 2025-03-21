package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.C3458d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class FieldManager {

    /* renamed from: a */
    private static final String f12419a = "cfgfd";

    /* renamed from: b */
    private static C3456b f12420b = C3456b.m11541b();

    /* renamed from: c */
    private static boolean f12421c = false;

    /* renamed from: d */
    private static Object f12422d = new Object();

    /* renamed from: com.umeng.commonsdk.config.FieldManager$a */
    private static class C3454a {

        /* renamed from: a */
        private static final FieldManager f12423a = new FieldManager();

        private C3454a() {
        }
    }

    /* renamed from: a */
    public static FieldManager m11529a() {
        return C3454a.f12423a;
    }

    public static boolean allow(String str) {
        synchronized (f12422d) {
            if (!f12421c) {
                return false;
            }
            return C3456b.m11540a(str);
        }
    }

    /* renamed from: b */
    public static boolean m11530b() {
        boolean z;
        synchronized (f12422d) {
            z = f12421c;
        }
        return z;
    }

    private FieldManager() {
    }

    /* renamed from: a */
    public void m11531a(Context context) {
        String str;
        String[] strArr = {C3458d.a.class.getName(), C3458d.b.class.getName(), C3458d.c.class.getName(), C3458d.d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f12422d) {
            Pair<Long, String> m11528a = m11528a(imprintProperty);
            if (((Long) m11528a.first).longValue() <= 1000 || (str = (String) m11528a.second) == null || str.length() <= 0) {
                str = "1001@3749699455,2130669566,262139,1983";
            }
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                C3461g c3461g = new C3461g();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(c3461g);
                    ((InterfaceC3459e) arrayList.get(i2)).mo11545a(split[i2], f12420b, C3458d.m11547b(strArr[i2]));
                }
            }
            f12421c = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
    
        if (r12.length() > 0) goto L14;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m11532a(android.content.Context r11, java.lang.String r12) {
        /*
            r10 = this;
            r11 = 4
            java.lang.String[] r11 = new java.lang.String[r11]
            java.lang.Class<com.umeng.commonsdk.config.d$a> r0 = com.umeng.commonsdk.config.C3458d.a.class
            java.lang.String r0 = r0.getName()
            r1 = 0
            r11[r1] = r0
            java.lang.Class<com.umeng.commonsdk.config.d$b> r0 = com.umeng.commonsdk.config.C3458d.b.class
            java.lang.String r0 = r0.getName()
            r2 = 1
            r11[r2] = r0
            java.lang.Class<com.umeng.commonsdk.config.d$c> r0 = com.umeng.commonsdk.config.C3458d.c.class
            java.lang.String r0 = r0.getName()
            r3 = 2
            r11[r3] = r0
            java.lang.Class<com.umeng.commonsdk.config.d$d> r0 = com.umeng.commonsdk.config.C3458d.d.class
            java.lang.String r0 = r0.getName()
            r3 = 3
            r11[r3] = r0
            java.lang.Object r0 = com.umeng.commonsdk.config.FieldManager.f12422d
            monitor-enter(r0)
            com.umeng.commonsdk.config.b r3 = com.umeng.commonsdk.config.FieldManager.f12420b     // Catch: java.lang.Throwable -> L84
            r3.m11542a()     // Catch: java.lang.Throwable -> L84
            if (r12 == 0) goto L50
            android.util.Pair r12 = m11528a(r12)     // Catch: java.lang.Throwable -> L84
            java.lang.Object r3 = r12.first     // Catch: java.lang.Throwable -> L84
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Throwable -> L84
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L84
            r5 = 1000(0x3e8, double:4.94E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L50
            java.lang.Object r12 = r12.second     // Catch: java.lang.Throwable -> L84
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L84
            if (r12 == 0) goto L50
            int r3 = r12.length()     // Catch: java.lang.Throwable -> L84
            if (r3 <= 0) goto L50
            goto L52
        L50:
            java.lang.String r12 = "1001@3749699455,2130669566,262139,1983"
        L52:
            java.lang.String r3 = ","
            java.lang.String[] r12 = r12.split(r3)     // Catch: java.lang.Throwable -> L84
            int r3 = r12.length     // Catch: java.lang.Throwable -> L84
            if (r3 <= 0) goto L80
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L84
            r4.<init>()     // Catch: java.lang.Throwable -> L84
            com.umeng.commonsdk.config.g r5 = new com.umeng.commonsdk.config.g     // Catch: java.lang.Throwable -> L84
            r5.<init>()     // Catch: java.lang.Throwable -> L84
        L65:
            if (r1 >= r3) goto L80
            r4.add(r5)     // Catch: java.lang.Throwable -> L84
            java.lang.Object r6 = r4.get(r1)     // Catch: java.lang.Throwable -> L84
            com.umeng.commonsdk.config.e r6 = (com.umeng.commonsdk.config.InterfaceC3459e) r6     // Catch: java.lang.Throwable -> L84
            r7 = r12[r1]     // Catch: java.lang.Throwable -> L84
            com.umeng.commonsdk.config.b r8 = com.umeng.commonsdk.config.FieldManager.f12420b     // Catch: java.lang.Throwable -> L84
            r9 = r11[r1]     // Catch: java.lang.Throwable -> L84
            java.lang.String[] r9 = com.umeng.commonsdk.config.C3458d.m11547b(r9)     // Catch: java.lang.Throwable -> L84
            r6.mo11545a(r7, r8, r9)     // Catch: java.lang.Throwable -> L84
            int r1 = r1 + 1
            goto L65
        L80:
            com.umeng.commonsdk.config.FieldManager.f12421c = r2     // Catch: java.lang.Throwable -> L84
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
            return
        L84:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.config.FieldManager.m11532a(android.content.Context, java.lang.String):void");
    }

    /* renamed from: a */
    private static Pair<Long, String> m11528a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
