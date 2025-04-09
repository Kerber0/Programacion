<?xml version="1.0" encoding="UTF-8"?> <!-- Declaración XML que indica la versión y la codificación del documento -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> <!-- Declaración del espacio de nombres XSLT -->
 <xsl:output encoding="UTF-8" indent="yes" method="html"/> <!-- Especifica la salida del documento transformado -->
 <xsl:template match="/"> <!-- plantilla que se aplica al documento XML completo -->
  <html> <!-- etiqueta raíz del documento HTML -->
   <head> <!-- sección de encabezado del documento HTML -->
    <title>Horario <xsl:value-of select="horario/@grupo" /> <xsl:value-of select="horario/@ciclo" /></title> <!-- título del documento HTML, que incluye el grupo y ciclo del horario -->
   </head> <!-- sección de encabezado del documento HTML -->
   <body>   <!-- sección del cuerpo del documento HTML -->
    <h1>Horario <xsl:value-of select="horario/@grupo" /> <xsl:value-of select="horario/@ciclo" />, ano <xsl:value-of select="horario/@ano" /></h1> <!-- encabezado principal del cuerpo del documento HTML -->
    <table border="1"> <!-- tabla con borde de 1 píxel -->
      <tr> <!-- fila, en este caso la primera fila con 3 columnas -->
        <th></th> <!-- columna vacía para el encabezado de la hora -->
        <th>Inicio</th> <!-- columna para el inicio de la hora -->
        <th>Fin</th> <!-- columna para el fin de la hora -->
      </tr> <!-- fila de encabezado con títulos de columnas -->
      <xsl:apply-templates select="horario/horas/hora" /> <!-- aplica las plantillas a cada elemento "hora" dentro del elemento "horas" de "horario" -->
    </table>        <!-- fin de la tabla -->        
   </body> <!-- sección del cuerpo del documento HTML -->
  </html> <!-- fin del documento HTML -->
 </xsl:template> <!-- plantilla que se aplica al documento XML completo --> 
 <xsl:template match="hora"> <!-- plantilla que se aplica a cada elemento "hora" -->
  <tr> <!-- fila de la tabla para cada hora -->
    <th><xsl:value-of select="@id" /> Hora</th> <!-- celda de encabezado con el id de la hora -->
    <td><xsl:value-of select="inicio" /></td> <!-- celda con el inicio de la hora -->
    <td><xsl:value-of select="fin" /></td> <!-- celda con el fin de la hora -->
  </tr> <!-- fin de la fila de la tabla -->
 </xsl:template>  <!-- plantilla que se aplica a cada elemento "hora" -->
</xsl:stylesheet> <!-- fin del documento XSLT -->

Horario 1º ASIR Ordinario, ano 2013

        Inicio Fin
1 Hora	08:45	09:35
2 Hora	09:35	10:25
3 Hora	10:25	11:15
4 Hora	11:15	12:05
5 Hora	12:05	12:55
6 Hora	12:55	13:45
7 Hora	13:45	14:35
8 Hora	16:20	17:10
9 Hora	17:10	18:00
<!-- Fin del documento HTML -->

A continuación, se explica el propósito de cada etiqueta de tabla (table) utilizada en HTML:

<table>

Función: Define la tabla en sí, actuando como contenedor de todos los elementos relacionados con la tabla (filas, encabezados, celdas, etc.).

<tr> (Table Row)

Función: Define una fila dentro de la tabla.

Uso: Cada <tr> contiene una o más celdas, que pueden ser <th> (encabezado) o <td> (dato).

<th> (Table Header)

Función: Define una celda de encabezado en una tabla.

Características:

El contenido se muestra generalmente en negrita y centrado.

Se usa para describir o identificar el contenido de las columnas o filas.

<td> (Table Data)

Función: Define una celda de datos en una fila de la tabla.

Uso: Contiene la información o los valores correspondientes a cada celda.

<thead>, <tbody> y <tfoot> (Opcionales)

Función:

<thead> agrupa las filas que contienen los encabezados de la tabla.

<tbody> agrupa las filas del cuerpo de la tabla, es decir, las filas que contienen los datos.

<tfoot> agrupa las filas que se usan para los pies de página de la tabla (como totales o resúmenes).

Beneficios:

Mejoran la semántica del documento.

