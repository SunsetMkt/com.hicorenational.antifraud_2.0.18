package com.google.gson.b0.q;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final com.google.gson.y<Class> a = new k().nullSafe();

    /* JADX INFO: renamed from: b */
    public static final com.google.gson.z f3731b = a(Class.class, a);

    /* JADX INFO: renamed from: c */
    public static final com.google.gson.y<BitSet> f3732c = new v().nullSafe();

    /* JADX INFO: renamed from: d */
    public static final com.google.gson.z f3733d = a(BitSet.class, f3732c);

    /* JADX INFO: renamed from: e */
    public static final com.google.gson.y<Boolean> f3734e = new c0();

    /* JADX INFO: renamed from: f */
    public static final com.google.gson.y<Boolean> f3735f = new d0();

    /* JADX INFO: renamed from: g */
    public static final com.google.gson.z f3736g = a(Boolean.TYPE, Boolean.class, f3734e);

    /* JADX INFO: renamed from: h */
    public static final com.google.gson.y<Number> f3737h = new e0();

    /* JADX INFO: renamed from: i */
    public static final com.google.gson.z f3738i = a(Byte.TYPE, Byte.class, f3737h);

    /* JADX INFO: renamed from: j */
    public static final com.google.gson.y<Number> f3739j = new f0();

    /* JADX INFO: renamed from: k */
    public static final com.google.gson.z f3740k = a(Short.TYPE, Short.class, f3739j);

    /* JADX INFO: renamed from: l */
    public static final com.google.gson.y<Number> f3741l = new g0();

    /* JADX INFO: renamed from: m */
    public static final com.google.gson.z f3742m = a(Integer.TYPE, Integer.class, f3741l);

    /* JADX INFO: renamed from: n */
    public static final com.google.gson.y<AtomicInteger> f3743n = new h0().nullSafe();
    public static final com.google.gson.z o = a(AtomicInteger.class, f3743n);
    public static final com.google.gson.y<AtomicBoolean> p = new i0().nullSafe();
    public static final com.google.gson.z q = a(AtomicBoolean.class, p);
    public static final com.google.gson.y<AtomicIntegerArray> r = new a().nullSafe();
    public static final com.google.gson.z s = a(AtomicIntegerArray.class, r);
    public static final com.google.gson.y<Number> t = new b();
    public static final com.google.gson.y<Number> u = new c();
    public static final com.google.gson.y<Number> v = new d();
    public static final com.google.gson.y<Character> w = new e();
    public static final com.google.gson.z x = a(Character.TYPE, Character.class, w);
    public static final com.google.gson.y<String> y = new f();
    public static final com.google.gson.y<BigDecimal> z = new g();
    public static final com.google.gson.y<BigInteger> A = new h();
    public static final com.google.gson.y<com.google.gson.b0.h> B = new i();
    public static final com.google.gson.z C = a(String.class, y);
    public static final com.google.gson.y<StringBuilder> D = new j();
    public static final com.google.gson.z E = a(StringBuilder.class, D);
    public static final com.google.gson.y<StringBuffer> F = new l();
    public static final com.google.gson.z G = a(StringBuffer.class, F);
    public static final com.google.gson.y<URL> H = new m();
    public static final com.google.gson.z I = a(URL.class, H);
    public static final com.google.gson.y<URI> J = new n();
    public static final com.google.gson.z K = a(URI.class, J);
    public static final com.google.gson.y<InetAddress> L = new C0075o();
    public static final com.google.gson.z M = b(InetAddress.class, L);
    public static final com.google.gson.y<UUID> N = new p();
    public static final com.google.gson.z O = a(UUID.class, N);
    public static final com.google.gson.y<Currency> P = new q().nullSafe();
    public static final com.google.gson.z Q = a(Currency.class, P);
    public static final com.google.gson.y<Calendar> R = new r();
    public static final com.google.gson.z S = b(Calendar.class, GregorianCalendar.class, R);
    public static final com.google.gson.y<Locale> T = new s();
    public static final com.google.gson.z U = a(Locale.class, T);
    public static final com.google.gson.y<com.google.gson.k> V = new t();
    public static final com.google.gson.z W = b(com.google.gson.k.class, V);
    public static final com.google.gson.z X = new u();

    /* JADX INFO: compiled from: TypeAdapters.java */
    class a extends com.google.gson.y<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            dVar.c();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                dVar.a(atomicIntegerArray.get(i2));
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        public AtomicIntegerArray read(com.google.gson.e0.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.c();
            while (aVar.j()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.o()));
                } catch (NumberFormatException e2) {
                    throw new com.google.gson.t(e2);
                }
            }
            aVar.f();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class a0 implements com.google.gson.z {
        final /* synthetic */ Class a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ com.google.gson.y f3744b;

        /* JADX INFO: compiled from: TypeAdapters.java */
        class a<T1> extends com.google.gson.y<T1> {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // com.google.gson.y
            public T1 read(com.google.gson.e0.a aVar) throws IOException {
                T1 t1 = (T1) a0.this.f3744b.read(aVar);
                if (t1 == null || this.a.isInstance(t1)) {
                    return t1;
                }
                throw new com.google.gson.t("Expected a " + this.a.getName() + " but was " + t1.getClass().getName() + "; at path " + aVar.i());
            }

            @Override // com.google.gson.y
            public void write(com.google.gson.e0.d dVar, T1 t1) throws IOException {
                a0.this.f3744b.write(dVar, t1);
            }
        }

        a0(Class cls, com.google.gson.y yVar) {
            this.a = cls;
            this.f3744b = yVar;
        }

        @Override // com.google.gson.z
        public <T2> com.google.gson.y<T2> create(com.google.gson.e eVar, com.google.gson.d0.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (this.a.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.f3744b + "]";
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class b extends com.google.gson.y<Number> {
        b() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.longValue());
            }
        }

        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                return Long.valueOf(aVar.p());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    static /* synthetic */ class b0 {
        static final /* synthetic */ int[] a = new int[com.google.gson.e0.c.values().length];

        static {
            try {
                a[com.google.gson.e0.c.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.gson.e0.c.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.gson.e0.c.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.gson.e0.c.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.gson.e0.c.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.google.gson.e0.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class c extends com.google.gson.y<Number> {
        c() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            dVar.a(number);
        }

        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Float.valueOf((float) aVar.n());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class c0 extends com.google.gson.y<Boolean> {
        c0() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Boolean bool) throws IOException {
            dVar.a(bool);
        }

        @Override // com.google.gson.y
        public Boolean read(com.google.gson.e0.a aVar) throws IOException {
            com.google.gson.e0.c cVarPeek = aVar.peek();
            if (cVarPeek != com.google.gson.e0.c.NULL) {
                return cVarPeek == com.google.gson.e0.c.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.s())) : Boolean.valueOf(aVar.m());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class d extends com.google.gson.y<Number> {
        d() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.doubleValue());
            }
        }

        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Double.valueOf(aVar.n());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class d0 extends com.google.gson.y<Boolean> {
        d0() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Boolean bool) throws IOException {
            dVar.d(bool == null ? d.c.a.b.a.a.f10075h : bool.toString());
        }

        @Override // com.google.gson.y
        public Boolean read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Boolean.valueOf(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class e extends com.google.gson.y<Character> {
        e() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Character ch) throws IOException {
            dVar.d(ch == null ? null : String.valueOf(ch));
        }

        @Override // com.google.gson.y
        public Character read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            if (strS.length() == 1) {
                return Character.valueOf(strS.charAt(0));
            }
            throw new com.google.gson.t("Expecting character, got: " + strS + "; at " + aVar.i());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class e0 extends com.google.gson.y<Number> {
        e0() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.byteValue());
            }
        }

        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                int iO = aVar.o();
                if (iO <= 255 && iO >= -128) {
                    return Byte.valueOf((byte) iO);
                }
                throw new com.google.gson.t("Lossy conversion from " + iO + " to byte; at path " + aVar.i());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class f extends com.google.gson.y<String> {
        f() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, String str) throws IOException {
            dVar.d(str);
        }

        @Override // com.google.gson.y
        public String read(com.google.gson.e0.a aVar) throws IOException {
            com.google.gson.e0.c cVarPeek = aVar.peek();
            if (cVarPeek != com.google.gson.e0.c.NULL) {
                return cVarPeek == com.google.gson.e0.c.BOOLEAN ? Boolean.toString(aVar.m()) : aVar.s();
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class f0 extends com.google.gson.y<Number> {
        f0() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.shortValue());
            }
        }

        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                int iO = aVar.o();
                if (iO <= 65535 && iO >= -32768) {
                    return Short.valueOf((short) iO);
                }
                throw new com.google.gson.t("Lossy conversion from " + iO + " to short; at path " + aVar.i());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class g extends com.google.gson.y<BigDecimal> {
        g() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, BigDecimal bigDecimal) throws IOException {
            dVar.a(bigDecimal);
        }

        @Override // com.google.gson.y
        public BigDecimal read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            try {
                return new BigDecimal(strS);
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t("Failed parsing '" + strS + "' as BigDecimal; at path " + aVar.i(), e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class g0 extends com.google.gson.y<Number> {
        g0() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.a(number.intValue());
            }
        }

        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                return Integer.valueOf(aVar.o());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class h extends com.google.gson.y<BigInteger> {
        h() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, BigInteger bigInteger) throws IOException {
            dVar.a(bigInteger);
        }

        @Override // com.google.gson.y
        public BigInteger read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            try {
                return new BigInteger(strS);
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t("Failed parsing '" + strS + "' as BigInteger; at path " + aVar.i(), e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class h0 extends com.google.gson.y<AtomicInteger> {
        h0() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, AtomicInteger atomicInteger) throws IOException {
            dVar.a(atomicInteger.get());
        }

        @Override // com.google.gson.y
        public AtomicInteger read(com.google.gson.e0.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.o());
            } catch (NumberFormatException e2) {
                throw new com.google.gson.t(e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class i extends com.google.gson.y<com.google.gson.b0.h> {
        i() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, com.google.gson.b0.h hVar) throws IOException {
            dVar.a(hVar);
        }

        @Override // com.google.gson.y
        public com.google.gson.b0.h read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return new com.google.gson.b0.h(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class i0 extends com.google.gson.y<AtomicBoolean> {
        i0() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, AtomicBoolean atomicBoolean) throws IOException {
            dVar.d(atomicBoolean.get());
        }

        @Override // com.google.gson.y
        public AtomicBoolean read(com.google.gson.e0.a aVar) throws IOException {
            return new AtomicBoolean(aVar.m());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class j extends com.google.gson.y<StringBuilder> {
        j() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, StringBuilder sb) throws IOException {
            dVar.d(sb == null ? null : sb.toString());
        }

        @Override // com.google.gson.y
        public StringBuilder read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return new StringBuilder(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    private static final class j0<T extends Enum<T>> extends com.google.gson.y<T> {
        private final Map<String, T> a = new HashMap();

        /* JADX INFO: renamed from: b */
        private final Map<String, T> f3746b = new HashMap();

        /* JADX INFO: renamed from: c */
        private final Map<T, String> f3747c = new HashMap();

        /* JADX INFO: compiled from: TypeAdapters.java */
        class a implements PrivilegedAction<Field[]> {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // java.security.PrivilegedAction
            public Field[] run() {
                Field[] declaredFields = this.a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public j0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    String string = r4.toString();
                    com.google.gson.a0.c cVar = (com.google.gson.a0.c) field.getAnnotation(com.google.gson.a0.c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.a.put(str, (T) r4);
                        }
                    }
                    this.a.put(strName, (T) r4);
                    this.f3746b.put(string, (T) r4);
                    this.f3747c.put((T) r4, strName);
                }
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            dVar.d(t == null ? null : this.f3747c.get(t));
        }

        @Override // com.google.gson.y
        public T read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            T t = this.a.get(strS);
            return t == null ? this.f3746b.get(strS) : t;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class k extends com.google.gson.y<Class> {
        k() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        @Override // com.google.gson.y
        public Class read(com.google.gson.e0.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class l extends com.google.gson.y<StringBuffer> {
        l() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, StringBuffer stringBuffer) throws IOException {
            dVar.d(stringBuffer == null ? null : stringBuffer.toString());
        }

        @Override // com.google.gson.y
        public StringBuffer read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return new StringBuffer(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class m extends com.google.gson.y<URL> {
        m() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, URL url) throws IOException {
            dVar.d(url == null ? null : url.toExternalForm());
        }

        @Override // com.google.gson.y
        public URL read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            if (d.c.a.b.a.a.f10075h.equals(strS)) {
                return null;
            }
            return new URL(strS);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class n extends com.google.gson.y<URI> {
        n() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, URI uri) throws IOException {
            dVar.d(uri == null ? null : uri.toASCIIString());
        }

        @Override // com.google.gson.y
        public URI read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            try {
                String strS = aVar.s();
                if (d.c.a.b.a.a.f10075h.equals(strS)) {
                    return null;
                }
                return new URI(strS);
            } catch (URISyntaxException e2) {
                throw new com.google.gson.l(e2);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.b0.q.o$o */
    /* JADX INFO: compiled from: TypeAdapters.java */
    class C0075o extends com.google.gson.y<InetAddress> {
        C0075o() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, InetAddress inetAddress) throws IOException {
            dVar.d(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        @Override // com.google.gson.y
        public InetAddress read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return InetAddress.getByName(aVar.s());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class p extends com.google.gson.y<UUID> {
        p() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, UUID uuid) throws IOException {
            dVar.d(uuid == null ? null : uuid.toString());
        }

        @Override // com.google.gson.y
        public UUID read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            String strS = aVar.s();
            try {
                return UUID.fromString(strS);
            } catch (IllegalArgumentException e2) {
                throw new com.google.gson.t("Failed parsing '" + strS + "' as UUID; at path " + aVar.i(), e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class q extends com.google.gson.y<Currency> {
        q() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Currency currency) throws IOException {
            dVar.d(currency.getCurrencyCode());
        }

        @Override // com.google.gson.y
        public Currency read(com.google.gson.e0.a aVar) throws IOException {
            String strS = aVar.s();
            try {
                return Currency.getInstance(strS);
            } catch (IllegalArgumentException e2) {
                throw new com.google.gson.t("Failed parsing '" + strS + "' as Currency; at path " + aVar.i(), e2);
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class r extends com.google.gson.y<Calendar> {
        private static final String a = "year";

        /* JADX INFO: renamed from: b */
        private static final String f3749b = "month";

        /* JADX INFO: renamed from: c */
        private static final String f3750c = "dayOfMonth";

        /* JADX INFO: renamed from: d */
        private static final String f3751d = "hourOfDay";

        /* JADX INFO: renamed from: e */
        private static final String f3752e = "minute";

        /* JADX INFO: renamed from: f */
        private static final String f3753f = "second";

        r() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                dVar.j();
                return;
            }
            dVar.d();
            dVar.b(a);
            dVar.a(calendar.get(1));
            dVar.b(f3749b);
            dVar.a(calendar.get(2));
            dVar.b(f3750c);
            dVar.a(calendar.get(5));
            dVar.b(f3751d);
            dVar.a(calendar.get(11));
            dVar.b(f3752e);
            dVar.a(calendar.get(12));
            dVar.b(f3753f);
            dVar.a(calendar.get(13));
            dVar.f();
        }

        @Override // com.google.gson.y
        public Calendar read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            aVar.d();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.peek() != com.google.gson.e0.c.END_OBJECT) {
                String strQ = aVar.q();
                int iO = aVar.o();
                if (a.equals(strQ)) {
                    i2 = iO;
                } else if (f3749b.equals(strQ)) {
                    i3 = iO;
                } else if (f3750c.equals(strQ)) {
                    i4 = iO;
                } else if (f3751d.equals(strQ)) {
                    i5 = iO;
                } else if (f3752e.equals(strQ)) {
                    i6 = iO;
                } else if (f3753f.equals(strQ)) {
                    i7 = iO;
                }
            }
            aVar.g();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class s extends com.google.gson.y<Locale> {
        s() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, Locale locale) throws IOException {
            dVar.d(locale == null ? null : locale.toString());
        }

        @Override // com.google.gson.y
        public Locale read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.s(), d.c.a.b.a.a.s1);
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class t extends com.google.gson.y<com.google.gson.k> {
        t() {
        }

        private com.google.gson.k a(com.google.gson.e0.a aVar, com.google.gson.e0.c cVar) throws IOException {
            int i2 = b0.a[cVar.ordinal()];
            if (i2 == 1) {
                return new com.google.gson.p(new com.google.gson.b0.h(aVar.s()));
            }
            if (i2 == 2) {
                return new com.google.gson.p(aVar.s());
            }
            if (i2 == 3) {
                return new com.google.gson.p(Boolean.valueOf(aVar.m()));
            }
            if (i2 == 6) {
                aVar.r();
                return com.google.gson.m.a;
            }
            throw new IllegalStateException("Unexpected token: " + cVar);
        }

        private com.google.gson.k b(com.google.gson.e0.a aVar, com.google.gson.e0.c cVar) throws IOException {
            int i2 = b0.a[cVar.ordinal()];
            if (i2 == 4) {
                aVar.c();
                return new com.google.gson.h();
            }
            if (i2 != 5) {
                return null;
            }
            aVar.d();
            return new JsonObject();
        }

        @Override // com.google.gson.y
        public com.google.gson.k read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar instanceof com.google.gson.b0.q.f) {
                return ((com.google.gson.b0.q.f) aVar).u();
            }
            com.google.gson.e0.c cVarPeek = aVar.peek();
            com.google.gson.k kVarB = b(aVar, cVarPeek);
            if (kVarB == null) {
                return a(aVar, cVarPeek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.j()) {
                    String strQ = kVarB instanceof JsonObject ? aVar.q() : null;
                    com.google.gson.e0.c cVarPeek2 = aVar.peek();
                    com.google.gson.k kVarB2 = b(aVar, cVarPeek2);
                    boolean z = kVarB2 != null;
                    if (kVarB2 == null) {
                        kVarB2 = a(aVar, cVarPeek2);
                    }
                    if (kVarB instanceof com.google.gson.h) {
                        ((com.google.gson.h) kVarB).a(kVarB2);
                    } else {
                        ((JsonObject) kVarB).add(strQ, kVarB2);
                    }
                    if (z) {
                        arrayDeque.addLast(kVarB);
                        kVarB = kVarB2;
                    }
                } else {
                    if (kVarB instanceof com.google.gson.h) {
                        aVar.f();
                    } else {
                        aVar.g();
                    }
                    if (arrayDeque.isEmpty()) {
                        return kVarB;
                    }
                    kVarB = (com.google.gson.k) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, com.google.gson.k kVar) throws IOException {
            if (kVar != null && !kVar.isJsonNull()) {
                if (kVar.isJsonPrimitive()) {
                    com.google.gson.p asJsonPrimitive = kVar.getAsJsonPrimitive();
                    if (asJsonPrimitive.b()) {
                        dVar.a(asJsonPrimitive.getAsNumber());
                        return;
                    } else if (asJsonPrimitive.a()) {
                        dVar.d(asJsonPrimitive.getAsBoolean());
                        return;
                    } else {
                        dVar.d(asJsonPrimitive.getAsString());
                        return;
                    }
                }
                if (kVar.isJsonArray()) {
                    dVar.c();
                    Iterator<com.google.gson.k> it = kVar.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        write(dVar, it.next());
                    }
                    dVar.e();
                    return;
                }
                if (kVar.isJsonObject()) {
                    dVar.d();
                    for (Map.Entry<String, com.google.gson.k> entry : kVar.getAsJsonObject().entrySet()) {
                        dVar.b(entry.getKey());
                        write(dVar, entry.getValue());
                    }
                    dVar.f();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
            dVar.j();
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class u implements com.google.gson.z {
        u() {
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new j0(rawType);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class v extends com.google.gson.y<BitSet> {
        v() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a */
        public void write(com.google.gson.e0.d dVar, BitSet bitSet) throws IOException {
            dVar.c();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                dVar.a(bitSet.get(i2) ? 1L : 0L);
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        public BitSet read(com.google.gson.e0.a aVar) throws IOException {
            boolean zM;
            BitSet bitSet = new BitSet();
            aVar.c();
            com.google.gson.e0.c cVarPeek = aVar.peek();
            int i2 = 0;
            while (cVarPeek != com.google.gson.e0.c.END_ARRAY) {
                int i3 = b0.a[cVarPeek.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    int iO = aVar.o();
                    if (iO == 0) {
                        zM = false;
                    } else {
                        if (iO != 1) {
                            throw new com.google.gson.t("Invalid bitset value " + iO + ", expected 0 or 1; at path " + aVar.i());
                        }
                        zM = true;
                    }
                } else {
                    if (i3 != 3) {
                        throw new com.google.gson.t("Invalid bitset value type: " + cVarPeek + "; at path " + aVar.h());
                    }
                    zM = aVar.m();
                }
                if (zM) {
                    bitSet.set(i2);
                }
                i2++;
                cVarPeek = aVar.peek();
            }
            aVar.f();
            return bitSet;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class w implements com.google.gson.z {
        final /* synthetic */ com.google.gson.d0.a a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ com.google.gson.y f3754b;

        w(com.google.gson.d0.a aVar, com.google.gson.y yVar) {
            this.a = aVar;
            this.f3754b = yVar;
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.equals(this.a)) {
                return this.f3754b;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class x implements com.google.gson.z {
        final /* synthetic */ Class a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ com.google.gson.y f3755b;

        x(Class cls, com.google.gson.y yVar) {
            this.a = cls;
            this.f3755b = yVar;
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.getRawType() == this.a) {
                return this.f3755b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + ",adapter=" + this.f3755b + "]";
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class y implements com.google.gson.z {
        final /* synthetic */ Class a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Class f3756b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ com.google.gson.y f3757c;

        y(Class cls, Class cls2, com.google.gson.y yVar) {
            this.a = cls;
            this.f3756b = cls2;
            this.f3757c = yVar;
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.a || rawType == this.f3756b) {
                return this.f3757c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f3756b.getName() + "+" + this.a.getName() + ",adapter=" + this.f3757c + "]";
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class z implements com.google.gson.z {
        final /* synthetic */ Class a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Class f3758b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ com.google.gson.y f3759c;

        z(Class cls, Class cls2, com.google.gson.y yVar) {
            this.a = cls;
            this.f3758b = cls2;
            this.f3759c = yVar;
        }

        @Override // com.google.gson.z
        public <T> com.google.gson.y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.a || rawType == this.f3758b) {
                return this.f3759c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + "+" + this.f3758b.getName() + ",adapter=" + this.f3759c + "]";
        }
    }

    private o() {
        throw new UnsupportedOperationException();
    }

    public static <TT> com.google.gson.z a(com.google.gson.d0.a<TT> aVar, com.google.gson.y<TT> yVar) {
        return new w(aVar, yVar);
    }

    public static <TT> com.google.gson.z b(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.y<? super TT> yVar) {
        return new z(cls, cls2, yVar);
    }

    public static <TT> com.google.gson.z a(Class<TT> cls, com.google.gson.y<TT> yVar) {
        return new x(cls, yVar);
    }

    public static <T1> com.google.gson.z b(Class<T1> cls, com.google.gson.y<T1> yVar) {
        return new a0(cls, yVar);
    }

    public static <TT> com.google.gson.z a(Class<TT> cls, Class<TT> cls2, com.google.gson.y<? super TT> yVar) {
        return new y(cls, cls2, yVar);
    }
}
