package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LongSerializationPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static final u DEFAULT = new a("DEFAULT", 0);
    public static final u STRING = new u("STRING", 1) { // from class: com.google.gson.u.b
        {
            a aVar = null;
        }

        @Override // com.google.gson.u
        public k serialize(Long l2) {
            return l2 == null ? m.a : new p(l2.toString());
        }
    };
    private static final /* synthetic */ u[] a = {DEFAULT, STRING};

    /* JADX INFO: compiled from: LongSerializationPolicy.java */
    enum a extends u {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.gson.u
        public k serialize(Long l2) {
            return l2 == null ? m.a : new p(l2);
        }
    }

    private u(String str, int i2) {
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) a.clone();
    }

    public abstract k serialize(Long l2);

    /* synthetic */ u(String str, int i2, a aVar) {
        this(str, i2);
    }
}
