package kr.co.manty.ex.strategypattern.service.decompress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CompressFileServiceLocator {

    @Autowired
    private List<CompressFileService> compressFileServices;

    public CompressFileService resolve(File file) {
        String extension = getFileExtension(file);
        return compressFileServices.stream()
                                   .filter(it -> it.supports(extension))
                                   .findFirst()
                                   .orElseThrow(() -> new NotSupportCompressExtException(extension));
    }

    private String getFileExtension(File file) {
        String filename = file.getName();
        String extension;

        int i = filename.lastIndexOf('.');
        if (i > 0) {
            extension = filename.substring(i + 1);
        } else {
            extension = "";
        }
        return extension;
    }

}
