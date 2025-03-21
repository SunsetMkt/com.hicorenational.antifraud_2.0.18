package com.luck.picture.lib.adapter;

import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.luck.picture.lib.C2639R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnVideoSelectedPlayCallback;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.File;
import java.util.List;
import p324i.p336c.p337a.InterfaceC5816d;

/* loaded from: classes.dex */
public class PictureSimpleFragmentAdapter extends PagerAdapter {
    private static final int MAX_CACHE_SIZE = 20;
    private PictureSelectionConfig config;
    private List<LocalMedia> images;
    private SparseArray<View> mCacheView = new SparseArray<>();
    private OnCallBackActivity onBackPressed;

    public interface OnCallBackActivity {
        void onActivityBackPressed();
    }

    public PictureSimpleFragmentAdapter(PictureSelectionConfig pictureSelectionConfig, List<LocalMedia> list, OnCallBackActivity onCallBackActivity) {
        this.config = pictureSelectionConfig;
        this.images = list;
        this.onBackPressed = onCallBackActivity;
    }

    /* renamed from: a */
    static /* synthetic */ void m8120a(LocalMedia localMedia, String str, @InterfaceC5816d ViewGroup viewGroup, View view) {
        OnVideoSelectedPlayCallback onVideoSelectedPlayCallback = PictureSelectionConfig.customVideoPlayCallback;
        if (onVideoSelectedPlayCallback != null) {
            onVideoSelectedPlayCallback.startPlayVideo(localMedia);
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean(PictureConfig.EXTRA_PREVIEW_VIDEO, true);
        bundle.putString("videoPath", str);
        intent.putExtras(bundle);
        JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
    }

    private void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setPanEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    public void clear() {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray != null) {
            sparseArray.clear();
            this.mCacheView = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
        if (this.mCacheView.size() > 20) {
            this.mCacheView.remove(i2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<LocalMedia> list = this.images;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @InterfaceC5816d
    public Object instantiateItem(@InterfaceC5816d final ViewGroup viewGroup, int i2) {
        ImageEngine imageEngine;
        ImageEngine imageEngine2;
        View view = this.mCacheView.get(i2);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(C2639R.layout.picture_image_preview, viewGroup, false);
            this.mCacheView.put(i2, view);
        }
        PhotoView photoView = (PhotoView) view.findViewById(C2639R.id.preview_image);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view.findViewById(C2639R.id.longImg);
        ImageView imageView = (ImageView) view.findViewById(C2639R.id.iv_play);
        final LocalMedia localMedia = this.images.get(i2);
        if (localMedia != null) {
            String mimeType = localMedia.getMimeType();
            final String compressPath = (!localMedia.isCut() || localMedia.isCompressed()) ? (localMedia.isCompressed() || (localMedia.isCut() && localMedia.isCompressed())) ? localMedia.getCompressPath() : localMedia.getPath() : localMedia.getCutPath();
            boolean isGif = PictureMimeType.isGif(mimeType);
            int i3 = 8;
            imageView.setVisibility(PictureMimeType.eqVideo(mimeType) ? 0 : 8);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PictureSimpleFragmentAdapter.m8120a(LocalMedia.this, compressPath, viewGroup, view2);
                }
            });
            boolean isLongImg = MediaUtils.isLongImg(localMedia);
            photoView.setVisibility((!isLongImg || isGif) ? 0 : 8);
            photoView.setOnViewTapListener(new OnViewTapListener() { // from class: com.luck.picture.lib.adapter.g
                @Override // com.luck.picture.lib.photoview.OnViewTapListener
                public final void onViewTap(View view2, float f2, float f3) {
                    PictureSimpleFragmentAdapter.this.m8122a(view2, f2, f3);
                }
            });
            if (isLongImg && !isGif) {
                i3 = 0;
            }
            subsamplingScaleImageView.setVisibility(i3);
            subsamplingScaleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PictureSimpleFragmentAdapter.this.m8121a(view2);
                }
            });
            if (!isGif || localMedia.isCompressed()) {
                if (this.config != null && (imageEngine = PictureSelectionConfig.imageEngine) != null) {
                    if (isLongImg) {
                        displayLongPic(SdkVersionUtils.checkedAndroid_Q() ? Uri.parse(compressPath) : Uri.fromFile(new File(compressPath)), subsamplingScaleImageView);
                    } else {
                        imageEngine.loadImage(view.getContext(), compressPath, photoView);
                    }
                }
            } else if (this.config != null && (imageEngine2 = PictureSelectionConfig.imageEngine) != null) {
                imageEngine2.loadAsGifImage(view.getContext(), compressPath, photoView);
            }
        }
        viewGroup.addView(view, 0);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@InterfaceC5816d View view, @InterfaceC5816d Object obj) {
        return view == obj;
    }

    public void removeCacheView(int i2) {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray == null || i2 >= sparseArray.size()) {
            return;
        }
        this.mCacheView.removeAt(i2);
    }

    /* renamed from: a */
    public /* synthetic */ void m8122a(View view, float f2, float f3) {
        OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8121a(View view) {
        OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }
}
