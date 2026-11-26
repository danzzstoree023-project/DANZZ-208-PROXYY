# DANZZ 208 PROXY — Android starter

Starter project Android native (Kotlin + Jetpack Compose) dengan tema navy/neon blue.

## Build APK melalui GitHub Actions (tanpa PC)
1. Buat repository GitHub baru, misalnya `DANZZ-208-PROXY`.
2. Upload seluruh isi folder ZIP ini ke root repository (jangan upload folder pembungkusnya).
3. Buka tab **Actions**. Jika diminta, izinkan workflow.
4. Pilih **Build DANZZ 208 PROXY APK** lalu tekan **Run workflow** (atau tunggu build otomatis setelah push).
5. Setelah selesai, buka run terbaru, bagian **Artifacts**, unduh `DANZZ-208-PROXY-debug`.
6. Ekstrak ZIP artifact, lalu install `app-debug.apk` di Android.

## Catatan penting
- Ini adalah starter UI/build pipeline, belum menghubungkan login Supabase, backend API, Proxy-Seller, SOCKS5 gateway, atau Android VPNService.
- Tombol CONNECT saat ini hanya demonstrasi tampilan; belum membuat koneksi internet/proxy.
- Untuk menyamakan halaman CONNECT dengan screenshot referensi, kirim ulang screenshot tersebut di chat ini.
- Jangan pernah memasukkan Supabase Secret Key, bot token, atau JWT secret ke dalam aplikasi Android atau repository publik.
