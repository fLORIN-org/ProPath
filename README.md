# ProPath — Персональный навигатор в киберспорте

**Автор:** Розанов Владислав Александрович, 9/2-РПО-24/1

## О проекте

ProPath — мобильное Android-приложение для начинающих киберспортсменов (14–20 лет).  
Помогает системно расти: трекер прогресса, статистика матчей, профиль игрока.

## Стек

- **Kotlin** — основной язык
- **MVVM** — архитектурный паттерн (ViewModel + LiveData)
- **Room** — локальная база данных
- **Navigation Component** — навигация между экранами
- **Material Design 3** — UI-компоненты
- **ViewBinding** — безопасная работа с layout

## Структура проекта

```
app/src/main/java/com/propath/app/
├── data/
│   ├── local/          # Room: AppDatabase, DAOs
│   ├── model/          # Модели данных: User, MatchResult
│   └── repository/     # UserRepository, ProgressRepository
└── ui/
    ├── auth/           # LoginActivity, LoginViewModel
    ├── onboarding/     # OnboardingActivity
    ├── main/           # MainActivity (нижняя навигация)
    ├── home/           # HomeFragment, HomeViewModel
    ├── progress/       # ProgressFragment, ProgressViewModel, MatchAdapter
    └── profile/        # ProfileFragment
```

## Как запустить

1. Открой папку `ProPath` в Android Studio
2. Подожди синхронизации Gradle
3. Запусти на эмуляторе или физическом устройстве (minSdk 26 = Android 8.0)

## Экраны

| Экран | Описание |
|-------|---------|
| Вход | Email + пароль, валидация |
| Онбординг | 3 слайда, показывается 1 раз |
| Главная | Статистика: матчи, winrate, K/D |
| Прогресс | Добавить матч, история результатов |
| Профиль | Данные пользователя, выход |

## Архитектура (MVVM)

```
UI (Fragment/Activity)
    ↕  наблюдает LiveData
ViewModel
    ↕  вызывает методы
Repository
    ↕  читает/пишет данные
Room (локальная БД)
```
