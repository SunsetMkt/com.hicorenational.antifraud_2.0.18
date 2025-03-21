package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.C4310s;
import com.xiaomi.push.service.C4355ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.f */
/* loaded from: classes2.dex */
public class C4383f {

    /* renamed from: a */
    private static final SparseArray<C4355ag.a<String, String, String>> f16702a;

    /* renamed from: a */
    private static final int[] f16703a = {1, 2, 4, 8, 16};

    /* renamed from: b */
    private static final SparseArray<Integer> f16704b;

    static {
        int i2 = 5;
        f16702a = new SparseArray<C4355ag.a<String, String, String>>(i2) { // from class: com.xiaomi.push.service.f.1
            {
                put(1, C4355ag.f16521b);
                put(2, C4355ag.f16522c);
                put(4, C4355ag.f16523d);
                put(8, C4355ag.f16525f);
                put(16, C4355ag.f16524e);
            }
        };
        f16704b = new SparseArray<Integer>(i2) { // from class: com.xiaomi.push.service.f.2
            {
                put(1, 32);
                put(2, 16);
                put(4, 8);
                put(8, 4);
                put(16, 2);
            }
        };
    }

    /* renamed from: a */
    static int m16081a(String str, String str2) {
        int i2 = m16094a(str, str2, 8) ? 8 : 0;
        if (m16094a(str, str2, 16)) {
            i2 |= 16;
        }
        if (m16094a(str, str2, 1)) {
            i2 |= 1;
        }
        if (m16094a(str, str2, 2)) {
            i2 |= 2;
        }
        return m16094a(str, str2, 4) ? i2 | 4 : i2;
    }

    /* renamed from: a */
    private static boolean m16093a(int i2, int i3) {
        return i2 >= 4 || (i3 & 2) > 0 || (i3 & 1) > 0 || (i3 & 8) > 0 || (i3 & 16) > 0;
    }

