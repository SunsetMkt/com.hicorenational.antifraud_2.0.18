package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.u */
/* loaded from: classes2.dex */
public final class C3196u extends AbstractC3188m implements Cloneable {

    /* renamed from: f */
    static final /* synthetic */ boolean f10795f = !C3196u.class.desiredAssertionStatus();

    /* renamed from: a */
    public String f10796a;

    /* renamed from: b */
    public String f10797b;

    /* renamed from: c */
    public String f10798c;

    /* renamed from: d */
    public long f10799d;

    /* renamed from: e */
    public String f10800e;

    public C3196u() {
        this.f10796a = "";
        this.f10797b = "";
        this.f10798c = "";
        this.f10799d = 0L;
        this.f10800e = "";
    }

    /* renamed from: a */
    public String m10148a() {
        return this.f10797b;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10795f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C3196u c3196u = (C3196u) obj;
        return C3189n.m10123a(this.f10796a, c3196u.f10796a) && C3189n.m10123a(this.f10797b, c3196u.f10797b) && C3189n.m10123a(this.f10798c, c3196u.f10798c) && C3189n.m10122a(this.f10799d, c3196u.f10799d) && C3189n.m10123a(this.f10800e, c3196u.f10800e);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10106a(this.f10796a, 0);
        c3187l.m10106a(this.f10797b, 1);
        String str = this.f10798c;
        if (str != null) {
            c3187l.m10106a(str, 2);
        }
        c3187l.m10103a(this.f10799d, 3);
        String str2 = this.f10800e;
        if (str2 != null) {
            c3187l.m10106a(str2, 4);
        }
    }

    public C3196u(String str, String str2, String str3, long j2, String str4) {
        this.f10796a = "";
        this.f10797b = "";
        this.f10798c = "";
        this.f10799d = 0L;
        this.f10800e = "";
        this.f10796a = str;
        this.f10797b = str2;
        this.f10798c = str3;
        this.f10799d = j2;
        this.f10800e = str4;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10796a = c3186k.m10078a(0, true);
        this.f10797b = c3186k.m10078a(1, true);
        this.f10798c = c3186k.m10078a(2, false);
        this.f10799d = c3186k.m10075a(this.f10799d, 3, true);
        this.f10800e = c3186k.m10078a(4, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        C3184i c3184i = new C3184i(sb, i2);
        c3184i.m10051a(this.f10796a, "apkMd5");
        c3184i.m10051a(this.f10797b, "apkUrl");
        c3184i.m10051a(this.f10798c, "manifestMd5");
        c3184i.m10048a(this.f10799d, "fileSize");
        c3184i.m10051a(this.f10800e, "signatureMd5");
    }
}
