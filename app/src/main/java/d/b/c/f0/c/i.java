package d.b.c.f0.c;

import d.b.c.t;

/* JADX INFO: compiled from: QRCodeDecoderMetaData.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    private final boolean a;

    i(boolean z) {
        this.a = z;
    }

    public boolean a() {
        return this.a;
    }

    public void a(t[] tVarArr) {
        if (!this.a || tVarArr == null || tVarArr.length < 3) {
            return;
        }
        t tVar = tVarArr[0];
        tVarArr[0] = tVarArr[2];
        tVarArr[2] = tVar;
    }
}
