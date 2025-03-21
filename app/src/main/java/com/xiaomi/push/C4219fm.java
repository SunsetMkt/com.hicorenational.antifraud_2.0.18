package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.fm */
/* loaded from: classes2.dex */
public class C4219fm extends AbstractC4221fo {

    /* renamed from: a */
    private a f15323a;

    /* renamed from: a */
    private final Map<String, String> f15324a;

    /* renamed from: com.xiaomi.push.fm$a */
    public static class a {

        /* renamed from: a */
        public static final a f15325a = new a("get");

        /* renamed from: b */
        public static final a f15326b = new a("set");

        /* renamed from: c */
        public static final a f15327c = new a("result");

        /* renamed from: d */
        public static final a f15328d = new a("error");

        /* renamed from: e */
        public static final a f15329e = new a("command");

        /* renamed from: a */
        private String f15330a;

        private a(String str) {
            this.f15330a = str;
        }

        /* renamed from: a */
        public static a m14833a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f15325a.toString().equals(lowerCase)) {
                return f15325a;
            }
            if (f15326b.toString().equals(lowerCase)) {
                return f15326b;
            }
            if (f15328d.toString().equals(lowerCase)) {
                return f15328d;
            }
            if (f15327c.toString().equals(lowerCase)) {
                return f15327c;
            }
            if (f15329e.toString().equals(lowerCase)) {
                return f15329e;
            }
            return null;
        }

        public String toString() {
            return this.f15330a;
        }
    }

    public C4219fm() {
        this.f15323a = a.f15325a;
        this.f15324a = new HashMap();
    }

    /* renamed from: a */
    public synchronized void m14831a(Map<String, String> map) {
        this.f15324a.putAll(map);
    }

    /* renamed from: b */
    public String mo14832b() {
        return null;
    }

    /* renamed from: a */
    public a m14828a() {
        return this.f15323a;
    }

    public C4219fm(Bundle bundle) {
        super(bundle);
        this.f15323a = a.f15325a;
        this.f15324a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f15323a = a.m14833a(bundle.getString("ext_iq_type"));
        }
    }

    /* renamed from: a */
    public void m14830a(a aVar) {
        if (aVar == null) {
            this.f15323a = a.f15325a;
        } else {
            this.f15323a = aVar;
        }
    }

    @Override // com.xiaomi.push.AbstractC4221fo
    /* renamed from: a */
    public Bundle mo14827a() {
        Bundle mo14827a = super.mo14827a();
        a aVar = this.f15323a;
        if (aVar != null) {
            mo14827a.putString("ext_iq_type", aVar.toString());
        }
        return mo14827a;
    }

    @Override // com.xiaomi.push.AbstractC4221fo
    /* renamed from: a */
    public String mo14829a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (m14864j() != null) {
            sb.append("id=\"" + m14864j() + "\" ");
        }
        if (m14867l() != null) {
            sb.append("to=\"");
            sb.append(C4230fx.m14901a(m14867l()));
            sb.append("\" ");
        }
        if (m14869m() != null) {
            sb.append("from=\"");
            sb.append(C4230fx.m14901a(m14869m()));
            sb.append("\" ");
        }
        if (m14865k() != null) {
            sb.append("chid=\"");
            sb.append(C4230fx.m14901a(m14865k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f15324a.entrySet()) {
            sb.append(C4230fx.m14901a(entry.getKey()));
            sb.append("=\"");
            sb.append(C4230fx.m14901a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.f15323a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(m14828a());
            sb.append("\">");
        }
        String mo14832b = mo14832b();
        if (mo14832b != null) {
            sb.append(mo14832b);
        }
        sb.append(m14873o());
        C4225fs m14858a = m14858a();
        if (m14858a != null) {
            sb.append(m14858a.m14882a());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
