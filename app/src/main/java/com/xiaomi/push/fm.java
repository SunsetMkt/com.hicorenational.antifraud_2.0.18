package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class fm extends fo {
    private a a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, String> f524a;

    public static class a {
        public static final a a = new a("get");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8985b = new a("set");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8986c = new a("result");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f8987d = new a("error");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8988e = new a("command");

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f525a;

        private a(String str) {
            this.f525a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (a.toString().equals(lowerCase)) {
                return a;
            }
            if (f8985b.toString().equals(lowerCase)) {
                return f8985b;
            }
            if (f8987d.toString().equals(lowerCase)) {
                return f8987d;
            }
            if (f8986c.toString().equals(lowerCase)) {
                return f8986c;
            }
            if (f8988e.toString().equals(lowerCase)) {
                return f8988e;
            }
            return null;
        }

        public String toString() {
            return this.f525a;
        }
    }

    public fm() {
        this.a = a.a;
        this.f524a = new HashMap();
    }

    public synchronized void a(Map<String, String> map) {
        this.f524a.putAll(map);
    }

    public String b() {
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m428a() {
        return this.a;
    }

    public fm(Bundle bundle) {
        super(bundle);
        this.a = a.a;
        this.f524a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.a = a.a;
        } else {
            this.a = aVar;
        }
    }

    @Override // com.xiaomi.push.fo
    public Bundle a() {
        Bundle bundleA = super.a();
        a aVar = this.a;
        if (aVar != null) {
            bundleA.putString("ext_iq_type", aVar.toString());
        }
        return bundleA;
    }

    @Override // com.xiaomi.push.fo
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo429a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(fx.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(fx.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(fx.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f524a.entrySet()) {
            sb.append(fx.a(entry.getKey()));
            sb.append("=\"");
            sb.append(fx.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(m428a());
            sb.append("\">");
        }
        String strB = b();
        if (strB != null) {
            sb.append(strB);
        }
        sb.append(o());
        fs fsVarM430a = m430a();
        if (fsVarM430a != null) {
            sb.append(fsVarM430a.m433a());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
