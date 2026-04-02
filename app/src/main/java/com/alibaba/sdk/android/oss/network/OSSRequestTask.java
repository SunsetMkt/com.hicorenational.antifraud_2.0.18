package com.alibaba.sdk.android.oss.network;

import android.os.ParcelFileDescriptor;
import anet.channel.request.Request;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler;
import com.alibaba.sdk.android.oss.internal.OSSRetryType;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.CheckedInputStream;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class OSSRequestTask<T extends OSSResult> implements Callable<T> {
    private OkHttpClient client;
    private ExecutionContext context;
    private int currentRetryCount = 0;
    private RequestMessage message;
    private ResponseParser<T> responseParser;
    private OSSRetryHandler retryHandler;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.oss.network.OSSRequestTask$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = new int[HttpMethod.values().length];

        static {
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.GET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.HEAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public OSSRequestTask(RequestMessage requestMessage, ResponseParser responseParser, ExecutionContext executionContext, int i2) {
        this.responseParser = responseParser;
        this.message = requestMessage;
        this.context = executionContext;
        this.client = executionContext.getClient();
        this.retryHandler = new OSSRetryHandler(i2);
    }

    private ResponseMessage buildResponseMessage(RequestMessage requestMessage, Response response) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequest(requestMessage);
        responseMessage.setResponse(response);
        HashMap map = new HashMap();
        Headers headers = response.headers();
        for (int i2 = 0; i2 < headers.size(); i2++) {
            map.put(headers.name(i2), headers.value(i2));
        }
        responseMessage.setHeaders(map);
        responseMessage.setStatusCode(response.code());
        responseMessage.setContentLength(response.body().contentLength());
        responseMessage.setContent(response.body().byteStream());
        return responseMessage;
    }

    /* JADX WARN: Removed duplicated region for block: B:233:0x0198 A[Catch: Exception -> 0x02ce, TryCatch #0 {Exception -> 0x02ce, blocks: (B:172:0x0004, B:174:0x000c, B:175:0x0019, B:177:0x003a, B:179:0x0043, B:181:0x0050, B:182:0x0062, B:184:0x0068, B:185:0x007f, B:240:0x01fd, B:196:0x00c6, B:197:0x00cc, B:198:0x00d2, B:202:0x00dd, B:204:0x00ec, B:233:0x0198, B:235:0x01a0, B:236:0x01ab, B:238:0x01cc, B:239:0x01e9, B:207:0x0103, B:209:0x010b, B:212:0x0128, B:213:0x0130, B:214:0x0131, B:216:0x0139, B:220:0x0169, B:226:0x0173, B:227:0x0176, B:228:0x0177, B:230:0x017f, B:231:0x018d, B:180:0x004a, B:258:0x02c6, B:259:0x02cd), top: B:318:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x01ca  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public T call() throws Exception {
        Call callNewCall;
        Request requestBuild;
        Exception clientException;
        ResponseMessage responseMessageBuildResponseMessage;
        OSSRequest request;
        long statSize;
        String stringBody;
        InputStream content;
        long contentLength;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            if (this.context.getApplicationContext() != null) {
                OSSLog.logInfo(OSSUtils.buildBaseLogInfo(this.context.getApplicationContext()));
            }
            OSSLog.logDebug("[call] - ");
            request = this.context.getRequest();
            OSSUtils.ensureRequestValid(request, this.message);
            OSSUtils.signRequest(this.message);
        } catch (Exception e2) {
            e = e2;
            callNewCall = null;
            requestBuild = null;
        }
        if (this.context.getCancellationHandler().isCancelled()) {
            throw new InterruptedIOException("This task is cancelled!");
        }
        Request.Builder builderUrl = new Request.Builder().url(request instanceof ListBucketsRequest ? this.message.buildOSSServiceURL() : this.message.buildCanonicalURL());
        for (String str : this.message.getHeaders().keySet()) {
            builderUrl = builderUrl.addHeader(str, (String) this.message.getHeaders().get(str));
        }
        String str2 = (String) this.message.getHeaders().get("Content-Type");
        OSSLog.logDebug("request method = " + this.message.getMethod());
        int i2 = AnonymousClass1.$SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[this.message.getMethod().ordinal()];
        if (i2 == 1 || i2 == 2) {
            OSSUtils.assertTrue(str2 != null, "Content type can't be null when upload!");
            if (this.message.getUploadData() != null) {
                content = new ByteArrayInputStream(this.message.getUploadData());
                contentLength = this.message.getUploadData().length;
            } else {
                if (this.message.getUploadFilePath() != null) {
                    File file = new File(this.message.getUploadFilePath());
                    FileInputStream fileInputStream = new FileInputStream(file);
                    long length = file.length();
                    if (length <= 0) {
                        throw new ClientException("the length of file is 0!");
                    }
                    stringBody = null;
                    content = fileInputStream;
                    statSize = length;
                } else if (this.message.getUploadUri() != null) {
                    content = this.context.getApplicationContext().getContentResolver().openInputStream(this.message.getUploadUri());
                    try {
                        parcelFileDescriptorOpenFileDescriptor = this.context.getApplicationContext().getContentResolver().openFileDescriptor(this.message.getUploadUri(), "r");
                    } catch (Throwable th) {
                        th = th;
                        parcelFileDescriptorOpenFileDescriptor = null;
                    }
                    try {
                        statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        stringBody = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        throw th;
                    }
                } else if (this.message.getContent() != null) {
                    content = this.message.getContent();
                    contentLength = this.message.getContentLength();
                } else {
                    statSize = 0;
                    stringBody = this.message.getStringBody();
                    content = null;
                }
                if (content == null) {
                    if (this.message.isCheckCRC64()) {
                        content = new CheckedInputStream(content, new CRC64());
                    }
                    this.message.setContent(content);
                    this.message.setContentLength(statSize);
                    builderUrl = builderUrl.method(this.message.getMethod().toString(), NetworkProgressHelper.addProgressRequestBody(content, statSize, str2, this.context));
                } else {
                    builderUrl = stringBody != null ? builderUrl.method(this.message.getMethod().toString(), RequestBody.create(MediaType.parse(str2), stringBody.getBytes("UTF-8"))) : builderUrl.method(this.message.getMethod().toString(), RequestBody.create((MediaType) null, new byte[0]));
                }
            }
            statSize = contentLength;
            stringBody = null;
            if (content == null) {
            }
        } else if (i2 == 3) {
            builderUrl = builderUrl.get();
        } else if (i2 == 4) {
            builderUrl = builderUrl.head();
        } else if (i2 == 5) {
            builderUrl = builderUrl.delete();
        }
        requestBuild = builderUrl.build();
        try {
            if (request instanceof GetObjectRequest) {
                this.client = NetworkProgressHelper.addProgressResponseListener(this.client, this.context);
                OSSLog.logDebug("getObject");
            }
            callNewCall = this.client.newCall(requestBuild);
            try {
                this.context.getCancellationHandler().setCall(callNewCall);
                Response responseExecute = callNewCall.execute();
                if (OSSLog.isEnableLog()) {
                    Map<String, List<String>> multimap = responseExecute.headers().toMultimap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("response:---------------------\n");
                    sb.append("response code: " + responseExecute.code() + " for url: " + requestBuild.url() + "\n");
                    for (String str3 : multimap.keySet()) {
                        sb.append("responseHeader [" + str3 + "]: ");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(multimap.get(str3).get(0));
                        sb2.append("\n");
                        sb.append(sb2.toString());
                    }
                    OSSLog.logDebug(sb.toString());
                }
                responseMessageBuildResponseMessage = buildResponseMessage(this.message, responseExecute);
                clientException = null;
            } catch (Exception e3) {
                e = e3;
                OSSLog.logError("Encounter local execpiton: " + e.toString());
                if (OSSLog.isEnableLog()) {
                    e.printStackTrace();
                }
                clientException = new ClientException(e.getMessage(), e);
                responseMessageBuildResponseMessage = null;
            }
        } catch (Exception e4) {
            e = e4;
            callNewCall = null;
        }
        if (clientException == null && (responseMessageBuildResponseMessage.getStatusCode() == 203 || responseMessageBuildResponseMessage.getStatusCode() >= 300)) {
            clientException = ResponseParsers.parseResponseErrorXML(responseMessageBuildResponseMessage, requestBuild.method().equals(Request.Method.HEAD));
        } else if (clientException == null) {
            try {
                T t = (T) this.responseParser.parse(responseMessageBuildResponseMessage);
                if (this.context.getCompletedCallback() != null) {
                    this.context.getCompletedCallback().onSuccess(this.context.getRequest(), t);
                }
                return t;
            } catch (IOException e5) {
                clientException = new ClientException(e5.getMessage(), e5);
            }
        }
        Exception clientException2 = ((callNewCall == null || !callNewCall.isCanceled()) && !this.context.getCancellationHandler().isCancelled()) ? clientException : new ClientException("Task is cancelled!", clientException.getCause(), true);
        OSSRetryType oSSRetryTypeShouldRetry = this.retryHandler.shouldRetry(clientException2, this.currentRetryCount);
        OSSLog.logError("[run] - retry, retry type: " + oSSRetryTypeShouldRetry);
        if (oSSRetryTypeShouldRetry == OSSRetryType.OSSRetryTypeShouldRetry) {
            this.currentRetryCount++;
            if (this.context.getRetryCallback() != null) {
                this.context.getRetryCallback().onRetryCallback();
            }
            try {
                Thread.sleep(this.retryHandler.timeInterval(this.currentRetryCount, oSSRetryTypeShouldRetry));
            } catch (InterruptedException e6) {
                Thread.currentThread().interrupt();
                e6.printStackTrace();
            }
            return (T) call();
        }
        if (oSSRetryTypeShouldRetry != OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry) {
            if (clientException2 instanceof ClientException) {
                if (this.context.getCompletedCallback() == null) {
                    throw clientException2;
                }
                this.context.getCompletedCallback().onFailure(this.context.getRequest(), (ClientException) clientException2, null);
                throw clientException2;
            }
            if (this.context.getCompletedCallback() == null) {
                throw clientException2;
            }
            this.context.getCompletedCallback().onFailure(this.context.getRequest(), null, (ServiceException) clientException2);
            throw clientException2;
        }
        if (responseMessageBuildResponseMessage != null) {
            String str4 = (String) responseMessageBuildResponseMessage.getHeaders().get(HttpHeaders.DATE);
            try {
                DateUtil.setCurrentServerTime(DateUtil.parseRfc822Date(str4).getTime());
                this.message.getHeaders().put(HttpHeaders.DATE, str4);
            } catch (Exception unused) {
                OSSLog.logError("[error] - synchronize time, reponseDate:" + str4);
            }
        }
        this.currentRetryCount++;
        if (this.context.getRetryCallback() != null) {
            this.context.getRetryCallback().onRetryCallback();
        }
        return (T) call();
    }
}
