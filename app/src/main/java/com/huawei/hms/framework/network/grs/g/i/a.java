package com.huawei.hms.framework.network.grs.g.i;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.j.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f4675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f4676c = new Object();

    public static synchronized d a(Context context) {
        synchronized (f4676c) {
            if (f4675b != null) {
                return f4675b;
            }
            String strA = c.a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(strA).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(jSONArray.get(i2).toString());
                    }
                }
                f4675b = new d();
                f4675b.a(arrayList);
                f4675b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                f4675b.a(jSONObject.getInt("grs_query_timeout"));
            } catch (JSONException e2) {
                Logger.w(a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            }
            return f4675b;
        }
    }
}
