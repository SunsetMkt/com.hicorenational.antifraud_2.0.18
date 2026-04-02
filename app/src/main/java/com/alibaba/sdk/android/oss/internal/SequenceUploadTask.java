package com.alibaba.sdk.android.oss.internal;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PartSummary;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.CheckedInputStream;

/* JADX INFO: loaded from: classes.dex */
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
    protected void checkException() throws Throwable {
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
                    HashMap map = new HashMap();
                    for (PartETag partETag : this.mPartETags) {
                        map.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
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
                                objectOutputStream2.writeObject(map);
                                objectOutputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                OSSLog.logThrowable2Local(e);
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x0140  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void initMultipartUploadId() throws ServiceException, ClientException, IOException {
        String strCalculateMd5Str;
        Map map;
        boolean zIsTruncated;
        if (!OSSUtils.isEmptyString(((ResumableUploadRequest) this.mRequest).getRecordDirectory())) {
            if (this.mUploadUri != null) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                try {
                    strCalculateMd5Str = BinaryUtil.calculateMd5Str(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                } finally {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                }
            } else {
                strCalculateMd5Str = BinaryUtil.calculateMd5Str(this.mUploadFilePath);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strCalculateMd5Str);
            sb.append(((ResumableUploadRequest) this.mRequest).getBucketName());
            sb.append(((ResumableUploadRequest) this.mRequest).getObjectKey());
            sb.append(String.valueOf(((ResumableUploadRequest) this.mRequest).getPartSize()));
            sb.append(this.mCheckCRC64 ? "-crc64" : "");
            sb.append("-sequence");
            this.mRecordFile = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + BinaryUtil.calculateMd5Str(sb.toString().getBytes()));
            if (this.mRecordFile.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.mRecordFile));
                this.mUploadId = bufferedReader.readLine();
                bufferedReader.close();
                OSSLog.logDebug("sequence [initUploadId] - Found record file, uploadid: " + this.mUploadId);
            }
            if (!OSSUtils.isEmptyString(this.mUploadId)) {
                if (this.mCheckCRC64) {
                    File file = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                    if (file.exists()) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                        try {
                            try {
                                map = (Map) objectInputStream.readObject();
                            } catch (ClassNotFoundException e2) {
                                e = e2;
                                map = null;
                            }
                            try {
                                file.delete();
                            } catch (ClassNotFoundException e3) {
                                e = e3;
                                OSSLog.logThrowable2Local(e);
                            }
                        } finally {
                            objectInputStream.close();
                            file.delete();
                        }
                    } else {
                        map = null;
                    }
                    int nextPartNumberMarker = 0;
                    do {
                        ListPartsRequest listPartsRequest = new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                        if (nextPartNumberMarker > 0) {
                            listPartsRequest.setPartNumberMarker(Integer.valueOf(nextPartNumberMarker));
                        }
                        OSSAsyncTask<ListPartsResult> oSSAsyncTaskListParts = this.mApiOperation.listParts(listPartsRequest, null);
                        try {
                            ListPartsResult listPartsResult = (ListPartsResult) oSSAsyncTaskListParts.getResult();
                            zIsTruncated = listPartsResult.isTruncated();
                            nextPartNumberMarker = listPartsResult.getNextPartNumberMarker();
                            List<PartSummary> parts = listPartsResult.getParts();
                            for (int i2 = 0; i2 < parts.size(); i2++) {
                                PartSummary partSummary = parts.get(i2);
                                PartETag partETag = new PartETag(partSummary.getPartNumber(), partSummary.getETag());
                                partETag.setPartSize(partSummary.getSize());
                                if (map != null && map.size() > 0 && map.containsKey(Integer.valueOf(partETag.getPartNumber()))) {
                                    partETag.setCRC64(((Long) map.get(Integer.valueOf(partETag.getPartNumber()))).longValue());
                                }
                                this.mPartETags.add(partETag);
                                this.mUploadedLength += partSummary.getSize();
                                this.mAlreadyUploadIndex.add(Integer.valueOf(partSummary.getPartNumber()));
                                if (i2 == 0) {
                                    this.mFirstPartSize = partSummary.getSize();
                                }
                            }
                        } catch (ClientException e4) {
                            throw e4;
                        } catch (ServiceException e5) {
                            if (e5.getStatusCode() != 404) {
                                throw e5;
                            }
                            this.mUploadId = null;
                            zIsTruncated = false;
                        }
                        oSSAsyncTaskListParts.waitUntilFinished();
                    } while (zIsTruncated);
                }
            }
            if (!this.mRecordFile.exists() && !this.mRecordFile.createNewFile()) {
                throw new ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
            }
        }
        if (OSSUtils.isEmptyString(this.mUploadId)) {
            InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), ((ResumableUploadRequest) this.mRequest).getMetadata());
            initiateMultipartUploadRequest.isSequential = true;
            this.mUploadId = ((InitiateMultipartUploadResult) this.mApiOperation.initMultipartUpload(initiateMultipartUploadRequest, null).getResult()).getUploadId();
            File file2 = this.mRecordFile;
            if (file2 != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                bufferedWriter.write(this.mUploadId);
                bufferedWriter.close();
            }
        }
        ((ResumableUploadRequest) this.mRequest).setUploadId(this.mUploadId);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf A[Catch: IOException -> 0x01c6, TRY_LEAVE, TryCatch #9 {IOException -> 0x01c6, blocks: (B:95:0x01c2, B:99:0x01ca, B:101:0x01cf), top: B:106:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6 A[Catch: ServiceException -> 0x011a, all -> 0x011c, Exception -> 0x011e, TryCatch #11 {ServiceException -> 0x011a, blocks: (B:30:0x0096, B:32:0x00c6, B:33:0x00d1, B:35:0x00ea, B:43:0x0105, B:44:0x0119), top: B:108:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea A[Catch: ServiceException -> 0x011a, all -> 0x011c, Exception -> 0x011e, TRY_LEAVE, TryCatch #11 {ServiceException -> 0x011a, blocks: (B:30:0x0096, B:32:0x00c6, B:33:0x00d1, B:35:0x00ea, B:43:0x0105, B:44:0x0119), top: B:108:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105 A[Catch: ServiceException -> 0x011a, all -> 0x011c, Exception -> 0x011e, TRY_ENTER, TryCatch #11 {ServiceException -> 0x011a, blocks: (B:30:0x0096, B:32:0x00c6, B:33:0x00d1, B:35:0x00ea, B:43:0x0105, B:44:0x0119), top: B:108:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144 A[Catch: IOException -> 0x0148, TRY_ENTER, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c A[Catch: IOException -> 0x0148, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0165 A[Catch: all -> 0x01bc, TryCatch #15 {all -> 0x01bc, blocks: (B:65:0x013f, B:78:0x015d, B:80:0x0165, B:81:0x0169, B:83:0x0183, B:84:0x01a1), top: B:109:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0169 A[Catch: all -> 0x01bc, TryCatch #15 {all -> 0x01bc, blocks: (B:65:0x013f, B:78:0x015d, B:80:0x0165, B:81:0x0169, B:83:0x0183, B:84:0x01a1), top: B:109:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ae A[Catch: IOException -> 0x0148, TRY_ENTER, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b3 A[Catch: IOException -> 0x0148, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b8 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #7 {IOException -> 0x0148, blocks: (B:37:0x00f6, B:39:0x00fb, B:41:0x0100, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ca A[Catch: IOException -> 0x01c6, TryCatch #9 {IOException -> 0x01c6, blocks: (B:95:0x01c2, B:99:0x01ca, B:101:0x01cf), top: B:106:0x01c2 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.alibaba.sdk.android.oss.model.UploadPartRequest] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask, com.alibaba.sdk.android.oss.internal.SequenceUploadTask] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uploadPart(int i2, int i3, int i4) throws Throwable {
        ?? r9;
        ?? r11;
        ?? r10;
        ?? r112;
        ?? r12;
        ?? r102;
        ?? r113;
        ?? r103;
        UploadPartRequest uploadPartRequest;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        Object obj;
        BufferedInputStream bufferedInputStream3;
        Throwable th = null;
        ?? r1 = 0;
        ?? r13 = 0;
        th = null;
        th = null;
        try {
        } catch (Throwable th2) {
            th = th2;
            r9 = 0;
        }
        try {
            try {
            } catch (ServiceException e2) {
                e = e2;
                Throwable th3 = th;
                Throwable th4 = th3;
                r12 = th4;
                r1 = th;
                r103 = th3;
                r113 = th4;
            } catch (Exception e3) {
                e = e3;
                Throwable th5 = th;
                r112 = th5;
                r13 = th;
                r102 = th5;
            } catch (Throwable th6) {
                th = th6;
                r9 = th;
                r10 = r9;
                r11 = r10;
            }
            if (this.mContext.getCancellationHandler().isCancelled()) {
                return;
            }
            this.mRunPartTaskCount++;
            preUploadPart(i2, i3, i4);
            long partSize = ((long) i2) * ((ResumableUploadRequest) this.mRequest).getPartSize();
            byte[] bArr = new byte[i3];
            if (this.mUploadUri != null) {
                InputStream inputStreamOpenInputStream = this.mContext.getApplicationContext().getContentResolver().openInputStream(this.mUploadUri);
                try {
                    bufferedInputStream3 = new BufferedInputStream(inputStreamOpenInputStream);
                } catch (ServiceException e4) {
                    e = e4;
                    bufferedInputStream2 = null;
                    obj = null;
                } catch (Exception e5) {
                    e = e5;
                    bufferedInputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    r9 = 0;
                    r11 = 0;
                    r10 = inputStreamOpenInputStream;
                    th = th;
                    if (r9 != 0) {
                    }
                    if (r10 != 0) {
                    }
                    if (r11 == 0) {
                    }
                }
                try {
                    bufferedInputStream3.skip(partSize);
                    bufferedInputStream3.read(bArr, 0, i3);
                    r9 = 0;
                    r11 = bufferedInputStream3;
                    r10 = inputStreamOpenInputStream;
                    try {
                        try {
                            uploadPartRequest = new UploadPartRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId, i2 + 1);
                        } catch (Exception e6) {
                            e = e6;
                            r13 = r9;
                            r102 = r10;
                            r112 = r11;
                            processException(e);
                            if (r13 != 0) {
                            }
                            if (r102 != 0) {
                            }
                            if (r112 != 0) {
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            th = th;
                            if (r9 != 0) {
                            }
                            if (r10 != 0) {
                            }
                            if (r11 == 0) {
                            }
                        }
                    } catch (ServiceException e7) {
                        e = e7;
                        uploadPartRequest = null;
                    }
                } catch (ServiceException e8) {
                    e = e8;
                    obj = null;
                    bufferedInputStream2 = bufferedInputStream3;
                    r103 = inputStreamOpenInputStream;
                    r113 = bufferedInputStream2;
                    r12 = obj;
                } catch (Exception e9) {
                    e = e9;
                    bufferedInputStream = bufferedInputStream3;
                    r102 = inputStreamOpenInputStream;
                    r112 = bufferedInputStream;
                    processException(e);
                    if (r13 != 0) {
                    }
                    if (r102 != 0) {
                    }
                    if (r112 != 0) {
                    }
                } catch (Throwable th9) {
                    r9 = 0;
                    r11 = bufferedInputStream3;
                    th = th9;
                    r10 = inputStreamOpenInputStream;
                    if (r9 != 0) {
                    }
                    if (r10 != 0) {
                    }
                    if (r11 == 0) {
                    }
                }
                try {
                    uploadPartRequest.setPartContent(bArr);
                    uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                    uploadPartRequest.setCRC64(((ResumableUploadRequest) this.mRequest).getCRC64());
                    UploadPartResult uploadPartResultSyncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                    PartETag partETag = new PartETag(uploadPartRequest.getPartNumber(), uploadPartResultSyncUploadPart.getETag());
                    long j2 = i3;
                    partETag.setPartSize(j2);
                    if (this.mCheckCRC64) {
                        partETag.setCRC64(uploadPartResultSyncUploadPart.getClientCRC().longValue());
                    }
                    this.mPartETags.add(partETag);
                    this.mUploadedLength += j2;
                    uploadPartFinish(partETag);
                    if (!this.mContext.getCancellationHandler().isCancelled()) {
                        TaskCancelException taskCancelException = new TaskCancelException("sequence upload task cancel");
                        throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
                    }
                    onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                    if (r9 != 0) {
                        r9.close();
                    }
                    if (r10 != 0) {
                        r10.close();
                    }
                    if (r11 != 0) {
                        r11.close();
                        return;
                    }
                    return;
                } catch (ServiceException e10) {
                    e = e10;
                    r1 = r9;
                    r103 = r10;
                    r113 = r11;
                    r12 = uploadPartRequest;
                    if (e.getStatusCode() == 409) {
                    }
                    if (r1 != 0) {
                    }
                    if (r103 != 0) {
                    }
                    if (r113 == 0) {
                    }
                }
            } else {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.mUploadFile, "r");
                try {
                    randomAccessFile.seek(partSize);
                    randomAccessFile.readFully(bArr, 0, i3);
                    r10 = 0;
                    r11 = 0;
                    r9 = randomAccessFile;
                    uploadPartRequest = new UploadPartRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId, i2 + 1);
                    uploadPartRequest.setPartContent(bArr);
                    uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                    uploadPartRequest.setCRC64(((ResumableUploadRequest) this.mRequest).getCRC64());
                    UploadPartResult uploadPartResultSyncUploadPart2 = this.mApiOperation.syncUploadPart(uploadPartRequest);
                    PartETag partETag2 = new PartETag(uploadPartRequest.getPartNumber(), uploadPartResultSyncUploadPart2.getETag());
                    long j22 = i3;
                    partETag2.setPartSize(j22);
                    if (this.mCheckCRC64) {
                    }
                    this.mPartETags.add(partETag2);
                    this.mUploadedLength += j22;
                    uploadPartFinish(partETag2);
                    if (!this.mContext.getCancellationHandler().isCancelled()) {
                    }
                } catch (ServiceException e11) {
                    e = e11;
                    r103 = 0;
                    r113 = 0;
                    r12 = 0;
                    r1 = randomAccessFile;
                } catch (Exception e12) {
                    e = e12;
                    r102 = 0;
                    r112 = 0;
                    r13 = randomAccessFile;
                    processException(e);
                    if (r13 != 0) {
                        r13.close();
                    }
                    if (r102 != 0) {
                        r102.close();
                    }
                    if (r112 != 0) {
                        r112.close();
                        return;
                    }
                    return;
                } catch (Throwable th10) {
                    th = th10;
                    r10 = 0;
                    r11 = 0;
                    r9 = randomAccessFile;
                    th = th;
                    if (r9 != 0) {
                    }
                    if (r10 != 0) {
                    }
                    if (r11 == 0) {
                    }
                }
            }
            if (r9 != 0) {
                try {
                    r9.close();
                } catch (IOException e13) {
                    OSSLog.logThrowable2Local(e13);
                    throw th;
                }
            }
            if (r10 != 0) {
                r10.close();
            }
            if (r11 == 0) {
                throw th;
            }
            r11.close();
            throw th;
            if (e.getStatusCode() == 409) {
                processException(e);
            } else {
                PartETag partETag3 = new PartETag(r12.getPartNumber(), e.getPartEtag());
                partETag3.setPartSize(r12.getPartContent().length);
                if (this.mCheckCRC64) {
                    partETag3.setCRC64(new CheckedInputStream(new ByteArrayInputStream(r12.getPartContent()), new CRC64()).getChecksum().getValue());
                }
                this.mPartETags.add(partETag3);
                this.mUploadedLength += (long) i3;
            }
            if (r1 != 0) {
                r1.close();
            }
            if (r103 != 0) {
                r103.close();
            }
            if (r113 == 0) {
                r113.close();
            }
        } catch (IOException e14) {
            OSSLog.logThrowable2Local(e14);
        }
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
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws Throwable {
        long j2 = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long jLongValue = this.mUploadedLength;
            if (jLongValue > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.mFirstPartSize != i2) {
                throw new ClientException("The part size setting is inconsistent with before");
            }
            if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                jLongValue = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j3 = jLongValue;
            OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
            if (oSSProgressCallback != 0) {
                oSSProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
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
