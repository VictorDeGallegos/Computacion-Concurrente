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
    cd C:\Users\Carlos\Documents\GitHub\Computacion-Concurrente\practicas\Practica2\src\practica2\sumas
    ::COMANDO DE COMPILACION
    javac SumaSecuencial.java
    javac SumaConcurrente.java

echo Termino compilacion
echo.
echo EMPIEZA LA EJECUCION DE LAS SUMAS DE LA PRACTICA 2
 :inicio
    SET var=0
    echo.
    echo ------------------------------------------------------------------------------
    echo Este es un menu interectivo ingresa el numero de la opcion que te interese. 
   
    echo  1     Suma Secuencial       1
    echo  2     Suma Concurrente      2
    echo  3     Salir 

    SET /p var= ^> Seleccione una opcion [1-10]:

    if "%var%"=="0" goto inicio
    if "%var%"=="1" goto op1
    if "%var%"=="2" goto op2
    if "%var%"=="3" goto salir

    ::Mensaje de error, validación cuando se selecciona una opción fuera de rango
    echo. El numero "%var%" no es una opcion valida, por favor intente de nuevo.
    echo.
    pause
    goto:inicio

    :op1
        echo.
        echo. Has elegido la opcion entonces se ejecutara la suma secuencial
        echo.
            java SumaSecuencial.java
        color 08
        echo.
        pause
    goto:inicio

    :op2
        echo.
        echo. Has elegido la opcion dos la cual te mostrara la suma concurrente.
        echo.
            java SumaConcurrente.java
        color 09
        echo.
        pause
    goto:inicio

    :salir
        @cls&exit
pause
echo.
pause exit