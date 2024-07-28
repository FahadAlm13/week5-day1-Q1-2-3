package spring.boot.eek5day1q3.Api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiEvent {
    private String message;
    private String status;

}
