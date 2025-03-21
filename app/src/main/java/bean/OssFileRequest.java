package bean;

import java.util.List;
import network.BaseBean;
import p286h.InterfaceC5713y;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: OssFileRequest.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, m23546d2 = {"Lbean/OssFileRequest;", "Lnetwork/BaseBean;", "()V", "fileMd5", "", "getFileMd5", "()Ljava/lang/String;", "setFileMd5", "(Ljava/lang/String;)V", "fileName", "getFileName", "setFileName", "filePath", "getFilePath", "setFilePath", "filePaths", "", "getFilePaths", "()Ljava/util/List;", "setFilePaths", "(Ljava/util/List;)V", "type", "getType", "setType", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class OssFileRequest extends BaseBean {

    @InterfaceC5817e
    private String fileMd5;

    @InterfaceC5817e
    private String fileName;

    @InterfaceC5817e
    private String filePath;

    @InterfaceC5817e
    private List<String> filePaths;

    @InterfaceC5817e
    private String type;

    @InterfaceC5817e
    public final String getFileMd5() {
        return this.fileMd5;
    }

    @InterfaceC5817e
    public final String getFileName() {
        return this.fileName;
    }

    @InterfaceC5817e
    public final String getFilePath() {
        return this.filePath;
    }

    @InterfaceC5817e
    public final List<String> getFilePaths() {
        return this.filePaths;
    }

    @InterfaceC5817e
    public final String getType() {
        return this.type;
    }

    public final void setFileMd5(@InterfaceC5817e String str) {
        this.fileMd5 = str;
    }

    public final void setFileName(@InterfaceC5817e String str) {
        this.fileName = str;
    }

    public final void setFilePath(@InterfaceC5817e String str) {
        this.filePath = str;
    }

    public final void setFilePaths(@InterfaceC5817e List<String> list) {
        this.filePaths = list;
    }

    public final void setType(@InterfaceC5817e String str) {
        this.type = str;
    }
}
