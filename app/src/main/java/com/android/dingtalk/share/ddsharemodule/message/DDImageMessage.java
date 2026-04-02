package com.android.dingtalk.share.ddsharemodule.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DDImageMessage extends BaseMediaObject {
    private static final int MAX_IMAGE_DATA_LENGTH = 10485760;
    private static final int MAX_IMAGE_THUMB_DATA_LENGTH = 32768;
    private static final int MAX_IMAGE_URL_LENGTH = 10240;
    private static final String TAG = "DDImageMessage";
    public byte[] mImageData;
    public String mImagePath;
    public Uri mImageUri;
    public String mImageUrl;

    public DDImageMessage() {
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void attachContext(Context context) {
        Uri uri;
        if (context == null || (uri = this.mImageUri) == null) {
            return;
        }
        context.grantUriPermission(ShareConstant.DD_APP_PACKAGE, uri, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkArgs() {
        String str;
        String str2;
        byte[] bArr = this.mImageData;
        if ((bArr == null || bArr.length == 0) && (((str = this.mImagePath) == null || str.length() == 0) && (((str2 = this.mImageUrl) == null || str2.length() == 0) && this.mImageUri == null))) {
            return false;
        }
        byte[] bArr2 = this.mImageData;
        if (bArr2 != null && bArr2.length > MAX_IMAGE_DATA_LENGTH) {
            return false;
        }
        String str3 = this.mImagePath;
        if (str3 != null && str3.length() > MAX_IMAGE_URL_LENGTH) {
            return false;
        }
        String str4 = this.mImagePath;
        if (str4 != null) {
            if (str4.length() != 0) {
                File file = new File(str4);
                int length = !file.exists() ? 0 : (int) file.length();
                if (length > MAX_IMAGE_DATA_LENGTH) {
                    return false;
                }
            }
        }
        String str5 = this.mImageUrl;
        return str5 == null || str5.length() <= MAX_IMAGE_URL_LENGTH;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int getSupportVersion() {
        return ShareConstant.DINGDING_SDK_SHARE_VERSION_V1;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putByteArray(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_DATA, this.mImageData);
        bundle.putString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_PATH, this.mImagePath);
        bundle.putString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URL, this.mImageUrl);
        bundle.putParcelable(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URI, this.mImageUri);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mImageData = bundle.getByteArray(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_DATA);
        this.mImagePath = bundle.getString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_PATH);
        this.mImageUrl = bundle.getString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URL);
        this.mImageUri = (Uri) bundle.getParcelable(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URI);
    }

    public DDImageMessage(byte[] bArr) {
        this.mImageData = bArr;
    }

    public DDImageMessage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream);
            this.mImageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
