# Tarea 5 - Estructuras de Datos Concurrentes

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Status badge](https://img.shields.io/badge/status-en%20progreso-yellow?style=for-the-badge)

## Computacion concurrente, Universidad Nacional Autónoma de México semestre 2023-1

> ---
>
> * **Victor Hugo Gallegos Mota** - *316160456* - [VictorDeGallegos](https://github.com/VictorDeGallegos)
> * **José Demian Jiménez** - *314291707* - [demian35](https://github.com/demian35)
> * **Carlos Cruz Rangel** - *314208682* - [CarlosCruzRangel](https://github.com/CarlosCruzRangel)
> * **Ernesto Muñoz Nieves** - *314133586* - [ernt](https://github.com/ernt)
> * **Juan Carlos Bautista Sandoval** - - [JuanBautistta](https://github.com/JuanBautistta)
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

Probado en Windows 10 Pro
```bash
java 11.0.15 2022-04-19 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.15+8-LTS-149)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.15+8-LTS-149, mixed mode)
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

| ![Algoritmos en ejecucion](https://user-images.githubusercontent.com/41756950/199122946-491d966f-f1cf-4096-8892-d85b9b080b8e.png)|
|:--------------------------:|
|**Tiempo de ejecucion de los Algoritmos con 3 hilos**|

## Pruebas de rendimiento

### Macbook Pro 2021 💻

![Neofetch Macbook](https://user-images.githubusercontent.com/41756950/199126905-2eea306c-b536-4e2a-83c6-8efe29432d3e.png)

**Tabla de tiempos de ejecución de los algoritmos:**

| Hilos | TAS | TTAS | BackOff | CLH | MCS |
| :---         |     :---:      |     :---:      |     :---:      |     :---:     |          ---: |
| 2   | 0.0014     | 0.0013     |  0.0023     |  0.0039    |  0.0038 |
| 3   | 0.0030     | 0.0019     | 0.0033     | 0.0120    |  0.0102 |
| 7     | 0.0065       | 0.0070       | 0.0051       | 0.0559       | 0.0540      |
| 15     | 0.0120      | 0.0658       | 0.0172       | 0.3553       | 0.2998      |
| 21     | 0.0826      | 0.1146       | 1.0111       | 0.3553       | 0.9655      |
| 30     | 0.0251      | 0.0172       | 0.0112       | 1.4604       | 1.3807      |
| 50     | 0.0443      | 0.0201       | 0.0592       | 3.5877       | 3.6035      |

### Dell Latitude E7240 💻

![System info](https://user-images.githubusercontent.com/79823316/199967044-9014d00a-d458-40c3-8ba7-89e7b03a607b.png)

| Hilos |  TAS   | TTAS   | BackOff | CLH     | MCS     |
| :---: | :---:  | :---:  |  :---:  | :---:   | :---:   |
| 2     | 0.0014 | 0.0013 | 0.0023  | 0.0039  | 0.0038  |
| 3     | 0.0030 | 0.0019 | 0.0033  | 0.0120  | 0.0102  |
| 7     | 0.0065 | 0.0070 | 0.0051  | 0.0559  | 0.0540  |
| 15    | 0.0120 | 0.0658 | 0.0172  | 0.3553  | 0.2998  |
| 21    | 0.0826 | 0.1146 | 1.0111  | 0.3553  | 0.9655  |
| 30    | 0.0251 | 0.0172 | 0.0112  | 1.4604  | 1.3807  |
| 50    | 0.0443 | 0.0201 | 0.0592  | 3.5877  | 3.6035  |
---
⌨️ con ❤️ por  [VictorDeGallegos](https://github.com/VictorDeGallegos), [demian35](https://github.com/demian35), [ernt](https://github.com/ernt), [CarlosCruzRangel](https://github.com/CarlosCruzRangel) y [JuanBautistta](https://github.com/JuanBautistta)