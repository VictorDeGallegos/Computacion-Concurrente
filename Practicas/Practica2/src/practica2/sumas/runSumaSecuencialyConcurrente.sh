#! /bin/sh

echo '      ,--.  .--,`) )  .--,      '
echo '   .--,`) \( (` /,--./ (`       '
echo '  ( ( ,--.  ) )\ /`) ).--,-.    '
echo '   ;.__`) )/ /) ) ( (( (`_) )   '
echo ' ( (  / /( (.   -.= )))__. -,   '
echo ' _,--.( ( /`         `,/ ,--,) )'
echo '( (``) \,====.    .====\( (`,-; '
echo ' ;-,( (_) ~8~ \  / ~8~ (_) )_) )'
echo '( (_ \_ (      )(      )__/___. '
echo ' .__,-,\ \     ºº      /\ ,-.   '
echo '   ( (_/ /\;;;;__;;;;/\ \_) )   '
echo '           \;;\__/;;/           '
echo '            \;;;;;;/            '
echo '              ----              '
echo ' ____ ____ ____ ____ ____ ____ ____ '
echo ' ____ ____ ____ ____ ____ ____ ____ '
echo '||J |||A |||V |||A |||T |||A |||R ||'
echo '||__|||__|||__|||__|||__|||__|||__||'
echo '|/__\|/__\|/__\|/__\|/__\|/__\|/__\|'
echo
echo
echo BIENVENIDO $USERNAME A LA PRACTICA DOS DEL EQUIPO JAVATAR
date +%D 
echo Compilando Practica dos desde:
echo

#RUTA DE COMPILACION
#Cambiar por la ruta donde se encuentre: Computacion-Concurrente/practicas/Practica2/src/practica2/sumas
cd /Users/victor/Documents/GitHub/Computacion-Concurrente/practicas/Practica2/src/practica2/sumas
javac /Users/victor/Documents/GitHub/Computacion-Concurrente/practicas/Practica2/src/practica2/sumas/SumaSecuencial.java
javac /Users/victor/Documents/GitHub/Computacion-Concurrente/practicas/Practica2/src/practica2/sumas/SumaConcurrente.java

echo Termino compilacion
echo
echo EMPIEZA LA EJECUCION DE PRACTICA 2
echo
java SumaSecuencial.java
java SumaConcurrente.java
echo
echo Termino la ejecucion
echo
