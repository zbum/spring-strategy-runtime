package kr.co.manty.ex.strategypattern.service.decompress;

import kr.co.manty.ex.strategypattern.service.Supportable;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CompressFileService extends Supportable {
    List<String> listFileNames(File compressedFile) ;
}
