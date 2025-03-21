package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class UseCaseGroup {
    private static final String TAG = "UseCaseGroup";

    @GuardedBy("mListenerLock")
    private StateChangeCallback mStateChangeCallback;
    private final Object mListenerLock = new Object();
    private final Object mUseCasesLock = new Object();

    @GuardedBy("mUseCasesLock")
    private final Set<UseCase> mUseCases = new HashSet();
    private volatile boolean mIsActive = false;

    public interface StateChangeCallback {
        void onGroupActive(@NonNull UseCaseGroup useCaseGroup);

        void onGroupInactive(@NonNull UseCaseGroup useCaseGroup);
    }

    public boolean addUseCase(@NonNull UseCase useCase) {
        boolean add;
        synchronized (this.mUseCasesLock) {
            add = this.mUseCases.add(useCase);
        }
        return add;
    }

    public void clear() {
        ArrayList<UseCase> arrayList = new ArrayList();
        synchronized (this.mUseCasesLock) {
            arrayList.addAll(this.mUseCases);
            this.mUseCases.clear();
        }
        for (UseCase useCase : arrayList) {
            String str = "Clearing use case: " + useCase.getName();
            useCase.clear();
        }
    }

    public boolean contains(@NonNull UseCase useCase) {
        boolean contains;
        synchronized (this.mUseCasesLock) {
            contains = this.mUseCases.contains(useCase);
        }
        return contains;
    }

    @NonNull
    public Map<String, Set<UseCase>> getCameraIdToUseCaseMap() {
        HashMap hashMap = new HashMap();
        synchronized (this.mUseCasesLock) {
            for (UseCase useCase : this.mUseCases) {
                for (String str : useCase.getAttachedCameraIds()) {
                    Set set = (Set) hashMap.get(str);
                    if (set == null) {
                        set = new HashSet();
                    }
                    set.add(useCase);
                    hashMap.put(str, set);
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    @NonNull
    public Collection<UseCase> getUseCases() {
        Collection<UseCase> unmodifiableCollection;
        synchronized (this.mUseCasesLock) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.mUseCases);
        }
        return unmodifiableCollection;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public boolean removeUseCase(@NonNull UseCase useCase) {
        boolean remove;
        synchronized (this.mUseCasesLock) {
            remove = this.mUseCases.remove(useCase);
        }
        return remove;
    }

    public void setListener(@NonNull StateChangeCallback stateChangeCallback) {
        synchronized (this.mListenerLock) {
            this.mStateChangeCallback = stateChangeCallback;
        }
    }

    public void start() {
        synchronized (this.mListenerLock) {
            if (this.mStateChangeCallback != null) {
                this.mStateChangeCallback.onGroupActive(this);
            }
            this.mIsActive = true;
        }
    }

    public void stop() {
        synchronized (this.mListenerLock) {
            if (this.mStateChangeCallback != null) {
                this.mStateChangeCallback.onGroupInactive(this);
            }
            this.mIsActive = false;
        }
    }
}
