package p286h.p306n2;

import java.io.ByteArrayOutputStream;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: FileReadWrite.kt */
/* renamed from: h.n2.g */
/* loaded from: classes2.dex */
final class C5448g extends ByteArrayOutputStream {
    public C5448g(int i2) {
        super(i2);
    }

    @InterfaceC5816d
    public final byte[] getBuffer() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        C5544i0.m22521a((Object) bArr, "buf");
        return bArr;
    }
}
