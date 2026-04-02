package androidx.camera.core;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageUtil;
import androidx.camera.core.impl.utils.Exif;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: renamed from: androidx.camera.core.ImageSaver$1, reason: invalid class name */
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
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    fileInputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, i2);
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
        OutputStream outputStreamOpenOutputStream = this.mOutputFileOptions.getContentResolver().openOutputStream(uri);
        if (outputStreamOpenOutputStream == null) {
            if (outputStreamOpenOutputStream != null) {
                outputStreamOpenOutputStream.close();
            }
            return false;
        }
        try {
            copyTempFileToOutputStream(file, outputStreamOpenOutputStream);
            if (outputStreamOpenOutputStream == null) {
                return true;
            }
            outputStreamOpenOutputStream.close();
            return true;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
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
                this.a.a(saveError, str, th);
            }
        });
    }

    private void postSuccess(@Nullable final Uri uri) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(uri);
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

    /* JADX WARN: Removed duplicated region for block: B:93:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Uri uriInsert;
        ImageUtil.CodecFailedException e2;
        SaveError saveError;
        String str;
        SaveError saveError2;
        String str2;
        ImageProxy imageProxy;
        try {
            File file = isSaveToFile() ? this.mOutputFileOptions.getFile() : File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
            Uri uri = null;
            Throwable th = null;
            Throwable th2 = null;
            uri = null;
            uri = null;
            uri = null;
            try {
                try {
                    imageProxy = this.mImage;
                } catch (ImageUtil.CodecFailedException e3) {
                    uriInsert = uri;
                    e2 = e3;
                } catch (IOException e4) {
                    e = e4;
                    uriInsert = uri;
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(ImageUtil.imageToJpegByteArray(this.mImage));
                        Exif exifCreateFromFile = Exif.createFromFile(file);
                        exifCreateFromFile.attachTimestamp();
                        if (this.mImage.getFormat() == 256) {
                            ByteBuffer buffer = this.mImage.getPlanes()[0].getBuffer();
                            buffer.rewind();
                            byte[] bArr = new byte[buffer.capacity()];
                            buffer.get(bArr);
                            exifCreateFromFile.setOrientation(Exif.createFromInputStream(new ByteArrayInputStream(bArr)).getOrientation());
                        } else {
                            exifCreateFromFile.rotate(this.mOrientation);
                        }
                        ImageCapture.Metadata metadata = this.mOutputFileOptions.getMetadata();
                        if (metadata.isReversedHorizontal()) {
                            exifCreateFromFile.flipHorizontally();
                        }
                        if (metadata.isReversedVertical()) {
                            exifCreateFromFile.flipVertically();
                        }
                        if (metadata.getLocation() != null) {
                            exifCreateFromFile.attachLocation(this.mOutputFileOptions.getMetadata().getLocation());
                        }
                        exifCreateFromFile.save();
                        if (isSaveToMediaStore()) {
                            uriInsert = this.mOutputFileOptions.getContentResolver().insert(this.mOutputFileOptions.getSaveCollection(), this.mOutputFileOptions.getContentValues());
                            try {
                                if (uriInsert == null) {
                                    saveError = SaveError.FILE_IO_FAILED;
                                    str = "Failed to insert URI.";
                                } else {
                                    setUriPending(uriInsert, 1);
                                    if (copyTempFileToUri(file, uriInsert)) {
                                        saveError = null;
                                        str = null;
                                    } else {
                                        saveError = SaveError.FILE_IO_FAILED;
                                        str = "Failed to save to URI.";
                                    }
                                    setUriPending(uriInsert, 0);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                uri = uriInsert;
                                try {
                                    throw th;
                                } catch (Throwable th4) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th5) {
                                        th.addSuppressed(th5);
                                    }
                                    throw th4;
                                }
                            }
                        } else {
                            if (isSaveToOutputStream()) {
                                copyTempFileToOutputStream(file, this.mOutputFileOptions.getOutputStream());
                            }
                            uriInsert = null;
                            saveError = null;
                            str = null;
                        }
                        try {
                            fileOutputStream.close();
                            if (imageProxy != null) {
                                try {
                                    imageProxy.close();
                                } catch (ImageUtil.CodecFailedException e5) {
                                    e2 = e5;
                                    int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType[e2.getFailureType().ordinal()];
                                    if (i2 == 1) {
                                        saveError2 = SaveError.ENCODE_FAILED;
                                        str2 = "Failed to encode mImage";
                                    } else if (i2 != 2) {
                                        saveError2 = SaveError.UNKNOWN;
                                        str2 = "Failed to transcode mImage";
                                    } else {
                                        saveError2 = SaveError.CROP_FAILED;
                                        str2 = "Failed to crop mImage";
                                    }
                                    saveError = saveError2;
                                    str = str2;
                                    th2 = e2;
                                    th = e2;
                                    if (!isSaveToFile()) {
                                    }
                                    if (saveError != null) {
                                    }
                                } catch (IOException e6) {
                                    e = e6;
                                    Throwable th6 = e;
                                    saveError = SaveError.FILE_IO_FAILED;
                                    str = "Failed to write or close the file";
                                    th2 = th6;
                                    th = th6;
                                    if (!isSaveToFile()) {
                                    }
                                    if (saveError != null) {
                                    }
                                }
                            }
                            if (saveError != null) {
                                postError(saveError, str, th);
                            } else {
                                postSuccess(uriInsert);
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            uri = uriInsert;
                            try {
                                throw th;
                            } catch (Throwable th8) {
                                if (imageProxy != null) {
                                    try {
                                        imageProxy.close();
                                    } catch (Throwable th9) {
                                        th.addSuppressed(th9);
                                    }
                                }
                                throw th8;
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    throw th;
                }
            } finally {
                if (!isSaveToFile()) {
                    file.delete();
                }
            }
        } catch (IOException e7) {
            postError(SaveError.FILE_IO_FAILED, "Failed to create temp file", e7);
        }
    }

    public /* synthetic */ void a(SaveError saveError, String str, Throwable th) {
        this.mCallback.onError(saveError, str, th);
    }
}
