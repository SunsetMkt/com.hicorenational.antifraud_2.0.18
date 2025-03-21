package com.huawei.hms.framework.network.grs.p174f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p173e.C2361a;
import com.huawei.hms.framework.network.grs.p175g.C2370b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.framework.network.grs.f.e */
/* loaded from: classes.dex */
public class C2368e {

    /* renamed from: a */
    private static final String f7370a = "e";

    /* renamed from: b */
    public static final Set<String> f7371b = Collections.unmodifiableSet(new a(16));

    /* renamed from: com.huawei.hms.framework.network.grs.f.e$a */
    class a extends HashSet<String> {
        a(int i2) {
            super(i2);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    /* renamed from: a */
    private static String m6889a(Context context, C2361a c2361a, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        String str2;
        StringBuilder sb;
        String str3;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str4 : str.split(">")) {
            if (f7371b.contains(str4.trim())) {
                if (!"ser_country".equals(str4.trim()) || TextUtils.isEmpty(serCountry) || "UNKNOWN".equals(serCountry)) {
                    if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !"UNKNOWN".equals(regCountry)) {
                        Logger.m6799i(f7370a, "current route_by is regCountry and routerCountry is: " + regCountry);
                        return regCountry;
                    }
                    if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !"UNKNOWN".equals(issueCountry)) {
                        Logger.m6799i(f7370a, "current route_by is issueCountry and routerCountry is: " + issueCountry);
                        return issueCountry;
                    }
                    if ("geo_ip".equals(str4.trim())) {
                        serCountry = new C2370b(context, c2361a, grsBaseInfo).m6898a(z);
                        str2 = f7370a;
                        sb = new StringBuilder();
                        str3 = "current route_by is geo_ip and routerCountry is: ";
                    }
                } else {
                    str2 = f7370a;
                    sb = new StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is: ";
                }
                sb.append(str3);
                sb.append(serCountry);
                Logger.m6799i(str2, sb.toString());
                return serCountry;
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m6890b(Context context, C2361a c2361a, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Logger.m6803w(f7370a, "routeBy must be not empty string or null.");
            return null;
        }
        if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return m6889a(context, c2361a, str, grsBaseInfo, z);
        }
        Logger.m6801v(f7370a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    }
}
