package com.chad.library.adapter.base.p143b;

import java.io.Serializable;

/* compiled from: SectionEntity.java */
/* renamed from: com.chad.library.adapter.base.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC1913d<T> implements Serializable {
    public String header;
    public boolean isHeader;

    /* renamed from: t */
    public T f5612t;

    public AbstractC1913d(boolean z, String str) {
        this.isHeader = z;
        this.header = str;
        this.f5612t = null;
    }

    public AbstractC1913d(T t) {
        this.isHeader = false;
        this.header = null;
        this.f5612t = t;
    }
}
