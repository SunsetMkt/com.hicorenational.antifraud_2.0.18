package l.a.a.a.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.hihonor.honorid.core.data.HonorAccount;
import com.taobao.accs.AccsClientConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import l.a.a.a.j.e;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: XmlFileGrade.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<HonorAccount> a(String str, Context context, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        ?? r2 = 0;
        try {
            try {
                File file = new File(context.getFilesDir().getCanonicalPath() + "/" + str);
                if (!file.exists()) {
                    e.b("XmlFileGrade", "xmlfilegradle sdk filepath not exist", true);
                    return new ArrayList<>();
                }
                fileInputStream = new FileInputStream(file);
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream, null);
                    ArrayList<HonorAccount> arrayListA = a(xmlPullParserNewPullParser, context, z);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                        e.a("XmlFileGrade", "IOException", true);
                    }
                    return arrayListA;
                } catch (FileNotFoundException unused2) {
                    e.a("XmlFileGrade", "readAccountsFromXml FileNotFoundException", true);
                    ArrayList<HonorAccount> arrayList = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            e.a("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList;
                } catch (IOException unused4) {
                    e.a("XmlFileGrade", "readAccountsFromXml IOException", true);
                    ArrayList<HonorAccount> arrayList2 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                            e.a("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList2;
                } catch (RuntimeException unused6) {
                    e.a("XmlFileGrade", "readAccountsFromXml RuntimeException", true);
                    ArrayList<HonorAccount> arrayList3 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                            e.a("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList3;
                } catch (XmlPullParserException unused8) {
                    e.a("XmlFileGrade", "XmlPullParserException readAccountsFromXmlfailed!", true);
                    ArrayList<HonorAccount> arrayList4 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused9) {
                            e.a("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList4;
                } catch (Exception unused10) {
                    e.a("XmlFileGrade", "readAccountsFromXml Exception", true);
                    ArrayList<HonorAccount> arrayList5 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused11) {
                            e.a("XmlFileGrade", "IOException", true);
                        }
                    }
                    return arrayList5;
                }
            } catch (FileNotFoundException unused12) {
                fileInputStream = null;
            } catch (IOException unused13) {
                fileInputStream = null;
            } catch (RuntimeException unused14) {
                fileInputStream = null;
            } catch (XmlPullParserException unused15) {
                fileInputStream = null;
            } catch (Exception unused16) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (r2 != 0) {
                }
            }
        } catch (Throwable th2) {
            r2 = str;
            th = th2;
            if (r2 != 0) {
                throw th;
            }
            try {
                r2.close();
                throw th;
            } catch (IOException unused17) {
                e.a("XmlFileGrade", "IOException", true);
                throw th;
            }
        }
    }

    private static void b(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if ("loginUserName".equals(str)) {
            honorAccount.l(com.hihonor.honorid.d.a.b.c(context, xmlPullParser.nextText()));
        } else if (d.c.a.b.a.a.D.equals(str)) {
            honorAccount.j(com.hihonor.honorid.d.a.b.c(context, xmlPullParser.nextText()));
        }
    }

    private void b(Context context) {
        e.b("XmlFileGrade", "update HnAccounts.xml when version update", true);
        l.a.a.b.a.a aVarA = l.a.a.b.a.a.a(context);
        aVarA.a("last_head_picture_url");
        e.b("XmlFileGrade", "delete last_head_picture_url in HonorAccount.xml", true);
        aVarA.a("DEVID_1");
        e.b("XmlFileGrade", "delete DEVID in HonorAccount.xml", true);
        aVarA.a("SUBDEVID");
        e.b("XmlFileGrade", "delete SUBDEVID in HonorAccount.xml", true);
        aVarA.a("hasEncryptHeadPictureUrl");
        e.b("XmlFileGrade", "delete hasEncryptHeadPictureUrl in HonorAccount.xml", true);
        String strA = aVarA.a("accessToken", "");
        if (!TextUtils.isEmpty(strA)) {
            String strC = com.hihonor.honorid.d.a.b.c(context, strA);
            if (!TextUtils.isEmpty(strC)) {
                e.b("XmlFileGrade", "update accessToken in HonorAccount.xml", true);
                aVarA.b("accessToken", strC);
            } else {
                aVarA.a("accessToken");
                e.b("XmlFileGrade", "accessToken ecb decrypt error", true);
            }
        }
        String strA2 = aVarA.a("UUID", "");
        if (!TextUtils.isEmpty(strA2)) {
            e.b("XmlFileGrade", "update uuid in HonorAccount.xml", true);
            aVarA.b("UUID", strA2);
        } else {
            aVarA.a("UUID");
            e.b("XmlFileGrade", "uuid ecb decrypt error", true);
        }
    }

    private static void a(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) throws XmlPullParserException, IOException {
        if ("userId".equals(str)) {
            String strNextText = xmlPullParser.nextText();
            if (z) {
                strNextText = com.hihonor.honorid.d.a.b.c(context, strNextText);
            }
            honorAccount.x(strNextText);
            return;
        }
        if ("deviceId".equals(str)) {
            String strNextText2 = xmlPullParser.nextText();
            if (z) {
                strNextText2 = com.hihonor.honorid.d.a.b.c(context, strNextText2);
            }
            honorAccount.g(strNextText2);
            return;
        }
        if (d.c.a.b.a.a.t.equals(str)) {
            String strNextText3 = xmlPullParser.nextText();
            if (z) {
                strNextText3 = com.hihonor.honorid.d.a.b.c(context, strNextText3);
            }
            honorAccount.s(strNextText3);
            return;
        }
        if ("deviceType".equals(str)) {
            honorAccount.h(xmlPullParser.nextText());
            return;
        }
        if (d.c.a.b.a.a.N.equals(str)) {
            honorAccount.t(com.hihonor.honorid.d.a.b.c(context, xmlPullParser.nextText()));
            return;
        }
        if (d.c.a.b.a.a.q.equals(str)) {
            try {
                honorAccount.b(Integer.parseInt(xmlPullParser.nextText()));
                return;
            } catch (NumberFormatException unused) {
                e.d("XmlFileGrade", "NumberFormatException: read accounts.xml parseInt error", true);
                return;
            } catch (Exception unused2) {
                e.d("XmlFileGrade", "read accounts.xml parseInt error", true);
                return;
            }
        }
        if ("accountType".equals(str)) {
            honorAccount.d(xmlPullParser.nextText());
        } else {
            b(xmlPullParser, context, z, honorAccount, str);
        }
    }

    private static ArrayList<HonorAccount> a(XmlPullParser xmlPullParser, Context context, boolean z) throws XmlPullParserException, IOException {
        e.c("XmlFileGrade", "parseAccountsFromXml Start", true);
        int eventType = xmlPullParser.getEventType();
        ArrayList<HonorAccount> arrayList = new ArrayList<>();
        HonorAccount honorAccount = new HonorAccount();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType != 0) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        e.c("XmlFileGrade", AccsClientConfig.DEFAULT_CONFIGTAG, true);
                    } else if (d.c.a.b.a.a.P.equals(name)) {
                        e.c("XmlFileGrade", "parseAccountsFromXml account add ", true);
                        if (!TextUtils.isEmpty(honorAccount.c())) {
                            arrayList.add(honorAccount);
                        } else {
                            e.b("XmlFileGrade", "Invalid account , not need add.", true);
                        }
                        honorAccount = new HonorAccount();
                    }
                } else if (d.c.a.b.a.a.P.equals(name)) {
                    String attributeValue = xmlPullParser.getAttributeValue("", "appId");
                    if (TextUtils.isEmpty(attributeValue)) {
                        e.c("XmlFileGrade", "authTokenType is null", true);
                        attributeValue = com.hihonor.honorid.f.a.d(context);
                    }
                    honorAccount.u(attributeValue);
                } else if (d.c.a.b.a.a.H.equals(name)) {
                    String strNextText = xmlPullParser.nextText();
                    if (z) {
                        strNextText = com.hihonor.honorid.d.a.b.c(context, strNextText);
                    }
                    honorAccount.c(strNextText);
                } else {
                    a(xmlPullParser, context, z, honorAccount, name);
                }
            }
            eventType = xmlPullParser.next();
        }
        return arrayList;
    }

    @Override // l.a.a.a.i.a
    public void a(Context context, int i2, int i3) throws Throwable {
        if (i2 >= i3) {
            e.a("XmlFileGrade", "newVersion is less then oldVersion, onUpgrade error", true);
        } else {
            b(context);
            a(context);
        }
    }

    private void a(Context context) throws Throwable {
        if (com.hihonor.honorid.f.a.e(context)) {
            return;
        }
        ArrayList<HonorAccount> arrayListA = a("accounts.xml", context, true);
        l.a.a.a.c.a(context, "accounts.xml");
        com.hihonor.honorid.g.c.b.a(context, "accounts.xml", (List<HonorAccount>) arrayListA, true);
    }
}
