package com.bumptech.glide.load.p125r.p127e;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* renamed from: com.bumptech.glide.load.r.e.a */
/* loaded from: classes.dex */
public class C1752a implements InterfaceC1605e<ByteBuffer> {

    /* renamed from: a */
    private final ByteBuffer f4967a;

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: com.bumptech.glide.load.r.e.a$a */
    public static class a implements InterfaceC1605e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e.a
        @NonNull
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public InterfaceC1605e<ByteBuffer> mo3860a(ByteBuffer byteBuffer) {
            return new C1752a(byteBuffer);
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e.a
        @NonNull
        /* renamed from: a */
        public Class<ByteBuffer> mo3861a() {
            return ByteBuffer.class;
        }
    }

    public C1752a(ByteBuffer byteBuffer) {
        this.f4967a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1605e
    /* renamed from: b */
    public void mo3859b() {
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1605e
    @NonNull
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public ByteBuffer mo3858a() {
        this.f4967a.position(0);
        return this.f4967a;
    }
}
