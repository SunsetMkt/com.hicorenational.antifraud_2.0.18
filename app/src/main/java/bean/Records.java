package bean;

import java.io.Serializable;
import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class Records extends BaseBean implements Serializable {
    public String checkTime;
    public int checkType;
    public String duration;
    public String fileFormat;
    public int fileSize;
    public long id;
    public String isAIGenerated;
    public String localFilePath;
    public String ossFilePath;
    public String resolutionRatio;
    public String textContent;
    public String textSize;

    public String getCheckTime() {
        return this.checkTime;
    }

    public int getCheckType() {
        return this.checkType;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getFileFormat() {
        return this.fileFormat;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public long getId() {
        return this.id;
    }

    public String getLocalFilePath() {
        return this.localFilePath;
    }

    public String getOssFilePath() {
        return this.ossFilePath;
    }

    public String getResolutionRatio() {
        return this.resolutionRatio;
    }

    public String getTextContent() {
        return this.textContent;
    }

    public String getTextSize() {
        return this.textSize;
    }

    public boolean isAIGenerated() {
        return "1".equals(this.isAIGenerated);
    }

    public void setAIGenerated(boolean z) {
        if (z) {
            this.isAIGenerated = "1";
        } else {
            this.isAIGenerated = "0";
        }
    }

    public void setCheckTime(String str) {
        this.checkTime = str;
    }

    public void setCheckType(int i2) {
        this.checkType = i2;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setFileFormat(String str) {
        this.fileFormat = str;
    }

    public void setFileSize(int i2) {
        this.fileSize = i2;
    }

    public void setId(long j2) {
        this.id = j2;
    }

    public void setLocalFilePath(String str) {
        this.localFilePath = str;
    }

    public void setOssFilePath(String str) {
        this.ossFilePath = str;
    }

    public void setResolutionRatio(String str) {
        this.resolutionRatio = str;
    }

    public void setTextContent(String str) {
        this.textContent = str;
    }

    public void setTextSize(String str) {
        this.textSize = str;
    }
}
