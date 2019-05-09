package xyz.lemone.lime.api.sys.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private String name;


    public UserDto() {
    }
}
