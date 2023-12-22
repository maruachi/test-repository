package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.TestConfig;
import com.goodchalk.goodpass.climbinggym.service.dto.ClimbingGymSaveDto;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(classes = TestConfig.class)
class ClimbingGymSaveServiceTest {
    @Autowired
    private ClimbingGymSaveService climbingGymSaveService;
    @Autowired
    private ClimbingGymRepository climbingGymRepository;

    @DisplayName("클라이밍장 등록이 서비스가 정상적으로 수행되는가?")
    @Test
    void register() {
        ClimbingGymSaveDto climbingGymSaveDto = ClimbingGymSaveDto.builder()
                .climbingGymName("그래비티 클라이밍")
                .build();
        ClimbingGym registeredClimbingGym = climbingGymSaveService.register(climbingGymSaveDto);
        Long id = registeredClimbingGym.getId();
        Optional<ClimbingGym> climbingGymOptional = climbingGymRepository.findById(id);
        ClimbingGym climbingGym = climbingGymOptional.orElseThrow(RuntimeException::new);

        Assertions.assertThat(climbingGym.getClimbingGymName()).isEqualTo("그래비티 클라이밍");
    }
}