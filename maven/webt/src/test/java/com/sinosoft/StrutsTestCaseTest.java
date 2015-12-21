package com.sinosoft;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.Test;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;

public class StrutsTestCaseTest extends StrutsTestCase {
    public void testGetActionMapping() throws UnsupportedEncodingException, ServletException {
    
        ActionMapping mapping = getActionMapping("/test/testAction.action");
        assertNotNull(mapping);
        assertEquals("/test", mapping.getNamespace());
        assertEquals("testAction", mapping.getName());
    }
 
    public void testGetActionProxy() throws Exception {
        //set parameters before calling getActionProxy
        request.setParameter("name", "FD");
         
        ActionProxy proxy = getActionProxy("/test/testAction.action");
        assertNotNull(proxy);
 
        TestAction action = (TestAction) proxy.getAction();
        assertNotNull(action);
        String result = proxy.execute();
        assertEquals(Action.SUCCESS, result);
        assertEquals("FD", action.getName());
    }
 
    public void testExecuteAction() throws ServletException, UnsupportedEncodingException {
        String output = executeAction("/test/testAction.action");
        assertEquals("Hello", output);
    }
 
    public void testGetValueFromStack() throws ServletException, UnsupportedEncodingException {
        request.setParameter("name", "FD");
        executeAction("/test/testAction.action");
        String name = (String) findValueAfterExecute("name");
        assertEquals("FD", name);
    }
    
    @Test 
    public void testExecute() throws Exception { 
        ActionProxy proxy = null; 
        TestAction test = null; 
         
        request.setParameter("name", "test..."); 
        proxy = getActionProxy("/test/testAction.action"); 
        test = (TestAction)proxy.getAction(); 
        
        String result = proxy.execute(); 
         
        assertEquals("success", result); 
        assertEquals("test...", test.getName()); 
 
 
    } 
}