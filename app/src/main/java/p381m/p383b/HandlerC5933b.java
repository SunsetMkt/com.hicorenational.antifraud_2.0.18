package p381m.p383b;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.hicorenational.antifraud.C2113R;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import p031c.p035b.p043c.C1100k;
import p031c.p035b.p043c.C1103n;
import p031c.p035b.p043c.EnumC1044e;
import zxing.android.CaptureActivity;

/* compiled from: DecodeHandler.java */
/* renamed from: m.b.b */
/* loaded from: classes2.dex */
public final class HandlerC5933b extends Handler {

    /* renamed from: d */
    private static final String f21418d = HandlerC5933b.class.getSimpleName();

    /* renamed from: a */
    private final CaptureActivity f21419a;

    /* renamed from: c */
    private boolean f21421c = true;

    /* renamed from: b */
    private final C1100k f21420b = new C1100k();

    HandlerC5933b(CaptureActivity captureActivity, Map<EnumC1044e, Object> map) {
        this.f21420b.m1904a((Map<EnumC1044e, ?>) map);
        this.f21419a = captureActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m24916a(byte[] r9, int r10, int r11) {
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
            zxing.android.CaptureActivity r9 = r8.f21419a
            m.a.d r9 = r9.m26821b()
            c.b.c.n r9 = r9.m24898a(r2, r11, r10)
            if (r9 == 0) goto L4f
            c.b.c.c r10 = new c.b.c.c
            c.b.c.z.j r11 = new c.b.c.z.j
            r11.<init>(r9)
            r10.<init>(r11)
            c.b.c.k r11 = r8.f21420b     // Catch: java.lang.Throwable -> L43 p031c.p035b.p043c.AbstractC1106q -> L4a
            c.b.c.r r10 = r11.m1905b(r10)     // Catch: java.lang.Throwable -> L43 p031c.p035b.p043c.AbstractC1106q -> L4a
            c.b.c.k r11 = r8.f21420b
            r11.reset()
            goto L50
        L43:
            r9 = move-exception
            c.b.c.k r10 = r8.f21420b
            r10.reset()
            throw r9
        L4a:
            c.b.c.k r10 = r8.f21420b
            r10.reset()
        L4f:
            r10 = 0
        L50:
            zxing.android.CaptureActivity r11 = r8.f21419a
            android.os.Handler r11 = r11.m26822c()
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
            m24915a(r9, r11)
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
        throw new UnsupportedOperationException("Method not decompiled: p381m.p383b.HandlerC5933b.m24916a(byte[], int, int):void");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f21421c) {
            int i2 = message.what;
            if (i2 == C2113R.id.decode) {
                m24916a((byte[]) message.obj, message.arg1, message.arg2);
            } else {
                if (i2 != C2113R.id.quit) {
                    return;
                }
                this.f21421c = false;
                Looper.myLooper().quit();
            }
        }
    }

    /* renamed from: a */
    private static void m24915a(C1103n c1103n, Bundle bundle) {
        int[] m1909k = c1103n.m1909k();
        int m1908j = c1103n.m1908j();
        Bitmap createBitmap = Bitmap.createBitmap(m1909k, 0, m1908j, m1908j, c1103n.m1907i(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(C5934c.f21422e, byteArrayOutputStream.toByteArray());
        bundle.putFloat(C5934c.f21423f, m1908j / c1103n.m1902c());
    }
}
