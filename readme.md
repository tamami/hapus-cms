# Informasi Hapus CMS

Aplikasi ini digunakan untuk melakukan pembatalan SPPT berdasarkan SK manual, bentuk filenya harus berformat sebagai berikut :

```
NOP | TAHUN
```

Proyek ini telah lengkap dengan menggunakan Connection Pool BoneCP pada hibernate, dan memanfaatkan feature Log4j untuk menyimpan informasi saat runtime, dan melakukan uji modul dengan junit.

# Cara jalankan aplikasi dengan maven

Caranya adalah dengan mengetik perintah berikut :

```
mvn exec:java -Dexec.mainClass="lab.aikibo.main.App" -Dexec.args="file daftar nop dengan format diatas"
```

baris perintah diatas sebetulnya bisa dibuatkan file .bat atau .sh sehingga mempermudah untuk menjalankan aplikasi bagi user.