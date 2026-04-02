package com.tencent.bugly.proguard;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class v extends m implements Cloneable {

    /* JADX INFO: renamed from: l */
    static final /* synthetic */ boolean f6572l = !v.class.desiredAssertionStatus();
    public String a;

    /* JADX INFO: renamed from: b */
    public byte f6573b;

    /* JADX INFO: renamed from: c */
    public int f6574c;

    /* JADX INFO: renamed from: d */
    public String f6575d;

    /* JADX INFO: renamed from: e */
    public int f6576e;

    /* JADX INFO: renamed from: f */
    public String f6577f;

    /* JADX INFO: renamed from: g */
    public long f6578g;

    /* JADX INFO: renamed from: h */
    public String f6579h;

    /* JADX INFO: renamed from: i */
    public String f6580i;

    /* JADX INFO: renamed from: j */
    public String f6581j;

    /* JADX INFO: renamed from: k */
    public String f6582k;

    public v() {
        this.a = "";
        this.f6573b = (byte) 0;
        this.f6574c = 0;
        this.f6575d = "";
        this.f6576e = 0;
        this.f6577f = "";
        this.f6578g = 0L;
        this.f6579h = "";
        this.f6580i = "";
        this.f6581j = "";
        this.f6582k = "";
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.b(this.f6573b, 1);
        lVar.a(this.f6574c, 2);
        String str = this.f6575d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f6576e, 4);
        String str2 = this.f6577f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        lVar.a(this.f6578g, 6);
        String str3 = this.f6579h;
        if (str3 != null) {
            lVar.a(str3, 7);
        }
        String str4 = this.f6580i;
        if (str4 != null) {
            lVar.a(str4, 8);
        }
        String str5 = this.f6581j;
        if (str5 != null) {
            lVar.a(str5, 9);
        }
        String str6 = this.f6582k;
        if (str6 != null) {
            lVar.a(str6, 10);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f6572l) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        v vVar = (v) obj;
        return n.a(this.a, vVar.a) && n.a(this.f6573b, vVar.f6573b) && n.a(this.f6574c, vVar.f6574c) && n.a(this.f6575d, vVar.f6575d) && n.a(this.f6576e, vVar.f6576e) && n.a(this.f6577f, vVar.f6577f) && n.a(this.f6578g, vVar.f6578g) && n.a(this.f6579h, vVar.f6579h) && n.a(this.f6580i, vVar.f6580i) && n.a(this.f6581j, vVar.f6581j) && n.a(this.f6582k, vVar.f6582k);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public v(String str, byte b2, int i2, String str2, int i3, String str3, long j2, String str4, String str5, String str6, String str7) {
        this.a = "";
        this.f6573b = (byte) 0;
        this.f6574c = 0;
        this.f6575d = "";
        this.f6576e = 0;
        this.f6577f = "";
        this.f6578g = 0L;
        this.f6579h = "";
        this.f6580i = "";
        this.f6581j = "";
        this.f6582k = "";
        this.a = str;
        this.f6573b = b2;
        this.f6574c = i2;
        this.f6575d = str2;
        this.f6576e = i3;
        this.f6577f = str3;
        this.f6578g = j2;
        this.f6579h = str4;
        this.f6580i = str5;
        this.f6581j = str6;
        this.f6582k = str7;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(0, true);
        this.f6573b = kVar.a(this.f6573b, 1, true);
        this.f6574c = kVar.a(this.f6574c, 2, true);
        this.f6575d = kVar.a(3, false);
        this.f6576e = kVar.a(this.f6576e, 4, false);
        this.f6577f = kVar.a(5, false);
        this.f6578g = kVar.a(this.f6578g, 6, false);
        this.f6579h = kVar.a(7, false);
        this.f6580i = kVar.a(8, false);
        this.f6581j = kVar.a(9, false);
        this.f6582k = kVar.a(10, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, "appId");
        iVar.a(this.f6573b, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
        iVar.a(this.f6574c, "versionCode");
        iVar.a(this.f6575d, "versionName");
        iVar.a(this.f6576e, "buildNo");
        iVar.a(this.f6577f, "iconUrl");
        iVar.a(this.f6578g, "apkId");
        iVar.a(this.f6579h, RemoteMessageConst.Notification.CHANNEL_ID);
        iVar.a(this.f6580i, "md5");
        iVar.a(this.f6581j, "sdkVer");
        iVar.a(this.f6582k, "bundleId");
    }
}
