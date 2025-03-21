package util.p396d2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Parameters.java */
/* renamed from: util.d2.a */
/* loaded from: classes2.dex */
public class C7269a {

    /* renamed from: a */
    private final Map<String, Map<Integer, Object>> f25288a = new LinkedHashMap();

    /* renamed from: b */
    private int f25289b = -1;

    /* renamed from: c */
    private int f25290c = 0;

    /* renamed from: d */
    private int f25291d = 0;

    /* renamed from: a */
    public void m26321a(String str, Object obj) throws IllegalStateException {
        if (str == null) {
            return;
        }
        if (!m26318a(obj)) {
            throw new IllegalArgumentException("Please use value which is primitive type like: String,Integer,Long and so on. But not Collection !");
        }
        this.f25290c++;
        int i2 = this.f25289b;
        if (i2 > -1 && this.f25290c > i2) {
            throw new IllegalStateException("parameters.maxCountFail: " + this.f25289b);
        }
        Map<Integer, Object> map = this.f25288a.get(str);
        if (map == null) {
            map = new LinkedHashMap<>(1);
            this.f25288a.put(str, map);
        }
        int i3 = this.f25291d;
        this.f25291d = i3 + 1;
        Integer valueOf = Integer.valueOf(i3);
        if (obj == null) {
            obj = "";
        }
        map.put(valueOf, obj);
    }

    /* renamed from: b */
    public String m26323b(String str) {
        Map<Integer, Object> map = this.f25288a.get(str);
        if (map == null || map.size() == 0) {
            return "";
        }
        String obj = map.values().iterator().next().toString();
        return (obj == null || AbstractC1191a.f2571h.equals(obj)) ? "" : obj;
    }

    /* renamed from: c */
    public boolean m26325c() {
        return this.f25288a.isEmpty();
    }

    /* renamed from: b */
    public Set<String> m26324b() {
        return this.f25288a.keySet();
    }

    /* renamed from: a */
    private boolean m26318a(Object obj) {
        return obj == null || (obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short);
    }

    /* renamed from: a */
    public String[] m26322a(String str) {
        Map<Integer, Object> map = this.f25288a.get(str);
        if (map == null) {
            return null;
        }
        return (String[]) map.values().toArray(new String[map.size()]);
    }

    /* renamed from: a */
    public int m26319a() {
        return this.f25289b;
    }

    /* renamed from: a */
    public void m26320a(int i2) {
        this.f25289b = i2;
    }
}
