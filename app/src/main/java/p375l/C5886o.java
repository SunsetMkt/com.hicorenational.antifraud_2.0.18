package p375l;

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
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p375l.AbstractC5881j;
import p375l.p380s.InterfaceC5901a;
import p375l.p380s.InterfaceC5902b;
import p375l.p380s.InterfaceC5903c;
import p375l.p380s.InterfaceC5904d;
import p375l.p380s.InterfaceC5905e;
import p375l.p380s.InterfaceC5906f;
import p375l.p380s.InterfaceC5907g;
import p375l.p380s.InterfaceC5908h;
import p375l.p380s.InterfaceC5909i;
import p375l.p380s.InterfaceC5910j;
import p375l.p380s.InterfaceC5911k;
import p375l.p380s.InterfaceC5912l;
import p375l.p380s.InterfaceC5913m;
import p375l.p380s.InterfaceC5914n;
import p375l.p380s.InterfaceC5915o;
import p375l.p380s.InterfaceC5916p;
import p375l.p380s.InterfaceC5917q;
import p375l.p380s.InterfaceC5918r;
import p375l.p380s.InterfaceC5919s;
import p375l.p380s.InterfaceC5920t;
import p375l.p380s.InterfaceC5921u;
import p375l.p380s.InterfaceC5922v;
import p375l.p380s.InterfaceC5924x;

/* compiled from: ServiceMethod.java */
/* renamed from: l.o */
/* loaded from: classes2.dex */
final class C5886o<R, T> {

    /* renamed from: a */
    private final Call.Factory f21290a;

    /* renamed from: b */
    private final InterfaceC5874c<R, T> f21291b;

    /* renamed from: c */
    private final HttpUrl f21292c;

    /* renamed from: d */
    private final InterfaceC5876e<ResponseBody, R> f21293d;

    /* renamed from: e */
    private final String f21294e;

    /* renamed from: f */
    private final String f21295f;

    /* renamed from: g */
    private final Headers f21296g;

    /* renamed from: h */
    private final MediaType f21297h;

    /* renamed from: i */
    private final boolean f21298i;

    /* renamed from: j */
    private final boolean f21299j;

    /* renamed from: k */
    private final boolean f21300k;

    /* renamed from: l */
    private final AbstractC5881j<?>[] f21301l;

    /* renamed from: n */
    static final Pattern f21288n = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: m */
    static final String f21287m = "[a-zA-Z][a-zA-Z0-9_-]*";

    /* renamed from: o */
    static final Pattern f21289o = Pattern.compile(f21287m);

    C5886o(a<R, T> aVar) {
        this.f21290a = aVar.f21302a.m24810c();
        this.f21291b = aVar.f21324w;
        this.f21292c = aVar.f21302a.m24806a();
        this.f21293d = aVar.f21323v;
        this.f21294e = aVar.f21314m;
        this.f21295f = aVar.f21318q;
        this.f21296g = aVar.f21319r;
        this.f21297h = aVar.f21320s;
        this.f21298i = aVar.f21315n;
        this.f21299j = aVar.f21316o;
        this.f21300k = aVar.f21317p;
        this.f21301l = aVar.f21322u;
    }

    /* renamed from: a */
    Call m24829a(@Nullable Object... objArr) throws IOException {
        C5883l c5883l = new C5883l(this.f21294e, this.f21292c, this.f21295f, this.f21296g, this.f21297h, this.f21298i, this.f21299j, this.f21300k);
        AbstractC5881j<?>[] abstractC5881jArr = this.f21301l;
        int length = objArr != null ? objArr.length : 0;
        if (length == abstractC5881jArr.length) {
            for (int i2 = 0; i2 < length; i2++) {
                abstractC5881jArr[i2].mo24762a(c5883l, objArr[i2]);
            }
            return this.f21290a.newCall(c5883l.m24777a());
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + abstractC5881jArr.length + ")");
    }

    /* renamed from: a */
    T m24827a(InterfaceC5873b<R> interfaceC5873b) {
        return this.f21291b.mo24748a(interfaceC5873b);
    }

    /* renamed from: a */
    R m24828a(ResponseBody responseBody) throws IOException {
        return this.f21293d.mo24746a(responseBody);
    }

