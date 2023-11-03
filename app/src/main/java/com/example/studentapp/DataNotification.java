package com.example.studentapp;

public class DataNotification {
   private String visitDone;
   private String date;
   private String description;

   public DataNotification(String visitDone, String date, String description) {
      this.visitDone = visitDone;
      this.date = date;
      this.description = description;
   }

   public String getVisitDone() {
      return visitDone;
   }

   public void setVisitDone(String visitDone) {
      this.visitDone = visitDone;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}
