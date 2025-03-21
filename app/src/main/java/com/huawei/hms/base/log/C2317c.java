package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: LogCatNode.java */
/* renamed from: com.huawei.hms.base.log.c */
/* loaded from: classes.dex */
public class C2317c implements InterfaceC2318d {

    /* renamed from: a */
    private InterfaceC2318d f7179a;

    @Override // com.huawei.hms.base.log.InterfaceC2318d
    /* renamed from: a */
    public void mo6661a(Context context, String str) {
        InterfaceC2318d interfaceC2318d = this.f7179a;
        if (interfaceC2318d != null) {
            interfaceC2318d.mo6661a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.InterfaceC2318d
    /* renamed from: a */
    public void mo6662a(InterfaceC2318d interfaceC2318d) {
        this.f7179a = interfaceC2318d;
    }

    @Override // com.huawei.hms.base.log.InterfaceC2318d
    /* renamed from: a */
    public void mo6663a(String str, int i2, String str2, String str3) {
        Log.println(i2, "HMSSDK_" + str2, str3);
        InterfaceC2318d interfaceC2318d = this.f7179a;
        if (interfaceC2318d != null) {
            interfaceC2318d.mo6663a(str, i2, str2, str3);
        }
    }
}
