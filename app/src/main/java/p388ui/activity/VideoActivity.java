package p388ui.activity;

import adapter.PictureSelectAdapter;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import network.ReportAppInfo;
import org.greenrobot.eventbus.C6049c;
import p357j.C5846e;
import p388ui.presenter.VideoPresenter;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class VideoActivity extends BaseUploadActivity implements PictureSelectAdapter.InterfaceC0068b, BaseQuickAdapter.InterfaceC1895i {
    private PictureSelectAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private int mMaxSelectNum = 9;
    private VideoPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.VideoActivity$a */
    class C6661a implements PermissionsListener {
        C6661a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(VideoActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(VideoActivity.this.mActivity, 200L, PictureMimeType.ofVideo(), VideoActivity.this.mMaxSelectNum - VideoActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6661a());
    }

    private ReportAppInfo createReport() {
        int i2;
        ReportAppInfo reportAppInfo = new ReportAppInfo();
        String childPath = getChildPath();
        reportAppInfo.setSource(5);
        reportAppInfo.setSource(getChildSource());
        reportAppInfo.setFileLocalPath(childPath);
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && list.size() > 0 && (i2 = this.mCurrentUploadIndex) > -1) {
            reportAppInfo.setFilePath(this.mUploadStateList.get(i2).getFilePath());
            reportAppInfo.setFileMd5(this.mUploadStateList.get(this.mCurrentUploadIndex).getFileMd5());
        }
        return reportAppInfo;
    }

    private void stopPlayVedio(int i2) {
        try {
            ((JzvdStd) this.mAdapter.m5094a(i2, C2113R.id.image_view)).mo2479o();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (isFinishing() || this.mBtnCommit == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mBtnCommit.setText(str);
        }
        this.mBtnCommit.setEnabled(z);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void doUpload() {
        this.mPresenter.doAudioUpload(createReport(), this.info);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public String getChildPath() {
        return this.mLocalMedia.get(this.mCurrentUploadIndex).getPath();
    }

    @Override // p388ui.activity.BaseUploadActivity
    public int getChildSource() {
        return 5;
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加视频");
        this.mTvCommitTip.setText(getResources().getString(C2113R.string.commit_tip_start_str) + this.mMaxSelectNum + "个视频");
        this.mPresenter = new VideoPresenter(this);
        this.mPresenter.attachView(this);
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        this.mAdapter = new PictureSelectAdapter(C2113R.layout.layout_cell_video, this.mLocalMedia, PictureSelectAdapter.f241b0, this.mMaxSelectNum, this.mUploadStateList);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mAdapter.setOnItemClickListener(this);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void notifyAdapter() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        List<LocalMedia> obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(obtainMultipleResult);
        }
        deleteDoubleElement(this.mLocalMedia, C7337y1.m26741a(obtainMultipleResult), null);
        if (this.mUploadStateList.size() <= 0) {
            for (int i4 = 0; i4 < this.mLocalMedia.size(); i4++) {
                this.mUploadStateList.add(new UploadStateInfo());
            }
        }
        this.mAdapter.notifyDataSetChanged();
        if (isAllSuccess()) {
            changeBtnCommit("确定", true);
        } else {
            changeBtnCommit("文件上传", true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (backPressedUpload()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Jzvd.m2440F();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != C2113R.id.iv_clear) {
            return;
        }
        deleteDialog(i2);
        Jzvd.m2438D();
    }

    @Override // adapter.PictureSelectAdapter.InterfaceC0068b
    public void onItemClickListener(int i2, List<LocalMedia> list) {
        if (i2 != list.size() || rejuctOperation(false)) {
            return;
        }
        checkPermission();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_commit) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            onBackPressed();
        } else {
            if (LoginManager.getInstance().isLogOut()) {
                return;
            }
            List<LocalMedia> list = this.mLocalMedia;
            if (list == null || list.size() <= 0) {
                onBackPressed();
            } else {
                Jzvd.m2440F();
                commitDeal();
            }
        }
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void redisplayData(C7265a c7265a) {
        List list = (List) c7265a.m26300b();
        if (list != null && list.size() > 0) {
            this.mLocalMedia.addAll(list);
        }
        List list2 = (List) c7265a.m26304d();
        if (list2 != null && list2.size() > 0) {
            this.mUploadStateList.addAll(list2);
        }
        this.mAdapter.notifyDataSetChanged();
        if (isAllSuccess()) {
            return;
        }
        changeBtnCommit("上传文件", true);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void removeLocalData(int i2) {
        stopPlayVedio(i2);
        this.mLocalMedia.remove(i2);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void sendData() {
        C6049c.m24987f().m25000d(new C7265a(7, this.mLocalMedia, this.mUploadStateList));
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_picture;
    }
}
