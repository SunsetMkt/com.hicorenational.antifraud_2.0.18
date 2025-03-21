package util;

import android.text.TextUtils;
import com.google.gson.AbstractC2063k;
import com.google.gson.C2051e;
import com.google.gson.C2067o;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MMKVUtils.java */
/* renamed from: util.p1 */
/* loaded from: classes2.dex */
public class C7307p1 {

    /* renamed from: A */
    public static final String f25491A = "key_cdn_version";

    /* renamed from: a */
    public static final int f25492a = 0;

    /* renamed from: b */
    public static final String f25493b = "key_longitude";

    /* renamed from: c */
    public static final String f25494c = "key_latitude";

    /* renamed from: d */
    public static final String f25495d = "key_address";

    /* renamed from: e */
    public static final String f25496e = "key_region_id";

    /* renamed from: f */
    public static final String f25497f = "key_province_name";

    /* renamed from: g */
    public static final String f25498g = "key_region_name";

    /* renamed from: h */
    public static final String f25499h = "key_node_address";

    /* renamed from: i */
    public static final String f25500i = "key_address_vertion";

    /* renamed from: j */
    public static final String f25501j = "key_address_last_day";

    /* renamed from: k */
    public static final String f25502k = "key_login_police";

    /* renamed from: l */
    public static final String f25503l = "key_user_info";

    /* renamed from: m */
    public static final String f25504m = "update_home";

    /* renamed from: n */
    public static final String f25505n = "key_xy_agree";

    /* renamed from: o */
    public static final String f25506o = "key_new_case";

    /* renamed from: p */
    public static final String f25507p = "key_white";

    /* renamed from: q */
    public static final String f25508q = "key_failLogin";

    /* renamed from: r */
    public static final String f25509r = "key_failAuthLogin";

    /* renamed from: s */
    public static final String f25510s = "key_failRegist";

    /* renamed from: t */
    public static final String f25511t = "key_failFortPwd";

    /* renamed from: u */
    public static final String f25512u = "key_failRestPhone";

    /* renamed from: v */
    public static final String f25513v = "key_failRestPwd";

    /* renamed from: w */
    public static final String f25514w = "key_logoutAcc";

    /* renamed from: x */
    public static final String f25515x = "key_policLogin";

    /* renamed from: y */
    public static final String f25516y = "isFirstEnter";

    /* renamed from: z */
    public static final String f25517z = "key_uuid";

    /* renamed from: a */
    private static MMKV m26475a() {
        return MMKV.defaultMMKV();
    }

    /* renamed from: b */
    public static void m26488b(String str, boolean z) {
        m26475a().encode(str, z);
    }

    /* renamed from: a */
    public static void m26479a(String str, String str2) {
        m26475a().encode(str, str2);
    }

    /* renamed from: b */
    public static void m26486b(String str, int i2) {
        m26475a().encode(str, i2);
    }

    /* renamed from: a */
    public static String m26477a(String str) {
        return m26475a().decodeString(str);
    }

    /* renamed from: b */
    public static void m26487b(String str, long j2) {
        m26475a().encode(str, j2);
    }

    /* renamed from: a */
    public static boolean m26481a(String str, boolean z) {
        return m26475a().decodeBool(str, z);
    }

    /* renamed from: b */
    public static void m26485b(String str, float f2) {
        m26475a().encode(str, f2);
    }

    /* renamed from: a */
    public static int m26473a(String str, int i2) {
        return m26475a().decodeInt(str, i2);
    }

    /* renamed from: b */
    public static void m26484b(String str, double d2) {
        m26475a().encode(str, d2);
    }

    /* renamed from: a */
    public static long m26474a(String str, long j2) {
        return m26475a().decodeLong(str, j2);
    }

    /* renamed from: b */
    public static void m26489b(String str, byte[] bArr) {
        m26475a().encode(str, bArr);
    }

    /* renamed from: a */
    public static float m26472a(String str, float f2) {
        return m26475a().decodeFloat(str, f2);
    }

    /* renamed from: b */
    public static <T> List<T> m26483b(String str, Class<T> cls) {
        MMKV m26475a = m26475a();
        C2051e c2051e = new C2051e();
        String decodeString = m26475a.decodeString(str, null);
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(decodeString)) {
                Iterator<AbstractC2063k> it = new C2067o().m5677a(decodeString).getAsJsonArray().iterator();
                while (it.hasNext()) {
                    arrayList.add(c2051e.m5563a(it.next(), (Class) cls));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* renamed from: a */
    public static double m26471a(String str, double d2) {
        return m26475a().decodeDouble(str, d2);
    }

    /* renamed from: a */
    public static byte[] m26482a(String str, byte[] bArr) {
        return m26475a().decodeBytes(str, bArr);
    }

    /* renamed from: a */
    public static <T> void m26478a(String str, T t) {
        MMKV m26475a = m26475a();
        C2051e c2051e = new C2051e();
        if (t == null) {
            m26475a.encode(str, "");
        } else {
            m26475a.encode(str, c2051e.m5572a(t));
        }
    }

    /* renamed from: a */
    public static <T> T m26476a(String str, Class<T> cls) {
        MMKV m26475a = m26475a();
        C2051e c2051e = new C2051e();
        String decodeString = m26475a.decodeString(str, "");
        try {
            if (TextUtils.isEmpty(decodeString)) {
                return null;
            }
            return (T) c2051e.m5563a((AbstractC2063k) new C2067o().m5677a(decodeString).getAsJsonObject(), (Class) cls);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static <T> void m26480a(String str, List<T> list) {
        MMKV m26475a = m26475a();
        C2051e c2051e = new C2051e();
        if (list == null) {
            m26475a.encode(str, "");
        } else {
            m26475a.encode(str, c2051e.m5572a(list));
        }
    }
}
