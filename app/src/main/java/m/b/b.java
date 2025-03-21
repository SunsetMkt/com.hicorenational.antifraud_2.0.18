package m.b;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.b.c.e;
import c.b.c.k;
import c.b.c.n;
import com.hicorenational.antifraud.R;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import zxing.android.CaptureActivity;

/* compiled from: DecodeHandler.java */
/* loaded from: classes2.dex */
public final class b extends Handler {

    /* renamed from: d, reason: collision with root package name */
    private static final String f17293d = b.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final CaptureActivity f17294a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17296c = true;

    /* renamed from: b, reason: collision with root package name */
    private final k f17295b = new k();

    b(CaptureActivity captureActivity, Map<e, Object> map) {
        this.f17295b.a((Map<e, ?>) map);
        this.f17294a = captureActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(byte[] r9, int r10, int r11) {
        /*
            r8 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = r9.length
            byte[] r2 = new byte[r2]
            r3 = 0
            r4 = 0
        L9:
            if (r4 >= r11) goto L21
            r5 = 0
        Lc:
            if (r5 >= r10) goto L1e
            int r6 = r5 * r11
            int r6 = r6 + r11
            int r6 = r6 - r4
            int r6 = r6 + (-1)
            int r7 = r4 * r10
            int r7 = r7 + r5
            r7 = r9[r7]
            r2[r6] = r7
            int r5 = r5 + 1
            goto Lc
        L1e:
            int r4 = r4 + 1
            goto L9
        L21:
            zxing.android.CaptureActivity r9 = r8.f17294a
            m.a.d r9 = r9.b()
            c.b.c.n r9 = r9.a(r2, r11, r10)
            if (r9 == 0) goto L4f
            c.b.c.c r10 = new c.b.c.c
            c.b.c.z.j r11 = new c.b.c.z.j
            r11.<init>(r9)
            r10.<init>(r11)
            c.b.c.k r11 = r8.f17295b     // Catch: java.lang.Throwable -> L43 c.b.c.q -> L4a
            c.b.c.r r10 = r11.b(r10)     // Catch: java.lang.Throwable -> L43 c.b.c.q -> L4a
            c.b.c.k r11 = r8.f17295b
            r11.reset()
            goto L50
        L43:
            r9 = move-exception
            c.b.c.k r10 = r8.f17295b
            r10.reset()
            throw r9
        L4a:
            c.b.c.k r10 = r8.f17295b
            r10.reset()
        L4f:
            r10 = 0
        L50:
            zxing.android.CaptureActivity r11 = r8.f17294a
            android.os.Handler r11 = r11.c()
            if (r10 == 0) goto L8a
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Found barcode in "
            r4.append(r5)
            long r2 = r2 - r0
            r4.append(r2)
            java.lang.String r0 = " ms"
            r4.append(r0)
            r4.toString()
            if (r11 == 0) goto L96
            r0 = 2131296499(0x7f0900f3, float:1.8210916E38)
            android.os.Message r10 = android.os.Message.obtain(r11, r0, r10)
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            a(r9, r11)
            r10.setData(r11)
            r10.sendToTarget()
            goto L96
        L8a:
            if (r11 == 0) goto L96
            r9 = 2131296498(0x7f0900f2, float:1.8210914E38)
            android.os.Message r9 = android.os.Message.obtain(r11, r9)
            r9.sendToTarget()
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.b.b.a(byte[], int, int):void");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f17296c) {
            int i2 = message.what;
            if (i2 == R.id.decode) {
                a((byte[]) message.obj, message.arg1, message.arg2);
            } else {
                if (i2 != R.id.quit) {
                    return;
                }
                this.f17296c = false;
                Looper.myLooper().quit();
            }
        }
    }

    private static void a(n nVar, Bundle bundle) {
        int[] k2 = nVar.k();
        int j2 = nVar.j();
        Bitmap createBitmap = Bitmap.createBitmap(k2, 0, j2, j2, nVar.i(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(c.f17297e, byteArrayOutputStream.toByteArray());
        bundle.putFloat(c.f17298f, j2 / nVar.c());
    }
}
