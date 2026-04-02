package com.tencent.open.a;

import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static f a;

    /* JADX INFO: renamed from: b */
    private i f6809b;

    /* JADX INFO: renamed from: c */
    private a f6810c;

    protected f() {
        b();
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        a.c();
        return a;
    }

    private void b() {
        String str = "AndroidSDK_" + Build.VERSION.SDK + d.c.a.b.a.a.s1 + com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()) + d.c.a.b.a.a.s1 + Build.VERSION.RELEASE;
        try {
            this.f6810c = new e(str);
        } catch (NoClassDefFoundError e2) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch error", e2);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch throwable", th);
        }
        if (this.f6810c == null) {
            this.f6810c = new b(str);
        }
    }

    private void c() {
        i iVar = this.f6809b;
        if (iVar == null) {
            return;
        }
        int iA = iVar.a("Common_HttpConnectionTimeout");
        if (iA == 0) {
            iA = 15000;
        }
        int iA2 = this.f6809b.a("Common_SocketConnectionTimeout");
        if (iA2 == 0) {
            iA2 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        }
        a(iA, iA2);
    }

    public void a(i iVar) {
        this.f6809b = iVar;
        c();
    }

    public g b(String str, Map<String, String> map) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        return this.f6810c.a(str, map);
    }

    public void a(long j2, long j3) {
        a aVar = this.f6810c;
        if (aVar != null) {
            aVar.a(j2, j3);
        }
    }

    public g a(String str, Map<String, String> map) throws IOException {
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
            return a(str, sb.toString());
        }
        return a(str, "");
    }

    public g a(String str, String str2) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        return this.f6810c.a(str, str2);
    }

    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            return this.f6810c.a(str, map, map2);
        }
        return b(str, map);
    }
}
