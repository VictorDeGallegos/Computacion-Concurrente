# Practica 5 - Aplicaciones de la Computación Concurrente

![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![JAVASCRIPT](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![Status badge](https://img.shields.io/badge/status-%20terminado-green?style=for-the-badge)

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

*Para poder ejecutar las aplicaciones es necesario tener conocimientos en html css y js*

## Ejecutar scripts 🚀

Desarrollamos la practica en el IDE Visual Studio Code, por lo que se recomienda utilizarlo para levantar el servidor con la extension [LiveServer](https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer).
Otra opcion mas sencilla es visitar el siguiente link donde se encuentra la aplicacion en produccion:
**[Gas-Zeratún](https://bucolic-gingersnap-47be36.netlify.app/)**

## PROBLEMA 1: Gas-Zeratún 🔥

Desarrollamos un porgrama que simula una cola virtual, o manejadador de turnos para una tienda en linea que distribuye tanques de gas, el usuario necesita consultar que tanques estan disponibles para posteriormente apartarlos o comparlos utilizando su numero de telefono.
Poisterior a esto podra consultar que tanques ha adquirido, mientras que otros usuarios no podran acceder a comprar el mismo puesto que se cumple la propiedad de justicia

### Capturas en ejecución

#### Pagina de inicio

En esta pagina se muestra el menu principal, el cual contiene las opciones de consultar tanques disponibles, consultar los tanques adquiridos.

<img width="600" alt="inicio" src="https://user-images.githubusercontent.com/41756950/204083599-ed920e2e-534c-4c42-946b-d300d86d9dbb.png">

#### Consultar tanques disponibles

En esta pagina se muestra la lista de tanques disponibles, el usuario puede seleccionar el tanque que desee y posteriormente comprarlo-reservarlo.

<img width="600" alt="Disponibles" src="https://user-images.githubusercontent.com/41756950/204083669-74c028e8-43ac-4d78-996c-94f6fb51ef69.png">

#### Reservar tanque

En esta pagina se muestra el tanque que el usuario selecciono, el usuario puede reservar por su numero de telefono el tanque o cancelar la operacion volviendo al inicio.

<img width="600" alt="reservar" src="https://user-images.githubusercontent.com/41756950/204083709-0aecfe8e-0ce4-4fd3-a93e-e5b38457165e.png">

#### Alerta satisfactoria

En esta pagina se muestra la alerta de que el tanque fue reservado con exito, el usuario puede volver al inicio o consultar los tanques reservados.

<img width="600" alt="Alerta satisfactoria" src="https://user-images.githubusercontent.com/41756950/204083756-d4a77c83-3622-4606-aa86-3e6d61eddec2.png">

#### Consultar tanques reservados

En esta pagina se muestra la lista de tanques reservados por el usuario

<img width="600" alt="Tanque recibido" src="https://user-images.githubusercontent.com/41756950/204083823-6d1ee6af-b266-4d35-9e91-e6d595a2b5c9.png">

#### Alerta de error al intentar reservar el mismo tanque

Despues de realizar el mismo procedimiento pero con un numero de telefono distinto se muestra una alerta indicando que ese tanque ya fue reservado por otro usuario.

<img width="600" alt="Alerta error" src="https://user-images.githubusercontent.com/41756950/204083867-a6fce51a-d60e-46f4-b8ee-e95ab9fa3fb7.png">

## PROBLEMA 2 De Regalo 🎁:

A Zeratún le encanta la pelicula de “Shrek 2”, por lo que decidio innovar en sus tanques de gas
por lo que necesitan de su ayuda, en primer lugar , sus clientes le mandan diseños, pero cuando
llegan se almacenan en una base de datos, pero lamentablemente cuando se les asigna un ID se
pueden a llegar a sobrescribir y perder la referencia, por lo que les pide 2 cosas:

1. Proponer una solución para que no se sobrescriba, de tal manera que se conserven ambas
imágenes
    Una solución que yo he utilizado para resolver este problema en otros proyectos es simplmente crear una variable la cual sea igual a la fecha y hora actual, de esta manera se podria crear un id unico para cada imagen, y con esto evitar que se sobrescriban ya que al concatenar la fecha + la ruta de la imagen se crea un archivo único.

   Ejemplo en php

    ```php
    $id = date("YmdHis"); //
    $ruta = "imagenes/".$id.".png"; // Ruta de la imagen
    move_uploaded_file($_FILES["imagen"]["tmp_name"], $ruta); // Mover imagen a la ruta
    ```

2. Realizar un dibujo para enviarsela como propuesta a Zeratun

20211020123456.shrek.png
<img width="300" alt="Alerta error" src="https://printmania.online/wp-content/uploads/2018/01/shrek-708x640.jpg">
20211020123457.shrek.png
<img width="300" alt="Alerta error" src="https://printmania.online/wp-content/uploads/2018/01/shrek-708x640.jpg">

---
⌨️ con ❤️ por  [VictorDeGallegos](https://github.com/VictorDeGallegos), [demian35](https://github.com/demian35), [ernt](https://github.com/ernt), [CarlosCruzRangel](https://github.com/CarlosCruzRangel) y [JuanBautistta](https://github.com/JuanBautistta)