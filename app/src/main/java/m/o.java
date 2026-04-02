package m;

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
import m.j;
import m.s.q;
import m.s.r;
import m.s.s;
import m.s.u;
import m.s.v;
import m.s.x;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ServiceMethod.java */
/* JADX INFO: loaded from: classes2.dex */
final class o<R, T> {
    private final Call.Factory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<R, T> f12764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HttpUrl f12765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e<ResponseBody, R> f12766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f12767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f12768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Headers f12769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MediaType f12770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f12771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f12772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f12773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final j<?>[] f12774l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final Pattern f12763n = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final String f12762m = "[a-zA-Z][a-zA-Z0-9_-]*";
    static final Pattern o = Pattern.compile(f12762m);

    o(a<R, T> aVar) {
        this.a = aVar.a.c();
        this.f12764b = aVar.w;
        this.f12765c = aVar.a.a();
        this.f12766d = aVar.v;
        this.f12767e = aVar.f12786m;
        this.f12768f = aVar.q;
        this.f12769g = aVar.r;
        this.f12770h = aVar.s;
        this.f12771i = aVar.f12787n;
        this.f12772j = aVar.o;
        this.f12773k = aVar.p;
        this.f12774l = aVar.u;
    }

    Call a(@Nullable Object... objArr) throws IOException {
        l lVar = new l(this.f12767e, this.f12765c, this.f12768f, this.f12769g, this.f12770h, this.f12771i, this.f12772j, this.f12773k);
        j<?>[] jVarArr = this.f12774l;
        int length = objArr != null ? objArr.length : 0;
        if (length == jVarArr.length) {
            for (int i2 = 0; i2 < length; i2++) {
                jVarArr[i2].a(lVar, objArr[i2]);
            }
            return this.a.newCall(lVar.a());
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + jVarArr.length + ")");
    }

    T a(b<R> bVar) {
        return this.f12764b.a(bVar);
    }

    R a(ResponseBody responseBody) throws IOException {
        return this.f12766d.a(responseBody);
    }

