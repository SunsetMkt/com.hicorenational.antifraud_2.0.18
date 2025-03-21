package network.http;

import android.app.Activity;
import android.text.TextUtils;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;
import util.C7307p1;

/* loaded from: classes2.dex */
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
        String m26477a = C7307p1.m26477a(C7307p1.f25497f);
        return TextUtils.isEmpty(m26477a) ? "" : m26477a;
    }

    public static String getNodeRegionId() {
        String m26477a = C7307p1.m26477a(C7307p1.f25496e);
        return TextUtils.isEmpty(m26477a) ? "" : m26477a;
    }

    public static String getNodeRegionName() {
        String m26477a = C7307p1.m26477a(C7307p1.f25498g);
        return TextUtils.isEmpty(m26477a) ? "" : m26477a;
    }

    public static void setNodeRegion(String str, String str2, String str3) {
        C7307p1.m26479a(C7307p1.f25497f, str);
        C7307p1.m26479a(C7307p1.f25498g, str2);
        C7307p1.m26479a(C7307p1.f25496e, str3);
    }
}
