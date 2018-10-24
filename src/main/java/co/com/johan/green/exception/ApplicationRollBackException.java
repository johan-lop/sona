/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.johan.green.exception;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
@javax.ejb.ApplicationException(rollback = true)
public class ApplicationRollBackException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public ApplicationRollBackException() {
        super();
    }
    public ApplicationRollBackException(String msg)   {
        super(msg);
    }
    public ApplicationRollBackException(String msg, Exception e)  {
        super(msg, e);
    }

}
