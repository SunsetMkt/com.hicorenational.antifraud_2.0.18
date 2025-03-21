package com.umeng.socialize.handler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.editorpage.IEditor;
import com.umeng.socialize.net.RestAPI;
import com.umeng.socialize.net.analytics.AnalyticsReqeust;
import com.umeng.socialize.net.analytics.AnalyticsResponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes2.dex */
public abstract class UMAPIShareHandler extends UMSSOHandler implements IEditor {
    private Stack<StatHolder> mStatStack = new Stack<>();

    private static class StatHolder {
        public ShareContent Content;
        private UMShareListener Listener;

        private StatHolder() {
        }
    }

    public abstract void authorizeCallBack(int i2, int i3, Intent intent);

    public abstract void deleteAuth();

    protected void doShare(ShareContent shareContent, UMShareListener uMShareListener) {
        if (!getShareConfig().isOpenShareEditActivity()) {
            sendShareRequest(shareContent, uMShareListener);
            return;
        }
        StatHolder statHolder = new StatHolder();
        statHolder.Content = shareContent;
        statHolder.Listener = uMShareListener;
        this.mStatStack.push(statHolder);
        if (this.mWeakAct.get() == null || this.mWeakAct.get().isFinishing()) {
            return;
        }
        try {
            Intent intent = new Intent(this.mWeakAct.get(), Class.forName("com.umeng.socialize.editorpage.ShareActivity"));
            intent.putExtras(getEditable(shareContent));
            this.mWeakAct.get().startActivityForResult(intent, getRequestCode());
        } catch (ClassNotFoundException e2) {
            sendShareRequest(shareContent, uMShareListener);
            SLog.error(UmengText.INTER.NULLJAR, e2);
            e2.printStackTrace();
        }
    }

    public abstract SHARE_MEDIA getPlatform();

    public abstract String getUID();

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void onActivityResult(int i2, int i3, Intent intent) {
        StatHolder pop;
        if (i2 != getRequestCode()) {
            return;
        }
        if (i3 == 1000) {
            if (this.mStatStack.isEmpty() || (pop = this.mStatStack.pop()) == null) {
                return;
            }
            pop.Listener.onCancel(getPlatform());
            return;
        }
        if (intent == null || !intent.hasExtra(SocializeConstants.KEY_TEXT)) {
            authorizeCallBack(i2, i3, intent);
            return;
        }
        if (this.mStatStack.empty()) {
            return;
        }
        final StatHolder pop2 = this.mStatStack.pop();
        final Bundle extras = intent.getExtras();
        if (i3 == -1) {
            QueuedWork.runInBack(new Runnable() { // from class: com.umeng.socialize.handler.UMAPIShareHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    UMAPIShareHandler.this.sendShareRequest(UMAPIShareHandler.this.getResult(pop2.Content, extras), pop2.Listener);
                }
            }, true);
        } else if (pop2.Listener != null) {
            pop2.Listener.onCancel(getPlatform());
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void onCreate(Context context, PlatformConfig.Platform platform) {
        super.onCreate(context, platform);
    }

    public void sendShareRequest(final ShareContent shareContent, final UMShareListener uMShareListener) {
        final SHARE_MEDIA platform = getPlatform();
        String lowerCase = platform.toString().toLowerCase();
        String uid = getUID();
        AnalyticsReqeust analyticsReqeust = new AnalyticsReqeust(getContext(), lowerCase, shareContent.mText);
        analyticsReqeust.setMedia(shareContent.mMedia);
        analyticsReqeust.setmUsid(uid);
        analyticsReqeust.setReqType(0);
        final AnalyticsResponse doShareByRequest = RestAPI.doShareByRequest(analyticsReqeust);
        if (doShareByRequest == null) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMAPIShareHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    uMShareListener.onError(platform, new Throwable(UmengErrorCode.ShareFailed.getMessage() + "response is null"));
                }
            });
        } else if (doShareByRequest.isOk()) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMAPIShareHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    uMShareListener.onResult(platform);
                }
            });
        } else {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMAPIShareHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    if (doShareByRequest.mStCode == 5027) {
                        UMAPIShareHandler.this.deleteAuth();
                        UMAPIShareHandler.this.share(shareContent, uMShareListener);
                        return;
                    }
                    uMShareListener.onError(platform, new Throwable(UmengErrorCode.ShareFailed.getMessage() + doShareByRequest.mMsg));
                }
            });
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean share(final ShareContent shareContent, final UMShareListener uMShareListener) {
        if (isAuthorize()) {
            doShare(shareContent, uMShareListener);
            return false;
        }
        authorize(new UMAuthListener() { // from class: com.umeng.socialize.handler.UMAPIShareHandler.2
            @Override // com.umeng.socialize.UMAuthListener
            public void onCancel(SHARE_MEDIA share_media, int i2) {
                uMShareListener.onCancel(share_media);
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onComplete(SHARE_MEDIA share_media, int i2, Map<String, String> map) {
                QueuedWork.runInBack(new Runnable() { // from class: com.umeng.socialize.handler.UMAPIShareHandler.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        UMAPIShareHandler.this.doShare(shareContent, uMShareListener);
                    }
                }, true);
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onError(SHARE_MEDIA share_media, int i2, Throwable th) {
                uMShareListener.onError(share_media, th);
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onStart(SHARE_MEDIA share_media) {
                uMShareListener.onStart(share_media);
            }
        });
        return false;
    }
}
