package api;

import model.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.phone.SmartPhoneService;
import service.phone.exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class SmartPhoneAPI {
    private final SmartPhoneService smartPhoneService;

    @Autowired
    public SmartPhoneAPI(SmartPhoneService smartPhoneService) {
        this.smartPhoneService = smartPhoneService;
    }

    @GetMapping()
    public ResponseEntity<List<SmartPhone>> getAllPhones() throws NotFoundException {
        List<SmartPhone> list = smartPhoneService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}