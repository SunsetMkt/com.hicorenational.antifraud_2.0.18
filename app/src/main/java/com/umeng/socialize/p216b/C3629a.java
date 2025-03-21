package com.umeng.socialize.p216b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.handler.UMMoreHandler;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.net.dplus.cache1.DplusCacheApi;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: SocialRouter.java */
/* renamed from: com.umeng.socialize.b.a */
/* loaded from: classes2.dex */
public final class C3629a {

    /* renamed from: b */
    private static final String f13512b = "umeng_share_platform";

    /* renamed from: c */
    private static final String f13513c = "share_action";

    /* renamed from: a */
    private SHARE_MEDIA f13514a;

    /* renamed from: d */
    private final Map<SHARE_MEDIA, UMSSOHandler> f13515d = new HashMap();

    /* renamed from: e */
    private final List<Pair<SHARE_MEDIA, String>> f13516e = new ArrayList();

    /* renamed from: f */
    private final a f13517f;

    /* renamed from: g */
    private Context f13518g;

    /* renamed from: h */
    private final SparseArray<UMAuthListener> f13519h;

    /* renamed from: i */
    private final SparseArray<UMShareListener> f13520i;

    /* renamed from: j */
    private final SparseArray<UMAuthListener> f13521j;

    public C3629a(Context context) {
        List<Pair<SHARE_MEDIA, String>> list = this.f13516e;
        list.add(Pair.create(SHARE_MEDIA.SINA, "com.umeng.socialize.handler.SinaSsoHandler"));
        list.add(Pair.create(SHARE_MEDIA.QQ, "com.umeng.socialize.handler.UMQQSsoHandler"));
        list.add(Pair.create(SHARE_MEDIA.QZONE, "com.umeng.socialize.handler.QZoneSsoHandler"));
        list.add(Pair.create(SHARE_MEDIA.WEIXIN, "com.umeng.socialize.handler.UMWXHandler"));
        list.add(Pair.create(SHARE_MEDIA.WEIXIN_CIRCLE, ""));
        list.add(Pair.create(SHARE_MEDIA.WEIXIN_FAVORITE, ""));
        list.add(Pair.create(SHARE_MEDIA.PINTEREST, "com.umeng.socialize.handler.UMPinterestHandler"));
        list.add(Pair.create(SHARE_MEDIA.WXWORK, "com.umeng.socialize.handler.UMWXWorkHandler"));
        list.add(Pair.create(SHARE_MEDIA.YIXIN, "com.umeng.socialize.handler.UMYXHandler"));
        list.add(Pair.create(SHARE_MEDIA.YIXIN_CIRCLE, ""));
        list.add(Pair.create(SHARE_MEDIA.EMAIL, "com.umeng.socialize.handler.EmailHandler"));
        list.add(Pair.create(SHARE_MEDIA.EVERNOTE, "com.umeng.socialize.handler.UMEvernoteHandler"));
        list.add(Pair.create(SHARE_MEDIA.FACEBOOK, "com.umeng.socialize.handler.UMFacebookHandler"));
        list.add(Pair.create(SHARE_MEDIA.FACEBOOK_MESSAGER, ""));
        list.add(Pair.create(SHARE_MEDIA.FLICKR, "com.umeng.socialize.handler.UMFlickrHandler"));
        list.add(Pair.create(SHARE_MEDIA.FOURSQUARE, "com.umeng.socialize.handler.UMFourSquareHandler"));
        list.add(Pair.create(SHARE_MEDIA.INSTAGRAM, "com.umeng.socialize.handler.UMInstagramHandler"));
        list.add(Pair.create(SHARE_MEDIA.KAKAO, "com.umeng.socialize.handler.UMKakaoHandler"));
        list.add(Pair.create(SHARE_MEDIA.LINE, "com.umeng.socialize.handler.UMLineHandler"));
        list.add(Pair.create(SHARE_MEDIA.LINKEDIN, "com.umeng.socialize.handler.UMLinkedInHandler"));
        list.add(Pair.create(SHARE_MEDIA.POCKET, "com.umeng.socialize.handler.UMPocketHandler"));
        list.add(Pair.create(SHARE_MEDIA.WHATSAPP, "com.umeng.socialize.handler.UMWhatsAppHandler"));
        list.add(Pair.create(SHARE_MEDIA.YNOTE, "com.umeng.socialize.handler.UMYNoteHandler"));
        list.add(Pair.create(SHARE_MEDIA.SMS, "com.umeng.socialize.handler.SmsHandler"));
        list.add(Pair.create(SHARE_MEDIA.DOUBAN, "com.umeng.socialize.handler.DoubanHandler"));
        list.add(Pair.create(SHARE_MEDIA.TUMBLR, "com.umeng.socialize.handler.UMTumblrHandler"));
        list.add(Pair.create(SHARE_MEDIA.TWITTER, "com.umeng.socialize.handler.TwitterHandler"));
        list.add(Pair.create(SHARE_MEDIA.ALIPAY, "com.umeng.socialize.handler.AlipayHandler"));
        list.add(Pair.create(SHARE_MEDIA.MORE, "com.umeng.socialize.handler.UMMoreHandler"));
        list.add(Pair.create(SHARE_MEDIA.DINGTALK, "com.umeng.socialize.handler.UMDingSSoHandler"));
        list.add(Pair.create(SHARE_MEDIA.VKONTAKTE, "com.umeng.socialize.handler.UMVKHandler"));
        list.add(Pair.create(SHARE_MEDIA.DROPBOX, "com.umeng.socialize.handler.UMDropBoxHandler"));
        list.add(Pair.create(SHARE_MEDIA.BYTEDANCE, "com.umeng.socialize.handler.UMDYHandler"));
        list.add(Pair.create(SHARE_MEDIA.BYTEDANCE_PUBLISH, ""));
        list.add(Pair.create(SHARE_MEDIA.BYTEDANCE_FRIENDS, ""));
        list.add(Pair.create(SHARE_MEDIA.HONOR, "com.umeng.socialize.handler.UMHonorHandler"));
        this.f13517f = new a(this.f13515d);
        this.f13519h = new SparseArray<>();
        this.f13520i = new SparseArray<>();
        this.f13521j = new SparseArray<>();
        this.f13518g = context;
        m12581b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized UMShareListener m12588e(int i2) {
        UMShareListener uMShareListener;
        uMShareListener = this.f13520i.get(i2, null);
        if (uMShareListener != null) {
            this.f13520i.remove(i2);
        }
        return uMShareListener;
    }

    /* renamed from: d */
    public boolean m12604d(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f13517f.m12607a(activity, share_media)) {
            return false;
        }
        this.f13515d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f13515d.get(share_media).isAuthorize();
    }

