package ui.activity;

import adapter.AIInspectRecordAdapter;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AIInspectRecordBean;
import bean.Records;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.List;
import ui.callview.AIInspectRecordCallView;
import ui.presenter.AIInspectRecordPresenter;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class AIInspectRecordActivity extends BaseActivity implements BaseQuickAdapter.k, AIInspectRecordCallView {
    private AIInspectRecordAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @BindView(R.id.cl_no_data)
    ConstraintLayout mNoDataLayout;
    private AIInspectRecordPresenter mPresenter;

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    private Parcelable mRecyclerViewState;

    @BindView(R.id.mRefreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.rl_title)
    RelativeLayout mTitleBg;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_tip)
    TextView tvTip;
    private List<Records> mList = new ArrayList();
    private int page = 1;
    private int rows = 10;
    private int total = 0;

    class a implements com.scwang.smartrefresh.layout.d.b {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.b
        public void b(@NonNull com.scwang.smartrefresh.layout.b.j jVar) {
            AIInspectRecordActivity.access$008(AIInspectRecordActivity.this);
            if (AIInspectRecordActivity.this.mList.size() < AIInspectRecordActivity.this.total) {
                AIInspectRecordActivity.this.mPresenter.getVerifyList(AIInspectRecordActivity.this.page, AIInspectRecordActivity.this.rows);
            } else {
                e2.a("\u5df2\u7ecf\u5230\u5e95\u4e86");
                AIInspectRecordActivity.this.mRefreshLayout.b();
            }
        }
    }

    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                AIInspectRecordActivity.this.saveRecyclerViewState();
            }
        }
    }

    static /* synthetic */ int access$008(AIInspectRecordActivity aIInspectRecordActivity) {
        int i2 = aIInspectRecordActivity.page;
        aIInspectRecordActivity.page = i2 + 1;
        return i2;
    }

    private void initData() {
        this.mPresenter.getVerifyList(this.page, this.rows);
    }

    private void initView() {
        this.tvTip.setText("\u6682\u65e0\u8bb0\u5f55");
        this.mLayoutManager = new LinearLayoutManager(this);
        this.mTitleBg.setBackgroundColor(getResources().getColor(R.color.ai_verify_bg));
        this.mTvTitle.setText(getResources().getText(R.string.ai_verify_record));
        this.mTvTitle.setTextSize(2, 18.0f);
        this.mTvTitle.setTypeface(null, 1);
        this.mRefreshLayout.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this));
        this.mNoDataLayout.setVisibility(0);
        this.mRecyclerView.setVisibility(0);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mAdapter = new AIInspectRecordAdapter(this.mList, this);
        this.mAdapter.setOnItemClickListener(this);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRefreshLayout.a(new com.scwang.smartrefresh.layout.d.d() { // from class: ui.activity.a
            @Override // com.scwang.smartrefresh.layout.d.d
            public final void a(com.scwang.smartrefresh.layout.b.j jVar) {
                this.a.a(jVar);
            }
        });
        this.mRefreshLayout.a((com.scwang.smartrefresh.layout.d.b) new a());
        this.mRecyclerView.addOnScrollListener(new b());
    }

    private void restoreRecyclerViewState() {
        LinearLayoutManager linearLayoutManager;
        Parcelable parcelable = this.mRecyclerViewState;
        if (parcelable == null || (linearLayoutManager = this.mLayoutManager) == null) {
            return;
        }
        linearLayoutManager.onRestoreInstanceState(parcelable);
        this.mRecyclerViewState = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveRecyclerViewState() {
        LinearLayoutManager linearLayoutManager = this.mLayoutManager;
        if (linearLayoutManager != null) {
            this.mRecyclerViewState = linearLayoutManager.onSaveInstanceState();
        }
    }

    public /* synthetic */ void a(com.scwang.smartrefresh.layout.b.j jVar) {
        this.page = 1;
        this.mList.clear();
        this.mPresenter.getVerifyList(this.page, this.rows);
    }

    public List<Records> getData() {
        ArrayList arrayList = new ArrayList();
        Records records = new Records();
        records.setId(1001L);
        records.setCheckType(1);
        records.setCheckTime("2024-01-15 14:30:25");
        records.setAIGenerated(true);
        records.setOssFilePath("https://images.unsplash.com/photo-1635070041078-e363dbe005cb?auto=format&fit=crop&w=1920&h=1080");
        records.setLocalFilePath("/storage/emulated/0/Download/ai_generated_image.jpg");
        records.setFileFormat("jpg");
        records.setFileSize(2457600);
        records.setResolutionRatio("1920x1080");
        arrayList.add(records);
        Records records2 = new Records();
        records2.setId(1002L);
        records2.setCheckType(2);
        records2.setCheckTime("2024-01-15 15:45:10");
        records2.setAIGenerated(false);
        records2.setOssFilePath("https://player.vimeo.com/external/371433846.sd.mp4?s=2e9c7a64e3f1c7b2a2e3b2e7a3b2e7a3b2e7a3b2e&profile_id=164&oauth2_token_id=57447761");
        records2.setLocalFilePath("/storage/emulated/0/Movies/sample_video.mp4");
        records2.setFileFormat("mp4");
        records2.setFileSize(10485760);
        records2.setResolutionRatio("1920x1080");
        records2.setDuration("00:00:30");
        arrayList.add(records2);
        Records records3 = new Records();
        records3.setId(1003L);
        records3.setCheckType(3);
        records3.setCheckTime("2024-01-15 16:20:15");
        records3.setAIGenerated(true);
        records3.setOssFilePath("https://raw.githubusercontent.com/norvig/pytudes/master/data/ai-ethics.txt");
        records3.setLocalFilePath("/storage/emulated/0/Documents/ai_ethics.txt");
        records3.setFileFormat(SocializeConstants.KEY_TEXT);
        records3.setFileSize(10240);
        records3.setTextContent("\u4eba\u5de5\u667a\u80fd\u4f26\u7406\u662f\u5f53\u524d\u91cd\u8981\u8bae\u9898\uff0c\u6d89\u53ca\u9690\u79c1\u3001\u516c\u5e73\u3001\u900f\u660e\u5ea6\u7b49\u591a\u4e2a\u65b9\u9762...");
        records3.setTextSize("1250");
        arrayList.add(records3);
        Records records4 = new Records();
        records4.setId(1004L);
        records4.setCheckType(4);
        records4.setCheckTime("2024-01-15 17:10:40");
        records4.setAIGenerated(true);
        records4.setOssFilePath("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
        records4.setLocalFilePath("/storage/emulated/0/Music/ai_generated_music.mp3");
        records4.setFileFormat("mp3");
        records4.setFileSize(5242880);
        records4.setDuration("00:03:06");
        arrayList.add(records4);
        Records records5 = new Records();
        records5.setId(1005L);
        records5.setCheckType(2);
        records5.setCheckTime("2024-01-15 18:30:20");
        records5.setAIGenerated(true);
        records5.setOssFilePath("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4");
        records5.setLocalFilePath("/storage/emulated/0/Movies/deepfake_video.mp4");
        records5.setFileFormat("mp4");
        records5.setFileSize(15728640);
        records5.setResolutionRatio("1280x720");
        records5.setDuration("00:01:02");
        arrayList.add(records5);
        Records records6 = new Records();
        records6.setId(1006L);
        records6.setCheckType(1);
        records6.setCheckTime("2024-01-15 19:45:33");
        records6.setAIGenerated(true);
        records6.setOssFilePath("https://images.unsplash.com/photo-1677442136019-21780ecad995?auto=format&fit=crop&w=1920&h=1080");
        records6.setLocalFilePath("/storage/emulated/0/Download/ai_art_2.jpg");
        records6.setFileFormat("jpg");
        records6.setFileSize(3145728);
        records6.setResolutionRatio("1920x1080");
        arrayList.add(records6);
        Records records7 = new Records();
        records7.setId(1007L);
        records7.setCheckType(4);
        records7.setCheckTime("2024-01-15 20:15:50");
        records7.setAIGenerated(true);
        records7.setOssFilePath("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3");
        records7.setLocalFilePath("/storage/emulated/0/Music/ai_podcast.mp3");
        records7.setFileFormat("mp3");
        records7.setFileSize(8388608);
        records7.setDuration("00:08:45");
        arrayList.add(records7);
        Records records8 = new Records();
        records8.setId(1008L);
        records8.setCheckType(3);
        records8.setCheckTime("2024-01-15 21:05:12");
        records8.setAIGenerated(false);
        records8.setOssFilePath("https://raw.githubusercontent.com/public-apis/public-apis/master/README.md");
        records8.setLocalFilePath("/storage/emulated/0/Documents/public_apis.txt");
        records8.setFileFormat("md");
        records8.setFileSize(20480);
        records8.setTextContent("## \u516c\u5f00API\u5217\u8868\n\u8fd9\u662f\u4e00\u4e2a\u6536\u96c6\u516c\u5f00API\u7684\u9879\u76ee\uff0c\u5305\u542b\u5404\u79cd\u7c7b\u522b\u7684API...");
        records8.setTextSize("5000");
        arrayList.add(records8);
        Records records9 = new Records();
        records9.setId(1009L);
        records9.setCheckType(2);
        records9.setCheckTime("2024-01-15 22:30:18");
        records9.setAIGenerated(false);
        records9.setOssFilePath("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4");
        records9.setLocalFilePath("/storage/emulated/0/Movies/demo_video.mp4");
        records9.setFileFormat("mp4");
        records9.setFileSize(20971520);
        records9.setResolutionRatio("1920x1080");
        records9.setDuration("00:00:15");
        arrayList.add(records9);
        Records records10 = new Records();
        records10.setId(1010L);
        records10.setCheckType(1);
        records10.setCheckTime("2024-01-15 23:45:05");
        records10.setAIGenerated(true);
        records10.setOssFilePath("https://images.unsplash.com/photo-1682686580391-615b1f28e5ee?auto=format&fit=crop&w=1920&h=1080");
        records10.setLocalFilePath("/storage/emulated/0/Download/ai_landscape.jpg");
        records10.setFileFormat("jpg");
        records10.setFileSize(4194304);
        records10.setResolutionRatio("1920x1080");
        arrayList.add(records10);
        return arrayList;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mPresenter = new AIInspectRecordPresenter(this.mActivity, this);
        initView();
        initData();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.k
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        try {
            if (this.mList == null || this.mList.size() <= 0 || this.mList.get(i2) == null) {
                return;
            }
            Records records = this.mList.get(i2);
            Intent intent = new Intent(this, (Class<?>) AIInspectReportActivity.class);
            intent.putExtra(SocializeConstants.KEY_PLATFORM, records);
            intent.putExtra("verifyType", records.getCheckType());
            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // ui.callview.AIInspectRecordCallView
    public void onSuccessRequest(AIInspectRecordBean aIInspectRecordBean) {
        if (aIInspectRecordBean != null) {
            this.total = aIInspectRecordBean.getTotal();
            if (aIInspectRecordBean.getRows() != null && aIInspectRecordBean.getRows().size() > 0) {
                this.mList.addAll(aIInspectRecordBean.getRows());
                this.mAdapter.setNewData(this.mList);
                restoreRecyclerViewState();
            }
        }
        this.mRefreshLayout.g();
        this.mRefreshLayout.b();
        if (this.mList.size() == 0) {
            this.mNoDataLayout.setVisibility(0);
        } else {
            this.mNoDataLayout.setVisibility(8);
        }
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.iv_back) {
            return;
        }
        finish();
    }

    @Override // ui.callview.AIInspectRecordCallView
    public void onfailRequest() {
        e2.a("\u83b7\u53d6\u6570\u636e\u5f02\u5e38");
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_ai_inspect_record;
    }
}
