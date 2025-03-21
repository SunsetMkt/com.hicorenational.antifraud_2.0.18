package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class GuideBean extends BaseBean {
    public static final int GUIDE_CODE_AUTO = 10005;
    public static final int GUIDE_CODE_FLOW = 10001;
    public static final int GUIDE_CODE_LOCK = 10007;
    public static final int GUIDE_CODE_PHONE = 10002;
    public static final int GUIDE_CODE_PHONE_RECORD = 10003;
    public static final int GUIDE_CODE_POWER = 10006;
    public static final int GUIDE_CODE_SMS = 10004;
    private int code;
    private String content;
    private String createTime;

    /* renamed from: id */
    private int f1598id;
    private String imgUrl;
    private String updateTime;

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public int getId() {
        return this.f1598id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setId(int i2) {
        this.f1598id = i2;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }
}
