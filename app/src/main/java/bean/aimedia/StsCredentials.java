package bean.aimedia;

import network.BaseBean;

/* JADX INFO: loaded from: classes.dex */
public class StsCredentials extends BaseBean {
    private String bucketName;
    private String endPoint;
    private String path;
    private StsCredentialsType stsCredentials;

    public String getbucketName() {
        return this.bucketName;
    }

    public String getendPoint() {
        return this.endPoint;
    }

    public String getpath() {
        return this.path;
    }

    public StsCredentialsType getstsCredentials() {
        return this.stsCredentials;
    }

    public void setbucketName(String str) {
        this.bucketName = str;
    }

    public void setendPoint(String str) {
        this.endPoint = str;
    }

    public void setpath(String str) {
        this.path = str;
    }

    public void setstsCredentials(StsCredentialsType stsCredentialsType) {
        this.stsCredentials = stsCredentialsType;
    }
}
