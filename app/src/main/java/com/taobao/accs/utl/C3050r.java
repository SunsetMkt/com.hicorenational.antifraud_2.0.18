package com.taobao.accs.utl;

import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.r */
/* loaded from: classes2.dex */
public class C3050r extends ByteArrayOutputStream {
    public C3050r(int i2) {
        super(i2);
    }

    /* renamed from: a */
    public C3050r m9267a(byte b2) {
        write(b2);
        return this;
    }

    public C3050r() {
    }

    /* renamed from: a */
    public C3050r m9268a(short s) {
        write(s >> 8);
        write(s);
        return this;
    }
}
