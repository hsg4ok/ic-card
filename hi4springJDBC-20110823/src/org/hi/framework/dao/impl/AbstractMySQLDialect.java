/*   */ package org.hi.framework.dao.impl;
/*   */ 
/*   */ public abstract class AbstractMySQLDialect extends HiAbstractDialect
/*   */ {
/*   */   protected String getFeildToString(String fieldName, FilterBean filterBean)
/*   */   {
/* 8 */     return fieldName;
/*   */   }
/*   */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.AbstractMySQLDialect
 * JD-Core Version:    0.6.0
 */