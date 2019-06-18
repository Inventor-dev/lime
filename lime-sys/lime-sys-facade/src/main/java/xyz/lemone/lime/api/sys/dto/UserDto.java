package xyz.lemone.lime.api.sys.dto;


import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private String name;


    public UserDto() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
