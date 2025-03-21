package p031c.p075c.p076a.p084c.p085a.p086b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.client.Status;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.honorid.C2151a;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.hihonor.honorid.p165f.C2171a;
import com.hihonor.honorid.p168h.C2178a;
import com.honor.openSdk.C2244R;
import com.huawei.hms.android.SystemUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import p031c.p075c.p076a.p077a.C1182a;
import p031c.p075c.p076a.p077a.p079d.InterfaceC1187a;
import p031c.p075c.p076a.p077a.p079d.InterfaceC1188b;
import p031c.p075c.p076a.p077a.p080e.C1189a;
import p031c.p075c.p076a.p077a.p080e.C1190b;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p031c.p075c.p076a.p090d.C1214k;
import p358k.p359a.p360a.p361a.C5847a;
import p358k.p359a.p360a.p361a.C5850d;
import p358k.p359a.p360a.p361a.C5851e;
import p358k.p359a.p360a.p361a.C5853g;
import p358k.p359a.p360a.p361a.p363j.C5863e;
import p358k.p359a.p360a.p367c.p368a.ServiceConnectionC5866a;

/* compiled from: AccountAuthUtil.java */
/* renamed from: c.c.a.c.a.b.b */
/* loaded from: classes.dex */
public class C1200b {
    /* renamed from: b */
    public static Intent m2303b(Context context, SignInOptions signInOptions) {
        if (context == null) {
            return null;
        }
        C5863e.m24690a(context);
        C5863e.m24692b("AccountAuthUtil", "getSignInIntent", true);
        if (C5853g.m24648c(context, 60000000)) {
            if (TextUtils.equals(C5853g.m24644b(context, C5851e.m24637a(context).m24638a()), context.getString(C2244R.string.apk_raw_finger))) {
                if (!m2307c(context)) {
                    return null;
                }
            } else if (C5853g.m24641a(context, 60300360)) {
                C5863e.m24692b("AccountAuthUtil", "HonorAPK version is too low", true);
                return null;
            }
        } else if (C5853g.m24647c(context)) {
            if (C5853g.m24641a(context, 60300360)) {
                C5863e.m24692b("AccountAuthUtil", "HonorAPK version is too low", true);
                return null;
            }
        } else if (!m2307c(context)) {
            return null;
        }
        String m6324c = C2171a.m6324c(context);
        m2304b(context, 907114522, 100, "getSignInIntent entry", m6324c, "api_entry");
        C5847a.m24623a(context, "AccountAuthUtil : Null context is not permitted.");
        String packageName = context.getPackageName();
        if (!TextUtils.equals(packageName, C2171a.m6326d(context))) {
            C5863e.m24692b("AccountAuthUtil", "packageName is not equals current's!", true);
            m2304b(context, 907114522, 100, "packageName is not equals current's!", m6324c, "api_ret");
            return null;
        }
        String m6026b = signInOptions.m6026b();
        C5847a.m24624a(m6026b, "AccountAuthUtil : Null clientId is not permitted.");
        Intent intent = new Intent();
        intent.setAction(AbstractC1191a.f2617w0);
        intent.setPackage("com.hihonor.id");
        intent.putExtra(Constants.PARAM_CLIENT_ID, m6026b);
        intent.putExtra(Constants.PARAM_SCOPE, C5850d.m24636a(signInOptions.m6030f()));
        intent.putExtra("loginChannel", signInOptions.m6027c());
        intent.putExtra(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, packageName);
        intent.putExtra("requireAuthCode", signInOptions.m6036l());
        intent.putExtra("requireToken", signInOptions.m6037m());
        intent.putExtra("callType", "openSDK");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m2304b(Context context, int i2, int i3, String str, String str2, String str3) {
    }

    /* renamed from: c */
    private static boolean m2307c(Context context) {
        if (!C5853g.m24641a(context, 50120345) && ((!C5853g.m24646b(context, 60100316) || !C5853g.m24648c(context, 60100318)) && ((!C5853g.m24646b(context, 60100301) || !C5853g.m24648c(context, 60100303)) && C5853g.m24643b(context) != 60130300))) {
            return true;
        }
        C5863e.m24692b("AccountAuthUtil", "HonorAPK version is too low", true);
        return false;
    }

    /* renamed from: d */
    public static AbstractC1213j<SignInAccountInfo> m2308d(Context context, SignInOptions signInOptions) {
        C5863e.m24692b("AccountAuthUtil", "silentSignIn start!", true);
        String m6324c = C2171a.m6324c(context);
        m2304b(context, 907114521, 100, "silentSignIn entry", m6324c, "api_entry");
        C1214k c1214k = new C1214k();
        if (!C2171a.m6319a(context)) {
            C5863e.m24691a("AccountAuthUtil", "HonorAccount is not install", true);
            m2304b(context, 907114521, 102, "HonorAccount is not install!", m6324c, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(34, "HonorAccount is not install")));
            return c1214k.m2345a();
        }
        if (!C2171a.m6320a(context, "com.hihonor.id.HonorInvokeService")) {
            C5863e.m24691a("AccountAuthUtil", "HonorAPK version is too low", true);
            m2304b(context, 907114521, 103, "HonorAPK version is too low", m6324c, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(35, "HonorAPK version is too low")));
            return c1214k.m2345a();
        }
        if (TextUtils.isEmpty(signInOptions.m6026b())) {
            C5863e.m24691a("AccountAuthUtil", "clientid is null", true);
            m2304b(context, 907114521, 104, "clientid is null", m6324c, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(12, "clientid is null")));
            return c1214k.m2345a();
        }
        ServiceConnectionC5866a m24716a = ServiceConnectionC5866a.m24716a(context);
        if (m24716a == null) {
            C5863e.m24691a("AccountAuthUtil", "manager is null", true);
            m2304b(context, 907114521, 106, "manager is null", m6324c, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(40, "manager is null!")));
            return c1214k.m2345a();
        }
        Bundle m2294a = C1199a.m2294a(signInOptions);
        m2294a.putString("transid", m6324c);
        m2294a.putBoolean("silentSignIn", true);
        m2294a.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
        m2294a.putString("callType", "openSDK");
        m24716a.m24733a(new C1190b(context, context.getPackageName(), m2294a, new a(context, m6324c, c1214k)));
        return c1214k.m2345a();
    }

    /* compiled from: AccountAuthUtil.java */
    /* renamed from: c.c.a.c.a.b.b$a */
    class a implements InterfaceC1187a {

        /* renamed from: a */
        final /* synthetic */ Context f2640a;

        /* renamed from: b */
        final /* synthetic */ String f2641b;

        /* renamed from: c */
        final /* synthetic */ C1214k f2642c;

        a(Context context, String str, C1214k c1214k) {
            this.f2640a = context;
            this.f2641b = str;
            this.f2642c = c1214k;
        }

        @Override // p031c.p075c.p076a.p077a.p079d.InterfaceC1187a
        /* renamed from: a */
        public void mo2267a(ErrorStatus errorStatus) {
            C1200b.m2304b(this.f2640a, 907114521, -1, "request network fail", this.f2641b, "api_ret");
            this.f2642c.m2346a((Exception) new C1182a(new Status(errorStatus.m6297a(), errorStatus.m6298b())));
        }

        @Override // p031c.p075c.p076a.p077a.p079d.InterfaceC1187a
        /* renamed from: a */
        public void mo2266a(HonorAccount honorAccount) {
            C1200b.m2304b(this.f2640a, 907114521, 0, "request network success", this.f2641b, "_success");
            if (honorAccount != null) {
                this.f2642c.m2347a((C1214k) C1199a.m2295a(honorAccount));
            }
        }
    }

    /* compiled from: AccountAuthUtil.java */
    /* renamed from: c.c.a.c.a.b.b$c */
    class c implements InterfaceC1188b {

        /* renamed from: a */
        final /* synthetic */ Context f2648a;

        /* renamed from: b */
        final /* synthetic */ String f2649b;

        /* renamed from: c */
        final /* synthetic */ CountDownLatch f2650c;

        /* renamed from: d */
        final /* synthetic */ List f2651d;

        /* renamed from: e */
        final /* synthetic */ AtomicBoolean f2652e;

        c(Context context, String str, CountDownLatch countDownLatch, List list, AtomicBoolean atomicBoolean) {
            this.f2648a = context;
            this.f2649b = str;
            this.f2650c = countDownLatch;
            this.f2651d = list;
            this.f2652e = atomicBoolean;
        }

        @Override // p031c.p075c.p076a.p077a.p079d.InterfaceC1188b
        /* renamed from: a */
        public void mo2269a(ErrorStatus errorStatus) {
            C5863e.m24691a("AccountAuthUtil", "checkIsContainScopes onFail : " + errorStatus.m6298b(), true);
            this.f2650c.countDown();
        }

        @Override // p031c.p075c.p076a.p077a.p079d.InterfaceC1188b
        /* renamed from: a */
        public void mo2268a(Bundle bundle) {
            C1200b.m2304b(this.f2648a, 907114518, 0, "checkIsContainScopes req success", this.f2649b, "api_ret");
            String string = bundle.getString(Constants.PARAM_SCOPE);
            if (TextUtils.isEmpty(string)) {
                C5863e.m24692b("AccountAuthUtil", "authOperationResult : strScope is null", true);
                this.f2650c.countDown();
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                for (String str : new JSONObject(string).getString(Constants.PARAM_SCOPE).replace("[", "").replace("]", "").replace(AbstractC1191a.f2568g, "").split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new Scope(str));
                    }
                }
            } catch (Exception e2) {
                C5863e.m24692b("AccountAuthUtil", "authOperationResult json exception", true);
                e2.printStackTrace();
            }
            if (arrayList.containsAll(this.f2651d)) {
                this.f2652e.set(true);
            }
            this.f2650c.countDown();
        }
    }

    /* renamed from: a */
    public static AbstractC1213j<SignInAccountInfo> m2296a(int i2, Intent intent) {
        C5863e.m24692b("AccountAuthUtil", "getSignInResultFromIntent : resultCode" + i2, true);
        C1214k c1214k = new C1214k();
        String str = "intent is null";
        if (intent != null) {
            if (-2 == i2 || -1 == i2) {
                HonorAccount m6155a = new HonorAccount().m6155a(intent.getExtras());
                C2178a.m6345a(C2151a.m6093c().m6094a()).m6347a(m6155a);
                c1214k.m2347a((C1214k) SignInAccountInfo.m5998a(m6155a.m6183m(), "", null, m6155a.m6185n(), m6155a.m6201v(), m6155a.m6175i()));
                return c1214k.m2345a();
            }
            if (57 == i2) {
                str = "mcp check fail";
            } else if (56 == i2) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    int i3 = extras.getInt("err_code", 56);
                    str = extras.getString("server_err_desc", "access server return error");
                    i2 = i3;
                } else {
                    i2 = 56;
                }
                C5863e.m24691a("AccountAuthUtil", "loginResult : errCode = " + i2 + " errMsg = " + str, true);
                if (1101 != i2) {
                    if (1202 == i2) {
                        i2 = 68;
                    }
                }
                i2 = 67;
            } else if (2005 == i2) {
                i2 = 5;
                str = "network unaviable!";
            } else {
                str = "other error!";
            }
        } else if (i2 == 2) {
            i2 = 30;
            str = "serviceToken invalid!";
        } else if (i2 == 0) {
            i2 = ErrorStatus.f6701r0;
            str = "user cancel login!";
        } else {
            if (2012 == i2) {
                i2 = 70;
                str = "user cancel auth!";
            }
            i2 = 67;
        }
        c1214k.m2346a((Exception) new C1182a(new Status(i2, str)));
        return c1214k.m2345a();
    }

    /* compiled from: AccountAuthUtil.java */
    /* renamed from: c.c.a.c.a.b.b$b */
    class b implements InterfaceC1188b {

        /* renamed from: a */
        final /* synthetic */ String f2643a;

        /* renamed from: b */
        final /* synthetic */ Context f2644b;

        /* renamed from: c */
        final /* synthetic */ int f2645c;

        /* renamed from: d */
        final /* synthetic */ String f2646d;

        /* renamed from: e */
        final /* synthetic */ C1214k f2647e;

        b(String str, Context context, int i2, String str2, C1214k c1214k) {
            this.f2643a = str;
            this.f2644b = context;
            this.f2645c = i2;
            this.f2646d = str2;
            this.f2647e = c1214k;
        }

        @Override // p031c.p075c.p076a.p077a.p079d.InterfaceC1188b
        /* renamed from: a */
        public void mo2269a(ErrorStatus errorStatus) {
            C5863e.m24691a("AccountAuthUtil", "authOperation : onFail call opType:" + this.f2643a, true);
            C1200b.m2304b(this.f2644b, this.f2645c, -1, "authOperation req fail", this.f2646d, "api_ret");
            this.f2647e.m2346a((Exception) new C1182a(new Status(errorStatus.m6297a(), errorStatus.m6298b())));
            C5863e.m24691a("AccountAuthUtil", "call opType:" + this.f2643a + " error:" + errorStatus.m6297a(), true);
        }

        @Override // p031c.p075c.p076a.p077a.p079d.InterfaceC1188b
        /* renamed from: a */
        public void mo2268a(Bundle bundle) {
            C5863e.m24691a("AccountAuthUtil", "authOperation : onSuccess call opType:" + this.f2643a, true);
            C1200b.m2304b(this.f2644b, this.f2645c, 0, "authOperation req success", this.f2646d, "api_ret");
            this.f2647e.m2347a((C1214k) null);
        }
    }

    /* renamed from: c */
    public static AbstractC1213j<Void> m2306c(Context context, SignInOptions signInOptions) {
        C5863e.m24692b("AccountAuthUtil", "logout start!", true);
        return m2298a(context, signInOptions, 907114520, "logout entry", C2171a.m6324c(context), "honorid.signout");
    }

    /* renamed from: a */
    public static AbstractC1213j<Void> m2298a(Context context, SignInOptions signInOptions, int i2, String str, String str2, String str3) {
        C5863e.m24692b("AccountAuthUtil", "authOperation : opType = " + str3, true);
        m2304b(context, i2, 100, str, str2, "api_entry");
        C1214k c1214k = new C1214k();
        if (context == null) {
            C5863e.m24692b("AccountAuthUtil", "getAccountsByType: context is null", true);
            c1214k.m2346a((Exception) new C1182a(new Status(12, "getAccountsByType: context is null!")));
            return c1214k.m2345a();
        }
        if (!C2171a.m6322b(context)) {
            C5863e.m24692b("AccountAuthUtil", "can not use honor id", true);
            m2304b(context, i2, 105, "can not use honor id", str2, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(33, "can not use honor id!")));
            return c1214k.m2345a();
        }
        if (!C5853g.m24640a(context)) {
            C5863e.m24692b("AccountAuthUtil", "honor id is not exit", true);
            m2304b(context, i2, 102, "honor id is not exit", str2, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(34, "honor id is not exit!")));
            return c1214k.m2345a();
        }
        if (!C2171a.m6320a(context, "com.hihonor.id.HonorInvokeService")) {
            C5863e.m24691a("AccountAuthUtil", "HonorAPK version is too low", true);
            m2304b(context, 907114521, 103, "HonorAPK version is too low", str2, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(35, "HonorAPK version is too low")));
            return c1214k.m2345a();
        }
        ServiceConnectionC5866a m24716a = ServiceConnectionC5866a.m24716a(context);
        if (m24716a == null) {
            C5863e.m24691a("AccountAuthUtil", "manager is null", true);
            m2304b(context, i2, 106, "manager is null", str2, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(40, "manager is null!")));
            return c1214k.m2345a();
        }
        String m6348b = C2178a.m6345a(context).m6348b();
        if (TextUtils.isEmpty(m6348b) && !"honorid.revokeaccess".equals(str3)) {
            C5863e.m24691a("AccountAuthUtil", "userId is null", true);
            m2304b(context, i2, 106, "userId is null", str2, "api_ret");
            c1214k.m2346a((Exception) new C1182a(new Status(12, "userId is null!")));
            return c1214k.m2345a();
        }
        Bundle bundle = new Bundle();
        bundle.putString("app_id", signInOptions.m6026b());
        bundle.putString("access_token", signInOptions.m6022a());
        bundle.putString("uid", m6348b);
        bundle.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
        m24716a.m24733a(new C1189a(context, bundle, str3, new b(str3, context, i2, str2, c1214k)));
        return c1214k.m2345a();
    }

    /* renamed from: b */
    public static boolean m2305b(Context context) {
        return C5853g.m24648c(context, 60001301);
    }

    /* renamed from: a */
    public static AbstractC1213j<Void> m2297a(Context context, SignInOptions signInOptions) {
        C5863e.m24692b("AccountAuthUtil", "cancelAuthorization start!", true);
        return m2298a(context, signInOptions, 907114519, "cancelAuthorization entry", C2171a.m6324c(context), "honorid.revokeaccess");
    }

    /* renamed from: a */
    public static boolean m2302a(Context context, SignInAccountInfo signInAccountInfo, List<Scope> list) {
        C5863e.m24692b("AccountAuthUtil", "checkIsContainScopes start!", true);
        String m6324c = C2171a.m6324c(context);
        m2304b(context, 907114518, 100, "checkIsContainScopes entry", m6324c, "api_entry");
        if (signInAccountInfo == null) {
            C5863e.m24692b("AccountAuthUtil", "checkIsContainScopes signInAccountInfo is null", true);
            return false;
        }
        if (list != null && list.size() > 0) {
            String m6348b = C2178a.m6345a(context).m6348b();
            if (TextUtils.isEmpty(m6348b)) {
                C5863e.m24691a("AccountAuthUtil", "checkIsContainScopes : userId is null", true);
                return false;
            }
            ServiceConnectionC5866a m24716a = ServiceConnectionC5866a.m24716a(context);
            if (!C2171a.m6320a(context, "com.hihonor.id.ICloudService")) {
                C5863e.m24692b("AccountAuthUtil", "has no service: com.hihonor.id.ICloudService", true);
                return false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", signInAccountInfo.m6040a());
            bundle.putString("uid", m6348b);
            bundle.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
            m24716a.m24733a(new C1189a(context, bundle, "honorid.getScope", new c(context, m6324c, countDownLatch, list, atomicBoolean)));
            try {
                if (!countDownLatch.await(C2084a.f6136r, TimeUnit.MILLISECONDS)) {
                    return false;
                }
            } catch (Exception e2) {
                C5863e.m24692b("AccountAuthUtil", "checkIsContainScopes await error ： " + e2.getMessage(), true);
            }
            return atomicBoolean.get();
        }
        C5863e.m24692b("AccountAuthUtil", "checkIsContainScopes scopeList is null or size <= 0", true);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        if (r3 == null) goto L44;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m2301a(android.content.Context r10) {
        /*
            java.lang.String r0 = "AccountAuthUtil"
            r1 = 1
            java.lang.String r2 = "isAccountAlreadyLogin"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r0, r2, r1)
            r2 = 0
            r3 = 0
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L46 java.lang.SecurityException -> L4f java.lang.IllegalArgumentException -> L58 android.database.SQLException -> L61
            java.lang.String r10 = "content://com.hihonor.id.api.provider/has_login"
            android.net.Uri r5 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L46 java.lang.SecurityException -> L4f java.lang.IllegalArgumentException -> L58 android.database.SQLException -> L61
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L46 java.lang.SecurityException -> L4f java.lang.IllegalArgumentException -> L58 android.database.SQLException -> L61
            if (r3 != 0) goto L23
            java.lang.String r10 = "isAccountAlreadyLogin cursor is null."
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r0, r10, r1)     // Catch: java.lang.Throwable -> L46 java.lang.SecurityException -> L4f java.lang.IllegalArgumentException -> L58 android.database.SQLException -> L61
        L23:
            r10 = 0
        L24:
            if (r3 == 0) goto L43
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L47 java.lang.SecurityException -> L50 java.lang.IllegalArgumentException -> L59 android.database.SQLException -> L62
            if (r4 == 0) goto L43
            java.lang.String r4 = "hasLogin"
            int r4 = r3.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L47 java.lang.SecurityException -> L50 java.lang.IllegalArgumentException -> L59 android.database.SQLException -> L62
            r5 = -1
            if (r4 != r5) goto L3b
            java.lang.String r4 = "isAccountAlreadyLogin index -1"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r0, r4, r1)     // Catch: java.lang.Throwable -> L47 java.lang.SecurityException -> L50 java.lang.IllegalArgumentException -> L59 android.database.SQLException -> L62
            goto L24
        L3b:
            int r10 = r3.getInt(r4)     // Catch: java.lang.Throwable -> L47 java.lang.SecurityException -> L50 java.lang.IllegalArgumentException -> L59 android.database.SQLException -> L62
            if (r1 != r10) goto L23
            r10 = 1
            goto L24
        L43:
            if (r3 == 0) goto L6c
            goto L69
        L46:
            r10 = 0
        L47:
            java.lang.String r2 = "isAccountAlreadyLogin Throwable."
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r0, r2, r1)     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L6c
            goto L69
        L4f:
            r10 = 0
        L50:
            java.lang.String r2 = "isAccountAlreadyLogin SecurityException."
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r0, r2, r1)     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L6c
            goto L69
        L58:
            r10 = 0
        L59:
            java.lang.String r2 = "isAccountAlreadyLogin IllegalArgumentException."
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r0, r2, r1)     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L6c
            goto L69
        L61:
            r10 = 0
        L62:
            java.lang.String r2 = "isAccountAlreadyLogin SQLException."
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r0, r2, r1)     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L6c
        L69:
            r3.close()
        L6c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "account state :"
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r0, r2, r1)
            return r10
        L81:
            r10 = move-exception
            if (r3 == 0) goto L87
            r3.close()
        L87:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p075c.p076a.p084c.p085a.p086b.C1200b.m2301a(android.content.Context):boolean");
    }

    /* renamed from: a */
    public static boolean m2300a() {
        try {
            return TextUtils.equals(Build.MANUFACTURER, SystemUtils.PRODUCT_HONOR);
        } catch (Exception unused) {
            return false;
        }
    }
}
