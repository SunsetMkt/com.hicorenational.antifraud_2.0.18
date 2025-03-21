package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.c */
/* loaded from: classes2.dex */
class C3178c {

    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f10728a = new HashMap<>();

    /* renamed from: b */
    protected HashMap<String, Object> f10729b = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, Object> f10732e = new HashMap<>();

    /* renamed from: c */
    protected String f10730c = "GBK";

    /* renamed from: d */
    C3186k f10731d = new C3186k();

    C3178c() {
    }

    /* renamed from: a */
    public void mo10028a(String str) {
        this.f10730c = str;
    }

    /* renamed from: a */
    public <T> void mo10029a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        C3187l c3187l = new C3187l();
        c3187l.m10096a(this.f10730c);
        c3187l.m10105a(t, 0);
        byte[] m10125a = C3189n.m10125a(c3187l.m10097a());
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        m10027a(arrayList, t);
        hashMap.put(C3137a.m9792a(arrayList), m10125a);
        this.f10732e.remove(str);
        this.f10728a.put(str, hashMap);
    }

    /* renamed from: a */
    private void m10027a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    m10027a(arrayList, Array.get(obj, 0));
                    return;
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            }
            throw new IllegalArgumentException("only byte[] is supported");
        }
        if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    m10027a(arrayList, list.get(0));
                    return;
                } else {
                    arrayList.add("?");
                    return;
                }
            }
            if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    m10027a(arrayList, obj2);
                    return;
                }
                arrayList.add("?");
                arrayList.add("?");
                return;
            }
            arrayList.add(obj.getClass().getName());
            return;
        }
        throw new IllegalArgumentException("can not support Array, please use List");
    }

    /* renamed from: a */
    public byte[] mo10031a() {
        C3187l c3187l = new C3187l(0);
        c3187l.m10096a(this.f10730c);
        c3187l.m10108a((Map) this.f10728a, 0);
        return C3189n.m10125a(c3187l.m10097a());
    }

    /* renamed from: a */
    public void mo10030a(byte[] bArr) {
        this.f10731d.m10084a(bArr);
        this.f10731d.m10074a(this.f10730c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f10728a = this.f10731d.m10079a((Map) hashMap, 0, false);
    }
}
