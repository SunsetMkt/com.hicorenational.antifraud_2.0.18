package anet.channel.statist;

import anet.channel.GlobalAppRuntimeInfo;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "strategy_stat")
/* loaded from: classes.dex */
public class StrategyStatObject extends StatObject {

    @Dimension
    public StringBuilder errorTrace;

    @Dimension
    public int isFileExists;

    @Dimension
    public int isReadObjectSucceed;

    @Dimension
    public int isRenameSucceed;

    @Dimension
    public int isSucceed;

    @Dimension
    public int isTempWriteSucceed;

    @Measure
    public long readCostTime;

    @Dimension
    public String readStrategyFileId;

    @Dimension
    public String readStrategyFilePath;

    @Dimension
    public int type;

    @Measure
    public long writeCostTime;

    @Dimension
    public String writeStrategyFileId;

    @Dimension
    public String writeStrategyFilePath;

    @Dimension
    public String writeTempFilePath;

    public StrategyStatObject(int i2) {
        this.type = -1;
        this.type = i2;
    }

    public void appendErrorTrace(String str, Throwable th) {
        String message = th.getMessage();
        if (this.errorTrace == null) {
            this.errorTrace = new StringBuilder();
        }
        StringBuilder sb = this.errorTrace;
        sb.append('[');
        sb.append(str);
        sb.append(']');
        sb.append(str);
        sb.append(' ');
        sb.append(message);
        sb.append('\n');
    }

    @Override // anet.channel.statist.StatObject
    public boolean beforeCommit() {
        return GlobalAppRuntimeInfo.isTargetProcess();
    }
}
