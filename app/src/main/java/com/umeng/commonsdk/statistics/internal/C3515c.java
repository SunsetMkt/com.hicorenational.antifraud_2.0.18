package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C3411l;
import com.umeng.analytics.pro.C3414o;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.C3471b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.C3494b;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.C3531d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: NetworkHelper.java */
/* renamed from: com.umeng.commonsdk.statistics.internal.c */
/* loaded from: classes2.dex */
public class C3515c {

    /* renamed from: e */
    private static boolean f12813e = false;

    /* renamed from: f */
    private static boolean f12814f = false;

    /* renamed from: g */
    private static boolean f12815g = false;

    /* renamed from: a */
    private String f12816a = "10.0.0.172";

    /* renamed from: b */
    private int f12817b = 80;

    /* renamed from: c */
    private Context f12818c;

    /* renamed from: d */
    private InterfaceC3514b f12819d;

    public C3515c(Context context) {
        this.f12818c = context;
    }

    /* renamed from: b */
    private void m11890b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f12818c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f12818c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f12818c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f12818c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(C3494b.f12716b)) {
            return;
        }
        if (C3494b.f12716b.startsWith(AbstractC1191a.f2512K) || C3494b.f12716b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    /* renamed from: c */
    private void m11891c() {
        if (f12815g) {
            return;
        }
        ImprintHandler.getImprintService(this.f12818c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.m11530b()) {
                    FieldManager.m11529a().m11532a(C3515c.this.f12818c, str2);
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(C3515c.this.f12818c, C3470a.f12609w, C3471b.m11589a(C3515c.this.f12818c).m11590a(), null);
                }
            }
        });
        f12815g = true;
    }

    /* renamed from: d */
    private void m11892d() {
        if (f12814f) {
            return;
        }
        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f12818c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.m11529a().m11531a(C3515c.this.f12818c);
                UMWorkDispatch.sendEvent(C3515c.this.f12818c, C3470a.f12605s, C3471b.m11589a(C3515c.this.f12818c).m11590a(), null);
                ImprintHandler.getImprintService(C3515c.this.f12818c).m11834a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f12818c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.m11529a().m11532a(C3515c.this.f12818c, str2);
                UMWorkDispatch.sendEvent(C3515c.this.f12818c, C3470a.f12605s, C3471b.m11589a(C3515c.this.f12818c).m11590a(), null);
                if (FieldManager.allow(C3531d.f12957E)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(C3515c.this.f12818c, C3414o.a.f12194D, CoreProtocol.getInstance(C3515c.this.f12818c), null, 0L);
                    }
                }
                if (FieldManager.allow(C3531d.f12958F)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    C3411l.m11269a(C3515c.this.f12818c).m11289b(C3515c.this.f12818c);
                }
                ImprintHandler.getImprintService(C3515c.this.f12818c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f12814f = true;
    }

    /* renamed from: a */
    public void m11893a(InterfaceC3514b interfaceC3514b) {
        this.f12819d = interfaceC3514b;
    }

    /* renamed from: a */
    private void m11889a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f12818c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f12818c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    /* renamed from: a */
    public byte[] m11895a(byte[] bArr, boolean z, boolean z2, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            m11889a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            m11890b();
        }
        int i2 = 0;
        byte[] bArr2 = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i2 >= strArr.length) {
                break;
            }
            String str2 = strArr[i2];
            if (z2) {
                m11892d();
            } else {
                m11891c();
            }
            bArr2 = m11894a(bArr, str2 + File.separator + str);
            if (bArr2 != null) {
                InterfaceC3514b interfaceC3514b = this.f12819d;
                if (interfaceC3514b != null) {
                    interfaceC3514b.onRequestSucceed(z);
                }
            } else {
                InterfaceC3514b interfaceC3514b2 = this.f12819d;
                if (interfaceC3514b2 != null) {
                    interfaceC3514b2.onRequestFailed();
                }
                i2++;
            }
        }
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0174: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:110:0x0180, block:B:109:0x0174 */
    /* renamed from: a */
    public byte[] m11894a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z;
        try {
            try {
                if (this.f12819d != null) {
                    this.f12819d.onRequestStart();
                }
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    if (!f12813e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f12813e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", C3513a.m11877a(this.f12818c).m11882b());
                    httpsURLConnection.setRequestProperty("Content-Type", C3513a.m11877a(this.f12818c).m11880a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, DeviceConfig.getCustomAgt());
                    httpsURLConnection.setConnectTimeout(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
                    httpsURLConnection.setReadTimeout(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    z = false;
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (UnknownHostException unused) {
                    outputStream = null;
                } catch (SSLHandshakeException unused2) {
                    outputStream = null;
                } catch (Throwable unused3) {
                    outputStream = null;
                }
            } catch (UnknownHostException unused4) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (SSLHandshakeException unused5) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (Throwable unused6) {
                httpsURLConnection = null;
                outputStream = null;
            }
            try {
                outputStream.write(bArr);
                outputStream.flush();
                httpsURLConnection.connect();
                if (this.f12819d != null) {
                    this.f12819d.onRequestEnd();
                }
                int responseCode = httpsURLConnection.getResponseCode();
                String headerField = httpsURLConnection.getHeaderField("Content-Type");
                if (!TextUtils.isEmpty(headerField) && headerField.equalsIgnoreCase("application/thrift")) {
                    z = true;
                }
                boolean z2 = AnalyticsConstants.UM_DEBUG;
                if (responseCode != 200 || !z) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e2) {
                            UMCrashManager.reportCrash(this.f12818c, e2);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused7) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                }
                InputStream inputStream = httpsURLConnection.getInputStream();
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                            UMCrashManager.reportCrash(this.f12818c, e3);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused8) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return readStreamToByteArray;
                } finally {
                    HelperUtils.safeClose(inputStream);
                }
            } catch (UnknownHostException unused9) {
                UMLog.m11549aq("A_10200", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        UMCrashManager.reportCrash(this.f12818c, e4);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused10) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            } catch (SSLHandshakeException unused11) {
                UMLog.m11549aq("A_10201", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e5) {
                        UMCrashManager.reportCrash(this.f12818c, e5);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused12) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            } catch (Throwable unused13) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        UMCrashManager.reportCrash(this.f12818c, e6);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused14) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            }
        } catch (Throwable th) {
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e7) {
                    UMCrashManager.reportCrash(this.f12818c, e7);
                }
            }
            if (str != 0) {
                try {
                    str.getInputStream().close();
                } catch (IOException unused15) {
                }
                str.disconnect();
                throw th;
            }
            throw th;
        }
    }
}
