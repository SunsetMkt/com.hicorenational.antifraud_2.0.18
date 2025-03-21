package org.greenrobot.eventbus.util;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ExceptionToResourceMapping.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends Throwable>, Integer> f17495a = new HashMap();

    public Integer a(Throwable th) {
        Throwable th2 = th;
        int i2 = 20;
        do {
            Integer b2 = b(th2);
            if (b2 == null) {
                th2 = th2.getCause();
                i2--;
                if (i2 <= 0 || th2 == th) {
                    break;
                }
            } else {
                return b2;
            }
        } while (th2 != null);
        String str = "No specific message resource ID found for " + th;
        return null;
    }

    protected Integer b(Throwable th) {
        Class<?> cls = th.getClass();
        Integer num = this.f17495a.get(cls);
        if (num == null) {
            Class<? extends Throwable> cls2 = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> entry : this.f17495a.entrySet()) {
                Class<? extends Throwable> key = entry.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    num = entry.getValue();
                    cls2 = key;
                }
            }
        }
        return num;
    }

    public d a(Class<? extends Throwable> cls, int i2) {
        this.f17495a.put(cls, Integer.valueOf(i2));
        return this;
    }
}
