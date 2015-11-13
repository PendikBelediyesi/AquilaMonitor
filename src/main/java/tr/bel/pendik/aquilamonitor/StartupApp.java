package tr.bel.pendik.aquilamonitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import tr.bel.pendik.aquilamonitor.data.*;
import tr.bel.pendik.aquilamonitor.repository.*;
import tr.bel.pendik.aquilamonitor.service.MailService;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
public class StartupApp implements CommandLineRunner {
//	@Autowired
//	private SystemMonitorRepository repository;
//	@Autowired
//	private AppAlertRepository repositoryAlert;

    @Autowired
    private ApplicationTypeRepository applicationTypeRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationRelationRepository applicationRelationRepository;

    @Autowired
    private IpAddressRepository ipAddressRepository;

    @Autowired
    private MonitorRepository monitorRepository;

    @Autowired
    private MonitorLogRepository monitorLogRepository;

    @Autowired
    private OsRepository osRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private RelationTypeRepository relationTypeRepository;

    @Autowired
    private ResponsibleRepository responsibleRepository;

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private ServerTypeRepository serverTypeRepository;

    @Autowired
    private ServerProgramRepository serverProgramRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(new Object[]{
                StartupApp.class}, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println();
    }

    public void run(String... args) throws Exception {

        //repository.deleteAll();
        //repositoryAlert.deleteAll();
        //
        // // save a couple of SystemMonitorApps
        // repository
        // .save(new SystemMonitorApp(
        // "Server",
        // "120",
        // "10.16.16.120",
        // "",
        // "",
        // "",
        // "",
        // 2,
        // "Eposta",
        // "moyavuz@pendik.bel.tr;umyildiz@pendik.bel.tr;aakkoc@pendik.bel.tr;gsisman@pendik.bel.tr;levent.subasi@vadi.com.tr"));

        // fetch all SystemMonitorApps
//		System.out.println("SystemMonitorApps found with findAll():");
//		System.out.println("-------------------------------");
//		for (SystemMonitorApp apps : repository.findAll()) {
//			System.out.println(apps);
//		}
//		System.out.println("-------------------------------");


        for (ApplicationEntity oss : applicationRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }

        for (ApplicationTypeEntity oss : applicationTypeRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }

        for (ApplicationRelationEntity oss : applicationRelationRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }
        for (IpAddressEntity oss : ipAddressRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }
        for (MonitorEntity oss : monitorRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }
        for (MonitorLogEntity oss : monitorLogRepository.findAll()) {
            System.out.println("-> " + oss.getResponseTime());
        }

        for (OsEntity oss : osRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }

        for (ProgramEntity oss : programRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }
        for (RelationTypeEntity oss : relationTypeRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }

        for (ResponsibleEntity oss : responsibleRepository.findAll()) {
            System.out.println("-> " + oss.getUserId());
        }

        for (ServerEntity oss : serverRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }

        for (ServerProgramEntity oss : serverProgramRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }
        for (ServerTypeEntity oss : serverTypeRepository.findAll()) {
            System.out.println("-> " + oss.getDesc());
        }
        for (UserEntity oss : userRepository.findAll()) {
            System.out.println("-> " + oss.getName());
        }

//		System.out.println("SystemMonitorApps found with findAll():");
//		System.out.println("-------------------------------");
//		for (SystemMonitorApp apps : repository.findByTypeAndEnabled("Server",
//				true)) {
//			System.out.println(apps);
//		}
        System.out.println("-------------------------------");
    }

}
