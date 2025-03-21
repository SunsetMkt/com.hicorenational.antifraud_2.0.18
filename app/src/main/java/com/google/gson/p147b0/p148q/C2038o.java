package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2063k;
import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2060h;
import com.google.gson.C2064l;
import com.google.gson.C2065m;
import com.google.gson.C2068p;
import com.google.gson.C2072t;
import com.google.gson.InterfaceC2078z;
import com.google.gson.JsonObject;
import com.google.gson.p146a0.InterfaceC2003c;
import com.google.gson.p147b0.C2015h;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.gson.b0.q.o */
/* loaded from: classes.dex */
public final class C2038o {

    /* renamed from: a */
    public static final AbstractC2077y<Class> f5826a = new k().nullSafe();

    /* renamed from: b */
    public static final InterfaceC2078z f5827b = m5484a(Class.class, f5826a);

    /* renamed from: c */
    public static final AbstractC2077y<BitSet> f5828c = new v().nullSafe();

    /* renamed from: d */
    public static final InterfaceC2078z f5829d = m5484a(BitSet.class, f5828c);

    /* renamed from: e */
    public static final AbstractC2077y<Boolean> f5830e = new c0();

    /* renamed from: f */
    public static final AbstractC2077y<Boolean> f5831f = new d0();

    /* renamed from: g */
    public static final InterfaceC2078z f5832g = m5485a(Boolean.TYPE, Boolean.class, f5830e);

    /* renamed from: h */
    public static final AbstractC2077y<Number> f5833h = new e0();

    /* renamed from: i */
    public static final InterfaceC2078z f5834i = m5485a(Byte.TYPE, Byte.class, f5833h);

    /* renamed from: j */
    public static final AbstractC2077y<Number> f5835j = new f0();

    /* renamed from: k */
    public static final InterfaceC2078z f5836k = m5485a(Short.TYPE, Short.class, f5835j);

    /* renamed from: l */
    public static final AbstractC2077y<Number> f5837l = new g0();

    /* renamed from: m */
    public static final InterfaceC2078z f5838m = m5485a(Integer.TYPE, Integer.class, f5837l);

    /* renamed from: n */
    public static final AbstractC2077y<AtomicInteger> f5839n = new h0().nullSafe();

    /* renamed from: o */
    public static final InterfaceC2078z f5840o = m5484a(AtomicInteger.class, f5839n);

    /* renamed from: p */
    public static final AbstractC2077y<AtomicBoolean> f5841p = new i0().nullSafe();

    /* renamed from: q */
    public static final InterfaceC2078z f5842q = m5484a(AtomicBoolean.class, f5841p);

    /* renamed from: r */
    public static final AbstractC2077y<AtomicIntegerArray> f5843r = new a().nullSafe();

    /* renamed from: s */
    public static final InterfaceC2078z f5844s = m5484a(AtomicIntegerArray.class, f5843r);

    /* renamed from: t */
    public static final AbstractC2077y<Number> f5845t = new b();

    /* renamed from: u */
    public static final AbstractC2077y<Number> f5846u = new c();

    /* renamed from: v */
    public static final AbstractC2077y<Number> f5847v = new d();

    /* renamed from: w */
    public static final AbstractC2077y<Character> f5848w = new e();

    /* renamed from: x */
    public static final InterfaceC2078z f5849x = m5485a(Character.TYPE, Character.class, f5848w);

    /* renamed from: y */
    public static final AbstractC2077y<String> f5850y = new f();

    /* renamed from: z */
    public static final AbstractC2077y<BigDecimal> f5851z = new g();

    /* renamed from: A */
    public static final AbstractC2077y<BigInteger> f5802A = new h();

    /* renamed from: B */
    public static final AbstractC2077y<C2015h> f5803B = new i();

    /* renamed from: C */
    public static final InterfaceC2078z f5804C = m5484a(String.class, f5850y);

    /* renamed from: D */
    public static final AbstractC2077y<StringBuilder> f5805D = new j();

