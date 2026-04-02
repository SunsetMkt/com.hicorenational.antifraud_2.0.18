package network.http;

import android.app.Activity;
import android.text.TextUtils;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.u1;

/* JADX INFO: loaded from: classes2.dex */
public class RegionConfigHttp extends ModelPresent {
    private static RegionConfigHttp regionConfigHttp;

    private RegionConfigHttp(Activity activity, BaseView baseView) {
        super(activity, baseView);
    }

    public static boolean existNodeRegion() {
        return (TextUtils.isEmpty(getNodeRegionName()) || TextUtils.isEmpty(getNodeRegionId())) ? false : true;
    }

    public static RegionConfigHttp getInstance() {
        if (regionConfigHttp == null) {
            synchronized (RegionConfigHttp.class) {
                if (regionConfigHttp == null) {
                    regionConfigHttp = new RegionConfigHttp(null, null);
                }
            }
        }
        return regionConfigHttp;
    }

    public static String getNodeProvinceName() {
        String strA = u1.a(u1.f15083f);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static String getNodeRegionId() {
        String strA = u1.a(u1.f15082e);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static String getNodeRegionName() {
        String strA = u1.a(u1.f15084g);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static void setNodeRegion(String str, String str2, String str3) {
        u1.a(u1.f15083f, str);
        u1.a(u1.f15084g, str2);
        u1.a(u1.f15082e, str3);
    }
}
