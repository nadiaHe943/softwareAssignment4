<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="xml" indent="yes"/>

<xsl:template match="logicalPage"> 
   <xsl:apply-templates/>
</xsl:template>

<xsl:template match="titleSection"> 
   <P><B>
   <xsl:apply-templates/>
   </B></P>
</xsl:template>
  
<xsl:template match="itemSection"> 
   <P>
   <xsl:apply-templates/>
   </P>
</xsl:template>


<xsl:template match="titleList"> 
   <B>
   <xsl:apply-templates/>
   </B>
</xsl:template>

<xsl:template match="list"> 
	<TABLE><xsl:apply-templates/></TABLE>
</xsl:template>


<xsl:template match="item">
   <TR bgcolor="red"><xsl:apply-templates/></TR>
</xsl:template>

<xsl:template match="node()[starts-with(local-name(),'itemAttribute')]"> 
	<TD><xsl:apply-templates/></TD>
</xsl:template>



</xsl:stylesheet>