🎮 Sayı Eşleme Oyunu - MULTIGROUP Android Bootcamp Bitirme Projesi
Modern Android geliştirme teknolojileriyle geliştirilmiş, hafıza temelli eğlenceli bir sayı eşleme oyunu!

📱 Uygulama Hakkında
Bu uygulama, kullanıcıların kartlara dokunarak eşleşen sayıları bulmaya çalıştığı klasik bir hafıza oyununun modern Jetpack Compose versiyonudur.
Oyuncular, kullanıcı adı ve zorluk seviyesi seçerek oyuna başlar, skorlarını takip edebilir ve uygulama ayarlarını özelleştirebilirler.

✨ Özellikler
🏠 Ana Sayfa

Başla: Oyun kurma ekranına yönlendirir.

Skorlarım: Önceki oyun skorlarını listeler.

Ayarlar: Tema ve oyun ayarlarını yapılandırır.

🛠 Oyun Kurma Ekranı

Kullanıcı adı girişi

Zorluk seçimi:

Kolay: 16 kart (8 farklı sayı çifti)

Zor: 24 kart (12 farklı sayı çifti)

🎯 Oyun Ekranı

Rastgele dağıtılmış kartlar

Animasyonlu kart açma ve eşleşme efekti

Aynı anda en fazla 2 kart açık olabilir

Eşleşen kartlar yeşil renkle vurgulanır

Her eşleşme +10 puan

60 saniyelik geri sayım

Oyun sonunda kazandı/kaybetti ekranı

📊 Skorlar Ekranı

Skorlar yüksekten düşüğe sıralanır

Kullanıcı adı, skor ve tarih bilgisi içerir

Tüm skorları temizleme özelliği

⚙️ Ayarlar Sayfası

Açık/koyu tema seçimi

Süre göstergesini açma/kapatma

Skor listesini sıfırlama

Uygulama bilgileri

📸 Ekran Görüntüleri


https://github.com/user-attachments/assets/54c58476-4b2f-4ba1-9cfd-3f6650827606



https://github.com/user-attachments/assets/6e54f7d6-cb8c-462d-bce7-61ccdeee1ab8


https://github.com/user-attachments/assets/c930a62f-5037-41d4-963d-5bf17cca2f29

<img width="348" height="806" alt="Screenshot 2025-07-25 120806" src="https://github.com/user-attachments/assets/d10279fe-229f-4448-84d9-7be2bc47499c" />

<img width="378" height="808" alt="Screenshot 2025-07-25 000843" src="https://github.com/user-attachments/assets/add4ecd0-d468-4268-a4d0-d569a4312bf0" />

<img width="371" height="822" alt="Screenshot 2025-07-25 120708" src="https://github.com/user-attachments/assets/7e26d541-1dd3-4577-ab58-56ef2ea2ea9d" />

<img width="383" height="778" alt="Screenshot 2025-07-25 120719" src="https://github.com/user-attachments/assets/261065fd-bbb5-43d0-a7aa-2935f93af29d" />



🧪 Kullanılan Teknolojiler

Katman      -	Teknoloji
Dil	        - Kotlin
UI	        - Jetpack Compose, Material 3
Mimari	    - MVVM, Clean Architecture
DI    	    - Hilt (Dagger)
Navigation  -	Navigation Component
Veri	      - Room Database
Reaktif yapı-	StateFlow, Coroutines
Animasyon	  - Compose Animations

🗂️ Proje Yapısı

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
    
⚙️ Kurulum ve Çalıştırma

Projeyi klonlayın:

git clone https://github.com/kullanici-adi/SayiEslemeOyunu.git
Android Studio ile projeyi açın

Gerekli bağımlılıkların yüklenmesini (Gradle sync) bekleyin

Emülatör veya fiziksel cihazda uygulamayı çalıştırın


🧠 Oyun Kuralları

Başlangıçta kartlar rastgele kapalı şekilde yerleştirilir.

Bir karta tıklayarak sayıyı görürsünüz.

Aynı anda en fazla 2 kart açık olabilir.

Eşleşen kartlar açık kalır ve yeşile döner.

Eşleşmeyen kartlar kısa bir beklemeden sonra kapanır.

Her başarılı eşleşme 10 puan kazandırır.

60 saniye içinde tüm kartları eşleştirmeye çalışın.

Tüm kartlar eşleşirse oyunu kazanırsınız.

Süre biterse oyun kaybedilir.


🧾 Geliştirici Notları

Bu proje, Android Bootcamp kapsamında bitirme projesi olarak geliştirilmiştir. Geliştirme sürecinde:

Clean Architecture prensipleri uygulanmıştır

SOLID prensiplerine uyulmuştur

Modern Android geliştirme yaklaşımları (best practices) takip edilmiştir

Kod okunabilirliği ve genişletilebilirlik ön planda tutulmuştur

Test yazılabilir bir yapı kurulmuştur

💬 Geri Bildirim & Katkı

Eğer proje hakkında öneri, geri bildirim veya katkı sağlamak isterseniz, GitHub üzerinden issue veya pull request gönderebilirsiniz. 🎉
