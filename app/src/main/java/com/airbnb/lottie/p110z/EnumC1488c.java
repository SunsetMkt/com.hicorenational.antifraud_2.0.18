package com.airbnb.lottie.p110z;

import com.airbnb.lottie.p100b0.C1354d;

/* compiled from: FileExtension.java */
/* renamed from: com.airbnb.lottie.z.c */
/* loaded from: classes.dex */
public enum EnumC1488c {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    EnumC1488c(String str) {
        this.extension = str;
    }

    public static EnumC1488c forFile(String str) {
        for (EnumC1488c enumC1488c : values()) {
            if (str.endsWith(enumC1488c.extension)) {
                return enumC1488c;
            }
        }
        C1354d.m2791b("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
