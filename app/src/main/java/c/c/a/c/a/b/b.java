package c.c.a.c.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import c.c.a.d.j;
import c.c.a.d.k;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.client.Status;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.honor.openSdk.R;
import com.huawei.hms.android.SystemUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k.a.a.a.d;
import k.a.a.a.g;
import k.a.a.a.j.e;
import org.json.JSONObject;

/* compiled from: AccountAuthUtil.java */
/* loaded from: classes.dex */
public class b {
    public static Intent b(Context context, SignInOptions signInOptions) {
        if (context == null) {
            return null;
        }
        e.a(context);
        e.b("AccountAuthUtil", "getSignInIntent", true);
        if (g.c(context, 60000000)) {
            if (TextUtils.equals(g.b(context, k.a.a.a.e.a(context).a()), context.getString(R.string.apk_raw_finger))) {
                if (!c(context)) {
                    return null;
                }
            } else if (g.a(context, 60300360)) {
                e.b("AccountAuthUtil", "HonorAPK version is too low", true);
                return null;
            }
        } else if (g.c(context)) {
            if (g.a(context, 60300360)) {
                e.b("AccountAuthUtil", "HonorAPK version is too low", true);
                return null;
            }
        } else if (!c(context)) {
            return null;
        }
        String c2 = com.hihonor.honorid.f.a.c(context);
        b(context, 907114522, 100, "getSignInIntent entry", c2, "api_entry");
        k.a.a.a.a.a(context, "AccountAuthUtil : Null context is not permitted.");
        String packageName = context.getPackageName();
        if (!TextUtils.equals(packageName, com.hihonor.honorid.f.a.d(context))) {
            e.b("AccountAuthUtil", "packageName is not equals current's!", true);
            b(context, 907114522, 100, "packageName is not equals current's!", c2, "api_ret");
            return null;
        }
        String b2 = signInOptions.b();
        k.a.a.a.a.a(b2, "AccountAuthUtil : Null clientId is not permitted.");
        Intent intent = new Intent();
        intent.setAction(c.c.a.b.a.a.w0);
        intent.setPackage("com.hihonor.id");
        intent.putExtra(Constants.PARAM_CLIENT_ID, b2);
        intent.putExtra(Constants.PARAM_SCOPE, d.a(signInOptions.f()));
        intent.putExtra("loginChannel", signInOptions.c());
        intent.putExtra(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, packageName);
        intent.putExtra("requireAuthCode", signInOptions.l());
        intent.putExtra("requireToken", signInOptions.m());
        intent.putExtra("callType", "openSDK");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, int i2, int i3, String str, String str2, String str3) {
    }

    private static boolean c(Context context) {
        if (!g.a(context, 50120345) && ((!g.b(context, 60100316) || !g.c(context, 60100318)) && ((!g.b(context, 60100301) || !g.c(context, 60100303)) && g.b(context) != 60130300))) {
            return true;
        }
        e.b("AccountAuthUtil", "HonorAPK version is too low", true);
        return false;
    }

