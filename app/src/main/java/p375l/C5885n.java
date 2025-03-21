package p375l;

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
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p375l.C5872a;
import p375l.C5886o;
import p375l.InterfaceC5874c;
import p375l.InterfaceC5876e;

/* compiled from: Retrofit.java */
/* renamed from: l.n */
/* loaded from: classes2.dex */
public final class C5885n {

    /* renamed from: a */
    private final Map<Method, C5886o<?, ?>> f21270a = new ConcurrentHashMap();

    /* renamed from: b */
    final Call.Factory f21271b;

    /* renamed from: c */
    final HttpUrl f21272c;

    /* renamed from: d */
    final List<InterfaceC5876e.a> f21273d;

    /* renamed from: e */
    final List<InterfaceC5874c.a> f21274e;

    /* renamed from: f */
    @Nullable
    final Executor f21275f;

    /* renamed from: g */
    final boolean f21276g;

    /* compiled from: Retrofit.java */
    /* renamed from: l.n$a */
    class a implements InvocationHandler {

        /* renamed from: a */
        private final C5882k f21277a = C5882k.m24770c();

        /* renamed from: b */
        final /* synthetic */ Class f21278b;

        a(Class cls) {
            this.f21278b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.f21277a.mo24774a(method)) {
                return this.f21277a.mo24771a(method, this.f21278b, obj, objArr);
            }
            C5886o<?, ?> m24805a = C5885n.this.m24805a(method);
            return m24805a.m24827a(new C5880i(m24805a, objArr));
        }
    }

    /* compiled from: Retrofit.java */
    /* renamed from: l.n$b */
    public static final class b {

        /* renamed from: a */
        private final C5882k f21280a;

        /* renamed from: b */
        @Nullable
        private Call.Factory f21281b;

        /* renamed from: c */
        private HttpUrl f21282c;

        /* renamed from: d */
        private final List<InterfaceC5876e.a> f21283d;

        /* renamed from: e */
        private final List<InterfaceC5874c.a> f21284e;

        /* renamed from: f */
        @Nullable
        private Executor f21285f;

        /* renamed from: g */
        private boolean f21286g;

        b(C5882k c5882k) {
            this.f21283d = new ArrayList();
            this.f21284e = new ArrayList();
            this.f21280a = c5882k;
        }

        /* renamed from: a */
        public b m24820a(OkHttpClient okHttpClient) {
            return m24818a((Call.Factory) C5887p.m24845a(okHttpClient, "client == null"));
        }

        /* renamed from: b */
        public List<InterfaceC5874c.a> m24823b() {
            return this.f21284e;
        }

        /* renamed from: c */
        public List<InterfaceC5876e.a> m24824c() {
            return this.f21283d;
        }

        /* renamed from: a */
        public b m24818a(Call.Factory factory) {
            this.f21281b = (Call.Factory) C5887p.m24845a(factory, "factory == null");
            return this;
        }

        /* renamed from: a */
        public b m24814a(String str) {
            C5887p.m24845a(str, "baseUrl == null");
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                return m24819a(parse);
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public b() {
            this(C5882k.m24770c());
        }

        b(C5885n c5885n) {
            this.f21283d = new ArrayList();
            this.f21284e = new ArrayList();
            this.f21280a = C5882k.m24770c();
            this.f21281b = c5885n.f21271b;
            this.f21282c = c5885n.f21272c;
            this.f21283d.addAll(c5885n.f21273d);
            this.f21283d.remove(0);
            this.f21284e.addAll(c5885n.f21274e);
            this.f21284e.remove(r0.size() - 1);
            this.f21285f = c5885n.f21275f;
            this.f21286g = c5885n.f21276g;
        }

        /* renamed from: a */
        public b m24819a(HttpUrl httpUrl) {
            C5887p.m24845a(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.f21282c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public b m24817a(InterfaceC5876e.a aVar) {
            this.f21283d.add(C5887p.m24845a(aVar, "factory == null"));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public b m24816a(InterfaceC5874c.a aVar) {
            this.f21284e.add(C5887p.m24845a(aVar, "factory == null"));
            return this;
        }

        /* renamed from: a */
        public b m24815a(Executor executor) {
            this.f21285f = (Executor) C5887p.m24845a(executor, "executor == null");
            return this;
        }

        /* renamed from: a */
        public b m24821a(boolean z) {
            this.f21286g = z;
            return this;
        }

        /* renamed from: a */
        public C5885n m24822a() {
            if (this.f21282c != null) {
                Call.Factory factory = this.f21281b;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Call.Factory factory2 = factory;
                Executor executor = this.f21285f;
                if (executor == null) {
                    executor = this.f21280a.mo24772a();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f21284e);
                arrayList.add(this.f21280a.mo24773a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f21283d.size() + 1);
                arrayList2.add(new C5872a());
                arrayList2.addAll(this.f21283d);
                return new C5885n(factory2, this.f21282c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f21286g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    C5885n(Call.Factory factory, HttpUrl httpUrl, List<InterfaceC5876e.a> list, List<InterfaceC5874c.a> list2, @Nullable Executor executor, boolean z) {
        this.f21271b = factory;
        this.f21272c = httpUrl;
        this.f21273d = list;
        this.f21274e = list2;
        this.f21275f = executor;
        this.f21276g = z;
    }

    /* renamed from: b */
    private void m24798b(Class<?> cls) {
        C5882k m24770c = C5882k.m24770c();
        for (Method method : cls.getDeclaredMethods()) {
            if (!m24770c.mo24774a(method)) {
                m24805a(method);
            }
        }
    }

    /* renamed from: a */
    public <T> T m24799a(Class<T> cls) {
        C5887p.m24851a((Class) cls);
        if (this.f21276g) {
            m24798b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    /* renamed from: c */
    public Call.Factory m24810c() {
        return this.f21271b;
    }

    @Nullable
    /* renamed from: d */
    public Executor m24811d() {
        return this.f21275f;
    }

    /* renamed from: e */
    public List<InterfaceC5876e.a> m24812e() {
        return this.f21273d;
    }

    /* renamed from: f */
    public b m24813f() {
        return new b(this);
    }

    /* renamed from: c */
    public <T> InterfaceC5876e<T, String> m24809c(Type type, Annotation[] annotationArr) {
        C5887p.m24845a(type, "type == null");
        C5887p.m24845a(annotationArr, "annotations == null");
        int size = this.f21273d.size();
        for (int i2 = 0; i2 < size; i2++) {
            InterfaceC5876e<T, String> interfaceC5876e = (InterfaceC5876e<T, String>) this.f21273d.get(i2).m24755b(type, annotationArr, this);
            if (interfaceC5876e != null) {
                return interfaceC5876e;
            }
        }
        return C5872a.d.f21195a;
    }

    /* renamed from: a */
    C5886o<?, ?> m24805a(Method method) {
        C5886o c5886o;
        C5886o<?, ?> c5886o2 = this.f21270a.get(method);
        if (c5886o2 != null) {
            return c5886o2;
        }
        synchronized (this.f21270a) {
            c5886o = this.f21270a.get(method);
            if (c5886o == null) {
                c5886o = new C5886o.a(this, method).m24842a();
                this.f21270a.put(method, c5886o);
            }
        }
        return c5886o;
    }

    /* renamed from: b */
    public List<InterfaceC5874c.a> m24807b() {
        return this.f21274e;
    }

    /* renamed from: b */
    public <T> InterfaceC5876e<ResponseBody, T> m24808b(Type type, Annotation[] annotationArr) {
        return m24803a((InterfaceC5876e.a) null, type, annotationArr);
    }

    /* renamed from: a */
    public HttpUrl m24806a() {
        return this.f21272c;
    }

    /* renamed from: a */
    public InterfaceC5874c<?, ?> m24800a(Type type, Annotation[] annotationArr) {
        return m24801a((InterfaceC5874c.a) null, type, annotationArr);
    }

    /* renamed from: a */
    public InterfaceC5874c<?, ?> m24801a(@Nullable InterfaceC5874c.a aVar, Type type, Annotation[] annotationArr) {
        C5887p.m24845a(type, "returnType == null");
        C5887p.m24845a(annotationArr, "annotations == null");
        int indexOf = this.f21274e.indexOf(aVar) + 1;
        int size = this.f21274e.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            InterfaceC5874c<?, ?> mo24752a = this.f21274e.get(i2).mo24752a(type, annotationArr, this);
            if (mo24752a != null) {
                return mo24752a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f21274e.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f21274e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f21274e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public <T> InterfaceC5876e<T, RequestBody> m24802a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return m24804a(null, type, annotationArr, annotationArr2);
    }

    /* renamed from: a */
    public <T> InterfaceC5876e<T, RequestBody> m24804a(@Nullable InterfaceC5876e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        C5887p.m24845a(type, "type == null");
        C5887p.m24845a(annotationArr, "parameterAnnotations == null");
        C5887p.m24845a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f21273d.indexOf(aVar) + 1;
        int size = this.f21273d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            InterfaceC5876e<T, RequestBody> interfaceC5876e = (InterfaceC5876e<T, RequestBody>) this.f21273d.get(i2).mo24745a(type, annotationArr, annotationArr2, this);
            if (interfaceC5876e != null) {
                return interfaceC5876e;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f21273d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f21273d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f21273d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public <T> InterfaceC5876e<ResponseBody, T> m24803a(@Nullable InterfaceC5876e.a aVar, Type type, Annotation[] annotationArr) {
        C5887p.m24845a(type, "type == null");
        C5887p.m24845a(annotationArr, "annotations == null");
        int indexOf = this.f21273d.indexOf(aVar) + 1;
        int size = this.f21273d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            InterfaceC5876e<ResponseBody, T> interfaceC5876e = (InterfaceC5876e<ResponseBody, T>) this.f21273d.get(i2).mo24744a(type, annotationArr, this);
            if (interfaceC5876e != null) {
                return interfaceC5876e;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f21273d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f21273d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f21273d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
