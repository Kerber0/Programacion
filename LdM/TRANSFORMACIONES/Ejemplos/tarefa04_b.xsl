<?xml version="1.0" encoding="UTF-8"?> <!-- Declaración XML que indica la versión y la codificación del documento -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> <!-- Declaración del espacio de nombres XSLT -->
 <xsl:output encoding="UTF-8" indent="yes" method="html"/> <!-- Especifica la salida del documento transformado -->
 <xsl:template match="/"> <!-- plantilla que se aplica al documento XML completo -->
  <html> <!-- etiqueta raíz del documento HTML -->
   <head> <!-- sección de encabezado del documento HTML --> 
    <title>Horario <xsl:value-of select="horario/@grupo" /> <xsl:value-of select="horario/@ciclo" /></title> <!-- título del documento HTML, que incluye el grupo y ciclo del horario -->
   </head> <!-- sección de encabezado del documento HTML -->
   <body> <!-- sección del cuerpo del documento HTML -->
    <h1>Asignaturas por día</h1> <!-- encabezado principal del cuerpo del documento HTML -->
    <ul> <!-- lista desordenada para mostrar los días y materias -->
      <xsl:apply-templates select="horario/dia" /> <!-- aplica las plantillas a cada elemento "dia" dentro del elemento "horario" -->
    </ul> <!-- fin de la lista desordenada -->
   </body> <!-- sección del cuerpo del documento HTML -->
  </html> <!-- fin del documento HTML -->
 </xsl:template> <!-- plantilla que se aplica al documento XML completo -->
 <xsl:template match="dia">   <!-- plantilla que se aplica a cada elemento "dia" -->
   <li>Día <xsl:value-of select="@num" /></li> <!-- muestra el número del día -->
   <ul> <!-- lista desordenada para mostrar las materias del día -->
     <xsl:apply-templates select="materia" /> <!-- aplica las plantillas a cada elemento "materia" dentro del elemento "dia" -->
   </ul> <!-- fin de la lista desordenada -->
</xsl:template> <!-- plantilla que se aplica a cada elemento "dia" -->
 <xsl:template match="materia"> <!-- plantilla que se aplica a cada elemento "materia" -->
   <li><xsl:value-of select="@nome" /></li> <!-- muestra el nombre de la materia -->
 </xsl:template> <!-- plantilla que se aplica a cada elemento "materia" -->
</xsl:stylesheet> <!-- fin del documento XSLT -->

<html>
  <head>
    <title>Horario 1º ASIR Ordinario</title>
  </head>
  <body>
    <h1>Asignaturas por día</h1>
    <ul>
      <li>Día 1</li>
      <ul>
        <li>Planificación e Administración de Redes</li>
        <li>Planificación e Administración de Redes</li>
        <li>Formación e Orientación Laboral</li>
        <li>Linguaxes de Marcas e Sistemas de Xestión da Información</li>
        <li>Linguaxes de Marcas e Sistemas de Xestión da Información</li>
        <li>Implanación de Sistemas Operativos</li>
        <li>Implanación de Sistemas Operativos</li>
      </ul>
      <li>Día 2</li>
      <ul>
        <li>Linguaxes de Marcas e Sistemas de Xestión da Información</li>
        <li>Linguaxes de Marcas e Sistemas de Xestión da Información</li>
        <li>Xestión de Bases de Datos</li>
        <li>Xestión de Bases de Datos</li>
        <li>Xestión de Bases de Datos</li>
        <li>Implanación de Sistemas Operativos</li>
        <li>Implanación de Sistemas Operativos</li>
      </ul>
      <li>Día 3</li>
      <ul>
        <li><!-- Esta materia no tiene atributo "nome", por lo que aparecerá vacío --></li>
        <li>Linguaxes de Marcas e Sistemas de Xestión da Información</li>
        <li>Formación e Orientación Laboral</li>
        <li>Planificación e Administración de Redes</li>
        <li>Planificación e Administración de Redes</li>
        <li>Fundamentos Hardware</li>
        <li>Fundamentos Hardware</li>
        <li>Implanación de Sistemas Operativos</li>
        <li>Implanación de Sistemas Operativos</li>
      </ul>
      <li>Día 4</li>
      <ul>
        <li>Planificación e Administración de Redes</li>
        <li>Planificación e Administración de Redes</li>
        <li>Implanación de Sistemas Operativos</li>
        <li>Implanación de Sistemas Operativos</li>
        <li>Formación e Orientación Laboral</li>
        <li>Xestión de Bases de Datos</li>
        <li>Xestión de Bases de Datos</li>
      </ul>
      <li>Día 5</li>
      <ul>
        <li>Planificación e Administración de Redes</li>
        <li>Planificación e Administración de Redes</li>
        <li>Xestión de Bases de Datos</li>
        <li>Xestión de Bases de Datos</li>
        <li>Fundamentos Hardware</li>
        <li>Fundamentos Hardware</li>
        <li>Formación e Orientación Laboral</li>
      </ul>
    </ul>
  </body>
</html>

<ul> lista desordenada normal 
  <li>Elemento de lista 1</li> <!-- elemento de lista normal -->
  <li>Elemento de lista 2</li> <!-- elemento de lista normal -->
  <li>Elemento de lista 3</li> <!-- elemento de lista normal -->
  </ul> <!-- fin de la lista desordenada normal -->

  <ol> lista ordenada normal
  <li>Elemento de lista 1</li> <!-- elemento de lista ordenada -->
  <li>Elemento de lista 2</li> <!-- elemento de lista ordenada -->
  <li>Elemento de lista 3</li> <!-- elemento de lista ordenada -->
  </ol> <!-- fin de la lista ordenada normal -->  Esto hace una lista desordenada normal, con 1, 2 y 3 como elementos de lista.