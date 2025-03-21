package cn.jzvd;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* compiled from: JZDataSource.java */
/* renamed from: cn.jzvd.v */
/* loaded from: classes.dex */
public class C1280v {

    /* renamed from: g */
    public static final String f2859g = "URL_KEY_DEFAULT";

    /* renamed from: a */
    public int f2860a;

    /* renamed from: b */
    public LinkedHashMap f2861b;

    /* renamed from: c */
    public String f2862c;

    /* renamed from: d */
    public HashMap<String, String> f2863d;

    /* renamed from: e */
    public boolean f2864e;

    /* renamed from: f */
    public Object[] f2865f;

    public C1280v(String str) {
        this.f2861b = new LinkedHashMap();
        this.f2862c = "";
        this.f2863d = new HashMap<>();
        this.f2864e = false;
        this.f2861b.put(f2859g, str);
        this.f2860a = 0;
    }

    /* renamed from: a */
    public String m2518a(int i2) {
        int i3 = 0;
        for (Object obj : this.f2861b.keySet()) {
            if (i3 == i2) {
                return obj.toString();
            }
            i3++;
        }
        return null;
    }

    /* renamed from: b */
    public Object m2520b() {
        return m2518a(this.f2860a);
    }

    /* renamed from: c */
    public Object m2522c() {
        return m2521b(this.f2860a);
    }

    /* renamed from: b */
    public Object m2521b(int i2) {
        int i3 = 0;
        for (Object obj : this.f2861b.keySet()) {
            if (i3 == i2) {
                return this.f2861b.get(obj);
            }
            i3++;
        }
        return null;
    }

    /* renamed from: a */
    public boolean m2519a(Object obj) {
        if (obj != null) {
            return this.f2861b.containsValue(obj);
        }
        return false;
    }

    /* renamed from: a */
    public C1280v m2517a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.f2861b);
        return new C1280v(linkedHashMap, this.f2862c);
    }

    public C1280v(String str, String str2) {
        this.f2861b = new LinkedHashMap();
        this.f2862c = "";
        this.f2863d = new HashMap<>();
        this.f2864e = false;
        this.f2861b.put(f2859g, str);
        this.f2862c = str2;
        this.f2860a = 0;
    }

    public C1280v(Object obj) {
        this.f2861b = new LinkedHashMap();
        this.f2862c = "";
        this.f2863d = new HashMap<>();
        this.f2864e = false;
        this.f2861b.put(f2859g, obj);
        this.f2860a = 0;
    }

    public C1280v(LinkedHashMap linkedHashMap) {
        this.f2861b = new LinkedHashMap();
        this.f2862c = "";
        this.f2863d = new HashMap<>();
        this.f2864e = false;
        this.f2861b.clear();
        this.f2861b.putAll(linkedHashMap);
        this.f2860a = 0;
    }

    public C1280v(LinkedHashMap linkedHashMap, String str) {
        this.f2861b = new LinkedHashMap();
        this.f2862c = "";
        this.f2863d = new HashMap<>();
        this.f2864e = false;
        this.f2861b.clear();
        this.f2861b.putAll(linkedHashMap);
        this.f2862c = str;
        this.f2860a = 0;
    }
}
