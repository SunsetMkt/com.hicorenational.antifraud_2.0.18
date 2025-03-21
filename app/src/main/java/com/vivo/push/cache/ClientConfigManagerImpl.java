package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.model.C3925a;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.ContextDelegate;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class ClientConfigManagerImpl implements InterfaceC3860d {
    private static final String TAG = "ClientConfigManager";
    private static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
    private C3857a mAppConfigSettings;
    private Context mContext;
    private C3861e mPushConfigSettings;

    private ClientConfigManagerImpl(Context context) {
        this.mContext = ContextDelegate.getContext(context);
        this.mAppConfigSettings = new C3857a(this.mContext);
        this.mPushConfigSettings = new C3861e(this.mContext);
    }

    public static synchronized ClientConfigManagerImpl getInstance(Context context) {
        ClientConfigManagerImpl clientConfigManagerImpl;
        synchronized (ClientConfigManagerImpl.class) {
            if (sClientConfigManagerImpl == null) {
                sClientConfigManagerImpl = new ClientConfigManagerImpl(context);
            }
            clientConfigManagerImpl = sClientConfigManagerImpl;
        }
        return clientConfigManagerImpl;
    }

    private void prepareAppConfig() {
        C3857a c3857a = this.mAppConfigSettings;
        if (c3857a == null) {
            this.mAppConfigSettings = new C3857a(this.mContext);
        } else {
            c3857a.m12906c();
        }
    }

    private C3861e preparePushConfigSettings() {
        C3861e c3861e = this.mPushConfigSettings;
        if (c3861e == null) {
            this.mPushConfigSettings = new C3861e(this.mContext);
        } else {
            c3861e.m12906c();
        }
        return this.mPushConfigSettings;
    }

    public void clearPush() {
        this.mAppConfigSettings.m12907d();
    }

    public Set<String> getBlackEventList() {
        return null;
    }

    public String getSuitTag() {
        return preparePushConfigSettings().m12910c("CSPT");
    }

    public String getValueByKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mPushConfigSettings.m12906c();
        return this.mPushConfigSettings.m12910c(str);
    }

    public Set<Long> getWhiteLogList() {
        HashSet hashSet = new HashSet();
        String valueByKey = getValueByKey("WLL");
        if (!TextUtils.isEmpty(valueByKey)) {
            for (String str : valueByKey.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                try {
                    hashSet.add(Long.valueOf(Long.parseLong(str)));
                } catch (Exception unused) {
                }
            }
        }
        C4010u.m13309d(TAG, " initWhiteLogList ".concat(String.valueOf(hashSet)));
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isCancleBroadcastReceiver() {
        /*
            r3 = this;
            com.vivo.push.cache.e r0 = r3.preparePushConfigSettings()
            java.lang.String r1 = "PSM"
            java.lang.String r0 = r0.m12910c(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L1a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L16
            goto L1b
        L16:
            r0 = move-exception
            r0.printStackTrace()
        L1a:
            r0 = 0
        L1b:
            r0 = r0 & 4
            if (r0 == 0) goto L21
            r0 = 1
            return r0
        L21:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.cache.ClientConfigManagerImpl.isCancleBroadcastReceiver():boolean");
    }

    public boolean isDebug() {
        this.mAppConfigSettings.m12906c();
        return C3857a.m12895a(this.mAppConfigSettings.m12898b());
    }

    public boolean isEnablePush() {
        prepareAppConfig();
        C3925a m12900c = this.mAppConfigSettings.m12900c(this.mContext.getPackageName());
        if (m12900c != null) {
            return "1".equals(m12900c.m13059b());
        }
        return true;
    }

    @Override // com.vivo.push.cache.InterfaceC3860d
    public boolean isInBlackList(long j2) {
        String m12910c = preparePushConfigSettings().m12910c("BL");
        if (!TextUtils.isEmpty(m12910c)) {
            for (String str : m12910c.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                try {
                    if (!TextUtils.isEmpty(str) && Long.parseLong(str) == j2) {
                        return true;
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean isDebug(int i2) {
        return C3857a.m12895a(i2);
    }
}
