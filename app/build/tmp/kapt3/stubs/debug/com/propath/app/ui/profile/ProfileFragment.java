package com.propath.app.ui.profile;

/**
 * Экран профиля — данные пользователя и кнопка выхода.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\u001a\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/propath/app/ui/profile/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/propath/app/databinding/FragmentProfileBinding;", "binding", "getBinding", "()Lcom/propath/app/databinding/FragmentProfileBinding;", "db", "Lcom/propath/app/data/local/AppDatabase;", "getDb", "()Lcom/propath/app/data/local/AppDatabase;", "db$delegate", "Lkotlin/Lazy;", "progressRepo", "Lcom/propath/app/data/repository/ProgressRepository;", "getProgressRepo", "()Lcom/propath/app/data/repository/ProgressRepository;", "progressRepo$delegate", "userRepo", "Lcom/propath/app/data/repository/UserRepository;", "getUserRepo", "()Lcom/propath/app/data/repository/UserRepository;", "userRepo$delegate", "loadProfile", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "app_debug"})
public final class ProfileFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.propath.app.databinding.FragmentProfileBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy db$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy userRepo$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy progressRepo$delegate = null;
    
    public ProfileFragment() {
        super();
    }
    
    private final com.propath.app.databinding.FragmentProfileBinding getBinding() {
        return null;
    }
    
    private final com.propath.app.data.local.AppDatabase getDb() {
        return null;
    }
    
    private final com.propath.app.data.repository.UserRepository getUserRepo() {
        return null;
    }
    
    private final com.propath.app.data.repository.ProgressRepository getProgressRepo() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadProfile() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}