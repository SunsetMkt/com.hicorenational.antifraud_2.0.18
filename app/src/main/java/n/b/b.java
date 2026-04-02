package n.b;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.hicorenational.antifraud.R;
import d.b.c.e;
import d.b.c.k;
import d.b.c.n;
import d.b.c.q;
import d.b.c.r;
import d.b.c.z.j;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import zxing.android.CaptureActivity;

/* JADX INFO: compiled from: DecodeHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12853d = b.class.getSimpleName();
    private final CaptureActivity a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12855c = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f12854b = new k();

    b(CaptureActivity captureActivity, Map<e, Object> map) {
        this.f12854b.a((Map<e, ?>) map);
        this.a = captureActivity;
    }

    private void a(byte[] bArr, int i2, int i3) {
        r rVarB;
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
            }
        }
        n nVarA = this.a.b().a(bArr2, i3, i2);
        if (nVarA != null) {
            try {
                rVarB = this.f12854b.b(new d.b.c.c(new j(nVarA)));
            } catch (q unused) {
                rVarB = null;
            } finally {
                this.f12854b.reset();
            }
        } else {
            rVarB = null;
        }
        Handler handlerC = this.a.c();
        if (rVarB == null) {
            if (handlerC != null) {
                Message.obtain(handlerC, R.id.decode_failed).sendToTarget();
                return;
            }
            return;
        }
        String str = "Found barcode in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms";
        if (handlerC != null) {
            Message messageObtain = Message.obtain(handlerC, R.id.decode_succeeded, rVarB);
            Bundle bundle = new Bundle();
            a(nVarA, bundle);
            messageObtain.setData(bundle);
            messageObtain.sendToTarget();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f12855c) {
            int i2 = message.what;
            if (i2 == R.id.decode) {
                a((byte[]) message.obj, message.arg1, message.arg2);
            } else {
                if (i2 != R.id.quit) {
                    return;
                }
                this.f12855c = false;
                Looper.myLooper().quit();
            }
        }
    }

    private static void a(n nVar, Bundle bundle) {
        int[] iArrK = nVar.k();
        int iJ = nVar.j();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrK, 0, iJ, iJ, nVar.i(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(c.f12856e, byteArrayOutputStream.toByteArray());
        bundle.putFloat(c.f12857f, iJ / nVar.c());
    }
}
