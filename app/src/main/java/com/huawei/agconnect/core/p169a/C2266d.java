package com.huawei.agconnect.core.p169a;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.agconnect.core.a.d */
/* loaded from: classes.dex */
public final class C2266d {

    /* renamed from: a */
    private static Map<Class<?>, Service> f6937a = new HashMap();

    /* renamed from: b */
    private static Map<Class<?>, Object> f6938b = new HashMap();

    /* renamed from: c */
    private Map<Class<?>, Service> f6939c = new HashMap();

    /* renamed from: d */
    private Map<Class<?>, Object> f6940d = new HashMap();

    C2266d(List<Service> list, Context context) {
        m6470a(list, context);
    }

    /* renamed from: a */
    private Object m6466a(AGConnectInstance aGConnectInstance, Service service2) {
        StringBuilder sb;
        String localizedMessage;
        if (service2.getInstance() != null) {
            return service2.getInstance();
        }
        Class<?> type = service2.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor m6467a = m6467a(type, Context.class, AGConnectInstance.class);
            if (m6467a != null) {
                return m6467a.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor m6467a2 = m6467a(type, Context.class);
            return m6467a2 != null ? m6467a2.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e2.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        } catch (InstantiationException e3) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e3.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        } catch (InvocationTargetException e4) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e4.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        }
    }

    /* renamed from: a */
    private static Constructor m6467a(Class cls, Class... clsArr) {
        boolean z = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                boolean z2 = z;
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    z2 = parameterTypes[i2] == clsArr[i2];
                }
                if (z2) {
                    return constructor;
                }
                z = z2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m6468a(String str, Exception exc) {
        String str2 = "Instantiate shared service " + str + exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder();
        sb.append("cause message:");
        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        sb.toString();
    }

    /* renamed from: a */
    public <T> T m6469a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service2 = this.f6939c.get(cls);
        if (service2 == null && (service2 = f6937a.get(cls)) != null) {
            return (T) f6938b.get(cls);
        }
        if (service2 == null) {
            return null;
        }
        if (service2.isSingleton() && (t = (T) this.f6940d.get(cls)) != null) {
            return t;
        }
        T t2 = (T) m6466a(aGConnectInstance, service2);
        if (t2 != null && service2.isSingleton()) {
            this.f6940d.put(cls, t2);
        }
        return t2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[Catch: InvocationTargetException -> 0x0076, InstantiationException -> 0x007a, IllegalAccessException -> 0x007e, TryCatch #2 {IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076, blocks: (B:22:0x0049, B:26:0x005b, B:27:0x006c, B:30:0x0064), top: B:21:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: InvocationTargetException -> 0x0076, InstantiationException -> 0x007a, IllegalAccessException -> 0x007e, TryCatch #2 {IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076, blocks: (B:22:0x0049, B:26:0x005b, B:27:0x006c, B:30:0x0064), top: B:21:0x0049 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6470a(java.util.List<com.huawei.agconnect.core.Service> r7, android.content.Context r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L3
            return
        L3:
            java.util.Iterator r7 = r7.iterator()
        L7:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L85
            java.lang.Object r0 = r7.next()
            com.huawei.agconnect.core.Service r0 = (com.huawei.agconnect.core.Service) r0
            boolean r1 = r0.isSharedInstance()
            if (r1 == 0) goto L28
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = com.huawei.agconnect.core.p169a.C2266d.f6937a
            java.lang.Class r2 = r0.getInterface()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L31
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = com.huawei.agconnect.core.p169a.C2266d.f6937a
            goto L2a
        L28:
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = r6.f6939c
        L2a:
            java.lang.Class r2 = r0.getInterface()
            r1.put(r2, r0)
        L31:
            boolean r1 = r0.isAutoCreated()
            if (r1 == 0) goto L7
            java.lang.Class r1 = r0.getType()
            if (r1 == 0) goto L7
            java.util.Map<java.lang.Class<?>, java.lang.Object> r1 = com.huawei.agconnect.core.p169a.C2266d.f6938b
            java.lang.Class r2 = r0.getInterface()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L7
            java.lang.Class r1 = r0.getType()     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.reflect.Constructor r1 = m6467a(r1, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            if (r1 == 0) goto L64
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            r2[r5] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.Object r1 = r1.newInstance(r2)     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            goto L6c
        L64:
            java.lang.Class r1 = r0.getType()     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
        L6c:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r2 = com.huawei.agconnect.core.p169a.C2266d.f6938b     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            java.lang.Class r0 = r0.getInterface()     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            r2.put(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L76 java.lang.InstantiationException -> L7a java.lang.IllegalAccessException -> L7e
            goto L7
        L76:
            r0 = move-exception
            java.lang.String r1 = "TargetException"
            goto L81
        L7a:
            r0 = move-exception
            java.lang.String r1 = "InstantiationException"
            goto L81
        L7e:
            r0 = move-exception
            java.lang.String r1 = "AccessException"
        L81:
            r6.m6468a(r1, r0)
            goto L7
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.p169a.C2266d.m6470a(java.util.List, android.content.Context):void");
    }
}
