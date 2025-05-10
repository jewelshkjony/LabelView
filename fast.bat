@echo off

setlocal

set "FAST_PATH=%~dp0"

if exist "%FAST_PATH%\fast.jar" (
    java -jar "%FAST_PATH%\fast.jar" %*
) else (
    echo Fast is not installed!
)

endlocal
