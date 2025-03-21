package p358k.p359a.p360a.p361a;

import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: HnIDCloudServiceUtils.java */
/* renamed from: k.a.a.a.d */
/* loaded from: classes2.dex */
public class C5850d {
    /* renamed from: a */
    public static String m24636a(List<Scope> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Scope> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().m6019a());
            sb.append(AbstractC1191a.f2568g);
        }
        C5863e.m24692b("HnIDCloudServiceUtils", "scopesToStr scopes : " + sb.toString().trim(), true);
        return sb.toString().trim();
    }
}
