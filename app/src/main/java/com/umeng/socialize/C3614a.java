package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.p216b.C3629a;
import com.umeng.socialize.uploadlog.UMLog;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeSpUtils;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* compiled from: UMShareImpl.java */
/* renamed from: com.umeng.socialize.a */
/* loaded from: classes2.dex */
class C3614a extends UMShareAPI {

    /* renamed from: a */
    private final C3629a f13451a;

    /* compiled from: UMShareImpl.java */
    /* renamed from: com.umeng.socialize.a$a */
    private static class a extends QueuedWork.UMAsyncTask<Void> {

        /* renamed from: a */
        private final Context f13474a;

        /* renamed from: b */
        private final boolean f13475b;

        /* renamed from: c */
        private final boolean f13476c = SocializeUtils.isHasDplusCache();

        public a(Context context) {
            this.f13474a = context;
            this.f13475b = SocializeUtils.isToday(SocializeSpUtils.getTime(context));
        }

        /* renamed from: b */
        private boolean m12492b() {
            return this.f13474a.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).getBoolean("newinstall", false);
        }

        /* renamed from: c */
        private void m12493c() {
            SharedPreferences.Editor edit = this.f13474a.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit();
            edit.putBoolean("newinstall", true);
            edit.commit();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground() {
            boolean m12492b = m12492b();
            SLog.m12716E(UmengText.CHECK.SDKVERSION + "7.3.2");
            if (!this.f13475b) {
                SocializeSpUtils.putTime(this.f13474a);
                DplusApi.uploadDAU(ContextUtil.getContext());
                SocialAnalytics.dauStats(this.f13474a, true);
            } else if (this.f13476c) {
                DplusApi.uploadDAU(ContextUtil.getContext());
                SocialAnalytics.dauStats(this.f13474a, true);
            }
            SocialAnalytics.verifyStats(this.f13474a);
            if (!m12492b) {
                m12493c();
                return null;
            }
            Context context = this.f13474a;
            UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, C2084a.f6135q);
            return null;
        }
    }

    protected C3614a(Context context) {
        ContextUtil.setContext(context.getApplicationContext());
        this.f13451a = new C3629a(context.getApplicationContext());
        String currentProcessName = UMFrUtils.getCurrentProcessName(context);
        if (TextUtils.isEmpty(currentProcessName) || !currentProcessName.equals(ContextUtil.getPackageName())) {
            return;
        }
        new a(context.getApplicationContext()).execute();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void deleteOauth(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (activity != null) {
            new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.2
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                protected Object doInBackground() {
                    C3614a.this.f13451a.m12595a(activity, share_media, uMAuthListener);
                    return null;
                }
            }.execute();
        } else {
            SLog.m12716E(UmengText.CHECK.ACTIVITYNULL);
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doOauthVerify(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        UMLog.putAuth();
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
            return;
        }
        if (!SLog.isDebug() || m12489a(activity, share_media)) {
            if (activity != null) {
                new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Void doInBackground() {
                        C3614a.this.f13451a.m12603c(activity, share_media, uMAuthListener);
                        return null;
                    }
                }.execute();
            } else {
                SLog.m12716E(UmengText.CHECK.ACTIVITYNULL);
            }
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doShare(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        UMLog.putShare();
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        if (SLog.isDebug()) {
            if (!m12489a(activity, shareAction.getPlatform())) {
                return;
            } else {
                UrlUtil.sharePrint(shareAction.getPlatform());
            }
        }
        if (weakReference.get() == null || ((Activity) weakReference.get()).isFinishing()) {
            SLog.m12716E(UmengText.CHECK.ACTIVITYNULL);
        } else {
            new QueuedWork.DialogThread<Void>((Context) weakReference.get()) { // from class: com.umeng.socialize.a.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground() {
                    if (weakReference.get() != null && !((Activity) weakReference.get()).isFinishing()) {
                        C3614a.this.f13451a.m12594a((Activity) weakReference.get(), shareAction, uMShareListener);
                        Context context = ContextUtil.getContext();
                        if (context != null) {
                            UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, C2084a.f6136r);
                        }
                    }
                    return null;
                }
            }.execute();
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        this.f13451a.m12593a(activity, bundle, uMAuthListener);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        C3629a c3629a = this.f13451a;
        if (c3629a != null) {
            return c3629a.m12589a(share_media);
        }
        return null;
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void getPlatformInfo(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (activity == null) {
            SLog.m12716E(UmengText.CHECK.ACTIVITYNULL);
            return;
        }
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
            return;
        }
        UMLog.putAuth();
        if (SLog.isDebug()) {
            if (!m12489a(activity, share_media)) {
                return;
            } else {
                UrlUtil.getInfoPrint(share_media);
            }
        }
        new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.3
            @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
            protected Object doInBackground() {
                C3614a.this.f13451a.m12600b(activity, share_media, uMAuthListener);
                Context context = ContextUtil.getContext();
                if (context == null) {
                    return null;
                }
                UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, C2084a.f6136r);
                return null;
            }
        }.execute();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return this.f13451a.m12602c(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return this.f13451a.m12604d(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return this.f13451a.m12599a(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return this.f13451a.m12601b(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onActivityResult(int i2, int i3, Intent intent) {
        C3629a c3629a = this.f13451a;
        if (c3629a != null) {
            c3629a.m12591a(i2, i3, intent);
        } else {
            SLog.m12716E(UmengText.CHECK.ROUTERNULL);
        }
        SLog.m12717I(UmengText.CHECK.getActivityResult(i2, i3));
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onSaveInstanceState(Bundle bundle) {
        this.f13451a.m12597a(bundle);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void release() {
        this.f13451a.m12590a();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void setShareConfig(UMShareConfig uMShareConfig) {
        this.f13451a.m12598a(uMShareConfig);
    }

    /* renamed from: a */
    private boolean m12489a(Activity activity, SHARE_MEDIA share_media) {
        boolean z = false;
        for (Method method : activity.getClass().getDeclaredMethods()) {
            if (method.getName().equals("onActivityResult")) {
                z = true;
            }
        }
        if (!z) {
            SLog.mutlE(UmengText.CHECK.ALL_NO_ONACTIVITY, UrlUtil.ALL_NO_ONACTIVITY);
        }
        if (share_media == SHARE_MEDIA.QQ) {
            SLog.m12716E(UmengTool.checkQQByself(activity));
            return true;
        }
        if (share_media == SHARE_MEDIA.WEIXIN) {
            SLog.m12716E(UmengTool.checkWxBySelf(activity));
            return true;
        }
        if (share_media == SHARE_MEDIA.SINA) {
            SLog.m12716E(UmengTool.checkSinaBySelf(activity));
            return true;
        }
        if (share_media == SHARE_MEDIA.FACEBOOK) {
            SLog.m12716E(UmengTool.checkFBByself(activity));
            return true;
        }
        if (share_media == SHARE_MEDIA.VKONTAKTE) {
            SLog.m12716E(UmengTool.checkVKByself(activity));
        }
        if (share_media == SHARE_MEDIA.LINKEDIN) {
            SLog.m12716E(UmengTool.checkLinkin(activity));
        }
        if (share_media == SHARE_MEDIA.KAKAO) {
            SLog.m12716E(UmengTool.checkKakao(activity));
        }
        return true;
    }
}
