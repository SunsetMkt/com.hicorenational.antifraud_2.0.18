package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends m implements Cloneable {

    /* JADX INFO: renamed from: f */
    static final /* synthetic */ boolean f6567f = !u.class.desiredAssertionStatus();
    public String a;

    /* JADX INFO: renamed from: b */
    public String f6568b;

    /* JADX INFO: renamed from: c */
    public String f6569c;

    /* JADX INFO: renamed from: d */
    public long f6570d;

    /* JADX INFO: renamed from: e */
    public String f6571e;

    public u() {
        this.a = "";
        this.f6568b = "";
        this.f6569c = "";
        this.f6570d = 0L;
        this.f6571e = "";
    }

    public String a() {
        return this.f6568b;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f6567f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        u uVar = (u) obj;
        return n.a(this.a, uVar.a) && n.a(this.f6568b, uVar.f6568b) && n.a(this.f6569c, uVar.f6569c) && n.a(this.f6570d, uVar.f6570d) && n.a(this.f6571e, uVar.f6571e);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.f6568b, 1);
        String str = this.f6569c;
        if (str != null) {
            lVar.a(str, 2);
        }
        lVar.a(this.f6570d, 3);
        String str2 = this.f6571e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
    }

    public u(String str, String str2, String str3, long j2, String str4) {
        this.a = "";
        this.f6568b = "";
        this.f6569c = "";
        this.f6570d = 0L;
        this.f6571e = "";
        this.a = str;
        this.f6568b = str2;
        this.f6569c = str3;
        this.f6570d = j2;
        this.f6571e = str4;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(0, true);
        this.f6568b = kVar.a(1, true);
        this.f6569c = kVar.a(2, false);
        this.f6570d = kVar.a(this.f6570d, 3, true);
        this.f6571e = kVar.a(4, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, "apkMd5");
        iVar.a(this.f6568b, "apkUrl");
        iVar.a(this.f6569c, "manifestMd5");
        iVar.a(this.f6570d, "fileSize");
        iVar.a(this.f6571e, "signatureMd5");
    }
}
