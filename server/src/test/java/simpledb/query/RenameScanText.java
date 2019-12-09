package simpledb.query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import simpledb.metadata.StatInfo;
import simpledb.record.Schema;
import simpledb.record.TableInfo;
import simpledb.server.SimpleDB;
import simpledb.tx.Transaction;

/**
 *
 * @author yasiro01
 */
public class RenameScanText {
  
  public RenameScanText() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    SimpleDB.init("studentdb");
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  @Test
  public void testDBCreation() {
    System.out.println("RENAME");
    Transaction tx = new Transaction();
    Plan studentTblPlan = new TablePlan("student", tx);
    tx.commit();

    Plan renamePlan = new RenamePlan(studentTblPlan, "gradyear", "gradDate");
    Scan renameScan = renamePlan.open();
    //System.out.println(renamePlan.schema().fields());
    assertEquals(true, renameScan.hasField("gradDate"));
    assertEquals(false, renameScan.hasField("gradyear"));
  }

}
