package com.google.gson;

import com.google.gson.p147b0.C2021n;

/* compiled from: ReflectionAccessFilter.java */
/* renamed from: com.google.gson.v */
/* loaded from: classes.dex */
public interface InterfaceC2074v {

    /* renamed from: a */
    public static final InterfaceC2074v f6031a = new a();

    /* renamed from: b */
    public static final InterfaceC2074v f6032b = new b();

    /* renamed from: c */
    public static final InterfaceC2074v f6033c = new c();

    /* renamed from: d */
    public static final InterfaceC2074v f6034d = new d();

    /* compiled from: ReflectionAccessFilter.java */
    /* renamed from: com.google.gson.v$a */
    class a implements InterfaceC2074v {
        a() {
        }

        @Override // com.google.gson.InterfaceC2074v
        /* renamed from: a */
        public e mo5683a(Class<?> cls) {
            return C2021n.m5388c(cls) ? e.BLOCK_INACCESSIBLE : e.INDECISIVE;
        }
    }

    /* compiled from: ReflectionAccessFilter.java */
    /* renamed from: com.google.gson.v$b */
    class b implements InterfaceC2074v {
        b() {
        }

        @Override // com.google.gson.InterfaceC2074v
        /* renamed from: a */
        public e mo5683a(Class<?> cls) {
            return C2021n.m5388c(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* compiled from: ReflectionAccessFilter.java */
    /* renamed from: com.google.gson.v$c */
    class c implements InterfaceC2074v {
        c() {
        }

        @Override // com.google.gson.InterfaceC2074v
        /* renamed from: a */
        public e mo5683a(Class<?> cls) {
            return C2021n.m5383a(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* compiled from: ReflectionAccessFilter.java */
    /* renamed from: com.google.gson.v$d */
    class d implements InterfaceC2074v {
        d() {
        }

        @Override // com.google.gson.InterfaceC2074v
        /* renamed from: a */
        public e mo5683a(Class<?> cls) {
            return C2021n.m5386b(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* compiled from: ReflectionAccessFilter.java */
    /* renamed from: com.google.gson.v$e */
    public enum e {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    /* renamed from: a */
    e mo5683a(Class<?> cls);
}
