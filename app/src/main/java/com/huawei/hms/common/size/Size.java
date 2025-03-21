package com.huawei.hms.common.size;

import com.huawei.hms.common.internal.Objects;

/* loaded from: classes.dex */
public class Size {

    /* renamed from: a */
    private final int f7305a;

    /* renamed from: b */
    private final int f7306b;

    public Size(int i2, int i3) {
        this.f7305a = i2;
        this.f7306b = i3;
    }

    public static Size parseSize(String str) {
        try {
            int indexOf = str.indexOf("x");
            if (indexOf < 0) {
                indexOf = str.indexOf("*");
            }
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f7305a == size.f7305a && this.f7306b == size.f7306b;
    }

    public final int getHeight() {
        return this.f7306b;
    }

    public final int getWidth() {
        return this.f7305a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        return "Width is " + this.f7305a + " Height is " + this.f7306b;
    }
}
