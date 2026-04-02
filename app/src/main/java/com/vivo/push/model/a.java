package com.vivo.push.model;

/* JADX INFO: compiled from: ConfigItem.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8564b;

    public a(String str, String str2) {
        this.a = str;
        this.f8564b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f8564b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.a;
        if (str == null) {
            if (aVar.a != null) {
                return false;
            }
        } else if (!str.equals(aVar.a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.a + "', mValue='" + this.f8564b + "'}";
    }
}
