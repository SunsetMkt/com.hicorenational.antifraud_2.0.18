package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aa */
/* loaded from: classes2.dex */
public final class C3138aa extends AbstractC3188m implements Cloneable {

    /* renamed from: c */
    static C3175bk f10457c;

    /* renamed from: d */
    static C3200y f10458d;

    /* renamed from: e */
    static final /* synthetic */ boolean f10459e = !C3138aa.class.desiredAssertionStatus();

    /* renamed from: a */
    public C3175bk f10460a = null;

    /* renamed from: b */
    public C3200y f10461b = null;

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        C3175bk c3175bk = this.f10460a;
        if (c3175bk != null) {
            c3187l.m10104a((AbstractC3188m) c3175bk, 0);
        }
        C3200y c3200y = this.f10461b;
        if (c3200y != null) {
            c3187l.m10104a((AbstractC3188m) c3200y, 1);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10459e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C3138aa c3138aa = (C3138aa) obj;
        return C3189n.m10123a(this.f10460a, c3138aa.f10460a) && C3189n.m10123a(this.f10461b, c3138aa.f10461b);
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
    public void mo9793a(C3186k c3186k) {
        if (f10457c == null) {
            f10457c = new C3175bk();
        }
        this.f10460a = (C3175bk) c3186k.m10076a((AbstractC3188m) f10457c, 0, false);
        if (f10458d == null) {
            f10458d = new C3200y();
        }
        this.f10461b = (C3200y) c3186k.m10076a((AbstractC3188m) f10458d, 1, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        C3184i c3184i = new C3184i(sb, i2);
        c3184i.m10049a((AbstractC3188m) this.f10460a, "baseStrategy");
        c3184i.m10049a((AbstractC3188m) this.f10461b, "grayStrategy");
    }
}
