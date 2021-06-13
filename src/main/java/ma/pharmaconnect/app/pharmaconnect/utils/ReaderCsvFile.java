package ma.pharmaconnect.app.pharmaconnect.utils;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderCsvFile {

  public static <T> List<T> readCsv(Path path, Class<T> clazz) {
    ColumnPositionMappingStrategy<T> ms = new ColumnPositionMappingStrategy<T>();
    ms.setColumnMapping("code", "name", "price","prescription");
    ms.setType(clazz);
    Reader reader;
    try {
      reader = Files.newBufferedReader(path);
    } catch (IOException e) {
      throw new RuntimeException("cannot read the file");
    }
    CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
        .withType(clazz)
        .withMappingStrategy(ms)
        .withSkipLines(1)
        .build();
    return cb.parse();
  }


}
