package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hihonor.honorid.p162d.p163a.C2167d;
import com.hihonor.honorid.p165f.C2172b;
import com.hihonor.honorid.p165f.C2173c;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class UserInfo implements Parcelable, Serializable {
    public static final String ADDRESS = "address";
    public static final String AGE = "age";
    public static final String BIRTHDATE = "birthDate";
    public static final String CITY = "city";
    public static final String CLOUDACCOUNT = "cloudAccount";
    public static final Parcelable.Creator<UserInfo> CREATOR = new C2161a();
    public static final String CTFCODE = "ctfCode";
    public static final String CTFTYPE = "ctfType";
    public static final String CTFVERIFYFLAG = "ctfVerifyFlag";
    public static final String FIRSTNAME = "firstName";
    public static final String GENDER = "gender";
    public static final String GUARDIAN_ACCOUNT = "guardianAccount";
    public static final String GUARDIAN_USER_ID = "guardianUserID";
    public static final String HEADPICTUREURL = "headPictureURL";
    public static final String INVITER = "Inviter";
    public static final String INVITER_USERID = "InviterUserID";
    public static final String LANGUAGECODE = "languageCode";
    public static final String LASTNAME = "lastName";
    public static final String LOGIN_NOTICE = "loginnotice";
    public static final String LOGIN_USER_NAME = "loginUserName";
    public static final String LOGIN_USER_NAME_FLAG = "loginUserNameFlag";
    public static final String NATIONALCODE = "nationalCode";
    public static final String NICKNAME = "nickName";
    public static final String OCCUPATION = "occupation";
    public static final String PASSWORDANWSER = "passwordAnswer";
    public static final String PASSWORDPROMPT = "passwordPrompt";
    public static final String PROVINCE = "province";
    public static final String RESET_PASSWD_MODE = "resetPasswdMode";
    public static final String SERVICEFLAG = "ServiceFlag";
    public static final String TWO_STEP_TIME = "twoStepTime";
    public static final String TWO_STEP_VERIFY = "twoStepVerify";
    public static final String UNIQUE_NICKNAME = "uniquelyNickname";
    public static final String UPDATE_TIME = "updateTime";
    public static final String USERSIGN = "userSignature";
    public static final String USERSTATE = "userState";
    public static final String USERVALID_STATUS = "userValidStatus";
    public static final String USER_STATUS_FLAGS = "userStatusFlags";

    /* renamed from: A */
    private String f6601A;

    /* renamed from: B */
    private String f6602B;

    /* renamed from: C */
    private String f6603C;

    /* renamed from: D */
    private String f6604D;

    /* renamed from: E */
    private String f6605E;

    /* renamed from: F */
    private String f6606F;

    /* renamed from: G */
    private String f6607G;

    /* renamed from: H */
    private String f6608H;

    /* renamed from: I */
    private String f6609I;

    /* renamed from: J */
    private String f6610J;

    /* renamed from: K */
    private String f6611K;

    /* renamed from: a */
    private String f6612a;

    /* renamed from: b */
    private String f6613b;

    /* renamed from: c */
    private String f6614c;

    /* renamed from: d */
    private String f6615d;

    /* renamed from: e */
    private String f6616e;

    /* renamed from: f */
    private String f6617f;

    /* renamed from: g */
    private String f6618g;

    /* renamed from: h */
    private String f6619h;

    /* renamed from: i */
    private String f6620i;

    /* renamed from: j */
    private String f6621j;

    /* renamed from: k */
    private String f6622k;

    /* renamed from: l */
    private String f6623l;

    /* renamed from: m */
    private String f6624m;

    /* renamed from: n */
    private String f6625n;

    /* renamed from: o */
    private String f6626o;

    /* renamed from: p */
    private String f6627p;

    /* renamed from: q */
    private String f6628q;

    /* renamed from: r */
    private String f6629r;

    /* renamed from: s */
    private String f6630s;

    /* renamed from: t */
    private String f6631t;

    /* renamed from: u */
    private String f6632u;

    /* renamed from: v */
    private String f6633v;

    /* renamed from: w */
    private String f6634w;

    /* renamed from: x */
    private String f6635x;

    /* renamed from: y */
    private String f6636y;

    /* renamed from: z */
    private String f6637z;

    /* renamed from: com.hihonor.honorid.core.data.UserInfo$a */
    class C2161a implements Parcelable.Creator<UserInfo> {
        C2161a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo createFromParcel(Parcel parcel) {
            UserInfo userInfo = new UserInfo();
            userInfo.f6620i = parcel.readString();
            userInfo.f6619h = parcel.readString();
            userInfo.f6625n = parcel.readString();
            userInfo.f6628q = parcel.readString();
            userInfo.f6615d = parcel.readString();
            userInfo.f6618g = parcel.readString();
            userInfo.f6622k = parcel.readString();
            userInfo.f6614c = parcel.readString();
            userInfo.f6616e = parcel.readString();
            userInfo.f6623l = parcel.readString();
            userInfo.f6612a = parcel.readString();
            userInfo.f6613b = parcel.readString();
            userInfo.f6621j = parcel.readString();
            userInfo.f6627p = parcel.readString();
            userInfo.f6626o = parcel.readString();
            userInfo.f6624m = parcel.readString();
            userInfo.f6629r = parcel.readString();
            userInfo.f6617f = parcel.readString();
            userInfo.f6630s = parcel.readString();
            userInfo.f6631t = parcel.readString();
            userInfo.f6632u = parcel.readString();
            userInfo.f6633v = parcel.readString();
            userInfo.f6634w = parcel.readString();
            userInfo.f6635x = parcel.readString();
            userInfo.f6636y = parcel.readString();
            userInfo.f6637z = parcel.readString();
            userInfo.f6601A = parcel.readString();
            userInfo.f6602B = parcel.readString();
            userInfo.f6604D = parcel.readString();
            userInfo.f6603C = parcel.readString();
            userInfo.f6605E = parcel.readString();
            userInfo.f6606F = parcel.readString();
            userInfo.f6609I = parcel.readString();
            userInfo.f6607G = parcel.readString();
            userInfo.f6608H = parcel.readString();
            userInfo.f6610J = parcel.readString();
            userInfo.f6611K = parcel.readString();
            return userInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo[] newArray(int i2) {
            return new UserInfo[i2];
        }
    }

    public static void getUserInfoIntag(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if (xmlPullParser == null || userInfo == null || str == null) {
            return;
        }
        m6250a(xmlPullParser, userInfo, str);
        m6252b(xmlPullParser, userInfo, str);
        m6254c(xmlPullParser, userInfo, str);
    }

    public static void setUserInfoIntag(XmlSerializer xmlSerializer, UserInfo userInfo) {
        if (xmlSerializer == null || userInfo == null) {
            return;
        }
        C2173c.m6330a(xmlSerializer, "uniquelyNickname", userInfo.getUniqueNickName());
        C2173c.m6330a(xmlSerializer, "nickName", userInfo.getNickName());
        C2173c.m6330a(xmlSerializer, LANGUAGECODE, userInfo.getLanguageCode());
        C2173c.m6330a(xmlSerializer, FIRSTNAME, userInfo.getFirstName());
        C2173c.m6330a(xmlSerializer, LASTNAME, userInfo.getLastName());
        C2173c.m6330a(xmlSerializer, USERSTATE, userInfo.getUserState());
        C2173c.m6330a(xmlSerializer, GENDER, userInfo.getGender());
        C2173c.m6330a(xmlSerializer, "birthDate", userInfo.getBirthDate());
        C2173c.m6330a(xmlSerializer, ADDRESS, userInfo.getAddress());
        C2173c.m6330a(xmlSerializer, OCCUPATION, userInfo.getOccupation());
        C2173c.m6330a(xmlSerializer, HEADPICTUREURL, userInfo.getHeadPictureUrl());
        C2173c.m6330a(xmlSerializer, NATIONALCODE, userInfo.getNationalCode());
        C2173c.m6330a(xmlSerializer, PROVINCE, userInfo.getProvince());
        C2173c.m6330a(xmlSerializer, CITY, userInfo.getCity());
        C2173c.m6330a(xmlSerializer, PASSWORDPROMPT, userInfo.getPasswordPrompt());
        C2173c.m6330a(xmlSerializer, PASSWORDANWSER, userInfo.getPasswordAnwser());
        C2173c.m6330a(xmlSerializer, CLOUDACCOUNT, userInfo.getCloudAccount());
        C2173c.m6330a(xmlSerializer, SERVICEFLAG, userInfo.getServiceFlag());
        C2173c.m6330a(xmlSerializer, USERVALID_STATUS, userInfo.getUserValidStatus());
        C2173c.m6330a(xmlSerializer, INVITER, userInfo.getInviter());
        C2173c.m6330a(xmlSerializer, INVITER_USERID, userInfo.getInviterUserId());
        C2173c.m6330a(xmlSerializer, "updateTime", userInfo.getUpdateTime());
        C2173c.m6330a(xmlSerializer, "loginUserName", userInfo.getLoginUserName());
        C2173c.m6330a(xmlSerializer, LOGIN_USER_NAME_FLAG, userInfo.getLoginUserNameFlag());
        C2173c.m6330a(xmlSerializer, USERSIGN, userInfo.getUserSign());
        C2173c.m6330a(xmlSerializer, CTFCODE, userInfo.getCtfCode());
        C2173c.m6330a(xmlSerializer, CTFTYPE, userInfo.getCtfType());
        C2173c.m6330a(xmlSerializer, CTFVERIFYFLAG, userInfo.getCtfVerifyFlag());
        C2173c.m6330a(xmlSerializer, "srvNationalCode", userInfo.getServiceCountryCode());
        C2173c.m6330a(xmlSerializer, "age", userInfo.getAge());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f6620i;
    }

    public String getAge() {
        return this.f6611K;
    }

    public String getBirthDate() {
        return this.f6619h;
    }

    public String getCity() {
        return this.f6625n;
    }

    public String getCloudAccount() {
        return this.f6628q;
    }

    public String getCtfCode() {
        return this.f6609I;
    }

    public String getCtfType() {
        return this.f6607G;
    }

    public String getCtfVerifyFlag() {
        return this.f6608H;
    }

    public String getFirstName() {
        return this.f6615d;
    }

    public String getGender() {
        return this.f6618g;
    }

    public String getGuardianAccount() {
        return this.f6606F;
    }

    public String getGuardianUserId() {
        return this.f6605E;
    }

    public String getHeadPictureUrl() {
        return this.f6622k;
    }

    public String getInviter() {
        return this.f6632u;
    }

    public String getInviterUserId() {
        return this.f6631t;
    }

    public String getLanguageCode() {
        return this.f6614c;
    }

    public String getLastName() {
        return this.f6616e;
    }

    public String getLoginNotice() {
        return this.f6604D;
    }

    public String getLoginUserName() {
        return this.f6634w;
    }

    public String getLoginUserNameFlag() {
        return this.f6635x;
    }

    public String getNationalCode() {
        return this.f6623l;
    }

    public String getNickName() {
        return this.f6612a;
    }

    public String getOccupation() {
        return this.f6621j;
    }

    public String getPasswordAnwser() {
        return this.f6627p;
    }

    public String getPasswordPrompt() {
        return this.f6626o;
    }

    public String getProvince() {
        return this.f6624m;
    }

    public String getResetPasswdMode() {
        return this.f6602B;
    }

    public String getServiceCountryCode() {
        return this.f6610J;
    }

    public String getServiceFlag() {
        return this.f6629r;
    }

    public String getUniqueNickName() {
        return this.f6613b;
    }

    public String getUpdateTime() {
        return this.f6633v;
    }

    public String getUserSign() {
        return this.f6603C;
    }

    public String getUserState() {
        return this.f6617f;
    }

    public int getUserType() {
        return (TextUtils.isEmpty(this.f6605E) || TextUtils.isEmpty(this.f6606F)) ? 0 : 1;
    }

    public String getUserValidStatus() {
        return this.f6630s;
    }

    public String gettwoStepTime() {
        return this.f6601A;
    }

    public String gettwoStepVerify() {
        return this.f6637z;
    }

    public String getuserStatusFlags() {
        return this.f6636y;
    }

    public boolean isObjectEquals(Object obj) {
        if (obj == null || !(obj instanceof UserInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        UserInfo userInfo = (UserInfo) obj;
        return C2172b.m6329a(getNickName(), userInfo.getNickName()) && C2172b.m6329a(getLoginUserName(), userInfo.getLoginUserName()) && C2172b.m6329a(getLoginUserNameFlag(), userInfo.getLoginUserNameFlag()) && C2172b.m6329a(getGender(), userInfo.getGender()) && C2172b.m6329a(getBirthDate(), userInfo.getBirthDate()) && C2172b.m6329a(getNationalCode(), userInfo.getNationalCode());
    }

    public void setAddress(String str) {
        this.f6620i = str;
    }

    public void setAge(String str) {
        this.f6611K = str;
    }

    public void setBirthDate(String str) {
        this.f6619h = str;
    }

    public void setCity(String str) {
        this.f6625n = str;
    }

    public void setCloudAccount(String str) {
        this.f6628q = str;
    }

    public void setCtfCode(String str) {
        this.f6609I = str;
    }

    public void setCtfType(String str) {
        this.f6607G = str;
    }

    public void setCtfVerifyFlag(String str) {
        this.f6608H = str;
    }

    public void setFirstName(String str) {
        this.f6615d = str;
    }

    public void setGender(String str) {
        this.f6618g = str;
    }

    public void setGuardianAccount(String str) {
        this.f6606F = str;
    }

    public void setGuardianUserId(String str) {
        this.f6605E = str;
    }

    public void setHeadPictureUrl(String str) {
        this.f6622k = str;
    }

    public void setInviter(String str) {
        this.f6632u = str;
    }

    public void setInviterUserId(String str) {
        this.f6631t = str;
    }

    public void setLanguageCode(String str) {
        this.f6614c = str;
    }

    public void setLastName(String str) {
        this.f6616e = str;
    }

    public void setLoginNotice(String str) {
        this.f6604D = str;
    }

    public void setLoginUserName(String str) {
        this.f6634w = str;
    }

    public void setLoginUserNameFlag(String str) {
        this.f6635x = str;
    }

    public void setNationalCode(String str) {
        this.f6623l = str;
    }

    public void setNickName(String str) {
        this.f6612a = str;
    }

    public void setOccupation(String str) {
        this.f6621j = str;
    }

    public void setPasswordAnwser(String str) {
        this.f6627p = str;
    }

    public void setPasswordPrompt(String str) {
        this.f6626o = str;
    }

    public void setProvince(String str) {
        this.f6624m = str;
    }

    public void setResetPasswdMode(String str) {
        this.f6602B = str;
    }

    public void setServiceCountryCode(String str) {
        this.f6610J = str;
    }

    public void setServiceFlag(String str) {
        this.f6629r = str;
    }

    public void setUniqueNickName(String str) {
        this.f6613b = str;
    }

    public void setUpdateTime(String str) {
        this.f6633v = str;
    }

    public void setUserSign(String str) {
        this.f6603C = str;
    }

    public void setUserState(String str) {
        this.f6617f = str;
    }

    public void setUserValidStatus(String str) {
        this.f6630s = str;
    }

    public void settwoStepTime(String str) {
        this.f6601A = str;
    }

    public void settwoStepVerify(String str) {
        this.f6637z = str;
    }

    public void setuserStatusFlags(String str) {
        this.f6636y = str;
    }

    public String toString() {
        return "UserInfo [mNickName=" + C2167d.m6309a(this.f6612a) + ", mUniqueNickName=" + C2167d.m6309a(this.f6613b) + ", mLanguageCode=" + this.f6614c + ", mFirstName=" + C2167d.m6309a(this.f6615d) + ", mLastName=" + C2167d.m6309a(this.f6616e) + ", mUserState=" + this.f6617f + ", mGender=" + this.f6618g + ", mBirthDate=" + this.f6619h + ", mAddress=" + C2167d.m6309a(this.f6620i) + ", mOccupation=" + this.f6621j + ", mHeadPictureUrl=" + this.f6622k + ", mNationalCode=" + this.f6623l + ", mProvince=" + this.f6624m + ", mCity=" + this.f6625n + ", mPasswordPrompt=" + C2167d.m6309a(this.f6626o) + ", mscrtdanws=" + this.f6627p + ", mCloudAccount=" + this.f6628q + ", mServiceFlag=" + this.f6629r + ", mUserValidStatus=" + this.f6630s + ", mInviterUserId=" + C2167d.m6309a(this.f6631t) + ", mInviter=" + C2167d.m6309a(this.f6632u) + ", mUpdateTime=" + this.f6633v + ", mLoginUserName=" + C2167d.m6309a(this.f6634w) + ", mLoginUserNameFlag=" + this.f6635x + ", muserStatusFlags=" + this.f6636y + ", mtwoStepVerify=" + this.f6637z + ", mtwoStepTime=" + this.f6601A + ", mResetPasswdMode=" + this.f6602B + ", mUserSign=" + this.f6603C + ", mLoginNotice=" + this.f6604D + ", mGuardianUserId=" + C2167d.m6309a(this.f6605E) + ", mGuardianAccount=" + C2167d.m6309a(this.f6606F) + ", mCtfType=" + this.f6607G + ", mCtfVerifyFlag=" + this.f6608H + ", mCtfCode=" + this.f6609I + ", mServiceCountryCode=" + this.f6610J + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6620i);
        parcel.writeString(this.f6619h);
        parcel.writeString(this.f6625n);
        parcel.writeString(this.f6628q);
        parcel.writeString(this.f6615d);
        parcel.writeString(this.f6618g);
        parcel.writeString(this.f6622k);
        parcel.writeString(this.f6614c);
        parcel.writeString(this.f6616e);
        parcel.writeString(this.f6623l);
        parcel.writeString(this.f6612a);
        parcel.writeString(this.f6613b);
        parcel.writeString(this.f6621j);
        parcel.writeString(this.f6627p);
        parcel.writeString(this.f6626o);
        parcel.writeString(this.f6624m);
        parcel.writeString(this.f6629r);
        parcel.writeString(this.f6617f);
        parcel.writeString(this.f6630s);
        parcel.writeString(this.f6631t);
        parcel.writeString(this.f6632u);
        parcel.writeString(this.f6633v);
        parcel.writeString(this.f6634w);
        parcel.writeString(this.f6635x);
        parcel.writeString(this.f6636y);
        parcel.writeString(this.f6637z);
        parcel.writeString(this.f6601A);
        parcel.writeString(this.f6602B);
        parcel.writeString(this.f6604D);
        parcel.writeString(this.f6603C);
        parcel.writeString(this.f6605E);
        parcel.writeString(this.f6606F);
        parcel.writeString(this.f6609I);
        parcel.writeString(this.f6608H);
        parcel.writeString(this.f6607G);
        parcel.writeString(this.f6610J);
        parcel.writeString(this.f6611K);
    }

    /* renamed from: a */
    private static void m6250a(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if ("nickName".equals(str)) {
            userInfo.setNickName(xmlPullParser.nextText());
            return;
        }
        if ("uniquelyNickname".equals(str)) {
            userInfo.setUniqueNickName(xmlPullParser.nextText());
            return;
        }
        if (LANGUAGECODE.equals(str)) {
            userInfo.setLanguageCode(xmlPullParser.nextText());
            return;
        }
        if (FIRSTNAME.equals(str)) {
            userInfo.setFirstName(xmlPullParser.nextText());
            return;
        }
        if (LASTNAME.equals(str)) {
            userInfo.setLastName(xmlPullParser.nextText());
            return;
        }
        if (USERSTATE.equals(str)) {
            userInfo.setUserState(xmlPullParser.nextText());
            return;
        }
        if (GUARDIAN_ACCOUNT.equals(str)) {
            userInfo.setGuardianAccount(xmlPullParser.nextText());
            return;
        }
        if (GUARDIAN_USER_ID.equals(str)) {
            userInfo.setGuardianUserId(xmlPullParser.nextText());
            return;
        }
        if (CTFCODE.equals(str)) {
            userInfo.setCtfCode(xmlPullParser.nextText());
            return;
        }
        if (CTFTYPE.equals(str)) {
            userInfo.setCtfType(xmlPullParser.nextText());
            return;
        }
        if (CTFVERIFYFLAG.equals(str)) {
            userInfo.setCtfVerifyFlag(xmlPullParser.nextText());
            return;
        }
        if (USERVALID_STATUS.equals(str)) {
            userInfo.setUserValidStatus(xmlPullParser.nextText());
        } else if (INVITER_USERID.equals(str)) {
            userInfo.setInviterUserId(xmlPullParser.nextText());
        } else if ("age".equals(str)) {
            userInfo.setAge(xmlPullParser.nextText());
        }
    }

    /* renamed from: b */
    private static void m6252b(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if (GENDER.equals(str)) {
            userInfo.setGender(xmlPullParser.nextText());
            return;
        }
        if ("birthDate".equals(str)) {
            userInfo.setBirthDate(xmlPullParser.nextText());
            return;
        }
        if (ADDRESS.equals(str)) {
            userInfo.setAddress(xmlPullParser.nextText());
            return;
        }
        if (OCCUPATION.equals(str)) {
            userInfo.setOccupation(xmlPullParser.nextText());
            return;
        }
        if (HEADPICTUREURL.equals(str)) {
            userInfo.setHeadPictureUrl(xmlPullParser.nextText());
            return;
        }
        if (NATIONALCODE.equals(str)) {
            userInfo.setNationalCode(xmlPullParser.nextText());
            return;
        }
        if (PROVINCE.equals(str)) {
            userInfo.setProvince(xmlPullParser.nextText());
            return;
        }
        if (CITY.equals(str)) {
            userInfo.setCity(xmlPullParser.nextText());
            return;
        }
        if (PASSWORDPROMPT.equals(str)) {
            userInfo.setPasswordPrompt(xmlPullParser.nextText());
            return;
        }
        if (PASSWORDANWSER.equals(str)) {
            userInfo.setPasswordAnwser(xmlPullParser.nextText());
        } else if (CLOUDACCOUNT.equals(str)) {
            userInfo.setCloudAccount(xmlPullParser.nextText());
        } else if (SERVICEFLAG.equals(str)) {
            userInfo.setServiceFlag(xmlPullParser.nextText());
        }
    }

    /* renamed from: c */
    private static void m6254c(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if (INVITER.equals(str)) {
            userInfo.setInviter(xmlPullParser.nextText());
            return;
        }
        if ("updateTime".equals(str)) {
            userInfo.setUpdateTime(xmlPullParser.nextText());
            return;
        }
        if ("loginUserName".equals(str)) {
            userInfo.setLoginUserName(xmlPullParser.nextText());
            return;
        }
        if (LOGIN_USER_NAME_FLAG.equals(str)) {
            userInfo.setLoginUserNameFlag(xmlPullParser.nextText());
            return;
        }
        if (USER_STATUS_FLAGS.equals(str)) {
            userInfo.setuserStatusFlags(xmlPullParser.nextText());
            return;
        }
        if (TWO_STEP_VERIFY.equals(str)) {
            userInfo.settwoStepVerify(xmlPullParser.nextText());
            return;
        }
        if (TWO_STEP_TIME.equals(str)) {
            userInfo.settwoStepTime(xmlPullParser.nextText());
            return;
        }
        if (RESET_PASSWD_MODE.equals(str)) {
            userInfo.setResetPasswdMode(xmlPullParser.nextText());
            return;
        }
        if (USERSIGN.equals(str)) {
            userInfo.setUserSign(xmlPullParser.nextText());
        } else if (LOGIN_NOTICE.equals(str)) {
            userInfo.setLoginNotice(xmlPullParser.nextText());
        } else if ("srvNationalCode".equals(str)) {
            userInfo.setServiceCountryCode(xmlPullParser.nextText());
        }
    }
}
