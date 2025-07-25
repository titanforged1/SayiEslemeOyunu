#Sayı Eşleme Oyunu - Android Bootcamp Bitirme Projesi

Modern Android geliştirme teknolojileri kullanılarak geliştirilmiş, hafıza temelli eğlenceli bir sayı eşleme oyunu!

Uygulama Hakkında

Bu uygulama, kullanıcıların kartlara dokunarak eşleşen sayıları bulmaya çalıştığı klasik hafıza oyununun modern Android versiyonudur. Oyuncular kendi kullanıcı adlarını girip zorluk seviyesi seçerek oyuna başlayabilir, skorlarını takip edebilir ve uygulama ayarlarını kişiselleştirebilirler.

##  Özellikler

### 🏠 Ana Sayfa
- **Başla**: Oyun kurma sayfasına yönlendirir
- **Skorlarım**: Daha önceki skorları listeler
- **Ayarlar**: Tema ve oyun ayarlarını yapılandırır

### ⚙️ Oyun Kurma Ekranı
- Kullanıcı adı girişi
- Zorluk seviyesi seçimi:
  - **Kolay**: 16 kart (8 farklı sayı çifti)
  - **Zor**: 24 kart (12 farklı sayı çifti)

### 🎲 Oyun Ekranı
- Rastgele dağıtılmış kartlar
- Animasyonlu kart açma
- En fazla 2 kart aynı anda açık
- Eşleşme durumunda yeşil renk
- Skor takibi (her eşleşme +10 puan)
- 60 saniyelik geri sayım
- Oyun sonu tebrik/kaybetme mesajları

### 📊 Skorlar Sayfası
- En yüksekten düşüğe sıralı skorlar
- Sıra numarası, kullanıcı adı, skor ve tarih bilgileri
- Skorları silme özelliği

### ⚙️ Ayarlar Sayfası
- Açık/koyu tema seçimi
- Süre göstergesi açma/kapatma
- Skor listesini sıfırlama
- Uygulama bilgileri

## 🛠 Kullanılan Teknolojiler

### Modern Android Bileşenleri
- **Kotlin**: Ana programlama dili
- **Jetpack Compose**: Modern UI framework
- **MVVM Architecture**: Temiz mimari yapısı
- **Hilt (Dagger)**: Dependency injection
- **Navigation Component**: Sayfalar arası geçiş
- **Room Database**: Skor verilerinin saklanması
- **StateFlow**: Reaktif state yönetimi
- **Coroutines**: Asenkron işlemler

### UI/UX Özellikleri
- **Material Design 3**: Modern tasarım dili
- **Animasyonlar**: Kart çevirme ve geçiş animasyonları
- **Responsive Design**: Farklı ekran boyutlarına uyum
- **Tema Desteği**: Açık ve koyu tema seçenekleri

## 📦 Proje Yapısı

```
app/
├── data/
│   └── local/
│       ├── dao/
│       │   └── ScoreDao.kt
│       ├── entity/
│       │   └── ScoreEntity.kt
│       └── ScoreDatabase.kt
├── di/
│   └── AppModule.kt
├── domain/
│   └── model/
│       └── MemoryCard.kt
└── presentation/
    ├── game/
    │   ├── GameScreen.kt
    │   ├── GameSetupScreen.kt
    │   └── GameViewModel.kt
    ├── home/
    │   └── HomeScreen.kt
    ├── score/
    │   ├── ScoreScreen.kt
    │   └── ScoreViewModel.kt
    ├── navigation/
    │   └── Navigation.kt
    └── SettingsScreen.kt
```

## 🚀 Kurulum ve Çalıştırma

### Kurulum Adımları
1. Projeyi klonlayın veya indirin
2. Android Studio'da projeyi açın
3. Gradle sync işleminin tamamlanmasını bekleyin
4. Uygulamayı emülatör veya fiziksel cihazda çalıştırın

## 🎯 Oyun Kuralları

1. **Başlangıç**: Tüm kartlar kapalı durumda rastgele dağıtılır
2. **Kart Açma**: Bir karta tıklayarak altındaki sayıyı görürsünüz
3. **Eşleştirme**: Aynı anda en fazla 2 kart açık kalabilir
4. **Başarı**: Eşleşen kartlar açık kalır ve yeşil renk alır
5. **Başarısızlık**: Eşleşmeyen kartlar kısa bir beklemeden sonra kapanır
6. **Puanlama**: Her başarılı eşleştirme 10 puan kazandırır
7. **Zaman**: 60 saniye içinde tüm kartları eşleştirmeye çalışın
8. **Kazanma**: Tüm kartları eşleştirirseniz kazanırsınız
9. **Kaybetme**: Süre dolarsa oyunu kaybedersiniz

## 📸 Ekran Görüntüleri
<img width="383" height="778" alt="Screenshot 2025-07-25 120719" src="https://github.com/user-attachments/assets/6c29b92d-8b1e-43e9-beeb-41bedeafc1dd" />
<img width="378" height="808" alt="Screenshot 2025-07-25 000843" src="https://github.com/user-attachments/assets/c15adb1f-75f2-48bb-83ae-a36adaa3135b" />


https://github.com/user-attachments/assets/42596d02-1b40-49ea-97c2-a63733520e36

<img width="371" height="822" alt="Screenshot 2025-07-25 120708" src="https://github.com/user-attachments/assets/ff6611f7-27e1-4d89-870c-d69f07b862f6" />
<img width="348" height="806" alt="Screenshot 2025-07-25 120806" src="https://github.com/user-attachments/assets/de1bd329-8678-416f-9a74-e404e654917e" />


https://github.com/user-attachments/assets/d0659f01-a3ea-4844-827b-2d20766bcc22



https://github.com/user-attachments/assets/8020cd8b-5b05-45e3-890f-44ed1f33c3fa



- Ana Sayfa
- Oyun Kurma Ekranı
- Oyun Ekranı (Kolay Mod)
- Oyun Ekranı (Zor Mod)
- Skorlar Sayfası
- Ayarlar Sayfası

## 🏆 Geliştirici Notları

Bu proje Android Bootcamp bitirme projesi olarak geliştirilmiştir. Proje geliştirimi sırasında:

- Clean Architecture prensipleri uygulanmıştır
- SOLID prensipleri gözetilmiştir
- Modern Android geliştirme best practice'leri takip edilmiştir
- Kod okunabilirliği ve sürdürülebilirlik ön planda tutulmuştur
- Unit test yazılabilir yapı kurulmuştur

