package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bm */
/* loaded from: classes2.dex */
public final class C3177bm extends AbstractC3188m implements Cloneable {

    /* renamed from: f */
    static ArrayList<C3176bl> f10721f;

    /* renamed from: g */
    static Map<String, String> f10722g;

    /* renamed from: a */
    public byte f10723a = 0;

    /* renamed from: b */
    public String f10724b = "";

    /* renamed from: c */
    public String f10725c = "";

    /* renamed from: d */
    public ArrayList<C3176bl> f10726d = null;

    /* renamed from: e */
    public Map<String, String> f10727e = null;

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10118b(this.f10723a, 0);
        String str = this.f10724b;
        if (str != null) {
            c3187l.m10106a(str, 1);
        }
        String str2 = this.f10725c;
        if (str2 != null) {
            c3187l.m10106a(str2, 2);
        }
        ArrayList<C3176bl> arrayList = this.f10726d;
        if (arrayList != null) {
            c3187l.m10107a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f10727e;
        if (map != null) {
            c3187l.m10108a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10723a = c3186k.m10070a(this.f10723a, 0, true);
        this.f10724b = c3186k.m10078a(1, false);
        this.f10725c = c3186k.m10078a(2, false);
        if (f10721f == null) {
            f10721f = new ArrayList<>();
            f10721f.add(new C3176bl());
        }
        this.f10726d = (ArrayList) c3186k.m10077a((C3186k) f10721f, 3, false);
        if (f10722g == null) {
            f10722g = new HashMap();
            f10722g.put("", "");
        }
        this.f10727e = (Map) c3186k.m10077a((C3186k) f10722g, 4, false);
    }
}
