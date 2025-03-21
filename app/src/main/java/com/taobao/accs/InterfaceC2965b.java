package com.taobao.accs;

import android.content.Context;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import java.net.URL;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.b */
/* loaded from: classes.dex */
public interface InterfaceC2965b {
    /* renamed from: a */
    String mo8914a(Context context, ACCSManager.AccsRequest accsRequest);

    /* renamed from: a */
    String mo8915a(Context context, ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo);

    /* renamed from: a */
    String mo8916a(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z);

    /* renamed from: a */
    String mo8917a(Context context, String str, String str2, byte[] bArr, String str3);

    /* renamed from: a */
    String mo8918a(Context context, String str, String str2, byte[] bArr, String str3, String str4);

    /* renamed from: a */
    String mo8919a(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url);

    /* renamed from: a */
    void mo8920a(Context context);

    @Deprecated
    /* renamed from: a */
    void mo8921a(Context context, int i2);

    /* renamed from: a */
    void mo8922a(Context context, ILoginInfo iLoginInfo);

    /* renamed from: a */
    void mo8923a(Context context, String str);

    /* renamed from: a */
    void mo8924a(Context context, String str, int i2);

    /* renamed from: a */
    void mo8925a(Context context, String str, AccsAbstractDataListener accsAbstractDataListener);

    /* renamed from: a */
    void mo8926a(Context context, String str, String str2);

    /* renamed from: a */
    void mo8927a(Context context, String str, String str2, IAppReceiver iAppReceiver);

    /* renamed from: a */
    void mo8928a(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver);

    /* renamed from: a */
    void mo8929a(Context context, String str, boolean z);

    /* renamed from: a */
    void mo8930a(AccsClientConfig accsClientConfig);

    /* renamed from: a */
    void mo8931a(AccsConnectStateListener accsConnectStateListener);

    /* renamed from: a */
    void mo8932a(String str, String str2, String str3, short s, String str4, Map<Integer, String> map);

    /* renamed from: a */
    boolean mo8933a();

    /* renamed from: a */
    boolean mo8934a(int i2);

    /* renamed from: a */
    boolean mo8935a(String str);

    /* renamed from: b */
    String mo8936b(Context context, ACCSManager.AccsRequest accsRequest);

    /* renamed from: b */
    String mo8937b(Context context, String str, String str2, byte[] bArr, String str3, String str4);

    /* renamed from: b */
    String mo8938b(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url);

    /* renamed from: b */
    Map<String, Boolean> mo8939b() throws Exception;

    /* renamed from: b */
    void mo8940b(Context context, String str);

    /* renamed from: b */
    void mo8941b(AccsConnectStateListener accsConnectStateListener);

    /* renamed from: b */
    boolean mo8942b(Context context);

    /* renamed from: c */
    Map<String, Boolean> mo8943c() throws Exception;

    /* renamed from: c */
    void mo8944c(Context context);

    /* renamed from: c */
    void mo8945c(Context context, String str);

    /* renamed from: d */
    void mo8946d(Context context);

    /* renamed from: d */
    void mo8947d(Context context, String str);

    /* renamed from: e */
    void mo8948e(Context context);

    /* renamed from: e */
    void mo8949e(Context context, String str);
}
