package kr.co.manty.ex.strategypattern.service.decompress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompressFileServiceTest {
    
    @Autowired
    private CompressFileServiceLocator serviceLocator;

    @Test
    public void listFilesTest() throws IOException {
        File file = new ClassPathResource("test.txt.zip").getFile();
        List<String> fileNames = serviceLocator.resolve(file).listFileNames(file);
        
        assertThat(fileNames.size(), is(1));
        assertThat(fileNames.get(0), is("test.txt"));
    }

    @Test
    public void listFilesTestForGzip() throws IOException {
        File file = new ClassPathResource("test.txt.tar").getFile();
        List<String> fileNames = serviceLocator.resolve(file).listFileNames(file);

        assertThat(fileNames.size(), is(1));
        assertThat(fileNames.get(0), is("test.txt"));
    }

    @Test
    public void listFilesTestFor7zip() throws IOException {
        File file = new ClassPathResource("test.txt.7z").getFile();
        List<String> fileNames = serviceLocator.resolve(file).listFileNames(file);

        assertThat(fileNames.size(), is(1));
        assertThat(fileNames.get(0), is("test.txt"));
    }
}