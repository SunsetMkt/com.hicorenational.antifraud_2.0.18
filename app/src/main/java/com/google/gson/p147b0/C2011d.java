package com.google.gson.p147b0;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2007b;
import com.google.gson.C2051e;
import com.google.gson.InterfaceC2000a;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p146a0.InterfaceC2001a;
import com.google.gson.p146a0.InterfaceC2004d;
import com.google.gson.p146a0.InterfaceC2005e;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Excluder.java */
/* renamed from: com.google.gson.b0.d */
/* loaded from: classes.dex */
public final class C2011d implements InterfaceC2078z, Cloneable {

    /* renamed from: g */
    private static final double f5671g = -1.0d;

    /* renamed from: h */
    public static final C2011d f5672h = new C2011d();

    /* renamed from: d */
    private boolean f5676d;

    /* renamed from: a */
    private double f5673a = f5671g;

    /* renamed from: b */
    private int f5674b = 136;

    /* renamed from: c */
    private boolean f5675c = true;

    /* renamed from: e */
    private List<InterfaceC2000a> f5677e = Collections.emptyList();

    /* renamed from: f */
    private List<InterfaceC2000a> f5678f = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* renamed from: com.google.gson.b0.d$a */
    class a<T> extends AbstractC2077y<T> {

        /* renamed from: a */
        private AbstractC2077y<T> f5679a;

        /* renamed from: b */
        final /* synthetic */ boolean f5680b;

        /* renamed from: c */
        final /* synthetic */ boolean f5681c;

        /* renamed from: d */
        final /* synthetic */ C2051e f5682d;

        /* renamed from: e */
        final /* synthetic */ C2049a f5683e;

        a(boolean z, boolean z2, C2051e c2051e, C2049a c2049a) {
            this.f5680b = z;
            this.f5681c = z2;
            this.f5682d = c2051e;
            this.f5683e = c2049a;
        }

        /* renamed from: a */
        private AbstractC2077y<T> m5355a() {
            AbstractC2077y<T> abstractC2077y = this.f5679a;
            if (abstractC2077y != null) {
                return abstractC2077y;
            }
            AbstractC2077y<T> m5558a = this.f5682d.m5558a(C2011d.this, this.f5683e);
            this.f5679a = m5558a;
            return m5558a;
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: read */
        public T read2(C2052a c2052a) throws IOException {
            if (!this.f5680b) {
                return m5355a().read2(c2052a);
            }
            c2052a.mo5431t();
            return null;
        }

        @Override // com.google.gson.AbstractC2077y
        public void write(C2055d c2055d, T t) throws IOException {
            if (this.f5681c) {
                c2055d.mo5448j();
            } else {
                m5355a().write(c2055d, t);
            }
        }
    }

    /* renamed from: c */
    private boolean m5346c(Class<?> cls) {
        return cls.isMemberClass() && !m5347d(cls);
    }

    /* renamed from: d */
    private boolean m5347d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* renamed from: a */
    public C2011d m5349a(double d2) {
        C2011d m26852clone = m26852clone();
        m26852clone.f5673a = d2;
        return m26852clone;
    }

    /* renamed from: b */
    public C2011d m5354b() {
        C2011d m26852clone = m26852clone();
        m26852clone.f5676d = true;
        return m26852clone;
    }

    @Override // com.google.gson.InterfaceC2078z
    public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
        Class<? super T> rawType = c2049a.getRawType();
        boolean m5343a = m5343a(rawType);
        boolean z = m5343a || m5345b(rawType, true);
        boolean z2 = m5343a || m5345b(rawType, false);
        if (z || z2) {
            return new a(z2, z, c2051e, c2049a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C2011d m26852clone() {
        try {
            return (C2011d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: b */
    private boolean m5345b(Class<?> cls, boolean z) {
        Iterator<InterfaceC2000a> it = (z ? this.f5677e : this.f5678f).iterator();
        while (it.hasNext()) {
            if (it.next().m5302a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public C2011d m5351a(int... iArr) {
        C2011d m26852clone = m26852clone();
        m26852clone.f5674b = 0;
        for (int i2 : iArr) {
            m26852clone.f5674b = i2 | m26852clone.f5674b;
        }
        return m26852clone;
    }

    /* renamed from: b */
    private boolean m5344b(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || m5347d(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    /* renamed from: a */
    public C2011d m5348a() {
        C2011d m26852clone = m26852clone();
        m26852clone.f5675c = false;
        return m26852clone;
    }

    /* renamed from: a */
    public C2011d m5350a(InterfaceC2000a interfaceC2000a, boolean z, boolean z2) {
        C2011d m26852clone = m26852clone();
        if (z) {
            m26852clone.f5677e = new ArrayList(this.f5677e);
            m26852clone.f5677e.add(interfaceC2000a);
        }
        if (z2) {
            m26852clone.f5678f = new ArrayList(this.f5678f);
            m26852clone.f5678f.add(interfaceC2000a);
        }
        return m26852clone;
    }

    /* renamed from: a */
    public boolean m5353a(Field field, boolean z) {
        InterfaceC2001a interfaceC2001a;
        if ((this.f5674b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f5673a != f5671g && !m5341a((InterfaceC2004d) field.getAnnotation(InterfaceC2004d.class), (InterfaceC2005e) field.getAnnotation(InterfaceC2005e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f5676d && ((interfaceC2001a = (InterfaceC2001a) field.getAnnotation(InterfaceC2001a.class)) == null || (!z ? interfaceC2001a.deserialize() : interfaceC2001a.serialize()))) {
            return true;
        }
        if ((!this.f5675c && m5346c(field.getType())) || m5344b(field.getType())) {
            return true;
        }
        List<InterfaceC2000a> list = z ? this.f5677e : this.f5678f;
        if (list.isEmpty()) {
            return false;
        }
        C2007b c2007b = new C2007b(field);
        Iterator<InterfaceC2000a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().m5301a(c2007b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m5343a(Class<?> cls) {
        if (this.f5673a != f5671g && !m5341a((InterfaceC2004d) cls.getAnnotation(InterfaceC2004d.class), (InterfaceC2005e) cls.getAnnotation(InterfaceC2005e.class))) {
            return true;
        }
        if (this.f5675c || !m5346c(cls)) {
            return m5344b(cls);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m5352a(Class<?> cls, boolean z) {
        return m5343a(cls) || m5345b(cls, z);
    }

    /* renamed from: a */
    private boolean m5341a(InterfaceC2004d interfaceC2004d, InterfaceC2005e interfaceC2005e) {
        return m5340a(interfaceC2004d) && m5342a(interfaceC2005e);
    }

    /* renamed from: a */
    private boolean m5340a(InterfaceC2004d interfaceC2004d) {
        if (interfaceC2004d != null) {
            return this.f5673a >= interfaceC2004d.value();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m5342a(InterfaceC2005e interfaceC2005e) {
        if (interfaceC2005e != null) {
            return this.f5673a < interfaceC2005e.value();
        }
        return true;
    }
}
