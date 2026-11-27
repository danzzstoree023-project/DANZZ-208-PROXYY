# DANZZ 208 PROXYY — Clean Android Build Project

This is a minimal native Android app project using Java and Android Views. It avoids Kotlin and Compose plugins to reduce build configuration complexity.

## Upload to GitHub
Upload the contents of this ZIP to the repository root. Ensure these files are at the root:
- `settings.gradle`
- `build.gradle`
- `gradle.properties`
- `app/build.gradle`
- `.github/workflows/build-apk.yml`

Do not leave old conflicting Kotlin DSL files in the repository:
- `settings.gradle.kts`
- `build.gradle.kts`
- `app/build.gradle.kts`

## Build
Open GitHub repository → Actions → Build DANZZ 208 PROXYY APK → Run workflow.
When successful, open the run → Artifacts → download `DANZZ-208-PROXYY-debug`. Extract it and install `app-debug.apk`.

## Important limitation
The CONNECT button in this starter is a UI demonstration only. It does not connect to a real proxy or create a VPN tunnel. Supabase authentication, API integration, proxy provider/gateway, SOCKS5 routing and Android VPNService must be implemented and tested in later stages. Never put Supabase Secret Key, Telegram bot token, or JWT signing secret in a public repository or APK.
