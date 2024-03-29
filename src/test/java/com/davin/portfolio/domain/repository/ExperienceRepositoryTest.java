package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.entity.Experience;
import com.davin.portfolio.domain.entity.ExperienceDetail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest {
    private static final int DATA_SIZE = 5;
    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceRepositoryTest(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    // 더미 객체 생성
    private Experience createExperience(int n) {
        Experience experience = Experience.builder()
                .title(String.valueOf(n))
                .description("테스트 설명 " + n)
                .startYear(2023)
                .startMonth(9)
                .endYear(2023)
                .endMonth(9)
                .isActive(true)
                .build();

        List<ExperienceDetail> details = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ExperienceDetail experienceDetail = ExperienceDetail.builder()
                    .content("테스트 " + i)
                    .isActive(true)
                    .build();
            details.add(experienceDetail);
        }
        experience.addDetails(details);

        return experience;
    }

    // 테스트 데이터 초기화
    @BeforeAll
    public void beforeAll() {
        System.out.println("----- 데이터 초기화 이전 조회 시작 -----");
        List<Experience> beforeInitialize = experienceRepository.findAll();
        assertThat(beforeInitialize).hasSize(0);
        System.out.println("----- 데이터 초기화 이전 조회 종료 -----");

        System.out.println("----- 테스트 데이터 초기화 시작 -----");
        List<Experience> experiences = new ArrayList<>();
        for (int i = 0; i < DATA_SIZE; i++) {
            Experience experience = createExperience(i);
            experiences.add(experience);
        }
        experienceRepository.saveAll(experiences);
        System.out.println("----- 테스트 데이터 초기화 종료 -----");
    }

    @Test
    public void testFindAll() {
        List<Experience> experiences = experienceRepository.findAll();
        assertThat(experiences).hasSize(DATA_SIZE);

        for (Experience e : experiences)
            assertThat(e.getDetails()).hasSize(Integer.parseInt(e.getTitle()));
    }

    @Test
    public void testFindAllByIsActive() {
        List<Experience> experiences = experienceRepository.findAllByIsActive(true);
        assertThat(experiences).hasSize(DATA_SIZE);

        for (Experience e : experiences)
            assertThat(e.getDetails()).hasSize(Integer.parseInt(e.getTitle()));
    }
}