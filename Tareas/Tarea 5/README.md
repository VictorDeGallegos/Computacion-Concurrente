# Tarea 5 - Estructuras de Datos Concurrentes

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Status badge](https://img.shields.io/badge/status-en%20progreso-yellow?style=for-the-badge)

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

Desarrollamos la practica en el IDE Visual Studio Code, por lo que se recomienda utilizarlo para ejecutar los scripts.

Utilizamos el plugin [Code Runner](https://marketplace.visualstudio.com/items?itemName=formulahendry.code-runner) para ejecutar los scripts. Basta con abrir cada archivo de forma individua o solo el arhivo Main.java  y presionar `Ctrl+Alt+N` para ejecutarlos al mismo tiempo.

O bien, se puede ejecutar todos al mismo tiempo desde la terminal con el siguiente comando:

### Para Main.java

```bash
javac Main.java
```

```bash
java Main
```

| ![Algoritmos en ejecucion](https://cdn.discordapp.com/attachments/1007174346265067553/1038007497245589554/terminal.png)|
|:--------------------------:|
|**Tiempo de ejecucion de los Algoritmos con 3 hilos**|

## Pruebas de rendimiento

### HP EliteBook 8460p 💻

![Windows 10](https://cdn.discordapp.com/attachments/1007174346265067553/1037156110324486194/especsPcDemian.png)

**Tabla de tiempos de ejecución de los algoritmos:**

| Hilos | TAS | TTAS | BackOff | CLH | MCS |
| :---         |     :---:      |     :---:      |     :---:      |     :---:     |          ---: |
| 2   | 0.0034447     | 0.0041384     |  0.1028013    |  0.0098006   |  0.0078988 |
| 3   | 0.0117994     | 0.0081241    | 0.058873     | 0.3975983    |  0.0097082 |
| 7     | 0.0081909        | 0.0058605      | 0.0434048       | 0.1111039     | 0.3149743       |
| 15     | 0.0118583      | 0.0109158       | 0.0242223      | 0.0951732      | 0.0796919      |
| 21     | 0.0331402    | 0.0608656       |0.045167       | 0.2100421      | 0.1342033      |
| 30     | 0.0135727      | 0.0798678      |0.024749       | 0.2737452       | 0.2574049     |
| 50     | 0.0577881       | 0.0477697     | 0.096521      | 0.7463273      | 0.6289357      |

---
⌨️ con ❤️ por  [VictorDeGallegos](https://github.com/VictorDeGallegos), [demian35](https://github.com/demian35), [ernt](https://github.com/ernt), [CarlosCruzRangel](https://github.com/CarlosCruzRangel) y [JuanBautistta](https://github.com/JuanBautistta)