package com.vivo.push.d.a;

import android.text.TextUtils;
import com.vivo.push.restructure.request.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: SyncProfileInfoInputDS.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.vivo.push.restructure.request.a.a.b {
    public static final b.a<b> a = new c();

    /* JADX INFO: renamed from: b */
    private String f8483b;

    /* JADX INFO: renamed from: c */
    private List<com.vivo.push.d.b> f8484c;

    /* JADX INFO: renamed from: d */
    private int f8485d;

    public b(String str, List<com.vivo.push.d.b> list, int i2) {
        this.f8484c = new ArrayList();
        this.f8483b = str;
        this.f8485d = i2;
        this.f8484c = list;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f8483b);
        aVar.a(this.f8485d);
        aVar.a(this.f8484c);
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.vivo.push.d.b> it = this.f8484c.iterator();
        while (it.hasNext()) {
            String strB = it.next().b();
            if (!TextUtils.isEmpty(strB)) {
                arrayList.add(strB);
            }
        }
        return arrayList;
    }

    protected b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f8484c = new ArrayList();
        this.f8483b = aVar.c();
        this.f8485d = aVar.a();
        aVar.a(com.vivo.push.d.b.a, this.f8484c);
    }
}
