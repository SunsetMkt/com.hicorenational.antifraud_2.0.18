package util;

import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MMKVUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class u1 {
    public static final String A = "key_cdn_version";
    public static final int a = 0;

    /* JADX INFO: renamed from: b */
    public static final String f15079b = "key_longitude";

    /* JADX INFO: renamed from: c */
    public static final String f15080c = "key_latitude";

    /* JADX INFO: renamed from: d */
    public static final String f15081d = "key_address";

    /* JADX INFO: renamed from: e */
    public static final String f15082e = "key_region_id";

    /* JADX INFO: renamed from: f */
    public static final String f15083f = "key_province_name";

    /* JADX INFO: renamed from: g */
    public static final String f15084g = "key_region_name";

    /* JADX INFO: renamed from: h */
    public static final String f15085h = "key_node_address";

    /* JADX INFO: renamed from: i */
    public static final String f15086i = "key_address_vertion";

    /* JADX INFO: renamed from: j */
    public static final String f15087j = "key_address_last_day";

    /* JADX INFO: renamed from: k */
    public static final String f15088k = "key_login_police";

    /* JADX INFO: renamed from: l */
    public static final String f15089l = "key_user_info";

    /* JADX INFO: renamed from: m */
    public static final String f15090m = "update_home";

    /* JADX INFO: renamed from: n */
    public static final String f15091n = "key_xy_agree";
    public static final String o = "key_new_case";
    public static final String p = "key_white";
    public static final String q = "key_failLogin";
    public static final String r = "key_failAuthLogin";
    public static final String s = "key_failRegist";
    public static final String t = "key_failFortPwd";
    public static final String u = "key_failRestPhone";
    public static final String v = "key_failRestPwd";
    public static final String w = "key_logoutAcc";
    public static final String x = "key_policLogin";
    public static final String y = "isFirstEnter";
    public static final String z = "key_uuid";

    private static MMKV a() {
        return MMKV.defaultMMKV();
    }

    public static void b(String str, boolean z2) {
        a().encode(str, z2);
    }

    public static void a(String str, String str2) {
        a().encode(str, str2);
    }

    public static void b(String str, int i2) {
        a().encode(str, i2);
    }

    public static String a(String str) {
        return a().decodeString(str);
    }

    public static void b(String str, long j2) {
        a().encode(str, j2);
    }

    public static boolean a(String str, boolean z2) {
        return a().decodeBool(str, z2);
    }

    public static void b(String str, float f2) {
        a().encode(str, f2);
    }

    public static int a(String str, int i2) {
        return a().decodeInt(str, i2);
    }

    public static void b(String str, double d2) {
        a().encode(str, d2);
    }

    public static long a(String str, long j2) {
        return a().decodeLong(str, j2);
    }

    public static void b(String str, byte[] bArr) {
        a().encode(str, bArr);
    }

    public static float a(String str, float f2) {
        return a().decodeFloat(str, f2);
    }

    public static <T> List<T> b(String str, Class<T> cls) {
        MMKV mmkvA = a();
        com.google.gson.e eVar = new com.google.gson.e();
        String strDecodeString = mmkvA.decodeString(str, null);
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(strDecodeString)) {
                Iterator<com.google.gson.k> it = new com.google.gson.o().a(strDecodeString).getAsJsonArray().iterator();
                while (it.hasNext()) {
                    arrayList.add(eVar.a(it.next(), (Class) cls));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static double a(String str, double d2) {
        return a().decodeDouble(str, d2);
    }

    public static byte[] a(String str, byte[] bArr) {
        return a().decodeBytes(str, bArr);
    }

    public static <T> void a(String str, T t2) {
        MMKV mmkvA = a();
        com.google.gson.e eVar = new com.google.gson.e();
        if (t2 == null) {
            mmkvA.encode(str, "");
        } else {
            mmkvA.encode(str, eVar.a(t2));
        }
    }

    public static <T> T a(String str, Class<T> cls) {
        MMKV mmkvA = a();
        com.google.gson.e eVar = new com.google.gson.e();
        String strDecodeString = mmkvA.decodeString(str, "");
        try {
            if (TextUtils.isEmpty(strDecodeString)) {
                return null;
            }
            return (T) eVar.a((com.google.gson.k) new com.google.gson.o().a(strDecodeString).getAsJsonObject(), (Class) cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> void a(String str, List<T> list) {
        MMKV mmkvA = a();
        com.google.gson.e eVar = new com.google.gson.e();
        if (list == null) {
            mmkvA.encode(str, "");
        } else {
            mmkvA.encode(str, eVar.a(list));
        }
    }
}
