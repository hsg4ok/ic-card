/*    */ package org.hi.i18n.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ import org.hi.i18n.model.Timezone;
/*    */ import org.hi.i18n.service.TimezoneManager;
/*    */ 
/*    */ public class TimezoneRemoveAction extends BaseAction
/*    */ {
/*    */   private Timezone timezone;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     TimezoneManager timezoneMgr = (TimezoneManager)SpringContextHolder.getBean(Timezone.class);
/* 14 */     timezoneMgr.removeTimezoneById(this.timezone.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Timezone getTimezone() {
/* 19 */     return this.timezone;
/*    */   }
/*    */ 
/*    */   public void setTimezone(Timezone timezone) {
/* 23 */     this.timezone = timezone;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.action.webwork.TimezoneRemoveAction
 * JD-Core Version:    0.6.0
 */