    /* renamed from: E */
    public static final InterfaceC2078z f5806E = m5484a(StringBuilder.class, f5805D);

    /* renamed from: F */
    public static final AbstractC2077y<StringBuffer> f5807F = new l();

    /* renamed from: G */
    public static final InterfaceC2078z f5808G = m5484a(StringBuffer.class, f5807F);

    /* renamed from: H */
    public static final AbstractC2077y<URL> f5809H = new m();

    /* renamed from: I */
    public static final InterfaceC2078z f5810I = m5484a(URL.class, f5809H);

    /* renamed from: J */
    public static final AbstractC2077y<URI> f5811J = new n();

    /* renamed from: K */
    public static final InterfaceC2078z f5812K = m5484a(URI.class, f5811J);

    /* renamed from: L */
    public static final AbstractC2077y<InetAddress> f5813L = new o();

    /* renamed from: M */
    public static final InterfaceC2078z f5814M = m5486b(InetAddress.class, f5813L);

    /* renamed from: N */
    public static final AbstractC2077y<UUID> f5815N = new p();

    /* renamed from: O */
    public static final InterfaceC2078z f5816O = m5484a(UUID.class, f5815N);

    /* renamed from: P */
    public static final AbstractC2077y<Currency> f5817P = new q().nullSafe();

    /* renamed from: Q */
    public static final InterfaceC2078z f5818Q = m5484a(Currency.class, f5817P);

    /* renamed from: R */
    public static final AbstractC2077y<Calendar> f5819R = new r();

    /* renamed from: S */
    public static final InterfaceC2078z f5820S = m5487b(Calendar.class, GregorianCalendar.class, f5819R);

    /* renamed from: T */
    public static final AbstractC2077y<Locale> f5821T = new s();

    /* renamed from: U */
    public static final InterfaceC2078z f5822U = m5484a(Locale.class, f5821T);

    /* renamed from: V */
    public static final AbstractC2077y<AbstractC2063k> f5823V = new t();

    /* renamed from: W */
    public static final InterfaceC2078z f5824W = m5486b(AbstractC2063k.class, f5823V);

