package p388ui.activity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import bean.OssFileInfo;
import bean.ReportResultBean;
import bean.UploadStateInfo;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import network.account.APIresult;
import network.alioss.AliOssClient;
import network.request.ReportCaseInfo;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import p388ui.callview.AudioCallView;
import p388ui.presenter.HandleFilePresenter;
import util.C7257b1;
import util.C7301n1;
import util.C7304o1;
import util.C7313q1;
import util.C7325u1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public abstract class BaseUploadActivity extends BaseActivity implements AudioCallView {
    public static final String UPLOAD_FINISH_TXT = "确定";
    public static final int UPLOAD_STATE_FAIL = 3;
    public static final int UPLOAD_STATE_LOADING = 0;
    public static final int UPLOAD_STATE_SUCCESS = 2;
    public static final int UPLOAD_STATE_UPLOAD = 1;
    public ReportCaseInfo info;
    private HandleFilePresenter mPresenter;
    public List<UploadStateInfo> mUploadStateList = new ArrayList();
    public int mCurrentUploadIndex = -1;

    /* renamed from: ui.activity.BaseUploadActivity$a */
    class C6146a implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ int f21876a;

        C6146a(int i2) {
            this.f21876a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            try {
                if (BaseUploadActivity.this.mUploadStateList.get(this.f21876a).getUploadState() == 1) {
                    AliOssClient.getInstance().taskCancle();
                }
                BaseUploadActivity.this.cancelUpdateHttp(this.f21876a);
                BaseUploadActivity.this.clearItem(this.f21876a);
                BaseUploadActivity.this.UploadNextFile();
            } catch (Exception unused) {
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* renamed from: ui.activity.BaseUploadActivity$b */
    class C6147b implements IClickListener {
        C6147b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            BaseUploadActivity.this.stopUpload();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* renamed from: ui.activity.BaseUploadActivity$c */
    class C6148c implements HandleFilePresenter.InterfaceC6991d {

        /* renamed from: ui.activity.BaseUploadActivity$c$a */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ OssFileInfo f21880a;

            a(OssFileInfo ossFileInfo) {
                this.f21880a = ossFileInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.f21880a != null) {
                        String filePath = this.f21880a.getFilePath();
                        if (!TextUtils.isEmpty(filePath)) {
                            BaseUploadActivity.this.mUploadStateList.get(BaseUploadActivity.this.mCurrentUploadIndex).setFilePath(filePath);
                        }
                        String fileMd5 = this.f21880a.getFileMd5();
                        if (!TextUtils.isEmpty(fileMd5)) {
                            BaseUploadActivity.this.mUploadStateList.get(BaseUploadActivity.this.mCurrentUploadIndex).setFileMd5(fileMd5);
                        }
                    }
                    BaseUploadActivity.this.doUpload();
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: ui.activity.BaseUploadActivity$c$b */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseUploadActivity.this.resultFail();
            }
        }

        C6148c() {
        }

        @Override // p388ui.presenter.HandleFilePresenter.InterfaceC6991d
        public void onSuccess(OssFileInfo ossFileInfo) {
            BaseUploadActivity.this.runOnUiThread(new a(ossFileInfo));
        }

        @Override // p388ui.presenter.HandleFilePresenter.InterfaceC6991d
        public void onfail() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                BaseUploadActivity.this.runOnUiThread(new b());
            } else {
                BaseUploadActivity.this.resultFail();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UploadNextFile() {
        int i2;
        nextUploadIndex();
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && (i2 = this.mCurrentUploadIndex) > -1 && i2 < list.size()) {
            setUpId();
            ossUpload(getChildPath());
        } else if (isAllSuccess()) {
            changeBtnCommit("确定", true);
        } else {
            changeBtnCommit("上传文件", true);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m25211a(APIresult aPIresult) {
        if (aPIresult.getCode() == 0) {
            C7301n1.m26459c("onNextMiddle--》", "成功");
        } else {
            C7331w1.m26688a("删除失败，请重试");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelUpdateHttp(int i2) {
        String fileId = this.mUploadStateList.get(i2).getFileId();
        if (TextUtils.isEmpty(fileId)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String upId = getUpId();
        if (TextUtils.isEmpty(upId)) {
            return;
        }
        hashMap.put("id", upId);
        if (this.mActivity instanceof AppActivity) {
            hashMap.put("appReportDetailId", fileId);
        } else {
            hashMap.put("reportDetailId", fileId);
        }
        this.mPresenter.cancelUpdateHttp(hashMap, new HandleFilePresenter.InterfaceC6990c() { // from class: ui.activity.h
            @Override // p388ui.presenter.HandleFilePresenter.InterfaceC6990c
            public final void onSuccRequest(APIresult aPIresult) {
                BaseUploadActivity.m25211a(aPIresult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItem(int i2) {
        boolean z;
        removeLocalData(i2);
        this.mUploadStateList.remove(i2);
        int i3 = this.mCurrentUploadIndex;
        if (i3 > i2) {
            this.mCurrentUploadIndex = i3 - 1;
        } else if (i3 == i2) {
            this.mCurrentUploadIndex = -1;
        }
        notifyAdapter();
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (it.next().getUploadState() != 2) {
                z = false;
                break;
            }
        }
        if (z) {
            changeBtnCommit("确定", true);
        }
    }

    private String getTruePath(String str) {
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getAuthority())) {
            return parse.getPath();
        }
        Cursor query = getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            if (query.moveToFirst()) {
                String string = query.getString(columnIndexOrThrow);
                query.close();
                return string;
            }
        }
        return "";
    }

    private void nextUploadFailIndex() {
        for (int i2 = 0; i2 < this.mUploadStateList.size(); i2++) {
            if (this.mUploadStateList.get(i2).getUploadState() == 3 || this.mUploadStateList.get(i2).getUploadState() == 1) {
                this.mUploadStateList.get(i2).setUploadState(0);
                return;
            }
        }
    }

    private void ossUpload(String str) {
        try {
            if (this.mCurrentUploadIndex > -1) {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(1);
                changeBtnCommit("", false);
                notifyAdapter();
            }
        } catch (Exception unused) {
        }
        this.mPresenter.ossUpload(str, new C6148c());
    }

    private void resultDeal(boolean z) {
        int i2;
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && (i2 = this.mCurrentUploadIndex) > -1 && i2 < list.size() && this.mCurrentUploadIndex < this.mUploadStateList.size()) {
            if (z) {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(2);
            } else {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(3);
                changeBtnCommit("上传文件", true);
            }
            notifyAdapter();
        }
        UploadNextFile();
    }

    public void backDialog() {
        C7257b1.m26183a(this.mActivity, "是否停止文件上传？", "", "是", "否", C2113R.color._353536, -1, (IClickListener) new C6147b());
    }

    public boolean backPressedUpload() {
        if (rejuctOperation(true)) {
            return true;
        }
        sendData();
        finish();
        return false;
    }

    public void changeBtnCommit(String str, boolean z) {
    }

    @Override // p388ui.activity.BaseActivity
    public void changePath(List<LocalMedia> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(getTruePath(list.get(i2).getPath()));
        }
    }

    public void commitDeal() {
        int i2;
        if (!C7313q1.m26534f()) {
            C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.err_timeout));
            networkFail();
            return;
        }
        if (isAllSuccess()) {
            sendData();
            finish();
            return;
        }
        nextUploadIndex();
        if (this.mCurrentUploadIndex <= -1) {
            nextUploadFailIndex();
            nextUploadIndex();
        }
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list == null || (i2 = this.mCurrentUploadIndex) <= -1 || i2 >= list.size()) {
            return;
        }
        createCaseInfo();
        ossUpload(getChildPath());
    }

    public void createCaseInfo() {
        if (this.info == null) {
            this.info = new ReportCaseInfo();
            this.info.setCommonParams();
        }
        setUpId();
    }

    public void deleteDialog(int i2) {
        if (i2 >= this.mUploadStateList.size()) {
            return;
        }
        int uploadState = this.mUploadStateList.get(i2).getUploadState();
        if (uploadState != 0) {
            if (uploadState == 1) {
                C7257b1.m26183a(this.mActivity, "是否停止上传并删除所选记录？", "", "是", "否", C2113R.color._353536, -1, (IClickListener) new C6146a(i2));
                return;
            }
            if (uploadState == 2) {
                if (!C7313q1.m26534f()) {
                    C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.err_timeout));
                    return;
                } else {
                    cancelUpdateHttp(i2);
                    clearItem(i2);
                    return;
                }
            }
            if (uploadState != 3) {
                return;
            }
        }
        clearItem(i2);
    }

    public void deleteDoubleElement(List<LocalMedia> list, List<LocalMedia> list2, LocalMedia localMedia) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null || (list2.size() <= 0 && localMedia != null)) {
            list2 = new ArrayList<>();
            list2.add(localMedia);
        }
        Iterator<LocalMedia> it = list2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            LocalMedia next = it.next();
            if (list.size() > 0) {
                for (LocalMedia localMedia2 : list) {
                    if (!next.getPath().equals(localMedia2.getPath())) {
                        if (Build.VERSION.SDK_INT > 28 && getChildSource() == 3) {
                            try {
                                String path = localMedia2.getPath();
                                String path2 = next.getPath();
                                if (C7304o1.m26466a(new File(path)).equals(C7304o1.m26466a(new File(path2)))) {
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    z = true;
                }
                if (!z) {
                    next.setChecked(true);
                    list.add(next);
                }
            } else {
                next.setChecked(true);
                list.add(next);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            LocalMedia localMedia3 = list.get(i2);
            if (localMedia3.isChecked()) {
                localMedia3.setChecked(false);
                this.mUploadStateList.add(i2, new UploadStateInfo());
            }
        }
    }

    public void doUpload() {
    }

    public String getChildPath() {
        return "";
    }

    public int getChildSource() {
        return -1;
    }

    public String getUpId() {
        return Hicore.fromPageReport ? ReportNewActivity.REPORT_UP_ID : C7325u1.m26625b(C7325u1.f25704w);
    }

    @Override // p388ui.activity.BaseActivity
    public abstract void initPage();

    public boolean isAllSuccess() {
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() != 2) {
                return false;
            }
        }
        return true;
    }

    public boolean isHasFail() {
        if (this.mUploadStateList.size() == 0) {
            return false;
        }
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isHasUpload() {
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() == 1) {
                return true;
            }
        }
        return false;
    }

    public void networkFail() {
    }

    public void nextUploadIndex() {
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list == null || list.size() <= 0) {
            this.mCurrentUploadIndex = -1;
            C7301n1.m26453a("mCurrentUploadIndex-->-1 mUploadStateList");
            return;
        }
        boolean z = false;
        int i2 = 0;
        boolean z2 = true;
        while (true) {
            if (i2 >= this.mUploadStateList.size()) {
                z = true;
                break;
            }
            if (this.mUploadStateList.get(i2).getUploadState() != 2) {
                z2 = false;
            }
            if (this.mUploadStateList.get(i2).getUploadState() == 0) {
                this.mCurrentUploadIndex = i2;
                break;
            }
            i2++;
        }
        if (z) {
            this.mCurrentUploadIndex = -1;
            C7301n1.m26453a("mCurrentUploadIndex-->-1 noLoading");
        }
        if (z2) {
            this.mCurrentUploadIndex = -1;
            C7301n1.m26453a("mCurrentUploadIndex-->-1 allSuccess");
        }
    }

    public void notifyAdapter() {
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C6049c.m24987f().m25001e(this);
        this.mPresenter = new HandleFilePresenter(this);
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @Override // p388ui.callview.AudioCallView
    public void onErrorRequest() {
        resultFail();
    }

    @InterfaceC6059m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a == 40 || m26297a == 50 || m26297a == 60 || m26297a == 70 || m26297a == 80) {
                C6049c.m24987f().m25002f(c7265a);
                redisplayData(c7265a);
            }
        }
    }

    @Override // p388ui.callview.AudioCallView
    public void onNextRequest(APIresult<ReportResultBean> aPIresult) {
        try {
            if (aPIresult.getCode() != 0) {
                C7331w1.m26688a(aPIresult.getMsg());
                resultFail();
                return;
            }
            ReportResultBean data = aPIresult.getData();
            if (data == null) {
                resultFail();
                return;
            }
            String id = data.getId();
            if (!TextUtils.isEmpty(id)) {
                if (Hicore.fromPageReport) {
                    ReportNewActivity.REPORT_UP_ID = id;
                } else {
                    C7325u1.m26630b(C7325u1.f25704w, id);
                }
            }
            if (this.mCurrentUploadIndex <= -1) {
                resultFail();
                return;
            }
            String appReportDetailId = TextUtils.isEmpty(data.getReportDetailId()) ? data.getAppReportDetailId() : data.getReportDetailId();
            if (!TextUtils.isEmpty(appReportDetailId)) {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setFileId(appReportDetailId);
            }
            resultSuccess();
        } catch (Exception unused) {
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // p388ui.callview.AudioCallView
    public void onStartRequest() {
    }

    public void onSuccessRequest(APIresult aPIresult) {
    }

    public void onfailRequest() {
    }

    public void redisplayData(C7265a c7265a) {
    }

    public boolean rejuctOperation(boolean z) {
        boolean isHasUpload = isHasUpload();
        if (isHasUpload) {
            if (z) {
                backDialog();
            } else {
                uploadingTip();
            }
        }
        return isHasUpload;
    }

    public void removeLocalData(int i2) {
    }

    public void resetToLoading() {
        for (UploadStateInfo uploadStateInfo : this.mUploadStateList) {
            if (uploadStateInfo.getUploadState() == 3) {
                uploadStateInfo.setUploadState(0);
            }
        }
    }

    public void resultFail() {
        resultDeal(false);
    }

    public void resultSuccess() {
        resultDeal(true);
    }

    public void sendData() {
    }

    @Override // p388ui.activity.BaseActivity
    public abstract int setLayoutView();

    public void setUpId() {
        if (this.info == null) {
            createCaseInfo();
        }
        ReportCaseInfo reportCaseInfo = this.info;
        if (reportCaseInfo == null || !TextUtils.isEmpty(reportCaseInfo.getId())) {
            return;
        }
        String m26625b = Hicore.fromPageReport ? ReportNewActivity.REPORT_UP_ID : C7325u1.m26625b(C7325u1.f25704w);
        if (TextUtils.isEmpty(m26625b)) {
            return;
        }
        this.info.setId(m26625b);
    }

    public void stopUpload() {
        try {
            if (this.mCurrentUploadIndex > -1) {
                if (this.mUploadStateList.get(this.mCurrentUploadIndex).getUploadState() == 1) {
                    AliOssClient.getInstance().taskCancle();
                    this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(3);
                }
                sendData();
                finish();
            }
        } catch (Exception unused) {
        }
    }

    public void uploadingTip() {
        C7331w1.m26688a("文件上传中，请上传完成后操作");
    }
}
