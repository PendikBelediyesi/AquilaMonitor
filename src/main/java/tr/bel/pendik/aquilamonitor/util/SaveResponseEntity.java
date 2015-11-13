package tr.bel.pendik.aquilamonitor.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by moyavuz on 14.10.2015.
 */

public class SaveResponseEntity extends ResponseEntity {
    public SaveResponseEntity() {
        super(HttpStatus.OK);
    }

    public SaveResponseEntity(HttpStatus statusCode) {
        super(statusCode);
    }

}
