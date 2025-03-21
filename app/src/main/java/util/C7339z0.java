package util;

import android.content.res.ColorStateList;
import androidx.core.view.ViewCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: ColorUtils.java */
/* renamed from: util.z0 */
/* loaded from: classes2.dex */
public class C7339z0 {

    /* renamed from: a */
    private static final int f25750a = 16842910;

    /* renamed from: b */
    private static final int f25751b = 16842912;

    /* renamed from: c */
    private static final int f25752c = 16842919;

    /* renamed from: a */
    public static ColorStateList m26802a(int i2) {
        int i3 = i2 - (-805306368);
        return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842912, 16842919}, new int[]{-16842912, 16842919}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i2 - (-520093696), CommonNetImpl.FLAG_AUTH, i3, CommonNetImpl.FLAG_SHARE, i3, CommonNetImpl.FLAG_SHARE});
    }

    /* renamed from: b */
    public static ColorStateList m26803b(int i2) {
        int i3 = i2 - (-1728053248);
        return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842919, -16842912}, new int[]{16842919, 16842912}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i2 - (-1442840576), -4539718, i3, i3, i2 | ViewCompat.MEASURED_STATE_MASK, -1446930});
    }
}
