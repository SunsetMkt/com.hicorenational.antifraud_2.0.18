package util.o2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Parameters.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final Map<String, Map<Integer, Object>> a = new LinkedHashMap();

    /* JADX INFO: renamed from: b */
    private int f15001b = -1;

    /* JADX INFO: renamed from: c */
    private int f15002c = 0;

    /* JADX INFO: renamed from: d */
    private int f15003d = 0;

    public void a(String str, Object obj) throws IllegalStateException {
        if (str == null) {
            return;
        }
        if (!a(obj)) {
            throw new IllegalArgumentException("Please use value which is primitive type like: String,Integer,Long and so on. But not Collection !");
        }
        this.f15002c++;
        int i2 = this.f15001b;
        if (i2 > -1 && this.f15002c > i2) {
            throw new IllegalStateException("parameters.maxCountFail: " + this.f15001b);
        }
        Map<Integer, Object> linkedHashMap = this.a.get(str);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>(1);
            this.a.put(str, linkedHashMap);
        }
        int i3 = this.f15003d;
        this.f15003d = i3 + 1;
        Integer numValueOf = Integer.valueOf(i3);
        if (obj == null) {
            obj = "";
        }
        linkedHashMap.put(numValueOf, obj);
    }

    public String b(String str) {
        Map<Integer, Object> map = this.a.get(str);
        if (map == null || map.size() == 0) {
            return "";
        }
        String string = map.values().iterator().next().toString();
        return (string == null || d.c.a.b.a.a.f10075h.equals(string)) ? "" : string;
    }

    public boolean c() {
        return this.a.isEmpty();
    }

    public Set<String> b() {
        return this.a.keySet();
    }

    private boolean a(Object obj) {
        return obj == null || (obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short);
    }

    public String[] a(String str) {
        Map<Integer, Object> map = this.a.get(str);
        if (map == null) {
            return null;
        }
        return (String[]) map.values().toArray(new String[map.size()]);
    }

    public int a() {
        return this.f15001b;
    }

    public void a(int i2) {
        this.f15001b = i2;
    }
}
