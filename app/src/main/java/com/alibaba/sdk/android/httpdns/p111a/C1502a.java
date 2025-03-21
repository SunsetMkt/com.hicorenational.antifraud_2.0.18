package com.alibaba.sdk.android.httpdns.p111a;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.beacon.Beacon;
import com.alibaba.sdk.android.httpdns.C1503b;
import com.alibaba.sdk.android.httpdns.C1522i;
import com.alibaba.sdk.android.httpdns.p114d.C1515b;
import com.heytap.mcssdk.constant.C2084a;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.alibaba.sdk.android.httpdns.a.a */
/* loaded from: classes.dex */
public class C1502a {

    /* renamed from: a */
    private static volatile C1502a f3838a;
    private Context mContext = null;

    /* renamed from: a */
    private C1515b f3842a = null;

    /* renamed from: a */
    private Beacon f3841a = null;

    /* renamed from: m */
    private boolean f3843m = true;

    /* renamed from: a */
    private final Beacon.OnUpdateListener f3840a = new Beacon.OnUpdateListener() { // from class: com.alibaba.sdk.android.httpdns.a.a.1
        @Override // com.alibaba.sdk.android.beacon.Beacon.OnUpdateListener
        public void onUpdate(List<Beacon.Config> list) {
            try {
                C1502a.this.m3419b(list);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* renamed from: a */
    private final Beacon.OnServiceErrListener f3839a = new Beacon.OnServiceErrListener() { // from class: com.alibaba.sdk.android.httpdns.a.a.2
        @Override // com.alibaba.sdk.android.beacon.Beacon.OnServiceErrListener
        public void onErr(Beacon.Error error) {
            String str = "beacon error. errorCode:" + error.errCode + ", errorMsg:" + error.errMsg;
        }
    };

    private C1502a() {
    }

    /* renamed from: a */
    public static C1502a m3416a() {
        if (f3838a == null) {
            synchronized (C1502a.class) {
                if (f3838a == null) {
                    f3838a = new C1502a();
                }
            }
        }
        return f3838a;
    }

    /* renamed from: a */
    private boolean m3418a(Beacon.Config config) {
        if (config == null || !config.key.equalsIgnoreCase("___httpdns_service___")) {
            return false;
        }
        String str = config.value;
        if (str != null) {
            String str2 = "httpdns configs:" + str;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ut")) {
                    m3420f(jSONObject.getString("ut"));
                }
                if (jSONObject.has("ip-ranking")) {
                    m3421i(jSONObject.getString("ip-ranking"));
                }
                if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                    m3422j(jSONObject.getString(NotificationCompat.CATEGORY_STATUS));
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3419b(List<Beacon.Config> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Beacon.Config config : list) {
            if (config.key.equalsIgnoreCase("___httpdns_service___")) {
                m3418a(config);
            }
        }
    }

    /* renamed from: f */
    private boolean m3420f(String str) {
        if (str == null || this.f3842a == null) {
            return false;
        }
        String str2 = "is report enabled:" + str;
        if (str.equalsIgnoreCase("disabled")) {
            this.f3842a.m3502e(false);
        } else {
            this.f3842a.m3502e(true);
        }
        return true;
    }

    /* renamed from: i */
    private void m3421i(String str) {
        if (str != null) {
            String str2 = "is IP probe enabled:" + str;
            this.f3843m = !str.equalsIgnoreCase("disabled");
        }
    }

    /* renamed from: j */
    private void m3422j(String str) {
        if (str != null) {
            C1503b.m3427a(!"disabled".equals(str));
            C1522i.m3526e("[beacon] httpdns enable: " + C1503b.m3428a());
        }
    }

    /* renamed from: a */
    public void m3423a(C1515b c1515b) {
        this.f3842a = c1515b;
    }

    /* renamed from: c */
    public void m3424c(Context context, String str) {
        this.mContext = context;
        if (this.mContext != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdkId", "httpdns");
            hashMap.put("accountId", str);
            this.f3841a = new Beacon.Builder().appKey("24657847").appSecret("f30fc0937f2b1e9e50a1b7134f1ddb10").loopInterval(C2084a.f6132n).extras(hashMap).build();
            this.f3841a.addUpdateListener(this.f3840a);
            this.f3841a.addServiceErrListener(this.f3839a);
            this.f3841a.start(this.mContext.getApplicationContext());
        }
    }

    /* renamed from: f */
    public boolean m3425f() {
        return this.f3843m;
    }
}
