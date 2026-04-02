package ui.activity;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ui.Hicore;
import util.e2;
import util.w1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProgressUploadActivity extends BaseActivity {
    public static final int DATA_TYPE_1 = 1;
    public static final int DATA_TYPE_2 = 2;
    public static final int REQUESTION_CODE_RECORD = 2000;
    public static final int REQUESTION_CODE_RECORD_AUDIO_1 = 2001;
    public static final int REQUESTION_CODE_RECORD_AUDIO_2 = 2002;
    public static final String UPLOAD_FINISH_TXT = "\u786e\u5b9a";
    public static final int UPLOAD_STATE_FAIL = 3;
    public static final int UPLOAD_STATE_LOADING = 0;
    public static final int UPLOAD_STATE_SUCCESS = 2;
    public static final int UPLOAD_STATE_UPLOAD = 1;
    private boolean isDataType2 = false;
    public List<UploadFileBean> mUploadList = new ArrayList();
    public List<UploadFileBean> mFirstUploadList = new ArrayList();
    public List<UploadFileBean> mSecondUploadList = new ArrayList();
    public List<UploadStateInfo> mStateList = new ArrayList();
    public List<UploadStateInfo> mFirstStateList = new ArrayList();
    public List<UploadStateInfo> mSecondStateList = new ArrayList();
    public int mCurrentUploadIndex = -1;
    private boolean isUploadOne = false;

    class a implements IClickListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            try {
                if (BaseProgressUploadActivity.this.mStateList.get(this.a).getUploadState() == 1) {
                    try {
                        BaseProgressUploadActivity.this.cancleDisposable();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                BaseProgressUploadActivity.this.deteleUpload(this.a);
                BaseProgressUploadActivity.this.clearItem(this.a);
                BaseProgressUploadActivity.this.UploadNextFile();
            } catch (Exception unused) {
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            BaseProgressUploadActivity.this.stopUpload();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UploadNextFile() {
        List<UploadStateInfo> list;
        if (this.isUploadOne) {
            this.isUploadOne = false;
            if (isHasFail()) {
                return;
            }
            changeBtnCommit("\u786e\u5b9a", true);
            return;
        }
        if (!w1.f()) {
            e2.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail2Fail();
            networkFail();
            return;
        }
        nextUploadIndex();
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1 && (list = this.mStateList) != null && i2 < list.size()) {
            doUpload();
            return;
        }
        if (isAllSuccess()) {
            finishFile();
            changeBtnCommit("\u786e\u5b9a", true);
        } else {
            if (isHasFail()) {
                return;
            }
            changeBtnCommit("\u4e0a\u4f20\u6587\u4ef6", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItem(int i2) {
        boolean z;
        removeLocalData(i2);
        this.mStateList.remove(i2);
        this.mUploadList.remove(i2);
        notifyAdapter();
        Iterator<UploadStateInfo> it = this.mStateList.iterator();
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
            changeBtnCommit("\u786e\u5b9a", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deteleUpload(int i2) {
        String id = this.mUploadList.get(i2).getId();
        if (id == null) {
            return;
        }
        deteleUploadHttp(id + "");
    }

    private void doUpload() {
        changeBtnCommit("", false);
        this.mStateList.get(this.mCurrentUploadIndex).setUploadState(1);
        notifyAdapter();
        doUploadHttp();
    }

    private void networkFail2Fail() {
        loadingToFail();
        notifyAdapter();
        changeBtnCommit("", false);
    }

    private void nextUploadFailIndex() {
        for (int i2 = 0; i2 < this.mStateList.size(); i2++) {
            if (this.mStateList.get(i2).getUploadState() == 3 || this.mStateList.get(i2).getUploadState() == 1) {
                this.mStateList.get(i2).setUploadState(0);
                return;
            }
        }
    }

    private void prepareUp() {
        List<UploadStateInfo> list;
        if (!w1.f()) {
            e2.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail2Fail();
            networkFail();
        } else {
            int i2 = this.mCurrentUploadIndex;
            if (i2 <= -1 || (list = this.mStateList) == null || i2 >= list.size()) {
                return;
            }
            doUpload();
        }
    }

    private void resultDeal(boolean z) {
        int i2;
        List<UploadStateInfo> list = this.mStateList;
        if (list != null && (i2 = this.mCurrentUploadIndex) > -1 && i2 < list.size() && this.mCurrentUploadIndex < this.mStateList.size()) {
            if (z) {
                this.mStateList.get(this.mCurrentUploadIndex).setUploadState(2);
            } else {
                this.mStateList.get(this.mCurrentUploadIndex).setUploadState(3);
            }
            notifyAdapter();
        }
        UploadNextFile();
    }

    public void UploadOneFile(int i2) {
        List<UploadStateInfo> list;
        if (!w1.f()) {
            e2.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail();
            return;
        }
        this.isUploadOne = true;
        this.mCurrentUploadIndex = i2;
        int i3 = this.mCurrentUploadIndex;
        if (i3 > -1 && (list = this.mStateList) != null && i3 < list.size()) {
            doUpload();
            return;
        }
        if (isAllSuccess()) {
            finishFile();
            changeBtnCommit("\u786e\u5b9a", true);
        } else {
            if (isHasFail()) {
                return;
            }
            changeBtnCommit("\u4e0a\u4f20\u6587\u4ef6", true);
        }
    }

    public void backDialog() {
        util.f1.a(this.mActivity, "\u6709\u672a\u4e0a\u4f20\u6210\u529f\u7684\u6587\u4ef6\uff0c\u786e\u5b9a\u8fd4\u56de\uff1f", "", "\u662f", "\u5426", R.color._353536, -1, (IClickListener) new b());
    }

    public boolean backPressedUpload() {
        if (rejuctOperation(true)) {
            return true;
        }
        creatAllData();
        finishFile();
        return false;
    }

    public void cancleDisposable() {
    }

    public void changeBtnCommit(String str, boolean z) {
    }

    public void commitDeal() {
        creatAllData();
        if (!w1.f()) {
            e2.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail2Fail();
            networkFail();
        } else {
            if (isAllSuccess()) {
                finishFile();
                return;
            }
            if (isHasFail()) {
                failToLoading();
            }
            nextUploadIndex();
            if (this.mCurrentUploadIndex > -1) {
                prepareUp();
            } else {
                finishFile();
            }
        }
    }

    public void creatAllData() {
        if (this.isDataType2) {
            this.mUploadList.clear();
            this.mUploadList.addAll(this.mFirstUploadList);
            this.mUploadList.addAll(this.mSecondUploadList);
            this.mStateList.clear();
            this.mStateList.addAll(this.mFirstStateList);
            this.mStateList.addAll(this.mSecondStateList);
        }
    }

    public void deleteDialog(int i2) {
        if (i2 >= this.mStateList.size()) {
            return;
        }
        int uploadState = this.mStateList.get(i2).getUploadState();
        if (uploadState != 0) {
            if (uploadState == 1) {
                util.f1.a(this.mActivity, "\u662f\u5426\u505c\u6b62\u4e0a\u4f20\u5e76\u5220\u9664\u6240\u9009\u8bb0\u5f55\uff1f", "", "\u662f", "\u5426", R.color._353536, -1, (IClickListener) new a(i2));
                return;
            }
            if (uploadState == 2) {
                if (!w1.f()) {
                    e2.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
                    return;
                } else {
                    deteleUpload(i2);
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

    public void deleteDoubleElement(List<LocalMedia> list, List<LocalMedia> list2, LocalMedia localMedia, List<UploadFileBean> list3, List<UploadStateInfo> list4) {
        if (list == null || list3 == null || list4 == null) {
            e2.a("\u804a\u5f55\u53bb\u91cd\uff0c\u8bf7\u5148\u521d\u59cb\u5316\u6570\u636e");
            return;
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
                                if (util.t1.a(new File(path)).equals(util.t1.a(new File(path2)))) {
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
                UploadFileBean uploadFileBean = new UploadFileBean();
                uploadFileBean.setLocalPath(localMedia3.getPath());
                uploadFileBean.setFileName(localMedia3.getFileName());
                uploadFileBean.setFileSize(localMedia3.getSize());
                list3.add(i2, uploadFileBean);
                list4.add(i2, new UploadStateInfo(localMedia3.getSize()));
            }
        }
    }

    public void deteleUploadHttp(String str) {
    }

    public void doUploadHttp() {
    }

    public void failToLoading() {
        for (UploadStateInfo uploadStateInfo : this.mStateList) {
            if (uploadStateInfo.getUploadState() == 3) {
                uploadStateInfo.setUploadState(0);
            }
        }
    }

    public void finishFile() {
    }

    public int getChildSource() {
        return -1;
    }

    public int getDataType() {
        return 1;
    }

    public List<UploadFileBean> getOldData() {
        return null;
    }

    public List<UploadFileBean> getSecondOldData() {
        return null;
    }

    public boolean isAllSuccess() {
        Iterator<UploadStateInfo> it = this.mStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() != 2) {
                return false;
            }
        }
        return true;
    }

    public boolean isHasFail() {
        if (this.mStateList.size() == 0) {
            return false;
        }
        Iterator<UploadStateInfo> it = this.mStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isHasUpload() {
        Iterator<UploadStateInfo> it = this.mStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() == 1) {
                return true;
            }
        }
        return false;
    }

    public void loadingToFail() {
        for (UploadStateInfo uploadStateInfo : this.mStateList) {
            if (uploadStateInfo.getUploadState() == 0) {
                uploadStateInfo.setUploadState(3);
            }
        }
    }

    public void networkFail() {
    }

    public void nextUploadIndex() {
        List<UploadStateInfo> list = this.mStateList;
        if (list == null || list.size() <= 0) {
            this.mCurrentUploadIndex = -1;
            util.s1.a("mCurrentUploadIndex-->-1 mUploadStateList");
            return;
        }
        boolean z = false;
        int i2 = 0;
        boolean z2 = true;
        while (true) {
            if (i2 >= this.mStateList.size()) {
                z = true;
                break;
            }
            if (this.mStateList.get(i2).getUploadState() != 2) {
                z2 = false;
            }
            if (this.mStateList.get(i2).getUploadState() == 0) {
                this.mCurrentUploadIndex = i2;
                break;
            }
            i2++;
        }
        if (z) {
            this.mCurrentUploadIndex = -1;
            util.s1.a("mCurrentUploadIndex-->-1 noLoading");
        }
        if (z2) {
            this.mCurrentUploadIndex = -1;
            util.s1.a("mCurrentUploadIndex-->-1 allSuccess");
        }
    }

    public void notifyAdapter() {
        if (this.mActivity.isFinishing()) {
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getDataType() != 2) {
            redisplayData(this.mUploadList);
            return;
        }
        this.isDataType2 = true;
        redisplayData(this.mFirstUploadList);
        secondRedisplayData(this.mSecondUploadList);
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mCurrentUploadIndex = -1;
        this.mFirstUploadList.clear();
        this.mFirstStateList.clear();
        this.mSecondUploadList.clear();
        this.mSecondStateList.clear();
        this.mUploadList.clear();
        this.mStateList.clear();
        this.mUploadList.clear();
        this.mStateList.clear();
    }

    public void redisplayData(List<UploadFileBean> list) {
    }

    public boolean rejuctOperation(boolean z) {
        boolean zIsHasUpload;
        if (z) {
            zIsHasUpload = !isAllSuccess();
            if (zIsHasUpload) {
                backDialog();
            }
        } else {
            zIsHasUpload = isHasUpload();
            if (zIsHasUpload) {
                uploadingTip();
            }
        }
        return zIsHasUpload;
    }

    public void removeLocalData(int i2) {
    }

    public void resultFail() {
        resultDeal(false);
    }

    public void resultSuccess() {
        resultDeal(true);
    }

    public void secondRedisplayData(List<UploadFileBean> list) {
    }

    public void startRequest() {
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1) {
            this.mStateList.get(i2).setUploadState(1);
            changeBtnCommit("", false);
            notifyAdapter();
        }
    }

    public void stopUpload() {
        finishFile();
        if (this.mCurrentUploadIndex > -1) {
            finish();
        }
    }

    public void uploadingTip() {
        e2.a("\u6587\u4ef6\u4e0a\u4f20\u4e2d\uff0c\u8bf7\u4e0a\u4f20\u5b8c\u6210\u540e\u64cd\u4f5c");
    }
}
