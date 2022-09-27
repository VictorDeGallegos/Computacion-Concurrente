@echo off 
echo             ,--.
echo          ,--.  .--,`) )  .--,
echo       .--,`) \( (` /,--./ (`
echo      ( ( ,--.  ) )\ /`) ).--,-.
echo       ;.__`) )/ /) ) ( (( (`_) )
echo      ( (  / /( (.'  -.) )) )__.'-,
echo     _,--.( ( /`         `,/ ,--,) )
echo    ( (``) \,====.    .====\( (`,-;
echo     ;-,( (_) ~8~ \  / ~8~ (_) )_) )
echo    ( (_ \_ (      )(      )__/___.'
echo    '.__,-,\ \     ''     /\ ,-.
echo       ( (_/ /\;;;;__;;;;/\ \_) )
echo        '._.'  \;;\__/;;/  '._.'
echo                \;;;;;;/
echo                 '----'
echo.
echo " ____ ____ ____ ____ ____ ____ ____ "
echo "||J |||A |||V |||A |||T |||A |||R ||"
echo "||__|||__|||__|||__|||__|||__|||__||"
echo "|/__\|/__\|/__\|/__\|/__\|/__\|/__\|"
echo.
echo.
echo BIENVENIDO %USERNAME% A LA PRACTICA DOS DEL EQUIPO JAVATAR
echo.%TIME% %DATE%
echo Compilando Practica dos
echo.

    ::RUTA DE COMPILACION
    ::Cambiar por la ruta donde se encuentre: Computacion-Concurrente\practicas\Practica2
    :: DEMIAN cd C:\Users\josed\OneDrive\Documentos\concurrente\practicas\Computacion-Concurrente\Practicas\Practica2
    :: Eiffel 
    cd C:\Users\Carlos\Documents\GitHub\Computacion-Concurrente\practicas\Practica2
    ::COMANDO DE COMPILACION
    javac -d ./classes src/Main.java src/practica2/filtros/*.java src/practica2/matrices/*.java

echo Termino compilacion
echo.
echo EMPIEZA LA EJECUCION DE PRACTICA 2
pause
echo.
    ::DEMOSTRACION DE FILTROS SECUENCIALES
    :inicio
    SET var=0
    echo.
    echo ------------------------------------------------------------------------------
    echo Este es un menu interectivo ingresa el numero de la opcion que te interese. 
   
    echo  1     Filtro Gray uno       1
    echo  2     Filtro Gray dos       2
    echo  3     Filtro Gray tres      3
    echo  4     Filtro Gray cuatro    4   
    echo  5     Filtro Alto Contraste 5 
    echo  6     Filtro Componente RGB 6
    echo  7     Filtro Blur uno       7 
    echo  8     Filtro Blur dos       8
    echo  9     Filtro Blur           9
    echo  10    Filtro Sharpen        10    
    echo  11    Salir 

    SET /p var= ^> Seleccione una opcion [1-10]:

    if "%var%"=="0" goto inicio
    if "%var%"=="1" goto op1
    if "%var%"=="2" goto op2
    if "%var%"=="3" goto op3
    if "%var%"=="4" goto op4
    if "%var%"=="5" goto op5
    if "%var%"=="6" goto op6
    if "%var%"=="7" goto op7
    if "%var%"=="8" goto op8
    if "%var%"=="9" goto op9
    if "%var%"=="10" goto op10
    if "%var%"=="11" goto salir

    ::Mensaje de error, validación cuando se selecciona una opción fuera de rango
    echo. El numero "%var%" no es una opcion valida, por favor intente de nuevo.
    echo.
    pause
    echo.
    goto:inicio

    :op1
        echo.
        echo. Has elegido la opcion No. 1 Gray
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
        java -cp ./classes Main %var1% imagenes/javatar%var3%.png 1 false %var2%


        color 08
        echo.
        pause
    goto:inicio

    :op2
               echo.
        echo. Has elegido la opcion No. 2 Gray
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
        java -cp ./classes Main %var1% imagenes/javatar%var3%.png 2 false %var2%
        color 09
        echo.
        pause
    goto:inicio

    :op3
        echo.
        echo. Has elegido la opcion No. 3 Gray
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
        java -cp ./classes Main %var1% imagenes/javatar%var3%.png 3 false %var2%
        color 0A
        echo.
        pause
   goto:inicio
  
    :op4
        echo.
        echo. Has elegido la opcion No. 4 Gray
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
         java -cp ./classes Main %var1% imagenes/javatar%var3%.png 4 false %var2%
        color 0B
        echo.
        pause
    goto:inicio

    :op5
        echo.
        echo. Has elegido la opcion No. 5 Alto Contraste
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
        java -cp ./classes Main %var1% imagenes/javatar%var3%.png 5 false %var2%
        color 0C
        echo.
        pause
    goto:inicio

    :op6
        echo.
        echo. Has elegido la opcion No. 6 Componentes RGB
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
         java -cp ./classes Main %var1% imagenes/javatar%var3%.png 6 false %var2%
        color 0C
        echo.
        pause
    goto:inicio

    :op7
        echo.
        echo. Has elegido la opcion No. 7 Componentes Blur
        echo.
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
         java -cp ./classes Main %var1% imagenes/javatar%var3%.png 7 false %var2%
        color 0C
        echo.
        pause
    goto:inicio

    :op8
        echo.
        echo. Has elegido la opcion No. 8 Componentes Blur
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
        java -cp ./classes Main %var1% imagenes/javatar%var3%.png 8 false %var2%
        color 0C
        echo.
        pause
    goto:inicio

    :op9
        echo.
        echo. Has elegido la opcion No. 9 Blur
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
        
        java -cp ./classes Main %var1% imagenes/javatar%var3%.png 9 false %var2%
        color 0C
        echo.
        pause
    goto:inicio

    :op10
        echo.
        echo. Has elegido la opcion No. 10 Sharpen
        echo.
        echo Ingresa un numero de la matriz de aplicacion solo acepta matriz de 10x10, 100x100, 1000x1000
        echo si quieres una matriz de 10x10 entonces ingresa 10
        echo si quieres una matriz de 100x100 entonces ingresa 100
        echo si quieres una matriz de 1000x1000 entonces ingresa 1000
        SET var1=0
        SET /p var1= ^> ingresa tu numero [1-1000]:
        echo Ingresa un numero de hilos Te recomendamos entre 1 y 1000 hilos
        SET var2=0
        SET /p var2= ^> ingresa tu numero [1 - 1000]:
        echo Tenemos tres ejemplos de imagen con ¿cual quiereres tarabajar? ¿1 o 2 o 3?
        SET var3=0
        SET /p var3= ^> ingresa tu numero [1 o 2 o 3]:
         java -cp ./classes Main %var1% imagenes/javatar%var3%.png 10 false %var2%
        color 0C
        echo.
        pause
    goto:inicio

    :salir
        @cls&exit

 pause
pause exit