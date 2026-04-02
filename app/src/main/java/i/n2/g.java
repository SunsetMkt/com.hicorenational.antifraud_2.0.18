package i.n2;

import i.q2.t.i0;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes2.dex */
final class g extends ByteArrayOutputStream {
    public g(int i2) {
        super(i2);
    }

    @j.c.a.d
    public final byte[] getBuffer() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        i0.a((Object) bArr, "buf");
        return bArr;
    }
}
