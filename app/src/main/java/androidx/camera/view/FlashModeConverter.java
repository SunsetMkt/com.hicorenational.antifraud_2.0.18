package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class FlashModeConverter {
    private FlashModeConverter() {
    }

    @NonNull
    public static String nameOf(int i2) {
        if (i2 == 0) {
            return "AUTO";
        }
        if (i2 == 1) {
            return "ON";
        }
        if (i2 == 2) {
            return "OFF";
        }
        throw new IllegalArgumentException("Unknown flash mode " + i2);
    }

    public static int valueOf(@Nullable String str) {
        if (str == null) {
            throw new NullPointerException("name cannot be null");
        }
        byte b2 = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != 2527) {
            if (iHashCode != 78159) {
                if (iHashCode == 2020783 && str.equals("AUTO")) {
                    b2 = 0;
                }
            } else if (str.equals("OFF")) {
                b2 = 2;
            }
        } else if (str.equals("ON")) {
            b2 = 1;
        }
        if (b2 == 0) {
            return 0;
        }
        if (b2 == 1) {
            return 1;
        }
        if (b2 == 2) {
            return 2;
        }
        throw new IllegalArgumentException("Unknown flash mode name " + str);
    }
}
