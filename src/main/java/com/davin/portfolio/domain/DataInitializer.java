package com.davin.portfolio.domain;

import com.davin.portfolio.domain.constant.SkillType;
import com.davin.portfolio.domain.entity.*;
import com.davin.portfolio.domain.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Profile("default")
@AllArgsConstructor
public class DataInitializer {
    private AchievementRepository achievementRepository;
    private IntroductionRepository introductionRepository;
    private LinkRepository linkRepository;
    private SkillRepository skillRepository;
    private ProjectRepository projectRepository;
    private ExperienceRepository experienceRepository;

    @PostConstruct
    private void initializeData() {
        // achievement 초기화
        List<Achievement> achievements = List.of(
                Achievement.builder()
                        .title("2022 Catkao 해커톤 최우수상")
                        .description("고양이 쇼핑몰 검색 서비스의 아키텍처, 데이터 모델링, API 개발 역할 수행")
                        .host("캣카오")
                        .achievedDate(LocalDate.of(2022, 8, 1))
                        .isActive(true)
                        .build(),
                Achievement.builder()
                        .title("2022 Catkao 해커톤 최우수상")
                        .description("고양이 쇼핑몰 검색 서비스의 아키텍처, 데이터 모델링, API 개발 역할 수행")
                        .host("캣카오")
                        .achievedDate(LocalDate.of(2022, 8, 1))
                        .isActive(true)
                        .build()
        );
        achievementRepository.saveAll(achievements);

        // introduction 초기화
        List<Introduction> introductions = List.of(
                Introduction.builder()
                        .content("주도적으로 문제를 찾고, 해결하는 고양이입니다.")
                        .isActive(true)
                        .build(),
                Introduction.builder()
                        .content("기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.")
                        .isActive(true)
                        .build(),
                Introduction.builder()
                        .content("기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.")
                        .isActive(true)
                        .build()
        );
        introductionRepository.saveAll(introductions);

        // link 초기화
        List<Link> links = List.of(
                Link.builder()
                        .name("Github")
                        .content("https://github.com/dav1n9")
                        .isActive(true)
                        .build(),
                Link.builder()
                        .name("Blog")
                        .content("https://lemon-barge-e29.notion.site/Spring-Spring-boot-054feaa1c30f453ebd89de4cc2d7daee?pvs=4")
                        .isActive(true)
                        .build()
        );
        linkRepository.saveAll(links);

        // experience / experience_detail 초기화
        Experience experience1 = Experience.builder()
                .title("강원대학교")
                .description("컴퓨터공학 전공")
                .startYear(2020)
                .startMonth(3)
                .endYear(2024)
                .endMonth(2)
                .isActive(true)
                .build();
        experience1.addDatails(
                List.of(
                        ExperienceDetail.builder()
                                .content("GPA 4.3/4.5")
                                .isActive(true)
                                .build()
                )
        );
        experienceRepository.saveAll(List.of(experience1));

        // skill 초기화
        Skill java = Skill.builder().name("Java").type(SkillType.LANGUAGE.name()).isActive(true).build();
        Skill dart = Skill.builder().name("Dart").type(SkillType.LANGUAGE.name()).isActive(true).build();
        Skill spring = Skill.builder().name("Spring").type(SkillType.FRAMEWORK.name()).isActive(true).build();
        Skill flutter = Skill.builder().name("Flutter").type(SkillType.FRAMEWORK.name()).isActive(true).build();
        Skill mysql = Skill.builder().name("MySQL").type(SkillType.DATABASE.name()).isActive(true).build();
        Skill redis = Skill.builder().name("Redis").type(SkillType.DATABASE.name()).isActive(true).build();
        skillRepository.saveAll(List.of(java, dart, spring, flutter, mysql, redis));

        // project / project_detail / project_skill 초기화
        Project project1 = Project.builder()
                .name("유기묘 발견 정보 공유 서비스")
                .description("유기묘 위치의 실시간 공유, 임시보호까지 연결해주는 서비스. 구글 맵스를 연동하여 유기묘 위치 " +
                        "정보를 직관적으로 파악할 수 있도록 하는 사용자 경험 개선 작업.")
                .startYear(2022)
                .startMonth(9)
                .endYear(2022)
                .endYear(12)
                .isActive(true)
                .build();
        project1.addDatails(
                List.of(
                        ProjectDetail.builder()
                                .content("구글 맵스를 활용한 유기묘 발견 지역 정보 제공 API 개발")
                                .url(null)
                                .isActive(true)
                                .build(),
                        ProjectDetail.builder()
                                .content("Redis 적용하여 인기 게시글의 조회 속도 1.5초 → 0.5초로 개선")
                                .url(null)
                                .isActive(true)
                                .build()
                )
        );
        project1.skills.addAll(List.of(
                ProjectSkill.builder().project(project1).skill(java).build(),
                ProjectSkill.builder().project(project1).skill(spring).build(),
                ProjectSkill.builder().project(project1).skill(mysql).build(),
                ProjectSkill.builder().project(project1).skill(redis).build()
        ));
        projectRepository.saveAll(List.of(project1));
    }
}
