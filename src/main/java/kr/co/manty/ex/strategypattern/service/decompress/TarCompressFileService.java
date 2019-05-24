package kr.co.manty.ex.strategypattern.service.decompress;


import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class TarCompressFileService implements CompressFileService {

    public List<String> listFileNames(File compressedFile) {

        List fileNames = new LinkedList();
        try (TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(compressedFile))) {
            ArchiveEntry archiveEntry = tais.getNextEntry();
            while (archiveEntry != null) {
                fileNames.add(archiveEntry.getName());
                archiveEntry = tais.getNextEntry();
            }
        } catch (IOException e) {
            throw new UncompressFailedException(e);
        }
        return fileNames;
    }
    @Override
    public boolean supports(String ext) {
        if ( ext == null )return false;
        return Objects.equals("tar", ext.toLowerCase());
    }
}
