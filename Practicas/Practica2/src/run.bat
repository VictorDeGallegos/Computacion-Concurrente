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
echo BIENVENIDO A LA PRACTICA DOS DEL EQUIPO JAVATAR
echo.
echo Compilando Practica dos
echo.

    ::RUTA DE COMPILACION
    ::Cambiar por la ruta donde se encuentre: Computacion-Concurrente\practicas\Practica2
    cd C:\Users\Carlos\Documents\GitHub\Computacion-Concurrente\practicas\Practica2
    ::COMANDO DE COMPILACION
    javac -d ./classes src/Main.java src/practica2/filtros/*.java src/practica2/matrices/*.java

echo Termino compilacion
echo.
echo EMPIEZA LA EJECUCION DE PRACTICA 2
pause
echo.
    ::DEMOSTRACION DE FILTROS SECUENCIALES
    echo A continuacion te mostraremos los filtros secuenciales
    ::cd C:\Users\Carlos\Documents\GitHub\Computacion-Concurrente\practicas\Practica2
    java -cp ./classes Main 10 imagenes/javatar.png 3 false 5


 pause
pause exit