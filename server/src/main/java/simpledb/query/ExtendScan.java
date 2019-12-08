package simpledb.query;

import java.util.*;

/**
 * The scan class corresponding to the <i>project</i> relational
 * algebra operator.
 * All methods except hasField delegate their work to the
 * underlying scan.
 * @author Edward Sciore
 */
public class ExtendScan implements Scan {
   private Scan s;
   private String fields;
   private Integer type, size;   
   /**
    * Creates a project scan having the specified
    * underlying scan and field list.
    * @param s the underlying scan
    * @param fieldlist the list of field names
    */
   public ExtendScan(Scan s, String fields, Integer type, Integer size) {
      this.s = s;
      this.fields = fields;
      this.type = type;
      this.size = size;
      s.next();
   }
   
   public void beforeFirst() {
      s.beforeFirst();
      s.next();
   }
   
   public boolean next() {
        if (s.next())
            return true;
        else {
            return false;
        }
      }
   
   public void close() {
      s.close();
   }
   
   public Constant getVal(String fldname) {
      if (hasField(fldname))
         return s.getVal(fldname);
      else
         throw new RuntimeException("field " + fldname + " not found.");
   }
   
   public int getInt(String fldname) {
      if (hasField(fldname))
         return s.getInt(fldname);
      else
         throw new RuntimeException("field " + fldname + " not found.");
   }
   
   public String getString(String fldname) {
      if (hasField(fldname))
         return s.getString(fldname);
      else
         throw new RuntimeException("field " + fldname + " not found.");
   }
   
   /**
    * Returns true if the specified field
    * is in the projection list.
    * @see simpledb.query.Scan#hasField(java.lang.String)
    */
   public boolean hasField(String fldname) {
       return s.hasField(fldname);
      }
}
