package com.taobao.accs.net;

import androidx.core.app.NotificationCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Objects;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class o implements Runnable {
    final /* synthetic */ Message a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f5829b;

    o(k kVar, Message message) {
        this.f5829b = kVar;
        this.a = message;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0260  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i2;
        boolean z;
        Session throwsException;
        Message message = this.a;
        if (message != null) {
            if (message.getNetPermanceMonitor() != null) {
                this.a.getNetPermanceMonitor().onTakeFromQueue();
            }
            int type = this.a.getType();
            try {
                if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.a.serviceId)) {
                    ALog.e(this.f5829b.d(), "sendMessage start", Constants.KEY_DATA_ID, this.a.getDataId(), "type", Message.MsgType.name(type));
                }
                String string = null;
                if (type != 1) {
                    i2 = 1;
                    ALog.e(this.f5829b.d(), "sendMessage skip", "type", Message.MsgType.name(type));
                } else {
                    if (this.a.host != null) {
                        SessionCenter sessionCenter = SessionCenter.getInstance(this.f5829b.f5806i.getAppKey());
                        this.f5829b.a(sessionCenter, this.a.host.getHost(), false);
                        try {
                            throwsException = sessionCenter.getThrowsException(this.a.host.toString(), ConnType.TypeLevel.SPDY, com.taobao.accs.utl.t.d());
                        } catch (Exception e2) {
                            ALog.e(this.f5829b.d(), "get session null", e2, new Object[0]);
                            string = e2.toString();
                            throwsException = null;
                        }
                        if (throwsException != null) {
                            byte[] bArrBuild = this.a.build(this.f5829b.f5801d, this.f5829b.f5800c);
                            if ("accs".equals(this.a.serviceId) || "accs-impaas".equals(this.a.serviceId)) {
                                String strD = this.f5829b.d();
                                Object[] objArr = new Object[10];
                                objArr[0] = Constants.KEY_DATA_ID;
                                objArr[1] = this.a.getDataId();
                                objArr[2] = "command";
                                objArr[3] = this.a.command;
                                objArr[4] = Constants.KEY_HOST;
                                objArr[5] = this.a.host;
                                objArr[6] = "len";
                                objArr[7] = Integer.valueOf(bArrBuild == null ? 0 : bArrBuild.length);
                                objArr[8] = "utdid";
                                objArr[9] = this.f5829b.f5807j;
                                ALog.e(strD, "sendMessage", objArr);
                            } else if (ALog.isPrintLog(ALog.Level.I)) {
                                String strD2 = this.f5829b.d();
                                Object[] objArr2 = new Object[10];
                                objArr2[0] = Constants.KEY_DATA_ID;
                                objArr2[1] = this.a.getDataId();
                                objArr2[2] = "command";
                                objArr2[3] = this.a.command;
                                objArr2[4] = Constants.KEY_HOST;
                                objArr2[5] = this.a.host;
                                objArr2[6] = "len";
                                objArr2[7] = Integer.valueOf(bArrBuild == null ? 0 : bArrBuild.length);
                                objArr2[8] = "utdid";
                                objArr2[9] = this.f5829b.f5807j;
                                ALog.d(strD2, "sendMessage", objArr2);
                            }
                            this.a.setSendTime(System.currentTimeMillis());
                            if (((byte[]) Objects.requireNonNull(bArrBuild)).length <= 49152 || this.a.command.intValue() == 102) {
                                this.f5829b.f5802e.a(this.a);
                                int id = this.a.isAck ? -this.a.getMsgId().getId() : this.a.getMsgId().getId();
                                if (this.a.isAck) {
                                    this.f5829b.f5809l.put(Integer.valueOf(id), this.a);
                                }
                                throwsException.sendCustomFrame(id, bArrBuild, 200);
                                if (this.a.getNetPermanceMonitor() != null) {
                                    this.a.getNetPermanceMonitor().onSendData();
                                }
                                this.f5829b.a(this.a.getDataId(), this.f5829b.f5806i.isQuickReconnect(), this.a.timeout);
                                this.f5829b.f5802e.a(new TrafficsMonitor.a(this.a.serviceId, GlobalAppRuntimeInfo.isAppBackground(), this.a.host.toString(), bArrBuild.length));
                            } else {
                                this.f5829b.f5802e.a(this.a, -4);
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        i2 = 1;
                        if (!z) {
                            if (type == i2) {
                                if (this.a.isTimeOut() || !this.f5829b.a(this.a, 2000)) {
                                    this.f5829b.f5802e.a(this.a, -11);
                                    String str = this.a.serviceId;
                                    if (string == null) {
                                        string = "conn time out";
                                    }
                                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_SESSION_ERROR, str, string, String.valueOf(-11));
                                }
                                Message message2 = this.a;
                                if (message2.retryTimes == 1 && message2.getNetPermanceMonitor() != null) {
                                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_accs", 0.0d);
                                }
                            } else {
                                this.f5829b.f5802e.a(this.a, -11);
                                String str2 = this.a.serviceId;
                                if (string == null) {
                                    string = "conn time out";
                                }
                                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_SESSION_ERROR, str2, string, String.valueOf(-11));
                            }
                        }
                        if (!"accs".equals(this.a.serviceId) || "accs-impaas".equals(this.a.serviceId)) {
                            ALog.e(this.f5829b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.a.getDataId(), NotificationCompat.CATEGORY_STATUS, Boolean.valueOf(z));
                        } else {
                            ALog.e(this.f5829b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.a.getDataId(), NotificationCompat.CATEGORY_STATUS, Boolean.valueOf(z));
                            return;
                        }
                    }
                    this.f5829b.f5802e.a(this.a, -5);
                    i2 = 1;
                }
                z = true;
                if (!z) {
                }
                if ("accs".equals(this.a.serviceId)) {
                }
                ALog.e(this.f5829b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.a.getDataId(), NotificationCompat.CATEGORY_STATUS, Boolean.valueOf(z));
            } catch (Throwable th) {
                try {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, this.a.serviceId, "", this.f5829b.f5800c + th.toString());
                    ALog.e(this.f5829b.d(), "sendMessage", th, new Object[0]);
                    if ("accs".equals(this.a.serviceId) || "accs-impaas".equals(this.a.serviceId)) {
                        ALog.e(this.f5829b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.a.getDataId(), NotificationCompat.CATEGORY_STATUS, true);
                    } else {
                        ALog.e(this.f5829b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.a.getDataId(), NotificationCompat.CATEGORY_STATUS, true);
                    }
                } catch (Throwable th2) {
                    if ("accs".equals(this.a.serviceId) || "accs-impaas".equals(this.a.serviceId)) {
                        ALog.e(this.f5829b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.a.getDataId(), NotificationCompat.CATEGORY_STATUS, true);
                    } else {
                        ALog.e(this.f5829b.d(), "sendMessage end", Constants.KEY_DATA_ID, this.a.getDataId(), NotificationCompat.CATEGORY_STATUS, true);
                    }
                    throw th2;
                }
            }
        }
    }
}
