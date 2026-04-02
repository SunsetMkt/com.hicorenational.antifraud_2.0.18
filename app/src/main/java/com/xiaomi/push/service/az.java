package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gp;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class az {

    /* JADX INFO: renamed from: a */
    private static AtomicLong f1027a = new AtomicLong(0);

    /* JADX INFO: renamed from: a */
    private static SimpleDateFormat f1026a = new SimpleDateFormat("yyyy/MM/dd");
    private static String a = f1026a.format(Long.valueOf(System.currentTimeMillis()));

    public static synchronized String a() {
        String str;
        str = f1026a.format(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.equals(a, str)) {
            f1027a.set(0L);
            a = str;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f1027a.incrementAndGet();
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<he> a(List<gj> list, String str, String str2, int i2) {
        int length;
        if (list == null) {
            com.xiaomi.channel.commonutils.logger.b.d("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        }
        if (list.size() == 0) {
            com.xiaomi.channel.commonutils.logger.b.d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        }
        ArrayList<he> arrayList = new ArrayList<>();
        gi giVar = new gi();
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            gj gjVar = list.get(i4);
            if (gjVar != null) {
                if (gjVar.m462a() == null || !gjVar.m462a().containsKey("item_size")) {
                    length = 0;
                } else {
                    String str3 = gjVar.m462a().get("item_size");
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            length = Integer.parseInt(str3);
                        } catch (Exception unused) {
                            length = 0;
                        }
                        if (gjVar.m462a().size() != 1) {
                            gjVar.a((Map<String, String>) null);
                        } else {
                            gjVar.m462a().remove("item_size");
                        }
                    } else {
                        length = 0;
                        if (gjVar.m462a().size() != 1) {
                        }
                    }
                }
                if (length <= 0) {
                    length = hp.a(gjVar).length;
                }
                if (length > i2) {
                    com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + gjVar.d());
                } else {
                    if (i3 + length > i2) {
                        arrayList.add(a(str, str2, giVar));
                        giVar = new gi();
                        i3 = 0;
                    }
                    giVar.a(gjVar);
                    i3 += length;
                }
            }
        }
        if (giVar.a() != 0) {
            arrayList.add(a(str, str2, giVar));
        }
        return arrayList;
    }

    private static he a(String str, String str2, gi giVar) {
        return new he("-1", false).d(str).b(str2).a(com.xiaomi.push.w.a(hp.a(giVar))).c(gp.UploadTinyData.f597a);
    }

    public static boolean a(gj gjVar, boolean z) {
        if (gjVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m48a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z && TextUtils.isEmpty(gjVar.f569a)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gjVar.f576d)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gjVar.f575c)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bb.m175a(gjVar.f576d)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bb.m175a(gjVar.f575c)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        String str = gjVar.f574b;
        if (str == null || str.length() <= 30720) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("item.data is too large(" + gjVar.f574b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
        return true;
    }

    public static void a(Context context, String str, String str2, long j2, String str3) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c(str2);
        gjVar.a(j2);
        gjVar.b(str3);
        gjVar.a("push_sdk_channel");
        gjVar.g(context.getPackageName());
        gjVar.e(context.getPackageName());
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.f(a());
        ba.a(context, gjVar);
    }

    public static boolean a(String str) {
        return !com.xiaomi.push.r.m638b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
