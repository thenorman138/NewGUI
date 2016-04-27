/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgui;

import javafx.stage.Stage;
import junit.framework.TestCase;

/**
 *
 * @author Hunter
 */
public class NewGUITest extends TestCase {
    
    public NewGUITest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of main method, of class NewGUI.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        NewGUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class NewGUI.
     */
    public void testStart() throws Exception {
        System.out.println("start");
        Stage stage = null;
        NewGUI instance = new NewGUI();
        instance.start(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
