package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p388ui.Hicore;
import p388ui.callview.BaseUploadView;
import p388ui.presenter.BasePicUploadPresenter;
import util.C7257b1;
import util.C7301n1;
import util.C7304o1;
import util.C7313q1;
import util.C7331w1;

/* loaded from: classes2.dex */
public abstract class BasePicUploadActivity extends BaseActivity implements BaseUploadView {
    public static final String UPLOAD_FINISH_TXT = "确定";
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
    Handler scollViewHander = new HandlerC6141b();
    Runnable scollRun = new Runnable() { // from class: ui.activity.g
        @Override // java.lang.Runnable
        public final void run() {
            BasePicUploadActivity.this.m25209a();
        }
    };

    /* renamed from: ui.activity.BasePicUploadActivity$a */
    class C6140a extends RecyclerView.OnScrollListener {
        C6140a() {
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

    /* renamed from: ui.activity.BasePicUploadActivity$b */
    class HandlerC6141b extends Handler {
        HandlerC6141b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            BasePicUploadActivity.this.isScroll = false;
        }
    }

    /* renamed from: ui.activity.BasePicUploadActivity$c */
    class C6142c implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ int f21870a;

        C6142c(int i2) {
            this.f21870a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            try {
                if (BasePicUploadActivity.this.mUploadStateList.get(this.f21870a).getUploadState() == 1) {
                    try {
                        BasePicUploadActivity.this.mPresenter.cancleDisposable();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                BasePicUploadActivity.this.cancelUpdateHttp(this.f21870a);
                BasePicUploadActivity.this.clearItem(this.f21870a);
                BasePicUploadActivity.this.mCurrentUploadIndex = -1;
                BasePicUploadActivity.this.UploadNextFile();
            } catch (Exception unused) {
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* renamed from: ui.activity.BasePicUploadActivity$d */
    class C6143d implements IClickListener {
        C6143d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            BasePicUploadActivity.this.finishFile();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UploadNextFile() {
        int i2;
        if (!C7313q1.m26534f()) {
            C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.err_timeout));
            networkFail();
            return;
        }
        nextUploadIndex();
        ArrayList<UploadStateInfo> arrayList = this.mUploadStateList;
        if (arrayList == null || (i2 = this.mCurrentUploadIndex) <= -1 || i2 >= arrayList.size()) {
            if (!isAllSuccess()) {
                changeBtnCommit("上传文件", true);
                return;
            } else {
                finishFile();
                changeBtnCommit("确定", true);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelUpdateHttp(int i2) {
        String id = this.mUploadPicList.get(i2).getId();
        String deLoadFileUrl = deLoadFileUrl();
        if (TextUtils.isEmpty(deLoadFileUrl)) {
            this.mPresenter.deleteDetail(i2);
        } else {
            this.mPresenter.deleteDetail(deLoadFileUrl, id, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            changeBtnCommit("确定", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishFile() {
        pageFileFinish();
    }

    private void prepareUp() {
        if (!C7313q1.m26534f()) {
            C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.err_timeout));
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
                changeBtnCommit("上传文件", true);
            }
            notifyAdapter();
        }
        UploadNextFile();
    }

    private void setRecyclerViewListener() {
        this.recyclerView.addOnScrollListener(new C6140a());
    }

    private void setScrollViewListener(NestedScrollView nestedScrollView) {
        nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: ui.activity.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BasePicUploadActivity.this.m25210a(view, motionEvent);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ boolean m25210a(View view, MotionEvent motionEvent) {
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
        C7257b1.m26183a(this.mActivity, "有未上传成功的文件，确定返回？", "", "是", "否", C2113R.color._353536, -1, (IClickListener) new C6143d());
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
                C7257b1.m26183a(this.mActivity, "是否停止上传并删除所选记录？", "", "是", "否", C2113R.color._353536, -1, (IClickListener) new C6142c(i2));
                return;
            }
            if (uploadState == 2) {
                if (C7313q1.m26534f()) {
                    cancelUpdateHttp(i2);
                    return;
                } else {
                    C7331w1.m26688a(Hicore.getApp().getResources().getString(C2113R.string.err_timeout));
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
                                if (C7304o1.m26466a(new File(localMedia2.getPath())).equals(C7304o1.m26466a(new File(next.getPath())))) {
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
        if (this.mActivity.isFinishing()) {
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mPresenter = new BasePicUploadPresenter(this, this);
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mCurrentUploadIndex = -1;
        this.mUploadPicList.clear();
        this.mUploadStateList.clear();
    }

    @Override // p388ui.callview.BaseUploadView
    public void onDeteleSuccess(int i2) {
        clearItem(i2);
    }

    @Override // p388ui.callview.BaseUploadView
    public void onErrorRequest() {
        resultFail();
    }

    @Override // p388ui.callview.BaseUploadView
    public void onSaveSuccess() {
        UploadNextFile();
    }

    @Override // p388ui.callview.BaseUploadView
    public void onStartRequest() {
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1) {
            this.mUploadStateList.get(i2).setUploadState(1);
            changeBtnCommit("", false);
            notifyAdapter();
        }
    }

    @Override // p388ui.callview.BaseUploadView
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
        boolean isHasUpload;
        if (z) {
            isHasUpload = !isAllSuccess();
            if (isHasUpload) {
                backDialog();
            }
        } else {
            isHasUpload = isHasUpload();
            if (isHasUpload) {
                uploadingTip();
            }
        }
        return isHasUpload;
    }

    public void removeLocalData(int i2) {
    }

    public void resetToLoading() {
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (it.hasNext()) {
            UploadStateInfo next = it.next();
            if (next.getUploadState() == 3) {
                next.setUploadState(0);
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
        C7331w1.m26688a("文件上传中，请上传完成后操作");
    }

    /* renamed from: a */
    public /* synthetic */ void m25209a() {
        this.scollViewHander.obtainMessage().sendToTarget();
    }
}
