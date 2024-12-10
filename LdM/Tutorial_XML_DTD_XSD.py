
# -----------------------------------------------
# TUTORIAL DE XML, DTD Y XML SCHEMA EN PYTHON
# -----------------------------------------------

# Este archivo contiene ejemplos prácticos y explicaciones sobre cómo trabajar con XML.
# Incluye secciones sobre la creación de documentos XML, validación con DTD, y uso de XML Schema (XSD).
# Cada sección está organizada en niveles de dificultad con instrucciones paso a paso.

# -----------------------------------------------
# 1. INTRODUCCIÓN A XML
# -----------------------------------------------

# Un documento XML es una estructura jerárquica que permite almacenar datos de manera organizada.
# Aquí tienes un ejemplo básico de un archivo XML que describe un libro.

# Ejemplo básico de XML:

xml_basico = """
<?xml version="1.0" encoding="UTF-8"?>
<libro>
    <titulo>Introducción a XML</titulo>
    <autor>Nico</autor>
    <fecha_publicacion>2024-12-07</fecha_publicacion>
</libro>
"""

# Explicación:
# - La declaración XML (<?xml version="1.0"?>) indica que se trata de un archivo XML.
# - Los elementos (<libro>, <titulo>, etc.) tienen etiquetas de apertura y cierre.
# - Los datos están organizados dentro de una jerarquía.


# -----------------------------------------------
#            SIMBOLOS UTILIZADOS XML
# -----------------------------------------------


#       Símbolo	                           Significado

#    < y >                      Delimitan el inicio y el fin de una etiqueta en XML.
#    </>	                    Indica el cierre de una etiqueta.
#    =	                        Separa el nombre del atributo de su valor.
#    " o '                      Encierra el valor de un atributo (puede usarse cualquiera de los dos).
#   <? ... ?>	                Define una declaración XML o una instrucción de procesamiento.
#   <!-- ... -->             	Indica un comentario. El contenido dentro no se procesa ni se muestra.
#   &	                        Inicia una entidad, utilizada para caracteres especiales o códigos.
#   /	                        Indica etiquetas autoconcluyentes al final de una etiqueta (e.g., <br />).
#    &lt;	                    Representa el carácter < (less than) en el texto.
#   &gt;	                    Representa el carácter > (greater than) en el texto.
#    &amp;	                    Representa el carácter & (ampersand).
#   &apos;	                    Representa el carácter ' (apostrophe).
#   &quot;	                    Representa el carácter " (quotation mark).


# -----------------------------------------------
# 3. JERARQUÍAS Y ATRIBUTOS
# -----------------------------------------------

# Los elementos XML pueden tener subelementos y atributos para proporcionar más información.

# Ejemplo de jerarquías y atributos:

xml_jerarquia = """
<?xml version="1.0" encoding="UTF-8"?>
<biblioteca>
    <libro genero="ficción">
        <titulo>1984</titulo>
        <autor>George Orwell</autor>
        <año>1949</año>
    </libro>
    <libro genero="ciencia">
        <titulo>Breve historia del tiempo</titulo>
        <autor>Stephen Hawking</autor>
        <año>1988</año>
    </libro>
</biblioteca>
"""

# Explicación:
# - El atributo "genero" proporciona información adicional sobre cada libro.
# - Los elementos están organizados dentro del elemento raíz <biblioteca>.

# -----------------------------------------------
# 3. VALIDACIÓN CON DTD (DIFICULTAD: MEDIA)
# -----------------------------------------------


# Los Document Type Definitions (DTD) se utilizan para validar la estructura de un archivo XML.


# -----------------------------------------------
#            SIMBOLOS UTILIZADOS DTD
# -----------------------------------------------
#
#               Símbolo	                   Significado

#            <!DOCTYPE>	                  Declara el inicio de una definición DTD.
#            <!ELEMENT>	                  Define un elemento y su contenido permitido (p. ej., texto, otros elementos).
#            <!ATTLIST>	                  Define los atributos permitidos para un elemento.
#              >	                      Cierra una definición de DTD, como elementos o atributos.
#              |(barra recta del 1)	      Barra vertical | se utiliza para definir una lista de opciones entre las que puede aparecer uno y solo uno
#              ,	                      Representa secuencia, los elementos deben aparecer en orden específico.
#              *	                      El elemento puede aparecer ninguna o múltiples veces
#              +	                      El elemento debe aparecer al menos una vez y puede repetirse
#              ?	                      El elemento es opcional; puede aparecer una sola vez o no estar presente.
#             ()	                      Agrupa elementos o reglas para establecer combinaciones complejas.
#           #PCDATA	                      Representa datos de texto parseados (text-only content).
#           #CDATA	                      Representa datos de texto no parseados (raw text).
#           #IMPLIED	                  Define que un atributo es opcional.
#           #REQUIRED	                  Define que un atributo es obligatorio.
#           #FIXED	                      Define un valor fijo para un atributo.


