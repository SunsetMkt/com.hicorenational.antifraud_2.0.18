package com.umeng.analytics.pro;

import com.umeng.analytics.pro.InterfaceC3360bq;
import com.umeng.analytics.pro.InterfaceC3367bx;
import java.io.Serializable;

/* compiled from: TBase.java */
/* renamed from: com.umeng.analytics.pro.bq */
/* loaded from: classes2.dex */
public interface InterfaceC3360bq<T extends InterfaceC3360bq<?, ?>, F extends InterfaceC3367bx> extends Serializable {
    void clear();

    InterfaceC3360bq<T, F> deepCopy();

    F fieldForId(int i2);

    void read(AbstractC3386cp abstractC3386cp) throws C3366bw;

    void write(AbstractC3386cp abstractC3386cp) throws C3366bw;
}
