package androidx.core.content.p015pm;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class PackageInfoCompat {
    private PackageInfoCompat() {
    }

    public static long getLongVersionCode(@NonNull PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }
}