# Ejemplo de XML con referencia a DTD:

xml_con_dtd = """
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE biblioteca SYSTEM "biblioteca.dtd">
<biblioteca>
    <libro>
        <titulo>1984</titulo>
        <autor>George Orwell</autor>
    </libro>
</biblioteca>
"""

# Ejemplo del archivo DTD (biblioteca.dtd):

dtd = """
<!ELEMENT biblioteca (libro+)>
<!ELEMENT libro (titulo, autor)>
<!ELEMENT titulo (#PCDATA)>
<!ELEMENT autor (#PCDATA)>
"""

# Explicación:
# - <!ELEMENT biblioteca (libro+)>: La raíz <biblioteca> debe contener uno o más elementos <libro>.
# - <!ELEMENT titulo (#PCDATA)>: El elemento <titulo> debe contener texto (PCDATA).

# -----------------------------------------------
# 4. VALIDACIÓN CON XML SCHEMA (XSD) (DIFICULTAD: ALTA)
# -----------------------------------------------

# XML Schema (XSD) es una forma más potente y flexible de validar XML.
# Permite definir tipos de datos, estructuras y restricciones.


# -----------------------------------------------
#            SIMBOLOS UTILIZADOS SXD
# -----------------------------------------------

#            Símbolo	            Significado

#            <xs:schema>	            Declara el inicio del esquema XSD.
#            <xs:element>	            Define un elemento en el XML.
#            <xs:attribute>	            Define un atributo para un elemento.
#            <xs:complexType>           Define un elemento con hijos y atributos.
#            <xs:simpleType>        	Define un elemento con valores simples (e.g., cadenas, números).
#            <xs:sequence>	            Define que los elementos hijos deben aparecer en un orden específico.
#            <xs:choice>	            Define que solo uno de los elementos hijos puede aparecer (opciones).
#            <xs:all>	                Define que todos los hijos deben aparecer, pero en cualquier orden.
#            <xs:minOccurs>	            Define el número mínimo de ocurrencias de un elemento.
#            <xs:maxOccurs>	            Define el número máximo de ocurrencias de un elemento.
#            <xs:restriction>	        Restringe el contenido de un tipo simple o atributo.
#            <xs:enumeration>	        Define valores permitidos específicos (como una lista predefinida).
#            <xs:pattern>	            Define una expresión regular para validar contenido.
#            <xs:import>	            Importa otro esquema XML.
#            <xs:include>	            Incluye otro esquema XSD en el actual.


# Ejemplo de XML con referencia a XSD:

xml_con_xsd = """
<?xml version="1.0" encoding="UTF-8"?>
<catalogo xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="catalogo.xsd">
    <producto>
        <nombre>Camiseta</nombre>
        <precio>19.99</precio>
        <stock>50</stock>
    </producto>
</catalogo>
"""

# Ejemplo del archivo XSD (catalogo.xsd):

xsd = """
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="catalogo">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="producto" maxOccurs="unbounded">
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name="nombre" type="xs:string"/>
                            <xs:element name="precio" type="xs:decimal"/>
                            <xs:element name="stock" type="xs:int"/>
                        </xs:sequence>
                    </xs:complexType>
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>
"""

# Explicación:
# - <xs:element>: Define un elemento dentro del XML.
# - type="xs:string": Define el tipo de datos para el elemento.
# - maxOccurs="unbounded": Permite múltiples elementos <producto>.

# -----------------------------------------------
# EJERCICIOS:
# 1. Modifica los ejemplos para agregar nuevos elementos y atributos.
# 2. Intenta validar los XML con sus respectivos DTD o XSD.
# 3. Crea un esquema XSD que permita validar un XML para gestionar inventarios.

# ¡Felicidades! Ahora tienes un entendimiento básico y práctico de XML.
