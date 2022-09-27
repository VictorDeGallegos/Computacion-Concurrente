# Practica 2 - Introducción a Hilos.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Status badge](https://img.shields.io/badge/status-%20terminado-green?style=for-the-badge)

## Computacion concurrente, Universidad Nacional Autónoma de México semestre 2023-1

> ---
>
> * **Victor Hugo Gallegos Mota** - *316160456* - [VictorDeGallegos](https://github.com/VictorDeGallegos)
> * **José Demian Jiménez** - *314291707* - [demian35](https://github.com/demian35)
> * **Carlos Cruz Rangel** - *314208682* - [CarlosCruzRangel](https://github.com/CarlosCruzRangel)
> * **Ernesto Muñoz Nieves** - *314133586* - [ernt](https://github.com/ernt)
> * **Juan Carlos Bautista Sandoval** - ** - [JuanBautistta](https://github.com/JuanBautistta)
>
>
>
> ---


## Pre-requisitos 📋

*Para poder ejecutar las aplicaciones es necesario tener instalado alguna version de java como java 8 o java 11.*

Probado en macOS

```bash
java -version
openjdk version "11.0.14" 2022-01-18 LTS
OpenJDK Runtime Environment Zulu11.54+23-CA (build 11.0.14+9-LTS)
OpenJDK 64-Bit Server VM Zulu11.54+23-CA (build 11.0.14+9-LTS, mixed mode)
```

## Ejecutar scripts 🚀

*Los siguientes comandos ejecutaran los programas de filtros, sumas sopas etc.*

### Para los filtros y matrices:

Bastaa con dar click 2 veces al el archivo **`run.bat`** para **Windows**

Esto ejecutara el programa mostrando el siguiente menu de opciones

```bash
            ,--.
         ,--.  .--,`) )  .--,
      .--,`) \( (` /,--./ (`
     ( ( ,--.  ) )\ /`) ).--,-.
      ;.__`) )/ /) ) ( (( (`_) )
     ( (  / /( (.'  -.) )) )__.'-,
    _,--.( ( /`         `,/ ,--,) )
   ( (``) \,====.    .====\( (`,-;
    ;-,( (_) ~8~ \  / ~8~ (_) )_) )
   ( (_ \_ (      )(      )__/___.'
   '.__,-,\ \     ''     /\ ,-.
      ( (_/ /\;;;;__;;;;/\ \_) )
       '._.'  \;;\__/;;/  '._.'
               \;;;;;;/
                '----'

" ____ ____ ____ ____ ____ ____ ____ "
"||J |||A |||V |||A |||T |||A |||R ||"
"||__|||__|||__|||__|||__|||__|||__||"
"|/__\|/__\|/__\|/__\|/__\|/__\|/__\|"


BIENVENIDO Carlos A LA PRACTICA DOS DEL EQUIPO JAVATAR
 1:51:09.38 27/09/2022
Compilando Practica dos

Termino compilacion

EMPIEZA LA EJECUCION DE PRACTICA 2
Presione una tecla para continuar . . .


------------------------------------------------------------------------------
Este es un menu interectivo ingresa el numero de la opcion que te interese.
 1     Filtro Gray uno       1
 2     Filtro Gray dos       2
 3     Filtro Gray tres      3
 4     Filtro Gray cuatro    4
 5     Filtro Alto Contraste 5
 6     Filtro Componente RGB 6
 7     Filtro Blur uno       7
 8     Filtro Blur dos       8
 9     Filtro Blur           9
 10    Filtro Sharpen        10
 11    Salir
> Seleccione una opcion [1-10]:

```

Y podremos interactuar con el programa de la siguiente forma:

![ejecucion](https://user-images.githubusercontent.com/41756950/192454835-e8c9200a-15cc-4daa-8952-8d569182662c.png)

Una vez aplicado todos los parametros obtenemos el siguiente resultado :

![resultado](https://user-images.githubusercontent.com/41756950/192456548-3b506eee-f3c3-4a06-998f-40ca6b2031e8.png)


Se intento hacer una interfaz grafica pero no se logro, pero se puede ver el codigo en la carpeta **`src`** en el archivo **`Main.java`** el cual aparece comentado y algo asi era su diseño (cargaba la imagen pero no aplicaba los cambios solo es **ilustrativo**).

![Interfaz grafica filtros](https://user-images.githubusercontent.com/41756950/190452932-1d906a42-cc4e-4feb-a563-aa824f307810.png)

### Para las sumas:
Basta con dar click 2 veces al el archivo **`runSumaSecuencialyConcurrente.bat`** para **Windows** o para ejecutar en Linux o Mac en la terminal

Para dar permisos de ejecucion al archivo:

```bash
chmod + runSumaSecuencialyConcurrente.sh
```

Ahora para ejecutar el programa:

```bash
sh runSumaSecuencialyConcurrente.sh  
```

Nos aparecera el siguiente menu de opciones:

```bash
            ,--.
         ,--.  .--,`) )  .--,
      .--,`) \( (` /,--./ (`
     ( ( ,--.  ) )\ /`) ).--,-.
      ;.__`) )/ /) ) ( (( (`_) )
     ( (  / /( (.'  -.) )) )__.'-,
    _,--.( ( /`         `,/ ,--,) )
   ( (``) \,====.    .====\( (`,-;
    ;-,( (_) ~8~ \  / ~8~ (_) )_) )
   ( (_ \_ (      )(      )__/___.'
   '.__,-,\ \     ''     /\ ,-.
      ( (_/ /\;;;;__;;;;/\ \_) )
       '._.'  \;;\__/;;/  '._.'
               \;;;;;;/
                '----'

" ____ ____ ____ ____ ____ ____ ____ "
"||J |||A |||V |||A |||T |||A |||R ||"
"||__|||__|||__|||__|||__|||__|||__||"
"|/__\|/__\|/__\|/__\|/__\|/__\|/__\|"


BIENVENIDO Carlos A LA PRACTICA DOS DEL EQUIPO JAVATAR
 2:02:09.34 27/09/2022
Compilando Practica dos

Termino compilacion

EMPIEZA LA EJECUCION DE LAS SUMAS DE LA PRACTICA 2

------------------------------------------------------------------------------
Este es un menu interectivo ingresa el numero de la opcion que te interese.
 1     Suma Secuencial       1
 2     Suma Concurrente      2
 3     Salir
> Seleccione una opcion [1-10]:
```

Y podremos interactuar con el programa de la siguiente forma (Se puede visualizar como genera suma secuencial usted visualizara ambas sumas):

![suma](https://user-images.githubusercontent.com/41756950/192457198-af8d1073-5e9f-43c8-bfab-774e5950e0c9.png)

### Para las sopas de letras:
Para ejecutar sopas recomendamos ejecutarlo utilizando la extension [CodeRunner](https://marketplace.visualstudio.com/items?itemName=formulahendry.code-runner) de **Visual Studio Code** para que se ejecute de manera mas rapida y se pueda visualizar el resultado en la terminal.

El resultado seria el siguiente para **SopaDeLetras(Secuencial)**

![secuencialsopas](https://user-images.githubusercontent.com/41756950/192460570-312197e4-6140-432e-ab03-e6a39df7c8a3.png)

Y para **SopaDeLetras(Concurrente)**

![sopaconcurrente](https://user-images.githubusercontent.com/41756950/192460864-49640e90-e323-4469-8927-9d051d8407e2.png)



## Expresiones de Gratitud 🎁

* Comenta a otros sobre este proyecto 📢
* Invita una cerveza 🍺 o un café ☕ a alguien del equipo.
* 10/10 en la tarea 1 🤓

---
⌨️ con ❤️ por  [VictorDeGallegos](https://github.com/VictorDeGallegos), [demian35](https://github.com/demian35), [ernt](https://github.com/ernt), [CarlosCruzRangel](https://github.com/CarlosCruzRangel) y [JuanBautistta](https://github.com/JuanBautistta)