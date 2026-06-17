package com.propath.app.ui.progress;

/**
 * ViewModel экрана прогресса.
 * Отдаёт список матчей и сохраняет новые результаты.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/propath/app/ui/progress/ProgressViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/propath/app/data/repository/UserRepository;", "progressRepository", "Lcom/propath/app/data/repository/ProgressRepository;", "(Lcom/propath/app/data/repository/UserRepository;Lcom/propath/app/data/repository/ProgressRepository;)V", "_userId", "Landroidx/lifecycle/MutableLiveData;", "", "errorMessage", "", "getErrorMessage", "()Landroidx/lifecycle/MutableLiveData;", "matches", "Landroidx/lifecycle/LiveData;", "", "Lcom/propath/app/data/model/MatchResult;", "getMatches", "()Landroidx/lifecycle/LiveData;", "setMatches", "(Landroidx/lifecycle/LiveData;)V", "saveResult", "", "getSaveResult", "init", "", "saveMatch", "isWin", "killsStr", "deathsStr", "app_debug"})
public final class ProgressViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.propath.app.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.propath.app.data.repository.ProgressRepository progressRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _userId = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> saveResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> errorMessage = null;
    public androidx.lifecycle.LiveData<java.util.List<com.propath.app.data.model.MatchResult>> matches;
    
    public ProgressViewModel(@org.jetbrains.annotations.NotNull()
    com.propath.app.data.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.propath.app.data.repository.ProgressRepository progressRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getSaveResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.propath.app.data.model.MatchResult>> getMatches() {
        return null;
    }
    
    public final void setMatches(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.propath.app.data.model.MatchResult>> p0) {
    }
    
    public final void init() {
    }
    
    public final void saveMatch(boolean isWin, @org.jetbrains.annotations.NotNull()
    java.lang.String killsStr, @org.jetbrains.annotations.NotNull()
    java.lang.String deathsStr) {
    }
}