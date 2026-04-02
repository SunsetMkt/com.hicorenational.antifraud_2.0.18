package m;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import m.a;
import m.c;
import m.e;
import m.o;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {
    private final Map<Method, o<?, ?>> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    final Call.Factory f12748b;

    /* JADX INFO: renamed from: c */
    final HttpUrl f12749c;

    /* JADX INFO: renamed from: d */
    final List<e.a> f12750d;

    /* JADX INFO: renamed from: e */
    final List<c.a> f12751e;

    /* JADX INFO: renamed from: f */
    @Nullable
    final Executor f12752f;

    /* JADX INFO: renamed from: g */
    final boolean f12753g;

    /* JADX INFO: compiled from: Retrofit.java */
    class a implements InvocationHandler {
        private final k a = k.c();

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Class f12754b;

        a(Class cls) {
            this.f12754b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.a.a(method)) {
                return this.a.a(method, this.f12754b, obj, objArr);
            }
            o<?, ?> oVarA = n.this.a(method);
            return oVarA.a(new i(oVarA, objArr));
        }
    }

    /* JADX INFO: compiled from: Retrofit.java */
    public static final class b {
        private final k a;

        /* JADX INFO: renamed from: b */
        @Nullable
        private Call.Factory f12756b;

        /* JADX INFO: renamed from: c */
        private HttpUrl f12757c;

        /* JADX INFO: renamed from: d */
        private final List<e.a> f12758d;

        /* JADX INFO: renamed from: e */
        private final List<c.a> f12759e;

        /* JADX INFO: renamed from: f */
        @Nullable
        private Executor f12760f;

        /* JADX INFO: renamed from: g */
        private boolean f12761g;

        b(k kVar) {
            this.f12758d = new ArrayList();
            this.f12759e = new ArrayList();
            this.a = kVar;
        }

        public b a(OkHttpClient okHttpClient) {
            return a((Call.Factory) p.a(okHttpClient, "client == null"));
        }

        public List<c.a> b() {
            return this.f12759e;
        }

        public List<e.a> c() {
            return this.f12758d;
        }

        public b a(Call.Factory factory) {
            this.f12756b = (Call.Factory) p.a(factory, "factory == null");
            return this;
        }

        public b a(String str) {
            p.a(str, "baseUrl == null");
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl != null) {
                return a(httpUrl);
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public b() {
            this(k.c());
        }

        b(n nVar) {
            this.f12758d = new ArrayList();
            this.f12759e = new ArrayList();
            this.a = k.c();
            this.f12756b = nVar.f12748b;
            this.f12757c = nVar.f12749c;
            this.f12758d.addAll(nVar.f12750d);
            this.f12758d.remove(0);
            this.f12759e.addAll(nVar.f12751e);
            this.f12759e.remove(r0.size() - 1);
            this.f12760f = nVar.f12752f;
            this.f12761g = nVar.f12753g;
        }

        public b a(HttpUrl httpUrl) {
            p.a(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.f12757c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public b a(e.a aVar) {
            this.f12758d.add((e.a) p.a(aVar, "factory == null"));
            return this;
        }

        public b a(c.a aVar) {
            this.f12759e.add((c.a) p.a(aVar, "factory == null"));
            return this;
        }

        public b a(Executor executor) {
            this.f12760f = (Executor) p.a(executor, "executor == null");
            return this;
        }

        public b a(boolean z) {
            this.f12761g = z;
            return this;
        }

        public n a() {
            if (this.f12757c != null) {
                Call.Factory okHttpClient = this.f12756b;
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                }
                Call.Factory factory = okHttpClient;
                Executor executorA = this.f12760f;
                if (executorA == null) {
                    executorA = this.a.a();
                }
                Executor executor = executorA;
                ArrayList arrayList = new ArrayList(this.f12759e);
                arrayList.add(this.a.a(executor));
                ArrayList arrayList2 = new ArrayList(this.f12758d.size() + 1);
                arrayList2.add(new m.a());
                arrayList2.addAll(this.f12758d);
                return new n(factory, this.f12757c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f12761g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    n(Call.Factory factory, HttpUrl httpUrl, List<e.a> list, List<c.a> list2, @Nullable Executor executor, boolean z) {
        this.f12748b = factory;
        this.f12749c = httpUrl;
        this.f12750d = list;
        this.f12751e = list2;
        this.f12752f = executor;
        this.f12753g = z;
    }

    private void b(Class<?> cls) {
        k kVarC = k.c();
        for (Method method : cls.getDeclaredMethods()) {
            if (!kVarC.a(method)) {
                a(method);
            }
        }
    }

    public <T> T a(Class<T> cls) {
        p.a((Class) cls);
        if (this.f12753g) {
            b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public Call.Factory c() {
        return this.f12748b;
    }

    @Nullable
    public Executor d() {
        return this.f12752f;
    }

    public List<e.a> e() {
        return this.f12750d;
    }

    public b f() {
        return new b(this);
    }

    public <T> e<T, String> c(Type type, Annotation[] annotationArr) {
        p.a(type, "type == null");
        p.a(annotationArr, "annotations == null");
        int size = this.f12750d.size();
        for (int i2 = 0; i2 < size; i2++) {
            e<T, String> eVar = (e<T, String>) this.f12750d.get(i2).b(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        return a.d.a;
    }

    o<?, ?> a(Method method) {
        o oVarA;
        o<?, ?> oVar = this.a.get(method);
        if (oVar != null) {
            return oVar;
        }
        synchronized (this.a) {
            oVarA = this.a.get(method);
            if (oVarA == null) {
                oVarA = new o.a(this, method).a();
                this.a.put(method, oVarA);
            }
        }
        return oVarA;
    }

    public List<c.a> b() {
        return this.f12751e;
    }

    public <T> e<ResponseBody, T> b(Type type, Annotation[] annotationArr) {
        return a((e.a) null, type, annotationArr);
    }

    public HttpUrl a() {
        return this.f12749c;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public c<?, ?> a(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        p.a(type, "returnType == null");
        p.a(annotationArr, "annotations == null");
        int iIndexOf = this.f12751e.indexOf(aVar) + 1;
        int size = this.f12751e.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            c<?, ?> cVarA = this.f12751e.get(i2).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f12751e.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f12751e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f12751e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public <T> e<T, RequestBody> a(@Nullable e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        p.a(type, "type == null");
        p.a(annotationArr, "parameterAnnotations == null");
        p.a(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f12750d.indexOf(aVar) + 1;
        int size = this.f12750d.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            e<T, RequestBody> eVar = (e<T, RequestBody>) this.f12750d.get(i2).a(type, annotationArr, annotationArr2, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f12750d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f12750d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f12750d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<ResponseBody, T> a(@Nullable e.a aVar, Type type, Annotation[] annotationArr) {
        p.a(type, "type == null");
        p.a(annotationArr, "annotations == null");
        int iIndexOf = this.f12750d.indexOf(aVar) + 1;
        int size = this.f12750d.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            e<ResponseBody, T> eVar = (e<ResponseBody, T>) this.f12750d.get(i2).a(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f12750d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f12750d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f12750d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