Facilitan la aplicación de estilos y la manipulación de la tabla mediante CSS o scripts.

<caption>

Función: Proporciona un título o descripción para la tabla.

Ubicación: Debe estar justo después de la etiqueta <table>.

Ejemplo de Tabla HTML
html
Copy
<table border="1">
  <caption>Horario de Clases</caption>
  <thead>
    <tr>
      <th>Hora</th>
      <th>Inicio</th>
      <th>Fin</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>08:45</td>
      <td>09:35</td>
    </tr>
    <tr>
      <td>2</td>
      <td>09:35</td>
      <td>10:25</td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <td colspan="3">Fin del Horario</td>
    </tr>
  </tfoot>
</table>
Resumen de Propósitos:

<table>: Contenedor global de la tabla.

<tr>: Cada fila de la tabla.

<th>: Celda de encabezado, para títulos o descripciones de columnas/filas.

<td>: Celda de datos, para el contenido principal.

<thead>, <tbody>, <tfoot>: Secciones opcionales que ayudan a estructurar y estilizar la tabla.

<caption>: Título o descripción de la tabla.

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output encoding="UTF-8" indent="yes" method="html"/>
 <xsl:template match="/">
  <html>
   <head>
    <title>Horario <xsl:value-of select="horario/@grupo" /> <xsl:value-of select="horario/@ciclo" /></title>
   </head>
   <body>
    <h1>Horario <xsl:value-of select="horario/@grupo" /> <xsl:value-of select="horario/@ciclo" />, ano <xsl:value-of select="horario/@ano" /></h1>
    <table border="1">
      <tr> fila, en este caso la primera fila con 3 columnas
        <th></th> columnas titulo
        <th>Inicio</th> 
        <th>Fin</th>
      </tr>
      <xsl:apply-templates select="horario/horas/hora" />
    </table>             
   </body>
  </html>
 </xsl:template>
 <xsl:template match="hora">
  <tr>
    <th><xsl:value-of select="@id" /> Hora</th>
    <td><xsl:value-of select="inicio" /></td>
    <td><xsl:value-of select="fin" /></td>
  </tr>
 </xsl:template>
</xsl:stylesheet>

Concepto Básico
Sintaxis:
Se escribe después de una ruta, por ejemplo:

xpath
Copy
/recetas/receta[1]
Este predicado [1] selecciona el primer nodo <receta> que se encuentre.

Propósito:
Los predicados filtran la lista de nodos seleccionados para devolver solo aquellos que cumplen una condición específica. La condición puede ser:

Un número (para seleccionar por posición).

Una comparación (por ejemplo, basándose en el valor de un atributo o nodo).

Una expresión lógica compleja.

Ejemplos y Explicaciones
Selección por posición:

xpath
Copy
/recetas/receta[1]
Significado:
Selecciona el primer nodo <receta> dentro de <recetas>.

Uso:
Cuando deseas trabajar solo con el primer elemento de un conjunto.

Filtrar por un atributo específico:

xpath
Copy
/recetas/productos/producto[@idProducto = 'CB']
Significado:
Selecciona aquellos nodos <producto> que tengan un atributo idProducto con valor 'CB'.

Uso:
Permite obtener solo el producto que tiene el identificador "CB", descartando el resto.

Filtrar por el contenido de un nodo:

xpath
Copy
/recetas/receta[nombreR = 'Sopa de cebolla']
Significado:
Selecciona el nodo <receta> cuyo hijo <nombreR> tenga exactamente el texto "Sopa de cebolla".

Uso:
Es útil para buscar un elemento por su contenido textual.

Predicados con condiciones complejas:

xpath
Copy
//ingrediente[cantidad > 50]
Significado:
Selecciona todos los nodos <ingrediente> cuyo nodo hijo <cantidad> contenga un valor mayor a 50.

Uso:
Puedes combinar condiciones para obtener solo aquellos ingredientes en los que la cantidad sea mayor que un cierto umbral.

Uso de varias condiciones:

xpath
Copy
/recetas/receta[comensales=4 and nombreR='Sopa de cebolla']
Significado:
Selecciona el nodo <receta> que tenga el valor "4" en <comensales> y además el nombre "Sopa de cebolla" en <nombreR>.

Uso:
Esto permite aplicar más de una condición simultáneamente para refinar aún más la selección.

