package com.vivo.push.p234d.p235a;

import android.text.TextUtils;
import com.vivo.push.p234d.C3867b;
import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: SyncProfileInfoInputDS.java */
/* renamed from: com.vivo.push.d.a.b */
/* loaded from: classes2.dex */
public final class C3865b implements InterfaceC3961b {

    /* renamed from: a */
    public static final InterfaceC3961b.a<C3865b> f13975a = new C3866c();

    /* renamed from: b */
    private String f13976b;

    /* renamed from: c */
    private List<C3867b> f13977c;

    /* renamed from: d */
    private int f13978d;

    public C3865b(String str, List<C3867b> list, int i2) {
        this.f13977c = new ArrayList();
        this.f13976b = str;
        this.f13978d = i2;
        this.f13977c = list;
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b
    /* renamed from: a */
    public final void mo12930a(C3960a c3960a) {
        c3960a.m13146a(this.f13976b);
        c3960a.m13143a(this.f13978d);
        c3960a.m13147a(this.f13977c);
    }

    /* renamed from: a */
    public final List<String> m12929a() {
        ArrayList arrayList = new ArrayList();
        Iterator<C3867b> it = this.f13977c.iterator();
        while (it.hasNext()) {
            String m12934b = it.next().m12934b();
            if (!TextUtils.isEmpty(m12934b)) {
                arrayList.add(m12934b);
            }
        }
        return arrayList;
    }

    protected C3865b(C3960a c3960a) throws JSONException {
        this.f13977c = new ArrayList();
        this.f13976b = c3960a.m13149c();
        this.f13978d = c3960a.m13142a();
        c3960a.m13145a(C3867b.f13979a, this.f13977c);
    }
}
