package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* renamed from: com.google.gson.c */
/* loaded from: classes.dex */
public abstract class EnumC2046c implements InterfaceC2048d {
    public static final EnumC2046c IDENTITY = new a("IDENTITY", 0);
    public static final EnumC2046c UPPER_CAMEL_CASE = new EnumC2046c("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.c.b
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2048d
        public String translateName(Field field) {
            return EnumC2046c.upperCaseFirstLetter(field.getName());
        }
    };
    public static final EnumC2046c UPPER_CAMEL_CASE_WITH_SPACES = new EnumC2046c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.c.c
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2048d
        public String translateName(Field field) {
            return EnumC2046c.upperCaseFirstLetter(EnumC2046c.separateCamelCase(field.getName(), ' '));
        }
    };
    public static final EnumC2046c UPPER_CASE_WITH_UNDERSCORES = new EnumC2046c("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.c.d
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2048d
        public String translateName(Field field) {
            return EnumC2046c.separateCamelCase(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    };
    public static final EnumC2046c LOWER_CASE_WITH_UNDERSCORES = new EnumC2046c("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: com.google.gson.c.e
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2048d
        public String translateName(Field field) {
            return EnumC2046c.separateCamelCase(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    };
    public static final EnumC2046c LOWER_CASE_WITH_DASHES = new EnumC2046c("LOWER_CASE_WITH_DASHES", 5) { // from class: com.google.gson.c.f
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2048d
        public String translateName(Field field) {
            return EnumC2046c.separateCamelCase(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    };
    public static final EnumC2046c LOWER_CASE_WITH_DOTS = new EnumC2046c("LOWER_CASE_WITH_DOTS", 6) { // from class: com.google.gson.c.g
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2048d
        public String translateName(Field field) {
            return EnumC2046c.separateCamelCase(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: a */
    private static final /* synthetic */ EnumC2046c[] f5897a = {IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, UPPER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES, LOWER_CASE_WITH_DOTS};

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: com.google.gson.c$a */
    enum a extends EnumC2046c {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.gson.InterfaceC2048d
        public String translateName(Field field) {
            return field.getName();
        }
    }

    private EnumC2046c(String str, int i2) {
    }

    static String separateCamelCase(String str, char c2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String upperCaseFirstLetter(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isLetter(charAt)) {
                if (Character.isUpperCase(charAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(charAt);
                if (i2 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
            }
        }
        return str;
    }

    public static EnumC2046c valueOf(String str) {
        return (EnumC2046c) Enum.valueOf(EnumC2046c.class, str);
    }

    public static EnumC2046c[] values() {
        return (EnumC2046c[]) f5897a.clone();
    }

    /* synthetic */ EnumC2046c(String str, int i2, a aVar) {
        this(str, i2);
    }
}