    static Set<String> a(String str) {
        Matcher matcher = f12763n.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    static Class<?> a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    /* JADX INFO: compiled from: ServiceMethod.java */
    static final class a<T, R> {
        final n a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f12775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Annotation[] f12776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[][] f12777d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Type[] f12778e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Type f12779f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f12780g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f12781h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f12782i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f12783j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f12784k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f12785l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        String f12786m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f12787n;
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
            this.a = nVar;
            this.f12775b = method;
            this.f12776c = method.getAnnotations();
            this.f12778e = method.getGenericParameterTypes();
            this.f12777d = method.getParameterAnnotations();
        }

        private c<T, R> b() {
            Type genericReturnType = this.f12775b.getGenericReturnType();
            if (p.d(genericReturnType)) {
                throw a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw a("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (c<T, R>) this.a.a(genericReturnType, this.f12775b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a(e2, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        private e<ResponseBody, T> c() {
            try {
                return this.a.b(this.f12779f, this.f12775b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a(e2, "Unable to create converter for %s", this.f12779f);
            }
        }

        public o a() {
            this.w = b();
            this.f12779f = this.w.a();
            Type type = this.f12779f;
            if (type == m.class || type == Response.class) {
                throw a("'" + p.c(this.f12779f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.v = c();
            for (Annotation annotation : this.f12776c) {
                a(annotation);
            }
            if (this.f12786m == null) {
                throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f12787n) {
                if (this.p) {
                    throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.o) {
                    throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f12777d.length;
            this.u = new j[length];
            for (int i2 = 0; i2 < length; i2++) {
                Type type2 = this.f12778e[i2];
                if (p.d(type2)) {
                    throw a(i2, "Parameter type must not include a type variable or wildcard: %s", type2);
                }
                Annotation[] annotationArr = this.f12777d[i2];
                if (annotationArr == null) {
                    throw a(i2, "No Retrofit annotation found.", new Object[0]);
                }
                this.u[i2] = a(i2, type2, annotationArr);
            }
            if (this.q == null && !this.f12785l) {
                throw a("Missing either @%s URL or @Url parameter.", this.f12786m);
            }
            if (!this.o && !this.p && !this.f12787n && this.f12782i) {
                throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (this.o && !this.f12780g) {
                throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.p || this.f12781h) {
                return new o(this);
            }
            throw a("Multipart method must contain at least one @Part.", new Object[0]);
        }

        private void a(Annotation annotation) {
            if (annotation instanceof m.s.b) {
                a(Request.Method.DELETE, ((m.s.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof m.s.f) {
                a("GET", ((m.s.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof m.s.g) {
                a(Request.Method.HEAD, ((m.s.g) annotation).value(), false);
                if (!Void.class.equals(this.f12779f)) {
                    throw a("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof m.s.n) {
                a("PATCH", ((m.s.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof m.s.o) {
                a("POST", ((m.s.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof m.s.p) {
                a(Request.Method.PUT, ((m.s.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof m.s.m) {
                a(Request.Method.OPTION, ((m.s.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof m.s.h) {
                m.s.h hVar = (m.s.h) annotation;
                a(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof m.s.k) {
                String[] strArrValue = ((m.s.k) annotation).value();
                if (strArrValue.length != 0) {
                    this.r = a(strArrValue);
                    return;
                }
                throw a("@Headers annotation is empty.", new Object[0]);
            }
            if (annotation instanceof m.s.l) {
                if (!this.o) {
                    this.p = true;
                    return;
                }
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            }
            if (annotation instanceof m.s.e) {
                if (!this.p) {
                    this.o = true;
                    return;
                }
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.f12786m;
            if (str3 == null) {
                this.f12786m = str;
                this.f12787n = z;
                if (str2.isEmpty()) {
                    return;
                }
                int iIndexOf = str2.indexOf(63);
                if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                    String strSubstring = str2.substring(iIndexOf + 1);
                    if (o.f12763n.matcher(strSubstring).find()) {
                        throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
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
                int iIndexOf = str.indexOf(58);
                if (iIndexOf != -1 && iIndexOf != 0 && iIndexOf != str.length() - 1) {
                    String strSubstring = str.substring(0, iIndexOf);
                    String strTrim = str.substring(iIndexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                        MediaType mediaType = MediaType.parse(strTrim);
                        if (mediaType != null) {
                            this.s = mediaType;
                        } else {
                            throw a("Malformed content type: %s", strTrim);
                        }
                    } else {
                        builder.add(strSubstring, strTrim);
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
                j<?> jVarA = a(i2, type, annotationArr, annotation);
                if (jVarA != null) {
                    if (jVar != null) {
                        throw a(i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    jVar = jVarA;
                }
            }
            if (jVar != null) {
                return jVar;
            }
            throw a(i2, "No Retrofit annotation found.", new Object[0]);
        }

        private j<?> a(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof x) {
                if (!this.f12785l) {
                    if (!this.f12783j) {
                        if (!this.f12784k) {
                            if (this.q != null) {
                                throw a(i2, "@Url cannot be used with @%s URL", this.f12786m);
                            }
                            this.f12785l = true;
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
                if (!this.f12784k) {
                    if (!this.f12785l) {
                        if (this.q == null) {
                            throw a(i2, "@Path can only be used with relative url on @%s", this.f12786m);
                        }
                        this.f12783j = true;
                        s sVar = (s) annotation;
                        String strValue = sVar.value();
                        a(i2, strValue);
                        return new j.C0272j(strValue, this.a.c(type, annotationArr), sVar.encoded());
                    }
                    throw a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw a(i2, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (annotation instanceof m.s.t) {
                m.s.t tVar = (m.s.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsC = p.c(type);
                this.f12784k = true;
                if (Iterable.class.isAssignableFrom(clsC)) {
                    if (type instanceof ParameterizedType) {
                        return new j.k(strValue2, this.a.c(p.a(0, (ParameterizedType) type), annotationArr), zEncoded).b();
                    }
                    throw a(i2, clsC.getSimpleName() + " must include generic type (e.g., " + clsC.getSimpleName() + "<String>)", new Object[0]);
                }
                if (clsC.isArray()) {
                    return new j.k(strValue2, this.a.c(o.a(clsC.getComponentType()), annotationArr), zEncoded).a();
                }
                return new j.k(strValue2, this.a.c(type, annotationArr), zEncoded);
            }
            if (annotation instanceof v) {
                boolean zEncoded2 = ((v) annotation).encoded();
                Class<?> clsC2 = p.c(type);
                this.f12784k = true;
                if (Iterable.class.isAssignableFrom(clsC2)) {
                    if (type instanceof ParameterizedType) {
                        return new j.m(this.a.c(p.a(0, (ParameterizedType) type), annotationArr), zEncoded2).b();
                    }
                    throw a(i2, clsC2.getSimpleName() + " must include generic type (e.g., " + clsC2.getSimpleName() + "<String>)", new Object[0]);
                }
                if (clsC2.isArray()) {
                    return new j.m(this.a.c(o.a(clsC2.getComponentType()), annotationArr), zEncoded2).a();
                }
                return new j.m(this.a.c(type, annotationArr), zEncoded2);
            }
            if (annotation instanceof u) {
                Class<?> clsC3 = p.c(type);
                if (Map.class.isAssignableFrom(clsC3)) {
                    Type typeB = p.b(type, clsC3, Map.class);
                    if (typeB instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) typeB;
                        Type typeA = p.a(0, parameterizedType);
                        if (String.class == typeA) {
                            return new j.l(this.a.c(p.a(1, parameterizedType), annotationArr), ((u) annotation).encoded());
                        }
                        throw a(i2, "@QueryMap keys must be of type String: " + typeA, new Object[0]);
                    }
                    throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i2, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof m.s.i) {
                String strValue3 = ((m.s.i) annotation).value();
                Class<?> clsC4 = p.c(type);
                if (Iterable.class.isAssignableFrom(clsC4)) {
                    if (type instanceof ParameterizedType) {
                        return new j.f(strValue3, this.a.c(p.a(0, (ParameterizedType) type), annotationArr)).b();
                    }
                    throw a(i2, clsC4.getSimpleName() + " must include generic type (e.g., " + clsC4.getSimpleName() + "<String>)", new Object[0]);
                }
                if (clsC4.isArray()) {
                    return new j.f(strValue3, this.a.c(o.a(clsC4.getComponentType()), annotationArr)).a();
                }
                return new j.f(strValue3, this.a.c(type, annotationArr));
            }
            if (annotation instanceof m.s.j) {
                Class<?> clsC5 = p.c(type);
                if (Map.class.isAssignableFrom(clsC5)) {
                    Type typeB2 = p.b(type, clsC5, Map.class);
                    if (typeB2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) typeB2;
                        Type typeA2 = p.a(0, parameterizedType2);
                        if (String.class == typeA2) {
                            return new j.g(this.a.c(p.a(1, parameterizedType2), annotationArr));
                        }
                        throw a(i2, "@HeaderMap keys must be of type String: " + typeA2, new Object[0]);
                    }
                    throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i2, "@HeaderMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof m.s.c) {
                if (this.o) {
                    m.s.c cVar = (m.s.c) annotation;
                    String strValue4 = cVar.value();
                    boolean zEncoded3 = cVar.encoded();
                    this.f12780g = true;
                    Class<?> clsC6 = p.c(type);
                    if (Iterable.class.isAssignableFrom(clsC6)) {
                        if (type instanceof ParameterizedType) {
                            return new j.d(strValue4, this.a.c(p.a(0, (ParameterizedType) type), annotationArr), zEncoded3).b();
                        }
                        throw a(i2, clsC6.getSimpleName() + " must include generic type (e.g., " + clsC6.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (clsC6.isArray()) {
                        return new j.d(strValue4, this.a.c(o.a(clsC6.getComponentType()), annotationArr), zEncoded3).a();
                    }
                    return new j.d(strValue4, this.a.c(type, annotationArr), zEncoded3);
                }
                throw a(i2, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof m.s.d) {
                if (this.o) {
                    Class<?> clsC7 = p.c(type);
                    if (Map.class.isAssignableFrom(clsC7)) {
                        Type typeB3 = p.b(type, clsC7, Map.class);
                        if (typeB3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) typeB3;
                            Type typeA3 = p.a(0, parameterizedType3);
                            if (String.class == typeA3) {
                                e<T, String> eVarC = this.a.c(p.a(1, parameterizedType3), annotationArr);
                                this.f12780g = true;
                                return new j.e(eVarC, ((m.s.d) annotation).encoded());
                            }
                            throw a(i2, "@FieldMap keys must be of type String: " + typeA3, new Object[0]);
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
                    this.f12781h = true;
                    String strValue5 = qVar.value();
                    Class<?> clsC8 = p.c(type);
                    if (strValue5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(clsC8)) {
                            if (type instanceof ParameterizedType) {
                                if (MultipartBody.Part.class.isAssignableFrom(p.c(p.a(0, (ParameterizedType) type)))) {
                                    return j.n.a.b();
                                }
                                throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw a(i2, clsC8.getSimpleName() + " must include generic type (e.g., " + clsC8.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (clsC8.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(clsC8.getComponentType())) {
                                return j.n.a.a();
                            }
                            throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(clsC8)) {
                            return j.n.a;
                        }
                        throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    Headers headersOf = Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                    if (Iterable.class.isAssignableFrom(clsC8)) {
                        if (type instanceof ParameterizedType) {
                            Type typeA4 = p.a(0, (ParameterizedType) type);
                            if (!MultipartBody.Part.class.isAssignableFrom(p.c(typeA4))) {
                                return new j.h(headersOf, this.a.a(typeA4, annotationArr, this.f12776c)).b();
                            }
                            throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw a(i2, clsC8.getSimpleName() + " must include generic type (e.g., " + clsC8.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (clsC8.isArray()) {
                        Class<?> clsA = o.a(clsC8.getComponentType());
                        if (!MultipartBody.Part.class.isAssignableFrom(clsA)) {
                            return new j.h(headersOf, this.a.a(clsA, annotationArr, this.f12776c)).a();
                        }
                        throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    if (!MultipartBody.Part.class.isAssignableFrom(clsC8)) {
                        return new j.h(headersOf, this.a.a(type, annotationArr, this.f12776c));
                    }
                    throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                throw a(i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof r) {
                if (this.p) {
                    this.f12781h = true;
                    Class<?> clsC9 = p.c(type);
                    if (Map.class.isAssignableFrom(clsC9)) {
                        Type typeB4 = p.b(type, clsC9, Map.class);
                        if (typeB4 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) typeB4;
                            Type typeA5 = p.a(0, parameterizedType4);
                            if (String.class == typeA5) {
                                Type typeA6 = p.a(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(p.c(typeA6))) {
                                    return new j.i(this.a.a(typeA6, annotationArr, this.f12776c), ((r) annotation).encoding());
                                }
                                throw a(i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw a(i2, "@PartMap keys must be of type String: " + typeA5, new Object[0]);
                        }
                        throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw a(i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw a(i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (!(annotation instanceof m.s.a)) {
                return null;
            }
            if (!this.o && !this.p) {
                if (!this.f12782i) {
                    try {
                        e<T, RequestBody> eVarA = this.a.a(type, annotationArr, this.f12776c);
                        this.f12782i = true;
                        return new j.c(eVarA);
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
            throw a(i2, "@Path parameter name must match %s. Found: %s", o.f12763n.pattern(), str);
        }

        private RuntimeException a(String str, Object... objArr) {
            return a((Throwable) null, str, objArr);
        }

        private RuntimeException a(Throwable th, String str, Object... objArr) {
            return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.f12775b.getDeclaringClass().getSimpleName() + "." + this.f12775b.getName(), th);
        }

        private RuntimeException a(Throwable th, int i2, String str, Object... objArr) {
            return a(th, str + " (parameter #" + (i2 + 1) + ")", objArr);
        }

        private RuntimeException a(int i2, String str, Object... objArr) {
            return a(str + " (parameter #" + (i2 + 1) + ")", objArr);
        }
    }
}
