package adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.UploadStateInfo;
import cn.jzvd.C1283y;
import cn.jzvd.JzvdStd;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;
import p388ui.Hicore;
import util.C7337y1;

/* loaded from: classes.dex */
public class PictureSelectAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

    /* renamed from: b0 */
    public static final String f241b0 = "style_item_video";

    /* renamed from: c0 */
    public static final String f242c0 = "style_item_picture";

    /* renamed from: d0 */
    static final int f243d0 = 0;

    /* renamed from: e0 */
    static final int f244e0 = 1;

    /* renamed from: V */
    private List<LocalMedia> f245V;

    /* renamed from: W */
    private InterfaceC0068b f246W;

    /* renamed from: X */
    private boolean f247X;

    /* renamed from: Y */
    private String f248Y;

    /* renamed from: Z */
    private int f249Z;

    /* renamed from: a0 */
    List<UploadStateInfo> f250a0;

    /* renamed from: adapter.PictureSelectAdapter$a */
    class ViewOnClickListenerC0067a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f251a;

        ViewOnClickListenerC0067a(BaseViewHolder baseViewHolder) {
            this.f251a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (PictureSelectAdapter.this.f246W != null) {
                    PictureSelectAdapter.this.f246W.onItemClickListener(this.f251a.getAdapterPosition(), PictureSelectAdapter.this.f245V);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: adapter.PictureSelectAdapter$b */
    public interface InterfaceC0068b {
        void onItemClickListener(int i2, List<LocalMedia> list);
    }

    public PictureSelectAdapter(int i2, List<LocalMedia> list) {
        super(i2, list);
        this.f247X = true;
        this.f248Y = "";
        this.f249Z = 9;
        this.f245V = list;
    }

    /* renamed from: c */
    private void m261c(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        baseViewHolder.m5194a(C2113R.id.iv_clear);
        JzvdStd jzvdStd = (JzvdStd) baseViewHolder.m5224c(C2113R.id.image_view);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_foot);
        ImageView imageView2 = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_clear);
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_video_duration);
        TextView textView2 = (TextView) baseViewHolder.m5224c(C2113R.id.tv_upload_state);
        if (localMedia == null) {
            imageView2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            jzvdStd.setVisibility(4);
            imageView.setVisibility(0);
            return;
        }
        try {
            if (this.f250a0 != null) {
                int indexOf = this.f245V.indexOf(localMedia);
                int size = this.f250a0.size();
                if (size > 0 && indexOf < size) {
                    m258a(textView2, this.f250a0.get(indexOf));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String path = localMedia.getPath();
        imageView2.setVisibility(0);
        textView2.setVisibility(0);
        jzvdStd.setVisibility(0);
        textView.setVisibility(0);
        imageView.setVisibility(8);
        ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
        if (imageEngine != null) {
            imageEngine.loadGridImage(this.f5580x, path, jzvdStd.f2791E0);
        }
        if (localMedia.getDuration() <= 0) {
            textView.setText(C1283y.m2549a(C7337y1.m26761b(this.f5580x, localMedia.getPath())));
        } else {
            textView.setText(C1283y.m2549a(localMedia.getDuration()));
        }
        jzvdStd.m2461a(path, "", 0);
        jzvdStd.f2770n.setVisibility(4);
        jzvdStd.f2773q.setVisibility(4);
        jzvdStd.f2772p.setVisibility(8);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.f245V.size();
        return (!this.f247X || size >= this.f249Z) ? size : size + 1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f247X) {
            int size = this.f245V.size();
            if (i2 + 1 == getItemCount() && size < this.f249Z + 1) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: k */
    public void m262k(boolean z) {
        this.f247X = z;
    }

    public void setOnItemClickListener(InterfaceC0068b interfaceC0068b) {
        this.f246W = interfaceC0068b;
    }

    /* renamed from: b */
    private void m260b(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        baseViewHolder.m5194a(C2113R.id.iv_clear);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.picture_select);
        ImageView imageView2 = (ImageView) baseViewHolder.m5224c(C2113R.id.picture_foot);
        ImageView imageView3 = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_clear);
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_upload_state);
        if (localMedia == null) {
            imageView3.setVisibility(8);
            imageView.setVisibility(8);
            textView.setVisibility(8);
            imageView2.setVisibility(0);
            return;
        }
        imageView2.setVisibility(8);
        try {
            if (this.f250a0 != null) {
                int indexOf = this.f245V.indexOf(localMedia);
                int size = this.f250a0.size();
                if (size > 0 && indexOf < size) {
                    m258a(textView, this.f250a0.get(indexOf));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String path = localMedia.getPath();
        imageView3.setVisibility(0);
        imageView.setVisibility(0);
        textView.setVisibility(0);
        if (localMedia.isCut()) {
            ComponentCallbacks2C1576b.m3649e(this.f5580x).mo3719a(localMedia.getCutPath()).m3768a(imageView);
        } else {
            ComponentCallbacks2C1576b.m3649e(this.f5580x).mo3719a(path).m3768a(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        if (f241b0.equals(this.f248Y)) {
            m261c(baseViewHolder, localMedia);
        } else {
            m260b(baseViewHolder, localMedia);
        }
    }

    public PictureSelectAdapter(int i2, List<LocalMedia> list, String str, int i3, List<UploadStateInfo> list2) {
        super(i2, list);
        this.f247X = true;
        this.f248Y = "";
        this.f249Z = 9;
        this.f245V = list;
        this.f248Y = str;
        this.f249Z = i3;
        this.f250a0 = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((PictureSelectAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0067a(baseViewHolder));
    }

    /* renamed from: a */
    private void m258a(TextView textView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView.setText("等待上传");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            return;
        }
        if (uploadState == 1) {
            textView.setText("上传中");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.black_dark));
        } else if (uploadState == 2) {
            textView.setText("上传完成");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.blue));
        } else {
            if (uploadState != 3) {
                return;
            }
            textView.setText("上传失败");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorRed));
        }
    }
}
