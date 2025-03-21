package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.C3414o;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* renamed from: a */
    private static Context f11355a;

    /* renamed from: com.umeng.analytics.CoreProtocol$a */
    private static class C3304a {

        /* renamed from: a */
        private static final CoreProtocol f11356a = new CoreProtocol();

        private C3304a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (f11355a == null && context != null) {
            f11355a = context.getApplicationContext();
        }
        return C3304a.f11356a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        C3414o.m11300a(f11355a).m11333a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        C3414o.m11300a(f11355a).m11340b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        C3414o.m11300a(f11355a).m11334a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return C3414o.m11300a(f11355a).m11332a(j2);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) {
        C3414o.m11300a(f11355a).m11335a(obj, i2);
    }

    private CoreProtocol() {
    }
}
