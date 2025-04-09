<?xml version="1.0" encoding="UTF-8"?> <!-- Declaración XML que indica la versión y la codificación del documento -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> <!-- Declaración del espacio de nombres XSLT -->
    <xsl:output encoding="UTF-8" indent="yes" method="xml"/> <!-- Especifica la salida del documento transformado -->
    <xsl:attribute-set name="atr_materia"> <!-- Define un conjunto de atributos para el elemento "materia" -->
       <xsl:attribute name="hora"><xsl:value-of select="@hora" /></xsl:attribute> <!-- Atributo "hora" que toma su valor del atributo "hora" del elemento "materia" -->
       <xsl:attribute name="nome"><xsl:value-of select="@nome" /></xsl:attribute> <!-- Atributo "nome" que toma su valor del atributo "nome" del elemento "materia" -->
    </xsl:attribute-set> <!-- Fin de la definición del conjunto de atributos -->
    <xsl:template match="/"> <!-- Plantilla que se aplica al documento XML completo -->
       <materias> <!-- Elemento raíz del documento transformado -->
          <xsl:apply-templates select="horario/dia" /> <!-- Aplica las plantillas a cada elemento "dia" dentro del elemento "horario" -->
       </materias>       <!-- Fin del elemento raíz del documento transformado -->
    </xsl:template> <!-- Fin de la plantilla que se aplica al documento XML completo -->
    <xsl:template match="dia"> <!-- Plantilla que se aplica a cada elemento "dia" -->
       <xsl:element name="dia"> <!-- Crea un nuevo elemento "dia" -->
          <xsl:attribute name="num"> <!-- Atributo "num" que toma su valor del atributo "num" del elemento "dia" -->
             <xsl:value-of select="@num" /> <!-- Valor del atributo "num" -->
          </xsl:attribute> <!-- Fin del atributo "num" -->
          <xsl:apply-templates select="materia" /> <!-- Aplica las plantillas a cada elemento "materia" dentro del elemento "dia" -->
       </xsl:element> <!-- Fin del nuevo elemento "dia" --> 
    </xsl:template> <!-- Fin de la plantilla que se aplica a cada elemento "dia" -->
    <xsl:template match="materia"> <!-- Plantilla que se aplica a cada elemento "materia" -->
       <xsl:element name="materia" use-attribute-sets="atr_materia"> <!-- Crea un nuevo elemento "materia" y aplica el conjunto de atributos definido anteriormente -->
          <xsl:apply-templates select="*" /> <!-- Aplica las plantillas a todos los elementos hijos del elemento "materia" -->
       </xsl:element> <!-- Fin del nuevo elemento "materia" -->
    </xsl:template> <!-- Fin de la plantilla que se aplica a cada elemento "materia" -->
</xsl:stylesheet> <!-- Fin del documento XSLT -->

entonces basicamente se crea una template raiz, se crea y se cierra el proximo nodo y dentro se le mete las templates al siguiente nodo, 
luego se abra una template de ese nodo  y se cierra y se meten dentro  se mete las templates al siguiente nodo y asi todo el rato 

Exacto. La idea fundamental en XSLT es construir la transformación de forma modular mediante plantillas (templates) que se aplican a diferentes nodos del XML original. Un flujo típico sería:

Template raíz:

Se define una plantilla para el nodo raíz (por ejemplo, match="/").

En ella se crea la estructura base del documento de salida (por ejemplo, <materias> o <html>, según el método de salida).

Aplicación de plantillas para nodos hijos:

Dentro de la plantilla raíz, se utiliza <xsl:apply-templates> para invocar otras plantillas que transformen nodos hijos específicos (por ejemplo, <horario/dia>).

Template para cada nodo específico:

Para cada tipo de nodo (por ejemplo, <dia>, <materia>, <hora>), se define una plantilla que:

Abre el elemento de salida correspondiente.

Extrae y procesa los datos necesarios del nodo.

