package manager;

import android.text.TextUtils;
import network.account.AccountInfo;
import network.http.RegionConfigHttp;
import util.C7307p1;
import util.C7325u1;

/* loaded from: classes2.dex */
public class AccountManager {
    public static int LOGIN_NORMAL = -1;
    public static int LOGIN_QQ = 1;
    public static int LOGIN_SINA = 3;
    public static int LOGIN_WX = 2;
    public static String mToken = "";

    public static String getAccountId() {
        AccountInfo accountInfo = getAccountInfo();
        return (accountInfo == null || TextUtils.isEmpty(accountInfo.getId())) ? "" : accountInfo.getId();
    }

    public static AccountInfo getAccountInfo() {
        return (AccountInfo) C7325u1.m26615a(C7325u1.f25709y0, AccountInfo.class);
    }

    public static String getAccountPhone() {
        AccountInfo accountInfo = getAccountInfo();
        return (accountInfo == null || TextUtils.isEmpty(accountInfo.getPhoneNum())) ? "" : accountInfo.getPhoneNum();
    }

    public static String getAccountToken() {
        AccountInfo accountInfo;
        if (TextUtils.isEmpty(mToken) && (accountInfo = getAccountInfo()) != null && !TextUtils.isEmpty(accountInfo.getToken())) {
            mToken = accountInfo.getToken();
        }
        return mToken;
    }

    public static String getPoliceUserID() {
        AccountInfo accountInfo = getAccountInfo();
        return (accountInfo == null || TextUtils.isEmpty(accountInfo.getPoliceUserID())) ? "" : accountInfo.getPoliceUserID();
    }

    public static String getPoliceUserPCode() {
        AccountInfo accountInfo = getAccountInfo();
        return (accountInfo == null || TextUtils.isEmpty(accountInfo.getPoliceUserPCode())) ? "" : accountInfo.getPoliceUserPCode();
    }

    public static String getRegisterRegionCode() {
        AccountInfo accountInfo = getAccountInfo();
        return (accountInfo == null || TextUtils.isEmpty(accountInfo.getRegisterRegionCode())) ? "" : accountInfo.getRegisterRegionCode();
    }

    public static String getRegisterRegionName() {
        AccountInfo accountInfo = getAccountInfo();
        return (accountInfo == null || TextUtils.isEmpty(accountInfo.getRegisterRegionName())) ? "" : accountInfo.getRegisterRegionName();
    }

    public static String getShareParam() {
        AccountInfo accountInfo = getAccountInfo();
        String str = "";
        if (accountInfo != null) {
            if (!TextUtils.isEmpty(accountInfo.getPoliceUserID())) {
                str = "&policeuserid=" + accountInfo.getPoliceUserID();
            }
            if (!TextUtils.isEmpty(accountInfo.getPoliceUserPCode())) {
                str = str + "&pcode=" + accountInfo.getPoliceUserPCode();
            }
        }
        if (TextUtils.isEmpty(RegionConfigHttp.getNodeRegionId())) {
            return str;
        }
        return str + "&nodeId=" + RegionConfigHttp.getNodeRegionId();
    }

    public static String getVisiblePhone() {
        AccountInfo accountInfo = getAccountInfo();
        return (accountInfo == null || TextUtils.isEmpty(accountInfo.getVisiblePhone())) ? "" : accountInfo.getVisiblePhone();
    }

    public static boolean isLogin() {
        AccountInfo accountInfo = getAccountInfo();
        return (accountInfo == null || TextUtils.isEmpty(accountInfo.getId())) ? false : true;
    }

    public static boolean isVerified() {
        AccountInfo accountInfo = getAccountInfo();
        if (accountInfo != null) {
            return accountInfo.isIsVerified();
        }
        return false;
    }

    public static void loginOut() {
        saveAccount(null);
        C7325u1.m26630b(C7325u1.f25646M, "");
        C7325u1.m26631b(C7325u1.f25645L, false);
        C7307p1.m26478a(C7307p1.f25503l, (Object) null);
    }

    public static void saveAccount(AccountInfo accountInfo) {
        mToken = accountInfo == null ? "" : accountInfo.getToken();
        C7325u1.m26619a(accountInfo, C7325u1.f25709y0);
    }

    public static void setRegion(String str) {
        AccountInfo accountInfo = getAccountInfo();
        accountInfo.setRegion(str);
        saveAccount(accountInfo);
    }

    public static void setVerified(boolean z, String str, String str2) {
        AccountInfo accountInfo = getAccountInfo();
        accountInfo.setIsVerified(z);
        accountInfo.setName(str);
        accountInfo.setIdNumber(str2);
        saveAccount(accountInfo);
    }

    public static void saveAccount(AccountInfo accountInfo, String str) {
        if (accountInfo != null) {
            accountInfo.setVisiblePhone(str);
        }
        C7325u1.m26619a(accountInfo, C7325u1.f25709y0);
    }
}
