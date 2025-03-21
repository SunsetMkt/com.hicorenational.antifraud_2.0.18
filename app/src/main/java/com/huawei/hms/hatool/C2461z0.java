package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import bean.SurveyH5Bean;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.hms.hatool.z0 */
/* loaded from: classes.dex */
public class C2461z0 {

    /* renamed from: a */
    private String f7649a;

    /* renamed from: b */
    public C2429l1 f7650b;

    public C2461z0(String str) {
        this.f7649a = str;
        this.f7650b = new C2429l1(str);
        C2446s.m7326c().m7330a(this.f7649a, this.f7650b);
    }

    /* renamed from: b */
    private C2447s0 m7432b(int i2) {
        if (i2 == 0) {
            return this.f7650b.m7224c();
        }
        if (i2 == 1) {
            return this.f7650b.m7222b();
        }
        if (i2 == 2) {
            return this.f7650b.m7225d();
        }
        if (i2 != 3) {
            return null;
        }
        return this.f7650b.m7219a();
    }

    /* renamed from: c */
    private boolean m7433c(int i2) {
        String str;
        if (i2 != 2) {
            C2447s0 m7432b = m7432b(i2);
            if (m7432b != null && !TextUtils.isEmpty(m7432b.m7355h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i2;
        } else {
            if ("_default_config_tag".equals(this.f7649a)) {
                return true;
            }
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        C2452v.m7389e("hmsSdk", str);
        return false;
    }

    /* renamed from: a */
    public void m7434a(int i2) {
        C2452v.m7387d("hmsSdk", "onReport. TAG: " + this.f7649a + ", TYPE: " + i2);
        C2413g0.m7107a().m7111a(this.f7649a, i2);
    }

    /* renamed from: a */
    public void m7435a(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        C2452v.m7387d("hmsSdk", "onEvent. TAG: " + this.f7649a + ", TYPE: " + i2 + ", eventId : " + str);
        if (C2408e1.m7097a(str) || !m7433c(i2)) {
            C2452v.m7389e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f7649a + ", TYPE: " + i2);
            return;
        }
        if (!C2408e1.m7100a(linkedHashMap)) {
            C2452v.m7389e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f7649a + ", TYPE: " + i2);
            linkedHashMap = null;
        }
        C2413g0.m7107a().m7112a(this.f7649a, i2, str, linkedHashMap);
    }

    /* renamed from: a */
    public void m7436a(Context context, String str, String str2) {
        C2452v.m7387d("hmsSdk", "onEvent(context). TAG: " + this.f7649a + ", eventId : " + str);
        if (context == null) {
            C2452v.m7389e("hmsSdk", "context is null in onevent ");
            return;
        }
        if (C2408e1.m7097a(str) || !m7433c(0)) {
            C2452v.m7389e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f7649a);
            return;
        }
        if (!C2408e1.m7098a(SurveyH5Bean.VALUE, str2, 65536)) {
            C2452v.m7389e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f7649a);
            str2 = "";
        }
        C2413g0.m7107a().m7113a(this.f7649a, context, str, str2);
    }

    /* renamed from: a */
    public void m7437a(C2447s0 c2447s0) {
        C2452v.m7385c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f7649a);
        if (c2447s0 != null) {
            this.f7650b.m7221a(c2447s0);
        } else {
            C2452v.m7389e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f7650b.m7221a((C2447s0) null);
        }
    }

    /* renamed from: b */
    public void m7438b(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        C2452v.m7387d("hmsSdk", "onStreamEvent. TAG: " + this.f7649a + ", TYPE: " + i2 + ", eventId : " + str);
        if (C2408e1.m7097a(str) || !m7433c(i2)) {
            C2452v.m7389e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f7649a + ", TYPE: " + i2);
            return;
        }
        if (!C2408e1.m7100a(linkedHashMap)) {
            C2452v.m7389e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f7649a + ", TYPE: " + i2);
            linkedHashMap = null;
        }
        C2413g0.m7107a().m7114b(this.f7649a, i2, str, linkedHashMap);
    }

    /* renamed from: b */
    public void m7439b(C2447s0 c2447s0) {
        C2452v.m7385c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f7649a);
        if (c2447s0 != null) {
            this.f7650b.m7223b(c2447s0);
        } else {
            this.f7650b.m7223b(null);
            C2452v.m7389e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }
}
