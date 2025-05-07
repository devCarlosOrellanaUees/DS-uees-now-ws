package ec.edu.uees.util;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseEB {

    private int status;
    private String message;
    private Object data;

}
