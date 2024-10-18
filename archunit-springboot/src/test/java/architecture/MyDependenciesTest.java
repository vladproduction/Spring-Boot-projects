package architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class MyDependenciesTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.vladproduction");


//    @Test
    public void testModelCanNotUseServiceAndControllerWithSubPackages(){
        ArchRule rule = noClasses().that()
                .resideInAPackage(
                        "com.vladproduction.archunitspringboot.model..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage(
                        "com.vladproduction.archunitspringboot.service..",
                        "com.vladproduction.archunitspringboot.controller..");

        rule.because("person can not depend on service or controller").check(classes);
    }

    @Test
    public void testModelCanNotUseServiceAndController(){
        ArchRule rule = noClasses().that()
                .resideInAPackage(
                        "com.vladproduction.archunitspringboot.model")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage(
                        "com.vladproduction.archunitspringboot.service..",
                        "com.vladproduction.archunitspringboot.controller..");

        rule.because("person can not depend on service or controller").check(classes);
    }

    //service do not depend from controller
//    @Test
    public void testServiceCanNotUseControllerWithSubPackages(){
        ArchRule rule = noClasses().that()
                .resideInAPackage(
                        "com.vladproduction.archunitspringboot.service..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage(
                        "com.vladproduction.archunitspringboot.controller..");

        rule.because("service can not depend controller").check(classes);
    }

    @Test
    public void testServiceCanNotUseController(){
        ArchRule rule = noClasses().that()
                .resideInAPackage(
                        "com.vladproduction.archunitspringboot.service")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage(
                        "com.vladproduction.archunitspringboot.controller..");

        rule.because("service can not depend controller").check(classes);
    }

    //could use only specific classes
    @Test
    public void testControllerCanUseOnlySpecificClasses(){
        ArchRule rule = classes().that()
                .resideInAPackage(
                        "com.vladproduction.archunitspringboot.controller")
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "com.vladproduction.archunitspringboot.controller..",
                        "com.vladproduction.archunitspringboot.service",
                        "com.vladproduction.archunitspringboot.model",
                        "org.springframework.web..",
                        "java..");

        rule.because("service can not depend controller").check(classes);
    }


}
