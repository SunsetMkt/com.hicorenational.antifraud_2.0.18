package p324i.p325a.p326a.p327a.p330m;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.C3351bh;
import java.util.Locale;

/* compiled from: Caverphone1.java */
/* renamed from: i.a.a.a.m.b */
/* loaded from: classes2.dex */
public class C5780b extends AbstractC5779a {

    /* renamed from: a */
    private static final String f20825a = "111111";

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) {
        if (str == null || str.length() == 0) {
            return f20825a;
        }
        return (str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll(C3351bh.f11584aI, "k").replaceAll("q", "k").replaceAll("x", "k").replaceAll("v", "f").replaceAll("dg", UtilityImpl.NET_TYPE_2G).replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("d", "t").replaceAll("ph", "fh").replaceAll("b", C3351bh.f11576aA).replaceAll("sh", "s2").replaceAll(C3351bh.f11582aG, C3351bh.f11580aE).replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wy", "Wy").replaceAll("wh3", "Wh3").replaceAll("why", "Why").replaceAll("w", "2").replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll(C3351bh.f11585aJ, "2").replaceAll("r3", "R3").replaceAll("ry", "Ry").replaceAll("r", "2").replaceAll("l3", "L3").replaceAll("ly", "Ly").replaceAll("l", "2").replaceAll("j", "y").replaceAll("y3", "Y3").replaceAll("y", "2").replaceAll("2", "").replaceAll("3", "") + f20825a).substring(0, 6);
    }
}
