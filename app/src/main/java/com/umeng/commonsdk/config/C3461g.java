package com.umeng.commonsdk.config;

import com.umeng.commonsdk.debug.UMRTLog;
import org.android.agoo.common.Config;

/* compiled from: SensitiveFieldHandler.java */
/* renamed from: com.umeng.commonsdk.config.g */
/* loaded from: classes2.dex */
public class C3461g implements InterfaceC3459e {
    @Override // com.umeng.commonsdk.config.InterfaceC3459e
    /* renamed from: a */
    public void mo11545a(String str, Object obj, String[] strArr) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong == -1) {
                UMRTLog.m11555e(Config.TAG, "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.");
                return;
            }
            UMRTLog.m11556i(Config.TAG, "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
            if (obj == null || !(obj instanceof C3456b)) {
                return;
            }
            try {
                Boolean.valueOf(true);
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String str2 = strArr[i2];
                    if (C3458d.m11546a(str2)) {
                        ((C3456b) obj).mo11543a(str2, Boolean.valueOf(C3455a.m11535a(parseLong, i2)));
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            UMRTLog.m11555e(Config.TAG, "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.");
        }
    }
}
