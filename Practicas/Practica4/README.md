# Practica 4 - Problemas Concurrentes

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Status badge](https://img.shields.io/badge/status-%20terminado-green?style=for-the-badge)

## Computacion concurrente, Universidad Nacional Autónoma de México semestre 2023-1

> ---
>
> * **Victor Hugo Gallegos Mota** - *316160456* - [VictorDeGallegos](https://github.com/VictorDeGallegos)
> * **José Demian Jiménez** - *314291707* - [demian35](https://github.com/demian35)
> * **Carlos Cruz Rangel** - *314208682* - [CarlosCruzRangel](https://github.com/CarlosCruzRangel)
> * **Ernesto Muñoz Nieves** - *314133586* - [ernt](https://github.com/ernt)
> * **Juan Carlos Bautista Sandoval** - *314275541* - [JuanBautistta](https://github.com/JuanBautistta)
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

Desarrollamos la practica en el IDE Visual Studio Code, por lo que se recomienda utilizarlo para ejecutar los scripts.

Utilizamos el plugin [Code Runner](https://marketplace.visualstudio.com/items?itemName=formulahendry.code-runner) para ejecutar los scripts. Basta con abrir el archivo FiltroLockTest.java ó PetersonLockTest.java y presionar `Ctrl+Alt+N` para ejecutarlos.

### Para Problema de los Inversores 💰

Bastó con ejecutar directamente en VS code en el botón run de la clase `TenedorTest.java`

|![Run](https://user-images.githubusercontent.com/41756950/206749624-6c937c1d-4a7d-4fec-96fa-92ba4a325952.png)|
|:--------------------------:|
|**Botón ejecutar**|

| ![TenedorTest](https://user-images.githubusercontent.com/41756950/206749059-dc801e33-5ed7-4c1e-b856-a520776864f2.png) |
|:--------------------------:|
|**Resultado en consola de TenedorTes.java**|

### Para el problema de los baños concurrentes 🚽

Se creo una clase principal `MainBannos.java` que ejecuta este problema, para ejecutarlo se puede hacer directo en la clase ejecutando la funcion run:

|![Run baños](https://user-images.githubusercontent.com/41756950/206757914-c3e96d77-7574-4291-b66d-9456f7f60822.png)|
|:--------------------------:|
|**Botón ejecutar**|

| <img align="center" width="622" alt="Run" src="https://user-images.githubusercontent.com/41756950/206758248-daf76d05-4bc2-4dc6-a086-b6a64d52293e.png">|
|:--------------------------:|
|**Resultado en consola de MainBannos.java**|


## Teoria 📖

Responde las siguientes preguntas, justificando tu respuesta:

* Si solo tuvieramos un hilo trabajando en Tía Aly, mejora, disminuye o se mantiene igual en terminos de rendimiento.

   **Respuesta:** Se mantiene igual en terminos de rendimiento.

* De que otra manera se puede implementar el Problema de la Tía Aly

    **Respuesta:** Se puede implementar con un semaforo binario.

* ¿Si tuvieramos n cocineros para n filas, siempre mejoraria el rendimiento?

    **Respuesta:** Si, siempre mejoraria el rendimiento. Como es el caso de los cajeros de un banco, si hay 5 cajeros para 5 filas, siempre mejorara el rendimiento.

* Tu propuesta para el problema de la Tía Aly, ¿cumple con la propiedad de Justicia? Justifica.

    **Respuesta:** Si, cumple con la propiedad de justicia, ya que los hilos se van a ir alternando en el uso de los recursos.

---
⌨️ con ❤️ por  [VictorDeGallegos](https://github.com/VictorDeGallegos), [demian35](https://github.com/demian35), [ernt](https://github.com/ernt), [CarlosCruzRangel](https://github.com/CarlosCruzRangel) y [JuanBautistta](https://github.com/JuanBautistta)
