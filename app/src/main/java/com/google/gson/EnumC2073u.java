package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* renamed from: com.google.gson.u */
/* loaded from: classes.dex */
public abstract class EnumC2073u {
    public static final EnumC2073u DEFAULT = new a("DEFAULT", 0);
    public static final EnumC2073u STRING = new EnumC2073u("STRING", 1) { // from class: com.google.gson.u.b
        {
            a aVar = null;
        }

        @Override // com.google.gson.EnumC2073u
        public AbstractC2063k serialize(Long l2) {
            return l2 == null ? C2065m.f6026a : new C2068p(l2.toString());
        }
    };

    /* renamed from: a */
    private static final /* synthetic */ EnumC2073u[] f6030a = {DEFAULT, STRING};

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: com.google.gson.u$a */
    enum a extends EnumC2073u {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.gson.EnumC2073u
        public AbstractC2063k serialize(Long l2) {
            return l2 == null ? C2065m.f6026a : new C2068p(l2);
        }
    }

    private EnumC2073u(String str, int i2) {
    }

    public static EnumC2073u valueOf(String str) {
        return (EnumC2073u) Enum.valueOf(EnumC2073u.class, str);
    }

    public static EnumC2073u[] values() {
        return (EnumC2073u[]) f6030a.clone();
    }

    public abstract AbstractC2063k serialize(Long l2);

    /* synthetic */ EnumC2073u(String str, int i2, a aVar) {
        this(str, i2);
    }
}
