# PowerShell script to build and install app to your connected device
# This handles the storage space issue by installing to external storage

Write-Host "Building and installing app to device..." -ForegroundColor Green

# Add Android SDK platform-tools to PATH for this session
$env:PATH += ";C:\Users\James\AppData\Local\Android\Sdk\platform-tools"

try {
    # Build the debug APK
    Write-Host "Building APK..." -ForegroundColor Yellow
    & .\gradlew.bat assembleDebug
    if ($LASTEXITCODE -ne 0) {
        throw "Build failed with exit code $LASTEXITCODE"
    }
    
    # Check if device is connected
    Write-Host "Checking device connection..." -ForegroundColor Yellow
    $devices = & adb devices
    if ($devices -notmatch "device$") {
        throw "No device connected. Please connect your device and enable USB debugging."
    }
    
    # Install to device with external storage preference
    Write-Host "Installing to device..." -ForegroundColor Yellow
    & adb install -r --install-location 2 app\build\outputs\apk\debug\app-debug.apk
    if ($LASTEXITCODE -ne 0) {
        throw "Installation failed with exit code $LASTEXITCODE"
    }
    
    Write-Host "✓ App successfully installed and ready to run!" -ForegroundColor Green
    Write-Host "You can now find 'My Application' on your device." -ForegroundColor Cyan
    
} catch {
    Write-Host "Error: $_" -ForegroundColor Red
    exit 1
}