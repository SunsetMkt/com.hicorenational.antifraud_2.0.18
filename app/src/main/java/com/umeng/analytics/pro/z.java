package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: Action.java */
/* JADX INFO: loaded from: classes2.dex */
public class z implements ag {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<aa> f7403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7404c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7405d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7406e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7407f = "";

    public z(String str, ArrayList<aa> arrayList) {
        this.a = null;
        this.f7403b = new ArrayList<>();
        this.a = str;
        this.f7403b = arrayList;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.f7404c;
    }

    public String c() {
        return this.f7405d;
    }

    private String c(String str) {
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (strArrSplit.length <= 0) {
            return "";
        }
        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.a);
        if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
            this.f7407f = forbidSdkArray.toString();
            for (String str2 : strArrSplit) {
                if (CcgAgent.getActionInfo(str2) != null && !forbidSdkArray.contains(str2)) {
                    return str2;
                }
            }
            return "";
        }
        String str3 = "";
        for (String str4 : strArrSplit) {
            ActionInfo actionInfo = CcgAgent.getActionInfo(str4);
            if (actionInfo != null) {
                String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                if (supportAction.length > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= supportAction.length) {
                            break;
                        }
                        if (this.a.equals(supportAction[i2])) {
                            str3 = str4;
                            break;
                        }
                        i2++;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return str3;
    }

    public void a(String str) {
        this.f7404c = str;
    }

    public void b(String str) {
        this.f7405d = str;
    }

    @Override // com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.f7403b.size();
            if (size == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f7403b.get(i2).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f7405d)) {
                this.f7406e = c(this.f7405d);
                if (TextUtils.isEmpty(this.f7406e)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "\u91c7\u96c6\u9879\uff1a" + this.a + "; \u672a\u9009\u4e2d\u53ef\u7528Module ; sdk: " + this.f7405d);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "\u91c7\u96c6\u9879\uff1a" + this.a + "; \u9009\u4e2dModule: " + this.f7406e + "; sdk: " + this.f7405d);
                }
            }
            aa aaVar = this.f7403b.get(size - 1);
            if (aaVar == null || !(aaVar instanceof ac)) {
                return null;
            }
            long jC = aaVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.a);
                jSONObject2.put(com.umeng.ccg.a.r, this.f7405d);
                jSONObject2.put(com.umeng.ccg.a.o, this.f7404c);
                jSONObject2.put("delay", jC);
                jSONObject2.put(com.umeng.ccg.a.p, this.f7406e);
                jSONObject2.put(com.umeng.ccg.a.q, this.f7407f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
