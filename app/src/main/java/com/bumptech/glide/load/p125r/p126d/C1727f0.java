package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.p126d.C1742q;
import com.bumptech.glide.util.C1869c;
import com.bumptech.glide.util.C1874h;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* renamed from: com.bumptech.glide.load.r.d.f0 */
/* loaded from: classes.dex */
public class C1727f0 implements InterfaceC1598l<InputStream, Bitmap> {

    /* renamed from: a */
    private final C1742q f4839a;

    /* renamed from: b */
    private final InterfaceC1623b f4840b;

    /* compiled from: StreamBitmapDecoder.java */
    /* renamed from: com.bumptech.glide.load.r.d.f0$a */
    static class a implements C1742q.b {

        /* renamed from: a */
        private final C1719b0 f4841a;

        /* renamed from: b */
        private final C1869c f4842b;

        a(C1719b0 c1719b0, C1869c c1869c) {
            this.f4841a = c1719b0;
            this.f4842b = c1869c;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1742q.b
        /* renamed from: a */
        public void mo4313a() {
            this.f4841a.m4306c();
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1742q.b
        /* renamed from: a */
        public void mo4314a(InterfaceC1626e interfaceC1626e, Bitmap bitmap) throws IOException {
            IOException m4964c = this.f4842b.m4964c();
            if (m4964c != null) {
                if (bitmap == null) {
                    throw m4964c;
                }
                interfaceC1626e.mo3924a(bitmap);
                throw m4964c;
            }
        }
    }

    public C1727f0(C1742q c1742q, InterfaceC1623b interfaceC1623b) {
        this.f4839a = c1742q;
        this.f4840b = interfaceC1623b;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull InputStream inputStream, @NonNull C1596j c1596j) {
        return this.f4839a.m4395a(inputStream);
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<Bitmap> mo3842a(@NonNull InputStream inputStream, int i2, int i3, @NonNull C1596j c1596j) throws IOException {
        C1719b0 c1719b0;
        boolean z;
        if (inputStream instanceof C1719b0) {
            c1719b0 = (C1719b0) inputStream;
            z = false;
        } else {
            c1719b0 = new C1719b0(inputStream, this.f4840b);
            z = true;
        }
        C1869c m4961b = C1869c.m4961b(c1719b0);
        try {
            return this.f4839a.m4393a(new C1874h(m4961b), i2, i3, c1596j, new a(c1719b0, m4961b));
        } finally {
            m4961b.m4965d();
            if (z) {
                c1719b0.m4307d();
            }
        }
    }
}
