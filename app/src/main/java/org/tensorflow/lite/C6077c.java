package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Interpreter.java */
/* renamed from: org.tensorflow.lite.c */
/* loaded from: classes2.dex */
public final class C6077c implements AutoCloseable {

    /* renamed from: a */
    NativeInterpreterWrapper f21687a;

    /* compiled from: Interpreter.java */
    /* renamed from: org.tensorflow.lite.c$a */
    public static class a {

        /* renamed from: b */
        Boolean f21689b;

        /* renamed from: c */
        Boolean f21690c;

        /* renamed from: d */
        Boolean f21691d;

        /* renamed from: a */
        int f21688a = -1;

        /* renamed from: e */
        final List<InterfaceC6076b> f21692e = new ArrayList();

        /* renamed from: a */
        public a m25154a(int i2) {
            this.f21688a = i2;
            return this;
        }

        /* renamed from: b */
        public a m25157b(boolean z) {
            this.f21690c = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: c */
        public a m25158c(boolean z) {
            this.f21689b = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: a */
        public a m25155a(InterfaceC6076b interfaceC6076b) {
            this.f21692e.add(interfaceC6076b);
            return this;
        }

        /* renamed from: a */
        public a m25156a(boolean z) {
            this.f21691d = Boolean.valueOf(z);
            return this;
        }
    }

    public C6077c(File file) {
        this(file, (a) null);
    }

    /* renamed from: f */
    private void m25140f() {
        if (this.f21687a == null) {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }

    /* renamed from: a */
    public void m25144a(Object obj, Object obj2) {
        Object[] objArr = {obj};
        HashMap hashMap = new HashMap();
        hashMap.put(0, obj2);
        m25147a(objArr, (Map<Integer, Object>) hashMap);
    }

    /* renamed from: b */
    public int m25148b(String str) {
        m25140f();
        return this.f21687a.m25107b(str);
    }

    /* renamed from: c */
    public int m25150c() {
        m25140f();
        return this.f21687a.m25108c();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.f21687a;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.close();
            this.f21687a = null;
        }
    }

    /* renamed from: d */
    public Long m25152d() {
        m25140f();
        return this.f21687a.m25110d();
    }

    /* renamed from: e */
    public int m25153e() {
        m25140f();
        return this.f21687a.m25112e();
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Deprecated
    public C6077c(File file, int i2) {
        this(file, new a().m25154a(i2));
    }

    public C6077c(File file, a aVar) {
        this.f21687a = new NativeInterpreterWrapper(file.getAbsolutePath(), aVar);
    }

    /* renamed from: b */
    public Tensor m25149b(int i2) {
        m25140f();
        return this.f21687a.m25111d(i2);
    }

    @Deprecated
    /* renamed from: c */
    public void m25151c(int i2) {
        m25140f();
        this.f21687a.m25113e(i2);
    }

    /* renamed from: a */
    public void m25147a(Object[] objArr, Map<Integer, Object> map) {
        m25140f();
        this.f21687a.m25105a(objArr, map);
    }

    public C6077c(ByteBuffer byteBuffer) {
        this(byteBuffer, (a) null);
    }

    @Deprecated
    public C6077c(ByteBuffer byteBuffer, int i2) {
        this(byteBuffer, new a().m25154a(i2));
    }

    /* renamed from: a */
    public void m25143a(int i2, int[] iArr) {
        m25140f();
        this.f21687a.m25102a(i2, iArr);
    }

    @Deprecated
    public C6077c(MappedByteBuffer mappedByteBuffer) {
        this(mappedByteBuffer, (a) null);
    }

    public C6077c(ByteBuffer byteBuffer, a aVar) {
        this.f21687a = new NativeInterpreterWrapper(byteBuffer, aVar);
    }

    /* renamed from: a */
    public int m25141a(String str) {
        m25140f();
        return this.f21687a.m25100a(str);
    }

    /* renamed from: a */
    public Tensor m25142a(int i2) {
        m25140f();
        return this.f21687a.m25101a(i2);
    }

    @Deprecated
    /* renamed from: a */
    public void m25146a(boolean z) {
        m25140f();
        this.f21687a.m25104a(z);
    }

    /* renamed from: a */
    public void m25145a(InterfaceC6076b interfaceC6076b) {
        m25140f();
        this.f21687a.m25103a(interfaceC6076b);
    }
}
