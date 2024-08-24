package ru.tearose.test_info.integration.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tearose.test_info.model.dto.UserInfoDto;
import ru.tearose.test_info.service.PersonalDataChecker;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

    private final PersonalDataChecker checker;

    @PostMapping("/personal-data/check")
    public ResponseEntity<Void> checkPersonalData(@Valid @RequestBody UserInfoDto userInfoDto) {
        log.info("start checkPersonalData. Body: {}", userInfoDto);

        checker.checkPersonalData(userInfoDto);
        log.info("checkPersonalData success");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
