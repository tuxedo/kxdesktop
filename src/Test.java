import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Test {
	static Session session;

	public static void main(String[] args) {
		Configuration config = null;

		config = new Configuration().configure();
		System.out.println("Creating tables...");
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.create(true, true);
		System.out.println("Table created.");

	}
}