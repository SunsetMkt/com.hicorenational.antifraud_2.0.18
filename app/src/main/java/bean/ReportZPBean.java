package bean;

import java.util.List;
import network.BaseBean;

/* loaded from: classes.dex */
public class ReportZPBean extends BaseBean {
    private List<ReportZPEleBean> children;
    private String clusterID;
    private int code;

    /* renamed from: id */
    private long f1619id;
    private String isShow;
    private String name;
    private String parentClusterID;
    private String sort;
    private String topClass;

    public List<ReportZPEleBean> getChildren() {
        return this.children;
    }

    public String getClusterID() {
        return this.clusterID;
    }

    public int getCode() {
        return this.code;
    }

    public long getId() {
        return this.f1619id;
    }

    public String getIsShow() {
        return this.isShow;
    }

    public String getName() {
        return this.name;
    }

    public String getParentClusterID() {
        return this.parentClusterID;
    }

    public String getSort() {
        return this.sort;
    }

    public String getTopClass() {
        return this.topClass;
    }

    public void setChildren(List<ReportZPEleBean> list) {
        this.children = list;
    }

    public void setClusterID(String str) {
        this.clusterID = str;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setId(long j2) {
        this.f1619id = j2;
    }

    public void setIsShow(String str) {
        this.isShow = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParentClusterID(String str) {
        this.parentClusterID = str;
    }

    public void setSort(String str) {
        this.sort = str;
    }

    public void setTopClass(String str) {
        this.topClass = str;
    }
}
