package com.huawei.hms.framework.network.grs.p175g.p176i;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2381d;
import com.huawei.hms.framework.network.grs.p178h.C2384c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.i.a */
/* loaded from: classes.dex */
public class C2377a {

    /* renamed from: a */
    private static final String f7428a = "a";

    /* renamed from: b */
    private static C2381d f7429b;

    /* renamed from: c */
    private static final Object f7430c = new Object();

    /* renamed from: a */
    public static synchronized C2381d m6956a(Context context) {
        synchronized (C2377a.class) {
            synchronized (f7430c) {
                if (f7429b != null) {
                    return f7429b;
                }
                String m6980a = C2384c.m6980a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
                ArrayList arrayList = null;
                if (TextUtils.isEmpty(m6980a)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(m6980a).getJSONObject("grs_server");
                    JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(jSONArray.get(i2).toString());
                        }
                    }
                    f7429b = new C2381d();
                    f7429b.m6969a(arrayList);
                    f7429b.m6968a(jSONObject.getString("grs_query_endpoint_2.0"));
                    f7429b.m6967a(jSONObject.getInt("grs_query_timeout"));
                } catch (JSONException e2) {
                    Logger.m6805w(f7428a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
                }
                return f7429b;
            }
        }
    }
}
