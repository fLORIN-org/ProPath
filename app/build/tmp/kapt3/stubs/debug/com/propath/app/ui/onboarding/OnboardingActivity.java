package com.propath.app.ui.onboarding;

/**
 * Экран онбординга — показывается только при первом запуске.
 * 3 слайда, переключение кнопкой Далее.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/propath/app/ui/onboarding/OnboardingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/propath/app/databinding/ActivityOnboardingBinding;", "currentPage", "", "slides", "", "Lkotlin/Triple;", "", "userRepo", "Lcom/propath/app/data/repository/UserRepository;", "getUserRepo", "()Lcom/propath/app/data/repository/UserRepository;", "userRepo$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupDots", "showSlide", "index", "app_debug"})
public final class OnboardingActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.propath.app.databinding.ActivityOnboardingBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy userRepo$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.Triple<java.lang.String, java.lang.String, java.lang.String>> slides = null;
    private int currentPage = 0;
    
    public OnboardingActivity() {
        super();
    }
    
    private final com.propath.app.data.repository.UserRepository getUserRepo() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showSlide(int index) {
    }
    
    private final void setupDots() {
    }
}