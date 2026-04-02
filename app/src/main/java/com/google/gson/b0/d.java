package com.google.gson.b0;

import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Excluder.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements z, Cloneable {

    /* JADX INFO: renamed from: g */
    private static final double f3647g = -1.0d;

    /* JADX INFO: renamed from: h */
    public static final d f3648h = new d();

    /* JADX INFO: renamed from: d */
    private boolean f3651d;
    private double a = f3647g;

    /* JADX INFO: renamed from: b */
    private int f3649b = 136;

    /* JADX INFO: renamed from: c */
    private boolean f3650c = true;

    /* JADX INFO: renamed from: e */
    private List<com.google.gson.a> f3652e = Collections.emptyList();

    /* JADX INFO: renamed from: f */
    private List<com.google.gson.a> f3653f = Collections.emptyList();

    /* JADX INFO: compiled from: Excluder.java */
    class a<T> extends y<T> {
        private y<T> a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ boolean f3654b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ boolean f3655c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ com.google.gson.e f3656d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ com.google.gson.d0.a f3657e;

        a(boolean z, boolean z2, com.google.gson.e eVar, com.google.gson.d0.a aVar) {
            this.f3654b = z;
            this.f3655c = z2;
            this.f3656d = eVar;
            this.f3657e = aVar;
        }

        private y<T> a() {
            y<T> yVar = this.a;
            if (yVar != null) {
                return yVar;
            }
            y<T> yVarA = this.f3656d.a(d.this, this.f3657e);
            this.a = yVarA;
            return yVarA;
        }

        @Override // com.google.gson.y
        public T read(com.google.gson.e0.a aVar) throws IOException {
            if (!this.f3654b) {
                return a().read(aVar);
            }
            aVar.t();
            return null;
        }

        @Override // com.google.gson.y
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            if (this.f3655c) {
                dVar.j();
            } else {
                a().write(dVar, t);
            }
        }
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public d a(double d2) {
        d dVarM36clone = m36clone();
        dVarM36clone.a = d2;
        return dVarM36clone;
    }

    public d b() {
        d dVarM36clone = m36clone();
        dVarM36clone.f3651d = true;
        return dVarM36clone;
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean zA = a(rawType);
        boolean z = zA || b(rawType, true);
        boolean z2 = zA || b(rawType, false);
        if (z || z2) {
            return new a(z2, z, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: renamed from: clone */
    public d m36clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean b(Class<?> cls, boolean z) {
        Iterator<com.google.gson.a> it = (z ? this.f3652e : this.f3653f).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    public d a(int... iArr) {
        d dVarM36clone = m36clone();
        dVarM36clone.f3649b = 0;
        for (int i2 : iArr) {
            dVarM36clone.f3649b = i2 | dVarM36clone.f3649b;
        }
        return dVarM36clone;
    }

    private boolean b(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || d(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    public d a() {
        d dVarM36clone = m36clone();
        dVarM36clone.f3650c = false;
        return dVarM36clone;
    }

    public d a(com.google.gson.a aVar, boolean z, boolean z2) {
        d dVarM36clone = m36clone();
        if (z) {
            dVarM36clone.f3652e = new ArrayList(this.f3652e);
            dVarM36clone.f3652e.add(aVar);
        }
        if (z2) {
            dVarM36clone.f3653f = new ArrayList(this.f3653f);
            dVarM36clone.f3653f.add(aVar);
        }
        return dVarM36clone;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a0.a aVar;
        if ((this.f3649b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.a != f3647g && !a((com.google.gson.a0.d) field.getAnnotation(com.google.gson.a0.d.class), (com.google.gson.a0.e) field.getAnnotation(com.google.gson.a0.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f3651d && ((aVar = (com.google.gson.a0.a) field.getAnnotation(com.google.gson.a0.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f3650c && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<com.google.gson.a> list = z ? this.f3652e : this.f3653f;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.b bVar = new com.google.gson.b(field);
        Iterator<com.google.gson.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(bVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> cls) {
        if (this.a != f3647g && !a((com.google.gson.a0.d) cls.getAnnotation(com.google.gson.a0.d.class), (com.google.gson.a0.e) cls.getAnnotation(com.google.gson.a0.e.class))) {
            return true;
        }
        if (this.f3650c || !c(cls)) {
            return b(cls);
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean a(com.google.gson.a0.d dVar, com.google.gson.a0.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a0.d dVar) {
        if (dVar != null) {
            return this.a >= dVar.value();
        }
        return true;
    }

    private boolean a(com.google.gson.a0.e eVar) {
        if (eVar != null) {
            return this.a < eVar.value();
        }
        return true;
    }
}
