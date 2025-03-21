package p381m.p382a;

import android.annotation.SuppressLint;
import android.hardware.Camera;

/* compiled from: OpenCameraInterface.java */
/* renamed from: m.a.e */
/* loaded from: classes2.dex */
public final class C5930e {

    /* renamed from: a */
    private static final String f21404a = "m.a.e";

    private C5930e() {
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static Camera m24910a(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            return null;
        }
        boolean z = i2 >= 0;
        if (!z) {
            i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i2++;
            }
        }
        if (i2 < numberOfCameras) {
            String str = "Opening camera #" + i2;
            return Camera.open(i2);
        }
        if (!z) {
            return Camera.open(0);
        }
        String str2 = "Requested camera does not exist: " + i2;
        return null;
    }

    /* renamed from: a */
    public static Camera m24909a() {
        return m24910a(-1);
    }
}
