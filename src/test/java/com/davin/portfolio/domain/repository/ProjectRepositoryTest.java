package com.davin.portfolio.domain.repository;

import com.davin.portfolio.domain.constant.SkillType;
import com.davin.portfolio.domain.entity.Project;
import com.davin.portfolio.domain.entity.ProjectDetail;
import com.davin.portfolio.domain.entity.ProjectSkill;
import com.davin.portfolio.domain.entity.Skill;
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
class ProjectRepositoryTest {
    private static final int DATA_SIZE = 5;
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;

    @Autowired
    public ProjectRepositoryTest(ProjectRepository projectRepository, SkillRepository skillRepository) {
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
    }

    // 더미 객체 생성
    private Project createProject(int n) {
        Project project = Project.builder()
                .name(String.valueOf(n))
                .description("테스트 설명 " + n)
                .startYear(2023)
                .startMonth(9)
                .endYear(2023)
                .endMonth(9)
                .isActive(true)
                .build();

        List<ProjectDetail> details = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ProjectDetail projectDetail = ProjectDetail.builder()
                    .content("테스트 " + i)
                    .url(null)
                    .isActive(true)
                    .build();
            details.add(projectDetail);
        }
        project.addDetails(details);

        List<Skill> skills = skillRepository.findAll();
        List<Skill> skillsUsedInProject = skills.subList(0, n);
        for (Skill skill : skillsUsedInProject) {
            ProjectSkill projectSkill = ProjectSkill.builder()
                    .project(project)
                    .skill(skill)
                    .build();
            project.getSkills().add(projectSkill);
        }

        return project;
    }

    // 테스트 데이터 초기화
    @BeforeAll
    public void beforeAll() {
        System.out.println("----- 스킬 데이터 초기화 시작 -----");
        List<Skill> skills = new ArrayList<>();
        for (int i = 0; i < DATA_SIZE; i++) {
            SkillType[] skillTypes = SkillType.values();
            Skill skill = Skill.builder()
                    .name("테스트 " + i)
                    .type(skillTypes[i % skillTypes.length].name())
                    .isActive(true)
                    .build();
            skills.add(skill);
        }
        skillRepository.saveAll(skills);
        System.out.println("----- 스킬 데이터 초기화 종료 -----");

        System.out.println("----- 테스트 데이터 초기화 시작 -----");
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < DATA_SIZE; i++) {
            Project project = createProject(i);
            projects.add(project);
        }
        projectRepository.saveAll(projects);
        System.out.println("----- 테스트 데이터 초기화 종료 -----");
    }

    @Test
    public void testFindAll() {
        List<Project> project = projectRepository.findAll();
        assertThat(project).hasSize(DATA_SIZE);

        for (Project e : project) {
            assertThat(e.getDetails()).hasSize(Integer.parseInt(e.getName()));
            assertThat(e.getSkills()).hasSize(Integer.parseInt(e.getName()));
        }
    }

    @Test
    public void testFindAllByIsActive() {
        List<Project> project = projectRepository.findAllByIsActive(true);
        assertThat(project).hasSize(DATA_SIZE);

        for (Project e : project) {
            assertThat(e.getDetails()).hasSize(Integer.parseInt(e.getName()));
            assertThat(e.getSkills()).hasSize(Integer.parseInt(e.getName()));
        }
    }
}