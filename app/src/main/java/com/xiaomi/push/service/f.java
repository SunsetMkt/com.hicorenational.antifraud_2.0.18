package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a */
    private static final int[] f1042a = {1, 2, 4, 8, 16};
    private static final SparseArray<ag.a<String, String, String>> a = new SparseArray<ag.a<String, String, String>>(5) { // from class: com.xiaomi.push.service.f.1
        AnonymousClass1(int i2) {
            super(i2);
            put(1, ag.f9346b);
            put(2, ag.f9347c);
            put(4, ag.f9348d);
            put(8, ag.f9350f);
            put(16, ag.f9349e);
        }
    };

    /* JADX INFO: renamed from: b */
    private static final SparseArray<Integer> f9399b = new SparseArray<Integer>(5) { // from class: com.xiaomi.push.service.f.2
        AnonymousClass2(int i2) {
            super(i2);
            put(1, 32);
            put(2, 16);
            put(4, 8);
            put(8, 4);
            put(16, 2);
        }
    };

    /* JADX INFO: renamed from: com.xiaomi.push.service.f$1 */
    static class AnonymousClass1 extends SparseArray<ag.a<String, String, String>> {
        AnonymousClass1(int i2) {
            super(i2);
            put(1, ag.f9346b);
            put(2, ag.f9347c);
            put(4, ag.f9348d);
            put(8, ag.f9350f);
            put(16, ag.f9349e);
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.f$2 */
    static class AnonymousClass2 extends SparseArray<Integer> {
        AnonymousClass2(int i2) {
            super(i2);
            put(1, 32);
            put(2, 16);
            put(4, 8);
            put(8, 4);
            put(16, 2);
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.service.f$3 */
    static class AnonymousClass3 extends ArrayList<String> {
        final /* synthetic */ String a;

        AnonymousClass3(String str) {
            str = str;
            add(str);
        }
    }

    static int a(String str, String str2) {
        int i2 = m714a(str, str2, 8) ? 8 : 0;
        if (m714a(str, str2, 16)) {
            i2 |= 16;
        }
        if (m714a(str, str2, 1)) {
            i2 |= 1;
        }
        if (m714a(str, str2, 2)) {
            i2 |= 2;
        }
        return m714a(str, str2, 4) ? i2 | 4 : i2;
    }

    private static boolean a(int i2, int i3) {
        return i2 >= 4 || (i3 & 2) > 0 || (i3 & 1) > 0 || (i3 & 8) > 0 || (i3 & 16) > 0;
    }

    static void a(Context context, String str, String str2, int i2, String str3, boolean z, int i3) {
        if (com.xiaomi.push.j.m625a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int iA = com.xiaomi.push.s.a(str3, 0);
            boolean zA = a(i2, iA);
            if (z) {
                a(str, str2, iA, i3);
                if (zA) {
                    synchronized (f.class) {
                        a(a(context), iA, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (f.class) {
                SharedPreferences sharedPreferencesA = a(context);
                if (zA || sharedPreferencesA.contains(str2)) {
                    a(sharedPreferencesA, iA, str, str2, i3);
                    if (zA) {
                        a(sharedPreferencesA, iA, str2);
                    } else {
                        a(sharedPreferencesA, str2);
                    }
                }
            }
            return;
        }
        if (com.xiaomi.push.j.m625a(context)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    static void a(Context context, String str) {
        List<NotificationChannel> listM683a;
        if (!com.xiaomi.push.j.m625a(context) || TextUtils.isEmpty(str) || (listM683a = af.a(context, str).m683a()) == null) {
            return;
        }
        synchronized (f.class) {
            SharedPreferences sharedPreferencesA = a(context);
            ArrayList arrayList = new ArrayList();
            Iterator<NotificationChannel> it = listM683a.iterator();
            while (it.hasNext()) {
                String str2 = (String) com.xiaomi.push.aw.a(it.next(), "mId");
                if (!TextUtils.isEmpty(str2) && sharedPreferencesA.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                a(sharedPreferencesA, arrayList);
            }
        }
    }

    static void a(String str, String str2, int i2, int i3) {
        for (int i4 : f1042a) {
            if ((f9399b.get(i4).intValue() & i3) == 0) {
                a(str, str2, i4, (i2 & i4) > 0);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m48a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i4 + "> :stoped by userLock");
            }
        }
    }

    private static void a(String str, String str2, int i2, boolean z) {
        com.xiaomi.channel.commonutils.logger.b.m48a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i2 + ContainerUtils.KEY_VALUE_DELIMITER + z + "> :" + ag.a(com.xiaomi.push.r.m634a(), str, str2, a.get(i2), z));
    }

    public static int a(String str, String str2, int i2) {
        return ag.a(com.xiaomi.push.r.m634a(), str, str2, a.get(i2));
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m713a(String str, String str2) {
        return ag.a(com.xiaomi.push.r.m634a(), str, str2);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m714a(String str, String str2, int i2) {
        boolean z = ag.a(com.xiaomi.push.r.m634a(), str, str2, a.get(i2)) == 1;
        com.xiaomi.channel.commonutils.logger.b.m48a("ChannelPermissions.checkPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i2 + ContainerUtils.KEY_VALUE_DELIMITER + z + ">");
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str, NotificationChannel notificationChannel) {
        int iA;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str) && notificationChannel != null) {
            int i2 = (notificationChannel.getImportance() != 0 ? 1 : 2) | 0;
            if (ag.a()) {
                Bundle bundleM713a = m713a(str, notificationChannel.getId());
                if (bundleM713a.containsKey(ag.f9350f.f9354c)) {
                    i2 |= (!bundleM713a.getBoolean(ag.f9350f.f9354c) || notificationChannel.getImportance() < 4) ? 8 : 4;
                }
                if (bundleM713a.containsKey(ag.f9349e.f9354c)) {
                    i2 |= bundleM713a.getBoolean(ag.f9349e.f9354c) ? 16 : 32;
                }
            } else {
                int iA2 = a(str, notificationChannel.getId(), 8);
                if (iA2 == 1) {
                    i2 = notificationChannel.getImportance() >= 4 ? i2 | 4 : i2 | 8;
                    iA = a(str, notificationChannel.getId(), 16);
                    if (iA != 1) {
                        i2 |= 16;
                    } else if (iA == 0) {
                        i2 |= 32;
                    }
                } else {
                    if (iA2 == 0) {
                    }
                    iA = a(str, notificationChannel.getId(), 16);
                    if (iA != 1) {
                    }
                }
            }
            return (notificationChannel.getSound() != null ? i2 | 64 : i2 | 128) | (notificationChannel.shouldVibrate() ? 256 : 512);
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("context|packageName|channel must not be null ");
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str, String str2) {
        int i2;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str)) {
            af afVarA = af.a(context, str);
            if (afVarA != null) {
                NotificationChannel notificationChannelM679a = afVarA.m679a(afVarA.m682a(str2));
                if (notificationChannelM679a != null) {
                    int i3 = (notificationChannelM679a.getImportance() != 0 ? 1 : 2) | 0;
                    int iA = a(str, notificationChannelM679a.getId(), 8);
                    if (iA == 1) {
                        i3 = notificationChannelM679a.getImportance() >= 4 ? i3 | 4 : i3 | 8;
                    } else if (iA == 0) {
                    }
                    int iA2 = a(str, notificationChannelM679a.getId(), 16);
                    if (iA2 == 1) {
                        i2 = i3 | 16;
                    } else {
                        if (iA2 != 0) {
                            return i3;
                        }
                        i2 = i3 | 32;
                    }
                    return i2;
                }
                com.xiaomi.channel.commonutils.logger.b.m48a("Channel must not be null");
                return 0;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("create NMHelper error");
            return 0;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("Must greater than or equal android O and context|packageName not be null");
        return 0;
    }

    private static void a(SharedPreferences sharedPreferences, int i2, String str, String str2, int i3) {
        if (sharedPreferences.getInt(str2, 0) != i2) {
            a(str, str2, i2, i3);
        }
    }

    private static void a(SharedPreferences sharedPreferences, int i2, String str) {
        sharedPreferences.edit().putInt(str, i2).commit();
    }

    private static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, new ArrayList<String>() { // from class: com.xiaomi.push.service.f.3
            final /* synthetic */ String a;

            AnonymousClass3(String str2) {
                str = str2;
                add(str);
            }
        });
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }
}
