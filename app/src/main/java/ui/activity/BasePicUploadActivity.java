package ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
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
import ui.callview.BaseUploadView;
import ui.presenter.BasePicUploadPresenter;
import util.e2;
import util.w1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasePicUploadActivity extends BaseActivity implements BaseUploadView {
    public static final String UPLOAD_FINISH_TXT = "\u786e\u5b9a";
    public static final int UPLOAD_STATE_FAIL = 3;
    public static final int UPLOAD_STATE_LOADING = 0;
    public static final int UPLOAD_STATE_SUCCESS = 2;
    public static final int UPLOAD_STATE_UPLOAD = 1;
    protected boolean isScroll;
    protected boolean isScrollOver;
    private BasePicUploadPresenter mPresenter;
    private RecyclerView recyclerView;
    public ArrayList<UploadFileBean> mUploadPicList = new ArrayList<>();
    public ArrayList<UploadStateInfo> mUploadStateList = new ArrayList<>();
    public int mCurrentUploadIndex = -1;
    Handler scollViewHander = new b();
    Runnable scollRun = new Runnable() { // from class: ui.activity.i
        @Override // java.lang.Runnable
        public final void run() {
            this.a.a();
        }
    };

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                BasePicUploadActivity basePicUploadActivity = BasePicUploadActivity.this;
                basePicUploadActivity.scollViewHander.postDelayed(basePicUploadActivity.scollRun, 1500L);
            } else {
                BasePicUploadActivity basePicUploadActivity2 = BasePicUploadActivity.this;
                basePicUploadActivity2.isScroll = true;
                basePicUploadActivity2.scollViewHander.removeCallbacks(basePicUploadActivity2.scollRun);
                BasePicUploadActivity.this.isScrollOver = false;
            }
        }
    }

    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            BasePicUploadActivity.this.isScroll = false;
        }
    }

    class c implements IClickListener {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            try {
                if (BasePicUploadActivity.this.mUploadStateList.get(this.a).getUploadState() == 1) {
                    try {
                        BasePicUploadActivity.this.mPresenter.cancleDisposable();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                BasePicUploadActivity.this.cancelUpdateHttp(this.a);
                BasePicUploadActivity.this.clearItem(this.a);
                BasePicUploadActivity.this.mCurrentUploadIndex = -1;
                BasePicUploadActivity.this.UploadNextFile();
            } catch (Exception unused) {
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            BasePicUploadActivity.this.finishFile();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    public void UploadNextFile() {
        int i2;
        if (!w1.f()) {
            e2.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail();
            return;
        }
        nextUploadIndex();
        ArrayList<UploadStateInfo> arrayList = this.mUploadStateList;
        if (arrayList == null || (i2 = this.mCurrentUploadIndex) <= -1 || i2 >= arrayList.size()) {
            if (!isAllSuccess()) {
                changeBtnCommit("\u4e0a\u4f20\u6587\u4ef6", true);
                return;
            } else {
                finishFile();
                changeBtnCommit("\u786e\u5b9a", true);
                return;
            }
        }
        UploadFileBean uploadFileBean = this.mUploadPicList.get(this.mCurrentUploadIndex);
        createUpLoadInfo(uploadFileBean);
        changeBtnCommit("", false);
        this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(1);
        notifyAdapter();
        this.mPresenter.uploadDetail(upLoadFileUrl(), uploadFileBean);
    }

    public void cancelUpdateHttp(int i2) {
        String id = this.mUploadPicList.get(i2).getId();
        String strDeLoadFileUrl = deLoadFileUrl();
        if (TextUtils.isEmpty(strDeLoadFileUrl)) {
            this.mPresenter.deleteDetail(i2);
        } else {
            this.mPresenter.deleteDetail(strDeLoadFileUrl, id, i2);
        }
    }

    public void clearItem(int i2) {
        boolean z;
        removeLocalData(i2);
        this.mUploadStateList.remove(i2);
        this.mUploadPicList.remove(i2);
        int i3 = this.mCurrentUploadIndex;
        if (i3 > i2) {
            this.mCurrentUploadIndex = i3 - 1;
        } else if (i3 == i2) {
            this.mCurrentUploadIndex = -1;
        }
        this.recyclerView.getAdapter().notifyDataSetChanged();
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
            changeBtnCommit("\u786e\u5b9a", true);
        }
    }

    public void finishFile() {
        pageFileFinish();
    }

    private void prepareUp() {
        if (!w1.f()) {
            e2.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail();
            return;
        }
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1) {
            UploadFileBean uploadFileBean = this.mUploadPicList.get(i2);
            createUpLoadInfo(uploadFileBean);
            changeBtnCommit("", false);
            this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(1);
            notifyAdapter();
            this.mPresenter.uploadDetail(upLoadFileUrl(), uploadFileBean);
        }
    }

    private void resultDeal(boolean z) {
        int i2;
        ArrayList<UploadStateInfo> arrayList = this.mUploadStateList;
        if (arrayList != null && (i2 = this.mCurrentUploadIndex) > -1 && i2 < arrayList.size() && this.mCurrentUploadIndex < this.mUploadStateList.size()) {
            if (z) {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(2);
            } else {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(3);
                changeBtnCommit("\u4e0a\u4f20\u6587\u4ef6", true);
            }
            notifyAdapter();
        }
        UploadNextFile();
    }

    private void setRecyclerViewListener() {
        this.recyclerView.addOnScrollListener(new a());
    }

    private void setScrollViewListener(NestedScrollView nestedScrollView) {
        nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: ui.activity.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.a.a(view, motionEvent);
            }
        });
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.isScroll = true;
            this.scollViewHander.removeCallbacks(this.scollRun);
            this.isScrollOver = false;
        } else {
            this.scollViewHander.postDelayed(this.scollRun, 1500L);
        }
        return false;
    }

    public void backDialog() {
        util.f1.a(this.mActivity, "\u6709\u672a\u4e0a\u4f20\u6210\u529f\u7684\u6587\u4ef6\uff0c\u786e\u5b9a\u8fd4\u56de\uff1f", "", "\u662f", "\u5426", R.color._353536, -1, (IClickListener) new d());
    }

    public boolean backPressedUpload() {
        if (rejuctOperation(true)) {
            return true;
        }
        finishFile();
        return false;
    }

    protected void cancleUpLoad() {
        try {
            this.mPresenter.cancleDisposable();
        } catch (Exception unused) {
        }
    }

    public void changeBtnCommit(String str, boolean z) {
    }

    public void commitDeal() {
        if (isAllSuccess()) {
            finishFile();
            return;
        }
        if (isHasFail()) {
            resetToLoading();
        }
        nextUploadIndex();
        if (this.mCurrentUploadIndex > -1) {
            prepareUp();
        } else {
            finishFile();
        }
    }

    public void createUpLoadInfo(UploadFileBean uploadFileBean) {
    }

    public String deLoadFileUrl() {
        return "";
    }

    public void deleteDialog(int i2) {
        if (i2 >= this.mUploadStateList.size()) {
            return;
        }
        int uploadState = this.mUploadStateList.get(i2).getUploadState();
        if (uploadState != 0) {
            if (uploadState == 1) {
                util.f1.a(this.mActivity, "\u662f\u5426\u505c\u6b62\u4e0a\u4f20\u5e76\u5220\u9664\u6240\u9009\u8bb0\u5f55\uff1f", "", "\u662f", "\u5426", R.color._353536, -1, (IClickListener) new c(i2));
                return;
            }
            if (uploadState == 2) {
                if (w1.f()) {
                    cancelUpdateHttp(i2);
                    return;
                } else {
                    e2.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
                    return;
                }
            }
            if (uploadState != 3) {
                return;
            }
        }
        clearItem(i2);
    }

    public boolean deleteDoubleElement(List<LocalMedia> list, List<LocalMedia> list2, LocalMedia localMedia) {
        int size = list.size();
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
                                if (util.t1.a(new File(localMedia2.getPath())).equals(util.t1.a(new File(next.getPath())))) {
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
        return list.size() > size;
    }

    public int getChildSource() {
        return -1;
    }

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
        ArrayList<UploadStateInfo> arrayList = this.mUploadStateList;
        if (arrayList == null || arrayList.size() <= 0) {
            this.mCurrentUploadIndex = -1;
            util.s1.a("mCurrentUploadIndex-->-1 mUploadStateList");
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
        this.mPresenter = new BasePicUploadPresenter(this, this);
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mCurrentUploadIndex = -1;
        this.mUploadPicList.clear();
        this.mUploadStateList.clear();
    }

    @Override // ui.callview.BaseUploadView
    public void onDeteleSuccess(int i2) {
        clearItem(i2);
    }

    @Override // ui.callview.BaseUploadView
    public void onErrorRequest() {
        resultFail();
    }

    @Override // ui.callview.BaseUploadView
    public void onSaveSuccess() {
        UploadNextFile();
    }

    @Override // ui.callview.BaseUploadView
    public void onStartRequest() {
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1) {
            this.mUploadStateList.get(i2).setUploadState(1);
            changeBtnCommit("", false);
            notifyAdapter();
        }
    }

    @Override // ui.callview.BaseUploadView
    public void onUploadSuccess(String str, UploadFileBean uploadFileBean) {
        int i2 = this.mCurrentUploadIndex;
        if (i2 <= -1) {
            return;
        }
        UploadFileBean uploadFileBean2 = this.mUploadPicList.get(i2);
        if (!TextUtils.isEmpty(str)) {
            uploadFileBean2.setId(str);
            this.mUploadStateList.get(this.mCurrentUploadIndex).setFileId(str);
        }
        resultSuccess();
    }

    protected void pageFileFinish() {
        cancleUpLoad();
    }

    protected void recycleViewListener(NestedScrollView nestedScrollView, RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        if (nestedScrollView != null) {
            setScrollViewListener(nestedScrollView);
        } else {
            setRecyclerViewListener();
        }
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

    public String upLoadFileUrl() {
        return "";
    }

    public void uploadingTip() {
        e2.a("\u6587\u4ef6\u4e0a\u4f20\u4e2d\uff0c\u8bf7\u4e0a\u4f20\u5b8c\u6210\u540e\u64cd\u4f5c");
    }

    public /* synthetic */ void a() {
        this.scollViewHander.obtainMessage().sendToTarget();
    }
}
