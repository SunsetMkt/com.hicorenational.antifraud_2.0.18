package adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import java.util.ArrayList;
import java.util.List;
import p357j.C5845d;
import p388ui.Hicore;
import util.C7337y1;

/* loaded from: classes.dex */
public class ReportPictureSelAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

    /* renamed from: b0 */
    public static final int f301b0 = 99;

    /* renamed from: c0 */
    public static final int f302c0 = 100;

    /* renamed from: d0 */
    static final int f303d0 = 0;

    /* renamed from: e0 */
    static final int f304e0 = 1;

    /* renamed from: f0 */
    private static RecyclerView f305f0;

    /* renamed from: V */
    private ArrayList<LocalMedia> f306V;

    /* renamed from: W */
    private InterfaceC0069a f307W;

    /* renamed from: X */
    private boolean f308X;

    /* renamed from: Y */
    private int f309Y;

    /* renamed from: Z */
    private int f310Z;

    /* renamed from: a0 */
    List<UploadStateInfo> f311a0;

    /* renamed from: adapter.ReportPictureSelAdapter$a */
    public interface InterfaceC0069a {
        void onItemClickListener(int i2, ArrayList<LocalMedia> arrayList);
    }

    public ReportPictureSelAdapter(int i2, ArrayList<LocalMedia> arrayList) {
        super(i2, arrayList);
        this.f308X = true;
        this.f310Z = 9;
        this.f306V = arrayList;
    }

    /* renamed from: b */
    private void m273b(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
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
            if (this.f311a0 != null) {
                int indexOf = this.f306V.indexOf(localMedia);
                int size = this.f311a0.size();
                if (size > 0 && indexOf < size) {
                    m272a(textView, this.f311a0.get(indexOf));
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
            C5845d.m24603a(this.f5580x, path, imageView, 4);
        }
    }

    /* renamed from: c */
    private void m274c(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
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
            if (this.f311a0 != null) {
                int indexOf = this.f306V.indexOf(localMedia);
                int size = this.f311a0.size();
                if (size > 0 && indexOf < size) {
                    m272a(textView2, this.f311a0.get(indexOf));
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

    /* renamed from: G */
    public RecyclerView m275G() {
        return f305f0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.f306V.size();
        return (!this.f308X || size >= this.f310Z) ? size : size + 1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f308X) {
            int size = this.f306V.size();
            if (i2 + 1 == getItemCount() && size < this.f310Z + 1) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: k */
    public void m277k(boolean z) {
        this.f308X = z;
    }

    public void setOnItemClickListener(InterfaceC0069a interfaceC0069a) {
        this.f307W = interfaceC0069a;
    }

    /* renamed from: a */
    public static ReportPictureSelAdapter m271a(Context context, RecyclerView recyclerView, int i2, InterfaceC0069a interfaceC0069a, BaseQuickAdapter.InterfaceC1895i interfaceC1895i, ArrayList<LocalMedia> arrayList, List<UploadStateInfo> list) {
        f305f0 = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        ReportPictureSelAdapter reportPictureSelAdapter = new ReportPictureSelAdapter(C2113R.layout.item_chat_picture, arrayList, 100, i2, list);
        reportPictureSelAdapter.m5103a(recyclerView);
        reportPictureSelAdapter.setOnItemClickListener(interfaceC0069a);
        reportPictureSelAdapter.setOnItemChildClickListener(interfaceC1895i);
        recyclerView.setAdapter(reportPictureSelAdapter);
        return reportPictureSelAdapter;
    }

    public ReportPictureSelAdapter(int i2, ArrayList<LocalMedia> arrayList, int i3, int i4, List<UploadStateInfo> list) {
        super(i2, arrayList);
        this.f308X = true;
        this.f310Z = 9;
        this.f306V = arrayList;
        this.f309Y = i3;
        this.f310Z = i4;
        this.f311a0 = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        if (99 == this.f309Y) {
            m274c(baseViewHolder, localMedia);
        } else {
            m273b(baseViewHolder, localMedia);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(final BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((ReportPictureSelAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportPictureSelAdapter.this.m276a(baseViewHolder, view);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m276a(BaseViewHolder baseViewHolder, View view) {
        try {
            if (this.f307W != null) {
                this.f307W.onItemClickListener(baseViewHolder.getAdapterPosition(), this.f306V);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m272a(TextView textView, UploadStateInfo uploadStateInfo) {
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
