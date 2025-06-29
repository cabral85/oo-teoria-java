@echo off
echo Compilando o projeto...
if not exist "bin" mkdir bin
javac -d bin src/main/java/banco/**/*.java
if %errorlevel% equ 0 (
    echo Compilacao concluida com sucesso!
    echo.
    echo Para executar o programa, use: java -cp bin banco.Main
) else (
    echo Erro na compilacao!
)
pause 