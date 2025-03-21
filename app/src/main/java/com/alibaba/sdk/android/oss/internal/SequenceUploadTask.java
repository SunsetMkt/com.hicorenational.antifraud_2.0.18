package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new ArrayList();
        this.mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void checkException() throws IOException, ServiceException, ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else {
                List<PartETag> list = this.mPartETags;
                if (list != null && list.size() > 0 && this.mCheckCRC64 && ((ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                    HashMap hashMap = new HashMap();
                    for (PartETag partETag : this.mPartETags) {
                        hashMap.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
                    }
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        try {
                            this.mCRC64RecordFile = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                            if (!this.mCRC64RecordFile.exists()) {
                                this.mCRC64RecordFile.createNewFile();
                            }
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.mCRC64RecordFile));
                            try {
                                objectOutputStream2.writeObject(hashMap);
                                objectOutputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                OSSLog.logThrowable2Local(e);
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                super.checkException();
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream = objectOutputStream2;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
            }
        }
        super.checkException();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0182 A[Catch: ClientException -> 0x01ed, ServiceException -> 0x01ef, TryCatch #6 {ClientException -> 0x01ed, ServiceException -> 0x01ef, blocks: (B:34:0x0169, B:35:0x017c, B:37:0x0182, B:39:0x019e, B:41:0x01a4, B:43:0x01b2, B:44:0x01c7, B:46:0x01e4), top: B:33:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023d  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        /*
            Method dump skipped, instructions count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.initMultipartUploadId():void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mIsCancel) {
            return;
        }
        this.mIsCancel = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0165 A[Catch: all -> 0x01bc, TryCatch #15 {all -> 0x01bc, blocks: (B:57:0x013f, B:37:0x015d, B:39:0x0165, B:48:0x0169, B:50:0x0183, B:51:0x01a1), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ae A[Catch: IOException -> 0x0148, TRY_ENTER, TryCatch #7 {IOException -> 0x0148, blocks: (B:26:0x00f6, B:28:0x00fb, B:30:0x0100, B:59:0x0144, B:61:0x014c, B:63:0x0151, B:41:0x01ae, B:43:0x01b3, B:45:0x01b8), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b3 A[Catch: IOException -> 0x0148, TryCatch #7 {IOException -> 0x0148, blocks: (B:26:0x00f6, B:28:0x00fb, B:30:0x0100, B:59:0x0144, B:61:0x014c, B:63:0x0151, B:41:0x01ae, B:43:0x01b3, B:45:0x01b8), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b8 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #7 {IOException -> 0x0148, blocks: (B:26:0x00f6, B:28:0x00fb, B:30:0x0100, B:59:0x0144, B:61:0x014c, B:63:0x0151, B:41:0x01ae, B:43:0x01b3, B:45:0x01b8), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0169 A[Catch: all -> 0x01bc, TryCatch #15 {all -> 0x01bc, blocks: (B:57:0x013f, B:37:0x015d, B:39:0x0165, B:48:0x0169, B:50:0x0183, B:51:0x01a1), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0144 A[Catch: IOException -> 0x0148, TRY_ENTER, TryCatch #7 {IOException -> 0x0148, blocks: (B:26:0x00f6, B:28:0x00fb, B:30:0x0100, B:59:0x0144, B:61:0x014c, B:63:0x0151, B:41:0x01ae, B:43:0x01b3, B:45:0x01b8), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014c A[Catch: IOException -> 0x0148, TryCatch #7 {IOException -> 0x0148, blocks: (B:26:0x00f6, B:28:0x00fb, B:30:0x0100, B:59:0x0144, B:61:0x014c, B:63:0x0151, B:41:0x01ae, B:43:0x01b3, B:45:0x01b8), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0151 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #7 {IOException -> 0x0148, blocks: (B:26:0x00f6, B:28:0x00fb, B:30:0x0100, B:59:0x0144, B:61:0x014c, B:63:0x0151, B:41:0x01ae, B:43:0x01b3, B:45:0x01b8), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ca A[Catch: IOException -> 0x01c6, TryCatch #9 {IOException -> 0x01c6, blocks: (B:81:0x01c2, B:70:0x01ca, B:72:0x01cf), top: B:80:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01cf A[Catch: IOException -> 0x01c6, TRY_LEAVE, TryCatch #9 {IOException -> 0x01c6, blocks: (B:81:0x01c2, B:70:0x01ca, B:72:0x01cf), top: B:80:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadPart(int r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.uploadPart(int, int, int):void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void uploadPartFinish(PartETag partETag) throws Exception {
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mSp.contains(this.mUploadId)) {
            return;
        }
        this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j2 = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long j3 = this.mUploadedLength;
            if (j3 > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.mFirstPartSize != i2) {
                throw new ClientException("The part size setting is inconsistent with before");
            }
            if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                j3 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j4 = j3;
            OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
            if (oSSProgressCallback != 0) {
                oSSProgressCallback.onProgress(this.mRequest, j4, this.mFileLength);
            }
            this.mSp.removeKey(this.mUploadId);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i4 + 1))) {
                if (i4 == i3 - 1) {
                    i2 = (int) (this.mFileLength - j2);
                }
                OSSLog.logDebug("upload part readByte : " + i2);
                j2 += (long) i2;
                uploadPart(i4, i2, i3);
                if (this.mUploadException != null) {
                    break;
                }
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new ResumableUploadResult(completeMultipartUploadResult) : null;
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        return resumableUploadResult;
    }
}
