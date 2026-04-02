package com.chad.library.adapter.base.b;

import java.io.Serializable;

/* JADX INFO: compiled from: SectionEntity.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<T> implements Serializable {
    public String header;
    public boolean isHeader;
    public T t;

    public d(boolean z, String str) {
        this.isHeader = z;
        this.header = str;
        this.t = null;
    }

    public d(T t) {
        this.isHeader = false;
        this.header = null;
        this.t = t;
    }
}
