package root;

public class ProjectProperties {

    static ProjectProperties instance = new ProjectProperties();
    //RDS
    String rds_table_name;
    String rds_db_name;
    String rds_user_name;
    String rds_password;
    String rds_hostname;
    String rds_port;

    public static ProjectProperties getInstance() {
        return instance;
    }

    public String getRds_table_name() {
        return rds_table_name;
    }

    public String getRds_db_name() {
        return rds_db_name;
    }

    public String getRds_user_name() {
        return rds_user_name;
    }

    public String getRds_password() {
        return rds_password;
    }

    public String getRds_hostname() {
        return rds_hostname;
    }

    public String getRds_port() {
        return rds_port;
    }

    private ProjectProperties() {

        if ((rds_table_name = System.getenv("RDS_TABLE_NAME")) == null) {
            rds_table_name = System.getProperty("RDS_TABLE_NAME");
        }

        if ((rds_db_name = System.getenv("RDS_DB_NAME")) == null) {
            rds_db_name = System.getProperty("RDS_DB_NAME");
        }

        if ((rds_user_name = System.getenv("RDS_USERNAME")) == null) {
            rds_user_name = System.getProperty("RDS_USERNAME");
        }

        if ((rds_password = System.getenv("RDS_PASSWORD")) == null) {
            rds_password = System.getProperty("RDS_PASSWORD");
        }

        if ((rds_hostname = System.getenv("RDS_HOSTNAME")) == null) {
            rds_hostname = System.getProperty("RDS_HOSTNAME");
        }

        if ((rds_port = System.getenv("RDS_PORT")) == null) {
            rds_port = System.getProperty("RDS_PORT");
        }
    }
}
