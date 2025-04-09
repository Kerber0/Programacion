<?xml version="1.0" encoding="UTF-8"?> <!-- Declaración XML que indica la versión y la codificación del documento -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> <!-- Declaración del espacio de nombres XSLT -->
    <xsl:output encoding="UTF-8" method="html"/> <!-- Especifica la salida del documento transformado -->
    <xsl:template match="/"> <!-- plantilla que se aplica al documento XML completo -->
       <html> <!-- etiqueta raíz del documento HTML -->
          <head> <!-- sección de encabezado del documento HTML -->
             <title>Táboa máquinas</title> <!-- título del documento HTML -->
          </head> <!-- sección de encabezado del documento HTML -->
          <body>  <!-- sección del cuerpo del documento HTML -->
             <h1>Táboa das máquinas</h1> <!-- encabezado principal del cuerpo del documento HTML -->
             <table border="1"> <!-- tabla con borde -->
                <tr> <!-- fila, en este caso la primera fila con 3 columnas -->
                   <th>Máquina</th> <!-- columna para el nombre de la máquina -->
                   <th>Procesador</th> <!-- columna para el procesador -->
                   <th>Memoria</th> <!-- columna para la memoria -->
                </tr> <!-- fila de encabezado con títulos de columnas -->
                 <xsl:apply-templates select="equipos/máquina" /> <!-- aplica las plantillas a cada elemento "máquina" dentro del elemento "equipos" -->
             </table> <!-- fin de la tabla -->
          </body> <!-- sección del cuerpo del documento HTML -->
       </html> <!-- fin del documento HTML -->
    </xsl:template> <!-- plantilla que se aplica al documento XML completo -->
    <xsl:template match="máquina"> <!-- plantilla que se aplica a cada elemento "máquina" -->
       <tr> <!-- fila de la tabla para cada máquina -->
          <td><xsl:value-of select="@nome" /></td> <!-- celda de encabezado con el nombre de la máquina -->
          <td><xsl:value-of select="hardware/procesador/@marca" />-<xsl:value-of select="hardware/procesador/text()" /></td> <!-- celda con el procesador de la máquina, que incluye la marca y el modelo -->
          <td><xsl:value-of select="hardware/memoria" />GB <xsl:value-of select="hardware/memoria/@tecnoloxía" /></td> <!-- celda con la memoria de la máquina, que incluye la cantidad y la tecnología -->
       </tr> <!-- fin de la fila de la tabla -->
    </xsl:template> <!-- plantilla que se aplica a cada elemento "máquina" -->
</xsl:stylesheet> <!-- fin del documento XSLT -->
