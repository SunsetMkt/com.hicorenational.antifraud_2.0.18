package com.umeng.socialize.media;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.p217c.p218a.C3633a;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* loaded from: classes2.dex */
public class SimpleShareContent {

    /* renamed from: a */
    private UMImage f13637a;

    /* renamed from: b */
    private UMImage[] f13638b;

    /* renamed from: c */
    private String f13639c;

    /* renamed from: d */
    private UMVideo f13640d;

    /* renamed from: e */
    private UMVideo[] f13641e;

    /* renamed from: f */
    private UMEmoji f13642f;

    /* renamed from: g */
    private UMusic f13643g;

    /* renamed from: h */
    private UMMin f13644h;

    /* renamed from: i */
    private UMQQMini f13645i;

    /* renamed from: j */
    private UMWeb f13646j;

    /* renamed from: k */
    private File f13647k;

    /* renamed from: l */
    private BaseMediaObject f13648l;

    /* renamed from: m */
    private int f13649m;

    /* renamed from: n */
    private String f13650n;

    /* renamed from: o */
    private String f13651o;

    /* renamed from: p */
    private CompressListener f13652p;
    public int THUMB_LIMIT = 24576;
    public int WX_THUMB_LIMIT = 18432;
    public int WX_MIN_LIMIT = 131072;
    public final int IMAGE_LIMIT = 491520;
    public final String DEFAULT_TITLE = "这里是标题";
    public final String DEFAULT_DESCRIPTION = "这里是描述";

