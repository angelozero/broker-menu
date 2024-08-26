package com.angelozero.broker.entrypoint;


import com.angelozero.broker.entrypoint.rest.PersonRequest;
import com.angelozero.broker.entrypoint.mapper.ControllerMapper;
import com.angelozero.broker.entrypoint.rest.PersonResponse;
import com.angelozero.broker.service.GetBrokerData;
import com.angelozero.broker.service.SaveBroker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/menu")
@AllArgsConstructor
public class MenuController {

    private final ControllerMapper mapper;
    private final GetBrokerData getBrokerData;
    private final SaveBroker saveBroker;

    @GetMapping
    public ResponseEntity<PersonResponse> getBroker(@RequestParam String cpf, @RequestParam String email) {
        PersonResponse pessoa = mapper.toPersonResponse(getBrokerData.execute(cpf, email));
        return pessoa != null ? ResponseEntity.ok().body(pessoa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> saveBroker(@RequestBody PersonRequest personRequest) throws URISyntaxException {
        saveBroker.execute(mapper.toPersonDTO(personRequest));
        return ResponseEntity.created(new URI("localhost")).build();
    }
}
