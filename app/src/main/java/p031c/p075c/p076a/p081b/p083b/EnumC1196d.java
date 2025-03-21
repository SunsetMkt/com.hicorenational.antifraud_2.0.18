package p031c.p075c.p076a.p081b.p083b;

import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: IntentType.java */
/* renamed from: c.c.a.b.b.d */
/* loaded from: classes.dex */
public enum EnumC1196d {
    REAL_NAME_VERIFY(AbstractC1191a.f2513K0, EnumC1195c.REAL_NAME_VERIFY),
    BIND_MOBILE_PHONE("BindMobilePhoneIntent", EnumC1195c.BIND_MOBILE_PHONE),
    BIND_EMAIL("BindEmailIntent", EnumC1195c.BIND_EMAIL);


    /* renamed from: a */
    private final String f2635a;

    /* renamed from: b */
    private final EnumC1195c f2636b;

    EnumC1196d(String str, EnumC1195c enumC1195c) {
        this.f2635a = str;
        this.f2636b = enumC1195c;
    }

    public EnumC1195c getFeatureType() {
        return this.f2636b;
    }

    public String getType() {
        return this.f2635a;
    }
}
