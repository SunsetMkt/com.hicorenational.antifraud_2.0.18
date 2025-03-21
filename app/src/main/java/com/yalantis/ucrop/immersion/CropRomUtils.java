package com.yalantis.ucrop.immersion;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes2.dex */
public class CropRomUtils {
    private static Integer romType;

    public class AvailableRomType {
        public static final int ANDROID_NATIVE = 3;
        public static final int FLYME = 2;
        public static final int MIUI = 1;

        /* renamed from: NA */
        public static final int f16839NA = 4;

        public AvailableRomType() {
        }
    }

    public static int getFlymeVersion() {
        String substring;
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme") || (substring = str.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(AbstractC1191a.f2568g, "").substring(0, 1)) == null) {
            return 0;
        }
        return stringToInt(substring);
    }

    public static int getLightStatausBarAvailableRomType() {
        Integer num = romType;
        if (num != null) {
            return num.intValue();
        }
        if (isMIUIV6OrAbove()) {
            romType = 1;
            return romType.intValue();
        }
        if (isFlymeV4OrAbove()) {
            romType = 2;
            return romType.intValue();
        }
        if (isAndroid5OrAbove()) {
            romType = 3;
            return romType.intValue();
        }
        romType = 4;
        return romType.intValue();
    }

    public static int getMIUIVersionCode() {
        String systemProperty = getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(systemProperty)) {
            return 0;
        }
        try {
            return Integer.parseInt(systemProperty);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return readLine;
        } catch (IOException unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static boolean isAndroid5OrAbove() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private static boolean isFlymeV4OrAbove() {
        return getFlymeVersion() >= 4;
    }

    private static boolean isMIUIV6OrAbove() {
        String systemProperty = getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        try {
            return Integer.parseInt(systemProperty) >= 4;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int stringToInt(String str) {
        if (Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return Integer.valueOf(str).intValue();
        }
        return 0;
    }
}
