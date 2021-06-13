package ma.pharmaconnect.app.pharmaconnect;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.pharmaconnect.app.pharmaconnect.processor.ProcessCsvProductToDb;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class PharmaConnectApplication extends SpringBootServletInitializer implements
    CommandLineRunner {

  private static final String PARSE_PRODUCT_CSV = "parse_product_csv";
  @Value("${parser.csvFile.product}")
  private String locationCsv;

  private final ProcessCsvProductToDb processCsvProductToDb;

  public static void main(String[] args) {
    SpringApplication.run(PharmaConnectApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(PharmaConnectApplication.class);
  }

  @Override
  public void run(String... args) throws Exception {

    if (args.length == 0) {
      log.info("please provid args with name  {}", PARSE_PRODUCT_CSV);
    }

    for (String arg : args) {
      switch (arg) {

        case PARSE_PRODUCT_CSV:
          processCsvProductToDb.processProductToDb(locationCsv);
          break;
        default:
          log.warn("Can't find case for {}", arg);

      }
    }


  }


}
