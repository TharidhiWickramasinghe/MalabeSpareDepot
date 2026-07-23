import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuditLogger {
    public void log(String action, String partCode, int quantity){
        LocalDateTime now = LocalDateTime.now();
    try{
        FileWriter fw = new FileWriter("data/audit_log.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(now + " | " +action+ " | "+partCode+ " |Qty: " +quantity);
        bw.newLine();
        bw.close();
    }catch (IOException e){
        System.out.println("Enter writing to log: " + e.getMessage());
    }
    }

}
