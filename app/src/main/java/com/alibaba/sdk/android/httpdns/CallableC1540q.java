package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* renamed from: com.alibaba.sdk.android.httpdns.q */
/* loaded from: classes.dex */
class CallableC1540q implements Callable<String[]> {

    /* renamed from: a */
    private static Context f3988a;

    /* renamed from: a */
    private EnumC1541s f3990a;

    /* renamed from: d */
    private int f3991d;

    /* renamed from: d */
    private long f3992d;

    /* renamed from: e */
    private String[] f3993e;
    private Map<String, String> extra;
    private String hostName;

    /* renamed from: j */
    private boolean f3994j;

    /* renamed from: k */
    private String f3995k;

    /* renamed from: l */
    private String f3996l;
    private static C1513d hostManager = C1513d.m3470a();

    /* renamed from: a */
    private static final Object f3989a = new Object();

    CallableC1540q(String str, EnumC1541s enumC1541s) {
        this.f3991d = 1;
        this.f3995k = null;
        this.f3993e = C1519f.f3925c;
        this.f3994j = false;
        this.f3996l = null;
        this.extra = new HashMap();
        this.f3992d = 0L;
        this.hostName = str;
        this.f3990a = enumC1541s;
    }

    CallableC1540q(String str, EnumC1541s enumC1541s, Map<String, String> map, String str2) {
        this.f3991d = 1;
        this.f3995k = null;
        this.f3993e = C1519f.f3925c;
        this.f3994j = false;
        this.f3996l = null;
        this.extra = new HashMap();
        this.f3992d = 0L;
        this.hostName = str;
        this.f3990a = enumC1541s;
        this.f3996l = str2;
        this.extra.putAll(map);
    }

    /* renamed from: d */
    private boolean m3576d(String str) {
        return str.matches("[a-zA-Z0-9\\-_]+");
    }

    /* renamed from: e */
    private boolean m3577e(String str) {
        return str.matches("[a-zA-Z0-9\\-_=]+");
    }

    private String getExtra() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.extra;
        boolean z2 = true;
        if (map != null) {
            z = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("&sdns-");
                sb.append(entry.getKey());
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                if (!m3576d(entry.getKey())) {
                    C1522i.m3527f("设置自定义参数失败，自定义key不合法：" + entry.getKey());
                    z2 = false;
                }
                if (!m3577e(entry.getValue())) {
                    C1522i.m3527f("设置自定义参数失败，自定义value不合法：" + entry.getValue());
                    z = false;
                }
            }
        } else {
            z = true;
        }
        if (z2 && z) {
            String sb2 = sb.toString();
            if (sb2.getBytes("UTF-8").length <= 1000) {
                return sb2;
            }
            C1522i.m3527f("设置自定义参数失败，自定义参数过长");
        }
        return "";
    }

    static void setContext(Context context) {
        f3988a = context;
    }

    /* renamed from: a */
    public void m3578a(int i2) {
        if (i2 >= 0) {
            this.f3991d = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03c5 A[Catch: all -> 0x03f4, TryCatch #2 {all -> 0x03f4, blocks: (B:77:0x03b7, B:79:0x03c5, B:86:0x03ce), top: B:76:0x03b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03db A[Catch: IOException -> 0x03df, TRY_ENTER, TryCatch #5 {IOException -> 0x03df, blocks: (B:30:0x0392, B:32:0x0397, B:83:0x03db, B:85:0x03e3), top: B:19:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03e3 A[Catch: IOException -> 0x03df, TRY_LEAVE, TryCatch #5 {IOException -> 0x03df, blocks: (B:30:0x0392, B:32:0x0397, B:83:0x03db, B:85:0x03e3), top: B:19:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03ce A[Catch: all -> 0x03f4, TRY_LEAVE, TryCatch #2 {all -> 0x03f4, blocks: (B:77:0x03b7, B:79:0x03c5, B:86:0x03ce), top: B:76:0x03b7 }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] call() {
        /*
            Method dump skipped, instructions count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.CallableC1540q.call():java.lang.String[]");
    }
}