    /* renamed from: X */
    public static final InterfaceC2078z f5825X = new u();

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$a */
    class a extends AbstractC2077y<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, AtomicIntegerArray atomicIntegerArray) throws IOException {
            c2055d.mo5442c();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                c2055d.mo5437a(atomicIntegerArray.get(i2));
            }
            c2055d.mo5446e();
        }

        @Override // com.google.gson.AbstractC2077y
        public AtomicIntegerArray read(C2052a c2052a) throws IOException {
            ArrayList arrayList = new ArrayList();
            c2052a.mo5417c();
            while (c2052a.mo5423j()) {
                try {
                    arrayList.add(Integer.valueOf(c2052a.mo5426o()));
                } catch (NumberFormatException e2) {
                    throw new C2072t(e2);
                }
            }
            c2052a.mo5419f();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$a0 */
    class a0 implements InterfaceC2078z {

        /* renamed from: a */
        final /* synthetic */ Class f5852a;

        /* renamed from: b */
        final /* synthetic */ AbstractC2077y f5853b;

        /* compiled from: TypeAdapters.java */
        /* renamed from: com.google.gson.b0.q.o$a0$a */
        class a<T1> extends AbstractC2077y<T1> {

            /* renamed from: a */
            final /* synthetic */ Class f5854a;

            a(Class cls) {
                this.f5854a = cls;
            }

            @Override // com.google.gson.AbstractC2077y
            public T1 read(C2052a c2052a) throws IOException {
                T1 t1 = (T1) a0.this.f5853b.read(c2052a);
                if (t1 == null || this.f5854a.isInstance(t1)) {
                    return t1;
                }
                throw new C2072t("Expected a " + this.f5854a.getName() + " but was " + t1.getClass().getName() + "; at path " + c2052a.mo5422i());
            }

            @Override // com.google.gson.AbstractC2077y
            public void write(C2055d c2055d, T1 t1) throws IOException {
                a0.this.f5853b.write(c2055d, t1);
            }
        }

        a0(Class cls, AbstractC2077y abstractC2077y) {
            this.f5852a = cls;
            this.f5853b = abstractC2077y;
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T2> AbstractC2077y<T2> create(C2051e c2051e, C2049a<T2> c2049a) {
            Class<? super T2> rawType = c2049a.getRawType();
            if (this.f5852a.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f5852a.getName() + ",adapter=" + this.f5853b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$b */
    class b extends AbstractC2077y<Number> {
        b() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
            } else {
                c2055d.mo5437a(number.longValue());
            }
        }

        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            try {
                return Long.valueOf(c2052a.mo5427p());
            } catch (NumberFormatException e2) {
                throw new C2072t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$b0 */
    static /* synthetic */ class b0 {

        /* renamed from: a */
        static final /* synthetic */ int[] f5856a = new int[EnumC2054c.values().length];

        static {
            try {
                f5856a[EnumC2054c.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5856a[EnumC2054c.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5856a[EnumC2054c.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5856a[EnumC2054c.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5856a[EnumC2054c.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5856a[EnumC2054c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$c */
    class c extends AbstractC2077y<Number> {
        c() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            c2055d.mo5439a(number);
        }

        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return Float.valueOf((float) c2052a.mo5425n());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$c0 */
    class c0 extends AbstractC2077y<Boolean> {
        c0() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Boolean bool) throws IOException {
            c2055d.mo5438a(bool);
        }

        @Override // com.google.gson.AbstractC2077y
        public Boolean read(C2052a c2052a) throws IOException {
            EnumC2054c peek = c2052a.peek();
            if (peek != EnumC2054c.NULL) {
                return peek == EnumC2054c.STRING ? Boolean.valueOf(Boolean.parseBoolean(c2052a.mo5430s())) : Boolean.valueOf(c2052a.mo5424m());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$d */
    class d extends AbstractC2077y<Number> {
        d() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
            } else {
                c2055d.mo5435a(number.doubleValue());
            }
        }

        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return Double.valueOf(c2052a.mo5425n());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$d0 */
    class d0 extends AbstractC2077y<Boolean> {
        d0() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Boolean bool) throws IOException {
            c2055d.mo5444d(bool == null ? AbstractC1191a.f2571h : bool.toString());
        }

        @Override // com.google.gson.AbstractC2077y
        public Boolean read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return Boolean.valueOf(c2052a.mo5430s());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$e */
    class e extends AbstractC2077y<Character> {
        e() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Character ch) throws IOException {
            c2055d.mo5444d(ch == null ? null : String.valueOf(ch));
        }

        @Override // com.google.gson.AbstractC2077y
        public Character read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            String mo5430s = c2052a.mo5430s();
            if (mo5430s.length() == 1) {
                return Character.valueOf(mo5430s.charAt(0));
            }
            throw new C2072t("Expecting character, got: " + mo5430s + "; at " + c2052a.mo5422i());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$e0 */
    class e0 extends AbstractC2077y<Number> {
        e0() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
            } else {
                c2055d.mo5437a(number.byteValue());
            }
        }

        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            try {
                int mo5426o = c2052a.mo5426o();
                if (mo5426o <= 255 && mo5426o >= -128) {
                    return Byte.valueOf((byte) mo5426o);
                }
                throw new C2072t("Lossy conversion from " + mo5426o + " to byte; at path " + c2052a.mo5422i());
            } catch (NumberFormatException e2) {
                throw new C2072t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$f */
    class f extends AbstractC2077y<String> {
        f() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, String str) throws IOException {
            c2055d.mo5444d(str);
        }

        @Override // com.google.gson.AbstractC2077y
        public String read(C2052a c2052a) throws IOException {
            EnumC2054c peek = c2052a.peek();
            if (peek != EnumC2054c.NULL) {
                return peek == EnumC2054c.BOOLEAN ? Boolean.toString(c2052a.mo5424m()) : c2052a.mo5430s();
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$f0 */
    class f0 extends AbstractC2077y<Number> {
        f0() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
            } else {
                c2055d.mo5437a(number.shortValue());
            }
        }

        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            try {
                int mo5426o = c2052a.mo5426o();
                if (mo5426o <= 65535 && mo5426o >= -32768) {
                    return Short.valueOf((short) mo5426o);
                }
                throw new C2072t("Lossy conversion from " + mo5426o + " to short; at path " + c2052a.mo5422i());
            } catch (NumberFormatException e2) {
                throw new C2072t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$g */
    class g extends AbstractC2077y<BigDecimal> {
        g() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, BigDecimal bigDecimal) throws IOException {
            c2055d.mo5439a(bigDecimal);
        }

        @Override // com.google.gson.AbstractC2077y
        public BigDecimal read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            String mo5430s = c2052a.mo5430s();
            try {
                return new BigDecimal(mo5430s);
            } catch (NumberFormatException e2) {
                throw new C2072t("Failed parsing '" + mo5430s + "' as BigDecimal; at path " + c2052a.mo5422i(), e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$g0 */
    class g0 extends AbstractC2077y<Number> {
        g0() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
            } else {
                c2055d.mo5437a(number.intValue());
            }
        }

        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            try {
                return Integer.valueOf(c2052a.mo5426o());
            } catch (NumberFormatException e2) {
                throw new C2072t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$h */
    class h extends AbstractC2077y<BigInteger> {
        h() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, BigInteger bigInteger) throws IOException {
            c2055d.mo5439a(bigInteger);
        }

        @Override // com.google.gson.AbstractC2077y
        public BigInteger read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            String mo5430s = c2052a.mo5430s();
            try {
                return new BigInteger(mo5430s);
            } catch (NumberFormatException e2) {
                throw new C2072t("Failed parsing '" + mo5430s + "' as BigInteger; at path " + c2052a.mo5422i(), e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$h0 */
    class h0 extends AbstractC2077y<AtomicInteger> {
        h0() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, AtomicInteger atomicInteger) throws IOException {
            c2055d.mo5437a(atomicInteger.get());
        }

        @Override // com.google.gson.AbstractC2077y
        public AtomicInteger read(C2052a c2052a) throws IOException {
            try {
                return new AtomicInteger(c2052a.mo5426o());
            } catch (NumberFormatException e2) {
                throw new C2072t(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$i */
    class i extends AbstractC2077y<C2015h> {
        i() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, C2015h c2015h) throws IOException {
            c2055d.mo5439a(c2015h);
        }

        @Override // com.google.gson.AbstractC2077y
        public C2015h read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return new C2015h(c2052a.mo5430s());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$i0 */
    class i0 extends AbstractC2077y<AtomicBoolean> {
        i0() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, AtomicBoolean atomicBoolean) throws IOException {
            c2055d.mo5445d(atomicBoolean.get());
        }

        @Override // com.google.gson.AbstractC2077y
        public AtomicBoolean read(C2052a c2052a) throws IOException {
            return new AtomicBoolean(c2052a.mo5424m());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$j */
    class j extends AbstractC2077y<StringBuilder> {
        j() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, StringBuilder sb) throws IOException {
            c2055d.mo5444d(sb == null ? null : sb.toString());
        }

        @Override // com.google.gson.AbstractC2077y
        public StringBuilder read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return new StringBuilder(c2052a.mo5430s());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$j0 */
    private static final class j0<T extends Enum<T>> extends AbstractC2077y<T> {

        /* renamed from: a */
        private final Map<String, T> f5857a = new HashMap();

        /* renamed from: b */
        private final Map<String, T> f5858b = new HashMap();

        /* renamed from: c */
        private final Map<T, String> f5859c = new HashMap();

        /* compiled from: TypeAdapters.java */
        /* renamed from: com.google.gson.b0.q.o$j0$a */
        class a implements PrivilegedAction<Field[]> {

            /* renamed from: a */
            final /* synthetic */ Class f5860a;

            a(Class cls) {
                this.f5860a = cls;
            }

            @Override // java.security.PrivilegedAction
            public Field[] run() {
                Field[] declaredFields = this.f5860a.getDeclaredFields();
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
                    String name = r4.name();
                    String str = r4.toString();
                    InterfaceC2003c interfaceC2003c = (InterfaceC2003c) field.getAnnotation(InterfaceC2003c.class);
                    if (interfaceC2003c != null) {
                        name = interfaceC2003c.value();
                        for (String str2 : interfaceC2003c.alternate()) {
                            this.f5857a.put(str2, r4);
                        }
                    }
                    this.f5857a.put(name, r4);
                    this.f5858b.put(str, r4);
                    this.f5859c.put(r4, name);
                }
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, T t) throws IOException {
            c2055d.mo5444d(t == null ? null : this.f5859c.get(t));
        }

        @Override // com.google.gson.AbstractC2077y
        public T read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            String mo5430s = c2052a.mo5430s();
            T t = this.f5857a.get(mo5430s);
            return t == null ? this.f5858b.get(mo5430s) : t;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$k */
    class k extends AbstractC2077y<Class> {
        k() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        @Override // com.google.gson.AbstractC2077y
        public Class read(C2052a c2052a) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$l */
    class l extends AbstractC2077y<StringBuffer> {
        l() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, StringBuffer stringBuffer) throws IOException {
            c2055d.mo5444d(stringBuffer == null ? null : stringBuffer.toString());
        }

        @Override // com.google.gson.AbstractC2077y
        public StringBuffer read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return new StringBuffer(c2052a.mo5430s());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$m */
    class m extends AbstractC2077y<URL> {
        m() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, URL url) throws IOException {
            c2055d.mo5444d(url == null ? null : url.toExternalForm());
        }

        @Override // com.google.gson.AbstractC2077y
        public URL read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            String mo5430s = c2052a.mo5430s();
            if (AbstractC1191a.f2571h.equals(mo5430s)) {
                return null;
            }
            return new URL(mo5430s);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$n */
    class n extends AbstractC2077y<URI> {
        n() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, URI uri) throws IOException {
            c2055d.mo5444d(uri == null ? null : uri.toASCIIString());
        }

        @Override // com.google.gson.AbstractC2077y
        public URI read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            try {
                String mo5430s = c2052a.mo5430s();
                if (AbstractC1191a.f2571h.equals(mo5430s)) {
                    return null;
                }
                return new URI(mo5430s);
            } catch (URISyntaxException e2) {
                throw new C2064l(e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$o */
    class o extends AbstractC2077y<InetAddress> {
        o() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, InetAddress inetAddress) throws IOException {
            c2055d.mo5444d(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        @Override // com.google.gson.AbstractC2077y
        public InetAddress read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return InetAddress.getByName(c2052a.mo5430s());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$p */
    class p extends AbstractC2077y<UUID> {
        p() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, UUID uuid) throws IOException {
            c2055d.mo5444d(uuid == null ? null : uuid.toString());
        }

        @Override // com.google.gson.AbstractC2077y
        public UUID read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            String mo5430s = c2052a.mo5430s();
            try {
                return UUID.fromString(mo5430s);
            } catch (IllegalArgumentException e2) {
                throw new C2072t("Failed parsing '" + mo5430s + "' as UUID; at path " + c2052a.mo5422i(), e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$q */
    class q extends AbstractC2077y<Currency> {
        q() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Currency currency) throws IOException {
            c2055d.mo5444d(currency.getCurrencyCode());
        }

        @Override // com.google.gson.AbstractC2077y
        public Currency read(C2052a c2052a) throws IOException {
            String mo5430s = c2052a.mo5430s();
            try {
                return Currency.getInstance(mo5430s);
            } catch (IllegalArgumentException e2) {
                throw new C2072t("Failed parsing '" + mo5430s + "' as Currency; at path " + c2052a.mo5422i(), e2);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$r */
    class r extends AbstractC2077y<Calendar> {

        /* renamed from: a */
        private static final String f5862a = "year";

        /* renamed from: b */
        private static final String f5863b = "month";

        /* renamed from: c */
        private static final String f5864c = "dayOfMonth";

        /* renamed from: d */
        private static final String f5865d = "hourOfDay";

        /* renamed from: e */
        private static final String f5866e = "minute";

        /* renamed from: f */
        private static final String f5867f = "second";

        r() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Calendar calendar) throws IOException {
            if (calendar == null) {
                c2055d.mo5448j();
                return;
            }
            c2055d.mo5443d();
            c2055d.mo5441b(f5862a);
            c2055d.mo5437a(calendar.get(1));
            c2055d.mo5441b(f5863b);
            c2055d.mo5437a(calendar.get(2));
            c2055d.mo5441b(f5864c);
            c2055d.mo5437a(calendar.get(5));
            c2055d.mo5441b(f5865d);
            c2055d.mo5437a(calendar.get(11));
            c2055d.mo5441b(f5866e);
            c2055d.mo5437a(calendar.get(12));
            c2055d.mo5441b(f5867f);
            c2055d.mo5437a(calendar.get(13));
            c2055d.mo5447f();
        }

        @Override // com.google.gson.AbstractC2077y
        public Calendar read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            c2052a.mo5418d();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (c2052a.peek() != EnumC2054c.END_OBJECT) {
                String mo5428q = c2052a.mo5428q();
                int mo5426o = c2052a.mo5426o();
                if (f5862a.equals(mo5428q)) {
                    i2 = mo5426o;
                } else if (f5863b.equals(mo5428q)) {
                    i3 = mo5426o;
                } else if (f5864c.equals(mo5428q)) {
                    i4 = mo5426o;
                } else if (f5865d.equals(mo5428q)) {
                    i5 = mo5426o;
                } else if (f5866e.equals(mo5428q)) {
                    i6 = mo5426o;
                } else if (f5867f.equals(mo5428q)) {
                    i7 = mo5426o;
                }
            }
            c2052a.mo5420g();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$s */
    class s extends AbstractC2077y<Locale> {
        s() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, Locale locale) throws IOException {
            c2055d.mo5444d(locale == null ? null : locale.toString());
        }

        @Override // com.google.gson.AbstractC2077y
        public Locale read(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(c2052a.mo5430s(), AbstractC1191a.f2606s1);
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$t */
    class t extends AbstractC2077y<AbstractC2063k> {
        t() {
        }

        /* renamed from: a */
        private AbstractC2063k m5515a(C2052a c2052a, EnumC2054c enumC2054c) throws IOException {
            int i2 = b0.f5856a[enumC2054c.ordinal()];
            if (i2 == 1) {
                return new C2068p(new C2015h(c2052a.mo5430s()));
            }
            if (i2 == 2) {
                return new C2068p(c2052a.mo5430s());
            }
            if (i2 == 3) {
                return new C2068p(Boolean.valueOf(c2052a.mo5424m()));
            }
            if (i2 == 6) {
                c2052a.mo5429r();
                return C2065m.f6026a;
            }
            throw new IllegalStateException("Unexpected token: " + enumC2054c);
        }

        /* renamed from: b */
        private AbstractC2063k m5516b(C2052a c2052a, EnumC2054c enumC2054c) throws IOException {
            int i2 = b0.f5856a[enumC2054c.ordinal()];
            if (i2 == 4) {
                c2052a.mo5417c();
                return new C2060h();
            }
            if (i2 != 5) {
                return null;
            }
            c2052a.mo5418d();
            return new JsonObject();
        }

        @Override // com.google.gson.AbstractC2077y
        public AbstractC2063k read(C2052a c2052a) throws IOException {
            if (c2052a instanceof C2029f) {
                return ((C2029f) c2052a).m5432u();
            }
            EnumC2054c peek = c2052a.peek();
            AbstractC2063k m5516b = m5516b(c2052a, peek);
            if (m5516b == null) {
                return m5515a(c2052a, peek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (c2052a.mo5423j()) {
                    String mo5428q = m5516b instanceof JsonObject ? c2052a.mo5428q() : null;
                    EnumC2054c peek2 = c2052a.peek();
                    AbstractC2063k m5516b2 = m5516b(c2052a, peek2);
                    boolean z = m5516b2 != null;
                    if (m5516b2 == null) {
                        m5516b2 = m5515a(c2052a, peek2);
                    }
                    if (m5516b instanceof C2060h) {
                        ((C2060h) m5516b).m5664a(m5516b2);
                    } else {
                        ((JsonObject) m5516b).add(mo5428q, m5516b2);
                    }
                    if (z) {
                        arrayDeque.addLast(m5516b);
                        m5516b = m5516b2;
                    }
                } else {
                    if (m5516b instanceof C2060h) {
                        c2052a.mo5419f();
                    } else {
                        c2052a.mo5420g();
                    }
                    if (arrayDeque.isEmpty()) {
                        return m5516b;
                    }
                    m5516b = (AbstractC2063k) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, AbstractC2063k abstractC2063k) throws IOException {
            if (abstractC2063k != null && !abstractC2063k.isJsonNull()) {
                if (abstractC2063k.isJsonPrimitive()) {
                    C2068p asJsonPrimitive = abstractC2063k.getAsJsonPrimitive();
                    if (asJsonPrimitive.m5680b()) {
                        c2055d.mo5439a(asJsonPrimitive.getAsNumber());
                        return;
                    } else if (asJsonPrimitive.m5679a()) {
                        c2055d.mo5445d(asJsonPrimitive.getAsBoolean());
                        return;
                    } else {
                        c2055d.mo5444d(asJsonPrimitive.getAsString());
                        return;
                    }
                }
                if (abstractC2063k.isJsonArray()) {
                    c2055d.mo5442c();
                    Iterator<AbstractC2063k> it = abstractC2063k.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        write(c2055d, it.next());
                    }
                    c2055d.mo5446e();
                    return;
                }
                if (abstractC2063k.isJsonObject()) {
                    c2055d.mo5443d();
                    for (Map.Entry<String, AbstractC2063k> entry : abstractC2063k.getAsJsonObject().entrySet()) {
                        c2055d.mo5441b(entry.getKey());
                        write(c2055d, entry.getValue());
                    }
                    c2055d.mo5447f();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + abstractC2063k.getClass());
            }
            c2055d.mo5448j();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$u */
    class u implements InterfaceC2078z {
        u() {
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            Class<? super T> rawType = c2049a.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new j0(rawType);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$v */
    class v extends AbstractC2077y<BitSet> {
        v() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a */
        public void write(C2055d c2055d, BitSet bitSet) throws IOException {
            c2055d.mo5442c();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                c2055d.mo5437a(bitSet.get(i2) ? 1L : 0L);
            }
            c2055d.mo5446e();
        }

        @Override // com.google.gson.AbstractC2077y
        public BitSet read(C2052a c2052a) throws IOException {
            boolean z;
            BitSet bitSet = new BitSet();
            c2052a.mo5417c();
            EnumC2054c peek = c2052a.peek();
            int i2 = 0;
            while (peek != EnumC2054c.END_ARRAY) {
                int i3 = b0.f5856a[peek.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    int mo5426o = c2052a.mo5426o();
                    if (mo5426o == 0) {
                        z = false;
                    } else {
                        if (mo5426o != 1) {
                            throw new C2072t("Invalid bitset value " + mo5426o + ", expected 0 or 1; at path " + c2052a.mo5422i());
                        }
                        z = true;
                    }
                } else {
                    if (i3 != 3) {
                        throw new C2072t("Invalid bitset value type: " + peek + "; at path " + c2052a.mo5421h());
                    }
                    z = c2052a.mo5424m();
                }
                if (z) {
                    bitSet.set(i2);
                }
                i2++;
                peek = c2052a.peek();
            }
            c2052a.mo5419f();
            return bitSet;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$w */
    class w implements InterfaceC2078z {

        /* renamed from: a */
        final /* synthetic */ C2049a f5868a;

        /* renamed from: b */
        final /* synthetic */ AbstractC2077y f5869b;

        w(C2049a c2049a, AbstractC2077y abstractC2077y) {
            this.f5868a = c2049a;
            this.f5869b = abstractC2077y;
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            if (c2049a.equals(this.f5868a)) {
                return this.f5869b;
            }
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$x */
    class x implements InterfaceC2078z {

        /* renamed from: a */
        final /* synthetic */ Class f5870a;

        /* renamed from: b */
        final /* synthetic */ AbstractC2077y f5871b;

        x(Class cls, AbstractC2077y abstractC2077y) {
            this.f5870a = cls;
            this.f5871b = abstractC2077y;
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            if (c2049a.getRawType() == this.f5870a) {
                return this.f5871b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5870a.getName() + ",adapter=" + this.f5871b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$y */
    class y implements InterfaceC2078z {

        /* renamed from: a */
        final /* synthetic */ Class f5872a;

        /* renamed from: b */
        final /* synthetic */ Class f5873b;

        /* renamed from: c */
        final /* synthetic */ AbstractC2077y f5874c;

        y(Class cls, Class cls2, AbstractC2077y abstractC2077y) {
            this.f5872a = cls;
            this.f5873b = cls2;
            this.f5874c = abstractC2077y;
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            Class<? super T> rawType = c2049a.getRawType();
            if (rawType == this.f5872a || rawType == this.f5873b) {
                return this.f5874c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5873b.getName() + "+" + this.f5872a.getName() + ",adapter=" + this.f5874c + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b0.q.o$z */
    class z implements InterfaceC2078z {

        /* renamed from: a */
        final /* synthetic */ Class f5875a;

        /* renamed from: b */
        final /* synthetic */ Class f5876b;

        /* renamed from: c */
        final /* synthetic */ AbstractC2077y f5877c;

        z(Class cls, Class cls2, AbstractC2077y abstractC2077y) {
            this.f5875a = cls;
            this.f5876b = cls2;
            this.f5877c = abstractC2077y;
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            Class<? super T> rawType = c2049a.getRawType();
            if (rawType == this.f5875a || rawType == this.f5876b) {
                return this.f5877c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5875a.getName() + "+" + this.f5876b.getName() + ",adapter=" + this.f5877c + "]";
        }
    }

    private C2038o() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public static <TT> InterfaceC2078z m5483a(C2049a<TT> c2049a, AbstractC2077y<TT> abstractC2077y) {
        return new w(c2049a, abstractC2077y);
    }

    /* renamed from: b */
    public static <TT> InterfaceC2078z m5487b(Class<TT> cls, Class<? extends TT> cls2, AbstractC2077y<? super TT> abstractC2077y) {
        return new z(cls, cls2, abstractC2077y);
    }

    /* renamed from: a */
    public static <TT> InterfaceC2078z m5484a(Class<TT> cls, AbstractC2077y<TT> abstractC2077y) {
        return new x(cls, abstractC2077y);
    }

    /* renamed from: b */
    public static <T1> InterfaceC2078z m5486b(Class<T1> cls, AbstractC2077y<T1> abstractC2077y) {
        return new a0(cls, abstractC2077y);
    }

    /* renamed from: a */
    public static <TT> InterfaceC2078z m5485a(Class<TT> cls, Class<TT> cls2, AbstractC2077y<? super TT> abstractC2077y) {
        return new y(cls, cls2, abstractC2077y);
    }
}
