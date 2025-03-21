package org.greenrobot.eventbus.util;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ExceptionToResourceMapping.java */
/* renamed from: org.greenrobot.eventbus.util.d */
/* loaded from: classes2.dex */
public class C6072d {

    /* renamed from: a */
    public final Map<Class<? extends Throwable>, Integer> f21663a = new HashMap();

    /* renamed from: a */
    public Integer m25092a(Throwable th) {
        Throwable th2 = th;
        int i2 = 20;
        do {
            Integer m25094b = m25094b(th2);
            if (m25094b == null) {
                th2 = th2.getCause();
                i2--;
                if (i2 <= 0 || th2 == th) {
                    break;
                }
            } else {
                return m25094b;
            }
        } while (th2 != null);
        String str = "No specific message resource ID found for " + th;
        return null;
    }

    /* renamed from: b */
    protected Integer m25094b(Throwable th) {
        Class<?> cls = th.getClass();
        Integer num = this.f21663a.get(cls);
        if (num == null) {
            Class<? extends Throwable> cls2 = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> entry : this.f21663a.entrySet()) {
                Class<? extends Throwable> key = entry.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    num = entry.getValue();
                    cls2 = key;
                }
            }
        }
        return num;
    }

    /* renamed from: a */
    public C6072d m25093a(Class<? extends Throwable> cls, int i2) {
        this.f21663a.put(cls, Integer.valueOf(i2));
        return this;
    }
}
