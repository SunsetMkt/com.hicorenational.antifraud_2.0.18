package com.umeng.socialize;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import anet.channel.util.HttpConstant;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.shareboard.ShareBoard;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareAction {

    /* renamed from: b */
    private SHARE_MEDIA f13429b;

    /* renamed from: c */
    private UMShareListener f13430c;

    /* renamed from: d */
    private ShareBoardlistener f13431d;

    /* renamed from: e */
    private Activity f13432e;

    /* renamed from: f */
    private List<SHARE_MEDIA> f13433f;

    /* renamed from: k */
    private View f13438k;

    /* renamed from: l */
    private boolean f13439l;

    /* renamed from: m */
    private ShareBoard f13440m;

    /* renamed from: a */
    private ShareContent f13428a = new ShareContent();

    /* renamed from: g */
    private final List<SnsPlatform> f13434g = new ArrayList();

    /* renamed from: h */
    private List<ShareContent> f13435h = new ArrayList();

    /* renamed from: i */
    private List<UMShareListener> f13436i = new ArrayList();

    /* renamed from: j */
    private int f13437j = 80;

    /* renamed from: n */
    private ShareBoardlistener f13441n = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.1
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    /* renamed from: o */
    private ShareBoardlistener f13442o = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.2
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            int indexOf = ShareAction.this.f13433f.indexOf(share_media);
            int size = ShareAction.this.f13435h.size();
            if (size != 0) {
                ShareAction.this.f13428a = indexOf < size ? (ShareContent) ShareAction.this.f13435h.get(indexOf) : (ShareContent) ShareAction.this.f13435h.get(size - 1);
            }
            int size2 = ShareAction.this.f13436i.size();
            if (size2 != 0) {
                if (indexOf < size2) {
                    ShareAction shareAction = ShareAction.this;
                    shareAction.f13430c = (UMShareListener) shareAction.f13436i.get(indexOf);
                } else {
                    ShareAction shareAction2 = ShareAction.this;
                    shareAction2.f13430c = (UMShareListener) shareAction2.f13436i.get(size2 - 1);
                }
            }
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.f13432e = (Activity) new WeakReference(activity).get();
        }
    }

    public static Rect locateView(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return null;
        }
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        } catch (NullPointerException e2) {
            SLog.error(e2);
            return null;
        }
    }

    public ShareAction addButton(String str, String str2, String str3, String str4) {
        this.f13434g.add(SHARE_MEDIA.createSnsPlatform(str, str2, str3, str4, 0));
        return this;
    }

    public ShareAction bySystem() {
        this.f13439l = true;
        return this;
    }

    public void close() {
        ShareBoard shareBoard = this.f13440m;
        if (shareBoard != null) {
            shareBoard.dismiss();
            this.f13440m = null;
        }
    }

    public SHARE_MEDIA getPlatform() {
        return this.f13429b;
    }

    public ShareContent getShareContent() {
        return this.f13428a;
    }

    public boolean getUrlValid() {
        UMediaObject uMediaObject;
        ShareContent shareContent = this.f13428a;
        return shareContent == null || (uMediaObject = shareContent.mMedia) == null || !(uMediaObject instanceof UMWeb) || uMediaObject.toUrl() == null || this.f13428a.mMedia.toUrl().startsWith(HttpConstant.HTTP);
    }

    public void open(ShareBoardConfig shareBoardConfig) {
        if (CommonUtil.isSilentMode(this.f13432e)) {
            return;
        }
        if (this.f13434g.size() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("listener", this.f13430c);
            hashMap.put("content", this.f13428a);
            try {
                this.f13440m = new ShareBoard(this.f13432e, this.f13434g, shareBoardConfig);
                if (this.f13431d == null) {
                    this.f13440m.setShareBoardlistener(this.f13442o);
                } else {
                    this.f13440m.setShareBoardlistener(this.f13431d);
                }
                this.f13440m.setFocusable(true);
                this.f13440m.setBackgroundDrawable(new BitmapDrawable());
                if (this.f13438k == null) {
                    this.f13438k = this.f13432e.getWindow().getDecorView();
                }
                this.f13440m.showAtLocation(this.f13438k, this.f13437j, 0, 0);
                return;
            } catch (Exception e2) {
                SLog.error(e2);
                return;
            }
        }
        this.f13434g.add(SHARE_MEDIA.WEIXIN.toSnsPlatform());
        this.f13434g.add(SHARE_MEDIA.WEIXIN_CIRCLE.toSnsPlatform());
        this.f13434g.add(SHARE_MEDIA.SINA.toSnsPlatform());
        this.f13434g.add(SHARE_MEDIA.QQ.toSnsPlatform());
        this.f13434g.add(SHARE_MEDIA.DINGTALK.toSnsPlatform());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("listener", this.f13430c);
        hashMap2.put("content", this.f13428a);
        this.f13440m = new ShareBoard(this.f13432e, this.f13434g, shareBoardConfig);
        ShareBoardlistener shareBoardlistener = this.f13431d;
        if (shareBoardlistener == null) {
            this.f13440m.setShareBoardlistener(this.f13441n);
        } else {
            this.f13440m.setShareBoardlistener(shareBoardlistener);
        }
        this.f13440m.setFocusable(true);
        this.f13440m.setBackgroundDrawable(new BitmapDrawable());
        if (this.f13438k == null) {
            this.f13438k = this.f13432e.getWindow().getDecorView();
        }
        this.f13440m.showAtLocation(this.f13438k, 80, 0, 0);
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.f13430c = uMShareListener;
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr == null || Arrays.asList(shareContentArr).size() == 0) {
            ShareContent shareContent = new ShareContent();
            shareContent.mText = "empty";
            this.f13435h.add(shareContent);
        } else {
            this.f13435h = Arrays.asList(shareContentArr);
        }
        return this;
    }

    public ShareAction setDisplayList(SHARE_MEDIA... share_mediaArr) {
        this.f13433f = Arrays.asList(share_mediaArr);
        this.f13434g.clear();
        Iterator<SHARE_MEDIA> it = this.f13433f.iterator();
        while (it.hasNext()) {
            this.f13434g.add(it.next().toSnsPlatform());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.f13436i = Arrays.asList(uMShareListenerArr);
        return this;
    }

    public ShareAction setPlatform(SHARE_MEDIA share_media) {
        this.f13429b = share_media;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.f13428a = shareContent;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.f13431d = shareBoardlistener;
        return this;
    }

    public void share() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f13432e);
        if (uMShareAPI != null) {
            ShareContent shareContent = getShareContent();
            if (shareContent != null) {
                shareContent.bySystem = this.f13439l;
            }
            uMShareAPI.doShare(this.f13432e, this, this.f13430c);
        }
    }

    public ShareAction withApp(File file) {
        this.f13428a.app = file;
        return this;
    }

    public ShareAction withExtra(UMImage uMImage) {
        this.f13428a.mExtra = uMImage;
        return this;
    }

    public ShareAction withFile(File file) {
        this.f13428a.file = file;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.f13428a.mFollow = str;
        return this;
    }

    public ShareAction withMedia(UMImage uMImage) {
        this.f13428a.mMedia = uMImage;
        return this;
    }

    public ShareAction withMedias(UMImage... uMImageArr) {
        if (uMImageArr != null && uMImageArr.length > 0) {
            this.f13428a.mMedia = uMImageArr[0];
        }
        this.f13428a.mMedias = uMImageArr;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i2) {
        this.f13437j = i2;
        this.f13438k = view;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.f13428a.subject = str;
        return this;
    }

    public ShareAction withText(String str) {
        this.f13428a.mText = str;
        return this;
    }

    public ShareAction withMedia(UMMin uMMin) {
        this.f13428a.mMedia = uMMin;
        return this;
    }

    public ShareAction withMedia(UMQQMini uMQQMini) {
        this.f13428a.mMedia = uMQQMini;
        return this;
    }

    public ShareAction withMedia(UMEmoji uMEmoji) {
        this.f13428a.mMedia = uMEmoji;
        return this;
    }

    public ShareAction withMedias(UMVideo... uMVideoArr) {
        if (uMVideoArr != null && uMVideoArr.length > 0) {
            this.f13428a.mMedia = uMVideoArr[0];
        }
        this.f13428a.Video_mMedias = uMVideoArr;
        return this;
    }

    public ShareAction withMedia(UMWeb uMWeb) {
        this.f13428a.mMedia = uMWeb;
        return this;
    }

    public ShareAction withMedia(UMusic uMusic) {
        this.f13428a.mMedia = uMusic;
        return this;
    }

    public ShareAction withMedia(UMVideo uMVideo) {
        this.f13428a.mMedia = uMVideo;
        return this;
    }

    public void open() {
        open(null);
    }
}
