package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.sina.weibo.BuildConfig;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.b.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends AsyncTask<WeiboMultiMessage, Void, c> {
    private WeakReference<Context> B;
    private b C;

    public d(Context context, b bVar) {
        this.B = new WeakReference<>(context);
        this.C = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012c  */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
        WeiboMultiMessage weiboMultiMessage;
        Uri uri;
        Context context = this.B.get();
        if (context == null || (weiboMultiMessage = weiboMultiMessageArr[0]) == null) {
            return null;
        }
        a.C0109a c0109aE = com.sina.weibo.sdk.b.a.e(context);
        String str = c0109aE != null ? c0109aE.packageName : "";
        if (TextUtils.isEmpty(str)) {
            str = BuildConfig.APPLICATION_ID;
        }
        c cVar = new c();
        try {
            if (weiboMultiMessage.imageObject != null && weiboMultiMessage.multiImageObject != null) {
                weiboMultiMessage.imageObject = null;
            }
            if (weiboMultiMessage.videoSourceObject != null && (weiboMultiMessage.imageObject != null || weiboMultiMessage.multiImageObject != null)) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            if (weiboMultiMessage.multiImageObject != null) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                for (Uri uri2 : weiboMultiMessage.multiImageObject.getImageList()) {
                    if (uri2 != null) {
                        String strA = com.sina.weibo.sdk.b.b.a(context, uri2);
                        if (TextUtils.isEmpty(strA)) {
                            throw new IllegalArgumentException("get image path is null");
                        }
                        File file = new File(strA);
                        if (!com.sina.weibo.sdk.b.b.c(file)) {
                            String strB = com.sina.weibo.sdk.b.b.b(file);
                            boolean z = !TextUtils.isEmpty(strB) && strB.startsWith("image/");
                            if (!z) {
                                continue;
                            } else if (Build.VERSION.SDK_INT >= 24) {
                                arrayList.add(uri2);
                                context.grantUriPermission(str, uri2, 1);
                            } else {
                                String strA2 = a.a(context, uri2, 1);
                                if (TextUtils.isEmpty(strA2)) {
                                    throw new IllegalArgumentException("image's path is null");
                                }
                                arrayList.add(Uri.fromFile(new File(strA2)));
                            }
                        }
                    }
                }
                weiboMultiMessage.multiImageObject.imageList = arrayList;
            }
        } catch (Throwable th) {
            cVar.z = false;
            String message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = th.toString();
            }
            cVar.errorMessage = message;
            com.sina.weibo.sdk.b.c.b("WBShareTag", "prepare resource error is :".concat(String.valueOf(message)));
        }
        if (weiboMultiMessage.videoSourceObject != null && (uri = weiboMultiMessage.videoSourceObject.videoPath) != null) {
            String strA3 = com.sina.weibo.sdk.b.b.a(context, uri);
            if (TextUtils.isEmpty(strA3)) {
                throw new IllegalArgumentException("get video path is null");
            }
            File file2 = new File(strA3);
            if (!com.sina.weibo.sdk.b.b.c(file2)) {
                String mimeTypeFromExtension = "*/*";
                String name = file2.getName();
                int iLastIndexOf = name.lastIndexOf(".");
                if (iLastIndexOf >= 0) {
                    String strSubstring = name.substring(iLastIndexOf);
                    if (!TextUtils.isEmpty(strSubstring) || strSubstring.length() >= 2) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(strSubstring.substring(1).toLowerCase());
                    }
                }
                boolean z2 = !TextUtils.isEmpty(mimeTypeFromExtension) && mimeTypeFromExtension.startsWith("video/");
                if (z2) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        weiboMultiMessage.videoSourceObject.videoPath = uri;
                        weiboMultiMessage.videoSourceObject.during = com.sina.weibo.sdk.b.b.e(com.sina.weibo.sdk.b.b.b(context, uri));
                        context.grantUriPermission(str, weiboMultiMessage.videoSourceObject.videoPath, 1);
                    } else {
                        String strA4 = a.a(context, uri, 0);
                        com.sina.weibo.sdk.b.c.a("WBShareTag", "prepare video resource and video'path is".concat(String.valueOf(strA4)));
                        if (TextUtils.isEmpty(strA4)) {
                            throw new IllegalArgumentException("video's path is null");
                        }
                        weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(strA4));
                        weiboMultiMessage.videoSourceObject.during = com.sina.weibo.sdk.b.b.e(strA4);
                    }
                }
            }
            return cVar;
        }
        cVar.A = weiboMultiMessage;
        cVar.z = true;
        return cVar;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(c cVar) {
        c cVar2 = cVar;
        super.onPostExecute(cVar2);
        b bVar = this.C;
        if (bVar != null) {
            bVar.a(cVar2);
        }
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        super.onPreExecute();
    }
}
