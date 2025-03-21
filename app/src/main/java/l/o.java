package l;

import anet.channel.request.Request;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import l.j;
import l.s.q;
import l.s.r;
import l.s.s;
import l.s.u;
import l.s.v;
import l.s.x;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: ServiceMethod.java */
/* loaded from: classes2.dex */
final class o<R, T> {

    /* renamed from: a, reason: collision with root package name */
    private final Call.Factory f17179a;

    /* renamed from: b, reason: collision with root package name */
    private final c<R, T> f17180b;

    /* renamed from: c, reason: collision with root package name */
    private final HttpUrl f17181c;

    /* renamed from: d, reason: collision with root package name */
    private final e<ResponseBody, R> f17182d;

    /* renamed from: e, reason: collision with root package name */
    private final String f17183e;

    /* renamed from: f, reason: collision with root package name */
    private final String f17184f;

    /* renamed from: g, reason: collision with root package name */
    private final Headers f17185g;

    /* renamed from: h, reason: collision with root package name */
    private final MediaType f17186h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f17187i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f17188j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f17189k;

    /* renamed from: l, reason: collision with root package name */
    private final j<?>[] f17190l;
    static final Pattern n = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: m, reason: collision with root package name */
    static final String f17178m = "[a-zA-Z][a-zA-Z0-9_-]*";
    static final Pattern o = Pattern.compile(f17178m);

    o(a<R, T> aVar) {
        this.f17179a = aVar.f17191a.c();
        this.f17180b = aVar.w;
        this.f17181c = aVar.f17191a.a();
        this.f17182d = aVar.v;
        this.f17183e = aVar.f17203m;
        this.f17184f = aVar.q;
        this.f17185g = aVar.r;
        this.f17186h = aVar.s;
        this.f17187i = aVar.n;
        this.f17188j = aVar.o;
        this.f17189k = aVar.p;
        this.f17190l = aVar.u;
    }

    Call a(@Nullable Object... objArr) throws IOException {
        l lVar = new l(this.f17183e, this.f17181c, this.f17184f, this.f17185g, this.f17186h, this.f17187i, this.f17188j, this.f17189k);
        j<?>[] jVarArr = this.f17190l;
        int length = objArr != null ? objArr.length : 0;
        if (length == jVarArr.length) {
            for (int i2 = 0; i2 < length; i2++) {
                jVarArr[i2].a(lVar, objArr[i2]);
            }
            return this.f17179a.newCall(lVar.a());
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + jVarArr.length + ")");
    }

    T a(b<R> bVar) {
        return this.f17180b.a(bVar);
    }

    R a(ResponseBody responseBody) throws IOException {
        return this.f17182d.a(responseBody);
    }

