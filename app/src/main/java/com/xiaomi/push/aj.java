package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
class aj implements ai, InvocationHandler {
    private static final String[][] a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Class f173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class f8736b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f175a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Method f176b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Method f8737c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f8738d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f8739e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Method f8740f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Method f8741g = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f174a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f169a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile long f170a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile a f172a = null;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Boolean f177a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f8742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f8743c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f8744d;

        private a() {
            this.f177a = null;
            this.f178a = null;
            this.f8742b = null;
            this.f8743c = null;
            this.f8744d = null;
        }

        boolean a() {
            if (!TextUtils.isEmpty(this.f178a) || !TextUtils.isEmpty(this.f8742b) || !TextUtils.isEmpty(this.f8743c) || !TextUtils.isEmpty(this.f8744d)) {
                this.f177a = true;
            }
            return this.f177a != null;
        }
    }

    public aj(Context context) {
        this.f171a = context.getApplicationContext();
        a(context);
        b(context);
    }

    private void b(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = -jElapsedRealtime;
        Class cls = this.f8736b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f175a, this.f173a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f8736b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
                jElapsedRealtime = j2;
            }
        } else {
            jElapsedRealtime = j2;
        }
        this.f170a = jElapsedRealtime;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public boolean mo135a() {
        a("isSupported");
        return this.f172a != null && Boolean.TRUE.equals(this.f172a.f177a);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f170a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Object obj2 = objArr[i2];
                if (obj2 != null && !a(obj2)) {
                    aVar.f8742b = (String) a(this.f8737c, obj2, new Object[0]);
                    aVar.f177a = (Boolean) a(this.f8740f, obj2, new Object[0]);
                    a(this.f8741g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.f172a != null);
                        b(sb.toString());
                        synchronized (aj.class) {
                            if (this.f172a == null) {
                                this.f172a = aVar;
                            }
                        }
                    }
                }
                i2++;
            }
        }
        a();
        return null;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public String mo134a() {
        a("getOAID");
        if (this.f172a == null) {
            return null;
        }
        return this.f172a.f8742b;
    }

    private void a(Context context) {
        Class<?> clsA = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i2 = 0;
        while (true) {
            String[][] strArr = a;
            if (i2 >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i2];
            Class<?> clsA2 = a(context, strArr2[0]);
            Class<?> clsA3 = a(context, strArr2[1]);
            if (clsA2 != null && clsA3 != null) {
                b("found class in index " + i2);
                cls2 = clsA3;
                cls = clsA2;
                break;
            }
            i2++;
            cls2 = clsA3;
            cls = clsA2;
        }
        this.f173a = clsA;
        this.f175a = a(clsA, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.f8736b = cls;
        this.f8737c = a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f8740f = a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.f8741g = a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    private static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m48a("mdid:" + str);
    }

    private void a(String str) {
        if (this.f172a != null) {
            return;
        }
        long j2 = this.f170a;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
        int i2 = this.f169a;
        if (jElapsedRealtime > 3000 && i2 < 3) {
            synchronized (this.f174a) {
                if (this.f170a == j2 && this.f169a == i2) {
                    b("retry, current count is " + i2);
                    this.f169a = this.f169a + 1;
                    b(this.f171a);
                    j2 = this.f170a;
                    jElapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
                }
            }
        }
        if (this.f172a != null || j2 < 0 || jElapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f174a) {
            if (this.f172a == null) {
                try {
                    b(str + " wait...");
                    this.f174a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a() {
        synchronized (this.f174a) {
            try {
                this.f174a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return r.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
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
