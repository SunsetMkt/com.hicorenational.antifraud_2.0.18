package com.luck.picture.lib.compress;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.DESUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Luban implements Handler.Callback {
    private static final int MSG_COMPRESS_ERROR = 2;
    private static final int MSG_COMPRESS_START = 1;
    private static final int MSG_COMPRESS_SUCCESS = 0;
    private static final String TAG = "Luban";
    private int compressQuality;
    private boolean focusAlpha;
    private int index;
    private boolean isAndroidQ;
    private boolean isCamera;
    private OnCompressListener mCompressListener;
    private CompressionPredicate mCompressionPredicate;
    private Handler mHandler;
    private int mLeastCompressSize;
    private String mNewFileName;
    private List<String> mPaths;
    private OnRenameListener mRenameListener;
    private List<InputStreamProvider> mStreamProviders;
    private String mTargetDir;
    private List<LocalMedia> mediaList;

    public static class Builder {
        private int compressQuality;
        private Context context;
        private boolean focusAlpha;
        private boolean isCamera;
        private OnCompressListener mCompressListener;
        private CompressionPredicate mCompressionPredicate;
        private String mNewFileName;
        private OnRenameListener mRenameListener;
        private String mTargetDir;
        private int mLeastCompressSize = 100;
        private List<String> mPaths = new ArrayList();
        private List<LocalMedia> mediaList = new ArrayList();
        private List<InputStreamProvider> mStreamProviders = new ArrayList();
        private boolean isAndroidQ = SdkVersionUtils.checkedAndroid_Q();

        Builder(Context context) {
            this.context = context;
        }

        private Luban build() {
            return new Luban(this);
        }

        public Builder filter(CompressionPredicate compressionPredicate) {
            this.mCompressionPredicate = compressionPredicate;
            return this;
        }

        public File get(final String str) throws IOException {
            return build().get(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.5
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return str;
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(str);
                }
            }, this.context);
        }

        public Builder ignoreBy(int i2) {
            this.mLeastCompressSize = i2;
            return this;
        }

        public Builder isCamera(boolean z) {
            this.isCamera = z;
            return this;
        }

        public void launch() {
            build().launch(this.context);
        }

        public Builder load(InputStreamProvider inputStreamProvider) {
            this.mStreamProviders.add(inputStreamProvider);
            return this;
        }

        public <T> Builder loadMediaData(List<LocalMedia> list) {
            this.mediaList = list;
            Iterator<LocalMedia> it = list.iterator();
            while (it.hasNext()) {
                load(it.next());
            }
            return this;
        }

        public Builder putGear(int i2) {
            return this;
        }

        public Builder setCompressListener(OnCompressListener onCompressListener) {
            this.mCompressListener = onCompressListener;
            return this;
        }

        public Builder setCompressQuality(int i2) {
            this.compressQuality = i2;
            return this;
        }

        public Builder setFocusAlpha(boolean z) {
            this.focusAlpha = z;
            return this;
        }

        public Builder setNewCompressFileName(String str) {
            this.mNewFileName = str;
            return this;
        }

        @Deprecated
        public Builder setRenameListener(OnRenameListener onRenameListener) {
            this.mRenameListener = onRenameListener;
            return this;
        }

        public Builder setTargetDir(String str) {
            this.mTargetDir = str;
            return this;
        }

        private Builder load(final LocalMedia localMedia) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.1
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return localMedia;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return localMedia.isCut() ? localMedia.getCutPath() : TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? localMedia.getPath() : localMedia.getAndroidQToPath();
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    if (!PictureMimeType.isContent(localMedia.getPath()) || localMedia.isCut()) {
                        return new FileInputStream(localMedia.isCut() ? localMedia.getCutPath() : localMedia.getPath());
                    }
                    return !TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? new FileInputStream(localMedia.getAndroidQToPath()) : Builder.this.context.getContentResolver().openInputStream(Uri.parse(localMedia.getPath()));
                }
            });
            return this;
        }

        public List<File> get() throws IOException {
            return build().get(this.context);
        }

        public Builder load(final Uri uri) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.2
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return uri.getPath();
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return Builder.this.context.getContentResolver().openInputStream(uri);
                }
            });
            return this;
        }

        public Builder load(final File file) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.3
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return file.getAbsolutePath();
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(file);
                }
            });
            return this;
        }

        public Builder load(final String str) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.luck.picture.lib.compress.Luban.Builder.4
                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.luck.picture.lib.compress.InputStreamProvider
                public String getPath() {
                    return str;
                }

                @Override // com.luck.picture.lib.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(str);
                }
            });
            return this;
        }

        public <T> Builder load(List<T> list) {
            for (T t : list) {
                if (t instanceof String) {
                    load((String) t);
                } else if (t instanceof File) {
                    load((File) t);
                } else if (t instanceof Uri) {
                    load((Uri) t);
                } else {
                    throw new IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
                }
            }
            return this;
        }
    }

    private File compress(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        try {
            return compressRealLocalMedia(context, inputStreamProvider);
        } finally {
            inputStreamProvider.close();
        }
    }

    private File compressReal(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        String extSuffix = Checker.SINGLE.extSuffix(inputStreamProvider.getMedia() != null ? inputStreamProvider.getMedia().getMimeType() : "");
        if (TextUtils.isEmpty(extSuffix)) {
            extSuffix = Checker.SINGLE.extSuffix(inputStreamProvider);
        }
        File imageCacheFile = getImageCacheFile(context, inputStreamProvider, extSuffix);
        OnRenameListener onRenameListener = this.mRenameListener;
        if (onRenameListener != null) {
            imageCacheFile = getImageCustomFile(context, onRenameListener.rename(inputStreamProvider.getPath()));
        }
        CompressionPredicate compressionPredicate = this.mCompressionPredicate;
        return compressionPredicate != null ? (compressionPredicate.apply(inputStreamProvider.getPath()) && Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath())) ? new Engine(inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality).compress() : new File(inputStreamProvider.getPath()) : Checker.SINGLE.extSuffix(inputStreamProvider).startsWith(".gif") ? new File(inputStreamProvider.getPath()) : Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath()) ? new Engine(inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality).compress() : new File(inputStreamProvider.getPath());
    }

    private File compressRealLocalMedia(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        String str;
        File file;
        LocalMedia media = inputStreamProvider.getMedia();
        if (media == null) {
            throw new NullPointerException("Luban Compress LocalMedia Can't be empty");
        }
        String realPath = this.isAndroidQ ? !TextUtils.isEmpty(media.getRealPath()) ? media.getRealPath() : PictureFileUtils.getPath(context, Uri.parse(inputStreamProvider.getPath())) : inputStreamProvider.getPath();
        String extSuffix = Checker.SINGLE.extSuffix(media.getMimeType());
        if (TextUtils.isEmpty(extSuffix)) {
            extSuffix = Checker.SINGLE.extSuffix(inputStreamProvider);
        }
        File imageCacheFile = getImageCacheFile(context, inputStreamProvider, extSuffix);
        if (TextUtils.isEmpty(this.mNewFileName)) {
            str = "";
        } else {
            String rename = this.isCamera ? this.mNewFileName : StringUtils.rename(this.mNewFileName);
            str = rename;
            imageCacheFile = getImageCustomFile(context, rename);
        }
        if (imageCacheFile.exists()) {
            return imageCacheFile;
        }
        if (this.mCompressionPredicate != null) {
            if (Checker.SINGLE.extSuffix(inputStreamProvider).startsWith(".gif")) {
                if (this.isAndroidQ) {
                    return new File(media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str));
                }
                return new File(realPath);
            }
            if (this.mCompressionPredicate.apply(realPath) && Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, realPath)) {
                return new Engine(inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality).compress();
            }
            if (this.isAndroidQ) {
                return new File(media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str));
            }
            return new File(realPath);
        }
        if (Checker.SINGLE.extSuffix(inputStreamProvider).startsWith(".gif")) {
            if (this.isAndroidQ) {
                return new File(media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str));
            }
            return new File(realPath);
        }
        if (Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, realPath)) {
            file = new Engine(inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality).compress();
        } else {
            if (this.isAndroidQ) {
                return new File(media.isCut() ? media.getCutPath() : (String) Objects.requireNonNull(AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str)));
            }
            file = new File(realPath);
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File get(InputStreamProvider inputStreamProvider, Context context) throws IOException {
        try {
            return new Engine(inputStreamProvider, getImageCacheFile(context, inputStreamProvider, Checker.SINGLE.extSuffix(inputStreamProvider)), this.focusAlpha, this.compressQuality).compress();
        } finally {
            inputStreamProvider.close();
        }
    }

    private static File getImageCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            Log.isLoggable(TAG, 6);
            return null;
        }
        if (externalFilesDir.mkdirs() || (externalFilesDir.exists() && externalFilesDir.isDirectory())) {
            return externalFilesDir;
        }
        return null;
    }

    private File getImageCacheFile(Context context, InputStreamProvider inputStreamProvider, String str) {
        String str2;
        File imageCacheDir;
        if (TextUtils.isEmpty(this.mTargetDir) && (imageCacheDir = getImageCacheDir(context)) != null) {
            this.mTargetDir = imageCacheDir.getAbsolutePath();
        }
        try {
            LocalMedia media = inputStreamProvider.getMedia();
            String encode = DESUtils.encode(DESUtils.DES_KEY_STRING, media.getPath(), media.getWidth(), media.getHeight());
            if (TextUtils.isEmpty(encode)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.mTargetDir);
                sb.append("/");
                sb.append(DateUtils.getCreateFileName("IMG_"));
                if (TextUtils.isEmpty(str)) {
                    str = ".jpg";
                }
                sb.append(str);
                str2 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mTargetDir);
                sb2.append("/");
                sb2.append("IMG_");
                sb2.append(encode.toUpperCase());
                if (TextUtils.isEmpty(str)) {
                    str = ".jpg";
                }
                sb2.append(str);
                str2 = sb2.toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            str2 = "";
        }
        return new File(str2);
    }

    private File getImageCustomFile(Context context, String str) {
        if (TextUtils.isEmpty(this.mTargetDir)) {
            this.mTargetDir = getImageCacheDir(context).getAbsolutePath();
        }
        return new File(this.mTargetDir + "/" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launch(final Context context) {
        List<InputStreamProvider> list = this.mStreamProviders;
        if (list == null || this.mPaths == null || (list.size() == 0 && this.mCompressListener != null)) {
            this.mCompressListener.onError(new NullPointerException("image file cannot be null"));
        }
        Iterator<InputStreamProvider> it = this.mStreamProviders.iterator();
        this.index = -1;
        while (it.hasNext()) {
            final InputStreamProvider next = it.next();
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: com.luck.picture.lib.compress.a
                @Override // java.lang.Runnable
                public final void run() {
                    Luban.this.a(next, context);
                }
            });
            it.remove();
        }
    }

    public static Builder with(Context context) {
        return new Builder(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1 A[Catch: IOException -> 0x00e8, TryCatch #0 {IOException -> 0x00e8, blocks: (B:3:0x0001, B:5:0x001c, B:7:0x002a, B:9:0x003d, B:10:0x006d, B:12:0x0071, B:14:0x0079, B:18:0x009b, B:22:0x00a3, B:23:0x00aa, B:25:0x00b1, B:26:0x00b7, B:30:0x00c9, B:38:0x00d7, B:40:0x004b, B:41:0x0050, B:43:0x005e, B:44:0x0068), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9 A[Catch: IOException -> 0x00e8, TryCatch #0 {IOException -> 0x00e8, blocks: (B:3:0x0001, B:5:0x001c, B:7:0x002a, B:9:0x003d, B:10:0x006d, B:12:0x0071, B:14:0x0079, B:18:0x009b, B:22:0x00a3, B:23:0x00aa, B:25:0x00b1, B:26:0x00b7, B:30:0x00c9, B:38:0x00d7, B:40:0x004b, B:41:0x0050, B:43:0x005e, B:44:0x0068), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void a(com.luck.picture.lib.compress.InputStreamProvider r7, android.content.Context r8) {
        /*
            r6 = this;
            r0 = 2
            int r1 = r6.index     // Catch: java.io.IOException -> Le8
            r2 = 1
            int r1 = r1 + r2
            r6.index = r1     // Catch: java.io.IOException -> Le8
            android.os.Handler r1 = r6.mHandler     // Catch: java.io.IOException -> Le8
            android.os.Handler r3 = r6.mHandler     // Catch: java.io.IOException -> Le8
            android.os.Message r3 = r3.obtainMessage(r2)     // Catch: java.io.IOException -> Le8
            r1.sendMessage(r3)     // Catch: java.io.IOException -> Le8
            com.luck.picture.lib.entity.LocalMedia r1 = r7.getMedia()     // Catch: java.io.IOException -> Le8
            boolean r1 = r1.isCompressed()     // Catch: java.io.IOException -> Le8
            if (r1 == 0) goto L50
            com.luck.picture.lib.entity.LocalMedia r1 = r7.getMedia()     // Catch: java.io.IOException -> Le8
            java.lang.String r1 = r1.getCompressPath()     // Catch: java.io.IOException -> Le8
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.io.IOException -> Le8
            if (r1 != 0) goto L50
            java.io.File r1 = new java.io.File     // Catch: java.io.IOException -> Le8
            com.luck.picture.lib.entity.LocalMedia r3 = r7.getMedia()     // Catch: java.io.IOException -> Le8
            java.lang.String r3 = r3.getCompressPath()     // Catch: java.io.IOException -> Le8
            r1.<init>(r3)     // Catch: java.io.IOException -> Le8
            boolean r1 = r1.exists()     // Catch: java.io.IOException -> Le8
            if (r1 == 0) goto L4b
            java.io.File r8 = new java.io.File     // Catch: java.io.IOException -> Le8
            com.luck.picture.lib.entity.LocalMedia r7 = r7.getMedia()     // Catch: java.io.IOException -> Le8
            java.lang.String r7 = r7.getCompressPath()     // Catch: java.io.IOException -> Le8
            r8.<init>(r7)     // Catch: java.io.IOException -> Le8
            goto L6d
        L4b:
            java.io.File r8 = r6.compress(r8, r7)     // Catch: java.io.IOException -> Le8
            goto L6d
        L50:
            com.luck.picture.lib.entity.LocalMedia r1 = r7.getMedia()     // Catch: java.io.IOException -> Le8
            java.lang.String r1 = r1.getMimeType()     // Catch: java.io.IOException -> Le8
            boolean r1 = com.luck.picture.lib.config.PictureMimeType.eqVideo(r1)     // Catch: java.io.IOException -> Le8
            if (r1 == 0) goto L68
            java.io.File r8 = new java.io.File     // Catch: java.io.IOException -> Le8
            java.lang.String r7 = r7.getPath()     // Catch: java.io.IOException -> Le8
            r8.<init>(r7)     // Catch: java.io.IOException -> Le8
            goto L6d
        L68:
            java.io.File r7 = r6.compress(r8, r7)     // Catch: java.io.IOException -> Le8
            r8 = r7
        L6d:
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r7 = r6.mediaList     // Catch: java.io.IOException -> Le8
            if (r7 == 0) goto Ld7
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r7 = r6.mediaList     // Catch: java.io.IOException -> Le8
            int r7 = r7.size()     // Catch: java.io.IOException -> Le8
            if (r7 <= 0) goto Ld7
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r7 = r6.mediaList     // Catch: java.io.IOException -> Le8
            int r1 = r6.index     // Catch: java.io.IOException -> Le8
            java.lang.Object r7 = r7.get(r1)     // Catch: java.io.IOException -> Le8
            com.luck.picture.lib.entity.LocalMedia r7 = (com.luck.picture.lib.entity.LocalMedia) r7     // Catch: java.io.IOException -> Le8
            java.lang.String r1 = r8.getAbsolutePath()     // Catch: java.io.IOException -> Le8
            boolean r1 = com.luck.picture.lib.config.PictureMimeType.isHttp(r1)     // Catch: java.io.IOException -> Le8
            java.lang.String r3 = r7.getMimeType()     // Catch: java.io.IOException -> Le8
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.eqVideo(r3)     // Catch: java.io.IOException -> Le8
            r4 = 0
            if (r1 != 0) goto L9a
            if (r3 != 0) goto L9a
            r5 = 1
            goto L9b
        L9a:
            r5 = 0
        L9b:
            r7.setCompressed(r5)     // Catch: java.io.IOException -> Le8
            if (r1 != 0) goto La8
            if (r3 == 0) goto La3
            goto La8
        La3:
            java.lang.String r8 = r8.getAbsolutePath()     // Catch: java.io.IOException -> Le8
            goto Laa
        La8:
            java.lang.String r8 = ""
        Laa:
            r7.setCompressPath(r8)     // Catch: java.io.IOException -> Le8
            boolean r8 = r6.isAndroidQ     // Catch: java.io.IOException -> Le8
            if (r8 == 0) goto Lb6
            java.lang.String r8 = r7.getCompressPath()     // Catch: java.io.IOException -> Le8
            goto Lb7
        Lb6:
            r8 = 0
        Lb7:
            r7.setAndroidQToPath(r8)     // Catch: java.io.IOException -> Le8
            int r7 = r6.index     // Catch: java.io.IOException -> Le8
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r8 = r6.mediaList     // Catch: java.io.IOException -> Le8
            int r8 = r8.size()     // Catch: java.io.IOException -> Le8
            int r8 = r8 - r2
            if (r7 != r8) goto Lc6
            goto Lc7
        Lc6:
            r2 = 0
        Lc7:
            if (r2 == 0) goto Lf2
            android.os.Handler r7 = r6.mHandler     // Catch: java.io.IOException -> Le8
            android.os.Handler r8 = r6.mHandler     // Catch: java.io.IOException -> Le8
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r1 = r6.mediaList     // Catch: java.io.IOException -> Le8
            android.os.Message r8 = r8.obtainMessage(r4, r1)     // Catch: java.io.IOException -> Le8
            r7.sendMessage(r8)     // Catch: java.io.IOException -> Le8
            goto Lf2
        Ld7:
            android.os.Handler r7 = r6.mHandler     // Catch: java.io.IOException -> Le8
            android.os.Handler r8 = r6.mHandler     // Catch: java.io.IOException -> Le8
            java.io.IOException r1 = new java.io.IOException     // Catch: java.io.IOException -> Le8
            r1.<init>()     // Catch: java.io.IOException -> Le8
            android.os.Message r8 = r8.obtainMessage(r0, r1)     // Catch: java.io.IOException -> Le8
            r7.sendMessage(r8)     // Catch: java.io.IOException -> Le8
            goto Lf2
        Le8:
            r7 = move-exception
            android.os.Handler r8 = r6.mHandler
            android.os.Message r7 = r8.obtainMessage(r0, r7)
            r8.sendMessage(r7)
        Lf2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.compress.Luban.a(com.luck.picture.lib.compress.InputStreamProvider, android.content.Context):void");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        OnCompressListener onCompressListener = this.mCompressListener;
        if (onCompressListener == null) {
            return false;
        }
        int i2 = message.what;
        if (i2 == 0) {
            onCompressListener.onSuccess((List) message.obj);
        } else if (i2 == 1) {
            onCompressListener.onStart();
        } else if (i2 == 2) {
            onCompressListener.onError((Throwable) message.obj);
        }
        return false;
    }

    private Luban(Builder builder) {
        this.index = -1;
        this.mPaths = builder.mPaths;
        this.mediaList = builder.mediaList;
        this.mTargetDir = builder.mTargetDir;
        this.mNewFileName = builder.mNewFileName;
        this.mRenameListener = builder.mRenameListener;
        this.mStreamProviders = builder.mStreamProviders;
        this.mCompressListener = builder.mCompressListener;
        this.mLeastCompressSize = builder.mLeastCompressSize;
        this.mCompressionPredicate = builder.mCompressionPredicate;
        this.compressQuality = builder.compressQuality;
        this.focusAlpha = builder.focusAlpha;
        this.isCamera = builder.isCamera;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.isAndroidQ = builder.isAndroidQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> get(Context context) throws IOException {
        File compress;
        ArrayList arrayList = new ArrayList();
        Iterator<InputStreamProvider> it = this.mStreamProviders.iterator();
        while (it.hasNext()) {
            InputStreamProvider next = it.next();
            if (next.getMedia().isCompressed() && !TextUtils.isEmpty(next.getMedia().getCompressPath())) {
                if (new File(next.getMedia().getCompressPath()).exists()) {
                    compress = new File(next.getMedia().getCompressPath());
                } else {
                    compress = compress(context, next);
                }
                arrayList.add(compress);
            } else {
                arrayList.add(PictureMimeType.eqVideo(next.getMedia().getMimeType()) ? new File(next.getMedia().getPath()) : compress(context, next));
            }
            it.remove();
        }
        return arrayList;
    }
}
