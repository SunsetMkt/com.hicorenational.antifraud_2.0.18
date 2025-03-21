package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.xiaomi.push.aj */
/* loaded from: classes2.dex */
class C4081aj implements InterfaceC4080ai, InvocationHandler {

    /* renamed from: a */
    private static final String[][] f14510a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a */
    private Context f14513a;

    /* renamed from: a */
    private Class f14515a = null;

    /* renamed from: b */
    private Class f14518b = null;

    /* renamed from: a */
    private Method f14517a = null;

    /* renamed from: b */
    private Method f14519b = null;

    /* renamed from: c */
    private Method f14520c = null;

    /* renamed from: d */
    private Method f14521d = null;

    /* renamed from: e */
    private Method f14522e = null;

    /* renamed from: f */
    private Method f14523f = null;

    /* renamed from: g */
    private Method f14524g = null;

    /* renamed from: a */
    private final Object f14516a = new Object();

    /* renamed from: a */
    private volatile int f14511a = 0;

    /* renamed from: a */
    private volatile long f14512a = 0;

    /* renamed from: a */
    private volatile a f14514a = null;

    /* renamed from: com.xiaomi.push.aj$a */
    private class a {

        /* renamed from: a */
        Boolean f14526a;

        /* renamed from: a */
        String f14527a;

        /* renamed from: b */
        String f14528b;

        /* renamed from: c */
        String f14529c;

        /* renamed from: d */
        String f14530d;

        private a() {
            this.f14526a = null;
            this.f14527a = null;
            this.f14528b = null;
            this.f14529c = null;
            this.f14530d = null;
        }

        /* renamed from: a */
        boolean m13749a() {
            if (!TextUtils.isEmpty(this.f14527a) || !TextUtils.isEmpty(this.f14528b) || !TextUtils.isEmpty(this.f14529c) || !TextUtils.isEmpty(this.f14530d)) {
                this.f14526a = true;
            }
            return this.f14526a != null;
        }
    }

    public C4081aj(Context context) {
        this.f14513a = context.getApplicationContext();
        m13744a(context);
        m13747b(context);
    }

    /* renamed from: b */
    private void m13747b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = -elapsedRealtime;
        Class cls = this.f14518b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                m13741a(this.f14517a, this.f14515a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f14518b}, this));
            } catch (Throwable th) {
                m13748b("call init sdk error:" + th);
            }
            this.f14512a = elapsedRealtime;
        }
        elapsedRealtime = j2;
        this.f14512a = elapsedRealtime;
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public boolean mo13737a() {
        m13745a("isSupported");
        return this.f14514a != null && Boolean.TRUE.equals(this.f14514a.f14526a);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f14512a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Object obj2 = objArr[i2];
                if (obj2 != null && !m13746a(obj2)) {
                    aVar.f14528b = (String) m13741a(this.f14520c, obj2, new Object[0]);
                    aVar.f14526a = (Boolean) m13741a(this.f14523f, obj2, new Object[0]);
                    m13741a(this.f14524g, obj2, new Object[0]);
                    if (aVar.m13749a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.f14514a != null);
                        m13748b(sb.toString());
                        synchronized (C4081aj.class) {
                            if (this.f14514a == null) {
                                this.f14514a = aVar;
                            }
                        }
                    }
                }
                i2++;
            }
        }
        m13743a();
        return null;
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public String mo13736a() {
        m13745a("getOAID");
        if (this.f14514a == null) {
            return null;
        }
        return this.f14514a.f14528b;
    }

    /* renamed from: a */
    private void m13744a(Context context) {
        Class<?> m13740a = m13740a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i2 = 0;
        while (true) {
            String[][] strArr = f14510a;
            if (i2 >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i2];
            Class<?> m13740a2 = m13740a(context, strArr2[0]);
            Class<?> m13740a3 = m13740a(context, strArr2[1]);
            if (m13740a2 != null && m13740a3 != null) {
                m13748b("found class in index " + i2);
                cls2 = m13740a3;
                cls = m13740a2;
                break;
            }
            i2++;
            cls2 = m13740a3;
            cls = m13740a2;
        }
        this.f14515a = m13740a;
        this.f14517a = m13742a(m13740a, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.f14518b = cls;
        this.f14520c = m13742a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f14523f = m13742a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.f14524g = m13742a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    /* renamed from: b */
    private static void m13748b(String str) {
        AbstractC4022b.m13347a("mdid:" + str);
    }

    /* renamed from: a */
    private void m13745a(String str) {
        if (this.f14514a != null) {
            return;
        }
        long j2 = this.f14512a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
        int i2 = this.f14511a;
        if (elapsedRealtime > 3000 && i2 < 3) {
            synchronized (this.f14516a) {
                if (this.f14512a == j2 && this.f14511a == i2) {
                    m13748b("retry, current count is " + i2);
                    this.f14511a = this.f14511a + 1;
                    m13747b(this.f14513a);
                    j2 = this.f14512a;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
                }
            }
        }
        if (this.f14514a != null || j2 < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f14516a) {
            if (this.f14514a == null) {
                try {
                    m13748b(str + " wait...");
                    this.f14516a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private void m13743a() {
        synchronized (this.f14516a) {
            try {
                this.f14516a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private static boolean m13746a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    /* renamed from: a */
    private static Class<?> m13740a(Context context, String str) {
        try {
            return C4309r.m15716a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static Method m13742a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static <T> T m13741a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T t = (T) method.invoke(obj, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
