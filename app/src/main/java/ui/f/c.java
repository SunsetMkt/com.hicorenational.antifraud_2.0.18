package ui.f;

import adapter.HRecyclerViewAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ShareConfigBean;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import manager.AccountManager;
import manager.BaseDialog;
import util.e2;
import util.g2;

/* JADX INFO: compiled from: HiShareDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends BaseDialog implements d {
    private int a;

    /* JADX INFO: renamed from: b */
    private Activity f14112b;

    /* JADX INFO: renamed from: c */
    private String f14113c;

    /* JADX INFO: renamed from: e */
    private String f14114e;

    /* JADX INFO: renamed from: f */
    private String f14115f;

    /* JADX INFO: renamed from: g */
    private UMImage f14116g;

    /* JADX INFO: renamed from: h */
    private ShareAction f14117h;

    /* JADX INFO: renamed from: i */
    private e f14118i;

    /* JADX INFO: renamed from: j */
    private ShareConfigBean f14119j;

    /* JADX INFO: renamed from: k */
    private b f14120k;

    /* JADX INFO: renamed from: l */
    private UMShareListener f14121l;

    /* JADX INFO: compiled from: HiShareDialog.java */
    class a implements UMShareListener {
        a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA share_media) {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA share_media, Throwable th) {
            e2.a("\u5206\u4eab\u5931\u8d25");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA share_media) {
            e2.a("\u5206\u4eab\u6210\u529f");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: compiled from: HiShareDialog.java */
    public interface b {
        void a();
    }

    public c(Activity activity, ShareConfigBean shareConfigBean, int i2) {
        super(activity, R.style.base_dialog_style);
        this.f14113c = e.a.f10142f + "/QRCode/?appkey=a28ft4&pcode=10000";
        this.f14114e = "\u4e0b\u8f7d\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3APP,\u516c\u5b89\u90e8\u6253\u51fb\u9632\u8303\u7535\u4fe1\u7f51\u7edc\u8bc8\u9a97\u5b98\u65b9\u5e94\u7528";
        this.f14115f = "\u770b\u66f4\u591a\u53cd\u8bc8\u6587\u7ae0\uff0c\u4e0a\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3APP";
        this.f14120k = null;
        this.f14121l = new a();
        this.f14112b = activity;
        this.a = i2;
        this.f14119j = shareConfigBean;
        this.f14117h = new ShareAction(this.f14112b);
        this.f14118i = new e(this.f14112b, shareConfigBean);
        b();
    }

    @SuppressLint({"ResourceType"})
    private void b() {
        setContentView(R.layout.share_dlg);
        setGravityLayout(0);
        setWidthDialog(-2.0d);
        setHeightDialogdp(-2.0f);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        initOnCreate();
        getWindow().setWindowAnimations(R.anim.anim_bottom_in);
        findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() { // from class: ui.f.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.h_recyclerview);
        HRecyclerViewAdapter hRecyclerViewAdapter = new HRecyclerViewAdapter(this.f14112b, this.a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f14112b);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(hRecyclerViewAdapter);
        hRecyclerViewAdapter.setOnItemClickListener(new HRecyclerViewAdapter.a() { // from class: ui.f.a
            @Override // adapter.HRecyclerViewAdapter.a
            public final void a(int i2, String str) {
                this.a.a(i2, str);
            }
        });
        ShareConfigBean shareConfigBean = this.f14119j;
        if (shareConfigBean != null) {
            if (!TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                this.f14113c = this.f14119j.downloadUrl;
            }
            if (!TextUtils.isEmpty(this.f14119j.title)) {
                this.f14114e = this.f14119j.title;
            }
            if (!TextUtils.isEmpty(this.f14119j.description)) {
                this.f14115f = this.f14119j.description;
            }
            if (TextUtils.isEmpty(this.f14119j.iconUrl)) {
                this.f14116g = new UMImage(this.f14112b, R.mipmap.logo);
            } else {
                this.f14116g = new UMImage(this.f14112b, this.f14119j.iconUrl);
            }
        } else {
            this.f14116g = new UMImage(this.f14112b, R.mipmap.logo);
        }
        this.f14113c += AccountManager.getShareParam();
    }

    public /* synthetic */ void a(View view) {
        dismiss();
    }

    private void a(String str) {
        if (TextUtils.equals("\u5fae\u535a", str)) {
            this.f14115f = this.f14114e;
        }
        int i2 = this.a;
        if (i2 == 3) {
            UMImage uMImage = new UMImage(this.f14112b, this.f14113c);
            uMImage.setTitle(this.f14114e);
            uMImage.setThumb(this.f14116g);
            uMImage.setDescription(this.f14115f);
            this.f14117h.withMedia(uMImage);
            return;
        }
        if (i2 == 4) {
            UMVideo uMVideo = new UMVideo(this.f14113c);
            uMVideo.setTitle(this.f14114e);
            uMVideo.setThumb(this.f14116g);
            uMVideo.setDescription(this.f14115f);
            this.f14117h.withMedia(uMVideo);
            return;
        }
        UMWeb uMWeb = new UMWeb(this.f14113c);
        uMWeb.setTitle(this.f14114e);
        uMWeb.setThumb(this.f14116g);
        uMWeb.setDescription(this.f14115f);
        this.f14117h.withMedia(uMWeb);
    }

    public c(Activity activity, ShareConfigBean shareConfigBean, int i2, b bVar) {
        super(activity, R.style.base_dialog_style);
        this.f14113c = e.a.f10142f + "/QRCode/?appkey=a28ft4&pcode=10000";
        this.f14114e = "\u4e0b\u8f7d\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3APP,\u516c\u5b89\u90e8\u6253\u51fb\u9632\u8303\u7535\u4fe1\u7f51\u7edc\u8bc8\u9a97\u5b98\u65b9\u5e94\u7528";
        this.f14115f = "\u770b\u66f4\u591a\u53cd\u8bc8\u6587\u7ae0\uff0c\u4e0a\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3APP";
        this.f14120k = null;
        this.f14121l = new a();
        this.f14112b = activity;
        this.a = i2;
        this.f14119j = shareConfigBean;
        this.f14117h = new ShareAction(this.f14112b);
        this.f14118i = new e(this.f14112b, shareConfigBean);
        this.f14120k = bVar;
        b();
    }

    public static boolean a(Activity activity, SHARE_MEDIA share_media) {
        return UMShareAPI.get(activity).isInstall(activity, share_media);
    }

    private void a() {
        b bVar = this.f14120k;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: renamed from: b */
    public void a(int i2, String str) {
        a(str);
        switch (i2) {
            case 0:
                if (a(this.f14112b, SHARE_MEDIA.WEIXIN)) {
                    a();
                    this.f14117h.setPlatform(SHARE_MEDIA.WEIXIN).share();
                } else {
                    e2.a("\u60a8\u672a\u5b89\u88c5\u5fae\u4fe1");
                }
                break;
            case 1:
                if (a(this.f14112b, SHARE_MEDIA.WEIXIN)) {
                    a();
                    this.f14117h.setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).share();
                } else {
                    e2.a("\u60a8\u672a\u5b89\u88c5\u5fae\u4fe1");
                }
                break;
            case 2:
                if (a(this.f14112b, SHARE_MEDIA.QQ)) {
                    a();
                    this.f14117h.setPlatform(SHARE_MEDIA.QQ).setCallback(this.f14121l).share();
                } else {
                    e2.a("\u5206\u4eab\u5931\u8d25");
                }
                break;
            case 3:
                if (a(this.f14112b, SHARE_MEDIA.QZONE)) {
                    a();
                    this.f14117h.setPlatform(SHARE_MEDIA.QZONE).setCallback(this.f14121l).share();
                } else {
                    e2.a("\u5206\u4eab\u5931\u8d25");
                }
                break;
            case 4:
                a();
                this.f14117h.setPlatform(SHARE_MEDIA.SINA).setCallback(this.f14121l).share();
                break;
            case 5:
                if (a(this.f14112b, SHARE_MEDIA.DINGTALK)) {
                    a();
                    this.f14117h.setPlatform(SHARE_MEDIA.DINGTALK).setCallback(this.f14121l).share();
                } else {
                    e2.a("\u60a8\u672a\u5b89\u88c5\u9489\u9489");
                }
                break;
            case 6:
                int i3 = this.a;
                if (i3 == 1) {
                    this.f14118i.show();
                    a();
                } else if (i3 == 2) {
                    g2.s(this.f14113c);
                    a();
                }
                break;
        }
        dismiss();
    }
}
