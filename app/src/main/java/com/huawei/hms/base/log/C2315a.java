package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* compiled from: ExtLogNode.java */
/* renamed from: com.huawei.hms.base.log.a */
/* loaded from: classes.dex */
public class C2315a implements InterfaceC2318d {

    /* renamed from: a */
    private final HMSExtLogger f7174a;

    /* renamed from: b */
    private InterfaceC2318d f7175b;

    public C2315a(HMSExtLogger hMSExtLogger) {
        this.f7174a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.InterfaceC2318d
    /* renamed from: a */
    public void mo6661a(Context context, String str) {
        InterfaceC2318d interfaceC2318d = this.f7175b;
        if (interfaceC2318d != null) {
            interfaceC2318d.mo6661a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.InterfaceC2318d
    /* renamed from: a */
    public void mo6662a(InterfaceC2318d interfaceC2318d) {
        this.f7175b = interfaceC2318d;
    }

    @Override // com.huawei.hms.base.log.InterfaceC2318d
    /* renamed from: a */
    public void mo6663a(String str, int i2, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.f7174a;
        if (hMSExtLogger != null) {
            if (i2 == 3) {
                hMSExtLogger.m7707d(str2, str3);
            } else if (i2 == 4) {
                hMSExtLogger.m7709i(str2, str3);
            } else if (i2 != 5) {
                hMSExtLogger.m7708e(str2, str3);
            } else {
                hMSExtLogger.m7710w(str2, str3);
            }
        }
        InterfaceC2318d interfaceC2318d = this.f7175b;
        if (interfaceC2318d != null) {
            interfaceC2318d.mo6663a(str, i2, str2, str3);
        }
    }
}
