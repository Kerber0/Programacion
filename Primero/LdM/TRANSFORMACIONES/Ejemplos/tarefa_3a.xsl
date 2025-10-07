<?xml version="1.0" encoding="UTF-8"?> <!-- Declaración XML que indica la versión y la codificación del documento -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> <!-- Declaración del espacio de nombres XSLT -->
<xsl:output encoding="UTF-8" method="xml"/> <!-- Especifica la salida del documento transformado -->
<xsl:template match="equipos">  <!-- Plantilla que se aplica al elemento "equipos" -->
    <xsl:element name="discos"> <!-- Crea un nuevo elemento "discos" -->
    <xsl:apply-templates select="máquina/hardware/disco"/> <!-- Aplica las plantillas a cada elemento "disco" dentro del elemento "hardware" de cada "máquina" -->
    </xsl:element> <!-- Fin del nuevo elemento "discos" -->
</xsl:template> <!-- Fin de la plantilla que se aplica al elemento "equipos" -->
<xsl:template match="disco"> <!-- Plantilla que se aplica a cada elemento "disco" -->
<xsl:element name="disco">  <!-- Crea un nuevo elemento "disco" -->
    <xsl:attribute name="tecnoloxía">   <!-- Atributo "tecnoloxía" que toma su valor del atributo "tecnoloxía" del elemento "disco" -->
        <xsl:value-of select="@tecnoloxía" /> <!-- Valor del atributo "tecnoloxía" -->
    </xsl:attribute> <!-- Fin del atributo "tecnoloxía" -->
    <xsl:attribute name="capacidade"> <!-- Atributo "capacidade" que toma su valor del atributo "capacidade" del elemento "disco" -->
        <xsl:value-of select="@capacidade" /> <!-- Valor del atributo "capacidade" -->
    </xsl:attribute> <!-- Fin del atributo "capacidade" -->
    <xsl:attribute name="máquina">  <!-- Atributo "máquina" que toma su valor del atributo "máquina" del elemento "disco" -->
    <xsl:value-of select="../../@nome" />  <!-- Valor del atributo "máquina" -->
    </xsl:attribute> <!-- Fin del atributo "máquina" -->
</xsl:element> <!-- Fin del nuevo elemento "disco" -->
</xsl:template> <!-- Fin de la plantilla que se aplica a cada elemento "disco" -->
</xsl:stylesheet> <!-- Fin del documento XSLT -->