[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/uNyxjjsc)
# Taller 5 - Estructuras estáticas/dinámicas _(arreglos de objetos)_

## Diseño orientado a objetos _(DOO)_ aplicando estructuras de datos estáticas/dinámicas 

* Leer detenidamente cada problemática propuesta.
* Usar el programa **DIA-UML** _(Open source)_ para generar la representación de su solución _(modelado)_, vía diagramas de clases.
* Para cada diagrama/solución _(modelado de su solución)_, genere/agregue 2 archivos _(fuente e img: \*.dia y \*.png \*.jpeg, etc)_. No olvide titular a cada clase, con el nombre representativo del análisis/solución. Para el nombre de cada archivo use el formato: _Problema-NroProbl_NombClase_. Ejemplo **Problema-1_Trabajador**. Todos estos archivos agréguelos en el subDirectorio: **Modelos_UML**
* En el subDirectorio **Solucion_Codigo** cree un único proyecto NetBeans - _Java Aplication_ (o con el IDE de su preferencia) y en él, agregue todas las clases necesarias para la solución de cada problema _(no use paquetes aun)_. Y para facilitar la revisión, utilice para la clase base el formato _**Problema-NroProbl_NombClaseBase**_, y para la clase de prueba/ejecutor use _**Problema-NroProbl_NombClaseEjecutor**_ _(Ésta última es la clase de prueba que genera/instancia con objetos cada entidad/clase y verifica su funcionalidad)_. 
* Respete la arquitectura **MVC**, es decir, no implemente entradas/salidas desde/hacia teclado-consola directamente en la clase base. Los datos de entrada y resultados deben ser ingresados/mostrados desde/hacia teclado-consola, en la clase de prueba/ejecutor.
* Para retornar los datos del objeto, usar el método _**toString()**_, vía cadena con formato legible. 
* Al diseñar su solución, usted tiene la potestad de elegir usar estructuras de datos estáticas y/o dinámicas; sin embargo, se recomienda usar en al menos 2 problema, las estructuras de datos estáticas, con el fin de reconocer las diferencias/ventajas de las estructuras dinámicas, las cuales son obligatorias implementar para este taller en el _(los)_ problemas deseados. 
___

## Problema 1 - Sistema de ventas

Desarrolla un programa para gestionar el sistema de ventas de una tienda. El programa debe tener dos clases principales: "Producto" y "CarritoDeCompras".

La clase "Producto" debe tener los siguientes atributos:

- Nombre: el nombre del producto.
- Precio: el precio del producto.
- Cantidad: la cantidad disponible del producto.

La clase "CarritoDeCompras" debe tener el siguiente atributo:

- Producto: un "Producto" que representa el producto a la compra por el cliente.

La clase "CarritoDeCompras" debe tener los siguientes métodos:

- _**AgregarProducto**_: recibe como parámetros el nombre y la cantidad de un producto, verifica si hay suficiente cantidad disponible y si el producto existe en la tienda. Si se cumplen las condiciones, crea un objeto de la clase "Producto" con esa información.
- _**CalcularTotal**_: calcula el total de la compra con el precio en el carrito de compras y la cantidad, al final devuelva el resultado.
- _**RealizarPago**_: recibe como parámetro el monto pagado por el cliente y verifica si es suficiente para cubrir el total de la compra. Si es suficiente, devuelva un mensaje de agradecimiento y actualiza la cantidad disponible de cada producto en la tienda. Si no es suficiente, muestra un mensaje indicando la cantidad faltante. Adicional si el pago supera un monto promocional de $1000, aplique un descuesto al monto total, el cual es definido por el dueño de la tienda.
- _**MostrarDetalleCompra**_: muestra en pantalla los productos seleccionados por el cliente y su cantidad.

El programa debe utilizar sentencias de control selectivas if - else para realizar las verificaciones necesarias en cada método, como verificar si hay suficiente cantidad disponible de un producto antes de agregarlo al carrito, o verificar si el monto pagado es suficiente para cubrir el total de la compra.

> [!Note]
> - Cree una clase de prueba/ejecutor _(quien contiene el método **main()**)_, quien prueba la funcionalidad de este escenario. 

## Problema 2 - Sistema de calificaciones de Estudiantes

Desarrolla un programa para gestionar las calificaciones de los estudiantes en una materia. El programa debe tener dos clases principales: "Estudiante" y "Materia".

Del Estudiante se registra su: nombre, edad y la materia a cruzar. 

Esta clase debe verificar la aprobación dadas tres calificaciones de una materia: ACD (3.5/10), APE (3.5/10) y AA (3/10). Se aprueba si la sumatoria es de al menos 70%, si cumple con este requisito, se considera que ha aprobado, caso contrario informar al estudiante que deberá rendir un examen de recuperación sobre 3.5/10 pts. agregado al 60% acumulado de los componentes ACD, APE y AA.

