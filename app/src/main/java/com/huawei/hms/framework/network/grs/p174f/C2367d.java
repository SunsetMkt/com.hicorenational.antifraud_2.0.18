package com.huawei.hms.framework.network.grs.p174f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.C2389a;
import com.huawei.hms.framework.network.grs.local.model.C2390b;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.d */
/* loaded from: classes.dex */
public class C2367d extends AbstractC2364a {
    public C2367d(Context context, String str, boolean z) {
        this.f7365d = z;
        if (m6866a(TextUtils.isEmpty(str) ? "grs_app_global_route_config.json" : str, context) == 0) {
            this.f7364c = true;
        }
    }

    public C2367d(boolean z, boolean z2) {
        this.f7365d = z2;
        this.f7364c = z;
    }

    @Override // com.huawei.hms.framework.network.grs.p174f.AbstractC2364a
    /* renamed from: b */
    public int mo6873b(String str) {
        this.f7362a = new C2389a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.f7362a.m6994b(jSONObject.getString(CommonNetImpl.NAME));
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            if (jSONArray != null && jSONArray.length() != 0) {
                if (jSONObject.has("customservices")) {
                    m6875b(jSONObject.getJSONArray("customservices"));
                }
                return 0;
            }
            return -1;
        } catch (JSONException e2) {
            Logger.m6805w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p174f.AbstractC2364a
    /* renamed from: c */
    public int mo6876c(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        this.f7363b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.m6796e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            if (jSONArray.length() != 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    C2390b c2390b = new C2390b();
                    c2390b.m6999b(jSONObject2.getString("id"));
                    c2390b.m7000c(jSONObject2.getString(CommonNetImpl.NAME));
                    c2390b.m6996a(jSONObject2.getString("description"));
                    if (jSONObject2.has("countriesOrAreas")) {
                        jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                    } else if (jSONObject2.has("countries")) {
                        jSONArray2 = jSONObject2.getJSONArray("countries");
                    } else {
                        Logger.m6803w("LocalManagerV2", "current country or area group has not config countries or areas.");
                        jSONArray2 = null;
                    }
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray2 != null && jSONArray2.length() != 0) {
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            hashSet.add((String) jSONArray2.get(i3));
                        }
                        c2390b.m6997a(hashSet);
                        this.f7363b.add(c2390b);
                    }
                    return -1;
                }
            }
            return 0;
        } catch (JSONException e2) {
            Logger.m6805w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p174f.AbstractC2364a
    /* renamed from: f */
    public int mo6880f(String str) {
        return m6879e(str);
    }
}
