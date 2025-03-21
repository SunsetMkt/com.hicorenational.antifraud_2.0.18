package com.xiaomi.push;

import java.util.Map;

/* renamed from: com.xiaomi.push.eh */
/* loaded from: classes2.dex */
public class C4187eh implements InterfaceC4185ef {

    /* renamed from: a */
    private InterfaceC4185ef f15085a;

    /* renamed from: com.xiaomi.push.eh$a */
    private static class a {

        /* renamed from: a */
        private static C4187eh f15086a = new C4187eh();
    }

    /* renamed from: a */
    public static C4187eh m14597a() {
        return a.f15086a;
    }

    private C4187eh() {
    }

    @Override // com.xiaomi.push.InterfaceC4185ef
    /* renamed from: a */
    public void mo14595a(InterfaceC4184ee interfaceC4184ee) {
        InterfaceC4185ef interfaceC4185ef = this.f15085a;
        if (interfaceC4185ef != null) {
            interfaceC4185ef.mo14595a(interfaceC4184ee);
        }
    }

    @Override // com.xiaomi.push.InterfaceC4185ef
    /* renamed from: a */
    public void mo14596a(String str, Map<String, Object> map) {
        InterfaceC4185ef interfaceC4185ef = this.f15085a;
        if (interfaceC4185ef != null) {
            interfaceC4185ef.mo14596a(str, map);
        }
    }
}
