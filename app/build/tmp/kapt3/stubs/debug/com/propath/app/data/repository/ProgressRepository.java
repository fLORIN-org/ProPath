package com.propath.app.data.repository;

/**
 * Репозиторий для работы с результатами матчей.
 * Слой Data в архитектуре MVVM.
 * ViewModel не знает, откуда данные — из БД или сети.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/propath/app/data/repository/ProgressRepository;", "", "dao", "Lcom/propath/app/data/local/MatchResultDao;", "(Lcom/propath/app/data/local/MatchResultDao;)V", "getMatchCount", "", "userId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMatches", "Landroidx/lifecycle/LiveData;", "", "Lcom/propath/app/data/model/MatchResult;", "getWinCount", "getWinrate", "saveMatch", "", "match", "(Lcom/propath/app/data/model/MatchResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ProgressRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.propath.app.data.local.MatchResultDao dao = null;
    
    public ProgressRepository(@org.jetbrains.annotations.NotNull()
    com.propath.app.data.local.MatchResultDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.propath.app.data.model.MatchResult>> getMatches(int userId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveMatch(@org.jetbrains.annotations.NotNull()
    com.propath.app.data.model.MatchResult match, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMatchCount(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWinCount(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWinrate(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
}