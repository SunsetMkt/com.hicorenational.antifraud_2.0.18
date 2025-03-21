package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.manager.C4025a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.bl */
/* loaded from: classes2.dex */
public class C4110bl {
    /* renamed from: a */
    public static String m13917a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    @TargetApi(9)
    /* renamed from: a */
    public static byte[] m13924a(String str) {
        byte[] copyOf = Arrays.copyOf(C4096ay.m13840a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* renamed from: a */
    public static String m13918a(Context context) {
        String m13928a = C4111bm.m13926a(context).m13928a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(m13928a)) {
            return m13928a;
        }
        String m13878a = C4100bb.m13878a(20);
        C4111bm.m13926a(context).m13930a("sp_client_report_status", "sp_client_report_key", m13878a);
        return m13878a;
    }

    /* renamed from: a */
    public static boolean m13922a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m13919a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra(AbstractC1191a.f2579j1, context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra(CommonNetImpl.NAME, "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /* renamed from: a */
    public static void m13921a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m13922a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                m13919a(context, str);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f4, code lost:
    
        if (r7 == null) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m13920a(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C4110bl.m13920a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public static boolean m13923a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = C4025a.m13366a(context).m13381a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() > maxFileLength) {
                    return false;
                }
            } catch (Exception e2) {
                AbstractC4022b.m13351a(e2);
                return false;
            }
        } else {
            C4408w.m16360a(file);
        }
        return true;
    }

    /* renamed from: a */
    public static File[] m13925a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bl.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return (TextUtils.isEmpty(str2) || str2.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
    }
}
