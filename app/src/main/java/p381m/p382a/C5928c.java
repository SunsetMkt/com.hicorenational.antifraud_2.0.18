package p381m.p382a;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import anet.channel.entity.ConnType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: CameraConfigurationUtils.java */
/* renamed from: m.a.c */
/* loaded from: classes2.dex */
public final class C5928c {

    /* renamed from: a */
    private static final String f21378a = "CameraConfiguration";

    /* renamed from: b */
    private static final Pattern f21379b = Pattern.compile(";");

    /* renamed from: c */
    private static final int f21380c = 153600;

    /* renamed from: d */
    private static final float f21381d = 1.5f;

    /* renamed from: e */
    private static final float f21382e = 0.0f;

    /* renamed from: f */
    private static final double f21383f = 0.15d;

    /* renamed from: g */
    private static final int f21384g = 10;

    /* renamed from: h */
    private static final int f21385h = 20;

    /* renamed from: i */
    private static final int f21386i = 400;

    /* compiled from: CameraConfigurationUtils.java */
    /* renamed from: m.a.c$a */
    static class a implements Comparator<Camera.Size> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            int i2 = size.height * size.width;
            int i3 = size2.height * size2.width;
            if (i3 < i2) {
                return -1;
            }
            return i3 > i2 ? 1 : 0;
        }
    }

    private C5928c() {
    }

    /* renamed from: a */
    public static void m24890a(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String m24886a = z ? (z3 || z2) ? m24886a("focus mode", supportedFocusModes, ConnType.PK_AUTO) : m24886a("focus mode", supportedFocusModes, "continuous-video", ConnType.PK_AUTO) : null;
        if (!z3 && m24886a == null) {
            m24886a = m24886a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (m24886a != null) {
            if (!m24886a.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(m24886a);
                return;
            }
            String str = "Focus mode already set to " + m24886a;
        }
    }

    /* renamed from: b */
    public static void m24893b(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String m24886a = z ? m24886a("flash mode", supportedFlashModes, "torch", "on") : m24886a("flash mode", supportedFlashModes, "off");
        if (m24886a != null) {
            if (m24886a.equals(parameters.getFlashMode())) {
                String str = "Flash mode already set to " + m24886a;
                return;
            }
            String str2 = "Setting flash mode to " + m24886a;
            parameters.setFlashMode(m24886a);
        }
    }

    /* renamed from: c */
    public static void m24894c(Camera.Parameters parameters) {
        m24888a(parameters, 10, 20);
    }

    /* renamed from: d */
    public static void m24895d(Camera.Parameters parameters) {
        String m24886a;
        if ("negative".equals(parameters.getColorEffect()) || (m24886a = m24886a("color effect", parameters.getSupportedColorEffects(), "negative")) == null) {
            return;
        }
        parameters.setColorEffect(m24886a);
    }

    /* renamed from: a */
    public static void m24889a(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation == 0 && maxExposureCompensation == 0) {
            return;
        }
        if (exposureCompensationStep > 0.0f) {
            int round = Math.round((z ? 0.0f : f21381d) / exposureCompensationStep);
            float f2 = exposureCompensationStep * round;
            int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
            if (parameters.getExposureCompensation() == max) {
                String str = "Exposure compensation already set to " + max + " / " + f2;
                return;
            }
            String str2 = "Setting exposure compensation to " + max + " / " + f2;
            parameters.setExposureCompensation(max);
        }
    }

    /* renamed from: b */
    public static void m24891b(Camera.Parameters parameters) {
        String m24886a;
        if ("barcode".equals(parameters.getSceneMode()) || (m24886a = m24886a("scene mode", parameters.getSupportedSceneModes(), "barcode")) == null) {
            return;
        }
        parameters.setSceneMode(m24886a);
    }

    /* renamed from: b */
    public static void m24892b(Camera.Parameters parameters, double d2) {
        Integer m24883a;
        if (!parameters.isZoomSupported() || (m24883a = m24883a(parameters, d2)) == null) {
            return;
        }
        if (parameters.getZoom() == m24883a.intValue()) {
            String str = "Zoom is already set to " + m24883a;
            return;
        }
        String str2 = "Setting zoom to " + m24883a;
        parameters.setZoom(m24883a.intValue());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m24888a(Camera.Parameters parameters, int i2, int i3) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        String str = "Supported FPS ranges: " + m24887a(supportedPreviewFpsRange);
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        int[] iArr = null;
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            int i4 = next[0];
            int i5 = next[1];
            if (i4 >= i2 * 1000 && i5 <= i3 * 1000) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            String str2 = "FPS range already set to " + Arrays.toString(iArr);
            return;
        }
        String str3 = "Setting FPS range to " + Arrays.toString(iArr);
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    /* renamed from: a */
    private static Integer m24883a(Camera.Parameters parameters, double d2) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        String str = "Zoom ratios: " + zoomRatios;
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            return null;
        }
        double d3 = d2 * 100.0d;
        double d4 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        for (int i3 = 0; i3 < zoomRatios.size(); i3++) {
            double abs = Math.abs(zoomRatios.get(i3).intValue() - d3);
            if (abs < d4) {
                i2 = i3;
                d4 = abs;
            }
        }
        String str2 = "Chose zoom ratio of " + (zoomRatios.get(i2).intValue() / 100.0d);
        return Integer.valueOf(i2);
    }

    /* renamed from: a */
    public static Point m24882a(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new a());
        if (Log.isLoggable(f21378a, 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            String str = "Supported preview sizes: " + ((Object) sb);
        }
        double d2 = point.x / point.y;
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                Camera.Size size2 = (Camera.Size) it.next();
                int i2 = size2.width;
                int i3 = size2.height;
                if (i2 * i3 < f21380c) {
                    it.remove();
                } else {
                    boolean z = i2 < i3;
                    int i4 = z ? i3 : i2;
                    int i5 = z ? i2 : i3;
                    if (Math.abs((i4 / i5) - d2) > f21383f) {
                        it.remove();
                    } else if (i4 == point.x && i5 == point.y) {
                        Point point2 = new Point(i2, i3);
                        String str2 = "Found preview size exactly matching screen size: " + point2;
                        return point2;
                    }
                }
            } else {
                if (!arrayList.isEmpty()) {
                    Camera.Size size3 = (Camera.Size) arrayList.get(0);
                    Point point3 = new Point(size3.width, size3.height);
                    String str3 = "Using largest suitable preview size: " + point3;
                    return point3;
                }
                Camera.Size previewSize2 = parameters.getPreviewSize();
                if (previewSize2 != null) {
                    Point point4 = new Point(previewSize2.width, previewSize2.height);
                    String str4 = "No suitable preview sizes, using default: " + point4;
                    return point4;
                }
                throw new IllegalStateException("Parameters contained no preview size!");
            }
        }
    }

    /* renamed from: a */
    private static String m24886a(String str, Collection<String> collection, String... strArr) {
        String str2 = "Requesting " + str + " value from among: " + Arrays.toString(strArr);
        String str3 = "Supported " + str + " values: " + collection;
        if (collection == null) {
            return null;
        }
        for (String str4 : strArr) {
            if (collection.contains(str4)) {
                String str5 = "Can set " + str + " to: " + str4;
                return str4;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m24887a(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: a */
    public static String m24884a(Camera.Parameters parameters) {
        return m24885a(parameters.flatten());
    }

    /* renamed from: a */
    public static String m24885a(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(Build.BOARD);
        sb.append('\n');
        sb.append("BRAND=");
        sb.append(Build.BRAND);
        sb.append('\n');
        sb.append("CPU_ABI=");
        sb.append(Build.CPU_ABI);
        sb.append('\n');
        sb.append("DEVICE=");
        sb.append(Build.DEVICE);
        sb.append('\n');
        sb.append("DISPLAY=");
        sb.append(Build.DISPLAY);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append('\n');
        sb.append("HOST=");
        sb.append(Build.HOST);
        sb.append('\n');
        sb.append("ID=");
        sb.append(Build.ID);
        sb.append('\n');
        sb.append("MANUFACTURER=");
        sb.append(Build.MANUFACTURER);
        sb.append('\n');
        sb.append("MODEL=");
        sb.append(Build.MODEL);
        sb.append('\n');
        sb.append("PRODUCT=");
        sb.append(Build.PRODUCT);
        sb.append('\n');
        sb.append("TAGS=");
        sb.append(Build.TAGS);
        sb.append('\n');
        sb.append("TIME=");
        sb.append(Build.TIME);
        sb.append('\n');
        sb.append("TYPE=");
        sb.append(Build.TYPE);
        sb.append('\n');
        sb.append("USER=");
        sb.append(Build.USER);
        sb.append('\n');
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append('\n');
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append('\n');
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.RELEASE);
        sb.append('\n');
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (charSequence != null) {
            String[] split = f21379b.split(charSequence);
            Arrays.sort(split);
            for (String str : split) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
