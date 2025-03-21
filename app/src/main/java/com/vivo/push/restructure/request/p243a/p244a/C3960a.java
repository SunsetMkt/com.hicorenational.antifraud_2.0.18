package com.vivo.push.restructure.request.p243a.p244a;

import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: JsonParcel.java */
/* renamed from: com.vivo.push.restructure.request.a.a.a */
/* loaded from: classes2.dex */
public final class C3960a {

    /* renamed from: a */
    private int f14167a;

    /* renamed from: b */
    private int f14168b;

    /* renamed from: c */
    private JSONArray f14169c;

    public C3960a() {
        this.f14167a = 0;
        this.f14169c = new JSONArray();
    }

    /* renamed from: a */
    public final void m13143a(int i2) {
        this.f14169c.put(i2);
    }

    /* renamed from: b */
    public final long m13148b() throws JSONException {
        int i2 = this.f14167a;
        if (i2 >= this.f14168b) {
            return 0L;
        }
        JSONArray jSONArray = this.f14169c;
        this.f14167a = i2 + 1;
        return jSONArray.getLong(i2);
    }

    /* renamed from: c */
    public final String m13149c() throws JSONException {
        int i2 = this.f14167a;
        if (i2 >= this.f14168b) {
            return null;
        }
        JSONArray jSONArray = this.f14169c;
        this.f14167a = i2 + 1;
        return jSONArray.getString(i2);
    }

    /* renamed from: d */
    public final String m13150d() {
        JSONArray jSONArray = this.f14169c;
        return jSONArray != null ? jSONArray.toString() : "";
    }

    /* renamed from: a */
    public final void m13144a(long j2) {
        this.f14169c.put(j2);
    }

    /* renamed from: a */
    public final void m13146a(String str) {
        this.f14169c.put(str);
    }

    public C3960a(String str) throws JSONException {
        this.f14167a = 0;
        this.f14169c = new JSONArray(str);
        this.f14167a = 0;
        this.f14168b = this.f14169c.length();
    }

    /* renamed from: a */
    public final <T extends InterfaceC3962c> void m13147a(List<T> list) {
        if (list != null) {
            this.f14169c.put(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.f14169c.put(it.next().mo12933a());
            }
            return;
        }
        this.f14169c.put((Object) null);
    }

    /* renamed from: a */
    public final int m13142a() throws JSONException {
        int i2 = this.f14167a;
        if (i2 >= this.f14168b) {
            return 0;
        }
        JSONArray jSONArray = this.f14169c;
        this.f14167a = i2 + 1;
        return jSONArray.getInt(i2);
    }

    /* renamed from: a */
    public final <T extends InterfaceC3962c> void m13145a(InterfaceC3962c.a<T> aVar, List<T> list) throws JSONException {
        T t;
        int i2 = this.f14167a;
        if (i2 < this.f14168b ? this.f14169c.isNull(i2) : true) {
            this.f14167a++;
            return;
        }
        JSONArray jSONArray = this.f14169c;
        int i3 = this.f14167a;
        this.f14167a = i3 + 1;
        int i4 = jSONArray.getInt(i3);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.f14167a;
            if (i6 < this.f14168b) {
                JSONArray jSONArray2 = this.f14169c;
                this.f14167a = i6 + 1;
                t = aVar.mo12936a(jSONArray2.getString(i6));
            } else {
                t = null;
            }
            list.add(t);
        }
    }
}
