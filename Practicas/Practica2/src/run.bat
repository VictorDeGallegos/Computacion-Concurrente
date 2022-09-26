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
    cd C:\Users\josed\OneDrive\Documentos\concurrente\practicas\Computacion-Concurrente\Practicas\Practica2
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
    echo  6    Salir 

    SET /p var= ^> Seleccione una opcion [1-6]:

    if "%var%"=="0" goto inicio
    if "%var%"=="1" goto op1
    if "%var%"=="2" goto op2
    if "%var%"=="3" goto op3
    if "%var%"=="4" goto op4
    if "%var%"=="5" goto op5
    if "%var%"=="6" goto salir

    ::Mensaje de error, validación cuando se selecciona una opción fuera de rango
    echo. El numero "%var%" no es una opcion valida, por favor intente de nuevo.
    echo.
    pause
    echo.
    goto:inicio

    :op1
        echo.
        echo. Has elegido la opcion No. 1
        echo.
        ::Aquí van las líneas de comando de tu opción
        color 08
        echo.
        pause
    goto:inicio

    :op2
        echo.
        echo. Has elegido la opcion No. 2
        echo.
            ::Aquí van las líneas de comando de tu opción
        color 09
        echo.
        pause
    goto:inicio

    :op3
        echo.
        echo. Has elegido la opcion No. 3
        echo.
        ::Aquí van las líneas de comando de tu opción
        color 0A
        echo.
        pause
   goto:inicio
  
    :op4
        echo.
        echo. Has elegido la opcion No. 4
        echo.
        ::Aquí van las líneas de comando de tu opción
        color 0B
        echo.
        pause
    goto:inicio

    :op5
        echo.
        echo. Has elegido la opcion No. 5
        echo.
        java -cp ./classes Main 10 imagenes/javatar.png 3 false 5
        color 0C
        echo.
        pause
    goto:inicio

    :salir
        @cls&exit



    


 pause
pause exit