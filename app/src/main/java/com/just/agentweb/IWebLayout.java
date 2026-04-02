package com.just.agentweb;

import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface IWebLayout<T extends WebView, V extends ViewGroup> {
    @NonNull
    V getLayout();

    @Nullable
    T getWebView();
}
