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
public class ExtendScanText {
  
  public ExtendScanText() {
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
    System.out.println("EXTEND");
    Transaction tx = new Transaction();
    Schema sch = SimpleDB.mdMgr().getTableInfo("student", tx).schema();
    Plan studentTblPlan = new TablePlan("student", tx);
    tx.commit();

    Plan extendPlan = new ExtendPlan(studentTblPlan, "gradclass", 0, 4);
    Scan extendScan = extendPlan.open();
    assertEquals(true, extendScan.hasField("gradclass"));
  }

}
