# Cajero Automático con Patrón "Chain of Responsibility"

[cite_start]Este proyecto es una simulación de la lógica de dispensación de dinero de un cajero automático, desarrollado como ejercicio para el examen final de la asignatura **Ingeniería del Software**. El objetivo principal es demostrar la aplicación práctica del patrón de diseño de comportamiento **Chain of Responsibility**.

[cite_start]El sistema procesa una solicitud de retiro de dinero a través de una cadena de manejadores, donde cada manejador es responsable de una denominación de billete específica. 

## Características Principales

* [cite_start]**Simulación de Retiro**: Permite al usuario ingresar un monto para simular una transacción de retiro de efectivo. 
* [cite_start]**Denominaciones Específicas**: El cajero dispensa billetes en denominaciones de $100.000, $50.000, $20.000, $10.000 y $5.000. 
* [cite_start]**Validación de Monto**: El sistema verifica que la cantidad solicitada sea un múltiplo de $5.000; de lo contrario, rechaza la transacción. 
* **Menú Interactivo**: La aplicación se ejecuta en un bucle continuo, permitiendo al usuario realizar múltiples retiros o salir del programa de forma controlada.

## Patrón de Diseño: Chain of Responsibility

[cite_start]La arquitectura de este proyecto se fundamenta en el patrón **Chain of Responsibility** para procesar la solicitud de retiro de forma secuencial y desacoplada. 

* [cite_start]**Handler (Interfaz)**: La interfaz `IDispensador.java` declara el contrato común para todos los manejadores, asegurando que todos puedan establecer un sucesor y manejar una solicitud. 
* [cite_start]**ConcreteHandler (Manejadores Concretos)**: Son las clases `Dispensador100k`, `Dispensador50k`, etc. Cada una contiene la lógica para procesar una parte de la solicitud (dispensar su denominación) y pasar el resto al siguiente manejador en la cadena. 
* **Client (Cliente)**: La clase `CajeroAutomatico.java` actúa como el cliente. [cite_start]Es responsable de construir la cadena de manejadores y de iniciar la solicitud enviándola al primer eslabón de la cadena. 

Este enfoque permite una gran flexibilidad, ya que se podrían añadir nuevas denominaciones (por ejemplo, billetes de $2.000) o cambiar el orden de dispensación con modificaciones mínimas, principalmente en la construcción de la cadena dentro del Cliente.

## Tecnologías Utilizadas

* **Lenguaje**: Java
* **Entorno de Desarrollo**: Visual Studio Code
* **Control de Versiones**: Git y GitHub

## ¿Cómo Ejecutar el Proyecto?

Para ejecutar este proyecto en tu máquina local, sigue estos pasos:

1.  **Clonar el repositorio:**
    ```sh
    git clone [https://github.com/luisJavieralvare/final_sofware.git](https://github.com/luisJavieralvare/final_sofware.git)
    ```
2.  **Abrir en VS Code:**
    Navega a la carpeta del proyecto y ábrela con Visual Studio Code.
3.  **Instalar Extensiones:**
    Asegúrate de tener instalado el paquete de extensiones **"Extension Pack for Java"** de Microsoft para una correcta compilación y ejecución.
4.  **Ejecutar la aplicación:**
    * Abre el archivo `src/CajeroAutomatico.java`.
    * Haz clic en el botón **"Run"** que aparece sobre el método `main`.
    * La aplicación se iniciará en la terminal integrada de VS Code.

## Autor

* **Luis Javier Alvarez**