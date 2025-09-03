@echo off
REM Script to easily run the app on your connected device
REM This script builds and installs the app to external storage to avoid space issues

echo Building and installing app to device...
set PATH=%PATH%;C:\Users\James\AppData\Local\Android\Sdk\platform-tools

REM Build the debug APK
call gradlew.bat assembleDebug
if %ERRORLEVEL% neq 0 (
    echo Build failed!
    pause
    exit /b 1
)

REM Install to device with external storage preference
adb install -r --install-location 2 app\build\outputs\apk\debug\app-debug.apk
if %ERRORLEVEL% neq 0 (
    echo Installation failed!
    pause
    exit /b 1
)

echo App successfully installed and ready to run!
echo You can now find "My Application" on your device.
pause