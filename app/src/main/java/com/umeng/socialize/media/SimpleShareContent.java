package com.umeng.socialize.media;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleShareContent {
    private UMImage a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private UMImage[] f8276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private UMVideo f8278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private UMVideo[] f8279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private UMEmoji f8280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private UMusic f8281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private UMMin f8282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private UMQQMini f8283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private UMWeb f8284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f8285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BaseMediaObject f8286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f8288n;
    private String o;
    private CompressListener p;
    public int THUMB_LIMIT = 24576;
    public int WX_THUMB_LIMIT = 18432;
    public int WX_MIN_LIMIT = 131072;
    public final int IMAGE_LIMIT = 491520;
    public final String DEFAULT_TITLE = "\u8fd9\u91cc\u662f\u6807\u9898";
    public final String DEFAULT_DESCRIPTION = "\u8fd9\u91cc\u662f\u63cf\u8ff0";

    public SimpleShareContent(ShareContent shareContent) {
        this.f8277c = shareContent.mText;
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject == null || !(uMediaObject instanceof UMImage) || shareContent.Video_mMedias == null) {
            UMediaObject uMediaObject2 = shareContent.mMedia;
            if (uMediaObject2 != null && (uMediaObject2 instanceof UMImage)) {
                this.a = (UMImage) uMediaObject2;
                this.f8286l = this.a;
                UMImage[] uMImageArr = shareContent.mMedias;
                if (uMImageArr != null && uMImageArr.length > 0) {
                    this.f8276b = uMImageArr;
                }
            }
            UMediaObject uMediaObject3 = shareContent.mMedia;
            if (uMediaObject3 != null && (uMediaObject3 instanceof UMusic)) {
                this.f8281g = (UMusic) uMediaObject3;
                this.f8286l = this.f8281g;
            }
            UMediaObject uMediaObject4 = shareContent.mMedia;
            if (uMediaObject4 != null && (uMediaObject4 instanceof UMVideo)) {
                this.f8278d = (UMVideo) uMediaObject4;
                this.f8286l = this.f8278d;
                UMVideo[] uMVideoArr = shareContent.Video_mMedias;
                if (uMVideoArr != null && uMVideoArr.length > 0) {
                    this.f8279e = uMVideoArr;
                }
            }
            UMediaObject uMediaObject5 = shareContent.mMedia;
            if (uMediaObject5 != null && (uMediaObject5 instanceof UMEmoji)) {
                this.f8280f = (UMEmoji) uMediaObject5;
                this.f8286l = this.f8280f;
            }
            UMediaObject uMediaObject6 = shareContent.mMedia;
            if (uMediaObject6 != null && (uMediaObject6 instanceof UMWeb)) {
                this.f8284j = (UMWeb) uMediaObject6;
                this.f8286l = this.f8284j;
            }
            UMediaObject uMediaObject7 = shareContent.mMedia;
            if (uMediaObject7 != null && (uMediaObject7 instanceof UMMin)) {
                this.f8282h = (UMMin) uMediaObject7;
                this.f8286l = this.f8284j;
            }
            UMediaObject uMediaObject8 = shareContent.mMedia;
            if (uMediaObject8 != null && (uMediaObject8 instanceof UMQQMini)) {
                this.f8283i = (UMQQMini) uMediaObject8;
                this.f8286l = this.f8284j;
            }
            File file = shareContent.file;
            if (file != null) {
                this.f8285k = file;
            }
        } else {
            this.a = (UMImage) uMediaObject;
            this.f8286l = this.a;
            UMImage[] uMImageArr2 = shareContent.mMedias;
            if (uMImageArr2 != null && uMImageArr2.length > 0) {
                this.f8276b = uMImageArr2;
            }
            this.f8286l = this.f8278d;
            UMVideo[] uMVideoArr2 = shareContent.Video_mMedias;
            if (uMVideoArr2 != null && uMVideoArr2.length > 0) {
                this.f8279e = uMVideoArr2;
            }
        }
        this.o = shareContent.subject;
        this.f8287m = shareContent.getShareType();
        this.f8288n = a();
    }

    private String a() {
        int i2 = this.f8287m;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 8 ? i2 != 16 ? i2 != 32 ? i2 != 64 ? i2 != 128 ? i2 != 256 ? "error" : "qqMini" : "minapp" : "emoji" : "file" : "web" : "video" : "music" : "textandimage" : "image" : "text";
    }

    private byte[] b() {
        byte[] bytes = DefaultClass.getBytes();
        if (ContextUtil.getIcon() != 0 && ((bytes = a.a(new UMImage(ContextUtil.getContext(), ContextUtil.getIcon()), this.WX_THUMB_LIMIT)) == null || bytes.length <= 0)) {
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        }
        return bytes;
    }

    public boolean canFileValid(UMImage uMImage) {
        return uMImage.asFileImage() != null;
    }

    public String getAssertSubject() {
        return TextUtils.isEmpty(this.o) ? "umengshare" : this.o;
    }

    public BaseMediaObject getBaseMediaObject() {
        return this.f8286l;
    }

    public File getFile() {
        return this.f8285k;
    }

    public UMImage getImage() {
        return this.a;
    }

    public byte[] getImageData(UMImage uMImage) {
        return uMImage.asBinImage();
    }

    public byte[] getImageThumb(UMImage uMImage) {
        if (uMImage.getThumbImage() == null) {
            return b();
        }
        byte[] bArrA = a.a(uMImage.getThumbImage(), this.WX_THUMB_LIMIT);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return b();
    }

    public UMusic getMusic() {
        return this.f8281g;
    }

    public String getMusicTargetUrl(UMusic uMusic) {
        return TextUtils.isEmpty(uMusic.getmTargetUrl()) ? uMusic.toUrl() : uMusic.getmTargetUrl();
    }

    public UMQQMini getQQMini() {
        return this.f8283i;
    }

    public String getStrStyle() {
        return this.f8288n;
    }

    public byte[] getStrictImageData(UMImage uMImage) {
        if (getUMImageScale(uMImage) <= 491520) {
            return getImageData(uMImage);
        }
        byte[] bArrA = a.a(getImage(), 491520);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return null;
    }

    public String getSubject() {
        return this.o;
    }

    public String getText() {
        return this.f8277c;
    }

    public int getUMImageScale(UMImage uMImage) {
        return a.a(uMImage);
    }

    public UMEmoji getUmEmoji() {
        return this.f8280f;
    }

    public UMMin getUmMin() {
        return this.f8282h;
    }

    public UMVideo[] getUmVideos() {
        return this.f8279e;
    }

    public UMWeb getUmWeb() {
        return this.f8284j;
    }

    public UMVideo getVideo() {
        return this.f8278d;
    }

    public UMImage[] getmImages() {
        return this.f8276b;
    }

    public int getmStyle() {
        return this.f8287m;
    }

    public String objectSetDescription(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getDescription())) {
            return "\u8fd9\u91cc\u662f\u63cf\u8ff0";
        }
        String description = baseMediaObject.getDescription();
        return description.length() > 1024 ? description.substring(0, 1024) : description;
    }

    public byte[] objectSetMInAppThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return DefaultClass.getBytes();
        }
        if (this.p != null) {
            UMImage thumbImage = baseMediaObject.getThumbImage();
            if (thumbImage == null) {
                return DefaultClass.getBytes();
            }
            byte[] bArrAsBinImage = thumbImage.asBinImage();
            return (bArrAsBinImage == null || a.a(thumbImage) > this.WX_MIN_LIMIT) ? this.p.compressThumb(bArrAsBinImage) : bArrAsBinImage;
        }
        byte[] bArrA = a.a(baseMediaObject.getThumbImage().asBinImage(), this.WX_MIN_LIMIT, Bitmap.CompressFormat.JPEG);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return bArrA;
    }

    public String objectSetText(String str, int i2) {
        return TextUtils.isEmpty(str) ? "\u8fd9\u91cc\u662f\u63cf\u8ff0" : str.length() > i2 ? str.substring(0, i2) : str;
    }

    public byte[] objectSetThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return b();
        }
        if (this.p != null) {
            UMImage thumbImage = baseMediaObject.getThumbImage();
            if (thumbImage == null) {
                return DefaultClass.getBytes();
            }
            byte[] bArrAsBinImage = thumbImage.asBinImage();
            return (bArrAsBinImage == null || a.a(thumbImage) > this.THUMB_LIMIT) ? this.p.compressThumb(bArrAsBinImage) : bArrAsBinImage;
        }
        byte[] bArrA = a.a(baseMediaObject.getThumbImage(), this.THUMB_LIMIT);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return b();
    }

    public String objectSetTitle(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getTitle())) {
            return "\u8fd9\u91cc\u662f\u6807\u9898";
        }
        String title = baseMediaObject.getTitle();
        return title.length() > 512 ? title.substring(0, 512) : title;
    }

    public void setCompressListener(CompressListener compressListener) {
        this.p = compressListener;
    }

    public void setImage(UMImage uMImage) {
        this.a = uMImage;
    }

    public void setMusic(UMusic uMusic) {
        this.f8281g = uMusic;
    }

    public void setText(String str) {
        this.f8277c = str;
    }

    public void setVideo(UMVideo uMVideo) {
        this.f8278d = uMVideo;
    }

    public String subString(String str, int i2) {
        return (!TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public String objectSetText(String str) {
        return objectSetText(str, 10240);
    }
}