Ahora, debe implementar los siguientes requisitos en su programa:
1. El programa debe permitir al usuario ingresar los datos de un estudiante, incluyendo su nombre y edad.
2. El programa debe permitir al usuario ingresar los datos de una materia, incluyendo su nombre y las calificaciones del estudiante en las categorías ACD, APE y AA.
3. El programa debe permitir al usuario vincular una materia a un estudiante, es decir, agregar la materia al estudiante.
4. El programa debe verificar si un estudiante ha aprobado una materia específica. Para ello, se deben evaluar las calificaciones del estudiante en las tres categorías (ACD, APE y AA). 

> [!Note]
> - Cree una clase de prueba/ejecutor _(quien contiene el método **main()**)_, quien prueba la funcionalidad de este escenario. 

## Problema 3: Sistema para categorización de Departamentos en una Empresa

Una empresa desea categorizar sus tres departamentos en base al número de empleados y la producción generada por cada departamento. Se debe crear dos clases: "Empresa" y "Departamento".

La clase "Empresa" que tiene un nombre, ruc y dirección asignada, se encargará del departamento, mientras que la clase "Departamento" representará a cada departamento individualmente con el nombre, número de empleados, producción anual, y su categoría merecida, para este último se deben cumplir los siguientes lineamientos: 

| CATEGORIA     | NÚMERO DE EMPLEADOS | PRODUCCIÓN ANUAL |
| ------------- | ------------------- | ---------------- |
| C             | 10                  | 500.000          |
| B             | 20                  | 1.000.000        |
| A             | >20                 | >1.000.000       |

> [!Note]
> - Puede agregar otros métodos o atributos según sea necesario. Su tarea es implementar las clases "Empresa" y "Departamento" en un programa que permita ingresar los datos de varios departamentos y determine su categoría (en la clase Departamento). El programa debe mostrar el resultado para cada departamento ingresado (toString).

## Problema 4:  App de la Fiscalia

Desde la fiscalía general del Estado le contactan para diseña su App de gestión de información sobre casos de corrupción en el sistema judicial de Ecuador y las personas implicadas en estos casos, dados los siguientes lineamientos:

- Los casos de corrupción deben incluir registrar información relevante sobre el caso, como el nombre del caso, la fecha de inicio, el estado del caso, y cualquier detalle adicional necesario. Además, debe poderse agregar personas implicadas en el caso y consultar información sobre las personas y sus roles en el caso.
- Por otro lado, las personas implicadas en un caso de corrupción tienen un nombre, la edad, la ocupación y el nivel de implicación en el caso (acusado, testigo, víctima, etc.). 
- La fiscalía a decidido establecer fechas para dar atención a los casos de corrupción. Si es que excede los 7 días su estado de “Iniciado” pasa a “Alerta”, y si pasa las 2 semana, su estado debe ser “Urgente”. 
- De igual manera, para las personas que tengan un nivel de implicación de acusado, pueden acogerse a reducción de pena si es que deciden colaborar confesando la verdad.
- Para los acusados que tengan una sentencia menor a 1 año, podrán acogerse a pagar fianza si es que colaboran con información útil para resolver el caso. En dicho caso la fianza no podrá superar al 50% del total de daño económico causado al estado. 

Relacione las posibles clases con la asociación correcta, dado que un caso de corrupción puede tener múltiples personas implicadas. Este diseño permite gestionar de manera eficiente la información sobre los casos de corrupción y las personas involucradas en el sistema judicial de Ecuador. 

## Problema 5: Sistema de gestión de conflitos

La ONU _(Organización de Naciones Unidad)_ se contacta con usted para que desarrollo una App que les permita registrar y gestionar toda la información histórica y actual relacionada con los conflictos internacionales suscitados en el mundo contemporáneo dados los siguientes requerimientos: 

- Un conflicto involucra a dos o más países, éste tiene un nombre, países involucrados, fecha de inicio, estado actual, y cualquier otro detalle adicional necesario. La App debe agregar eventos importantes relacionados con el conflicto y consultar información sobre estos eventos.
- Un evento específico dentro de un conflicto internacional puede ser una batalla, un tratado de paz, una reunión diplomática, etc. Su información relevante es: nombre del evento, fecha en que ocurrió, ubicación y una descripción del evento, etc. Se debe tener actualizar la información del evento y consultar detalles relevantes sobre el mismo.
- En el caso de existir eventos de batalla en más del 50% de países del mundo, declarar el estado actual del conflicto en Guerra mundial, si esta batalla ocurre entre el 50% al 30% de países del planeta, convocar a la ONU a reunión urgente. 
- En el caso de existir eventos de batalla en los países desarrollados de primer mundo, declarar de igual forma como Guerra mundial, solo si se usan armas nucleares. 
- Para el caso de los eventos que causen el 50% o mas de bajas en alguno de los países involucrados, de igual forma se debe convocar a la ONU con carácter de urgente. 

Relacione las posibles clases modeladas con la asociación correcta. No olvide que un conflicto internacional puede tener múltiples eventos asociados, y un evento puede estar relacionado con un único conflicto internacional. Este diseño permite gestionar de manera eficiente la información sobre los conflictos internacionales y los eventos relacionados en el mundo actual.
