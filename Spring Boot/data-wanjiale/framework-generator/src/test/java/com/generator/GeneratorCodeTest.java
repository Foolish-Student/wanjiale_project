package com.generator;

import com.framework.GeneratorApplication;
import com.framework.service.SysGeneratorService;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GeneratorApplication.class)
public class GeneratorCodeTest {
    @Autowired
    private SysGeneratorService sysGeneratorService;

    @Test
    public void testGen()throws Exception{
        String[] tableNames = {"t_course_info","t_user_course_score_ref","t_user_info"};
        byte[] data = sysGeneratorService.generatorCode(tableNames);
        String zip = "d:/gen.zip";
        FileUtils.writeByteArrayToFile(new File(zip), data);
    }
}
