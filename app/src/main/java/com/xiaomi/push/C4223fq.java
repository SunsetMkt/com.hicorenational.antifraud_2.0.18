package com.xiaomi.push;

import android.os.Bundle;

/* renamed from: com.xiaomi.push.fq */
/* loaded from: classes2.dex */
public class C4223fq extends AbstractC4221fo {

    /* renamed from: a */
    private int f15359a;

    /* renamed from: a */
    private a f15360a;

    /* renamed from: a */
    private b f15361a;

    /* renamed from: b */
    private String f15362b;

    /* renamed from: com.xiaomi.push.fq$a */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* renamed from: com.xiaomi.push.fq$b */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public C4223fq(b bVar) {
        this.f15361a = b.available;
        this.f15362b = null;
        this.f15359a = Integer.MIN_VALUE;
        this.f15360a = null;
        m14878a(bVar);
    }

    @Override // com.xiaomi.push.AbstractC4221fo
    /* renamed from: a */
    public Bundle mo14827a() {
        Bundle mo14827a = super.mo14827a();
        b bVar = this.f15361a;
        if (bVar != null) {
            mo14827a.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f15362b;
        if (str != null) {
            mo14827a.putString("ext_pres_status", str);
        }
        int i2 = this.f15359a;
        if (i2 != Integer.MIN_VALUE) {
            mo14827a.putInt("ext_pres_prio", i2);
        }
        a aVar = this.f15360a;
        if (aVar != null && aVar != a.available) {
            mo14827a.putString("ext_pres_mode", aVar.toString());
        }
        return mo14827a;
    }

    public C4223fq(Bundle bundle) {
        super(bundle);
        this.f15361a = b.available;
        this.f15362b = null;
        this.f15359a = Integer.MIN_VALUE;
        this.f15360a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f15361a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f15362b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f15359a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f15360a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    /* renamed from: a */
    public void m14878a(b bVar) {
        if (bVar != null) {
            this.f15361a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    /* renamed from: a */
    public void m14879a(String str) {
        this.f15362b = str;
    }

    /* renamed from: a */
    public void m14876a(int i2) {
        if (i2 >= -128 && i2 <= 128) {
            this.f15359a = i2;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i2 + " is not valid. Valid range is -128 through 128.");
    }

    /* renamed from: a */
    public void m14877a(a aVar) {
        this.f15360a = aVar;
    }

    @Override // com.xiaomi.push.AbstractC4221fo
    /* renamed from: a */
    public String mo14829a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (m14875p() != null) {
            sb.append(" xmlns=\"");
            sb.append(m14875p());
            sb.append("\"");
        }
        if (m14864j() != null) {
            sb.append(" id=\"");
            sb.append(m14864j());
            sb.append("\"");
        }
        if (m14867l() != null) {
            sb.append(" to=\"");
            sb.append(C4230fx.m14901a(m14867l()));
            sb.append("\"");
        }
        if (m14869m() != null) {
            sb.append(" from=\"");
            sb.append(C4230fx.m14901a(m14869m()));
            sb.append("\"");
        }
        if (m14865k() != null) {
            sb.append(" chid=\"");
            sb.append(C4230fx.m14901a(m14865k()));
            sb.append("\"");
        }
        if (this.f15361a != null) {
            sb.append(" type=\"");
            sb.append(this.f15361a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f15362b != null) {
            sb.append("<status>");
            sb.append(C4230fx.m14901a(this.f15362b));
            sb.append("</status>");
        }
        if (this.f15359a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f15359a);
            sb.append("</priority>");
        }
        a aVar = this.f15360a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f15360a);
            sb.append("</show>");
        }
        sb.append(m14873o());
        C4225fs m14858a = m14858a();
        if (m14858a != null) {
            sb.append(m14858a.m14882a());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
