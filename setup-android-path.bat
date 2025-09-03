@echo off
REM This script adds Android SDK platform-tools to your system PATH
REM Run this once to enable direct use of adb, fastboot, etc.

echo Adding Android SDK platform-tools to system PATH...

REM Add to user PATH (doesn't require admin rights)
setx PATH "%PATH%;C:\Users\James\AppData\Local\Android\Sdk\platform-tools"

if %ERRORLEVEL% equ 0 (
    echo ✓ Successfully added Android SDK tools to PATH!
    echo ✓ You can now use 'adb', 'fastboot' commands directly
    echo ✓ Restart your terminal/IDE to use the new PATH
    echo.
    echo To test, open a new terminal and run: adb devices
) else (
    echo ✗ Failed to update PATH. You may need to run as administrator.
)

pause