    static Set<String> a(String str) {
        Matcher matcher = n.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    static Class<?> a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    /* compiled from: ServiceMethod.java */
    static final class a<T, R> {

        /* renamed from: a, reason: collision with root package name */
        final n f17191a;

        /* renamed from: b, reason: collision with root package name */
        final Method f17192b;

        /* renamed from: c, reason: collision with root package name */
        final Annotation[] f17193c;

        /* renamed from: d, reason: collision with root package name */
        final Annotation[][] f17194d;

        /* renamed from: e, reason: collision with root package name */
        final Type[] f17195e;

        /* renamed from: f, reason: collision with root package name */
        Type f17196f;

        /* renamed from: g, reason: collision with root package name */
        boolean f17197g;

        /* renamed from: h, reason: collision with root package name */
        boolean f17198h;

        /* renamed from: i, reason: collision with root package name */
        boolean f17199i;

        /* renamed from: j, reason: collision with root package name */
        boolean f17200j;

        /* renamed from: k, reason: collision with root package name */
        boolean f17201k;

        /* renamed from: l, reason: collision with root package name */
        boolean f17202l;

        /* renamed from: m, reason: collision with root package name */
        String f17203m;
        boolean n;
        boolean o;
        boolean p;
        String q;
        Headers r;
        MediaType s;
        Set<String> t;
        j<?>[] u;
        e<ResponseBody, T> v;
        c<T, R> w;

        a(n nVar, Method method) {
            this.f17191a = nVar;
            this.f17192b = method;
            this.f17193c = method.getAnnotations();
            this.f17195e = method.getGenericParameterTypes();
            this.f17194d = method.getParameterAnnotations();
        }

        private c<T, R> b() {
            Type genericReturnType = this.f17192b.getGenericReturnType();
            if (p.d(genericReturnType)) {
                throw a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw a("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (c<T, R>) this.f17191a.a(genericReturnType, this.f17192b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a(e2, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        private e<ResponseBody, T> c() {
            try {
                return this.f17191a.b(this.f17196f, this.f17192b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a(e2, "Unable to create converter for %s", this.f17196f);
            }
        }

        public o a() {
            this.w = b();
            this.f17196f = this.w.a();
            Type type = this.f17196f;
            if (type == m.class || type == Response.class) {
                throw a("'" + p.c(this.f17196f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.v = c();
            for (Annotation annotation : this.f17193c) {
                a(annotation);
            }
            if (this.f17203m == null) {
                throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.n) {
                if (this.p) {
                    throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.o) {
                    throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f17194d.length;
            this.u = new j[length];
            for (int i2 = 0; i2 < length; i2++) {
                Type type2 = this.f17195e[i2];
                if (p.d(type2)) {
                    throw a(i2, "Parameter type must not include a type variable or wildcard: %s", type2);
                }
                Annotation[] annotationArr = this.f17194d[i2];
                if (annotationArr == null) {
                    throw a(i2, "No Retrofit annotation found.", new Object[0]);
                }
                this.u[i2] = a(i2, type2, annotationArr);
            }
            if (this.q == null && !this.f17202l) {
                throw a("Missing either @%s URL or @Url parameter.", this.f17203m);
            }
            if (!this.o && !this.p && !this.n && this.f17199i) {
                throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (this.o && !this.f17197g) {
                throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.p || this.f17198h) {
                return new o(this);
            }
            throw a("Multipart method must contain at least one @Part.", new Object[0]);
        }

        private void a(Annotation annotation) {
            if (annotation instanceof l.s.b) {
                a(Request.Method.DELETE, ((l.s.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof l.s.f) {
                a("GET", ((l.s.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof l.s.g) {
                a(Request.Method.HEAD, ((l.s.g) annotation).value(), false);
                if (!Void.class.equals(this.f17196f)) {
                    throw a("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof l.s.n) {
                a("PATCH", ((l.s.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof l.s.o) {
                a("POST", ((l.s.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof l.s.p) {
                a(Request.Method.PUT, ((l.s.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof l.s.m) {
                a(Request.Method.OPTION, ((l.s.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof l.s.h) {
                l.s.h hVar = (l.s.h) annotation;
                a(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof l.s.k) {
                String[] value = ((l.s.k) annotation).value();
                if (value.length != 0) {
                    this.r = a(value);
                    return;
                }
                throw a("@Headers annotation is empty.", new Object[0]);
            }
            if (annotation instanceof l.s.l) {
                if (!this.o) {
                    this.p = true;
                    return;
                }
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            }
            if (annotation instanceof l.s.e) {
                if (!this.p) {
                    this.o = true;
                    return;
                }
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.f17203m;
            if (str3 == null) {
                this.f17203m = str;
                this.n = z;
                if (str2.isEmpty()) {
                    return;
                }
                int indexOf = str2.indexOf(63);
                if (indexOf != -1 && indexOf < str2.length() - 1) {
                    String substring = str2.substring(indexOf + 1);
                    if (o.n.matcher(substring).find()) {
                        throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                    }
                }
                this.q = str2;
                this.t = o.a(str2);
                return;
            }
            throw a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private Headers a(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf != -1 && indexOf != 0 && indexOf != str.length() - 1) {
                    String substring = str.substring(0, indexOf);
                    String trim = str.substring(indexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(substring)) {
                        MediaType parse = MediaType.parse(trim);
                        if (parse != null) {
                            this.s = parse;
                        } else {
                            throw a("Malformed content type: %s", trim);
                        }
                    } else {
                        builder.add(substring, trim);
                    }
                } else {
                    throw a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
            }
            return builder.build();
        }

        private j<?> a(int i2, Type type, Annotation[] annotationArr) {
            j<?> jVar = null;
            for (Annotation annotation : annotationArr) {
                j<?> a2 = a(i2, type, annotationArr, annotation);
                if (a2 != null) {
                    if (jVar != null) {
                        throw a(i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    jVar = a2;
                }
            }
            if (jVar != null) {
                return jVar;
            }
            throw a(i2, "No Retrofit annotation found.", new Object[0]);
        }

        private j<?> a(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof x) {
                if (!this.f17202l) {
                    if (!this.f17200j) {
                        if (!this.f17201k) {
                            if (this.q != null) {
                                throw a(i2, "@Url cannot be used with @%s URL", this.f17203m);
                            }
                            this.f17202l = true;
                            if (type != HttpUrl.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                throw a(i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                            }
                            return new j.o();
                        }
                        throw a(i2, "A @Url parameter must not come after a @Query", new Object[0]);
                    }
                    throw a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw a(i2, "Multiple @Url method annotations found.", new Object[0]);
            }
            if (annotation instanceof s) {
                if (!this.f17201k) {
                    if (!this.f17202l) {
                        if (this.q == null) {
                            throw a(i2, "@Path can only be used with relative url on @%s", this.f17203m);
                        }
                        this.f17200j = true;
                        s sVar = (s) annotation;
                        String value = sVar.value();
                        a(i2, value);
                        return new j.C0271j(value, this.f17191a.c(type, annotationArr), sVar.encoded());
                    }
                    throw a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw a(i2, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (annotation instanceof l.s.t) {
                l.s.t tVar = (l.s.t) annotation;
                String value2 = tVar.value();
                boolean encoded = tVar.encoded();
                Class<?> c2 = p.c(type);
                this.f17201k = true;
                if (Iterable.class.isAssignableFrom(c2)) {
                    if (type instanceof ParameterizedType) {
                        return new j.k(value2, this.f17191a.c(p.a(0, (ParameterizedType) type), annotationArr), encoded).b();
                    }
                    throw a(i2, c2.getSimpleName() + " must include generic type (e.g., " + c2.getSimpleName() + "<String>)", new Object[0]);
                }
                if (c2.isArray()) {
                    return new j.k(value2, this.f17191a.c(o.a(c2.getComponentType()), annotationArr), encoded).a();
                }
                return new j.k(value2, this.f17191a.c(type, annotationArr), encoded);
            }
            if (annotation instanceof v) {
                boolean encoded2 = ((v) annotation).encoded();
                Class<?> c3 = p.c(type);
                this.f17201k = true;
                if (Iterable.class.isAssignableFrom(c3)) {
                    if (type instanceof ParameterizedType) {
                        return new j.m(this.f17191a.c(p.a(0, (ParameterizedType) type), annotationArr), encoded2).b();
                    }
                    throw a(i2, c3.getSimpleName() + " must include generic type (e.g., " + c3.getSimpleName() + "<String>)", new Object[0]);
                }
                if (c3.isArray()) {
                    return new j.m(this.f17191a.c(o.a(c3.getComponentType()), annotationArr), encoded2).a();
                }
                return new j.m(this.f17191a.c(type, annotationArr), encoded2);
            }
            if (annotation instanceof u) {
                Class<?> c4 = p.c(type);
                if (Map.class.isAssignableFrom(c4)) {
                    Type b2 = p.b(type, c4, Map.class);
                    if (b2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) b2;
                        Type a2 = p.a(0, parameterizedType);
                        if (String.class == a2) {
                            return new j.l(this.f17191a.c(p.a(1, parameterizedType), annotationArr), ((u) annotation).encoded());
                        }
                        throw a(i2, "@QueryMap keys must be of type String: " + a2, new Object[0]);
                    }
                    throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i2, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof l.s.i) {
                String value3 = ((l.s.i) annotation).value();
                Class<?> c5 = p.c(type);
                if (Iterable.class.isAssignableFrom(c5)) {
                    if (type instanceof ParameterizedType) {
                        return new j.f(value3, this.f17191a.c(p.a(0, (ParameterizedType) type), annotationArr)).b();
                    }
                    throw a(i2, c5.getSimpleName() + " must include generic type (e.g., " + c5.getSimpleName() + "<String>)", new Object[0]);
                }
                if (c5.isArray()) {
                    return new j.f(value3, this.f17191a.c(o.a(c5.getComponentType()), annotationArr)).a();
                }
                return new j.f(value3, this.f17191a.c(type, annotationArr));
            }
            if (annotation instanceof l.s.j) {
                Class<?> c6 = p.c(type);
                if (Map.class.isAssignableFrom(c6)) {
                    Type b3 = p.b(type, c6, Map.class);
                    if (b3 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) b3;
                        Type a3 = p.a(0, parameterizedType2);
                        if (String.class == a3) {
                            return new j.g(this.f17191a.c(p.a(1, parameterizedType2), annotationArr));
                        }
                        throw a(i2, "@HeaderMap keys must be of type String: " + a3, new Object[0]);
                    }
                    throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i2, "@HeaderMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof l.s.c) {
                if (this.o) {
                    l.s.c cVar = (l.s.c) annotation;
                    String value4 = cVar.value();
                    boolean encoded3 = cVar.encoded();
                    this.f17197g = true;
                    Class<?> c7 = p.c(type);
                    if (Iterable.class.isAssignableFrom(c7)) {
                        if (type instanceof ParameterizedType) {
                            return new j.d(value4, this.f17191a.c(p.a(0, (ParameterizedType) type), annotationArr), encoded3).b();
                        }
                        throw a(i2, c7.getSimpleName() + " must include generic type (e.g., " + c7.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (c7.isArray()) {
                        return new j.d(value4, this.f17191a.c(o.a(c7.getComponentType()), annotationArr), encoded3).a();
                    }
                    return new j.d(value4, this.f17191a.c(type, annotationArr), encoded3);
                }
                throw a(i2, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof l.s.d) {
                if (this.o) {
                    Class<?> c8 = p.c(type);
                    if (Map.class.isAssignableFrom(c8)) {
                        Type b4 = p.b(type, c8, Map.class);
                        if (b4 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) b4;
                            Type a4 = p.a(0, parameterizedType3);
                            if (String.class == a4) {
                                e<T, String> c9 = this.f17191a.c(p.a(1, parameterizedType3), annotationArr);
                                this.f17197g = true;
                                return new j.e(c9, ((l.s.d) annotation).encoded());
                            }
                            throw a(i2, "@FieldMap keys must be of type String: " + a4, new Object[0]);
                        }
                        throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw a(i2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw a(i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof q) {
                if (this.p) {
                    q qVar = (q) annotation;
                    this.f17198h = true;
                    String value5 = qVar.value();
                    Class<?> c10 = p.c(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(c10)) {
                            if (type instanceof ParameterizedType) {
                                if (MultipartBody.Part.class.isAssignableFrom(p.c(p.a(0, (ParameterizedType) type)))) {
                                    return j.n.f17141a.b();
                                }
                                throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw a(i2, c10.getSimpleName() + " must include generic type (e.g., " + c10.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (c10.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(c10.getComponentType())) {
                                return j.n.f17141a.a();
                            }
                            throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(c10)) {
                            return j.n.f17141a;
                        }
                        throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    Headers of = Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                    if (Iterable.class.isAssignableFrom(c10)) {
                        if (type instanceof ParameterizedType) {
                            Type a5 = p.a(0, (ParameterizedType) type);
                            if (!MultipartBody.Part.class.isAssignableFrom(p.c(a5))) {
                                return new j.h(of, this.f17191a.a(a5, annotationArr, this.f17193c)).b();
                            }
                            throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw a(i2, c10.getSimpleName() + " must include generic type (e.g., " + c10.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (c10.isArray()) {
                        Class<?> a6 = o.a(c10.getComponentType());
                        if (!MultipartBody.Part.class.isAssignableFrom(a6)) {
                            return new j.h(of, this.f17191a.a(a6, annotationArr, this.f17193c)).a();
                        }
                        throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    if (!MultipartBody.Part.class.isAssignableFrom(c10)) {
                        return new j.h(of, this.f17191a.a(type, annotationArr, this.f17193c));
                    }
                    throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                throw a(i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof r) {
                if (this.p) {
                    this.f17198h = true;
                    Class<?> c11 = p.c(type);
                    if (Map.class.isAssignableFrom(c11)) {
                        Type b5 = p.b(type, c11, Map.class);
                        if (b5 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) b5;
                            Type a7 = p.a(0, parameterizedType4);
                            if (String.class == a7) {
                                Type a8 = p.a(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(p.c(a8))) {
                                    return new j.i(this.f17191a.a(a8, annotationArr, this.f17193c), ((r) annotation).encoding());
                                }
                                throw a(i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw a(i2, "@PartMap keys must be of type String: " + a7, new Object[0]);
                        }
                        throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw a(i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw a(i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (!(annotation instanceof l.s.a)) {
                return null;
            }
            if (!this.o && !this.p) {
                if (!this.f17199i) {
                    try {
                        e<T, RequestBody> a9 = this.f17191a.a(type, annotationArr, this.f17193c);
                        this.f17199i = true;
                        return new j.c(a9);
                    } catch (RuntimeException e2) {
                        throw a(e2, i2, "Unable to create @Body converter for %s", type);
                    }
                }
                throw a(i2, "Multiple @Body method annotations found.", new Object[0]);
            }
            throw a(i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        }

        private void a(int i2, String str) {
            if (o.o.matcher(str).matches()) {
                if (!this.t.contains(str)) {
                    throw a(i2, "URL \"%s\" does not contain \"{%s}\".", this.q, str);
                }
                return;
            }
            throw a(i2, "@Path parameter name must match %s. Found: %s", o.n.pattern(), str);
        }

        private RuntimeException a(String str, Object... objArr) {
            return a((Throwable) null, str, objArr);
        }

        private RuntimeException a(Throwable th, String str, Object... objArr) {
            return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.f17192b.getDeclaringClass().getSimpleName() + "." + this.f17192b.getName(), th);
        }

        private RuntimeException a(Throwable th, int i2, String str, Object... objArr) {
            return a(th, str + " (parameter #" + (i2 + 1) + ")", objArr);
        }

        private RuntimeException a(int i2, String str, Object... objArr) {
            return a(str + " (parameter #" + (i2 + 1) + ")", objArr);
        }
    }
}
