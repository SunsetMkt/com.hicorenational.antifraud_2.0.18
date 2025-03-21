package com.tencent.open.p211a;

import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3288f;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3291i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.f */
/* loaded from: classes2.dex */
public class C3255f {

    /* renamed from: a */
    private static C3255f f11154a;

    /* renamed from: b */
    private C3291i f11155b;

    /* renamed from: c */
    private InterfaceC3250a f11156c;

    protected C3255f() {
        m10417b();
    }

    /* renamed from: a */
    public static C3255f m10416a() {
        if (f11154a == null) {
            synchronized (C3255f.class) {
                if (f11154a == null) {
                    f11154a = new C3255f();
                }
            }
        }
        f11154a.m10418c();
        return f11154a;
    }

    /* renamed from: b */
    private void m10417b() {
        String str = "AndroidSDK_" + Build.VERSION.SDK + AbstractC1191a.f2606s1 + C3288f.m10596a().m10600b(C3289g.m10603a()) + AbstractC1191a.f2606s1 + Build.VERSION.RELEASE;
        try {
            this.f11156c = new C3254e(str);
        } catch (NoClassDefFoundError e2) {
            SLog.m10501e("openSDK_LOG.OpenHttpService", "initClient okHttp catch error", e2);
        } catch (Throwable th) {
            SLog.m10501e("openSDK_LOG.OpenHttpService", "initClient okHttp catch throwable", th);
        }
        if (this.f11156c == null) {
            this.f11156c = new C3251b(str);
        }
    }

    /* renamed from: c */
    private void m10418c() {
        C3291i c3291i = this.f11155b;
        if (c3291i == null) {
            return;
        }
        int m10624a = c3291i.m10624a("Common_HttpConnectionTimeout");
        if (m10624a == 0) {
            m10624a = 15000;
        }
        int m10624a2 = this.f11155b.m10624a("Common_SocketConnectionTimeout");
        if (m10624a2 == 0) {
            m10624a2 = BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH;
        }
        m10422a(m10624a, m10624a2);
    }

    /* renamed from: a */
    public void m10423a(C3291i c3291i) {
        this.f11155b = c3291i;
        m10418c();
    }

    /* renamed from: b */
    public InterfaceC3256g m10424b(String str, Map<String, String> map) throws IOException {
        SLog.m10502i("openSDK_LOG.OpenHttpService", "post data");
        return this.f11156c.mo10401a(str, map);
    }

    /* renamed from: a */
    public void m10422a(long j2, long j3) {
        InterfaceC3250a interfaceC3250a = this.f11156c;
        if (interfaceC3250a != null) {
            interfaceC3250a.mo10403a(j2, j3);
        }
    }

    /* renamed from: a */
    public InterfaceC3256g m10420a(String str, Map<String, String> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder("");
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                    sb.append("&");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return m10419a(str, sb.toString());
        }
        return m10419a(str, "");
    }

    /* renamed from: a */
    public InterfaceC3256g m10419a(String str, String str2) throws IOException {
        SLog.m10502i("openSDK_LOG.OpenHttpService", "get.");
        return this.f11156c.mo10400a(str, str2);
    }

    /* renamed from: a */
    public InterfaceC3256g m10421a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            return this.f11156c.mo10402a(str, map, map2);
        }
        return m10424b(str, map);
    }
}
