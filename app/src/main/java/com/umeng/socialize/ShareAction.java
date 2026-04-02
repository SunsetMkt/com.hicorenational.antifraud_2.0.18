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

/* JADX INFO: loaded from: classes2.dex */
public class ShareAction {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SHARE_MEDIA f8134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UMShareListener f8135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ShareBoardlistener f8136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f8137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<SHARE_MEDIA> f8138f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f8143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8144l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ShareBoard f8145m;
    private ShareContent a = new ShareContent();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<SnsPlatform> f8139g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<ShareContent> f8140h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<UMShareListener> f8141i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8142j = 80;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ShareBoardlistener f8146n = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.1
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };
    private ShareBoardlistener o = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.2
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            int iIndexOf = ShareAction.this.f8138f.indexOf(share_media);
            int size = ShareAction.this.f8140h.size();
            if (size != 0) {
                ShareAction.this.a = iIndexOf < size ? (ShareContent) ShareAction.this.f8140h.get(iIndexOf) : (ShareContent) ShareAction.this.f8140h.get(size - 1);
            }
            int size2 = ShareAction.this.f8141i.size();
            if (size2 != 0) {
                if (iIndexOf < size2) {
                    ShareAction shareAction = ShareAction.this;
                    shareAction.f8135c = (UMShareListener) shareAction.f8141i.get(iIndexOf);
                } else {
                    ShareAction shareAction2 = ShareAction.this;
                    shareAction2.f8135c = (UMShareListener) shareAction2.f8141i.get(size2 - 1);
                }
            }
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.f8137e = (Activity) new WeakReference(activity).get();
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
        this.f8139g.add(SHARE_MEDIA.createSnsPlatform(str, str2, str3, str4, 0));
        return this;
    }

    public ShareAction bySystem() {
        this.f8144l = true;
        return this;
    }

    public void close() {
        ShareBoard shareBoard = this.f8145m;
        if (shareBoard != null) {
            shareBoard.dismiss();
            this.f8145m = null;
        }
    }

    public SHARE_MEDIA getPlatform() {
        return this.f8134b;
    }

    public ShareContent getShareContent() {
        return this.a;
    }

    public boolean getUrlValid() {
        UMediaObject uMediaObject;
        ShareContent shareContent = this.a;
        return shareContent == null || (uMediaObject = shareContent.mMedia) == null || !(uMediaObject instanceof UMWeb) || uMediaObject.toUrl() == null || this.a.mMedia.toUrl().startsWith(HttpConstant.HTTP);
    }

    public void open(ShareBoardConfig shareBoardConfig) {
        if (CommonUtil.isSilentMode(this.f8137e)) {
            return;
        }
        if (this.f8139g.size() != 0) {
            HashMap map = new HashMap();
            map.put("listener", this.f8135c);
            map.put("content", this.a);
            try {
                this.f8145m = new ShareBoard(this.f8137e, this.f8139g, shareBoardConfig);
                if (this.f8136d == null) {
                    this.f8145m.setShareBoardlistener(this.o);
                } else {
                    this.f8145m.setShareBoardlistener(this.f8136d);
                }
                this.f8145m.setFocusable(true);
                this.f8145m.setBackgroundDrawable(new BitmapDrawable());
                if (this.f8143k == null) {
                    this.f8143k = this.f8137e.getWindow().getDecorView();
                }
                this.f8145m.showAtLocation(this.f8143k, this.f8142j, 0, 0);
                return;
            } catch (Exception e2) {
                SLog.error(e2);
                return;
            }
        }
        this.f8139g.add(SHARE_MEDIA.WEIXIN.toSnsPlatform());
        this.f8139g.add(SHARE_MEDIA.WEIXIN_CIRCLE.toSnsPlatform());
        this.f8139g.add(SHARE_MEDIA.SINA.toSnsPlatform());
        this.f8139g.add(SHARE_MEDIA.QQ.toSnsPlatform());
        this.f8139g.add(SHARE_MEDIA.DINGTALK.toSnsPlatform());
        HashMap map2 = new HashMap();
        map2.put("listener", this.f8135c);
        map2.put("content", this.a);
        this.f8145m = new ShareBoard(this.f8137e, this.f8139g, shareBoardConfig);
        ShareBoardlistener shareBoardlistener = this.f8136d;
        if (shareBoardlistener == null) {
            this.f8145m.setShareBoardlistener(this.f8146n);
        } else {
            this.f8145m.setShareBoardlistener(shareBoardlistener);
        }
        this.f8145m.setFocusable(true);
        this.f8145m.setBackgroundDrawable(new BitmapDrawable());
        if (this.f8143k == null) {
            this.f8143k = this.f8137e.getWindow().getDecorView();
        }
        this.f8145m.showAtLocation(this.f8143k, 80, 0, 0);
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.f8135c = uMShareListener;
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr == null || Arrays.asList(shareContentArr).size() == 0) {
            ShareContent shareContent = new ShareContent();
            shareContent.mText = "empty";
            this.f8140h.add(shareContent);
        } else {
            this.f8140h = Arrays.asList(shareContentArr);
        }
        return this;
    }

    public ShareAction setDisplayList(SHARE_MEDIA... share_mediaArr) {
        this.f8138f = Arrays.asList(share_mediaArr);
        this.f8139g.clear();
        Iterator<SHARE_MEDIA> it = this.f8138f.iterator();
        while (it.hasNext()) {
            this.f8139g.add(it.next().toSnsPlatform());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.f8141i = Arrays.asList(uMShareListenerArr);
        return this;
    }

    public ShareAction setPlatform(SHARE_MEDIA share_media) {
        this.f8134b = share_media;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.a = shareContent;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.f8136d = shareBoardlistener;
        return this;
    }

    public void share() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f8137e);
        if (uMShareAPI != null) {
            ShareContent shareContent = getShareContent();
            if (shareContent != null) {
                shareContent.bySystem = this.f8144l;
            }
            uMShareAPI.doShare(this.f8137e, this, this.f8135c);
        }
    }

    public ShareAction withApp(File file) {
        this.a.app = file;
        return this;
    }

    public ShareAction withExtra(UMImage uMImage) {
        this.a.mExtra = uMImage;
        return this;
    }

    public ShareAction withFile(File file) {
        this.a.file = file;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.a.mFollow = str;
        return this;
    }

    public ShareAction withMedia(UMImage uMImage) {
        this.a.mMedia = uMImage;
        return this;
    }

    public ShareAction withMedias(UMImage... uMImageArr) {
        if (uMImageArr != null && uMImageArr.length > 0) {
            this.a.mMedia = uMImageArr[0];
        }
        this.a.mMedias = uMImageArr;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i2) {
        this.f8142j = i2;
        this.f8143k = view;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.a.subject = str;
        return this;
    }

    public ShareAction withText(String str) {
        this.a.mText = str;
        return this;
    }

    public ShareAction withMedia(UMMin uMMin) {
        this.a.mMedia = uMMin;
        return this;
    }

    public ShareAction withMedia(UMQQMini uMQQMini) {
        this.a.mMedia = uMQQMini;
        return this;
    }

    public ShareAction withMedia(UMEmoji uMEmoji) {
        this.a.mMedia = uMEmoji;
        return this;
    }

    public ShareAction withMedias(UMVideo... uMVideoArr) {
        if (uMVideoArr != null && uMVideoArr.length > 0) {
            this.a.mMedia = uMVideoArr[0];
        }
        this.a.Video_mMedias = uMVideoArr;
        return this;
    }

    public ShareAction withMedia(UMWeb uMWeb) {
        this.a.mMedia = uMWeb;
        return this;
    }

    public ShareAction withMedia(UMusic uMusic) {
        this.a.mMedia = uMusic;
        return this;
    }

    public ShareAction withMedia(UMVideo uMVideo) {
        this.a.mMedia = uMVideo;
        return this;
    }

    public void open() {
        open(null);
    }
}
