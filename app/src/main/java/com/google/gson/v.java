package com.google.gson;

/* JADX INFO: compiled from: ReflectionAccessFilter.java */
/* JADX INFO: loaded from: classes.dex */
public interface v {
    public static final v a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f3830b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f3831c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f3832d = new d();

    /* JADX INFO: compiled from: ReflectionAccessFilter.java */
    class a implements v {
        a() {
        }

        @Override // com.google.gson.v
        public e a(Class<?> cls) {
            return com.google.gson.b0.n.c(cls) ? e.BLOCK_INACCESSIBLE : e.INDECISIVE;
        }
    }

    /* JADX INFO: compiled from: ReflectionAccessFilter.java */
    class b implements v {
        b() {
        }

        @Override // com.google.gson.v
        public e a(Class<?> cls) {
            return com.google.gson.b0.n.c(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* JADX INFO: compiled from: ReflectionAccessFilter.java */
    class c implements v {
        c() {
        }

        @Override // com.google.gson.v
        public e a(Class<?> cls) {
            return com.google.gson.b0.n.a(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* JADX INFO: compiled from: ReflectionAccessFilter.java */
    class d implements v {
        d() {
        }

        @Override // com.google.gson.v
        public e a(Class<?> cls) {
            return com.google.gson.b0.n.b(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* JADX INFO: compiled from: ReflectionAccessFilter.java */
    public enum e {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    e a(Class<?> cls);
}
