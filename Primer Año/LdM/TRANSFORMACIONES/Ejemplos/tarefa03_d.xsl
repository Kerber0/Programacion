<?xml version="1.0" encoding="UTF-8"?> <!-- Declaración XML que indica la versión y la codificación del documento -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> <!-- Declaración del espacio de nombres XSLT -->
	<xsl:output encoding="UTF-8" indent="yes" method="xml"/> <!-- Especifica la salida del documento transformado -->
	<xsl:attribute-set name="atr_máquina"> <!-- Conjunto de atributos para el elemento "máquina" -->
  <xsl:attribute name="tipo"> <!-- Atributo "tipo" que toma su valor del elemento "tipo" dentro de "hardware" -->
	  <xsl:value-of select="hardware/tipo"/> <!-- Valor del atributo "tipo" -->
	 </xsl:attribute> <!-- Fin del atributo "tipo" -->
	 <xsl:attribute name="fabricante"> <!-- Atributo "fabricante" que toma su valor del elemento "fabricante" dentro de "hardware" -->
	  <xsl:value-of select="hardware/fabricante"/> <!-- Valor del atributo "fabricante" -->
	 </xsl:attribute> <!-- Fin del atributo "fabricante" -->
	 <xsl:attribute name="procesador"> <!-- Atributo "procesador" que toma su valor del elemento "procesador" dentro de "hardware" -->
	  <xsl:value-of select="concat(hardware/procesador/@marca, ' ', hardware/procesador/@num_nucleos, ' núcleos a ', hardware/procesador/@velocidade, ' GHz')" /> <!-- Valor del atributo "procesador" -->
	 </xsl:attribute> <!-- Fin del atributo "procesador" -->
	 <xsl:attribute name="discos"> <!-- Atributo "discos" que toma su valor del elemento "disco" dentro de "hardware" -->
	  <xsl:value-of select="concat(count(hardware/disco), ' con ', sum(hardware/disco/@capacidade), 'GB') "/> <!-- Valor del atributo "discos" -->
	 </xsl:attribute> 	<!-- Fin del atributo "discos" -->
	</xsl:attribute-set> <!-- Fin del conjunto de atributos para el elemento "máquina" -->
	<xsl:template match="equipos"> <!-- Plantilla que se aplica al elemento "equipos" -->
	 <xsl:element name="máquinas"> <!-- Crea un nuevo elemento "máquinas" -->
	  <xsl:apply-templates select="máquina"/> <!-- Aplica las plantillas a cada elemento "máquina" dentro del elemento "equipos" -->
	 </xsl:element> <!-- Fin del nuevo elemento "máquinas" -->
	</xsl:template> <!-- Fin de la plantilla que se aplica al elemento "equipos" -->
	<xsl:template match="máquina"> 	<!-- Plantilla que se aplica a cada elemento "máquina" -->
	 <xsl:element name="máquina" use-attribute-sets="atr_máquina" /> <!-- Crea un nuevo elemento "máquina" y aplica el conjunto de atributos definido anteriormente -->
	</xsl:template> <!-- Fin de la plantilla que se aplica a cada elemento "máquina" -->
</xsl:stylesheet> <!-- Fin del documento XSLT -->
