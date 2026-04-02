package cn.cloudwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import cn.cloudwalk.FaceInterface;
import cn.cloudwalk.callback.FaceInfoCallback;
import cn.cloudwalk.callback.ImageAnalyCallBack;
import cn.cloudwalk.callback.LivessCallBack;
import cn.cloudwalk.jni.FaceDetTrack;
import cn.cloudwalk.jni.FaceLivingImg;
import cn.cloudwalk.jni.FaceParam;
import cn.cloudwalk.util.AssetsManager;
import cn.cloudwalk.util.IOUtils;
import cn.cloudwalk.util.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class CloudwalkSDK {
    static final int BEST_FACE_INDEX = 3;
    private static final String FACE_DETECT_FILE_PATH = "live_model_20201218/faceDetector3_27_dpn";
    private static final String FACE_KEYPT_DETECT_FILE_PATH = "live_model_20201218/keypt_detect_model_sdm_9pts.bin";
    private static final String FACE_KEYPT_TRACK_FILE_PATH = "live_model_20201218/keypt_track_model_sdm_9pts.bin";
    private static final String FACE_LIVENESS_FILE_PATH = "live_model_20201218/liveness201209_attack119.dpn";
    private static final String FACE_QUALITY_FILE_PATH = "live_model_20201218/faceanalyze_20201221_quality15.dpn";
    private static final String MODEL_ASSETS_DIR = "live_model_20201218";
    static final int NEXT_FACE_INDEX = 2;
    private static final String TAG = "yc_CloudwalkSDK";
    private FaceInfoCallback faceInfoCallback;
    FaceLivingImg[] faceLivingImgs;
    int faceNum;
    private int frameAngle;
    int frameFormat;
    private int frameH;
    private int frameMirror;
    private int frameW;
    private LivessCallBack livessCallBack;
    int livessLevel;
    private volatile int livessType;
    private Frame mPreviewFrame;
    private long mStartTime;
    private DetectType mWorkType = DetectType.LIVE_DETECT;
    private int actionCount = 0;
    private volatile boolean mPushFrame = true;
    private Thread videoThread = null;
    private volatile boolean bDetecting = false;
    private PriorityBlockingQueue<Frame> mFrameQueue = new PriorityBlockingQueue<>();
    volatile int op = 4068;
    private volatile int stageflag = 1;
    FaceDetTrack faceDetTrack = new FaceDetTrack();

    /* JADX INFO: renamed from: cn.cloudwalk.CloudwalkSDK$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cn$cloudwalk$CloudwalkSDK$DetectType = new int[DetectType.values().length];

        static {
            try {
                $SwitchMap$cn$cloudwalk$CloudwalkSDK$DetectType[DetectType.LIVE_DETECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cn$cloudwalk$CloudwalkSDK$DetectType[DetectType.REATIME_ANALYZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum DetectType {
        LIVE_DETECT,
        REATIME_ANALYZE
    }

    private class Frame implements Comparable<Frame> {
        byte[] data;
        long time;

        public Frame(byte[] bArr, long j2) {
            this.data = bArr;
            this.time = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Frame frame) {
            long j2 = this.time;
            long j3 = frame.time;
            if (j2 < j3) {
                return 1;
            }
            return j2 > j3 ? -1 : 0;
        }
    }

    class VideoRecordRunnable implements Runnable {
        private PriorityBlockingQueue<Frame> mFrameQueue;

        public VideoRecordRunnable(PriorityBlockingQueue<Frame> priorityBlockingQueue) {
            this.mFrameQueue = priorityBlockingQueue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                if (!CloudwalkSDK.this.bDetecting) {
                    break;
                }
                try {
                    int i2 = AnonymousClass1.$SwitchMap$cn$cloudwalk$CloudwalkSDK$DetectType[CloudwalkSDK.this.mWorkType.ordinal()];
                    if (i2 != 1) {
                        if (i2 == 2) {
                            CloudwalkSDK.this.mPreviewFrame = this.mFrameQueue.take();
                            this.mFrameQueue.clear();
                            CloudwalkSDK.this.processVideoFrame(CloudwalkSDK.this.mPreviewFrame);
                        }
                    } else if (CloudwalkSDK.this.mPushFrame) {
                        CloudwalkSDK.this.mPreviewFrame = this.mFrameQueue.take();
                        this.mFrameQueue.clear();
                        CloudwalkSDK.this.processVideoFrame(CloudwalkSDK.this.mPreviewFrame);
                    }
                } catch (InterruptedException unused) {
                    if (!CloudwalkSDK.this.bDetecting) {
                        CloudwalkSDK.this.bDetecting = false;
                        CloudwalkSDK.this.cwReleaseDetector();
                    }
                }
            }
            CloudwalkSDK.this.cwReleaseDetector();
        }
    }

    private int abs(String str, int i2) {
        if (i2 == 0) {
            return 0;
        }
        cn.cloudwalk.util.TestLog.netE("ret", str + "\u53d8\u6362\u524dsfRet=" + i2);
        int iAbs = Math.abs(i2);
        cn.cloudwalk.util.TestLog.netE("ret", str + "\u53d8\u6362\u540eret=" + iAbs);
        return iAbs;
    }

    private Bitmap cwClipFaceBitmap(Bitmap bitmap, FaceLivingImg faceLivingImg) {
        return Bitmap.createBitmap(bitmap, (int) (((double) faceLivingImg.faceRectX) * 0.65d), (int) (((double) faceLivingImg.faceRectY) * 0.65d), (int) (((double) faceLivingImg.faceRectWidth) * 1.4d), (int) (((double) faceLivingImg.faceRectHeight) * 1.5d));
    }

    private FaceLivingImg[] cwGetFaceLivingImg() {
        return this.faceDetTrack.cwGetLivingImage();
    }

    private int cwStart() {
        this.bDetecting = true;
        this.faceLivingImgs = null;
        this.stageflag = 1;
        this.op = 4068;
        this.mPushFrame = true;
        if (this.videoThread != null) {
            cn.cloudwalk.util.TestLog.netd(TAG, "cwStart null != videoThread");
            return 0;
        }
        cn.cloudwalk.util.TestLog.netd(TAG, "cwStar null == videoThread");
        this.mFrameQueue.clear();
        this.videoThread = new Thread(new VideoRecordRunnable(this.mFrameQueue));
        this.videoThread.start();
        return 0;
    }

    private int cwStop() {
        this.bDetecting = false;
        this.faceLivingImgs = null;
        this.stageflag = 1;
        this.mFrameQueue.clear();
        cn.cloudwalk.util.TestLog.netd(TAG, "cwStop videoThread:" + this.videoThread + "bDetecting:" + this.bDetecting);
        Thread thread = this.videoThread;
        if (thread != null) {
            try {
                thread.interrupt();
                this.videoThread.join();
                this.videoThread = null;
                cn.cloudwalk.util.TestLog.netd(TAG, "cwStop videoThread null");
            } catch (Exception e2) {
                LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e2.getMessage());
                LogUtils.LOGE(TAG, "----cwStop exception:" + e2.getMessage());
            }
        }
        return 0;
    }

    private synchronized void detectCallBack(int i2) {
        Bitmap bitmapYuv2Img = IOUtils.yuv2Img(this.mPreviewFrame.data, 17, this.frameW, this.frameH, 95);
        Bitmap bitmapRotaingImageView = IOUtils.rotaingImageView(bitmapYuv2Img, this.frameAngle, this.frameMirror);
        if (this.livessCallBack != null) {
            if (bitmapRotaingImageView != null) {
                this.livessCallBack.detectLivess(i2, IOUtils.bitmapToByte(bitmapRotaingImageView, Bitmap.CompressFormat.JPEG));
            } else {
                this.livessCallBack.detectLivess(i2, null);
            }
        }
        if (bitmapYuv2Img != null) {
            IOUtils.recycleBitmap(bitmapYuv2Img);
        }
        if (bitmapRotaingImageView != null) {
            IOUtils.recycleBitmap(bitmapRotaingImageView);
        }
        this.livessType = 0;
    }

    private float maxPoint(float[] fArr) {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (fArr[i2] >= f2) {
                f2 = fArr[i2];
            }
        }
        return f2;
    }

    private float minPoint(float[] fArr) {
        float f2 = fArr[0];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (fArr[i2] <= f2) {
                f2 = fArr[i2];
            }
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processVideoFrame(Frame frame) {
        try {
            if (frame.data != null && this.bDetecting) {
                this.faceNum = 0;
                if (this.bDetecting || this.mPushFrame) {
                    int iCwFaceDetectTrack = cwFaceDetectTrack(frame.data, frame.time, this.frameW, this.frameH, this.frameFormat, this.frameAngle, this.frameMirror, this.op);
                    if (iCwFaceDetectTrack == 1) {
                        int i2 = this.actionCount;
                        this.actionCount = i2 - 1;
                        if (i2 == 0) {
                            this.faceLivingImgs = cwGetFaceLivingImg();
                        }
                    }
                    if (this.bDetecting || this.mPushFrame) {
                        doFaceInfo();
                        if (this.mPushFrame && this.mWorkType == DetectType.LIVE_DETECT) {
                            doLivessDetect(iCwFaceDetectTrack);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void cwClearBestFace() {
        this.faceLivingImgs = null;
    }

    public int cwDestory() {
        cwStop();
        synchronized (this) {
            this.faceInfoCallback = null;
            this.livessCallBack = null;
        }
        return 0;
    }

    public int cwFaceDetectTrack(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int iCwFaceDetectTrack = this.faceDetTrack.cwFaceDetectTrack(bArr, bArr.length, j2, i2, i3, i4, i5, i6, i7, this.stageflag);
        this.faceNum = this.faceDetTrack.mFaceNum;
        return iCwFaceDetectTrack;
    }

    public synchronized void cwFaceInfoCallback(FaceInfoCallback faceInfoCallback) {
        this.faceInfoCallback = faceInfoCallback;
    }

    public String cwGetBestInfo() {
        FaceLivingImg[] faceLivingImgArr = this.faceLivingImgs;
        if (faceLivingImgArr == null || faceLivingImgArr[3] == null) {
            this.faceLivingImgs = cwGetFaceLivingImg();
        }
        return IOUtils.cwGetFaceLivingImgInfo(this.faceLivingImgs[3]);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[PHI: r2
  0x0065: PHI (r2v3 android.graphics.Bitmap) = (r2v1 android.graphics.Bitmap), (r2v7 android.graphics.Bitmap), (r2v7 android.graphics.Bitmap) binds: [B:20:0x0041, B:11:0x002c, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] cwGetClipedBestFace() {
        Bitmap bitmapByteArrayBGRToBitmap;
        Bitmap bitmapCwClipFaceBitmap;
        FaceLivingImg[] faceLivingImgArr = this.faceLivingImgs;
        if (faceLivingImgArr == null || faceLivingImgArr[3] == null || faceLivingImgArr[3].livingImageData == null) {
            this.faceLivingImgs = cwGetFaceLivingImg();
        }
        try {
            bitmapByteArrayBGRToBitmap = IOUtils.byteArrayBGRToBitmap(this.faceLivingImgs[3].livingImageData, this.faceLivingImgs[3].livingImageW, this.faceLivingImgs[3].livingImageH);
        } catch (Exception e2) {
            e = e2;
            bitmapByteArrayBGRToBitmap = null;
        }
        if (bitmapByteArrayBGRToBitmap != null) {
            try {
            } catch (Exception e3) {
                e = e3;
                LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e.getMessage());
                LogUtils.LOGE(TAG, "----cwGetClipedBestFace exception:" + e.getMessage());
            }
            bitmapCwClipFaceBitmap = this.faceLivingImgs[3] != null ? cwClipFaceBitmap(bitmapByteArrayBGRToBitmap, this.faceLivingImgs[3]) : null;
        }
        byte[] bArrBitmapToByte = bitmapCwClipFaceBitmap != null ? IOUtils.bitmapToByte(bitmapCwClipFaceBitmap, Bitmap.CompressFormat.JPEG) : null;
        if (bitmapByteArrayBGRToBitmap != null) {
            IOUtils.recycleBitmap(bitmapByteArrayBGRToBitmap);
        }
        if (bitmapCwClipFaceBitmap != null) {
            IOUtils.recycleBitmap(bitmapCwClipFaceBitmap);
        }
        return bArrBitmapToByte;
    }

    public Bitmap cwGetIDFaceImage(Bitmap bitmap) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bitmap bitmapCwGetIDFaceImage = cwGetIDFaceImage(bitmap, 0);
        cn.cloudwalk.util.TestLog.netE("2222", "cwGetIDFaceImage" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return bitmapCwGetIDFaceImage;
    }

    public byte[] cwGetNextFace() {
        FaceLivingImg[] faceLivingImgArr = this.faceLivingImgs;
        if (faceLivingImgArr == null || faceLivingImgArr[2].livingImageData == null) {
            this.faceLivingImgs = cwGetFaceLivingImg();
        }
        Bitmap bitmapByteArrayBGRToBitmap = null;
        try {
            bitmapByteArrayBGRToBitmap = IOUtils.byteArrayBGRToBitmap(this.faceLivingImgs[2].livingImageData, this.faceLivingImgs[2].livingImageW, this.faceLivingImgs[2].livingImageH);
        } catch (Exception e2) {
            LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e2.getMessage());
            LogUtils.LOGE(TAG, "----cwGetNextFace exception:" + e2.getMessage());
        }
        byte[] bArrBitmapToByte = IOUtils.bitmapToByte(bitmapByteArrayBGRToBitmap, Bitmap.CompressFormat.JPEG);
        IOUtils.recycleBitmap(bitmapByteArrayBGRToBitmap);
        return bArrBitmapToByte;
    }

    public String cwGetNextInfo() {
        FaceLivingImg[] faceLivingImgArr = this.faceLivingImgs;
        if (faceLivingImgArr == null || faceLivingImgArr[2] == null || faceLivingImgArr[2].livingImageData == null) {
            this.faceLivingImgs = cwGetFaceLivingImg();
        }
        return IOUtils.cwGetFaceLivingImgInfo(this.faceLivingImgs[2]);
    }

    public byte[] cwGetOriBestFace() {
        FaceLivingImg[] faceLivingImgArr = this.faceLivingImgs;
        if (faceLivingImgArr == null || faceLivingImgArr[3] == null || faceLivingImgArr[3].livingImageData == null) {
            this.faceLivingImgs = cwGetFaceLivingImg();
        }
        Bitmap bitmapByteArrayBGRToBitmap = null;
        try {
            bitmapByteArrayBGRToBitmap = IOUtils.byteArrayBGRToBitmap(this.faceLivingImgs[3].livingImageData, this.faceLivingImgs[3].livingImageW, this.faceLivingImgs[3].livingImageH);
        } catch (Exception e2) {
            LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e2.getMessage());
            LogUtils.LOGE(TAG, "----cwGetOriBestFace exception:" + e2.getMessage());
        }
        byte[] bArrBitmapToByte = IOUtils.bitmapToByte(bitmapByteArrayBGRToBitmap, Bitmap.CompressFormat.JPEG);
        IOUtils.recycleBitmap(bitmapByteArrayBGRToBitmap);
        return bArrBitmapToByte;
    }

    public int cwGetParam(FaceParam faceParam) {
        return abs("cwGetParam", this.faceDetTrack.cwGetParam(faceParam));
    }

    public String cwGetVersionInfo() {
        return this.faceDetTrack.cwGetVersionInfo();
    }

    public void cwImageAnaly(Bitmap bitmap, ImageAnalyCallBack imageAnalyCallBack) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.faceNum = 0;
        this.faceDetTrack.cwFaceDetectTrack(byteArray, byteArray.length, System.currentTimeMillis() % 1000000, bitmap.getWidth(), bitmap.getHeight(), 6, 0, 0, 22, 1);
        FaceDetTrack faceDetTrack = this.faceDetTrack;
        this.faceNum = faceDetTrack.mFaceNum;
        if (imageAnalyCallBack != null) {
            imageAnalyCallBack.analyFaceInfo(faceDetTrack.faceInfos, this.faceNum);
        }
    }

    public int cwInit(Context context, String str) {
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator;
        AssetsManager.copyAsset(context, MODEL_ASSETS_DIR, str2);
        int iCwCreateDetectorFromFile = this.faceDetTrack.cwCreateDetectorFromFile(str2 + FACE_DETECT_FILE_PATH, str2 + FACE_KEYPT_DETECT_FILE_PATH, str2 + FACE_KEYPT_TRACK_FILE_PATH, str2 + FACE_QUALITY_FILE_PATH, str2 + FACE_LIVENESS_FILE_PATH, str, 0);
        this.mStartTime = 0L;
        if (iCwCreateDetectorFromFile == 0) {
            cwStart();
        }
        return iCwCreateDetectorFromFile;
    }

    public synchronized void cwLivessInfoCallback(LivessCallBack livessCallBack) {
        this.livessCallBack = livessCallBack;
    }

    public void cwPushFrame(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        this.frameW = i2;
        this.frameH = i3;
        this.frameFormat = i4;
        if (this.frameAngle != i5 || this.frameMirror != i6) {
            cn.cloudwalk.util.TestLog.netE(TAG, "\u6444\u50cf\u5934,\u5c4f\u5e55\u65b9\u5411\u53d8 \u89d2\u5ea6=" + i5 + "\u955c\u50cf=" + i6);
            cwClearBestFace();
        }
        this.frameAngle = i5;
        this.frameMirror = i6;
        if (cn.cloudwalk.util.TestLog.isDebug) {
            cn.cloudwalk.util.TestLog.frame++;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime == 0) {
            this.mStartTime = jCurrentTimeMillis;
        }
        try {
            int i7 = AnonymousClass1.$SwitchMap$cn$cloudwalk$CloudwalkSDK$DetectType[this.mWorkType.ordinal()];
            if (i7 != 1) {
                if (i7 != 2) {
                    return;
                }
                if (this.videoThread == null) {
                    this.mFrameQueue.clear();
                }
                this.mFrameQueue.put(new Frame(bArr, ((jCurrentTimeMillis - this.mStartTime) % 1000000) + 1));
                return;
            }
            if (!this.mPushFrame) {
                this.mFrameQueue.clear();
                return;
            }
            if (this.videoThread == null) {
                this.mFrameQueue.clear();
            }
            this.mFrameQueue.put(new Frame(bArr, ((jCurrentTimeMillis - this.mStartTime) % 1000000) + 1));
        } catch (Exception e2) {
            LogUtils.LOGE(TAG, "----cwPushFrame exception:" + e2.getMessage());
        }
    }

    public int cwReleaseDetector() {
        return abs("cwReleaseDetector", this.faceDetTrack.cwReleaseDetector());
    }

    public int cwResetLivenessTarget() {
        return abs("cwResetLivenessTarget", this.faceDetTrack.cwResetLivenessTarget());
    }

    @Deprecated
    public int cwResetLiving() {
        return 0;
    }

    @Deprecated
    public void cwSetLivessLevel(int i2) {
        this.livessLevel = i2;
    }

    public void cwStartLivess(int i2) {
        cn.cloudwalk.util.TestLog.netd(TAG, "StartLivess=" + i2);
        this.livessType = i2;
        if (i2 == 1000) {
            this.stageflag = 2;
            this.mFrameQueue.clear();
            this.mPushFrame = true;
            return;
        }
        if (i2 == 1001) {
            this.stageflag = 4;
            this.mFrameQueue.clear();
            this.mPushFrame = true;
        } else if (i2 == 1004) {
            this.stageflag = 8;
            this.mFrameQueue.clear();
            this.mPushFrame = true;
        } else {
            if (i2 != 1005) {
                return;
            }
            this.stageflag = 16;
            this.mFrameQueue.clear();
            this.mPushFrame = true;
        }
    }

    public void cwStopLivess() {
        this.livessType = -1;
        this.stageflag = 0;
        this.mFrameQueue.clear();
    }

    public int cwVerifyBestImg() {
        return this.faceDetTrack.cwVerifyBestImg();
    }

    public int cwsetParam(FaceParam faceParam) {
        return abs("cwsetParam", this.faceDetTrack.cwSetParam(faceParam));
    }

    void doFaceInfo() {
        this.faceNum = this.faceDetTrack.mFaceNum;
        synchronized (this) {
            if (this.faceInfoCallback != null) {
                this.faceInfoCallback.detectFaceInfo(this.faceDetTrack.faceInfos, this.faceNum);
            }
        }
    }

    void doLivessDetect(int i2) {
        if (i2 >= 20000) {
            synchronized (this) {
                if (this.livessCallBack != null) {
                    this.livessCallBack.detectInfo(i2);
                    if (this.stageflag != 0 && this.stageflag != 1 && i2 == 20002) {
                        this.livessCallBack.onActionNotStandard(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_NOPEOPLE);
                    }
                }
            }
            return;
        }
        if (i2 > 1) {
            synchronized (this) {
                if (this.livessCallBack != null) {
                    this.livessCallBack.detectInfo(i2);
                }
            }
            return;
        }
        if (i2 == 1) {
            this.mFrameQueue.clear();
            if (this.stageflag == 1) {
                synchronized (this) {
                    if (this.livessCallBack != null) {
                        this.livessCallBack.detectReady();
                    }
                }
                this.stageflag = 0;
                return;
            }
            if (this.stageflag == 2 || this.stageflag == 4 || this.stageflag == 8 || this.stageflag == 16 || this.stageflag == 32 || this.stageflag == 64) {
                dolivess();
                this.stageflag = 0;
                return;
            }
            return;
        }
        if (i2 != 0) {
            if (i2 < 0) {
                synchronized (this) {
                    if (this.livessCallBack != null) {
                        if (i2 == -4) {
                            this.livessCallBack.onActionNotStandard(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_ATTACK_PICTURE);
                        } else if (i2 == -7) {
                            this.livessCallBack.onActionNotStandard(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_PEOPLECHANGED);
                        } else {
                            this.livessCallBack.onActionNotStandard(i2);
                        }
                    }
                }
                return;
            }
            return;
        }
        if (this.stageflag == 1 || this.stageflag == 2 || this.stageflag == 4 || this.stageflag == 8 || this.stageflag == 16 || this.stageflag == 32 || this.stageflag == 64) {
            synchronized (this) {
                if (this.livessCallBack != null) {
                    this.livessCallBack.detectInfo(i2);
                }
            }
        }
    }

    void dolivess() {
        if (this.livessCallBack != null) {
            int i2 = this.livessType;
            if (i2 == 1000) {
                LogUtils.LOGI(TAG, "LivessType.LIVESS_HEAD_LEFT");
                detectCallBack(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADLEFT);
                return;
            }
            if (i2 == 1001) {
                LogUtils.LOGI(TAG, "LivessType.LIVESS_HEAD_RIGHT");
                detectCallBack(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADRIGHT);
            } else if (i2 == 1004) {
                LogUtils.LOGI(TAG, "LivessType.LIVESS_EYE");
                detectCallBack(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_BLINK);
            } else {
                if (i2 != 1005) {
                    return;
                }
                LogUtils.LOGI(TAG, "LivessType.LIVESS_MOUTH");
                detectCallBack(600);
            }
        }
    }

    public int getLogInfo() {
        return this.faceDetTrack.getLogInfo();
    }

    double getScale(int i2, int i3, int i4, double d2) {
        while (((double) i2) + (((double) i3) * d2) > i4) {
            d2 -= 0.1d;
        }
        return d2;
    }

    public void setActionCount(int i2) {
        this.actionCount = i2;
    }

    public int setLog(boolean z) {
        return this.faceDetTrack.setLog(z);
    }

    public int setLogAndSaveImage(boolean z, String str, boolean z2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return this.faceDetTrack.setLogAndSaveImage(z, str, z2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public void setOperator(int i2) {
        this.op = i2;
    }

    public void setPushFrame(boolean z) {
        this.mPushFrame = z;
    }

    public void setStageflag(int i2) {
        this.stageflag = i2;
        this.mPushFrame = true;
        this.mFrameQueue.clear();
    }

    public void setWorkType(DetectType detectType) {
        this.mWorkType = detectType;
    }

    private Bitmap cwGetIDFaceImage(Bitmap bitmap, int i2) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.faceNum = 0;
            this.faceDetTrack.cwFaceDetectTrack(byteArray, byteArray.length, System.currentTimeMillis() % 1000000, bitmap.getWidth(), bitmap.getHeight(), 6, i2, 0, 4, 0);
            this.faceNum = this.faceDetTrack.mFaceNum;
            if (this.faceNum <= 0 || this.faceDetTrack.faceInfos == null) {
                return null;
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            int i3 = this.faceDetTrack.faceInfos[0].x;
            int i4 = this.faceDetTrack.faceInfos[0].y;
            int i5 = this.faceDetTrack.faceInfos[0].width;
            int i6 = this.faceDetTrack.faceInfos[0].height;
            int i7 = i3 - (i5 / 4) > 0 ? i3 - (i5 / 4) : 0;
            int i8 = i4 - (i6 / 2) > 0 ? i4 - (i6 / 2) : 0;
            return Bitmap.createBitmap(bitmap, i7, i8, (int) (((double) i5) * getScale(i7, i5, width, 1.5d)), (int) (((double) i6) * getScale(i8, i6, height, 2.0d)));
        } catch (Exception e2) {
            LogUtils.LOGE(TAG, "----cwGetIDFaceImage exception:" + e2.getMessage());
            return null;
        }
    }
}
