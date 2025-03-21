package com.tencent.p208mm.opensdk.channel.p209a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.p208mm.opensdk.constants.Build;
import com.tencent.p208mm.opensdk.constants.ConstantsAPI;
import com.tencent.p208mm.opensdk.utils.C3240b;
import com.tencent.p208mm.opensdk.utils.Log;
import com.umeng.analytics.pro.C3393cw;
import java.security.MessageDigest;

/* renamed from: com.tencent.mm.opensdk.channel.a.a */
/* loaded from: classes2.dex */
public class C3232a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a */
    public static class a {

        /* renamed from: a */
        public String f11051a;

        /* renamed from: b */
        public String f11052b;

        /* renamed from: c */
        public String f11053c;

        /* renamed from: d */
        public long f11054d;

        /* renamed from: e */
        public Bundle f11055e;
    }

    /* renamed from: a */
    public static int m10346a(Bundle bundle, String str, int i2) {
        if (bundle == null) {
            return i2;
        }
        try {
            return bundle.getInt(str, i2);
        } catch (Exception e2) {
            Log.m10364e("MicroMsg.IntentUtil", "getIntExtra exception:" + e2.getMessage());
            return i2;
        }
    }

    /* renamed from: a */
    public static Object m10347a(int i2, String str) {
        try {
            switch (i2) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    Log.m10364e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        } catch (Exception e2) {
            Log.m10364e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static String m10348a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e2) {
            Log.m10364e("MicroMsg.IntentUtil", "getStringExtra exception:" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m10349a(Context context, a aVar) {
        String str;
        if (context == null || aVar == null) {
            str = "send fail, invalid argument";
        } else {
            if (!C3240b.m10372b(aVar.f11052b)) {
                String str2 = null;
                if (!C3240b.m10372b(aVar.f11051a)) {
                    str2 = aVar.f11051a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(aVar.f11052b);
                Bundle bundle = aVar.f11055e;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, aVar.f11053c);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.f11054d);
                intent.putExtra(ConstantsAPI.CHECK_SUM, m10351a(aVar.f11053c, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.m10363d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.m10364e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0155: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:168:0x0155 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] m10350a(java.lang.String r8, int r9) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p208mm.opensdk.channel.p209a.C3232a.m10350a(java.lang.String, int):byte[]");
    }

    /* renamed from: a */
    public static byte[] m10351a(String str, int i2, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i2);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i3 = 0;
            for (byte b2 : digest) {
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                i3 = i4 + 1;
                cArr2[i4] = cArr[b2 & C3393cw.f11873m];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
