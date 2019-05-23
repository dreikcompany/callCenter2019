# callCenter2019
Simulador de Call Center

### Solución al problema

Para dar solución al planteamiento realizado en principio estaba pensando en usar la clase Thread y manejar la cola de prioridad mediante PriorityQueue, investigando un poco encontré la clase PriorityBlockingQueue y la interface ExecutorService, la primera me permite manejar colas de prioridad en concurrencia y la segunda manejar varios Thread.

### Extras/Plus
Para dar solución a los 2 puntos extras, el programa fue pensado de manera tal que ofrezca una serie de alternativas al cliente, tales como: 
-	Esperar por un asesor en vista de que todos se encuentran ocupados.
-	Dejar un numero de contacto para luego ser llamado.
-	Finalizar la llamada si no esta dispuesto a esperar.

Para los test solo tomo en cuenta 2 métodos, uno donde se ejecuta el programa para 10 llamadas dado que la cantidad de empleados es igual a 10 estos atenderán cada uno una llamada.
Para el segundo test enviamos 30 llamadas dado que la cantidad de empleados disponibles es menor a las llamadas, la cola de prioridad estará vacía y es donde se verán las 3 alternativas mencionadas antes.
