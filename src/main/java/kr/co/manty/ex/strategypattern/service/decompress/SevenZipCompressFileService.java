package kr.co.manty.ex.strategypattern.service.decompress;


import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class SevenZipCompressFileService implements CompressFileService {

    public List<String> listFileNames(File compressedFile) {

        List fileNames = new LinkedList();
        
        try (SevenZFile sevenZFile = new SevenZFile(compressedFile)) {
            SevenZArchiveEntry zipEntry = sevenZFile.getNextEntry();
            while (zipEntry != null) {
                fileNames.add(zipEntry.getName());
                zipEntry = sevenZFile.getNextEntry();
            }
        } catch (IOException e) {
            throw new UncompressFailedException(e);
        }

        return fileNames;
    }

    @Override
    public boolean supports(String ext) {
        if ( ext == null )return false;
        return Objects.equals("7z", ext.toLowerCase());
    }
}
