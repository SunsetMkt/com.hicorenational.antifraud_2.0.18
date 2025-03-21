package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2063k;
import com.google.gson.C2060h;
import com.google.gson.C2065m;
import com.google.gson.C2068p;
import com.google.gson.JsonObject;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2056e;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import p286h.p323z2.C5736h0;

/* compiled from: JsonTreeReader.java */
/* renamed from: com.google.gson.b0.q.f */
/* loaded from: classes.dex */
public final class C2029f extends C2052a {

    /* renamed from: h0 */
    private static final Reader f5733h0 = new a();

    /* renamed from: i0 */
    private static final Object f5734i0 = new Object();

    /* renamed from: d0 */
    private Object[] f5735d0;

    /* renamed from: e0 */
    private int f5736e0;

    /* renamed from: f0 */
    private String[] f5737f0;

    /* renamed from: g0 */
    private int[] f5738g0;

    /* compiled from: JsonTreeReader.java */
    /* renamed from: com.google.gson.b0.q.f$a */
    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    /* compiled from: JsonTreeReader.java */
    /* renamed from: com.google.gson.b0.q.f$b */
    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f5739a = new int[EnumC2054c.values().length];

        static {
            try {
                f5739a[EnumC2054c.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5739a[EnumC2054c.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5739a[EnumC2054c.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5739a[EnumC2054c.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C2029f(AbstractC2063k abstractC2063k) {
        super(f5733h0);
        this.f5735d0 = new Object[32];
        this.f5736e0 = 0;
        this.f5737f0 = new String[32];
        this.f5738g0 = new int[32];
        m5411a(abstractC2063k);
    }

    /* renamed from: a */
    private void m5410a(EnumC2054c enumC2054c) throws IOException {
        if (peek() == enumC2054c) {
            return;
        }
        throw new IllegalStateException("Expected " + enumC2054c + " but was " + peek() + m5414l());
    }

    /* renamed from: b */
    private String m5412b(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(C5736h0.f20713b);
        int i2 = 0;
        while (true) {
            int i3 = this.f5736e0;
            if (i2 >= i3) {
                return sb.toString();
            }
            Object[] objArr = this.f5735d0;
            if (objArr[i2] instanceof C2060h) {
                i2++;
                if (i2 < i3 && (objArr[i2] instanceof Iterator)) {
                    int i4 = this.f5738g0[i2];
                    if (z && i4 > 0 && (i2 == i3 - 1 || i2 == i3 - 2)) {
                        i4--;
                    }
                    sb.append('[');
                    sb.append(i4);
                    sb.append(']');
                }
            } else if ((objArr[i2] instanceof JsonObject) && (i2 = i2 + 1) < i3 && (objArr[i2] instanceof Iterator)) {
                sb.append('.');
                String[] strArr = this.f5737f0;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
            i2++;
        }
    }

    /* renamed from: l */
    private String m5414l() {
        return " at path " + mo5421h();
    }

    /* renamed from: w */
    private Object m5415w() {
        return this.f5735d0[this.f5736e0 - 1];
    }

    /* renamed from: x */
    private Object m5416x() {
        Object[] objArr = this.f5735d0;
        int i2 = this.f5736e0 - 1;
        this.f5736e0 = i2;
        Object obj = objArr[i2];
        objArr[this.f5736e0] = null;
        return obj;
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: c */
    public void mo5417c() throws IOException {
        m5410a(EnumC2054c.BEGIN_ARRAY);
        m5411a(((C2060h) m5415w()).iterator());
        this.f5738g0[this.f5736e0 - 1] = 0;
    }

    @Override // com.google.gson.p153e0.C2052a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5735d0 = new Object[]{f5734i0};
        this.f5736e0 = 1;
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: d */
    public void mo5418d() throws IOException {
        m5410a(EnumC2054c.BEGIN_OBJECT);
        m5411a(((JsonObject) m5415w()).entrySet().iterator());
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: f */
    public void mo5419f() throws IOException {
        m5410a(EnumC2054c.END_ARRAY);
        m5416x();
        m5416x();
        int i2 = this.f5736e0;
        if (i2 > 0) {
            int[] iArr = this.f5738g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: g */
    public void mo5420g() throws IOException {
        m5410a(EnumC2054c.END_OBJECT);
        this.f5737f0[this.f5736e0 - 1] = null;
        m5416x();
        m5416x();
        int i2 = this.f5736e0;
        if (i2 > 0) {
            int[] iArr = this.f5738g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: h */
    public String mo5421h() {
        return m5412b(false);
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: i */
    public String mo5422i() {
        return m5412b(true);
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: j */
    public boolean mo5423j() throws IOException {
        EnumC2054c peek = peek();
        return (peek == EnumC2054c.END_OBJECT || peek == EnumC2054c.END_ARRAY || peek == EnumC2054c.END_DOCUMENT) ? false : true;
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: m */
    public boolean mo5424m() throws IOException {
        m5410a(EnumC2054c.BOOLEAN);
        boolean asBoolean = ((C2068p) m5416x()).getAsBoolean();
        int i2 = this.f5736e0;
        if (i2 > 0) {
            int[] iArr = this.f5738g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: n */
    public double mo5425n() throws IOException {
        EnumC2054c peek = peek();
        if (peek != EnumC2054c.NUMBER && peek != EnumC2054c.STRING) {
            throw new IllegalStateException("Expected " + EnumC2054c.NUMBER + " but was " + peek + m5414l());
        }
        double asDouble = ((C2068p) m5415w()).getAsDouble();
        if (!m5611k() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new C2056e("JSON forbids NaN and infinities: " + asDouble);
        }
        m5416x();
        int i2 = this.f5736e0;
        if (i2 > 0) {
            int[] iArr = this.f5738g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: o */
    public int mo5426o() throws IOException {
        EnumC2054c peek = peek();
        if (peek != EnumC2054c.NUMBER && peek != EnumC2054c.STRING) {
            throw new IllegalStateException("Expected " + EnumC2054c.NUMBER + " but was " + peek + m5414l());
        }
        int asInt = ((C2068p) m5415w()).getAsInt();
        m5416x();
        int i2 = this.f5736e0;
        if (i2 > 0) {
            int[] iArr = this.f5738g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: p */
    public long mo5427p() throws IOException {
        EnumC2054c peek = peek();
        if (peek != EnumC2054c.NUMBER && peek != EnumC2054c.STRING) {
            throw new IllegalStateException("Expected " + EnumC2054c.NUMBER + " but was " + peek + m5414l());
        }
        long asLong = ((C2068p) m5415w()).getAsLong();
        m5416x();
        int i2 = this.f5736e0;
        if (i2 > 0) {
            int[] iArr = this.f5738g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.p153e0.C2052a
    public EnumC2054c peek() throws IOException {
        if (this.f5736e0 == 0) {
            return EnumC2054c.END_DOCUMENT;
        }
        Object m5415w = m5415w();
        if (m5415w instanceof Iterator) {
            boolean z = this.f5735d0[this.f5736e0 - 2] instanceof JsonObject;
            Iterator it = (Iterator) m5415w;
            if (!it.hasNext()) {
                return z ? EnumC2054c.END_OBJECT : EnumC2054c.END_ARRAY;
            }
            if (z) {
                return EnumC2054c.NAME;
            }
            m5411a(it.next());
            return peek();
        }
        if (m5415w instanceof JsonObject) {
            return EnumC2054c.BEGIN_OBJECT;
        }
        if (m5415w instanceof C2060h) {
            return EnumC2054c.BEGIN_ARRAY;
        }
        if (m5415w instanceof C2068p) {
            C2068p c2068p = (C2068p) m5415w;
            if (c2068p.m5681c()) {
                return EnumC2054c.STRING;
            }
            if (c2068p.m5679a()) {
                return EnumC2054c.BOOLEAN;
            }
            if (c2068p.m5680b()) {
                return EnumC2054c.NUMBER;
            }
            throw new AssertionError();
        }
        if (m5415w instanceof C2065m) {
            return EnumC2054c.NULL;
        }
        if (m5415w == f5734i0) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new C2056e("Custom JsonElement subclass " + m5415w.getClass().getName() + " is not supported");
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: q */
    public String mo5428q() throws IOException {
        return m5413c(false);
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: r */
    public void mo5429r() throws IOException {
        m5410a(EnumC2054c.NULL);
        m5416x();
        int i2 = this.f5736e0;
        if (i2 > 0) {
            int[] iArr = this.f5738g0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: s */
    public String mo5430s() throws IOException {
        EnumC2054c peek = peek();
        if (peek == EnumC2054c.STRING || peek == EnumC2054c.NUMBER) {
            String asString = ((C2068p) m5416x()).getAsString();
            int i2 = this.f5736e0;
            if (i2 > 0) {
                int[] iArr = this.f5738g0;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return asString;
        }
        throw new IllegalStateException("Expected " + EnumC2054c.STRING + " but was " + peek + m5414l());
    }

    @Override // com.google.gson.p153e0.C2052a
    /* renamed from: t */
    public void mo5431t() throws IOException {
        int i2 = b.f5739a[peek().ordinal()];
        if (i2 == 1) {
            m5413c(true);
            return;
        }
        if (i2 == 2) {
            mo5419f();
            return;
        }
        if (i2 == 3) {
            mo5420g();
            return;
        }
        if (i2 != 4) {
            m5416x();
            int i3 = this.f5736e0;
            if (i3 > 0) {
                int[] iArr = this.f5738g0;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
        }
    }

    @Override // com.google.gson.p153e0.C2052a
    public String toString() {
        return C2029f.class.getSimpleName() + m5414l();
    }

    /* renamed from: u */
    AbstractC2063k m5432u() throws IOException {
        EnumC2054c peek = peek();
        if (peek != EnumC2054c.NAME && peek != EnumC2054c.END_ARRAY && peek != EnumC2054c.END_OBJECT && peek != EnumC2054c.END_DOCUMENT) {
            AbstractC2063k abstractC2063k = (AbstractC2063k) m5415w();
            mo5431t();
            return abstractC2063k;
        }
        throw new IllegalStateException("Unexpected " + peek + " when reading a JsonElement.");
    }

    /* renamed from: v */
    public void m5433v() throws IOException {
        m5410a(EnumC2054c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m5415w()).next();
        m5411a(entry.getValue());
        m5411a(new C2068p((String) entry.getKey()));
    }

    /* renamed from: a */
    private void m5411a(Object obj) {
        int i2 = this.f5736e0;
        Object[] objArr = this.f5735d0;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            this.f5735d0 = Arrays.copyOf(objArr, i3);
            this.f5738g0 = Arrays.copyOf(this.f5738g0, i3);
            this.f5737f0 = (String[]) Arrays.copyOf(this.f5737f0, i3);
        }
        Object[] objArr2 = this.f5735d0;
        int i4 = this.f5736e0;
        this.f5736e0 = i4 + 1;
        objArr2[i4] = obj;
    }

    /* renamed from: c */
    private String m5413c(boolean z) throws IOException {
        m5410a(EnumC2054c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m5415w()).next();
        String str = (String) entry.getKey();
        this.f5737f0[this.f5736e0 - 1] = z ? "<skipped>" : str;
        m5411a(entry.getValue());
        return str;
    }
}
