package com.hihonor.honorid.p162d.p163a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Proguard.java */
/* renamed from: com.hihonor.honorid.d.a.d */
/* loaded from: classes.dex */
public class C2167d {

    /* renamed from: a */
    private static final List<String> f6719a = new ArrayList();

    /* renamed from: b */
    private static String[] f6720b = {"userid", "password", "siteid", "plmn", "mobilephone", "deviceinfo", "uuid", "deviceid2", "secretdigest", "salt", "emmcid", "secretdigesttype", "clientip", "deviceid", "device_id", "securityphone", "securityemail", "cookie", "devicetype", "useremail", NotificationCompat.CATEGORY_EMAIL, AbstractC1191a.f2506I, "oldpassword", "newpassword", "thirdtoken", "smsauthcode", "phone", "access_token", "sc", "sso_st", "token", "ac", "pw", "dvid", C3351bh.f11578aC, "dvid2", "sc", "emid", "sct", C3351bh.f11584aI, "st", Constants.JumpUrlConstants.SRC_TYPE_APP, "uid", com.taobao.accs.common.Constants.KEY_IMSI, "thirdopenid", "thirdaccesstoken", AbstractC1191a.f2503H, "useraccount", "fulluseraccount", "nickName", "uniquelynickname", "loginusername", "thirdnickname", "fingerST"};

    static {
        m6310a();
    }

    /* renamed from: a */
    private static void m6310a() {
        String[] strArr = f6720b;
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    f6719a.add(str.toLowerCase(Locale.ENGLISH));
                }
            }
        }
    }

    /* renamed from: a */
    private static String m6308a(char c2, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m6309a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() == 1) {
            return "*";
        }
        int ceil = (int) Math.ceil((str.length() * 50) / 100.0d);
        return m6308a('*', ceil) + str.substring(ceil);
    }
}
