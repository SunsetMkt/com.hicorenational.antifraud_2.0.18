package com.vivo.push.model;

/* compiled from: ConfigItem.java */
/* renamed from: com.vivo.push.model.a */
/* loaded from: classes2.dex */
public final class C3925a {

    /* renamed from: a */
    private String f14091a;

    /* renamed from: b */
    private String f14092b;

    public C3925a(String str, String str2) {
        this.f14091a = str;
        this.f14092b = str2;
    }

    /* renamed from: a */
    public final String m13058a() {
        return this.f14091a;
    }

    /* renamed from: b */
    public final String m13059b() {
        return this.f14092b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3925a.class != obj.getClass()) {
            return false;
        }
        C3925a c3925a = (C3925a) obj;
        String str = this.f14091a;
        if (str == null) {
            if (c3925a.f14091a != null) {
                return false;
            }
        } else if (!str.equals(c3925a.f14091a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f14091a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f14091a + "', mValue='" + this.f14092b + "'}";
    }
}
