package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.p232b.C3834f;
import com.vivo.push.p234d.C3869d;
import com.vivo.push.p234d.InterfaceC3863a;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PushClient extends C3824a implements InterfaceC3863a {
    public static final String DEFAULT_REQUEST_ID = "1";
    private static volatile PushClient sPushClient;
    private Context mContext;
    private boolean mIsInitSdk;
    private boolean mIsSdkInited = true;
    private InterfaceC3863a mSyncProfileInfo;

    private PushClient(Context context) {
        this.mContext = ContextDelegate.getContext(context);
        C3932a.m13069a().m13070a(context);
        C3924m.m13016a().m13030a(context);
        this.mSyncProfileInfo = new C3869d();
    }

    private boolean checkAgreePrivacyStatementAndInitSdk() {
        if (!C3932a.m13069a().m13074e().mo13130l().isAgreePrivacyStatement()) {
            return false;
        }
        inidSdk(this.mContext);
        return true;
    }

    private void checkParam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("PushManager String param should not be ".concat(String.valueOf(str)));
        }
    }

    private String getAppId(String str) {
        return !TextUtils.isEmpty(str) ? str : C3932a.m13069a().m13074e().mo13112a();
    }

    private String getAppKey(String str) {
        return !TextUtils.isEmpty(str) ? str : C3932a.m13069a().m13074e().mo13118c();
    }

    public static synchronized PushClient getInstance(Context context) {
        PushClient pushClient;
        synchronized (PushClient.class) {
            if (sPushClient == null) {
                sPushClient = new PushClient(context.getApplicationContext());
            }
            pushClient = sPushClient;
        }
        return pushClient;
    }

    private void inidSdk(Context context) {
        synchronized (this) {
            if (!this.mIsInitSdk) {
                C3924m.m13016a().m13030a(context);
                this.mIsInitSdk = true;
            }
        }
    }

    private boolean isSdkInited() {
        return this.mIsSdkInited;
    }

    @Override // com.vivo.push.p234d.InterfaceC3863a
    public void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else if (!isSdkInited()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8011);
            }
        } else {
            InterfaceC3863a interfaceC3863a = this.mSyncProfileInfo;
            if (interfaceC3863a != null) {
                interfaceC3863a.addProfileId(str, iPushRequestCallback);
            }
        }
    }

    public void bindAlias(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (isSdkInited()) {
            checkParam(str);
            C3924m.m13016a().m13036a(str, getAppId(""), getAppKey(""), iPushActionListener);
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
    }

    public void checkManifest() throws VivoPushException {
        if (checkAgreePrivacyStatementAndInitSdk() && isSdkInited()) {
            C3924m.m13016a().m13039b();
        }
    }

    public void delTopic(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (isSdkInited()) {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            C3924m.m13016a().m13042b(arrayList, getAppId(""), getAppKey(""), iPushActionListener);
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
    }

    @Override // com.vivo.push.p234d.InterfaceC3863a
    public void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else if (!isSdkInited()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8011);
            }
        } else {
            InterfaceC3863a interfaceC3863a = this.mSyncProfileInfo;
            if (interfaceC3863a != null) {
                interfaceC3863a.deleteAllProfileId(iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.p234d.InterfaceC3863a
    public void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else if (!isSdkInited()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8011);
            }
        } else {
            InterfaceC3863a interfaceC3863a = this.mSyncProfileInfo;
            if (interfaceC3863a != null) {
                interfaceC3863a.deleteProfileId(str, iPushRequestCallback);
            }
        }
    }

    public void deleteRegid(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (isSdkInited()) {
            super.deleteRegid(iPushActionListener, getAppId(""), getAppKey(""));
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
    }

    public String getAlias() {
        if (checkAgreePrivacyStatementAndInitSdk() && isSdkInited()) {
            return C3924m.m13016a().m13050i();
        }
        return null;
    }

    @Override // com.vivo.push.C3824a
    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushQueryActionListener != null) {
                iPushQueryActionListener.onFail(104);
            }
        } else if (isSdkInited()) {
            super.getRegId(iPushQueryActionListener);
        } else if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onFail(8011);
        }
    }

    public List<String> getTopics() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return new ArrayList();
        }
        if (!isSdkInited()) {
            return new ArrayList();
        }
        C3924m.m13016a();
        return C3924m.m13026c();
    }

    public String getVersion() {
        if (checkAgreePrivacyStatementAndInitSdk() && isSdkInited()) {
            return "3.4.0.0";
        }
        return null;
    }

    public void initialize(PushConfig pushConfig) throws VivoPushException {
        if (pushConfig == null) {
            throw new VivoPushException("initialize error config is null");
        }
        C3932a.m13069a().m13074e().mo13114a(pushConfig);
        initialize();
    }

    public boolean isSupport() {
        if (checkAgreePrivacyStatementAndInitSdk() && isSdkInited()) {
            return C3924m.m13016a().m13045d();
        }
        return false;
    }

    public int isSupportNewControlStrategies() {
        if (checkAgreePrivacyStatementAndInitSdk() && isSdkInited()) {
            return C3932a.m13069a().m13076g().m12891a();
        }
        return -1;
    }

    public int isSupportSyncProfileInfo() {
        if (checkAgreePrivacyStatementAndInitSdk() && isSdkInited()) {
            return C3932a.m13069a().m13076g().m12892b();
        }
        return -1;
    }

    @Override // com.vivo.push.p234d.InterfaceC3863a
    public void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else if (!isSdkInited()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8011);
            }
        } else {
            InterfaceC3863a interfaceC3863a = this.mSyncProfileInfo;
            if (interfaceC3863a != null) {
                interfaceC3863a.queryProfileIds(iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.C3824a
    public void querySubscribeState(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
        if (!isSdkInited() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
        super.querySubscribeState(iPushActionListener);
    }

    public void setSystemModel(boolean z) {
        if (checkAgreePrivacyStatementAndInitSdk() && isSdkInited()) {
            C3924m.m13016a().m13038a(z);
        }
    }

    public void setTopic(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (isSdkInited()) {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            C3924m.m13016a().m13037a(arrayList, getAppId(""), getAppKey(""), iPushActionListener);
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (isSdkInited()) {
            C3924m.m13016a().m13043c(iPushActionListener, getAppId(""), getAppKey(""));
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (isSdkInited()) {
            C3924m.m13016a().m13031a(iPushActionListener, getAppId(""), getAppKey(""));
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (isSdkInited()) {
            checkParam(str);
            C3924m.m13016a().m13041b(str, getAppId(""), getAppKey(""), iPushActionListener);
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
    }

    private void initialize() throws VivoPushException {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            checkManifest();
            C3924m m13016a = C3924m.m13016a();
            C3834f c3834f = new C3834f();
            C3932a.m13069a();
            c3834f.m12845d();
            m13016a.m13032a(c3834f);
            if (this.mIsSdkInited) {
                return;
            }
            this.mIsSdkInited = true;
        }
    }
}
