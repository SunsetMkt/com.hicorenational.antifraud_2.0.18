package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageProxy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class ImageUtil {
    private static final String TAG = "ImageUtil";

    private ImageUtil() {
    }

    @Nullable
    public static Rect computeCropRectFromAspectRatio(@NonNull Size size, @NonNull Rational rational) {
        int round;
        int i2;
        int i3;
        int i4;
        if (!isAspectRatioValid(rational)) {
            return null;
        }
        int width = size.getWidth();
        int height = size.getHeight();
        float f2 = width;
        float f3 = height;
        float f4 = f2 / f3;
        int numerator = rational.getNumerator();
        int denominator = rational.getDenominator();
        if (rational.floatValue() > f4) {
            int round2 = Math.round((f2 / numerator) * denominator);
            i4 = (height - round2) / 2;
            i3 = round2;
            round = width;
            i2 = 0;
        } else {
            round = Math.round((f3 / denominator) * numerator);
            i2 = (width - round) / 2;
            i3 = height;
            i4 = 0;
        }
        return new Rect(i2, i4, round + i2, i3 + i4);
    }

    @NonNull
    public static byte[] cropByteArray(@NonNull byte[] bArr, @Nullable Rect rect) throws CodecFailedException {
        if (rect == null) {
            return bArr;
        }
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
            Bitmap decodeRegion = newInstance.decodeRegion(rect, new BitmapFactory.Options());
            newInstance.recycle();
            if (decodeRegion == null) {
                throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!decodeRegion.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)) {
                throw new CodecFailedException("Encode bitmap failed.", CodecFailedException.FailureType.ENCODE_FAILED);
            }
            decodeRegion.recycle();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        } catch (IllegalArgumentException e2) {
            throw new CodecFailedException("Decode byte array failed with illegal argument." + e2, CodecFailedException.FailureType.DECODE_FAILED);
        }
    }

    @Nullable
    public static byte[] imageToJpegByteArray(@NonNull ImageProxy imageProxy) throws CodecFailedException {
        if (imageProxy.getFormat() == 256) {
            return jpegImageToJpegByteArray(imageProxy);
        }
        if (imageProxy.getFormat() == 35) {
            return yuvImageToJpegByteArray(imageProxy);
        }
        String str = "Unrecognized image format: " + imageProxy.getFormat();
        return null;
    }

    private static Rational inverseRational(Rational rational) {
        return rational == null ? rational : new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static boolean isAspectRatioValid(@Nullable Rational rational) {
        return (rational == null || rational.floatValue() <= 0.0f || rational.isNaN()) ? false : true;
    }

    private static boolean isCropAspectRatioHasEffect(Size size, Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        float numerator = rational.getNumerator();
        float denominator = rational.getDenominator();
        return (height == Math.round((((float) width) / numerator) * denominator) && width == Math.round((((float) height) / denominator) * numerator)) ? false : true;
    }

    private static byte[] jpegImageToJpegByteArray(ImageProxy imageProxy) throws CodecFailedException {
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.get(bArr);
        return shouldCropImage(imageProxy) ? cropByteArray(bArr, imageProxy.getCropRect()) : bArr;
    }

    private static byte[] nv21ToJpeg(byte[] bArr, int i2, int i3, @Nullable Rect rect) throws CodecFailedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        YuvImage yuvImage = new YuvImage(bArr, 17, i2, i3, null);
        if (rect == null) {
            rect = new Rect(0, 0, i2, i3);
        }
        if (yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
    }

    @NonNull
    public static Rational rotate(@NonNull Rational rational, int i2) {
        return (i2 == 90 || i2 == 270) ? inverseRational(rational) : rational;
    }

    private static boolean shouldCropImage(ImageProxy imageProxy) {
        return !new Size(imageProxy.getCropRect().width(), imageProxy.getCropRect().height()).equals(new Size(imageProxy.getWidth(), imageProxy.getHeight()));
    }

    private static byte[] yuvImageToJpegByteArray(ImageProxy imageProxy) throws CodecFailedException {
        return nv21ToJpeg(yuv_420_888toNv21(imageProxy), imageProxy.getWidth(), imageProxy.getHeight(), shouldCropImage(imageProxy) ? imageProxy.getCropRect() : null);
    }

    private static byte[] yuv_420_888toNv21(ImageProxy imageProxy) {
        ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[0];
        ImageProxy.PlaneProxy planeProxy2 = imageProxy.getPlanes()[1];
        ImageProxy.PlaneProxy planeProxy3 = imageProxy.getPlanes()[2];
        ByteBuffer buffer = planeProxy.getBuffer();
        ByteBuffer buffer2 = planeProxy2.getBuffer();
        ByteBuffer buffer3 = planeProxy3.getBuffer();
        buffer.rewind();
        buffer2.rewind();
        buffer3.rewind();
        int remaining = buffer.remaining();
        byte[] bArr = new byte[((imageProxy.getWidth() * imageProxy.getHeight()) / 2) + remaining];
        int i2 = 0;
        for (int i3 = 0; i3 < imageProxy.getHeight(); i3++) {
            buffer.get(bArr, i2, imageProxy.getWidth());
            i2 += imageProxy.getWidth();
            buffer.position(Math.min(remaining, (buffer.position() - imageProxy.getWidth()) + planeProxy.getRowStride()));
        }
        int height = imageProxy.getHeight() / 2;
        int width = imageProxy.getWidth() / 2;
        int rowStride = planeProxy3.getRowStride();
        int rowStride2 = planeProxy2.getRowStride();
        int pixelStride = planeProxy3.getPixelStride();
        int pixelStride2 = planeProxy2.getPixelStride();
        byte[] bArr2 = new byte[rowStride];
        byte[] bArr3 = new byte[rowStride2];
        int i4 = i2;
        int i5 = 0;
        while (i5 < height) {
            buffer3.get(bArr2, 0, Math.min(rowStride, buffer3.remaining()));
            buffer2.get(bArr3, 0, Math.min(rowStride2, buffer2.remaining()));
            int i6 = i4;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < width; i9++) {
                int i10 = i6 + 1;
                bArr[i6] = bArr2[i7];
                i6 = i10 + 1;
                bArr[i10] = bArr3[i8];
                i7 += pixelStride;
                i8 += pixelStride2;
            }
            i5++;
            i4 = i6;
        }
        return bArr;
    }

    public static final class CodecFailedException extends Exception {
        private FailureType mFailureType;

        enum FailureType {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        CodecFailedException(String str) {
            super(str);
            this.mFailureType = FailureType.UNKNOWN;
        }

        @NonNull
        public FailureType getFailureType() {
            return this.mFailureType;
        }

        CodecFailedException(String str, FailureType failureType) {
            super(str);
            this.mFailureType = failureType;
        }
    }

    public static boolean isAspectRatioValid(@NonNull Size size, @Nullable Rational rational) {
        return rational != null && rational.floatValue() > 0.0f && isCropAspectRatioHasEffect(size, rational) && !rational.isNaN();
    }
}
