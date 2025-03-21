package com.bumptech.glide;

/* compiled from: MemoryCategory.java */
/* renamed from: com.bumptech.glide.f */
/* loaded from: classes.dex */
public enum EnumC1580f {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);

    private final float multiplier;

    EnumC1580f(float f2) {
        this.multiplier = f2;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
