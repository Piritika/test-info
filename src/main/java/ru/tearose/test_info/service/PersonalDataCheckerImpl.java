package ru.tearose.test_info.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tearose.test_info.exception.IncorrectUserDataException;
import ru.tearose.test_info.model.dto.UserInfoDto;

@Slf4j
@Service
public class PersonalDataCheckerImpl implements PersonalDataChecker {

    @Override
    public void checkPersonalData(UserInfoDto userInfoDto) {
        log.info("start checkPersonalData");

        String phoneLastTen = userInfoDto.getPhoneNumber().substring(userInfoDto.getPhoneNumber().length() - 10);

        if (phoneLastTen.startsWith("666")){
            throw new IncorrectUserDataException("Пользователь предоставил неверные данные.");
        }
    }
}
