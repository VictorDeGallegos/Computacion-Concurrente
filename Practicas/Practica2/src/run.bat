::@echo off 
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
    ::cd C:\Users\josed\OneDrive\Documentos\concurrente\practicas\Computacion-Concurrente\Practicas\Practica2
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
    cls
    echo ------------------------------------------------------------------------------
    echo.
   
    echo  1    Opcion 1  
    echo  2    Opcion 2  
    echo  3    Opcion 3  
    echo  4    Opcion 4  
    echo  5    Opcion 5 
    echo  6    Opcion 6
    echo  7    Opcion 7 
    echo  8    Opcion 8
    echo  9    Opcion 9
    echo  10    Opcion 10    
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
        ::Aquí van las líneas de comando de tu opción
        java -cp ./classes Main 100 imagenes/javatar.png 1 false 5


        color 08
        echo.
        pause
    goto:inicio

    :op2
        echo.
        echo. Has elegido la opcion No. 2 Gray
        echo.
            ::Aquí van las líneas de comando de tu opción
         java -cp ./classes Main 100 imagenes/javatar.png 2 false 5   
        color 09
        echo.
        pause
    goto:inicio

    :op3
        echo.
        echo. Has elegido la opcion No. 3 Gray
        echo.
        ::Aquí van las líneas de comando de tu opción
        java -cp ./classes Main 100 imagenes/javatar.png 3 false 5
        color 0A
        echo.
        pause
   goto:inicio
  
    :op4
        echo.
        echo. Has elegido la opcion No. 4 Gray
        echo.
        ::Aquí van las líneas de comando de tu opción
        java -cp ./classes Main 100 imagenes/javatar.png 4 false 5
        color 0B
        echo.
        pause
    goto:inicio

    :op5
        echo.
        echo. Has elegido la opcion No. 5 Alto Contraste
        echo.
        java -cp ./classes Main 100 imagenes/javatar.png 5 false 5
        color 0C
        echo.
        pause
    goto:inicio

    :op6
        echo.
        echo. Has elegido la opcion No. 6 Componentes RGB
        echo.
        java -cp ./classes Main 100 imagenes/javatar.png 6 false 5
        color 0C
        echo.
        pause
    goto:inicio

    :op7
        echo.
        echo. Has elegido la opcion No. 7 Componentes Blur
        echo.
        java -cp ./classes Main 100 imagenes/javatar.png 7 false 5
        color 0C
        echo.
        pause
    goto:inicio

    :op8
        echo.
        echo. Has elegido la opcion No. 8 Componentes Blur
        echo.
        java -cp ./classes Main 10 imagenes/javatar.png 8 false 5
        color 0C
        echo.
        pause
    goto:inicio

    :op9
        echo.
        echo. Has elegido la opcion No. 9 Blur
        echo.
        java -cp ./classes Main 10 imagenes/javatar.png 9 false 5
        color 0C
        echo.
        pause
    goto:inicio

    :op10
        echo.
        echo. Has elegido la opcion No. 10 Sharpen
        echo.
        java -cp ./classes Main 10 imagenes/javatar.png 10 false 5
        color 0C
        echo.
        pause
    goto:inicio

    :salir
        @cls&exit



    


 pause
pause exit