package p388ui.p391f;

import adapter.HRecyclerViewAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ShareConfigBean;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import manager.AccountManager;
import manager.BaseDialog;
import p245d.C4440a;
import util.C7331w1;
import util.C7337y1;

/* compiled from: HiShareDialog.java */
/* renamed from: ui.f.c */
/* loaded from: classes2.dex */
public class DialogC6827c extends BaseDialog implements InterfaceC6828d {

    /* renamed from: a */
    private int f23720a;

    /* renamed from: b */
    private Activity f23721b;

    /* renamed from: c */
    private String f23722c;

    /* renamed from: e */
    private String f23723e;

    /* renamed from: f */
    private String f23724f;

    /* renamed from: g */
    private UMImage f23725g;

    /* renamed from: h */
    private ShareAction f23726h;

    /* renamed from: i */
    private ViewOnClickListenerC6829e f23727i;

    /* renamed from: j */
    private ShareConfigBean f23728j;

    /* renamed from: k */
    private b f23729k;

    /* renamed from: l */
    private UMShareListener f23730l;

    /* compiled from: HiShareDialog.java */
    /* renamed from: ui.f.c$a */
    class a implements UMShareListener {
        a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA share_media) {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA share_media, Throwable th) {
            C7331w1.m26688a("分享失败");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA share_media) {
            C7331w1.m26688a("分享成功");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* compiled from: HiShareDialog.java */
    /* renamed from: ui.f.c$b */
    public interface b {
        /* renamed from: a */
        void mo25436a();
    }

    public DialogC6827c(Activity activity, ShareConfigBean shareConfigBean, int i2) {
        super(activity, C2113R.style.base_dialog_style);
        this.f23722c = C4440a.f16884f + "/QRCode/?appkey=a28ft4&pcode=10000";
        this.f23723e = "下载国家反诈中心APP,公安部打击防范电信网络诈骗官方应用";
        this.f23724f = "看更多反诈文章，上国家反诈中心APP";
        this.f23729k = null;
        this.f23730l = new a();
        this.f23721b = activity;
        this.f23720a = i2;
        this.f23728j = shareConfigBean;
        this.f23726h = new ShareAction(this.f23721b);
        this.f23727i = new ViewOnClickListenerC6829e(this.f23721b, shareConfigBean);
        m25524b();
    }

    @SuppressLint({"ResourceType"})
    /* renamed from: b */
    private void m25524b() {
        setContentView(C2113R.layout.share_dlg);
        setGravityLayout(0);
        setWidthDialog(-2.0d);
        setHeightDialogdp(-2.0f);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        initOnCreate();
        getWindow().setWindowAnimations(C2113R.anim.anim_bottom_in);
        findViewById(C2113R.id.cancel_btn).setOnClickListener(new View.OnClickListener() { // from class: ui.f.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC6827c.this.m25526a(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(C2113R.id.h_recyclerview);
        HRecyclerViewAdapter hRecyclerViewAdapter = new HRecyclerViewAdapter(this.f23721b, this.f23720a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f23721b);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(hRecyclerViewAdapter);
        hRecyclerViewAdapter.setOnItemClickListener(new HRecyclerViewAdapter.InterfaceC0062a() { // from class: ui.f.a
            @Override // adapter.HRecyclerViewAdapter.InterfaceC0062a
            /* renamed from: a */
            public final void mo237a(int i2, String str) {
                DialogC6827c.this.m25525a(i2, str);
            }
        });
        ShareConfigBean shareConfigBean = this.f23728j;
        if (shareConfigBean != null) {
            if (!TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                this.f23722c = this.f23728j.downloadUrl;
            }
            if (!TextUtils.isEmpty(this.f23728j.title)) {
                this.f23723e = this.f23728j.title;
            }
            if (!TextUtils.isEmpty(this.f23728j.description)) {
                this.f23724f = this.f23728j.description;
            }
            if (TextUtils.isEmpty(this.f23728j.iconUrl)) {
                this.f23725g = new UMImage(this.f23721b, C2113R.mipmap.logo);
            } else {
                this.f23725g = new UMImage(this.f23721b, this.f23728j.iconUrl);
            }
        } else {
            this.f23725g = new UMImage(this.f23721b, C2113R.mipmap.logo);
        }
        this.f23722c += AccountManager.getShareParam();
    }

    /* renamed from: a */
    public /* synthetic */ void m25526a(View view) {
        dismiss();
    }

    /* renamed from: a */
    private void m25522a(String str) {
        if (TextUtils.equals("微博", str)) {
            this.f23724f = this.f23723e;
        }
        int i2 = this.f23720a;
        if (i2 == 3) {
            UMImage uMImage = new UMImage(this.f23721b, this.f23722c);
            uMImage.setTitle(this.f23723e);
            uMImage.setThumb(this.f23725g);
            uMImage.setDescription(this.f23724f);
            this.f23726h.withMedia(uMImage);
            return;
        }
        if (i2 == 4) {
            UMVideo uMVideo = new UMVideo(this.f23722c);
            uMVideo.setTitle(this.f23723e);
            uMVideo.setThumb(this.f23725g);
            uMVideo.setDescription(this.f23724f);
            this.f23726h.withMedia(uMVideo);
            return;
        }
        UMWeb uMWeb = new UMWeb(this.f23722c);
        uMWeb.setTitle(this.f23723e);
        uMWeb.setThumb(this.f23725g);
        uMWeb.setDescription(this.f23724f);
        this.f23726h.withMedia(uMWeb);
    }

    public DialogC6827c(Activity activity, ShareConfigBean shareConfigBean, int i2, b bVar) {
        super(activity, C2113R.style.base_dialog_style);
        this.f23722c = C4440a.f16884f + "/QRCode/?appkey=a28ft4&pcode=10000";
        this.f23723e = "下载国家反诈中心APP,公安部打击防范电信网络诈骗官方应用";
        this.f23724f = "看更多反诈文章，上国家反诈中心APP";
        this.f23729k = null;
        this.f23730l = new a();
        this.f23721b = activity;
        this.f23720a = i2;
        this.f23728j = shareConfigBean;
        this.f23726h = new ShareAction(this.f23721b);
        this.f23727i = new ViewOnClickListenerC6829e(this.f23721b, shareConfigBean);
        this.f23729k = bVar;
        m25524b();
    }

    /* renamed from: a */
    public static boolean m25523a(Activity activity, SHARE_MEDIA share_media) {
        return UMShareAPI.get(activity).isInstall(activity, share_media);
    }

    /* renamed from: a */
    private void m25521a() {
        b bVar = this.f23729k;
        if (bVar != null) {
            bVar.mo25436a();
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void m25525a(int i2, String str) {
        m25522a(str);
        switch (i2) {
            case 0:
                if (m25523a(this.f23721b, SHARE_MEDIA.WEIXIN)) {
                    m25521a();
                    this.f23726h.setPlatform(SHARE_MEDIA.WEIXIN).share();
                    break;
                } else {
                    C7331w1.m26688a("您未安装微信");
                    break;
                }
            case 1:
                if (m25523a(this.f23721b, SHARE_MEDIA.WEIXIN)) {
                    m25521a();
                    this.f23726h.setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).share();
                    break;
                } else {
                    C7331w1.m26688a("您未安装微信");
                    break;
                }
            case 2:
                if (m25523a(this.f23721b, SHARE_MEDIA.QQ)) {
                    m25521a();
                    this.f23726h.setPlatform(SHARE_MEDIA.QQ).setCallback(this.f23730l).share();
                    break;
                } else {
                    C7331w1.m26688a("分享失败");
                    break;
                }
            case 3:
                if (m25523a(this.f23721b, SHARE_MEDIA.QZONE)) {
                    m25521a();
                    this.f23726h.setPlatform(SHARE_MEDIA.QZONE).setCallback(this.f23730l).share();
                    break;
                } else {
                    C7331w1.m26688a("分享失败");
                    break;
                }
            case 4:
                m25521a();
                this.f23726h.setPlatform(SHARE_MEDIA.SINA).setCallback(this.f23730l).share();
                break;
            case 5:
                if (m25523a(this.f23721b, SHARE_MEDIA.DINGTALK)) {
                    m25521a();
                    this.f23726h.setPlatform(SHARE_MEDIA.DINGTALK).setCallback(this.f23730l).share();
                    break;
                } else {
                    C7331w1.m26688a("您未安装钉钉");
                    break;
                }
            case 6:
                int i3 = this.f23720a;
                if (i3 != 1) {
                    if (i3 == 2) {
                        C7337y1.m26794s(this.f23722c);
                        m25521a();
                        break;
                    }
                } else {
                    this.f23727i.show();
                    m25521a();
                    break;
                }
                break;
        }
        dismiss();
    }
}
