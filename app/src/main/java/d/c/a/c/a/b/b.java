package d.c.a.c.a.b;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.client.Status;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.honor.openSdk.R;
import com.huawei.hms.android.SystemUtils;
import com.tencent.connect.common.Constants;
import d.c.a.d.j;
import d.c.a.d.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import l.a.a.a.d;
import l.a.a.a.g;
import l.a.a.a.j.e;
import org.json.JSONObject;

/* JADX INFO: compiled from: AccountAuthUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static Intent b(Context context, SignInOptions signInOptions) {
        if (context == null) {
            return null;
        }
        e.a(context);
        e.b("AccountAuthUtil", "getSignInIntent", true);
        if (g.c(context, 60000000)) {
            if (TextUtils.equals(g.b(context, l.a.a.a.e.a(context).a()), context.getString(R.string.apk_raw_finger))) {
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
        String strC = com.hihonor.honorid.f.a.c(context);
        b(context, 907114522, 100, "getSignInIntent entry", strC, "api_entry");
        l.a.a.a.a.a(context, "AccountAuthUtil : Null context is not permitted.");
        String packageName = context.getPackageName();
        if (!TextUtils.equals(packageName, com.hihonor.honorid.f.a.d(context))) {
            e.b("AccountAuthUtil", "packageName is not equals current's!", true);
            b(context, 907114522, 100, "packageName is not equals current's!", strC, "api_ret");
            return null;
        }
        String strB = signInOptions.b();
        l.a.a.a.a.a(strB, "AccountAuthUtil : Null clientId is not permitted.");
        Intent intent = new Intent();
        intent.setAction(d.c.a.b.a.a.w0);
        intent.setPackage("com.hihonor.id");
        intent.putExtra(Constants.PARAM_CLIENT_ID, strB);
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
        String strC = com.hihonor.honorid.f.a.c(context);
        b(context, 907114521, 100, "silentSignIn entry", strC, "api_entry");
        k kVar = new k();
        if (!com.hihonor.honorid.f.a.a(context)) {
            e.a("AccountAuthUtil", "HonorAccount is not install", true);
            b(context, 907114521, 102, "HonorAccount is not install!", strC, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(34, "HonorAccount is not install")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.HonorInvokeService")) {
            e.a("AccountAuthUtil", "HonorAPK version is too low", true);
            b(context, 907114521, 103, "HonorAPK version is too low", strC, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(35, "HonorAPK version is too low")));
            return kVar.a();
        }
        if (TextUtils.isEmpty(signInOptions.b())) {
            e.a("AccountAuthUtil", "clientid is null", true);
            b(context, 907114521, 104, "clientid is null", strC, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(12, "clientid is null")));
            return kVar.a();
        }
        l.a.a.c.a.a aVarA = l.a.a.c.a.a.a(context);
        if (aVarA == null) {
            e.a("AccountAuthUtil", "manager is null", true);
            b(context, 907114521, 106, "manager is null", strC, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(40, "manager is null!")));
            return kVar.a();
        }
        Bundle bundleA = d.c.a.c.a.b.a.a(signInOptions);
        bundleA.putString("transid", strC);
        bundleA.putBoolean("silentSignIn", true);
        bundleA.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
        bundleA.putString("callType", "openSDK");
        aVarA.a(new d.c.a.a.e.b(context, context.getPackageName(), bundleA, new a(context, strC, kVar)));
        return kVar.a();
    }

    /* JADX INFO: compiled from: AccountAuthUtil.java */
    class a implements d.c.a.a.d.a {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f10089c;

        a(Context context, String str, k kVar) {
            this.a = context;
            this.f10088b = str;
            this.f10089c = kVar;
        }

        @Override // d.c.a.a.d.a
        public void a(ErrorStatus errorStatus) {
            b.b(this.a, 907114521, -1, "request network fail", this.f10088b, "api_ret");
            this.f10089c.a((Exception) new d.c.a.a.a(new Status(errorStatus.a(), errorStatus.b())));
        }

        @Override // d.c.a.a.d.a
        public void a(HonorAccount honorAccount) {
            b.b(this.a, 907114521, 0, "request network success", this.f10088b, "_success");
            if (honorAccount != null) {
                this.f10089c.a(d.c.a.c.a.b.a.a(honorAccount));
            }
        }
    }

    /* JADX INFO: compiled from: AccountAuthUtil.java */
    class c implements d.c.a.a.d.b {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f10095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f10096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f10097e;

        c(Context context, String str, CountDownLatch countDownLatch, List list, AtomicBoolean atomicBoolean) {
            this.a = context;
            this.f10094b = str;
            this.f10095c = countDownLatch;
            this.f10096d = list;
            this.f10097e = atomicBoolean;
        }

        @Override // d.c.a.a.d.b
        public void a(ErrorStatus errorStatus) {
            e.a("AccountAuthUtil", "checkIsContainScopes onFail : " + errorStatus.b(), true);
            this.f10095c.countDown();
        }

        @Override // d.c.a.a.d.b
        public void a(Bundle bundle) {
            b.b(this.a, 907114518, 0, "checkIsContainScopes req success", this.f10094b, "api_ret");
            String string = bundle.getString(Constants.PARAM_SCOPE);
            if (TextUtils.isEmpty(string)) {
                e.b("AccountAuthUtil", "authOperationResult : strScope is null", true);
                this.f10095c.countDown();
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                for (String str : new JSONObject(string).getString(Constants.PARAM_SCOPE).replace("[", "").replace("]", "").replace(d.c.a.b.a.a.f10074g, "").split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new Scope(str));
                    }
                }
            } catch (Exception e2) {
                e.b("AccountAuthUtil", "authOperationResult json exception", true);
                e2.printStackTrace();
            }
            if (arrayList.containsAll(this.f10096d)) {
                this.f10097e.set(true);
            }
            this.f10095c.countDown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5 A[PHI: r4
  0x00d5: PHI (r4v4 java.lang.String) = (r4v0 java.lang.String), (r4v9 java.lang.String) binds: [B:36:0x00cd, B:19:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static j<SignInAccountInfo> a(int i2, Intent intent) {
        e.b("AccountAuthUtil", "getSignInResultFromIntent : resultCode" + i2, true);
        k kVar = new k();
        String string = "intent is null";
        if (intent != null) {
            if (-2 == i2 || -1 == i2) {
                HonorAccount honorAccountA = new HonorAccount().a(intent.getExtras());
                com.hihonor.honorid.h.a.a(com.hihonor.honorid.a.c().a()).a(honorAccountA);
                kVar.a(SignInAccountInfo.a(honorAccountA.m(), "", null, honorAccountA.n(), honorAccountA.v(), honorAccountA.i()));
                return kVar.a();
            }
            if (57 == i2) {
                string = "mcp check fail";
            } else if (56 == i2) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    int i3 = extras.getInt("err_code", 56);
                    string = extras.getString("server_err_desc", "access server return error");
                    i2 = i3;
                } else {
                    i2 = 56;
                }
                e.a("AccountAuthUtil", "loginResult : errCode = " + i2 + " errMsg = " + string, true);
                if (1101 == i2) {
                    i2 = 67;
                } else if (1202 == i2) {
                    i2 = 68;
                }
            } else if (2005 == i2) {
                i2 = 5;
                string = "network unaviable!";
            } else {
                string = "other error!";
            }
        } else if (i2 == 2) {
            i2 = 30;
            string = "serviceToken invalid!";
        } else if (i2 == 0) {
            i2 = ErrorStatus.r0;
            string = "user cancel login!";
        } else if (2012 == i2) {
            i2 = 70;
            string = "user cancel auth!";
        }
        kVar.a((Exception) new d.c.a.a.a(new Status(i2, string)));
        return kVar.a();
    }

    /* JADX INFO: renamed from: d.c.a.c.a.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccountAuthUtil.java */
    class C0163b implements d.c.a.a.d.b {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f10090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f10091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f10093e;

        C0163b(String str, Context context, int i2, String str2, k kVar) {
            this.a = str;
            this.f10090b = context;
            this.f10091c = i2;
            this.f10092d = str2;
            this.f10093e = kVar;
        }

        @Override // d.c.a.a.d.b
        public void a(ErrorStatus errorStatus) {
            e.a("AccountAuthUtil", "authOperation : onFail call opType:" + this.a, true);
            b.b(this.f10090b, this.f10091c, -1, "authOperation req fail", this.f10092d, "api_ret");
            this.f10093e.a((Exception) new d.c.a.a.a(new Status(errorStatus.a(), errorStatus.b())));
            e.a("AccountAuthUtil", "call opType:" + this.a + " error:" + errorStatus.a(), true);
        }

        @Override // d.c.a.a.d.b
        public void a(Bundle bundle) {
            e.a("AccountAuthUtil", "authOperation : onSuccess call opType:" + this.a, true);
            b.b(this.f10090b, this.f10091c, 0, "authOperation req success", this.f10092d, "api_ret");
            this.f10093e.a((Object) null);
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
            kVar.a((Exception) new d.c.a.a.a(new Status(12, "getAccountsByType: context is null!")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.b(context)) {
            e.b("AccountAuthUtil", "can not use honor id", true);
            b(context, i2, 105, "can not use honor id", str2, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(33, "can not use honor id!")));
            return kVar.a();
        }
        if (!g.a(context)) {
            e.b("AccountAuthUtil", "honor id is not exit", true);
            b(context, i2, 102, "honor id is not exit", str2, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(34, "honor id is not exit!")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.HonorInvokeService")) {
            e.a("AccountAuthUtil", "HonorAPK version is too low", true);
            b(context, 907114521, 103, "HonorAPK version is too low", str2, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(35, "HonorAPK version is too low")));
            return kVar.a();
        }
        l.a.a.c.a.a aVarA = l.a.a.c.a.a.a(context);
        if (aVarA == null) {
            e.a("AccountAuthUtil", "manager is null", true);
            b(context, i2, 106, "manager is null", str2, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(40, "manager is null!")));
            return kVar.a();
        }
        String strB = com.hihonor.honorid.h.a.a(context).b();
        if (TextUtils.isEmpty(strB) && !"honorid.revokeaccess".equals(str3)) {
            e.a("AccountAuthUtil", "userId is null", true);
            b(context, i2, 106, "userId is null", str2, "api_ret");
            kVar.a((Exception) new d.c.a.a.a(new Status(12, "userId is null!")));
            return kVar.a();
        }
        Bundle bundle = new Bundle();
        bundle.putString("app_id", signInOptions.b());
        bundle.putString("access_token", signInOptions.a());
        bundle.putString("uid", strB);
        bundle.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
        aVarA.a(new d.c.a.a.e.a(context, bundle, str3, new C0163b(str3, context, i2, str2, kVar)));
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
        String strC = com.hihonor.honorid.f.a.c(context);
        b(context, 907114518, 100, "checkIsContainScopes entry", strC, "api_entry");
        if (signInAccountInfo == null) {
            e.b("AccountAuthUtil", "checkIsContainScopes signInAccountInfo is null", true);
            return false;
        }
        if (list != null && list.size() > 0) {
            String strB = com.hihonor.honorid.h.a.a(context).b();
            if (TextUtils.isEmpty(strB)) {
                e.a("AccountAuthUtil", "checkIsContainScopes : userId is null", true);
                return false;
            }
            l.a.a.c.a.a aVarA = l.a.a.c.a.a.a(context);
            if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.ICloudService")) {
                e.b("AccountAuthUtil", "has no service: com.hihonor.id.ICloudService", true);
                return false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", signInAccountInfo.a());
            bundle.putString("uid", strB);
            bundle.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
            aVarA.a(new d.c.a.a.e.a(context, bundle, "honorid.getScope", new c(context, strC, countDownLatch, list, atomicBoolean)));
            try {
                if (!countDownLatch.await(com.heytap.mcssdk.constant.a.r, TimeUnit.MILLISECONDS)) {
                    return false;
                }
            } catch (Exception e2) {
                e.b("AccountAuthUtil", "checkIsContainScopes await error \uff1a " + e2.getMessage(), true);
            }
            return atomicBoolean.get();
        }
        e.b("AccountAuthUtil", "checkIsContainScopes scopeList is null or size <= 0", true);
        return false;
    }

    public static boolean a(Context context) {
        boolean z;
        e.b("AccountAuthUtil", "isAccountAlreadyLogin", true);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse(d.c.a.b.a.a.w1), null, null, null, null);
                if (cursorQuery == null) {
                    e.a("AccountAuthUtil", "isAccountAlreadyLogin cursor is null.", true);
                }
                loop0: while (true) {
                    z = false;
                    while (cursorQuery != null) {
                        try {
                            if (!cursorQuery.moveToNext()) {
                                break loop0;
                            }
                            int columnIndex = cursorQuery.getColumnIndex("hasLogin");
                            if (columnIndex == -1) {
                                e.b("AccountAuthUtil", "isAccountAlreadyLogin index -1", true);
                            } else if (1 == cursorQuery.getInt(columnIndex)) {
                                z = true;
                            }
                        } catch (SQLException unused) {
                            e.b("AccountAuthUtil", "isAccountAlreadyLogin SQLException.", true);
                            if (cursorQuery != null) {
                            }
                            e.b("AccountAuthUtil", "account state :" + z, true);
                            return z;
                        } catch (IllegalArgumentException unused2) {
                            e.b("AccountAuthUtil", "isAccountAlreadyLogin IllegalArgumentException.", true);
                            if (cursorQuery != null) {
                            }
                            e.b("AccountAuthUtil", "account state :" + z, true);
                            return z;
                        } catch (SecurityException unused3) {
                            e.b("AccountAuthUtil", "isAccountAlreadyLogin SecurityException.", true);
                            if (cursorQuery != null) {
                            }
                            e.b("AccountAuthUtil", "account state :" + z, true);
                            return z;
                        } catch (Throwable unused4) {
                            e.b("AccountAuthUtil", "isAccountAlreadyLogin Throwable.", true);
                            if (cursorQuery != null) {
                            }
                            e.b("AccountAuthUtil", "account state :" + z, true);
                            return z;
                        }
                    }
                }
            } catch (SQLException unused5) {
                z = false;
            } catch (IllegalArgumentException unused6) {
                z = false;
            } catch (SecurityException unused7) {
                z = false;
            } catch (Throwable unused8) {
                z = false;
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static boolean a() {
        try {
            return TextUtils.equals(Build.MANUFACTURER, SystemUtils.PRODUCT_HONOR);
        } catch (Exception unused) {
            return false;
        }
    }
}
