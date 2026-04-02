package com.vivo.push.restructure.request.a.a;

import com.vivo.push.restructure.request.a.a.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: JsonParcel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONArray f8618c;

    public a() {
        this.a = 0;
        this.f8618c = new JSONArray();
    }

    public final void a(int i2) {
        this.f8618c.put(i2);
    }

    public final long b() throws JSONException {
        int i2 = this.a;
        if (i2 >= this.f8617b) {
            return 0L;
        }
        JSONArray jSONArray = this.f8618c;
        this.a = i2 + 1;
        return jSONArray.getLong(i2);
    }

    public final String c() throws JSONException {
        int i2 = this.a;
        if (i2 >= this.f8617b) {
            return null;
        }
        JSONArray jSONArray = this.f8618c;
        this.a = i2 + 1;
        return jSONArray.getString(i2);
    }

    public final String d() {
        JSONArray jSONArray = this.f8618c;
        return jSONArray != null ? jSONArray.toString() : "";
    }

    public final void a(long j2) {
        this.f8618c.put(j2);
    }

    public final void a(String str) {
        this.f8618c.put(str);
    }

    public a(String str) throws JSONException {
        this.a = 0;
        this.f8618c = new JSONArray(str);
        this.a = 0;
        this.f8617b = this.f8618c.length();
    }

    public final <T extends c> void a(List<T> list) {
        if (list != null) {
            this.f8618c.put(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.f8618c.put(it.next().a());
            }
            return;
        }
        this.f8618c.put((Object) null);
    }

    public final int a() throws JSONException {
        int i2 = this.a;
        if (i2 >= this.f8617b) {
            return 0;
        }
        JSONArray jSONArray = this.f8618c;
        this.a = i2 + 1;
        return jSONArray.getInt(i2);
    }

    public final <T extends c> void a(c.a<T> aVar, List<T> list) throws JSONException {
        T tA;
        int i2 = this.a;
        if (i2 < this.f8617b ? this.f8618c.isNull(i2) : true) {
            this.a++;
            return;
        }
        JSONArray jSONArray = this.f8618c;
        int i3 = this.a;
        this.a = i3 + 1;
        int i4 = jSONArray.getInt(i3);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.a;
            if (i6 < this.f8617b) {
                JSONArray jSONArray2 = this.f8618c;
                this.a = i6 + 1;
                tA = aVar.a(jSONArray2.getString(i6));
            } else {
                tA = null;
            }
            list.add(tA);
        }
    }
}
