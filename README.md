
# 🎮 Sayı Eşleme Oyunu  
**MULTIGROUP Android Bootcamp Bitirme Projesi**  
Modern Android geliştirme teknolojileriyle geliştirilmiş, hafıza temelli eğlenceli bir sayı eşleme oyunu!

---

## 📱 Uygulama Hakkında
Bu uygulama, kullanıcıların kartlara dokunarak eşleşen sayıları bulmaya çalıştığı klasik bir hafıza oyununun modern Jetpack Compose versiyonudur.  
- Oyuncular kullanıcı adı ve zorluk seviyesi seçerek oyuna başlar.  
- Skorlarını takip edebilir ve uygulama ayarlarını özelleştirebilirler.  

---

## ✨ Özellikler

### 🏠 Ana Sayfa
- **Başla:** Oyun kurma ekranına yönlendirir.  
- **Skorlarım:** Önceki oyun skorlarını listeler.  
- **Ayarlar:** Tema ve oyun ayarlarını yapılandırır.  

### 🛠 Oyun Kurma Ekranı
- **Kullanıcı adı girişi**  
- **Zorluk seçimi:**  
  - *Kolay:* 16 kart (8 farklı sayı çifti)  
  - *Zor:* 24 kart (12 farklı sayı çifti)  

### 🎯 Oyun Ekranı
- Rastgele dağıtılmış kartlar  
- Animasyonlu kart açma ve eşleşme efekti  
- Aynı anda en fazla 2 kart açık olabilir  
- Eşleşen kartlar yeşil renkle vurgulanır  
- Her eşleşme +10 puan  
- 60 saniyelik geri sayım  
- Oyun sonunda kazandı/kaybetti ekranı  

### 📊 Skorlar Ekranı
- Skorlar yüksekten düşüğe sıralanır  
- Kullanıcı adı, skor ve tarih bilgisi içerir  
- Tüm skorları temizleme özelliği  

### ⚙️ Ayarlar Sayfası
- Açık/koyu tema seçimi  
- Süre göstergesini açma/kapatma  
- Skor listesini sıfırlama  
- Uygulama bilgileri  

---

## 📸 Ekran Görüntüleri

![Ekran1](https://github.com/user-attachments/assets/c7b6b296-0173-4380-8654-3b6c8458b38b)  
![Ekran2](https://github.com/user-attachments/assets/aa785883-ce1f-4bd7-844c-5002382dfddf)  
<img width="300" src="https://github.com/user-attachments/assets/e3dfad49-736e-4258-98c6-62a71342372f" alt="Koyu Tema"/>  
<img width="300" src="https://github.com/user-attachments/assets/6199cb73-83c6-4216-8aca-4c3284fd0fd2" alt="Açık Tema"/>  
<img width="300" src="https://github.com/user-attachments/assets/b938d2bc-1352-4325-861c-e59c6b0e524b" alt="Ekran"/>  
<img width="300" src="https://github.com/user-attachments/assets/7dbbaa5c-2ce4-45f6-bd1e-8e368d5cef30" alt="Ekran"/>  

---

## 🧪 Kullanılan Teknolojiler

| Katman          | Teknoloji |
|-----------------|-----------|
| **Dil**         | Kotlin |
| **UI**          | Jetpack Compose, Material 3 |
| **Mimari**      | MVVM, Clean Architecture |
| **DI**          | Hilt (Dagger) |
| **Navigation**  | Navigation Component |
| **Veri**        | Room Database |
| **Reaktif yapı**| StateFlow, Coroutines |
| **Animasyon**   | Compose Animations |

---

## ⚙️ Kurulum ve Çalıştırma

1. Projeyi klonlayın:  
   ```bash
   git clone https://github.com/kullanici-adi/SayiEslemeOyunu.git
   ```
2. Android Studio ile projeyi açın.  
3. Gerekli bağımlılıkların yüklenmesini (Gradle sync) bekleyin.  
4. Emülatör veya fiziksel cihazda uygulamayı çalıştırın.  

---

## 🧠 Oyun Kuralları
- Başlangıçta kartlar rastgele kapalı şekilde yerleştirilir.  
- Bir karta tıklayarak sayıyı görürsünüz.  
- Aynı anda en fazla 2 kart açık olabilir.  
- Eşleşen kartlar açık kalır ve yeşile döner.  
- Eşleşmeyen kartlar kısa bir beklemeden sonra kapanır.  
- Her başarılı eşleşme **+10 puan** kazandırır.  
- **60 saniye** içinde tüm kartları eşleştirmeye çalışın.  
- Tüm kartlar eşleşirse oyunu kazanırsınız.  
- Süre biterse oyun kaybedilir.  

---

## 🧾 Geliştirici Notları
Bu proje, Android Bootcamp kapsamında bitirme projesi olarak geliştirilmiştir.  
- Clean Architecture prensipleri uygulanmıştır.  
- SOLID prensiplerine uyulmuştur.  
- Modern Android geliştirme yaklaşımları (best practices) takip edilmiştir.  
- Kod okunabilirliği ve genişletilebilirlik ön planda tutulmuştur.  
- Test yazılabilir bir yapı kurulmuştur.  

---

## 💬 Geri Bildirim & Katkı
Eğer proje hakkında öneri, geri bildirim veya katkı sağlamak isterseniz, GitHub üzerinden **issue** veya **pull request** gönderebilirsiniz. 🎉
