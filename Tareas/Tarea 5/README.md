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

*Para poder ejecutar las aplicaciones es necesario tener instalado alguna version de java como java 8  ,java 11 o posterior.*

Probado en windows 10

```cmd powershell
java -version
java version "17.0.4.1" 2022-08-18 LTS
Java(TM) SE Runtime Environment (build 17.0.4.1+1-LTS-2)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.4.1+1-LTS-2, mixed mode, sharing)
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

| ![Algoritmos en ejecucion](https://cdn.discordapp.com/attachments/1007174346265067553/1038007497245589554/terminal.png)|
|:--------------------------:|
|**Tiempo de ejecucion de los Algoritmos con 3 hilos**|

## Pruebas de rendimiento

### HP EliteBook 8460p 💻

![System info](https://cdn.discordapp.com/attachments/1007174346265067553/1038187242532909106/neofetch.png)

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

### Dell Latitude E7240 💻

![System info](https://user-images.githubusercontent.com/79823316/199967044-9014d00a-d458-40c3-8ba7-89e7b03a607b.png)

**Tabla de tiempos de ejecución de los algoritmos:**


| Hilos |  TAS   | TTAS   | BackOff | CLH    | MCS    |
| :---: | :---:  | :---:  |  :---:  | :---:  | :---:  |
| 2     | 0.0028 | 0.0017 | 0.0067  | 0.0049 | 0.0068 |
| 3     | 0.0033 | 0.0022 | 0.0069  | 0.0088 | 0.0052 |
| 7     | 0.0056 | 0.0047 | 0.0136  | 0.0298 | 0.0282 |
| 15    | 0.0101 | 0.0103 | 0.0218  | 0.0943 | 0.0927 |
| 21    | 0.0186 | 0.0755 | 0.0249  | 0.1659 | 0.1518 |
| 30    | 0.0200 | 0.0199 | 0.0220  | 0.3459 | 0.2983 |
| 50    | 0.0573 | 0.2103 | 0.1330  | 0.9320 | 0.9437 |
---
### LENOVO Legion 5 💻

![info](https://cdn.discordapp.com/attachments/1007174346265067553/1038152509488893952/neofecht.png)

**Tabla de tiempos de ejecución de los algoritmos:**


| Hilos |  TAS   | TTAS   | BackOff | CLH    | MCS    |
| :---: | :---:  | :---:  |  :---:  | :---:  | :---:  |
| 2     | 0.0020 | 0.0010 | 0.0038  | 0.0040 | 0.0035 |
| 3     | 0.0028 | 0.0015 | 0.0054  | 0.0041 | 0.0038 |
| 7     | 0.0042 | 0.0037 | 0.0102  | 0.0154 | 0.0131 |
| 15    | 0.0086 | 0.0057 | 0.0147  | 0.0413 | 0.0403 |
| 21    | 0.0079 | 0.0061 | 0.0230  | 0.0698 | 0.0717 |
| 30    | 0.0094 | 0.0085 | 0.0339  | 0.1284 | 0.1242 |
| 50    | 0.0123 | 0.0132 | 0.0862  | 0.3761 | 0.3339 |
---
⌨️ con ❤️ por  [VictorDeGallegos](https://github.com/VictorDeGallegos), [demian35](https://github.com/demian35), [ernt](https://github.com/ernt), [CarlosCruzRangel](https://github.com/CarlosCruzRangel) y [JuanBautistta](https://github.com/JuanBautistta)