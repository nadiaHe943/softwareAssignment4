<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="xml" indent="yes"/>
  
<xsl:template match="book"> 
   <logicalPage><xsl:apply-templates/></logicalPage>
</xsl:template>


<xsl:template match="title">
   <titleSection>Title: <xsl:apply-templates/></titleSection>
</xsl:template>

<xsl:template match="author">
   <itemSection>Author: <xsl:apply-templates/></itemSection>
</xsl:template>

<xsl:template match="patternList">
   <titleList>Pattern List:</titleList>
   <list><xsl:apply-templates/></list>
</xsl:template>

<xsl:template match="pattern">
      <item><xsl:apply-templates/></item>
</xsl:template>

<xsl:template match="name">
	<itemAttribute1><xsl:apply-templates/></itemAttribute1>
</xsl:template>

<xsl:template match="description">
	<itemAttribute2><xsl:apply-templates/></itemAttribute2>
</xsl:template>

</xsl:stylesheet>