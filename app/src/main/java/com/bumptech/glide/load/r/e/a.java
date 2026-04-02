package com.bumptech.glide.load.r.e;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.e;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<ByteBuffer> {
    private final ByteBuffer a;

    /* JADX INFO: renamed from: com.bumptech.glide.load.r.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferRewinder.java */
    public static class C0060a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.o.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.o.e
    @NonNull
    public ByteBuffer a() {
        this.a.position(0);
        return this.a;
    }
}
