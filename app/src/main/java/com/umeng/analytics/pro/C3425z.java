package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.C3438a;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: Action.java */
/* renamed from: com.umeng.analytics.pro.z */
/* loaded from: classes2.dex */
public class C3425z implements InterfaceC3323ag {

    /* renamed from: a */
    private String f12277a;

    /* renamed from: b */
    private ArrayList<InterfaceC3317aa> f12278b;

    /* renamed from: c */
    private String f12279c = "";

    /* renamed from: d */
    private String f12280d = "";

    /* renamed from: e */
    private String f12281e = "";

    /* renamed from: f */
    private String f12282f = "";

    public C3425z(String str, ArrayList<InterfaceC3317aa> arrayList) {
        this.f12277a = null;
        this.f12278b = new ArrayList<>();
        this.f12277a = str;
        this.f12278b = arrayList;
    }

    /* renamed from: a */
    public String m11437a() {
        return this.f12277a;
    }

    /* renamed from: b */
    public String m11439b() {
        return this.f12279c;
    }

    /* renamed from: c */
    public String m11441c() {
        return this.f12280d;
    }

    /* renamed from: c */
    private String m11436c(String str) {
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length <= 0) {
            return "";
        }
        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f12277a);
        if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
            this.f12282f = forbidSdkArray.toString();
            for (String str2 : split) {
                if (CcgAgent.getActionInfo(str2) != null && !forbidSdkArray.contains(str2)) {
                    return str2;
                }
            }
            return "";
        }
        String str3 = "";
        for (String str4 : split) {
            ActionInfo actionInfo = CcgAgent.getActionInfo(str4);
            if (actionInfo != null) {
                String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                if (supportAction.length > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= supportAction.length) {
                            break;
                        }
                        if (this.f12277a.equals(supportAction[i2])) {
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

    /* renamed from: a */
    public void m11438a(String str) {
        this.f12279c = str;
    }

    /* renamed from: b */
    public void m11440b(String str) {
        this.f12280d = str;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3323ag
    /* renamed from: a */
    public JSONObject mo10812a(String str, JSONObject jSONObject) {
        try {
            int size = this.f12278b.size();
            if (size == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f12278b.get(i2).mo10810b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f12280d)) {
                this.f12281e = m11436c(this.f12280d);
                if (TextUtils.isEmpty(this.f12281e)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "采集项：" + this.f12277a + "; 未选中可用Module ; sdk: " + this.f12280d);
                } else {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "采集项：" + this.f12277a + "; 选中Module: " + this.f12281e + "; sdk: " + this.f12280d);
                }
            }
            InterfaceC3317aa interfaceC3317aa = this.f12278b.get(size - 1);
            if (interfaceC3317aa == null || !(interfaceC3317aa instanceof C3319ac)) {
                return null;
            }
            long mo10811c = interfaceC3317aa.mo10811c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f12277a);
                jSONObject2.put(C3438a.f12345r, this.f12280d);
                jSONObject2.put(C3438a.f12342o, this.f12279c);
                jSONObject2.put("delay", mo10811c);
                jSONObject2.put(C3438a.f12343p, this.f12281e);
                jSONObject2.put(C3438a.f12344q, this.f12282f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