    /* renamed from: a */
    static Set<String> m24826a(String str) {
        Matcher matcher = f21288n.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    static Class<?> m24825a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    /* compiled from: ServiceMethod.java */
    /* renamed from: l.o$a */
    static final class a<T, R> {

        /* renamed from: a */
        final C5885n f21302a;

        /* renamed from: b */
        final Method f21303b;

        /* renamed from: c */
        final Annotation[] f21304c;

        /* renamed from: d */
        final Annotation[][] f21305d;

        /* renamed from: e */
        final Type[] f21306e;

        /* renamed from: f */
        Type f21307f;

        /* renamed from: g */
        boolean f21308g;

        /* renamed from: h */
        boolean f21309h;

        /* renamed from: i */
        boolean f21310i;

        /* renamed from: j */
        boolean f21311j;

        /* renamed from: k */
        boolean f21312k;

        /* renamed from: l */
        boolean f21313l;

        /* renamed from: m */
        String f21314m;

        /* renamed from: n */
        boolean f21315n;

        /* renamed from: o */
        boolean f21316o;

        /* renamed from: p */
        boolean f21317p;

        /* renamed from: q */
        String f21318q;

        /* renamed from: r */
        Headers f21319r;

        /* renamed from: s */
        MediaType f21320s;

        /* renamed from: t */
        Set<String> f21321t;

        /* renamed from: u */
        AbstractC5881j<?>[] f21322u;

        /* renamed from: v */
        InterfaceC5876e<ResponseBody, T> f21323v;

        /* renamed from: w */
        InterfaceC5874c<T, R> f21324w;

        a(C5885n c5885n, Method method) {
            this.f21302a = c5885n;
            this.f21303b = method;
            this.f21304c = method.getAnnotations();
            this.f21306e = method.getGenericParameterTypes();
            this.f21305d = method.getParameterAnnotations();
        }

        /* renamed from: b */
        private InterfaceC5874c<T, R> m24840b() {
            Type genericReturnType = this.f21303b.getGenericReturnType();
            if (C5887p.m24859d(genericReturnType)) {
                throw m24831a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw m24831a("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (InterfaceC5874c<T, R>) this.f21302a.m24800a(genericReturnType, this.f21303b.getAnnotations());
            } catch (RuntimeException e2) {
                throw m24833a(e2, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        /* renamed from: c */
        private InterfaceC5876e<ResponseBody, T> m24841c() {
            try {
                return this.f21302a.m24808b(this.f21307f, this.f21303b.getAnnotations());
            } catch (RuntimeException e2) {
                throw m24833a(e2, "Unable to create converter for %s", this.f21307f);
            }
        }

        /* renamed from: a */
        public C5886o m24842a() {
            this.f21324w = m24840b();
            this.f21307f = this.f21324w.mo24749a();
            Type type = this.f21307f;
            if (type == C5884m.class || type == Response.class) {
                throw m24831a("'" + C5887p.m24858c(this.f21307f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.f21323v = m24841c();
            for (Annotation annotation : this.f21304c) {
                m24839a(annotation);
            }
            if (this.f21314m == null) {
                throw m24831a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f21315n) {
                if (this.f21317p) {
                    throw m24831a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f21316o) {
                    throw m24831a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f21305d.length;
            this.f21322u = new AbstractC5881j[length];
            for (int i2 = 0; i2 < length; i2++) {
                Type type2 = this.f21306e[i2];
                if (C5887p.m24859d(type2)) {
                    throw m24830a(i2, "Parameter type must not include a type variable or wildcard: %s", type2);
                }
                Annotation[] annotationArr = this.f21305d[i2];
                if (annotationArr == null) {
                    throw m24830a(i2, "No Retrofit annotation found.", new Object[0]);
                }
                this.f21322u[i2] = m24834a(i2, type2, annotationArr);
            }
            if (this.f21318q == null && !this.f21313l) {
                throw m24831a("Missing either @%s URL or @Url parameter.", this.f21314m);
            }
            if (!this.f21316o && !this.f21317p && !this.f21315n && this.f21310i) {
                throw m24831a("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (this.f21316o && !this.f21308g) {
                throw m24831a("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f21317p || this.f21309h) {
                return new C5886o(this);
            }
            throw m24831a("Multipart method must contain at least one @Part.", new Object[0]);
        }

        /* renamed from: a */
        private void m24839a(Annotation annotation) {
            if (annotation instanceof InterfaceC5902b) {
                m24838a(Request.Method.DELETE, ((InterfaceC5902b) annotation).value(), false);
                return;
            }
            if (annotation instanceof InterfaceC5906f) {
                m24838a("GET", ((InterfaceC5906f) annotation).value(), false);
                return;
            }
            if (annotation instanceof InterfaceC5907g) {
                m24838a(Request.Method.HEAD, ((InterfaceC5907g) annotation).value(), false);
                if (!Void.class.equals(this.f21307f)) {
                    throw m24831a("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof InterfaceC5914n) {
                m24838a("PATCH", ((InterfaceC5914n) annotation).value(), true);
                return;
            }
            if (annotation instanceof InterfaceC5915o) {
                m24838a("POST", ((InterfaceC5915o) annotation).value(), true);
                return;
            }
            if (annotation instanceof InterfaceC5916p) {
                m24838a(Request.Method.PUT, ((InterfaceC5916p) annotation).value(), true);
                return;
            }
            if (annotation instanceof InterfaceC5913m) {
                m24838a(Request.Method.OPTION, ((InterfaceC5913m) annotation).value(), false);
                return;
            }
            if (annotation instanceof InterfaceC5908h) {
                InterfaceC5908h interfaceC5908h = (InterfaceC5908h) annotation;
                m24838a(interfaceC5908h.method(), interfaceC5908h.path(), interfaceC5908h.hasBody());
                return;
            }
            if (annotation instanceof InterfaceC5911k) {
                String[] value = ((InterfaceC5911k) annotation).value();
                if (value.length != 0) {
                    this.f21319r = m24836a(value);
                    return;
                }
                throw m24831a("@Headers annotation is empty.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5912l) {
                if (!this.f21316o) {
                    this.f21317p = true;
                    return;
                }
                throw m24831a("Only one encoding annotation is allowed.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5905e) {
                if (!this.f21317p) {
                    this.f21316o = true;
                    return;
                }
                throw m24831a("Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        /* renamed from: a */
        private void m24838a(String str, String str2, boolean z) {
            String str3 = this.f21314m;
            if (str3 == null) {
                this.f21314m = str;
                this.f21315n = z;
                if (str2.isEmpty()) {
                    return;
                }
                int indexOf = str2.indexOf(63);
                if (indexOf != -1 && indexOf < str2.length() - 1) {
                    String substring = str2.substring(indexOf + 1);
                    if (C5886o.f21288n.matcher(substring).find()) {
                        throw m24831a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                    }
                }
                this.f21318q = str2;
                this.f21321t = C5886o.m24826a(str2);
                return;
            }
            throw m24831a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        /* renamed from: a */
        private Headers m24836a(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf != -1 && indexOf != 0 && indexOf != str.length() - 1) {
                    String substring = str.substring(0, indexOf);
                    String trim = str.substring(indexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(substring)) {
                        MediaType parse = MediaType.parse(trim);
                        if (parse != null) {
                            this.f21320s = parse;
                        } else {
                            throw m24831a("Malformed content type: %s", trim);
                        }
                    } else {
                        builder.add(substring, trim);
                    }
                } else {
                    throw m24831a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
            }
            return builder.build();
        }

        /* renamed from: a */
        private AbstractC5881j<?> m24834a(int i2, Type type, Annotation[] annotationArr) {
            AbstractC5881j<?> abstractC5881j = null;
            for (Annotation annotation : annotationArr) {
                AbstractC5881j<?> m24835a = m24835a(i2, type, annotationArr, annotation);
                if (m24835a != null) {
                    if (abstractC5881j != null) {
                        throw m24830a(i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    abstractC5881j = m24835a;
                }
            }
            if (abstractC5881j != null) {
                return abstractC5881j;
            }
            throw m24830a(i2, "No Retrofit annotation found.", new Object[0]);
        }

        /* renamed from: a */
        private AbstractC5881j<?> m24835a(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof InterfaceC5924x) {
                if (!this.f21313l) {
                    if (!this.f21311j) {
                        if (!this.f21312k) {
                            if (this.f21318q != null) {
                                throw m24830a(i2, "@Url cannot be used with @%s URL", this.f21314m);
                            }
                            this.f21313l = true;
                            if (type != HttpUrl.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                throw m24830a(i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                            }
                            return new AbstractC5881j.o();
                        }
                        throw m24830a(i2, "A @Url parameter must not come after a @Query", new Object[0]);
                    }
                    throw m24830a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw m24830a(i2, "Multiple @Url method annotations found.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5919s) {
                if (!this.f21312k) {
                    if (!this.f21313l) {
                        if (this.f21318q == null) {
                            throw m24830a(i2, "@Path can only be used with relative url on @%s", this.f21314m);
                        }
                        this.f21311j = true;
                        InterfaceC5919s interfaceC5919s = (InterfaceC5919s) annotation;
                        String value = interfaceC5919s.value();
                        m24837a(i2, value);
                        return new AbstractC5881j.j(value, this.f21302a.m24809c(type, annotationArr), interfaceC5919s.encoded());
                    }
                    throw m24830a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw m24830a(i2, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5920t) {
                InterfaceC5920t interfaceC5920t = (InterfaceC5920t) annotation;
                String value2 = interfaceC5920t.value();
                boolean encoded = interfaceC5920t.encoded();
                Class<?> m24858c = C5887p.m24858c(type);
                this.f21312k = true;
                if (Iterable.class.isAssignableFrom(m24858c)) {
                    if (type instanceof ParameterizedType) {
                        return new AbstractC5881j.k(value2, this.f21302a.m24809c(C5887p.m24846a(0, (ParameterizedType) type), annotationArr), encoded).m24763b();
                    }
                    throw m24830a(i2, m24858c.getSimpleName() + " must include generic type (e.g., " + m24858c.getSimpleName() + "<String>)", new Object[0]);
                }
                if (m24858c.isArray()) {
                    return new AbstractC5881j.k(value2, this.f21302a.m24809c(C5886o.m24825a(m24858c.getComponentType()), annotationArr), encoded).m24761a();
                }
                return new AbstractC5881j.k(value2, this.f21302a.m24809c(type, annotationArr), encoded);
            }
            if (annotation instanceof InterfaceC5922v) {
                boolean encoded2 = ((InterfaceC5922v) annotation).encoded();
                Class<?> m24858c2 = C5887p.m24858c(type);
                this.f21312k = true;
                if (Iterable.class.isAssignableFrom(m24858c2)) {
                    if (type instanceof ParameterizedType) {
                        return new AbstractC5881j.m(this.f21302a.m24809c(C5887p.m24846a(0, (ParameterizedType) type), annotationArr), encoded2).m24763b();
                    }
                    throw m24830a(i2, m24858c2.getSimpleName() + " must include generic type (e.g., " + m24858c2.getSimpleName() + "<String>)", new Object[0]);
                }
                if (m24858c2.isArray()) {
                    return new AbstractC5881j.m(this.f21302a.m24809c(C5886o.m24825a(m24858c2.getComponentType()), annotationArr), encoded2).m24761a();
                }
                return new AbstractC5881j.m(this.f21302a.m24809c(type, annotationArr), encoded2);
            }
            if (annotation instanceof InterfaceC5921u) {
                Class<?> m24858c3 = C5887p.m24858c(type);
                if (Map.class.isAssignableFrom(m24858c3)) {
                    Type m24857b = C5887p.m24857b(type, m24858c3, Map.class);
                    if (m24857b instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) m24857b;
                        Type m24846a = C5887p.m24846a(0, parameterizedType);
                        if (String.class == m24846a) {
                            return new AbstractC5881j.l(this.f21302a.m24809c(C5887p.m24846a(1, parameterizedType), annotationArr), ((InterfaceC5921u) annotation).encoded());
                        }
                        throw m24830a(i2, "@QueryMap keys must be of type String: " + m24846a, new Object[0]);
                    }
                    throw m24830a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw m24830a(i2, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5909i) {
                String value3 = ((InterfaceC5909i) annotation).value();
                Class<?> m24858c4 = C5887p.m24858c(type);
                if (Iterable.class.isAssignableFrom(m24858c4)) {
                    if (type instanceof ParameterizedType) {
                        return new AbstractC5881j.f(value3, this.f21302a.m24809c(C5887p.m24846a(0, (ParameterizedType) type), annotationArr)).m24763b();
                    }
                    throw m24830a(i2, m24858c4.getSimpleName() + " must include generic type (e.g., " + m24858c4.getSimpleName() + "<String>)", new Object[0]);
                }
                if (m24858c4.isArray()) {
                    return new AbstractC5881j.f(value3, this.f21302a.m24809c(C5886o.m24825a(m24858c4.getComponentType()), annotationArr)).m24761a();
                }
                return new AbstractC5881j.f(value3, this.f21302a.m24809c(type, annotationArr));
            }
            if (annotation instanceof InterfaceC5910j) {
                Class<?> m24858c5 = C5887p.m24858c(type);
                if (Map.class.isAssignableFrom(m24858c5)) {
                    Type m24857b2 = C5887p.m24857b(type, m24858c5, Map.class);
                    if (m24857b2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) m24857b2;
                        Type m24846a2 = C5887p.m24846a(0, parameterizedType2);
                        if (String.class == m24846a2) {
                            return new AbstractC5881j.g(this.f21302a.m24809c(C5887p.m24846a(1, parameterizedType2), annotationArr));
                        }
                        throw m24830a(i2, "@HeaderMap keys must be of type String: " + m24846a2, new Object[0]);
                    }
                    throw m24830a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw m24830a(i2, "@HeaderMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5903c) {
                if (this.f21316o) {
                    InterfaceC5903c interfaceC5903c = (InterfaceC5903c) annotation;
                    String value4 = interfaceC5903c.value();
                    boolean encoded3 = interfaceC5903c.encoded();
                    this.f21308g = true;
                    Class<?> m24858c6 = C5887p.m24858c(type);
                    if (Iterable.class.isAssignableFrom(m24858c6)) {
                        if (type instanceof ParameterizedType) {
                            return new AbstractC5881j.d(value4, this.f21302a.m24809c(C5887p.m24846a(0, (ParameterizedType) type), annotationArr), encoded3).m24763b();
                        }
                        throw m24830a(i2, m24858c6.getSimpleName() + " must include generic type (e.g., " + m24858c6.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (m24858c6.isArray()) {
                        return new AbstractC5881j.d(value4, this.f21302a.m24809c(C5886o.m24825a(m24858c6.getComponentType()), annotationArr), encoded3).m24761a();
                    }
                    return new AbstractC5881j.d(value4, this.f21302a.m24809c(type, annotationArr), encoded3);
                }
                throw m24830a(i2, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5904d) {
                if (this.f21316o) {
                    Class<?> m24858c7 = C5887p.m24858c(type);
                    if (Map.class.isAssignableFrom(m24858c7)) {
                        Type m24857b3 = C5887p.m24857b(type, m24858c7, Map.class);
                        if (m24857b3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) m24857b3;
                            Type m24846a3 = C5887p.m24846a(0, parameterizedType3);
                            if (String.class == m24846a3) {
                                InterfaceC5876e<T, String> m24809c = this.f21302a.m24809c(C5887p.m24846a(1, parameterizedType3), annotationArr);
                                this.f21308g = true;
                                return new AbstractC5881j.e(m24809c, ((InterfaceC5904d) annotation).encoded());
                            }
                            throw m24830a(i2, "@FieldMap keys must be of type String: " + m24846a3, new Object[0]);
                        }
                        throw m24830a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw m24830a(i2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw m24830a(i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5917q) {
                if (this.f21317p) {
                    InterfaceC5917q interfaceC5917q = (InterfaceC5917q) annotation;
                    this.f21309h = true;
                    String value5 = interfaceC5917q.value();
                    Class<?> m24858c8 = C5887p.m24858c(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(m24858c8)) {
                            if (type instanceof ParameterizedType) {
                                if (MultipartBody.Part.class.isAssignableFrom(C5887p.m24858c(C5887p.m24846a(0, (ParameterizedType) type)))) {
                                    return AbstractC5881j.n.f21250a.m24763b();
                                }
                                throw m24830a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw m24830a(i2, m24858c8.getSimpleName() + " must include generic type (e.g., " + m24858c8.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (m24858c8.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(m24858c8.getComponentType())) {
                                return AbstractC5881j.n.f21250a.m24761a();
                            }
                            throw m24830a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(m24858c8)) {
                            return AbstractC5881j.n.f21250a;
                        }
                        throw m24830a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    Headers m24924of = Headers.m24924of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", interfaceC5917q.encoding());
                    if (Iterable.class.isAssignableFrom(m24858c8)) {
                        if (type instanceof ParameterizedType) {
                            Type m24846a4 = C5887p.m24846a(0, (ParameterizedType) type);
                            if (!MultipartBody.Part.class.isAssignableFrom(C5887p.m24858c(m24846a4))) {
                                return new AbstractC5881j.h(m24924of, this.f21302a.m24802a(m24846a4, annotationArr, this.f21304c)).m24763b();
                            }
                            throw m24830a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw m24830a(i2, m24858c8.getSimpleName() + " must include generic type (e.g., " + m24858c8.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (m24858c8.isArray()) {
                        Class<?> m24825a = C5886o.m24825a(m24858c8.getComponentType());
                        if (!MultipartBody.Part.class.isAssignableFrom(m24825a)) {
                            return new AbstractC5881j.h(m24924of, this.f21302a.m24802a(m24825a, annotationArr, this.f21304c)).m24761a();
                        }
                        throw m24830a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    if (!MultipartBody.Part.class.isAssignableFrom(m24858c8)) {
                        return new AbstractC5881j.h(m24924of, this.f21302a.m24802a(type, annotationArr, this.f21304c));
                    }
                    throw m24830a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                throw m24830a(i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof InterfaceC5918r) {
                if (this.f21317p) {
                    this.f21309h = true;
                    Class<?> m24858c9 = C5887p.m24858c(type);
                    if (Map.class.isAssignableFrom(m24858c9)) {
                        Type m24857b4 = C5887p.m24857b(type, m24858c9, Map.class);
                        if (m24857b4 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) m24857b4;
                            Type m24846a5 = C5887p.m24846a(0, parameterizedType4);
                            if (String.class == m24846a5) {
                                Type m24846a6 = C5887p.m24846a(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(C5887p.m24858c(m24846a6))) {
                                    return new AbstractC5881j.i(this.f21302a.m24802a(m24846a6, annotationArr, this.f21304c), ((InterfaceC5918r) annotation).encoding());
                                }
                                throw m24830a(i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw m24830a(i2, "@PartMap keys must be of type String: " + m24846a5, new Object[0]);
                        }
                        throw m24830a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw m24830a(i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw m24830a(i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (!(annotation instanceof InterfaceC5901a)) {
                return null;
            }
            if (!this.f21316o && !this.f21317p) {
                if (!this.f21310i) {
                    try {
                        InterfaceC5876e<T, RequestBody> m24802a = this.f21302a.m24802a(type, annotationArr, this.f21304c);
                        this.f21310i = true;
                        return new AbstractC5881j.c(m24802a);
                    } catch (RuntimeException e2) {
                        throw m24832a(e2, i2, "Unable to create @Body converter for %s", type);
                    }
                }
                throw m24830a(i2, "Multiple @Body method annotations found.", new Object[0]);
            }
            throw m24830a(i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        }

        /* renamed from: a */
        private void m24837a(int i2, String str) {
            if (C5886o.f21289o.matcher(str).matches()) {
                if (!this.f21321t.contains(str)) {
                    throw m24830a(i2, "URL \"%s\" does not contain \"{%s}\".", this.f21318q, str);
                }
                return;
            }
            throw m24830a(i2, "@Path parameter name must match %s. Found: %s", C5886o.f21288n.pattern(), str);
        }

        /* renamed from: a */
        private RuntimeException m24831a(String str, Object... objArr) {
            return m24833a((Throwable) null, str, objArr);
        }

        /* renamed from: a */
        private RuntimeException m24833a(Throwable th, String str, Object... objArr) {
            return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.f21303b.getDeclaringClass().getSimpleName() + "." + this.f21303b.getName(), th);
        }

        /* renamed from: a */
        private RuntimeException m24832a(Throwable th, int i2, String str, Object... objArr) {
            return m24833a(th, str + " (parameter #" + (i2 + 1) + ")", objArr);
        }

        /* renamed from: a */
        private RuntimeException m24830a(int i2, String str, Object... objArr) {
            return m24831a(str + " (parameter #" + (i2 + 1) + ")", objArr);
        }
    }
}
