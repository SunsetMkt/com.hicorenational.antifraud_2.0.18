package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class fs {
    private int a;

    /* JADX INFO: renamed from: a */
    private String f537a;

    /* JADX INFO: renamed from: a */
    private List<fl> f538a;

    /* JADX INFO: renamed from: b */
    private String f9020b;

    /* JADX INFO: renamed from: c */
    private String f9021c;

    /* JADX INFO: renamed from: d */
    private String f9022d;

    public static class a {
        public static final a a = new a("internal-server-error");

        /* JADX INFO: renamed from: b */
        public static final a f9023b = new a("forbidden");

        /* JADX INFO: renamed from: c */
        public static final a f9024c = new a("bad-request");

        /* JADX INFO: renamed from: d */
        public static final a f9025d = new a("conflict");

        /* JADX INFO: renamed from: e */
        public static final a f9026e = new a("feature-not-implemented");

        /* JADX INFO: renamed from: f */
        public static final a f9027f = new a("gone");

        /* JADX INFO: renamed from: g */
        public static final a f9028g = new a("item-not-found");

        /* JADX INFO: renamed from: h */
        public static final a f9029h = new a("jid-malformed");

        /* JADX INFO: renamed from: i */
        public static final a f9030i = new a("not-acceptable");

        /* JADX INFO: renamed from: j */
        public static final a f9031j = new a("not-allowed");

        /* JADX INFO: renamed from: k */
        public static final a f9032k = new a("not-authorized");

        /* JADX INFO: renamed from: l */
        public static final a f9033l = new a("payment-required");

        /* JADX INFO: renamed from: m */
        public static final a f9034m = new a("recipient-unavailable");

        /* JADX INFO: renamed from: n */
        public static final a f9035n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");

        /* JADX INFO: renamed from: a */
        private String f539a;

        public a(String str) {
            this.f539a = str;
        }

        public String toString() {
            return this.f539a;
        }
    }

    public fs(a aVar) {
        this.f538a = null;
        a(aVar);
        this.f9022d = null;
    }

    private void a(a aVar) {
        this.f9020b = aVar.f539a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f9020b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.a);
        sb.append(")");
        if (this.f9022d != null) {
            sb.append(d.c.a.b.a.a.f10074g);
            sb.append(this.f9022d);
        }
        return sb.toString();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f537a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.a);
        String str2 = this.f9021c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f9020b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f9022d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<fl> list = this.f538a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            Iterator<fl> it = this.f538a.iterator();
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i2] = bundleA;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public fs(int i2, String str, String str2, String str3, String str4, List<fl> list) {
        this.f538a = null;
        this.a = i2;
        this.f537a = str;
        this.f9021c = str2;
        this.f9020b = str3;
        this.f9022d = str4;
        this.f538a = list;
    }

    public fs(Bundle bundle) {
        this.f538a = null;
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f537a = bundle.getString("ext_err_type");
        }
        this.f9020b = bundle.getString("ext_err_cond");
        this.f9021c = bundle.getString("ext_err_reason");
        this.f9022d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f538a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fl flVarA = fl.a((Bundle) parcelable);
                if (flVarA != null) {
                    this.f538a.add(flVarA);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public String m433a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.a);
        sb.append("\"");
        if (this.f537a != null) {
            sb.append(" type=\"");
            sb.append(this.f537a);
            sb.append("\"");
        }
        if (this.f9021c != null) {
            sb.append(" reason=\"");
            sb.append(this.f9021c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f9020b != null) {
            sb.append("<");
            sb.append(this.f9020b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f9022d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f9022d);
            sb.append("</text>");
        }
        Iterator<fl> it = m434a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public synchronized List<fl> m434a() {
        if (this.f538a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.f538a);
    }
}