Puede, a su vez, utilizar <xsl:apply-templates> para procesar nodos anidados o hijos.

Cada plantilla se encierra y termina cuando ha terminado de transformar el nodo correspondiente.

Encadenamiento de templates:

Así, la transformación se realiza en cascada: la plantilla raíz llama a otras plantillas, que a su vez pueden llamar a más plantillas,
 creando una estructura jerárquica y modular en la salida.

En resumen, sí: se define una plantilla para el nodo raíz, se genera un elemento (o estructura) y, dentro de ese contexto, 
se aplican otras plantillas para procesar los nodos hijos. Cada vez que se abre una plantilla para un nodo específico, se transforma ese nodo y
 se anidan las llamadas a plantillas para sus nodos internos, y así sucesivamente. Este mecanismo permite construir la salida de forma organizada y escalable.

 <?xml version="1.0" encoding="UTF-8"?>
<materias>
  <dia num="1">
    <materia hora="1" nome="Planificación e Administración de Redes"/>
    <materia hora="2" nome="Planificación e Administración de Redes"/>
    <materia hora="3" nome="Formación e Orientación Laboral"/>
    <materia hora="4" nome="Linguaxes de Marcas e Sistemas de Xestión da Información"/>
    <materia hora="5" nome="Linguaxes de Marcas e Sistemas de Xestión da Información"/>
    <materia hora="6" nome="Implanación de Sistemas Operativos"/>
    <materia hora="7" nome="Implanación de Sistemas Operativos"/>
  </dia>
  <dia num="2">
    <materia hora="1" nome="Linguaxes de Marcas e Sistemas de Xestión da Información"/>
    <materia hora="2" nome="Linguaxes de Marcas e Sistemas de Xestión da Información"/>
    <materia hora="3" nome="Xestión de Bases de Datos"/>
    <materia hora="4" nome="Xestión de Bases de Datos"/>
    <materia hora="5" nome="Xestión de Bases de Datos"/>
    <materia hora="6" nome="Implanación de Sistemas Operativos"/>
    <materia hora="7" nome="Implanación de Sistemas Operativos"/>
  </dia>
  <dia num="3">
    <materia hora="1"/>
    <materia hora="2" nome="Linguaxes de Marcas e Sistemas de Xestión da Información"/>
    <materia hora="3" nome="Formación e Orientación Laboral"/>
    <materia hora="4" nome="Planificación e Administración de Redes"/>
    <materia hora="5" nome="Planificación e Administración de Redes"/>
    <materia hora="6" nome="Fundamentos Hardware"/>
    <materia hora="7" nome="Fundamentos Hardware"/>
    <materia hora="8" nome="Implanación de Sistemas Operativos"/>
    <materia hora="9" nome="Implanación de Sistemas Operativos"/>
  </dia>
  <dia num="4">
    <materia hora="1" nome="Planificación e Administración de Redes"/>
    <materia hora="2" nome="Planificación e Administración de Redes"/>
    <materia hora="3" nome="Implanación de Sistemas Operativos"/>
    <materia hora="4" nome="Implanación de Sistemas Operativos"/>
    <materia hora="5" nome="Formación e Orientación Laboral"/>
    <materia hora="6" nome="Xestión de Bases de Datos"/>
    <materia hora="7" nome="Xestión de Bases de Datos"/>
  </dia>
  <dia num="5">
    <materia hora="1" nome="Planificación e Administración de Redes"/>
    <materia hora="2" nome="Planificación e Administración de Redes"/>
    <materia hora="3" nome="Xestión de Bases de Datos"/>
    <materia hora="4" nome="Xestión de Bases de Datos"/>
    <materia hora="5" nome="Fundamentos Hardware"/>
    <materia hora="6" nome="Fundamentos Hardware"/>
    <materia hora="7" nome="Formación e Orientación Laboral"/>
  </dia>
</materias>