    public SimpleShareContent(ShareContent shareContent) {
        this.f13639c = shareContent.mText;
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject == null || !(uMediaObject instanceof UMImage) || shareContent.Video_mMedias == null) {
            UMediaObject uMediaObject2 = shareContent.mMedia;
            if (uMediaObject2 != null && (uMediaObject2 instanceof UMImage)) {
                this.f13637a = (UMImage) uMediaObject2;
                this.f13648l = this.f13637a;
                UMImage[] uMImageArr = shareContent.mMedias;
                if (uMImageArr != null && uMImageArr.length > 0) {
                    this.f13638b = uMImageArr;
                }
            }
            UMediaObject uMediaObject3 = shareContent.mMedia;
            if (uMediaObject3 != null && (uMediaObject3 instanceof UMusic)) {
                this.f13643g = (UMusic) uMediaObject3;
                this.f13648l = this.f13643g;
            }
            UMediaObject uMediaObject4 = shareContent.mMedia;
            if (uMediaObject4 != null && (uMediaObject4 instanceof UMVideo)) {
                this.f13640d = (UMVideo) uMediaObject4;
                this.f13648l = this.f13640d;
                UMVideo[] uMVideoArr = shareContent.Video_mMedias;
                if (uMVideoArr != null && uMVideoArr.length > 0) {
                    this.f13641e = uMVideoArr;
                }
            }
            UMediaObject uMediaObject5 = shareContent.mMedia;
            if (uMediaObject5 != null && (uMediaObject5 instanceof UMEmoji)) {
                this.f13642f = (UMEmoji) uMediaObject5;
                this.f13648l = this.f13642f;
            }
            UMediaObject uMediaObject6 = shareContent.mMedia;
            if (uMediaObject6 != null && (uMediaObject6 instanceof UMWeb)) {
                this.f13646j = (UMWeb) uMediaObject6;
                this.f13648l = this.f13646j;
            }
            UMediaObject uMediaObject7 = shareContent.mMedia;
            if (uMediaObject7 != null && (uMediaObject7 instanceof UMMin)) {
                this.f13644h = (UMMin) uMediaObject7;
                this.f13648l = this.f13646j;
            }
            UMediaObject uMediaObject8 = shareContent.mMedia;
            if (uMediaObject8 != null && (uMediaObject8 instanceof UMQQMini)) {
                this.f13645i = (UMQQMini) uMediaObject8;
                this.f13648l = this.f13646j;
            }
            File file = shareContent.file;
            if (file != null) {
                this.f13647k = file;
            }
        } else {
            this.f13637a = (UMImage) uMediaObject;
            this.f13648l = this.f13637a;
            UMImage[] uMImageArr2 = shareContent.mMedias;
            if (uMImageArr2 != null && uMImageArr2.length > 0) {
                this.f13638b = uMImageArr2;
            }
            this.f13648l = this.f13640d;
            UMVideo[] uMVideoArr2 = shareContent.Video_mMedias;
            if (uMVideoArr2 != null && uMVideoArr2.length > 0) {
                this.f13641e = uMVideoArr2;
            }
        }
        this.f13651o = shareContent.subject;
        this.f13649m = shareContent.getShareType();
        this.f13650n = m12647a();
    }

    /* renamed from: a */
    private String m12647a() {
        int i2 = this.f13649m;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 8 ? i2 != 16 ? i2 != 32 ? i2 != 64 ? i2 != 128 ? i2 != 256 ? "error" : "qqMini" : "minapp" : "emoji" : "file" : "web" : "video" : "music" : "textandimage" : "image" : "text";
    }

    /* renamed from: b */
    private byte[] m12648b() {
        byte[] bytes = DefaultClass.getBytes();
        if (ContextUtil.getIcon() != 0 && ((bytes = C3633a.m12617a(new UMImage(ContextUtil.getContext(), ContextUtil.getIcon()), this.WX_THUMB_LIMIT)) == null || bytes.length <= 0)) {
            SLog.m12716E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        }
        return bytes;
    }

    public boolean canFileValid(UMImage uMImage) {
        return uMImage.asFileImage() != null;
    }

    public String getAssertSubject() {
        return TextUtils.isEmpty(this.f13651o) ? "umengshare" : this.f13651o;
    }

    public BaseMediaObject getBaseMediaObject() {
        return this.f13648l;
    }

    public File getFile() {
        return this.f13647k;
    }

    public UMImage getImage() {
        return this.f13637a;
    }

    public byte[] getImageData(UMImage uMImage) {
        return uMImage.asBinImage();
    }

    public byte[] getImageThumb(UMImage uMImage) {
        if (uMImage.getThumbImage() == null) {
            return m12648b();
        }
        byte[] m12617a = C3633a.m12617a(uMImage.getThumbImage(), this.WX_THUMB_LIMIT);
        if (m12617a != null && m12617a.length > 0) {
            return m12617a;
        }
        SLog.m12716E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return m12648b();
    }

    public UMusic getMusic() {
        return this.f13643g;
    }

    public String getMusicTargetUrl(UMusic uMusic) {
        return TextUtils.isEmpty(uMusic.getmTargetUrl()) ? uMusic.toUrl() : uMusic.getmTargetUrl();
    }

    public UMQQMini getQQMini() {
        return this.f13645i;
    }

    public String getStrStyle() {
        return this.f13650n;
    }

    public byte[] getStrictImageData(UMImage uMImage) {
        if (getUMImageScale(uMImage) <= 491520) {
            return getImageData(uMImage);
        }
        byte[] m12617a = C3633a.m12617a(getImage(), 491520);
        if (m12617a != null && m12617a.length > 0) {
            return m12617a;
        }
        SLog.m12716E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return null;
    }

    public String getSubject() {
        return this.f13651o;
    }

    public String getText() {
        return this.f13639c;
    }

    public int getUMImageScale(UMImage uMImage) {
        return C3633a.m12610a(uMImage);
    }

    public UMEmoji getUmEmoji() {
        return this.f13642f;
    }

    public UMMin getUmMin() {
        return this.f13644h;
    }

    public UMVideo[] getUmVideos() {
        return this.f13641e;
    }

    public UMWeb getUmWeb() {
        return this.f13646j;
    }

    public UMVideo getVideo() {
        return this.f13640d;
    }

    public UMImage[] getmImages() {
        return this.f13638b;
    }

    public int getmStyle() {
        return this.f13649m;
    }

    public String objectSetDescription(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getDescription())) {
            return "这里是描述";
        }
        String description = baseMediaObject.getDescription();
        return description.length() > 1024 ? description.substring(0, 1024) : description;
    }

    public byte[] objectSetMInAppThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return DefaultClass.getBytes();
        }
        if (this.f13652p != null) {
            UMImage thumbImage = baseMediaObject.getThumbImage();
            if (thumbImage == null) {
                return DefaultClass.getBytes();
            }
            byte[] asBinImage = thumbImage.asBinImage();
            return (asBinImage == null || C3633a.m12610a(thumbImage) > this.WX_MIN_LIMIT) ? this.f13652p.compressThumb(asBinImage) : asBinImage;
        }
        byte[] m12620a = C3633a.m12620a(baseMediaObject.getThumbImage().asBinImage(), this.WX_MIN_LIMIT, Bitmap.CompressFormat.JPEG);
        if (m12620a != null && m12620a.length > 0) {
            return m12620a;
        }
        SLog.m12716E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return m12620a;
    }

    public String objectSetText(String str, int i2) {
        return TextUtils.isEmpty(str) ? "这里是描述" : str.length() > i2 ? str.substring(0, i2) : str;
    }

    public byte[] objectSetThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return m12648b();
        }
        if (this.f13652p != null) {
            UMImage thumbImage = baseMediaObject.getThumbImage();
            if (thumbImage == null) {
                return DefaultClass.getBytes();
            }
            byte[] asBinImage = thumbImage.asBinImage();
            return (asBinImage == null || C3633a.m12610a(thumbImage) > this.THUMB_LIMIT) ? this.f13652p.compressThumb(asBinImage) : asBinImage;
        }
        byte[] m12617a = C3633a.m12617a(baseMediaObject.getThumbImage(), this.THUMB_LIMIT);
        if (m12617a != null && m12617a.length > 0) {
            return m12617a;
        }
        SLog.m12716E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return m12648b();
    }

    public String objectSetTitle(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getTitle())) {
            return "这里是标题";
        }
        String title = baseMediaObject.getTitle();
        return title.length() > 512 ? title.substring(0, 512) : title;
    }

    public void setCompressListener(CompressListener compressListener) {
        this.f13652p = compressListener;
    }

    public void setImage(UMImage uMImage) {
        this.f13637a = uMImage;
    }

    public void setMusic(UMusic uMusic) {
        this.f13643g = uMusic;
    }

    public void setText(String str) {
        this.f13639c = str;
    }

    public void setVideo(UMVideo uMVideo) {
        this.f13640d = uMVideo;
    }

    public String subString(String str, int i2) {
        return (!TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public String objectSetText(String str) {
        return objectSetText(str, 10240);
    }
}
