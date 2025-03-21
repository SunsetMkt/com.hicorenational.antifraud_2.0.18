package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.j */
/* loaded from: classes.dex */
public class C2421j {

    /* renamed from: b */
    private static C2421j f7538b;

    /* renamed from: a */
    private Context f7539a;

    /* renamed from: com.huawei.hms.hatool.j$a */
    private static class a extends AbstractC2407e0 {

        /* renamed from: a */
        String f7540a;

        /* renamed from: b */
        String f7541b;

        public a(String str, String str2) {
            this.f7540a = str;
            this.f7541b = str2;
        }

        @Override // com.huawei.hms.hatool.AbstractC2407e0
        /* renamed from: a */
        public String mo7091a() {
            return AbstractC2460z.m7424d(this.f7540a, this.f7541b);
        }

        @Override // com.huawei.hms.hatool.AbstractC2407e0
        /* renamed from: a */
        public String mo7092a(String str) {
            return SHA.sha256Encrypt(str);
        }

        @Override // com.huawei.hms.hatool.AbstractC2407e0
        /* renamed from: b */
        public String mo7093b() {
            return AbstractC2460z.m7427g(this.f7540a, this.f7541b);
        }

        @Override // com.huawei.hms.hatool.AbstractC2407e0
        /* renamed from: c */
        public String mo7094c() {
            return AbstractC2460z.m7430j(this.f7540a, this.f7541b);
        }

        @Override // com.huawei.hms.hatool.AbstractC2407e0
        /* renamed from: d */
        public int mo7095d() {
            return (AbstractC2460z.m7431k(this.f7540a, this.f7541b) ? 4 : 0) | 0 | (AbstractC2460z.m7425e(this.f7540a, this.f7541b) ? 2 : 0) | (AbstractC2460z.m7428h(this.f7540a, this.f7541b) ? 1 : 0);
        }
    }

    /* renamed from: a */
    public static C2421j m7169a() {
        C2421j c2421j;
        synchronized (C2421j.class) {
            if (f7538b == null) {
                f7538b = new C2421j();
            }
            c2421j = f7538b;
        }
        return c2421j;
    }

    /* renamed from: a */
    public String m7170a(String str, String str2) {
        return AbstractC2419i0.m7164a(this.f7539a, str, str2);
    }

    /* renamed from: a */
    public String m7171a(boolean z) {
        if (!z) {
            return "";
        }
        String m7303e = AbstractC2443q0.m7303e();
        if (TextUtils.isEmpty(m7303e)) {
            m7303e = C2403d.m7069a(this.f7539a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(m7303e)) {
                m7303e = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                C2403d.m7074b(this.f7539a, "global_v2", "uuid", m7303e);
            }
            AbstractC2443q0.m7310h(m7303e);
        }
        return m7303e;
    }

    /* renamed from: a */
    public void m7172a(Context context) {
        if (this.f7539a == null) {
            this.f7539a = context;
        }
    }

    /* renamed from: b */
    public String m7173b(String str, String str2) {
        return AbstractC2419i0.m7165b(this.f7539a, str, str2);
    }

    /* renamed from: c */
    public C2418i m7174c(String str, String str2) {
        return new a(str, str2).m7090a(this.f7539a);
    }

    /* renamed from: d */
    public String m7175d(String str, String str2) {
        return AbstractC2411f1.m7106b(str, str2);
    }

    /* renamed from: e */
    public Pair<String, String> m7176e(String str, String str2) {
        if (!AbstractC2460z.m7426f(str, str2)) {
            return new Pair<>("", "");
        }
        String m7146p = C2446s.m7326c().m7331b().m7146p();
        String m7148q = C2446s.m7326c().m7331b().m7148q();
        if (!TextUtils.isEmpty(m7146p) && !TextUtils.isEmpty(m7148q)) {
            return new Pair<>(m7146p, m7148q);
        }
        Pair<String, String> m7413e = C2457x0.m7413e(this.f7539a);
        C2446s.m7326c().m7331b().m7137k((String) m7413e.first);
        C2446s.m7326c().m7331b().m7139l((String) m7413e.second);
        return m7413e;
    }

    /* renamed from: f */
    public String m7177f(String str, String str2) {
        return AbstractC2411f1.m7105a(str, str2);
    }
}
