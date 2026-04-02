package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Interpreter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements AutoCloseable {
    NativeInterpreterWrapper a;

    /* JADX INFO: compiled from: Interpreter.java */
    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Boolean f13012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Boolean f13013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Boolean f13014d;
        int a = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List<b> f13015e = new ArrayList();

        public a a(int i2) {
            this.a = i2;
            return this;
        }

        public a b(boolean z) {
            this.f13013c = Boolean.valueOf(z);
            return this;
        }

        public a c(boolean z) {
            this.f13012b = Boolean.valueOf(z);
            return this;
        }

        public a a(b bVar) {
            this.f13015e.add(bVar);
            return this;
        }

        public a a(boolean z) {
            this.f13014d = Boolean.valueOf(z);
            return this;
        }
    }

    public c(File file) {
        this(file, (a) null);
    }

    private void f() {
        if (this.a == null) {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }

    public void a(Object obj, Object obj2) {
        Object[] objArr = {obj};
        HashMap map = new HashMap();
        map.put(0, obj2);
        a(objArr, (Map<Integer, Object>) map);
    }

    public int b(String str) {
        f();
        return this.a.b(str);
    }

    public int c() {
        f();
        return this.a.c();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.a;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.close();
            this.a = null;
        }
    }

    public Long d() {
        f();
        return this.a.d();
    }

    public int e() {
        f();
        return this.a.e();
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Deprecated
    public c(File file, int i2) {
        this(file, new a().a(i2));
    }

    public c(File file, a aVar) {
        this.a = new NativeInterpreterWrapper(file.getAbsolutePath(), aVar);
    }

    public Tensor b(int i2) {
        f();
        return this.a.d(i2);
    }

    @Deprecated
    public void c(int i2) {
        f();
        this.a.e(i2);
    }

    public void a(Object[] objArr, Map<Integer, Object> map) {
        f();
        this.a.a(objArr, map);
    }

    public c(ByteBuffer byteBuffer) {
        this(byteBuffer, (a) null);
    }

    @Deprecated
    public c(ByteBuffer byteBuffer, int i2) {
        this(byteBuffer, new a().a(i2));
    }

    public void a(int i2, int[] iArr) {
        f();
        this.a.a(i2, iArr);
    }

    @Deprecated
    public c(MappedByteBuffer mappedByteBuffer) {
        this(mappedByteBuffer, (a) null);
    }

    public c(ByteBuffer byteBuffer, a aVar) {
        this.a = new NativeInterpreterWrapper(byteBuffer, aVar);
    }

    public int a(String str) {
        f();
        return this.a.a(str);
    }

    public Tensor a(int i2) {
        f();
        return this.a.a(i2);
    }

    @Deprecated
    public void a(boolean z) {
        f();
        this.a.a(z);
    }

    public void a(b bVar) {
        f();
        this.a.a(bVar);
    }
}
