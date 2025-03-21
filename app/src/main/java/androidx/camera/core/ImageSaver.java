package androidx.camera.core;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class ImageSaver implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    final OnImageSavedCallback mCallback;
    private final Executor mExecutor;
    private final ImageProxy mImage;
    private final int mOrientation;

    @NonNull
    private final ImageCapture.OutputFileOptions mOutputFileOptions;

    /* renamed from: androidx.camera.core.ImageSaver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType = new int[ImageUtil.CodecFailedException.FailureType.values().length];

        static {
            try {
                $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.DECODE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface OnImageSavedCallback {
        void onError(SaveError saveError, String str, @Nullable Throwable th);

        void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults);
    }

    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    ImageSaver(ImageProxy imageProxy, @NonNull ImageCapture.OutputFileOptions outputFileOptions, int i2, Executor executor, OnImageSavedCallback onImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = i2;
        this.mCallback = onImageSavedCallback;
        this.mExecutor = executor;
    }

    private void copyTempFileToOutputStream(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private boolean copyTempFileToUri(@NonNull File file, @NonNull Uri uri) throws IOException {
        OutputStream openOutputStream = this.mOutputFileOptions.getContentResolver().openOutputStream(uri);
        if (openOutputStream == null) {
            if (openOutputStream != null) {
                openOutputStream.close();
            }
            return false;
        }
        try {
            copyTempFileToOutputStream(file, openOutputStream);
            if (openOutputStream == null) {
                return true;
            }
            openOutputStream.close();
            return true;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private boolean isSaveToFile() {
        return this.mOutputFileOptions.getFile() != null;
    }

    private boolean isSaveToMediaStore() {
        return (this.mOutputFileOptions.getSaveCollection() == null || this.mOutputFileOptions.getContentResolver() == null || this.mOutputFileOptions.getContentValues() == null) ? false : true;
    }

    private boolean isSaveToOutputStream() {
        return this.mOutputFileOptions.getOutputStream() != null;
    }

    private void postError(final SaveError saveError, final String str, @Nullable final Throwable th) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.e0
            @Override // java.lang.Runnable
            public final void run() {
                ImageSaver.this.a(saveError, str, th);
            }
        });
    }

    private void postSuccess(@Nullable final Uri uri) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.d0
            @Override // java.lang.Runnable
            public final void run() {
                ImageSaver.this.a(uri);
            }
        });
    }

    private void setUriPending(Uri uri, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", Integer.valueOf(i2));
            this.mOutputFileOptions.getContentResolver().update(uri, contentValues, null, null);
        }
    }

    public /* synthetic */ void a(Uri uri) {
        this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0156, code lost:
    
        if (r6 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0158, code lost:
    
        postError(r6, r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x015c, code lost:
    
        postSuccess(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x015f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0145, code lost:
    
        if (isSaveToFile() != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0153, code lost:
    
        if (isSaveToFile() != false) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.camera.core.ImageSaver] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r5v20, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.net.Uri] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.run():void");
    }

    public /* synthetic */ void a(SaveError saveError, String str, Throwable th) {
        this.mCallback.onError(saveError, str, th);
    }
}
