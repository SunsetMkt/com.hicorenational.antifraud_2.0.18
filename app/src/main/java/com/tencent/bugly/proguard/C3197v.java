package com.tencent.bugly.proguard;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.p208mm.opensdk.constants.ConstantsAPI;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.v */
/* loaded from: classes2.dex */
public final class C3197v extends AbstractC3188m implements Cloneable {

    /* renamed from: l */
    static final /* synthetic */ boolean f10801l = !C3197v.class.desiredAssertionStatus();

    /* renamed from: a */
    public String f10802a;

    /* renamed from: b */
    public byte f10803b;

    /* renamed from: c */
    public int f10804c;

    /* renamed from: d */
    public String f10805d;

    /* renamed from: e */
    public int f10806e;

    /* renamed from: f */
    public String f10807f;

    /* renamed from: g */
    public long f10808g;

    /* renamed from: h */
    public String f10809h;

    /* renamed from: i */
    public String f10810i;

    /* renamed from: j */
    public String f10811j;

    /* renamed from: k */
    public String f10812k;

    public C3197v() {
        this.f10802a = "";
        this.f10803b = (byte) 0;
        this.f10804c = 0;
        this.f10805d = "";
        this.f10806e = 0;
        this.f10807f = "";
        this.f10808g = 0L;
        this.f10809h = "";
        this.f10810i = "";
        this.f10811j = "";
        this.f10812k = "";
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10106a(this.f10802a, 0);
        c3187l.m10118b(this.f10803b, 1);
        c3187l.m10102a(this.f10804c, 2);
        String str = this.f10805d;
        if (str != null) {
            c3187l.m10106a(str, 3);
        }
        c3187l.m10102a(this.f10806e, 4);
        String str2 = this.f10807f;
        if (str2 != null) {
            c3187l.m10106a(str2, 5);
        }
        c3187l.m10103a(this.f10808g, 6);
        String str3 = this.f10809h;
        if (str3 != null) {
            c3187l.m10106a(str3, 7);
        }
        String str4 = this.f10810i;
        if (str4 != null) {
            c3187l.m10106a(str4, 8);
        }
        String str5 = this.f10811j;
        if (str5 != null) {
            c3187l.m10106a(str5, 9);
        }
        String str6 = this.f10812k;
        if (str6 != null) {
            c3187l.m10106a(str6, 10);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10801l) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C3197v c3197v = (C3197v) obj;
        return C3189n.m10123a(this.f10802a, c3197v.f10802a) && C3189n.m10120a(this.f10803b, c3197v.f10803b) && C3189n.m10121a(this.f10804c, c3197v.f10804c) && C3189n.m10123a(this.f10805d, c3197v.f10805d) && C3189n.m10121a(this.f10806e, c3197v.f10806e) && C3189n.m10123a(this.f10807f, c3197v.f10807f) && C3189n.m10122a(this.f10808g, c3197v.f10808g) && C3189n.m10123a(this.f10809h, c3197v.f10809h) && C3189n.m10123a(this.f10810i, c3197v.f10810i) && C3189n.m10123a(this.f10811j, c3197v.f10811j) && C3189n.m10123a(this.f10812k, c3197v.f10812k);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C3197v(String str, byte b2, int i2, String str2, int i3, String str3, long j2, String str4, String str5, String str6, String str7) {
        this.f10802a = "";
        this.f10803b = (byte) 0;
        this.f10804c = 0;
        this.f10805d = "";
        this.f10806e = 0;
        this.f10807f = "";
        this.f10808g = 0L;
        this.f10809h = "";
        this.f10810i = "";
        this.f10811j = "";
        this.f10812k = "";
        this.f10802a = str;
        this.f10803b = b2;
        this.f10804c = i2;
        this.f10805d = str2;
        this.f10806e = i3;
        this.f10807f = str3;
        this.f10808g = j2;
        this.f10809h = str4;
        this.f10810i = str5;
        this.f10811j = str6;
        this.f10812k = str7;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10802a = c3186k.m10078a(0, true);
        this.f10803b = c3186k.m10070a(this.f10803b, 1, true);
        this.f10804c = c3186k.m10073a(this.f10804c, 2, true);
        this.f10805d = c3186k.m10078a(3, false);
        this.f10806e = c3186k.m10073a(this.f10806e, 4, false);
        this.f10807f = c3186k.m10078a(5, false);
        this.f10808g = c3186k.m10075a(this.f10808g, 6, false);
        this.f10809h = c3186k.m10078a(7, false);
        this.f10810i = c3186k.m10078a(8, false);
        this.f10811j = c3186k.m10078a(9, false);
        this.f10812k = c3186k.m10078a(10, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        C3184i c3184i = new C3184i(sb, i2);
        c3184i.m10051a(this.f10802a, "appId");
        c3184i.m10043a(this.f10803b, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
        c3184i.m10047a(this.f10804c, "versionCode");
        c3184i.m10051a(this.f10805d, "versionName");
        c3184i.m10047a(this.f10806e, "buildNo");
        c3184i.m10051a(this.f10807f, "iconUrl");
        c3184i.m10048a(this.f10808g, "apkId");
        c3184i.m10051a(this.f10809h, RemoteMessageConst.Notification.CHANNEL_ID);
        c3184i.m10051a(this.f10810i, "md5");
        c3184i.m10051a(this.f10811j, "sdkVer");
        c3184i.m10051a(this.f10812k, "bundleId");
    }
}
