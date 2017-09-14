package co.com.johan.green.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;

/**
  * @generated
  *  @author Johan Lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuRolDTO {

    public MenuRolDTO(){
        //constructor base
    }
    
    public MenuRolDTO(Long id){
        this.id=id;
    }

	private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
    
    
    /**
    * @generated
    */
    private MenuDTO menu;
    
    
	/**
	* @generated
	*/
	public MenuDTO getMenu() {
	    return this.menu;
	}
	
	/**
	* @generated
	*/
	public void setMenu(MenuDTO menu) {
	    this.menu = menu;
	}
	
}