¿Cómo funcionan internamente?
Evaluación del predicado:
Cuando XPath evalúa una ruta seguida de un predicado, primero encuentra todos los nodos que coinciden con la ruta sin el predicado. Luego, para cada nodo, evalúa la condición dentro de los corchetes.

Retorno de la lista filtrada:
Solo se devuelven aquellos nodos para los cuales la condición es verdadera. Si el predicado es numérico, se selecciona el nodo que está en esa posición (contando desde 1).

Resumen
Predicado:
Es la parte entre corchetes que permite filtrar nodos.

Ejemplo simple:
/recetas/receta[1] selecciona el primer <receta>.

Ejemplo con atributo:
/recetas/productos/producto[@idProducto='CB'] selecciona el <producto> con idProducto igual a "CB".

Ejemplo con condiciones:
Puedes combinar condiciones lógicas como and o or para filtrar de manera más precisa.

¿Qué hace <xsl:for-each>?
Iteración sobre nodos:
Permite recorrer todos los nodos que coinciden con la expresión XPath que le especifiques. Durante la iteración, el contexto se actualiza a cada nodo individualmente.

Procesamiento dentro del bucle:
Dentro de <xsl:for-each>, puedes incluir cualquier código XSLT (como <xsl:value-of>, <xsl:element>, etc.) para transformar o extraer datos del nodo actual.

Ordenación (opcional):
Puedes incluir un <xsl:sort> dentro de <xsl:for-each> para ordenar los nodos antes de iterar sobre ellos.

Ejemplo Básico
Imagina que tienes el siguiente fragmento de XML:

xml
Copy
<ingredientes>
  <ingrediente codigo="CB">
    <cantidad medida="kg">1</cantidad>
  </ingrediente>
  <ingrediente codigo="CC">
    <cantidad medida="l">2</cantidad>
  </ingrediente>
</ingredientes>
Para recorrer cada <ingrediente> y mostrar su código, cantidad y medida, podrías usar:

xml
Copy
<xsl:for-each select="ingredientes/ingrediente">
  <p>
    Código: <xsl:value-of select="@codigo"/> - 
    Cantidad: <xsl:value-of select="cantidad"/> 
    (<xsl:value-of select="cantidad/@medida"/>)
  </p>
</xsl:for-each>
¿Cómo Funciona?
Selección de nodos:
La expresión select="ingredientes/ingrediente" busca todos los nodos <ingrediente> que sean hijos del nodo <ingredientes> en el contexto actual.

Iteración y Contexto:
Por cada nodo <ingrediente> encontrado, el contenido dentro del <xsl:for-each> se ejecuta. Durante cada iteración, el nodo actual se convierte en el contexto para las expresiones XPath dentro del bucle.

Extracción de datos:

<xsl:value-of select="@codigo"/> obtiene el valor del atributo codigo del nodo actual.

<xsl:value-of select="cantidad"/> obtiene el contenido textual del nodo <cantidad> que es hijo del nodo actual.

<xsl:value-of select="cantidad/@medida"/> extrae el atributo medida del nodo <cantidad>.

Ventajas de Usar <xsl:for-each>
Claridad:
Es una forma directa y sencilla de procesar cada nodo de un conjunto.

Flexibilidad:
Puedes combinarlo con otras instrucciones XSLT y expresiones XPath para transformar y dar formato a los datos.

Ordenación:
Con <xsl:sort>, puedes ordenar los nodos según criterios específicos antes de procesarlos.

Ejemplo con Ordenación
Si deseas que los ingredientes se muestren ordenados por el valor numérico de <cantidad>, puedes hacer:

xml
Copy
<xsl:for-each select="ingredientes/ingrediente">
  <xsl:sort select="cantidad" data-type="number" order="ascending"/>
  <p>
    Código: <xsl:value-of select="@codigo"/> - 
    Cantidad: <xsl:value-of select="cantidad"/> 
    (<xsl:value-of select="cantidad/@medida"/>)
  </p>
</xsl:for-each>
En este ejemplo, <xsl:sort> ordena los ingredientes de menor a mayor cantidad antes de que se procese cada uno.

En resumen, <xsl:for-each> es una herramienta fundamental en XSLT para recorrer colecciones de nodos y aplicar transformaciones o extracciones de datos de manera iterativa, facilitando la generación dinámica de contenido basado en el XML de entrada.