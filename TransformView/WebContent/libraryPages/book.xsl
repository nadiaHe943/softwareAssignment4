<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="xml" indent="yes"/>
  
<xsl:template match="book"> 
   <xsl:apply-templates/>
</xsl:template>


<xsl:template match="title">
   <P><B>Title: <xsl:apply-templates/></B></P>
</xsl:template>

<xsl:template match="patternList">
   <P><B>Pattern List:</B></P>
   <TABLE><xsl:apply-templates/></TABLE>
</xsl:template>

<xsl:template match="pattern">
   <xsl:variable name="bgcolor">
      <xsl:choose>
         <xsl:when test="(position() mod 2) = 1">lightblue</xsl:when>
	 <xsl:otherwise>red</xsl:otherwise>
      </xsl:choose>
	 </xsl:variable>

      <TR bgcolor="{$bgcolor}"><TD><xsl:apply-templates/></TD></TR>
</xsl:template>


</xsl:stylesheet>