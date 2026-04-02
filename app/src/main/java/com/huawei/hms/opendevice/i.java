package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* JADX INFO: compiled from: PushClientSp.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends PushPreferences {

    /* JADX INFO: renamed from: c */
    private static final String f4836c = "i";

    /* JADX INFO: renamed from: b */
    private Context f4837b;

    private i(Context context) {
        super(context, "push_client_self_info");
        this.f4837b = context;
    }

    public static i a(Context context) {
        return new i(context);
    }

    public String b(String str) {
        try {
            return TextUtils.isEmpty(str) ? a("token_info_v2") : a(str);
        } catch (Exception e2) {
            HMSLog.e(f4836c, "getSecureData" + e2.getMessage());
            return "";
        }
    }

    public boolean c(String str) {
        try {
            return TextUtils.isEmpty(str) ? removeKey("token_info_v2") : removeKey(str);
        } catch (Exception e2) {
            HMSLog.e(f4836c, "removeToken" + e2.getMessage());
            return false;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return PushEncrypter.decrypter(this.f4837b, getString(str));
        } catch (Exception e2) {
            HMSLog.e(f4836c, "getSecureData" + e2.getMessage());
            return "";
        }
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveString(str, PushEncrypter.encrypter(this.f4837b, str2));
        } catch (Exception e2) {
            HMSLog.e(f4836c, "saveSecureData" + e2.getMessage());
            return false;
        }
    }

    public boolean b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return a("token_info_v2", str2);
            }
            return a(str, str2);
        } catch (Exception e2) {
            HMSLog.e(f4836c, "saveSecureData" + e2.getMessage());
            return false;
        }
    }

    public void a() {
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
