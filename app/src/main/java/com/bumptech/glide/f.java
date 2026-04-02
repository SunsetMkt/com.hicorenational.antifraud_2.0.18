package com.bumptech.glide;

/* JADX INFO: compiled from: MemoryCategory.java */
/* JADX INFO: loaded from: classes.dex */
public enum f {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);

    private final float multiplier;

    f(float f2) {
        this.multiplier = f2;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