    /* renamed from: a */
    static void m16086a(Context context, String str, String str2, int i2, String str3, boolean z, int i3) {
        if (C4300j.m15681a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int m15725a = C4310s.m15725a(str3, 0);
            boolean m16093a = m16093a(i2, m15725a);
            if (z) {
                m16091a(str, str2, m15725a, i3);
                if (m16093a) {
                    synchronized (C4383f.class) {
                        m16087a(m16083a(context), m15725a, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (C4383f.class) {
                SharedPreferences m16083a = m16083a(context);
                if (m16093a || m16083a.contains(str2)) {
                    m16088a(m16083a, m15725a, str, str2, i3);
                    if (m16093a) {
                        m16087a(m16083a, m15725a, str2);
                    } else {
                        m16089a(m16083a, str2);
                    }
                }
            }
            return;
        }
        if (C4300j.m15681a(context)) {
            AbstractC4022b.m13347a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    /* renamed from: a */
    static void m16085a(Context context, String str) {
        List<NotificationChannel> m15890a;
        if (!C4300j.m15681a(context) || TextUtils.isEmpty(str) || (m15890a = C4354af.m15874a(context, str).m15890a()) == null) {
            return;
        }
        synchronized (C4383f.class) {
            SharedPreferences m16083a = m16083a(context);
            ArrayList arrayList = new ArrayList();
            Iterator<NotificationChannel> it = m15890a.iterator();
            while (it.hasNext()) {
                String str2 = (String) C4094aw.m13821a(it.next(), "mId");
                if (!TextUtils.isEmpty(str2) && m16083a.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                m16090a(m16083a, arrayList);
            }
        }
    }

    /* renamed from: a */
    static void m16091a(String str, String str2, int i2, int i3) {
        for (int i4 : f16703a) {
            if ((f16704b.get(i4).intValue() & i3) == 0) {
                m16092a(str, str2, i4, (i2 & i4) > 0);
            } else {
                AbstractC4022b.m13347a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i4 + "> :stoped by userLock");
            }
        }
    }

    /* renamed from: a */
    private static void m16092a(String str, String str2, int i2, boolean z) {
        AbstractC4022b.m13347a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i2 + ContainerUtils.KEY_VALUE_DELIMITER + z + "> :" + C4355ag.m15917a(C4309r.m15715a(), str, str2, f16702a.get(i2), z));
    }

    /* renamed from: a */
    public static int m16082a(String str, String str2, int i2) {
        return C4355ag.m15901a(C4309r.m15715a(), str, str2, f16702a.get(i2));
    }

    /* renamed from: a */
    public static Bundle m16084a(String str, String str2) {
        return C4355ag.m15902a(C4309r.m15715a(), str, str2);
    }

    /* renamed from: a */
    private static boolean m16094a(String str, String str2, int i2) {
        boolean z = C4355ag.m15901a(C4309r.m15715a(), str, str2, f16702a.get(i2)) == 1;
        AbstractC4022b.m13347a("ChannelPermissions.checkPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i2 + ContainerUtils.KEY_VALUE_DELIMITER + z + ">");
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0081, code lost:
    
        if (r1 == 0) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0092  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m16079a(android.content.Context r5, java.lang.String r6, android.app.NotificationChannel r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto Laf
            if (r5 == 0) goto Laf
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto Laf
            if (r7 == 0) goto Laf
            int r5 = r7.getImportance()
            r0 = 1
            if (r5 == 0) goto L1a
            r5 = 1
            goto L1b
        L1a:
            r5 = 2
        L1b:
            r5 = r5 | r1
            boolean r1 = com.xiaomi.push.service.C4355ag.m15914a()
            r2 = 16
            r3 = 4
            r4 = 8
            if (r1 == 0) goto L6e
            java.lang.String r0 = r7.getId()
            android.os.Bundle r6 = m16084a(r6, r0)
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.C4355ag.f16525f
            T r0 = r0.f16530c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L51
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.C4355ag.f16525f
            T r0 = r0.f16530c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.getBoolean(r0)
            if (r0 == 0) goto L4e
            int r0 = r7.getImportance()
            if (r0 < r3) goto L4e
            goto L50
        L4e:
            r3 = 8
        L50:
            r5 = r5 | r3
        L51:
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.C4355ag.f16524e
            T r0 = r0.f16530c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L96
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.C4355ag.f16524e
            T r0 = r0.f16530c
            java.lang.String r0 = (java.lang.String) r0
            boolean r6 = r6.getBoolean(r0)
            if (r6 == 0) goto L6a
            goto L6c
        L6a:
            r2 = 32
        L6c:
            r5 = r5 | r2
            goto L96
        L6e:
            java.lang.String r1 = r7.getId()
            int r1 = m16082a(r6, r1, r4)
            if (r1 != r0) goto L81
            int r1 = r7.getImportance()
            if (r1 < r3) goto L83
            r5 = r5 | 4
            goto L85
        L81:
            if (r1 != 0) goto L85
        L83:
            r5 = r5 | 8
        L85:
            java.lang.String r1 = r7.getId()
            int r6 = m16082a(r6, r1, r2)
            if (r6 != r0) goto L92
            r5 = r5 | 16
            goto L96
        L92:
            if (r6 != 0) goto L96
            r5 = r5 | 32
        L96:
            android.net.Uri r6 = r7.getSound()
            if (r6 == 0) goto L9f
            r5 = r5 | 64
            goto La1
        L9f:
            r5 = r5 | 128(0x80, float:1.8E-43)
        La1:
            boolean r6 = r7.shouldVibrate()
            if (r6 == 0) goto Laa
            r6 = 256(0x100, float:3.59E-43)
            goto Lac
        Laa:
            r6 = 512(0x200, float:7.17E-43)
        Lac:
            r1 = r5 | r6
            goto Lb4
        Laf:
            java.lang.String r5 = "context|packageName|channel must not be null "
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r5)
        Lb4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4383f.m16079a(android.content.Context, java.lang.String, android.app.NotificationChannel):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m16080a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto L67
            if (r3 == 0) goto L67
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L67
            com.xiaomi.push.service.af r3 = com.xiaomi.push.service.C4354af.m15874a(r3, r4)
            if (r3 == 0) goto L61
            java.lang.String r5 = r3.m15889a(r5)
            android.app.NotificationChannel r3 = r3.m15886a(r5)
            if (r3 == 0) goto L5b
            int r5 = r3.getImportance()
            r0 = 1
            if (r5 == 0) goto L28
            r5 = 1
            goto L29
        L28:
            r5 = 2
        L29:
            r5 = r5 | r1
            java.lang.String r1 = r3.getId()
            r2 = 8
            int r1 = m16082a(r4, r1, r2)
            if (r1 != r0) goto L40
            int r1 = r3.getImportance()
            r2 = 4
            if (r1 < r2) goto L42
            r5 = r5 | 4
            goto L44
        L40:
            if (r1 != 0) goto L44
        L42:
            r5 = r5 | 8
        L44:
            java.lang.String r3 = r3.getId()
            r1 = 16
            int r3 = m16082a(r4, r3, r1)
            if (r3 != r0) goto L54
            r3 = r5 | 16
        L52:
            r1 = r3
            goto L6c
        L54:
            if (r3 != 0) goto L59
            r3 = r5 | 32
            goto L52
        L59:
            r1 = r5
            goto L6c
        L5b:
            java.lang.String r3 = "Channel must not be null"
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r3)
            goto L6c
        L61:
            java.lang.String r3 = "create NMHelper error"
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r3)
            goto L6c
        L67:
            java.lang.String r3 = "Must greater than or equal android O and context|packageName not be null"
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r3)
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4383f.m16080a(android.content.Context, java.lang.String, java.lang.String):int");
    }

    /* renamed from: a */
    private static void m16088a(SharedPreferences sharedPreferences, int i2, String str, String str2, int i3) {
        if (sharedPreferences.getInt(str2, 0) != i2) {
            m16091a(str, str2, i2, i3);
        }
    }

    /* renamed from: a */
    private static void m16087a(SharedPreferences sharedPreferences, int i2, String str) {
        sharedPreferences.edit().putInt(str, i2).commit();
    }

    /* renamed from: a */
    private static void m16089a(SharedPreferences sharedPreferences, final String str) {
        m16090a(sharedPreferences, new ArrayList<String>() { // from class: com.xiaomi.push.service.f.3
            {
                add(str);
            }
        });
    }

    /* renamed from: a */
    private static void m16090a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.commit();
    }

    /* renamed from: a */
    private static SharedPreferences m16083a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }
}