    public static j<SignInAccountInfo> d(Context context, SignInOptions signInOptions) {
        e.b("AccountAuthUtil", "silentSignIn start!", true);
        String c2 = com.hihonor.honorid.f.a.c(context);
        b(context, 907114521, 100, "silentSignIn entry", c2, "api_entry");
        k kVar = new k();
        if (!com.hihonor.honorid.f.a.a(context)) {
            e.a("AccountAuthUtil", "HonorAccount is not install", true);
            b(context, 907114521, 102, "HonorAccount is not install!", c2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(34, "HonorAccount is not install")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.HonorInvokeService")) {
            e.a("AccountAuthUtil", "HonorAPK version is too low", true);
            b(context, 907114521, 103, "HonorAPK version is too low", c2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(35, "HonorAPK version is too low")));
            return kVar.a();
        }
        if (TextUtils.isEmpty(signInOptions.b())) {
            e.a("AccountAuthUtil", "clientid is null", true);
            b(context, 907114521, 104, "clientid is null", c2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(12, "clientid is null")));
            return kVar.a();
        }
        k.a.a.c.a.a a2 = k.a.a.c.a.a.a(context);
        if (a2 == null) {
            e.a("AccountAuthUtil", "manager is null", true);
            b(context, 907114521, 106, "manager is null", c2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(40, "manager is null!")));
            return kVar.a();
        }
        Bundle a3 = c.c.a.c.a.b.a.a(signInOptions);
        a3.putString("transid", c2);
        a3.putBoolean("silentSignIn", true);
        a3.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
        a3.putString("callType", "openSDK");
        a2.a(new c.c.a.a.e.b(context, context.getPackageName(), a3, new a(context, c2, kVar)));
        return kVar.a();
    }

    /* compiled from: AccountAuthUtil.java */
    class a implements c.c.a.a.d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3119a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3120b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f3121c;

        a(Context context, String str, k kVar) {
            this.f3119a = context;
            this.f3120b = str;
            this.f3121c = kVar;
        }

        @Override // c.c.a.a.d.a
        public void a(ErrorStatus errorStatus) {
            b.b(this.f3119a, 907114521, -1, "request network fail", this.f3120b, "api_ret");
            this.f3121c.a((Exception) new c.c.a.a.a(new Status(errorStatus.a(), errorStatus.b())));
        }

        @Override // c.c.a.a.d.a
        public void a(HonorAccount honorAccount) {
            b.b(this.f3119a, 907114521, 0, "request network success", this.f3120b, "_success");
            if (honorAccount != null) {
                this.f3121c.a((k) c.c.a.c.a.b.a.a(honorAccount));
            }
        }
    }

    /* compiled from: AccountAuthUtil.java */
    class c implements c.c.a.a.d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3127a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3128b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f3129c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f3130d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f3131e;

        c(Context context, String str, CountDownLatch countDownLatch, List list, AtomicBoolean atomicBoolean) {
            this.f3127a = context;
            this.f3128b = str;
            this.f3129c = countDownLatch;
            this.f3130d = list;
            this.f3131e = atomicBoolean;
        }

        @Override // c.c.a.a.d.b
        public void a(ErrorStatus errorStatus) {
            e.a("AccountAuthUtil", "checkIsContainScopes onFail : " + errorStatus.b(), true);
            this.f3129c.countDown();
        }

        @Override // c.c.a.a.d.b
        public void a(Bundle bundle) {
            b.b(this.f3127a, 907114518, 0, "checkIsContainScopes req success", this.f3128b, "api_ret");
            String string = bundle.getString(Constants.PARAM_SCOPE);
            if (TextUtils.isEmpty(string)) {
                e.b("AccountAuthUtil", "authOperationResult : strScope is null", true);
                this.f3129c.countDown();
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                for (String str : new JSONObject(string).getString(Constants.PARAM_SCOPE).replace("[", "").replace("]", "").replace(c.c.a.b.a.a.f3100g, "").split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new Scope(str));
                    }
                }
            } catch (Exception e2) {
                e.b("AccountAuthUtil", "authOperationResult json exception", true);
                e2.printStackTrace();
            }
            if (arrayList.containsAll(this.f3130d)) {
                this.f3131e.set(true);
            }
            this.f3129c.countDown();
        }
    }

    public static j<SignInAccountInfo> a(int i2, Intent intent) {
        e.b("AccountAuthUtil", "getSignInResultFromIntent : resultCode" + i2, true);
        k kVar = new k();
        String str = "intent is null";
        if (intent != null) {
            if (-2 == i2 || -1 == i2) {
                HonorAccount a2 = new HonorAccount().a(intent.getExtras());
                com.hihonor.honorid.h.a.a(com.hihonor.honorid.a.c().a()).a(a2);
                kVar.a((k) SignInAccountInfo.a(a2.m(), "", null, a2.n(), a2.v(), a2.i()));
                return kVar.a();
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
                e.a("AccountAuthUtil", "loginResult : errCode = " + i2 + " errMsg = " + str, true);
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
            i2 = ErrorStatus.r0;
            str = "user cancel login!";
        } else {
            if (2012 == i2) {
                i2 = 70;
                str = "user cancel auth!";
            }
            i2 = 67;
        }
        kVar.a((Exception) new c.c.a.a.a(new Status(i2, str)));
        return kVar.a();
    }

    /* compiled from: AccountAuthUtil.java */
    /* renamed from: c.c.a.c.a.b.b$b, reason: collision with other inner class name */
    class C0040b implements c.c.a.a.d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3122a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f3123b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3124c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3125d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f3126e;

        C0040b(String str, Context context, int i2, String str2, k kVar) {
            this.f3122a = str;
            this.f3123b = context;
            this.f3124c = i2;
            this.f3125d = str2;
            this.f3126e = kVar;
        }

        @Override // c.c.a.a.d.b
        public void a(ErrorStatus errorStatus) {
            e.a("AccountAuthUtil", "authOperation : onFail call opType:" + this.f3122a, true);
            b.b(this.f3123b, this.f3124c, -1, "authOperation req fail", this.f3125d, "api_ret");
            this.f3126e.a((Exception) new c.c.a.a.a(new Status(errorStatus.a(), errorStatus.b())));
            e.a("AccountAuthUtil", "call opType:" + this.f3122a + " error:" + errorStatus.a(), true);
        }

        @Override // c.c.a.a.d.b
        public void a(Bundle bundle) {
            e.a("AccountAuthUtil", "authOperation : onSuccess call opType:" + this.f3122a, true);
            b.b(this.f3123b, this.f3124c, 0, "authOperation req success", this.f3125d, "api_ret");
            this.f3126e.a((k) null);
        }
    }

    public static j<Void> c(Context context, SignInOptions signInOptions) {
        e.b("AccountAuthUtil", "logout start!", true);
        return a(context, signInOptions, 907114520, "logout entry", com.hihonor.honorid.f.a.c(context), "honorid.signout");
    }

    public static j<Void> a(Context context, SignInOptions signInOptions, int i2, String str, String str2, String str3) {
        e.b("AccountAuthUtil", "authOperation : opType = " + str3, true);
        b(context, i2, 100, str, str2, "api_entry");
        k kVar = new k();
        if (context == null) {
            e.b("AccountAuthUtil", "getAccountsByType: context is null", true);
            kVar.a((Exception) new c.c.a.a.a(new Status(12, "getAccountsByType: context is null!")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.b(context)) {
            e.b("AccountAuthUtil", "can not use honor id", true);
            b(context, i2, 105, "can not use honor id", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(33, "can not use honor id!")));
            return kVar.a();
        }
        if (!g.a(context)) {
            e.b("AccountAuthUtil", "honor id is not exit", true);
            b(context, i2, 102, "honor id is not exit", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(34, "honor id is not exit!")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.HonorInvokeService")) {
            e.a("AccountAuthUtil", "HonorAPK version is too low", true);
            b(context, 907114521, 103, "HonorAPK version is too low", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(35, "HonorAPK version is too low")));
            return kVar.a();
        }
        k.a.a.c.a.a a2 = k.a.a.c.a.a.a(context);
        if (a2 == null) {
            e.a("AccountAuthUtil", "manager is null", true);
            b(context, i2, 106, "manager is null", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(40, "manager is null!")));
            return kVar.a();
        }
        String b2 = com.hihonor.honorid.h.a.a(context).b();
        if (TextUtils.isEmpty(b2) && !"honorid.revokeaccess".equals(str3)) {
            e.a("AccountAuthUtil", "userId is null", true);
            b(context, i2, 106, "userId is null", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(12, "userId is null!")));
            return kVar.a();
        }
        Bundle bundle = new Bundle();
        bundle.putString("app_id", signInOptions.b());
        bundle.putString("access_token", signInOptions.a());
        bundle.putString("uid", b2);
        bundle.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
        a2.a(new c.c.a.a.e.a(context, bundle, str3, new C0040b(str3, context, i2, str2, kVar)));
        return kVar.a();
    }

    public static boolean b(Context context) {
        return g.c(context, 60001301);
    }

    public static j<Void> a(Context context, SignInOptions signInOptions) {
        e.b("AccountAuthUtil", "cancelAuthorization start!", true);
        return a(context, signInOptions, 907114519, "cancelAuthorization entry", com.hihonor.honorid.f.a.c(context), "honorid.revokeaccess");
    }

    public static boolean a(Context context, SignInAccountInfo signInAccountInfo, List<Scope> list) {
        e.b("AccountAuthUtil", "checkIsContainScopes start!", true);
        String c2 = com.hihonor.honorid.f.a.c(context);
        b(context, 907114518, 100, "checkIsContainScopes entry", c2, "api_entry");
        if (signInAccountInfo == null) {
            e.b("AccountAuthUtil", "checkIsContainScopes signInAccountInfo is null", true);
            return false;
        }
        if (list != null && list.size() > 0) {
            String b2 = com.hihonor.honorid.h.a.a(context).b();
            if (TextUtils.isEmpty(b2)) {
                e.a("AccountAuthUtil", "checkIsContainScopes : userId is null", true);
                return false;
            }
            k.a.a.c.a.a a2 = k.a.a.c.a.a.a(context);
            if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.ICloudService")) {
                e.b("AccountAuthUtil", "has no service: com.hihonor.id.ICloudService", true);
                return false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", signInAccountInfo.a());
            bundle.putString("uid", b2);
            bundle.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
            a2.a(new c.c.a.a.e.a(context, bundle, "honorid.getScope", new c(context, c2, countDownLatch, list, atomicBoolean)));
            try {
                if (!countDownLatch.await(com.heytap.mcssdk.constant.a.r, TimeUnit.MILLISECONDS)) {
                    return false;
                }
            } catch (Exception e2) {
                e.b("AccountAuthUtil", "checkIsContainScopes await error ： " + e2.getMessage(), true);
            }
            return atomicBoolean.get();
        }
        e.b("AccountAuthUtil", "checkIsContainScopes scopeList is null or size <= 0", true);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        if (r3 == null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r10) {
        /*
            java.lang.String r0 = "AccountAuthUtil"
            r1 = 1
            java.lang.String r2 = "isAccountAlreadyLogin"
            k.a.a.a.j.e.b(r0, r2, r1)
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
            k.a.a.a.j.e.a(r0, r10, r1)     // Catch: java.lang.Throwable -> L46 java.lang.SecurityException -> L4f java.lang.IllegalArgumentException -> L58 android.database.SQLException -> L61
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
            k.a.a.a.j.e.b(r0, r4, r1)     // Catch: java.lang.Throwable -> L47 java.lang.SecurityException -> L50 java.lang.IllegalArgumentException -> L59 android.database.SQLException -> L62
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
            k.a.a.a.j.e.b(r0, r2, r1)     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L6c
            goto L69
        L4f:
            r10 = 0
        L50:
            java.lang.String r2 = "isAccountAlreadyLogin SecurityException."
            k.a.a.a.j.e.b(r0, r2, r1)     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L6c
            goto L69
        L58:
            r10 = 0
        L59:
            java.lang.String r2 = "isAccountAlreadyLogin IllegalArgumentException."
            k.a.a.a.j.e.b(r0, r2, r1)     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L6c
            goto L69
        L61:
            r10 = 0
        L62:
            java.lang.String r2 = "isAccountAlreadyLogin SQLException."
            k.a.a.a.j.e.b(r0, r2, r1)     // Catch: java.lang.Throwable -> L81
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
            k.a.a.a.j.e.b(r0, r2, r1)
            return r10
        L81:
            r10 = move-exception
            if (r3 == 0) goto L87
            r3.close()
        L87:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.c.a.b.b.a(android.content.Context):boolean");
    }

    public static boolean a() {
        try {
            return TextUtils.equals(Build.MANUFACTURER, SystemUtils.PRODUCT_HONOR);
        } catch (Exception unused) {
            return false;
        }
    }
}