    /* renamed from: b */
    private void m12583b(Context context) {
        String appkey = SocializeUtils.getAppkey(context);
        if (TextUtils.isEmpty(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_NO_APPKEY));
        }
        if (SocializeNetUtils.isConSpeCharacters(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
        if (SocializeNetUtils.isSelfAppkey(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
    }

    /* renamed from: c */
    public String m12602c(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f13517f.m12607a(activity, share_media)) {
            return "";
        }
        this.f13515d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f13515d.get(share_media).getSDKVersion();
    }

    /* renamed from: a */
    public void m12596a(Context context) {
        if (context != null) {
            this.f13518g = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    private UMSSOHandler m12572a(String str) {
        try {
            return (UMSSOHandler) Class.forName(str).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public synchronized UMAuthListener m12587d(int i2) {
        UMAuthListener uMAuthListener;
        uMAuthListener = this.f13521j.get(i2, null);
        if (uMAuthListener != null) {
            this.f13521j.remove(i2);
        }
        return uMAuthListener;
    }

    /* renamed from: a */
    public UMSSOHandler m12589a(SHARE_MEDIA share_media) {
        UMSSOHandler uMSSOHandler = this.f13515d.get(share_media);
        if (uMSSOHandler != null) {
            uMSSOHandler.onCreate(this.f13518g, PlatformConfig.getPlatform(share_media));
        }
        return uMSSOHandler;
    }

    /* renamed from: c */
    public void m12603c(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f13517f.m12607a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f13515d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.authstart(ContextUtil.getContext(), share_media, uMSSOHandler.getSDKVersion(), uMSSOHandler.isInstall(), valueOf);
            }
            int ordinal = share_media.ordinal();
            m12575a(ordinal, uMAuthListener);
            UMAuthListener m12569a = m12569a(ordinal, valueOf, uMSSOHandler.isInstall());
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uMAuthListener.onStart(share_media);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            uMSSOHandler.authorize(m12569a);
            this.f13514a = share_media;
        }
    }

    /* compiled from: SocialRouter.java */
    /* renamed from: com.umeng.socialize.b.a$a */
    private static class a {

        /* renamed from: a */
        private final Map<SHARE_MEDIA, UMSSOHandler> f13580a;

        public a(Map<SHARE_MEDIA, UMSSOHandler> map) {
            this.f13580a = map;
        }

        /* renamed from: a */
        private boolean m12605a(Context context) {
            return context != null;
        }

        /* renamed from: a */
        public boolean m12607a(Context context, SHARE_MEDIA share_media) {
            if (CommonUtil.isSilentMode(context) || !m12605a(context) || !m12606a(share_media)) {
                return false;
            }
            if (this.f13580a.get(share_media).isSupportAuth()) {
                return true;
            }
            SLog.m12716E(share_media.toString() + UmengText.AUTH.NOT_SUPPORT_PLATFROM);
            return false;
        }

        /* renamed from: a */
        public boolean m12608a(ShareAction shareAction, Activity activity) {
            SHARE_MEDIA platform;
            if (CommonUtil.isSilentMode(activity) || (platform = shareAction.getPlatform()) == null) {
                return false;
            }
            if ((platform == SHARE_MEDIA.SINA || platform == SHARE_MEDIA.QQ) && !PlatformConfig.configs.get(platform).isConfigured()) {
                SLog.m12716E(UmengText.CHECK.noKey(platform));
                return false;
            }
            return m12606a(platform);
        }

        /* renamed from: a */
        private boolean m12606a(SHARE_MEDIA share_media) {
            if (this.f13580a.get(share_media) != null) {
                return true;
            }
            SLog.mutlE(UmengText.CHECK.noJar(share_media), UrlUtil.ALL_NO_JAR);
            return false;
        }
    }

    /* renamed from: a */
    public void m12591a(int i2, int i3, Intent intent) {
        UMSSOHandler m12571a = m12571a(i2);
        if (m12571a != null) {
            m12571a.onActivityResult(i2, i3, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m12581b() {
        UMSSOHandler m12572a;
        for (Pair<SHARE_MEDIA, String> pair : this.f13516e) {
            Object obj = pair.first;
            if (obj == SHARE_MEDIA.WEIXIN_CIRCLE) {
                m12572a = this.f13515d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.WEIXIN_FAVORITE) {
                m12572a = this.f13515d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.FACEBOOK_MESSAGER) {
                m12572a = this.f13515d.get(SHARE_MEDIA.FACEBOOK);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_PUBLISH) {
                m12572a = this.f13515d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_FRIENDS) {
                m12572a = this.f13515d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.YIXIN_CIRCLE) {
                m12572a = this.f13515d.get(SHARE_MEDIA.YIXIN);
            } else if (obj == SHARE_MEDIA.MORE) {
                m12572a = new UMMoreHandler();
            } else {
                m12572a = m12572a((String) pair.second);
            }
            this.f13515d.put(pair.first, m12572a);
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m12592a(Activity activity, int i2, UMAuthListener uMAuthListener) {
        UMSSOHandler m12571a = m12571a(i2);
        if (m12571a != null) {
            if (i2 == 10103 || i2 == 11101) {
                m12571a.onCreate(activity, PlatformConfig.getPlatform(m12580b(i2)));
                m12578a(SHARE_MEDIA.QQ, uMAuthListener, m12571a, String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* renamed from: a */
    private UMSSOHandler m12571a(int i2) {
        int i3 = 10103;
        if (i2 != 10103 && i2 != 11101) {
            i3 = i2;
        }
        if (i2 == 64207 || i2 == 64206 || i2 == 64208) {
            i3 = HandlerRequestCode.FACEBOOK_REQUEST_AUTH_CODE;
        }
        if (i2 == 32973 || i2 == 765) {
            i3 = 10001;
        }
        if (i2 == 5650) {
            i3 = HandlerRequestCode.SINA_REQUEST_CODE;
        }
        for (UMSSOHandler uMSSOHandler : this.f13515d.values()) {
            if (uMSSOHandler != null && i3 == uMSSOHandler.getRequestCode()) {
                return uMSSOHandler;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m12595a(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (this.f13517f.m12607a(activity, share_media)) {
            if (uMAuthListener == null) {
                uMAuthListener = new UMAuthListener() { // from class: com.umeng.socialize.b.a.1
                    @Override // com.umeng.socialize.UMAuthListener
                    public void onCancel(SHARE_MEDIA share_media2, int i2) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onComplete(SHARE_MEDIA share_media2, int i2, Map<String, String> map) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onError(SHARE_MEDIA share_media2, int i2, Throwable th) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onStart(SHARE_MEDIA share_media2) {
                    }
                };
            }
            this.f13515d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            this.f13515d.get(share_media).deleteAuth(uMAuthListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized UMAuthListener m12584c(int i2) {
        UMAuthListener uMAuthListener;
        this.f13514a = null;
        uMAuthListener = this.f13519h.get(i2, null);
        if (uMAuthListener != null) {
            this.f13519h.remove(i2);
        }
        return uMAuthListener;
    }

    /* renamed from: a */
    public boolean m12599a(Activity activity, SHARE_MEDIA share_media) {
        this.f13515d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f13515d.get(share_media).isInstall();
    }

    /* renamed from: c */
    private synchronized void m12586c() {
        this.f13519h.clear();
        this.f13520i.clear();
        this.f13521j.clear();
    }

    /* renamed from: a */
    private UMAuthListener m12569a(final int i2, final String str, final boolean z) {
        return new UMAuthListener() { // from class: com.umeng.socialize.b.a.5
            @Override // com.umeng.socialize.UMAuthListener
            public void onCancel(final SHARE_MEDIA share_media, final int i3) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMAuthListener m12584c = C3629a.this.m12584c(i2);
                            if (m12584c != null) {
                                m12584c.onCancel(share_media, i3);
                            }
                            if (ContextUtil.getContext() != null) {
                                SocialAnalytics.authendt(ContextUtil.getContext(), share_media, CommonNetImpl.CANCEL, z, "", str, null);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onComplete(final SHARE_MEDIA share_media, final int i3, final Map<String, String> map) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMAuthListener m12584c = C3629a.this.m12584c(i2);
                            if (m12584c != null) {
                                m12584c.onComplete(share_media, i3, map);
                            }
                            if (ContextUtil.getContext() != null) {
                                SocialAnalytics.authendt(ContextUtil.getContext(), share_media, "success", z, "", str, C3629a.this.m12574a(share_media, (Map<String, String>) map));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onError(final SHARE_MEDIA share_media, final int i3, final Throwable th) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMAuthListener m12584c = C3629a.this.m12584c(i2);
                            if (m12584c != null) {
                                m12584c.onError(share_media, i3, th);
                            }
                            if (th != null) {
                                SLog.m12716E(th.getMessage());
                                SLog.runtimePrint(th.getMessage());
                            } else {
                                SLog.m12716E(AbstractC1191a.f2571h);
                                SLog.runtimePrint(AbstractC1191a.f2571h);
                            }
                            if (ContextUtil.getContext() == null || th == null) {
                                return;
                            }
                            SocialAnalytics.authendt(ContextUtil.getContext(), share_media, "fail", z, th.getMessage(), str, null);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onStart(final SHARE_MEDIA share_media) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMAuthListener m12584c = C3629a.this.m12584c(i2);
                            if (m12584c != null) {
                                m12584c.onStart(share_media);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m12574a(SHARE_MEDIA share_media, Map<String, String> map) {
        String str;
        String str2;
        String str3 = "";
        if (PlatformConfig.getPlatform(share_media) != null) {
            str3 = PlatformConfig.getPlatform(share_media).getAppid();
            str2 = PlatformConfig.getPlatform(share_media).getAppSecret();
            str = PlatformConfig.getPlatform(share_media).getClick_key();
        } else {
            str = "";
            str2 = str;
        }
        map.put(CommonNetImpl.AID, str3);
        map.put(CommonNetImpl.f13712AS, str2);
        map.put("at", str);
        return map;
    }

    /* renamed from: b */
    private SHARE_MEDIA m12580b(int i2) {
        if (i2 == 10103 || i2 == 11101) {
            return SHARE_MEDIA.QQ;
        }
        if (i2 != 32973 && i2 != 765) {
            return SHARE_MEDIA.QQ;
        }
        return SHARE_MEDIA.SINA;
    }

    /* renamed from: b */
    public void m12600b(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f13517f.m12607a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f13515d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.getInfostart(ContextUtil.getContext(), share_media, valueOf);
            }
            final int ordinal = share_media.ordinal();
            m12582b(ordinal, uMAuthListener);
            UMAuthListener uMAuthListener2 = new UMAuthListener() { // from class: com.umeng.socialize.b.a.2
                @Override // com.umeng.socialize.UMAuthListener
                public void onCancel(final SHARE_MEDIA share_media2, final int i2) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMAuthListener m12587d = C3629a.this.m12587d(ordinal);
                                if (m12587d != null) {
                                    m12587d.onCancel(share_media2, i2);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, CommonNetImpl.CANCEL, "", valueOf, null);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onComplete(final SHARE_MEDIA share_media2, final int i2, final Map<String, String> map) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMAuthListener m12587d = C3629a.this.m12587d(ordinal);
                                if (m12587d != null) {
                                    m12587d.onComplete(share_media2, i2, map);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "success", "", valueOf, map);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onError(final SHARE_MEDIA share_media2, final int i2, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMAuthListener m12587d = C3629a.this.m12587d(ordinal);
                                if (m12587d != null) {
                                    m12587d.onError(share_media2, i2, th);
                                }
                                if (th != null) {
                                    SLog.m12716E(th.getMessage());
                                    SLog.m12716E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                } else {
                                    SLog.m12716E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                }
                                if (ContextUtil.getContext() == null || th == null) {
                                    return;
                                }
                                SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "fail", th.getMessage(), valueOf, null);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onStart(final SHARE_MEDIA share_media2) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMAuthListener m12587d = C3629a.this.m12587d(ordinal);
                                if (m12587d != null) {
                                    m12587d.onStart(share_media2);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            };
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uMAuthListener.onStart(share_media);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            uMSSOHandler.getPlatformInfo(uMAuthListener2);
        }
    }

    /* renamed from: a */
    private void m12577a(ShareAction shareAction) {
        ShareContent shareContent = shareAction.getShareContent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UmengText.SHARE.INFO);
        arrayList.add(UmengText.SHARE.SHAREPLAT + shareAction.getPlatform().toString());
        arrayList.add(UmengText.SHARE.SHARESTYLE + shareAction.getShareContent().getShareType());
        arrayList.add(UmengText.SHARE.SHARETEXT + shareContent.mText);
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject != null) {
            if (uMediaObject instanceof UMImage) {
                UMImage uMImage = (UMImage) uMediaObject;
                if (uMImage.isUrlMedia()) {
                    arrayList.add(UmengText.SHARE.URLIMAGE + uMImage.asUrlImage());
                } else {
                    byte[] asBinImage = uMImage.asBinImage();
                    StringBuilder sb = new StringBuilder();
                    sb.append(UmengText.SHARE.LOCALIMAGE);
                    sb.append(asBinImage == null ? 0 : asBinImage.length);
                    arrayList.add(sb.toString());
                }
                if (uMImage.getThumbImage() != null) {
                    UMImage thumbImage = uMImage.getThumbImage();
                    if (thumbImage.isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + thumbImage.asUrlImage());
                    } else {
                        byte[] asBinImage2 = thumbImage.asBinImage();
                        if (asBinImage2 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage2.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject2 = shareContent.mMedia;
            if (uMediaObject2 instanceof UMVideo) {
                UMVideo uMVideo = (UMVideo) uMediaObject2;
                arrayList.add(UmengText.SHARE.VIDEOURL + uMVideo.toUrl());
                arrayList.add(UmengText.SHARE.VIDEOTITLE + uMVideo.getTitle());
                arrayList.add(UmengText.SHARE.VIDEODES + uMVideo.getDescription());
                if (uMVideo.getThumbImage() != null) {
                    if (uMVideo.getThumbImage().isUrlMedia()) {
                        if (uMVideo.getThumbImage().asUrlImage() != null) {
                            arrayList.add(UmengText.SHARE.URLTHUMB + uMVideo.getThumbImage().asUrlImage());
                        }
                    } else {
                        byte[] asBinImage3 = uMVideo.getThumbImage().asBinImage();
                        if (asBinImage3 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage3.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject3 = shareContent.mMedia;
            if (uMediaObject3 instanceof UMusic) {
                UMusic uMusic = (UMusic) uMediaObject3;
                arrayList.add(UmengText.SHARE.MUSICURL + uMusic.toUrl() + "   " + uMusic.getmTargetUrl());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(UmengText.SHARE.MUSICTITLE);
                sb2.append(uMusic.getTitle());
                arrayList.add(sb2.toString());
                arrayList.add(UmengText.SHARE.MUSICDES + uMusic.getDescription());
                if (uMusic.getThumbImage() != null) {
                    if (uMusic.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMusic.getThumbImage().asUrlImage());
                    } else {
                        byte[] asBinImage4 = uMusic.getThumbImage().asBinImage();
                        if (asBinImage4 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage4.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject4 = shareContent.mMedia;
            if (uMediaObject4 instanceof UMWeb) {
                UMWeb uMWeb = (UMWeb) uMediaObject4;
                arrayList.add(UmengText.SHARE.URLURL + uMWeb.toUrl());
                arrayList.add(UmengText.SHARE.URLTITLE + uMWeb.getTitle());
                arrayList.add(UmengText.SHARE.URLDES + uMWeb.getDescription());
                if (uMWeb.getThumbImage() != null) {
                    if (uMWeb.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMWeb.getThumbImage().asUrlImage());
                    } else {
                        byte[] asBinImage5 = uMWeb.getThumbImage().asBinImage();
                        if (asBinImage5 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage5.length);
                        }
                    }
                }
            }
        }
        if (shareContent.file != null) {
            arrayList.add(UmengText.SHARE.FILENAME + shareContent.file.getName());
        }
        SLog.mutlI((String[]) arrayList.toArray(new String[1]));
    }

    /* renamed from: b */
    public boolean m12601b(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f13517f.m12607a(activity, share_media)) {
            return false;
        }
        this.f13515d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f13515d.get(share_media).isSupport();
    }

    /* renamed from: b */
    private synchronized void m12582b(int i2, UMAuthListener uMAuthListener) {
        this.f13521j.put(i2, uMAuthListener);
    }

    /* renamed from: a */
    public void m12594a(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        m12583b(activity);
        WeakReference weakReference = new WeakReference(activity);
        if (this.f13517f.m12608a(shareAction, activity)) {
            if (SLog.isDebug()) {
                SLog.m12716E(UmengText.SHARE.VERSION + "7.3.2");
                m12577a(shareAction);
            }
            SHARE_MEDIA platform = shareAction.getPlatform();
            UMSSOHandler uMSSOHandler = this.f13515d.get(platform);
            uMSSOHandler.onCreate((Context) weakReference.get(), PlatformConfig.getPlatform(platform));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                DplusApi.uploadShare(ContextUtil.getContext(), shareAction.getShareContent(), uMSSOHandler.isInstall(), platform, valueOf, shareAction.getShareContent().mMedia instanceof UMImage ? ((UMImage) shareAction.getShareContent().mMedia).isHasWaterMark() : false);
            }
            final int ordinal = platform.ordinal();
            m12576a(ordinal, uMShareListener);
            final UMShareListener uMShareListener2 = new UMShareListener() { // from class: com.umeng.socialize.b.a.6
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, CommonNetImpl.CANCEL, "", valueOf);
                                }
                                UMShareListener m12588e = C3629a.this.m12588e(ordinal);
                                if (m12588e != null) {
                                    m12588e.onCancel(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(final SHARE_MEDIA share_media, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null && th != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "fail", th.getMessage(), valueOf);
                                }
                                UMShareListener m12588e = C3629a.this.m12588e(ordinal);
                                if (m12588e != null) {
                                    m12588e.onError(share_media, th);
                                }
                                if (th != null) {
                                    SLog.m12716E(th.getMessage());
                                    SLog.m12716E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                    return;
                                }
                                SLog.m12716E(AbstractC1191a.f2571h);
                                SLog.m12716E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                SLog.runtimePrint(AbstractC1191a.f2571h);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onResult(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "success", "", valueOf);
                                }
                                UMShareListener m12588e = C3629a.this.m12588e(ordinal);
                                if (m12588e != null) {
                                    m12588e.onResult(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onStart(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMShareListener m12588e = C3629a.this.m12588e(ordinal);
                                if (m12588e != null) {
                                    m12588e.onStart(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            };
            if (!shareAction.getUrlValid()) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            uMShareListener2.onError(shareAction.getPlatform(), new Throwable(UmengErrorCode.ShareFailed.getMessage() + UmengText.SHARE.WEB_HTTP));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (uMShareListener != null) {
                            uMShareListener.onStart(shareAction.getPlatform());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            try {
                uMSSOHandler.share(shareAction.getShareContent(), uMShareListener2);
            } catch (Throwable th) {
                SLog.error(th);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m12575a(int i2, UMAuthListener uMAuthListener) {
        this.f13519h.put(i2, uMAuthListener);
    }

    /* renamed from: a */
    private synchronized void m12576a(int i2, UMShareListener uMShareListener) {
        this.f13520i.put(i2, uMShareListener);
    }

    /* renamed from: a */
    private void m12578a(SHARE_MEDIA share_media, UMAuthListener uMAuthListener, UMSSOHandler uMSSOHandler, String str) {
        if (uMSSOHandler.isHasAuthListener()) {
            return;
        }
        int ordinal = share_media.ordinal();
        m12575a(ordinal, uMAuthListener);
        uMSSOHandler.setAuthListener(m12569a(ordinal, str, uMSSOHandler.isInstall()));
    }

    /* renamed from: a */
    public void m12590a() {
        m12586c();
        DplusCacheApi.getInstance().cleanCache(ContextUtil.getContext());
        UMSSOHandler uMSSOHandler = this.f13515d.get(SHARE_MEDIA.SINA);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        UMSSOHandler uMSSOHandler2 = this.f13515d.get(SHARE_MEDIA.MORE);
        if (uMSSOHandler2 != null) {
            uMSSOHandler2.release();
        }
        UMSSOHandler uMSSOHandler3 = this.f13515d.get(SHARE_MEDIA.DINGTALK);
        if (uMSSOHandler3 != null) {
            uMSSOHandler3.release();
        }
        UMSSOHandler uMSSOHandler4 = this.f13515d.get(SHARE_MEDIA.WEIXIN);
        if (uMSSOHandler4 != null) {
            uMSSOHandler4.release();
        }
        UMSSOHandler uMSSOHandler5 = this.f13515d.get(SHARE_MEDIA.QQ);
        if (uMSSOHandler5 != null) {
            uMSSOHandler5.release();
        }
        this.f13514a = null;
        DplusCacheApi.getInstance().closeDBConnection(ContextUtil.getContext());
    }

    /* renamed from: a */
    public void m12597a(Bundle bundle) {
        String str;
        int i2;
        SHARE_MEDIA share_media = this.f13514a;
        if (share_media == null || !(share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.QQ || share_media == SHARE_MEDIA.SINA)) {
            str = "";
            i2 = -1;
        } else {
            str = this.f13514a.toString();
            i2 = 0;
        }
        bundle.putString(f13512b, str);
        bundle.putInt(f13513c, i2);
        this.f13514a = null;
    }

    /* renamed from: a */
    public void m12593a(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        SHARE_MEDIA convertToEmun;
        UMSSOHandler m12589a;
        if (bundle == null || uMAuthListener == null) {
            return;
        }
        String string = bundle.getString(f13512b, null);
        if (bundle.getInt(f13513c, -1) != 0 || TextUtils.isEmpty(string) || (convertToEmun = SHARE_MEDIA.convertToEmun(string)) == null) {
            return;
        }
        if (convertToEmun == SHARE_MEDIA.QQ) {
            m12589a = this.f13515d.get(convertToEmun);
            m12589a.onCreate(activity, PlatformConfig.getPlatform(convertToEmun));
        } else {
            m12589a = m12589a(convertToEmun);
        }
        if (m12589a != null) {
            m12578a(convertToEmun, uMAuthListener, m12589a, String.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: a */
    public void m12598a(UMShareConfig uMShareConfig) {
        if (this.f13515d.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<SHARE_MEDIA, UMSSOHandler>> it = this.f13515d.entrySet().iterator();
        while (it.hasNext()) {
            UMSSOHandler value = it.next().getValue();
            if (value != null) {
                value.setShareConfig(uMShareConfig);
            }
        }
    }
}
