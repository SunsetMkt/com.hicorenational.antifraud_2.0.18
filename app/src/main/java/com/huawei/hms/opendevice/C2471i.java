package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* compiled from: PushClientSp.java */
/* renamed from: com.huawei.hms.opendevice.i */
/* loaded from: classes.dex */
public class C2471i extends PushPreferences {

    /* renamed from: c */
    private static final String f7665c = "i";

    /* renamed from: b */
    private Context f7666b;

    private C2471i(Context context) {
        super(context, "push_client_self_info");
        this.f7666b = context;
    }

    /* renamed from: a */
    public static C2471i m7469a(Context context) {
        return new C2471i(context);
    }

    /* renamed from: b */
    public String m7473b(String str) {
        try {
            return TextUtils.isEmpty(str) ? m7470a("token_info_v2") : m7470a(str);
        } catch (Exception e2) {
            HMSLog.m7715e(f7665c, "getSecureData" + e2.getMessage());
            return "";
        }
    }

    /* renamed from: c */
    public boolean m7475c(String str) {
        try {
            return TextUtils.isEmpty(str) ? removeKey("token_info_v2") : removeKey(str);
        } catch (Exception e2) {
            HMSLog.m7715e(f7665c, "removeToken" + e2.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public String m7470a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return PushEncrypter.decrypter(this.f7666b, getString(str));
        } catch (Exception e2) {
            HMSLog.m7715e(f7665c, "getSecureData" + e2.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public boolean m7472a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveString(str, PushEncrypter.encrypter(this.f7666b, str2));
        } catch (Exception e2) {
            HMSLog.m7715e(f7665c, "saveSecureData" + e2.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public boolean m7474b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return m7472a("token_info_v2", str2);
            }
            return m7472a(str, str2);
        } catch (Exception e2) {
            HMSLog.m7715e(f7665c, "saveSecureData" + e2.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public void m7471a() {
        Map<String, ?> all = getAll();
        if (all.isEmpty() || all.keySet().isEmpty()) {
            return;
        }
        for (String str : all.keySet()) {
            if (!"push_kit_auto_init_enabled".equals(str) && !"_proxy_init".equals(str)) {
                removeKey(str);
            }
        }
    }
}
