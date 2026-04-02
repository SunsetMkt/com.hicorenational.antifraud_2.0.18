package adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadStateInfo;
import cn.jzvd.JZUtils;
import cn.jzvd.JzvdStd;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import util.g2;

/* JADX INFO: loaded from: classes.dex */
public class ReportPictureSelAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {
    public static final int b0 = 99;
    public static final int c0 = 100;
    static final int d0 = 0;
    static final int e0 = 1;
    private static RecyclerView f0;
    private ArrayList<LocalMedia> V;
    private a W;
    private boolean X;
    private int Y;
    private int Z;
    List<UploadStateInfo> a0;

    public interface a {
        void onItemClickListener(int i2, ArrayList<LocalMedia> arrayList);
    }

    public ReportPictureSelAdapter(int i2, ArrayList<LocalMedia> arrayList) {
        super(i2, arrayList);
        this.X = true;
        this.Z = 9;
        this.V = arrayList;
    }

    private void b(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        baseViewHolder.a(R.id.iv_clear);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.picture_select);
        ImageView imageView2 = (ImageView) baseViewHolder.c(R.id.picture_foot);
        ImageView imageView3 = (ImageView) baseViewHolder.c(R.id.iv_clear);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_upload_state);
        if (localMedia == null) {
            imageView3.setVisibility(8);
            imageView.setVisibility(8);
            textView.setVisibility(8);
            imageView2.setVisibility(0);
            return;
        }
        imageView2.setVisibility(8);
        try {
            if (this.a0 != null) {
                int iIndexOf = this.V.indexOf(localMedia);
                int size = this.a0.size();
                if (size > 0 && iIndexOf < size) {
                    a(textView, this.a0.get(iIndexOf));
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
            com.bumptech.glide.b.e(this.x).a(localMedia.getCutPath()).a(imageView);
        } else {
            k.d.a(this.x, path, imageView, 4);
        }
    }

    private void c(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        baseViewHolder.a(R.id.iv_clear);
        JzvdStd jzvdStd = (JzvdStd) baseViewHolder.c(R.id.image_view);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_foot);
        ImageView imageView2 = (ImageView) baseViewHolder.c(R.id.iv_clear);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_video_duration);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.tv_upload_state);
        if (localMedia == null) {
            imageView2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            jzvdStd.setVisibility(4);
            imageView.setVisibility(0);
            return;
        }
        try {
            if (this.a0 != null) {
                int iIndexOf = this.V.indexOf(localMedia);
                int size = this.a0.size();
                if (size > 0 && iIndexOf < size) {
                    a(textView2, this.a0.get(iIndexOf));
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
            imageEngine.loadGridImage(this.x, path, jzvdStd.thumbImageView);
        }
        if (localMedia.getDuration() <= 0) {
            textView.setText(JZUtils.stringForTime(g2.b(this.x, localMedia.getPath())));
        } else {
            textView.setText(JZUtils.stringForTime(localMedia.getDuration()));
        }
        jzvdStd.setUp(path, "", 0);
        jzvdStd.progressBar.setVisibility(4);
        jzvdStd.totalTimeTextView.setVisibility(4);
        jzvdStd.currentTimeTextView.setVisibility(8);
    }

    public RecyclerView G() {
        return f0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.V.size();
        return (!this.X || size >= this.Z) ? size : size + 1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.X) {
            int size = this.V.size();
            if (i2 + 1 == getItemCount() && size < this.Z + 1) {
                return 1;
            }
        }
        return 0;
    }

    public void k(boolean z) {
        this.X = z;
    }

    public void setOnItemClickListener(a aVar) {
        this.W = aVar;
    }

    public static ReportPictureSelAdapter a(Context context, RecyclerView recyclerView, int i2, a aVar, BaseQuickAdapter.i iVar, ArrayList<LocalMedia> arrayList, List<UploadStateInfo> list) {
        f0 = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        ReportPictureSelAdapter reportPictureSelAdapter = new ReportPictureSelAdapter(R.layout.item_chat_picture, arrayList, 100, i2, list);
        reportPictureSelAdapter.a(recyclerView);
        reportPictureSelAdapter.setOnItemClickListener(aVar);
        reportPictureSelAdapter.setOnItemChildClickListener(iVar);
        recyclerView.setAdapter(reportPictureSelAdapter);
        return reportPictureSelAdapter;
    }

    public ReportPictureSelAdapter(int i2, ArrayList<LocalMedia> arrayList, int i3, int i4, List<UploadStateInfo> list) {
        super(i2, arrayList);
        this.X = true;
        this.Z = 9;
        this.V = arrayList;
        this.Y = i3;
        this.Z = i4;
        this.a0 = list;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        if (99 == this.Y) {
            c(baseViewHolder, localMedia);
        } else {
            b(baseViewHolder, localMedia);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(final BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder(baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(baseViewHolder, view);
            }
        });
    }

    public /* synthetic */ void a(BaseViewHolder baseViewHolder, View view) {
        try {
            if (this.W != null) {
                this.W.onItemClickListener(baseViewHolder.getAdapterPosition(), this.V);
            }
        } catch (Exception unused) {
        }
    }

    private void a(TextView textView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView.setText("\u7b49\u5f85\u4e0a\u4f20");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            return;
        }
        if (uploadState == 1) {
            textView.setText("\u4e0a\u4f20\u4e2d");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.black_dark));
        } else if (uploadState == 2) {
            textView.setText("\u4e0a\u4f20\u5b8c\u6210");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.blue));
        } else {
            if (uploadState != 3) {
                return;
            }
            textView.setText("\u4e0a\u4f20\u5931\u8d25");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorRed));
        }
    }
}
