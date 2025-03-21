package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.fs */
/* loaded from: classes2.dex */
public class C4225fs {

    /* renamed from: a */
    private int f15379a;

    /* renamed from: a */
    private String f15380a;

    /* renamed from: a */
    private List<C4218fl> f15381a;

    /* renamed from: b */
    private String f15382b;

    /* renamed from: c */
    private String f15383c;

    /* renamed from: d */
    private String f15384d;

    /* renamed from: com.xiaomi.push.fs$a */
    public static class a {

        /* renamed from: a */
        public static final a f15385a = new a("internal-server-error");

        /* renamed from: b */
        public static final a f15386b = new a("forbidden");

        /* renamed from: c */
        public static final a f15387c = new a("bad-request");

        /* renamed from: d */
        public static final a f15388d = new a("conflict");

        /* renamed from: e */
        public static final a f15389e = new a("feature-not-implemented");

        /* renamed from: f */
        public static final a f15390f = new a("gone");

        /* renamed from: g */
        public static final a f15391g = new a("item-not-found");

        /* renamed from: h */
        public static final a f15392h = new a("jid-malformed");

        /* renamed from: i */
        public static final a f15393i = new a("not-acceptable");

        /* renamed from: j */
        public static final a f15394j = new a("not-allowed");

        /* renamed from: k */
        public static final a f15395k = new a("not-authorized");

        /* renamed from: l */
        public static final a f15396l = new a("payment-required");

        /* renamed from: m */
        public static final a f15397m = new a("recipient-unavailable");

        /* renamed from: n */
        public static final a f15398n = new a("redirect");

        /* renamed from: o */
        public static final a f15399o = new a("registration-required");

        /* renamed from: p */
        public static final a f15400p = new a("remote-server-error");

        /* renamed from: q */
        public static final a f15401q = new a("remote-server-not-found");

        /* renamed from: r */
        public static final a f15402r = new a("remote-server-timeout");

        /* renamed from: s */
        public static final a f15403s = new a("resource-constraint");

        /* renamed from: t */
        public static final a f15404t = new a("service-unavailable");

        /* renamed from: u */
        public static final a f15405u = new a("subscription-required");

        /* renamed from: v */
        public static final a f15406v = new a("undefined-condition");

        /* renamed from: w */
        public static final a f15407w = new a("unexpected-request");

        /* renamed from: x */
        public static final a f15408x = new a("request-timeout");

        /* renamed from: a */
        private String f15409a;

        public a(String str) {
            this.f15409a = str;
        }

        public String toString() {
            return this.f15409a;
        }
    }

    public C4225fs(a aVar) {
        this.f15381a = null;
        m14880a(aVar);
        this.f15384d = null;
    }

    /* renamed from: a */
    private void m14880a(a aVar) {
        this.f15382b = aVar.f15409a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f15382b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f15379a);
        sb.append(")");
        if (this.f15384d != null) {
            sb.append(AbstractC1191a.f2568g);
            sb.append(this.f15384d);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public Bundle m14881a() {
        Bundle bundle = new Bundle();
        String str = this.f15380a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f15379a);
        String str2 = this.f15383c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f15382b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f15384d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<C4218fl> list = this.f15381a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            Iterator<C4218fl> it = this.f15381a.iterator();
            while (it.hasNext()) {
                Bundle m14818a = it.next().m14818a();
                if (m14818a != null) {
                    bundleArr[i2] = m14818a;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public C4225fs(int i2, String str, String str2, String str3, String str4, List<C4218fl> list) {
        this.f15381a = null;
        this.f15379a = i2;
        this.f15380a = str;
        this.f15383c = str2;
        this.f15382b = str3;
        this.f15384d = str4;
        this.f15381a = list;
    }

    public C4225fs(Bundle bundle) {
        this.f15381a = null;
        this.f15379a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f15380a = bundle.getString("ext_err_type");
        }
        this.f15382b = bundle.getString("ext_err_cond");
        this.f15383c = bundle.getString("ext_err_reason");
        this.f15384d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f15381a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C4218fl m14815a = C4218fl.m14815a((Bundle) parcelable);
                if (m14815a != null) {
                    this.f15381a.add(m14815a);
                }
            }
        }
    }

    /* renamed from: a */
    public String m14882a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.f15379a);
        sb.append("\"");
        if (this.f15380a != null) {
            sb.append(" type=\"");
            sb.append(this.f15380a);
            sb.append("\"");
        }
        if (this.f15383c != null) {
            sb.append(" reason=\"");
            sb.append(this.f15383c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f15382b != null) {
            sb.append("<");
            sb.append(this.f15382b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f15384d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f15384d);
            sb.append("</text>");
        }
        Iterator<C4218fl> it = m14883a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().mo14826d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a */
    public synchronized List<C4218fl> m14883a() {
        if (this.f15381a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.f15381a);
    }
}
