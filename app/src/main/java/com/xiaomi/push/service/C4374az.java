package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4242gi;
import com.xiaomi.push.C4243gj;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.C4408w;
import com.xiaomi.push.EnumC4249gp;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.xiaomi.push.service.az */
/* loaded from: classes2.dex */
public class C4374az {

    /* renamed from: a */
    private static AtomicLong f16671a = new AtomicLong(0);

    /* renamed from: a */
    private static SimpleDateFormat f16670a = new SimpleDateFormat("yyyy/MM/dd");

    /* renamed from: a */
    private static String f16669a = f16670a.format(Long.valueOf(System.currentTimeMillis()));

    /* renamed from: a */
    public static synchronized String m16040a() {
        String str;
        synchronized (C4374az.class) {
            String format = f16670a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f16669a, format)) {
                f16671a.set(0L);
                f16669a = format;
            }
            str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f16671a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.xiaomi.push.C4265he> m16041a(java.util.List<com.xiaomi.push.C4243gj> r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r0 = 0
            if (r11 != 0) goto L9
            java.lang.String r11 = "requests can not be null in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r11)
            return r0
        L9:
            int r1 = r11.size()
            if (r1 != 0) goto L15
            java.lang.String r11 = "requests.length is 0 in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r11)
            return r0
        L15:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaomi.push.gi r2 = new com.xiaomi.push.gi
            r2.<init>()
            r3 = 0
            r4 = r2
            r2 = 0
            r5 = 0
        L23:
            int r6 = r11.size()
            if (r2 >= r6) goto Lae
            java.lang.Object r6 = r11.get(r2)
            com.xiaomi.push.gj r6 = (com.xiaomi.push.C4243gj) r6
            if (r6 != 0) goto L33
            goto Laa
        L33:
            java.util.Map r7 = r6.m14985a()
            if (r7 == 0) goto L72
            java.util.Map r7 = r6.m14985a()
            java.lang.String r8 = "item_size"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L72
            java.util.Map r7 = r6.m14985a()
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L5a
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L5a
            goto L5b
        L5a:
            r7 = 0
        L5b:
            java.util.Map r9 = r6.m14985a()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L6a
            r6.m14982a(r0)
            goto L73
        L6a:
            java.util.Map r9 = r6.m14985a()
            r9.remove(r8)
            goto L73
        L72:
            r7 = 0
        L73:
            if (r7 > 0) goto L7a
            byte[] r7 = com.xiaomi.push.C4276hp.m15567a(r6)
            int r7 = r7.length
        L7a:
            if (r7 <= r14) goto L95
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TinyData is too big, ignore upload request item:"
            r7.append(r8)
            java.lang.String r6 = r6.m15001d()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r6)
            goto Laa
        L95:
            int r8 = r5 + r7
            if (r8 <= r14) goto La6
            com.xiaomi.push.he r4 = m16039a(r12, r13, r4)
            r1.add(r4)
            com.xiaomi.push.gi r4 = new com.xiaomi.push.gi
            r4.<init>()
            r5 = 0
        La6:
            r4.m14975a(r6)
            int r5 = r5 + r7
        Laa:
            int r2 = r2 + 1
            goto L23
        Lae:
            int r11 = r4.m14972a()
            if (r11 == 0) goto Lbb
            com.xiaomi.push.he r11 = m16039a(r12, r13, r4)
            r1.add(r11)
        Lbb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4374az.m16041a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    /* renamed from: a */
    private static C4265he m16039a(String str, String str2, C4242gi c4242gi) {
        return new C4265he("-1", false).m15322d(str).m15314b(str2).m15305a(C4408w.m16362a(C4276hp.m15567a(c4242gi))).m15318c(EnumC4249gp.UploadTinyData.f15769a);
    }

    /* renamed from: a */
    public static boolean m16043a(C4243gj c4243gj, boolean z) {
        if (c4243gj == null) {
            AbstractC4022b.m13347a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z && TextUtils.isEmpty(c4243gj.f15538a)) {
            AbstractC4022b.m13347a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(c4243gj.f15545d)) {
            AbstractC4022b.m13347a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(c4243gj.f15544c)) {
            AbstractC4022b.m13347a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!C4100bb.m13886a(c4243gj.f15545d)) {
            AbstractC4022b.m13347a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!C4100bb.m13886a(c4243gj.f15544c)) {
            AbstractC4022b.m13347a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        String str = c4243gj.f15543b;
        if (str == null || str.length() <= 30720) {
            return false;
        }
        AbstractC4022b.m13347a("item.data is too large(" + c4243gj.f15543b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
        return true;
    }

    /* renamed from: a */
    public static void m16042a(Context context, String str, String str2, long j2, String str3) {
        C4243gj c4243gj = new C4243gj();
        c4243gj.m15000d(str);
        c4243gj.m14996c(str2);
        c4243gj.m14980a(j2);
        c4243gj.m14992b(str3);
        c4243gj.m14981a("push_sdk_channel");
        c4243gj.m15008g(context.getPackageName());
        c4243gj.m15003e(context.getPackageName());
        c4243gj.m14983a(true);
        c4243gj.m14991b(System.currentTimeMillis());
        c4243gj.m15006f(m16040a());
        C4376ba.m16052a(context, c4243gj);
    }

    /* renamed from: a */
    public static boolean m16044a(String str) {
        return !C4309r.m15722b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
