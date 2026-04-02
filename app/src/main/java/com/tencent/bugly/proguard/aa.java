package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class aa extends m implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static bk f6332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static y f6333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f6334e = !aa.class.desiredAssertionStatus();
    public bk a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f6335b = null;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        bk bkVar = this.a;
        if (bkVar != null) {
            lVar.a((m) bkVar, 0);
        }
        y yVar = this.f6335b;
        if (yVar != null) {
            lVar.a((m) yVar, 1);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f6334e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        aa aaVar = (aa) obj;
        return n.a(this.a, aaVar.a) && n.a(this.f6335b, aaVar.f6335b);
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
    public void a(k kVar) {
        if (f6332c == null) {
            f6332c = new bk();
        }
        this.a = (bk) kVar.a((m) f6332c, 0, false);
        if (f6333d == null) {
            f6333d = new y();
        }
        this.f6335b = (y) kVar.a((m) f6333d, 1, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a((m) this.a, "baseStrategy");
        iVar.a((m) this.f6335b, "grayStrategy");
    }
}
