package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.k */
/* loaded from: classes.dex */
public class C2424k extends C2451u0 {

    /* renamed from: com.huawei.hms.hatool.k$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f7552a;

        static {
            int[] iArr = new int[EnumC2404d0.values().length];
            f7552a = iArr;
            try {
                iArr[EnumC2404d0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7552a[EnumC2404d0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7552a[EnumC2404d0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: a */
    protected static C2410f0 m7189a(String str, String str2, String str3, String str4) {
        C2410f0 m7373a = C2451u0.m7373a(str, str2, str3, str4);
        String m7171a = C2421j.m7169a().m7171a(AbstractC2396a1.m7021c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String sha256Encrypt = SHA.sha256Encrypt(AbstractC2443q0.m7305f() + m7171a + currentTimeMillis);
        m7373a.m7199f(String.valueOf(currentTimeMillis));
        m7373a.m7104g(sha256Encrypt);
        return m7373a;
    }

    /* renamed from: a */
    public static C2417h1 m7190a(List<C2399b1> list, String str, String str2, String str3, String str4) {
        C2452v.m7385c("hmsSdk", "generate UploadData");
        C2417h1 m7376b = C2451u0.m7376b(str, str2);
        if (m7376b == null) {
            return null;
        }
        m7376b.m7157a(m7189a(C2432m1.m7236d().m7237a(), str, str2, str3));
        m7376b.m7158a(m7191a(str, str2));
        m7376b.m7159a(m7192a(str2, str, str4));
        m7376b.m7160a(AbstractC2396a1.m7025g(str, str2));
        m7376b.m7161a(list);
        return m7376b;
    }

    /* renamed from: a */
    protected static C2427l m7191a(String str, String str2) {
        C2427l m7374a = C2451u0.m7374a(str, str2);
        C2418i m7174c = C2421j.m7169a().m7174c(str, str2);
        m7374a.m7212g(C2421j.m7169a().m7171a(AbstractC2396a1.m7021c(str, str2)));
        m7374a.m7211f(AbstractC2396a1.m7033o(str, str2));
        m7374a.m7208c(C2421j.m7169a().m7177f(str, str2));
        int i2 = a.f7552a[m7174c.m7162a().ordinal()];
        if (i2 == 1) {
            m7374a.m7209d(m7174c.m7163b());
        } else if (i2 == 2) {
            m7374a.m7207b(m7174c.m7163b());
        } else if (i2 == 3) {
            m7374a.m7210e(m7174c.m7163b());
        }
        return m7374a;
    }

    /* renamed from: a */
    protected static C2459y0 m7192a(String str, String str2, String str3) {
        C2459y0 m7375a = C2451u0.m7375a(str, str2, str3);
        Pair<String, String> m7176e = C2421j.m7169a().m7176e(str2, str);
        m7375a.m7418f((String) m7176e.first);
        m7375a.m7419g((String) m7176e.second);
        m7375a.m7420h(AbstractC2436o.m7262b());
        m7375a.m7369d(C2421j.m7169a().m7175d(str2, str));
        return m7375a;
    }

    /* renamed from: b */
    public static Map<String, String> m7193b(String str, String str2, String str3) {
        Map<String, String> m7377c = C2451u0.m7377c(str, str3);
        Map<String, String> m7027i = AbstractC2396a1.m7027i(str, str2);
        if (m7027i == null) {
            return m7377c;
        }
        m7377c.putAll(m7027i);
        return m7377c;
    }
}
