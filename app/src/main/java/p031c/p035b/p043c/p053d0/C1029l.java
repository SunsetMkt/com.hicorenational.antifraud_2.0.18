package p031c.p035b.p043c.p053d0;

import cn.cloudwalk.FaceInterface;
import cn.cloudwalk.libproject.Contants;
import com.yalantis.ucrop.UCrop;
import com.youth.banner.BannerConfig;
import java.util.ArrayList;
import java.util.List;
import p031c.p035b.p043c.p070y.p071a.C1145k;

/* compiled from: EANManufacturerOrgSupport.java */
/* renamed from: c.b.c.d0.l */
/* loaded from: classes.dex */
final class C1029l {

    /* renamed from: a */
    private final List<int[]> f1925a = new ArrayList();

    /* renamed from: b */
    private final List<String> f1926b = new ArrayList();

    C1029l() {
    }

    /* renamed from: a */
    String m1500a(String str) {
        int[] iArr;
        int i2;
        m1498a();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.f1925a.size();
        for (int i3 = 0; i3 < size && parseInt >= (i2 = (iArr = this.f1925a.get(i3))[0]); i3++) {
            if (iArr.length != 1) {
                i2 = iArr[1];
            }
            if (parseInt <= i2) {
                return this.f1926b.get(i3);
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m1499a(int[] iArr, String str) {
        this.f1925a.add(iArr);
        this.f1926b.add(str);
    }

    /* renamed from: a */
    private synchronized void m1498a() {
        if (this.f1925a.isEmpty()) {
            m1499a(new int[]{0, 19}, "US/CA");
            m1499a(new int[]{30, 39}, "US");
            m1499a(new int[]{60, 139}, "US/CA");
            m1499a(new int[]{300, 379}, "FR");
            m1499a(new int[]{380}, "BG");
            m1499a(new int[]{383}, "SI");
            m1499a(new int[]{385}, "HR");
            m1499a(new int[]{387}, "BA");
            m1499a(new int[]{400, 440}, "DE");
            m1499a(new int[]{450, 459}, "JP");
            m1499a(new int[]{460, 469}, "RU");
            m1499a(new int[]{471}, "TW");
            m1499a(new int[]{474}, "EE");
            m1499a(new int[]{475}, "LV");
            m1499a(new int[]{476}, "AZ");
            m1499a(new int[]{477}, "LT");
            m1499a(new int[]{478}, "UZ");
            m1499a(new int[]{479}, "LK");
            m1499a(new int[]{480}, "PH");
            m1499a(new int[]{481}, "BY");
            m1499a(new int[]{482}, "UA");
            m1499a(new int[]{484}, "MD");
            m1499a(new int[]{485}, "AM");
            m1499a(new int[]{486}, "GE");
            m1499a(new int[]{487}, "KZ");
            m1499a(new int[]{489}, "HK");
            m1499a(new int[]{490, 499}, "JP");
            m1499a(new int[]{500, 509}, "GB");
            m1499a(new int[]{520}, "GR");
            m1499a(new int[]{528}, C1145k.f2348r);
            m1499a(new int[]{529}, "CY");
            m1499a(new int[]{531}, "MK");
            m1499a(new int[]{535}, "MT");
            m1499a(new int[]{539}, "IE");
            m1499a(new int[]{540, 549}, "BE/LU");
            m1499a(new int[]{560}, "PT");
            m1499a(new int[]{569}, "IS");
            m1499a(new int[]{570, 579}, "DK");
            m1499a(new int[]{590}, "PL");
            m1499a(new int[]{594}, "RO");
            m1499a(new int[]{599}, "HU");
            m1499a(new int[]{600, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_BLINK}, "ZA");
            m1499a(new int[]{FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADDOWN}, "GH");
            m1499a(new int[]{608}, "BH");
            m1499a(new int[]{UCrop.REQUEST_MULTI_CROP}, "MU");
            m1499a(new int[]{611}, "MA");
            m1499a(new int[]{613}, "DZ");
            m1499a(new int[]{616}, "KE");
            m1499a(new int[]{FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FACEDEC_OK}, "CI");
            m1499a(new int[]{619}, "TN");
            m1499a(new int[]{621}, "SY");
            m1499a(new int[]{622}, "EG");
            m1499a(new int[]{624}, "LY");
            m1499a(new int[]{625}, "JO");
            m1499a(new int[]{626}, "IR");
            m1499a(new int[]{627}, "KW");
            m1499a(new int[]{628}, "SA");
            m1499a(new int[]{629}, "AE");
            m1499a(new int[]{Contants.PREVIEW_W, 649}, "FI");
            m1499a(new int[]{690, 695}, "CN");
            m1499a(new int[]{FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_NOPEOPLE, 709}, "NO");
            m1499a(new int[]{729}, "IL");
            m1499a(new int[]{730, 739}, "SE");
            m1499a(new int[]{740}, "GT");
            m1499a(new int[]{741}, "SV");
            m1499a(new int[]{742}, "HN");
            m1499a(new int[]{743}, "NI");
            m1499a(new int[]{744}, "CR");
            m1499a(new int[]{745}, "PA");
            m1499a(new int[]{746}, "DO");
            m1499a(new int[]{750}, "MX");
            m1499a(new int[]{754, 755}, "CA");
            m1499a(new int[]{759}, "VE");
            m1499a(new int[]{760, 769}, "CH");
            m1499a(new int[]{770}, "CO");
            m1499a(new int[]{773}, "UY");
            m1499a(new int[]{775}, "PE");
            m1499a(new int[]{777}, "BO");
            m1499a(new int[]{779}, "AR");
            m1499a(new int[]{780}, "CL");
            m1499a(new int[]{784}, "PY");
            m1499a(new int[]{785}, "PE");
            m1499a(new int[]{786}, "EC");
            m1499a(new int[]{789, 790}, "BR");
            m1499a(new int[]{BannerConfig.DURATION, 839}, "IT");
            m1499a(new int[]{840, 849}, "ES");
            m1499a(new int[]{850}, "CU");
            m1499a(new int[]{858}, "SK");
            m1499a(new int[]{859}, "CZ");
            m1499a(new int[]{860}, "YU");
            m1499a(new int[]{865}, "MN");
            m1499a(new int[]{867}, "KP");
            m1499a(new int[]{868, 869}, "TR");
            m1499a(new int[]{870, 879}, "NL");
            m1499a(new int[]{880}, "KR");
            m1499a(new int[]{885}, "TH");
            m1499a(new int[]{888}, "SG");
            m1499a(new int[]{890}, "IN");
            m1499a(new int[]{893}, "VN");
            m1499a(new int[]{896}, "PK");
            m1499a(new int[]{899}, "ID");
            m1499a(new int[]{900, 919}, "AT");
            m1499a(new int[]{930, 939}, "AU");
            m1499a(new int[]{940, 949}, "AZ");
            m1499a(new int[]{955}, "MY");
            m1499a(new int[]{958}, "MO");
        }
    }
}
